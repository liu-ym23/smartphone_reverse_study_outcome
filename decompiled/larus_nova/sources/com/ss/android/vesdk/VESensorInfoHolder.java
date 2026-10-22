package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public class VESensorInfoHolder {
    private static float[] DEFAULT_FOV;
    private static float[] DEFAULT_QUATERNION;
    private static volatile VESensorInfoHolder instance;
    private float[] fov;
    private boolean isSensorMode;
    private float[] quaternion;
    private double sensorTimestamp;

    static {
        DEFAULT_QUATERNION = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        DEFAULT_FOV = new float[]{-2.0f, -2.0f};
    }

    public static VESensorInfoHolder getInstance() {
        if (instance != null) goto L15;
        monitor-enter(VESensorInfoHolder.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new VESensorInfoHolder();     // Catch: Throwable -> L11
    L9:
        monitor-exit(VESensorInfoHolder.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private VESensorInfoHolder() {
        this.quaternion = DEFAULT_QUATERNION;
        this.fov = DEFAULT_FOV;
        this.isSensorMode = false;
    }

    public float[] getFov() {
        return this.fov;
    }

    public float[] getQuaternion() {
        return this.quaternion;
    }

    public double getRotationSensorTimestamp() {
        return this.sensorTimestamp;
    }

    public boolean isSensorMode() {
        return this.isSensorMode;
    }

    private void setQuaternion(float[] r100) {
        if (r100 != null) goto L4;
    L8:
        this.quaternion = DEFAULT_QUATERNION;
        return;
    L4:
        if (r100.length != 4) goto L8;
        this.quaternion = r100;
    }

    private void setRotationSensorTimestamp(double r100) {
        this.sensorTimestamp = r100;
    }

    public void setFov(float[] r100) {
        this.fov = r100;
    }

    public void setSensorMode(boolean r100) {
        this.isSensorMode = r100;
    }

    public void setRotationSensorInfo(float[] r100, double r101) {
        setQuaternion(r100);
        setRotationSensorTimestamp(r101);
    }
}
