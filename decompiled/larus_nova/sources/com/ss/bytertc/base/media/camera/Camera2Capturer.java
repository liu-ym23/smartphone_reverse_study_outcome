package com.ss.bytertc.base.media.camera;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.SurfaceTextureHelper;

/* JADX INFO: loaded from: classes40.dex */
public class Camera2Capturer extends CameraCapturer {
    private final CameraManager cameraManager;
    private final Context context;

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

    public Camera2Capturer(Context r100, String r101, CameraVideoCapturer.CameraEventsHandler r102) {
        super(r101, r102, new Camera2Enumerator(r100));
        this.context = r100;
        this.cameraManager = (CameraManager) r100.getSystemService("camera");
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

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer, com.ss.bytertc.base.media.VideoCapturer
    public /* bridge */ /* synthetic */ void startCapture(int r100, int r101, int r102, int r103) {
        super.startCapture(r100, r101, r102, r103);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraCapturer
    public void createCameraSession(CameraSession.CreateSessionCallback r110, CameraSession.Events r111, Context r112, SurfaceTextureHelper r113, String r114, int r115, int r116, int r117) {
        Camera2Session.create(r110, r111, r112, this.cameraManager, r113, r114, r115, r116, r117);
    }
}
