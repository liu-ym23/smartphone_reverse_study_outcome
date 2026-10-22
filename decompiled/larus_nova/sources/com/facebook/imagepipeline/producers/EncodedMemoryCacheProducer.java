package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class EncodedMemoryCacheProducer implements Producer<EncodedImage> {
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<EncodedImage> mInputProducer;
    private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;

    public static class EncodedMemoryCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final boolean mIsMemoryCacheEnabled;
        private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
        private final CacheKey mRequestedCacheKey;

        public void onNewResultImpl(EncodedImage r100, int r101) {
        L49:
            th = move-exception;
            if (FrescoSystrace.isTracing() == false) goto L53;
            FrescoSystrace.endSection();
        L53:
            throw th;
        L3:
            if (FrescoSystrace.isTracing() == false) goto L6;
            FrescoSystrace.beginSection("EncodedMemoryCacheProducer#onNewResultImpl");     // Catch: Throwable -> L49
        L6:
            if (BaseConsumer.isNotLast(r101) == true) goto L44;
            if (r100 == null) goto L44;
            if (BaseConsumer.statusHasAnyFlag(r101, 10) == true) goto L44;
            if (r100.getImageFormat() == ImageFormat.UNKNOWN) goto L44;
            CloseableReference<PooledByteBuffer> r102 = r100.getByteBufferRef();     // Catch: Throwable -> L49
            if (r102 != null) goto L59;
        L39:
            getConsumer().onNewResult(r100, r101);     // Catch: Throwable -> L49
            if (FrescoSystrace.isTracing() == false) goto L62;
            FrescoSystrace.endSection();
            return;
        L62:
            return;
        L59:
        L36:
            th = move-exception;
            CloseableReference.closeSafely(r102);     // Catch: Throwable -> L49
            throw th;     // Catch: Throwable -> L49
        L16:
            if (this.mIsMemoryCacheEnabled == false) goto L19;
            CloseableReference<PooledByteBuffer> r103 = this.mMemoryCache.cache(this.mRequestedCacheKey, r102);     // Catch: Throwable -> L36
        L20:
            CloseableReference.closeSafely(r102);     // Catch: Throwable -> L49
            if (r103 == null) goto L39;
            EncodedImage r104 = new EncodedImage(r103);     // Catch: Throwable -> L33
            r104.copyMetaDataFrom(r100);     // Catch: Throwable -> L33
            CloseableReference.closeSafely(r103);     // Catch: Throwable -> L49
            getConsumer().onProgressUpdate(1.0f);     // Catch: Throwable -> L30
            getConsumer().onNewResult(r104, r101);     // Catch: Throwable -> L30
            EncodedImage.closeSafely(r104);     // Catch: Throwable -> L49
            if (FrescoSystrace.isTracing() == false) goto L61;
            FrescoSystrace.endSection();
            return;
        L61:
            return;
        L30:
            th = move-exception;
            EncodedImage.closeSafely(r104);     // Catch: Throwable -> L49
            throw th;     // Catch: Throwable -> L49
        L33:
            th = move-exception;
            CloseableReference.closeSafely(r103);     // Catch: Throwable -> L49
            throw th;     // Catch: Throwable -> L49
        L19:
            r103 = null;
        L44:
            getConsumer().onNewResult(r100, r101);     // Catch: Throwable -> L49
            if (FrescoSystrace.isTracing() == false) goto L63;
            FrescoSystrace.endSection();
            return;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object r100, int r101) {
            onNewResultImpl((EncodedImage) r100, r101);
        }

        public EncodedMemoryCacheConsumer(Consumer<EncodedImage> r100, MemoryCache<CacheKey, PooledByteBuffer> r101, CacheKey r102, boolean r103) {
            super(r100);
            this.mMemoryCache = r101;
            this.mRequestedCacheKey = r102;
            this.mIsMemoryCacheEnabled = r103;
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> r110, ProducerContext r111) {
    L63:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L67;
        FrescoSystrace.endSection();
    L67:
        throw th;
    L4:
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("EncodedMemoryCacheProducer#produceResults");     // Catch: Throwable -> L63
    L6:
        String r100 = r111.getId();     // Catch: Throwable -> L63
        ProducerListener r101 = r111.getListener();     // Catch: Throwable -> L63
        r101.onProducerStart(r100, PRODUCER_NAME);     // Catch: Throwable -> L63
        ImageRequest r102 = r111.getImageRequest();     // Catch: Throwable -> L63
        CacheKey r103 = this.mCacheKeyFactory.getEncodedCacheKey(r102, r111.getCallerContext());     // Catch: Throwable -> L63
        if (r102 == null) goto L15;
        SizeDeterminer r104 = r102.getSizeDeterminer();     // Catch: Throwable -> L63
        if (r104 == null) goto L15;
        if (r104.getSize() == null) goto L15;
        Pair<Integer, Integer> r105 = r104.getSize();     // Catch: Throwable -> L63
        if (r105 == null) goto L15;
        int r106 = ((Integer) r105.first).intValue();     // Catch: Throwable -> L63
        int r107 = ((Integer) r105.second).intValue();     // Catch: Throwable -> L63
    L16:
        CloseableReference<PooledByteBuffer> r108 = this.mMemoryCache.get(r103);     // Catch: Throwable -> L63
        Map<String, String> r112 = null;
        if (r108 == null) goto L40;
        EncodedImage r113 = new EncodedImage(r108);     // Catch: Throwable -> L60
        if (r102 != null) goto L22;
    L24:
        r113.setViewWidth(r106);     // Catch: Throwable -> L60
        r113.setViewHeight(r107);     // Catch: Throwable -> L60
    L35:
        th = move-exception;
        EncodedImage.closeSafely(r113);     // Catch: Throwable -> L60
        throw th;     // Catch: Throwable -> L60
    L26:
        if (r101.requiresExtraMap(r100) == false) goto L28;
        r112 = ImmutableMap.of("cached_value_found", "true");     // Catch: Throwable -> L35
    L28:
        r101.onProducerFinishWithSuccess(r100, PRODUCER_NAME, r112);     // Catch: Throwable -> L35
        r101.onUltimateProducerReached(r100, PRODUCER_NAME, true);     // Catch: Throwable -> L35
        r110.onProgressUpdate(1.0f);     // Catch: Throwable -> L35
        r110.onNewResult(r113, 1);     // Catch: Throwable -> L35
        EncodedImage.closeSafely(r113);     // Catch: Throwable -> L60
        CloseableReference.closeSafely(r108);     // Catch: Throwable -> L63
        if (FrescoSystrace.isTracing() == false) goto L72;
        FrescoSystrace.endSection();
        return;
    L72:
        return;
    L22:
        if (r102.getSourceUri() == null) goto L24;
        r113.setUri(r102.getSourceUri().toString());     // Catch: Throwable -> L60
        goto L24
    L40:
        if (r111.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) goto L42;
        EncodedMemoryCacheConsumer r109 = new EncodedMemoryCacheConsumer(r110, this.mMemoryCache, r103, r111.getImageRequest().isMemoryCacheEnabled());     // Catch: Throwable -> L60
        if (r101.requiresExtraMap(r100) == false) goto L54;
        r112 = ImmutableMap.of("cached_value_found", "false");     // Catch: Throwable -> L60
    L54:
        r101.onProducerFinishWithSuccess(r100, PRODUCER_NAME, r112);     // Catch: Throwable -> L60
        this.mInputProducer.produceResults(r109, r111);     // Catch: Throwable -> L60
        CloseableReference.closeSafely(r108);     // Catch: Throwable -> L63
        if (FrescoSystrace.isTracing() == false) goto L74;
        FrescoSystrace.endSection();
        return;
    L74:
        return;
    L42:
        if (r101.requiresExtraMap(r100) == false) goto L44;
        Map<String, String> r114 = ImmutableMap.of("cached_value_found", "false");     // Catch: Throwable -> L60
    L45:
        r101.onProducerFinishWithSuccess(r100, PRODUCER_NAME, r114);     // Catch: Throwable -> L60
        r101.onUltimateProducerReached(r100, PRODUCER_NAME, false);     // Catch: Throwable -> L60
        r110.onNewResult(null, 1);     // Catch: Throwable -> L60
        CloseableReference.closeSafely(r108);     // Catch: Throwable -> L63
        if (FrescoSystrace.isTracing() == false) goto L73;
        FrescoSystrace.endSection();
        return;
    L73:
        return;
    L44:
        r114 = null;
    L60:
        th = move-exception;
        CloseableReference.closeSafely(r108);     // Catch: Throwable -> L63
        throw th;     // Catch: Throwable -> L63
    L15:
        r107 = 0;
        r106 = 0;
        goto L16
    }

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> r100, CacheKeyFactory r101, Producer<EncodedImage> r102) {
        this.mMemoryCache = r100;
        this.mCacheKeyFactory = r101;
        this.mInputProducer = r102;
    }
}
