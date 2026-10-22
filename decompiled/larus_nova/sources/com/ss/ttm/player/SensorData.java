package com.ss.ttm.player;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes40.dex */
public class SensorData {
    protected static final int Sensor_ACC_Data = 1;
    protected static final int Sensor_MAG_Data = 2;
    protected static final int Sensor_ROT_Data = 3;
    private float[] accel;
    private long mHandle;
    private SensorEventListener mListener;
    private SensorManager mSensorManager;
    private float[] magnet;

    private static final native void _writeData(long r100, int r101, float r102, float r103, float r104);

    public void stop() {
        this.mHandle = 0;
    }

    public SensorData() {
        this.mHandle = 0;
        this.mSensorManager = null;
        this.mListener = null;
        this.magnet = new float[3];
        this.accel = new float[3];
    }

    public int start() {
        if (initListeners().booleanValue() == false) goto L6;
        return 0;
    L6:
        return -1;
    }

    public void finalize() {
        stop();
    }

    public Boolean initListeners() {
        return Boolean.FALSE;
    }

    public void setHandle(long r100, TTPlayer r101) {
        this.mHandle = r100;
        r101.getContext();
    }
}
