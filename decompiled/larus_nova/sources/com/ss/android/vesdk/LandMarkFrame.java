package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public class LandMarkFrame {
    private float[] FOVAngle;
    private float[] quaternion;
    private double sensorTimestamp;

    public LandMarkFrame() {
    }

    public float[] getFOVAngle() {
        return this.FOVAngle;
    }

    public float[] getQuaternion() {
        return this.quaternion;
    }

    public double getSensorTimestamp() {
        return this.sensorTimestamp;
    }

    public void setFOVAngle(float[] r100) {
        this.FOVAngle = r100;
    }

    public void setQuaternion(float[] r100) {
        this.quaternion = r100;
    }

    public void setSensorTimestamp(double r100) {
        this.sensorTimestamp = r100;
    }

    public void setInfo(double r100, float[] r101, float[] r102) {
        this.sensorTimestamp = r100;
        this.quaternion = r101;
        this.FOVAngle = r102;
    }
}
