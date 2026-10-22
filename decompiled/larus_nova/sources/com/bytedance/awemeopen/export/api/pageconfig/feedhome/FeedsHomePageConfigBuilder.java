package com.bytedance.awemeopen.export.api.pageconfig.feedhome;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.alipay.sdk.m.x.d;
import com.bytedance.awemeopen.export.api.series.homepage.SeriesHomePageConfig;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u0000 |2\u00020\u0001:\u0001}B\t\b\u0002¢\u0006\u0004\bz\u0010{J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017J\u0010\u0010!\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0017J\u0010\u0010#\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0017J\u0010\u0010%\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0017J\u0010\u0010'\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0017J\u0010\u0010)\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010\u0017J\u0010\u0010+\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010\u0017J\u0010\u0010-\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\u0017J\u0010\u0010/\u001a\u00020\u00002\b\u0010.\u001a\u0004\u0018\u00010\u0017J\u000e\u00102\u001a\u00020\u00002\u0006\u00101\u001a\u000200J\u000e\u00104\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0002J\u000e\u00106\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0002J\u000e\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0002J\u000e\u0010:\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0002J\u0010\u0010<\u001a\u00020\u00002\b\u0010;\u001a\u0004\u0018\u00010\u0017J\u0010\u0010>\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010\u0017J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0002J\u000e\u0010B\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0002J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u0002J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0002J\u000e\u0010H\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0002J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\u0002J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010L\u001a\u00020KJ\u0010\u0010P\u001a\u00020\u00002\b\u0010O\u001a\u0004\u0018\u00010NJ\u0010\u0010R\u001a\u00020\u00002\b\u0010O\u001a\u0004\u0018\u00010QJ\u000e\u0010T\u001a\u00020\u00002\u0006\u0010S\u001a\u000200J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010U\u001a\u000200J\u000e\u0010X\u001a\u00020\u00002\u0006\u0010W\u001a\u000200J\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010Y\u001a\u000200J\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010[\u001a\u00020\u0014J\u000e\u0010^\u001a\u00020\u00002\u0006\u0010]\u001a\u00020\u0014J0\u0010d\u001a\u00020\u00002\b\u0010_\u001a\u0004\u0018\u00010\u00172\u0006\u0010`\u001a\u00020\u00142\u0006\u0010a\u001a\u00020\u00142\u0006\u0010b\u001a\u00020\u00142\u0006\u0010c\u001a\u00020\u000bJ\u0006\u0010f\u001a\u00020eR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010gR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010hR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010iR\u0018\u0010j\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010iR\u0018\u0010k\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010iR\u0018\u0010o\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010iR\u0018\u0010p\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010iR\u0018\u0010q\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010iR\u0018\u0010*\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010iR\u0018\u0010,\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010iR\u0018\u0010.\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010iR\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010gR\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010gR\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010gR\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010gR\u0018\u0010;\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010iR\u0018\u0010=\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010iR\u0016\u0010?\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010gR\u0016\u0010A\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010gR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010rR\u0016\u0010s\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010u\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010w\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010S\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010tR\u0016\u0010U\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010tR\u0016\u0010W\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010tR\u0016\u0010C\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010gR\u0016\u0010E\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010gR\u0016\u0010G\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010gR\u0016\u0010I\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010gR\u0016\u0010]\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010hR\u0018\u0010_\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010iR\u0016\u0010b\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010hR\u0016\u0010c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010yR\u0016\u0010`\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010hR\u0016\u0010a\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010hR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010gR\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010gR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010gR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010gR\u0016\u0010Y\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010tR\u0016\u0010[\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010hR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010yR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010gR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010y¨\u0006~"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedsHomePageConfigBuilder;", "", "", "enableFeedBtmComment", "withFeedBtmComment", "decodeByOpenAid", "withDecodeByOpenAid", "ignoreOnBackTest", "withIgnoreOnBackTest", "ignoreUserPauseOrPlay", "withIgnoreUserPauseOrPlay", "", "clickFeedTimeStamp", "withClickFeedTimeStamp", "enableRecFeedSkeletonLoading", "withEnableRecFeedSkeletonLoading", "startPlayPosition", "withStartPlayPosition", "fullScreen", "withFullScreen", "", "bottomMarginPxIfNotFullScreen", "withBottomMarginPxIfNotFullScreen", "", "enterFrom", "withEnterFrom", "topAid", "withEnterAid", "requestId", "withEnterRequestId", "topAids", "withEnterAids", "topOpenAid", "withEnterOpenAid", "topOpenAids", "withEnterOpenAids", "hostGid", "withEnterHostGid", "hostGids", "withEnterHostGids", "enterHostlocalParams", "withEnterHostlocalParams", "enterHostClientParams", "withEnterHostClientParams", "enterHostVideoSequence", "withEnterHostVideoSequence", "contentScene", "withContentScene", "Lorg/json/JSONObject;", "extraEvent", "withExtraEventParams", d.f25927q, "withShowBackButton", "showComment", "withShowComment", "showCollect", "withShowCollect", "ignorePageStatusControl", "withIgnorePageStatusControl", "liveRoomId", "withEnterLiveRoomId", "previousPage", "withPreviousPage", "uselessFollowChannel", "withUselessFollowChannel", "showSeriesChannel", "withShowSeriesChannel", "shouldPaddingStatusBarHeight", "withShouldPaddingStatusBarHeight", "needRefresh", "withNeedRefresh", "needLoadMore", "withNeedLoadMore", "needCustomLoadMore", "withNeedCustomLoadMore", "Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;", "seriesConfig", "withSeriesConfig", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "followExtra", "withFeedFollowExtra", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "withProfileFollowExtra", "hostCommonParams", "withHostCommonParams", "hostExtraParams", "withHostExtraParams", "ecEntranceInfo", "withEcEntranceInfo", "ecDetailParams", "withEcDetailParams", "bottomTabBarHeight", "withBottomTabBarHeight", "commentBottomMargin", "withCommentBottomMargin", "hostCoverUrl", "hostCoverWidth", "hostCoverHeight", "excludedHeight", "doubleBallLoadingDelay", "withHostCoverUrl", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedsHomePageConfig;", "build", "Z", "I", "Ljava/lang/String;", "enterAid", "enterRequestId", "enterAids", "enterOpenAid", "enterOpenAids", "enterHostGid", "enterHostGids", "enterHostLocalParams", "Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;", "extraEventParams", "Lorg/json/JSONObject;", "feedFollowExtra", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "profileFollowExtra", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "J", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class FeedsHomePageConfigBuilder {
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
    private JSONObject hostCommonParams;
    private int hostCoverHeight;
    private String hostCoverUrl;
    private int hostCoverWidth;
    private JSONObject hostExtraParams;
    private boolean ignoreOnBackTest;
    private boolean ignorePageStatusControl;
    private boolean ignoreUserPauseOrPlay;
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

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public /* synthetic */ FeedsHomePageConfigBuilder(DefaultConstructorMarker r100) {
        this();
    }

    public final FeedsHomePageConfig build() {
        FeedsHomePageConfig r100 = new FeedsHomePageConfig();
        r100.setFullScreen(this.fullScreen);
        r100.setBottomMarginPxIfNotFullScreen(this.bottomMarginPxIfNotFullScreen);
        r100.setEnterFrom(this.enterFrom);
        r100.setEnterAid(this.enterAid);
        r100.setEnterRequestId(this.enterRequestId);
        r100.setEnterAids(this.enterAids);
        r100.setEnterOpenAid(this.enterOpenAid);
        r100.setEnterOpenAids(this.enterOpenAids);
        r100.setEnterHostGid(this.enterHostGid);
        r100.setEnterHostGids(this.enterHostGids);
        r100.setEnterHostLocalParams(this.enterHostLocalParams);
        r100.setEnterHostClientParams(this.enterHostClientParams);
        r100.setEnterHostVideoSequence(this.enterHostVideoSequence);
        r100.setContentScene(this.contentScene);
        r100.setShowBackButton(this.showBackButton);
        r100.setShowComment(this.showComment);
        r100.setShowCollect(this.showCollect);
        r100.setIgnorePageStatusControl(this.ignorePageStatusControl);
        r100.setLiveRoomId(this.liveRoomId);
        r100.setExtraEventParams(this.extraEventParams);
        r100.setFeedFollowExtra(this.feedFollowExtra);
        r100.setProfileFollowExtra(this.profileFollowExtra);
        r100.setPreviousPage(this.previousPage);
        r100.setUselessFollowChannel(this.uselessFollowChannel);
        r100.setShowSeriesChannel(this.showSeriesChannel);
        r100.setSeriesConfig(this.seriesConfig);
        r100.setHostCommonParams(this.hostCommonParams);
        r100.setHostExtraParams(this.hostExtraParams);
        r100.setNeedRefresh(this.needRefresh);
        r100.setNeedLoadMore(this.needLoadMore);
        r100.setNeedCustomLoadMore(this.needCustomLoadMore);
        r100.setShouldPaddingStatusBarHeight(this.shouldPaddingStatusBarHeight);
        r100.setCommentBottomMargin(this.commentBottomMargin);
        r100.setHostCoverUrl(this.hostCoverUrl);
        r100.setExcludedHeight(this.excludedHeight);
        r100.setDoubleBallLoadingDelay(this.doubleBallLoadingDelay);
        r100.setHostCoverWidth(this.hostCoverWidth);
        r100.setHostCoverHeight(this.hostCoverHeight);
        r100.setIgnoreUserPauseOrPlay(this.ignoreUserPauseOrPlay);
        r100.setEcDetailParams(this.ecDetailParams);
        r100.setClickFeedTimeStamp(this.clickFeedTimeStamp);
        r100.setEnableRecFeedSkeletonLoading(this.enableRecFeedSkeletonLoading);
        r100.setBottomTabBarHeight(this.bottomTabBarHeight);
        r100.setEcEntranceInfo(this.ecEntranceInfo);
        r100.setIgnoreOnBackTest(this.ignoreOnBackTest);
        r100.setDecodeByOpenAid(this.decodeByOpenAid);
        r100.setEnableFeedBtmComment(this.enableFeedBtmComment);
        r100.setStartPlayPosition(this.startPlayPosition);
        return r100;
    }

    private FeedsHomePageConfigBuilder() {
        this.fullScreen = true;
        this.bottomMarginPxIfNotFullScreen = MathKt.roundToInt(TypedValue.applyDimension(1, 34, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_pageconfig_feedhome_FeedsHomePageConfigBuilder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        this.showBackButton = true;
        this.showComment = true;
        this.showCollect = true;
        this.extraEventParams = new JSONObject();
        this.hostCommonParams = new JSONObject();
        this.hostExtraParams = new JSONObject();
        this.ecEntranceInfo = new JSONObject();
        this.shouldPaddingStatusBarHeight = true;
        this.needRefresh = true;
        this.needLoadMore = true;
        this.ignoreUserPauseOrPlay = true;
        this.ecDetailParams = new JSONObject();
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_pageconfig_feedhome_FeedsHomePageConfigBuilder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final FeedsHomePageConfigBuilder withBottomMarginPxIfNotFullScreen(int r100) {
        this.bottomMarginPxIfNotFullScreen = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withBottomTabBarHeight(int r100) {
        this.bottomTabBarHeight = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withClickFeedTimeStamp(long r100) {
        this.clickFeedTimeStamp = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withCommentBottomMargin(int r100) {
        this.commentBottomMargin = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withContentScene(String r100) {
        this.contentScene = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withDecodeByOpenAid(boolean r100) {
        this.decodeByOpenAid = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEcDetailParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "ecDetailParams");
        this.ecDetailParams = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEcEntranceInfo(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "ecEntranceInfo");
        this.ecEntranceInfo = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnableRecFeedSkeletonLoading(boolean r100) {
        this.enableRecFeedSkeletonLoading = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnterAid(String r100) {
        this.enterAid = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnterAids(String r100) {
        this.enterAids = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnterFrom(String r100) {
        this.enterFrom = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnterHostClientParams(String r100) {
        this.enterHostClientParams = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnterHostGid(String r100) {
        this.enterHostGid = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnterHostGids(String r100) {
        this.enterHostGids = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnterHostVideoSequence(String r100) {
        this.enterHostVideoSequence = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnterHostlocalParams(String r100) {
        this.enterHostLocalParams = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnterLiveRoomId(String r100) {
        this.liveRoomId = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnterOpenAid(String r100) {
        this.enterOpenAid = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnterOpenAids(String r100) {
        this.enterOpenAids = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withEnterRequestId(String r100) {
        this.enterRequestId = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withExtraEventParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "extraEvent");
        this.extraEventParams = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withFeedBtmComment(boolean r100) {
        this.enableFeedBtmComment = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withFeedFollowExtra(FeedFollowExtra r100) {
        this.feedFollowExtra = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withFullScreen(boolean r100) {
        this.fullScreen = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withHostCommonParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "hostCommonParams");
        this.hostCommonParams = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withHostExtraParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "hostExtraParams");
        this.hostExtraParams = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withIgnoreOnBackTest(boolean r100) {
        this.ignoreOnBackTest = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withIgnorePageStatusControl(boolean r100) {
        this.ignorePageStatusControl = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withIgnoreUserPauseOrPlay(boolean r100) {
        this.ignoreUserPauseOrPlay = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withNeedCustomLoadMore(boolean r100) {
        this.needCustomLoadMore = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withNeedLoadMore(boolean r100) {
        this.needLoadMore = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withNeedRefresh(boolean r100) {
        this.needRefresh = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withPreviousPage(String r100) {
        this.previousPage = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withProfileFollowExtra(ProfileFollowExtra r100) {
        this.profileFollowExtra = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withSeriesConfig(SeriesHomePageConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "seriesConfig");
        this.seriesConfig = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withShouldPaddingStatusBarHeight(boolean r100) {
        this.shouldPaddingStatusBarHeight = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withShowBackButton(boolean r100) {
        this.showBackButton = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withShowCollect(boolean r100) {
        this.showCollect = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withShowComment(boolean r100) {
        this.showComment = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withShowSeriesChannel(boolean r100) {
        this.showSeriesChannel = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withStartPlayPosition(long r100) {
        this.startPlayPosition = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withUselessFollowChannel(boolean r100) {
        this.uselessFollowChannel = r100;
        return this;
    }

    public final FeedsHomePageConfigBuilder withHostCoverUrl(String r100, int r101, int r102, int r103, long r104) {
        this.hostCoverUrl = r100;
        this.hostCoverWidth = r101;
        this.hostCoverHeight = r102;
        this.excludedHeight = r103;
        this.doubleBallLoadingDelay = r104;
        return this;
    }
}
