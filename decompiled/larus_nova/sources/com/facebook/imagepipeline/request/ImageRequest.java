package com.facebook.imagepipeline.request;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imageutils.BitmapUtil;
import java.io.File;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ImageRequest {
    private boolean isAsyncAttach;
    private boolean isAsyncRequest;
    private boolean isFallBackToMainMemory;
    private int mAwebpScanNumber;
    private final List<Uri> mBackupUris;

    @Nullable
    private final BlurHashConfig mBlurHashOptions;

    @Nullable
    private final BytesRange mBytesRange;
    private final CacheChoice mCacheChoice;

    @Nullable
    private ResizeOptions mCacheKeyResizeOptions;
    private final Uri mCacheKeyUri;
    private CalculateColorConfig mCalculateColorConfig;
    private final String mCustomCacheName;
    private Map<String, String> mCustomParam;
    private boolean mDisableAutoDownsample;
    private boolean mEnableNetworkPriority;
    private boolean mHasDecodedThumb;
    private Map<String, String> mHttpHeader;
    private final ImageDecodeOptions mImageDecodeOptions;
    private final boolean mIsDiskCacheEnabled;
    private final boolean mIsMemoryCacheEnabled;
    private boolean mIsOptPrefetch;
    private boolean mIsPrefetch;
    private final boolean mIsResizedImageDiskCacheEnabled;
    private final boolean mLoadThumbnailOnly;
    private final boolean mLocalThumbnailPreviewsEnabled;
    private final RequestLevel mLowestPermittedRequestLevel;
    private boolean mMultiplexerEnabled;
    private boolean mNeedReplaceUri;
    private boolean mOptOnNewResultMsg;

    @Nullable
    private final Postprocessor mPostprocessor;
    private int mPreviewAlgo;
    private long mPreviewDecodeEnd;
    private long mPreviewDecodeTime;
    private int mPreviewDuration;
    private String mPreviewError;
    private boolean mPreviewUsed;
    private final boolean mProgressiveRenderingAnimatedEnabled;
    private final boolean mProgressiveRenderingEnabled;
    private final boolean mProgressiveRenderingHeicEnabled;
    private String mPublicKey;

    @Nullable
    private final RequestListener mRequestListener;
    private final Priority mRequestPriority;

    @Nullable
    private final ResizeOptions mResizeOptions;
    private final RotationOptions mRotationOptions;
    private int mSampleSize;
    private SizeDeterminer mSizeDeterminer;
    private File mSourceFile;
    private final Uri mSourceUri;
    private final int mSourceUriType;
    private int mTargetHeight;
    private int mTargetWidth;
    private boolean mThumbDataInFetch;
    private String mUrlKey;
    private boolean useSingleHeaderBlurhash;

    public static final enum CacheChoice extends Enum<CacheChoice> {
        private static final /* synthetic */ CacheChoice[] $VALUES = null;
        public static final CacheChoice CUSTOM = null;
        public static final CacheChoice DEFAULT = null;
        public static final CacheChoice SMALL = null;

        static {
            CacheChoice r100 = new CacheChoice("CUSTOM", 0);
            CUSTOM = r100;
            CacheChoice r101 = new CacheChoice("SMALL", 1);
            SMALL = r101;
            CacheChoice r102 = new CacheChoice("DEFAULT", 2);
            DEFAULT = r102;
            $VALUES = new CacheChoice[]{r100, r101, r102};
        }

        public static CacheChoice[] values() {
            return (CacheChoice[]) $VALUES.clone();
        }

        public static CacheChoice valueOf(String r100) {
            return (CacheChoice) Enum.valueOf(CacheChoice.class, r100);
        }

        private CacheChoice(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum RequestLevel extends Enum<RequestLevel> {
        private static final /* synthetic */ RequestLevel[] $VALUES = null;
        public static final RequestLevel BITMAP_MEMORY_CACHE = null;
        public static final RequestLevel DISK_CACHE = null;
        public static final RequestLevel ENCODED_MEMORY_CACHE = null;
        public static final RequestLevel FULL_FETCH = null;
        private int mValue;

        static {
            RequestLevel r100 = new RequestLevel("FULL_FETCH", 0, 1);
            FULL_FETCH = r100;
            RequestLevel r101 = new RequestLevel("DISK_CACHE", 1, 2);
            DISK_CACHE = r101;
            RequestLevel r102 = new RequestLevel("ENCODED_MEMORY_CACHE", 2, 3);
            ENCODED_MEMORY_CACHE = r102;
            RequestLevel r103 = new RequestLevel("BITMAP_MEMORY_CACHE", 3, 4);
            BITMAP_MEMORY_CACHE = r103;
            $VALUES = new RequestLevel[]{r100, r101, r102, r103};
        }

        public static RequestLevel[] values() {
            return (RequestLevel[]) $VALUES.clone();
        }

        public int getValue() {
            return this.mValue;
        }

        public static RequestLevel valueOf(String r100) {
            return (RequestLevel) Enum.valueOf(RequestLevel.class, r100);
        }

        public static RequestLevel getMax(RequestLevel r100, RequestLevel r101) {
            if (r100.getValue() <= r101.getValue()) goto L6;
            return r100;
        L6:
            return r101;
        }

        private RequestLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    public synchronized File getSourceFile() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mSourceFile != null) goto L6;
        this.mSourceFile = new PolarisFileWrapper(this.mSourceUri.getPath());     // Catch: Throwable -> L9
    L6:
        File r100 = this.mSourceFile;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public boolean getAutoRotateEnabled() {
        return this.mRotationOptions.useImageMetadata();
    }

    public boolean getLoadThumbnailOnlyForAndroidSdkAboveQ() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
    L7:
        return false;
    L5:
        if (this.mLoadThumbnailOnly == false) goto L7;
        return true;
    }

    public int getPreferredHeight() {
        ResizeOptions r100 = this.mResizeOptions;
        if (r100 == null) goto L6;
        return r100.height;
    L6:
        return (int) BitmapUtil.MAX_BITMAP_SIZE;
    }

    public int getPreferredWidth() {
        ResizeOptions r100 = this.mResizeOptions;
        if (r100 == null) goto L6;
        return r100.width;
    L6:
        return (int) BitmapUtil.MAX_BITMAP_SIZE;
    }

    public int hashCode() {
        Postprocessor r100 = this.mPostprocessor;
        if (r100 == null) goto L5;
        CacheKey r101 = r100.getPostprocessorCacheKey();
    L7:
        if (r101 == null) goto L11;
        return Objects.hashCode(new Object[]{this.mCacheChoice, this.mSourceUri, this.mSourceFile, this.mBytesRange, null, this.mResizeOptions, this.mRotationOptions, r101, Boolean.valueOf(this.mLoadThumbnailOnly)});
    L11:
        return Objects.hashCode(new Object[]{this.mCacheChoice, this.mSourceUri, this.mSourceFile, this.mBytesRange, this.mImageDecodeOptions, this.mResizeOptions, this.mRotationOptions, r101, Boolean.valueOf(this.mLoadThumbnailOnly)});
    L5:
        r101 = null;
        goto L7
    }

    public boolean isResizedImageDiskCacheActuallyEnabled() {
        if (isResizedImageDiskCacheEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (getResizeOptions() == null) goto L7;
        return true;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("uri", this.mSourceUri).add("cacheChoice", this.mCacheChoice).add("decodeOptions", this.mImageDecodeOptions).add("postprocessor", this.mPostprocessor).add("priority", this.mRequestPriority).add("resizeOptions", this.mResizeOptions).add("rotationOptions", this.mRotationOptions).add("bytesRange", this.mBytesRange).toString();
    }

    public int getAwebpScanNumber() {
        return this.mAwebpScanNumber;
    }

    public List<Uri> getBackupUris() {
        return this.mBackupUris;
    }

    @Nullable
    public BlurHashConfig getBlurHashOptions() {
        return this.mBlurHashOptions;
    }

    @Nullable
    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public CacheChoice getCacheChoice() {
        return this.mCacheChoice;
    }

    public ResizeOptions getCacheKeyResizeOptions() {
        return this.mCacheKeyResizeOptions;
    }

    public Uri getCacheKeyUri() {
        return this.mCacheKeyUri;
    }

    public CalculateColorConfig getCalculateColorConfig() {
        return this.mCalculateColorConfig;
    }

    public String getCustomCacheName() {
        return this.mCustomCacheName;
    }

    public Map<String, String> getCustomParam() {
        return this.mCustomParam;
    }

    public boolean getHasDecodedThumb() {
        return this.mHasDecodedThumb;
    }

    public Map<String, String> getHttpHeader() {
        return this.mHttpHeader;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        return this.mImageDecodeOptions;
    }

    public boolean getLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    @Nullable
    public Postprocessor getPostprocessor() {
        return this.mPostprocessor;
    }

    public int getPreviewAlgo() {
        return this.mPreviewAlgo;
    }

    public long getPreviewDecodeEnd() {
        return this.mPreviewDecodeEnd;
    }

    public long getPreviewDecodeTime() {
        return this.mPreviewDecodeTime;
    }

    public int getPreviewDuration() {
        return this.mPreviewDuration;
    }

    public String getPreviewError() {
        return this.mPreviewError;
    }

    public boolean getPreviewUsed() {
        return this.mPreviewUsed;
    }

    public Priority getPriority() {
        return this.mRequestPriority;
    }

    public boolean getProgressiveRenderingAnimatedEnabled() {
        return this.mProgressiveRenderingAnimatedEnabled;
    }

    public boolean getProgressiveRenderingEnabled() {
        return this.mProgressiveRenderingEnabled;
    }

    public boolean getProgressiveRenderingHeicEnabled() {
        return this.mProgressiveRenderingHeicEnabled;
    }

    public String getPublicKey() {
        return this.mPublicKey;
    }

    @Nullable
    public RequestListener getRequestListener() {
        return this.mRequestListener;
    }

    @Nullable
    public ResizeOptions getResizeOptions() {
        return this.mResizeOptions;
    }

    public RotationOptions getRotationOptions() {
        return this.mRotationOptions;
    }

    public int getSampleSize() {
        return this.mSampleSize;
    }

    public SizeDeterminer getSizeDeterminer() {
        return this.mSizeDeterminer;
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }

    public int getSourceUriType() {
        return this.mSourceUriType;
    }

    public int getTargetHeight() {
        return this.mTargetHeight;
    }

    public int getTargetWidth() {
        return this.mTargetWidth;
    }

    public String getUrlKey() {
        return this.mUrlKey;
    }

    public boolean isAsyncAttach() {
        return this.isAsyncAttach;
    }

    public boolean isAsyncRequest() {
        return this.isAsyncRequest;
    }

    public boolean isAutoDownsampleDisabled() {
        return this.mDisableAutoDownsample;
    }

    public boolean isDiskCacheEnabled() {
        return this.mIsDiskCacheEnabled;
    }

    public boolean isEnableNetworkPriority() {
        return this.mEnableNetworkPriority;
    }

    public boolean isFallBackToMainMemory() {
        return this.isFallBackToMainMemory;
    }

    public boolean isLoadThumbnailOnly() {
        return this.mLoadThumbnailOnly;
    }

    public boolean isMemoryCacheEnabled() {
        return this.mIsMemoryCacheEnabled;
    }

    public boolean isMultiplexerEnabled() {
        return this.mMultiplexerEnabled;
    }

    public boolean isNeedReplaceUri() {
        return this.mNeedReplaceUri;
    }

    public boolean isOptOnNewResultMsg() {
        return this.mOptOnNewResultMsg;
    }

    public boolean isOptPrefetch() {
        return this.mIsOptPrefetch;
    }

    public boolean isPrefetch() {
        return this.mIsPrefetch;
    }

    public boolean isResizedImageDiskCacheEnabled() {
        return this.mIsResizedImageDiskCacheEnabled;
    }

    public boolean isThumbDataInFetch() {
        return this.mThumbDataInFetch;
    }

    public boolean isUseSingleHeaderBlurhash() {
        return this.useSingleHeaderBlurhash;
    }

    public ImageRequest(ImageRequestBuilder r100) {
        this.useSingleHeaderBlurhash = false;
        this.mOptOnNewResultMsg = false;
        this.isAsyncRequest = true;
        this.isAsyncAttach = true;
        this.mCacheChoice = r100.getCacheChoice();
        Uri r101 = r100.getSourceUri();
        this.mSourceUri = r101;
        this.mBackupUris = r100.getBackupUris();
        this.mSourceUriType = getSourceUriType(r101, r100.getMimeType());
        this.mCacheKeyUri = r100.getCacheKeyUri();
        this.mProgressiveRenderingEnabled = r100.isProgressiveRenderingEnabled();
        this.mProgressiveRenderingAnimatedEnabled = r100.isProgressiveRenderingAnimatedEnabled();
        this.mProgressiveRenderingHeicEnabled = r100.isProgressiveRenderingHeicEnabled();
        this.mLocalThumbnailPreviewsEnabled = r100.isLocalThumbnailPreviewsEnabled();
        this.mLoadThumbnailOnly = r100.getLoadThumbnailOnly();
        this.mImageDecodeOptions = r100.getImageDecodeOptions();
        this.mResizeOptions = r100.getResizeOptions();
        this.mBlurHashOptions = r100.getBlurHashOptions();
        if (r100.getRotationOptions() != null) goto L5;
        RotationOptions r102 = RotationOptions.autoRotate();
    L6:
        this.mRotationOptions = r102;
        this.mBytesRange = r100.getBytesRange();
        this.mRequestPriority = r100.getRequestPriority();
        this.mLowestPermittedRequestLevel = r100.getLowestPermittedRequestLevel();
        this.mIsDiskCacheEnabled = r100.isDiskCacheEnabled();
        this.mIsResizedImageDiskCacheEnabled = r100.isResizedImageDiskCacheEnabled();
        this.mIsMemoryCacheEnabled = r100.isMemoryCacheEnabled();
        this.mPostprocessor = r100.getPostprocessor();
        this.mRequestListener = r100.getRequestListener();
        this.mCustomCacheName = r100.getCustomCacheName();
        this.mMultiplexerEnabled = r100.isMultiplexerEnabled();
        this.mNeedReplaceUri = r100.isNeedReplaceUri();
        this.mHttpHeader = r100.getHttpHeader();
        this.mAwebpScanNumber = r100.getAwebpScanNumber();
        this.mCustomParam = r100.getCustomParam();
        this.mPublicKey = r100.getPublicKey();
        this.mUrlKey = r100.getUrlKey();
        this.mIsOptPrefetch = r100.isOptPrefetch();
        this.mSampleSize = r100.getSampleSize();
        this.mDisableAutoDownsample = r100.isAutoDownsampleDisabled();
        this.mTargetWidth = r100.getTargetWidth();
        this.mTargetHeight = r100.getTargetHeight();
        this.mIsPrefetch = r100.getPrefetchMark();
        this.useSingleHeaderBlurhash = r100.isUseSingleHeaderBlurhash();
        this.isFallBackToMainMemory = r100.isFallBackToMainMemory();
        this.mCalculateColorConfig = r100.getCalculateColorConfig();
        this.mEnableNetworkPriority = r100.isEnableNetworkPriority();
        this.mOptOnNewResultMsg = r100.isOptOnNewResultMsg();
        return;
    L5:
        r102 = r100.getRotationOptions();
        goto L6
    }

    public static ImageRequest fromFile(@Nullable File r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return fromUri(UriUtil.getUriForFile(r100));
    }

    public static ImageRequest fromUri(@Nullable String r100) {
        if (r100 != null) goto L4;
    L7:
        return null;
    L4:
        if (r100.length() == 0) goto L7;
        return fromUri(Uri.parse(r100));
    }

    private static int getSourceUriType(Uri r100) {
        return getSourceUriType(r100, "");
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ImageRequest) == true) goto L5;
        return false;
    L5:
        ImageRequest r101 = (ImageRequest) r100;
        if (Objects.equal(this.mSourceUri, r101.mSourceUri) == true) goto L8;
    L31:
        return false;
    L8:
        if (Objects.equal(this.mCacheChoice, r101.mCacheChoice) == false) goto L31;
        if (Objects.equal(this.mSourceFile, r101.mSourceFile) == false) goto L31;
        if (Objects.equal(this.mBytesRange, r101.mBytesRange) == false) goto L31;
        if (Objects.equal(this.mImageDecodeOptions, r101.mImageDecodeOptions) == false) goto L31;
        if (Objects.equal(this.mResizeOptions, r101.mResizeOptions) == false) goto L31;
        if (Objects.equal(this.mRotationOptions, r101.mRotationOptions) == false) goto L31;
        if (this.mLoadThumbnailOnly != r101.mLoadThumbnailOnly) goto L31;
        Postprocessor r102 = this.mPostprocessor;
        CacheKey r103 = null;
        if (r102 == null) goto L25;
        CacheKey r104 = r102.getPostprocessorCacheKey();
    L26:
        Postprocessor r105 = r101.mPostprocessor;
        if (r105 == null) goto L30;
        r103 = r105.getPostprocessorCacheKey();
    L30:
        return Objects.equal(r104, r103);
    L25:
        r104 = null;
        goto L26
    }

    public void setAsyncAttach(boolean r100) {
        this.isAsyncAttach = r100;
    }

    public void setAsyncRequest(boolean r100) {
        this.isAsyncRequest = r100;
    }

    public void setAutoDownsampleDisabled(boolean r100) {
        this.mDisableAutoDownsample = r100;
    }

    public void setCacheKeyResizeOptions(ResizeOptions r100) {
        this.mCacheKeyResizeOptions = r100;
    }

    public void setHasDecodedThumb(boolean r100) {
        this.mHasDecodedThumb = r100;
    }

    public void setHttpHeader(Map<String, String> r100) {
        this.mHttpHeader = r100;
    }

    public void setMultiplexerEnabled(boolean r100) {
        this.mMultiplexerEnabled = r100;
    }

    public void setPrefetchMark(boolean r100) {
        this.mIsPrefetch = r100;
    }

    public void setPreviewAlgo(int r100) {
        this.mPreviewAlgo = r100;
    }

    public void setPreviewDecodeEnd(long r100) {
        this.mPreviewDecodeEnd = r100;
    }

    public void setPreviewDecodeTime(long r100) {
        this.mPreviewDecodeTime = r100;
    }

    public void setPreviewDuration(int r100) {
        this.mPreviewDuration = r100;
    }

    public void setPreviewError(String r100) {
        this.mPreviewError = r100;
    }

    public void setPreviewUsed(boolean r100) {
        this.mPreviewUsed = r100;
    }

    public void setSizeDeterminer(SizeDeterminer r100) {
        this.mSizeDeterminer = r100;
    }

    public void setThumbDataInFetch(boolean r100) {
        this.mThumbDataInFetch = r100;
    }

    public static ImageRequest fromUri(@Nullable Uri r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return ImageRequestBuilder.newBuilderWithSource(r100).build();
    }

    private static int getSourceUriType(Uri r100, String r101) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (UriUtil.isNetworkUri(r100) == false) goto L10;
        return 0;
    L10:
        if (UriUtil.isLocalFileUri(r100) == false) goto L18;
        if (MediaUtils.isVideo(MediaUtils.extractMime(r100.getPath())) == false) goto L15;
        return 2;
    L15:
        return 3;
    L18:
        if (UriUtil.isLocalContentUri(r100) == false) goto L32;
        if (TextUtils.isEmpty(r101) == false) goto L22;
        return 4;
    L22:
        if (MediaUtils.isVideo(r101) == false) goto L26;
        return 9;
    L26:
        if (MediaUtils.isPhoto(r101) == false) goto L48;
        return 10;
    L48:
        return 4;
    L32:
        if (UriUtil.isLocalAssetUri(r100) == false) goto L36;
        return 5;
    L36:
        if (UriUtil.isLocalResourceUri(r100) == false) goto L40;
        return 6;
    L40:
        if (UriUtil.isDataUri(r100) == false) goto L44;
        return 7;
    L44:
        if (UriUtil.isQualifiedResourceUri(r100) == false) goto L47;
        return 8;
    L47:
        return -1;
    }
}
