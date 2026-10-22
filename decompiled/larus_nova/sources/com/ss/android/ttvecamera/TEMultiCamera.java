package com.ss.android.ttvecamera;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ttvecamera.cameraalgorithm.TECameraAlgorithmInterface;
import com.ss.android.ttvecamera.cameraalgorithm.TECameraAlgorithmParam;
import com.ss.android.ttvecamera.model.BurstRequest;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class TEMultiCamera implements ICameraInstance {
    private static final String TAG = "TEMultiCamera";
    private static int mPrimaryCameraFacing;
    private final ConcurrentHashMap<TECameraBase, TECameraCallbackHolder> mCameraCallbacks;
    private final List<TECameraBase> mCameraInstances;
    private TECameraSettings mCameraSettings;
    private final HashSet<ICameraInstance> mCamerasToClose;
    private HashSet<TECameraBase> mCamerasToOpen;
    private long mCloseStartTime;
    private Context mContext;
    private int mControlFacing;
    private final TECameraBase.CameraEvents mConvergedCameraEvent;
    private Handler mHandler;
    private boolean mHasFirstBackFrameCaptured;
    private boolean mHasFirstFrontFrameCaptured;
    private int mHasOpenedCameraFacing;
    private long mOpenStartTime;
    private TECameraBase.PictureSizeCallBack mPictureSizeCallback;
    private long mPreviewStartTime;
    private Object mPrivacyCert;
    private TECameraProviderManager mProviderMgr;
    private boolean mbNeedToCallOnClosed;
    private boolean mbNeedToCallbackInfo;

    public class InstancedCameraEvents implements TECameraBase.CameraEvents {
        int mCameraIndex;
        final /* synthetic */ TEMultiCamera this$0;

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onCameraInfo(int r100, int r101, String r102, Object r103) {
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public final /* synthetic */ void onCameraInfoForTrack(int r100, int r101, String r102, long r103) {
            TECameraBase.CameraEvents.CC.$default$onCameraInfoForTrack(this, r100, r101, r102, r103);
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onPreviewStopped(int r100, int r101, int r102, String r103, Object r104) {
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onTorchError(int r100, int r101, int r102, String r103, Object r104) {
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onTorchSuccess(int r100, int r101, int r102, String r103, Object r104) {
        }

        public InstancedCameraEvents(TEMultiCamera r100, int r101) {
            this.this$0 = r100;
            this.mCameraIndex = r101;
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onCameraClosed(int r100, ICameraInstance r101, Object r102) {
            TEMultiCamera.access$300(this.this$0).remove(r101);
            TELogUtils.i(TEMultiCamera.TAG, "onCameraClosed, mCameraToClose size = " + TEMultiCamera.access$300(this.this$0).size() + " camera:" + r101 + ", mbNeedToCallOnClosed = " + TEMultiCamera.access$800(this.this$0));
            if (TEMultiCamera.access$300(this.this$0).isEmpty() == false) goto L8;
            if (TEMultiCamera.access$800(this.this$0) == false) goto L8;
            TEMultiCamera.access$100(this.this$0).onCameraClosed(r100, this.this$0, r102);
            return;
        L8:
            if (TEMultiCamera.access$800(this.this$0) == true) goto L12;
            TEMultiCamera.access$802(this.this$0, true);
            return;
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onCameraError(int r100, int r101, String r102, Object r103) {
            TELogUtils.e(TEMultiCamera.TAG, "onCameraError " + r102);
            if (r101 != (-409)) goto L5;
        L6:
            TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_DUAL_CAMERA_OPEN_RET, r101);
        L7:
            TEMultiCamera.access$100(this.this$0).onCameraError(r100, r101, r102, r103);
            return;
        L5:
            if (r101 != 3) goto L7;
            goto L6
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onCameraOpened(int r100, int r101, ICameraInstance r102, Object r110) {
            TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_DUAL_CAMERA_OPEN_RET, r101);
            long r103 = System.currentTimeMillis() - TEMultiCamera.access$000(this.this$0);
            TELogUtils.i(TEMultiCamera.TAG, "onCameraOpened, camera index =  " + this.mCameraIndex + ", camera = " + r102 + ", ret = " + r101 + ", cost " + r103);
            StringBuilder r104 = new StringBuilder("te_record_camera_open_cost_multi_");
            r104.append(this.mCameraIndex);
            TECameraMonitor.perfLong(r104.toString(), r103);
            if (r101 == 0) goto L6;
            TEMultiCamera.access$100(this.this$0).onCameraOpened(r100, r101, this.this$0, r110);
            return;
        L6:
            if (r102 == null) goto L9;
            TEMultiCamera.access$200(this.this$0).remove((TECameraBase) r102);
            TEMultiCamera.access$300(this.this$0).add(r102);
        L9:
            if (TEMultiCamera.access$400(this.this$0).mbDualCameraExpansionScheme == false) goto L24;
            if (TEMultiCamera.access$500(this.this$0) == false) goto L14;
            TEMultiCamera.access$100(this.this$0).onCameraInfo(122, TEMultiCamera.access$400(this.this$0).mCameraType, "switch to dual camera done", this);
            TEMultiCamera.access$502(this.this$0, false);
        L14:
            if (TEMultiCamera.access$200(this.this$0).isEmpty() == true) goto L16;
            TEMultiCamera.access$100(this.this$0).onCameraOpened(r100, r101, this.this$0, r110);
            return;
        L16:
            TELogUtils.i(TEMultiCamera.TAG, "startCapture for sec camera = " + r102);
            if (r102 != null) goto L19;
            return;
        L19:
            if (r102.getCameraSettings().mFacing != 0) goto L21;
            TEMultiCamera.access$602(this.this$0, false);
        L22:
            r102.startCapture();
            return;
        L21:
            TEMultiCamera.access$702(this.this$0, false);
            goto L22
        L24:
            if (TEMultiCamera.access$200(this.this$0).isEmpty() == false) goto L30;
            TEMultiCamera.access$100(this.this$0).onCameraOpened(r100, r101, this.this$0, r110);
            return;
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onPreviewError(int r100, int r101, String r102, Object r103) {
            TELogUtils.w(TEMultiCamera.TAG, "onPreviewError ret" + r101 + " error = " + r102);
            TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_DUAL_CAMERA_PREVIEW_RET, (long) r101);
            if (r101 != (-437)) goto L5;
            TEMultiCamera.access$100(this.this$0).onCameraError(r100, -409, r102, r103);
            return;
        L5:
            TEMultiCamera.access$100(this.this$0).onPreviewError(r100, r101, r102, r103);
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onPreviewSuccess(int r100, int r101, int r102, String r103, Object r104) {
            TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_DUAL_CAMERA_PREVIEW_RET, 0);
            if (TEMultiCamera.access$400(this.this$0).mbDualCameraExpansionScheme == true) goto L5;
            return;
        L5:
            if (TEMultiCamera.access$200(this.this$0).isEmpty() == true) goto L15;
            TELogUtils.i(TEMultiCamera.TAG, "onPreviewSuccess instance = " + r104);
            TECameraBase r105 = (TECameraBase) ListProtector.get(TEMultiCamera.access$900(this.this$0), 1);
            if (r105 != null) goto L11;
            TELogUtils.e(TEMultiCamera.TAG, "failed to open, first camera is null");
            return;
        L11:
            if (TEMultiCamera.access$1000(this.this$0, r105) == 0) goto L16;
            TELogUtils.e(TEMultiCamera.TAG, "failed to open camera");
            return;
        L16:
            return;
        }
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void addCameraAlgorithm(TECameraAlgorithmParam r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void cameraInfoForAppLog(int r100, int r101, String r102) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void cancelFocus() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void captureBurst(BurstRequest r100, TECameraSettings.CaptureBufferFrameCallback r101) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void changeRecorderState(int r100, TECameraBase.CameraKitStateCallback r101) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void checkIfNeedCbCameraInfo(int r100, int r101, String r102, Object r103) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void collectCameraCapabilities() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Exception createException(Exception r100, int r101) {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void enableCaf() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void enableMulticamZoom(boolean r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Bundle fillFeatures() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public float[] getApertureRange() {
        return new float[0];
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public long getAvgExpTime(boolean r100) {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public TEFrameSizei getBestPreviewSize(float r100, TEFrameSizei r101) {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public JSONObject getCameraCapbilitiesForBytebench() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int[] getCameraCaptureSize() {
        return new int[0];
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public TECameraSettings.ExposureCompensationInfo getCameraECInfo() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Cert getCameraPrivacyCert(TECameraSettings.TECameraPrivacyCertType r100) {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public TECameraSettings getCameraSettings() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getCameraType() {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Context getContext() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getExposureCompensation() {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public float[] getFOV() {
        return new float[0];
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Bundle getFeatures(String r100) {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Map<String, Bundle> getFeatures() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getFlashMode() {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getFrameOrientation() {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getFrameRotation() {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Handler getHandler() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getISO() {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public float getManualFocusAbility() {
        return 0.0f;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public float getMaxZoom() {
        return 0.0f;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int[] getPictureSize() {
        return new int[0];
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int[] getPreviewFps() {
        return new int[0];
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public HashMap<String, Object> getPreviewMetadata() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getRetryStartPreviewCount() {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public long[] getShutterTimeRange() {
        return new long[0];
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public List<TEFrameSizei> getSupportedPictureSizes() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public List<TEFrameSizei> getSupportedPreviewSizes() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public String getWideAngleID() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public boolean isAutoExposureLockSupported() {
        return false;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public boolean isAutoFocusLockSupported() {
        return false;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public boolean isDynamicRangeProfileSupported(long r100) {
        return false;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public boolean isHDR10BitSupported() {
        return false;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public boolean isNeedCollectCameraCapabilities() {
        return false;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public boolean isSupportWhiteBalance() {
        return false;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public boolean isSupportedExposureCompensation() {
        return false;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public boolean isTorchSupported() {
        return false;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int open(int r100, int r101, int r102, int r103, int r104, boolean r105, Object r106) {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void process(TECameraSettings.Operation r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public TECameraFrame processAlgorithm(TECameraFrame r100) {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void queryShaderZoomStep(TECameraSettings.ShaderZoomCallback r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void registerFpsConfigListener(TECameraBase.CameraFpsConfigCallback r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void registerPreviewListener(TECameraBase.PreviewSizeCallBack r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void removeCameraAlgorithm(int r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void resetRetryStartPreviewCount() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void retryStartPreviewOnce() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setAperture(float r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setAutoExposureLock(boolean r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setAutoFocusLock(boolean r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setDeviceRotation(int r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public boolean setExposureCompensation(int r100) {
        return false;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setFeatureParameters(Bundle r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setISO(int r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setLensCallback(TECameraAlgorithmInterface.TECameraLensCallback r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setManualFocusDistance(float r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setPictureSize(int r100, int r101) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setPreviewFpsRange() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setPreviewFpsRangeWhenRunning(TEFrameRateRange r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setSATZoomCallback(TECameraBase.SATZoomCallback r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setSceneMode(int r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setShutterTime(long r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setWhiteBalance(boolean r100, String r101) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int startRecording() {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void startZoom(float r100, TECameraSettings.ZoomCallback r101) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void stopCameraFaceDetect() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int stopRecording() {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void stopRetryStartPreview() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void stopZoom(TECameraSettings.ZoomCallback r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void switchCameraMode(int r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void toggleTorch(boolean r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void updateCameraAlgorithmParam(TECameraAlgorithmParam r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void updateSurface() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void useFaceAEStrategy(int r100) {
    }

    private List<TECameraBase> getCurrentControlCamera() {
        ArrayList r100 = new ArrayList();
        int r101 = this.mControlFacing;
        if (r101 != 1) goto L5;
        r100.add((TECameraBase) ListProtector.get(this.mCameraInstances, 1));
    L9:
        return r100;
    L5:
        if (r101 == 7) goto L7;
        r100.add((TECameraBase) ListProtector.get(this.mCameraInstances, 0));
        goto L9
    L7:
        r100.addAll(this.mCameraInstances);
        goto L9
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void abortSession() {
        Iterator<TECameraBase> r100 = this.mCameraInstances.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().abortSession();
        goto L4
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void clearResourceBeforeRestartWhenCameraErr() {
        Iterator<TECameraBase> r100 = this.mCameraInstances.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().clearResourceBeforeRestartWhenCameraErr();
        goto L4
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void destroy() {
        Iterator<TECameraBase> r100 = this.mCameraInstances.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().destroy();
        goto L4
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public TECameraBase.CameraEvents getCameraEvents() {
        TECameraBase r100 = (TECameraBase) ListProtector.get(this.mCameraInstances, 0);
        if (r100 != null) goto L5;
    L7:
        return null;
    L5:
        if (this.mCameraCallbacks.get(r100) == null) goto L7;
        return this.mCameraCallbacks.get(r100).cameraEvents;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getFacing() {
        return this.mCameraSettings.mFacing;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int[] getISORange() {
        Iterator<TECameraBase> r100 = this.mCameraInstances.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        TECameraBase r101 = r100.next();
        if (r101.getFacing() != this.mControlFacing) goto L4;
        return r101.getISORange();
    L10:
        return new int[0];
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void releaseSurfaceTexture() {
        Iterator<TECameraBase> r100 = this.mCameraInstances.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().releaseSurfaceTexture();
        goto L4
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void stopCapture() {
        Iterator<TECameraBase> r100 = this.mCameraInstances.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().stopCapture();
        goto L4
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void startCapture() {
        this.mPreviewStartTime = System.currentTimeMillis();
        if (this.mCameraSettings.mbDualCameraExpansionScheme == false) goto L5;
        TECameraBase r100 = (TECameraBase) ListProtector.get(this.mCameraInstances, 0);
        this.mHasFirstBackFrameCaptured = false;
        r100.startCapture();
        return;
    L5:
        Iterator<TECameraBase> r101 = this.mCameraInstances.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().startCapture();
        goto L7
    L9:
        this.mHasFirstBackFrameCaptured = false;
        this.mHasFirstFrontFrameCaptured = false;
    }

    public int getPrimaryCameraFacing() {
        return mPrimaryCameraFacing;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public TECameraProviderManager getProviderManager() {
        return this.mProviderMgr;
    }

    public static /* synthetic */ long access$000(TEMultiCamera r100) {
        return r100.mOpenStartTime;
    }

    public static /* synthetic */ TECameraBase.CameraEvents access$100(TEMultiCamera r100) {
        return r100.mConvergedCameraEvent;
    }

    public static /* synthetic */ HashSet access$200(TEMultiCamera r100) {
        return r100.mCamerasToOpen;
    }

    public static /* synthetic */ HashSet access$300(TEMultiCamera r100) {
        return r100.mCamerasToClose;
    }

    public static /* synthetic */ TECameraSettings access$400(TEMultiCamera r100) {
        return r100.mCameraSettings;
    }

    public static /* synthetic */ boolean access$500(TEMultiCamera r100) {
        return r100.mbNeedToCallbackInfo;
    }

    public static /* synthetic */ boolean access$800(TEMultiCamera r100) {
        return r100.mbNeedToCallOnClosed;
    }

    public static /* synthetic */ List access$900(TEMultiCamera r100) {
        return r100.mCameraInstances;
    }

    private int openCamera(TECameraBase r100) {
        TECameraSettings r101 = (TECameraSettings) this.mCameraSettings.clone();
        r101.mFacing = r100.getCameraSettings().mFacing;
        TELogUtils.i(TAG, "opening camera = " + r100 + ", facing = " + r101.mFacing);
        if (r101.mFacing != 1) goto L6;
        r101.mDefaultZoomRatio = 1.0f;
    L6:
        return r100.open(r101, this.mPrivacyCert);
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int changeCurrentControlCam(int r100) {
        TELogUtils.i(TAG, "changeCurrentControlCam to " + r100);
        this.mControlFacing = r100;
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int close(Object r100) {
        this.mCloseStartTime = System.currentTimeMillis();
        Iterator<TECameraBase> r101 = this.mCameraInstances.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        TECameraBase r103 = r101.next();
        int r104 = r103.close(r100);
        if (r104 == 0) goto L8;
        r102 = r104;
    L8:
        TECameraMonitor.perfLong("te_record_camera_close_cost_multi_" + r103.getFacing(), System.currentTimeMillis() - this.mCloseStartTime);
        TELogUtils.d(TAG, "multicamera " + r103.getFacing() + "close cost " + (System.currentTimeMillis() - this.mCloseStartTime));
        goto L4
    L9:
        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_DUAL_CAMERA_CLOSE_RET, r102);
        return r102;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void focusAtPoint(TEFocusSettings r100) {
        Iterator<TECameraBase> r101 = getCurrentControlCamera().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().focusAtPoint(r100);
        goto L4
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void forceCloseCamera(Object r100) {
        Iterator<TECameraBase> r101 = this.mCameraInstances.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().forceCloseCamera(r100);
        goto L4
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getFrameRotation(int r100) {
        return ((TECameraBase) ListProtector.get(this.mCameraInstances, r100)).getFrameRotation();
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void needToReleaseSurfaceTexture(boolean r100) {
        Iterator<TECameraBase> r101 = this.mCameraInstances.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().needToReleaseSurfaceTexture(r100);
        goto L4
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void notifyFrameAvailable(int r100) {
        if (r100 == 0) goto L5;
    L6:
        if (r100 == 1) goto L8;
        return;
    L8:
        if (this.mHasFirstFrontFrameCaptured == true) goto L18;
    L9:
        if (r100 != 0) goto L11;
        this.mHasFirstBackFrameCaptured = true;
    L12:
        long r101 = System.currentTimeMillis() - this.mPreviewStartTime;
        TECameraBase.CameraEvents r102 = getCameraEvents();
        if (r102 == null) goto L15;
        r102.onCameraInfo(3, 0, "Camera first frame captured, multi camera, facing: " + r100, this);
    L15:
        TELogUtils.i(TAG, "Camera first frame captured，multi camera, facing = " + r100 + ", start preview cost time = " + r101);
        StringBuilder r103 = new StringBuilder("te_record_camera_preview_first_frame_cost_multi_");
        r103.append(r100);
        TECameraMonitor.perfLong(r103.toString(), r101);
        TELogUtils.logMonitorInfo("te_record_camera_preview_first_frame_cost_multi_" + r100, Long.valueOf(r101));
        return;
    L11:
        this.mHasFirstFrontFrameCaptured = true;
        goto L12
    L18:
        return;
    L5:
        if (this.mHasFirstBackFrameCaptured == false) goto L9;
        goto L6
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setProviderManager(TECameraProviderManager r100) {
        TELogUtils.i(TAG, "setProviderManager");
        this.mProviderMgr = r100;
        Iterator<TECameraBase> r101 = this.mCameraInstances.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().setProviderManager(r100);
        goto L4
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void switchFlashMode(int r100) {
        Iterator<TECameraBase> r101 = getCurrentControlCamera().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().switchFlashMode(r100);
        goto L4
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void takePicture(TECameraSettings.PictureCallback r100) {
        int r101 = this.mControlFacing;
        if (r101 != 0) goto L5;
        ((TECameraBase) ListProtector.get(this.mCameraInstances, 0)).takePicture(r100);
        return;
    L5:
        if (r101 != 1) goto L7;
        ((TECameraBase) ListProtector.get(this.mCameraInstances, 1)).takePicture(r100);
        return;
    L7:
        if (r101 == 7) goto L9;
        ((TECameraBase) ListProtector.get(this.mCameraInstances, 0)).takePicture(r100);
        return;
    L9:
        Iterator<TECameraBase> r102 = this.mCameraInstances.iterator();
    L11:
        if (r102.hasNext() == false) goto L19;
        r102.next().takePicture(r100);
        goto L11
    }

    public static /* synthetic */ int access$1000(TEMultiCamera r100, TECameraBase r101) {
        return r100.openCamera(r101);
    }

    public static /* synthetic */ boolean access$502(TEMultiCamera r100, boolean r101) {
        r100.mbNeedToCallbackInfo = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$602(TEMultiCamera r100, boolean r101) {
        r100.mHasFirstBackFrameCaptured = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$702(TEMultiCamera r100, boolean r101) {
        r100.mHasFirstFrontFrameCaptured = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$802(TEMultiCamera r100, boolean r101) {
        r100.mbNeedToCallOnClosed = r101;
        return r101;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int open(TECameraSettings r100, Object r101) {
        this.mPrivacyCert = r101;
        this.mCameraSettings = r100;
        int r102 = 0;
        this.mbNeedToCallbackInfo = false;
        this.mbNeedToCallOnClosed = true;
        this.mOpenStartTime = System.currentTimeMillis();
        int r103 = 0;
    L4:
        if (r103 >= this.mCameraInstances.size()) goto L9;
        TECameraBase r104 = (TECameraBase) ListProtector.get(this.mCameraInstances, r103);
        if (r104 == null) goto L8;
        TECameraSettings r105 = r104.getCameraSettings();
        r105.mMode = r100.mMode;
        r104.getCameraSettings().mFacing = r103;
    L8:
        r103 = r103 + 1;
        goto L4
    L9:
        this.mCamerasToOpen = new HashSet(this.mCameraInstances);
        if (this.mCameraSettings.mbDualCameraExpansionScheme == false) goto L18;
        TECameraBase r106 = (TECameraBase) ListProtector.get(this.mCameraInstances, 0);
        if (r106 != null) goto L15;
        TELogUtils.e(TAG, "failed to open, first camera is null");
        return -1;
    L15:
        int r107 = openCamera(r106);
        if (r107 == 0) goto L27;
        TELogUtils.e(TAG, "failed to open camera");
    L27:
        this.mHasOpenedCameraFacing = 7;
        return r107;
    L18:
        Iterator<TECameraBase> r108 = this.mCameraInstances.iterator();
    L20:
        if (r108.hasNext() == false) goto L26;
        TECameraBase r109 = r108.next();
        if (r109 == null) goto L20;
        r102 = openCamera(r109);
        if (r102 == 0) goto L20;
        TELogUtils.e(TAG, "failed to open camera");
    L26:
        r107 = r102;
        goto L27
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void queryZoomAbility(TECameraSettings.ZoomCallback r100, boolean r101) {
        Iterator<TECameraBase> r102 = getCurrentControlCamera().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().queryZoomAbility(r100, r101);
        goto L4
    }

    public int switchCamera(int r100, Object r101) {
        TELogUtils.i(TAG, "switchCamera, facing = " + r100 + ", mHasOpenedCameraFacing = " + this.mHasOpenedCameraFacing);
        if (r100 == 0) goto L37;
        if (r100 == 1) goto L18;
        if (r100 != 7) goto L17;
        int r102 = this.mHasOpenedCameraFacing;
        if (r102 == 7) goto L17;
        if (r102 != 1) goto L11;
        TECameraBase r103 = (TECameraBase) ListProtector.get(this.mCameraInstances, 0);
    L12:
        if (r103 != null) goto L15;
        TELogUtils.e(TAG, "switchCamera, failed to open, camera is null");
        return -1;
    L15:
        this.mHasOpenedCameraFacing = 7;
        this.mbNeedToCallbackInfo = true;
        return openCamera(r103);
    L11:
        r103 = (TECameraBase) ListProtector.get(this.mCameraInstances, 1);
    L17:
        return -1;
    L18:
        int r104 = this.mHasOpenedCameraFacing;
        if (r104 == 7) goto L21;
        if (r104 == 0) goto L21;
    L36:
        return 0;
    L21:
        TECameraBase r105 = (TECameraBase) ListProtector.get(this.mCameraInstances, 0);
        if (r105 != null) goto L25;
        TELogUtils.e(TAG, "switchCamera, failed to close, back camera is null");
        return -1;
    L25:
        this.mbNeedToCallOnClosed = false;
        r105.close(r101);
        TECameraBase.CameraEvents r106 = getCameraEvents();
        if (r106 == null) goto L31;
        if (this.mHasOpenedCameraFacing != 7) goto L31;
        r106.onCameraInfo(122, this.mCameraSettings.mCameraType, "switch to front camera done", this);
    L31:
        if (this.mHasOpenedCameraFacing != 0) goto L35;
        TECameraBase r107 = (TECameraBase) ListProtector.get(this.mCameraInstances, 1);
        if (r107 == null) goto L35;
        this.mbNeedToCallbackInfo = true;
        openCamera(r107);
    L35:
        this.mHasOpenedCameraFacing = 1;
        changeCurrentControlCam(1);
        goto L36
    L37:
        int r108 = this.mHasOpenedCameraFacing;
        if (r108 == 7) goto L40;
        if (r108 == 1) goto L40;
    L55:
        return 0;
    L40:
        TECameraBase r109 = (TECameraBase) ListProtector.get(this.mCameraInstances, 1);
        if (r109 != null) goto L44;
        TELogUtils.e(TAG, "switchCamera, failed to close, front camera is null");
        return -1;
    L44:
        this.mbNeedToCallOnClosed = false;
        r109.close(r101);
        TECameraBase.CameraEvents r110 = getCameraEvents();
        if (r110 == null) goto L50;
        if (this.mHasOpenedCameraFacing != 7) goto L50;
        r110.onCameraInfo(122, this.mCameraSettings.mCameraType, "switch to rear camera done", this);
    L50:
        if (this.mHasOpenedCameraFacing != 1) goto L54;
        TECameraBase r111 = (TECameraBase) ListProtector.get(this.mCameraInstances, 0);
        if (r111 == null) goto L54;
        this.mbNeedToCallbackInfo = true;
        openCamera(r111);
    L54:
        this.mHasOpenedCameraFacing = 0;
        changeCurrentControlCam(0);
        goto L55
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void zoomV2(float r100, TECameraSettings.ZoomCallback r101) {
        Iterator<TECameraBase> r102 = getCurrentControlCamera().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().zoomV2(r100, r101);
        goto L4
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void takePicture(int r100, int r101, TECameraSettings.PictureCallback r102) {
        Iterator<TECameraBase> r103 = getCurrentControlCamera().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().takePicture(r100, r101, r102);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.ss.android.ttvecamera.TECameraBase$PictureSizeCallBack, com.ss.android.ttvecamera.TECameraSettings] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public TEMultiCamera(int r110, Context r210, TECameraBase.CameraEvents r211, Handler r212, TECameraBase.PictureSizeCallBack r213) {
        this.mCamerasToOpen = new HashSet();
        this.mCamerasToClose = new HashSet();
        this.mControlFacing = 0;
        this.mHasOpenedCameraFacing = -1;
        this.mHasFirstBackFrameCaptured = false;
        this.mHasFirstFrontFrameCaptured = false;
        this.mbNeedToCallbackInfo = false;
        this.mbNeedToCallOnClosed = true;
        this.mOpenStartTime = 0;
        this.mPreviewStartTime = 0;
        this.mCloseStartTime = 0;
        ArrayList r100 = new ArrayList();
        this.mCameraInstances = r100;
        ConcurrentHashMap<TECameraBase, TECameraCallbackHolder> r111 = new ConcurrentHashMap();
        this.mCameraCallbacks = r111;
        this.mContext = r210;
        this.mConvergedCameraEvent = r211;
        this.mHandler = r212;
        this.mPictureSizeCallback = r213;
        this.mProviderMgr = new TECameraProviderManager();
        InstancedCameraEvents r112 = new InstancedCameraEvents(this, 0);
        InstancedCameraEvents r113 = new InstancedCameraEvents(this, 1);
        TECamera2 r101 = null;
        if (r110 != 2) goto L5;
        ?? r102 = 0;
        TECamera2 r114 = new TECamera2(r110, r210, r112, r212, r213);
        TECamera2 r103 = new TECamera2(r110, r210, r113, r212, null);
    L15:
        r101 = r114;
    L16:
        r100.add(r101);
        r100.add(r103);
        if (r101 == null) goto L19;
        r111.put(r101, new TECameraCallbackHolder(r112, r213, r102));
    L19:
        if (r103 == null) goto L21;
        r111.put(r103, new TECameraCallbackHolder(r113, r102, r102));
    L21:
        TELogUtils.i(TAG, "create TEMultiCamera, mCameraInstances = " + r100);
        return;
    L5:
        if (r110 == 8) goto L8;
        TELogUtils.e(TAG, "Unsupported camera type");
        r102 = 0;
        r103 = null;
        goto L16
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        r102 = 0;
        TECamera2 r115 = (TECamera2) TECameraUtils.createCameraInstance("com.ss.android.ttvecamera.TEXmV2Camera", r110, r210, r112, r212, r213);
        TECamera2 r104 = (TECamera2) TECameraUtils.createCameraInstance("com.ss.android.ttvecamera.TEXmV2Camera", r110, r210, r113, r212, null);
        TELogUtils.i(TAG, "create TEXmV2Camera instance for MultiCamera");
        r103 = r104;
        r101 = r115;
    L11:
        if (r101 == null) goto L13;
        if (r103 != null) goto L16;
    L13:
        TELogUtils.e(TAG, "create TEXmV2Camera failed, change to camera2");
        r114 = new TECamera2(r110, r210, r112, r212, r213);
        r103 = new TECamera2(r110, r210, r113, r212, null);
        r102 = r102;
        goto L15
    L10:
        r102 = 0;
        r103 = null;
        r101 = null;
        goto L11
    }

    public static TEMultiCamera create(int r100, Context r101, TECameraBase.CameraEvents r102, Handler r110, TECameraBase.PictureSizeCallBack r111, int r112) {
        if (r112 == 7) goto L6;
        mPrimaryCameraFacing = r112;
    L6:
        return new TEMultiCamera(r100, r101, r102, r110, r111);
    }
}
