package com.bytedance.lighten.core.config;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.lighten.core.ImagePiplinePriority;
import df6.d;
import df6.e;
import df6.h;
import df6.m;
import df6.n;
import hf6.k;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\u0019\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0004H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u001a\u0010\u0015\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H&J\b\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\u0006H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\b\u0010\u001d\u001a\u00020\u0006H&J\b\u0010\u001e\u001a\u00020\u0016H&J\b\u0010\u001f\u001a\u00020\u0016H&J\b\u0010 \u001a\u00020\u0016H&J\b\u0010!\u001a\u00020\u0016H&J\b\u0010\"\u001a\u00020\u0006H&J\b\u0010#\u001a\u00020\u0006H&J\b\u0010$\u001a\u00020\u0004H&J\b\u0010%\u001a\u00020\u0006H&J\b\u0010&\u001a\u00020\u0004H&J\b\u0010'\u001a\u00020\u0006H&J\b\u0010(\u001a\u00020\u0006H&J\b\u0010)\u001a\u00020\u0006H&J\b\u0010*\u001a\u00020\u0004H&J\b\u0010+\u001a\u00020\u0004H&J\n\u0010-\u001a\u0004\u0018\u00010,H&J\n\u0010/\u001a\u0004\u0018\u00010.H&J\b\u00100\u001a\u00020\u0004H&J\u0012\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101H&J\b\u00104\u001a\u00020\u0004H&J\n\u00106\u001a\u0004\u0018\u000105H&J\b\u00107\u001a\u00020\u0004H&J\b\u00108\u001a\u00020\u0004H&J\b\u00109\u001a\u00020\u0004H&J\b\u0010:\u001a\u00020\u0006H&J\b\u0010;\u001a\u00020\u0004H&J\b\u0010<\u001a\u00020\u0004H&J\b\u0010=\u001a\u00020\u0006H&J\b\u0010>\u001a\u00020\u0004H&J\b\u0010?\u001a\u00020\u0004H&J\b\u0010@\u001a\u00020\u0004H&J\b\u0010B\u001a\u00020AH&J\b\u0010C\u001a\u00020\u0006H&J\b\u0010D\u001a\u00020\u0004H&J\b\u0010E\u001a\u00020\u0016H&J\b\u0010F\u001a\u00020\u0016H&J\b\u0010G\u001a\u00020\u0004H&J\b\u0010H\u001a\u00020\u0004H&J\b\u0010I\u001a\u00020\u0004H&J\b\u0010J\u001a\u00020\u0004H&J\b\u0010K\u001a\u00020\u0004H&J\b\u0010L\u001a\u00020\u0006H&J\b\u0010M\u001a\u00020\u0004H&J\b\u0010N\u001a\u00020\u0004H&J\b\u0010O\u001a\u00020\u0004H&J\b\u0010P\u001a\u00020\u0004H&J\b\u0010Q\u001a\u00020\u0004H&J\b\u0010R\u001a\u00020\u0006H&J\b\u0010S\u001a\u00020\u0006H&J\b\u0010T\u001a\u00020\u0006H&J\n\u0010V\u001a\u0004\u0018\u00010UH&J\b\u0010W\u001a\u00020\u0004H&J\b\u0010X\u001a\u00020\u0004H&J\b\u0010Y\u001a\u00020\u0004H&J\b\u0010Z\u001a\u00020\u0004H&J\b\u0010[\u001a\u00020\u0004H&J\n\u0010]\u001a\u0004\u0018\u00010\\H&J\b\u0010^\u001a\u00020\u0004H&J\n\u0010`\u001a\u0004\u0018\u00010_H&J\n\u0010b\u001a\u0004\u0018\u00010aH&J\b\u0010c\u001a\u00020\u0006H&J\n\u0010e\u001a\u0004\u0018\u00010dH&J\b\u0010f\u001a\u00020\u0004H&J\b\u0010g\u001a\u00020\u0004H&J\b\u0010h\u001a\u00020\u0004H&J\b\u0010i\u001a\u00020\u0004H&J\b\u0010j\u001a\u00020\u0004H&J\b\u0010k\u001a\u00020\u0004H&J\b\u0010l\u001a\u00020\u0004H&J\b\u0010m\u001a\u00020\u0004H&J\b\u0010n\u001a\u00020\u0004H&J\b\u0010o\u001a\u00020\u0016H&J\b\u0010p\u001a\u00020\u0004H&J\b\u0010q\u001a\u00020\u0004H&J\n\u0010s\u001a\u0004\u0018\u00010rH&J\b\u0010t\u001a\u00020\u0004H&J\u001e\u0010u\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b01\u0018\u00010\u0013H&J\u001e\u0010v\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b01\u0018\u00010\u0013H&J\b\u0010w\u001a\u00020\u0004H\u0016J\b\u0010x\u001a\u00020\u0004H\u0016J\b\u0010y\u001a\u00020\u0004H\u0016J\n\u0010{\u001a\u0004\u0018\u00010zH\u0016J\b\u0010|\u001a\u00020\u0004H\u0016J\b\u0010}\u001a\u00020\u0004H\u0016J\u0017\u0010~\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016¢\u0006\u0004\b~\u0010\r¨\u0006\u007f"}, d2 = {"Lcom/bytedance/lighten/core/config/ILightenConfigOutService;", "", "Landroid/content/Context;", "getContext", "", "isCacheKeyWithoutHost", "", "getWebpAlignTime", "isCacheKeyOnlyPath", "isDecodeHeicUseSystemApiFirst", "", "", "getCacheNoHostAllowlist", "()[Ljava/lang/String;", "isEnableMemoryCacheTracker", "Ldf6/n;", "getImageFetcherFactory", "Ljava/io/File;", "getDiskCacheDir", "", "Ldf6/e;", "getCustomDiskCacheDirMap", "", "getMaxDiskCacheSize", "getDebugLevel", "Lef6/b;", "getConverterFactory", "Landroid/graphics/Bitmap$Config;", "getBitmapConfig", "getPreDecodeFrameCount", "getMaxBitmapMemoryCacheSize", "getMaxAnimBitmapMemoryCacheSize", "getMaxEncodedMemoryCacheSize", "getSmallDiskMaxCacheSize", "getMaxOptEntrySize", "getMaxPrefetchOptEntrySize", "isImageMonitorEnabled", "isMonitorSampleOptEnabled", "isLimitBitmapMonitorEnable", "getLimitFileSize", "getLimitBitmapContrast", "getLimitRamSize", "isMonitorLogEnabled", "ismEnableOpt", "Lhf6/k;", "getImageMonitorListener", "Lhf6/b;", "getCacheEventListener", "isForceInit", "", "Ldf6/a;", "getAnimationFrameSchedulers", "isTrimMemory", "Ldf6/m;", "getSoLoader", "needMD5", "needEncrypt", "isWasImmediate", "getOomOpt", "isBugfix", "isFixMemoryLeak", "getImageRequestOpt", "isLoadBitmapWithoutCopy", "isAnimatedHeifIndividualCacheEnabled", "isSplitMemCache", "", "getDiskCacheEvictRadio", "getMaxBitmapSize", "isEnableBigImgCache", "getBigImgSizeLimit", "getBigImgCacheSize", "isSaveAfterSrPostBitmap", "isSavePreSrPostBitmap", "isLocalVideoThumbnailOptEnabled", "isHeifBitmapOpt", "isVvicUseWpp", "getVvicDecodeThreads", "isDownloadAnrFix", "isBitmapConfigFix", "isSRAutoScaleLowerFirst", "isSplitPrefetchCache", "isOptPrefetchCacheKey", "getPrefetchImgBitmapMaxCacheSize", "getPrefetchImgBitmapMaxCacheEntries", "getPrefetchImgBitmapMaxEvictionQueueSize", "Ldf6/h;", "getHeifUrlReplaceConfig", "isNewHeifBitmapOpt", "isEnableSecurityTag", "isEnableDefaultResizeOption", "isAutoBitmapConfig", "isFadeDurationBugfix", "Ldf6/d;", "getCacheKeyConfig", "isPieDecoderEnabled", "Lgf6/a;", "getExecutorSupplierConfig", "Lcom/bytedance/lighten/core/ImagePiplinePriority;", "getDefaultImagePipelinePriority", "getCustomCacheDownloadBugfix", "Lif6/a;", "getGlobalSharpConfig", "isEnableLazyInit", "isEnableDupRequestOpt", "isEnableWriteDiskCacheThreadOpt", "isDisableSRForNODisplayImageRequest", "getReuseMemoryCache", "isHardwareBitmapCopyBugfix", "enableFrescoInternalRequestPriority", "isCreateNewEmptyBuilder", "isEnableSingleMemCache", "getMaxSingleBitmapMemoryCacheSize", "isFrescoProducerOpt", "isSizeDeterminerBugfix", "Lcom/bytedance/lighten/core/config/a;", "getLightenBitmapPrepareConfig", "isLoadBitmapSmartSubscriberOpt", "getWhiteList", "getBlackList", "isIntermediateProgressUpdatesDisabled", "isIntermediateProgressUpdatesForPrefetchDisabled", "isHeifBitmapPoolEnabled", "Lcom/bytedance/lighten/core/config/b;", "getFrescoPoolLazyConfig", "isCacheKeyHostOptEnableBugfix", "isCacheKeyWithoutHostBlackList", "getCacheNoHostNotAllowlist", "lighten-core_release"}, k = 1, mv = {1, 4, 0})
public interface ILightenConfigOutService {
    boolean enableFrescoInternalRequestPriority();

