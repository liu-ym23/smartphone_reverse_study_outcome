package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public class LocalAssetFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalAssetFetchProducer";
    private final AssetManager mAssetManager;

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return PRODUCER_NAME;
    }

    private static String getAssetName(ImageRequest r100) {
        return r100.getSourceUri().getPath().substring(1);
    }

    private int getLength(ImageRequest r100) {
        AssetFileDescriptor r101 = null;
        r101 = this.mAssetManager.openFd(getAssetName(r100));     // Catch: Throwable -> L7 IOException -> L11
        int r102 = (int) r101.getLength();
        r101.close();     // Catch: IOException -> L15
    L6:
        return r102;
    L11:
        if (r101 == null) goto L26;
        r101.close();     // Catch: IOException -> L17
        return -1;
    L27:
        return -1;
    L26:
        return -1;
    L7:
        th = move-exception;
        if (r101 != null) goto L18;
    L10:
        throw th;
    L18:
        r101.close();     // Catch: IOException -> L16
        goto L10
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public EncodedImage getEncodedImage(ImageRequest r100) throws IOException {
        return getEncodedImage(this.mAssetManager.open(getAssetName(r100), 2), getLength(r100));
    }

    public LocalAssetFetchProducer(Executor r100, PooledByteBufferFactory r101, AssetManager r102) {
        super(r100, r101);
        this.mAssetManager = r102;
    }
}
