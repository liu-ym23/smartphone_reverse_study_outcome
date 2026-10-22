package com.facebook.imagepipeline.producers;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public class LocalFileFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalFileFetchProducer";

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return PRODUCER_NAME;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public EncodedImage getEncodedImage(ImageRequest r100) throws IOException {
        return getEncodedImage(new PolarisFileInputStreamWrapper(r100.getSourceFile().toString()), (int) r100.getSourceFile().length());
    }

    public LocalFileFetchProducer(Executor r100, PooledByteBufferFactory r101) {
        super(r100, r101);
    }
}