    List<df6.a> getAnimationFrameSchedulers();

    long getBigImgCacheSize();

    long getBigImgSizeLimit();

    Bitmap.Config getBitmapConfig();

    Map<String, List<String>> getBlackList();

    hf6.b getCacheEventListener();

    d getCacheKeyConfig();

    String[] getCacheNoHostAllowlist();

    String[] getCacheNoHostNotAllowlist();

    Context getContext();

    ef6.b getConverterFactory();

    int getCustomCacheDownloadBugfix();

    Map<String, e> getCustomDiskCacheDirMap();

    int getDebugLevel();

    ImagePiplinePriority getDefaultImagePipelinePriority();

    File getDiskCacheDir();

    float getDiskCacheEvictRadio();

    gf6.a getExecutorSupplierConfig();

    b getFrescoPoolLazyConfig();

    if6.a getGlobalSharpConfig();

    h getHeifUrlReplaceConfig();

    n getImageFetcherFactory();

    k getImageMonitorListener();

    int getImageRequestOpt();

    a getLightenBitmapPrepareConfig();

    int getLimitBitmapContrast();

    int getLimitFileSize();

    int getLimitRamSize();

    long getMaxAnimBitmapMemoryCacheSize();

    long getMaxBitmapMemoryCacheSize();

    int getMaxBitmapSize();

