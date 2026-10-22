package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.internal.compat.workaround.CaptureFailedRetryEnabler;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class TakePictureRequest {
    private int mRemainingRetires;

    public interface RetryControl {
        void retryRequest(TakePictureRequest r1);
    }

    public static /* synthetic */ void a(TakePictureRequest r0, ImageCaptureException r1) {
        r0.lambda$onError$0(r1);
    }

    public static /* synthetic */ void b(TakePictureRequest r0, int r1) {
        r0.lambda$onCaptureProcessProgressed$3(r1);
    }

    public static /* synthetic */ void c(TakePictureRequest r0, Bitmap r1) {
        r0.lambda$onPostviewBitmapAvailable$4(r1);
    }

    public static /* synthetic */ void d(TakePictureRequest r0, ImageCapture.OutputFileResults r1) {
        r0.lambda$onResult$1(r1);
    }

    public static /* synthetic */ void e(TakePictureRequest r0, ImageProxy r1) {
        r0.lambda$onResult$2(r1);
    }

    public abstract Executor getAppExecutor();

    public abstract int getCaptureMode();

    public abstract Rect getCropRect();

    public abstract ImageCapture.OnImageCapturedCallback getInMemoryCallback();

    public abstract int getJpegQuality();

    public abstract ImageCapture.OnImageSavedCallback getOnDiskCallback();

    public abstract ImageCapture.OutputFileOptions getOutputFileOptions();

    public abstract int getRotationDegrees();

    public abstract Matrix getSensorToBufferTransform();

    public abstract List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks();

    public TakePictureRequest() {
        this.mRemainingRetires = new CaptureFailedRetryEnabler().getRetryCount();
    }

    public boolean decrementRetryCounter() {
        Threads.checkMainThread();
        int r0 = this.mRemainingRetires;
        if (r0 <= 0) goto L6;
        this.mRemainingRetires = r0 - 1;
        return true;
    L6:
        return false;
    }

    public int getRemainingRetries() {
        Threads.checkMainThread();
        return this.mRemainingRetires;
    }

    public void incrementRetryCounter() {
        Threads.checkMainThread();
        this.mRemainingRetires++;
    }

    private /* synthetic */ void lambda$onCaptureProcessProgressed$3(int r2) {
        if (getOnDiskCallback() == null) goto L6;
        getOnDiskCallback().onCaptureProcessProgressed(r2);
        return;
    L6:
        if (getInMemoryCallback() == null) goto L10;
        getInMemoryCallback().onCaptureProcessProgressed(r2);
        return;
    }

    private /* synthetic */ void lambda$onError$0(ImageCaptureException r5) {
        boolean r1 = true;
        if (getInMemoryCallback() == null) goto L5;
        boolean r0 = true;
    L7:
        if (getOnDiskCallback() != null) goto L10;
        r1 = false;
    L10:
        if (r0 == false) goto L13;
        if (r1 == true) goto L13;
        ImageCapture.OnImageCapturedCallback r2 = getInMemoryCallback();
        Objects.requireNonNull(r2);
        r2.onError(r5);
        return;
    L13:
        if (r1 == false) goto L18;
        if (r0 == true) goto L18;
        ImageCapture.OnImageSavedCallback r3 = getOnDiskCallback();
        Objects.requireNonNull(r3);
        r3.onError(r5);
        return;
    L18:
        throw new IllegalStateException("One and only one callback is allowed.");
    L5:
        r0 = false;
        goto L7
    }

    private /* synthetic */ void lambda$onPostviewBitmapAvailable$4(Bitmap r2) {
        if (getOnDiskCallback() == null) goto L6;
        getOnDiskCallback().onPostviewBitmapAvailable(r2);
        return;
    L6:
        if (getInMemoryCallback() == null) goto L10;
        getInMemoryCallback().onPostviewBitmapAvailable(r2);
        return;
    }

    private /* synthetic */ void lambda$onResult$1(ImageCapture.OutputFileResults r3) {
        ImageCapture.OnImageSavedCallback r0 = getOnDiskCallback();
        Objects.requireNonNull(r0);
        Objects.requireNonNull(r3);
        r0.onImageSaved(r3);
    }

    private /* synthetic */ void lambda$onResult$2(ImageProxy r3) {
        ImageCapture.OnImageCapturedCallback r0 = getInMemoryCallback();
        Objects.requireNonNull(r0);
        Objects.requireNonNull(r3);
        r0.onCaptureSuccess(r3);
    }

    public void onCaptureProcessProgressed(final int r3) {
        getAppExecutor().execute(new x(this, r3));
    }

    public void onError(final ImageCaptureException r3) {
        getAppExecutor().execute(new a0(this, r3));
    }

    public void onPostviewBitmapAvailable(final Bitmap r3) {
        getAppExecutor().execute(new y(this, r3));
    }

    public void onResult(final ImageCapture.OutputFileResults r3) {
        getAppExecutor().execute(new z(this, r3));
    }

    public void onResult(final ImageProxy r3) {
        getAppExecutor().execute(new b0(this, r3));
    }

    public static TakePictureRequest of(Executor r12, ImageCapture.OnImageCapturedCallback r13, ImageCapture.OnImageSavedCallback r14, ImageCapture.OutputFileOptions r15, Rect r16, Matrix r17, int r18, int r19, int r20, List<CameraCaptureCallback> r21) {
        boolean r0 = true;
        if (r14 != null) goto L5;
        boolean r2 = true;
    L6:
        if (r15 != null) goto L8;
        boolean r3 = true;
    L9:
        if (r2 != r3) goto L11;
        boolean r4 = true;
    L12:
        Preconditions.checkArgument(r4, "onDiskCallback and outputFileOptions should be both null or both non-null.");
        if (r14 != null) goto L15;
        boolean r5 = true;
    L16:
        if (r13 == null) goto L19;
        r0 = false;
    L19:
        Preconditions.checkArgument(r0 ^ r5, "One and only one on-disk or in-memory callback should be present.");
        return new AutoValue_TakePictureRequest(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    L15:
        r5 = false;
        goto L16
    L11:
        r4 = false;
        goto L12
    L8:
        r3 = false;
        goto L9
    L5:
        r2 = false;
        goto L6
    }
}
