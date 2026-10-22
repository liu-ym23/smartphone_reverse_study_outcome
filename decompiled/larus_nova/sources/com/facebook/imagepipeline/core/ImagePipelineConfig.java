package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.fresco.cloudcontrol.ImageFormatUtils;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.datasource.FrescoOptUtil;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class ImagePipelineConfig {
    public static final long DEFAULT_BIG_IMG_SIZE_LIMIT = 2097152;
    private static ImagePipelineConfig mImagePipelineConfig;
    private static boolean mWasImmediate;
    private static DefaultImageRequestConfig sDefaultImageRequestConfig;
    public static volatile boolean sIsLazyInit;
    public static boolean useSingleImageRequest;
    private ImagePipelineConfigLazySet mImagePipelineConfigLazySet;

    public static class Builder {
        private static int mHeicDecodeThreads = 1;
        private static boolean mHeicUseWpp = false;
        private static int mHeifDecodeThreads = 1;
        private static boolean mHeifUseWpp = false;
        private static boolean mOptMultiOriginListener = false;
        private static boolean mSRAutoScaleLowerFirst = false;
        private static boolean mUseNewOptHeifBitmap = false;
        private static boolean mUseOptHeifBitmap = false;
        private static int mVvicDecodeThreads = 1;
        private static boolean mVvicUseWpp;
        private Supplier<MemoryCacheParams> mAnimBitmapMemoryCacheParamsSupplier;
        private boolean mAnimatedHeifIndividualCacheEnabled;
        private boolean mAnimatedHeifIndividualCacheForImageRequestEnabled;
        private Supplier<MemoryCacheParams> mBigImgBitmapMemoryCacheParamsSupplier;
        private long mBigImgSizeLimit;
        private Bitmap.Config mBitmapConfig;
        private Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
        private CountingMemoryCache.CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
        private CacheKeyFactory mCacheKeyFactory;
        private final Context mContext;
        private HashMap<String, DiskCacheConfig> mCustomImageDiskCacheConfigMap;
        private boolean mDiskCacheEnabled;
        private boolean mDownsampleEnabled;
        private boolean mEnableAddLogUriInfo;
        private boolean mEnableBigImgCache;
        private boolean mEnableNewLocalVideoThumbnailOpt;
        private boolean mEnableSingleMemCache;
        private Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
        private ExecutorSupplier mExecutorSupplier;
        private final ImagePipelineExperiments.Builder mExperimentsBuilder;
        private FileCacheFactory mFileCacheFactory;
        private int mHttpConnectionTimeout;
        private ImageCacheStatsTracker mImageCacheStatsTracker;
        private ImageDecoder mImageDecoder;
        private ImageDecoderConfig mImageDecoderConfig;
        private ImageTranscoderFactory mImageTranscoderFactory;

        @Nullable
        private Integer mImageTranscoderType;
        private Supplier<Boolean> mIsPrefetchEnabledSupplier;
        private boolean mIsSplitMemCache;
        private boolean mIsSplitPrefetchCache;
        private DiskCacheConfig mMainDiskCacheConfig;

        @Nullable
        private Integer mMemoryChunkType;
        private MemoryTrimmableRegistry mMemoryTrimmableRegistry;
        private NetworkFetcher mNetworkFetcher;
        private boolean mOptPrefetchCacheKey;
        private PlatformBitmapFactory mPlatformBitmapFactory;
        private PoolFactory mPoolFactory;
        private Supplier<MemoryCacheParams> mPrefetchImgBitmapMemoryCacheParamsSupplier;
        private ProgressiveJpegConfig mProgressiveJpegConfig;
        private Set<RequestListener> mRequestListeners;
        private boolean mResizeAndRotateEnabledForNetwork;
        private boolean mRetainPreviousImage;
        private boolean mSaveAfterSrPostBitmap;
        private boolean mSavePreSrPostBitmap;
        private boolean mShowHeifDebugLog;
        private Supplier<MemoryCacheParams> mSingleBitmapMemoryCacheParamsSupplier;
        private DiskCacheConfig mSmallImageDiskCacheConfig;
        private Map<String, String> mWaitParseParamFromUrl;
        private boolean mWasImmediate;

        public ImagePipelineConfig build() {
            return new ImagePipelineConfig(this, null);
        }

        public ImagePipelineExperiments.Builder experiment() {
            return this.mExperimentsBuilder;
        }

        public long getBigImgSizeLimit() {
            return this.mBigImgSizeLimit;
        }

        public int getHeicDecodeThreads() {
            return mHeicDecodeThreads;
        }

        public int getHeifDecodeThreads() {
            return mHeifDecodeThreads;
        }

        @Nullable
        public Integer getImageTranscoderType() {
            return this.mImageTranscoderType;
        }

        @Nullable
        public Integer getMemoryChunkType() {
            return this.mMemoryChunkType;
        }

        public int getVvicDecodeThreads() {
            return mVvicDecodeThreads;
        }

        public Map<String, String> getWaitParseParamFromUrl() {
            return this.mWaitParseParamFromUrl;
        }

        public boolean isDiskCacheEnabled() {
            return this.mDiskCacheEnabled;
        }

        public boolean isDownsampleEnabled() {
            return this.mDownsampleEnabled;
        }

        public boolean isEnableAnimatedHeifIndividualCache() {
            return this.mAnimatedHeifIndividualCacheEnabled;
        }

        public boolean isEnableAnimatedHeifIndividualCacheForImageRequest() {
            return this.mAnimatedHeifIndividualCacheForImageRequestEnabled;
        }

        public boolean isEnableBigImgCache() {
            return this.mEnableBigImgCache;
        }

        public boolean isEnableSingleMemCache() {
            return this.mEnableSingleMemCache;
        }

        public boolean isHeicUseWpp() {
            return mHeicUseWpp;
        }

        public boolean isHeifUseWpp() {
            return mHeifUseWpp;
        }

        public boolean isNewLocalVideoThumbnailOptEnabled() {
            return this.mEnableNewLocalVideoThumbnailOpt;
        }

        public boolean isOptAddLogUriInfo() {
            return this.mEnableAddLogUriInfo;
        }

        public boolean isOptMultiOriginListener() {
            return mOptMultiOriginListener;
        }

        public boolean isOptPrefetchCacheKey() {
            return this.mOptPrefetchCacheKey;
        }

        public boolean isResizeAndRotateEnabledForNetwork() {
            return this.mResizeAndRotateEnabledForNetwork;
        }

        public boolean isRetainPreviousImage() {
            return this.mRetainPreviousImage;
        }

        public boolean isSRAutoScaleLowerFirst() {
            return mSRAutoScaleLowerFirst;
        }

        public boolean isSaveAfterPostBitmap() {
            return this.mSaveAfterSrPostBitmap;
        }

        public boolean isSavePrePostBitmap() {
            return this.mSavePreSrPostBitmap;
        }

        public boolean isShowHeifDebugLog() {
            return this.mShowHeifDebugLog;
        }

        public boolean isSplitMemCache() {
            return this.mIsSplitMemCache;
        }

        public boolean isSplitPrefetchCache() {
            return this.mIsSplitPrefetchCache;
        }

        public boolean isUseNewOptHeifBitmap() {
            return mUseNewOptHeifBitmap;
        }

        public boolean isUseOptHeifBitmap() {
            return mUseOptHeifBitmap;
        }

        public boolean isVvicUseWpp() {
            return mVvicUseWpp;
        }

        private Builder(Context r100) {
            this.mDownsampleEnabled = FrescoOptUtil.isDownsampleEnabled();
            this.mImageTranscoderType = null;
            this.mMemoryChunkType = null;
            this.mResizeAndRotateEnabledForNetwork = true;
            this.mHttpConnectionTimeout = -1;
            this.mExperimentsBuilder = new ImagePipelineExperiments.Builder(this);
            this.mDiskCacheEnabled = true;
            this.mAnimatedHeifIndividualCacheEnabled = false;
            this.mAnimatedHeifIndividualCacheForImageRequestEnabled = false;
            this.mWasImmediate = true;
            this.mIsSplitMemCache = false;
            this.mEnableSingleMemCache = false;
            this.mShowHeifDebugLog = false;
            this.mEnableBigImgCache = false;
            this.mBigImgSizeLimit = 2097152;
            this.mRetainPreviousImage = false;
            this.mSavePreSrPostBitmap = true;
            this.mSaveAfterSrPostBitmap = false;
            this.mEnableNewLocalVideoThumbnailOpt = false;
            this.mIsSplitPrefetchCache = false;
            this.mOptPrefetchCacheKey = false;
            this.mEnableAddLogUriInfo = false;
            this.mContext = (Context) Preconditions.checkNotNull(r100);
        }

        public static /* synthetic */ ImagePipelineExperiments.Builder access$100(Builder r100) {
            return r100.mExperimentsBuilder;
        }

        public static /* synthetic */ CacheKeyFactory access$1000(Builder r100) {
            return r100.mCacheKeyFactory;
        }

        public static /* synthetic */ FileCacheFactory access$1100(Builder r100) {
            return r100.mFileCacheFactory;
        }

        public static /* synthetic */ boolean access$1200(Builder r100) {
            return r100.mDownsampleEnabled;
        }

        public static /* synthetic */ Supplier access$1300(Builder r100) {
            return r100.mEncodedMemoryCacheParamsSupplier;
        }

        public static /* synthetic */ ImageCacheStatsTracker access$1400(Builder r100) {
            return r100.mImageCacheStatsTracker;
        }

        public static /* synthetic */ ImageDecoder access$1500(Builder r100) {
            return r100.mImageDecoder;
        }

        public static /* synthetic */ Integer access$1600(Builder r100) {
            return r100.mImageTranscoderType;
        }

        public static /* synthetic */ Supplier access$1700(Builder r100) {
            return r100.mIsPrefetchEnabledSupplier;
        }

        public static /* synthetic */ DiskCacheConfig access$1800(Builder r100) {
            return r100.mMainDiskCacheConfig;
        }

        public static /* synthetic */ MemoryTrimmableRegistry access$1900(Builder r100) {
            return r100.mMemoryTrimmableRegistry;
        }

        public static /* synthetic */ Supplier access$200(Builder r100) {
            return r100.mBitmapMemoryCacheParamsSupplier;
        }

        public static /* synthetic */ int access$2000(Builder r100) {
            return r100.mHttpConnectionTimeout;
        }

        public static /* synthetic */ NetworkFetcher access$2100(Builder r100) {
            return r100.mNetworkFetcher;
        }

        public static /* synthetic */ PlatformBitmapFactory access$2200(Builder r100) {
            return r100.mPlatformBitmapFactory;
        }

        public static /* synthetic */ PoolFactory access$2300(Builder r100) {
            return r100.mPoolFactory;
        }

        public static /* synthetic */ ProgressiveJpegConfig access$2400(Builder r100) {
            return r100.mProgressiveJpegConfig;
        }

        public static /* synthetic */ Set access$2500(Builder r100) {
            return r100.mRequestListeners;
        }

        public static /* synthetic */ boolean access$2600(Builder r100) {
            return r100.mResizeAndRotateEnabledForNetwork;
        }

        public static /* synthetic */ DiskCacheConfig access$2700(Builder r100) {
            return r100.mSmallImageDiskCacheConfig;
        }

        public static /* synthetic */ HashMap access$2800(Builder r100) {
            return r100.mCustomImageDiskCacheConfigMap;
        }

        public static /* synthetic */ ImageDecoderConfig access$2900(Builder r100) {
            return r100.mImageDecoderConfig;
        }

        public static /* synthetic */ Context access$300(Builder r100) {
            return r100.mContext;
        }

        public static /* synthetic */ ExecutorSupplier access$3000(Builder r100) {
            return r100.mExecutorSupplier;
        }

        public static /* synthetic */ boolean access$3100(Builder r100) {
            return r100.mAnimatedHeifIndividualCacheEnabled;
        }

        public static /* synthetic */ boolean access$3200(Builder r100) {
            return r100.mAnimatedHeifIndividualCacheForImageRequestEnabled;
        }

        public static /* synthetic */ boolean access$3300(Builder r100) {
            return r100.mDiskCacheEnabled;
        }

        public static /* synthetic */ boolean access$3400(Builder r100) {
            return r100.mWasImmediate;
        }

        public static /* synthetic */ ImageTranscoderFactory access$3600(Builder r100) {
            return r100.mImageTranscoderFactory;
        }

        public static /* synthetic */ Integer access$3700(Builder r100) {
            return r100.mMemoryChunkType;
        }

        public static /* synthetic */ Supplier access$400(Builder r100) {
            return r100.mSingleBitmapMemoryCacheParamsSupplier;
        }

        public static /* synthetic */ Supplier access$500(Builder r100) {
            return r100.mBigImgBitmapMemoryCacheParamsSupplier;
        }

        public static /* synthetic */ Supplier access$600(Builder r100) {
            return r100.mPrefetchImgBitmapMemoryCacheParamsSupplier;
        }

        public static /* synthetic */ Supplier access$700(Builder r100) {
            return r100.mAnimBitmapMemoryCacheParamsSupplier;
        }

        public static /* synthetic */ CountingMemoryCache.CacheTrimStrategy access$800(Builder r100) {
            return r100.mBitmapMemoryCacheTrimStrategy;
        }

        public static /* synthetic */ Bitmap.Config access$900(Builder r100) {
            return r100.mBitmapConfig;
        }

        public Builder setAnimBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> r100) {
            this.mAnimBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(r100);
            return this;
        }

        public Builder setBigImgBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> r100) {
            this.mBigImgBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(r100);
            return this;
        }

        public Builder setBigImgSizeLimit(long r100) {
            this.mBigImgSizeLimit = r100;
            return this;
        }

        public Builder setBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> r100) {
            this.mBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(r100);
            return this;
        }

        public Builder setBitmapMemoryCacheTrimStrategy(CountingMemoryCache.CacheTrimStrategy r100) {
            this.mBitmapMemoryCacheTrimStrategy = r100;
            return this;
        }

        public Builder setBitmapsConfig(Bitmap.Config r100) {
            this.mBitmapConfig = r100;
            return this;
        }

        public Builder setCacheKeyFactory(CacheKeyFactory r100) {
            this.mCacheKeyFactory = r100;
            return this;
        }

        public Builder setCustomImageDiskCacheConfigMap(HashMap<String, DiskCacheConfig> r100) {
            this.mCustomImageDiskCacheConfigMap = r100;
            return this;
        }

        public Builder setDiskCacheEnabled(boolean r100) {
            this.mDiskCacheEnabled = r100;
            return this;
        }

        public Builder setDownsampleEnabled(boolean r100) {
            this.mDownsampleEnabled = r100;
            return this;
        }

        public Builder setEnableAnimatedHeifIndividualCache(boolean r100) {
            this.mAnimatedHeifIndividualCacheEnabled = r100;
            return this;
        }

        public Builder setEnableAnimatedHeifIndividualCacheForImageRequest(boolean r100) {
            this.mAnimatedHeifIndividualCacheForImageRequestEnabled = r100;
            return this;
        }

        public Builder setEnableBigImgCache(boolean r100) {
            this.mEnableBigImgCache = r100;
            return this;
        }

        public Builder setEnableSaveAfterSrPostBitmap(boolean r100) {
            this.mSaveAfterSrPostBitmap = r100;
            return this;
        }

        public Builder setEnableSavePreSrPostBitmap(boolean r100) {
            this.mSavePreSrPostBitmap = r100;
            return this;
        }

        public Builder setEnableSingleMemCache(boolean r100) {
            this.mEnableSingleMemCache = r100;
            return this;
        }

        public Builder setEncodedMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> r100) {
            this.mEncodedMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(r100);
            return this;
        }

        public Builder setExecutorSupplier(ExecutorSupplier r100) {
            this.mExecutorSupplier = r100;
            return this;
        }

        public Builder setFileCacheFactory(FileCacheFactory r100) {
            this.mFileCacheFactory = r100;
            return this;
        }

        public Builder setHeicDecodeThreads(int r100) {
            mHeicDecodeThreads = r100;
            return this;
        }

        public Builder setHeicUseWpp(boolean r100) {
            mHeicUseWpp = r100;
            return this;
        }

        public Builder setHeifDecodeThreads(int r100) {
            mHeifDecodeThreads = r100;
            return this;
        }

        public Builder setHeifUseWpp(boolean r100) {
            mHeifUseWpp = r100;
            return this;
        }

        public Builder setHttpConnectionTimeout(int r100) {
            this.mHttpConnectionTimeout = r100;
            return this;
        }

        public Builder setImageCacheStatsTracker(ImageCacheStatsTracker r100) {
            this.mImageCacheStatsTracker = r100;
            return this;
        }

        public Builder setImageDecoder(ImageDecoder r100) {
            this.mImageDecoder = r100;
            return this;
        }

        public Builder setImageDecoderConfig(ImageDecoderConfig r100) {
            this.mImageDecoderConfig = r100;
            Iterator<ImageFormat> r101 = r100.getCustomImageDecoders().keySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ImageFormatUtils.addCustomFormat(r101.next().getFileExtension());
            goto L4
        L6:
            return this;
        }

        public Builder setImageTranscoderFactory(ImageTranscoderFactory r100) {
            this.mImageTranscoderFactory = r100;
            return this;
        }

        public Builder setImageTranscoderType(int r100) {
            this.mImageTranscoderType = Integer.valueOf(r100);
            return this;
        }

        public Builder setIsPrefetchEnabledSupplier(Supplier<Boolean> r100) {
            this.mIsPrefetchEnabledSupplier = r100;
            return this;
        }

        public Builder setMainDiskCacheConfig(DiskCacheConfig r100) {
            this.mMainDiskCacheConfig = r100;
            return this;
        }

        public Builder setMemoryChunkType(int r100) {
            this.mMemoryChunkType = Integer.valueOf(r100);
            return this;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry r100) {
            this.mMemoryTrimmableRegistry = r100;
            return this;
        }

        public Builder setNetworkFetcher(NetworkFetcher r100) {
            this.mNetworkFetcher = r100;
            return this;
        }

        public Builder setNewLocalVideoThumbnailOptEnabled(boolean r100) {
            this.mEnableNewLocalVideoThumbnailOpt = r100;
            return this;
        }

        public Builder setOptAddLogUriInfo(boolean r100) {
            this.mEnableAddLogUriInfo = r100;
            return this;
        }

        public Builder setOptMultiOriginListener(boolean r100) {
            mOptMultiOriginListener = r100;
            return this;
        }

        public Builder setOptPrefetchCacheKey(boolean r100) {
            this.mOptPrefetchCacheKey = r100;
            return this;
        }

        public Builder setPlatformBitmapFactory(PlatformBitmapFactory r100) {
            this.mPlatformBitmapFactory = r100;
            return this;
        }

        public Builder setPoolFactory(PoolFactory r100) {
            this.mPoolFactory = r100;
            return this;
        }

        public Builder setPrefetchImgBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> r100) {
            this.mPrefetchImgBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(r100);
            return this;
        }

        public Builder setProgressiveJpegConfig(ProgressiveJpegConfig r100) {
            this.mProgressiveJpegConfig = r100;
            return this;
        }

        public Builder setRequestListeners(Set<RequestListener> r100) {
            this.mRequestListeners = r100;
            return this;
        }

        public Builder setResizeAndRotateEnabledForNetwork(boolean r100) {
            this.mResizeAndRotateEnabledForNetwork = r100;
            return this;
        }

        public Builder setRetainPreviousImage(boolean r100) {
            this.mRetainPreviousImage = r100;
            return this;
        }

        public Builder setSRAutoScaleLowerFirst(boolean r100) {
            mSRAutoScaleLowerFirst = r100;
            return this;
        }

        public Builder setShowHeifDebugLog(boolean r100) {
            this.mShowHeifDebugLog = r100;
            return this;
        }

        public Builder setSingleBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> r100) {
            this.mSingleBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(r100);
            return this;
        }

        public Builder setSmallImageDiskCacheConfig(DiskCacheConfig r100) {
            this.mSmallImageDiskCacheConfig = r100;
            return this;
        }

        public Builder setSplitMemCache(boolean r100) {
            this.mIsSplitMemCache = r100;
            return this;
        }

        public Builder setSplitPrefetchCache(boolean r100) {
            this.mIsSplitPrefetchCache = r100;
            return this;
        }

        public Builder setUseNewOptHeifBitmap(boolean r100) {
            mUseNewOptHeifBitmap = r100;
            return this;
        }

        public Builder setUseOptHeifBitmap(boolean r100) {
            mUseOptHeifBitmap = r100;
            return this;
        }

        public Builder setVvicDecodeThreads(int r100) {
            mVvicDecodeThreads = r100;
            return this;
        }

        public Builder setVvicUseWpp(boolean r100) {
            mVvicUseWpp = r100;
            return this;
        }

        public Builder setWaitParseParamFromUrl(Map<String, String> r100) {
            this.mWaitParseParamFromUrl = r100;
            return this;
        }

        public Builder setWasImmediate(boolean r100) {
            this.mWasImmediate = r100;
            return this;
        }

        public /* synthetic */ Builder(Context r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static class DefaultImageRequestConfig {
        private boolean mDecodeHeicUseSystemApiFirst;
        private int mPixelsToPick;
        private boolean mProgressiveRenderingAnimatedEnabled;
        private boolean mProgressiveRenderingEnabled;
        private boolean mProgressiveRenderingHeicEnabled;

        private DefaultImageRequestConfig() {
            this.mProgressiveRenderingEnabled = false;
            this.mProgressiveRenderingAnimatedEnabled = false;
            this.mProgressiveRenderingHeicEnabled = false;
            this.mDecodeHeicUseSystemApiFirst = false;
            this.mPixelsToPick = 30;
        }

        public int getPixelsToPick() {
            return this.mPixelsToPick;
        }

        public boolean isDecodeHeicUseSystemApiFirst() {
            return this.mDecodeHeicUseSystemApiFirst;
        }

        public boolean isProgressiveRenderingAnimatedEnabled() {
            return this.mProgressiveRenderingAnimatedEnabled;
        }

        public boolean isProgressiveRenderingEnabled() {
            return this.mProgressiveRenderingEnabled;
        }

        public boolean isProgressiveRenderingHeicEnabled() {
            return this.mProgressiveRenderingHeicEnabled;
        }

        public /* synthetic */ DefaultImageRequestConfig(AnonymousClass1 r100) {
            this();
        }

        public void setDecodeHeicUseSystemApiFirst(boolean r100) {
            this.mDecodeHeicUseSystemApiFirst = r100;
        }

        public void setPixelsToPick(int r100) {
            this.mPixelsToPick = r100;
        }

        public void setProgressiveRenderingAnimatedEnabled(boolean r100) {
            this.mProgressiveRenderingAnimatedEnabled = r100;
        }

        public void setProgressiveRenderingEnabled(boolean r100) {
            this.mProgressiveRenderingEnabled = r100;
        }

        public void setProgressiveRenderingHeicEnabled(boolean r100) {
            this.mProgressiveRenderingHeicEnabled = r100;
        }
    }

    public boolean isEnableBigImgCache() {
    L20:
        th = move-exception;
        FLog.e("debug_tt", "isEnableBigImgCache: t = " + th);
        return false;
    L4:
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L8;
        return FrescoCacheMonitorUtil.isEnableBigImgCache();
    L8:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L15;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;     // Catch: Throwable -> L20
        if (r100 != null) goto L12;
    L13:
        return false;
    L12:
        if (r100.getMEnableBigImgCache() == null) goto L13;
    L15:
        if (FrescoCacheMonitorUtil.isEnableBigImgCache() == false) goto L17;
    L18:
        return true;
    L17:
        if (this.mImagePipelineConfigLazySet.getMEnableBigImgCache().booleanValue() == true) goto L18;
        return false;
    }

    public boolean isEnablePrefetchImgCache() {
    L20:
        th = move-exception;
        FLog.e("debug_tt", "isEnablePrefetchImgCache: t = " + th);
        return false;
    L4:
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L8;
        return FrescoCacheMonitorUtil.isEnablePrefetchImgCache();
    L8:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L15;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;     // Catch: Throwable -> L20
        if (r100 != null) goto L12;
    L13:
        return false;
    L12:
        if (r100.getMEnablePrefetchImgCache() == null) goto L13;
    L15:
        if (FrescoCacheMonitorUtil.isEnablePrefetchImgCache() == false) goto L17;
    L18:
        return true;
    L17:
        if (this.mImagePipelineConfigLazySet.getMEnablePrefetchImgCache().booleanValue() == true) goto L18;
        return false;
    }

    public boolean isEnableSingleMemCache() {
    L20:
        th = move-exception;
        FLog.e("debug_tt", "isSplitMemCache: t = " + th);
        return false;
    L4:
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L8;
        return FrescoCacheMonitorUtil.isEnableSingleCache();
    L8:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L15;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;     // Catch: Throwable -> L20
        if (r100 != null) goto L12;
    L13:
        return false;
    L12:
        if (r100.getMEnableSingleMemCache() == null) goto L13;
    L15:
        if (FrescoCacheMonitorUtil.isEnableSingleCache() == false) goto L17;
    L18:
        return true;
    L17:
        if (this.mImagePipelineConfigLazySet.getMEnableSingleMemCache().booleanValue() == true) goto L18;
        return false;
    }

    public boolean isHeifBitmapPoolEnabled() {
    L20:
        th = move-exception;
        FLog.e("debug_tt", "isHeifBitmapPoolEnabled: t = " + th);
        return false;
    L4:
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L8;
        return FrescoCacheMonitorUtil.isHeifBitmapPoolEnabled();
    L8:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L15;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;     // Catch: Throwable -> L20
        if (r100 != null) goto L12;
    L13:
        return false;
    L12:
        if (r100.getMHeifBitmapPoolEnabled() == null) goto L13;
    L15:
        if (FrescoCacheMonitorUtil.isHeifBitmapPoolEnabled() == false) goto L17;
    L18:
        return true;
    L17:
        if (this.mImagePipelineConfigLazySet.getMHeifBitmapPoolEnabled().booleanValue() == true) goto L18;
        return false;
    }

    public boolean isNewLocalVideoThumbnailOptEnabled() {
    L20:
        th = move-exception;
        FLog.e("debug_tt", "isNewLocalVideoThumbnailOptEnabled: t = " + th);
        return false;
    L4:
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L8;
        return FrescoCacheMonitorUtil.isNewLocalVideoThumbnailOptEnabled();
    L8:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L15;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;     // Catch: Throwable -> L20
        if (r100 != null) goto L12;
    L13:
        return false;
    L12:
        if (r100.getMEnableNewLocalVideoThumbnailOpt() == null) goto L13;
    L15:
        if (FrescoCacheMonitorUtil.isNewLocalVideoThumbnailOptEnabled() == false) goto L17;
    L18:
        return true;
    L17:
        if (this.mImagePipelineConfigLazySet.getMEnableNewLocalVideoThumbnailOpt().booleanValue() == true) goto L18;
        return false;
    }

    public boolean isSplitMemCache() {
    L20:
        th = move-exception;
        FLog.e("debug_lazy", "isSplitMemCache: t = " + th);
        return false;
    L4:
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L8;
        return FrescoCacheMonitorUtil.isSplitMemCache();
    L8:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L15;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;     // Catch: Throwable -> L20
        if (r100 != null) goto L12;
    L13:
        return false;
    L12:
        if (r100.getMIsSplitMemCache() == null) goto L13;
    L15:
        if (FrescoCacheMonitorUtil.isSplitMemCache() == false) goto L17;
    L18:
        return true;
    L17:
        if (this.mImagePipelineConfigLazySet.getMIsSplitMemCache().booleanValue() == true) goto L18;
        return false;
    }

    public boolean isUseOptHeifBitmap() {
    L20:
        th = move-exception;
        FLog.e("debug_tt", "isUseOptHeifBitmap: t = " + th);
        return false;
    L4:
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L8;
        return FrescoCacheMonitorUtil.isUseOptHeifBitmap();
    L8:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L15;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;     // Catch: Throwable -> L20
        if (r100 != null) goto L12;
    L13:
        return false;
    L12:
        if (r100.getMUseOptHeifBitmap() == null) goto L13;
    L15:
        if (FrescoCacheMonitorUtil.isUseOptHeifBitmap() == false) goto L17;
    L18:
        return true;
    L17:
        if (this.mImagePipelineConfigLazySet.getMUseOptHeifBitmap().booleanValue() == true) goto L18;
        return false;
    }

    static {
        sDefaultImageRequestConfig = new DefaultImageRequestConfig(null);
        mWasImmediate = true;
        useSingleImageRequest = false;
        mImagePipelineConfig = null;
        sIsLazyInit = false;
    }

    public static ImagePipelineConfig getInstance() {
        if (mImagePipelineConfig != null) goto L6;
        mImagePipelineConfig = new ImagePipelineConfig();
    L6:
        return mImagePipelineConfig;
    }

    public static void resetDefaultRequestConfig() {
        sDefaultImageRequestConfig = new DefaultImageRequestConfig(null);
    }

    public Supplier<MemoryCacheParams> getAnimBitmapMemoryCacheParamsSupplier() {
        return this.mImagePipelineConfigLazySet.getMAnimBitmapMemoryCacheParamsSupplier();
    }

    public Supplier<MemoryCacheParams> getBigImgBitmapMemoryCacheParamsSupplier() {
        return this.mImagePipelineConfigLazySet.getMBigImgBitmapMemoryCacheParamsSupplier();
    }

    public long getBigImgSizeLimit() {
        return this.mImagePipelineConfigLazySet.getMBigImgSizeLimit().longValue();
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mImagePipelineConfigLazySet.getMBitmapConfig();
    }

    public Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
        return this.mImagePipelineConfigLazySet.getMBitmapMemoryCacheParamsSupplier();
    }

    public CountingMemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
        return this.mImagePipelineConfigLazySet.getMBitmapMemoryCacheTrimStrategy();
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.mImagePipelineConfigLazySet.getMCacheKeyFactory();
    }

    public Context getContext() {
        return this.mImagePipelineConfigLazySet.getMContext();
    }

    public HashMap<String, DiskCacheConfig> getCustomImageDiskCacheConfigMap() {
        return this.mImagePipelineConfigLazySet.getMCustomImageDiskCacheConfigMap();
    }

    public Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
        return this.mImagePipelineConfigLazySet.getMEncodedMemoryCacheParamsSupplier();
    }

    public ExecutorSupplier getExecutorSupplier() {
        return this.mImagePipelineConfigLazySet.getMExecutorSupplier();
    }

    public ImagePipelineExperiments getExperiments() {
        return this.mImagePipelineConfigLazySet.getMImagePipelineExperiments();
    }

    public FileCacheFactory getFileCacheFactory() {
        return this.mImagePipelineConfigLazySet.getMFileCacheFactory();
    }

    public ImageCacheStatsTracker getImageCacheStatsTracker() {
        return this.mImagePipelineConfigLazySet.getMImageCacheStatsTracker();
    }

    @Nullable
    public ImageDecoder getImageDecoder() {
        return this.mImagePipelineConfigLazySet.getMImageDecoder();
    }

    @Nullable
    public ImageDecoderConfig getImageDecoderConfig() {
        return this.mImagePipelineConfigLazySet.getMImageDecoderConfig();
    }

    @Nullable
    public ImageTranscoderFactory getImageTranscoderFactory() {
        return this.mImagePipelineConfigLazySet.getMImageTranscoderFactory();
    }

    @Nullable
    public Integer getImageTranscoderType() {
        return this.mImagePipelineConfigLazySet.getMImageTranscoderType();
    }

    public Supplier<Boolean> getIsPrefetchEnabledSupplier() {
        return this.mImagePipelineConfigLazySet.getMIsPrefetchEnabledSupplier();
    }

    public DiskCacheConfig getMainDiskCacheConfig() {
        return this.mImagePipelineConfigLazySet.getMMainDiskCacheConfig();
    }

    public int getMemoryChunkType() {
        return this.mImagePipelineConfigLazySet.getMMemoryChunkType().intValue();
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.mImagePipelineConfigLazySet.getMMemoryTrimmableRegistry();
    }

    public NetworkFetcher getNetworkFetcher() {
        return this.mImagePipelineConfigLazySet.getMNetworkFetcher();
    }

    @Nullable
    public PlatformBitmapFactory getPlatformBitmapFactory() {
        return this.mImagePipelineConfigLazySet.getMPlatformBitmapFactory();
    }

    public PoolFactory getPoolFactory() {
        return this.mImagePipelineConfigLazySet.getMPoolFactory();
    }

    public Supplier<MemoryCacheParams> getPrefetchImgBitmapMemoryCacheParamsSupplier() {
        return this.mImagePipelineConfigLazySet.getMPrefetchImgBitmapMemoryCacheParamsSupplier();
    }

    public ProgressiveJpegConfig getProgressiveJpegConfig() {
        return this.mImagePipelineConfigLazySet.getMProgressiveJpegConfig();
    }

    public Set<RequestListener> getRequestListeners() {
        return Collections.unmodifiableSet(this.mImagePipelineConfigLazySet.getMRequestListeners());
    }

    public Supplier<MemoryCacheParams> getSingleBitmapMemoryCacheParamsSupplier() {
        return this.mImagePipelineConfigLazySet.getMSingleBitmapMemoryCacheParamsSupplier();
    }

    public DiskCacheConfig getSmallImageDiskCacheConfig() {
        return this.mImagePipelineConfigLazySet.getMSmallImageDiskCacheConfig();
    }

    public void preloadConfig() {
        this.mImagePipelineConfigLazySet.getMImagePipelineExperiments();
        this.mImagePipelineConfigLazySet.getMBitmapConfig();
        this.mImagePipelineConfigLazySet.getMImageDecoderConfig();
        this.mImagePipelineConfigLazySet.getMPoolFactory();
        this.mImagePipelineConfigLazySet.getMImageDecoderConfig();
        this.mImagePipelineConfigLazySet.getMBitmapMemoryCacheParamsSupplier();
        this.mImagePipelineConfigLazySet.getMAnimBitmapMemoryCacheParamsSupplier();
        this.mImagePipelineConfigLazySet.getMBitmapMemoryCacheTrimStrategy();
        this.mImagePipelineConfigLazySet.getMCacheKeyFactory();
        this.mImagePipelineConfigLazySet.getMContext();
        this.mImagePipelineConfigLazySet.getMIsSplitMemCache();
        this.mImagePipelineConfigLazySet.getMEnableSingleMemCache();
        this.mImagePipelineConfigLazySet.getMSingleBitmapMemoryCacheParamsSupplier();
        this.mImagePipelineConfigLazySet.getMAnimatedHeifIndividualCacheEnabled();
        this.mImagePipelineConfigLazySet.getMShowHeifDebugLog();
        this.mImagePipelineConfigLazySet.getMAnimatedHeifIndividualCacheForImageRequestEnabled();
        this.mImagePipelineConfigLazySet.getMDiskCacheEnabled();
        this.mImagePipelineConfigLazySet.getMDownsampleEnabled();
        this.mImagePipelineConfigLazySet.getMEncodedMemoryCacheParamsSupplier();
        this.mImagePipelineConfigLazySet.getMExecutorSupplier();
        this.mImagePipelineConfigLazySet.getMFileCacheFactory();
        this.mImagePipelineConfigLazySet.getMHttpNetworkTimeout();
        this.mImagePipelineConfigLazySet.getMImageCacheStatsTracker();
        this.mImagePipelineConfigLazySet.getMImageTranscoderFactory();
        this.mImagePipelineConfigLazySet.getMIsPrefetchEnabledSupplier();
        this.mImagePipelineConfigLazySet.getMMainDiskCacheConfig();
        this.mImagePipelineConfigLazySet.getMMemoryChunkType();
        this.mImagePipelineConfigLazySet.getMMemoryTrimmableRegistry();
        this.mImagePipelineConfigLazySet.getMImageDecoder();
        this.mImagePipelineConfigLazySet.getMPlatformBitmapFactory();
        this.mImagePipelineConfigLazySet.getMProgressiveJpegConfig();
        this.mImagePipelineConfigLazySet.getMRequestListeners();
        this.mImagePipelineConfigLazySet.getMResizeAndRotateEnabledForNetwork();
        this.mImagePipelineConfigLazySet.getMSmallImageDiskCacheConfig();
        this.mImagePipelineConfigLazySet.getMCustomImageDiskCacheConfigMap();
        this.mImagePipelineConfigLazySet.getMWasImmediate();
        this.mImagePipelineConfigLazySet.getMEnableBigImgCache();
        this.mImagePipelineConfigLazySet.getMBigImgBitmapMemoryCacheParamsSupplier();
        this.mImagePipelineConfigLazySet.getMBigImgSizeLimit();
        this.mImagePipelineConfigLazySet.getMEnablePrefetchImgCache();
        this.mImagePipelineConfigLazySet.getMPrefetchImgBitmapMemoryCacheParamsSupplier();
        this.mImagePipelineConfigLazySet.getUseSingleImageRequest();
        this.mImagePipelineConfigLazySet.getMEnableNewLocalVideoThumbnailOpt();
        this.mImagePipelineConfigLazySet.getMRetainPreviousImage();
        this.mImagePipelineConfigLazySet.getMUseOptHeifBitmap();
        this.mImagePipelineConfigLazySet.getMHeifBitmapPoolEnabled();
    }

    private ImagePipelineConfig() {
        ImagePipelineConfigLazySet r100 = new ImagePipelineConfigLazySet();
        this.mImagePipelineConfigLazySet = r100;
        if (r100.getMImagePipelineExperiments() == null) goto L5;
        WebpBitmapFactory r101 = this.mImagePipelineConfigLazySet.getMImagePipelineExperiments().getWebpBitmapFactory();
    L6:
        if (r101 == null) goto L9;
        HoneycombBitmapCreator r102 = new HoneycombBitmapCreator(getPoolFactory());
        setWebpBitmapFactory(r101, this.mImagePipelineConfigLazySet.getMImagePipelineExperiments(), r102);
        return;
    L9:
        if (this.mImagePipelineConfigLazySet.getMImagePipelineExperiments() != null) goto L11;
        return;
    L11:
        if (this.mImagePipelineConfigLazySet.getMImagePipelineExperiments().isWebpSupportEnabled() == true) goto L13;
        return;
    L13:
        if (WebpSupportStatus.sIsWebpSupportRequired == false) goto L21;
        WebpBitmapFactory r103 = WebpSupportStatus.loadWebpBitmapFactoryIfExists();
        if (r103 == null) goto L22;
        HoneycombBitmapCreator r104 = new HoneycombBitmapCreator(getPoolFactory());
        setWebpBitmapFactory(r103, this.mImagePipelineConfigLazySet.getMImagePipelineExperiments(), r104);
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r101 = null;
        goto L6
    }

    private static HashMap<String, DiskCacheConfig> getDefaultCustomDiskCacheConfigMap() {
    L10:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L14;
        FrescoSystrace.endSection();
    L14:
        throw th;
    L3:
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("DiskCacheConfig.getDefaultCustomDiskCacheConfigMap");     // Catch: Throwable -> L10
    L5:
        HashMap<String, DiskCacheConfig> r100 = new HashMap();     // Catch: Throwable -> L10
        if (FrescoSystrace.isTracing() == false) goto L9;
        FrescoSystrace.endSection();
    L9:
        return r100;
    }

    public boolean isAnimatedHeifIndividualCacheEnabled() {
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L7;
        return FrescoCacheMonitorUtil.isAnimatedHeifIndividualCacheEnabled();
    L7:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L14;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;
        if (r100 != null) goto L11;
    L12:
        return false;
    L11:
        if (r100.getMAnimatedHeifIndividualCacheEnabled() == null) goto L12;
    L14:
        if (FrescoCacheMonitorUtil.isAnimatedHeifIndividualCacheEnabled() == false) goto L16;
    L17:
        return true;
    L16:
        if (this.mImagePipelineConfigLazySet.getMAnimatedHeifIndividualCacheEnabled().booleanValue() == true) goto L17;
        return false;
    }

    public boolean isAnimatedHeifIndividualCacheForImageRequestEnabled() {
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L7;
        return FrescoCacheMonitorUtil.isAnimatedHeifIndividualCacheForImageRequestEnabled();
    L7:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L14;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;
        if (r100 != null) goto L11;
    L12:
        return false;
    L11:
        if (r100.getMAnimatedHeifIndividualCacheForImageRequestEnabled() == null) goto L12;
    L14:
        if (FrescoCacheMonitorUtil.isAnimatedHeifIndividualCacheForImageRequestEnabled() == false) goto L16;
    L17:
        return true;
    L16:
        if (this.mImagePipelineConfigLazySet.getMAnimatedHeifIndividualCacheForImageRequestEnabled().booleanValue() == true) goto L17;
        return false;
    }

    public boolean isDiskCacheEnabled() {
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L7;
        return FrescoCacheMonitorUtil.isDiskCacheEnabled();
    L7:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L14;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;
        if (r100 != null) goto L11;
    L12:
        return false;
    L11:
        if (r100.getMDiskCacheEnabled() == null) goto L12;
    L14:
        if (FrescoCacheMonitorUtil.isDiskCacheEnabled() == false) goto L16;
    L17:
        return true;
    L16:
        if (this.mImagePipelineConfigLazySet.getMDiskCacheEnabled().booleanValue() == true) goto L17;
        return false;
    }

    public boolean isDownsampleEnabled() {
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L7;
        return FrescoCacheMonitorUtil.isDownsampleEnabled();
    L7:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L14;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;
        if (r100 != null) goto L11;
    L12:
        return false;
    L11:
        if (r100.getMDownsampleEnabled() == null) goto L12;
    L14:
        if (FrescoCacheMonitorUtil.isDownsampleEnabled() == false) goto L16;
    L17:
        return true;
    L16:
        if (this.mImagePipelineConfigLazySet.getMDownsampleEnabled().booleanValue() == true) goto L17;
        return false;
    }

    public boolean isResizeAndRotateEnabledForNetwork() {
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L7;
        return FrescoCacheMonitorUtil.isResizeAndRotateEnabledForNetwork();
    L7:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L14;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;
        if (r100 != null) goto L11;
    L12:
        return false;
    L11:
        if (r100.getMResizeAndRotateEnabledForNetwork() == null) goto L12;
    L14:
        if (FrescoCacheMonitorUtil.isResizeAndRotateEnabledForNetwork() == false) goto L16;
    L17:
        return true;
    L16:
        if (this.mImagePipelineConfigLazySet.getMResizeAndRotateEnabledForNetwork().booleanValue() == true) goto L17;
        return false;
    }

    public boolean isShowHeifDebugLog() {
        if (FrescoCacheMonitorUtil.isSkipLazyRead() == false) goto L7;
        return FrescoCacheMonitorUtil.isShowHeifDebugLog();
    L7:
        if (FrescoCacheMonitorUtil.isOptLazyInit() == false) goto L14;
        ImagePipelineConfigLazySet r100 = this.mImagePipelineConfigLazySet;
        if (r100 != null) goto L11;
    L12:
        return false;
    L11:
        if (r100.getMShowHeifDebugLog() == null) goto L12;
    L14:
        if (FrescoCacheMonitorUtil.isShowHeifDebugLog() == false) goto L16;
    L17:
        return true;
    L16:
        if (this.mImagePipelineConfigLazySet.getMShowHeifDebugLog().booleanValue() == true) goto L17;
        return false;
    }

    public static DefaultImageRequestConfig getDefaultImageRequestConfig() {
        return sDefaultImageRequestConfig;
    }

    public static boolean isWasImmediate() {
        return mWasImmediate;
    }

    private ImagePipelineConfig(Builder r100) {
        this.mImagePipelineConfigLazySet = new ImagePipelineConfigLazySet();
        if (sIsLazyInit == false) goto L6;
        return;
    L6:
        if (FrescoSystrace.isTracing() == false) goto L8;
        FrescoSystrace.beginSection("ImagePipelineConfig()");
    L8:
        this.mImagePipelineConfigLazySet.setMImagePipelineExperiments(Builder.access$100(r100).build());
        ImagePipelineConfigLazySet r101 = this.mImagePipelineConfigLazySet;
        if (Builder.access$200(r100) != null) goto L11;
        Supplier<MemoryCacheParams> r102 = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) Builder.access$300(r100).getSystemService("activity"));
    L12:
        r101.setMBitmapMemoryCacheParamsSupplier(r102);
        ImagePipelineConfigLazySet r103 = this.mImagePipelineConfigLazySet;
        if (Builder.access$400(r100) != null) goto L15;
        Supplier<MemoryCacheParams> r104 = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) Builder.access$300(r100).getSystemService("activity"));
    L16:
        r103.setMSingleBitmapMemoryCacheParamsSupplier(r104);
        ImagePipelineConfigLazySet r105 = this.mImagePipelineConfigLazySet;
        if (Builder.access$500(r100) != null) goto L19;
        Supplier<MemoryCacheParams> r106 = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) Builder.access$300(r100).getSystemService("activity"));
    L20:
        r105.setMBigImgBitmapMemoryCacheParamsSupplier(r106);
        ImagePipelineConfigLazySet r107 = this.mImagePipelineConfigLazySet;
        if (Builder.access$600(r100) != null) goto L23;
        Supplier<MemoryCacheParams> r108 = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) Builder.access$300(r100).getSystemService("activity"));
    L24:
        r107.setMPrefetchImgBitmapMemoryCacheParamsSupplier(r108);
        ImagePipelineConfigLazySet r109 = this.mImagePipelineConfigLazySet;
        if (Builder.access$700(r100) != null) goto L27;
        Supplier<MemoryCacheParams> r110 = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) Builder.access$300(r100).getSystemService("activity"));
    L28:
        r109.setMAnimBitmapMemoryCacheParamsSupplier(r110);
        ImagePipelineConfigLazySet r111 = this.mImagePipelineConfigLazySet;
        if (Builder.access$800(r100) != null) goto L31;
        CountingMemoryCache.CacheTrimStrategy r112 = new BitmapMemoryCacheTrimStrategy();
    L32:
        r111.setMBitmapMemoryCacheTrimStrategy(r112);
        FrescoCacheMonitorUtil.setSplitMemCache(r100.isSplitMemCache());
        FrescoCacheMonitorUtil.setEnableSingleCache(r100.isEnableSingleMemCache());
        FrescoCacheMonitorUtil.setEnableBigImgCache(r100.isEnableBigImgCache());
        FrescoCacheMonitorUtil.setBigImgSizeLimit(r100.getBigImgSizeLimit());
        FrescoCacheMonitorUtil.setRetainPreviousImage(r100.isRetainPreviousImage());
        FrescoCacheMonitorUtil.setEnableSavePreSrPostBitmap(r100.isSavePrePostBitmap());
        FrescoCacheMonitorUtil.setEnableSaveAfterSrPostBitmap(r100.isSaveAfterPostBitmap());
        FrescoCacheMonitorUtil.setNewLocalVideoThumbnailOptEnabled(r100.isNewLocalVideoThumbnailOptEnabled());
        FrescoCacheMonitorUtil.setWaitParseParamFromUrl(r100.getWaitParseParamFromUrl());
        FrescoCacheMonitorUtil.setUseOptHeifBitmap(r100.isUseOptHeifBitmap());
        FrescoCacheMonitorUtil.setUseNewOptHeifBitmap(r100.isUseNewOptHeifBitmap());
        FrescoCacheMonitorUtil.setVvicUseWpp(r100.isVvicUseWpp());
        FrescoCacheMonitorUtil.setVvicDecodeThreads(r100.getVvicDecodeThreads());
        FrescoCacheMonitorUtil.setHeicUseWpp(r100.isHeicUseWpp());
        FrescoCacheMonitorUtil.setHeicDecodeThreads(r100.getHeicDecodeThreads());
        FrescoCacheMonitorUtil.setHeifUseWpp(r100.isHeifUseWpp());
        FrescoCacheMonitorUtil.setHeifDecodeThreads(r100.getHeifDecodeThreads());
        FrescoCacheMonitorUtil.setOptMultiOriginListener(r100.isOptMultiOriginListener());
        FrescoCacheMonitorUtil.setSRAutoScaleLowerFirst(r100.isSRAutoScaleLowerFirst());
        FrescoCacheMonitorUtil.setSplitPrefetchCache(r100.isSplitPrefetchCache());
        FrescoCacheMonitorUtil.setOptPrefetchCacheKey(r100.isOptPrefetchCacheKey());
        FrescoCacheMonitorUtil.setEnableAddLogUriInfo(r100.isOptAddLogUriInfo());
        FrescoCacheMonitorUtil.setDownsampleEnabled(r100.isDownsampleEnabled());
        FrescoCacheMonitorUtil.setDiskCacheEnabled(r100.isDiskCacheEnabled());
        FrescoCacheMonitorUtil.setResizeAndRotateEnabledForNetwork(r100.isResizeAndRotateEnabledForNetwork());
        FrescoCacheMonitorUtil.setShowHeifDebugLog(r100.isShowHeifDebugLog());
        FrescoCacheMonitorUtil.setAnimatedHeifIndividualCacheEnabled(r100.isEnableAnimatedHeifIndividualCache());
        FrescoCacheMonitorUtil.setAnimatedHeifIndividualCacheForImageRequestEnabled(r100.isEnableAnimatedHeifIndividualCacheForImageRequest());
        ImagePipelineConfigLazySet r113 = this.mImagePipelineConfigLazySet;
        if (Builder.access$900(r100) != null) goto L35;
        Bitmap.Config r114 = Bitmap.Config.ARGB_8888;
    L36:
        r113.setMBitmapConfig(r114);
        ImagePipelineConfigLazySet r115 = this.mImagePipelineConfigLazySet;
        if (Builder.access$1000(r100) != null) goto L39;
        CacheKeyFactory r116 = DefaultCacheKeyFactory.getInstance();
    L40:
        r115.setMCacheKeyFactory(r116);
        this.mImagePipelineConfigLazySet.setMContext((Context) Preconditions.checkNotNull(Builder.access$300(r100)));
        ImagePipelineConfigLazySet r117 = this.mImagePipelineConfigLazySet;
        if (Builder.access$1100(r100) != null) goto L43;
        FileCacheFactory r118 = new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory());
    L44:
        r117.setMFileCacheFactory(r118);
        this.mImagePipelineConfigLazySet.setMDownsampleEnabled(Boolean.valueOf(Builder.access$1200(r100)));
        ImagePipelineConfigLazySet r119 = this.mImagePipelineConfigLazySet;
        if (Builder.access$1300(r100) != null) goto L47;
        Supplier<MemoryCacheParams> r120 = new DefaultEncodedMemoryCacheParamsSupplier();
    L48:
        r119.setMEncodedMemoryCacheParamsSupplier(r120);
        ImagePipelineConfigLazySet r121 = this.mImagePipelineConfigLazySet;
        if (Builder.access$1400(r100) != null) goto L51;
        ImageCacheStatsTracker r122 = NoOpImageCacheStatsTracker.getInstance();
    L52:
        r121.setMImageCacheStatsTracker(r122);
        this.mImagePipelineConfigLazySet.setMImageDecoder(Builder.access$1500(r100));
        this.mImagePipelineConfigLazySet.setMImageTranscoderFactory(getImageTranscoderFactory(r100));
        this.mImagePipelineConfigLazySet.setMImageTranscoderType(Builder.access$1600(r100));
        ImagePipelineConfigLazySet r123 = this.mImagePipelineConfigLazySet;
        if (Builder.access$1700(r100) != null) goto L55;
        Supplier<Boolean> r124 = new AnonymousClass1(this);
    L56:
        r123.setMIsPrefetchEnabledSupplier(r124);
        ImagePipelineConfigLazySet r125 = this.mImagePipelineConfigLazySet;
        if (Builder.access$1800(r100) != null) goto L59;
        DiskCacheConfig r126 = getDefaultMainDiskCacheConfig(Builder.access$300(r100));
    L60:
        r125.setMMainDiskCacheConfig(r126);
        ImagePipelineConfigLazySet r127 = this.mImagePipelineConfigLazySet;
        if (Builder.access$1900(r100) != null) goto L63;
        MemoryTrimmableRegistry r128 = NoOpMemoryTrimmableRegistry.getInstance();
    L64:
        r127.setMMemoryTrimmableRegistry(r128);
        ImagePipelineConfigLazySet r129 = this.mImagePipelineConfigLazySet;
        r129.setMMemoryChunkType(Integer.valueOf(getMemoryChunkType(r100, r129.getMImagePipelineExperiments())));
        ImagePipelineConfigLazySet r130 = this.mImagePipelineConfigLazySet;
        if (Builder.access$2000(r100) >= 0) goto L67;
        int r131 = 30000;
    L68:
        r130.setMHttpNetworkTimeout(Integer.valueOf(r131));
        if (FrescoSystrace.isTracing() == false) goto L71;
        FrescoSystrace.beginSection("ImagePipelineConfig->mNetworkFetcher");
    L71:
        ImagePipelineConfigLazySet r132 = this.mImagePipelineConfigLazySet;
        if (Builder.access$2100(r100) != null) goto L74;
        NetworkFetcher<? extends FetchState> r133 = new HttpUrlConnectionNetworkFetcher(this.mImagePipelineConfigLazySet.getMHttpNetworkTimeout().intValue());
    L75:
        r132.setMNetworkFetcher(r133);
        if (FrescoSystrace.isTracing() == false) goto L78;
        FrescoSystrace.endSection();
    L78:
        this.mImagePipelineConfigLazySet.setMPlatformBitmapFactory(Builder.access$2200(r100));
        ImagePipelineConfigLazySet r134 = this.mImagePipelineConfigLazySet;
        if (Builder.access$2300(r100) != null) goto L81;
        PoolFactory r135 = new PoolFactory(PoolConfig.newBuilder().build());
    L82:
        r134.setMPoolFactory(r135);
        ImagePipelineConfigLazySet r136 = this.mImagePipelineConfigLazySet;
        if (Builder.access$2400(r100) != null) goto L85;
        ProgressiveJpegConfig r137 = new SimpleProgressiveJpegConfig();
    L86:
        r136.setMProgressiveJpegConfig(r137);
        ImagePipelineConfigLazySet r138 = this.mImagePipelineConfigLazySet;
        if (Builder.access$2500(r100) != null) goto L89;
        Set<? extends RequestListener> r139 = new HashSet();
    L90:
        r138.setMRequestListeners(r139);
        this.mImagePipelineConfigLazySet.setMResizeAndRotateEnabledForNetwork(Boolean.valueOf(Builder.access$2600(r100)));
        ImagePipelineConfigLazySet r140 = this.mImagePipelineConfigLazySet;
        if (Builder.access$2700(r100) != null) goto L93;
        DiskCacheConfig r141 = this.mImagePipelineConfigLazySet.getMMainDiskCacheConfig();
    L94:
        r140.setMSmallImageDiskCacheConfig(r141);
        ImagePipelineConfigLazySet r142 = this.mImagePipelineConfigLazySet;
        if (Builder.access$2800(r100) != null) goto L97;
        HashMap<String, DiskCacheConfig> r143 = getDefaultCustomDiskCacheConfigMap();
    L98:
        r142.setMCustomImageDiskCacheConfigMap(r143);
        this.mImagePipelineConfigLazySet.setMImageDecoderConfig(Builder.access$2900(r100));
        int r144 = this.mImagePipelineConfigLazySet.getMPoolFactory().getFlexByteArrayPoolMaxNumThreads();
        ImagePipelineConfigLazySet r145 = this.mImagePipelineConfigLazySet;
        if (Builder.access$3000(r100) != null) goto L101;
        ExecutorSupplier r146 = new DefaultExecutorSupplier(r144);
    L102:
        r145.setMExecutorSupplier(r146);
        this.mImagePipelineConfigLazySet.setMAnimatedHeifIndividualCacheEnabled(Boolean.valueOf(Builder.access$3100(r100)));
        this.mImagePipelineConfigLazySet.setMShowHeifDebugLog(Boolean.valueOf(r100.isShowHeifDebugLog()));
        this.mImagePipelineConfigLazySet.setMAnimatedHeifIndividualCacheForImageRequestEnabled(Boolean.valueOf(Builder.access$3200(r100)));
        this.mImagePipelineConfigLazySet.setMDiskCacheEnabled(Boolean.valueOf(Builder.access$3300(r100)));
        mWasImmediate = Builder.access$3400(r100);
        WebpBitmapFactory r147 = this.mImagePipelineConfigLazySet.getMImagePipelineExperiments().getWebpBitmapFactory();
        if (r147 == null) goto L106;
        HoneycombBitmapCreator r148 = new HoneycombBitmapCreator(getPoolFactory());
        setWebpBitmapFactory(r147, this.mImagePipelineConfigLazySet.getMImagePipelineExperiments(), r148);
    L113:
        if (FrescoSystrace.isTracing() == false) goto L116;
        FrescoSystrace.endSection();
        return;
    L116:
        return;
    L106:
        if (this.mImagePipelineConfigLazySet.getMImagePipelineExperiments().isWebpSupportEnabled() == false) goto L113;
        if (WebpSupportStatus.sIsWebpSupportRequired == false) goto L113;
        WebpBitmapFactory r149 = WebpSupportStatus.loadWebpBitmapFactoryIfExists();
        if (r149 == null) goto L113;
        HoneycombBitmapCreator r150 = new HoneycombBitmapCreator(getPoolFactory());
        setWebpBitmapFactory(r149, this.mImagePipelineConfigLazySet.getMImagePipelineExperiments(), r150);
        goto L113
    L101:
        r146 = Builder.access$3000(r100);
        goto L102
    L97:
        r143 = Builder.access$2800(r100);
        goto L98
    L93:
        r141 = Builder.access$2700(r100);
        goto L94
    L89:
        r139 = Builder.access$2500(r100);
        goto L90
    L85:
        r137 = Builder.access$2400(r100);
        goto L86
    L81:
        r135 = Builder.access$2300(r100);
        goto L82
    L74:
        r133 = Builder.access$2100(r100);
        goto L75
    L67:
        r131 = Builder.access$2000(r100);
        goto L68
    L63:
        r128 = Builder.access$1900(r100);
        goto L64
    L59:
        r126 = Builder.access$1800(r100);
        goto L60
    L55:
        r124 = Builder.access$1700(r100);
        goto L56
    L51:
        r122 = Builder.access$1400(r100);
        goto L52
    L47:
        r120 = Builder.access$1300(r100);
        goto L48
    L43:
        r118 = Builder.access$1100(r100);
        goto L44
    L39:
        r116 = Builder.access$1000(r100);
        goto L40
    L35:
        r114 = Builder.access$900(r100);
        goto L36
    L31:
        r112 = Builder.access$800(r100);
        goto L32
    L27:
        r110 = Builder.access$700(r100);
        goto L28
    L23:
        r108 = Builder.access$600(r100);
        goto L24
    L19:
        r106 = Builder.access$500(r100);
        goto L20
    L15:
        r104 = Builder.access$400(r100);
        goto L16
    L11:
        r102 = Builder.access$200(r100);
        goto L12
    }

    private static DiskCacheConfig getDefaultMainDiskCacheConfig(Context r100) {
    L10:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L14;
        FrescoSystrace.endSection();
    L14:
        throw th;
    L3:
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("DiskCacheConfig.getDefaultMainDiskCacheConfig");     // Catch: Throwable -> L10
    L5:
        DiskCacheConfig r101 = DiskCacheConfig.newBuilder(r100).build();     // Catch: Throwable -> L10
        if (FrescoSystrace.isTracing() == false) goto L9;
        FrescoSystrace.endSection();
    L9:
        return r101;
    }

    @Nullable
    private static ImageTranscoderFactory getImageTranscoderFactory(Builder r100) {
        if (Builder.access$3600(r100) == null) goto L10;
        if (Builder.access$1600(r100) == null) goto L10;
        throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType");
    L10:
        if (Builder.access$3600(r100) != null) goto L12;
        return null;
    L12:
        return Builder.access$3600(r100);
    }

    public static Builder newBuilder(Context r100) {
        return new Builder(r100, null);
    }

    public /* synthetic */ ImagePipelineConfig(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    private static int getMemoryChunkType(Builder r100, ImagePipelineExperiments r101) {
        if (Builder.access$3700(r100) == null) goto L7;
        return Builder.access$3700(r100).intValue();
    L7:
        if (r101.isNativeCodeDisabled() == false) goto L10;
        return 1;
    L10:
        return 0;
    }

    private static void setWebpBitmapFactory(WebpBitmapFactory r100, ImagePipelineExperiments r101, BitmapCreator r102) {
        WebpSupportStatus.sWebpBitmapFactory = r100;
        WebpBitmapFactory.WebpErrorLogger r103 = r101.getWebpErrorLogger();
        if (r103 == null) goto L5;
        r100.setWebpErrorLogger(r103);
    L5:
        if (r102 == null) goto L8;
        r100.setBitmapCreator(r102);
        return;
    }
}
