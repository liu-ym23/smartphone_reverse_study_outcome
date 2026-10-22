package com.ss.bytertc.base.media;

import android.content.Context;

/* JADX INFO: loaded from: classes40.dex */
public interface VideoCapturer {
    void changeCaptureFormat(int r100, int r101, int r102);

    void disableDoOrientation();

    void dispose();

    int enableCameraAutoExposureFaceMode(boolean r100);

    int enableFollowGravity(boolean r100);

    float getCameraZoomMaxRatio();

    int getDeviceOrientation();

    void initialize(SurfaceTextureHelper r100, Context r101, CapturerObserver r102);

    boolean isCameraExposurePointSupported();

    boolean isCameraFocusPointSupported();

    boolean isCameraTorchSupported();

    boolean isCameraZoomSupported();

    boolean isScreencast();

    int setCameraExposureCompensation(float r100);

    int setCameraExposurePoint(float r100, float r101);

    int setCameraFocusPoint(float r100, float r101);

    int setCameraZoomRatio(float r100);

    void startCapture(int r100, int r101, int r102);

    void startCapture(int r100, int r101, int r102, int r103);

    void stopCapture() throws InterruptedException;

    void turnOffFlashLight();

    void turnOnFlashLight();
}
