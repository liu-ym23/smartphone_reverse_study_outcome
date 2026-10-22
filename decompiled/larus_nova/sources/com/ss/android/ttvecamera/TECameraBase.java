package com.ss.android.ttvecamera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.bpea.basics.Cert;
import com.ss.android.ttvecamera.cameraalgorithm.TECameraAlgorithmInterface;
import com.ss.android.ttvecamera.cameraalgorithm.TECameraAlgorithmParam;
import com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityCollector;
import com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityKBUpload;
import com.ss.android.ttvecamera.model.BurstRequest;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public abstract class TECameraBase implements ICameraInstance {
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    public static final int CAMERA_FACING_WIDE_ANGLE = 2;
    public static final int CAMERA_TYPE_1 = 1;
    public static final int CAMERA_TYPE_2 = 2;
    public static final int HW_CHECK_LEVEL_3 = 3;
    public static final int HW_CHECK_LEVEL_FULL = 2;
    public static final int HW_CHECK_LEVEL_LEGACY = 0;
    public static final int HW_CHECK_LEVEL_LIMITED = 1;
    private static final String TAG = "TECameraBase";
    public TECameraAlgorithmInterface mAlgorithmInterface;
    protected Map<Integer, Bundle> mAllDevicesFeatures;
    public long mAvgExpTime;
    public int mAvgISO;
    public JSONObject mCameraCapabilitiesMap;
    protected CameraEvents mCameraEvents;
    public HashMap<TECameraSettings.TECameraPrivacyCertType, Cert> mCameraPrivacyCertMap;
    protected int mCameraRotation;
    protected TECameraSettings mCameraSettings;
    protected TECameraCapabilityCollector mCapabilityCollector;
    protected long mCloseStartTime;
    protected Context mContext;
    protected int mDeviceRotation;
    protected int mFacing;
    protected Map<String, Bundle> mFeatures;
    protected CameraFpsConfigCallback mFpsConfigCallback;
    public long mFrameCountFromCamera2;
    public int mFrameNum;
    public boolean mFrameReset;
    protected Handler mHandler;
    private boolean mHasFirstBackFrameCaptured;
    private boolean mHasFirstFrameCaptured;
    private boolean mHasFirstFrontFrameCaptured;
    protected boolean mHaveCollectedCapbilities;
    protected boolean mIsRunning;
    protected float mMaxZoom;
    public Runnable mMonitorRuntimeInfoTask;
    protected int mNewFacing;
    protected long mOpenStartTime;
    protected PictureSizeCallBack mPictureSizeCallback;
    public final TECameraFrame.Metadata mPreviewMetadata;
    protected PreviewSizeCallBack mPreviewSizeCallback;
    protected long mPreviewStartTime;
    protected TECameraProviderManager mProviderMgr;
    protected int mRetryStartPreviewCount;
    public TECameraResult.TECameraRuntimeInfo mRuntimeInfo;
    protected SATZoomCallback mSATZoomCallback;
    protected SurfaceTexture mSurfaceTexture;
    private final Object mSurfaceTextureLock;
    private AtomicBoolean mUpdateCameraOrientation;
    public boolean mZslSupport;
    private volatile boolean mbNeedReleaseSurfaceTexture;
    protected Object openPrivacyCert;

    /* JADX INFO: renamed from: com.ss.android.ttvecamera.TECameraBase$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$ttvecamera$provider$TECameraProviderManager$SURFACE_OPERATION = null;

        static {
            int[] r100 = new int[TECameraProviderManager.SURFACE_OPERATION.values().length];
            $SwitchMap$com$ss$android$ttvecamera$provider$TECameraProviderManager$SURFACE_OPERATION = r100;
            r100[TECameraProviderManager.SURFACE_OPERATION.REMOVE_SURFACE_TEXTURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public interface CameraEvents {

        /* JADX INFO: renamed from: com.ss.android.ttvecamera.TECameraBase$CameraEvents$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCameraInfoForTrack(CameraEvents r100, int r101, int r102, String r103, long r104) {
            }
        }

        void onCameraClosed(int r100, ICameraInstance r101, Object r102);

        void onCameraError(int r100, int r101, String r102, Object r103);

        void onCameraInfo(int r100, int r101, String r102, Object r103);

        void onCameraInfoForTrack(int r100, int r101, String r102, long r103);

        void onCameraOpened(int r100, int r101, ICameraInstance r102, Object r103);

        void onPreviewError(int r100, int r101, String r102, Object r103);

        void onPreviewStopped(int r100, int r101, int r102, String r103, Object r104);

        void onPreviewSuccess(int r100, int r101, int r102, String r103, Object r104);

        void onTorchError(int r100, int r101, int r102, String r103, Object r104);

        void onTorchSuccess(int r100, int r101, int r102, String r103, Object r104);
    }

    public interface CameraFpsConfigCallback {
        int[] config(List<int[]> r100);
    }

    public interface CameraKitStateCallback {
        void onPause();

        void onResume();

        void onStart();

        void onStop();
    }

    public static class ExposureCompensationInfo {
        public int exposure;
        public int max;
        public int min;
        public float step;

        public boolean isSupportExposureCompensation() {
            if (this.max > this.min) goto L5;
        L7:
            return false;
        L5:
            if (this.step <= 0.001f) goto L7;
            return true;
        }

        public ExposureCompensationInfo() {
            this.max = 0;
            this.exposure = 0;
            this.min = 0;
            this.step = 0.0f;
        }
    }

    public interface PictureSizeCallBack {
        TEFrameSizei getPictureSize(List<TEFrameSizei> r100, List<TEFrameSizei> r101);
    }

    public interface PreviewSizeCallBack {
        TEFrameSizei getPreviewSize(List<TEFrameSizei> r100);
    }

    public interface SATZoomCallback {
        void onChange(int r100, float r101);
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void abortSession() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void addCameraAlgorithm(TECameraAlgorithmParam r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void cancelFocus();

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int changeCurrentControlCam(int r100) {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void changeRecorderState(int r100, CameraKitStateCallback r101) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void clearResourceBeforeRestartWhenCameraErr() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void collectCameraCapabilities() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void enableCaf();

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void enableMulticamZoom(boolean r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void focusAtPoint(TEFocusSettings r100);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void forceCloseCamera(Object r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public float[] getApertureRange() {
        return new float[]{-1.0f, -1.0f};
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract TEFrameSizei getBestPreviewSize(float r100, TEFrameSizei r101);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public JSONObject getCameraCapbilitiesForBytebench() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int[] getCameraCaptureSize() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract int getCameraType();

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract float[] getFOV();

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getFlashMode() {
        return -1;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract int getFrameOrientation();

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getISO() {
        return -1;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int[] getISORange() {
        return new int[]{-1, -1};
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public float getManualFocusAbility() {
        return -1.0f;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int[] getPictureSize() {
        TEFrameSizei r100 = this.mCameraSettings.mPictureSize;
        return new int[]{r100.width, r100.height};
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int[] getPreviewFps() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public long[] getShutterTimeRange() {
        return new long[]{-1, -1};
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public String getWideAngleID() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract boolean isAutoExposureLockSupported();

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public boolean isAutoFocusLockSupported() {
        return false;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract boolean isDynamicRangeProfileSupported(long r100);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract boolean isHDR10BitSupported();

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract boolean isSupportWhiteBalance();

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract boolean isTorchSupported();

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract int open(int r100, int r101, int r102, int r103, int r104, boolean r105, Object r106);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void queryShaderZoomStep(TECameraSettings.ShaderZoomCallback r100);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void queryZoomAbility(TECameraSettings.ZoomCallback r100, boolean r101);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void removeCameraAlgorithm(int r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setAperture(float r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void setAutoExposureLock(boolean r100);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setAutoFocusLock(boolean r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract boolean setExposureCompensation(int r100);

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
    public void setSATZoomCallback(SATZoomCallback r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setShutterTime(long r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void setWhiteBalance(boolean r100, String r101);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void startCapture() {
        this.mHasFirstFrameCaptured = false;
        this.mHasFirstBackFrameCaptured = false;
        this.mHasFirstFrontFrameCaptured = false;
        this.mPreviewStartTime = System.currentTimeMillis();
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int startRecording() {
        return -1;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void startZoom(float r100, TECameraSettings.ZoomCallback r101);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void stopCameraFaceDetect() {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void stopCapture();

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int stopRecording() {
        return -1;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void stopRetryStartPreview() {
        this.mRetryStartPreviewCount = 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void stopZoom(TECameraSettings.ZoomCallback r100);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void switchCameraMode(int r100);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void switchFlashMode(int r100);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void takePicture(int r100, int r101, TECameraSettings.PictureCallback r102);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void takePicture(TECameraSettings.PictureCallback r100);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void toggleTorch(boolean r100);

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void updateCameraAlgorithmParam(TECameraAlgorithmParam r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void useFaceAEStrategy(int r100) {
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public abstract void zoomV2(float r100, TECameraSettings.ZoomCallback r101);

    public boolean canUseYuvPictureFormat() {
        TECameraSettings r100 = this.mCameraSettings;
        int r101 = r100.mCameraCaptureYuvStrategy;
        if (r101 != 3) goto L5;
        return true;
    L5:
        if (r101 != 1) goto L10;
        if (r100.mFacing != 1) goto L10;
        return true;
    L10:
        if (r101 == 2) goto L12;
        return false;
    L12:
        if (r100.mFacing != 0) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void destroy() {
        TECameraAlgorithmInterface r100 = this.mAlgorithmInterface;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        TECameraProviderManager r101 = this.mProviderMgr;
        if (r101 == null) goto L9;
        r101.removeProvider();
        TELogUtils.i(TAG, "release provider");
        return;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Bundle fillFeatures() {
        String r100 = this.mCameraSettings.mCameraType + "_" + this.mCameraSettings.mFacing;
        TELogUtils.d(TAG, "fillFeatures key = " + r100);
        if (this.mFeatures.containsKey(r100) == false) goto L5;
        Bundle r101 = this.mFeatures.get(r100);
    L6:
        if (r101 == null) goto L8;
        r101.putInt(TECameraSettings.Features.CAMERA_FACING, this.mCameraSettings.mFacing);
    L8:
        return r101;
    L5:
        Bundle r102 = new Bundle();
        this.mFeatures.put(r100, r102);
        r101 = r102;
        goto L6
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public TECameraSettings.ExposureCompensationInfo getCameraECInfo() {
        return this.mCameraSettings.mCameraECInfo;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getExposureCompensation() {
        TECameraSettings.ExposureCompensationInfo r100 = this.mCameraSettings.mCameraECInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.exposure;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getFrameRotation() {
        if (this.mUpdateCameraOrientation.getAndSet(false) == false) goto L6;
        getFrameOrientation();
    L6:
        return this.mCameraRotation;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public HashMap<String, Object> getPreviewMetadata() {
        return this.mPreviewMetadata.flattenForTitan();
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public List<TEFrameSizei> getSupportedPictureSizes() {
        TELogUtils.e(TAG, "getSupportedPictureSizes error");
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public List<TEFrameSizei> getSupportedPreviewSizes() {
        TELogUtils.e(TAG, "getSupportedPreviewSizes error");
        return null;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public boolean isNeedCollectCameraCapabilities() {
        if (this.mCameraSettings.mEnableCollectCapbilities == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mHaveCollectedCapbilities == true) goto L7;
        return true;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public boolean isSupportedExposureCompensation() {
        TECameraSettings.ExposureCompensationInfo r100 = this.mCameraSettings.mCameraECInfo;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isSupportExposureCompensation() == false) goto L7;
        return true;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void releaseSurfaceTexture() {
        TELogUtils.i(TAG, "releaseSurfaceTexture");
        Object r100 = this.mSurfaceTextureLock;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mbNeedReleaseSurfaceTexture == false) goto L7;
        TELogUtils.d(TAG, "need releaseSurfaceTexture");     // Catch: Throwable -> L9
        this.mbNeedReleaseSurfaceTexture = false;     // Catch: Throwable -> L9
        this.mProviderMgr.releaseSurfaceTexture();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void resetRetryStartPreviewCount() {
        this.mRetryStartPreviewCount = this.mCameraSettings.mRetryStartPreviewCnt;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void retryStartPreviewOnce() {
        int r100 = this.mRetryStartPreviewCount;
        if (r100 <= 0) goto L6;
        this.mRetryStartPreviewCount = r100 - 1;
        return;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void updateSurface() {
        TELogUtils.i(TAG, "updateSurface");
        TECameraProviderManager r100 = this.mProviderMgr;
        if (r100 != null) goto L5;
    L12:
        TELogUtils.e(TAG, "can not update provider");
        return;
    L5:
        if (r100.getProvider() == null) goto L12;
        if (AnonymousClass2.$SwitchMap$com$ss$android$ttvecamera$provider$TECameraProviderManager$SURFACE_OPERATION[this.mProviderMgr.getProvider().getSurfaceOperation().ordinal()] == 1) goto L10;
        TELogUtils.w(TAG, "not support!");
        return;
    L10:
        this.mProviderMgr.getProvider().removeSurfaceTexture();
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public CameraEvents getCameraEvents() {
        return this.mCameraEvents;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public TECameraSettings getCameraSettings() {
        return this.mCameraSettings;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getFacing() {
        return this.mFacing;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Map<String, Bundle> getFeatures() {
        return this.mFeatures;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Handler getHandler() {
        return this.mHandler;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public float getMaxZoom() {
        return this.mMaxZoom;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public TECameraProviderManager getProviderManager() {
        return this.mProviderMgr;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getRetryStartPreviewCount() {
        return this.mRetryStartPreviewCount;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int close(Object r100) {
        this.mCloseStartTime = System.currentTimeMillis();
        TELogUtils.d(TAG, "close...");
        return 0;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public long getAvgExpTime(boolean r100) {
        long r101 = this.mAvgExpTime;
        this.mFrameReset = r100;
        return r101;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Cert getCameraPrivacyCert(TECameraSettings.TECameraPrivacyCertType r100) {
        HashMap<TECameraSettings.TECameraPrivacyCertType, Cert> r101 = this.mCameraPrivacyCertMap;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return null;
    L7:
        if (this.mCameraPrivacyCertMap.containsKey(r100) == true) goto L9;
        return null;
    L9:
        return this.mCameraPrivacyCertMap.get(r100);
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Bundle getFeatures(String r100) {
        return this.mFeatures.get(r100);
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int getFrameRotation(int r100) {
        return getFrameRotation();
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void needToReleaseSurfaceTexture(boolean r100) {
        Object r101 = this.mSurfaceTextureLock;
        monitor-enter(r101);
        TELogUtils.i(TAG, "needRelease is " + r100);     // Catch: Throwable -> L7
        this.mbNeedReleaseSurfaceTexture = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void notifyFrameAvailable(int r110) {
        int r100 = this.mCameraSettings.mFacing;
        if (r100 == 7) goto L6;
        this.mFrameNum++;
    L6:
        if (r100 != 7) goto L8;
    L13:
        if (r100 != 7) goto L29;
        if (r110 == 0) goto L16;
    L17:
        if (r110 == 1) goto L19;
        return;
    L19:
        if (this.mHasFirstFrontFrameCaptured == true) goto L31;
    L20:
        if (r110 != 0) goto L22;
        this.mHasFirstBackFrameCaptured = true;
    L23:
        long r101 = System.currentTimeMillis() - this.mPreviewStartTime;
        CameraEvents r102 = getCameraEvents();
        if (r102 == null) goto L26;
        r102.onCameraInfoForTrack(3, 0, "Camera first frame captured, multi camera, facing: " + r110, System.currentTimeMillis());
        TELogUtils.i(TAG, "track for TET_CAMERA_FIRST_FRAME_CAPTURED timeStamp:" + System.currentTimeMillis());
        r102.onCameraInfo(3, 0, "Camera first frame captured, multi camera, facing: " + r110, this);
    L26:
        TELogUtils.i(TAG, "Camera first frame captured，multi camera, facing = " + r110 + ", start preview cost time = " + r101);
        StringBuilder r103 = new StringBuilder("te_record_camera_preview_first_frame_cost_multi_");
        r103.append(r110);
        TECameraMonitor.perfLong(r103.toString(), r101);
        TELogUtils.logMonitorInfo("te_record_camera_preview_first_frame_cost_multi_" + r110, Long.valueOf(r101));
        return;
    L22:
        this.mHasFirstFrontFrameCaptured = true;
        goto L23
    L31:
        return;
    L16:
        if (this.mHasFirstBackFrameCaptured == false) goto L20;
    L29:
        return;
    L8:
        if (this.mHasFirstFrameCaptured == true) goto L13;
        this.mHasFirstFrameCaptured = true;
        long r104 = System.currentTimeMillis() - this.mPreviewStartTime;
        CameraEvents r111 = getCameraEvents();
        if (r111 == null) goto L12;
        int r105 = (int) r104;
        r111.onCameraInfoForTrack(3, r105, "Camera first frame captured", System.currentTimeMillis());
        TELogUtils.i(TAG, "track for TET_CAMERA_FIRST_FRAME_CAPTURED timeStamp:" + System.currentTimeMillis());
        r111.onCameraInfo(3, r105, "Camera first frame captured", this);
    L12:
        TELogUtils.i(TAG, "Camera first frame captured，single camera, start preview cost time = " + r104);
        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_PREVIEW_FIRST_FRAME_COST, r104);
        TELogUtils.logMonitorInfo(TECameraMonitor.TE_RECORD_CAMERA_PREVIEW_FIRST_FRAME_COST, Long.valueOf(r104));
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void process(TECameraSettings.Operation r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getType() != 2) goto L8;
        this.mUpdateCameraOrientation.set(true);
        return;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public TECameraFrame processAlgorithm(TECameraFrame r100) {
        TECameraAlgorithmInterface r101 = this.mAlgorithmInterface;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.processAlgorithm(r100);
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void registerFpsConfigListener(CameraFpsConfigCallback r100) {
        this.mFpsConfigCallback = r100;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void registerPreviewListener(PreviewSizeCallBack r100) {
        this.mPreviewSizeCallback = r100;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setDeviceRotation(int r100) {
        this.mDeviceRotation = r100;
        this.mUpdateCameraOrientation.set(true);
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setProviderManager(TECameraProviderManager r100) {
        if (this.mProviderMgr != null) goto L6;
        this.mProviderMgr = r100;
        return;
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void setSceneMode(int r100) {
        TELogUtils.i(TAG, "scene mode: " + r100);
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void captureBurst(BurstRequest r100, TECameraSettings.CaptureBufferFrameCallback r101) {
        r101.onError(new UnsupportedOperationException("unsupport capture burst, camera type:" + getCameraType()));
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public Exception createException(Exception r100, int r101) {
        String r102 = r100.getMessage();
        if (r102 != null) goto L6;
        r102 = "Exception message";
    L6:
        return new Exception(r102 + ", errorCode=" + r101);
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public int open(TECameraSettings r100, Object r101) {
        this.mRetryStartPreviewCount = r100.mRetryStartPreviewCnt;
        this.mOpenStartTime = System.currentTimeMillis();
        TELogUtils.i(TAG, "set start preview retry count: " + this.mRetryStartPreviewCount);
        this.mCameraPrivacyCertMap = r100.mCameraPrivacyCertMap;
        TELogUtils.i(TAG, "set mCameraPrivacyCertMap: " + this.mCameraPrivacyCertMap);
        return 0;
    }

    public TECameraBase(Context r100, CameraEvents r101, Handler r102) {
        this.mZslSupport = false;
        this.mIsRunning = false;
        this.mProviderMgr = new TECameraProviderManager();
        this.mCameraRotation = -1;
        this.mDeviceRotation = -1;
        this.mRetryStartPreviewCount = 0;
        this.mPreviewSizeCallback = null;
        this.mFpsConfigCallback = null;
        this.mUpdateCameraOrientation = new AtomicBoolean(false);
        this.mFeatures = new HashMap();
        this.mAllDevicesFeatures = new HashMap();
        this.openPrivacyCert = null;
        this.mCapabilityCollector = new TECameraCapabilityCollector();
        this.mCameraCapabilitiesMap = new JSONObject();
        this.mHaveCollectedCapbilities = false;
        this.mAlgorithmInterface = null;
        this.mAvgExpTime = 0;
        this.mAvgISO = 0;
        this.mFrameCountFromCamera2 = 0;
        this.mFrameReset = false;
        this.mFrameNum = 0;
        this.mbNeedReleaseSurfaceTexture = false;
        this.mSurfaceTextureLock = new Object();
        this.mHasFirstFrameCaptured = false;
        this.mHasFirstBackFrameCaptured = false;
        this.mHasFirstFrontFrameCaptured = false;
        this.mPreviewStartTime = 0;
        this.mOpenStartTime = 0;
        this.mCloseStartTime = 0;
        this.mRuntimeInfo = new TECameraResult.TECameraRuntimeInfo();
        this.mPreviewMetadata = new TECameraFrame.Metadata();
        this.mCameraPrivacyCertMap = null;
        this.mMonitorRuntimeInfoTask = new AnonymousClass1(this);
        this.mContext = r100;
        this.mCameraEvents = r101;
        this.mHandler = r102;
        this.mCapabilityCollector.init(new TECameraCapabilityKBUpload());
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void cameraInfoForAppLog(int r100, int r101, String r102) {
        CameraEvents r103 = this.mCameraEvents;
        if (r103 == null) goto L6;
        r103.onCameraInfoForTrack(r100, r101, r102, System.currentTimeMillis());
        return;
    }

    public TECameraBase(Context r100, CameraEvents r101, Handler r102, PictureSizeCallBack r103) {
        this.mZslSupport = false;
        this.mIsRunning = false;
        this.mProviderMgr = new TECameraProviderManager();
        this.mCameraRotation = -1;
        this.mDeviceRotation = -1;
        this.mRetryStartPreviewCount = 0;
        this.mPreviewSizeCallback = null;
        this.mFpsConfigCallback = null;
        this.mUpdateCameraOrientation = new AtomicBoolean(false);
        this.mFeatures = new HashMap();
        this.mAllDevicesFeatures = new HashMap();
        this.openPrivacyCert = null;
        this.mCapabilityCollector = new TECameraCapabilityCollector();
        this.mCameraCapabilitiesMap = new JSONObject();
        this.mHaveCollectedCapbilities = false;
        this.mAlgorithmInterface = null;
        this.mAvgExpTime = 0;
        this.mAvgISO = 0;
        this.mFrameCountFromCamera2 = 0;
        this.mFrameReset = false;
        this.mFrameNum = 0;
        this.mbNeedReleaseSurfaceTexture = false;
        this.mSurfaceTextureLock = new Object();
        this.mHasFirstFrameCaptured = false;
        this.mHasFirstBackFrameCaptured = false;
        this.mHasFirstFrontFrameCaptured = false;
        this.mPreviewStartTime = 0;
        this.mOpenStartTime = 0;
        this.mCloseStartTime = 0;
        this.mRuntimeInfo = new TECameraResult.TECameraRuntimeInfo();
        this.mPreviewMetadata = new TECameraFrame.Metadata();
        this.mCameraPrivacyCertMap = null;
        this.mMonitorRuntimeInfoTask = new AnonymousClass1(this);
        this.mContext = r100;
        this.mCameraEvents = r101;
        this.mHandler = r102;
        this.mPictureSizeCallback = r103;
        this.mCapabilityCollector.init(new TECameraCapabilityKBUpload());
    }

    @Override // com.ss.android.ttvecamera.ICameraInstance
    public void checkIfNeedCbCameraInfo(int r100, int r101, String r102, Object r103) {
        TELogUtils.d(TAG, "checkIfNeedCbCameraInfo type=" + r100 + ", msg=" + r102);
        this.mCameraEvents.onCameraInfo(r100, r101, r102, r103);
    }
}
