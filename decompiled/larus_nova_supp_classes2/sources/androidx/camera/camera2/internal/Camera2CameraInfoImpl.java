package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.camera2.internal.compat.quirk.CameraQuirks;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import androidx.camera.camera2.internal.compat.workaround.FlashAvailabilityChecker;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraState;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExposureState;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.Logger;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.DynamicRanges;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Camera2CameraInfoImpl implements CameraInfoInternal {
    private static final String TAG = "Camera2CameraInfo";
    private Camera2CameraControlImpl mCamera2CameraControlImpl;
    private final Camera2CameraInfo mCamera2CameraInfo;
    private final EncoderProfilesProvider mCamera2EncoderProfilesProvider;
    private List<Pair<CameraCaptureCallback, Executor>> mCameraCaptureCallbacks;
    private final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    private final String mCameraId;
    private final CameraManagerCompat mCameraManager;
    private final Quirks mCameraQuirks;
    private final RedirectableLiveData<CameraState> mCameraStateLiveData;
    private final Object mLock;
    private Set<CameraInfo> mPhysicalCameraInfos;
    private RedirectableLiveData<Integer> mRedirectTorchStateLiveData;
    private RedirectableLiveData<ZoomState> mRedirectZoomStateLiveData;

    public static class RedirectableLiveData<T> extends MediatorLiveData<T> {
        private final T mInitialValue;
        private LiveData<T> mLiveDataSource;

        public T getValue() {
            LiveData<T> r0 = this.mLiveDataSource;
            if (r0 != null) goto L6;
            return this.mInitialValue;
        L6:
            return (T) r0.getValue();
        }

        public RedirectableLiveData(T r1) {
            this.mInitialValue = r1;
        }

        public void redirectTo(LiveData<T> r2) {
            LiveData<T> r0 = this.mLiveDataSource;
            if (r0 == null) goto L5;
            super.removeSource(r0);
        L5:
            this.mLiveDataSource = r2;
            super.addSource(r2, new q0(this));
        }

        public <S> void addSource(LiveData<S> r1, Observer<? super S> r2) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.CameraInfo
    public final /* synthetic */ CameraSelector getCameraSelector() {
        return CameraInfoInternal.CC.$default$getCameraSelector(this);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final /* synthetic */ CameraInfoInternal getImplementation() {
        return CameraInfoInternal.CC.$default$getImplementation(this);
    }

    @Override // androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final /* synthetic */ boolean isCaptureProcessProgressSupported() {
        return CameraInfoInternal.CC.$default$isCaptureProcessProgressSupported(this);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final /* synthetic */ boolean isPostviewSupported() {
        return CameraInfoInternal.CC.$default$isPostviewSupported(this);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Object getCameraCharacteristics() {
        return this.mCameraCharacteristicsCompat.toCameraCharacteristics();
    }

    public Map<String, CameraCharacteristics> getCameraCharacteristicsMap() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(this.mCameraId, this.mCameraCharacteristicsCompat.toCameraCharacteristics());
        Iterator<String> r1 = this.mCameraCharacteristicsCompat.getPhysicalCameraIds().iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        if (Objects.equals(r2, this.mCameraId) == true) goto L4;
        r0.put(r2, this.mCameraManager.getCameraCharacteristicsCompat(r2).toCameraCharacteristics());     // Catch: CameraAccessExceptionCompat -> L10
    L10:
        e = move-exception;
        Logger.e(TAG, "Failed to get CameraCharacteristics for cameraId " + r2, e);
        goto L4
    L12:
        return r0;
    }

    @Override // androidx.camera.core.CameraInfo
    public ExposureState getExposureState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Camera2CameraControlImpl r1 = this.mCamera2CameraControlImpl;     // Catch: Throwable -> L12
        if (r1 != null) goto L9;
        ExposureState r2 = ExposureControl.getDefaultExposureState(this.mCameraCharacteristicsCompat);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L9:
        ExposureState r3 = r1.getExposureControl().getExposureState();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.CameraInfo
    public float getIntrinsicZoomRatio() {
        Integer r0 = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING);
        if (r0 != null) goto L11;
        return 1.0f;
    L11:
        return FovUtil.getDeviceDefaultViewAngleDegrees(this.mCameraManager, r0.intValue()) / FovUtil.focalLengthToViewAngleDegrees(FovUtil.getDefaultFocalLength(this.mCameraCharacteristicsCompat), FovUtil.getSensorHorizontalLength(this.mCameraCharacteristicsCompat));
    L8:
        e = move-exception;
        Logger.e(TAG, "The camera is unable to provide necessary information to resolve its intrinsic zoom ratio with error: " + e);
        return 1.0f;
    }

    @Override // androidx.camera.core.CameraInfo
    public int getLensFacing() {
        Integer r0 = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING);
        if (r0 == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "Unable to get the lens facing of the camera.");
        return LensFacingUtil.getCameraSelectorLensFacing(r0.intValue());
    L5:
        r1 = false;
        goto L6
    }

    @Override // androidx.camera.core.CameraInfo
    public Set<CameraInfo> getPhysicalCameraInfos() {
        if (this.mPhysicalCameraInfos != null) goto L14;
        this.mPhysicalCameraInfos = new HashSet();
        Iterator<String> r0 = this.mCameraCharacteristicsCompat.getPhysicalCameraIds().iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        String r1 = r0.next();
        this.mPhysicalCameraInfos.add(new Camera2PhysicalCameraInfoImpl(r1, this.mCameraManager));     // Catch: CameraAccessExceptionCompat -> L10
    L10:
        e = move-exception;
        Logger.e(TAG, "Failed to get CameraCharacteristics for cameraId " + r1, e);
        return Collections.emptySet();
    L14:
        return this.mPhysicalCameraInfos;
    }

    public int getSensorOrientation() {
        Integer r0 = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_ORIENTATION);
        Preconditions.checkNotNull(r0);
        return r0.intValue();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return DynamicRangesCompat.fromCameraCharacteristics(this.mCameraCharacteristicsCompat).getSupportedDynamicRanges();
    }

    @Override // androidx.camera.core.CameraInfo
    public Set<Range<Integer>> getSupportedFrameRateRanges() {
        Range[] r0 = (Range[]) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (r0 == null) goto L7;
        return new HashSet(Arrays.asList(r0));
    L7:
        return Collections.emptySet();
    }

    public int getSupportedHardwareLevel() {
        Integer r0 = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        Preconditions.checkNotNull(r0);
        return r0.intValue();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Set<Integer> getSupportedOutputFormats() {
        int[] r0 = this.mCameraCharacteristicsCompat.getStreamConfigurationMapCompat().getOutputFormats();
        if (r0 == null) goto L5;
        HashSet r1 = new HashSet();
        int r2 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        r1.add(Integer.valueOf(r0[r3]));
        r3 = r3 + 1;
        goto L7
    L9:
        return r1;
    L5:
        return new HashSet();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Timebase getTimebase() {
        Integer r0 = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_INFO_TIMESTAMP_SOURCE);
        Preconditions.checkNotNull(r0);
        if (r0.intValue() == 1) goto L7;
        return Timebase.UPTIME;
    L7:
        return Timebase.REALTIME;
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<Integer> getTorchState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Camera2CameraControlImpl r1 = this.mCamera2CameraControlImpl;     // Catch: Throwable -> L19
        if (r1 == null) goto L7;
        RedirectableLiveData<Integer> r2 = this.mRedirectTorchStateLiveData;     // Catch: Throwable -> L19
        if (r2 == null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r2;
    L16:
        LiveData<Integer> r3 = r1.getTorchControl().getTorchState();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r3;
    L7:
        if (this.mRedirectTorchStateLiveData != null) goto L9;
        this.mRedirectTorchStateLiveData = new RedirectableLiveData(0);     // Catch: Throwable -> L19
    L9:
        RedirectableLiveData<Integer> r4 = this.mRedirectTorchStateLiveData;     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r4;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<ZoomState> getZoomState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Camera2CameraControlImpl r1 = this.mCamera2CameraControlImpl;     // Catch: Throwable -> L19
        if (r1 == null) goto L7;
        RedirectableLiveData<ZoomState> r2 = this.mRedirectZoomStateLiveData;     // Catch: Throwable -> L19
        if (r2 == null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r2;
    L16:
        LiveData<ZoomState> r3 = r1.getZoomControl().getZoomState();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r3;
    L7:
        if (this.mRedirectZoomStateLiveData != null) goto L9;
        this.mRedirectZoomStateLiveData = new RedirectableLiveData(ZoomControl.getDefaultZoomState(this.mCameraCharacteristicsCompat));     // Catch: Throwable -> L19
    L9:
        RedirectableLiveData<ZoomState> r4 = this.mRedirectZoomStateLiveData;     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r4;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean hasFlashUnit() {
        CameraCharacteristicsCompat r0 = this.mCameraCharacteristicsCompat;
        Objects.requireNonNull(r0);
        return FlashAvailabilityChecker.isFlashAvailable(new p0(r0));
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isLogicalMultiCameraSupported() {
        return ZslUtil.isCapabilitySupported(this.mCameraCharacteristicsCompat, 11);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public boolean isPreviewStabilizationSupported() {
        int[] r0 = (int[]) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        if (r0 == null) goto L11;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        if (r0[r3] == 2) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isPrivateReprocessingSupported() {
        return ZslUtil.isCapabilitySupported(this.mCameraCharacteristicsCompat, 4);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public boolean isVideoStabilizationSupported() {
        int[] r0 = (int[]) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        if (r0 == null) goto L10;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L10;
        if (r0[r3] == 1) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        return true;
    L10:
        return false;
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isZslSupported() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L9:
        return false;
    L5:
        if (isPrivateReprocessingSupported() == false) goto L9;
        if (DeviceQuirks.get(ZslDisablerQuirk.class) != null) goto L9;
        return true;
    }

    private void logDeviceLevel() {
        int r0 = getSupportedHardwareLevel();
        if (r0 != 0) goto L5;
        String r1 = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
    L18:
        Logger.i(TAG, "Device Level: " + r1);
        return;
    L5:
        if (r0 != 1) goto L7;
        r1 = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
        goto L18
    L7:
        if (r0 != 2) goto L9;
        r1 = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
        goto L18
    L9:
        if (r0 != 3) goto L11;
        r1 = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
        goto L18
    L11:
        if (r0 == 4) goto L13;
        r1 = "Unknown value: " + r0;
        goto L18
    L13:
        r1 = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
        goto L18
    }

    @Override // androidx.camera.core.CameraInfo
    public String getImplementationType() {
        if (getSupportedHardwareLevel() != 2) goto L5;
        return CameraInfo.IMPLEMENTATION_TYPE_CAMERA2_LEGACY;
    L5:
        return CameraInfo.IMPLEMENTATION_TYPE_CAMERA2;
    }

    private void logDeviceInfo() {
        logDeviceLevel();
    }

    public Camera2CameraInfo getCamera2CameraInfo() {
        return this.mCamera2CameraInfo;
    }

    public CameraCharacteristicsCompat getCameraCharacteristicsCompat() {
        return this.mCameraCharacteristicsCompat;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public String getCameraId() {
        return this.mCameraId;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Quirks getCameraQuirks() {
        return this.mCameraQuirks;
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<CameraState> getCameraState() {
        return this.mCameraStateLiveData;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public EncoderProfilesProvider getEncoderProfilesProvider() {
        return this.mCamera2EncoderProfilesProvider;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Object getPhysicalCameraCharacteristics(String r5) {
    L8:
        e = move-exception;
        Logger.e(TAG, "Failed to get CameraCharacteristics for cameraId " + r5, e);
        return null;
    L4:
        if (this.mCameraCharacteristicsCompat.getPhysicalCameraIds().contains(r5) == true) goto L6;
        return null;
    L6:
        return this.mCameraManager.getCameraCharacteristicsCompat(r5).toCameraCharacteristics();
    }

    @Override // androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees(int r4) {
        int r0 = getSensorOrientation();
        int r5 = CameraOrientationUtil.surfaceRotationToDegrees(r4);
        boolean r2 = true;
        if (1 == getLensFacing()) goto L7;
        r2 = false;
    L7:
        return CameraOrientationUtil.getRelativeImageRotation(r5, r0, r2);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public List<Size> getSupportedHighResolutions(int r2) {
        Size[] r3 = this.mCameraCharacteristicsCompat.getStreamConfigurationMapCompat().getHighResolutionOutputSizes(r2);
        if (r3 == null) goto L6;
        return Arrays.asList(r3);
    L6:
        return Collections.emptyList();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public List<Size> getSupportedResolutions(int r2) {
        Size[] r3 = this.mCameraCharacteristicsCompat.getStreamConfigurationMapCompat().getOutputSizes(r2);
        if (r3 == null) goto L6;
        return Arrays.asList(r3);
    L6:
        return Collections.emptyList();
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isFocusMeteringSupported(FocusMeteringAction r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Camera2CameraControlImpl r1 = this.mCamera2CameraControlImpl;     // Catch: Throwable -> L12
        if (r1 != null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L9:
        boolean r4 = r1.getFocusMeteringControl().isFocusMeteringSupported(r3);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L12:
        th = move-exception;
        throw th;
    }

    public void linkWithCameraControl(Camera2CameraControlImpl r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCamera2CameraControlImpl = r5;     // Catch: Throwable -> L20
        RedirectableLiveData<ZoomState> r1 = this.mRedirectZoomStateLiveData;     // Catch: Throwable -> L20
        if (r1 == null) goto L7;
        r1.redirectTo(r5.getZoomControl().getZoomState());     // Catch: Throwable -> L20
    L7:
        RedirectableLiveData<Integer> r6 = this.mRedirectTorchStateLiveData;     // Catch: Throwable -> L20
        if (r6 == null) goto L10;
        r6.redirectTo(this.mCamera2CameraControlImpl.getTorchControl().getTorchState());     // Catch: Throwable -> L20
    L10:
        List<Pair<CameraCaptureCallback, Executor>> r7 = this.mCameraCaptureCallbacks;     // Catch: Throwable -> L20
        if (r7 == null) goto L17;
        Iterator<Pair<CameraCaptureCallback, Executor>> r8 = r7.iterator();     // Catch: Throwable -> L20
    L14:
        if (r8.hasNext() == false) goto L16;
        Pair<CameraCaptureCallback, Executor> r2 = r8.next();     // Catch: Throwable -> L20
        this.mCamera2CameraControlImpl.addSessionCameraCaptureCallback((Executor) r2.second, (CameraCaptureCallback) r2.first);     // Catch: Throwable -> L20
        goto L14
    L16:
        this.mCameraCaptureCallbacks = null;     // Catch: Throwable -> L20
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L20
        logDeviceInfo();
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.CameraInfo
    public Set<DynamicRange> querySupportedDynamicRanges(Set<DynamicRange> r2) {
        return DynamicRanges.findAllPossibleMatches(r2, getSupportedDynamicRanges());
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public void removeSessionCaptureCallback(CameraCaptureCallback r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Camera2CameraControlImpl r1 = this.mCamera2CameraControlImpl;     // Catch: Throwable -> L21
        if (r1 != null) goto L18;
        List<Pair<CameraCaptureCallback, Executor>> r2 = this.mCameraCaptureCallbacks;     // Catch: Throwable -> L21
        if (r2 != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L10:
        Iterator<Pair<CameraCaptureCallback, Executor>> r3 = r2.iterator();     // Catch: Throwable -> L21
    L12:
        if (r3.hasNext() == false) goto L16;
        if (r3.next().first != r4) goto L12;
        r3.remove();     // Catch: Throwable -> L21
        goto L12
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L18:
        r1.removeSessionCameraCaptureCallback(r4);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public void setCameraStateSource(LiveData<CameraState> r2) {
        this.mCameraStateLiveData.redirectTo(r2);
    }

    public Camera2CameraInfoImpl(String r2, CameraManagerCompat r3) throws CameraAccessExceptionCompat {
        this.mLock = new Object();
        this.mRedirectTorchStateLiveData = null;
        this.mRedirectZoomStateLiveData = null;
        this.mCameraCaptureCallbacks = null;
        String r0 = (String) Preconditions.checkNotNull(r2);
        this.mCameraId = r0;
        this.mCameraManager = r3;
        CameraCharacteristicsCompat r4 = r3.getCameraCharacteristicsCompat(r0);
        this.mCameraCharacteristicsCompat = r4;
        this.mCamera2CameraInfo = new Camera2CameraInfo(this);
        Quirks r5 = CameraQuirks.get(r2, r4);
        this.mCameraQuirks = r5;
        this.mCamera2EncoderProfilesProvider = new Camera2EncoderProfilesProvider(r2, r5);
        this.mCameraStateLiveData = new RedirectableLiveData(CameraState.create(CameraState.Type.CLOSED));
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public void addSessionCaptureCallback(Executor r4, CameraCaptureCallback r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Camera2CameraControlImpl r1 = this.mCamera2CameraControlImpl;     // Catch: Throwable -> L15
        if (r1 == null) goto L7;
        r1.addSessionCameraCaptureCallback(r4, r5);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L7:
        if (this.mCameraCaptureCallbacks != null) goto L9;
        this.mCameraCaptureCallbacks = new ArrayList();     // Catch: Throwable -> L15
    L9:
        this.mCameraCaptureCallbacks.add(new Pair(r5, r4));     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
