package com.bytedance.awemeopen.export.api.pageconfig.recfeed;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.alipay.sdk.m.x.d;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.FeedFollowExtra;
import com.bytedance.awemeopen.export.api.series.homepage.SeriesHomePageConfig;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\t\n\u0002\b<\b\u0007\u0018\u0000 Å\u00012\u00020\u0001:\u0002Æ\u0001B\t¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001B\u0013\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0006\bÂ\u0001\u0010Ä\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR$\u0010#\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR$\u0010)\u001a\u0004\u0018\u00010\u00168F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR$\u0010,\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR$\u0010/\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0018\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR$\u00102\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0018\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR$\u00105\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0018\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cR$\u00108\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0018\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR\"\u0010;\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR\"\u0010>\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR\"\u0010A\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR\"\u0010D\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR$\u0010G\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010\u0018\u001a\u0004\bH\u0010\u001a\"\u0004\bI\u0010\u001cR$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u000b\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000fR\"\u0010T\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010\u000b\u001a\u0004\bT\u0010\r\"\u0004\bU\u0010\u000fR\"\u0010V\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010\u000b\u001a\u0004\bW\u0010\r\"\u0004\bX\u0010\u000fR\"\u0010Y\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010\u000b\u001a\u0004\bZ\u0010\r\"\u0004\b[\u0010\u000fR$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010\u0018\u001a\u0004\bd\u0010\u001a\"\u0004\be\u0010\u001cR\"\u0010f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010\u000b\u001a\u0004\bg\u0010\r\"\u0004\bh\u0010\u000fR\"\u0010j\u001a\u00020i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010p\u001a\u00020i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010k\u001a\u0004\bq\u0010m\"\u0004\br\u0010oR\"\u0010s\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010\u000b\u001a\u0004\bt\u0010\r\"\u0004\bu\u0010\u000fR\"\u0010v\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010\u000b\u001a\u0004\bw\u0010\r\"\u0004\bx\u0010\u000fR\"\u0010y\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010\u000b\u001a\u0004\bz\u0010\r\"\u0004\b{\u0010\u000fR\"\u0010|\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b|\u0010\u0011\u001a\u0004\b}\u0010\u0013\"\u0004\b~\u0010\u0015R&\u0010\u007f\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010\u0018\u001a\u0005\b\u0080\u0001\u0010\u001a\"\u0005\b\u0081\u0001\u0010\u001cR&\u0010\u0082\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010\u0011\u001a\u0005\b\u0083\u0001\u0010\u0013\"\u0005\b\u0084\u0001\u0010\u0015R&\u0010\u0085\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010\u0011\u001a\u0005\b\u0086\u0001\u0010\u0013\"\u0005\b\u0087\u0001\u0010\u0015R&\u0010\u0088\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010\u0011\u001a\u0005\b\u0089\u0001\u0010\u0013\"\u0005\b\u008a\u0001\u0010\u0015R*\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R*\u0010\u0092\u0001\u001a\u00030\u008b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u008d\u0001\u001a\u0006\b\u0093\u0001\u0010\u008f\u0001\"\u0006\b\u0094\u0001\u0010\u0091\u0001R&\u0010\u0095\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0095\u0001\u0010\u000b\u001a\u0005\b\u0096\u0001\u0010\r\"\u0005\b\u0097\u0001\u0010\u000fR&\u0010\u0098\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010\u000b\u001a\u0005\b\u0099\u0001\u0010\r\"\u0005\b\u009a\u0001\u0010\u000fR&\u0010\u009b\u0001\u001a\u00020\t8F@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010\u000b\u001a\u0005\b\u009c\u0001\u0010\r\"\u0005\b\u009d\u0001\u0010\u000fR*\u0010\u009e\u0001\u001a\u00030\u008b\u00018F@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u008d\u0001\u001a\u0006\b\u009f\u0001\u0010\u008f\u0001\"\u0006\b \u0001\u0010\u0091\u0001R&\u0010¡\u0001\u001a\u00020i8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¡\u0001\u0010k\u001a\u0005\b¢\u0001\u0010m\"\u0005\b£\u0001\u0010oR&\u0010¤\u0001\u001a\u00020i8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¤\u0001\u0010k\u001a\u0005\b¥\u0001\u0010m\"\u0005\b¦\u0001\u0010oR&\u0010§\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b§\u0001\u0010\u0011\u001a\u0005\b¨\u0001\u0010\u0013\"\u0005\b©\u0001\u0010\u0015R&\u0010ª\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bª\u0001\u0010\u000b\u001a\u0005\bª\u0001\u0010\r\"\u0005\b«\u0001\u0010\u000fR&\u0010¬\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¬\u0001\u0010\u000b\u001a\u0005\b¬\u0001\u0010\r\"\u0005\b\u00ad\u0001\u0010\u000fR*\u0010®\u0001\u001a\u00030\u008b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b®\u0001\u0010\u008d\u0001\u001a\u0006\b¯\u0001\u0010\u008f\u0001\"\u0006\b°\u0001\u0010\u0091\u0001R(\u0010±\u0001\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b±\u0001\u0010k\u001a\u0005\b²\u0001\u0010m\"\u0005\b³\u0001\u0010oR(\u0010´\u0001\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b´\u0001\u0010k\u001a\u0005\bµ\u0001\u0010m\"\u0005\b¶\u0001\u0010oR&\u0010·\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b·\u0001\u0010\u000b\u001a\u0005\b¸\u0001\u0010\r\"\u0005\b¹\u0001\u0010\u000fR&\u0010º\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bº\u0001\u0010\u000b\u001a\u0005\b»\u0001\u0010\r\"\u0005\b¼\u0001\u0010\u000fR*\u0010½\u0001\u001a\u00030\u008b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b½\u0001\u0010\u008d\u0001\u001a\u0006\b¾\u0001\u0010\u008f\u0001\"\u0006\b¿\u0001\u0010\u0091\u0001R\u0013\u0010Á\u0001\u001a\u00020\u00168F¢\u0006\u0007\u001a\u0005\bÀ\u0001\u0010\u001a¨\u0006Ç\u0001"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pageconfig/recfeed/FeedPageConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "fullScreen", "Z", "getFullScreen", "()Z", "setFullScreen", "(Z)V", "bottomMarginPxIfNotFullScreen", "I", "getBottomMarginPxIfNotFullScreen", "()I", "setBottomMarginPxIfNotFullScreen", "(I)V", "", "enterFrom", "Ljava/lang/String;", "getEnterFrom", "()Ljava/lang/String;", "setEnterFrom", "(Ljava/lang/String;)V", "enterAid", "getEnterAid", "setEnterAid", "enterAids", "getEnterAids", "setEnterAids", "enterRequestId", "getEnterRequestId", "setEnterRequestId", "decodeByOpenAid", "getDecodeByOpenAid", "setDecodeByOpenAid", "enterHostGid", "getEnterHostGid", "setEnterHostGid", "enterHostGids", "getEnterHostGids", "setEnterHostGids", "enterHostlocalParams", "getEnterHostlocalParams", "setEnterHostlocalParams", "enterHostClientParams", "getEnterHostClientParams", "setEnterHostClientParams", "enterHostVideoSequence", "getEnterHostVideoSequence", "setEnterHostVideoSequence", "contentScene", "getContentScene", "setContentScene", d.f25927q, "getShowBackButton", "setShowBackButton", "showComment", "getShowComment", "setShowComment", "showCollect", "getShowCollect", "setShowCollect", "ignorePageStatusControl", "getIgnorePageStatusControl", "setIgnorePageStatusControl", "liveRoomId", "getLiveRoomId", "setLiveRoomId", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "feedFollowExtra", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "getFeedFollowExtra", "()Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "setFeedFollowExtra", "(Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;)V", "hideLongPressTab", "getHideLongPressTab", "setHideLongPressTab", "isTeenagerModel", "setTeenagerModel", "uselessFollowChannel", "getUselessFollowChannel", "setUselessFollowChannel", "showSeriesChannel", "getShowSeriesChannel", "setShowSeriesChannel", "Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;", "seriesConfig", "Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;", "getSeriesConfig", "()Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;", "setSeriesConfig", "(Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;)V", "previousPage", "getPreviousPage", "setPreviousPage", "shouldPaddingStatusBarHeight", "getShouldPaddingStatusBarHeight", "setShouldPaddingStatusBarHeight", "Lorg/json/JSONObject;", "hostCommonParams", "Lorg/json/JSONObject;", "getHostCommonParams", "()Lorg/json/JSONObject;", "setHostCommonParams", "(Lorg/json/JSONObject;)V", "ecEntranceInfo", "getEcEntranceInfo", "setEcEntranceInfo", "needRefresh", "getNeedRefresh", "setNeedRefresh", "needLoadMore", "getNeedLoadMore", "setNeedLoadMore", "needCustomLoadMore", "getNeedCustomLoadMore", "setNeedCustomLoadMore", "commentBottomMargin", "getCommentBottomMargin", "setCommentBottomMargin", "hostCoverUrl", "getHostCoverUrl", "setHostCoverUrl", "excludedHeight", "getExcludedHeight", "setExcludedHeight", "hostCoverWidth", "getHostCoverWidth", "setHostCoverWidth", "hostCoverHeight", "getHostCoverHeight", "setHostCoverHeight", "", "fullscreenButtonAppearDelayMs", "J", "getFullscreenButtonAppearDelayMs", "()J", "setFullscreenButtonAppearDelayMs", "(J)V", "doubleBallLoadingDelay", "getDoubleBallLoadingDelay", "setDoubleBallLoadingDelay", "ignoreUserPauseOrPlay", "getIgnoreUserPauseOrPlay", "setIgnoreUserPauseOrPlay", "ignoreOnBackTest", "getIgnoreOnBackTest", "setIgnoreOnBackTest", "needOpenComment", "getNeedOpenComment", "setNeedOpenComment", "videoSeekPosition", "getVideoSeekPosition", "setVideoSeekPosition", "recommendTagText", "getRecommendTagText", "setRecommendTagText", "ecDetailParams", "getEcDetailParams", "setEcDetailParams", "bottomTabBarHeight", "getBottomTabBarHeight", "setBottomTabBarHeight", "isCardMode", "setCardMode", "isLandscapeFullscreen", "setLandscapeFullscreen", "clickFeedTimeStamp", "getClickFeedTimeStamp", "setClickFeedTimeStamp", "localLifeSchemaParams", "getLocalLifeSchemaParams", "setLocalLifeSchemaParams", "hostExtraParams", "getHostExtraParams", "setHostExtraParams", "enableFeedBtmComment", "getEnableFeedBtmComment", "setEnableFeedBtmComment", "enableRecFeedSkeletonLoading", "getEnableRecFeedSkeletonLoading", "setEnableRecFeedSkeletonLoading", "startPlayPosition", "getStartPlayPosition", "setStartPlayPosition", "getHostEnterFrom", "hostEnterFrom", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class FeedPageConfig implements Parcelable {
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
    private String enterHostVideoSequence;
    private String enterHostlocalParams;
    private String enterRequestId;
    private int excludedHeight;
    private FeedFollowExtra feedFollowExtra;
    private boolean fullScreen;
    private long fullscreenButtonAppearDelayMs;
    private boolean hideLongPressTab;
    private JSONObject hostCommonParams;
    private int hostCoverHeight;
    private String hostCoverUrl;
    private int hostCoverWidth;
    private JSONObject hostExtraParams;
    private boolean ignoreOnBackTest;
    private boolean ignorePageStatusControl;
    private boolean ignoreUserPauseOrPlay;
    private boolean isCardMode;
    private boolean isLandscapeFullscreen;
    private boolean isTeenagerModel;
    private String liveRoomId;
    private JSONObject localLifeSchemaParams;
    private boolean needCustomLoadMore;
    private boolean needLoadMore;
    private boolean needOpenComment;
    private boolean needRefresh;
    private String previousPage;
    private JSONObject recommendTagText;
    private SeriesHomePageConfig seriesConfig;
    private boolean shouldPaddingStatusBarHeight;
    private boolean showBackButton;
    private boolean showCollect;
    private boolean showComment;
    private boolean showSeriesChannel;
    private long startPlayPosition;
    private boolean uselessFollowChannel;
    private long videoSeekPosition;

    public static final class a implements Parcelable.Creator<FeedPageConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeedPageConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new FeedPageConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final FeedPageConfig[] newArray(int r100) {
            return new FeedPageConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getEnterAid() {
        String r100 = this.enterAid;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L18;
        String r103 = this.enterAids;
        if (r103 != null) goto L13;
    L14:
        r101 = true;
    L15:
        if (r101 == true) goto L18;
        String r104 = this.enterAids;
        Intrinsics.checkNotNull(r104);
        this.enterAid = (String) CollectionsKt.firstOrNull(StringsKt.split$default(r104, new String[]{","}, false, 0, 6, null));
        goto L18
    L13:
        if (r103.length() != 0) goto L15;
    L18:
        return this.enterAid;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final String getEnterHostGid() {
        String r100 = this.enterHostGid;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L18;
        String r103 = this.enterHostGids;
        if (r103 != null) goto L13;
    L14:
        r101 = true;
    L15:
        if (r101 == true) goto L18;
        String r104 = this.enterHostGids;
        Intrinsics.checkNotNull(r104);
        this.enterHostGid = (String) CollectionsKt.firstOrNull(StringsKt.split$default(r104, new String[]{","}, false, 0, 6, null));
        goto L18
    L13:
        if (r103.length() != 0) goto L15;
    L18:
        return this.enterHostGid;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final String getHostEnterFrom() {
        return this.hostCommonParams.optString("host_enter_from", "");
    }

    public final boolean getNeedOpenComment() {
        boolean r100 = this.needOpenComment;
        this.needOpenComment = false;
        return r100;
    }

    public final long getVideoSeekPosition() {
        long r100 = this.videoSeekPosition;
        this.videoSeekPosition = 0;
        return r100;
    }

    public FeedPageConfig() {
        this.fullScreen = true;
        this.bottomMarginPxIfNotFullScreen = MathKt.roundToInt(TypedValue.applyDimension(1, 10, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_pageconfig_recfeed_FeedPageConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        this.showComment = true;
        this.showCollect = true;
        this.shouldPaddingStatusBarHeight = true;
        this.hostCommonParams = new JSONObject();
        this.ecEntranceInfo = new JSONObject();
        this.needRefresh = true;
        this.needLoadMore = true;
        this.ignoreUserPauseOrPlay = true;
        this.ignoreOnBackTest = true;
        this.recommendTagText = new JSONObject();
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

    public final String getEnterAids() {
        return this.enterAids;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterHostClientParams() {
        return this.enterHostClientParams;
    }

    public final String getEnterHostGids() {
        return this.enterHostGids;
    }

    public final String getEnterHostVideoSequence() {
        return this.enterHostVideoSequence;
    }

    public final String getEnterHostlocalParams() {
        return this.enterHostlocalParams;
    }

    public final String getEnterRequestId() {
        return this.enterRequestId;
    }

    public final int getExcludedHeight() {
        return this.excludedHeight;
    }

    public final FeedFollowExtra getFeedFollowExtra() {
        return this.feedFollowExtra;
    }

    public final boolean getFullScreen() {
        return this.fullScreen;
    }

    public final long getFullscreenButtonAppearDelayMs() {
        return this.fullscreenButtonAppearDelayMs;
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

    public final JSONObject getLocalLifeSchemaParams() {
        return this.localLifeSchemaParams;
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

    public final JSONObject getRecommendTagText() {
        return this.recommendTagText;
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

    public final boolean isCardMode() {
        return this.isCardMode;
    }

    public final boolean isLandscapeFullscreen() {
        return this.isLandscapeFullscreen;
    }

    public final boolean isTeenagerModel() {
        return this.isTeenagerModel;
    }

    public FeedPageConfig(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        boolean r101 = false;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.fullScreen = r102;
        this.bottomMarginPxIfNotFullScreen = r100.readInt();
        this.enterFrom = r100.readString();
        this.enterAid = r100.readString();
        this.enterAids = r100.readString();
        this.enterRequestId = r100.readString();
        String r103 = r100.readString();
        String r104 = "";
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        this.enterHostGid = r103;
        String r105 = r100.readString();
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        this.enterHostGids = r105;
        String r106 = r100.readString();
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        this.enterHostlocalParams = r106;
        String r107 = r100.readString();
        if (r107 != null) goto L18;
        r107 = "";
    L18:
        this.enterHostClientParams = r107;
        String r108 = r100.readString();
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        this.enterHostVideoSequence = r108;
        String r109 = r100.readString();
        if (r109 != null) goto L24;
        r109 = "";
    L24:
        this.contentScene = r109;
        if (r100.readByte() == 0) goto L27;
        boolean r110 = true;
    L28:
        this.showBackButton = r110;
        if (r100.readByte() == 0) goto L31;
        boolean r111 = true;
    L32:
        this.showComment = r111;
        if (r100.readByte() == 0) goto L35;
        boolean r112 = true;
    L36:
        this.showCollect = r112;
        if (r100.readByte() == 0) goto L39;
        boolean r113 = true;
    L40:
        this.ignorePageStatusControl = r113;
        this.liveRoomId = r100.readString();
        this.feedFollowExtra = (FeedFollowExtra) r100.readParcelable(FeedFollowExtra.class.getClassLoader());
        if (r100.readByte() == 0) goto L43;
        boolean r114 = true;
    L44:
        this.hideLongPressTab = r114;
        if (r100.readByte() == 0) goto L47;
        boolean r115 = true;
    L48:
        this.isTeenagerModel = r115;
        if (r100.readByte() == 0) goto L51;
        boolean r116 = true;
    L52:
        this.uselessFollowChannel = r116;
        if (r100.readByte() == 0) goto L55;
        boolean r117 = true;
    L56:
        this.showSeriesChannel = r117;
        this.seriesConfig = (SeriesHomePageConfig) r100.readParcelable(SeriesHomePageConfig.class.getClassLoader());
        this.previousPage = r100.readString();
        if (r100.readByte() == 0) goto L59;
        boolean r118 = true;
    L60:
        this.needOpenComment = r118;
        this.videoSeekPosition = r100.readLong();
        String r119 = r100.readString();
        if (r119 != null) goto L63;
        r119 = "";
    L63:
        this.hostCommonParams = new JSONObject(r119);
        if (r100.readByte() == 0) goto L66;
        boolean r120 = true;
    L67:
        this.needRefresh = r120;
        if (r100.readByte() == 0) goto L70;
        boolean r121 = true;
    L71:
        this.needLoadMore = r121;
        if (r100.readByte() == 0) goto L74;
        boolean r122 = true;
    L75:
        this.shouldPaddingStatusBarHeight = r122;
        if (r100.readByte() == 0) goto L78;
        boolean r123 = true;
    L79:
        this.needCustomLoadMore = r123;
        this.commentBottomMargin = r100.readInt();
        this.hostCoverUrl = r100.readString();
        this.excludedHeight = r100.readInt();
        this.fullscreenButtonAppearDelayMs = r100.readLong();
        this.doubleBallLoadingDelay = r100.readLong();
        this.hostCoverWidth = r100.readInt();
        this.hostCoverHeight = r100.readInt();
        if (r100.readInt() != 1) goto L82;
        boolean r124 = true;
    L83:
        this.ignoreUserPauseOrPlay = r124;
        String r125 = r100.readString();
        if (r125 != null) goto L86;
    L89:
        boolean r126 = true;
    L90:
        if (r126 == true) goto L92;
        JSONObject r127 = new JSONObject(r125);
    L93:
        this.recommendTagText = r127;
        String r128 = r100.readString();
        if (r128 != null) goto L96;
        r128 = "";
    L96:
        this.ecDetailParams = new JSONObject(r128);
        this.bottomTabBarHeight = r100.readInt();
        String r129 = r100.readString();
        if (r129 != null) goto L99;
        r129 = "";
    L99:
        this.ecEntranceInfo = new JSONObject(r129);
        if (r100.readInt() != 1) goto L102;
        boolean r130 = true;
    L103:
        this.ignoreOnBackTest = r130;
        if (r100.readInt() != 1) goto L106;
        boolean r131 = true;
    L107:
        this.enableFeedBtmComment = r131;
        String r132 = r100.readString();
        if (r132 == null) goto L111;
        r104 = r132;
    L111:
        this.hostExtraParams = new JSONObject(r104);
        if (r100.readByte() == 0) goto L114;
        r101 = true;
    L114:
        this.enableRecFeedSkeletonLoading = r101;
        this.startPlayPosition = r100.readLong();
        return;
    L106:
        r131 = false;
        goto L107
    L102:
        r130 = false;
        goto L103
    L92:
        r127 = new JSONObject();
        goto L93
    L86:
        if (StringsKt.isBlank(r125) == true) goto L89;
        r126 = false;
        goto L90
    L82:
        r124 = false;
        goto L83
    L78:
        r123 = false;
        goto L79
    L74:
        r122 = false;
        goto L75
    L70:
        r121 = false;
        goto L71
    L66:
        r120 = false;
        goto L67
    L59:
        r118 = false;
        goto L60
    L55:
        r117 = false;
        goto L56
    L51:
        r116 = false;
        goto L52
    L47:
        r115 = false;
        goto L48
    L43:
        r114 = false;
        goto L44
    L39:
        r113 = false;
        goto L40
    L35:
        r112 = false;
        goto L36
    L31:
        r111 = false;
        goto L32
    L27:
        r110 = false;
        goto L28
    L5:
        r102 = false;
        goto L6
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_pageconfig_recfeed_FeedPageConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void setBottomMarginPxIfNotFullScreen(int r100) {
        this.bottomMarginPxIfNotFullScreen = r100;
    }

    public final void setBottomTabBarHeight(int r100) {
        this.bottomTabBarHeight = r100;
    }

    public final void setCardMode(boolean r100) {
        this.isCardMode = r100;
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

    public final void setEnterHostVideoSequence(String r100) {
        this.enterHostVideoSequence = r100;
    }

    public final void setEnterHostlocalParams(String r100) {
        this.enterHostlocalParams = r100;
    }

    public final void setEnterRequestId(String r100) {
        this.enterRequestId = r100;
    }

    public final void setExcludedHeight(int r100) {
        this.excludedHeight = r100;
    }

    public final void setFeedFollowExtra(FeedFollowExtra r100) {
        this.feedFollowExtra = r100;
    }

    public final void setFullScreen(boolean r100) {
        this.fullScreen = r100;
    }

    public final void setFullscreenButtonAppearDelayMs(long r100) {
        this.fullscreenButtonAppearDelayMs = r100;
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

    public final void setLandscapeFullscreen(boolean r100) {
        this.isLandscapeFullscreen = r100;
    }

    public final void setLiveRoomId(String r100) {
        this.liveRoomId = r100;
    }

    public final void setLocalLifeSchemaParams(JSONObject r100) {
        this.localLifeSchemaParams = r100;
    }

    public final void setNeedCustomLoadMore(boolean r100) {
        this.needCustomLoadMore = r100;
    }

    public final void setNeedLoadMore(boolean r100) {
        this.needLoadMore = r100;
    }

    public final void setNeedOpenComment(boolean r100) {
        this.needOpenComment = r100;
    }

    public final void setNeedRefresh(boolean r100) {
        this.needRefresh = r100;
    }

    public final void setPreviousPage(String r100) {
        this.previousPage = r100;
    }

    public final void setRecommendTagText(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recommendTagText = r100;
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

    public final void setVideoSeekPosition(long r100) {
        this.videoSeekPosition = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeByte(this.fullScreen ? 1 : 0);
        r100.writeInt(this.bottomMarginPxIfNotFullScreen);
        r100.writeString(this.enterFrom);
        r100.writeString(getEnterAid());
        r100.writeString(this.enterAids);
        r100.writeString(this.enterRequestId);
        r100.writeString(getEnterHostGid());
        r100.writeString(this.enterHostGids);
        r100.writeString(this.enterHostlocalParams);
        r100.writeString(this.enterHostClientParams);
        r100.writeString(this.enterHostVideoSequence);
        r100.writeString(this.contentScene);
        r100.writeByte(this.showBackButton ? 1 : 0);
        r100.writeByte(this.showComment ? 1 : 0);
        r100.writeByte(this.showCollect ? 1 : 0);
        r100.writeByte(this.ignorePageStatusControl ? 1 : 0);
        r100.writeString(this.liveRoomId);
        r100.writeParcelable(this.feedFollowExtra, r101);
        r100.writeByte(this.hideLongPressTab ? 1 : 0);
        r100.writeByte(this.isTeenagerModel ? 1 : 0);
        r100.writeByte(this.uselessFollowChannel ? 1 : 0);
        r100.writeByte(this.showSeriesChannel ? 1 : 0);
        r100.writeParcelable(this.seriesConfig, r101);
        r100.writeString(this.previousPage);
        r100.writeByte(getNeedOpenComment() ? 1 : 0);
        r100.writeLong(getVideoSeekPosition());
        r100.writeString(this.hostCommonParams.toString());
        r100.writeByte(this.needRefresh ? 1 : 0);
        r100.writeByte(this.needLoadMore ? 1 : 0);
        r100.writeByte(this.shouldPaddingStatusBarHeight ? 1 : 0);
        r100.writeByte(this.needCustomLoadMore ? 1 : 0);
        r100.writeInt(this.commentBottomMargin);
        r100.writeString(this.hostCoverUrl);
        r100.writeInt(this.excludedHeight);
        r100.writeLong(this.fullscreenButtonAppearDelayMs);
        r100.writeLong(this.doubleBallLoadingDelay);
        r100.writeInt(this.hostCoverWidth);
        r100.writeInt(this.hostCoverHeight);
        r100.writeInt(this.ignoreUserPauseOrPlay ? 1 : 0);
        r100.writeString(this.recommendTagText.toString());
        r100.writeString(this.ecDetailParams.toString());
        r100.writeInt(this.bottomTabBarHeight);
        r100.writeString(this.ecEntranceInfo.toString());
        r100.writeInt(this.ignoreOnBackTest ? 1 : 0);
        r100.writeInt(this.enableFeedBtmComment ? 1 : 0);
        r100.writeString(String.valueOf(this.hostExtraParams));
        r100.writeByte(this.enableRecFeedSkeletonLoading ? 1 : 0);
        r100.writeLong(this.startPlayPosition);
    }
}