    long getMaxDiskCacheSize();

    long getMaxEncodedMemoryCacheSize();

    int getMaxOptEntrySize();

    int getMaxPrefetchOptEntrySize();

    long getMaxSingleBitmapMemoryCacheSize();

    int getOomOpt();

    int getPreDecodeFrameCount();

    int getPrefetchImgBitmapMaxCacheEntries();

    int getPrefetchImgBitmapMaxCacheSize();

    int getPrefetchImgBitmapMaxEvictionQueueSize();

    boolean getReuseMemoryCache();

    long getSmallDiskMaxCacheSize();

    m getSoLoader();

    int getVvicDecodeThreads();

    int getWebpAlignTime();

    Map<String, List<String>> getWhiteList();

    boolean isAnimatedHeifIndividualCacheEnabled();

    boolean isAutoBitmapConfig();

    boolean isBitmapConfigFix();

    boolean isBugfix();

    boolean isCacheKeyHostOptEnableBugfix();

    boolean isCacheKeyOnlyPath();

    boolean isCacheKeyWithoutHost();

    boolean isCacheKeyWithoutHostBlackList();

    boolean isCreateNewEmptyBuilder();

    boolean isDecodeHeicUseSystemApiFirst();

    boolean isDisableSRForNODisplayImageRequest();

    boolean isDownloadAnrFix();

    boolean isEnableBigImgCache();

    boolean isEnableDefaultResizeOption();

    boolean isEnableDupRequestOpt();

    boolean isEnableLazyInit();

    boolean isEnableMemoryCacheTracker();

    boolean isEnableSecurityTag();

    boolean isEnableSingleMemCache();

    boolean isEnableWriteDiskCacheThreadOpt();

    boolean isFadeDurationBugfix();

    boolean isFixMemoryLeak();

    boolean isForceInit();

    boolean isFrescoProducerOpt();

    boolean isHardwareBitmapCopyBugfix();

    boolean isHeifBitmapOpt();

    boolean isHeifBitmapPoolEnabled();

    boolean isImageMonitorEnabled();

    boolean isIntermediateProgressUpdatesDisabled();

    boolean isIntermediateProgressUpdatesForPrefetchDisabled();

    boolean isLimitBitmapMonitorEnable();

    boolean isLoadBitmapSmartSubscriberOpt();

    boolean isLoadBitmapWithoutCopy();

    boolean isLocalVideoThumbnailOptEnabled();

    boolean isMonitorLogEnabled();

    int isMonitorSampleOptEnabled();

    boolean isNewHeifBitmapOpt();

    boolean isOptPrefetchCacheKey();

    boolean isPieDecoderEnabled();

    boolean isSRAutoScaleLowerFirst();

    boolean isSaveAfterSrPostBitmap();

    boolean isSavePreSrPostBitmap();

    boolean isSizeDeterminerBugfix();

    boolean isSplitMemCache();

    boolean isSplitPrefetchCache();

    boolean isTrimMemory();

    boolean isVvicUseWpp();

    boolean isWasImmediate();

    boolean ismEnableOpt();

    boolean needEncrypt();

    boolean needMD5();
}
