package com.facebook.fresco.animation.bitmap.preparation;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageOOMOptStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class DefaultBitmapFramePreparer implements BitmapFramePreparer {
    private static final Class<?> TAG = null;
    private final Bitmap.Config mBitmapConfig;
    private final BitmapFrameRenderer mBitmapFrameRenderer;
    private final ExecutorService mExecutorService;
    private final SparseArray<Runnable> mPendingFrameDecodeJobs;
    private final PlatformBitmapFactory mPlatformBitmapFactory;

    public class FrameDecodeRunnable implements Runnable {
        private final AnimationBackend mAnimationBackend;
        private final BitmapFrameCache mBitmapFrameCache;
        private final int mFrameNumber;
        private final int mHashCode;
        final /* synthetic */ DefaultBitmapFramePreparer this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_facebook_fresco_animation_bitmap_preparation_DefaultBitmapFramePreparer$FrameDecodeRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_facebook_fresco_animation_bitmap_preparation_DefaultBitmapFramePreparer$FrameDecodeRunnable__run$___twin___() {
        L25:
            th = move-exception;
            monitor-enter(DefaultBitmapFramePreparer.access$100(this.this$0));
            DefaultBitmapFramePreparer.access$100(this.this$0).remove(this.mHashCode);     // Catch: Throwable -> L31
            throw th;
        L31:
            th = move-exception;
            throw th;
        L3:
            if (this.mBitmapFrameCache.contains(this.mFrameNumber, this.mAnimationBackend.getImageFormat(), this.mAnimationBackend.isAnimatedHeifIndividualCacheEnabled()) == false) goto L14;
            FLog.v(DefaultBitmapFramePreparer.access$000(), "Frame %d is cached already.", Integer.valueOf(this.mFrameNumber));     // Catch: Throwable -> L25
            SparseArray r100 = DefaultBitmapFramePreparer.access$100(this.this$0);
            monitor-enter(r100);
            DefaultBitmapFramePreparer.access$100(this.this$0).remove(this.mHashCode);     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L14:
            if (prepareFrameAndCache(this.mFrameNumber, 1) == false) goto L16;
            FLog.v(DefaultBitmapFramePreparer.access$000(), "Prepared frame frame %d.", Integer.valueOf(this.mFrameNumber));     // Catch: Throwable -> L25
        L17:
            SparseArray r101 = DefaultBitmapFramePreparer.access$100(this.this$0);
            monitor-enter(r101);
            DefaultBitmapFramePreparer.access$100(this.this$0).remove(this.mHashCode);     // Catch: Throwable -> L22
            monitor-exit(r101);     // Catch: Throwable -> L22
            return;
        L22:
            th = move-exception;
            throw th;
        L16:
            FLog.e(DefaultBitmapFramePreparer.access$000(), "Could not prepare frame %d.", new Object[]{Integer.valueOf(this.mFrameNumber)});     // Catch: Throwable -> L25
            goto L17
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_facebook_fresco_animation_bitmap_preparation_DefaultBitmapFramePreparer$FrameDecodeRunnable_com_larus_apm_impl_protector_RunnableLancet_run(FrameDecodeRunnable r100) {
            r100.com_facebook_fresco_animation_bitmap_preparation_DefaultBitmapFramePreparer$FrameDecodeRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private boolean prepareFrameAndCache(int r110, int r111) {
            int r100 = 2;
            boolean r101 = false;
            if (r111 == 1) goto L13;
            if (r111 == 2) goto L35;
            CloseableReference.closeSafely(null);
            return false;
        L35:
            CloseableReference<Bitmap> r102 = DefaultBitmapFramePreparer.access$300(this.this$0).createBitmap(this.mAnimationBackend.getIntrinsicWidth(), this.mAnimationBackend.getIntrinsicHeight(), DefaultBitmapFramePreparer.access$200(this.this$0));     // Catch: RuntimeException -> L9 Throwable -> L16 OutOfMemoryError -> L18
            r100 = -1;
        L14:
            r101 = renderFrameAndCache(r110, r102, r111);     // Catch: Throwable -> L16 OutOfMemoryError -> L18
            CloseableReference.closeSafely(r102);
        L25:
            if (r101 == true) goto L30;
            if (r100 == (-1)) goto L30;
            return prepareFrameAndCache(r110, r100);
        L30:
            return r101;
        L9:
            e = move-exception;
            FLog.w(DefaultBitmapFramePreparer.access$000(), "Failed to create frame bitmap", e);     // Catch: Throwable -> L16 OutOfMemoryError -> L18
            CloseableReference.closeSafely(null);
            return false;
        L13:
            r102 = this.mBitmapFrameCache.getBitmapToReuseForFrame(r110, this.mAnimationBackend.getIntrinsicWidth(), this.mAnimationBackend.getIntrinsicHeight(), this.mAnimationBackend.getImageFormat(), this.mAnimationBackend.isAnimatedHeifIndividualCacheEnabled());     // Catch: Throwable -> L16 OutOfMemoryError -> L18
        L18:
            e = move-exception;
            ImageOOMOptStrategy r103 = ImageOOMOptStrategy.getStrategy();     // Catch: Throwable -> L16
            if (r103 != null) goto L22;
        L31:
            throw e;     // Catch: Throwable -> L16
        L22:
            if (r103.isEnableAnimatedOOMOpt() == false) goto L31;
            r103.optMemoryWhenAnimatedOOM();     // Catch: Throwable -> L16
            CloseableReference.closeSafely(null);
            r100 = -1;
        L16:
            th = move-exception;
            CloseableReference.closeSafely(null);
            throw th;
        }

        private boolean renderFrameAndCache(int r100, CloseableReference<Bitmap> r101, int r102) {
            if (CloseableReference.isValid(r101) == true) goto L6;
            return false;
        L6:
            if (DefaultBitmapFramePreparer.access$400(this.this$0).renderFrame(r100, r101.get()) == true) goto L8;
            return false;
        L8:
            FLog.v(DefaultBitmapFramePreparer.access$000(), "Frame %d ready.", Integer.valueOf(this.mFrameNumber));
            SparseArray r103 = DefaultBitmapFramePreparer.access$100(this.this$0);
            monitor-enter(r103);
            this.mBitmapFrameCache.onFramePrepared(this.mFrameNumber, r101, r102, this.mAnimationBackend.getImageFormat(), this.mAnimationBackend.isAnimatedHeifIndividualCacheEnabled());     // Catch: Throwable -> L14
            monitor-exit(r103);     // Catch: Throwable -> L14
            return true;
        L14:
            th = move-exception;
            throw th;
        }

        public FrameDecodeRunnable(DefaultBitmapFramePreparer r100, AnimationBackend r101, BitmapFrameCache r102, int r103, int r104) {
            this.this$0 = r100;
            this.mAnimationBackend = r101;
            this.mBitmapFrameCache = r102;
            this.mFrameNumber = r103;
            this.mHashCode = r104;
        }
    }

    static {
        TAG = DefaultBitmapFramePreparer.class;
    }

    public static /* synthetic */ Class access$000() {
        return TAG;
    }

    public static /* synthetic */ SparseArray access$100(DefaultBitmapFramePreparer r100) {
        return r100.mPendingFrameDecodeJobs;
    }

    public static /* synthetic */ Bitmap.Config access$200(DefaultBitmapFramePreparer r100) {
        return r100.mBitmapConfig;
    }

    public static /* synthetic */ PlatformBitmapFactory access$300(DefaultBitmapFramePreparer r100) {
        return r100.mPlatformBitmapFactory;
    }

    public static /* synthetic */ BitmapFrameRenderer access$400(DefaultBitmapFramePreparer r100) {
        return r100.mBitmapFrameRenderer;
    }

    private static int getUniqueId(AnimationBackend r100, int r101) {
        return (r100.hashCode() * 31) + r101;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer
    public boolean prepareFrame(BitmapFrameCache r110, AnimationBackend r111, int r112) {
        int r100 = getUniqueId(r111, r112);
        SparseArray<Runnable> r101 = this.mPendingFrameDecodeJobs;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingFrameDecodeJobs.get(r100) == null) goto L10;
        FLog.v(TAG, "Already scheduled decode job for frame %d", Integer.valueOf(r112));     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return true;
    L10:
        if (r110.contains(r112, r111.getImageFormat(), r111.isAnimatedHeifIndividualCacheEnabled()) == false) goto L14;
        FLog.v(TAG, "Frame %d is cached already.", Integer.valueOf(r112));     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return true;
    L14:
        FrameDecodeRunnable r102 = new FrameDecodeRunnable(this, r111, r110, r112, r100);     // Catch: Throwable -> L17
        this.mPendingFrameDecodeJobs.put(r100, r102);     // Catch: Throwable -> L17
        this.mExecutorService.execute(r102);     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return true;
    }

    public DefaultBitmapFramePreparer(PlatformBitmapFactory r100, BitmapFrameRenderer r101, Bitmap.Config r102, ExecutorService r103) {
        this.mPlatformBitmapFactory = r100;
        this.mBitmapFrameRenderer = r101;
        this.mBitmapConfig = r102;
        this.mExecutorService = r103;
        this.mPendingFrameDecodeJobs = new SparseArray();
    }
}
