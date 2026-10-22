package com.bytedance.map.api.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.map.api.model.IMarker;
import faceverify.w;
import fna.g;
import ona.a;
import ona.b;

/* JADX INFO: loaded from: classes21.dex */
public class SensorEventHelper implements SensorEventListener {
    private final int TIME_SENSOR;
    private long lastTime;
    private float mAngle;
    private Context mContext;
    private IMarker mMarker;
    private Sensor mSensor;
    private SensorManager mSensorManager;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor r100, int r101) {
    }

    public void registerSensorListener() {
        this.mSensorManager.registerListener(this, this.mSensor, 3);
    }

    public void unRegisterSensorListener() {
        INVOKEVIRTUAL_com_bytedance_map_api_sensor_SensorEventHelper_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(this.mSensorManager, this, this.mSensor);
    }

    public SensorEventHelper(Context r100) {
        this.lastTime = 0;
        this.TIME_SENSOR = 100;
        this.mContext = r100;
        SensorManager r101 = (SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        this.mSensorManager = r101;
        this.mSensor = r101.getDefaultSensor(3);
    }

    public static int getScreenRotationOnPhone(Context r100) {
        int r101 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRotation();
        if (r101 != 1) goto L5;
        return 90;
    L5:
        if (r101 != 2) goto L7;
        return 180;
    L7:
        if (r101 == 3) goto L10;
        return 0;
    L10:
        return -90;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent r100) {
        if ((System.currentTimeMillis() - this.lastTime) >= 100) goto L6;
        return;
    L6:
        if (r100.sensor.getType() != 3) goto L25;
        float r101 = (r100.values[0] + getScreenRotationOnPhone(this.mContext)) % 360.0f;
        if (r101 <= 180.0f) goto L12;
        r101 = r101 - 360.0f;
    L15:
        if (Math.abs(this.mAngle - r101) >= 3.0f) goto L18;
        return;
    L18:
        if (Float.isNaN(r101) == false) goto L20;
        r101 = 0.0f;
    L20:
        this.mAngle = r101;
        IMarker r102 = this.mMarker;
        if (r102 == null) goto L23;
        r102.setRotateAngle(360.0f - r101);
    L23:
        this.lastTime = System.currentTimeMillis();
        return;
    L12:
        if (r101 >= (-180.0f)) goto L15;
        r101 = r101 + 360.0f;
        goto L15
    }

    public void setCurrentMarker(IMarker r100) {
        this.mMarker = r100;
    }

    public static void INVOKEVIRTUAL_com_bytedance_map_api_sensor_SensorEventHelper_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r100, SensorEventListener r101, Sensor r102) {
        if (g.d() == true) goto L6;
        r100.unregisterListener(r101, r102);
        return;
    L6:
        r100.unregisterListener(r101, r102);
        int r103 = 0;
        if (r101 == null) goto L9;
        int r104 = r101.hashCode();
    L10:
        if (r102 == null) goto L12;
        r103 = r102.hashCode();
    L12:
        b.c(new a(r104, Integer.valueOf(r103)));
        return;
    L9:
        r104 = 0;
        goto L10
    }
}
