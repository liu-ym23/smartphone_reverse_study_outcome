package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.FileCache;
import com.facebook.imagepipeline.cache.StagingArea;
import com.facebook.imagepipeline.image.EncodedImage;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class FrescoCacheMonitorUtil {
    private static boolean mAddMDLCancel = false;
    private static boolean mAnimatedHeifIndividualCacheEnabled = false;
    private static boolean mAnimatedHeifIndividualCacheForImageRequestEnabled = false;
    private static boolean mAutoDownsampleKeyOpt = false;
    private static boolean mAvoidSRAbnormal = false;
    private static long mBigImgSizeLimit = 2097152;
    private static boolean mControllerBuilderByLazyInit = false;
    private static List<String> mCurrentSceneTags = null;
    private static long mDelayTime = 0;
    private static boolean mDelayWriteDisk = false;
    private static boolean mDiskCacheEnabled = false;
    private static boolean mDownsampleEnabled = false;
    private static boolean mEnableAddLogUriInfo = false;
    private static boolean mEnableBigImgCache = false;
    private static boolean mEnableCalculateColor = false;
    private static boolean mEnableFileProviderOpt = false;
    private static boolean mEnableNewLocalVideoThumbnailOpt = false;
    private static boolean mEnablePrefetchImgCache = false;
    private static boolean mEnableSingleCache = false;
    private static boolean mFixVvicDecode = false;
    private static int mHeicDecodeThreads = 1;
    private static boolean mHeicUseWpp = false;
    private static boolean mHeifBitmapPoolEnabled = false;
    private static int mHeifDecodeThreads = 1;
    private static boolean mHeifUseWpp = false;
    private static boolean mIsFallBackMainDisk = false;
    private static boolean mIsSplitMemCache = false;
    private static boolean mIsSplitPrefetchCache = false;
    private static boolean mLocalVideoThumbOpt = false;
    private static boolean mMultiUrlCacheOpt = false;
    private static boolean mOptAnimCacheClear = false;
    private static boolean mOptAutoSr = false;
    private static boolean mOptBitmapCacheKey = false;
    private static boolean mOptHardWareForSRProcessor = false;
    private static boolean mOptHeifParse = false;
    private static boolean mOptLazyInit = false;
    private static boolean mOptListenerAnr = false;
    private static boolean mOptMDLCancel = false;
    private static boolean mOptMonitorSample = false;
    private static boolean mOptMonitorSampleDebug = false;
    private static boolean mOptMultiOriginListener = false;
    private static boolean mOptMultiRequestSensible = false;
    private static boolean mOptPlaceholderNull = false;
    private static boolean mOptPrefetchCacheKey = false;
    private static boolean mOptRest = false;
    private static boolean mOptRgbaForPostProcessor = false;
    private static boolean mOptSensibleMonitor = false;
    private static boolean mOptSimpleDraweeViewAnr = false;
    private static boolean mOptUltimateProducerReached = false;
    private static boolean mRemoveVvicUseSystemApi = false;
    private static boolean mResizeAndRotateEnabledForNetwork = false;
    private static boolean mRetainPreviousImage = false;
    private static boolean mSRAutoScaleLowerFirst = false;
    private static boolean mSaveAfterSrPostBitmap = false;
    private static boolean mSavePreSrPostBitmap = false;
    private static boolean mShowHeifDebugLog = false;
    private static boolean mSkipLazyRead = false;
    private static float mStretchAboveForSR = 0.0f;
    private static boolean mTTHeifAnimDecOpt = false;
    private static boolean mTTHeifDecOpt = false;
    private static boolean mUseHeicHdr = false;
    private static boolean mUseHeicHdrRgba102 = false;
    private static boolean mUseImageDecoder = false;
    private static boolean mUseJniSr = false;
    private static boolean mUseNewOptHeifBitmap = false;
    private static boolean mUseOptHeifBitmap = false;
    private static boolean mUseUltimateOptHeifBitmap = false;
    private static int mUsedBytes = 0;
    private static boolean mVvicDecOpt = false;
    private static int mVvicDecodeThreads = 1;
    private static int mVvicOptMode;
    private static boolean mVvicUseWpp;
    private static Map<String, String> mWaitParseParamFromUrl;
    private static FileCache mainFileCache;
    private static StagingArea mainStagingArea;
    private static int maxSizeHardCap;

    /* JADX INFO: loaded from: classes23.dex */
    public static class SingletonHolder {
        private static final int NUM_IO_BOUND_THREADS = 2;
        private static final ScheduledExecutorService mIoBoundExecutor = null;

        private SingletonHolder() {
        }

        static {
            mIoBoundExecutor = PThreadExecutorsUtils.newScheduledThreadPool(2, new PriorityThreadFactory(10, "FrescoDelayIoBoundExecutor", true));
        }

        public static /* synthetic */ ScheduledExecutorService access$000() {
            return mIoBoundExecutor;
        }
    }

    public FrescoCacheMonitorUtil() {
    }

    public static ScheduledExecutorService getNewIoBoundExecutor() {
        return SingletonHolder.access$000();
    }

    public static long getBigImgSizeLimit() {
        return mBigImgSizeLimit;
    }

    public static List<String> getCurrentSceneTags() {
        return mCurrentSceneTags;
    }

    public static long getDelayTime() {
        return mDelayTime;
    }

    public static int getHeicDecodeThreads() {
        return mHeicDecodeThreads;
    }

    public static int getHeifDecodeThreads() {
        return mHeifDecodeThreads;
    }

    public static FileCache getMainFileCache() {
        return mainFileCache;
    }

    public static StagingArea getMainStagingArea() {
        return mainStagingArea;
    }

    public static int getMaxSizeHardCap() {
        return maxSizeHardCap;
    }

    public static float getStretchAboveForSR() {
        return mStretchAboveForSR;
    }

    public static boolean getTTHeifAnimDecOpt() {
        return mTTHeifAnimDecOpt;
    }

    public static boolean getTTHeifDecOpt() {
        return mTTHeifDecOpt;
    }

    public static int getUsedBytes() {
        return mUsedBytes;
    }

    public static boolean getVvicDecOpt() {
        return mVvicDecOpt;
    }

    public static int getVvicDecodeThreads() {
        return mVvicDecodeThreads;
    }

    public static int getVvicOptMode() {
        return mVvicOptMode;
    }

    public static Map<String, String> getWaitParseParamFromUrl() {
        return mWaitParseParamFromUrl;
    }

    public static boolean isAddMDLCancel() {
        return mAddMDLCancel;
    }

    public static boolean isAnimatedHeifIndividualCacheEnabled() {
        return mAnimatedHeifIndividualCacheEnabled;
    }

    public static boolean isAnimatedHeifIndividualCacheForImageRequestEnabled() {
        return mAnimatedHeifIndividualCacheForImageRequestEnabled;
    }

    public static boolean isAutoDownsampleKeyOpt() {
        return mAutoDownsampleKeyOpt;
    }

    public static boolean isAvoidSRAbnormal() {
        return mAvoidSRAbnormal;
    }

    public static boolean isControllerBuilderByLazyInit() {
        return mControllerBuilderByLazyInit;
    }

    public static boolean isDelayWriteDisk() {
        return mDelayWriteDisk;
    }

    public static boolean isDiskCacheEnabled() {
        return mDiskCacheEnabled;
    }

    public static boolean isDownsampleEnabled() {
        return mDownsampleEnabled;
    }

    public static boolean isEnableAddLogUriInfo() {
        return mEnableAddLogUriInfo;
    }

    public static boolean isEnableBigImgCache() {
        return mEnableBigImgCache;
    }

    public static boolean isEnableCalculateColor() {
        return mEnableCalculateColor;
    }

    public static boolean isEnableFileProviderOpt() {
        return mEnableFileProviderOpt;
    }

    public static boolean isEnablePrefetchImgCache() {
        return mEnablePrefetchImgCache;
    }

    public static boolean isEnableSingleCache() {
        return mEnableSingleCache;
    }

    public static boolean isFallBackMainDisk() {
        return mIsFallBackMainDisk;
    }

    public static boolean isFixVvicDecode() {
        return mFixVvicDecode;
    }

    public static boolean isHeicUseWpp() {
        return mHeicUseWpp;
    }

    public static boolean isHeifBitmapPoolEnabled() {
        return mHeifBitmapPoolEnabled;
    }

    public static boolean isHeifUseWpp() {
        return mHeifUseWpp;
    }

    public static boolean isLocalVideoThumbOpt() {
        return mLocalVideoThumbOpt;
    }

    public static boolean isMultiUrlCacheOpt() {
        return mMultiUrlCacheOpt;
    }

    public static boolean isNewLocalVideoThumbnailOptEnabled() {
        return mEnableNewLocalVideoThumbnailOpt;
    }

    public static boolean isOptAnimCacheClear() {
        return mOptAnimCacheClear;
    }

    public static boolean isOptAutoSr() {
        return mOptAutoSr;
    }

    public static boolean isOptBitmapCacheKey() {
        return mOptBitmapCacheKey;
    }

    public static boolean isOptHardWareForSRProcessor() {
        return mOptHardWareForSRProcessor;
    }

    public static boolean isOptHeifParse() {
        return mOptHeifParse;
    }

    public static boolean isOptLazyInit() {
        return mOptLazyInit;
    }

    public static boolean isOptListenerAnr() {
        return mOptListenerAnr;
    }

    public static boolean isOptMDLCancel() {
        return mOptMDLCancel;
    }

    public static boolean isOptMonitorSample() {
        return mOptMonitorSample;
    }

    public static boolean isOptMonitorSampleDebug() {
        return mOptMonitorSampleDebug;
    }

    public static boolean isOptMultiOriginListener() {
        return mOptMultiOriginListener;
    }

    public static boolean isOptMultiRequestSensible() {
        return mOptMultiRequestSensible;
    }

    public static boolean isOptPrefetchCacheKey() {
        return mOptPrefetchCacheKey;
    }

    public static boolean isOptRest() {
        return mOptRest;
    }

    public static boolean isOptRgbaForPostProcessor() {
        return mOptRgbaForPostProcessor;
    }

    public static boolean isOptSensibleMonitor() {
        return mOptSensibleMonitor;
    }

    public static boolean isOptSimpleDraweeViewAnr() {
        return mOptSimpleDraweeViewAnr;
    }

    public static boolean isOptUltimateProducerReached() {
        return mOptUltimateProducerReached;
    }

    public static boolean isRemoveVvicUseSystemApi() {
        return mRemoveVvicUseSystemApi;
    }

    public static boolean isResizeAndRotateEnabledForNetwork() {
        return mResizeAndRotateEnabledForNetwork;
    }

    public static boolean isRetainPreviousImage() {
        return mRetainPreviousImage;
    }

    public static boolean isSRAutoScaleLowerFirst() {
        return mSRAutoScaleLowerFirst;
    }

    public static boolean isSaveAfterPostBitmap() {
        return mSaveAfterSrPostBitmap;
    }

    public static boolean isSavePrePostBitmap() {
        return mSavePreSrPostBitmap;
    }

    public static boolean isShowHeifDebugLog() {
        return mShowHeifDebugLog;
    }

    public static boolean isSkipLazyRead() {
        return mSkipLazyRead;
    }

    public static boolean isSplitMemCache() {
        return mIsSplitMemCache;
    }

    public static boolean isSplitPrefetchCache() {
        return mIsSplitPrefetchCache;
    }

    public static boolean isUseHeicHdr() {
        return mUseHeicHdr;
    }

    public static boolean isUseHeicHdrRgba102() {
        return mUseHeicHdrRgba102;
    }

    public static boolean isUseImageDecoder() {
        return mUseImageDecoder;
    }

    public static boolean isUseJniSr() {
        return mUseJniSr;
    }

    public static boolean isUseNewOptHeifBitmap() {
        return mUseNewOptHeifBitmap;
    }

    public static boolean isUseOptHeifBitmap() {
        return mUseOptHeifBitmap;
    }

    public static boolean isUseUltimateOptHeifBitmap() {
        return mUseUltimateOptHeifBitmap;
    }

    public static boolean isVvicUseWpp() {
        return mVvicUseWpp;
    }

    public static void setAddMDLCancel(boolean r100) {
        mAddMDLCancel = r100;
    }

    public static void setAnimatedHeifIndividualCacheEnabled(boolean r100) {
        mAnimatedHeifIndividualCacheEnabled = r100;
    }

    public static void setAnimatedHeifIndividualCacheForImageRequestEnabled(boolean r100) {
        mAnimatedHeifIndividualCacheForImageRequestEnabled = r100;
    }

    public static void setAutoDownsampleKeyOpt(boolean r100) {
        mAutoDownsampleKeyOpt = r100;
    }

    public static void setAvoidSRAbnormal(boolean r100) {
        mAvoidSRAbnormal = r100;
    }

    public static void setBigImgSizeLimit(long r100) {
        mBigImgSizeLimit = r100;
    }

    public static void setControllerBuilderByLazyInit(boolean r100) {
        mControllerBuilderByLazyInit = r100;
    }

    public static void setCurrentSceneTags(List<String> r100) {
        mCurrentSceneTags = r100;
    }

    public static void setDiskCacheEnabled(boolean r100) {
        mDiskCacheEnabled = r100;
    }

    public static void setDownsampleEnabled(boolean r100) {
        mDownsampleEnabled = r100;
    }

    public static void setEnableAddLogUriInfo(boolean r100) {
        mEnableAddLogUriInfo = r100;
    }

    public static void setEnableBigImgCache(boolean r100) {
        mEnableBigImgCache = r100;
    }

    public static void setEnableCalculateColor(boolean r100) {
        mEnableCalculateColor = r100;
    }

    public static void setEnableFileProviderOpt(boolean r100) {
        mEnableFileProviderOpt = r100;
    }

    public static void setEnablePrefetchImgCache(boolean r100) {
        mEnablePrefetchImgCache = r100;
    }

    public static void setEnableSaveAfterSrPostBitmap(boolean r100) {
        mSaveAfterSrPostBitmap = r100;
    }

    public static void setEnableSavePreSrPostBitmap(boolean r100) {
        mSavePreSrPostBitmap = r100;
    }

    public static void setEnableSingleCache(boolean r100) {
        mEnableSingleCache = r100;
    }

    public static void setFixVvicDecode(boolean r100) {
        mFixVvicDecode = r100;
    }

    public static void setHeicDecodeThreads(int r100) {
        mHeicDecodeThreads = r100;
    }

    public static void setHeicUseWpp(boolean r100) {
        mHeicUseWpp = r100;
    }

    public static void setHeifBitmapPoolEnabled(boolean r100) {
        mHeifBitmapPoolEnabled = r100;
    }

    public static void setHeifDecodeThreads(int r100) {
        mHeifDecodeThreads = r100;
    }

    public static void setHeifUseWpp(boolean r100) {
        mHeifUseWpp = r100;
    }

    public static void setIsFallBackMainDisk(boolean r100) {
        mIsFallBackMainDisk = r100;
    }

    public static void setLocalVideoThumbOpt(boolean r100) {
        mLocalVideoThumbOpt = r100;
    }

    public static void setMainFileCache(FileCache r100) {
        mainFileCache = r100;
    }

    public static void setMainStagingArea(StagingArea r100) {
        mainStagingArea = r100;
    }

    public static void setMaxSizeHardCap(int r100) {
        maxSizeHardCap = r100;
    }

    public static void setMultiUrlCacheOpt(boolean r100) {
        mMultiUrlCacheOpt = r100;
    }

    public static void setNewLocalVideoThumbnailOptEnabled(boolean r100) {
        mEnableNewLocalVideoThumbnailOpt = r100;
    }

    public static void setOptAnimCacheClear(boolean r100) {
        mOptAnimCacheClear = r100;
    }

    public static void setOptAutoSr(boolean r100) {
        mOptAutoSr = r100;
    }

    public static void setOptBitmapCacheKey(boolean r100) {
        mOptBitmapCacheKey = r100;
    }

    public static void setOptHardWareForSRProcessor(boolean r100) {
        mOptHardWareForSRProcessor = r100;
    }

    public static void setOptHeifParse(boolean r100) {
        if (r100 == false) goto L4;
        EncodedImage.setOptHeifParse(true);
    L4:
        mOptHeifParse = r100;
    }

    public static void setOptLazyInit(boolean r100) {
        mOptLazyInit = r100;
    }

    public static void setOptListenerAnr(boolean r100) {
        mOptListenerAnr = r100;
    }

    public static void setOptMDLCancel(boolean r100) {
        mOptMDLCancel = r100;
    }

    public static void setOptMonitorSample(boolean r100) {
        mOptMonitorSample = r100;
    }

    public static void setOptMonitorSampleDebug(boolean r100) {
        mOptMonitorSampleDebug = r100;
    }

    public static void setOptMultiOriginListener(boolean r100) {
        mOptMultiOriginListener = r100;
    }

    public static void setOptMultiRequestSensible(boolean r100) {
        mOptMultiRequestSensible = r100;
    }

    public static void setOptPlaceholderNull(boolean r100) {
        mOptPlaceholderNull = r100;
    }

    public static void setOptPrefetchCacheKey(boolean r100) {
        mOptPrefetchCacheKey = r100;
    }

    public static void setOptRest(boolean r100) {
        mOptRest = r100;
    }

    public static void setOptRgbaForPostProcessor(boolean r100) {
        mOptRgbaForPostProcessor = r100;
    }

    public static void setOptSensibleMonitor(boolean r100) {
        mOptSensibleMonitor = r100;
    }

    public static void setOptSimpleDraweeViewAnr(boolean r100) {
        mOptSimpleDraweeViewAnr = r100;
    }

    public static void setOptUltimateProducerReached(boolean r100) {
        mOptUltimateProducerReached = r100;
    }

    public static void setRemoveVvicUseSystemApi(boolean r100) {
        mRemoveVvicUseSystemApi = r100;
    }

    public static void setResizeAndRotateEnabledForNetwork(boolean r100) {
        mResizeAndRotateEnabledForNetwork = r100;
    }

    public static void setRetainPreviousImage(boolean r100) {
        mRetainPreviousImage = r100;
    }

    public static void setSRAutoScaleLowerFirst(boolean r100) {
        mSRAutoScaleLowerFirst = r100;
    }

    public static void setShowHeifDebugLog(boolean r100) {
        mShowHeifDebugLog = r100;
    }

    public static void setSkipLazyRead(boolean r100) {
        mSkipLazyRead = r100;
    }

    public static void setSplitMemCache(boolean r100) {
        mIsSplitMemCache = r100;
    }

    public static void setSplitPrefetchCache(boolean r100) {
        mIsSplitPrefetchCache = r100;
    }

    public static void setStretchAboveForSR(float r100) {
        mStretchAboveForSR = r100;
    }

    public static void setTTHeifAnimDecOpt(boolean r100) {
        mTTHeifAnimDecOpt = r100;
    }

    public static void setTTHeifDecOpt(boolean r100) {
        mTTHeifDecOpt = r100;
    }

    public static void setUseHeicHdr(boolean r100) {
        mUseHeicHdr = r100;
    }

    public static void setUseHeicHdrRgba102(boolean r100) {
        mUseHeicHdrRgba102 = r100;
    }

    public static void setUseImageDecoder(boolean r100) {
        mUseImageDecoder = r100;
    }

    public static void setUseJniSr(boolean r100) {
        mUseJniSr = r100;
    }

    public static void setUseNewOptHeifBitmap(boolean r100) {
        mUseNewOptHeifBitmap = r100;
    }

    public static void setUseOptHeifBitmap(boolean r100) {
        mUseOptHeifBitmap = r100;
    }

    public static void setUseUltimateOptHeifBitmap(boolean r100) {
        EncodedImage.setUseUltimateOptHeifBitmap(r100);
        mUseUltimateOptHeifBitmap = r100;
    }

    public static void setUsedBytes(int r100) {
        mUsedBytes = r100;
    }

    public static void setVvicDecOpt(boolean r100) {
        mVvicDecOpt = r100;
    }

    public static void setVvicDecodeThreads(int r100) {
        mVvicDecodeThreads = r100;
    }

    public static void setVvicOptMode(int r100) {
        mVvicOptMode = r100;
    }

    public static void setVvicUseWpp(boolean r100) {
        mVvicUseWpp = r100;
    }

    public static void setWaitParseParamFromUrl(Map<String, String> r100) {
        mWaitParseParamFromUrl = r100;
    }

    public static void setDelayWriteDisk(boolean r100, long r101) {
        mDelayWriteDisk = r100;
        mDelayTime = r101;
        if (r100 == false) goto L5;
        return;
    L5:
        if (getNewIoBoundExecutor() == null) goto L9;
        getNewIoBoundExecutor().shutdown();
        return;
    }
}
