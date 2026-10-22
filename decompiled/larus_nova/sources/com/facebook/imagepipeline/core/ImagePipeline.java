package com.facebook.imagepipeline.core;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.optimize.statistics.FrescoTraceListener;
import com.ss.alog.middleware.ALogService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class ImagePipeline {
    public static int CLEAR_ANIM_BITMAP_MEM;
    public static int CLEAR_BIG_BITMAP_MEM;
    public static int CLEAR_BITMAP_MEM;
    public static int CLEAR_PREFETCH_BITMAP_MEM;
    public static int CLEAR_SINGLE_BITMAP_MEM;
    private static final CancellationException PREFETCH_EXCEPTION = null;
    private static boolean isOpenDebug;
    private final MemoryCache<CacheKey, CloseableImage> mAnimBitmapMemoryCache;
    private final MemoryCache<CacheKey, Bitmap> mAnimatedHeifFrameMemoryCache;
    private final MemoryCache<CacheKey, CloseableImage> mBigImgBitmapMemoryCache;
    private final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    private final CacheKeyFactory mCacheKeyFactory;
    private final ImagePipelineConfig mConfig;
    private final HashMap<String, BufferedDiskCache> mCustomImageBufferedDiskCacheMap;
    private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    private AtomicLong mIdCounter;
    private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
    private final Supplier<Boolean> mLazyDataSource;
    private final BufferedDiskCache mMainBufferedDiskCache;
    private final MemoryCache<CacheKey, CloseableImage> mPrefetchImgBitmapMemoryCache;
    private final ProducerSequenceFactory mProducerSequenceFactory;
    private final RequestListener mRequestListener;
    private final MemoryCache<CacheKey, CloseableImage> mSingleBitmapMemoryCache;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;
    private final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
    private final WebpOptSwitch webpOptSwitch;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.core.ImagePipeline$14, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass14 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice = null;

        static {
            int[] r100 = new int[ImageRequest.CacheChoice.values().length];
            $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice = r100;
            r100[ImageRequest.CacheChoice.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[ImageRequest.CacheChoice.SMALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[ImageRequest.CacheChoice.CUSTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
        isOpenDebug = false;
        CLEAR_BITMAP_MEM = 1;
        CLEAR_ANIM_BITMAP_MEM = 2;
        CLEAR_BIG_BITMAP_MEM = 4;
        CLEAR_PREFETCH_BITMAP_MEM = 8;
        CLEAR_SINGLE_BITMAP_MEM = 16;
    }

    private String generateUniqueFutureId() {
        return String.valueOf(this.mIdCounter.getAndIncrement());
    }

    private boolean isCustomCacheMapNullOrEmpty() {
        HashMap<String, BufferedDiskCache> r100 = this.mCustomImageBufferedDiskCacheMap;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isEmpty() == true) goto L8;
        return false;
    }

    public void clearBitmapMemoryCaches() {
        Predicate<CacheKey> r100 = new AnonymousClass6(this);
        this.mBitmapMemoryCache.removeAll(r100);
        MemoryCache<CacheKey, CloseableImage> r101 = this.mSingleBitmapMemoryCache;
        if (r101 == null) goto L5;
        r101.removeAll(r100);
    L5:
        MemoryCache<CacheKey, CloseableImage> r102 = this.mBigImgBitmapMemoryCache;
        if (r102 == null) goto L8;
        r102.removeAll(r100);
    L8:
        MemoryCache<CacheKey, CloseableImage> r103 = this.mAnimBitmapMemoryCache;
        if (r103 == null) goto L11;
        r103.removeAll(r100);
    L11:
        MemoryCache<CacheKey, CloseableImage> r104 = this.mPrefetchImgBitmapMemoryCache;
        if (r104 == null) goto L15;
        r104.removeAll(r100);
        return;
    }

    public void clearDiskCaches() {
        this.mMainBufferedDiskCache.clearAll();
        this.mSmallImageBufferedDiskCache.clearAll();
        if (isCustomCacheMapNullOrEmpty() == true) goto L10;
        Iterator<String> r100 = this.mCustomImageBufferedDiskCacheMap.keySet().iterator();
    L6:
        if (r100.hasNext() == false) goto L16;
        String r101 = r100.next();
        BufferedDiskCache r102 = this.mCustomImageBufferedDiskCacheMap.get(r101);
        if (r102 == null) goto L6;
        r102.clearAll();
        goto L6
    L16:
        return;
    }

    public void clearEncodeMemoryCaches() {
        Predicate<CacheKey> r100 = new AnonymousClass8(this);
        this.mEncodedMemoryCache.removeAll(r100);
    }

    public void clearHeifMemoryCaches() {
        Predicate<CacheKey> r100 = new AnonymousClass9(this);
        MemoryCache<CacheKey, Bitmap> r101 = this.mAnimatedHeifFrameMemoryCache;
        if (r101 == null) goto L6;
        r101.removeAll(r100);
        return;
    }

    public void clearMemoryCaches() {
        Predicate<CacheKey> r100 = new AnonymousClass5(this);
        this.mBitmapMemoryCache.removeAll(r100);
        MemoryCache<CacheKey, CloseableImage> r101 = this.mSingleBitmapMemoryCache;
        if (r101 == null) goto L5;
        r101.removeAll(r100);
    L5:
        MemoryCache<CacheKey, CloseableImage> r102 = this.mBigImgBitmapMemoryCache;
        if (r102 == null) goto L8;
        r102.removeAll(r100);
    L8:
        MemoryCache<CacheKey, CloseableImage> r103 = this.mAnimBitmapMemoryCache;
        if (r103 == null) goto L11;
        r103.removeAll(r100);
    L11:
        MemoryCache<CacheKey, CloseableImage> r104 = this.mPrefetchImgBitmapMemoryCache;
        if (r104 == null) goto L14;
        r104.removeAll(r100);
    L14:
        this.mEncodedMemoryCache.removeAll(r100);
    }

    public boolean isPaused() {
        return this.mThreadHandoffProducerQueue.isQueueing();
    }

    public void pause() {
        if (isOpenDebug == false) goto L5;
        ALogService.iSafely(FrescoTraceListener.ALOGTAG, "ImagePipeline pause!");
    L5:
        this.mThreadHandoffProducerQueue.startQueueing();
    }

    public void resume() {
        if (isOpenDebug == false) goto L5;
        ALogService.iSafely(FrescoTraceListener.ALOGTAG, "ImagePipeline resume!");
    L5:
        this.mThreadHandoffProducerQueue.stopQueuing();
    }

    public void clearCaches() {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public MemoryCache<CacheKey, CloseableImage> getAnimBitmapMemoryCache() {
        return this.mAnimBitmapMemoryCache;
    }

    public MemoryCache<CacheKey, CloseableImage> getBigImgBitmapMemoryCache() {
        return this.mBigImgBitmapMemoryCache;
    }

    public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        return this.mBitmapMemoryCache;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.mCacheKeyFactory;
    }

    public ImagePipelineConfig getConfig() {
        return this.mConfig;
    }

    public WebpOptSwitch getWebpOptSwitch() {
        return this.webpOptSwitch;
    }

    public Supplier<Boolean> isLazyDataSource() {
        return this.mLazyDataSource;
    }

    public static /* synthetic */ boolean access$000(ImagePipeline r100) {
        return r100.isCustomCacheMapNullOrEmpty();
    }

    public static /* synthetic */ HashMap access$100(ImagePipeline r100) {
        return r100.mCustomImageBufferedDiskCacheMap;
    }

    public static /* synthetic */ BufferedDiskCache access$200(ImagePipeline r100) {
        return r100.mSmallImageBufferedDiskCache;
    }

    private Priority getPriority(ImageRequest r100) {
        if (r100 == null) goto L5;
        return r100.getPriority();
    L5:
        return Priority.HIGH;
    }

    public static void openDebug(boolean r100) {
        isOpenDebug = r100;
    }

    private Predicate<CacheKey> predicateForUri(final Uri r100) {
        return new AnonymousClass13(this, r100);
    }

    public void clearAllCustomDiskCacheByTimestamp(long r100) {
        if (isCustomCacheMapNullOrEmpty() == true) goto L10;
        Iterator<String> r101 = this.mCustomImageBufferedDiskCacheMap.keySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        String r102 = r101.next();
        BufferedDiskCache r103 = this.mCustomImageBufferedDiskCacheMap.get(r102);
        if (r103 == null) goto L6;
        r103.clearByTimestamp(r100);
        goto L6
    L16:
        return;
    }

    public void clearBitmapMemoryCaches(int r100) {
        Predicate<CacheKey> r101 = new AnonymousClass7(this);
        if ((CLEAR_BITMAP_MEM | r100) <= 0) goto L6;
        this.mBitmapMemoryCache.removeAll(r101);
    L6:
        if ((CLEAR_SINGLE_BITMAP_MEM | r100) <= 0) goto L11;
        MemoryCache<CacheKey, CloseableImage> r102 = this.mSingleBitmapMemoryCache;
        if (r102 == null) goto L11;
        r102.removeAll(r101);
    L11:
        if ((CLEAR_BIG_BITMAP_MEM | r100) <= 0) goto L16;
        MemoryCache<CacheKey, CloseableImage> r103 = this.mBigImgBitmapMemoryCache;
        if (r103 == null) goto L16;
        r103.removeAll(r101);
    L16:
        if ((CLEAR_ANIM_BITMAP_MEM | r100) <= 0) goto L21;
        MemoryCache<CacheKey, CloseableImage> r104 = this.mAnimBitmapMemoryCache;
        if (r104 == null) goto L21;
        r104.removeAll(r101);
    L21:
        if ((r100 | CLEAR_PREFETCH_BITMAP_MEM) <= 0) goto L26;
        MemoryCache<CacheKey, CloseableImage> r105 = this.mPrefetchImgBitmapMemoryCache;
        if (r105 == null) goto L27;
        r105.removeAll(r101);
        return;
    L27:
        return;
    }

    public void clearCustomDiskCacheByPercentage(Double r100) {
        if (isCustomCacheMapNullOrEmpty() == true) goto L10;
        Iterator<String> r101 = this.mCustomImageBufferedDiskCacheMap.keySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        String r102 = r101.next();
        BufferedDiskCache r103 = this.mCustomImageBufferedDiskCacheMap.get(r102);
        if (r103 == null) goto L6;
        r103.clearByPercentage(r100);
        goto L6
    L16:
        return;
    }

    public void clearMainDiskCacheByPercentage(Double r100) {
        this.mMainBufferedDiskCache.clearByPercentage(r100);
    }

    public void clearMainDiskCacheByTimestamp(long r100) {
        this.mMainBufferedDiskCache.clearByTimestamp(r100);
    }

    public void clearSmallDiskCacheByPercentage(Double r100) {
        this.mSmallImageBufferedDiskCache.clearByPercentage(r100);
    }

    public void clearSmallDiskCacheByTimestamp(long r100) {
        this.mSmallImageBufferedDiskCache.clearByTimestamp(r100);
    }

    public void evictFromCache(Uri r100) {
        evictFromMemoryCache(r100);
        evictFromDiskCache(r100);
    }

    public void evictFromDiskCache(ImageRequest r100) {
        CacheKey r101 = this.mCacheKeyFactory.getEncodedCacheKey(r100, null);
        this.mMainBufferedDiskCache.remove(r101);
        this.mSmallImageBufferedDiskCache.remove(r101);
        if (isCustomCacheMapNullOrEmpty() == true) goto L9;
        if (r100 == null) goto L10;
        BufferedDiskCache r102 = this.mCustomImageBufferedDiskCacheMap.get(r100.getCustomCacheName());
        if (r102 == null) goto L11;
        r102.remove(r101);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void evictFromMemoryCache(Uri r100) {
        ImageRequest r101 = ImageRequest.fromUri(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        final Uri r102 = Uri.parse(DefaultCacheKeyFactory.getInstance().getBitmapCacheKey(r101, null).getUriString());
        Predicate<CacheKey> r103 = new AnonymousClass4(this, r102);
        this.mBitmapMemoryCache.removeAll(r103);
        MemoryCache<CacheKey, CloseableImage> r104 = this.mSingleBitmapMemoryCache;
        if (r104 == null) goto L8;
        r104.removeAll(r103);
    L8:
        MemoryCache<CacheKey, CloseableImage> r105 = this.mBigImgBitmapMemoryCache;
        if (r105 == null) goto L11;
        r105.removeAll(r103);
    L11:
        MemoryCache<CacheKey, CloseableImage> r106 = this.mAnimBitmapMemoryCache;
        if (r106 == null) goto L14;
        r106.removeAll(r103);
    L14:
        MemoryCache<CacheKey, CloseableImage> r107 = this.mPrefetchImgBitmapMemoryCache;
        if (r107 == null) goto L17;
        r107.removeAll(r103);
    L17:
        this.mEncodedMemoryCache.removeAll(r103);
    }

    @Nullable
    public CloseableReference<CloseableImage> getCachedImage(@Nullable CacheKey r100) {
        MemoryCache<CacheKey, CloseableImage> r101 = this.mBitmapMemoryCache;
        if (r101 == null) goto L29;
        if (r100 == null) goto L29;
        MemoryCache<CacheKey, CloseableImage> r102 = this.mBigImgBitmapMemoryCache;
        MemoryCache<CacheKey, CloseableImage> r103 = this.mSingleBitmapMemoryCache;
        MemoryCache<CacheKey, CloseableImage> r104 = this.mPrefetchImgBitmapMemoryCache;
        if (ImagePipelineFactory.getInstance().isEnableSingleCache() == false) goto L10;
        if (r103 == null) goto L10;
        CloseableReference<CloseableImage> r105 = r103.get(r100);
    L11:
        if (r105 == null) goto L13;
    L16:
        if (r105 != null) goto L18;
        r105 = r101.get(r100);
    L18:
        if (r105 == null) goto L20;
    L23:
        if (r105 != null) goto L25;
    L28:
        return r105;
    L25:
        if (r105.get().getQualityInfo().isOfFullQuality() == true) goto L28;
        r105.close();
        return null;
    L20:
        if (ImagePipelineFactory.getInstance().isSplitPrefetchCache() == false) goto L23;
        if (r104 == null) goto L23;
        r105 = r104.get(r100);
        goto L23
    L13:
        if (ImagePipelineFactory.getInstance().isEnableBigImgCache() == false) goto L16;
        if (r102 == null) goto L16;
        r105 = r102.get(r100);
    L10:
        r105 = null;
    L29:
        return null;
    }

    public boolean isInBitmapMemoryCache(ImageRequest r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        CacheKey r101 = this.mCacheKeyFactory.getBitmapCacheKey(r100, null);
        CloseableReference<CloseableImage> r102 = this.mBitmapMemoryCache.get(r101);
        if (r102 == null) goto L8;
    L12:
        if (r102 == null) goto L14;
    L18:
        if (r102 == null) goto L20;
    L30:
        boolean r103 = CloseableReference.isValid(r102);     // Catch: Throwable -> L27
        CloseableReference.closeSafely(r102);
        return r103;
    L27:
        th = move-exception;
        CloseableReference.closeSafely(r102);
        throw th;
    L20:
        if (ImagePipelineFactory.getInstance().isSplitPrefetchCache() == false) goto L30;
        MemoryCache<CacheKey, CloseableImage> r104 = this.mPrefetchImgBitmapMemoryCache;
        if (r104 == null) goto L30;
        r102 = r104.get(r101);
        goto L30
    L14:
        if (ImagePipelineFactory.getInstance().isEnableBigImgCache() == false) goto L18;
        MemoryCache<CacheKey, CloseableImage> r105 = this.mBigImgBitmapMemoryCache;
        if (r105 == null) goto L18;
        r102 = r105.get(r101);
        goto L18
    L8:
        if (ImagePipelineFactory.getInstance().isEnableSingleCache() == false) goto L12;
        MemoryCache<CacheKey, CloseableImage> r106 = this.mSingleBitmapMemoryCache;
        if (r106 == null) goto L12;
        r102 = r106.get(r101);
        goto L12
    }

    public DataSource<Boolean> isInDiskCache(final ImageRequest r100) {
        final CacheKey r101 = this.mCacheKeyFactory.getEncodedCacheKey(r100, null);
        final SimpleDataSource r102 = SimpleDataSource.create();
        this.mMainBufferedDiskCache.contains(r101).continueWithTask(new AnonymousClass12(this, r101)).continueWithTask(new AnonymousClass11(this, r100, r101)).continueWith(new AnonymousClass10(this, r102));
        return r102;
    }

    public boolean isInDiskCacheSync(ImageRequest r100) {
        CacheKey r101 = this.mCacheKeyFactory.getEncodedCacheKey(r100, null);
        ImageRequest.CacheChoice r102 = r100.getCacheChoice();
        int r103 = AnonymousClass14.$SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[r102.ordinal()];
        if (r103 == 1) goto L20;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L10;
        return false;
    L10:
        if (isCustomCacheMapNullOrEmpty() == true) goto L15;
        BufferedDiskCache r104 = this.mCustomImageBufferedDiskCacheMap.get(r100.getCustomCacheName());
        if (r104 != null) goto L14;
        return false;
    L14:
        return r104.diskCheckSync(r101);
    L15:
        return false;
    L18:
        return this.mSmallImageBufferedDiskCache.diskCheckSync(r101);
    L20:
        return this.mMainBufferedDiskCache.diskCheckSync(r101);
    }

    public void setNetWorkFetcher(NetworkFetcher r100) {
        this.mProducerSequenceFactory.setNetworkFetcher(r100);
    }

    public void evictFromDiskCache(Uri r100) {
        evictFromDiskCache(ImageRequest.fromUri(r100));
    }

    public boolean isInBitmapMemoryCache(Uri r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return isInBitmapMemoryCache(ImageRequest.fromUri(r100));
    }

    public DataSource<Boolean> isInDiskCache(Uri r100) {
        return isInDiskCache(ImageRequest.fromUri(r100));
    }

    public boolean isInDiskCacheSync(Uri r100) {
        if (isInDiskCacheSync(r100, ImageRequest.CacheChoice.SMALL) == false) goto L5;
    L8:
        return true;
    L5:
        if (isInDiskCacheSync(r100, ImageRequest.CacheChoice.DEFAULT) == true) goto L8;
        return false;
    }

    public void clearCustomDiskCacheByTimestamp(String r100, long r101) {
        if (isCustomCacheMapNullOrEmpty() == true) goto L8;
        BufferedDiskCache r102 = this.mCustomImageBufferedDiskCacheMap.get(r100);
        if (r102 == null) goto L9;
        r102.clearByTimestamp(r101);
        return;
    L9:
        return;
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest r100, Object r101) {
        return fetchDecodedImage(r100, r101, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest r100, Object r101) {
        return fetchEncodedImage(r100, r101, null);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest r100, Object r101) {
        return fetchDecodedImage(r100, r101, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    @Nullable
    public CacheKey getCacheKey(ImageRequest r100, Object r101) {
        CacheKeyFactory r102 = this.mCacheKeyFactory;
        if (r102 == null) goto L9;
        if (r100 == null) goto L9;
        if (r100.getPostprocessor() == null) goto L12;
        return r102.getPostprocessedBitmapCacheKey(r100, r101);
    L12:
        return r102.getBitmapCacheKey(r100, r101);
    L9:
        return null;
    }

    public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(final ImageRequest r100, final Object r101) {
        return new AnonymousClass3(this, r100, r101);
    }

    public RequestListener getRequestListenerForRequest(ImageRequest r100, @Nullable RequestListener r101) {
        if (r101 != null) goto L11;
        if (r100.getRequestListener() != null) goto L9;
        return this.mRequestListener;
    L9:
        return new ForwardingRequestListener(new RequestListener[]{this.mRequestListener, r100.getRequestListener()});
    L11:
        if (r100.getRequestListener() != null) goto L15;
        return new ForwardingRequestListener(new RequestListener[]{this.mRequestListener, r101});
    L15:
        return new ForwardingRequestListener(new RequestListener[]{this.mRequestListener, r101, r100.getRequestListener()});
    }

    public boolean isInDiskCacheSync(Uri r100, ImageRequest.CacheChoice r101) {
        return isInDiskCacheSync(ImageRequestBuilder.newBuilderWithSource(r100).setCacheChoice(r101).build());
    }

    public DataSource<Void> prefetchToBitmapCache(ImageRequest r100, Object r101) {
        if (this.mIsPrefetchEnabledSupplier.get().booleanValue() == false) goto L5;
    L12:
        e = move-exception;
        return DataSources.immediateFailedDataSource(e);
    L7:
        if (this.mSuppressBitmapPrefetchingSupplier.get().booleanValue() == false) goto L9;
        Producer<Void> r102 = this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(r100);     // Catch: Exception -> L12
    L10:
        return submitPrefetchRequest(r102, r100, ImageRequest.RequestLevel.FULL_FETCH, r101, getPriority(r100));
    L9:
        r102 = this.mProducerSequenceFactory.getDecodedImagePrefetchProducerSequence(r100);     // Catch: Exception -> L12
        goto L10
    L5:
        return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest r100, Object r101) {
        return prefetchToDiskCache(r100, r101, getPriority(r100));
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest r100, Object r101, @Nullable RequestListener r102) {
        return fetchDecodedImage(r100, r101, ImageRequest.RequestLevel.FULL_FETCH, r102);
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest r100, Object r101, @Nullable RequestListener r110) {
        Preconditions.checkNotNull(r100.getSourceUri());
        Producer<CloseableReference<PooledByteBuffer>> r102 = this.mProducerSequenceFactory.getEncodedImageProducerSequence(r100);     // Catch: Exception -> L8
        if (r100.getResizeOptions() == null) goto L6;
        r100 = ImageRequestBuilder.fromRequest(r100).setResizeOptions(null).build();     // Catch: Exception -> L8
    L6:
        return submitFetchRequest(r102, r100, ImageRequest.RequestLevel.FULL_FETCH, r101, r110);
    L8:
        e = move-exception;
        return DataSources.immediateFailedDataSource(e);
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest r100, final Object r101, final ImageRequest.RequestLevel r102) {
        return new AnonymousClass1(this, r100, r101, r102);
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest r100, Object r101, Priority r110) {
        if (this.mIsPrefetchEnabledSupplier.get().booleanValue() == false) goto L5;
        return submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(r100), r100, ImageRequest.RequestLevel.FULL_FETCH, r101, r110);
    L8:
        e = move-exception;
        return DataSources.immediateFailedDataSource(e);
    L5:
        return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest r100, Object r101, ImageRequest.RequestLevel r102) {
        return fetchDecodedImage(r100, r101, r102, null);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest r100, Object r101, ImageRequest.RequestLevel r102, @Nullable RequestListener r110) {
        return fetchDecodedImage(r100, r101, r102, r110, getPriority(r100));
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest r100, final Object r101, final ImageRequest.RequestLevel r110, @Nullable final RequestListener r111) {
        return new AnonymousClass2(this, r100, r101, r110, r111);
    }

    private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> r100, ImageRequest r101, ImageRequest.RequestLevel r110, Object r111, @Nullable RequestListener r112) {
        return submitFetchRequest(r100, r101, r110, r111, r112, getPriority(r101));
    }

    private DataSource<Void> submitPrefetchRequest(Producer<Void> r110, ImageRequest r111, ImageRequest.RequestLevel r112, Object r113, Priority r114) {
        RequestListener r100 = getRequestListenerForRequest(r111, null);
        if (r111 != null) goto L11;
    L6:
        ImageRequest.RequestLevel r101 = ImageRequest.RequestLevel.getMax(r111.getLowestPermittedRequestLevel(), r112);     // Catch: Exception -> L8
        return ProducerToDataSourceAdapter.create(r110, new SettableProducerContext(r111, generateUniqueFutureId(), r100, r113, r101, true, false, Priority.getLowerPriority(r114, Priority.MEDIUM)), r100);
    L8:
        e = move-exception;
        return DataSources.immediateFailedDataSource(e);
    L11:
        r111.setPrefetchMark(true);     // Catch: Exception -> L8
        goto L6
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest r100, Object r110, ImageRequest.RequestLevel r111, @Nullable RequestListener r112, Priority r113) {
        return submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(r100), r100, r111, r110, r112, r113);
    L4:
        e = move-exception;
        return DataSources.immediateFailedDataSource(e);
    }

    private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> r110, ImageRequest r111, ImageRequest.RequestLevel r112, Object r113, @Nullable RequestListener r114, Priority r115) {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
    L5:
        RequestListener r116 = getRequestListenerForRequest(r111, r114);
        ImageRequest.RequestLevel r100 = ImageRequest.RequestLevel.getMax(r111.getLowestPermittedRequestLevel(), r112);     // Catch: Throwable -> L20 Exception -> L22
        String r101 = generateUniqueFutureId();     // Catch: Throwable -> L20 Exception -> L22
        boolean r102 = r111.isPrefetch();     // Catch: Throwable -> L20 Exception -> L22
        if (r111.getProgressiveRenderingEnabled() == false) goto L9;
    L14:
        boolean r103 = true;
    L15:
        DataSource<CloseableReference<T>> r104 = CloseableProducerToDataSourceAdapter.create(r110, new SettableProducerContext(r111, r101, r116, r113, r100, r102, r103, r115), r116);     // Catch: Throwable -> L20 Exception -> L22
    L17:
        if (FrescoSystrace.isTracing() == false) goto L19;
        FrescoSystrace.endSection();
    L19:
        return r104;
    L9:
        if (r111.getProgressiveRenderingAnimatedEnabled() == true) goto L14;
        if (UriUtil.isNetworkUri(r111.getSourceUri()) == false) goto L14;
        r103 = false;
    L22:
        e = move-exception;
        DataSource<CloseableReference<T>> r105 = DataSources.immediateFailedDataSource(e);     // Catch: Throwable -> L20
        if (FrescoSystrace.isTracing() == false) goto L27;
        FrescoSystrace.endSection();
    L27:
        return r105;
    L20:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L31;
        FrescoSystrace.endSection();
    L31:
        throw th;
    }

    public ImagePipeline(ProducerSequenceFactory r110, Set<RequestListener> r111, Supplier<Boolean> r112, MemoryCache<CacheKey, CloseableImage> r210, MemoryCache<CacheKey, Bitmap> r211, MemoryCache<CacheKey, PooledByteBuffer> r212, BufferedDiskCache r213, BufferedDiskCache r214, HashMap<String, BufferedDiskCache> r215, CacheKeyFactory r216, ThreadHandoffProducerQueue r217, Supplier<Boolean> r218, Supplier<Boolean> r219, ImagePipelineConfig r310) {
        this(r110, r111, r112, r210, null, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public ImagePipeline(ProducerSequenceFactory r100, Set<RequestListener> r101, Supplier<Boolean> r102, MemoryCache<CacheKey, CloseableImage> r103, MemoryCache<CacheKey, CloseableImage> r104, MemoryCache<CacheKey, Bitmap> r105, MemoryCache<CacheKey, PooledByteBuffer> r110, BufferedDiskCache r111, BufferedDiskCache r112, HashMap<String, BufferedDiskCache> r113, CacheKeyFactory r114, ThreadHandoffProducerQueue r115, Supplier<Boolean> r116, Supplier<Boolean> r117, ImagePipelineConfig r118) {
        this.mIdCounter = new AtomicLong();
        this.mProducerSequenceFactory = r100;
        this.mRequestListener = new ForwardingRequestListener(r101);
        this.mIsPrefetchEnabledSupplier = r102;
        this.mBitmapMemoryCache = r103;
        InstrumentedMemoryCache<CacheKey, CloseableImage> r106 = null;
        if (ImagePipelineFactory.getInstance().isEnableSingleCache() == false) goto L5;
        InstrumentedMemoryCache<CacheKey, CloseableImage> r107 = ImagePipelineFactory.getInstance().getSingleBitmapMemoryCache();
    L6:
        this.mSingleBitmapMemoryCache = r107;
        if (ImagePipelineFactory.getInstance().isEnableBigImgCache() == false) goto L9;
        InstrumentedMemoryCache<CacheKey, CloseableImage> r108 = ImagePipelineFactory.getInstance().getBigImgBitmapMemoryCache();
    L10:
        this.mBigImgBitmapMemoryCache = r108;
        if (ImagePipelineFactory.getInstance().isSplitPrefetchCache() == false) goto L13;
        r106 = ImagePipelineFactory.getInstance().getPrefetchImgBitmapMemoryCache();
    L13:
        this.mPrefetchImgBitmapMemoryCache = r106;
        this.mAnimBitmapMemoryCache = r104;
        this.mAnimatedHeifFrameMemoryCache = r105;
        this.mEncodedMemoryCache = r110;
        this.mMainBufferedDiskCache = r111;
        this.mSmallImageBufferedDiskCache = r112;
        this.mCustomImageBufferedDiskCacheMap = r113;
        this.mCacheKeyFactory = r114;
        this.mThreadHandoffProducerQueue = r115;
        this.mSuppressBitmapPrefetchingSupplier = r116;
        this.mLazyDataSource = r117;
        this.webpOptSwitch = new WebpOptSwitch();
        this.mConfig = r118;
        return;
    L9:
        r108 = null;
        goto L10
    L5:
        r107 = null;
        goto L6
    }
}
