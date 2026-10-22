package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes23.dex */
public class BitmapMemoryCacheGetProducer extends BitmapMemoryCacheProducer {
    public static final String PRODUCER_NAME = "BitmapMemoryCacheGetProducer";

    @Override // com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer
    public String getProducerName() {
        return PRODUCER_NAME;
    }

    @Override // com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer
    public Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> r100, CacheKey r101, boolean r102, Object r103, ImageRequest r104) {
        return r100;
    }

    public BitmapMemoryCacheGetProducer(MemoryCache<CacheKey, CloseableImage> r100, CacheKeyFactory r101, Producer<CloseableReference<CloseableImage>> r102) {
        super(r100, r101, r102);
    }
}
