package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes23.dex */
public class DiskCacheReadProducer implements Producer<EncodedImage> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "DiskCacheProducer";
    private static final String TAG = "DiskCacheProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final HashMap<String, BufferedDiskCache> mCustomImageBufferedDiskCacheMap;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final Producer<EncodedImage> mInputProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    public static /* synthetic */ boolean access$000(Task r100) {
        return isTaskCancelled(r100);
    }

    public static /* synthetic */ Producer access$100(DiskCacheReadProducer r100) {
        return r100.mInputProducer;
    }

    public static /* synthetic */ PooledByteBufferFactory access$200(DiskCacheReadProducer r100) {
        return r100.mPooledByteBufferFactory;
    }

    private static boolean isTaskCancelled(Task<?> r100) {
        if (r100.isCancelled() == false) goto L5;
    L10:
        return true;
    L5:
        if (r100.isFaulted() == true) goto L7;
    L9:
        return false;
    L7:
        if ((r100.getError() instanceof CancellationException) == false) goto L9;
        goto L9
    }

    public boolean isCacheEnabled(ProducerContext r100) {
        return r100.getImageRequest().isDiskCacheEnabled();
    }

    private void maybeStartInputProducer(Consumer<EncodedImage> r100, ProducerContext r101) {
        if (r101.getLowestPermittedRequestLevel().getValue() < ImageRequest.RequestLevel.DISK_CACHE.getValue()) goto L6;
        r100.onNewResult(null, 1);
        return;
    L6:
        this.mInputProducer.produceResults(r100, r101);
    }

    private Continuation<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> r100, final ProducerContext r101) {
        final String r102 = r101.getId();
        final ProducerListener r103 = r101.getListener();
        return new AnonymousClass1(this, r103, r102, r100, r101);
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean r100, ProducerContext r101) {
        r101.addCallbacks(new AnonymousClass2(this, r100));
    }

    public CacheKey getKey(CacheKeyFactory r100, ProducerContext r101) {
        return r100.getEncodedCacheKey(r101.getImageRequest(), r101.getCallerContext());
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> r100, ProducerContext r101) {
        ImageRequest r102 = r101.getImageRequest();
        if (isCacheEnabled(r101) == true) goto L6;
        maybeStartInputProducer(r100, r101);
        return;
    L6:
        r101.getListener().onProducerStart(r101.getId(), "DiskCacheProducer");
        CacheKey r103 = getKey(this.mCacheKeyFactory, r101);
        boolean r104 = true;
        if (r102.getCacheChoice() != ImageRequest.CacheChoice.SMALL) goto L9;
        boolean r105 = true;
    L11:
        if (r102.getCacheChoice() == ImageRequest.CacheChoice.CUSTOM) goto L14;
        r104 = false;
    L14:
        if (r104 == false) goto L16;
        BufferedDiskCache r106 = this.mCustomImageBufferedDiskCacheMap.get(r102.getCustomCacheName());
    L17:
        if (r106 != null) goto L21;
        if (r105 == false) goto L20;
        r106 = this.mSmallImageBufferedDiskCache;
        goto L21
    L20:
        r106 = this.mDefaultBufferedDiskCache;
    L21:
        AtomicBoolean r107 = new AtomicBoolean(false);
        r106.get(r103, r107).continueWith(onFinishDiskReads(r100, r101));
        subscribeTaskForRequestCancellation(r107, r101);
        return;
    L16:
        r106 = null;
        goto L17
    L9:
        r105 = false;
        goto L11
    }

    public static Map<String, String> getExtraMap(ProducerListener r100, String r101, boolean r102, int r103) {
        if (r100.requiresExtraMap(r101) == true) goto L7;
        return null;
    L7:
        if (r102 == false) goto L11;
        return ImmutableMap.of("cached_value_found", String.valueOf(r102), "encodedImageSize", String.valueOf(r103));
    L11:
        return ImmutableMap.of("cached_value_found", String.valueOf(r102));
    }

    public DiskCacheReadProducer(BufferedDiskCache r100, BufferedDiskCache r101, HashMap<String, BufferedDiskCache> r102, CacheKeyFactory r103, Producer<EncodedImage> r104, PooledByteBufferFactory r105) {
        this.mDefaultBufferedDiskCache = r100;
        this.mSmallImageBufferedDiskCache = r101;
        this.mCustomImageBufferedDiskCacheMap = r102;
        this.mCacheKeyFactory = r103;
        this.mInputProducer = r104;
        this.mPooledByteBufferFactory = r105;
    }
}
