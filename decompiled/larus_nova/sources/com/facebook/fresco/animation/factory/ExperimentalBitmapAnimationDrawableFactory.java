package com.facebook.fresco.animation.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.datasource.FrescoOptUtil;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache;
import com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache;
import com.facebook.fresco.animation.bitmap.cache.NoOpCache;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.animated.impl.AnimatedHeifFrameCache;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.HashMapMemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ExperimentalBitmapAnimationDrawableFactory implements DrawableFactory {
    public static final int CACHING_STRATEGY_FRESCO_CACHE = 1;
    public static final int CACHING_STRATEGY_FRESCO_CACHE_NO_REUSING = 2;
    public static final int CACHING_STRATEGY_KEEP_LAST_CACHE = 3;
    public static final int CACHING_STRATEGY_NO_CACHE = 0;
    private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final HashMapMemoryCache<CacheKey, Bitmap> mAnimatedHeifBackingCache;
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    private final Supplier<Integer> mCachingStrategySupplier;
    private final ExecutorService mExecutorServiceForFramePreparing;
    private final MonotonicClock mMonotonicClock;
    private final Supplier<Integer> mNumberOfFramesToPrepareSupplier;
    private final PlatformBitmapFactory mPlatformBitmapFactory;
    private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;

    public static class AnimationFrameCacheKey implements CacheKey {
        private static final String URI_PREFIX = "anim://";
        private final String mAnimationUriString;

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            String r100 = this.mAnimationUriString;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        @Override // com.facebook.cache.common.CacheKey
        public String getUriString() {
            return this.mAnimationUriString;
        }

        @Override // com.facebook.cache.common.CacheKey
        public String toString() {
            return this.mAnimationUriString;
        }

        public AnimationFrameCacheKey(int r100) {
            this.mAnimationUriString = URI_PREFIX + r100;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean containsUri(Uri r100) {
            return r100.toString().startsWith(this.mAnimationUriString);
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L17;
            String r101 = this.mAnimationUriString;
            String r102 = ((AnimationFrameCacheKey) r100).mAnimationUriString;
            if (r101 != null) goto L18;
            if (r102 == null) goto L19;
            return false;
        L19:
            return true;
        L18:
            return r101.equals(r102);
        }
    }

    private AnimatedDrawableBackend createAnimatedDrawableBackend(AnimatedImageResult r100) {
        AnimatedImage r101 = r100.getImage();
        Rect r102 = new Rect(0, 0, r101.getWidth(), r101.getHeight());
        return this.mAnimatedDrawableBackendProvider.get(r100, r102);
    }

    private AnimatedFrameCache createAnimatedFrameCache(AnimatedImageResult r100) {
        if (TextUtils.isEmpty(r100.getSourceUri()) == false) goto L5;
        int r101 = r100.hashCode();
    L6:
        AnimatedFrameCache r102 = new AnimatedFrameCache(new AnimationFrameCacheKey(r101), this.mBackingCache);
        int r103 = r100.getDecodedFrameSize();
        if (r103 <= 0) goto L14;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L14;
        if (r100.hasDecodedFrame(r104) == false) goto L13;
        cacheDecodedBitmap(r102, r104, r100.getDecodedFrame(r104));
    L13:
        r104 = r104 + 1;
    L14:
        return r102;
    L5:
        r101 = r100.getSourceUri().hashCode();
        goto L6
    }

    private AnimatedHeifFrameCache createAnimatedHeifFrameCache(AnimatedImageResult r100) {
        if (TextUtils.isEmpty(r100.getSourceUri()) == false) goto L5;
        int r101 = r100.hashCode();
    L7:
        return new AnimatedHeifFrameCache(new AnimationFrameCacheKey(r101), this.mAnimatedHeifBackingCache);
    L5:
        r101 = r100.getSourceUri().hashCode();
        goto L7
    }

    private BitmapFrameCache createBitmapFrameCache(AnimatedImageResult r100) {
        int r101 = this.mCachingStrategySupplier.get().intValue();
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L13;
        if (r101 == 3) goto L11;
        return new NoOpCache();
    L11:
        return new KeepLastFrameCache();
    L13:
        return new FrescoFrameCache(createAnimatedFrameCache(r100), createAnimatedHeifFrameCache(r100), false);
    L15:
        return new FrescoFrameCache(createAnimatedFrameCache(r100), createAnimatedHeifFrameCache(r100), true);
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public AnimatedDrawable2 createDrawable(CloseableImage r100) {
        CloseableAnimatedImage r101 = (CloseableAnimatedImage) r100;
        AnimatedImageResult r102 = r101.getImageResult();
        if (r102.getImage().getFrameCount() > 0) goto L6;
        return null;
    L6:
        BitmapFrameCache r103 = createBitmapFrameCache(r102);
        int r104 = r102.getImage().getDecodeStatus();
        return new AnimatedDrawable2(createAnimationBackend(r101, r103), r101.getOptions().decodeContext, r103, r104, r102.getImage().getImageFormat());
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(CloseableImage r100) {
        return r100 instanceof CloseableAnimatedImage;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public /* bridge */ /* synthetic */ Drawable createDrawable(CloseableImage r100) {
        return createDrawable(r100);
    }

    private AnimationBackend createAnimationBackend(CloseableAnimatedImage r110, BitmapFrameCache r111) {
        AnimatedDrawableBackend r100 = createAnimatedDrawableBackend(r110.getImageResult());
        AnimatedDrawableBackendFrameRenderer r101 = new AnimatedDrawableBackendFrameRenderer(r111, r100);
        int r102 = r110.getOptions().preDecodeFrameCount;
        if (r102 > 0) goto L7;
        r102 = this.mNumberOfFramesToPrepareSupplier.get().intValue();
    L7:
        if (ImagePipelineFactory.getInstance().isShowHeifDebugLog() == false) goto L9;
        DefaultImageFormats.isHeifFormatAnimated(r110.getImageFormat());
        ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheEnabled();
        ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheForImageRequestEnabled();
    L9:
        ImageFormat r103 = null;
        if (r102 > 0) goto L12;
    L20:
        FixedNumberBitmapFramePreparationStrategy r104 = null;
        BitmapFramePreparer r105 = null;
    L21:
        BitmapAnimationBackend r106 = new BitmapAnimationBackend(this.mPlatformBitmapFactory, r111, new AnimatedDrawableBackendAnimationInformation(r100), r101, r104, r105);
        r106.setBitmapConfig(r110.getOptions().bitmapConfig);
        r106.setImageFormat(r110.getImageFormat());
        r106.setAnimHeifIndividualCacheForCurrentRequestEnabled(r110.getOptions().animatedHeifIndividualCacheEnabled);
        AnimatedImage r112 = r110.getImage();
        if (r112 == null) goto L25;
        r103 = r112.getImageFormat();
    L25:
        return AnimationBackendDelegateWithInactivityCheck.createForBackend(r103, r106, this.mMonotonicClock, this.mScheduledExecutorServiceForUiThread);
    L12:
        if (FrescoOptUtil.isOptHeifAnimDecode() == false) goto L14;
    L19:
        FixedNumberBitmapFramePreparationStrategy r107 = new FixedNumberBitmapFramePreparationStrategy(r102);
        r105 = createBitmapFramePreparer(r101, r110.getOptions().bitmapConfig);
        r104 = r107;
        goto L21
    L14:
        if (DefaultImageFormats.isHeifFormatAnimated(r110.getImageFormat()) == false) goto L19;
        if (ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheEnabled() == true) goto L19;
        if (ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheForImageRequestEnabled() == false) goto L20;
        goto L19
    }

    private BitmapFramePreparer createBitmapFramePreparer(BitmapFrameRenderer r100, Bitmap.Config r101) {
        return new DefaultBitmapFramePreparer(this.mPlatformBitmapFactory, r100, r101, this.mExecutorServiceForFramePreparing);
    }

    private boolean shouldUpdateAnimatedImage(AnimatedDrawable2 r100, AnimatedImage r101) {
        AnimationBackend r102 = r100.getAnimationBackend();
        if ((r102 instanceof AnimationBackendDelegate) == false) goto L14;
        AnimationBackend r103 = ((AnimationBackendDelegate) r102).getAnimationBackend();
        if ((r103 instanceof BitmapAnimationBackend) == false) goto L16;
        AnimatedImageResult r104 = ((AnimatedDrawableBackendAnimationInformation) ((BitmapAnimationBackend) r103).getAnimationInformation()).getAnimatedDrawableBackend().getAnimatedImageResult();
        if (r104 == null) goto L17;
        AnimatedImage r105 = r104.getImage();
        if (r105 == null) goto L18;
        if (r101 == null) goto L19;
        if (r101 == r105) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L18:
        return false;
    L17:
        return false;
    L16:
        return false;
    L14:
        return false;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    @Nullable
    public Drawable createDrawable(CloseableImage r110, Drawable r111) {
        CloseableAnimatedImage r100 = (CloseableAnimatedImage) r110;
        AnimatedImageResult r101 = r100.getImageResult();
        int r102 = r101.getImage().getDecodeStatus();
        if (r101.getImage().getFrameCount() > 0) goto L6;
        return r111;
    L6:
        if ((r111 instanceof AnimatedDrawable2) == false) goto L25;
        if (r102 != 2) goto L10;
    L11:
        AnimatedDrawable2 r112 = (AnimatedDrawable2) r111;
        BitmapFrameCache r103 = r112.getBitmapFrameCache();
        if (shouldUpdateAnimatedImage(r112, r101.getImage()) == true) goto L14;
        return r112;
    L14:
        AnimatedDrawableBackend r104 = createAnimatedDrawableBackend(r101);
        AnimatedDrawableBackendFrameRenderer r105 = new AnimatedDrawableBackendFrameRenderer(r103, r104);
        int r106 = this.mNumberOfFramesToPrepareSupplier.get().intValue();
        if (r106 > 0) goto L17;
    L21:
        FixedNumberBitmapFramePreparationStrategy r107 = null;
        BitmapFramePreparer r108 = null;
    L22:
        BitmapAnimationBackend r113 = new BitmapAnimationBackend(this.mPlatformBitmapFactory, r103, new AnimatedDrawableBackendAnimationInformation(r104), r105, r107, r108);
        r113.setBitmapConfig(r100.getOptions().bitmapConfig);
        r113.setImageFormat(r100.getImageFormat());
        r113.setAnimHeifIndividualCacheForCurrentRequestEnabled(r100.getOptions().animatedHeifIndividualCacheEnabled);
        r112.updateDrawable(AnimationBackendDelegateWithInactivityCheck.createForBackend(r113, this.mMonotonicClock, this.mScheduledExecutorServiceForUiThread), r100.getOptions().decodeContext, r102);
        return r112;
    L17:
        if (FrescoOptUtil.isOptHeifAnimDecode() == false) goto L19;
    L20:
        r107 = new FixedNumberBitmapFramePreparationStrategy(r106);
        r108 = createBitmapFramePreparer(r105, r100.getOptions().bitmapConfig);
        goto L22
    L19:
        if (DefaultImageFormats.isHeifFormatAnimated(r110.getImageFormat()) == true) goto L21;
    L10:
        if (r102 == 3) goto L11;
    L25:
        return createDrawable(r110);
    }

    private void cacheDecodedBitmap(AnimatedFrameCache r100, int r101, CloseableReference<Bitmap> r102) {
        CloseableReference<CloseableImage> r103 = null;
        r103 = CloseableReference.of(new CloseableStaticBitmap(r102, ImmutableQualityInfo.FULL_QUALITY, 0));     // Catch: Throwable -> L6
        r100.cache(r101, r103);     // Catch: Throwable -> L6
        CloseableReference.closeSafely(r103);
        return;
    L6:
        th = move-exception;
        CloseableReference.closeSafely(r103);
        throw th;
    }

    public ExperimentalBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider r100, ScheduledExecutorService r101, ExecutorService r102, MonotonicClock r103, PlatformBitmapFactory r104, CountingMemoryCache<CacheKey, CloseableImage> r105, HashMapMemoryCache<CacheKey, Bitmap> r106, Supplier<Integer> r107, Supplier<Integer> r108) {
        this.mAnimatedDrawableBackendProvider = r100;
        this.mScheduledExecutorServiceForUiThread = r101;
        this.mExecutorServiceForFramePreparing = r102;
        this.mMonotonicClock = r103;
        this.mPlatformBitmapFactory = r104;
        this.mBackingCache = r105;
        this.mAnimatedHeifBackingCache = r106;
        this.mCachingStrategySupplier = r107;
        this.mNumberOfFramesToPrepareSupplier = r108;
    }
}
