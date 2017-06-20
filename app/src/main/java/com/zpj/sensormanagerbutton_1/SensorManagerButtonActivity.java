package com.zpj.sensormanagerbutton_1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.hardware.SensorManager;
import android.util.Log;
import android.hardware.Sensor;
import android.content.Context;
import java.util.List;

public class SensorManagerButtonActivity extends AppCompatActivity {
//public class MainActivity extends Activity implements OnClickListener {
    private Button btnGetSensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_manager_button_layout);

        initWedget();
    }

    private void initWedget() {
        btnGetSensor = (Button) findViewById(R.id.btnGetSensor);
        btnGetSensor.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View v) {
        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //得到手机上所有的传感器
        List<Sensor> listSensor = manager.getSensorList(Sensor.TYPE_ALL);
        int i = 1;
        for (Sensor sensor : listSensor) {
            Log.d("sensor " + i, sensor.getName());
            i++;
        }
        //通过调用getDefaultSensor方法获取某一个类型的默认传感器
        //Sensor s = manager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }
}
