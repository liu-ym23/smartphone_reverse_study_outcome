package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public abstract class LocalFetchProducer implements Producer<EncodedImage> {
    private final Executor mExecutor;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    public abstract EncodedImage getEncodedImage(ImageRequest r100) throws IOException;

    public abstract String getProducerName();

    public LocalFetchProducer(Executor r100, PooledByteBufferFactory r101) {
        this.mExecutor = r100;
        this.mPooledByteBufferFactory = r101;
    }

    public EncodedImage getByteBufferBackedEncodedImage(InputStream r100, int r101) throws IOException {
        CloseableReference r102 = null;
        if (r101 > 0) goto L5;
        CloseableReference r103 = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(r100));     // Catch: Throwable -> L9
    L6:
        r102 = r103;
        EncodedImage r104 = new EncodedImage(r102);     // Catch: Throwable -> L9
        Closeables.closeQuietly(r100);
        CloseableReference.closeSafely(r102);
        return r104;
    L5:
        r103 = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(r100, r101));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Closeables.closeQuietly(r100);
        CloseableReference.closeSafely(r102);
        throw th;
    }

    public EncodedImage getEncodedImage(InputStream r100, int r101) throws IOException {
        return getByteBufferBackedEncodedImage(r100, r101);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(final Consumer<EncodedImage> r110, ProducerContext r111) {
        final ProducerListener r100 = r111.getListener();
        final String r101 = r111.getId();
        final ImageRequest r102 = r111.getImageRequest();
        final String r103 = getProducerName();
        final StatefulProducerRunnable<EncodedImage> r104 = new AnonymousClass1(this, r110, r100, r103, r101, r102, r100, r101);
        r111.addCallbacks(new AnonymousClass2(this, r104));
        this.mExecutor.execute(r104);
    }
}
