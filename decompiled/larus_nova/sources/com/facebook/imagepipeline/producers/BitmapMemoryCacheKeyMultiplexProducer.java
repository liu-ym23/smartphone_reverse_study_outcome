package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.io.Closeable;

/* JADX INFO: loaded from: classes23.dex */
public class BitmapMemoryCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, String>, CloseableReference<CloseableImage>> {
    private final CacheKeyFactory mCacheKeyFactory;

    private String buildSecondOfPair(ProducerContext r100) {
        if (r100.getImageRequest().isMultiplexerEnabled() == true) goto L7;
        return r100.getId();
    L7:
        return String.valueOf(r100.getLowestPermittedRequestLevel().getValue());
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public /* bridge */ /* synthetic */ Closeable cloneOrNull(Closeable r100) {
        return cloneOrNull((CloseableReference) r100);
    }

    public CloseableReference<CloseableImage> cloneResultOrNull(CloseableReference<CloseableImage> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.get() != null) goto L6;
        return null;
    L6:
        return CloseableReference.of(r100.get().cloneOrNull());
    }

    public ImageFormat getImageFormat(CloseableReference<CloseableImage> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.get() != null) goto L6;
        return null;
    L6:
        return r100.get().getImageFormat();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public Pair<CacheKey, String> getKey(ProducerContext r100) {
        return Pair.create(this.mCacheKeyFactory.getBitmapCacheKey(r100.getImageRequest(), r100.getCallerContext()), buildSecondOfPair(r100));
    }

    public CloseableReference<CloseableImage> cloneOrNull(CloseableReference<CloseableImage> r100) {
        return CloseableReference.cloneOrNull(r100);
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public /* bridge */ /* synthetic */ Closeable cloneResultOrNull(Closeable r100) {
        return cloneResultOrNull((CloseableReference) r100);
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public /* bridge */ /* synthetic */ ImageFormat getImageFormat(Closeable r100) {
        return getImageFormat((CloseableReference) r100);
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public /* bridge */ /* synthetic */ Pair<CacheKey, String> getKey(ProducerContext r100) {
        return getKey(r100);
    }

    public BitmapMemoryCacheKeyMultiplexProducer(CacheKeyFactory r100, Producer r101) {
        super(r101);
        this.mCacheKeyFactory = r100;
    }
}
