package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Identifier;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.RestrictedCameraControl;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.processing.TargetUtils;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.compose.material3.MenuKt;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraUseCaseAdapter implements Camera {
    private static final String TAG = "CameraUseCaseAdapter";
    private final RestrictedCameraControl mAdapterCameraControl;
    private final RestrictedCameraInfo mAdapterCameraInfo;
    private final RestrictedCameraInfo mAdapterSecondaryCameraInfo;
    private final List<UseCase> mAppUseCases;
    private boolean mAttached;
    private final CameraConfig mCameraConfig;
    private final CameraCoordinator mCameraCoordinator;
    private final CameraDeviceSurfaceManager mCameraDeviceSurfaceManager;
    private final CameraInternal mCameraInternal;
    private final List<UseCase> mCameraUseCases;
    private List<CameraEffect> mEffects;
    private final CameraId mId;
    private Config mInteropConfig;
    private final LayoutSettings mLayoutSettings;
    private final Object mLock;
    private UseCase mPlaceholderForExtensions;
    private final CameraInternal mSecondaryCameraInternal;
    private final LayoutSettings mSecondaryLayoutSettings;
    private StreamSharing mStreamSharing;
    private final UseCaseConfigFactory mUseCaseConfigFactory;
    private ViewPort mViewPort;

    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(String r1) {
            super(r1);
        }

        public CameraException(Throwable r1) {
            super(r1);
        }
    }

    public static abstract class CameraId {
        public CameraId() {
        }

        public abstract Identifier getCameraConfigId();

        public abstract String getCameraIdString();

        public static CameraId create(String r1, Identifier r2) {
            return new AutoValue_CameraUseCaseAdapter_CameraId(r1, r2);
        }
    }

    public static class ConfigPair {
        UseCaseConfig<?> mCameraConfig;
        UseCaseConfig<?> mExtendedConfig;

        public ConfigPair(UseCaseConfig<?> r1, UseCaseConfig<?> r2) {
            this.mExtendedConfig = r1;
            this.mCameraConfig = r2;
        }
    }

    public static /* synthetic */ void a(SurfaceRequest r0) {
        lambda$createExtraPreview$1(r0);
    }

    public static /* synthetic */ void b(Surface r0, SurfaceTexture r1, SurfaceRequest.Result r2) {
        lambda$createExtraPreview$0(r0, r1, r2);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... r1) {
        return Camera.CC.$default$isUseCasesCombinationSupported(this, r1);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupportedByFramework(UseCase... r1) {
        return Camera.CC.$default$isUseCasesCombinationSupportedByFramework(this, r1);
    }

    private void cacheInteropConfig() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CameraControlInternal r1 = this.mCameraInternal.getCameraControlInternal();     // Catch: Throwable -> L7
        this.mInteropConfig = r1.getInteropConfig();     // Catch: Throwable -> L7
        r1.clearInteropConfig();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ImageCapture createExtraImageCapture() {
        return new ImageCapture.Builder().setTargetName("ImageCapture-Extra").build();
    }

    private Preview createExtraPreview() {
        Preview r0 = new Preview.Builder().setTargetName("Preview-Extra").build();
        r0.setSurfaceProvider(new b());
        return r0;
    }

    private int getCameraMode() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mCameraCoordinator.getCameraOperatingMode() != 2) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return 1;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return 0;
    }

    private boolean hasExtension() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mCameraConfig.getSessionProcessor(null) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    private boolean isCoexistingPreviewImageCaptureRequired() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = true;
        if (this.mCameraConfig.getUseCaseCombinationRequiredRule() == 1) goto L8;
        r2 = false;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    private void restoreInteropConfig() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mInteropConfig == null) goto L7;
        this.mCameraInternal.getCameraControlInternal().addInteropConfig(this.mInteropConfig);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void attachUseCases() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.mAttached == false) goto L7;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L7:
        if (this.mCameraUseCases.isEmpty() == true) goto L11;
        this.mCameraInternal.setExtendedConfig(this.mCameraConfig);     // Catch: Throwable -> L21
        CameraInternal r1 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L21
        if (r1 == null) goto L11;
        r1.setExtendedConfig(this.mCameraConfig);     // Catch: Throwable -> L21
    L11:
        this.mCameraInternal.attachUseCases(this.mCameraUseCases);     // Catch: Throwable -> L21
        CameraInternal r2 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L21
        if (r2 == null) goto L14;
        r2.attachUseCases(this.mCameraUseCases);     // Catch: Throwable -> L21
    L14:
        restoreInteropConfig();     // Catch: Throwable -> L21
        Iterator<UseCase> r3 = this.mCameraUseCases.iterator();     // Catch: Throwable -> L21
    L16:
        if (r3.hasNext() == false) goto L18;
        r3.next().notifyState();     // Catch: Throwable -> L21
        goto L16
    L18:
        this.mAttached = true;     // Catch: Throwable -> L21
        goto L19
    }

    public void detachUseCases() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mAttached == false) goto L10;
        this.mCameraInternal.detachUseCases(new ArrayList(this.mCameraUseCases));     // Catch: Throwable -> L12
        CameraInternal r1 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r1.detachUseCases(new ArrayList(this.mCameraUseCases));     // Catch: Throwable -> L12
    L9:
        cacheInteropConfig();     // Catch: Throwable -> L12
        this.mAttached = false;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public Collection<UseCase> getCameraUseCases() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mCameraUseCases);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.Camera
    public CameraConfig getExtendedConfig() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CameraConfig r1 = this.mCameraConfig;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<UseCase> getUseCases() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mAppUseCases);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.Camera
    public CameraControl getCameraControl() {
        return this.mAdapterCameraControl;
    }

    public CameraId getCameraId() {
        return this.mId;
    }

    @Override // androidx.camera.core.Camera
    public CameraInfo getCameraInfo() {
        return this.mAdapterCameraInfo;
    }

    public CameraInfo getSecondaryCameraInfo() {
        return this.mAdapterSecondaryCameraInfo;
    }

    private void checkUnsupportedFeatureCombinationAndThrow(Collection<UseCase> r3) throws IllegalArgumentException {
        if (hasExtension() == true) goto L5;
    L13:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L16:
        if (this.mEffects.isEmpty() == false) goto L18;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L18:
        if (hasUltraHdrImageCapture(r3) == false) goto L22;
        throw new IllegalArgumentException("Ultra HDR image capture does not support for use with CameraEffect.");     // Catch: Throwable -> L24
    L5:
        if (hasNonSdrConfig(r3) == true) goto L12;
        if (hasUltraHdrImageCapture(r3) == false) goto L13;
        throw new IllegalArgumentException("Extensions are not supported for use with Ultra HDR image capture.");
    L12:
        throw new IllegalArgumentException("Extensions are only supported for use with standard dynamic range.");
    }

    private int getSharingTargets(boolean r8) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<CameraEffect> r1 = this.mEffects.iterator();     // Catch: Throwable -> L19
        CameraEffect r2 = null;
    L5:
        int r4 = 0;
        boolean r5 = false;
        if (r1.hasNext() == false) goto L12;
        CameraEffect r3 = r1.next();     // Catch: Throwable -> L19
        if (TargetUtils.getNumberOfTargets(r3.getTargets()) <= 1) goto L5;
        if (r2 != null) goto L11;
        r5 = true;
    L11:
        Preconditions.checkState(r5, "Can only have one sharing effect.");     // Catch: Throwable -> L19
        r2 = r3;
        goto L5
    L12:
        if (r2 == null) goto L15;
        r4 = r2.getTargets();     // Catch: Throwable -> L19
    L15:
        if (r8 == false) goto L17;
        r4 = r4 | 3;     // Catch: Throwable -> L19
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r4;
    L19:
        th = move-exception;
        throw th;
    }

    private static boolean hasNonSdrConfig(Collection<UseCase> r1) {
        Iterator<UseCase> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (isNotSdr(r2.next().getCurrentConfig().getDynamicRange()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private static boolean hasUltraHdrImageCapture(Collection<UseCase> r3) {
        Iterator<UseCase> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        UseCase r0 = r4.next();
        if (isImageCapture(r0) == false) goto L4;
        UseCaseConfig<?> r1 = r0.getCurrentConfig();
        Config.Option<?> r2 = ImageCaptureConfig.OPTION_OUTPUT_FORMAT;
        if (r1.containsOption(r2) == false) goto L4;
        if (((Integer) Preconditions.checkNotNull((Integer) r1.retrieveOption(r2))).intValue() != 1) goto L4;
        return true;
    L13:
        return false;
    }

    private static boolean hasVideoCapture(Collection<UseCase> r1) {
        Iterator<UseCase> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (isVideoCapture(r2.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private static boolean isExtraImageCaptureRequired(Collection<UseCase> r6) {
        Iterator<UseCase> r7 = r6.iterator();
        boolean r1 = false;
        boolean r2 = false;
    L4:
        if (r7.hasNext() == false) goto L14;
        UseCase r3 = r7.next();
        if (isPreview(r3) == true) goto L13;
        if (StreamSharing.isStreamSharing(r3) == true) goto L13;
        if (isImageCapture(r3) == false) goto L4;
        r2 = true;
    L13:
        r1 = true;
        goto L4
    L14:
        if (r1 == false) goto L27;
        if (r2 == true) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    }

    private static boolean isExtraPreviewRequired(Collection<UseCase> r6) {
        Iterator<UseCase> r7 = r6.iterator();
        boolean r1 = false;
        boolean r2 = false;
    L4:
        if (r7.hasNext() == false) goto L14;
        UseCase r3 = r7.next();
        if (isPreview(r3) == true) goto L13;
        if (StreamSharing.isStreamSharing(r3) == true) goto L13;
        if (isImageCapture(r3) == false) goto L4;
        r1 = true;
    L13:
        r2 = true;
        goto L4
    L14:
        if (r1 == false) goto L27;
        if (r2 == true) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    }

    private static boolean isImageCapture(UseCase r0) {
        return r0 instanceof ImageCapture;
    }

    private static boolean isNotSdr(DynamicRange r4) {
        if (r4.getBitDepth() != 10) goto L5;
        boolean r0 = true;
    L7:
        if (r4.getEncoding() != 1) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r0 == true) goto L14;
        if (r5 == true) goto L14;
        return false;
    L14:
        return true;
    L9:
        if (r4.getEncoding() == 0) goto L11;
        r5 = true;
        goto L12
    L5:
        r0 = false;
        goto L7
    }

    private static boolean isPreview(UseCase r0) {
        return r0 instanceof Preview;
    }

    public static boolean isStreamSharingChildrenCombinationValid(Collection<UseCase> r8) {
        int[] r1 = {1, 2, 4};
        HashSet r2 = new HashSet();
        Iterator<UseCase> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L14;
        UseCase r3 = r9.next();
        int r5 = 0;
    L6:
        if (r5 >= 3) goto L4;
        int r6 = r1[r5];
        if (r3.isEffectTargetsSupported(r6) == true) goto L10;
    L13:
        r5 = r5 + 1;
        goto L6
    L10:
        if (r2.contains(Integer.valueOf(r6)) == true) goto L11;
        r2.add(Integer.valueOf(r6));
        goto L13
    L11:
        return false;
    L14:
        return true;
    }

    private static boolean isVideoCapture(UseCase r3) {
        if (r3 != null) goto L5;
    L11:
        return false;
    L5:
        if (r3.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE) == true) goto L7;
        r3.toString();
        goto L11
    L7:
        if (r3.getCurrentConfig().getCaptureType() != UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE) goto L12;
        return true;
    L12:
        return false;
    }

    private static /* synthetic */ void lambda$createExtraPreview$1(SurfaceRequest r4) {
        final SurfaceTexture r0 = new SurfaceTexture(0);
        r0.setDefaultBufferSize(r4.getResolution().getWidth(), r4.getResolution().getHeight());
        r0.detachFromGLContext();
        final Surface r1 = new Surface(r0);
        r4.provideSurface(r1, CameraXExecutors.directExecutor(), new a(r1, r0));
    }

    public void addUseCases(Collection<UseCase> r6) throws CameraException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCameraInternal.setExtendedConfig(this.mCameraConfig);     // Catch: Throwable -> L21
        CameraInternal r1 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L21
        if (r1 == null) goto L7;
        r1.setExtendedConfig(this.mCameraConfig);     // Catch: Throwable -> L21
    L7:
        LinkedHashSet r2 = new LinkedHashSet(this.mAppUseCases);     // Catch: Throwable -> L21
        r2.addAll(r6);     // Catch: Throwable -> L21
        CameraInternal r7 = this.mSecondaryCameraInternal;     // Catch: IllegalArgumentException -> L18 Throwable -> L21
        boolean r3 = true;
        if (r7 == null) goto L11;
        boolean r4 = true;
    L12:
        if (r7 != null) goto L15;
        r3 = false;
    L15:
        updateUseCases(r2, r4, r3);     // Catch: IllegalArgumentException -> L18 Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L11:
        r4 = false;
    L18:
        e = move-exception;
        throw new CameraException(e);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public boolean isEquivalent(CameraUseCaseAdapter r2) {
        return getCameraId().equals(r2.getCameraId());
    }

    public void removeUseCases(Collection<UseCase> r6) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LinkedHashSet r1 = new LinkedHashSet(this.mAppUseCases);     // Catch: Throwable -> L14
        r1.removeAll(r6);     // Catch: Throwable -> L14
        CameraInternal r7 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L14
        boolean r2 = true;
        if (r7 == null) goto L7;
        boolean r4 = true;
    L8:
        if (r7 != null) goto L11;
        r2 = false;
    L11:
        updateUseCases(r1, r4, r2);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        r4 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public void setActiveResumingMode(boolean r2) {
        this.mCameraInternal.setActiveResumingMode(r2);
    }

    public void setEffects(List<CameraEffect> r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mEffects = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setViewPort(ViewPort r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mViewPort = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void updateUseCases(Collection<UseCase> r2) {
        updateUseCases(r2, false, false);
    }

    private UseCase calculatePlaceholderForExtensions(Collection<UseCase> r3, StreamSharing r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(r3);     // Catch: Throwable -> L24
        if (r4 == null) goto L8;
        r1.add(r4);     // Catch: Throwable -> L24
        r1.removeAll(r4.getChildren());     // Catch: Throwable -> L24
    L8:
        if (isCoexistingPreviewImageCaptureRequired() == true) goto L10;
    L21:
        UseCase r5 = null;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L24
        return r5;
    L10:
        if (isExtraPreviewRequired(r1) == false) goto L16;
        if (isPreview(this.mPlaceholderForExtensions) == false) goto L14;
        r5 = this.mPlaceholderForExtensions;     // Catch: Throwable -> L24
        goto L22
    L14:
        r5 = createExtraPreview();     // Catch: Throwable -> L24
        goto L22
    L16:
        if (isExtraImageCaptureRequired(r1) == false) goto L21;
        if (isImageCapture(this.mPlaceholderForExtensions) == false) goto L20;
        r5 = this.mPlaceholderForExtensions;     // Catch: Throwable -> L24
        goto L22
    L20:
        r5 = createExtraImageCapture();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private static Matrix calculateSensorToBufferTransformMatrix(Rect r4, Size r5) {
        if (r4.width() > 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF r1 = new RectF(r4);
        Matrix r6 = new Matrix();
        r6.setRectToRect(new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r5.getWidth(), r5.getHeight()), r1, Matrix.ScaleToFit.CENTER);
        r6.invert(r6);
        return r6;
    L5:
        if (r4.height() <= 0) goto L7;
        r0 = true;
        goto L8
    }

    private StreamSharing createOrReuseStreamSharing(Collection<UseCase> r9, boolean r10) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Set<UseCase> r6 = getStreamSharingChildren(r9, r10);     // Catch: Throwable -> L26
        if (r6.size() < 2) goto L7;
    L12:
        StreamSharing r11 = this.mStreamSharing;     // Catch: Throwable -> L26
        if (r11 == null) goto L20;
        if (r11.getChildren().equals(r6) == false) goto L20;
        StreamSharing r12 = this.mStreamSharing;     // Catch: Throwable -> L26
        Objects.requireNonNull(r12);     // Catch: Throwable -> L26
        StreamSharing r13 = r12;     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return r12;
    L20:
        if (isStreamSharingChildrenCombinationValid(r6) == true) goto L23;
        monitor-exit(r0);     // Catch: Throwable -> L26
        return null;
    L23:
        StreamSharing r14 = new StreamSharing(this.mCameraInternal, this.mSecondaryCameraInternal, this.mLayoutSettings, this.mSecondaryLayoutSettings, r6, this.mUseCaseConfigFactory);     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return r14;
    L7:
        if (hasExtension() == true) goto L9;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L26
        return null;
    L9:
        if (hasVideoCapture(r6) == true) goto L12;
    L26:
        th = move-exception;
        throw th;
    }

    public static CameraId generateCameraId(RestrictedCameraInfo r2, RestrictedCameraInfo r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.getCameraId());
        if (r3 != null) goto L5;
        String r4 = "";
    L6:
        r0.append(r4);
        return CameraId.create(r0.toString(), r2.getCameraConfig().getCompatibilityId());
    L5:
        r4 = r3.getCameraId();
        goto L6
    }

    private static UseCaseConfig<?> generateExtendedStreamSharingConfigFromPreview(UseCaseConfigFactory r2, StreamSharing r3) {
        UseCaseConfig<?> r4 = new Preview.Builder().build().getDefaultConfig(false, r2);
        if (r4 != null) goto L6;
        return null;
    L6:
        MutableOptionsBundle r5 = MutableOptionsBundle.from(r4);
        r5.removeOption(TargetConfig.OPTION_TARGET_CLASS);
        return r3.getUseCaseConfigBuilder(r5).getUseCaseConfig();
    }

    private Set<UseCase> getStreamSharingChildren(Collection<UseCase> r5, boolean r6) {
        HashSet r0 = new HashSet();
        int r7 = getSharingTargets(r6);
        Iterator<UseCase> r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        UseCase r1 = r8.next();
        Preconditions.checkArgument(!StreamSharing.isStreamSharing(r1), "Only support one level of sharing for now.");
        if (r1.isEffectTargetsSupported(r7) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    private static boolean hasImplementationOptionChanged(StreamSpec r4, SessionConfig r5) {
        Config r6 = r4.getImplementationOptions();
        Config r0 = r5.getImplementationOptions();
        if (r6.listOptions().size() == r5.getImplementationOptions().listOptions().size()) goto L5;
        return true;
    L5:
        Iterator<Config.Option<?>> r7 = r6.listOptions().iterator();
    L7:
        if (r7.hasNext() == false) goto L13;
        Config.Option<?> r1 = r7.next();
        if (r0.containsOption(r1) == false) goto L12;
        if (Objects.equals(r0.retrieveOption(r1), r6.retrieveOption(r1)) == true) goto L7;
    L12:
        return true;
    L13:
        return false;
    }

    private static List<CameraEffect> setEffectsOnUseCases(List<CameraEffect> r7, Collection<UseCase> r8) {
        ArrayList r0 = new ArrayList(r7);
        Iterator<UseCase> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L15;
        UseCase r1 = r9.next();
        r1.setEffect(null);
        Iterator<CameraEffect> r2 = r7.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        CameraEffect r3 = r2.next();
        if (r1.isEffectTargetsSupported(r3.getTargets()) == false) goto L7;
        if (r1.getEffect() != null) goto L13;
        boolean r4 = true;
    L14:
        Preconditions.checkState(r4, r1 + " already has effect" + r1.getEffect());
        r1.setEffect(r3);
        r0.remove(r3);
        goto L7
    L13:
        r4 = false;
        goto L14
    L15:
        return r0;
    }

    private void updateViewPortAndSensorToBufferMatrix(Map<UseCase, StreamSpec> r11, Collection<UseCase> r12) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.mViewPort != null) goto L7;
    L20:
        Iterator<UseCase> r13 = r12.iterator();     // Catch: Throwable -> L26
    L22:
        if (r13.hasNext() == false) goto L24;
        UseCase r1 = r13.next();     // Catch: Throwable -> L26
        r1.setSensorToBufferTransformMatrix(calculateSensorToBufferTransformMatrix(this.mCameraInternal.getCameraControlInternal().getSensorRect(), ((StreamSpec) Preconditions.checkNotNull(r11.get(r1))).getResolution()));     // Catch: Throwable -> L26
        goto L22
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L26
        return;
    L7:
        if (r12.isEmpty() == true) goto L20;
        Integer r2 = Integer.valueOf(this.mCameraInternal.getCameraInfoInternal().getLensFacing());     // Catch: Throwable -> L26
        boolean r3 = true;
        if (r2 != null) goto L12;
        Logger.w(TAG, "The lens facing is null, probably an external.");     // Catch: Throwable -> L26
        boolean r4 = true;
    L16:
        Map<UseCase, Rect> r5 = ViewPorts.calculateViewPortRects(this.mCameraInternal.getCameraControlInternal().getSensorRect(), r4, this.mViewPort.getAspectRatio(), this.mCameraInternal.getCameraInfoInternal().getSensorRotationDegrees(this.mViewPort.getRotation()), this.mViewPort.getScaleType(), this.mViewPort.getLayoutDirection(), r11);     // Catch: Throwable -> L26
        Iterator<UseCase> r6 = r12.iterator();     // Catch: Throwable -> L26
    L18:
        if (r6.hasNext() == false) goto L20;
        UseCase r7 = r6.next();     // Catch: Throwable -> L26
        r7.setViewPortCropRect((Rect) Preconditions.checkNotNull(r5.get(r7)));     // Catch: Throwable -> L26
        goto L18
    L12:
        if (r2.intValue() == 0) goto L15;
        r3 = false;
    L15:
        r4 = r3;
        goto L16
    }

    @Override // androidx.camera.core.Camera
    public boolean isUseCasesCombinationSupported(boolean r8, UseCase... r9) {
        Collection<UseCase> r10 = Arrays.asList(r9);
        if (r8 == false) goto L5;
        r10 = calculateCameraUseCases(r10, null, createOrReuseStreamSharing(r10, true));
    L5:
        Collection<UseCase> r4 = r10;
        Object r11 = this.mLock;
        monitor-enter(r11);
        Map<UseCase, ConfigPair> r6 = getConfigs(r4, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);     // Catch: Throwable -> L10 IllegalArgumentException -> L12
        calculateSuggestedStreamSpecs(getCameraMode(), this.mCameraInternal.getCameraInfoInternal(), r4, Collections.emptyList(), r6);     // Catch: Throwable -> L10 IllegalArgumentException -> L12
        monitor-exit(r11);     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        throw th;
    L13:
        return false;
    }

    public static Collection<UseCase> calculateCameraUseCases(Collection<UseCase> r1, UseCase r2, StreamSharing r3) {
        ArrayList r0 = new ArrayList(r1);
        if (r2 == null) goto L5;
        r0.add(r2);
    L5:
        if (r3 == null) goto L7;
        r0.add(r3);
        r0.removeAll(r3.getChildren());
    L7:
        return r0;
    }

    private static Map<UseCase, ConfigPair> getConfigs(Collection<UseCase> r5, UseCaseConfigFactory r6, UseCaseConfigFactory r7) {
        HashMap r0 = new HashMap();
        Iterator<UseCase> r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        UseCase r1 = r8.next();
        if (StreamSharing.isStreamSharing(r1) == false) goto L8;
        UseCaseConfig<?> r2 = generateExtendedStreamSharingConfigFromPreview(r6, (StreamSharing) r1);
    L9:
        r0.put(r1, new ConfigPair(r2, r1.getDefaultConfig(true, r7)));
        goto L4
    L8:
        r2 = r1.getDefaultConfig(false, r6);
        goto L9
    L10:
        return r0;
    }

    private static /* synthetic */ void lambda$createExtraPreview$0(Surface r0, SurfaceTexture r1, SurfaceRequest.Result r2) {
        r0.release();
        r1.release();
    }

    public static void updateEffects(List<CameraEffect> r1, Collection<UseCase> r2, Collection<UseCase> r3) {
        List<CameraEffect> r4 = setEffectsOnUseCases(r1, r2);
        ArrayList r0 = new ArrayList(r3);
        r0.removeAll(r2);
        List<CameraEffect> r5 = setEffectsOnUseCases(r4, r0);
        if (r5.size() <= 0) goto L6;
        Logger.w(TAG, "Unused effects: " + r5);
        return;
    }

    public void updateUseCases(Collection<UseCase> r20, boolean r21, boolean r22) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        checkUnsupportedFeatureCombinationAndThrow(r20);     // Catch: Throwable -> L77
        if (r21 == false) goto L7;
    L13:
        StreamSharing r0 = createOrReuseStreamSharing(r20, r21);     // Catch: Throwable -> L77
        UseCase r12 = calculatePlaceholderForExtensions(r20, r0);     // Catch: Throwable -> L77
        Collection<UseCase> r13 = calculateCameraUseCases(r20, r12, r0);     // Catch: Throwable -> L77
        ArrayList r14 = new ArrayList(r13);     // Catch: Throwable -> L77
        r14.removeAll(this.mCameraUseCases);     // Catch: Throwable -> L77
        ArrayList r15 = new ArrayList(r13);     // Catch: Throwable -> L77
        r15.retainAll(this.mCameraUseCases);     // Catch: Throwable -> L77
        ArrayList r6 = new ArrayList(this.mCameraUseCases);     // Catch: Throwable -> L77
        r6.removeAll(r13);     // Catch: Throwable -> L77
        Map<UseCase, ConfigPair> r5 = getConfigs(r14, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);     // Catch: Throwable -> L77
        Map<UseCase, StreamSpec> r16 = Collections.emptyMap();     // Catch: Throwable -> L77
        Map<UseCase, ConfigPair> r17 = r5;
        Map<UseCase, StreamSpec> r7 = calculateSuggestedStreamSpecs(getCameraMode(), this.mCameraInternal.getCameraInfoInternal(), r14, r15, r17);     // Catch: IllegalArgumentException -> L67 Throwable -> L77
        if (this.mSecondaryCameraInternal == null) goto L19;
        int r2 = getCameraMode();     // Catch: IllegalArgumentException -> L67 Throwable -> L77
        CameraInternal r1 = this.mSecondaryCameraInternal;     // Catch: IllegalArgumentException -> L67 Throwable -> L77
        Objects.requireNonNull(r1);     // Catch: IllegalArgumentException -> L67 Throwable -> L77
        r16 = calculateSuggestedStreamSpecs(r2, r1.getCameraInfoInternal(), r14, r15, r17);     // Catch: IllegalArgumentException -> L67 Throwable -> L77
    L19:
        Map<UseCase, StreamSpec> r3 = r16;
        updateViewPortAndSensorToBufferMatrix(r7, r13);     // Catch: Throwable -> L77
        updateEffects(this.mEffects, r13, r20);     // Catch: Throwable -> L77
        Iterator r4 = r6.iterator();     // Catch: Throwable -> L77
    L22:
        if (r4.hasNext() == false) goto L24;
        ((UseCase) r4.next()).unbindFromCamera(this.mCameraInternal);     // Catch: Throwable -> L77
        goto L22
    L24:
        this.mCameraInternal.detachUseCases(r6);     // Catch: Throwable -> L77
        if (this.mSecondaryCameraInternal == null) goto L32;
        Iterator r8 = r6.iterator();     // Catch: Throwable -> L77
    L28:
        if (r8.hasNext() == false) goto L30;
        UseCase r9 = (UseCase) r8.next();     // Catch: Throwable -> L77
        CameraInternal r11 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L77
        Objects.requireNonNull(r11);     // Catch: Throwable -> L77
        r9.unbindFromCamera(r11);     // Catch: Throwable -> L77
        goto L28
    L30:
        CameraInternal r18 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L77
        Objects.requireNonNull(r18);     // Catch: Throwable -> L77
        r18.detachUseCases(r6);     // Catch: Throwable -> L77
    L32:
        if (r6.isEmpty() == false) goto L47;
        Iterator r19 = r15.iterator();     // Catch: Throwable -> L77
    L35:
        if (r19.hasNext() == false) goto L47;
        UseCase r23 = (UseCase) r19.next();     // Catch: Throwable -> L77
        if (r7.containsKey(r23) == false) goto L35;
        StreamSpec r24 = r7.get(r23);     // Catch: Throwable -> L77
        Config r25 = r24.getImplementationOptions();     // Catch: Throwable -> L77
        if (r25 == null) goto L35;
        if (hasImplementationOptionChanged(r24, r23.getSessionConfig()) == false) goto L35;
        r23.updateSuggestedStreamSpecImplementationOptions(r25);     // Catch: Throwable -> L77
        if (this.mAttached == false) goto L35;
        this.mCameraInternal.onUseCaseUpdated(r23);     // Catch: Throwable -> L77
        CameraInternal r26 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L77
        if (r26 == null) goto L35;
        Objects.requireNonNull(r26);     // Catch: Throwable -> L77
        r26.onUseCaseUpdated(r23);     // Catch: Throwable -> L77
    L47:
        Iterator r27 = r14.iterator();     // Catch: Throwable -> L77
    L49:
        if (r27.hasNext() == false) goto L56;
        UseCase r28 = (UseCase) r27.next();     // Catch: Throwable -> L77
        Map<UseCase, ConfigPair> r29 = r17;
        ConfigPair r30 = r29.get(r28);     // Catch: Throwable -> L77
        Objects.requireNonNull(r30);     // Catch: Throwable -> L77
        ConfigPair r31 = r30;     // Catch: Throwable -> L77
        CameraInternal r32 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L77
        if (r32 == null) goto L53;
        CameraInternal r33 = this.mCameraInternal;     // Catch: Throwable -> L77
        Objects.requireNonNull(r32);     // Catch: Throwable -> L77
        r28.bindToCamera(r33, r32, r30.mExtendedConfig, r30.mCameraConfig);     // Catch: Throwable -> L77
        r28.updateSuggestedStreamSpec((StreamSpec) Preconditions.checkNotNull(r7.get(r28)), r3.get(r28));     // Catch: Throwable -> L77
    L54:
        r17 = r29;
        goto L49
    L53:
        r28.bindToCamera(this.mCameraInternal, null, r30.mExtendedConfig, r30.mCameraConfig);     // Catch: Throwable -> L77
        r28.updateSuggestedStreamSpec((StreamSpec) Preconditions.checkNotNull(r7.get(r28)), null);     // Catch: Throwable -> L77
        goto L54
    L56:
        if (this.mAttached == false) goto L60;
        this.mCameraInternal.attachUseCases(r14);     // Catch: Throwable -> L77
        CameraInternal r34 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L77
        if (r34 == null) goto L60;
        Objects.requireNonNull(r34);     // Catch: Throwable -> L77
        r34.attachUseCases(r14);     // Catch: Throwable -> L77
    L60:
        Iterator r35 = r14.iterator();     // Catch: Throwable -> L77
    L62:
        if (r35.hasNext() == false) goto L64;
        ((UseCase) r35.next()).notifyState();     // Catch: Throwable -> L77
        goto L62
    L64:
        this.mAppUseCases.clear();     // Catch: Throwable -> L77
        this.mAppUseCases.addAll(r20);     // Catch: Throwable -> L77
        this.mCameraUseCases.clear();     // Catch: Throwable -> L77
        this.mCameraUseCases.addAll(r13);     // Catch: Throwable -> L77
        this.mPlaceholderForExtensions = r12;     // Catch: Throwable -> L77
        this.mStreamSharing = r0;     // Catch: Throwable -> L77
        monitor-exit(r10);     // Catch: Throwable -> L77
        return;
    L67:
        e = move-exception;
        if (r21 == false) goto L70;
    L76:
        throw e;     // Catch: Throwable -> L77
    L70:
        if (hasExtension() == true) goto L76;
        if (this.mCameraCoordinator.getCameraOperatingMode() == 2) goto L76;
        updateUseCases(r20, true, r22);     // Catch: Throwable -> L77
        return;
    L7:
        if (hasExtension() == false) goto L13;
        if (hasVideoCapture(r20) == false) goto L13;
        updateUseCases(r20, true, r22);     // Catch: Throwable -> L77
        monitor-exit(r10);     // Catch: Throwable -> L77
        return;
    L77:
        th = move-exception;
        throw th;
    }

    public CameraUseCaseAdapter(CameraInternal r11, CameraCoordinator r12, CameraDeviceSurfaceManager r13, UseCaseConfigFactory r14) {
        RestrictedCameraInfo r3 = new RestrictedCameraInfo(r11.getCameraInfoInternal(), CameraConfigs.defaultConfig());
        LayoutSettings r6 = LayoutSettings.DEFAULT;
        this(r11, null, r3, null, r6, r6, r12, r13, r14);
    }

    private Map<UseCase, StreamSpec> calculateSuggestedStreamSpecs(int r21, CameraInfoInternal r22, Collection<UseCase> r23, Collection<UseCase> r24, Map<UseCase, ConfigPair> r25) {
        ArrayList r4 = new ArrayList();
        String r3 = r22.getCameraId();
        HashMap r8 = new HashMap();
        HashMap r9 = new HashMap();
        Iterator<UseCase> r2 = r24.iterator();
    L3:
        Size r6 = null;
        if (r2.hasNext() == false) goto L7;
        UseCase r5 = r2.next();
        AttachedSurfaceInfo r7 = AttachedSurfaceInfo.create(this.mCameraDeviceSurfaceManager.transformSurfaceConfig(r21, r3, r5.getImageFormat(), r5.getAttachedSurfaceResolution()), r5.getImageFormat(), r5.getAttachedSurfaceResolution(), ((StreamSpec) Preconditions.checkNotNull(r5.getAttachedStreamSpec())).getDynamicRange(), StreamSharing.getCaptureTypes(r5), r5.getAttachedStreamSpec().getImplementationOptions(), r5.getCurrentConfig().getTargetFrameRate(null));
        r4.add(r7);
        r9.put(r7, r5);
        r8.put(r5, r5.getAttachedStreamSpec());
        goto L3
    L7:
        if (r23.isEmpty() == true) goto L34;
        HashMap r10 = new HashMap();
        HashMap r11 = new HashMap();
        Rect r12 = this.mCameraInternal.getCameraControlInternal().getSensorRect();     // Catch: NullPointerException -> L11
    L13:
        if (r12 == null) goto L15;
        r6 = TransformUtils.rectToSize(r12);
    L15:
        SupportedOutputSizesSorter r13 = new SupportedOutputSizesSorter(r22, r6);
        Iterator<UseCase> r14 = r23.iterator();
    L16:
        boolean r15 = false;
    L18:
        if (r14.hasNext() == false) goto L24;
        UseCase r16 = r14.next();
        ConfigPair r17 = r25.get(r16);
        UseCaseConfig<?> r18 = r16.mergeConfigs(r22, r17.mExtendedConfig, r17.mCameraConfig);
        r10.put(r18, r16);
        r11.put(r18, r13.getSortedSupportedOutputSizes(r18));
        if ((r16.getCurrentConfig() instanceof PreviewConfig) == false) goto L18;
        PreviewConfig r19 = (PreviewConfig) r16.getCurrentConfig();
        r19.getClass();
        if (UseCaseConfig.CC.$default$getPreviewStabilizationMode(r19) != 2) goto L16;
        r15 = true;
        goto L18
    L24:
        Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> r1 = this.mCameraDeviceSurfaceManager.getSuggestedStreamSpecs(r21, r3, r4, r11, r15, hasVideoCapture(r23));
        Iterator r20 = r10.entrySet().iterator();
    L26:
        if (r20.hasNext() == false) goto L28;
        Map.Entry r26 = (Map.Entry) r20.next();
        r8.put((UseCase) r26.getValue(), (StreamSpec) ((Map) r1.first).get(r26.getKey()));
        goto L26
    L28:
        Iterator r27 = ((Map) r1.second).entrySet().iterator();
    L30:
        if (r27.hasNext() == false) goto L34;
        Map.Entry r28 = (Map.Entry) r27.next();
        if (r9.containsKey(r28.getKey()) == false) goto L30;
        r8.put((UseCase) r9.get(r28.getKey()), (StreamSpec) r28.getValue());
    L11:
        r12 = null;
    L34:
        return r8;
    }

    public CameraUseCaseAdapter(CameraInternal r2, CameraInternal r3, RestrictedCameraInfo r4, RestrictedCameraInfo r5, LayoutSettings r6, LayoutSettings r7, CameraCoordinator r8, CameraDeviceSurfaceManager r9, UseCaseConfigFactory r10) {
        this.mAppUseCases = new ArrayList();
        this.mCameraUseCases = new ArrayList();
        this.mEffects = Collections.emptyList();
        this.mLock = new Object();
        this.mAttached = true;
        this.mInteropConfig = null;
        this.mCameraInternal = r2;
        this.mSecondaryCameraInternal = r3;
        this.mLayoutSettings = r6;
        this.mSecondaryLayoutSettings = r7;
        this.mCameraCoordinator = r8;
        this.mCameraDeviceSurfaceManager = r9;
        this.mUseCaseConfigFactory = r10;
        CameraConfig r11 = r4.getCameraConfig();
        this.mCameraConfig = r11;
        SessionProcessor r12 = r11.getSessionProcessor(null);
        this.mAdapterCameraControl = new RestrictedCameraControl(r2.getCameraControlInternal(), r12);
        this.mAdapterCameraInfo = r4;
        this.mAdapterSecondaryCameraInfo = r5;
        this.mId = generateCameraId(r4, r5);
    }
}
