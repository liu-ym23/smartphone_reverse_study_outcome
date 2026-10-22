package androidx.camera.core.processing;

import androidx.camera.core.CameraEffect;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceProcessor;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Consumer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SurfaceProcessorWithExecutor implements SurfaceProcessorInternal {
    private static final String TAG = "SurfaceProcessor";
    private final Consumer<Throwable> mErrorListener;
    private final Executor mExecutor;
    private final SurfaceProcessor mSurfaceProcessor;

    public static /* synthetic */ void a(SurfaceProcessorWithExecutor r0, SurfaceRequest r1) {
        r0.lambda$onInputSurface$0(r1);
    }

    public static /* synthetic */ void b(SurfaceProcessorWithExecutor r0, SurfaceOutput r1) {
        r0.lambda$onOutputSurface$1(r1);
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public void release() {
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public SurfaceProcessor getProcessor() {
        return this.mSurfaceProcessor;
    }

    public SurfaceProcessorWithExecutor(CameraEffect r2) {
        SurfaceProcessor r0 = r2.getSurfaceProcessor();
        Objects.requireNonNull(r0);
        this.mSurfaceProcessor = r0;
        this.mExecutor = r2.getExecutor();
        this.mErrorListener = r2.getErrorListener();
    }

    private /* synthetic */ void lambda$onInputSurface$0(SurfaceRequest r3) {
        this.mSurfaceProcessor.onInputSurface(r3);     // Catch: ProcessingException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "Failed to setup SurfaceProcessor input.", e);
        this.mErrorListener.accept(e);
    }

    private /* synthetic */ void lambda$onOutputSurface$1(SurfaceOutput r3) {
        this.mSurfaceProcessor.onOutputSurface(r3);     // Catch: ProcessingException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "Failed to setup SurfaceProcessor output.", e);
        this.mErrorListener.accept(e);
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onInputSurface(final SurfaceRequest r3) {
        this.mExecutor.execute(new h0(this, r3));
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onOutputSurface(final SurfaceOutput r3) {
        this.mExecutor.execute(new i0(this, r3));
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public ListenableFuture<Void> snapshot(int r1, int r2) {
        return Futures.immediateFailedFuture(new Exception("Snapshot not supported by external SurfaceProcessor"));
    }
}
