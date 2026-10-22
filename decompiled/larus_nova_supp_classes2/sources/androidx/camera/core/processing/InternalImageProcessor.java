package androidx.camera.core.processing;

import androidx.camera.core.CameraEffect;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessor;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class InternalImageProcessor {
    private final Consumer<Throwable> mErrorListener;
    private final Executor mExecutor;
    private final ImageProcessor mImageProcessor;

    public static /* synthetic */ void a(InternalImageProcessor r0, ImageProcessor.Request r1, CallbackToFutureAdapter.Completer r2) {
        r0.lambda$safeProcess$0(r1, r2);
    }

    public static /* synthetic */ Object b(InternalImageProcessor r0, ImageProcessor.Request r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$safeProcess$1(r1, r2);
    }

    public InternalImageProcessor(CameraEffect r3) {
        if (r3.getTargets() != 4) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        this.mExecutor = r3.getExecutor();
        ImageProcessor r1 = r3.getImageProcessor();
        Objects.requireNonNull(r1);
        this.mImageProcessor = r1;
        this.mErrorListener = r3.getErrorListener();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public ImageProcessor.Response safeProcess(final ImageProcessor.Request r4) throws ImageCaptureException {
        return (ImageProcessor.Response) CallbackToFutureAdapter.getFuture(new r(this, r4)).get();
    L4:
        e = move-exception;
        Throwable r0 = e.getCause();
        Exception r5 = e;
        if (r0 == null) goto L9;
        r5 = e.getCause();
    L9:
        throw new ImageCaptureException(0, "Failed to invoke ImageProcessor.", r5);
    }

    private /* synthetic */ void lambda$safeProcess$0(ImageProcessor.Request r2, CallbackToFutureAdapter.Completer r3) {
        r3.set(this.mImageProcessor.process(r2));
        return;
    L5:
        e = move-exception;
        this.mErrorListener.accept(e);
        r3.setException(e);
    }

    private /* synthetic */ Object lambda$safeProcess$1(final ImageProcessor.Request r3, final CallbackToFutureAdapter.Completer r4) throws Exception {
        this.mExecutor.execute(new q(this, r3, r4));
        return "InternalImageProcessor#process " + r3.hashCode();
    }
}
