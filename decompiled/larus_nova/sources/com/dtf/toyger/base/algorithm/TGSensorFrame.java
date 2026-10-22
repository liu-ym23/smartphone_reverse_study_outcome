package com.dtf.toyger.base.algorithm;

import java.util.Arrays;

/* JADX INFO: loaded from: classes22.dex */
public class TGSensorFrame {
    public float[] accelerateData;
    public float[] gyroData;
    public float[] rotationData;
    public long timeStamp;

    public String toString() {
        return "TGSensorFrame{gyroData=" + Arrays.toString(this.gyroData) + ", accelerateData=" + Arrays.toString(this.accelerateData) + ", rotationData=" + Arrays.toString(this.rotationData) + ", timeStamp=" + this.timeStamp + '}';
    }

    public TGSensorFrame(TGSensorFrame r100) {
        if (r100 == null) goto L6;
        this.gyroData = r100.gyroData;
        this.accelerateData = r100.gyroData;
        this.rotationData = r100.rotationData;
        this.timeStamp = r100.timeStamp;
        return;
    }

    public TGSensorFrame(float[] r100, float[] r101, float[] r102, long r103) {
        this.gyroData = r100;
        this.accelerateData = r101;
        this.rotationData = r102;
        this.timeStamp = r103;
    }
}
