package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes23.dex */
public class ResizedImageCacheKeyMultiplexProducer extends EncodedCacheKeyMultiplexProducer {
    private final CacheKeyFactory mCacheKeyFactory;

    private String buildSecondOfPair(ProducerContext r100) {
        if (r100.getImageRequest().isMultiplexerEnabled() == true) goto L7;
        return r100.getId();
    L7:
        return String.valueOf(r100.getLowestPermittedRequestLevel().getValue());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer, com.facebook.imagepipeline.producers.MultiplexProducer
    public Pair<CacheKey, String> getKey(ProducerContext r100) {
        ImageRequest r101 = r100.getImageRequest();
        return Pair.create(this.mCacheKeyFactory.getResizedImageCacheKey(r101, r100.getCallerContext()), buildSecondOfPair(r100));
    }

    @Override // com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer, com.facebook.imagepipeline.producers.MultiplexProducer
    public /* bridge */ /* synthetic */ Pair<CacheKey, String> getKey(ProducerContext r100) {
        return getKey(r100);
    }

    public ResizedImageCacheKeyMultiplexProducer(CacheKeyFactory r100, Producer r101) {
        super(r100, r101);
        this.mCacheKeyFactory = r100;
    }
}
