package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.arch.core.util.Function;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.util.GLUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class DefaultSurfaceProcessor implements SurfaceProcessorInternal, SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "DefaultSurfaceProcessor";
    private final Executor mGlExecutor;
    final Handler mGlHandler;
    private final OpenGlRenderer mGlRenderer;
    final HandlerThread mGlThread;
    private int mInputSurfaceCount;
    private final AtomicBoolean mIsReleaseRequested;
    private boolean mIsReleased;
    final Map<SurfaceOutput, Surface> mOutputSurfaces;
    private final List<PendingSnapshot> mPendingSnapshots;
    private final float[] mSurfaceOutputMatrix;
    private final float[] mTextureMatrix;

    public static class Factory {
        private static Function<DynamicRange, SurfaceProcessorInternal> sSupplier;

        static {
            sSupplier = new p();
        }

        private Factory() {
        }

        public static SurfaceProcessorInternal newInstance(DynamicRange r1) {
            return sSupplier.apply(r1);
        }

        public static void setSupplier(Function<DynamicRange, SurfaceProcessorInternal> r0) {
            sSupplier = r0;
        }
    }

    public static abstract class PendingSnapshot {
        public PendingSnapshot() {
        }

        public abstract CallbackToFutureAdapter.Completer<Void> getCompleter();

        public abstract int getJpegQuality();

        public abstract int getRotationDegrees();

        public static AutoValue_DefaultSurfaceProcessor_PendingSnapshot of(int r1, int r2, CallbackToFutureAdapter.Completer<Void> r3) {
            return new AutoValue_DefaultSurfaceProcessor_PendingSnapshot(r1, r2, r3);
        }
    }

    public static /* synthetic */ void a(DefaultSurfaceProcessor r0, SurfaceOutput r1) {
        r0.lambda$onOutputSurface$4(r1);
    }

    public static /* synthetic */ void b(DefaultSurfaceProcessor r0) {
        r0.lambda$release$5();
    }

    public static /* synthetic */ void c(DefaultSurfaceProcessor r0, SurfaceOutput r1, SurfaceOutput.Event r2) {
        r0.lambda$onOutputSurface$3(r1, r2);
    }

    public static /* synthetic */ void d(DefaultSurfaceProcessor r0, DynamicRange r1, Map r2, CallbackToFutureAdapter.Completer r3) {
        r0.lambda$initGlRenderer$9(r1, r2, r3);
    }

    public static /* synthetic */ Object e(DefaultSurfaceProcessor r0, int r1, int r2, CallbackToFutureAdapter.Completer r3) {
        return r0.lambda$snapshot$8(r1, r2, r3);
    }

    public static /* synthetic */ Object g(DefaultSurfaceProcessor r0, DynamicRange r1, Map r2, CallbackToFutureAdapter.Completer r3) {
        return r0.lambda$initGlRenderer$10(r1, r2, r3);
    }

    public static /* synthetic */ void i() {
        lambda$executeSafely$11();
    }

    public static /* synthetic */ void j(DefaultSurfaceProcessor r0, PendingSnapshot r1) {
        r0.lambda$snapshot$6(r1);
    }

    public static /* synthetic */ void k(DefaultSurfaceProcessor r0, SurfaceRequest r1, SurfaceTexture r2, Surface r3, SurfaceRequest.Result r4) {
        r0.lambda$onInputSurface$1(r1, r2, r3, r4);
    }

    public static /* synthetic */ void l(CallbackToFutureAdapter.Completer r0) {
        lambda$snapshot$7(r0);
    }

    private static /* synthetic */ void lambda$executeSafely$11() {
    }

    private /* synthetic */ void lambda$release$5() {
        this.mIsReleased = true;
        checkReadyToRelease();
    }

    public static /* synthetic */ void n(DefaultSurfaceProcessor r0, Runnable r1, Runnable r2) {
        r0.lambda$executeSafely$12(r1, r2);
    }

    public static /* synthetic */ void o(DefaultSurfaceProcessor r0, SurfaceRequest r1, SurfaceRequest.TransformationInfo r2) {
        r0.lambda$onInputSurface$0(r1, r2);
    }

    public static /* synthetic */ void p(DefaultSurfaceProcessor r0, SurfaceRequest r1) {
        r0.lambda$onInputSurface$2(r1);
    }

    private void checkReadyToRelease() {
        if (this.mIsReleased == true) goto L5;
        return;
    L5:
        if (this.mInputSurfaceCount != 0) goto L19;
        Iterator<SurfaceOutput> r0 = this.mOutputSurfaces.keySet().iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        r0.next().close();
        goto L8
    L10:
        Iterator<PendingSnapshot> r1 = this.mPendingSnapshots.iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        r1.next().getCompleter().setException(new Exception("Failed to snapshot: DefaultSurfaceProcessor is released."));
        goto L12
    L14:
        this.mOutputSurfaces.clear();
        this.mGlRenderer.release();
        this.mGlThread.quit();
        return;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public void release() {
        if (this.mIsReleaseRequested.getAndSet(true) == false) goto L5;
        return;
    L5:
        executeSafely(new n(this));
    }

    public DefaultSurfaceProcessor(DynamicRange r2) {
        this(r2, Collections.emptyMap());
    }

    private void executeSafely(Runnable r2) {
        executeSafely(r2, new o());
    }

    private void failAllPendingSnapshots(Throwable r3) {
        Iterator<PendingSnapshot> r0 = this.mPendingSnapshots.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getCompleter().setException(r3);
        goto L4
    L6:
        this.mPendingSnapshots.clear();
    }

    private /* synthetic */ void lambda$onInputSurface$2(final SurfaceRequest r5) {
        this.mInputSurfaceCount++;
        final SurfaceTexture r0 = new SurfaceTexture(this.mGlRenderer.getTextureName());
        r0.setDefaultBufferSize(r5.getResolution().getWidth(), r5.getResolution().getHeight());
        final Surface r1 = new Surface(r0);
        r5.setTransformationInfoListener(this.mGlExecutor, new b(this, r5));
        r5.provideSurface(r1, this.mGlExecutor, new c(this, r5, r0, r1));
        r0.setOnFrameAvailableListener(this, this.mGlHandler);
    }

    private /* synthetic */ void lambda$onOutputSurface$4(final SurfaceOutput r3) {
        Surface r0 = r3.getSurface(this.mGlExecutor, new d(this, r3));
        this.mGlRenderer.registerOutputSurface(r0);
        this.mOutputSurfaces.put(r3, r0);
    }

    private /* synthetic */ void lambda$snapshot$6(PendingSnapshot r2) {
        this.mPendingSnapshots.add(r2);
    }

    private static /* synthetic */ void lambda$snapshot$7(CallbackToFutureAdapter.Completer r2) {
        r2.setException(new Exception("Failed to snapshot: OpenGLRenderer not ready."));
    }

    private void takeSnapshotAndDrawJpeg(Triple<Surface, Size, float[]> r12) {
        if (this.mPendingSnapshots.isEmpty() == false) goto L5;
        return;
    L5:
        if (r12 != null) goto L35;
        failAllPendingSnapshots(new Exception("Failed to snapshot: no JPEG Surface."));
        return;
    L35:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: IOException -> L32
        Iterator<PendingSnapshot> r1 = this.mPendingSnapshots.iterator();     // Catch: Throwable -> L26
        Bitmap r5 = null;
        byte[] r7 = null;
        int r4 = -1;
        int r6 = -1;
    L10:
        if (r1.hasNext() == false) goto L24;
        PendingSnapshot r8 = r1.next();     // Catch: Throwable -> L26
        if (r4 != r8.getRotationDegrees()) goto L15;
        if (r5 == null) goto L15;
    L20:
        if (r6 == r8.getJpegQuality()) goto L22;
        r0.reset();     // Catch: Throwable -> L26
        r6 = r8.getJpegQuality();     // Catch: Throwable -> L26
        r5.compress(Bitmap.CompressFormat.JPEG, r6, r0);     // Catch: Throwable -> L26
        r7 = r0.toByteArray();     // Catch: Throwable -> L26
    L22:
        Surface r9 = (Surface) r12.getFirst();     // Catch: Throwable -> L26
        Objects.requireNonNull(r7);     // Catch: Throwable -> L26
        ImageProcessingUtil.writeJpegBytesToSurface(r9, r7);     // Catch: Throwable -> L26
        r8.getCompleter().set(null);     // Catch: Throwable -> L26
        r1.remove();     // Catch: Throwable -> L26
    L15:
        r4 = r8.getRotationDegrees();     // Catch: Throwable -> L26
        if (r5 == null) goto L18;
        r5.recycle();     // Catch: Throwable -> L26
    L18:
        r5 = getBitmap((Size) r12.getSecond(), (float[]) r12.getThird(), r4);     // Catch: Throwable -> L26
        r6 = -1;
        goto L20
    L24:
        r0.close();     // Catch: IOException -> L32
        return;
    L26:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: IOException -> L32
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L32
    L32:
        e = move-exception;
        failAllPendingSnapshots(e);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture r10) {
        if (this.mIsReleaseRequested.get() == false) goto L5;
        return;
    L5:
        r10.updateTexImage();
        r10.getTransformMatrix(this.mTextureMatrix);
        Iterator<Map.Entry<SurfaceOutput, Surface>> r0 = this.mOutputSurfaces.entrySet().iterator();
        Triple<Surface, Size, float[]> r1 = null;
    L7:
        if (r0.hasNext() == false) goto L30;
        Map.Entry<SurfaceOutput, Surface> r2 = r0.next();
        Surface r3 = r2.getValue();
        SurfaceOutput r4 = r2.getKey();
        r4.updateTransformMatrix(this.mSurfaceOutputMatrix, this.mTextureMatrix);
        if (r4.getFormat() != 34) goto L14;
        this.mGlRenderer.render(r10.getTimestamp(), this.mSurfaceOutputMatrix, r3);     // Catch: RuntimeException -> L12
    L12:
        e = move-exception;
        Logger.e(TAG, "Failed to render with OpenGL.", e);
        goto L7
    L14:
        boolean r6 = true;
        if (r4.getFormat() != 256) goto L17;
        boolean r5 = true;
    L18:
        Preconditions.checkState(r5, "Unsupported format: " + r4.getFormat());
        if (r1 == null) goto L22;
        r6 = false;
    L22:
        Preconditions.checkState(r6, "Only one JPEG output is supported.");
        r1 = new Triple(r3, r4.getSize(), (float[]) this.mSurfaceOutputMatrix.clone());
        goto L7
    L17:
        r5 = false;
        goto L18
    L30:
        takeSnapshotAndDrawJpeg(r1);     // Catch: RuntimeException -> L25
        return;
    L25:
        e = move-exception;
        failAllPendingSnapshots(e);
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onInputSurface(final SurfaceRequest r3) {
        if (this.mIsReleaseRequested.get() == false) goto L6;
        r3.willNotProvideSurface();
        return;
    L6:
        Runnable r0 = new j(this, r3);
        Objects.requireNonNull(r3);
        executeSafely(r0, new k(r3));
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onOutputSurface(final SurfaceOutput r3) {
        if (this.mIsReleaseRequested.get() == false) goto L6;
        r3.close();
        return;
    L6:
        Runnable r0 = new g(this, r3);
        Objects.requireNonNull(r3);
        executeSafely(r0, new h(r3));
    }

    public DefaultSurfaceProcessor(DynamicRange r4, Map<GLUtils.InputFormat, ShaderProvider> r5) {
        this.mIsReleaseRequested = new AtomicBoolean(false);
        this.mTextureMatrix = new float[16];
        this.mSurfaceOutputMatrix = new float[16];
        this.mOutputSurfaces = new LinkedHashMap();
        this.mInputSurfaceCount = 0;
        this.mIsReleased = false;
        this.mPendingSnapshots = new ArrayList();
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("GL Thread");
        this.mGlThread = r0;
        ThreadMethodProxy.start(r0);
        Handler r1 = new Handler(r0.getLooper());
        this.mGlHandler = r1;
        this.mGlExecutor = CameraXExecutors.newHandlerExecutor(r1);
        this.mGlRenderer = new OpenGlRenderer();
        initGlRenderer(r4, r5);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        release();
        throw e;
    }

    private void executeSafely(final Runnable r3, final Runnable r4) {
        this.mGlExecutor.execute(new i(this, r4, r3));     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Logger.w(TAG, "Unable to executor runnable", e);
        r4.run();
    }

    private void initGlRenderer(final DynamicRange r2, final Map<GLUtils.InputFormat, ShaderProvider> r3) {
        CallbackToFutureAdapter.getFuture(new a(this, r2, r3)).get();     // Catch: Throwable -> L5 ExecutionException -> L7
        return;
    L5:
        e = move-exception;
        boolean r4 = e instanceof ExecutionException;
        Throwable r5 = e;
        if (r4 == false) goto L12;
        r5 = e.getCause();
    L12:
        if ((r5 instanceof RuntimeException) == false) goto L16;
        throw ((RuntimeException) r5);
    L16:
        throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", r5);
    }

    private /* synthetic */ void lambda$executeSafely$12(Runnable r2, Runnable r3) {
        if (this.mIsReleased == false) goto L5;
        r2.run();
        return;
    L5:
        r3.run();
    }

    private /* synthetic */ void lambda$onInputSurface$0(SurfaceRequest r2, SurfaceRequest.TransformationInfo r3) {
        GLUtils.InputFormat r0 = GLUtils.InputFormat.DEFAULT;
        if (r2.getDynamicRange().is10BitHdr() == true) goto L5;
    L7:
        this.mGlRenderer.setInputFormat(r0);
        return;
    L5:
        if (r3.hasCameraTransform() == false) goto L7;
        r0 = GLUtils.InputFormat.YUV;
        goto L7
    }

    private /* synthetic */ void lambda$onOutputSurface$3(SurfaceOutput r1, SurfaceOutput.Event r2) {
        r1.close();
        Surface r3 = this.mOutputSurfaces.remove(r1);
        if (r3 == null) goto L6;
        this.mGlRenderer.unregisterOutputSurface(r3);
        return;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public ListenableFuture<Void> snapshot(final int r2, final int r3) {
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new l(this, r2, r3)));
    }

    private Bitmap getBitmap(Size r3, float[] r4, int r5) {
        float[] r6 = (float[]) r4.clone();
        MatrixExt.preRotate(r6, r5, 0.5f, 0.5f);
        MatrixExt.preVerticalFlip(r6, 0.5f);
        return this.mGlRenderer.snapshot(TransformUtils.rotateSize(r3, r5), r6);
    }

    private /* synthetic */ Object lambda$initGlRenderer$10(final DynamicRange r2, final Map r3, final CallbackToFutureAdapter.Completer r4) throws Exception {
        executeSafely(new m(this, r2, r3, r4));
        return "Init GlRenderer";
    }

    private /* synthetic */ void lambda$initGlRenderer$9(DynamicRange r2, Map r3, CallbackToFutureAdapter.Completer r4) {
        this.mGlRenderer.init(r2, r3);     // Catch: RuntimeException -> L4
        r4.set(null);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        r4.setException(e);
    }

    private /* synthetic */ Object lambda$snapshot$8(int r1, int r2, final CallbackToFutureAdapter.Completer r3) throws Exception {
        final AutoValue_DefaultSurfaceProcessor_PendingSnapshot r4 = PendingSnapshot.of(r1, r2, r3);
        executeSafely(new e(this, r4), new f(r3));
        return "DefaultSurfaceProcessor#snapshot";
    }

    private /* synthetic */ void lambda$onInputSurface$1(SurfaceRequest r1, SurfaceTexture r2, Surface r3, SurfaceRequest.Result r4) {
        r1.clearTransformationInfoListener();
        r2.setOnFrameAvailableListener(null);
        r2.release();
        r3.release();
        this.mInputSurfaceCount--;
        checkReadyToRelease();
    }
}
