package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.type.VideoDeviceFacing;

/* JADX INFO: loaded from: classes40.dex */
public class VideoDeviceInfo {
    public VideoDeviceFacing deviceFacing;
    public String deviceId;
    public String deviceName;

    public VideoDeviceInfo() {
        this.deviceId = "";
        this.deviceName = "";
        this.deviceFacing = VideoDeviceFacing.UNKNOWN;
    }

    public VideoDeviceInfo(String r100, String r101, VideoDeviceFacing r102) {
        this.deviceId = r100;
        this.deviceName = r101;
        this.deviceFacing = r102;
    }

    public static VideoDeviceInfo create(String r100, String r101, VideoDeviceFacing r102) {
        return new VideoDeviceInfo(r100, r101, r102);
    }
}
