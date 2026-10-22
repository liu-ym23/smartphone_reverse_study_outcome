package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
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
import androidx.camera.core.processing.util.OutConfig;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SurfaceProcessorNode implements Node<In, Out> {
    private static final String TAG = "SurfaceProcessorNode";
    final CameraInternal mCameraInternal;
    private In mInput;
    private Out mOutput;
    final SurfaceProcessorInternal mSurfaceProcessor;

    public static abstract class In {
        public In() {
        }

        public abstract List<OutConfig> getOutConfigs();

        public abstract SurfaceEdge getSurfaceEdge();

        public static In of(SurfaceEdge r1, List<OutConfig> r2) {
            return new AutoValue_SurfaceProcessorNode_In(r1, r2);
        }
    }

    public static class Out extends HashMap<OutConfig, SurfaceEdge> {
        public Out() {
        }
    }

    public static /* synthetic */ void a(SurfaceProcessorNode r0, SurfaceEdge r1, Map.Entry r2) {
        r0.lambda$sendSurfaceOutputs$0(r1, r2);
    }

    public static /* synthetic */ void b(SurfaceProcessorNode r0) {
        r0.lambda$release$2();
    }

    public static /* synthetic */ void c(Map r0, SurfaceRequest.TransformationInfo r1) {
        lambda$setUpRotationUpdates$1(r0, r1);
    }

    private /* synthetic */ void lambda$release$2() {
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
        Threads.runOnMain(new g0(this));
    }

    public SurfaceProcessorInternal getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    private void sendSurfaceRequest(SurfaceEdge r3) {
        this.mSurfaceProcessor.onInputSurface(r3.createSurfaceRequest(this.mCameraInternal));     // Catch: ProcessingException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "Failed to send SurfaceRequest to SurfaceProcessor.", e);
    }

    /* JADX INFO: renamed from: transform, reason: avoid collision after fix types in other method */
    public Out transform2(In r5) {
        Threads.checkMainThread();
        this.mInput = r5;
        this.mOutput = new Out();
        SurfaceEdge r0 = r5.getSurfaceEdge();
        Iterator<OutConfig> r6 = r5.getOutConfigs().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        OutConfig r1 = r6.next();
        this.mOutput.put(r1, transformSingleOutput(r0, r1));
        goto L4
    L6:
        sendSurfaceRequest(r0);
        sendSurfaceOutputs(r0, this.mOutput);
        setUpRotationUpdates(r0, this.mOutput);
        return this.mOutput;
    }

    @Override // androidx.camera.core.processing.Node
    public /* bridge */ /* synthetic */ Out transform(In r1) {
        return transform2(r1);
    }

    public SurfaceProcessorNode(CameraInternal r1, SurfaceProcessorInternal r2) {
        this.mCameraInternal = r1;
        this.mSurfaceProcessor = r2;
    }

    private void createAndSendSurfaceOutput(SurfaceEdge r7, Map.Entry<OutConfig, SurfaceEdge> r8) {
        final SurfaceEdge r0 = r8.getValue();
        Size r1 = r7.getStreamSpec().getResolution();
        Rect r2 = r8.getKey().getCropRect();
        if (r7.hasCameraTransform() == false) goto L5;
        CameraInternal r9 = this.mCameraInternal;
    L6:
        Futures.addCallback(r0.createSurfaceOutputFuture(r8.getKey().getFormat(), SurfaceOutput.CameraInputInfo.of(r1, r2, r9, r8.getKey().getRotationDegrees(), r8.getKey().isMirroring()), null), new AnonymousClass1(this, r0), CameraXExecutors.mainThreadExecutor());
        return;
    L5:
        r9 = null;
        goto L6
    }

    private /* synthetic */ void lambda$sendSurfaceOutputs$0(SurfaceEdge r1, Map.Entry r2) {
        createAndSendSurfaceOutput(r1, r2);
    }

    private static /* synthetic */ void lambda$setUpRotationUpdates$1(Map r3, SurfaceRequest.TransformationInfo r4) {
        Iterator r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) r5.next();
        int r1 = r4.getRotationDegrees() - ((OutConfig) r0.getKey()).getRotationDegrees();
        if (((OutConfig) r0.getKey()).isMirroring() == false) goto L8;
        r1 = -r1;
    L8:
        int r2 = TransformUtils.within360(r1);
        ((SurfaceEdge) r0.getValue()).updateTransformation(r2, -1);
        goto L4
    }

    private void sendSurfaceOutputs(final SurfaceEdge r4, Map<OutConfig, SurfaceEdge> r5) {
        Iterator<Map.Entry<OutConfig, SurfaceEdge>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        final Map.Entry<OutConfig, SurfaceEdge> r0 = r6.next();
        createAndSendSurfaceOutput(r4, r0);
        r0.getValue().addOnInvalidatedListener(new f0(this, r4, r0));
        goto L4
    }

    private SurfaceEdge transformSingleOutput(SurfaceEdge r14, OutConfig r15) {
        Rect r0 = r15.getCropRect();
        int r1 = r15.getRotationDegrees();
        boolean r2 = r15.isMirroring();
        Matrix r7 = new Matrix(r14.getSensorToBufferTransform());
        Matrix r3 = TransformUtils.getRectToRect(new RectF(r0), TransformUtils.sizeToRectF(r15.getSize()), r1, r2);
        r7.postConcat(r3);
        Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.getRotatedSize(r0, r1), r15.getSize()));
        if (r15.shouldRespectInputCropRect() == false) goto L5;
        Preconditions.checkArgument(r15.getCropRect().contains(r14.getCropRect()), String.format("Output crop rect %s must contain input crop rect %s", new Object[]{r15.getCropRect(), r14.getCropRect()}));
        Rect r4 = new Rect();
        RectF r6 = new RectF(r14.getCropRect());
        r3.mapRect(r6);
        r6.round(r4);
    L6:
        Rect r9 = r4;
        StreamSpec r8 = r14.getStreamSpec().toBuilder().setResolution(r15.getSize()).build();
        int r10 = r15.getTargets();
        int r16 = r15.getFormat();
        int r5 = r14.getRotationDegrees() - r1;
        if (r14.isMirroring() == r2) goto L9;
        boolean r12 = true;
    L11:
        return new SurfaceEdge(r10, r16, r8, r7, false, r9, r5, -1, r12);
    L9:
        r12 = false;
        goto L11
    L5:
        r4 = TransformUtils.sizeToRect(r15.getSize());
        goto L6
    }

    public void setUpRotationUpdates(SurfaceEdge r2, final Map<OutConfig, SurfaceEdge> r3) {
        r2.addTransformationUpdateListener(new e0(r3));
    }
}
