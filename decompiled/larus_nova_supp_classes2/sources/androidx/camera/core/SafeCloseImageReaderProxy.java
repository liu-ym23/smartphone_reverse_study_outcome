package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.impl.ImageReaderProxy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SafeCloseImageReaderProxy implements ImageReaderProxy {
    private ForwardingImageProxy.OnImageCloseListener mForwardingImageCloseListener;
    private final ForwardingImageProxy.OnImageCloseListener mImageCloseListener;
    private final ImageReaderProxy mImageReaderProxy;
    private boolean mIsClosed;
    private final Object mLock;
    private int mOutstandingImages;
    private final Surface mSurface;

    public static /* synthetic */ void a(SafeCloseImageReaderProxy r0, ImageReaderProxy.OnImageAvailableListener r1, ImageReaderProxy r2) {
        r0.lambda$setOnImageAvailableListener$1(r1, r2);
    }

    public static /* synthetic */ void b(SafeCloseImageReaderProxy r0, ImageProxy r1) {
        r0.lambda$new$0(r1);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireLatestImage() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ImageProxy r1 = wrapImageProxy(this.mImageReaderProxy.acquireLatestImage());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireNextImage() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ImageProxy r1 = wrapImageProxy(this.mImageReaderProxy.acquireNextImage());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mImageReaderProxy.clearOnImageAvailableListener();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Surface r1 = this.mSurface;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.release();     // Catch: Throwable -> L10
    L7:
        this.mImageReaderProxy.close();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public int getCapacity() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mImageReaderProxy.getMaxImages() - this.mOutstandingImages;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mImageReaderProxy.getHeight();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mImageReaderProxy.getImageFormat();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public ImageReaderProxy getImageReaderProxy() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ImageReaderProxy r1 = this.mImageReaderProxy;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mImageReaderProxy.getMaxImages();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public Surface getSurface() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Surface r1 = this.mImageReaderProxy.getSurface();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mImageReaderProxy.getWidth();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isClosed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mIsClosed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void safeClose() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsClosed = true;     // Catch: Throwable -> L10
        this.mImageReaderProxy.clearOnImageAvailableListener();     // Catch: Throwable -> L10
        if (this.mOutstandingImages != 0) goto L8;
        close();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public SafeCloseImageReaderProxy(ImageReaderProxy r2) {
        this.mLock = new Object();
        this.mOutstandingImages = 0;
        this.mIsClosed = false;
        this.mImageCloseListener = new e0(this);
        this.mImageReaderProxy = r2;
        this.mSurface = r2.getSurface();
    }

    private /* synthetic */ void lambda$new$0(ImageProxy r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mOutstandingImages - 1;     // Catch: Throwable -> L13
        this.mOutstandingImages = r1;     // Catch: Throwable -> L13
        if (this.mIsClosed == false) goto L8;
        if (r1 != 0) goto L8;
        close();     // Catch: Throwable -> L13
    L8:
        ForwardingImageProxy.OnImageCloseListener r2 = this.mForwardingImageCloseListener;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (r2 == null) goto L18;
        r2.onImageClose(r4);
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private ImageProxy wrapImageProxy(ImageProxy r2) {
        if (r2 == null) goto L5;
        this.mOutstandingImages++;
        SingleCloseImageProxy r0 = new SingleCloseImageProxy(r2);
        r0.addOnImageCloseListener(this.mImageCloseListener);
        return r0;
    L5:
        return null;
    }

    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mForwardingImageCloseListener = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$setOnImageAvailableListener$1(ImageReaderProxy.OnImageAvailableListener r1, ImageReaderProxy r2) {
        r1.onImageAvailable(this);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(final ImageReaderProxy.OnImageAvailableListener r4, Executor r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mImageReaderProxy.setOnImageAvailableListener(new f0(this, r4), r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
