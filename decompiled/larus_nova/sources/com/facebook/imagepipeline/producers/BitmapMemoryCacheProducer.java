package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
    private boolean isFallBackToMainMemory;
    private boolean isPrefetch;
    private boolean isSrPost;
    private final MemoryCache<CacheKey, CloseableImage> mBigImgMemoryCache;
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
    private final MemoryCache<CacheKey, CloseableImage> mPrefetchImgMemoryCache;
    private final MemoryCache<CacheKey, CloseableImage> mSingleMemoryCache;

    public String getProducerName() {
        return PRODUCER_NAME;
    }

    public static /* synthetic */ MemoryCache access$000(BitmapMemoryCacheProducer r100) {
        return r100.mBigImgMemoryCache;
    }

    public static /* synthetic */ MemoryCache access$100(BitmapMemoryCacheProducer r100) {
        return r100.mSingleMemoryCache;
    }

    public static /* synthetic */ MemoryCache access$200(BitmapMemoryCacheProducer r100) {
        return r100.mMemoryCache;
    }

    public static /* synthetic */ MemoryCache access$300(BitmapMemoryCacheProducer r100) {
        return r100.mPrefetchImgMemoryCache;
    }

    public static /* synthetic */ boolean access$400(BitmapMemoryCacheProducer r100) {
        return r100.isSrPost;
    }

    public static /* synthetic */ boolean access$500(BitmapMemoryCacheProducer r100) {
        return r100.isPrefetch;
    }

    public static /* synthetic */ boolean access$600(BitmapMemoryCacheProducer r100) {
        return r100.isFallBackToMainMemory;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> r110, ProducerContext r111) {
    L99:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L103;
        FrescoSystrace.endSection();
    L103:
        throw th;
    L3:
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("BitmapMemoryCacheProducer#produceResults");     // Catch: Throwable -> L99
    L5:
        ProducerListener r100 = r111.getListener();     // Catch: Throwable -> L99
        String r101 = r111.getId();     // Catch: Throwable -> L99
        r100.onProducerStart(r101, getProducerName());     // Catch: Throwable -> L99
        ImageRequest r102 = r111.getImageRequest();     // Catch: Throwable -> L99
        Object r103 = r111.getCallerContext();     // Catch: Throwable -> L99
        MemoryCacheLookupListener r104 = MemoryCacheLookupListener.getStrategy();     // Catch: Throwable -> L99
        if (r104 == null) goto L9;
        r104.onMemoryCacheLookupStart(r102, r103);     // Catch: Throwable -> L104
    L9:
        if (r111.getImageRequest() != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        this.isPrefetch = r105;     // Catch: Throwable -> L99
        if (r111.getImageRequest() != null) goto L17;
    L19:
        boolean r106 = false;
    L20:
        this.isFallBackToMainMemory = r106;     // Catch: Throwable -> L99
        if (r102.getPostprocessor() == null) goto L23;
        this.isSrPost = "SRPostProcessor".equalsIgnoreCase(r102.getPostprocessor().getName());     // Catch: Throwable -> L99
    L24:
        CacheKey r107 = BitmapMemoryCacheKey.getReuseOptCacheKey(this.mCacheKeyFactory.getBitmapCacheKey(r102, r103));     // Catch: Throwable -> L99
        Map<String, String> r108 = null;
        if (ImagePipelineFactory.getInstance().isEnableBigImgCache() == false) goto L27;
    L28:
        MemoryCache<CacheKey, CloseableImage> r109 = this.mBigImgMemoryCache;     // Catch: Throwable -> L99
        if (r109 == null) goto L31;
        CloseableReference<CloseableImage> r112 = r109.get(r107);     // Catch: Throwable -> L99
    L32:
        if (r112 == null) goto L34;
    L40:
        if (r112 != null) goto L42;
        r112 = this.mMemoryCache.get(r107);     // Catch: Throwable -> L99
    L42:
        if (r112 != null) goto L51;
        if (ImagePipelineFactory.getInstance().isSplitPrefetchCache() == false) goto L46;
    L47:
        MemoryCache<CacheKey, CloseableImage> r113 = this.mPrefetchImgMemoryCache;     // Catch: Throwable -> L99
        if (r113 == null) goto L51;
        r112 = r113.get(r107);     // Catch: Throwable -> L99
        goto L51
    L46:
        if (ImagePipelineConfig.getInstance().isEnablePrefetchImgCache() == true) goto L47;
    L51:
        if (r112 == null) goto L72;
        if (r104 == null) goto L55;
        r104.onMemoryCacheHit(r102, r103, r112);     // Catch: Throwable -> L105
    L55:
        if (r112.get().getQualityInfo().isOfFullQuality() == true) goto L57;
    L59:
        boolean r114 = false;
    L60:
        if (r114 == false) goto L66;
        BitmapMemoryCacheKey.checkKeyNotDownsample(r102, r107);     // Catch: Throwable -> L99
        String r115 = getProducerName();     // Catch: Throwable -> L99
        if (r100.requiresExtraMap(r101) == false) goto L64;
        Map<String, String> r116 = ImmutableMap.of("cached_value_found", "true");     // Catch: Throwable -> L99
    L65:
        r100.onProducerFinishWithSuccess(r101, r115, r116);     // Catch: Throwable -> L99
        r100.onUltimateProducerReached(r101, getProducerName(), true);     // Catch: Throwable -> L99
        r110.onProgressUpdate(1.0f);     // Catch: Throwable -> L99
        goto L66
    L64:
        r116 = null;
    L66:
        r110.onNewResult(r112, BaseConsumer.simpleStatusForIsLast(r114));     // Catch: Throwable -> L99
        r112.close();     // Catch: Throwable -> L99
        if (r114 == false) goto L76;
        if (FrescoSystrace.isTracing() == false) goto L114;
        FrescoSystrace.endSection();
        return;
    L114:
        return;
    L76:
        if (r111.getLowestPermittedRequestLevel().getValue() < ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) goto L86;
        String r117 = getProducerName();     // Catch: Throwable -> L99
        if (r100.requiresExtraMap(r101) == false) goto L80;
        Map<String, String> r118 = ImmutableMap.of("cached_value_found", "false");     // Catch: Throwable -> L99
    L81:
        r100.onProducerFinishWithSuccess(r101, r117, r118);     // Catch: Throwable -> L99
        r100.onUltimateProducerReached(r101, getProducerName(), false);     // Catch: Throwable -> L99
        r110.onNewResult(null, 1);     // Catch: Throwable -> L99
        if (FrescoSystrace.isTracing() == false) goto L115;
        FrescoSystrace.endSection();
        return;
    L115:
        return;
    L80:
        r118 = null;
        goto L81
    L86:
        Consumer<CloseableReference<CloseableImage>> r119 = wrapConsumer(r110, r107, r111.getImageRequest().isMemoryCacheEnabled(), r111.getCallerContext(), r102);     // Catch: Throwable -> L99
        String r120 = getProducerName();     // Catch: Throwable -> L99
        if (r100.requiresExtraMap(r101) == false) goto L89;
        r108 = ImmutableMap.of("cached_value_found", "false");     // Catch: Throwable -> L99
    L89:
        r100.onProducerFinishWithSuccess(r101, r120, r108);     // Catch: Throwable -> L99
        if (FrescoSystrace.isTracing() == false) goto L92;
        FrescoSystrace.beginSection("mInputProducer.produceResult");     // Catch: Throwable -> L99
    L92:
        this.mInputProducer.produceResults(r119, r111);     // Catch: Throwable -> L99
        if (FrescoSystrace.isTracing() == false) goto L96;
        FrescoSystrace.endSection();     // Catch: Throwable -> L99
    L96:
        if (FrescoSystrace.isTracing() == false) goto L116;
        FrescoSystrace.endSection();
        return;
    L116:
        return;
    L57:
        if (r112.get().isThumbCache() == true) goto L59;
        r114 = true;
        goto L60
    L72:
        if (r104 == null) goto L76;
        r104.onMemoryCacheMiss(r102, r103);     // Catch: Throwable -> L106
        goto L76
    L34:
        if (ImagePipelineFactory.getInstance().isEnableSingleCache() == false) goto L36;
    L37:
        MemoryCache<CacheKey, CloseableImage> r121 = this.mSingleMemoryCache;     // Catch: Throwable -> L99
        if (r121 == null) goto L40;
        r112 = r121.get(r107);     // Catch: Throwable -> L99
        goto L40
    L36:
        if (ImagePipelineConfig.getInstance().isEnableSingleMemCache() == false) goto L40;
    L31:
        r112 = null;
        goto L32
    L27:
        if (ImagePipelineConfig.getInstance().isEnableBigImgCache() == false) goto L31;
    L23:
        this.isSrPost = false;     // Catch: Throwable -> L99
        goto L24
    L17:
        if (r111.getImageRequest().isFallBackToMainMemory() == false) goto L19;
        r106 = true;
        goto L20
    L11:
        if (r111.getImageRequest().isOptPrefetch() == false) goto L13;
        r105 = true;
        goto L14
    }

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> r100, CacheKeyFactory r101, Producer<CloseableReference<CloseableImage>> r102) {
        this.isSrPost = false;
        this.isPrefetch = false;
        this.isFallBackToMainMemory = false;
        this.mMemoryCache = r100;
        InstrumentedMemoryCache<CacheKey, CloseableImage> r103 = null;
        if (ImagePipelineFactory.getInstance().isEnableSingleCache() == false) goto L5;
    L8:
        InstrumentedMemoryCache<CacheKey, CloseableImage> r104 = ImagePipelineFactory.getInstance().getSingleBitmapMemoryCache();
    L9:
        this.mSingleMemoryCache = r104;
        if (ImagePipelineFactory.getInstance().isEnableBigImgCache() == false) goto L12;
    L15:
        InstrumentedMemoryCache<CacheKey, CloseableImage> r105 = ImagePipelineFactory.getInstance().getBigImgBitmapMemoryCache();
    L16:
        this.mBigImgMemoryCache = r105;
        if (ImagePipelineFactory.getInstance().isSplitPrefetchCache() == false) goto L19;
    L20:
        r103 = ImagePipelineFactory.getInstance().getPrefetchImgBitmapMemoryCache();
    L21:
        this.mPrefetchImgMemoryCache = r103;
        this.mCacheKeyFactory = r101;
        this.mInputProducer = r102;
        return;
    L19:
        if (ImagePipelineConfig.getInstance().isEnablePrefetchImgCache() == false) goto L21;
    L12:
        if (ImagePipelineConfig.getInstance().isEnableBigImgCache() == true) goto L15;
        r105 = null;
        goto L16
    L5:
        if (ImagePipelineConfig.getInstance().isEnableSingleMemCache() == true) goto L8;
        r104 = null;
        goto L9
    }

    public Consumer<CloseableReference<CloseableImage>> wrapConsumer(final Consumer<CloseableReference<CloseableImage>> r100, final CacheKey r110, final boolean r111, final Object r112, final ImageRequest r113) {
        return new AnonymousClass1(this, r100, r110, r111, r113, r112);
    }
}
