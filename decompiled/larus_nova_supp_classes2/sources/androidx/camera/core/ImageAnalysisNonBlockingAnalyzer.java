package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ImageAnalysisNonBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    final Executor mBackgroundExecutor;
    ImageProxy mCachedImage;
    private final Object mLock;
    private CacheAnalyzingImageProxy mPostedImage;

    public static class CacheAnalyzingImageProxy extends ForwardingImageProxy {
        final WeakReference<ImageAnalysisNonBlockingAnalyzer> mNonBlockingAnalyzerWeakReference;

        public static /* synthetic */ void a(CacheAnalyzingImageProxy r0, ImageProxy r1) {
            r0.lambda$new$1(r1);
        }

        public static /* synthetic */ void b(ImageAnalysisNonBlockingAnalyzer r0) {
            lambda$new$0(r0);
        }

        private static /* synthetic */ void lambda$new$0(ImageAnalysisNonBlockingAnalyzer r0) {
            r0.analyzeCachedImage();
        }

        private /* synthetic */ void lambda$new$1(ImageProxy r3) {
            final ImageAnalysisNonBlockingAnalyzer r4 = this.mNonBlockingAnalyzerWeakReference.get();
            if (r4 == null) goto L6;
            r4.mBackgroundExecutor.execute(new o(r4));
            return;
        }

        public CacheAnalyzingImageProxy(ImageProxy r1, ImageAnalysisNonBlockingAnalyzer r2) {
            super(r1);
            this.mNonBlockingAnalyzerWeakReference = new WeakReference(r2);
            addOnImageCloseListener(new p(this));
        }
    }

    public void analyzeCachedImage() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPostedImage = null;     // Catch: Throwable -> L10
        if (this.mCachedImage == null) goto L8;
        ImageProxy r2 = this.mCachedImage;     // Catch: Throwable -> L10
        this.mCachedImage = null;     // Catch: Throwable -> L10
        onValidImageAvailable(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public void clearCache() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ImageProxy r1 = this.mCachedImage;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.close();     // Catch: Throwable -> L9
        this.mCachedImage = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public ImageAnalysisNonBlockingAnalyzer(Executor r2) {
        this.mLock = new Object();
        this.mBackgroundExecutor = r2;
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public ImageProxy acquireImage(ImageReaderProxy r1) {
        return r1.acquireLatestImage();
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public void onValidImageAvailable(ImageProxy r7) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsAttached == true) goto L10;
        r7.close();     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L10:
        if (this.mPostedImage != null) goto L12;
        final CacheAnalyzingImageProxy r1 = new CacheAnalyzingImageProxy(r7, this);     // Catch: Throwable -> L23
        this.mPostedImage = r1;     // Catch: Throwable -> L23
        Futures.addCallback(analyzeImage(r1), new AnonymousClass1(this, r1), CameraXExecutors.directExecutor());     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L12:
        if (r7.getImageInfo().getTimestamp() > this.mPostedImage.getImageInfo().getTimestamp()) goto L14;
        r7.close();     // Catch: Throwable -> L23
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L14:
        ImageProxy r2 = this.mCachedImage;     // Catch: Throwable -> L23
        if (r2 == null) goto L17;
        r2.close();     // Catch: Throwable -> L23
    L17:
        this.mCachedImage = r7;     // Catch: Throwable -> L23
        goto L18
    }
}
