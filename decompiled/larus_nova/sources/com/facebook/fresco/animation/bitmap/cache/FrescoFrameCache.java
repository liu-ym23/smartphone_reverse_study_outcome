package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.animated.impl.AnimatedHeifFrameCache;
import com.facebook.imagepipeline.cache.HashMapMemoryCache;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class FrescoFrameCache implements BitmapFrameCache {
    private static final Class<?> TAG = null;
    private final AnimatedFrameCache mAnimatedFrameCache;
    private final AnimatedHeifFrameCache mAnimatedHeifFrameCache;
    private final boolean mEnableBitmapReusing;
    private int mLastRenderedIndex;

    @Nullable
    private CloseableReference<CloseableImage> mLastRenderedItem;
    private final SparseArray<CloseableReference<CloseableImage>> mPreparedPendingFrames;

    private synchronized int getPreparedPendingFramesSizeBytes() {
        monitor-enter(this);
        int r100 = 0;
        int r101 = 0;
    L13:
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r100 >= this.mPreparedPendingFrames.size()) goto L8;
        r101 = r101 + getBitmapSizeBytes(this.mPreparedPendingFrames.valueAt(r100));
        r100 = r100 + 1;
        goto L13
    L8:
        monitor-exit(this);
        return r101;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized int getSizeInBytes() {
        monitor-enter(this);
        int r100 = getBitmapSizeBytes(this.mLastRenderedItem) + getPreparedPendingFramesSizeBytes();
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener r100) {
    }

    static {
        TAG = FrescoFrameCache.class;
    }

    @Nullable
    public static CloseableReference<Bitmap> convertToBitmapReferenceAndClose(@Nullable CloseableReference<CloseableImage> r100) {
    L13:
        th = move-exception;
        CloseableReference.closeSafely(r100);
        throw th;
    L3:
        if (CloseableReference.isValid(r100) == true) goto L5;
    L11:
        CloseableReference.closeSafely(r100);
        return null;
    L5:
        if ((r100.get() instanceof CloseableStaticBitmap) == false) goto L11;
        CloseableStaticBitmap r101 = (CloseableStaticBitmap) r100.get();     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        CloseableReference<Bitmap> r102 = r101.cloneUnderlyingBitmapReference();     // Catch: Throwable -> L13
        CloseableReference.closeSafely(r100);
        return r102;
    }

    @Nullable
    private static CloseableReference<CloseableImage> createImageReference(CloseableReference<Bitmap> r100) {
        return CloseableReference.of(new CloseableStaticBitmap(r100, ImmutableQualityInfo.FULL_QUALITY, 0));
    }

    private static int getBitmapSizeBytes(@Nullable CloseableReference<CloseableImage> r100) {
        if (CloseableReference.isValid(r100) == true) goto L7;
        return 0;
    L7:
        return getBitmapSizeBytes(r100.get());
    }

    private synchronized void removePreparedReference(int r100) {
        monitor-enter(this);
        CloseableReference<CloseableImage> r101 = this.mPreparedPendingFrames.get(r100);     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        this.mPreparedPendingFrames.delete(r100);     // Catch: Throwable -> L8
        CloseableReference.closeSafely(r101);     // Catch: Throwable -> L8
        FLog.v(TAG, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(r100), this.mPreparedPendingFrames);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getFallbackFrame(int r100) {
        monitor-enter(this);
        CloseableReference<Bitmap> r101 = convertToBitmapReferenceAndClose(CloseableReference.cloneOrNull(this.mLastRenderedItem));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    private static int getBitmapSizeBytes(@Nullable CloseableImage r100) {
        if ((r100 instanceof CloseableBitmap) == true) goto L7;
        return 0;
    L7:
        return BitmapUtil.getSizeInBytes(((CloseableBitmap) r100).getUnderlyingBitmap());
    }

    public FrescoFrameCache(AnimatedFrameCache r100, boolean r101) {
        this.mLastRenderedIndex = -1;
        this.mAnimatedFrameCache = r100;
        this.mAnimatedHeifFrameCache = new AnimatedHeifFrameCache(new SimpleCacheKey("Sample"), new HashMapMemoryCache());
        this.mEnableBitmapReusing = r101;
        this.mPreparedPendingFrames = new SparseArray();
    }

    public FrescoFrameCache(AnimatedFrameCache r100, AnimatedHeifFrameCache r101, boolean r102) {
        this.mLastRenderedIndex = -1;
        this.mAnimatedFrameCache = r100;
        this.mAnimatedHeifFrameCache = r101;
        this.mEnableBitmapReusing = r102;
        this.mPreparedPendingFrames = new SparseArray();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void clear(ImageFormat r100, int r101, boolean r102) {
        monitor-enter(this);
        int r103 = 0;
        if (DefaultImageFormats.isHeifFormatAnimated(r100) == false) goto L7;
        if (r102 == false) goto L7;
        boolean r104 = true;
    L8:
        CloseableReference.closeSafely(this.mLastRenderedItem);     // Catch: Throwable -> L32
        if (r104 == false) goto L12;
        this.mAnimatedHeifFrameCache.clear();     // Catch: Throwable -> L32
    L19:
        this.mLastRenderedItem = null;     // Catch: Throwable -> L32
        this.mLastRenderedIndex = -1;     // Catch: Throwable -> L32
        if (FrescoCacheMonitorUtil.isOptAnimCacheClear() == false) goto L22;
    L29:
        this.mPreparedPendingFrames.clear();     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L22:
        if (r103 >= this.mPreparedPendingFrames.size()) goto L29;
        CloseableReference<CloseableImage> r105 = this.mPreparedPendingFrames.valueAt(r103);     // Catch: Throwable -> L32
        if (r105 == null) goto L28;
        CloseableReference.closeSafely(r105);     // Catch: Throwable -> L32
        if (r104 == true) goto L28;
        this.mAnimatedFrameCache.clear(this.mPreparedPendingFrames.keyAt(r103));     // Catch: Throwable -> L32
    L28:
        r103 = r103 + 1;     // Catch: Throwable -> L32
        goto L22
    L12:
        if (FrescoCacheMonitorUtil.isOptAnimCacheClear() == true) goto L14;
    L18:
        this.mAnimatedFrameCache.clear(this.mLastRenderedIndex);     // Catch: Throwable -> L32
        goto L19
    L14:
        if (this.mLastRenderedIndex == (-1)) goto L18;
        int r106 = 0;
    L16:
        if (r106 >= r101) goto L19;
        this.mAnimatedFrameCache.clear(r106);     // Catch: Throwable -> L32
        r106 = r106 + 1;     // Catch: Throwable -> L32
    L7:
        r104 = false;
    L32:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized boolean contains(int r100, ImageFormat r101, boolean r102) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (DefaultImageFormats.isHeifFormatAnimated(r101) == false) goto L10;
        if (r102 == false) goto L10;
        if (this.mAnimatedHeifFrameCache.contains(r100) == true) goto L15;
    L11:
        if (this.mPreparedPendingFrames.get(r100) != null) goto L15;
        boolean r103 = false;
    L16:
        monitor-exit(this);
        return r103;
    L15:
        r103 = true;
    L10:
        if (this.mAnimatedFrameCache.contains(r100) == true) goto L15;
        goto L11
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getCachedFrame(int r100, ImageFormat r101, boolean r102) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (DefaultImageFormats.isHeifFormatAnimated(r101) == false) goto L10;
        if (r102 == false) goto L10;
        CloseableReference<Bitmap> r103 = this.mAnimatedHeifFrameCache.get(r100);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r103;
    L10:
        if (this.mAnimatedFrameCache.contains(r100) == false) goto L14;
        CloseableReference<Bitmap> r104 = convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.get(r100));     // Catch: Throwable -> L17
        monitor-exit(this);
        return r104;
    L14:
        CloseableReference<Bitmap> r105 = convertToBitmapReferenceAndClose(CloseableReference.cloneOrNull(this.mPreparedPendingFrames.get(r100)));     // Catch: Throwable -> L17
        monitor-exit(this);
        return r105;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int r100, int r101, int r102, ImageFormat r103, boolean r104) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (DefaultImageFormats.isHeifFormatAnimated(r103) == false) goto L10;
        if (r104 == false) goto L10;
        monitor-exit(this);
        return null;
    L10:
        if (this.mEnableBitmapReusing == true) goto L13;
        monitor-exit(this);
        return null;
    L13:
        CloseableReference<Bitmap> r105 = convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.getForReuse());     // Catch: Throwable -> L16
        monitor-exit(this);
        return r105;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFramePrepared(int r100, CloseableReference<Bitmap> r101, int r102, @Nullable ImageFormat r103, boolean r104) {
        monitor-enter(this);
        Preconditions.checkNotNull(r101);     // Catch: Throwable -> L27
        CloseableReference<CloseableImage> r105 = null;
        if (r103 != null) goto L30;
    L10:
        r105 = createImageReference(r101);     // Catch: Throwable -> L24
        if (r105 != null) goto L15;
        CloseableReference.closeSafely(r105);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L15:
        CloseableReference<CloseableImage> r106 = this.mAnimatedFrameCache.cache(r100, r105);     // Catch: Throwable -> L24
    L17:
        if (CloseableReference.isValid(r106) == false) goto L19;
        CloseableReference.closeSafely(this.mPreparedPendingFrames.get(r100));     // Catch: Throwable -> L24
    L20:
        this.mPreparedPendingFrames.put(r100, r106);     // Catch: Throwable -> L24
        FLog.v(TAG, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(r100), this.mPreparedPendingFrames);     // Catch: Throwable -> L24
        CloseableReference.closeSafely(r105);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        CloseableReference.closeSafely(r105);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L19:
        r106 = r105.clone();     // Catch: Throwable -> L24
        CloseableReference.closeSafely(this.mPreparedPendingFrames.get(r100));     // Catch: Throwable -> L24
        goto L20
    L30:
        if (DefaultImageFormats.isHeifFormatAnimated(r103) == false) goto L10;
        if (r104 == false) goto L10;
        r106 = createImageReference(this.mAnimatedHeifFrameCache.cache(r100, r101));     // Catch: Throwable -> L24
    L27:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFrameRendered(int r100, CloseableReference<Bitmap> r101, int r102, @Nullable ImageFormat r103, boolean r104) {
        monitor-enter(this);
        Preconditions.checkNotNull(r101);     // Catch: Throwable -> L21
        removePreparedReference(r100);     // Catch: Throwable -> L21
        CloseableReference<CloseableImage> r105 = null;
        CloseableReference.closeSafely(this.mLastRenderedItem);     // Catch: Throwable -> L18
        if (r103 != null) goto L8;
    L11:
        r105 = createImageReference(r101);     // Catch: Throwable -> L18
        if (r105 == null) goto L14;
        this.mLastRenderedItem = this.mAnimatedFrameCache.cache(r100, r105);     // Catch: Throwable -> L18
    L14:
        this.mLastRenderedIndex = r100;     // Catch: Throwable -> L18
        CloseableReference.closeSafely(r105);     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L8:
        if (DefaultImageFormats.isHeifFormatAnimated(r103) == false) goto L11;
        if (r104 == false) goto L11;
        this.mLastRenderedItem = createImageReference(this.mAnimatedHeifFrameCache.cache(r100, r101));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableReference.closeSafely(r105);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }
}
