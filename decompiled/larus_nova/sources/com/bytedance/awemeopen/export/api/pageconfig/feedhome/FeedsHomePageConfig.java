package com.bytedance.awemeopen.export.api.pageconfig.feedhome;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.alipay.sdk.m.x.d;
import com.bytedance.awemeopen.export.api.series.homepage.SeriesHomePageConfig;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\t\n\u0002\b'\b\u0007\u0018\u0000 À\u00012\u00020\u0001:\u0002Á\u0001B\t¢\u0006\u0006\b½\u0001\u0010¾\u0001B\u0013\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0006\b½\u0001\u0010¿\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR$\u0010#\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR$\u0010&\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR$\u0010)\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR$\u0010,\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR$\u0010/\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0018\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR$\u00102\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0018\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR$\u00105\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0018\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cR$\u00108\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0018\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR$\u0010;\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0018\u001a\u0004\b<\u0010\u001a\"\u0004\b=\u0010\u001cR\"\u0010>\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR\"\u0010A\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR\"\u0010D\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR\"\u0010G\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010\u000b\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000fR$\u0010J\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u0018\u001a\u0004\bK\u0010\u001a\"\u0004\bL\u0010\u001cR\"\u0010N\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010\\\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010\u000b\u001a\u0004\bc\u0010\r\"\u0004\bd\u0010\u000fR\"\u0010e\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010\u000b\u001a\u0004\be\u0010\r\"\u0004\bf\u0010\u000fR\"\u0010g\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010\u000b\u001a\u0004\bh\u0010\r\"\u0004\bi\u0010\u000fR\"\u0010j\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010\u000b\u001a\u0004\bk\u0010\r\"\u0004\bl\u0010\u000fR$\u0010n\u001a\u0004\u0018\u00010m8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR$\u0010t\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010\u0018\u001a\u0004\bu\u0010\u001a\"\u0004\bv\u0010\u001cR\"\u0010w\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010\u000b\u001a\u0004\bx\u0010\r\"\u0004\by\u0010\u000fR\"\u0010z\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010O\u001a\u0004\b{\u0010Q\"\u0004\b|\u0010SR\"\u0010}\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b}\u0010O\u001a\u0004\b~\u0010Q\"\u0004\b\u007f\u0010SR&\u0010\u0080\u0001\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010O\u001a\u0005\b\u0081\u0001\u0010Q\"\u0005\b\u0082\u0001\u0010SR&\u0010\u0083\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010\u000b\u001a\u0005\b\u0084\u0001\u0010\r\"\u0005\b\u0085\u0001\u0010\u000fR&\u0010\u0086\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010\u000b\u001a\u0005\b\u0087\u0001\u0010\r\"\u0005\b\u0088\u0001\u0010\u000fR&\u0010\u0089\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010\u000b\u001a\u0005\b\u008a\u0001\u0010\r\"\u0005\b\u008b\u0001\u0010\u000fR&\u0010\u008c\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010\u0011\u001a\u0005\b\u008d\u0001\u0010\u0013\"\u0005\b\u008e\u0001\u0010\u0015R(\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010\u0018\u001a\u0005\b\u0090\u0001\u0010\u001a\"\u0005\b\u0091\u0001\u0010\u001cR&\u0010\u0092\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010\u0011\u001a\u0005\b\u0093\u0001\u0010\u0013\"\u0005\b\u0094\u0001\u0010\u0015R&\u0010\u0095\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0095\u0001\u0010\u0011\u001a\u0005\b\u0096\u0001\u0010\u0013\"\u0005\b\u0097\u0001\u0010\u0015R&\u0010\u0098\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010\u0011\u001a\u0005\b\u0099\u0001\u0010\u0013\"\u0005\b\u009a\u0001\u0010\u0015R*\u0010\u009c\u0001\u001a\u00030\u009b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R&\u0010¢\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¢\u0001\u0010\u000b\u001a\u0005\b£\u0001\u0010\r\"\u0005\b¤\u0001\u0010\u000fR&\u0010¥\u0001\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¥\u0001\u0010O\u001a\u0005\b¦\u0001\u0010Q\"\u0005\b§\u0001\u0010SR&\u0010¨\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¨\u0001\u0010\u0011\u001a\u0005\b©\u0001\u0010\u0013\"\u0005\bª\u0001\u0010\u0015R&\u0010«\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b«\u0001\u0010\u000b\u001a\u0005\b¬\u0001\u0010\r\"\u0005\b\u00ad\u0001\u0010\u000fR&\u0010®\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b®\u0001\u0010\u000b\u001a\u0005\b¯\u0001\u0010\r\"\u0005\b°\u0001\u0010\u000fR&\u0010±\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b±\u0001\u0010\u000b\u001a\u0005\b²\u0001\u0010\r\"\u0005\b³\u0001\u0010\u000fR*\u0010´\u0001\u001a\u00030\u009b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b´\u0001\u0010\u009d\u0001\u001a\u0006\bµ\u0001\u0010\u009f\u0001\"\u0006\b¶\u0001\u0010¡\u0001R&\u0010·\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b·\u0001\u0010\u000b\u001a\u0005\b¸\u0001\u0010\r\"\u0005\b¹\u0001\u0010\u000fR*\u0010º\u0001\u001a\u00030\u009b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bº\u0001\u0010\u009d\u0001\u001a\u0006\b»\u0001\u0010\u009f\u0001\"\u0006\b¼\u0001\u0010¡\u0001¨\u0006Â\u0001"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedsHomePageConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "fullScreen", "Z", "getFullScreen", "()Z", "setFullScreen", "(Z)V", "bottomMarginPxIfNotFullScreen", "I", "getBottomMarginPxIfNotFullScreen", "()I", "setBottomMarginPxIfNotFullScreen", "(I)V", "", "enterFrom", "Ljava/lang/String;", "getEnterFrom", "()Ljava/lang/String;", "setEnterFrom", "(Ljava/lang/String;)V", "enterAid", "getEnterAid", "setEnterAid", "enterRequestId", "getEnterRequestId", "setEnterRequestId", "enterAids", "getEnterAids", "setEnterAids", "enterOpenAid", "getEnterOpenAid", "setEnterOpenAid", "enterOpenAids", "getEnterOpenAids", "setEnterOpenAids", "enterHostGid", "getEnterHostGid", "setEnterHostGid", "enterHostGids", "getEnterHostGids", "setEnterHostGids", "enterHostLocalParams", "getEnterHostLocalParams", "setEnterHostLocalParams", "enterHostClientParams", "getEnterHostClientParams", "setEnterHostClientParams", "enterHostVideoSequence", "getEnterHostVideoSequence", "setEnterHostVideoSequence", "contentScene", "getContentScene", "setContentScene", d.f25927q, "getShowBackButton", "setShowBackButton", "showComment", "getShowComment", "setShowComment", "showCollect", "getShowCollect", "setShowCollect", "ignorePageStatusControl", "getIgnorePageStatusControl", "setIgnorePageStatusControl", "liveRoomId", "getLiveRoomId", "setLiveRoomId", "Lorg/json/JSONObject;", "extraEventParams", "Lorg/json/JSONObject;", "getExtraEventParams", "()Lorg/json/JSONObject;", "setExtraEventParams", "(Lorg/json/JSONObject;)V", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "feedFollowExtra", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "getFeedFollowExtra", "()Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "setFeedFollowExtra", "(Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;)V", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "profileFollowExtra", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "getProfileFollowExtra", "()Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "setProfileFollowExtra", "(Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;)V", "hideLongPressTab", "getHideLongPressTab", "setHideLongPressTab", "isTeenagerModel", "setTeenagerModel", "uselessFollowChannel", "getUselessFollowChannel", "setUselessFollowChannel", "showSeriesChannel", "getShowSeriesChannel", "setShowSeriesChannel", "Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;", "seriesConfig", "Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;", "getSeriesConfig", "()Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;", "setSeriesConfig", "(Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;)V", "previousPage", "getPreviousPage", "setPreviousPage", "shouldPaddingStatusBarHeight", "getShouldPaddingStatusBarHeight", "setShouldPaddingStatusBarHeight", "hostCommonParams", "getHostCommonParams", "setHostCommonParams", "hostExtraParams", "getHostExtraParams", "setHostExtraParams", "ecEntranceInfo", "getEcEntranceInfo", "setEcEntranceInfo", "needRefresh", "getNeedRefresh", "setNeedRefresh", "needLoadMore", "getNeedLoadMore", "setNeedLoadMore", "needCustomLoadMore", "getNeedCustomLoadMore", "setNeedCustomLoadMore", "commentBottomMargin", "getCommentBottomMargin", "setCommentBottomMargin", "hostCoverUrl", "getHostCoverUrl", "setHostCoverUrl", "excludedHeight", "getExcludedHeight", "setExcludedHeight", "hostCoverWidth", "getHostCoverWidth", "setHostCoverWidth", "hostCoverHeight", "getHostCoverHeight", "setHostCoverHeight", "", "doubleBallLoadingDelay", "J", "getDoubleBallLoadingDelay", "()J", "setDoubleBallLoadingDelay", "(J)V", "ignoreUserPauseOrPlay", "getIgnoreUserPauseOrPlay", "setIgnoreUserPauseOrPlay", "ecDetailParams", "getEcDetailParams", "setEcDetailParams", "bottomTabBarHeight", "getBottomTabBarHeight", "setBottomTabBarHeight", "ignoreOnBackTest", "getIgnoreOnBackTest", "setIgnoreOnBackTest", "decodeByOpenAid", "getDecodeByOpenAid", "setDecodeByOpenAid", "enableFeedBtmComment", "getEnableFeedBtmComment", "setEnableFeedBtmComment", "clickFeedTimeStamp", "getClickFeedTimeStamp", "setClickFeedTimeStamp", "enableRecFeedSkeletonLoading", "getEnableRecFeedSkeletonLoading", "setEnableRecFeedSkeletonLoading", "startPlayPosition", "getStartPlayPosition", "setStartPlayPosition", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class FeedsHomePageConfig implements Parcelable {
    public static final a CREATOR = null;
    private int bottomMarginPxIfNotFullScreen;
    private int bottomTabBarHeight;
    private long clickFeedTimeStamp;
    private int commentBottomMargin;
    private String contentScene;
    private boolean decodeByOpenAid;
    private long doubleBallLoadingDelay;
    private JSONObject ecDetailParams;
    private JSONObject ecEntranceInfo;
    private boolean enableFeedBtmComment;
    private boolean enableRecFeedSkeletonLoading;
    private String enterAid;
    private String enterAids;
    private String enterFrom;
    private String enterHostClientParams;
    private String enterHostGid;
    private String enterHostGids;
    private String enterHostLocalParams;
    private String enterHostVideoSequence;
    private String enterOpenAid;
    private String enterOpenAids;
    private String enterRequestId;
    private int excludedHeight;
    private JSONObject extraEventParams;
    private FeedFollowExtra feedFollowExtra;
    private boolean fullScreen;
    private boolean hideLongPressTab;
    private JSONObject hostCommonParams;
    private int hostCoverHeight;
    private String hostCoverUrl;
    private int hostCoverWidth;
    private JSONObject hostExtraParams;
    private boolean ignoreOnBackTest;
    private boolean ignorePageStatusControl;
    private boolean ignoreUserPauseOrPlay;
    private boolean isTeenagerModel;
    private String liveRoomId;
    private boolean needCustomLoadMore;
    private boolean needLoadMore;
    private boolean needRefresh;
    private String previousPage;
    private ProfileFollowExtra profileFollowExtra;
    private SeriesHomePageConfig seriesConfig;
    private boolean shouldPaddingStatusBarHeight;
    private boolean showBackButton;
    private boolean showCollect;
    private boolean showComment;
    private boolean showSeriesChannel;
    private long startPlayPosition;
    private boolean uselessFollowChannel;

    public static final class a implements Parcelable.Creator<FeedsHomePageConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeedsHomePageConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new FeedsHomePageConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final FeedsHomePageConfig[] newArray(int r100) {
            return new FeedsHomePageConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FeedsHomePageConfig() {
        this.fullScreen = true;
        this.bottomMarginPxIfNotFullScreen = MathKt.roundToInt(TypedValue.applyDimension(1, 34, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_pageconfig_feedhome_FeedsHomePageConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        this.showBackButton = true;
        this.showComment = true;
        this.showCollect = true;
        this.extraEventParams = new JSONObject();
        this.shouldPaddingStatusBarHeight = true;
        this.hostCommonParams = new JSONObject();
        this.hostExtraParams = new JSONObject();
        this.ecEntranceInfo = new JSONObject();
        this.needRefresh = true;
        this.needLoadMore = true;
        this.ignoreUserPauseOrPlay = true;
        this.ecDetailParams = new JSONObject();
    }

    public final int getBottomMarginPxIfNotFullScreen() {
        return this.bottomMarginPxIfNotFullScreen;
    }

    public final int getBottomTabBarHeight() {
        return this.bottomTabBarHeight;
    }

    public final long getClickFeedTimeStamp() {
        return this.clickFeedTimeStamp;
    }

    public final int getCommentBottomMargin() {
        return this.commentBottomMargin;
    }

    public final String getContentScene() {
        return this.contentScene;
    }

    public final boolean getDecodeByOpenAid() {
        return this.decodeByOpenAid;
    }

    public final long getDoubleBallLoadingDelay() {
        return this.doubleBallLoadingDelay;
    }

    public final JSONObject getEcDetailParams() {
        return this.ecDetailParams;
    }

    public final JSONObject getEcEntranceInfo() {
        return this.ecEntranceInfo;
    }

    public final boolean getEnableFeedBtmComment() {
        return this.enableFeedBtmComment;
    }

    public final boolean getEnableRecFeedSkeletonLoading() {
        return this.enableRecFeedSkeletonLoading;
    }

    public final String getEnterAid() {
        return this.enterAid;
    }

    public final String getEnterAids() {
        return this.enterAids;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterHostClientParams() {
        return this.enterHostClientParams;
    }

    public final String getEnterHostGid() {
        return this.enterHostGid;
    }

    public final String getEnterHostGids() {
        return this.enterHostGids;
    }

    public final String getEnterHostLocalParams() {
        return this.enterHostLocalParams;
    }

    public final String getEnterHostVideoSequence() {
        return this.enterHostVideoSequence;
    }

    public final String getEnterOpenAid() {
        return this.enterOpenAid;
    }

    public final String getEnterOpenAids() {
        return this.enterOpenAids;
    }

    public final String getEnterRequestId() {
        return this.enterRequestId;
    }

    public final int getExcludedHeight() {
        return this.excludedHeight;
    }

    public final JSONObject getExtraEventParams() {
        return this.extraEventParams;
    }

    public final FeedFollowExtra getFeedFollowExtra() {
        return this.feedFollowExtra;
    }

    public final boolean getFullScreen() {
        return this.fullScreen;
    }

    public final boolean getHideLongPressTab() {
        return this.hideLongPressTab;
    }

    public final JSONObject getHostCommonParams() {
        return this.hostCommonParams;
    }

    public final int getHostCoverHeight() {
        return this.hostCoverHeight;
    }

    public final String getHostCoverUrl() {
        return this.hostCoverUrl;
    }

    public final int getHostCoverWidth() {
        return this.hostCoverWidth;
    }

    public final JSONObject getHostExtraParams() {
        return this.hostExtraParams;
    }

    public final boolean getIgnoreOnBackTest() {
        return this.ignoreOnBackTest;
    }

    public final boolean getIgnorePageStatusControl() {
        return this.ignorePageStatusControl;
    }

    public final boolean getIgnoreUserPauseOrPlay() {
        return this.ignoreUserPauseOrPlay;
    }

    public final String getLiveRoomId() {
        return this.liveRoomId;
    }

    public final boolean getNeedCustomLoadMore() {
        return this.needCustomLoadMore;
    }

    public final boolean getNeedLoadMore() {
        return this.needLoadMore;
    }

    public final boolean getNeedRefresh() {
        return this.needRefresh;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final ProfileFollowExtra getProfileFollowExtra() {
        return this.profileFollowExtra;
    }

    public final SeriesHomePageConfig getSeriesConfig() {
        return this.seriesConfig;
    }

    public final boolean getShouldPaddingStatusBarHeight() {
        return this.shouldPaddingStatusBarHeight;
    }

    public final boolean getShowBackButton() {
        return this.showBackButton;
    }

    public final boolean getShowCollect() {
        return this.showCollect;
    }

    public final boolean getShowComment() {
        return this.showComment;
    }

    public final boolean getShowSeriesChannel() {
        return this.showSeriesChannel;
    }

    public final long getStartPlayPosition() {
        return this.startPlayPosition;
    }

    public final boolean getUselessFollowChannel() {
        return this.uselessFollowChannel;
    }

    public final boolean isTeenagerModel() {
        return this.isTeenagerModel;
    }

    public FeedsHomePageConfig(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.fullScreen = r102;
        this.bottomMarginPxIfNotFullScreen = r100.readInt();
        String r103 = r100.readString();
        String r104 = "";
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        this.enterFrom = r103;
        String r105 = r100.readString();
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        this.enterAid = r105;
        this.enterRequestId = r100.readString();
        String r106 = r100.readString();
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        this.enterAids = r106;
        String r107 = r100.readString();
        if (r107 != null) goto L18;
        r107 = "";
    L18:
        this.enterOpenAid = r107;
        String r108 = r100.readString();
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        this.enterOpenAids = r108;
        String r109 = r100.readString();
        if (r109 != null) goto L24;
        r109 = "";
    L24:
        this.enterHostGid = r109;
        String r110 = r100.readString();
        if (r110 != null) goto L27;
        r110 = "";
    L27:
        this.enterHostGids = r110;
        String r111 = r100.readString();
        if (r111 != null) goto L30;
        r111 = "";
    L30:
        this.enterHostLocalParams = r111;
        String r112 = r100.readString();
        if (r112 != null) goto L33;
        r112 = "";
    L33:
        this.enterHostClientParams = r112;
        String r113 = r100.readString();
        if (r113 != null) goto L36;
        r113 = "";
    L36:
        this.enterHostVideoSequence = r113;
        String r114 = r100.readString();
        if (r114 != null) goto L39;
        r114 = "";
    L39:
        this.contentScene = r114;
        if (r100.readByte() == 0) goto L42;
        boolean r115 = true;
    L43:
        this.showBackButton = r115;
        if (r100.readByte() == 0) goto L46;
        boolean r116 = true;
    L47:
        this.showComment = r116;
        if (r100.readByte() == 0) goto L50;
        boolean r117 = true;
    L51:
        this.showCollect = r117;
        if (r100.readByte() == 0) goto L54;
        boolean r118 = true;
    L55:
        this.ignorePageStatusControl = r118;
        String r119 = r100.readString();
        if (r119 != null) goto L58;
        r119 = "";
    L58:
        this.extraEventParams = new JSONObject(r119);
        this.liveRoomId = r100.readString();
        this.feedFollowExtra = (FeedFollowExtra) r100.readParcelable(FeedFollowExtra.class.getClassLoader());
        this.profileFollowExtra = (ProfileFollowExtra) r100.readParcelable(ProfileFollowExtra.class.getClassLoader());
        if (r100.readByte() == 0) goto L61;
        boolean r120 = true;
    L62:
        this.hideLongPressTab = r120;
        if (r100.readByte() == 0) goto L65;
        boolean r121 = true;
    L66:
        this.isTeenagerModel = r121;
        if (r100.readByte() == 0) goto L69;
        boolean r122 = true;
    L70:
        this.uselessFollowChannel = r122;
        if (r100.readByte() == 0) goto L73;
        boolean r123 = true;
    L74:
        this.showSeriesChannel = r123;
        this.seriesConfig = (SeriesHomePageConfig) r100.readParcelable(SeriesHomePageConfig.class.getClassLoader());
        this.previousPage = r100.readString();
        if (r100.readByte() == 0) goto L77;
        boolean r124 = true;
    L78:
        this.shouldPaddingStatusBarHeight = r124;
        String r125 = r100.readString();
        if (r125 != null) goto L81;
        r125 = "";
    L81:
        this.hostCommonParams = new JSONObject(r125);
        String r126 = r100.readString();
        if (r126 != null) goto L84;
        r126 = "";
    L84:
        this.hostExtraParams = new JSONObject(r126);
        if (r100.readByte() == 0) goto L87;
        boolean r127 = true;
    L88:
        this.needRefresh = r127;
        if (r100.readByte() == 0) goto L91;
        boolean r128 = true;
    L92:
        this.needLoadMore = r128;
        if (r100.readByte() == 0) goto L95;
        boolean r129 = true;
    L96:
        this.needCustomLoadMore = r129;
        this.commentBottomMargin = r100.readInt();
        this.hostCoverUrl = r100.readString();
        this.excludedHeight = r100.readInt();
        this.doubleBallLoadingDelay = r100.readLong();
        this.hostCoverWidth = r100.readInt();
        this.hostCoverHeight = r100.readInt();
        if (r100.readByte() == 0) goto L99;
        boolean r130 = true;
    L100:
        this.ignoreUserPauseOrPlay = r130;
        String r131 = r100.readString();
        if (r131 != null) goto L103;
        r131 = "";
    L103:
        this.ecDetailParams = new JSONObject(r131);
        this.bottomTabBarHeight = r100.readInt();
        String r132 = r100.readString();
        if (r132 == null) goto L107;
        r104 = r132;
    L107:
        this.ecEntranceInfo = new JSONObject(r104);
        if (r100.readByte() == 0) goto L110;
        boolean r133 = true;
    L111:
        this.ignoreOnBackTest = r133;
        if (r100.readByte() == 0) goto L114;
        boolean r134 = true;
    L115:
        this.decodeByOpenAid = r134;
        if (r100.readByte() == 0) goto L118;
        boolean r135 = true;
    L119:
        this.enableFeedBtmComment = r135;
        this.clickFeedTimeStamp = r100.readLong();
        if (r100.readByte() != 0) goto L123;
        r101 = false;
    L123:
        this.enableRecFeedSkeletonLoading = r101;
        this.startPlayPosition = r100.readLong();
        return;
    L118:
        r135 = false;
        goto L119
    L114:
        r134 = false;
        goto L115
    L110:
        r133 = false;
        goto L111
    L99:
        r130 = false;
        goto L100
    L95:
        r129 = false;
        goto L96
    L91:
        r128 = false;
        goto L92
    L87:
        r127 = false;
        goto L88
    L77:
        r124 = false;
        goto L78
    L73:
        r123 = false;
        goto L74
    L69:
        r122 = false;
        goto L70
    L65:
        r121 = false;
        goto L66
    L61:
        r120 = false;
        goto L62
    L54:
        r118 = false;
        goto L55
    L50:
        r117 = false;
        goto L51
    L46:
        r116 = false;
        goto L47
    L42:
        r115 = false;
        goto L43
    L5:
        r102 = false;
        goto L6
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_pageconfig_feedhome_FeedsHomePageConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void setBottomMarginPxIfNotFullScreen(int r100) {
        this.bottomMarginPxIfNotFullScreen = r100;
    }

    public final void setBottomTabBarHeight(int r100) {
        this.bottomTabBarHeight = r100;
    }

    public final void setClickFeedTimeStamp(long r100) {
        this.clickFeedTimeStamp = r100;
    }

    public final void setCommentBottomMargin(int r100) {
        this.commentBottomMargin = r100;
    }

    public final void setContentScene(String r100) {
        this.contentScene = r100;
    }

    public final void setDecodeByOpenAid(boolean r100) {
        this.decodeByOpenAid = r100;
    }

    public final void setDoubleBallLoadingDelay(long r100) {
        this.doubleBallLoadingDelay = r100;
    }

    public final void setEcDetailParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ecDetailParams = r100;
    }

    public final void setEcEntranceInfo(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ecEntranceInfo = r100;
    }

    public final void setEnableFeedBtmComment(boolean r100) {
        this.enableFeedBtmComment = r100;
    }

    public final void setEnableRecFeedSkeletonLoading(boolean r100) {
        this.enableRecFeedSkeletonLoading = r100;
    }

    public final void setEnterAid(String r100) {
        this.enterAid = r100;
    }

    public final void setEnterAids(String r100) {
        this.enterAids = r100;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setEnterHostClientParams(String r100) {
        this.enterHostClientParams = r100;
    }

    public final void setEnterHostGid(String r100) {
        this.enterHostGid = r100;
    }

    public final void setEnterHostGids(String r100) {
        this.enterHostGids = r100;
    }

    public final void setEnterHostLocalParams(String r100) {
        this.enterHostLocalParams = r100;
    }

    public final void setEnterHostVideoSequence(String r100) {
        this.enterHostVideoSequence = r100;
    }

    public final void setEnterOpenAid(String r100) {
        this.enterOpenAid = r100;
    }

    public final void setEnterOpenAids(String r100) {
        this.enterOpenAids = r100;
    }

    public final void setEnterRequestId(String r100) {
        this.enterRequestId = r100;
    }

    public final void setExcludedHeight(int r100) {
        this.excludedHeight = r100;
    }

    public final void setExtraEventParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraEventParams = r100;
    }

    public final void setFeedFollowExtra(FeedFollowExtra r100) {
        this.feedFollowExtra = r100;
    }

    public final void setFullScreen(boolean r100) {
        this.fullScreen = r100;
    }

    public final void setHideLongPressTab(boolean r100) {
        this.hideLongPressTab = r100;
    }

    public final void setHostCommonParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostCommonParams = r100;
    }

    public final void setHostCoverHeight(int r100) {
        this.hostCoverHeight = r100;
    }

    public final void setHostCoverUrl(String r100) {
        this.hostCoverUrl = r100;
    }

    public final void setHostCoverWidth(int r100) {
        this.hostCoverWidth = r100;
    }

    public final void setHostExtraParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostExtraParams = r100;
    }

    public final void setIgnoreOnBackTest(boolean r100) {
        this.ignoreOnBackTest = r100;
    }

    public final void setIgnorePageStatusControl(boolean r100) {
        this.ignorePageStatusControl = r100;
    }

    public final void setIgnoreUserPauseOrPlay(boolean r100) {
        this.ignoreUserPauseOrPlay = r100;
    }

    public final void setLiveRoomId(String r100) {
        this.liveRoomId = r100;
    }

    public final void setNeedCustomLoadMore(boolean r100) {
        this.needCustomLoadMore = r100;
    }

    public final void setNeedLoadMore(boolean r100) {
        this.needLoadMore = r100;
    }

    public final void setNeedRefresh(boolean r100) {
        this.needRefresh = r100;
    }

    public final void setPreviousPage(String r100) {
        this.previousPage = r100;
    }

    public final void setProfileFollowExtra(ProfileFollowExtra r100) {
        this.profileFollowExtra = r100;
    }

    public final void setSeriesConfig(SeriesHomePageConfig r100) {
        this.seriesConfig = r100;
    }

    public final void setShouldPaddingStatusBarHeight(boolean r100) {
        this.shouldPaddingStatusBarHeight = r100;
    }

    public final void setShowBackButton(boolean r100) {
        this.showBackButton = r100;
    }

    public final void setShowCollect(boolean r100) {
        this.showCollect = r100;
    }

    public final void setShowComment(boolean r100) {
        this.showComment = r100;
    }

    public final void setShowSeriesChannel(boolean r100) {
        this.showSeriesChannel = r100;
    }

    public final void setStartPlayPosition(long r100) {
        this.startPlayPosition = r100;
    }

    public final void setTeenagerModel(boolean r100) {
        this.isTeenagerModel = r100;
    }

    public final void setUselessFollowChannel(boolean r100) {
        this.uselessFollowChannel = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeByte(this.fullScreen ? 1 : 0);
        r100.writeInt(this.bottomMarginPxIfNotFullScreen);
        r100.writeString(this.enterFrom);
        r100.writeString(this.enterAid);
        r100.writeString(this.enterRequestId);
        r100.writeString(this.enterAids);
        r100.writeString(this.enterOpenAid);
        r100.writeString(this.enterOpenAids);
        r100.writeString(this.enterHostGid);
        r100.writeString(this.enterHostGids);
        r100.writeString(this.enterHostLocalParams);
        r100.writeString(this.enterHostClientParams);
        r100.writeString(this.enterHostVideoSequence);
        r100.writeString(this.contentScene);
        r100.writeByte(this.showBackButton ? 1 : 0);
        r100.writeByte(this.showComment ? 1 : 0);
        r100.writeByte(this.showCollect ? 1 : 0);
        r100.writeByte(this.ignorePageStatusControl ? 1 : 0);
        r100.writeString(this.extraEventParams.toString());
        r100.writeString(this.liveRoomId);
        r100.writeParcelable(this.feedFollowExtra, r101);
        r100.writeParcelable(this.profileFollowExtra, r101);
        r100.writeByte(this.hideLongPressTab ? 1 : 0);
        r100.writeByte(this.isTeenagerModel ? 1 : 0);
        r100.writeByte(this.uselessFollowChannel ? 1 : 0);
        r100.writeByte(this.showSeriesChannel ? 1 : 0);
        r100.writeParcelable(this.seriesConfig, r101);
        r100.writeString(this.previousPage);
        r100.writeByte(this.shouldPaddingStatusBarHeight ? 1 : 0);
        r100.writeString(this.hostCommonParams.toString());
        r100.writeString(this.hostExtraParams.toString());
        r100.writeByte(this.needRefresh ? 1 : 0);
        r100.writeByte(this.needLoadMore ? 1 : 0);
        r100.writeByte(this.needCustomLoadMore ? 1 : 0);
        r100.writeInt(this.commentBottomMargin);
        r100.writeString(this.hostCoverUrl);
        r100.writeInt(this.excludedHeight);
        r100.writeLong(this.doubleBallLoadingDelay);
        r100.writeInt(this.hostCoverWidth);
        r100.writeInt(this.hostCoverHeight);
        r100.writeByte(this.ignoreUserPauseOrPlay ? 1 : 0);
        r100.writeString(this.ecDetailParams.toString());
        r100.writeInt(this.bottomTabBarHeight);
        r100.writeString(this.ecEntranceInfo.toString());
        r100.writeByte(this.ignoreOnBackTest ? 1 : 0);
        r100.writeByte(this.decodeByOpenAid ? 1 : 0);
        r100.writeByte(this.enableFeedBtmComment ? 1 : 0);
        r100.writeLong(this.clickFeedTimeStamp);
        r100.writeByte(this.enableRecFeedSkeletonLoading ? 1 : 0);
        r100.writeLong(this.startPlayPosition);
    }
}
