package com.bytedance.unitm.api;

/* JADX INFO: loaded from: classes22.dex */
public class ThermalStatusConfig {
    public static final ThermalStatusConfig DEFAULT = null;
    public static final int STATUS_SOURCE_AOSP = 1;
    public static final int STATUS_SOURCE_BATTERY = 0;
    public static final int STATUS_SOURCE_OEM = 2;
    public long NO_STATUS_CHANGE_NOTIFY_DELTA_TIME;
    public boolean enableStatusSourceAosp;
    public boolean enableStatusSourceBattery;
    public boolean enableStatusSourceOem;
    public int statusSource;

    static {
        DEFAULT = new ThermalStatusConfig();
    }

    public String toString() {
        return "ThermalStatusConfig{statusSource=" + this.statusSource + ", enableStatusSourceBattery=" + this.enableStatusSourceBattery + ", enableStatusSourceAosp=" + this.enableStatusSourceAosp + ", enableStatusSourceOem=" + this.enableStatusSourceOem + ", NO_CHANGE_NOTIFY_DELTA_TIME=" + this.NO_STATUS_CHANGE_NOTIFY_DELTA_TIME + '}';
    }

    public ThermalStatusConfig() {
        this.statusSource = 0;
        this.enableStatusSourceBattery = true;
        this.enableStatusSourceAosp = true;
        this.enableStatusSourceOem = false;
        this.NO_STATUS_CHANGE_NOTIFY_DELTA_TIME = 300000;
    }
}
