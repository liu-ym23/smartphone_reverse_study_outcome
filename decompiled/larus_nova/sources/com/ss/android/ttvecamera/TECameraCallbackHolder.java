package com.ss.android.ttvecamera;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraCallbackHolder {
    public TECameraBase.CameraEvents cameraEvents;
    public TECameraSettings cameraSettings;
    public TECameraBase.PictureSizeCallBack pictureSizeCallback;

    public TECameraCallbackHolder(TECameraBase.CameraEvents r100, TECameraBase.PictureSizeCallBack r101, TECameraSettings r102) {
        this.cameraEvents = r100;
        this.pictureSizeCallback = r101;
        this.cameraSettings = r102;
    }
}
