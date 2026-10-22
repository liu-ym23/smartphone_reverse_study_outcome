package androidx.camera.core.streamsharing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.processing.concurrent.DualOutConfig;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode;
import androidx.camera.core.processing.util.OutConfig;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class StreamSharing extends UseCase {
    private static final String TAG = "StreamSharing";
    private SurfaceEdge mCameraEdge;
    private SessionConfig.CloseableErrorListener mCloseableErrorListener;
    private final StreamSharingConfig mDefaultConfig;
    private DualSurfaceProcessorNode mDualSharingNode;
    private SurfaceProcessorNode mEffectNode;
    private final LayoutSettings mLayoutSettings;
    private SurfaceEdge mSecondaryCameraEdge;
    private final LayoutSettings mSecondaryLayoutSettings;
    SessionConfig.Builder mSecondarySessionConfigBuilder;
    private SurfaceEdge mSecondarySharingInputEdge;
    SessionConfig.Builder mSessionConfigBuilder;
    private SurfaceEdge mSharingInputEdge;
    private SurfaceProcessorNode mSharingNode;
    private final VirtualCameraAdapter mVirtualCameraAdapter;

    public interface Control {
        ListenableFuture<Void> jpegSnapshot(int r1, int r2);
    }

    public static /* synthetic */ void a(StreamSharing r0, String r1, String r2, UseCaseConfig r3, StreamSpec r4, StreamSpec r5, SessionConfig r6, SessionConfig.SessionError r7) {
        r0.lambda$addCameraErrorListener$1(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ ListenableFuture b(StreamSharing r0, int r1, int r2) {
        return r0.lambda$new$0(r1, r2);
    }

    private void clearPipeline() {
        SessionConfig.CloseableErrorListener r0 = this.mCloseableErrorListener;
        if (r0 == null) goto L5;
        r0.close();
        this.mCloseableErrorListener = null;
    L5:
        SurfaceEdge r1 = this.mCameraEdge;
        if (r1 == null) goto L8;
        r1.close();
        this.mCameraEdge = null;
    L8:
        SurfaceEdge r2 = this.mSecondaryCameraEdge;
        if (r2 == null) goto L11;
        r2.close();
        this.mSecondaryCameraEdge = null;
    L11:
        SurfaceEdge r3 = this.mSharingInputEdge;
        if (r3 == null) goto L14;
        r3.close();
        this.mSharingInputEdge = null;
    L14:
        SurfaceEdge r4 = this.mSecondarySharingInputEdge;
        if (r4 == null) goto L17;
        r4.close();
        this.mSecondarySharingInputEdge = null;
    L17:
        SurfaceProcessorNode r5 = this.mSharingNode;
        if (r5 == null) goto L20;
        r5.release();
        this.mSharingNode = null;
    L20:
        DualSurfaceProcessorNode r6 = this.mDualSharingNode;
        if (r6 == null) goto L23;
        r6.release();
        this.mDualSharingNode = null;
    L23:
        SurfaceProcessorNode r7 = this.mEffectNode;
        if (r7 == null) goto L27;
        r7.release();
        this.mEffectNode = null;
        return;
    }

    public Set<UseCase> getChildren() {
        return this.mVirtualCameraAdapter.getChildren();
    }

    @Override // androidx.camera.core.UseCase
    public Set<Integer> getSupportedEffectTargets() {
        HashSet r0 = new HashSet();
        r0.add(3);
        return r0;
    }

    private boolean getMirroringAppliedByEffect() {
        if (((CameraEffect) Preconditions.checkNotNull(getEffect())).getTransformation() != 1) goto L10;
        CameraInternal r0 = (CameraInternal) Preconditions.checkNotNull(getCamera());
        if (r0.isFrontFacing() == true) goto L7;
        return false;
    L7:
        if (r0.getHasTransform() == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private int getRotationAppliedByEffect() {
        if (((CameraEffect) Preconditions.checkNotNull(getEffect())).getTransformation() == 1) goto L5;
        return 0;
    L5:
        return getRelativeRotation((CameraInternal) Preconditions.checkNotNull(getCamera()));
    }

    @Override // androidx.camera.core.UseCase
    public void onBind() {
        super.onBind();
        this.mVirtualCameraAdapter.bindChildren();
    }

    @Override // androidx.camera.core.UseCase
    public void onStateAttached() {
        super.onStateAttached();
        this.mVirtualCameraAdapter.notifyStateAttached();
    }

    @Override // androidx.camera.core.UseCase
    public void onStateDetached() {
        super.onStateDetached();
        this.mVirtualCameraAdapter.notifyStateDetached();
    }

    @Override // androidx.camera.core.UseCase
    public void onUnbind() {
        super.onUnbind();
        clearPipeline();
        this.mVirtualCameraAdapter.unbindChildren();
    }

    public SurfaceEdge getCameraEdge() {
        return this.mCameraEdge;
    }

    public SurfaceEdge getSharingInputEdge() {
        return this.mSharingInputEdge;
    }

    public SurfaceProcessorNode getSharingNode() {
        return this.mSharingNode;
    }

    public VirtualCameraAdapter getVirtualCameraAdapter() {
        return this.mVirtualCameraAdapter;
    }

    public static List<UseCaseConfigFactory.CaptureType> getCaptureTypes(UseCase r2) {
        ArrayList r0 = new ArrayList();
        if (isStreamSharing(r2) == false) goto L8;
        Iterator<UseCase> r3 = ((StreamSharing) r2).getChildren().iterator();
    L6:
        if (r3.hasNext() == false) goto L9;
        r0.add(r3.next().getCurrentConfig().getCaptureType());
    L9:
        return r0;
    L8:
        r0.add(r2.getCurrentConfig().getCaptureType());
        goto L9
    }

    private static int getChildTemplate(UseCase r0) {
        return r0.getCurrentConfig().getDefaultSessionConfig().getTemplateType();
    }

    private Rect getCropRect(Size r4) {
        if (getViewPortCropRect() == null) goto L7;
        return getViewPortCropRect();
    L7:
        return new Rect(0, 0, r4.getWidth(), r4.getHeight());
    }

    private Rect getCropRectAppliedByEffect(SurfaceEdge r3) {
        if (((CameraEffect) Preconditions.checkNotNull(getEffect())).getTransformation() != 1) goto L7;
        return TransformUtils.sizeToRect(r3.getStreamSpec().getResolution());
    L7:
        return r3.getCropRect();
    }

    private static StreamSharingConfig getDefaultConfig(Set<UseCase> r5) {
        MutableConfig r0 = new StreamSharingBuilder().getMutableConfig();
        r0.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
        ArrayList r1 = new ArrayList();
        Iterator<UseCase> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        UseCase r2 = r6.next();
        if (r2.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE) == false) goto L4;
        r1.add(r2.getCurrentConfig().getCaptureType());
        goto L4
    L8:
        r0.insertOption(StreamSharingConfig.OPTION_CAPTURE_TYPES, r1);
        r0.insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, 2);
        return new StreamSharingConfig(OptionsBundle.from(r0));
    }

    public static boolean isStreamSharing(UseCase r0) {
        return r0 instanceof StreamSharing;
    }

    private void propagateChildrenTemplate(SessionConfig.Builder r5) {
        Iterator<UseCase> r0 = getChildren().iterator();
        int r2 = -1;
    L4:
        if (r0.hasNext() == false) goto L6;
        r2 = SessionConfig.getHigherPriorityTemplateType(r2, getChildTemplate(r0.next()));
        goto L4
    L6:
        if (r2 == (-1)) goto L10;
        r5.setTemplateType(r2);
        return;
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config r2) {
        return new StreamSharingBuilder(MutableOptionsBundle.from(r2));
    }

    @Override // androidx.camera.core.UseCase
    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config r5) {
        this.mSessionConfigBuilder.addImplementationOptions(r5);
        Object[] r2 = {this.mSessionConfigBuilder.build()};
        ArrayList r0 = new ArrayList(1);
        Object r1 = r2[0];
        Objects.requireNonNull(r1);
        r0.add(r1);
        updateSessionConfig(Collections.unmodifiableList(r0));
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(r5).build();
    }

    private SurfaceEdge getSharingInputEdge(SurfaceEdge r10, CameraInternal r11) {
        if (getEffect() != null) goto L6;
        return r10;
    L6:
        if (getEffect().getTransformation() != 2) goto L9;
        return r10;
    L9:
        if (getEffect().getOutputOption() != 1) goto L11;
        return r10;
    L11:
        this.mEffectNode = new SurfaceProcessorNode(r11, getEffect().createSurfaceProcessorInternal());
        int r6 = getRotationAppliedByEffect();
        Rect r4 = getCropRectAppliedByEffect(r10);
        OutConfig r12 = OutConfig.of(r10.getTargets(), r10.getFormat(), r4, TransformUtils.getRotatedSize(r4, r6), r6, getMirroringAppliedByEffect(), true);
        SurfaceProcessorNode.In r13 = SurfaceProcessorNode.In.of(r10, Collections.singletonList(r12));
        SurfaceEdge r14 = this.mEffectNode.transform2(r13).get(r12);
        Objects.requireNonNull(r14);
        return r14;
    }

    private SurfaceProcessorNode getSharingNode(CameraInternal r3, StreamSpec r4) {
        if (getEffect() == null) goto L9;
        if (getEffect().getOutputOption() != 1) goto L9;
        SurfaceProcessorNode r5 = new SurfaceProcessorNode(r3, getEffect().createSurfaceProcessorInternal());
        this.mEffectNode = r5;
        return r5;
    L9:
        return new SurfaceProcessorNode(r3, DefaultSurfaceProcessor.Factory.newInstance(r4.getDynamicRange()));
    }

    private /* synthetic */ ListenableFuture lambda$new$0(int r2, int r3) {
        SurfaceProcessorNode r0 = this.mSharingNode;
        if (r0 == null) goto L7;
        return r0.getSurfaceProcessor().snapshot(r2, r3);
    L7:
        return Futures.immediateFailedFuture(new Exception("Failed to take picture: pipeline is not ready."));
    }

    private void propagateChildrenCamera2Interop(Size r4, SessionConfig.Builder r5) {
        Iterator<UseCase> r0 = getChildren().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        SessionConfig r1 = SessionConfig.Builder.createFrom(r0.next().getCurrentConfig(), r4).build();
        r5.addAllRepeatingCameraCaptureCallbacks(r1.getRepeatingCameraCaptureCallbacks());
        r5.addAllCameraCaptureCallbacks(r1.getSingleCameraCaptureCallbacks());
        r5.addAllSessionStateCallbacks(r1.getSessionStateCallbacks());
        r5.addAllDeviceStateCallbacks(r1.getDeviceStateCallbacks());
        r5.addImplementationOptions(r1.getImplementationOptions());
        goto L4
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> getDefaultConfig(boolean r3, UseCaseConfigFactory r4) {
        Config r5 = r4.getConfig(this.mDefaultConfig.getCaptureType(), 1);
        if (r3 == false) goto L5;
        r5 = Config.CC.mergeConfigs(r5, this.mDefaultConfig.getConfig());
    L5:
        if (r5 != null) goto L8;
        return null;
    L8:
        return getUseCaseConfigBuilder(r5).getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal r2, UseCaseConfig.Builder<?, ?, ?> r3) {
        this.mVirtualCameraAdapter.mergeChildrenConfigs(r3.getMutableConfig());
        return r3.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec r7, StreamSpec r8) {
        updateSessionConfig(createPipelineAndUpdateChildrenSpecs(getCameraId(), getSecondaryCameraId(), getCurrentConfig(), r7, r8));
        notifyActive();
        return r7;
    }

    private SessionConfig.Builder createSessionConfigBuilder(SurfaceEdge r4, UseCaseConfig<?> r5, StreamSpec r6) {
        SessionConfig.Builder r7 = SessionConfig.Builder.createFrom(r5, r6.getResolution());
        propagateChildrenTemplate(r7);
        propagateChildrenCamera2Interop(r6.getResolution(), r7);
        r7.addSurface(r4.getDeferrableSurface(), r6.getDynamicRange(), null, -1);
        r7.addRepeatingCameraCaptureCallback(this.mVirtualCameraAdapter.getParentMetadataCallback());
        if (r6.getImplementationOptions() == null) goto L5;
        r7.addImplementationOptions(r6.getImplementationOptions());
    L5:
        return r7;
    }

    private List<SessionConfig> createPipelineAndUpdateChildrenSpecs(String r9, String r10, UseCaseConfig<?> r11, StreamSpec r12, StreamSpec r13) {
        Threads.checkMainThread();
        int r0 = 0;
        if (r13 != null) goto L14;
        createPrimaryCamera(r9, r10, r11, r12, null);
        CameraInternal r14 = getCamera();
        Objects.requireNonNull(r14);
        this.mSharingNode = getSharingNode(r14, r12);
        if (getViewPortCropRect() == null) goto L7;
        boolean r15 = true;
    L8:
        Map<UseCase, OutConfig> r16 = this.mVirtualCameraAdapter.getChildrenOutConfigs(this.mSharingInputEdge, getTargetRotationInternal(), r15);
        SurfaceProcessorNode.Out r17 = this.mSharingNode.transform2(SurfaceProcessorNode.In.of(this.mSharingInputEdge, new ArrayList(r16.values())));
        HashMap r18 = new HashMap();
        Iterator<Map.Entry<UseCase, OutConfig>> r19 = r16.entrySet().iterator();
    L10:
        if (r19.hasNext() == false) goto L12;
        Map.Entry<UseCase, OutConfig> r110 = r19.next();
        r18.put(r110.getKey(), r17.get(r110.getValue()));
        goto L10
    L12:
        this.mVirtualCameraAdapter.setChildrenEdges(r18);
        Object[] r111 = {this.mSessionConfigBuilder.build()};
        ArrayList r20 = new ArrayList(1);
        Object r112 = r111[0];
        Objects.requireNonNull(r112);
        r20.add(r112);
        return Collections.unmodifiableList(r20);
    L7:
        r15 = false;
        goto L8
    L14:
        createPrimaryCamera(r9, r10, r11, r12, r13);
        createSecondaryCamera(r9, r10, r11, r12, r13);
        this.mDualSharingNode = getDualSharingNode(getCamera(), getSecondaryCamera(), r12, this.mLayoutSettings, this.mSecondaryLayoutSettings);
        if (getViewPortCropRect() == null) goto L17;
        boolean r21 = true;
    L18:
        Map<UseCase, DualOutConfig> r22 = this.mVirtualCameraAdapter.getChildrenOutConfigs(this.mSharingInputEdge, this.mSecondarySharingInputEdge, getTargetRotationInternal(), r21);
        DualSurfaceProcessorNode.Out r113 = this.mDualSharingNode.transform2(DualSurfaceProcessorNode.In.of(this.mSharingInputEdge, this.mSecondarySharingInputEdge, new ArrayList(r22.values())));
        HashMap r114 = new HashMap();
        Iterator<Map.Entry<UseCase, DualOutConfig>> r23 = r22.entrySet().iterator();
    L20:
        if (r23.hasNext() == false) goto L22;
        Map.Entry<UseCase, DualOutConfig> r115 = r23.next();
        r114.put(r115.getKey(), r113.get(r115.getValue()));
        goto L20
    L22:
        this.mVirtualCameraAdapter.setChildrenEdges(r114);
        Object[] r116 = {this.mSessionConfigBuilder.build(), this.mSecondarySessionConfigBuilder.build()};
        ArrayList r24 = new ArrayList(2);
    L23:
        if (r0 >= 2) goto L26;
        Object r117 = r116[r0];
        Objects.requireNonNull(r117);
        r24.add(r117);
        r0 = r0 + 1;
        goto L23
    L26:
        return Collections.unmodifiableList(r24);
    L17:
        r21 = false;
        goto L18
    }

    private void createPrimaryCamera(String r19, String r20, UseCaseConfig<?> r21, StreamSpec r22, StreamSpec r23) {
        Matrix r12 = getSensorToBufferTransformMatrix();
        CameraInternal r1 = getCamera();
        Objects.requireNonNull(r1);
        boolean r13 = r1.getHasTransform();
        Rect r14 = getCropRect(r22.getResolution());
        Objects.requireNonNull(r14);
        CameraInternal r2 = getCamera();
        Objects.requireNonNull(r2);
        int r15 = getRelativeRotation(r2);
        CameraInternal r3 = getCamera();
        Objects.requireNonNull(r3);
        this.mCameraEdge = new SurfaceEdge(3, 34, r22, r12, r13, r14, r15, -1, isMirroringRequired(r3));
        SurfaceEdge r0 = this.mCameraEdge;
        CameraInternal r4 = getCamera();
        Objects.requireNonNull(r4);
        this.mSharingInputEdge = getSharingInputEdge(r0, r4);
        SessionConfig.Builder r5 = createSessionConfigBuilder(this.mCameraEdge, r21, r22);
        this.mSessionConfigBuilder = r5;
        addCameraErrorListener(r5, r19, r20, r21, r22, r23);
    }

    private void createSecondaryCamera(String r19, String r20, UseCaseConfig<?> r21, StreamSpec r22, StreamSpec r23) {
        Matrix r12 = getSensorToBufferTransformMatrix();
        CameraInternal r1 = getSecondaryCamera();
        Objects.requireNonNull(r1);
        boolean r13 = r1.getHasTransform();
        Rect r14 = getCropRect(r23.getResolution());
        Objects.requireNonNull(r14);
        CameraInternal r2 = getSecondaryCamera();
        Objects.requireNonNull(r2);
        int r15 = getRelativeRotation(r2);
        CameraInternal r3 = getSecondaryCamera();
        Objects.requireNonNull(r3);
        this.mSecondaryCameraEdge = new SurfaceEdge(3, 34, r23, r12, r13, r14, r15, -1, isMirroringRequired(r3));
        SurfaceEdge r0 = this.mSecondaryCameraEdge;
        CameraInternal r4 = getSecondaryCamera();
        Objects.requireNonNull(r4);
        this.mSecondarySharingInputEdge = getSharingInputEdge(r0, r4);
        SessionConfig.Builder r5 = createSessionConfigBuilder(this.mSecondaryCameraEdge, r21, r23);
        this.mSecondarySessionConfigBuilder = r5;
        addCameraErrorListener(r5, r19, r20, r21, r22, r23);
    }

    private DualSurfaceProcessorNode getDualSharingNode(CameraInternal r2, CameraInternal r3, StreamSpec r4, LayoutSettings r5, LayoutSettings r6) {
        return new DualSurfaceProcessorNode(r2, r3, DualSurfaceProcessor.Factory.newInstance(r4.getDynamicRange(), r5, r6));
    }

    public StreamSharing(CameraInternal r8, CameraInternal r9, LayoutSettings r10, LayoutSettings r11, Set<UseCase> r12, UseCaseConfigFactory r13) {
        super(getDefaultConfig(r12));
        this.mDefaultConfig = getDefaultConfig(r12);
        this.mLayoutSettings = r10;
        this.mSecondaryLayoutSettings = r11;
        this.mVirtualCameraAdapter = new VirtualCameraAdapter(r8, r9, r12, r13, new a(this));
    }

    private void addCameraErrorListener(SessionConfig.Builder r10, final String r11, final String r12, final UseCaseConfig<?> r13, final StreamSpec r14, final StreamSpec r15) {
        SessionConfig.CloseableErrorListener r0 = this.mCloseableErrorListener;
        if (r0 == null) goto L5;
        r0.close();
    L5:
        SessionConfig.CloseableErrorListener r1 = new SessionConfig.CloseableErrorListener(new b(this, r11, r12, r13, r14, r15));
        this.mCloseableErrorListener = r1;
        r10.setErrorListener(r1);
    }

    private /* synthetic */ void lambda$addCameraErrorListener$1(String r1, String r2, UseCaseConfig r3, StreamSpec r4, StreamSpec r5, SessionConfig r6, SessionConfig.SessionError r7) {
        if (getCamera() != null) goto L5;
        return;
    L5:
        clearPipeline();
        updateSessionConfig(createPipelineAndUpdateChildrenSpecs(r1, r2, r3, r4, r5));
        notifyReset();
        this.mVirtualCameraAdapter.resetChildren();
    }
}
