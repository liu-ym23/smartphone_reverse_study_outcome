package androidx.camera.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Size;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class SurfaceViewImplementation extends PreviewViewImplementation {
    private static final int SCREENSHOT_TIMEOUT_MILLIS = 100;
    private static final String TAG = "SurfaceViewImpl";
    final SurfaceRequestCallback mSurfaceRequestCallback;
    SurfaceView mSurfaceView;

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void pixelCopyRequest(SurfaceView r0, Bitmap r1, PixelCopy.OnPixelCopyFinishedListener r2, Handler r3) {
            PixelCopy.request(r0, r1, r2, r3);
        }
    }

    public class SurfaceRequestCallback implements SurfaceHolder.Callback {
        private Size mCurrentSurfaceSize;
        private boolean mNeedToInvalidate;
        private PreviewViewImplementation.OnSurfaceNotInUseListener mOnSurfaceNotInUseListener;
        private SurfaceRequest mSurfaceRequest;
        private SurfaceRequest mSurfaceRequestToBeInvalidated;
        private Size mTargetSize;
        private boolean mWasSurfaceProvided;
        final /* synthetic */ SurfaceViewImplementation this$0;

        public static /* synthetic */ void a(PreviewViewImplementation.OnSurfaceNotInUseListener r0, SurfaceRequest.Result r1) {
            lambda$tryToComplete$0(r0, r1);
        }

        private boolean canProvideSurface() {
            if (this.mWasSurfaceProvided == false) goto L5;
        L9:
            return false;
        L5:
            if (this.mSurfaceRequest == null) goto L9;
            if (Objects.equals(this.mTargetSize, this.mCurrentSurfaceSize) == false) goto L9;
            return true;
        }

        private void cancelPreviousRequest() {
            if (this.mSurfaceRequest == null) goto L6;
            Logger.d(SurfaceViewImplementation.TAG, "Request canceled: " + this.mSurfaceRequest);
            this.mSurfaceRequest.willNotProvideSurface();
            return;
        }

        private void closeSurface() {
            if (this.mSurfaceRequest == null) goto L6;
            Logger.d(SurfaceViewImplementation.TAG, "Surface closed " + this.mSurfaceRequest);
            this.mSurfaceRequest.getDeferrableSurface().close();
            return;
        }

        private boolean tryToComplete() {
            Surface r0 = this.this$0.mSurfaceView.getHolder().getSurface();
            if (canProvideSurface() == false) goto L6;
            Logger.d(SurfaceViewImplementation.TAG, "Surface set on Preview.");
            final PreviewViewImplementation.OnSurfaceNotInUseListener r1 = this.mOnSurfaceNotInUseListener;
            SurfaceRequest r2 = this.mSurfaceRequest;
            Objects.requireNonNull(r2);
            r2.provideSurface(r0, ContextCompat.getMainExecutor(this.this$0.mSurfaceView.getContext()), new a0(r1));
            this.mWasSurfaceProvided = true;
            this.this$0.onSurfaceProvided();
            return true;
        L6:
            return false;
        }

        public SurfaceRequestCallback(SurfaceViewImplementation r1) {
            this.this$0 = r1;
            this.mWasSurfaceProvided = false;
            this.mNeedToInvalidate = false;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder r2) {
            Logger.d(SurfaceViewImplementation.TAG, "Surface created.");
            if (this.mNeedToInvalidate == false) goto L8;
            SurfaceRequest r3 = this.mSurfaceRequestToBeInvalidated;
            if (r3 == null) goto L9;
            r3.invalidate();
            this.mSurfaceRequestToBeInvalidated = null;
            this.mNeedToInvalidate = false;
            return;
        L9:
            return;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder r2) {
            Logger.d(SurfaceViewImplementation.TAG, "Surface destroyed.");
            if (this.mWasSurfaceProvided == false) goto L5;
            closeSurface();
        L6:
            this.mNeedToInvalidate = true;
            SurfaceRequest r3 = this.mSurfaceRequest;
            if (r3 == null) goto L9;
            this.mSurfaceRequestToBeInvalidated = r3;
        L9:
            this.mWasSurfaceProvided = false;
            this.mSurfaceRequest = null;
            this.mOnSurfaceNotInUseListener = null;
            this.mCurrentSurfaceSize = null;
            this.mTargetSize = null;
            return;
        L5:
            cancelPreviousRequest();
            goto L6
        }

        private static /* synthetic */ void lambda$tryToComplete$0(PreviewViewImplementation.OnSurfaceNotInUseListener r1, SurfaceRequest.Result r2) {
            Logger.d(SurfaceViewImplementation.TAG, "Safe to release surface.");
            if (r1 == null) goto L6;
            r1.onSurfaceNotInUse();
            return;
        }

        public void setSurfaceRequest(SurfaceRequest r3, PreviewViewImplementation.OnSurfaceNotInUseListener r4) {
            cancelPreviousRequest();
            if (this.mNeedToInvalidate == false) goto L5;
            this.mNeedToInvalidate = false;
            r3.invalidate();
            return;
        L5:
            this.mSurfaceRequest = r3;
            this.mOnSurfaceNotInUseListener = r4;
            Size r5 = r3.getResolution();
            this.mTargetSize = r5;
            this.mWasSurfaceProvided = false;
            if (tryToComplete() == true) goto L10;
            Logger.d(SurfaceViewImplementation.TAG, "Wait for new Surface creation.");
            this.this$0.mSurfaceView.getHolder().setFixedSize(r5.getWidth(), r5.getHeight());
            return;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
            Logger.d(SurfaceViewImplementation.TAG, "Surface changed. Size: " + r3 + "x" + r4);
            this.mCurrentSurfaceSize = new Size(r3, r4);
            tryToComplete();
        }
    }

    public static /* synthetic */ void a(Semaphore r0, int r1) {
        lambda$getPreviewBitmap$1(r0, r1);
    }

    public static /* synthetic */ void b(SurfaceViewImplementation r0, SurfaceRequest r1, PreviewViewImplementation.OnSurfaceNotInUseListener r2) {
        r0.lambda$onSurfaceRequested$0(r1, r2);
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void onAttachedToWindow() {
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void onDetachedFromWindow() {
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public ListenableFuture<Void> waitForNextFrame() {
        return Futures.immediateFuture(null);
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public Bitmap getPreviewBitmap() {
        SurfaceView r1 = this.mSurfaceView;
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.getHolder().getSurface() != null) goto L7;
        return null;
    L7:
        if (this.mSurfaceView.getHolder().getSurface().isValid() == false) goto L28;
        final Semaphore r2 = new Semaphore(0);
        Bitmap r3 = Bitmap.createBitmap(this.mSurfaceView.getWidth(), this.mSurfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        PthreadHandlerThreadV2 r4 = new PthreadHandlerThreadV2("pixelCopyRequest Thread");
        ThreadMethodProxy.start(r4);
        Handler r5 = new Handler(r4.getLooper());
        Api24Impl.pixelCopyRequest(this.mSurfaceView, r3, new z(r2), r5);
    L16:
        e = move-exception;
        Logger.e(TAG, "Interrupted while trying to acquire screenshot.", e);     // Catch: Throwable -> L14
    L13:
        r4.quitSafely();
        return r3;
    L14:
        th = move-exception;
        r4.quitSafely();
        throw th;
    L11:
        if (r2.tryAcquire(1, 100, TimeUnit.MILLISECONDS) == true) goto L13;
        Logger.e(TAG, "Timed out while trying to acquire screenshot.");     // Catch: Throwable -> L14 InterruptedException -> L16
    L28:
        return null;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void initializePreview() {
        Preconditions.checkNotNull(this.mParent);
        Preconditions.checkNotNull(this.mResolution);
        SurfaceView r0 = new SurfaceView(this.mParent.getContext());
        this.mSurfaceView = r0;
        r0.setLayoutParams(new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
        this.mParent.removeAllViews();
        this.mParent.addView(this.mSurfaceView);
        this.mSurfaceView.getHolder().addCallback(this.mSurfaceRequestCallback);
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public View getPreview() {
        return this.mSurfaceView;
    }

    public SurfaceViewImplementation(FrameLayout r1, PreviewTransformation r2) {
        super(r1, r2);
        this.mSurfaceRequestCallback = new SurfaceRequestCallback(this);
    }

    private static /* synthetic */ void lambda$getPreviewBitmap$1(Semaphore r3, int r4) {
        if (r4 != 0) goto L5;
        Logger.d(TAG, "PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
    L6:
        r3.release();
        return;
    L5:
        Logger.e(TAG, "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + r4);
        goto L6
    }

    private /* synthetic */ void lambda$onSurfaceRequested$0(SurfaceRequest r2, PreviewViewImplementation.OnSurfaceNotInUseListener r3) {
        this.mSurfaceRequestCallback.setSurfaceRequest(r2, r3);
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void onSurfaceRequested(final SurfaceRequest r3, final PreviewViewImplementation.OnSurfaceNotInUseListener r4) {
        if (shouldReusePreview(this.mSurfaceView, this.mResolution, r3) == true) goto L5;
        this.mResolution = r3.getResolution();
        initializePreview();
    L5:
        if (r4 == null) goto L7;
        r3.addRequestCancellationListener(ContextCompat.getMainExecutor(this.mSurfaceView.getContext()), new x(r4));
    L7:
        this.mSurfaceView.post(new y(this, r3, r4));
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void setFrameUpdateListener(Executor r1, PreviewView.OnFrameUpdateListener r2) {
        throw new IllegalArgumentException("SurfaceView doesn't support frame update listener");
    }

    private static boolean shouldReusePreview(SurfaceView r0, Size r1, SurfaceRequest r2) {
        boolean r3 = Objects.equals(r1, r2.getResolution());
        if (r0 == null) goto L6;
        if (r3 == false) goto L6;
        return true;
    L6:
        return false;
    }
}
