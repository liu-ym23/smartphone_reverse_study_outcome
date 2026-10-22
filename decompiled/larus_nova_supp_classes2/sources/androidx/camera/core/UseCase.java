package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.camera.core.processing.TargetUtils;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class UseCase {
    private SessionConfig mAttachedSecondarySessionConfig;
    private SessionConfig mAttachedSessionConfig;
    private StreamSpec mAttachedStreamSpec;
    private CameraInternal mCamera;
    private UseCaseConfig<?> mCameraConfig;
    private final Object mCameraLock;
    private UseCaseConfig<?> mCurrentConfig;
    private CameraEffect mEffect;
    private UseCaseConfig<?> mExtendedConfig;
    private String mPhysicalCameraId;
    private CameraInternal mSecondaryCamera;
    private Matrix mSensorToBufferTransformMatrix;
    private State mState;
    private final Set<StateChangeCallback> mStateChangeCallbacks;
    private UseCaseConfig<?> mUseCaseConfig;
    private Rect mViewPortCropRect;

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State ACTIVE = null;
        public static final State INACTIVE = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{ACTIVE, INACTIVE};
        }

        static {
            ACTIVE = new State("ACTIVE", 0);
            INACTIVE = new State("INACTIVE", 1);
            $VALUES = $values();
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface StateChangeCallback {
        void onUseCaseActive(UseCase r1);

        void onUseCaseInactive(UseCase r1);

        void onUseCaseReset(UseCase r1);

        void onUseCaseUpdated(UseCase r1);
    }

    public abstract UseCaseConfig<?> getDefaultConfig(boolean r1, UseCaseConfigFactory r2);

    public abstract UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config r1);

    public void onBind() {
    }

    public void onCameraControlReady() {
    }

    public void onStateAttached() {
    }

    public void onStateDetached() {
    }

    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec r1, StreamSpec r2) {
        return r1;
    }

    public void onUnbind() {
    }

    public int getAppTargetRotation() {
        return ((ImageOutputConfig) this.mCurrentConfig).getAppTargetRotation(-1);
    }

    public Size getAttachedSurfaceResolution() {
        StreamSpec r0 = this.mAttachedStreamSpec;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getResolution();
    }

    public CameraInternal getCamera() {
        Object r0 = this.mCameraLock;
        monitor-enter(r0);
        CameraInternal r1 = this.mCamera;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public CameraControlInternal getCameraControl() {
        Object r0 = this.mCameraLock;
        monitor-enter(r0);
        CameraInternal r1 = this.mCamera;     // Catch: Throwable -> L12
        if (r1 != null) goto L9;
        CameraControlInternal r2 = CameraControlInternal.DEFAULT_EMPTY_INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L9:
        CameraControlInternal r3 = r1.getCameraControlInternal();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    public int getImageFormat() {
        return this.mCurrentConfig.getInputFormat();
    }

    public int getMirrorModeInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getMirrorMode(-1);
    }

    public String getName() {
        String r0 = this.mCurrentConfig.getTargetName("<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(r0);
        return r0;
    }

    public CameraInternal getSecondaryCamera() {
        Object r0 = this.mCameraLock;
        monitor-enter(r0);
        CameraInternal r1 = this.mSecondaryCamera;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Range<Integer> getTargetFrameRateInternal() {
        return this.mCurrentConfig.getTargetFrameRate(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
    }

    public int getTargetRotationInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getTargetRotation(0);
    }

    public final void notifyActive() {
        this.mState = State.ACTIVE;
        notifyState();
    }

    public final void notifyInactive() {
        this.mState = State.INACTIVE;
        notifyState();
    }

    public final void notifyReset() {
        Iterator<StateChangeCallback> r0 = this.mStateChangeCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onUseCaseReset(this);
        goto L4
    }

    public final void notifyState() {
        int r0 = this.mState.ordinal();
        if (r0 != 0) goto L5;
        Iterator<StateChangeCallback> r1 = this.mStateChangeCallbacks.iterator();
    L13:
        if (r1.hasNext() == false) goto L19;
        r1.next().onUseCaseActive(this);
        goto L13
    L19:
        return;
    L5:
        if (r0 != 1) goto L15;
        Iterator<StateChangeCallback> r2 = this.mStateChangeCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L18;
        r2.next().onUseCaseInactive(this);
        goto L9
    L18:
        return;
    }

    public final void notifyUpdated() {
        Iterator<StateChangeCallback> r0 = this.mStateChangeCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onUseCaseUpdated(this);
        goto L4
    }

    public String getCameraId() {
        return ((CameraInternal) Preconditions.checkNotNull(getCamera(), "No camera attached to use case: " + this)).getCameraInfoInternal().getCameraId();
    }

    public ResolutionInfo getResolutionInfoInternal() {
        CameraInternal r0 = getCamera();
        Size r1 = getAttachedSurfaceResolution();
        if (r0 == null) goto L11;
        if (r1 == null) goto L13;
        Rect r2 = getViewPortCropRect();
        if (r2 != null) goto L10;
        r2 = new Rect(0, 0, r1.getWidth(), r1.getHeight());
    L10:
        return new ResolutionInfo(r1, r2, getRelativeRotation(r0));
    L13:
        return null;
    L11:
        return null;
    }

    public String getSecondaryCameraId() {
        if (getSecondaryCamera() != null) goto L6;
        return null;
    L6:
        return getSecondaryCamera().getCameraInfoInternal().getCameraId();
    }

    public Set<Integer> getSupportedEffectTargets() {
        return Collections.emptySet();
    }

    public UseCaseConfig<?> getAppConfig() {
        return this.mUseCaseConfig;
    }

    public StreamSpec getAttachedStreamSpec() {
        return this.mAttachedStreamSpec;
    }

    public UseCaseConfig<?> getCurrentConfig() {
        return this.mCurrentConfig;
    }

    public CameraEffect getEffect() {
        return this.mEffect;
    }

    public String getPhysicalCameraId() {
        return this.mPhysicalCameraId;
    }

    public SessionConfig getSecondarySessionConfig() {
        return this.mAttachedSecondarySessionConfig;
    }

    public Matrix getSensorToBufferTransformMatrix() {
        return this.mSensorToBufferTransformMatrix;
    }

    public SessionConfig getSessionConfig() {
        return this.mAttachedSessionConfig;
    }

    public Rect getViewPortCropRect() {
        return this.mViewPortCropRect;
    }

    public UseCase(UseCaseConfig<?> r2) {
        this.mStateChangeCallbacks = new HashSet();
        this.mCameraLock = new Object();
        this.mState = State.INACTIVE;
        this.mSensorToBufferTransformMatrix = new Matrix();
        this.mAttachedSessionConfig = SessionConfig.defaultEmptySessionConfig();
        this.mAttachedSecondarySessionConfig = SessionConfig.defaultEmptySessionConfig();
        this.mUseCaseConfig = r2;
        this.mCurrentConfig = r2;
    }

    private void addStateChangeCallback(StateChangeCallback r2) {
        this.mStateChangeCallbacks.add(r2);
    }

    private void removeStateChangeCallback(StateChangeCallback r2) {
        this.mStateChangeCallbacks.remove(r2);
    }

    public static int snapToSurfaceRotation(int r3) {
        Preconditions.checkArgumentInRange(r3, 0, 359, "orientation");
        if (r3 < 315) goto L5;
    L17:
        return 0;
    L5:
        if (r3 < 45) goto L17;
        if (r3 < 225) goto L12;
        return 1;
    L12:
        if (r3 < 135) goto L15;
        return 2;
    L15:
        return 3;
    }

    public int getRelativeRotation(CameraInternal r2) {
        return getRelativeRotation(r2, false);
    }

    public boolean isCurrentCamera(String r2) {
        if (getCamera() != null) goto L7;
        return false;
    L7:
        return Objects.equals(r2, getCameraId());
    }

    public boolean isEffectTargetsSupported(int r3) {
        Iterator<Integer> r0 = getSupportedEffectTargets().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (TargetUtils.isSuperset(r3, r0.next().intValue()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public boolean isMirroringRequired(CameraInternal r4) {
        int r0 = getMirrorModeInternal();
        if (r0 == (-1)) goto L14;
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r0 != 1) goto L8;
        return true;
    L8:
        if (r0 != 2) goto L12;
        return r4.isFrontFacing();
    L12:
        throw new AssertionError("Unknown mirrorMode: " + r0);
    L14:
        return false;
    }

    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config r2) {
        StreamSpec r0 = this.mAttachedStreamSpec;
        if (r0 == null) goto L7;
        return r0.toBuilder().setImplementationOptions(r2).build();
    L7:
        throw new UnsupportedOperationException("Attempt to update the implementation options for a use case without attached stream specifications.");
    }

    public void setEffect(CameraEffect r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        Preconditions.checkArgument(r0);
        this.mEffect = r2;
        return;
    L4:
        if (isEffectTargetsSupported(r2.getTargets()) == true) goto L7;
        r0 = false;
        goto L8
    }

    public void setPhysicalCameraId(String r1) {
        this.mPhysicalCameraId = r1;
    }

    public void setSensorToBufferTransformMatrix(Matrix r2) {
        this.mSensorToBufferTransformMatrix = new Matrix(r2);
    }

    public boolean setTargetRotationInternal(int r3) {
        int r0 = ((ImageOutputConfig) getCurrentConfig()).getTargetRotation(-1);
        if (r0 == (-1)) goto L8;
        if (r0 != r3) goto L8;
        return false;
    L8:
        UseCaseConfig.Builder<?, ?, ?> r1 = getUseCaseConfigBuilder(this.mUseCaseConfig);
        UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(r1, r3);
        this.mUseCaseConfig = r1.getUseCaseConfig();
        CameraInternal r4 = getCamera();
        if (r4 != null) goto L11;
        this.mCurrentConfig = this.mUseCaseConfig;
        return true;
    L11:
        this.mCurrentConfig = mergeConfigs(r4.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        return true;
    }

    public void setViewPortCropRect(Rect r1) {
        this.mViewPortCropRect = r1;
    }

    public final void unbindFromCamera(CameraInternal r4) {
        onUnbind();
        Object r0 = this.mCameraLock;
        monitor-enter(r0);
        CameraInternal r1 = this.mCamera;     // Catch: Throwable -> L13
        if (r4 != r1) goto L7;
        removeStateChangeCallback(r1);     // Catch: Throwable -> L13
        this.mCamera = null;     // Catch: Throwable -> L13
    L7:
        CameraInternal r2 = this.mSecondaryCamera;     // Catch: Throwable -> L13
        if (r4 != r2) goto L10;
        removeStateChangeCallback(r2);     // Catch: Throwable -> L13
        this.mSecondaryCamera = null;     // Catch: Throwable -> L13
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L13
        this.mAttachedStreamSpec = null;
        this.mViewPortCropRect = null;
        this.mCurrentConfig = this.mUseCaseConfig;
        this.mExtendedConfig = null;
        this.mCameraConfig = null;
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void updateSessionConfig(List<SessionConfig> r4) {
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        this.mAttachedSessionConfig = (SessionConfig) ListProtector.get(r4, 0);
        if (r4.size() <= 1) goto L8;
        this.mAttachedSecondarySessionConfig = (SessionConfig) ListProtector.get(r4, 1);
    L8:
        Iterator<SessionConfig> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L17;
        Iterator<DeferrableSurface> r0 = r5.next().getSurfaces().iterator();
    L13:
        if (r0.hasNext() == false) goto L10;
        DeferrableSurface r1 = r0.next();
        if (r1.getContainerClass() != null) goto L13;
        r1.setContainerClass(getClass());
        goto L13
    }

    public void updateSuggestedStreamSpecImplementationOptions(Config r1) {
        this.mAttachedStreamSpec = onSuggestedStreamSpecImplementationOptionsUpdated(r1);
    }

    public int getRelativeRotation(CameraInternal r3, boolean r4) {
        int r0 = r3.getCameraInfoInternal().getSensorRotationDegrees(getTargetRotationInternal());
        if (r3.getHasTransform() == true) goto L6;
        if (r4 == false) goto L6;
        boolean r5 = true;
    L7:
        if (r5 == true) goto L9;
        return r0;
    L9:
        return TransformUtils.within360(-r0);
    L6:
        r5 = false;
        goto L7
    }

    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal r1, UseCaseConfig.Builder<?, ?, ?> r2) {
        return r2.getUseCaseConfig();
    }

    public void updateSuggestedStreamSpec(StreamSpec r1, StreamSpec r2) {
        this.mAttachedStreamSpec = onSuggestedStreamSpecUpdated(r1, r2);
    }

    public UseCaseConfig<?> mergeConfigs(CameraInfoInternal r5, UseCaseConfig<?> r6, UseCaseConfig<?> r7) {
        if (r7 == null) goto L4;
        MutableOptionsBundle r8 = MutableOptionsBundle.from(r7);
        r8.removeOption(TargetConfig.OPTION_TARGET_NAME);
    L6:
        if (this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO) == false) goto L8;
    L9:
        Config.Option<ResolutionSelector> r0 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (r8.containsOption(r0) == false) goto L12;
        r8.removeOption(r0);
    L12:
        UseCaseConfig<?> r1 = this.mUseCaseConfig;
        Config.Option<ResolutionSelector> r2 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (r1.containsOption(r2) == false) goto L19;
        Config.Option<Size> r3 = ImageOutputConfig.OPTION_MAX_RESOLUTION;
        if (r8.containsOption(r3) == false) goto L19;
        if (((ResolutionSelector) this.mUseCaseConfig.retrieveOption(r2)).getResolutionStrategy() == null) goto L19;
        r8.removeOption(r3);
    L19:
        Iterator<Config.Option<?>> r4 = this.mUseCaseConfig.listOptions().iterator();
    L21:
        if (r4.hasNext() == false) goto L23;
        Config.Option<?> r9 = r4.next();
        Config.CC.mergeOptionValue(r8, r8, this.mUseCaseConfig, r9);
        goto L21
    L23:
        if (r6 == null) goto L32;
        Iterator<Config.Option<?>> r10 = r6.listOptions().iterator();
    L26:
        if (r10.hasNext() == false) goto L32;
        Config.Option<?> r11 = r10.next();
        if (r11.getId().equals(TargetConfig.OPTION_TARGET_NAME.getId()) == true) goto L26;
        Config.CC.mergeOptionValue(r8, r8, r6, r11);
    L32:
        if (r8.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION) == false) goto L36;
        Config.Option<Integer> r12 = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
        if (r8.containsOption(r12) == false) goto L36;
        r8.removeOption(r12);
    L36:
        Config.Option<ResolutionSelector> r13 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (r8.containsOption(r13) == false) goto L42;
        if (((ResolutionSelector) r8.retrieveOption(r13)).getAllowedResolutionMode() == 0) goto L42;
        r8.insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.TRUE);
    L42:
        return onMergeConfig(r5, getUseCaseConfigBuilder(r8));
    L8:
        if (this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION) == false) goto L12;
    L4:
        r8 = MutableOptionsBundle.create();
        goto L6
    }

    public final void bindToCamera(CameraInternal r2, CameraInternal r3, UseCaseConfig<?> r4, UseCaseConfig<?> r5) {
        Object r0 = this.mCameraLock;
        monitor-enter(r0);
        this.mCamera = r2;     // Catch: Throwable -> L10
        this.mSecondaryCamera = r3;     // Catch: Throwable -> L10
        addStateChangeCallback(r2);     // Catch: Throwable -> L10
        if (r3 == null) goto L7;
        addStateChangeCallback(r3);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mExtendedConfig = r4;
        this.mCameraConfig = r5;
        this.mCurrentConfig = mergeConfigs(r2.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        onBind();
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
