package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class DiskCacheWriteProducer implements Producer<EncodedImage> {
    public static final String PRODUCER_NAME = "DiskCacheWriteProducer";
    private static final String TAG = "DiskCacheWriteProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final HashMap<String, BufferedDiskCache> mCustomImageBufferedDiskCacheMap;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final Producer<EncodedImage> mInputProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.DiskCacheWriteProducer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DiskCacheWriteConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final boolean isCache;
        private final CacheKeyFactory mCacheKeyFactory;
        private final HashMap<String, BufferedDiskCache> mCustomImageBufferedDiskCacheMap;
        private final BufferedDiskCache mDefaultBufferedDiskCache;
        private String mImageType;
        private final PooledByteBufferFactory mPooledByteBufferFactory;
        private final ProducerContext mProducerContext;
        private final BufferedDiskCache mSmallImageBufferedDiskCache;

        public String getImageType() {
            return this.mImageType;
        }

        private EncodedImage getDecryptEncodeImage(EncodedImage r100) {
            byte[] r101 = ((ForwardingRequestListener) this.mProducerContext.getListener()).decrypt(r100.getInputStream());
            if (r101 != null) goto L5;
        L17:
            return r100;
        L5:
            if (r101.length <= 0) goto L17;
            PooledByteBufferOutputStream r102 = this.mPooledByteBufferFactory.newOutputStream(r101.length);
            CloseableReference r103 = null;
            r102.write(r101, 0, r101.length);     // Catch: Throwable -> L10 IOException -> L12
            r103 = CloseableReference.of(r102.toByteBuffer());     // Catch: Throwable -> L10 IOException -> L12
            EncodedImage r104 = new EncodedImage(r103);     // Catch: Throwable -> L10 IOException -> L12
            r104.copyMetaDataFrom(r100);     // Catch: Throwable -> L10 IOException -> L12
            r104.parseMetaData();     // Catch: Throwable -> L10 IOException -> L12
            CloseableReference.closeSafely(r103);
            return r104;
        L10:
            th = move-exception;
            CloseableReference.closeSafely(r103);
            throw th;
        L12:
            e = move-exception;
            FLog.e("DiskCacheWriteProducer", "Construct decrypted data error", e);     // Catch: Throwable -> L10
            CloseableReference.closeSafely(r103);
            goto L17
        }

        public void onNewResultImpl(EncodedImage r100, int r110) {
            if (BaseConsumer.isNotLast(r110) == true) goto L35;
            if (r100 == null) goto L35;
            if (BaseConsumer.statusHasAnyFlag(r110, 10) == true) goto L35;
            String r101 = this.mProducerContext.getId();
            this.mProducerContext.getListener().onProducerStart(r101, "DiskCacheWriteProducer");
            EncodedImage r102 = getDecryptEncodeImage(r100);
            this.mImageType = r102.getImageFormat().getName();     // Catch: Throwable -> L32
            if (r102.getImageFormat() != ImageFormat.UNKNOWN) goto L16;
            getConsumer().onNewResult(r102, r110);     // Catch: Throwable -> L32
            EncodedImage.closeSafely(r102);
            return;
        L16:
            if (this.isCache == true) goto L20;
            this.mProducerContext.getListener().onProducerFinishWithSuccess(r101, "DiskCacheWriteProducer", DiskCacheWriteProducer.getExtraMap(this.mProducerContext.getListener(), r101, getImageType(), r102.getWidth() + "x" + r102.getHeight()));     // Catch: Throwable -> L32
            getConsumer().onNewResult(r102, r110);     // Catch: Throwable -> L32
            EncodedImage.closeSafely(r102);
            return;
        L20:
            ImageRequest r103 = this.mProducerContext.getImageRequest();     // Catch: Throwable -> L32
            CacheKey r104 = this.mCacheKeyFactory.getEncodedCacheKey(r103, this.mProducerContext.getCallerContext());     // Catch: Throwable -> L32
            if (r103.getCacheChoice() != ImageRequest.CacheChoice.SMALL) goto L24;
            this.mSmallImageBufferedDiskCache.put(r104, r100);     // Catch: Throwable -> L32
        L29:
            this.mProducerContext.getListener().onProducerFinishWithSuccess(r101, "DiskCacheWriteProducer", DiskCacheWriteProducer.getExtraMap(this.mProducerContext.getListener(), r101, getImageType(), r102.getWidth() + "x" + r102.getHeight()));     // Catch: Throwable -> L32
            getConsumer().onNewResult(r102, r110);     // Catch: Throwable -> L32
            EncodedImage.closeSafely(r102);
            return;
        L24:
            if (r103.getCacheChoice() != ImageRequest.CacheChoice.CUSTOM) goto L28;
            BufferedDiskCache r105 = this.mCustomImageBufferedDiskCacheMap.get(r103.getCustomCacheName());     // Catch: Throwable -> L32
            if (r105 == null) goto L29;
            r105.put(r104, r100);     // Catch: Throwable -> L32
            goto L29
        L28:
            this.mDefaultBufferedDiskCache.put(r104, r100);     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            EncodedImage.closeSafely(r102);
            throw th;
        L35:
            getConsumer().onNewResult(r100, r110);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object r100, int r101) {
            onNewResultImpl((EncodedImage) r100, r101);
        }

        private DiskCacheWriteConsumer(Consumer<EncodedImage> r110, ProducerContext r111, BufferedDiskCache r112, BufferedDiskCache r113, HashMap<String, BufferedDiskCache> r114, CacheKeyFactory r115, PooledByteBufferFactory r116) {
            this(r110, r111, r112, r113, r114, r115, true, r116);
        }

        private DiskCacheWriteConsumer(Consumer<EncodedImage> r100, ProducerContext r101, BufferedDiskCache r102, BufferedDiskCache r103, HashMap<String, BufferedDiskCache> r104, CacheKeyFactory r105, boolean r106, PooledByteBufferFactory r107) {
            super(r100);
            this.mProducerContext = r101;
            this.mDefaultBufferedDiskCache = r102;
            this.mSmallImageBufferedDiskCache = r103;
            this.mCustomImageBufferedDiskCacheMap = r104;
            this.mCacheKeyFactory = r105;
            this.isCache = r106;
            this.mPooledByteBufferFactory = r107;
        }

        public /* synthetic */ DiskCacheWriteConsumer(Consumer r100, ProducerContext r101, BufferedDiskCache r102, BufferedDiskCache r103, HashMap r104, CacheKeyFactory r105, boolean r106, PooledByteBufferFactory r107, AnonymousClass1 r108) {
            this(r100, r101, r102, r103, r104, r105, r106, r107);
        }
    }

    private void maybeStartInputProducer(Consumer<EncodedImage> r110, ProducerContext r111) {
        if (r111.getLowestPermittedRequestLevel().getValue() < ImageRequest.RequestLevel.DISK_CACHE.getValue()) goto L5;
        r110.onNewResult(null, 1);
        return;
    L5:
        DiskCacheWriteConsumer r100 = new DiskCacheWriteConsumer(r110, r111, this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCustomImageBufferedDiskCacheMap, this.mCacheKeyFactory, r111.getImageRequest().isDiskCacheEnabled(), this.mPooledByteBufferFactory, null);
        this.mInputProducer.produceResults(r100, r111);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> r100, ProducerContext r101) {
        maybeStartInputProducer(r100, r101);
    }

    public static Map<String, String> getExtraMap(ProducerListener r100, String r101, String r102) {
        if (r100.requiresExtraMap(r101) == true) goto L7;
        return null;
    L7:
        return ImmutableMap.of("imageType", r102);
    }

    public static Map<String, String> getExtraMap(ProducerListener r100, String r101, String r102, String r103) {
        if (r100.requiresExtraMap(r101) == true) goto L7;
        return null;
    L7:
        return ImmutableMap.of("imageType", r102, "encodedImageSize", r103);
    }

    public DiskCacheWriteProducer(BufferedDiskCache r100, BufferedDiskCache r101, HashMap<String, BufferedDiskCache> r102, CacheKeyFactory r103, Producer<EncodedImage> r104, PooledByteBufferFactory r105) {
        this.mDefaultBufferedDiskCache = r100;
        this.mSmallImageBufferedDiskCache = r101;
        this.mCustomImageBufferedDiskCacheMap = r102;
        this.mCacheKeyFactory = r103;
        this.mInputProducer = r104;
        this.mPooledByteBufferFactory = r105;
    }
}
