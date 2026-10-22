package androidx.camera.core.imagecapture;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class TakePictureManager implements ForwardingImageProxy.OnImageCloseListener, TakePictureRequest.RetryControl {
    private static final String TAG = "TakePictureManager";
    private RequestWithCallback mCapturingRequest;
    final ImageCaptureControl mImageCaptureControl;
    ImagePipeline mImagePipeline;
    private final List<RequestWithCallback> mIncompleteRequests;
    final Deque<TakePictureRequest> mNewRequests;
    boolean mPaused;

    public static abstract class CaptureError {
        public CaptureError() {
        }

        public abstract ImageCaptureException getImageCaptureException();

        public abstract int getRequestId();

        public static CaptureError of(int r1, ImageCaptureException r2) {
            return new AutoValue_TakePictureManager_CaptureError(r1, r2);
        }
    }

    public static /* synthetic */ void a(TakePictureManager r0, RequestWithCallback r1) {
        r0.lambda$trackCurrentRequests$1(r1);
    }

    public static /* synthetic */ void b(TakePictureManager r0) {
        r0.lambda$trackCurrentRequests$0();
    }

    private /* synthetic */ void lambda$trackCurrentRequests$0() {
        this.mCapturingRequest = null;
        issueNextRequest();
    }

    public boolean hasCapturingRequest() {
        if (this.mCapturingRequest == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void abortRequests() {
        Threads.checkMainThread();
        ImageCaptureException r0 = new ImageCaptureException(3, "Camera is closed.", null);
        Iterator<TakePictureRequest> r1 = this.mNewRequests.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onError(r0);
        goto L4
    L6:
        this.mNewRequests.clear();
        Iterator r2 = new ArrayList(this.mIncompleteRequests).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((RequestWithCallback) r2.next()).abortAndSendErrorToApp(r0);
        goto L8
    }

    public void issueNextRequest() {
        Threads.checkMainThread();
        if (hasCapturingRequest() == false) goto L6;
        return;
    L6:
        if (this.mPaused == false) goto L9;
        return;
    L9:
        if (this.mImagePipeline.getCapacity() != 0) goto L11;
        return;
    L11:
        TakePictureRequest r0 = this.mNewRequests.poll();
        if (r0 != null) goto L14;
        return;
    L14:
        RequestWithCallback r1 = new RequestWithCallback(r0, this);
        trackCurrentRequests(r1);
        Pair<CameraRequest, ProcessingRequest> r2 = this.mImagePipeline.createRequests(r0, r1, r1.getCaptureFuture());
        CameraRequest r3 = (CameraRequest) r2.first;
        Objects.requireNonNull(r3);
        ProcessingRequest r4 = (ProcessingRequest) r2.second;
        Objects.requireNonNull(r4);
        this.mImagePipeline.submitProcessingRequest(r4);
        r1.setCaptureRequestFuture(submitCameraRequest(r3));
    }

    public void pause() {
        Threads.checkMainThread();
        this.mPaused = true;
        RequestWithCallback r0 = this.mCapturingRequest;
        if (r0 == null) goto L6;
        r0.abortSilentlyAndRetry();
        return;
    }

    public void resume() {
        Threads.checkMainThread();
        this.mPaused = false;
        issueNextRequest();
    }

    public RequestWithCallback getCapturingRequest() {
        return this.mCapturingRequest;
    }

    public ImagePipeline getImagePipeline() {
        return this.mImagePipeline;
    }

    public List<RequestWithCallback> getIncompleteRequests() {
        return this.mIncompleteRequests;
    }

    public TakePictureManager(ImageCaptureControl r2) {
        this.mNewRequests = new ArrayDeque();
        this.mPaused = false;
        Threads.checkMainThread();
        this.mImageCaptureControl = r2;
        this.mIncompleteRequests = new ArrayList();
    }

    private /* synthetic */ void lambda$trackCurrentRequests$1(RequestWithCallback r2) {
        this.mIncompleteRequests.remove(r2);
    }

    private ListenableFuture<Void> submitCameraRequest(final CameraRequest r3) {
        Threads.checkMainThread();
        this.mImageCaptureControl.lockFlashMode();
        ListenableFuture<Void> r0 = this.mImageCaptureControl.submitStillCaptureRequests(r3.getCaptureConfigs());
        Futures.addCallback(r0, new AnonymousClass1(this, r3), CameraXExecutors.mainThreadExecutor());
        return r0;
    }

    private void trackCurrentRequests(final RequestWithCallback r4) {
        Preconditions.checkState(!hasCapturingRequest());
        this.mCapturingRequest = r4;
        r4.getCaptureFuture().addListener(new u(this), CameraXExecutors.directExecutor());
        this.mIncompleteRequests.add(r4);
        r4.getCompleteFuture().addListener(new v(this, r4), CameraXExecutors.directExecutor());
    }

    public void offerRequest(TakePictureRequest r2) {
        Threads.checkMainThread();
        this.mNewRequests.offer(r2);
        issueNextRequest();
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public void onImageClose(ImageProxy r2) {
        CameraXExecutors.mainThreadExecutor().execute(new w(this));
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest.RetryControl
    public void retryRequest(TakePictureRequest r3) {
        Threads.checkMainThread();
        Logger.d(TAG, "Add a new request for retrying.");
        this.mNewRequests.addFirst(r3);
        issueNextRequest();
    }

    public void setImagePipeline(ImagePipeline r1) {
        Threads.checkMainThread();
        this.mImagePipeline = r1;
        r1.setOnImageCloseListener(this);
    }
}
