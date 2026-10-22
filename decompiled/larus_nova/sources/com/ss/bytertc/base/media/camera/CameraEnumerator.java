package com.ss.bytertc.base.media.camera;

import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public interface CameraEnumerator {
    CameraVideoCapturer createCapturer(String r100, CameraVideoCapturer.CameraEventsHandler r101);

    String[] getDeviceNames();

    int getDeviceOrientation(String r100);

    List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String r100);

    boolean isBackFacing(String r100);

    boolean isFrontFacing(String r100);
}
