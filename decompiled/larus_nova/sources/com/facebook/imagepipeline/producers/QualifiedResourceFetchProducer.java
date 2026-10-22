package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public class QualifiedResourceFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "QualifiedResourceFetchProducer";
    private final ContentResolver mContentResolver;

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return PRODUCER_NAME;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public EncodedImage getEncodedImage(ImageRequest r100) throws IOException {
        Uri r101 = r100.getSourceUri();
        return getEncodedImage(ContentResolverWrapper.openInputStream(this.mContentResolver, r101), -1);
    }

    public QualifiedResourceFetchProducer(Executor r100, PooledByteBufferFactory r101, ContentResolver r102) {
        super(r100, r101);
        this.mContentResolver = r102;
    }
}
