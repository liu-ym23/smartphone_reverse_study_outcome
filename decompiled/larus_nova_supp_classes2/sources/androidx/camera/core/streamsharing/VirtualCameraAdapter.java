package androidx.camera.core.streamsharing;

import android.graphics.Rect;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.concurrent.DualOutConfig;
import androidx.camera.core.processing.util.OutConfig;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class VirtualCameraAdapter implements UseCase.StateChangeCallback {
    final Set<UseCase> mChildren;
    final Map<UseCase, Boolean> mChildrenActiveState;
    private final Set<UseCaseConfig<?>> mChildrenConfigs;
    private final Map<UseCase, UseCaseConfig<?>> mChildrenConfigsMap;
    final Map<UseCase, SurfaceEdge> mChildrenEdges;
    private final Map<UseCase, VirtualCamera> mChildrenVirtualCameras;
    private final CameraInternal mParentCamera;
    private final CameraCaptureCallback mParentMetadataCallback;
    private final ResolutionsMerger mResolutionsMerger;
    private final CameraInternal mSecondaryParentCamera;
    private ResolutionsMerger mSecondaryResolutionsMerger;
    private final UseCaseConfigFactory mUseCaseConfigFactory;

    public void bindChildren() {
        Iterator<UseCase> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        UseCase r1 = r0.next();
        VirtualCamera r2 = this.mChildrenVirtualCameras.get(r1);
        Objects.requireNonNull(r2);
        r1.bindToCamera(r2, null, null, r1.getDefaultConfig(true, this.mUseCaseConfigFactory));
        goto L4
    }

    public CameraCaptureCallback createCameraCaptureCallback() {
        return new AnonymousClass1(this);
    }

    public void notifyStateAttached() {
        Iterator<UseCase> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        UseCase r1 = r0.next();
        r1.onStateAttached();
        r1.onCameraControlReady();
        goto L4
    }

    public void notifyStateDetached() {
        Iterator<UseCase> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onStateDetached();
        goto L4
    }

    public void unbindChildren() {
        Iterator<UseCase> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        UseCase r1 = r0.next();
        VirtualCamera r2 = this.mChildrenVirtualCameras.get(r1);
        Objects.requireNonNull(r2);
        r1.unbindFromCamera(r2);
        goto L4
    }

    public void resetChildren() {
        Threads.checkMainThread();
        Iterator<UseCase> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        onUseCaseReset(r0.next());
        goto L4
    }

    public Set<UseCase> getChildren() {
        return this.mChildren;
    }

    public CameraCaptureCallback getParentMetadataCallback() {
        return this.mParentMetadataCallback;
    }

    private static int getChildFormat(UseCase r0) {
        if ((r0 instanceof ImageCapture) == false) goto L5;
        return 256;
    L5:
        return 34;
    }

    public static DeferrableSurface getChildSurface(UseCase r3) {
        if ((r3 instanceof ImageCapture) == false) goto L5;
        List<DeferrableSurface> r4 = r3.getSessionConfig().getSurfaces();
    L7:
        if (r4.size() > 1) goto L9;
        boolean r0 = true;
    L10:
        Preconditions.checkState(r0);
        if (r4.size() == 1) goto L13;
        return null;
    L13:
        return (DeferrableSurface) ListProtector.get(r4, 0);
    L9:
        r0 = false;
        goto L10
    L5:
        r4 = r3.getSessionConfig().getRepeatingCaptureConfig().getSurfaces();
        goto L7
    }

    private static int getChildTargetType(UseCase r1) {
        if ((r1 instanceof Preview) == false) goto L7;
        return 1;
    L7:
        if ((r1 instanceof ImageCapture) == false) goto L10;
        return 4;
    L10:
        return 2;
    }

    private static int getHighestSurfacePriority(Set<UseCaseConfig<?>> r3) {
        Iterator<UseCaseConfig<?>> r4 = r3.iterator();
        int r1 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r1 = Math.max(r1, r4.next().getSurfaceOccupancyPriority(0));
        goto L4
    L6:
        return r1;
    }

    private SurfaceEdge getUseCaseEdge(UseCase r2) {
        SurfaceEdge r3 = this.mChildrenEdges.get(r2);
        Objects.requireNonNull(r3);
        return r3;
    }

    private boolean isUseCaseActive(UseCase r2) {
        Boolean r3 = this.mChildrenActiveState.get(r2);
        Objects.requireNonNull(r3);
        return r3.booleanValue();
    }

    public void mergeChildrenConfigs(MutableConfig r5) {
        List<Size> r0 = this.mResolutionsMerger.getMergedResolutions(r5);
        r5.insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, r0);
        r5.insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(getHighestSurfacePriority(this.mChildrenConfigs)));
        DynamicRange r1 = DynamicRangeUtils.resolveDynamicRange(this.mChildrenConfigs);
        if (r1 == null) goto L15;
        r5.insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, r1);
        Iterator<UseCase> r2 = this.mChildren.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        UseCase r3 = r2.next();
        if (r3.getCurrentConfig().getVideoStabilizationMode() == 0) goto L11;
        r5.insertOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, Integer.valueOf(r3.getCurrentConfig().getVideoStabilizationMode()));
    L11:
        if (r3.getCurrentConfig().getPreviewStabilizationMode() == 0) goto L6;
        r5.insertOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, Integer.valueOf(r3.getCurrentConfig().getPreviewStabilizationMode()));
        goto L6
    L13:
        return;
    L15:
        throw new IllegalArgumentException("Failed to merge child dynamic ranges, can not find a dynamic range that satisfies all children.");
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseActive(UseCase r3) {
        Threads.checkMainThread();
        if (isUseCaseActive(r3) == false) goto L5;
        return;
    L5:
        this.mChildrenActiveState.put(r3, Boolean.TRUE);
        DeferrableSurface r0 = getChildSurface(r3);
        if (r0 == null) goto L9;
        forceSetProvider(getUseCaseEdge(r3), r0, r3.getSessionConfig());
        return;
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseInactive(UseCase r3) {
        Threads.checkMainThread();
        if (isUseCaseActive(r3) == true) goto L5;
        return;
    L5:
        this.mChildrenActiveState.put(r3, Boolean.FALSE);
        getUseCaseEdge(r3).disconnect();
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseReset(UseCase r3) {
        Threads.checkMainThread();
        SurfaceEdge r0 = getUseCaseEdge(r3);
        if (isUseCaseActive(r3) == true) goto L5;
        return;
    L5:
        DeferrableSurface r1 = getChildSurface(r3);
        if (r1 == null) goto L9;
        forceSetProvider(r0, r1, r3.getSessionConfig());
        return;
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseUpdated(UseCase r3) {
        Threads.checkMainThread();
        if (isUseCaseActive(r3) == true) goto L5;
        return;
    L5:
        SurfaceEdge r0 = getUseCaseEdge(r3);
        DeferrableSurface r1 = getChildSurface(r3);
        if (r1 == null) goto L8;
        forceSetProvider(r0, r1, r3.getSessionConfig());
        return;
    L8:
        r0.disconnect();
    }

    public void setChildrenEdges(Map<UseCase, SurfaceEdge> r4) {
        this.mChildrenEdges.clear();
        this.mChildrenEdges.putAll(r4);
        Iterator<Map.Entry<UseCase, SurfaceEdge>> r5 = this.mChildrenEdges.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<UseCase, SurfaceEdge> r0 = r5.next();
        UseCase r1 = r0.getKey();
        SurfaceEdge r2 = r0.getValue();
        r1.setViewPortCropRect(r2.getCropRect());
        r1.setSensorToBufferTransformMatrix(r2.getSensorToBufferTransform());
        r1.updateSuggestedStreamSpec(r2.getStreamSpec(), null);
        r1.notifyState();
        goto L4
    }

    private int getChildRotationDegrees(UseCase r2, CameraInternal r3) {
        int r4 = ((ImageOutputConfig) r2.getCurrentConfig()).getTargetRotation(0);
        return r3.getCameraInfo().getSensorRotationDegrees(r4);
    }

    private static void forceSetProvider(SurfaceEdge r0, DeferrableSurface r1, SessionConfig r2) {
        r0.invalidate();
        r0.setProvider(r1);     // Catch: DeferrableSurface.SurfaceClosedException -> L5
        return;
    L6:
        if (r2.getErrorListener() == null) goto L11;
        r2.getErrorListener().onError(r2, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
        return;
    }

    public static void sendCameraCaptureResultToChild(CameraCaptureResult r4, SessionConfig r5, int r6) {
        Iterator<CameraCaptureCallback> r0 = r5.getRepeatingCameraCaptureCallbacks().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCaptureCompleted(r6, new VirtualCameraCaptureResult(r5.getRepeatingCaptureConfig().getTagBundle(), r4));
        goto L4
    }

    private static Map<UseCase, UseCaseConfig<?>> toChildrenConfigsMap(CameraInternal r5, Set<UseCase> r6, UseCaseConfigFactory r7) {
        HashMap r0 = new HashMap();
        Iterator<UseCase> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        UseCase r1 = r8.next();
        r0.put(r1, r1.mergeConfigs(r5.getCameraInfoInternal(), null, r1.getDefaultConfig(true, r7)));
        goto L4
    L6:
        return r0;
    }

    public Map<UseCase, OutConfig> getChildrenOutConfigs(SurfaceEdge r11, int r12, boolean r13) {
        HashMap r0 = new HashMap();
        Iterator<UseCase> r1 = this.mChildren.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        UseCase r2 = r1.next();
        r0.put(r2, calculateOutConfig(r2, this.mResolutionsMerger, this.mParentCamera, r11, r12, r13));
        goto L4
    L6:
        return r0;
    }

    public Map<UseCase, DualOutConfig> getChildrenOutConfigs(SurfaceEdge r12, SurfaceEdge r13, int r14, boolean r15) {
        HashMap r0 = new HashMap();
        Iterator<UseCase> r1 = this.mChildren.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        UseCase r2 = r1.next();
        OutConfig r10 = calculateOutConfig(r2, this.mResolutionsMerger, this.mParentCamera, r12, r14, r15);
        ResolutionsMerger r5 = this.mSecondaryResolutionsMerger;
        CameraInternal r3 = this.mSecondaryParentCamera;
        Objects.requireNonNull(r3);
        r0.put(r2, DualOutConfig.of(r10, calculateOutConfig(r2, r5, r3, r13, r14, r15)));
        goto L4
    L6:
        return r0;
    }

    public VirtualCameraAdapter(CameraInternal r2, CameraInternal r3, Set<UseCase> r4, UseCaseConfigFactory r5, StreamSharing.Control r6) {
        this.mChildrenEdges = new HashMap();
        this.mChildrenVirtualCameras = new HashMap();
        this.mChildrenActiveState = new HashMap();
        this.mParentMetadataCallback = createCameraCaptureCallback();
        this.mParentCamera = r2;
        this.mSecondaryParentCamera = r3;
        this.mUseCaseConfigFactory = r5;
        this.mChildren = r4;
        Map<UseCase, UseCaseConfig<?>> r7 = toChildrenConfigsMap(r2, r4, r5);
        this.mChildrenConfigsMap = r7;
        HashSet r0 = new HashSet(r7.values());
        this.mChildrenConfigs = r0;
        this.mResolutionsMerger = new ResolutionsMerger(r2, r0);
        if (r3 == null) goto L5;
        this.mSecondaryResolutionsMerger = new ResolutionsMerger(r3, r0);
    L5:
        Iterator<UseCase> r8 = r4.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        UseCase r9 = r8.next();
        this.mChildrenActiveState.put(r9, Boolean.FALSE);
        this.mChildrenVirtualCameras.put(r9, new VirtualCamera(r2, this, r6));
        goto L7
    }

    private OutConfig calculateOutConfig(UseCase r8, ResolutionsMerger r9, CameraInternal r10, SurfaceEdge r11, int r12, boolean r13) {
        int r14 = r10.getCameraInfo().getSensorRotationDegrees(r12);
        boolean r0 = TransformUtils.isMirrored(r11.getSensorToBufferTransform());
        UseCaseConfig<?> r1 = this.mChildrenConfigsMap.get(r8);
        Objects.requireNonNull(r1);
        Pair<Rect, Size> r15 = r9.getPreferredChildSizePair(r1, r11.getCropRect(), TransformUtils.getRotationDegrees(r11.getSensorToBufferTransform()), r13);
        Rect r3 = (Rect) r15.first;
        Size r16 = (Size) r15.second;
        int r17 = getChildRotationDegrees(r8, this.mParentCamera);
        VirtualCamera r2 = this.mChildrenVirtualCameras.get(r8);
        Objects.requireNonNull(r2);
        r2.setRotationDegrees(r17);
        int r5 = TransformUtils.within360((r11.getRotationDegrees() + r17) - r14);
        return OutConfig.of(getChildTargetType(r8), getChildFormat(r8), r3, TransformUtils.rotateSize(r16, r5), r5, r8.isMirroringRequired(r10) ^ r0);
    }
}
