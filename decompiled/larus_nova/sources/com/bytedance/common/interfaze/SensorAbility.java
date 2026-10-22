package com.bytedance.common.interfaze;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes15.dex */
public interface SensorAbility {
    Sensor getDefaultSensor(SensorManager r100, int r101);

    boolean registerListener(SensorManager r100, SensorEventListener r101, Sensor r102, int r103);

    void unregisterListener(SensorManager r100, SensorEventListener r101, Sensor r102);
}
