package com.bytedance.awemeopen.export.api.pageconfig.recfeed;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.alipay.sdk.m.x.d;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.FeedFollowExtra;
import com.bytedance.awemeopen.export.api.series.homepage.SeriesHomePageConfig;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b*\b\u0007\u0018\u0000 \u009c\u00012\u00020\u0001:\u0002\u009d\u0001B\t¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J'\u0010\u0005\u001a\u00020\u00032\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010!\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u000fJ\u0010\u0010#\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010%\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010'\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0007J\u0010\u00101\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u000fJ\u0010\u00104\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u000102J\u000e\u00106\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0007J\u000e\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0007J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0007J\u0010\u0010?\u001a\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010=J\u0010\u0010A\u001a\u00020\u00002\b\u0010@\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0007J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010E\u001a\u00020DJ\u000e\u0010H\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0007J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\fJ0\u0010R\u001a\u00020\u00002\b\u0010M\u001a\u0004\u0018\u00010\u000f2\u0006\u0010N\u001a\u00020\f2\u0006\u0010O\u001a\u00020\f2\u0006\u0010P\u001a\u00020\f2\u0006\u0010Q\u001a\u00020DJ\u000e\u0010T\u001a\u00020\u00002\u0006\u0010S\u001a\u00020DJ\u000e\u0010V\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0003J\u000e\u0010X\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\u0003J\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\u0007J\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010[\u001a\u00020\u0003J\u000e\u0010^\u001a\u00020\u00002\u0006\u0010]\u001a\u00020\u0007J\u000e\u0010`\u001a\u00020\u00002\u0006\u0010_\u001a\u00020\u0007J\u0010\u0010b\u001a\u00020\u00002\b\u0010a\u001a\u0004\u0018\u00010\u0003J\u000e\u0010d\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u0003J\u000e\u0010f\u001a\u00020\u00002\u0006\u0010e\u001a\u00020\fJ\u000e\u0010h\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\u0007J\u000e\u0010j\u001a\u00020\u00002\u0006\u0010i\u001a\u00020\u0007J\u000e\u0010l\u001a\u00020\u00002\u0006\u0010k\u001a\u00020DJ\u000e\u0010n\u001a\u00020\u00002\u0006\u0010m\u001a\u00020DJ\u0010\u0010o\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\u0010\u0010p\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\u0010\u0010q\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\u000e\u0010s\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\u0007J\u0006\u0010u\u001a\u00020tR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010vR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010wR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010xR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010xR\u0018\u0010y\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010xR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010xR\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010vR$\u0010z\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010x\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R&\u0010\u007f\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010x\u001a\u0005\b\u0080\u0001\u0010|\"\u0005\b\u0081\u0001\u0010~R(\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010x\u001a\u0005\b\u0083\u0001\u0010|\"\u0005\b\u0084\u0001\u0010~R&\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b \u0010x\u001a\u0005\b\u0085\u0001\u0010|\"\u0005\b\u0086\u0001\u0010~R&\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\"\u0010x\u001a\u0005\b\u0087\u0001\u0010|\"\u0005\b\u0088\u0001\u0010~R\u0018\u0010&\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010xR\u0016\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010vR\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010vR\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010vR\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010vR\u0018\u00100\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010xR\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0016\u00105\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010vR\u0016\u00107\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010vR\u0016\u00109\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010vR\u0016\u0010;\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010vR\u0019\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b>\u0010\u008b\u0001R\u0018\u0010@\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010xR\u0016\u0010B\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010vR\u0019\u0010\u008c\u0001\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0016\u0010G\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010vR\u0017\u0010U\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bU\u0010\u008e\u0001R\u0017\u0010W\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bW\u0010\u008e\u0001R\u0017\u0010[\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b[\u0010\u008e\u0001R\u0016\u0010]\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010vR\u0016\u0010_\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010vR\u0016\u0010I\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010vR\u0016\u0010K\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010wR\u0018\u0010M\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010xR\u0016\u0010P\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010wR\u0016\u0010N\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010wR\u0016\u0010O\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010wR\u0017\u0010S\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bS\u0010\u008d\u0001R\u0017\u0010Q\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bQ\u0010\u008d\u0001R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010vR\u001b\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u008e\u0001R\u0016\u0010Y\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010vR\u0016\u0010g\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010vR\u0017\u0010m\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bm\u0010\u008d\u0001R\u0016\u0010i\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010vR\u0017\u0010k\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bk\u0010\u008d\u0001R+\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u008e\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R+\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u008e\u0001\u001a\u0006\b\u0096\u0001\u0010\u0092\u0001\"\u0006\b\u0097\u0001\u0010\u0094\u0001R\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u008e\u0001R\u001b\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u008e\u0001R\u0016\u0010r\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010vR\u0017\u0010c\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bc\u0010\u008e\u0001R\u0016\u0010e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010w¨\u0006\u009e\u0001"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pageconfig/recfeed/FeedPageConfigBuilder;", "", "", "Lorg/json/JSONObject;", "objs", "mergeJSONObject", "([Lorg/json/JSONObject;)Lorg/json/JSONObject;", "", "ignoreUserPauseOrPlay", "withIgnoreUserPauseOrPlay", "fullScreen", "withFullScreen", "", "bottomMarginPxIfNotFullScreen", "withBottomMarginPxIfNotFullScreen", "", "enterFrom", "withEnterFrom", "topAid", "withEnterAid", "requestId", "withEnterRequestId", "topAids", "withEnterAids", "decodeByOpenAid", "withDecodeByOpenAid", "extraParams", "withVideoEventExtraParams", "hostGids", "withEnterHostGids", "enterHostlocalParams", "withEnterHostLocalParams", "enterHostClientParams", "withEnterHostClientParams", "enterHostVideoSequence", "withEnterHostVideoSequence", "hostGid", "withEnterHostGid", "contentScene", "withContentScene", d.f25927q, "withShowBackButton", "showComment", "withShowComment", "showCollect", "withShowCollect", "ignorePageStatusControl", "withIgnorePageStatusControl", "liveRoomId", "withEnterLiveRoomId", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "followExtra", "withFeedFollowExtra", "hideLongPressTab", "withHideLongPressTab", "isTeenagerModel", "withIsTeenagerModel", "uselessFollowChannel", "withUselessFollowChannel", "showSeriesChannel", "withShowSeriesChannel", "Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;", "seriesConfig", "withSeriesConfig", "previousPage", "withPreviousPage", "needOpenComment", "withNeedOpenComment", "", "position", "withVideoSeekPosition", "shouldPaddingStatusBarHeight", "withShouldPaddingStatusBarHeight", "needCustomLoadMore", "withNeedCustomLoadMore", "commentBottomMargin", "withCommentBottomMargin", "hostCoverUrl", "hostCoverWidth", "hostCoverHeight", "excludedHeight", "doubleBallLoadingDelay", "withHostCoverUrl", "fullscreenButtonAppearDelayMs", "withFullscreenButtonAppearDelayMs", "hostCommonParams", "withHostCommonParams", "hostExtraParams", "withHostExtraParams", "ignoreOnBackTest", "withIgnoreOnBackTest", "ecEntranceInfo", "withEcEntranceInfo", "needRefresh", "withNeedRefresh", "needLoadMore", "withNeedLoadMore", "recommendText", "withRecommendTagText", "ecDetailParams", "withEcDetailParams", "bottomTabBarHeight", "withBottomTabBarHeight", "isCardMode", "withCardMode", "enableRecFeedSkeletonLoading", "withEnableRecFeedSkeletonLoading", "startPlayPosition", "withStartPlayPosition", "clickFeedTimeStamp", "withClickFeedTimeStamp", "withLocalLifeSchemaParams", "withLocalLifeExtraParams", "withLiveEventExtraParams", "enableFeedBtmComment", "withFeedBtmComment", "Lcom/bytedance/awemeopen/export/api/pageconfig/recfeed/FeedPageConfig;", "build", "Z", "I", "Ljava/lang/String;", "topRequestId", "enterHostGid", "getEnterHostGid", "()Ljava/lang/String;", "setEnterHostGid", "(Ljava/lang/String;)V", "enterHostGids", "getEnterHostGids", "setEnterHostGids", "enterHostLocalParams", "getEnterHostLocalParams", "setEnterHostLocalParams", "getEnterHostClientParams", "setEnterHostClientParams", "getEnterHostVideoSequence", "setEnterHostVideoSequence", "feedFollowExtra", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;", "videoSeekPosition", "J", "Lorg/json/JSONObject;", "recommendTagText", "localLifeExtraParams", "getLocalLifeExtraParams", "()Lorg/json/JSONObject;", "setLocalLifeExtraParams", "(Lorg/json/JSONObject;)V", "videoEventExtraParams", "getVideoEventExtraParams", "setVideoEventExtraParams", "localLifeSchemaParams", "liveEventExtraParams", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class FeedPageConfigBuilder {
    public static final String CONFIG_KEY = "FEED_PAGE_CONFIG_CONFIG_KEY";
    public static final a Companion = null;
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
    private String enterFrom;
    private String enterHostClientParams;
    private String enterHostGid;
    private String enterHostGids;
    private String enterHostLocalParams;
    private String enterHostVideoSequence;
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
    private boolean isTeenagerModel;
    private JSONObject liveEventExtraParams;
    private String liveRoomId;
    private JSONObject localLifeExtraParams;
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
    private String topAid;
    private String topAids;
    private String topRequestId;
    private boolean uselessFollowChannel;
    private JSONObject videoEventExtraParams;
    private long videoSeekPosition;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final FeedPageConfig build() {
        FeedPageConfig r100 = new FeedPageConfig();
        r100.setFullScreen(this.fullScreen);
        r100.setBottomMarginPxIfNotFullScreen(this.bottomMarginPxIfNotFullScreen);
        r100.setEnterFrom(this.enterFrom);
        r100.setEnterAid(this.topAid);
        r100.setEnterRequestId(this.topRequestId);
        r100.setEnterAids(this.topAids);
        r100.setDecodeByOpenAid(this.decodeByOpenAid);
        r100.setEnterHostGid(this.enterHostGid);
        r100.setEnterHostGids(this.enterHostGids);
        r100.setEnterHostlocalParams(this.enterHostLocalParams);
        r100.setEnterHostClientParams(this.enterHostClientParams);
        r100.setEnterHostVideoSequence(this.enterHostVideoSequence);
        r100.setContentScene(this.contentScene);
        r100.setShowBackButton(this.showBackButton);
        r100.setShowComment(this.showComment);
        r100.setShowCollect(this.showCollect);
        r100.setIgnorePageStatusControl(this.ignorePageStatusControl);
        r100.setLiveRoomId(this.liveRoomId);
        r100.setFeedFollowExtra(this.feedFollowExtra);
        r100.setHideLongPressTab(this.hideLongPressTab);
        r100.setTeenagerModel(this.isTeenagerModel);
        r100.setUselessFollowChannel(this.uselessFollowChannel);
        r100.setShowSeriesChannel(this.showSeriesChannel);
        r100.setSeriesConfig(this.seriesConfig);
        r100.setPreviousPage(this.previousPage);
        r100.setNeedOpenComment(this.needOpenComment);
        r100.setVideoSeekPosition(this.videoSeekPosition);
        r100.setHostCommonParams(this.hostCommonParams);
        r100.setHostExtraParams(mergeJSONObject(new JSONObject[]{this.hostExtraParams, this.videoEventExtraParams, this.localLifeExtraParams, this.liveEventExtraParams}));
        r100.setNeedRefresh(this.needRefresh);
        r100.setNeedLoadMore(this.needLoadMore);
        r100.setNeedCustomLoadMore(this.needCustomLoadMore);
        r100.setShouldPaddingStatusBarHeight(this.shouldPaddingStatusBarHeight);
        r100.setCommentBottomMargin(this.commentBottomMargin);
        r100.setHostCoverUrl(this.hostCoverUrl);
        r100.setExcludedHeight(this.excludedHeight);
        r100.setFullscreenButtonAppearDelayMs(this.fullscreenButtonAppearDelayMs);
        r100.setDoubleBallLoadingDelay(this.doubleBallLoadingDelay);
        r100.setHostCoverWidth(this.hostCoverWidth);
        r100.setHostCoverHeight(this.hostCoverHeight);
        r100.setIgnoreUserPauseOrPlay(this.ignoreUserPauseOrPlay);
        JSONObject r101 = this.recommendTagText;
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        r100.setRecommendTagText(r101);
        r100.setEcDetailParams(this.ecDetailParams);
        r100.setBottomTabBarHeight(this.bottomTabBarHeight);
        r100.setEcEntranceInfo(this.ecEntranceInfo);
        r100.setIgnoreOnBackTest(this.ignoreOnBackTest);
        r100.setCardMode(this.isCardMode);
        r100.setClickFeedTimeStamp(this.clickFeedTimeStamp);
        r100.setEnableRecFeedSkeletonLoading(this.enableRecFeedSkeletonLoading);
        r100.setLocalLifeSchemaParams(this.localLifeSchemaParams);
        r100.setEnableFeedBtmComment(this.enableFeedBtmComment);
        r100.setStartPlayPosition(this.startPlayPosition);
        return r100;
    }

    public FeedPageConfigBuilder() {
        this.fullScreen = true;
        this.bottomMarginPxIfNotFullScreen = MathKt.roundToInt(TypedValue.applyDimension(1, 34, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_pageconfig_recfeed_FeedPageConfigBuilder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        this.showBackButton = true;
        this.showComment = true;
        this.showCollect = true;
        this.shouldPaddingStatusBarHeight = true;
        this.hostCommonParams = new JSONObject();
        this.hostExtraParams = new JSONObject();
        this.ecEntranceInfo = new JSONObject();
        this.needRefresh = true;
        this.needLoadMore = true;
        this.ignoreUserPauseOrPlay = true;
        this.ignoreOnBackTest = true;
        this.ecDetailParams = new JSONObject();
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

    public final JSONObject getLocalLifeExtraParams() {
        return this.localLifeExtraParams;
    }

    public final JSONObject getVideoEventExtraParams() {
        return this.videoEventExtraParams;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_pageconfig_recfeed_FeedPageConfigBuilder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final JSONObject mergeJSONObject(JSONObject... r100) {
        JSONObject r101 = new JSONObject();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        JSONObject r104 = r100[r103];
        if (r104 == null) goto L10;
        Iterator<String> r105 = r104.keys();
    L8:
        if (r105.hasNext() == false) goto L10;
        String r106 = r105.next();
        r101.put(r106, r104.get(r106));
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        return r101;
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

    public final void setLocalLifeExtraParams(JSONObject r100) {
        this.localLifeExtraParams = r100;
    }

    public final void setVideoEventExtraParams(JSONObject r100) {
        this.videoEventExtraParams = r100;
    }

    public final FeedPageConfigBuilder withBottomMarginPxIfNotFullScreen(int r100) {
        this.bottomMarginPxIfNotFullScreen = r100;
        return this;
    }

    public final FeedPageConfigBuilder withBottomTabBarHeight(int r100) {
        this.bottomTabBarHeight = r100;
        return this;
    }

    public final FeedPageConfigBuilder withCardMode(boolean r100) {
        this.isCardMode = r100;
        return this;
    }

    public final FeedPageConfigBuilder withClickFeedTimeStamp(long r100) {
        this.clickFeedTimeStamp = r100;
        return this;
    }

    public final FeedPageConfigBuilder withCommentBottomMargin(int r100) {
        this.commentBottomMargin = r100;
        return this;
    }

    public final FeedPageConfigBuilder withContentScene(String r100) {
        this.contentScene = r100;
        return this;
    }

    public final FeedPageConfigBuilder withDecodeByOpenAid(boolean r100) {
        this.decodeByOpenAid = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEcDetailParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "ecDetailParams");
        this.ecDetailParams = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEcEntranceInfo(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "ecEntranceInfo");
        this.ecEntranceInfo = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEnableRecFeedSkeletonLoading(boolean r100) {
        this.enableRecFeedSkeletonLoading = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEnterAid(String r100) {
        this.topAid = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEnterAids(String r100) {
        this.topAids = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEnterFrom(String r100) {
        this.enterFrom = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEnterHostClientParams(String r100) {
        this.enterHostClientParams = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEnterHostGid(String r100) {
        this.enterHostGid = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEnterHostGids(String r100) {
        this.enterHostGids = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEnterHostLocalParams(String r100) {
        this.enterHostLocalParams = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEnterHostVideoSequence(String r100) {
        this.enterHostVideoSequence = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEnterLiveRoomId(String r100) {
        this.liveRoomId = r100;
        return this;
    }

    public final FeedPageConfigBuilder withEnterRequestId(String r100) {
        this.topRequestId = r100;
        return this;
    }

    public final FeedPageConfigBuilder withFeedBtmComment(boolean r100) {
        this.enableFeedBtmComment = r100;
        return this;
    }

    public final FeedPageConfigBuilder withFeedFollowExtra(FeedFollowExtra r100) {
        this.feedFollowExtra = r100;
        return this;
    }

    public final FeedPageConfigBuilder withFullScreen(boolean r100) {
        this.fullScreen = r100;
        return this;
    }

    public final FeedPageConfigBuilder withFullscreenButtonAppearDelayMs(long r100) {
        this.fullscreenButtonAppearDelayMs = r100;
        return this;
    }

    public final FeedPageConfigBuilder withHideLongPressTab(boolean r100) {
        this.hideLongPressTab = r100;
        return this;
    }

    public final FeedPageConfigBuilder withHostCommonParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "hostCommonParams");
        this.hostCommonParams = r100;
        return this;
    }

    public final FeedPageConfigBuilder withHostExtraParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "hostExtraParams");
        this.hostExtraParams = r100;
        return this;
    }

    public final FeedPageConfigBuilder withIgnoreOnBackTest(boolean r100) {
        this.ignoreOnBackTest = r100;
        return this;
    }

    public final FeedPageConfigBuilder withIgnorePageStatusControl(boolean r100) {
        this.ignorePageStatusControl = r100;
        return this;
    }

    public final FeedPageConfigBuilder withIgnoreUserPauseOrPlay(boolean r100) {
        this.ignoreUserPauseOrPlay = r100;
        return this;
    }

    public final FeedPageConfigBuilder withIsTeenagerModel(boolean r100) {
        this.isTeenagerModel = r100;
        return this;
    }

    public final FeedPageConfigBuilder withLiveEventExtraParams(JSONObject r100) {
        this.liveEventExtraParams = r100;
        return this;
    }

    public final FeedPageConfigBuilder withLocalLifeExtraParams(JSONObject r100) {
        this.localLifeExtraParams = r100;
        return this;
    }

    public final FeedPageConfigBuilder withLocalLifeSchemaParams(JSONObject r100) {
        this.localLifeSchemaParams = r100;
        return this;
    }

    public final FeedPageConfigBuilder withNeedCustomLoadMore(boolean r100) {
        this.needCustomLoadMore = r100;
        return this;
    }

    public final FeedPageConfigBuilder withNeedLoadMore(boolean r100) {
        this.needLoadMore = r100;
        return this;
    }

    public final FeedPageConfigBuilder withNeedOpenComment(boolean r100) {
        this.needOpenComment = r100;
        return this;
    }

    public final FeedPageConfigBuilder withNeedRefresh(boolean r100) {
        this.needRefresh = r100;
        return this;
    }

    public final FeedPageConfigBuilder withPreviousPage(String r100) {
        this.previousPage = r100;
        return this;
    }

    public final FeedPageConfigBuilder withRecommendTagText(JSONObject r100) {
        this.recommendTagText = r100;
        return this;
    }

    public final FeedPageConfigBuilder withSeriesConfig(SeriesHomePageConfig r100) {
        this.seriesConfig = r100;
        return this;
    }

    public final FeedPageConfigBuilder withShouldPaddingStatusBarHeight(boolean r100) {
        this.shouldPaddingStatusBarHeight = r100;
        return this;
    }

    public final FeedPageConfigBuilder withShowBackButton(boolean r100) {
        this.showBackButton = r100;
        return this;
    }

    public final FeedPageConfigBuilder withShowCollect(boolean r100) {
        this.showCollect = r100;
        return this;
    }

    public final FeedPageConfigBuilder withShowComment(boolean r100) {
        this.showComment = r100;
        return this;
    }

    public final FeedPageConfigBuilder withShowSeriesChannel(boolean r100) {
        this.showSeriesChannel = r100;
        return this;
    }

    public final FeedPageConfigBuilder withStartPlayPosition(long r100) {
        this.startPlayPosition = r100;
        return this;
    }

    public final FeedPageConfigBuilder withUselessFollowChannel(boolean r100) {
        this.uselessFollowChannel = r100;
        return this;
    }

    public final FeedPageConfigBuilder withVideoEventExtraParams(JSONObject r100) {
        this.videoEventExtraParams = r100;
        return this;
    }

    public final FeedPageConfigBuilder withVideoSeekPosition(long r100) {
        this.videoSeekPosition = r100;
        return this;
    }

    public final FeedPageConfigBuilder withHostCoverUrl(String r100, int r101, int r102, int r103, long r104) {
        this.hostCoverUrl = r100;
        this.hostCoverWidth = r101;
        this.hostCoverHeight = r102;
        this.excludedHeight = r103;
        this.doubleBallLoadingDelay = r104;
        return this;
    }
}
