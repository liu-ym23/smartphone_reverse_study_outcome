package com.bytedance.ee.bear.document.device;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setAndroidPad(boolean r1) {
        this.androidPad = r1;
    }

    public void setBrand(String r1) {
        this.brand = r1;
    }

    public void setDeviceId(String r1) {
        this.deviceId = r1;
    }

    public void setModel(String r1) {
        this.model = r1;
    }

    public DeviceInfo(String r1, String r2, String r3, boolean r4) {
        this.brand = r1;
        this.model = r2;
        this.deviceId = r3;
        this.androidPad = r4;
    }
}
