package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class AndroidImageReaderProxy implements ImageReaderProxy {
    private final ImageReader mImageReader;
    private boolean mIsImageAvailableListenerCleared;
    private final Object mLock;

    public static /* synthetic */ void a(AndroidImageReaderProxy r0, Executor r1, ImageReaderProxy.OnImageAvailableListener r2, ImageReader r3) {
        r0.lambda$setOnImageAvailableListener$1(r1, r2, r3);
    }

    public static /* synthetic */ void b(AndroidImageReaderProxy r0, ImageReaderProxy.OnImageAvailableListener r1) {
        r0.lambda$setOnImageAvailableListener$0(r1);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireLatestImage() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Image r2 = this.mImageReader.acquireLatestImage();     // Catch: Throwable -> L7 RuntimeException -> L9
    L13:
        if (r2 != null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return null;
    L16:
        AndroidImageProxy r1 = new AndroidImageProxy(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L9:
        e = move-exception;
        if (isImageReaderContextNotInitializedException(e) == false) goto L19;
        r2 = null;
        goto L13
    L19:
        throw e;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireNextImage() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Image r2 = this.mImageReader.acquireNextImage();     // Catch: Throwable -> L7 RuntimeException -> L9
    L13:
        if (r2 != null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return null;
    L16:
        AndroidImageProxy r1 = new AndroidImageProxy(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L9:
        e = move-exception;
        if (isImageReaderContextNotInitializedException(e) == false) goto L19;
        r2 = null;
        goto L13
    L19:
        throw e;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsImageAvailableListenerCleared = true;     // Catch: Throwable -> L8
        this.mImageReader.setOnImageAvailableListener(null, null);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mImageReader.close();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mImageReader.getHeight();     // Catch: Throwable -> L7
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
        int r1 = this.mImageReader.getImageFormat();     // Catch: Throwable -> L7
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
        int r1 = this.mImageReader.getMaxImages();     // Catch: Throwable -> L7
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
        Surface r1 = this.mImageReader.getSurface();     // Catch: Throwable -> L7
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
        int r1 = this.mImageReader.getWidth();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public AndroidImageReaderProxy(ImageReader r2) {
        this.mLock = new Object();
        this.mIsImageAvailableListenerCleared = true;
        this.mImageReader = r2;
    }

    private boolean isImageReaderContextNotInitializedException(RuntimeException r2) {
        return "ImageReaderContext is not initialized".equals(r2.getMessage());
    }

    private /* synthetic */ void lambda$setOnImageAvailableListener$0(ImageReaderProxy.OnImageAvailableListener r1) {
        r1.onImageAvailable(this);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(final ImageReaderProxy.OnImageAvailableListener r3, final Executor r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsImageAvailableListenerCleared = false;     // Catch: Throwable -> L8
        ImageReader.OnImageAvailableListener r1 = new b(this, r4, r3);     // Catch: Throwable -> L8
        this.mImageReader.setOnImageAvailableListener(r1, MainThreadAsyncHandler.getInstance());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$setOnImageAvailableListener$1(Executor r2, final ImageReaderProxy.OnImageAvailableListener r3, ImageReader r4) {
        Object r5 = this.mLock;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsImageAvailableListenerCleared == true) goto L7;
        r2.execute(new a(this, r3));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r5);     // Catch: Throwable -> L9
    }
}
