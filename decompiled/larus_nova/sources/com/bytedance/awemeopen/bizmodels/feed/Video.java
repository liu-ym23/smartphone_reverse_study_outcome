package com.bytedance.awemeopen.bizmodels.feed;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.awemeopen.bizmodels.repo.Boolean2IntAdapter;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r14.j0;
import r14.l;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u001b\u0018\u0000 Ã\u00012\u00020\u0001:\u0002Ä\u0001B\t¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000f\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\tJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\tJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u001c\u001a\u00020\tJ\b\u0010\u001d\u001a\u00020\u000bH\u0016J\u0006\u0010\u001f\u001a\u00020\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u001e\u0010#\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010A\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010'\u001a\u0004\bB\u0010)\"\u0004\bC\u0010+R$\u0010D\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010'\u001a\u0004\bE\u0010)\"\u0004\bF\u0010+R$\u0010G\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010'\u001a\u0004\bH\u0010)\"\u0004\bI\u0010+R$\u0010J\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010'\u001a\u0004\bK\u0010)\"\u0004\bL\u0010+R\u0018\u0010M\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bM\u0010'R$\u0010N\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010'\u001a\u0004\bO\u0010)\"\u0004\bP\u0010+R\"\u0010Q\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010W\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010R\u001a\u0004\bX\u0010T\"\u0004\bY\u0010VR$\u0010Z\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010-\u001a\u0004\b[\u0010/\"\u0004\b\\\u00101R$\u0010]\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010'\u001a\u0004\b^\u0010)\"\u0004\b_\u0010+R\"\u0010`\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\b`\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010R\u001a\u0004\bf\u0010T\"\u0004\bg\u0010VR*\u0010i\u001a\n\u0012\u0004\u0012\u00020h\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bi\u00105\u001a\u0004\bj\u00107\"\u0004\bk\u00109R$\u0010l\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bl\u0010'\u001a\u0004\bm\u0010)\"\u0004\bn\u0010+R$\u0010o\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bo\u0010'\u001a\u0004\bp\u0010)\"\u0004\bq\u0010+R$\u0010r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\br\u0010'\u001a\u0004\bs\u0010)\"\u0004\bt\u0010+R\"\u0010u\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bu\u0010a\u001a\u0004\bv\u0010b\"\u0004\bw\u0010dR$\u0010x\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bx\u0010'\u001a\u0004\by\u0010)\"\u0004\bz\u0010+R\"\u0010{\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b{\u0010a\u001a\u0004\b{\u0010b\"\u0004\b|\u0010dR(\u0010~\u001a\u0004\u0018\u00010}8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R.\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020}\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u00105\u001a\u0005\b\u0085\u0001\u00107\"\u0005\b\u0086\u0001\u00109R(\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010-\u001a\u0005\b\u0088\u0001\u0010/\"\u0005\b\u0089\u0001\u00101R$\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u001c\u0010a\u001a\u0005\b\u008a\u0001\u0010b\"\u0005\b\u008b\u0001\u0010dR&\u0010\u008c\u0001\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010R\u001a\u0005\b\u008d\u0001\u0010T\"\u0005\b\u008e\u0001\u0010VR(\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010'\u001a\u0005\b\u0090\u0001\u0010)\"\u0005\b\u0091\u0001\u0010+R*\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R&\u0010\u0099\u0001\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010a\u001a\u0005\b\u0099\u0001\u0010b\"\u0005\b\u009a\u0001\u0010dR&\u0010\u009b\u0001\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010a\u001a\u0005\b\u009b\u0001\u0010b\"\u0005\b\u009c\u0001\u0010dR(\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009d\u0001\u0010-\u001a\u0005\b\u009e\u0001\u0010/\"\u0005\b\u009f\u0001\u00101R&\u0010 \u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b \u0001\u0010a\u001a\u0005\b \u0001\u0010b\"\u0005\b¡\u0001\u0010dR\u001a\u0010£\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R(\u0010¥\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¥\u0001\u0010'\u001a\u0005\b¦\u0001\u0010)\"\u0005\b§\u0001\u0010+R&\u0010¨\u0001\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¨\u0001\u0010R\u001a\u0005\b¨\u0001\u0010T\"\u0005\b©\u0001\u0010VR*\u0010«\u0001\u001a\u00030ª\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R+\u0010±\u0001\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b±\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R(\u0010¶\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¶\u0001\u0010'\u001a\u0005\b·\u0001\u0010)\"\u0005\b¸\u0001\u0010+R+\u0010¹\u0001\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¹\u0001\u0010²\u0001\u001a\u0006\b¹\u0001\u0010³\u0001\"\u0006\bº\u0001\u0010µ\u0001R\u001a\u0010»\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b»\u0001\u0010'R(\u0010¼\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¼\u0001\u0010'\u001a\u0005\b½\u0001\u0010)\"\u0005\b¾\u0001\u0010+R+\u0010¿\u0001\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¿\u0001\u0010²\u0001\u001a\u0006\b¿\u0001\u0010³\u0001\"\u0006\bÀ\u0001\u0010µ\u0001¨\u0006Å\u0001"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/Video;", "Ljava/io/Serializable;", "Lr14/j0;", "getProperPlayAddr", "getPlayAddr", "getPlayAddrH264", "getPlayAddrH265", "Lt14/a;", "urlModel", "", "checkVideo", "", "aid", "", "setRationAndSourceId", "setSourceId", "isCoverValid", "isOriginCoverValid", "getOriginCover", "hasEndWaterMark", "", "duration", "setDuration", "isLowBr", "getVideoId", "getVideoIdAuth", "getVideoIdPToken", "getVideoIdApiHost", "enableIntertrustDrm", "toString", "", "getDuration", "playAddr", "Lr14/j0;", "playAddrH265", "h264PlayAddr", "getH264PlayAddr", "()Lr14/j0;", "cover", "Lt14/a;", "getCover", "()Lt14/a;", "setCover", "(Lt14/a;)V", "dVideoModel", "Ljava/lang/String;", "getDVideoModel", "()Ljava/lang/String;", "setDVideoModel", "(Ljava/lang/String;)V", "", "Lcom/google/gson/JsonElement;", "videoThumbs", "Ljava/util/List;", "getVideoThumbs", "()Ljava/util/List;", "setVideoThumbs", "(Ljava/util/List;)V", "Lz14/a;", "drmTokenAuth", "Lz14/a;", "getDrmTokenAuth", "()Lz14/a;", "setDrmTokenAuth", "(Lz14/a;)V", "intelligentCover", "getIntelligentCover", "setIntelligentCover", "dynamicCover", "getDynamicCover", "setDynamicCover", "resetCover", "getResetCover", "setResetCover", "animatedCover", "getAnimatedCover", "setAnimatedCover", "originCover", "optimizedCover", "getOptimizedCover", "setOptimizedCover", "height", "I", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "getRatio", "setRatio", "downloadAddr", "getDownloadAddr", "setDownloadAddr", "isHasWaterMark", "Z", "()Z", "setHasWaterMark", "(Z)V", "videoLength", "getVideoLength", "setVideoLength", "Lr14/l;", "bitRate", "getBitRate", "setBitRate", "newDownloadAddr", "getNewDownloadAddr", "setNewDownloadAddr", "suffixLogoDownloadAddr", "getSuffixLogoDownloadAddr", "setSuffixLogoDownloadAddr", "uIAlikeDownloadAddr", "getUIAlikeDownloadAddr", "setUIAlikeDownloadAddr", "hasSuffixWaterMark", "getHasSuffixWaterMark", "setHasSuffixWaterMark", "captionDownloadAddr", "getCaptionDownloadAddr", "setCaptionDownloadAddr", "isNeedSetCookie", "setNeedSetCookie", "Lcom/bytedance/awemeopen/bizmodels/feed/VideoTag;", "videoTag", "Lcom/bytedance/awemeopen/bizmodels/feed/VideoTag;", "getVideoTag", "()Lcom/bytedance/awemeopen/bizmodels/feed/VideoTag;", "setVideoTag", "(Lcom/bytedance/awemeopen/bizmodels/feed/VideoTag;)V", "videoTags", "getVideoTags", "setVideoTags", "miscDownloadAddrs", "getMiscDownloadAddrs", "setMiscDownloadAddrs", "getEnableIntertrustDrm", "setEnableIntertrustDrm", "pilotLength", "getPilotLength", "setPilotLength", "cachedOuterCoverUrl", "getCachedOuterCoverUrl", "setCachedOuterCoverUrl", "", "cachedOuterCoverSize", "[I", "getCachedOuterCoverSize", "()[I", "setCachedOuterCoverSize", "([I)V", "isCallback", "setCallback", "isUseStaticCover", "setUseStaticCover", "meta", "getMeta", "setMeta", "isForceUseSoftwareDecode", "setForceUseSoftwareDecode", "", "aspectRatio", FaceService.girlLabel, "playAddrLowbr", "getPlayAddrLowbr", "setPlayAddrLowbr", "isH265", "setH265", "", "cdnUrlExpired", "J", "getCdnUrlExpired", "()J", "setCdnUrlExpired", "(J)V", "isLongVideo", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setLongVideo", "(Ljava/lang/Integer;)V", "playAddrBytevc1", "getPlayAddrBytevc1", "setPlayAddrBytevc1", "isBytevc1", "setBytevc1", "blurCover", "aicover", "getAicover", "setAicover", "isSourceHdr", "setSourceHdr", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class Video implements Serializable {
    public static final a Companion = null;

    @SerializedName("AiCover")
    private t14.a aicover;

    @SerializedName("animated_cover")
    private t14.a animatedCover;
    private float aspectRatio;

    @SerializedName("bit_rate")
    private List<l> bitRate;

    @SerializedName("blur_cover")
    public t14.a blurCover;
    private int[] cachedOuterCoverSize;
    private t14.a cachedOuterCoverUrl;

    @SerializedName("caption_download_addr")
    private t14.a captionDownloadAddr;

    @SerializedName("cdn_url_expired")
    private long cdnUrlExpired;

    @SerializedName("cover")
    private t14.a cover;

    @SerializedName("video_model")
    private String dVideoModel;

    @SerializedName("download_addr")
    private t14.a downloadAddr;

    @SerializedName("token_auth")
    private z14.a drmTokenAuth;

    @SerializedName("dynamic_cover")
    private t14.a dynamicCover;

    @SerializedName("is_drm_source")
    private boolean enableIntertrustDrm;

    @SerializedName("play_addr_h264")
    private j0 h264PlayAddr;

    @SerializedName("has_download_suffix_logo_addr")
    private boolean hasSuffixWaterMark;

    @SerializedName("height")
    private int height;

    @SerializedName("intelligent_cover")
    private t14.a intelligentCover;

    @SerializedName("is_bytevc1")
    private Integer isBytevc1;

    @SerializedName("is_callback")
    private boolean isCallback;
    private boolean isForceUseSoftwareDecode;

    @SerializedName("is_h265")
    @JsonAdapter(Boolean2IntAdapter.class)
    private int isH265;

    @SerializedName("has_watermark")
    private boolean isHasWaterMark;

    @SerializedName("is_long_video")
    private Integer isLongVideo;

    @SerializedName("need_set_token")
    private boolean isNeedSetCookie;

    @SerializedName("is_source_HDR")
    private Integer isSourceHdr;

    @SerializedName("use_static_cover")
    private boolean isUseStaticCover;

    @SerializedName("meta")
    private String meta;

    @SerializedName("misc_download_addrs")
    private String miscDownloadAddrs;

    @SerializedName("new_download_addr")
    private t14.a newDownloadAddr;

    @SerializedName("optimized_cover")
    private t14.a optimizedCover;

    @SerializedName("origin_cover")
    private t14.a originCover;

    @SerializedName("real_duration")
    private int pilotLength;

    @SerializedName("play_addr")
    private j0 playAddr;

    @SerializedName("play_addr_bytevc1")
    private t14.a playAddrBytevc1;

    @SerializedName("play_addr_265")
    private j0 playAddrH265;

    @SerializedName("play_addr_lowbr")
    private t14.a playAddrLowbr;

    @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    private String ratio;

    @SerializedName("reset_cover")
    private t14.a resetCover;

    @SerializedName("download_suffix_logo_addr")
    private t14.a suffixLogoDownloadAddr;

    @SerializedName("ui_alike_download_addr")
    private t14.a uIAlikeDownloadAddr;

    @SerializedName("duration")
    private int videoLength;

    @SerializedName("tag")
    private VideoTag videoTag;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private List<VideoTag> videoTags;

    @SerializedName("big_thumbs")
    private List<? extends JsonElement> videoThumbs;

    @SerializedName("width")
    private int width;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isLowBr() {
        return false;
    }

    public final void a() {
        j0 r100 = this.playAddrH265;
        if (r100 != null) goto L5;
    L13:
        j0 r101 = this.playAddr;
        if (r101 != null) goto L16;
        return;
    L16:
        if (r101.i() == null) goto L26;
        r101.j(this.bitRate);
        r101.l(this.videoLength);
        r101.f535643d = false;
        r101.k(this.cdnUrlExpired);
        if (this.aspectRatio > 0.0f) goto L27;
        int r102 = this.width;
        if (r102 == 0) goto L28;
        int r103 = this.height;
        if (r103 == 0) goto L29;
        this.aspectRatio = (r102 * 1.0f) / r103;
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L5:
        if (r100.i() == null) goto L13;
        r100.j(this.bitRate);
        r100.l(this.videoLength);
        r100.f535643d = true;
        r100.k(this.cdnUrlExpired);
        if (this.aspectRatio > 0.0f) goto L13;
        int r104 = this.width;
        if (r104 == 0) goto L13;
        int r105 = this.height;
        if (r105 == 0) goto L13;
        this.aspectRatio = (r104 * 1.0f) / r105;
        goto L13
    }

    public final String getVideoId() {
        z14.a r100 = this.drmTokenAuth;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    public final String getVideoIdApiHost() {
        z14.a r100 = this.drmTokenAuth;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.d();
    }

    public final String getVideoIdAuth() {
        z14.a r100 = this.drmTokenAuth;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    public final String getVideoIdPToken() {
        z14.a r100 = this.drmTokenAuth;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    public final boolean isCoverValid() {
        a r100 = Companion;
        t14.a r101 = this.cover;
        r100.getClass();
        if (r101 == null) goto L8;
        List<String> r102 = r101.g();
        if (r102 == null) goto L8;
        return r102.isEmpty();
    L8:
        return false;
    }

    public final boolean isOriginCoverValid() {
        a r100 = Companion;
        t14.a r101 = this.originCover;
        r100.getClass();
        if (r101 == null) goto L8;
        List<String> r102 = r101.g();
        if (r102 == null) goto L8;
        return r102.isEmpty();
    L8:
        return false;
    }

    public String toString() {
        return "Video{playAddr=" + this.playAddr + ", playAddrH265=" + this.playAddrH265 + ", cover=" + this.cover + ", dynamicCover=" + this.dynamicCover + ", intelligentCover=" + this.intelligentCover + ", originCover=" + this.originCover + ", height=" + this.height + ", width=" + this.width + ", ratio='" + this.ratio + "', downloadAddr=" + this.downloadAddr + ", hasWaterMark=" + this.isHasWaterMark + ", videoLength=" + this.videoLength + ", bitRate=" + this.bitRate + ", newDownloadAddr=" + this.newDownloadAddr + ", suffixLogoAddr=" + this.suffixLogoDownloadAddr + ", hasSuffixWaterMark=" + this.hasSuffixWaterMark + ", needSetCookie=" + this.isNeedSetCookie + ", misc_download_addrs=" + this.miscDownloadAddrs + ", isCallback=" + this.isCallback + '}';
    }

    public Video() {
        this.cachedOuterCoverSize = new int[0];
    }

    public final t14.a getOriginCover() {
        if (isOriginCoverValid() == true) goto L8;
        if (isCoverValid() == false) goto L8;
        return this.cover;
    L8:
        return this.originCover;
    }

    public final j0 getPlayAddr() {
        a();
        j0 r100 = this.playAddrH265;
        if (r100 == null) goto L5;
        r100.f535643d = true;
        r100.f535641b = this.ratio;
    L5:
        j0 r101 = this.playAddr;
        if (r101 == null) goto L9;
        r101.f535643d = false;
        r101.f535641b = this.ratio;
    L9:
        if (checkVideo(r100) == false) goto L12;
        return this.playAddrH265;
    L12:
        return this.playAddr;
    }

    public final j0 getPlayAddrH264() {
        a();
        j0 r100 = this.playAddr;
        if (r100 == null) goto L5;
        r100.f535643d = false;
        r100.f535641b = this.ratio;
    L5:
        return r100;
    }

    public final j0 getPlayAddrH265() {
        a();
        j0 r100 = this.playAddrH265;
        if (r100 == null) goto L6;
        r100.f535643d = true;
    L6:
        if (r100 == null) goto L9;
        r100.f535641b = this.ratio;
    L9:
        return r100;
    }

    public final j0 getProperPlayAddr() {
        return getPlayAddr();
    }

    public final boolean enableIntertrustDrm() {
        return this.enableIntertrustDrm;
    }

    public final t14.a getAicover() {
        return this.aicover;
    }

    public final t14.a getAnimatedCover() {
        return this.animatedCover;
    }

    public final List<l> getBitRate() {
        return this.bitRate;
    }

    public final int[] getCachedOuterCoverSize() {
        return this.cachedOuterCoverSize;
    }

    public final t14.a getCachedOuterCoverUrl() {
        return this.cachedOuterCoverUrl;
    }

    public final t14.a getCaptionDownloadAddr() {
        return this.captionDownloadAddr;
    }

    public final long getCdnUrlExpired() {
        return this.cdnUrlExpired;
    }

    public final t14.a getCover() {
        return this.cover;
    }

    public final String getDVideoModel() {
        return this.dVideoModel;
    }

    public final t14.a getDownloadAddr() {
        return this.downloadAddr;
    }

    public final z14.a getDrmTokenAuth() {
        return this.drmTokenAuth;
    }

    public final int getDuration() {
        return this.videoLength;
    }

    public final t14.a getDynamicCover() {
        return this.dynamicCover;
    }

    public final boolean getEnableIntertrustDrm() {
        return this.enableIntertrustDrm;
    }

    public final boolean getHasSuffixWaterMark() {
        return this.hasSuffixWaterMark;
    }

    public final int getHeight() {
        return this.height;
    }

    public final t14.a getIntelligentCover() {
        return this.intelligentCover;
    }

    public final String getMeta() {
        return this.meta;
    }

    public final String getMiscDownloadAddrs() {
        return this.miscDownloadAddrs;
    }

    public final t14.a getNewDownloadAddr() {
        return this.newDownloadAddr;
    }

    public final t14.a getOptimizedCover() {
        return this.optimizedCover;
    }

    public final int getPilotLength() {
        return this.pilotLength;
    }

    public final t14.a getPlayAddrBytevc1() {
        return this.playAddrBytevc1;
    }

    public final t14.a getPlayAddrLowbr() {
        return this.playAddrLowbr;
    }

    public final String getRatio() {
        return this.ratio;
    }

    public final t14.a getResetCover() {
        return this.resetCover;
    }

    public final t14.a getSuffixLogoDownloadAddr() {
        return this.suffixLogoDownloadAddr;
    }

    public final t14.a getUIAlikeDownloadAddr() {
        return this.uIAlikeDownloadAddr;
    }

    public final int getVideoLength() {
        return this.videoLength;
    }

    public final VideoTag getVideoTag() {
        return this.videoTag;
    }

    public final List<VideoTag> getVideoTags() {
        return this.videoTags;
    }

    public final List<JsonElement> getVideoThumbs() {
        return this.videoThumbs;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean hasEndWaterMark() {
        return this.hasSuffixWaterMark;
    }

    public final Integer isBytevc1() {
        return this.isBytevc1;
    }

    public final boolean isCallback() {
        return this.isCallback;
    }

    public final boolean isForceUseSoftwareDecode() {
        return this.isForceUseSoftwareDecode;
    }

    public final int isH265() {
        return this.isH265;
    }

    public final boolean isHasWaterMark() {
        return this.isHasWaterMark;
    }

    public final Integer isLongVideo() {
        return this.isLongVideo;
    }

    public final boolean isNeedSetCookie() {
        return this.isNeedSetCookie;
    }

    public final Integer isSourceHdr() {
        return this.isSourceHdr;
    }

    public final boolean isUseStaticCover() {
        return this.isUseStaticCover;
    }

    public final boolean checkVideo(t14.a r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        List<String> r101 = r100.g();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.isEmpty() == true) goto L36;
        List<String> r102 = r101;
        if ((r102 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r103 = r102.iterator();
    L17:
        if (r103.hasNext() == false) goto L14;
        if (((String) r103.next()).length() != 0) goto L21;
        boolean r104 = true;
    L23:
        if ((!r104) == false) goto L17;
        boolean r105 = true;
    L25:
        if (r105 == true) goto L27;
        return false;
    L27:
        if (TextUtils.isEmpty(r100.e()) == true) goto L35;
        return true;
    L35:
        return false;
    L21:
        r104 = false;
    L14:
        r105 = false;
        goto L25
    L13:
        if (r102.isEmpty() == false) goto L15;
    L36:
        return false;
    }

    public final void setAicover(t14.a r100) {
        this.aicover = r100;
    }

    public final void setAnimatedCover(t14.a r100) {
        this.animatedCover = r100;
    }

    public final void setBitRate(List<l> r100) {
        this.bitRate = r100;
    }

    public final void setBytevc1(Integer r100) {
        this.isBytevc1 = r100;
    }

    public final void setCachedOuterCoverSize(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cachedOuterCoverSize = r100;
    }

    public final void setCachedOuterCoverUrl(t14.a r100) {
        this.cachedOuterCoverUrl = r100;
    }

    public final void setCallback(boolean r100) {
        this.isCallback = r100;
    }

    public final void setCaptionDownloadAddr(t14.a r100) {
        this.captionDownloadAddr = r100;
    }

    public final void setCdnUrlExpired(long r100) {
        this.cdnUrlExpired = r100;
    }

    public final void setCover(t14.a r100) {
        this.cover = r100;
    }

    public final void setDVideoModel(String r100) {
        this.dVideoModel = r100;
    }

    public final void setDownloadAddr(t14.a r100) {
        this.downloadAddr = r100;
    }

    public final void setDrmTokenAuth(z14.a r100) {
        this.drmTokenAuth = r100;
    }

    public final void setDuration(double r100) {
        this.videoLength = (int) r100;
    }

    public final void setDynamicCover(t14.a r100) {
        this.dynamicCover = r100;
    }

    public final void setEnableIntertrustDrm(boolean r100) {
        this.enableIntertrustDrm = r100;
    }

    public final void setForceUseSoftwareDecode(boolean r100) {
        this.isForceUseSoftwareDecode = r100;
    }

    public final void setH265(int r100) {
        this.isH265 = r100;
    }

    public final void setHasSuffixWaterMark(boolean r100) {
        this.hasSuffixWaterMark = r100;
    }

    public final void setHasWaterMark(boolean r100) {
        this.isHasWaterMark = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setIntelligentCover(t14.a r100) {
        this.intelligentCover = r100;
    }

    public final void setLongVideo(Integer r100) {
        this.isLongVideo = r100;
    }

    public final void setMeta(String r100) {
        this.meta = r100;
    }

    public final void setMiscDownloadAddrs(String r100) {
        this.miscDownloadAddrs = r100;
    }

    public final void setNeedSetCookie(boolean r100) {
        this.isNeedSetCookie = r100;
    }

    public final void setNewDownloadAddr(t14.a r100) {
        this.newDownloadAddr = r100;
    }

    public final void setOptimizedCover(t14.a r100) {
        this.optimizedCover = r100;
    }

    public final void setPilotLength(int r100) {
        this.pilotLength = r100;
    }

    public final void setPlayAddrBytevc1(t14.a r100) {
        this.playAddrBytevc1 = r100;
    }

    public final void setPlayAddrLowbr(t14.a r100) {
        this.playAddrLowbr = r100;
    }

    public final void setRatio(String r100) {
        this.ratio = r100;
    }

    public final void setRationAndSourceId(String r100) {
        j0 r101 = this.playAddrH265;
        if (r101 == null) goto L5;
        r101.f535641b = this.ratio;
        r101.f535640a = r100;
        r101.f535643d = true;
    L5:
        j0 r102 = this.playAddr;
        if (r102 == null) goto L9;
        r102.f535641b = this.ratio;
        r102.f535640a = r100;
        r102.f535643d = false;
        return;
    }

    public final void setResetCover(t14.a r100) {
        this.resetCover = r100;
    }

    public final void setSourceHdr(Integer r100) {
        this.isSourceHdr = r100;
    }

    public final void setSourceId(String r100) {
        setRationAndSourceId(r100);
    }

    public final void setSuffixLogoDownloadAddr(t14.a r100) {
        this.suffixLogoDownloadAddr = r100;
    }

    public final void setUIAlikeDownloadAddr(t14.a r100) {
        this.uIAlikeDownloadAddr = r100;
    }

    public final void setUseStaticCover(boolean r100) {
        this.isUseStaticCover = r100;
    }

    public final void setVideoLength(int r100) {
        this.videoLength = r100;
    }

    public final void setVideoTag(VideoTag r100) {
        this.videoTag = r100;
    }

    public final void setVideoTags(List<VideoTag> r100) {
        this.videoTags = r100;
    }

    public final void setVideoThumbs(List<? extends JsonElement> r100) {
        this.videoThumbs = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }
}
