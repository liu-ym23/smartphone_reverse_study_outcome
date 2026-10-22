package com.ss.android.ttvecamera;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.bpea.basics.Cert;
import com.ss.android.ttvecamera.cameraalgorithm.TECameraAlgorithmInterface;
import com.ss.android.ttvecamera.cameraalgorithm.TECameraAlgorithmParam;
import com.ss.android.ttvecamera.model.BurstRequest;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface ICameraInstance {
    void abortSession();

    void addCameraAlgorithm(TECameraAlgorithmParam r100);

    void cameraInfoForAppLog(int r100, int r101, String r102);

    void cancelFocus();

    void captureBurst(BurstRequest r100, TECameraSettings.CaptureBufferFrameCallback r101);

    int changeCurrentControlCam(int r100);

    void changeRecorderState(int r100, TECameraBase.CameraKitStateCallback r101);

    void checkIfNeedCbCameraInfo(int r100, int r101, String r102, Object r103);

    void clearResourceBeforeRestartWhenCameraErr();

    int close(Object r100);

    void collectCameraCapabilities();

    Exception createException(Exception r100, int r101);

    void destroy();

    void enableCaf();

    void enableMulticamZoom(boolean r100);

    Bundle fillFeatures();

    void focusAtPoint(TEFocusSettings r100);

    void forceCloseCamera(Object r100);

    float[] getApertureRange();

    long getAvgExpTime(boolean r100);

    TEFrameSizei getBestPreviewSize(float r100, TEFrameSizei r101);

    JSONObject getCameraCapbilitiesForBytebench();

    int[] getCameraCaptureSize();

    TECameraSettings.ExposureCompensationInfo getCameraECInfo();

    TECameraBase.CameraEvents getCameraEvents();

    Cert getCameraPrivacyCert(TECameraSettings.TECameraPrivacyCertType r100);

    TECameraSettings getCameraSettings();

    int getCameraType();

    Context getContext();

    int getExposureCompensation();

    float[] getFOV();

    int getFacing();

    Bundle getFeatures(String r100);

    Map<String, Bundle> getFeatures();

    int getFlashMode();

    int getFrameOrientation();

    int getFrameRotation();

    int getFrameRotation(int r100);

    Handler getHandler();

    int getISO();

    int[] getISORange();

    float getManualFocusAbility();

    float getMaxZoom();

    int[] getPictureSize();

    int[] getPreviewFps();

    HashMap<String, Object> getPreviewMetadata();

    TECameraProviderManager getProviderManager();

    int getRetryStartPreviewCount();

    long[] getShutterTimeRange();

    List<TEFrameSizei> getSupportedPictureSizes();

    List<TEFrameSizei> getSupportedPreviewSizes();

    String getWideAngleID();

    boolean isAutoExposureLockSupported();

    boolean isAutoFocusLockSupported();

    boolean isDynamicRangeProfileSupported(long r100);

    boolean isHDR10BitSupported();

    boolean isNeedCollectCameraCapabilities();

    boolean isSupportWhiteBalance();

    boolean isSupportedExposureCompensation();

    boolean isTorchSupported();

    void needToReleaseSurfaceTexture(boolean r100);

    void notifyFrameAvailable(int r100);

    int open(int r100, int r101, int r102, int r103, int r104, boolean r105, Object r106);

    int open(TECameraSettings r100, Object r101);

    void process(TECameraSettings.Operation r100);

    TECameraFrame processAlgorithm(TECameraFrame r100);

    void queryShaderZoomStep(TECameraSettings.ShaderZoomCallback r100);

    void queryZoomAbility(TECameraSettings.ZoomCallback r100, boolean r101);

    void registerFpsConfigListener(TECameraBase.CameraFpsConfigCallback r100);

    void registerPreviewListener(TECameraBase.PreviewSizeCallBack r100);

    void releaseSurfaceTexture();

    void removeCameraAlgorithm(int r100);

    void resetRetryStartPreviewCount();

    void retryStartPreviewOnce();

    void setAperture(float r100);

    void setAutoExposureLock(boolean r100);

    void setAutoFocusLock(boolean r100);

    void setDeviceRotation(int r100);

    boolean setExposureCompensation(int r100);

    void setFeatureParameters(Bundle r100);

    void setISO(int r100);

    void setLensCallback(TECameraAlgorithmInterface.TECameraLensCallback r100);

    void setManualFocusDistance(float r100);

    void setPictureSize(int r100, int r101);

    void setPreviewFpsRange();

    void setPreviewFpsRangeWhenRunning(TEFrameRateRange r100);

    void setProviderManager(TECameraProviderManager r100);

    void setSATZoomCallback(TECameraBase.SATZoomCallback r100);

    void setSceneMode(int r100);

    void setShutterTime(long r100);

    void setWhiteBalance(boolean r100, String r101);

    void startCapture();

    int startRecording();

    void startZoom(float r100, TECameraSettings.ZoomCallback r101);

    void stopCameraFaceDetect();

    void stopCapture();

    int stopRecording();

    void stopRetryStartPreview();

    void stopZoom(TECameraSettings.ZoomCallback r100);

    void switchCameraMode(int r100);

    void switchFlashMode(int r100);

    void takePicture(int r100, int r101, TECameraSettings.PictureCallback r102);

    void takePicture(TECameraSettings.PictureCallback r100);

    void toggleTorch(boolean r100);

    void updateCameraAlgorithmParam(TECameraAlgorithmParam r100);

    void updateSurface();

    void useFaceAEStrategy(int r100);

    void zoomV2(float r100, TECameraSettings.ZoomCallback r101);
}
