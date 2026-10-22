package com.ss.bytertc.engine.device;

/* JADX INFO: loaded from: classes40.dex */
public class MediaDeviceInfo {
    public DeviceError error;
    public String message;
    public DeviceState state;
    public DeviceType type;

    public String toString() {
        return "[type=" + this.type + ", state=" + this.state + ", error=" + this.error + ", msg=" + this.message + "]";
    }

    public MediaDeviceInfo(DeviceType r100, DeviceState r101, DeviceError r102, String r103) {
        this.type = r100;
        this.state = r101;
        this.error = r102;
        this.message = r103;
    }
}
