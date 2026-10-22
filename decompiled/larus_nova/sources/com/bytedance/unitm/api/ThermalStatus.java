package com.bytedance.unitm.api;

/* JADX INFO: loaded from: classes22.dex */
public class ThermalStatus {
    public static final int STATUS_CRITICAL = 4;
    public static final int STATUS_EMERGENCY = 5;
    public static final int STATUS_LIGHT = 1;
    public static final int STATUS_MAX = 6;
    public static final int STATUS_MODERATE = 2;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_SEVERE = 3;
    public static final int STATUS_SHUTDOWN = 6;
    public static final int STATUS_UNKOWN = -1;
    public int aospStatus;
    public int batteryStatus;
    public float batteryTemp;
    public float borderTemp;
    public int oemStatus;
    public int status;

    public String toString() {
        return "ThermalStatus{status=" + this.status + ", batteryStatus=" + this.batteryStatus + ", oemStatus=" + this.oemStatus + ", aospStatus=" + this.aospStatus + ", batteryTemp=" + this.batteryTemp + ", borderTemp=" + this.borderTemp + '}';
    }

    public ThermalStatus() {
        this.status = -1;
        this.batteryStatus = -1;
        this.oemStatus = -1;
        this.aospStatus = -1;
        this.batteryTemp = -99.0f;
        this.borderTemp = -99.0f;
    }
}
