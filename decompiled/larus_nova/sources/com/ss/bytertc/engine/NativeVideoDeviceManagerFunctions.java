package com.ss.bytertc.engine;

import com.ss.bytertc.engine.video.VideoDeviceInfo;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class NativeVideoDeviceManagerFunctions {
    public NativeVideoDeviceManagerFunctions() {
    }

    public static native List<VideoDeviceInfo> nativeEnumerateVideoCaptureDevices(long r100);

    public static native int nativeSetVideoCaptureDevice(long r100, String r101);
}
