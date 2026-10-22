package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.Closeable;

/* JADX INFO: loaded from: classes23.dex */
public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, String>, EncodedImage> {
    private final CacheKeyFactory mCacheKeyFactory;

    private String buildSecondOfPair(ProducerContext r100) {
        if (r100.getImageRequest().isMultiplexerEnabled() == true) goto L7;
        return r100.getId();
    L7:
        return String.valueOf(r100.getLowestPermittedRequestLevel().getValue());
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public /* bridge */ /* synthetic */ Closeable cloneOrNull(Closeable r100) {
        return cloneOrNull((EncodedImage) r100);
    }

    public ImageFormat getImageFormat(EncodedImage r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return r100.getImageFormat();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public Pair<CacheKey, String> getKey(ProducerContext r100) {
        return Pair.create(this.mCacheKeyFactory.getEncodedCacheKey(r100.getImageRequest(), r100.getCallerContext()), buildSecondOfPair(r100));
    }

    public EncodedImage cloneOrNull(EncodedImage r100) {
        return EncodedImage.cloneOrNull(r100);
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public /* bridge */ /* synthetic */ ImageFormat getImageFormat(Closeable r100) {
        return getImageFormat((EncodedImage) r100);
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public /* bridge */ /* synthetic */ Pair<CacheKey, String> getKey(ProducerContext r100) {
        return getKey(r100);
    }

    public EncodedCacheKeyMultiplexProducer(CacheKeyFactory r100, Producer r101) {
        super(r101);
        this.mCacheKeyFactory = r100;
    }
}
