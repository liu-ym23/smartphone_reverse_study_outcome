package com.ss.bytertc.base.media.camera;

import android.content.Context;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.SurfaceTextureHelper;

/* JADX INFO: loaded from: classes40.dex */
public class Camera1Capturer extends CameraCapturer {
    private final boolean captureToTexture;
    private final boolean isDesktopMode;
    protected boolean mEnableFaceAE;

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ float getCameraZoomMaxRatio() {
        return super.getCameraZoomMaxRatio();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ int getDeviceOrientation() {
        return super.getDeviceOrientation();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ boolean isCameraExposurePointSupported() {
        return super.isCameraExposurePointSupported();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ boolean isCameraFocusPointSupported() {
        return super.isCameraFocusPointSupported();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ boolean isCameraTorchSupported() {
        return super.isCameraTorchSupported();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ boolean isCameraZoomSupported() {
        return super.isCameraZoomSupported();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ boolean isScreencast() {
        return super.isScreencast();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ void disableDoOrientation() {
        super.disableDoOrientation();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ void dispose() {
        super.dispose();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer
    public /* bridge */ /* synthetic */ void printStackTrace() {
        super.printStackTrace();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ void stopCapture() {
        super.stopCapture();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ void turnOffFlashLight() {
        super.turnOffFlashLight();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ void turnOnFlashLight() {
        super.turnOnFlashLight();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ int enableCameraAutoExposureFaceMode(boolean r100) {
        return super.enableCameraAutoExposureFaceMode(r100);
    }

    public void enableFaceAE(boolean r100) {
        this.mEnableFaceAE = r100;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ int enableFollowGravity(boolean r100) {
        return super.enableFollowGravity(r100);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ int setCameraExposureCompensation(float r100) {
        return super.setCameraExposureCompensation(r100);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ int setCameraZoomRatio(float r100) {
        return super.setCameraZoomRatio(r100);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.camera.CameraVideoCapturer
    public /* bridge */ /* synthetic */ void setOrientationMode(CameraVideoCapturer.ORIENTATION_MODE r100) {
        super.setOrientationMode(r100);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.camera.CameraVideoCapturer
    public /* bridge */ /* synthetic */ void switchCamera(CameraVideoCapturer.CameraSwitchHandler r100) {
        super.switchCamera(r100);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ int setCameraExposurePoint(float r100, float r101) {
        return super.setCameraExposurePoint(r100, r101);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ int setCameraFocusPoint(float r100, float r101) {
        return super.setCameraFocusPoint(r100, r101);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ void changeCaptureFormat(int r100, int r101, int r102) {
        super.changeCaptureFormat(r100, r101, r102);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ void initialize(SurfaceTextureHelper r100, Context r101, CapturerObserver r102) {
        super.initialize(r100, r101, r102);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ void startCapture(int r100, int r101, int r102) {
        super.startCapture(r100, r101, r102);
    }

    public Camera1Capturer(String r100, CameraVideoCapturer.CameraEventsHandler r101, boolean r102, boolean r103) {
        super(r100, r101, new Camera1Enumerator(r102, r103));
        this.captureToTexture = r102;
        this.isDesktopMode = r103;
        this.mEnableFaceAE = false;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ void startCapture(int r100, int r101, int r102, int r103) {
        super.startCapture(r100, r101, r102, r103);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer
    public void createCameraSession(CameraSession.CreateSessionCallback r110, CameraSession.Events r111, Context r112, SurfaceTextureHelper r113, String r114, int r115, int r210, int r211) {
        Camera1Session.create(r110, r111, this.captureToTexture, this.isDesktopMode, r112, r113, Camera1Enumerator.getCameraIndex(r114), r115, r210, r211, this.mEnableFaceAE, this.mEnableFollowGravity);
    }
}
