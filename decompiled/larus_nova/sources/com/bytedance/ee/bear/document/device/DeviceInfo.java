package com.bytedance.ee.bear.document.device;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class DeviceInfo implements NonProguard {
    private boolean androidPad;
    private String brand;
    private String deviceId;
    private String model;

    public String toString() {
        return "DeviceInfo{brand='" + this.brand + "', model='" + this.model + "', deviceId='" + this.deviceId + "'}";
    }

    public DeviceInfo() {
        this.androidPad = false;
    }

    public boolean getAndroidPad() {
        return this.androidPad;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getModel() {
        return this.model;
    }

    public void setAndroidPad(boolean r100) {
        this.androidPad = r100;
    }

    public void setBrand(String r100) {
        this.brand = r100;
    }

    public void setDeviceId(String r100) {
        this.deviceId = r100;
    }

    public void setModel(String r100) {
        this.model = r100;
    }

    public DeviceInfo(String r100, String r101, String r102, boolean r103) {
        this.brand = r100;
        this.model = r101;
        this.deviceId = r102;
        this.androidPad = r103;
    }
}
