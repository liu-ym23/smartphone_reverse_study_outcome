package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class TextureViewImplementation extends PreviewViewImplementation {
    private static final String TAG = "TextureViewImpl";
    SurfaceTexture mDetachedSurfaceTexture;
    Executor mFrameUpdateExecutor;
    boolean mIsSurfaceTextureDetachedFromView;
    AtomicReference<CallbackToFutureAdapter.Completer<Void>> mNextFrameCompleter;
    PreviewView.OnFrameUpdateListener mOnFrameUpdateListener;
    PreviewViewImplementation.OnSurfaceNotInUseListener mOnSurfaceNotInUseListener;
    ListenableFuture<SurfaceRequest.Result> mSurfaceReleaseFuture;
    SurfaceRequest mSurfaceRequest;
    SurfaceTexture mSurfaceTexture;
    TextureView mTextureView;

    /* JADX INFO: renamed from: androidx.camera.view.TextureViewImplementation$1, reason: invalid class name */
    public class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        final /* synthetic */ TextureViewImplementation this$0;

        public static /* synthetic */ void a(PreviewView.OnFrameUpdateListener r0, SurfaceTexture r1) {
            lambda$onSurfaceTextureUpdated$0(r0, r1);
        }

        public AnonymousClass1(TextureViewImplementation r1) {
            this.this$0 = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(final SurfaceTexture r4) {
            TextureViewImplementation r0 = this.this$0;
            r0.mSurfaceTexture = null;
            ListenableFuture<SurfaceRequest.Result> r1 = r0.mSurfaceReleaseFuture;
            if (r1 == null) goto L6;
            Futures.addCallback(r1, new C00041(this, r4), ContextCompat.getMainExecutor(this.this$0.mTextureView.getContext()));
            this.this$0.mDetachedSurfaceTexture = r4;
            return false;
        L6:
            Logger.d(TextureViewImplementation.TAG, "SurfaceTexture about to be destroyed");
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(final SurfaceTexture r4) {
            CallbackToFutureAdapter.Completer<Void> r0 = this.this$0.mNextFrameCompleter.getAndSet(null);
            if (r0 == null) goto L5;
            r0.set(null);
        L5:
            TextureViewImplementation r1 = this.this$0;
            final PreviewView.OnFrameUpdateListener r2 = r1.mOnFrameUpdateListener;
            Executor r3 = r1.mFrameUpdateExecutor;
            if (r2 == null) goto L10;
            if (r3 == null) goto L11;
            r3.execute(new g0(r2, r4));
            return;
        L11:
            return;
        }

        private static /* synthetic */ void lambda$onSurfaceTextureUpdated$0(PreviewView.OnFrameUpdateListener r2, SurfaceTexture r3) {
            r2.onFrameUpdate(r3.getTimestamp());
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture r3, int r4, int r5) {
            Logger.d(TextureViewImplementation.TAG, "SurfaceTexture available. Size: " + r4 + "x" + r5);
            TextureViewImplementation r6 = this.this$0;
            r6.mSurfaceTexture = r3;
            if (r6.mSurfaceReleaseFuture == null) goto L5;
            Preconditions.checkNotNull(r6.mSurfaceRequest);
            Logger.d(TextureViewImplementation.TAG, "Surface invalidated " + this.this$0.mSurfaceRequest);
            this.this$0.mSurfaceRequest.getDeferrableSurface().close();
            return;
        L5:
            r6.tryToProvidePreviewSurface();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture r2, int r3, int r4) {
            Logger.d(TextureViewImplementation.TAG, "SurfaceTexture size changed: " + r3 + "x" + r4);
        }
    }

    public static /* synthetic */ Object a(TextureViewImplementation r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$waitForNextFrame$3(r1);
    }

    public static /* synthetic */ void b(TextureViewImplementation r0, SurfaceRequest r1) {
        r0.lambda$onSurfaceRequested$0(r1);
    }

    public static /* synthetic */ void c(TextureViewImplementation r0, Surface r1, ListenableFuture r2, SurfaceRequest r3) {
        r0.lambda$tryToProvidePreviewSurface$2(r1, r2, r3);
    }

    public static /* synthetic */ Object d(TextureViewImplementation r0, Surface r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$tryToProvidePreviewSurface$1(r1, r2);
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void onDetachedFromWindow() {
        this.mIsSurfaceTextureDetachedFromView = true;
    }

    private void notifySurfaceNotInUse() {
        PreviewViewImplementation.OnSurfaceNotInUseListener r0 = this.mOnSurfaceNotInUseListener;
        if (r0 == null) goto L6;
        r0.onSurfaceNotInUse();
        this.mOnSurfaceNotInUseListener = null;
        return;
    }

    private void reattachSurfaceTexture() {
        if (this.mIsSurfaceTextureDetachedFromView == true) goto L5;
        return;
    L5:
        if (this.mDetachedSurfaceTexture == null) goto L11;
        SurfaceTexture r0 = this.mTextureView.getSurfaceTexture();
        SurfaceTexture r1 = this.mDetachedSurfaceTexture;
        if (r0 == r1) goto L12;
        this.mTextureView.setSurfaceTexture(r1);
        this.mDetachedSurfaceTexture = null;
        this.mIsSurfaceTextureDetachedFromView = false;
        return;
    L12:
        return;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public Bitmap getPreviewBitmap() {
        TextureView r0 = this.mTextureView;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isAvailable() == true) goto L8;
        return null;
    L8:
        return this.mTextureView.getBitmap();
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void initializePreview() {
        Preconditions.checkNotNull(this.mParent);
        Preconditions.checkNotNull(this.mResolution);
        TextureView r0 = new TextureView(this.mParent.getContext());
        this.mTextureView = r0;
        r0.setLayoutParams(new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
        this.mTextureView.setSurfaceTextureListener(new AnonymousClass1(this));
        this.mParent.removeAllViews();
        this.mParent.addView(this.mTextureView);
    }

    public void tryToProvidePreviewSurface() {
        Size r0 = this.mResolution;
        if (r0 == null) goto L11;
        SurfaceTexture r1 = this.mSurfaceTexture;
        if (r1 != null) goto L7;
        return;
    L7:
        if (this.mSurfaceRequest == null) goto L13;
        r1.setDefaultBufferSize(r0.getWidth(), this.mResolution.getHeight());
        final Surface r2 = new Surface(this.mSurfaceTexture);
        final SurfaceRequest r3 = this.mSurfaceRequest;
        final ListenableFuture<SurfaceRequest.Result> r4 = CallbackToFutureAdapter.getFuture(new b0(this, r2));
        this.mSurfaceReleaseFuture = r4;
        r4.addListener(new c0(this, r2, r4, r3), ContextCompat.getMainExecutor(this.mTextureView.getContext()));
        onSurfaceProvided();
        return;
    L13:
        return;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public ListenableFuture<Void> waitForNextFrame() {
        return CallbackToFutureAdapter.getFuture(new d0(this));
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public View getPreview() {
        return this.mTextureView;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void onAttachedToWindow() {
        reattachSurfaceTexture();
    }

    private /* synthetic */ void lambda$onSurfaceRequested$0(SurfaceRequest r2) {
        SurfaceRequest r0 = this.mSurfaceRequest;
        if (r0 == null) goto L6;
        if (r0 != r2) goto L6;
        this.mSurfaceRequest = null;
        this.mSurfaceReleaseFuture = null;
    L6:
        notifySurfaceNotInUse();
    }

    private /* synthetic */ Object lambda$waitForNextFrame$3(CallbackToFutureAdapter.Completer r2) throws Exception {
        this.mNextFrameCompleter.set(r2);
        return "textureViewImpl_waitForNextFrame";
    }

    public TextureViewImplementation(FrameLayout r1, PreviewTransformation r2) {
        super(r1, r2);
        this.mIsSurfaceTextureDetachedFromView = false;
        this.mNextFrameCompleter = new AtomicReference();
    }

    private /* synthetic */ Object lambda$tryToProvidePreviewSurface$1(Surface r4, final CallbackToFutureAdapter.Completer r5) throws Exception {
        Logger.d(TAG, "Surface set on Preview.");
        SurfaceRequest r0 = this.mSurfaceRequest;
        Executor r1 = CameraXExecutors.directExecutor();
        Objects.requireNonNull(r5);
        r0.provideSurface(r4, r1, new e0(r5));
        return "provideSurface[request=" + this.mSurfaceRequest + " surface=" + r4 + "]";
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void onSurfaceRequested(final SurfaceRequest r2, PreviewViewImplementation.OnSurfaceNotInUseListener r3) {
        this.mResolution = r2.getResolution();
        this.mOnSurfaceNotInUseListener = r3;
        initializePreview();
        SurfaceRequest r4 = this.mSurfaceRequest;
        if (r4 == null) goto L5;
        r4.willNotProvideSurface();
    L5:
        this.mSurfaceRequest = r2;
        r2.addRequestCancellationListener(ContextCompat.getMainExecutor(this.mTextureView.getContext()), new f0(this, r2));
        tryToProvidePreviewSurface();
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void setFrameUpdateListener(Executor r1, PreviewView.OnFrameUpdateListener r2) {
        this.mOnFrameUpdateListener = r2;
        this.mFrameUpdateExecutor = r1;
    }

    private /* synthetic */ void lambda$tryToProvidePreviewSurface$2(Surface r3, ListenableFuture r4, SurfaceRequest r5) {
        Logger.d(TAG, "Safe to release surface.");
        notifySurfaceNotInUse();
        r3.release();
        if (this.mSurfaceReleaseFuture != r4) goto L6;
        this.mSurfaceReleaseFuture = null;
    L6:
        if (this.mSurfaceRequest != r5) goto L9;
        this.mSurfaceRequest = null;
        return;
    }
}
