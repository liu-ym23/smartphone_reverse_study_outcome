package androidx.camera.core.processing.concurrent;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.processing.ShaderProvider;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.util.GLUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class DualSurfaceProcessor implements SurfaceProcessorInternal, SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "DualSurfaceProcessor";
    private final Executor mGlExecutor;
    final Handler mGlHandler;
    private final DualOpenGlRenderer mGlRenderer;
    final HandlerThread mGlThread;
    private int mInputSurfaceCount;
    private final AtomicBoolean mIsReleaseRequested;
    private boolean mIsReleased;
    final Map<SurfaceOutput, Surface> mOutputSurfaces;
    private SurfaceTexture mPrimarySurfaceTexture;
    private SurfaceTexture mSecondarySurfaceTexture;

    public static class Factory {
        private static Function3<DynamicRange, LayoutSettings, LayoutSettings, SurfaceProcessorInternal> sSupplier;

        static {
            sSupplier = new j();
        }

        private Factory() {
        }

        public static void setSupplier(Function3<DynamicRange, LayoutSettings, LayoutSettings, SurfaceProcessorInternal> r0) {
            sSupplier = r0;
        }

        public static SurfaceProcessorInternal newInstance(DynamicRange r1, LayoutSettings r2, LayoutSettings r3) {
            return (SurfaceProcessorInternal) sSupplier.invoke(r1, r2, r3);
        }
    }

    public static /* synthetic */ void a(DualSurfaceProcessor r0) {
        r0.lambda$release$4();
    }

    public static /* synthetic */ void b() {
        lambda$executeSafely$7();
    }

    public static /* synthetic */ void c(DualSurfaceProcessor r0, DynamicRange r1, Map r2, CallbackToFutureAdapter.Completer r3) {
        r0.lambda$initGlRenderer$5(r1, r2, r3);
    }

    public static /* synthetic */ void d(DualSurfaceProcessor r0, Runnable r1, Runnable r2) {
        r0.lambda$executeSafely$8(r1, r2);
    }

    public static /* synthetic */ Object e(DualSurfaceProcessor r0, DynamicRange r1, Map r2, CallbackToFutureAdapter.Completer r3) {
        return r0.lambda$initGlRenderer$6(r1, r2, r3);
    }

    public static /* synthetic */ void g(DualSurfaceProcessor r0, SurfaceOutput r1, SurfaceOutput.Event r2) {
        r0.lambda$onOutputSurface$2(r1, r2);
    }

    public static /* synthetic */ void i(DualSurfaceProcessor r0, SurfaceOutput r1) {
        r0.lambda$onOutputSurface$3(r1);
    }

    public static /* synthetic */ void j(DualSurfaceProcessor r0, SurfaceTexture r1, Surface r2, SurfaceRequest.Result r3) {
        r0.lambda$onInputSurface$0(r1, r2, r3);
    }

    public static /* synthetic */ void k(DualSurfaceProcessor r0, SurfaceRequest r1) {
        r0.lambda$onInputSurface$1(r1);
    }

    private static /* synthetic */ void lambda$executeSafely$7() {
    }

    private /* synthetic */ void lambda$release$4() {
        this.mIsReleased = true;
        checkReadyToRelease();
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public final /* synthetic */ ListenableFuture snapshot(int r1, int r2) {
        return SurfaceProcessorInternal.CC.$default$snapshot(this, r1, r2);
    }

    private void checkReadyToRelease() {
        if (this.mIsReleased == true) goto L5;
        return;
    L5:
        if (this.mInputSurfaceCount != 0) goto L14;
        Iterator<SurfaceOutput> r0 = this.mOutputSurfaces.keySet().iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        r0.next().close();
        goto L8
    L10:
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
        executeSafely(new b(this));
    }

    private void executeSafely(Runnable r2) {
        executeSafely(r2, new h());
    }

    private /* synthetic */ void lambda$onInputSurface$1(SurfaceRequest r5) {
        this.mInputSurfaceCount++;
        final SurfaceTexture r0 = new SurfaceTexture(this.mGlRenderer.getTextureName(r5.isPrimary()));
        r0.setDefaultBufferSize(r5.getResolution().getWidth(), r5.getResolution().getHeight());
        final Surface r1 = new Surface(r0);
        r5.provideSurface(r1, this.mGlExecutor, new e(this, r0, r1));
        if (r5.isPrimary() == false) goto L5;
        this.mPrimarySurfaceTexture = r0;
        return;
    L5:
        this.mSecondarySurfaceTexture = r0;
        r0.setOnFrameAvailableListener(this, this.mGlHandler);
    }

    private /* synthetic */ void lambda$onOutputSurface$3(final SurfaceOutput r3) {
        Surface r0 = r3.getSurface(this.mGlExecutor, new c(this, r3));
        this.mGlRenderer.registerOutputSurface(r0);
        this.mOutputSurfaces.put(r3, r0);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture r11) {
        if (this.mIsReleaseRequested.get() == false) goto L5;
        return;
    L5:
        SurfaceTexture r0 = this.mPrimarySurfaceTexture;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.mSecondarySurfaceTexture == null) goto L27;
        r0.updateTexImage();
        this.mSecondarySurfaceTexture.updateTexImage();
        Iterator<Map.Entry<SurfaceOutput, Surface>> r1 = this.mOutputSurfaces.entrySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L28;
        Map.Entry<SurfaceOutput, Surface> r2 = r1.next();
        Surface r6 = r2.getValue();
        SurfaceOutput r7 = r2.getKey();
        if (r7.getFormat() != 34) goto L12;
        this.mGlRenderer.render(r11.getTimestamp(), r6, r7, this.mPrimarySurfaceTexture, this.mSecondarySurfaceTexture);     // Catch: RuntimeException -> L17
    L17:
        e = move-exception;
        Logger.e(TAG, "Failed to render with OpenGL.", e);
        goto L12
    L28:
        return;
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onInputSurface(final SurfaceRequest r3) throws ProcessingException {
        if (this.mIsReleaseRequested.get() == false) goto L6;
        r3.willNotProvideSurface();
        return;
    L6:
        Runnable r0 = new f(this, r3);
        Objects.requireNonNull(r3);
        executeSafely(r0, new androidx.camera.core.processing.k(r3));
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onOutputSurface(final SurfaceOutput r3) throws ProcessingException {
        if (this.mIsReleaseRequested.get() == false) goto L6;
        r3.close();
        return;
    L6:
        Runnable r0 = new d(this, r3);
        Objects.requireNonNull(r3);
        executeSafely(r0, new androidx.camera.core.processing.h(r3));
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
        CallbackToFutureAdapter.getFuture(new g(this, r2, r3)).get();     // Catch: Throwable -> L5 ExecutionException -> L7
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

    private /* synthetic */ void lambda$executeSafely$8(Runnable r2, Runnable r3) {
        if (this.mIsReleased == false) goto L5;
        r2.run();
        return;
    L5:
        r3.run();
    }

    private /* synthetic */ void lambda$onOutputSurface$2(SurfaceOutput r1, SurfaceOutput.Event r2) {
        r1.close();
        Surface r3 = this.mOutputSurfaces.remove(r1);
        if (r3 == null) goto L6;
        this.mGlRenderer.unregisterOutputSurface(r3);
        return;
    }

    public DualSurfaceProcessor(DynamicRange r2, LayoutSettings r3, LayoutSettings r4) {
        this(r2, Collections.emptyMap(), r3, r4);
    }

    private /* synthetic */ void lambda$initGlRenderer$5(DynamicRange r2, Map r3, CallbackToFutureAdapter.Completer r4) {
        this.mGlRenderer.init(r2, r3);     // Catch: RuntimeException -> L4
        r4.set(null);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        r4.setException(e);
    }

    private /* synthetic */ Object lambda$initGlRenderer$6(final DynamicRange r2, final Map r3, final CallbackToFutureAdapter.Completer r4) throws Exception {
        executeSafely(new a(this, r2, r3, r4));
        return "Init GlRenderer";
    }

    private /* synthetic */ void lambda$onInputSurface$0(SurfaceTexture r1, Surface r2, SurfaceRequest.Result r3) {
        r1.setOnFrameAvailableListener(null);
        r1.release();
        r2.release();
        this.mInputSurfaceCount--;
        checkReadyToRelease();
    }

    public DualSurfaceProcessor(DynamicRange r3, Map<GLUtils.InputFormat, ShaderProvider> r4, LayoutSettings r5, LayoutSettings r6) {
        this.mInputSurfaceCount = 0;
        this.mIsReleased = false;
        this.mIsReleaseRequested = new AtomicBoolean(false);
        this.mOutputSurfaces = new LinkedHashMap();
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("GL Thread");
        this.mGlThread = r0;
        ThreadMethodProxy.start(r0);
        Handler r1 = new Handler(r0.getLooper());
        this.mGlHandler = r1;
        this.mGlExecutor = CameraXExecutors.newHandlerExecutor(r1);
        this.mGlRenderer = new DualOpenGlRenderer(r5, r6);
        initGlRenderer(r3, r4);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        release();
        throw e;
    }
}
