package com.ss.android.cert.manager.ablity;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioRecord;

/* JADX INFO: loaded from: classes5.dex */
public interface ICertCompliance {
    Sensor getDefaultSensor(SensorManager r100, int r101);

    Camera openCamera();

    Camera openCamera(int r100);

    void releaseCamera(Camera r100);

    void releaseRecord(AudioRecord r100);

    void requestPermissions(Activity r100, String[] r101, int r102);

    void startRecord(AudioRecord r100);

    void stopRecord(AudioRecord r100);
}
