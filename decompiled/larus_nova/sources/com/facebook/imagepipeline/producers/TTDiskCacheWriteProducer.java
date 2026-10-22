package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.HashMap;

/* JADX INFO: loaded from: classes23.dex */
public class TTDiskCacheWriteProducer extends DiskCacheWriteProducer {
    static final String PRODUCER_NAME = "DiskCacheProducer";
    private final Producer<EncodedImage> mInputProducer;

    @Override // com.facebook.imagepipeline.producers.DiskCacheWriteProducer, com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> r100, ProducerContext r101) {
        this.mInputProducer.produceResults(r100, r101);
    }

    public TTDiskCacheWriteProducer(BufferedDiskCache r100, BufferedDiskCache r101, HashMap<String, BufferedDiskCache> r102, CacheKeyFactory r103, Producer<EncodedImage> r104, PooledByteBufferFactory r105) {
        super(r100, r101, r102, r103, r104, r105);
        this.mInputProducer = r104;
    }
}
