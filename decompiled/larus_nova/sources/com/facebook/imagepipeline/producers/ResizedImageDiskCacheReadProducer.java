package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.HashMap;

/* JADX INFO: loaded from: classes23.dex */
public class ResizedImageDiskCacheReadProducer extends DiskCacheReadProducer {
    public static final String PRODUCER_NAME = "ResizedDiskCacheReadProducer";

    @Override // com.facebook.imagepipeline.producers.DiskCacheReadProducer
    public boolean isCacheEnabled(ProducerContext r100) {
        return r100.getImageRequest().isResizedImageDiskCacheActuallyEnabled();
    }

    @Override // com.facebook.imagepipeline.producers.DiskCacheReadProducer
    public CacheKey getKey(CacheKeyFactory r100, ProducerContext r101) {
        return r100.getResizedImageCacheKey(r101.getImageRequest(), r101.getCallerContext());
    }

    public ResizedImageDiskCacheReadProducer(BufferedDiskCache r100, BufferedDiskCache r101, HashMap<String, BufferedDiskCache> r102, CacheKeyFactory r103, Producer<EncodedImage> r104, PooledByteBufferFactory r105) {
        super(r100, r101, r102, r103, r104, r105);
    }
}
