package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.Threads;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class RequestWithCallback implements TakePictureCallback {
    private CallbackToFutureAdapter.Completer<Void> mCaptureCompleter;
    private final ListenableFuture<Void> mCaptureFuture;
    private ListenableFuture<Void> mCaptureRequestFuture;
    private CallbackToFutureAdapter.Completer<Void> mCompleteCompleter;
    private final ListenableFuture<Void> mCompleteFuture;
    private boolean mIsAborted;
    private boolean mIsStarted;
    private final TakePictureRequest.RetryControl mRetryControl;
    private final TakePictureRequest mTakePictureRequest;

    public static /* synthetic */ Object a(RequestWithCallback r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$new$1(r1);
    }

    public static /* synthetic */ Object b(RequestWithCallback r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$new$0(r1);
    }

    private void checkOnImageCaptured() {
        Preconditions.checkState(this.mCaptureFuture.isDone(), "onImageCaptured() must be called before onFinalResult()");
    }

    private void markComplete() {
        Preconditions.checkState(!this.mCompleteFuture.isDone(), "The callback can only complete once.");
        this.mCompleteCompleter.set(null);
    }

    public void abortSilentlyAndRetry() {
        Threads.checkMainThread();
        if (this.mCompleteFuture.isDone() == false) goto L5;
        return;
    L5:
        abort(new ImageCaptureException(3, "The request is aborted silently and retried.", null));
        this.mRetryControl.retryRequest(this.mTakePictureRequest);
    }

    public ListenableFuture<Void> getCaptureFuture() {
        Threads.checkMainThread();
        return this.mCaptureFuture;
    }

    public ListenableFuture<Void> getCompleteFuture() {
        Threads.checkMainThread();
        return this.mCompleteFuture;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void onCaptureStarted() {
        Threads.checkMainThread();
        if (this.mIsAborted == false) goto L5;
        return;
    L5:
        if (this.mIsStarted == true) goto L16;
        this.mIsStarted = true;
        ImageCapture.OnImageCapturedCallback r0 = this.mTakePictureRequest.getInMemoryCallback();
        if (r0 == null) goto L10;
        r0.onCaptureStarted();
    L10:
        ImageCapture.OnImageSavedCallback r1 = this.mTakePictureRequest.getOnDiskCallback();
        if (r1 == null) goto L15;
        r1.onCaptureStarted();
        return;
    L15:
        return;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void onImageCaptured() {
        Threads.checkMainThread();
        if (this.mIsAborted == false) goto L6;
        return;
    L6:
        if (this.mIsStarted == true) goto L8;
        onCaptureStarted();
    L8:
        this.mCaptureCompleter.set(null);
    }

    public TakePictureRequest getTakePictureRequest() {
        return this.mTakePictureRequest;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public boolean isAborted() {
        return this.mIsAborted;
    }

    private void abort(ImageCaptureException r3) {
        Threads.checkMainThread();
        this.mIsAborted = true;
        ListenableFuture<Void> r1 = this.mCaptureRequestFuture;
        Objects.requireNonNull(r1);
        r1.cancel(true);
        this.mCaptureCompleter.setException(r3);
        this.mCompleteCompleter.set(null);
    }

    private /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer r1) throws Exception {
        this.mCaptureCompleter = r1;
        return "CaptureCompleteFuture";
    }

    private /* synthetic */ Object lambda$new$1(CallbackToFutureAdapter.Completer r1) throws Exception {
        this.mCompleteCompleter = r1;
        return "RequestCompleteFuture";
    }

    private void onFailure(ImageCaptureException r2) {
        Threads.checkMainThread();
        this.mTakePictureRequest.onError(r2);
    }

    public void abortAndSendErrorToApp(ImageCaptureException r2) {
        Threads.checkMainThread();
        if (this.mCompleteFuture.isDone() == false) goto L5;
        return;
    L5:
        abort(r2);
        onFailure(r2);
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void onCaptureFailure(ImageCaptureException r3) {
        Threads.checkMainThread();
        if (this.mIsAborted == false) goto L5;
        return;
    L5:
        boolean r0 = this.mTakePictureRequest.decrementRetryCounter();
        if (r0 == true) goto L8;
        onFailure(r3);
    L8:
        markComplete();
        this.mCaptureCompleter.setException(r3);
        if (r0 == false) goto L12;
        this.mRetryControl.retryRequest(this.mTakePictureRequest);
        return;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void onCaptureProcessProgressed(int r2) {
        Threads.checkMainThread();
        if (this.mIsAborted == false) goto L5;
        return;
    L5:
        this.mTakePictureRequest.onCaptureProcessProgressed(r2);
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void onFinalResult(ImageProxy r2) {
        Threads.checkMainThread();
        if (this.mIsAborted == false) goto L6;
        r2.close();
        return;
    L6:
        checkOnImageCaptured();
        markComplete();
        this.mTakePictureRequest.onResult(r2);
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void onPostviewBitmapAvailable(Bitmap r2) {
        Threads.checkMainThread();
        if (this.mIsAborted == false) goto L5;
        return;
    L5:
        this.mTakePictureRequest.onPostviewBitmapAvailable(r2);
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void onProcessFailure(ImageCaptureException r2) {
        Threads.checkMainThread();
        if (this.mIsAborted == false) goto L5;
        return;
    L5:
        checkOnImageCaptured();
        markComplete();
        onFailure(r2);
    }

    public void setCaptureRequestFuture(ListenableFuture<Void> r3) {
        Threads.checkMainThread();
        if (this.mCaptureRequestFuture != null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0, "CaptureRequestFuture can only be set once.");
        this.mCaptureRequestFuture = r3;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.camera.core.imagecapture.TakePictureCallback
    public void onFinalResult(ImageCapture.OutputFileResults r2) {
        Threads.checkMainThread();
        if (this.mIsAborted == false) goto L5;
        return;
    L5:
        checkOnImageCaptured();
        markComplete();
        this.mTakePictureRequest.onResult(r2);
    }

    public RequestWithCallback(TakePictureRequest r2, TakePictureRequest.RetryControl r3) {
        this.mIsAborted = false;
        this.mIsStarted = false;
        this.mTakePictureRequest = r2;
        this.mRetryControl = r3;
        this.mCaptureFuture = CallbackToFutureAdapter.getFuture(new s(this));
        this.mCompleteFuture = CallbackToFutureAdapter.getFuture(new t(this));
    }
}
