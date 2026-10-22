package androidx.camera.core.processing.concurrent;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Node;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.util.OutConfig;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class DualSurfaceProcessorNode implements Node<In, Out> {
    private static final String TAG = "DualSurfaceProcessorNode";
    private In mInput;
    private Out mOutput;
    final CameraInternal mPrimaryCameraInternal;
    final CameraInternal mSecondaryCameraInternal;
    final SurfaceProcessorInternal mSurfaceProcessor;

    public static abstract class In {
        public In() {
        }

        public abstract List<DualOutConfig> getOutConfigs();

        public abstract SurfaceEdge getPrimarySurfaceEdge();

        public abstract SurfaceEdge getSecondarySurfaceEdge();

        public static In of(SurfaceEdge r1, SurfaceEdge r2, List<DualOutConfig> r3) {
            return new AutoValue_DualSurfaceProcessorNode_In(r1, r2, r3);
        }
    }

    public static class Out extends HashMap<DualOutConfig, SurfaceEdge> {
        public Out() {
        }
    }

    public static /* synthetic */ void a(DualSurfaceProcessorNode r0, CameraInternal r1, CameraInternal r2, SurfaceEdge r3, SurfaceEdge r4, Map.Entry r5) {
        r0.lambda$sendSurfaceOutputs$0(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void b(DualSurfaceProcessorNode r0) {
        r0.lambda$release$1();
    }

    private /* synthetic */ void lambda$release$1() {
        Out r0 = this.mOutput;
        if (r0 == null) goto L8;
        Iterator<SurfaceEdge> r1 = r0.values().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        r1.next().close();
        goto L6
    L10:
        return;
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
        this.mSurfaceProcessor.release();
        Threads.runOnMain(new k(this));
    }

    /* JADX INFO: renamed from: transform, reason: avoid collision after fix types in other method */
    public Out transform2(In r7) {
        Threads.checkMainThread();
        this.mInput = r7;
        this.mOutput = new Out();
        SurfaceEdge r3 = this.mInput.getPrimarySurfaceEdge();
        SurfaceEdge r4 = this.mInput.getSecondarySurfaceEdge();
        Iterator<DualOutConfig> r8 = this.mInput.getOutConfigs().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        DualOutConfig r0 = r8.next();
        this.mOutput.put(r0, transformSingleOutput(r3, r0.getPrimaryOutConfig()));
        goto L4
    L6:
        sendSurfaceRequest(this.mPrimaryCameraInternal, r3, this.mOutput, true);
        sendSurfaceRequest(this.mSecondaryCameraInternal, r4, this.mOutput, false);
        sendSurfaceOutputs(this.mPrimaryCameraInternal, this.mSecondaryCameraInternal, r3, r4, this.mOutput);
        return this.mOutput;
    }

    @Override // androidx.camera.core.processing.Node
    public /* bridge */ /* synthetic */ Out transform(In r1) {
        return transform2(r1);
    }

    private SurfaceEdge transformSingleOutput(SurfaceEdge r14, OutConfig r15) {
        Rect r0 = r15.getCropRect();
        int r1 = r15.getRotationDegrees();
        boolean r2 = r15.isMirroring();
        Matrix r7 = new Matrix();
        Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.getRotatedSize(r0, r1), r15.getSize()));
        Rect r9 = TransformUtils.sizeToRect(r15.getSize());
        StreamSpec r6 = r14.getStreamSpec().toBuilder().setResolution(r15.getSize()).build();
        int r4 = r15.getTargets();
        int r5 = r15.getFormat();
        int r10 = r14.getRotationDegrees() - r1;
        if (r14.isMirroring() == r2) goto L5;
        boolean r12 = true;
    L7:
        return new SurfaceEdge(r4, r5, r6, r7, false, r9, r10, -1, r12);
    L5:
        r12 = false;
        goto L7
    }

    public DualSurfaceProcessorNode(CameraInternal r1, CameraInternal r2, SurfaceProcessorInternal r3) {
        this.mPrimaryCameraInternal = r1;
        this.mSecondaryCameraInternal = r2;
        this.mSurfaceProcessor = r3;
    }

    private void sendSurfaceRequest(CameraInternal r1, SurfaceEdge r2, Map<DualOutConfig, SurfaceEdge> r3, boolean r4) {
        SurfaceRequest r5 = r2.createSurfaceRequest(r1, r4);
        this.mSurfaceProcessor.onInputSurface(r5);     // Catch: ProcessingException -> L5
        return;
    L5:
        e = move-exception;
        Logger.e(TAG, "Failed to send SurfaceRequest to SurfaceProcessor.", e);
    }

    private void createAndSendSurfaceOutput(CameraInternal r6, CameraInternal r7, SurfaceEdge r8, SurfaceEdge r9, Map.Entry<DualOutConfig, SurfaceEdge> r10) {
        final SurfaceEdge r0 = r10.getValue();
        Size r1 = r8.getStreamSpec().getResolution();
        Rect r2 = r10.getKey().getPrimaryOutConfig().getCropRect();
        if (r8.hasCameraTransform() == true) goto L6;
        r6 = null;
    L6:
        SurfaceOutput.CameraInputInfo r11 = SurfaceOutput.CameraInputInfo.of(r1, r2, r6, r10.getKey().getPrimaryOutConfig().getRotationDegrees(), r10.getKey().getPrimaryOutConfig().isMirroring());
        Size r12 = r9.getStreamSpec().getResolution();
        Rect r3 = r10.getKey().getSecondaryOutConfig().getCropRect();
        if (r9.hasCameraTransform() == true) goto L10;
        r7 = null;
    L10:
        Futures.addCallback(r0.createSurfaceOutputFuture(r10.getKey().getPrimaryOutConfig().getFormat(), r11, SurfaceOutput.CameraInputInfo.of(r12, r3, r7, r10.getKey().getSecondaryOutConfig().getRotationDegrees(), r10.getKey().getSecondaryOutConfig().isMirroring())), new AnonymousClass1(this, r0), CameraXExecutors.mainThreadExecutor());
    }

    private /* synthetic */ void lambda$sendSurfaceOutputs$0(CameraInternal r1, CameraInternal r2, SurfaceEdge r3, SurfaceEdge r4, Map.Entry r5) {
        createAndSendSurfaceOutput(r1, r2, r3, r4, r5);
    }

    private void sendSurfaceOutputs(final CameraInternal r10, final CameraInternal r11, final SurfaceEdge r12, final SurfaceEdge r13, Map<DualOutConfig, SurfaceEdge> r14) {
        Iterator<Map.Entry<DualOutConfig, SurfaceEdge>> r15 = r14.entrySet().iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        final Map.Entry<DualOutConfig, SurfaceEdge> r7 = r15.next();
        createAndSendSurfaceOutput(r10, r11, r12, r13, r7);
        r7.getValue().addOnInvalidatedListener(new l(this, r10, r11, r12, r13, r7));
        goto L4
    }
}
