package com.facebook.imagepipeline.request;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.utils.ImageCenterStrategy;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.texturerender.TextureRenderKeys;
import el9.a;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class ImageRequestBuilder {
    private static boolean enableGlobalSecurityTag;
    private static IHeaderInterceptor mHeaderInterceptor;
    private static IRequestBackUrlReplace mRequestBackUrlReplace;
    private static IRequestUrlReplace mRequestUrlReplace;
    private boolean enableSecurityTag;
    private boolean isFallBackToMainMemory;
    private int mAwebpScanNumber;
    private List<Uri> mBackupUris;

    @Nullable
    private BlurHashConfig mBlurHashOptions;

    @Nullable
    private BytesRange mBytesRange;
    private ImageRequest.CacheChoice mCacheChoice;
    private Uri mCacheKeyUri;
    private CalculateColorConfig mCalculateColorConfig;
    private String mCustomCacheName;
    private Map<String, String> mCustomParam;
    private boolean mDisableAutoDownsample;
    private boolean mDiskCacheEnabled;
    private boolean mEnableNetworkPriority;
    private Map<String, String> mHttpHeader;
    private ImageDecodeOptions mImageDecodeOptions;
    private boolean mIsOptPrefetch;
    private boolean mIsPrefetch;
    private boolean mLoadThumbnailOnly;
    private boolean mLocalThumbnailPreviewsEnabled;
    private ImageRequest.RequestLevel mLowestPermittedRequestLevel;
    private boolean mMemoryCacheEnabled;

    @Nullable
    private String mMimeType;
    private boolean mMultiplexerEnabled;
    private boolean mNeedReplaceUri;
    private boolean mOptOnNewResultMsg;

    @Nullable
    private Postprocessor mPostprocessor;
    private boolean mProgressiveRenderingAnimatedEnabled;
    private boolean mProgressiveRenderingEnabled;
    private boolean mProgressiveRenderingHeicEnabled;
    private String mPublicKey;

    @Nullable
    private RequestListener mRequestListener;
    private Priority mRequestPriority;

    @Nullable
    private ResizeOptions mResizeOptions;
    private boolean mResizedImageDiskCacheEnabled;

    @Nullable
    private RotationOptions mRotationOptions;
    private int mSampleSize;
    private Uri mSourceUri;
    private int mTargetHeight;
    private int mTargetWidth;
    private String mUrlKey;
    private Map<String, String> mWaitParseParamFromUrl;
    private boolean useSingleHeaderBlurhash;

    public static class BuilderException extends RuntimeException {
        public BuilderException(String r100) {
            super("Invalid request builder: " + r100);
        }
    }

    public interface IHeaderInterceptor {
        Map<String, String> interceptHeader(Uri r100, Map<String, String> r101);
    }

    public interface IRequestBackUrlReplace {
        List<Uri> replaceRequestBackUrl(List<Uri> r100);
    }

    public interface IRequestUrlReplace {
        Uri replaceRequestUrl(Uri r100);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public ImageRequestBuilder disableDiskCache() {
        this.mDiskCacheEnabled = false;
        return this;
    }

    public ImageRequestBuilder disableMemoryCache() {
        this.mMemoryCacheEnabled = false;
        return this;
    }

    public Map<String, String> getHttpHeader() {
        if (enableGlobalSecurityTag == true) goto L7;
        if (this.enableSecurityTag == true) goto L7;
    L9:
        IHeaderInterceptor r100 = mHeaderInterceptor;
        if (r100 == null) goto L13;
        this.mHttpHeader = r100.interceptHeader(this.mSourceUri, this.mHttpHeader);
    L13:
        return this.mHttpHeader;
    L7:
        if (this.mHttpHeader != null) goto L9;
        HashMap r101 = new HashMap();
        this.mHttpHeader = r101;
        r101.put("x-security-argus", "StaticResource/img/BDFresco");
        goto L9
    }

    public boolean isDiskCacheEnabled() {
        if (this.mDiskCacheEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (UriUtil.isNetworkUri(this.mSourceUri) == false) goto L7;
        return true;
    }

    public void validate() {
        Uri r100 = this.mSourceUri;
        if (r100 == null) goto L34;
        if (UriUtil.isLocalResourceUri(r100) == false) goto L19;
        if (this.mSourceUri.isAbsolute() == false) goto L17;
        if (this.mSourceUri.getPath().isEmpty() == true) goto L15;
        Integer.parseInt(this.mSourceUri.getPath().substring(1));     // Catch: NumberFormatException -> L12
    L13:
        throw new BuilderException("Resource URI path must be a resource id.");
    L15:
        throw new BuilderException("Resource URI must not be empty");
    L17:
        throw new BuilderException("Resource URI path must be absolute.");
    L19:
        if (this.mCustomCacheName != null) goto L26;
        if (this.mCacheChoice.equals(ImageRequest.CacheChoice.CUSTOM) == false) goto L26;
        throw new BuilderException("CustomCacheName must be set as you have choice your cacheChoice as 'CUSTOM'");
    L26:
        if (UriUtil.isLocalAssetUri(this.mSourceUri) == true) goto L28;
        return;
    L28:
        if (this.mSourceUri.isAbsolute() == false) goto L31;
        return;
    L31:
        throw new BuilderException("Asset URI path must be absolute.");
    L34:
        throw new BuilderException("Source must be set!");
    }

    private ImageRequestBuilder() {
        this.mSourceUri = null;
        this.mCacheKeyUri = null;
        this.mBackupUris = null;
        this.mLowestPermittedRequestLevel = ImageRequest.RequestLevel.FULL_FETCH;
        this.mResizeOptions = null;
        this.mBlurHashOptions = null;
        this.mRotationOptions = null;
        this.mImageDecodeOptions = ImageDecodeOptions.defaults();
        this.mCacheChoice = ImageRequest.CacheChoice.DEFAULT;
        this.mProgressiveRenderingEnabled = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingEnabled();
        this.mProgressiveRenderingAnimatedEnabled = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingAnimatedEnabled();
        this.mProgressiveRenderingHeicEnabled = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingHeicEnabled();
        this.mLocalThumbnailPreviewsEnabled = false;
        this.mLoadThumbnailOnly = false;
        this.mRequestPriority = Priority.MEDIUM;
        this.mPostprocessor = null;
        this.mDiskCacheEnabled = true;
        this.mResizedImageDiskCacheEnabled = false;
        this.mMemoryCacheEnabled = true;
        this.mBytesRange = null;
        this.mCustomCacheName = null;
        this.mAwebpScanNumber = 1;
        this.enableSecurityTag = false;
        this.mIsPrefetch = false;
        this.useSingleHeaderBlurhash = false;
        this.isFallBackToMainMemory = false;
        this.mMultiplexerEnabled = true;
        this.mNeedReplaceUri = false;
        this.mIsOptPrefetch = false;
        this.mSampleSize = -1;
        this.mDisableAutoDownsample = false;
        this.mTargetWidth = -1;
        this.mTargetHeight = -1;
        this.mOptOnNewResultMsg = false;
    }

    public ImageRequest build() {
        validate();
        Map<String, String> r100 = getWaitParseParamFromUrl();
        Map<String, String> r101 = FrescoCacheMonitorUtil.getWaitParseParamFromUrl();
        if (r101 != null) goto L5;
    L8:
        if (r100 == null) goto L14;
        if (this.mCustomParam != null) goto L12;
        this.mCustomParam = new HashMap();
    L12:
        updateCustomParam(this.mSourceUri, this.mCustomParam, r100);
    L14:
        if (ImageRequestDiskCacheStrategy.getStrategy() == null) goto L36;
        ImageRequestDiskCacheStrategy r102 = ImageRequestDiskCacheStrategy.getStrategy();
        if (r102 == null) goto L36;
        ImageRequest.CacheChoice r103 = getCacheChoice();
        ImageRequest.CacheChoice r104 = ImageRequest.CacheChoice.SMALL;
        if (r103 != r104) goto L21;
        int r105 = 2;
    L24:
        Pair<Integer, String> r106 = r102.getCustomDiskCache(getSourceUri(), r105, getCustomCacheName());
        if (r106 == null) goto L36;
        if (((Integer) r106.first).intValue() != 1) goto L30;
        setCacheChoice(ImageRequest.CacheChoice.DEFAULT);
        goto L36
    L30:
        if (((Integer) r106.first).intValue() != 2) goto L33;
        setCacheChoice(r104);
        goto L36
    L33:
        if (((Integer) r106.first).intValue() != 3) goto L36;
        setCacheChoice(ImageRequest.CacheChoice.CUSTOM);
        setCustomCacheName((String) r106.second);
        goto L36
    L21:
        if (getCacheChoice() != ImageRequest.CacheChoice.CUSTOM) goto L23;
        r105 = 3;
        goto L24
    L23:
        r105 = 1;
    L36:
        if (ImageCenterStrategy.getStrategy() == null) goto L64;
        if (getSourceUri() == null) goto L64;
        Map<String, Object> r107 = ImageCenterStrategy.getStrategy().getImageStrategyResult(getSourceUri().toString(), null);
        if (r107 == null) goto L64;
        if (r107.isEmpty() == true) goto L64;
        if (r107.containsKey("super_resolution") == false) goto L54;
        Object r108 = r107.get("super_resolution");
        if (r108 == null) goto L64;
        JSONObject r109 = new JSONObject(r108.toString());     // Catch: JSONException -> L51
        if (r109.optBoolean("enable") == false) goto L64;
        this.mPostprocessor = (Postprocessor) getPostProcesorByStrategy(2, "com.bytedance.fresco.sr.SRPostProcessor", r109);     // Catch: JSONException -> L51
    L51:
        e = move-exception;
        e.printStackTrace();
        goto L64
    L54:
        if (r107.containsKey(ImageCenterStrategy.IMAGE_RESULT_KEY_SHARPEN) == false) goto L64;
        Object r110 = r107.get(ImageCenterStrategy.IMAGE_RESULT_KEY_SHARPEN);
        if (r110 == null) goto L64;
        JSONObject r111 = new JSONObject(r110.toString());     // Catch: JSONException -> L61
        if (r111.optBoolean("enable") == false) goto L64;
        this.mPostprocessor = (Postprocessor) getPostProcesorByStrategy(4, "com.bytedance.fresco.sharp.SharpPostProcessor", r111);     // Catch: JSONException -> L61
    L61:
        e = move-exception;
        e.printStackTrace();
    L64:
        return new ImageRequest(this);
    L5:
        if (this.mCustomParam != null) goto L7;
        this.mCustomParam = new HashMap();
    L7:
        updateCustomParam(this.mSourceUri, this.mCustomParam, r101);
        goto L8
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

    public ImageRequest.CacheChoice getCacheChoice() {
        return this.mCacheChoice;
    }

    public Uri getCacheKeyUri() {
        return this.mCacheKeyUri;
    }

    public CalculateColorConfig getCalculateColorConfig() {
        return this.mCalculateColorConfig;
    }

    @Nullable
    public String getCustomCacheName() {
        return this.mCustomCacheName;
    }

    public Map<String, String> getCustomParam() {
        return this.mCustomParam;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        return this.mImageDecodeOptions;
    }

    public boolean getLoadThumbnailOnly() {
        return this.mLoadThumbnailOnly;
    }

    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    @Nullable
    public String getMimeType() {
        return this.mMimeType;
    }

    @Nullable
    public Postprocessor getPostprocessor() {
        return this.mPostprocessor;
    }

    public boolean getPrefetchMark() {
        return this.mIsPrefetch;
    }

    public String getPublicKey() {
        return this.mPublicKey;
    }

    @Nullable
    public RequestListener getRequestListener() {
        return this.mRequestListener;
    }

    public Priority getRequestPriority() {
        return this.mRequestPriority;
    }

    @Nullable
    public ResizeOptions getResizeOptions() {
        return this.mResizeOptions;
    }

    @Nullable
    public RotationOptions getRotationOptions() {
        return this.mRotationOptions;
    }

    public int getSampleSize() {
        return this.mSampleSize;
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
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

    public Map<String, String> getWaitParseParamFromUrl() {
        return this.mWaitParseParamFromUrl;
    }

    public boolean isAutoDownsampleDisabled() {
        return this.mDisableAutoDownsample;
    }

    public boolean isEnableNetworkPriority() {
        return this.mEnableNetworkPriority;
    }

    public boolean isFallBackToMainMemory() {
        return this.isFallBackToMainMemory;
    }

    public boolean isLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public boolean isMemoryCacheEnabled() {
        return this.mMemoryCacheEnabled;
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

    public boolean isProgressiveRenderingAnimatedEnabled() {
        return this.mProgressiveRenderingAnimatedEnabled;
    }

    public boolean isProgressiveRenderingEnabled() {
        return this.mProgressiveRenderingEnabled;
    }

    public boolean isProgressiveRenderingHeicEnabled() {
        return this.mProgressiveRenderingHeicEnabled;
    }

    public boolean isResizedImageDiskCacheEnabled() {
        return this.mResizedImageDiskCacheEnabled;
    }

    public boolean isUseSingleHeaderBlurhash() {
        return this.useSingleHeaderBlurhash;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_facebook_imagepipeline_request_ImageRequestBuilder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static ImageRequestBuilder fromRequest(ImageRequest r100) {
        if (ImagePipelineConfig.useSingleImageRequest == true) goto L8;
        ImageRequestBuilder r101 = newBuilderWithSource(r100.getSourceUri()).setImageDecodeOptions(r100.getImageDecodeOptions()).setBytesRange(r100.getBytesRange()).setCacheChoice(r100.getCacheChoice()).setLocalThumbnailPreviewsEnabled(r100.getLocalThumbnailPreviewsEnabled()).setLoadThumbnailOnly(r100.getLoadThumbnailOnlyForAndroidSdkAboveQ()).setLowestPermittedRequestLevel(r100.getLowestPermittedRequestLevel()).setPostprocessor(r100.getPostprocessor()).setProgressiveRenderingEnabled(r100.getProgressiveRenderingEnabled()).setRequestPriority(r100.getPriority()).setResizeOptions(r100.getResizeOptions()).setRequestListener(r100.getRequestListener()).setRotationOptions(r100.getRotationOptions());
        if (r100.getCustomCacheName() == null) goto L7;
        r101.setCustomCacheName(r100.getCustomCacheName());
    L7:
        return r101;
    L8:
        ImageRequestBuilder r102 = newBuilderWithSource(r100.getSourceUri()).setImageDecodeOptions(r100.getImageDecodeOptions()).setBytesRange(r100.getBytesRange()).setCacheChoice(r100.getCacheChoice()).setLocalThumbnailPreviewsEnabled(r100.getLocalThumbnailPreviewsEnabled()).setLoadThumbnailOnly(r100.getLoadThumbnailOnlyForAndroidSdkAboveQ()).setLowestPermittedRequestLevel(r100.getLowestPermittedRequestLevel()).setPostprocessor(r100.getPostprocessor()).setProgressiveRenderingEnabled(r100.getProgressiveRenderingEnabled()).setRequestPriority(r100.getPriority()).setResizeOptions(r100.getResizeOptions()).setRequestListener(r100.getRequestListener()).setRotationOptions(r100.getRotationOptions()).setAwebpScanNumber(r100.getAwebpScanNumber()).setProgressiveRenderingAnimatedEnabled(r100.getProgressiveRenderingAnimatedEnabled()).setProgressiveRenderingHeicEnabled(r100.getProgressiveRenderingHeicEnabled()).setMultiplexerEnabled(r100.isMultiplexerEnabled()).setSampleSize(r100.getSampleSize()).setOptPrefetch(r100.isOptPrefetch()).setOpenHeaderBlurhash(r100.isUseSingleHeaderBlurhash()).setOptOnNewResultMsg(r100.isOptOnNewResultMsg()).setPrefetchMark(r100.isPrefetch()).setTargetWidth(r100.getTargetWidth()).setTargetHeight(r100.getTargetHeight());
        if (r100.getCustomCacheName() == null) goto L12;
        r102.setCustomCacheName(r100.getCustomCacheName());
    L12:
        if (r100.getHttpHeader() == null) goto L14;
        r102.setHttpHeader(r100.getHttpHeader());
    L14:
        return r102;
    }

    private int getScaleType(float r100) {
        if (r100 > 0.0f) goto L6;
        return -1;
    L6:
        if (Math.abs(r100 - 1.1f) > 1.0E-6f) goto L9;
        return 4;
    L9:
        if (Math.abs(r100 - 1.2f) > 1.0E-6f) goto L12;
        return 8;
    L12:
        if (Math.abs(r100 - 1.3f) > 1.0E-6f) goto L15;
        return 16;
    L15:
        if (Math.abs(r100 - 1.4f) > 1.0E-6f) goto L18;
        return 32;
    L18:
        if (Math.abs(r100 - 1.5f) > 1.0E-6f) goto L21;
        return 1;
    L21:
        if (Math.abs(r100 - 2.0f) > 1.0E-6f) goto L29;
        return 2;
    L29:
        return -1;
    }

    public static ImageRequestBuilder newBuilderWithResourceId(int r100) {
        return newBuilderWithSource(UriUtil.getUriForResourceId(r100));
    }

    public static ImageRequestBuilder newBuilderWithSource(Uri r100) {
        return new ImageRequestBuilder().setSource(r100);
    }

    public static void setEnableGlobalSecurityTag(boolean r100) {
        enableGlobalSecurityTag = r100;
    }

    public static void setHeaderInterceptor(IHeaderInterceptor r100) {
        mHeaderInterceptor = r100;
    }

    public static void setRequestBackUrlReplace(IRequestBackUrlReplace r100) {
        mRequestBackUrlReplace = r100;
    }

    public static void setRequestUrlReplace(IRequestUrlReplace r100) {
        mRequestUrlReplace = r100;
    }

    public ImageRequestBuilder enableResizedImageDiskCache(boolean r100) {
        this.mResizedImageDiskCacheEnabled = r100;
        return this;
    }

    public ImageRequestBuilder setAutoRotateEnabled(boolean r100) {
        if (r100 == false) goto L6;
        return setRotationOptions(RotationOptions.autoRotate());
    L6:
        return setRotationOptions(RotationOptions.disableRotation());
    }

    public ImageRequestBuilder setAwebpScanNumber(int r100) {
        this.mAwebpScanNumber = r100;
        return this;
    }

    public ImageRequestBuilder setBackup(List<Uri> r100) {
        IRequestBackUrlReplace r101 = mRequestBackUrlReplace;
        if (r101 == null) goto L5;
        r100 = r101.replaceRequestBackUrl(r100);
    L5:
        this.mBackupUris = r100;
        return this;
    }

    public ImageRequestBuilder setBlurHashOptions(@Nullable BlurHashConfig r100) {
        this.mBlurHashOptions = r100;
        return this;
    }

    public ImageRequestBuilder setBytesRange(@Nullable BytesRange r100) {
        this.mBytesRange = r100;
        return this;
    }

    public ImageRequestBuilder setCacheChoice(ImageRequest.CacheChoice r100) {
        this.mCacheChoice = r100;
        return this;
    }

    public ImageRequestBuilder setCacheKeyUri(Uri r100) {
        this.mCacheKeyUri = r100;
        return this;
    }

    public ImageRequestBuilder setCalculateColorConfig(CalculateColorConfig r100) {
        this.mCalculateColorConfig = r100;
        return this;
    }

    public ImageRequestBuilder setCustomCacheName(String r100) {
        Preconditions.checkNotNull(r100);
        this.mCustomCacheName = r100;
        return this;
    }

    public ImageRequestBuilder setCustomParam(Map<String, String> r100) {
        this.mCustomParam = r100;
        return this;
    }

    public ImageRequestBuilder setDisableAutoDownsample(boolean r100) {
        this.mDisableAutoDownsample = r100;
        return this;
    }

    public ImageRequestBuilder setEnableNetworkPriority(boolean r100) {
        this.mEnableNetworkPriority = r100;
        return this;
    }

    public ImageRequestBuilder setEnableSecurityTag(boolean r100) {
        this.enableSecurityTag = r100;
        return this;
    }

    public ImageRequestBuilder setFallBackToMainMemory(boolean r100) {
        this.isFallBackToMainMemory = r100;
        return this;
    }

    public ImageRequestBuilder setHttpHeader(Map<String, String> r100) {
        Map<String, String> r101 = this.mHttpHeader;
        if (r101 != null) goto L5;
        this.mHttpHeader = new HashMap();
    L6:
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
        boolean r103 = false;
    L8:
        if (r102.hasNext() == false) goto L26;
        Map.Entry<String, String> r104 = r102.next();
        if (enableGlobalSecurityTag == true) goto L14;
        if (this.enableSecurityTag == true) goto L14;
    L24:
        this.mHttpHeader.put(r104.getKey(), r104.getValue());
    L14:
        if (TextUtils.isEmpty(r104.getKey()) == true) goto L24;
        if (r104.getKey().contains("x-security-argus") == false) goto L24;
        if (r104.getValue() != null) goto L20;
    L22:
        this.mHttpHeader.put(r104.getKey(), r104.getValue());
    L23:
        r103 = true;
        goto L8
    L20:
        if (r104.getValue().contains("StaticResource/") == true) goto L22;
        this.mHttpHeader.put(r104.getKey(), r104.getValue() + " StaticResource/img/BDFresco");
        goto L23
    L26:
        if (enableGlobalSecurityTag == false) goto L28;
    L29:
        if (r103 == true) goto L31;
        this.mHttpHeader.put("x-security-argus", "StaticResource/img/BDFresco");
    L31:
        return this;
    L28:
        if (this.enableSecurityTag == false) goto L31;
    L5:
        r101.clear();
        goto L6
    }

    public ImageRequestBuilder setImageDecodeOptions(ImageDecodeOptions r100) {
        this.mImageDecodeOptions = r100;
        return this;
    }

    public ImageRequestBuilder setLoadThumbnailOnly(boolean r100) {
        this.mLoadThumbnailOnly = r100;
        return this;
    }

    public ImageRequestBuilder setLocalThumbnailPreviewsEnabled(boolean r100) {
        this.mLocalThumbnailPreviewsEnabled = r100;
        return this;
    }

    public ImageRequestBuilder setLowestPermittedRequestLevel(ImageRequest.RequestLevel r100) {
        this.mLowestPermittedRequestLevel = r100;
        return this;
    }

    public ImageRequestBuilder setMimeType(@Nullable String r100) {
        this.mMimeType = r100;
        return this;
    }

    public ImageRequestBuilder setMultiplexerEnabled(boolean r100) {
        this.mMultiplexerEnabled = r100;
        return this;
    }

    public ImageRequestBuilder setNeedReplaceUri(boolean r100) {
        this.mNeedReplaceUri = r100;
        return this;
    }

    public ImageRequestBuilder setOpenHeaderBlurhash(boolean r100) {
        this.useSingleHeaderBlurhash = r100;
        return this;
    }

    public ImageRequestBuilder setOptOnNewResultMsg(boolean r100) {
        this.mOptOnNewResultMsg = r100;
        return this;
    }

    public ImageRequestBuilder setOptPrefetch(boolean r100) {
        this.mIsOptPrefetch = r100;
        return this;
    }

    public ImageRequestBuilder setPostprocessor(Postprocessor r100) {
        this.mPostprocessor = r100;
        return this;
    }

    public ImageRequestBuilder setPrefetchMark(boolean r100) {
        this.mIsPrefetch = r100;
        return this;
    }

    public ImageRequestBuilder setProgressiveRenderingAnimatedEnabled(boolean r100) {
        this.mProgressiveRenderingAnimatedEnabled = r100;
        return this;
    }

    public ImageRequestBuilder setProgressiveRenderingEnabled(boolean r100) {
        this.mProgressiveRenderingEnabled = r100;
        return this;
    }

    public ImageRequestBuilder setProgressiveRenderingHeicEnabled(boolean r100) {
        this.mProgressiveRenderingHeicEnabled = r100;
        return this;
    }

    public ImageRequestBuilder setPublicKey(String r100) {
        this.mPublicKey = r100;
        return this;
    }

    public ImageRequestBuilder setRequestListener(RequestListener r100) {
        this.mRequestListener = r100;
        return this;
    }

    public ImageRequestBuilder setRequestPriority(Priority r100) {
        this.mRequestPriority = r100;
        return this;
    }

    public ImageRequestBuilder setResizeOptions(@Nullable ResizeOptions r100) {
        this.mResizeOptions = r100;
        return this;
    }

    public ImageRequestBuilder setRotationOptions(@Nullable RotationOptions r100) {
        this.mRotationOptions = r100;
        return this;
    }

    public ImageRequestBuilder setSampleSize(int r100) {
        this.mSampleSize = r100;
        return this;
    }

    public ImageRequestBuilder setSource(Uri r100) {
        Preconditions.checkNotNull(r100);
        IRequestUrlReplace r101 = mRequestUrlReplace;
        if (r101 == null) goto L5;
        r100 = r101.replaceRequestUrl(r100);
    L5:
        this.mSourceUri = r100;
        return this;
    }

    public ImageRequestBuilder setTargetHeight(int r100) {
        this.mTargetHeight = r100;
        return this;
    }

    public ImageRequestBuilder setTargetWidth(int r100) {
        this.mTargetWidth = r100;
        return this;
    }

    public ImageRequestBuilder setUrlKey(String r100) {
        this.mUrlKey = r100;
        return this;
    }

    public ImageRequestBuilder setWaitParseParamFromUrl(Map<String, String> r100) {
        this.mWaitParseParamFromUrl = r100;
        return this;
    }

    private void updateCustomParam(Uri r100, Map<String, String> r101, Map<String, String> r102) {
        if (r100 != null) goto L13;
        return;
    L13:
        Iterator<String> r103 = r102.keySet().iterator();     // Catch: Exception -> L11
    L6:
        if (r103.hasNext() == false) goto L20;
        String r104 = r103.next();     // Catch: Exception -> L11
        String r105 = r102.get(r104);     // Catch: Exception -> L11
        String r106 = r100.getQueryParameter(r104);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r106) == true) goto L6;
        r101.put(r105, r106);     // Catch: Exception -> L11
        goto L6
    L20:
        return;
    L11:
        FLog.e("ImageRequestBuilder", "updateCustomParam failed");
    }

    public Object getPostProcesorByStrategy(int r110, String r111, JSONObject r112) {
        if (TextUtils.isEmpty(r111) == false) goto L26;
        return null;
    L26:
        Class r100 = INVOKESTATIC_com_facebook_imagepipeline_request_ImageRequestBuilder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r111);     // Catch: Exception -> L22
        if (r110 == 2) goto L16;
        if (r110 == 4) goto L10;
        return null;
    L10:
        int r101 = r112.optInt(ThumbGlideUrl.SOURCE_TEMPLATE);     // Catch: Exception -> L22
        if (r101 != 10) goto L14;
        Class<?> r113 = Float.TYPE;     // Catch: Exception -> L22
        Constructor r102 = r100.getDeclaredConstructor(new Class[]{Integer.TYPE, r113, r113, r113, Boolean.TYPE, r113, r113});     // Catch: Exception -> L22
        r102.setAccessible(true);     // Catch: Exception -> L22
        return r102.newInstance(new Object[]{Integer.valueOf(r112.optInt("algorithm_type")), Float.valueOf((float) r112.optDouble("wt")), Float.valueOf((float) r112.optDouble("thr")), Float.valueOf((float) r112.optDouble("ovrt")), Boolean.valueOf(r112.optBoolean(TextureRenderKeys.KEY_IS_BMF_SHARPEN_ENABLE_ADAPTIVE)), Float.valueOf((float) r112.optDouble("g0")), Float.valueOf((float) r112.optDouble("lc_wt_thr"))});
    L14:
        Constructor r103 = r100.getDeclaredConstructor(new Class[]{Integer.TYPE});     // Catch: Exception -> L22
        r103.setAccessible(true);     // Catch: Exception -> L22
        return r103.newInstance(new Object[]{Integer.valueOf(r101)});
    L16:
        Class<?> r104 = Integer.TYPE;     // Catch: Exception -> L22
        Constructor r105 = r100.getDeclaredConstructor(new Class[]{r104, r104, r104, r104, Boolean.TYPE});     // Catch: Exception -> L22
        r105.setAccessible(true);     // Catch: Exception -> L22
        int r106 = r112.optInt("algorithm_type");     // Catch: Exception -> L22
        return r105.newInstance(new Object[]{Integer.valueOf(r106), Integer.valueOf(getScaleType((float) r112.optDouble("scale_type"))), Integer.valueOf(r112.optInt(TextureRenderKeys.KEY_IS_MAX_WIDTH)), Integer.valueOf(r112.optInt(TextureRenderKeys.KEY_IS_MAX_HEIGHT)), Boolean.valueOf(r112.getBoolean("enable_all_sr"))});
    L20:
        e = e;
    L24:
        e.printStackTrace();
        return null;
    L22:
        e = e;
        goto L24
    }
}
