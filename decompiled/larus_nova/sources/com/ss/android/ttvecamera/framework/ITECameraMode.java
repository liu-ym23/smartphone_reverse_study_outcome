package com.ss.android.ttvecamera.framework;

import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.os.Bundle;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TEFocusSettings;
import com.ss.android.ttvecamera.model.BurstRequest;

/* JADX INFO: loaded from: classes38.dex */
public interface ITECameraMode {
    public static final int CAMERA_SCENE_CAPTURE = 0;
    public static final int CAMERA_SCENE_RECORD = 1;

    void abortSession();

    Rect calculateZoomSize(float r100);

    Rect calculateZoomSizeV2(float r100);

    int cancelFocus();

    void captureBurst(BurstRequest r100, int r101, TECameraSettings.CaptureBufferFrameCallback r102);

    void close();

    void closePreviewSession();

    int enableCaf();

    void fillFeatures();

    int focusAtPoint(int r100, int r101, float r102, int r103, int r104);

    int focusAtPoint(TEFocusSettings r100);

    float[] getApertureRange();

    int[] getCameraCaptureSize();

    float[] getFOV();

    int[] getFaceDetectData();

    int getFlashMode();

    int getISO();

    int[] getISORange();

    float getManualFocusAbility();

    int[] getPictureSize();

    int[] getPreviewFps();

    long[] getShutterTimeRange();

    int openCamera(String r100, int r101) throws CameraAccessException;

    int prepareProvider();

    void process(TECameraSettings.Operation r100);

    void removeFocusSettings();

    void reset();

    String selectCamera(int r100) throws CameraAccessException;

    void setAperture(float r100);

    void setAutoExposureLock(boolean r100);

    void setAutoFocusLock(boolean r100);

    void setCameraDevice(Object r100) throws ClassCastException;

    boolean setExposureCompensation(int r100);

    void setFeatureParameter(Bundle r100);

    void setFpsConfigCallback(TECameraBase.CameraFpsConfigCallback r100);

    void setISO(int r100);

    void setManualFocusDistance(float r100);

    int setPictureSize(int r100, int r101);

    void setPictureSizeCallback(TECameraBase.PictureSizeCallBack r100);

    void setPreviewSizeCallback(TECameraBase.PreviewSizeCallBack r100);

    void setSceneMode(int r100);

    void setShutterTime(long r100);

    void setWhileBalance(boolean r100, String r101);

    int startPreview() throws Exception;

    int startRecording();

    int startZoom(float r100, TECameraSettings.ZoomCallback r101);

    int stopRecording();

    void stopZoom();

    void switchFlashMode(int r100);

    void takePicture(int r100, int r101, TECameraSettings.PictureCallback r102);

    void takePicture(TECameraSettings.PictureCallback r100, int r101);

    int updateCapture() throws CameraAccessException;

    void zoomV2(float r100, TECameraSettings.ZoomCallback r101);
}
