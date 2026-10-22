package com.bytedance.awemeopen.apps.framework.feed.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.awemeopen.apps.framework.comment.write.WriteCommentEntranceView;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentCommonDataViewModel;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosRecomendFeedViewModel;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.SlideEventReportHelper;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.FeedDrawAdViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.player.AutoPlayHelper;
import com.bytedance.awemeopen.apps.framework.player.VideoPreRenderHelper;
import com.bytedance.awemeopen.bizmodels.ad.CsjAdScene;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.servicesapi.livepreview.AoLiveService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00010\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001OB\u000f\u0012\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bM\u0010NJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0013\u001a\u0004\b2\u00103R*\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R%\u0010B\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\t0=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006P"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosRecommendFeedLayout;", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosFeedPagerListLayout;", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/AosRecomendFeedViewModel;", "", "getCurrentEnterFrom", "", "getWriteCommentHeight", "", "scrollable", "", "setCanScroll2Profile", "debug", "setDebug", "multiTab", "setMultiTab", "Lb54/a;", "getSwipeChangeListener", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;", "U", "Lkotlin/Lazy;", "getFeedSeekBarHelper", "()Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;", "feedSeekBarHelper", "Lcom/bytedance/awemeopen/apps/framework/player/VideoPreRenderHelper;", "V", "getVideoPreRenderHelper", "()Lcom/bytedance/awemeopen/apps/framework/player/VideoPreRenderHelper;", "videoPreRenderHelper", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/helper/SlideEventReportHelper;", "W", "getVideoSlideEventReportHelper", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/helper/SlideEventReportHelper;", "videoSlideEventReportHelper", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/helper/e;", "k0", "getContentShowReportHelper", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/helper/e;", "contentShowReportHelper", "Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;", "p0", "getAutoPlayHelper", "()Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;", "autoPlayHelper", "Lvz3/c;", "H0", "getFeedPageConfig", "()Lvz3/c;", "feedPageConfig", "com/bytedance/awemeopen/apps/framework/feed/layout/AosRecommendFeedLayout$liveStatusDetectScheduler$2$a", "L0", "getLiveStatusDetectScheduler", "()Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosRecommendFeedLayout$liveStatusDetectScheduler$2$a;", "liveStatusDetectScheduler", "Landroidx/lifecycle/Observer;", "p1", "Landroidx/lifecycle/Observer;", "getEnterPinchObserver", "()Landroidx/lifecycle/Observer;", "setEnterPinchObserver", "(Landroidx/lifecycle/Observer;)V", "enterPinchObserver", "Lkotlin/Function1;", "v1", "Lkotlin/jvm/functions/Function1;", "getAction", "()Lkotlin/jvm/functions/Function1;", "action", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/r;", "L1", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/r;", "getRecommendFeedListener", "()Lcom/bytedance/awemeopen/apps/framework/feed/layout/r;", "setRecommendFeedListener", "(Lcom/bytedance/awemeopen/apps/framework/feed/layout/r;)V", "recommendFeedListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class AosRecommendFeedLayout extends AosFeedPagerListLayout<AosRecomendFeedViewModel> {
    public static final /* synthetic */ int S1 = 0;
    public final Function0<Unit> G1;
    public final Lazy H0;
    public final Function0<Unit> H1;
    public final Lazy L0;
    public r L1;
    public boolean M1;
    public final boolean P;
    public final m P0;
    public boolean P1;
    public final String Q;
    public WriteCommentEntranceView Q1;
    public boolean R;
    public boolean S;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.m T;
    public final Lazy U;
    public final Lazy V;
    public final Function2<String, String, Unit> V0;
    public final Lazy W;
    public int b1;
    public final n g1;
    public final o h1;
    public final Lazy k0;
    public boolean k1;
    public final Lazy p0;
    public Observer<Boolean> p1;
    public final Function1<String, Unit> v1;
    public final Function0<Unit> x1;
    public final Function2<String, Map<String, String>, Unit> y1;

    public static final class a {
    }

    public static final class b implements FeedSeekBarHelper.b {
        public b() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper.b
        public final void a() {
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper.b
        public final void b() {
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
        }
    }

    static {
    }

    private final String getCurrentEnterFrom() {
        return "homepage_hot";
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void J() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void K() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void O() {
        boolean r0 = true;
        this.R = true;
        r r1 = this.L1;
        if (r1 == null) goto L5;
        r0 = r1.e();
    L5:
        this.S = r0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final boolean l() {
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final Class<AosRecomendFeedViewModel> m() {
        return AosRecomendFeedViewModel.class;
    }

    private final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.e getContentShowReportHelper() {
        return (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.e) this.k0.getValue();
    }

    private final vz3.c getFeedPageConfig() {
        return (vz3.c) this.H0.getValue();
    }

    private final FeedSeekBarHelper getFeedSeekBarHelper() {
        return (FeedSeekBarHelper) this.U.getValue();
    }

    private final AosRecommendFeedLayout$liveStatusDetectScheduler$2.a getLiveStatusDetectScheduler() {
        return (AosRecommendFeedLayout$liveStatusDetectScheduler$2.a) this.L0.getValue();
    }

    private final VideoPreRenderHelper getVideoPreRenderHelper() {
        return (VideoPreRenderHelper) this.V.getValue();
    }

    private final SlideEventReportHelper getVideoSlideEventReportHelper() {
        return (SlideEventReportHelper) this.W.getValue();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void C() {
        d14.a r0 = b14.a.a;
        b14.a.a(l24.a.class).O0(getContext(), this.Q, CsjAdScene.FIT_CONTAINER_FEED, getLayoutRootView().getWidth(), getLayoutRootView().getHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d0() {
        if (com.bytedance.awemeopen.apps.framework.card.d.a == true) goto L5;
        return;
    L5:
        ((AosRecomendFeedViewModel) getVm()).setWaitToConsumeEnterAid(com.bytedance.awemeopen.apps.framework.card.d.b);
        ((AosRecomendFeedViewModel) getVm()).getPageConfig().setPreviousPage(com.bytedance.awemeopen.apps.framework.card.d.c);
        boolean r0 = false;
        com.bytedance.awemeopen.apps.framework.card.d.a = false;
        com.bytedance.awemeopen.apps.framework.card.d.b = "";
        com.bytedance.awemeopen.apps.framework.card.d.c = "";
        String r1 = ((AosRecomendFeedViewModel) getVm()).getWaitToConsumeEnterAid();
        if (r1 != null) goto L8;
    L9:
        r0 = true;
    L10:
        if (r0 == true) goto L67;
        ListState r2 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        ListState.State r3 = null;
        if (r2 == null) goto L14;
        ListState.State r4 = r2.c;
    L16:
        if (r4 == ListState.State.NEW) goto L68;
        ListState r5 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r5 == null) goto L20;
        ListState.State r6 = r5.c;
    L22:
        if (r6 == ListState.State.REQUEST_LAUNCH_CONFIG) goto L69;
        ListState r7 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r7 == null) goto L26;
        ListState.State r8 = r7.c;
    L28:
        if (r8 == ListState.State.REQUEST_LAUNCH_CONFIG_SUCCESS) goto L70;
        ListState r9 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r9 == null) goto L32;
        ListState.State r10 = r9.c;
    L34:
        if (r10 == ListState.State.REQUEST_LAUNCH_CONFIG_FAIL) goto L71;
        ListState r11 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r11 == null) goto L38;
        ListState.State r12 = r11.c;
    L40:
        if (r12 == ListState.State.INITIAL_LOAD) goto L72;
        ListState r13 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r13 == null) goto L44;
        ListState.State r14 = r13.c;
    L46:
        if (r14 == ListState.State.START_REFRESH) goto L73;
        ListState r15 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r15 == null) goto L50;
        ListState.State r16 = r15.c;
    L52:
        if (r16 == ListState.State.START_LOAD_MORE) goto L74;
        ListState r17 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r17 == null) goto L56;
        ListState.State r18 = r17.c;
    L58:
        if (r18 == ListState.State.START_LOAD_FORWARD) goto L75;
        ListState r19 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r19 == null) goto L63;
        r3 = r19.c;
    L63:
        if (r3 != ListState.State.INITIAL_FAIL) goto L65;
        ((AosRecomendFeedViewModel) getVm()).retry();
        return;
    L65:
        onRefresh();
        return;
    L75:
        return;
    L56:
        r18 = null;
        goto L58
    L74:
        return;
    L50:
        r16 = null;
        goto L52
    L73:
        return;
    L44:
        r14 = null;
        goto L46
    L72:
        return;
    L38:
        r12 = null;
        goto L40
    L71:
        return;
    L32:
        r10 = null;
        goto L34
    L70:
        return;
    L26:
        r8 = null;
        goto L28
    L69:
        return;
    L20:
        r6 = null;
        goto L22
    L68:
        return;
    L14:
        r4 = null;
        goto L16
    L67:
        return;
    L8:
        if (r1.length() != 0) goto L10;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f0() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("enter_from", ((AosRecomendFeedViewModel) getVm()).sceneId());
        ListState r1 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        int r2 = 0;
        if (r1 == null) goto L16;
        List r3 = (List) r1.a;
        if (r3 == null) goto L16;
        int r4 = r3.size();
        int r5 = 0;
    L7:
        if (r2 >= r4) goto L12;
        if (((jz3.a) ListProtector.get(r3, r2)).e == false) goto L11;
        r5 = r5 + 1;
    L11:
        r2 = r2 + 1;
        goto L7
    L12:
        d14.a r6 = b14.a.a;
        if (b14.a.a(x24.a.class).W(getAweme()) == false) goto L15;
        r5 = r5 + 1;
    L15:
        r2 = r5;
    L16:
        r0.put("vv_num", Integer.valueOf(r2 - com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.q.b));
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.q.b = r2;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.q.a(r0);
    }

    public final AutoPlayHelper getAutoPlayHelper() {
        return (AutoPlayHelper) this.p0.getValue();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final List<Integer> v() {
        AoLiveService r0 = AoLive.a;
        if (r0 == null) goto L5;
        boolean r1 = r0.E1();
    L7:
        if (r1 == true) goto L14;
        if (r1 == true) goto L13;
        return CollectionsKt.mutableListOf(new Integer[]{2, 5});
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        return CollectionsKt.mutableListOf(new Integer[]{5});
    L5:
        r1 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getWriteCommentHeight() {
        if (((AosRecomendFeedViewModel) getVm()).getEnableBtmComment() == false) goto L6;
        Resources r1 = Resources.getSystem();
        return MathKt.roundToInt(TypedValue.applyDimension(1, 56, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
    L6:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final boolean A() {
        return ((AosRecomendFeedViewModel) getVm()).getPageConfig().getNeedRefresh();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void G() {
        super.G();
        if (this.P1 == true) goto L5;
        return;
    L5:
        if (getFeedSeekBarHelper().c() == true) goto L9;
        getFeedSeekBarHelper().a();
        this.P1 = false;
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void H() {
        super.H();
        if (this.P1 == false) goto L5;
        return;
    L5:
        if (getFeedSeekBarHelper().c() == false) goto L9;
        this.P1 = true;
        getFeedSeekBarHelper().b();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void e() {
        super.e();
        getLayoutRootView().post(new i(this));
        d14.a r0 = b14.a.a;
        b14.a.a(c34.a.class).i();
        ((AosRecomendFeedViewModel) getVm()).getFeedPlayerHelper().c(com.bytedance.awemeopen.apps.framework.player.d.a);
        ((AosRecomendFeedViewModel) getVm()).getFeedPlayerHelper().c(getVideoPreRenderHelper());
        com.bytedance.awemeopen.apps.framework.player.d.a(this.Q, ((AosRecomendFeedViewModel) getVm()).getFeedPlayerHelper());
        w24.d r1 = b14.a.a(w24.d.class);
        r1.j1((Function1) c04.h.a(this.v1));
        r1.n((Function0) c04.h.a(this.x1));
        r1.S2((Function0) c04.h.a(this.G1));
        r1.I0((Function0) c04.h.a(this.H1));
        r1.o3((Function2) c04.h.a(this.y1));
        if (((AosRecomendFeedViewModel) getVm()).getEnableBtmComment() == false) goto L9;
        WriteCommentEntranceView r2 = new WriteCommentEntranceView(this, new q(this));
        this.Q1 = r2;
        r2.d();
        WriteCommentEntranceView r3 = this.Q1;
        if (r3 == null) goto L7;
        Context r4 = getContext();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        r3.f(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b((Activity) r4, this, getViewPager(), this, this, null, 0, 224), true);
    L7:
        post(new p(this));
        ViewGroup.LayoutParams r5 = getRefreshLayout().getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        Resources r7 = Resources.getSystem();
        r6.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 56, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics())));
        getRefreshLayout().setLayoutParams(r6);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final boolean g() {
        if (W() == false) goto L5;
        return true;
    L5:
        int r0 = ((AosRecomendFeedViewModel) getVm()).getCurrentIndex() + 1;
        ListState r2 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r2 == null) goto L10;
        List r3 = (List) r2.a;
        if (r3 == null) goto L10;
        jz3.a r4 = (jz3.a) CollectionsKt.getOrNull(r3, r0);
    L11:
        if (r4 == null) goto L14;
        r4.g = true;
    L14:
        getViewPager().y(r0, true);
        zx3.a.c(getContext(), 2131894448).d();
        d14.a r1 = b14.a.a;
        b14.a.a(t24.a.class).t1(getCurrentEnterFrom());
        return true;
    L10:
        r4 = null;
        goto L11
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public b54.a getSwipeChangeListener() {
        k54.c r0 = getFeedPageListener();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void h() {
        super.h();
        boolean r0 = false;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.q.b = 0;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.q.a = -1;
        d14.a r1 = b14.a.a;
        t24.a r2 = b14.a.a(t24.a.class);
        r2.H1(this.g1);
        r2.H1(this.h1);
        r2.v0();
        getFeedSeekBarHelper().f();
        FeedSeekBarHelper r3 = getFeedSeekBarHelper();
        b r4 = new b();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "callback");
        r3.D = r4;
        VerticalViewPager r5 = getViewPager();
        r5.c(getFeedSeekBarHelper());
        r5.c(getVideoPreRenderHelper());
        r5.c(getVideoSlideEventReportHelper());
        r5.c(getAutoPlayHelper());
        ((AosRecomendFeedViewModel) getVm()).setFeedSeekBarHelper(getFeedSeekBarHelper());
        AosRecomendFeedViewModel r6 = (AosRecomendFeedViewModel) getVm();
        if (AosExtConfig.b.W1().a == true) goto L5;
    L7:
        r6.setEnableFollowChannel(r0);
        b14.a.a(k34.b.class).Q0(this.V0);
        r r7 = this.L1;
        if (r7 == null) goto L10;
        r7.onBind();
    L10:
        AosRecomendFeedViewModel r8 = (AosRecomendFeedViewModel) getVm();
        AutoPlayHelper r9 = getAutoPlayHelper();
        r9.e.observe(this, this.P0);
        r8.setAutoPlayHelper(r9);
        if (((AosRecomendFeedViewModel) getVm()).getPageConfig().getShouldPaddingStatusBarHeight() == true) goto L27;
        Context r10 = getContext();
        ViewGroup.MarginLayoutParams r11 = null;
        if ((r10 instanceof Activity) == false) goto L15;
        Activity r12 = (Activity) r10;
    L17:
        if (w04.a.b(r12) == false) goto L27;
        RelativeLayout r13 = (RelativeLayout) getRootView().findViewById(2131372214);
        if (r13 == null) goto L27;
        int r14 = z04.c.a(r13.getContext());
        ViewGroup.LayoutParams r15 = r13.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        r11 = (ViewGroup.MarginLayoutParams) r15;
    L23:
        if (r11 == null) goto L26;
        r11.topMargin = r14;
    L26:
        r13.requestLayout();
        goto L27
    L15:
        r12 = null;
    L27:
        ((AosRecomendFeedViewModel) getVm()).getEnterCleanMode().observe(this, new j(this));
        ((AosRecomendFeedViewModel) getVm()).getEnterSkeleton().observe(this, new k(this));
        Observer<Boolean> r16 = new l(this);
        this.p1 = r16;
        ((AosRecomendFeedViewModel) getVm()).getEnterPinchMode().observe(this, r16);
        return;
    L5:
        if (((AosRecomendFeedViewModel) getVm()).getPageConfig().getUselessFollowChannel() == true) goto L7;
        r0 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void i() {
        super.i();
        Observer<Boolean> r0 = this.p1;
        if (r0 == null) goto L7;
        DiscardFirstValueLiveData<Boolean> r1 = ((AosRecomendFeedViewModel) getVm()).getEnterPinchMode();
        if (r1 == null) goto L7;
        r1.removeObserver(r0);
    L7:
        VerticalViewPager r2 = getViewPager();
        r2.v(getFeedSeekBarHelper());
        r2.v(getVideoPreRenderHelper());
        r2.v(getVideoSlideEventReportHelper());
        r2.v(getAutoPlayHelper());
        AutoPlayHelper r3 = ((AosRecomendFeedViewModel) getVm()).getAutoPlayHelper();
        if (r3 == null) goto L12;
        MutableLiveData<Integer> r4 = r3.e;
        if (r4 == null) goto L12;
        r4.removeObserver(this.P0);
    L12:
        AutoPlayHelper r5 = ((AosRecomendFeedViewModel) getVm()).getAutoPlayHelper();
        if (r5 == null) goto L15;
        r5.b();
    L15:
        d14.a r6 = b14.a.a;
        b14.a.a(k34.b.class).I1(this.V0);
        r r7 = this.L1;
        if (r7 == null) goto L18;
        r7.c();
    L18:
        t24.a r8 = b14.a.a(t24.a.class);
        r8.z0(this.g1);
        r8.z0(this.h1);
        ((AosRecomendFeedViewModel) getVm()).getEnterCleanMode().removeObservers(this);
        ((AosRecomendFeedViewModel) getVm()).getEnterSkeleton().removeObservers(this);
        ((AosRecomendFeedViewModel) getVm()).getEnterPinchMode().removeObservers(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void j() {
        super.j();
        ((AosRecomendFeedViewModel) getVm()).setPageKey(this.Q);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onDestroy() {
        super.onDestroy();
        ((AosRecomendFeedViewModel) getVm()).getFeedPlayerHelper().g(com.bytedance.awemeopen.apps.framework.player.d.a);
        com.bytedance.awemeopen.apps.framework.player.d.b(this.Q);
        getFeedSeekBarHelper().g();
        VideoPreRenderHelper r0 = getVideoPreRenderHelper();
        ((AosRecomendFeedViewModel) getVm()).getFeedPlayerHelper().g(r0);
        r0.c.clear();
        ListState r1 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        int r2 = 0;
        if (r1 == null) goto L16;
        List r3 = (List) r1.a;
        if (r3 == null) goto L16;
        int r4 = r3.size();
        int r5 = 0;
    L7:
        if (r2 >= r4) goto L15;
        if (r2 > AosExtConfig.b.n1().b()) goto L15;
        if (((jz3.a) ListProtector.get(r3, r2)).a.t == false) goto L14;
        r5 = r5 + 1;
    L14:
        r2 = r2 + 1;
    L15:
        int r9 = r5;
    L17:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.m r6 = this.T;
        Context r7 = getContext();
        String r8 = ((AosRecomendFeedViewModel) getVm()).sceneId();
        String r10 = ((AosRecomendFeedViewModel) getVm()).getPageConfig().getEnterAid();
        r14.c r11 = getAweme();
        if (r11 == null) goto L20;
        String r12 = r11.c();
    L22:
        if (Intrinsics.areEqual(r10, r12) == false) goto L24;
        String r13 = ((AosRecomendFeedViewModel) getVm()).getPageConfig().getEnterHostGid();
    L25:
        r6.a(r7, r8, r13, getAweme(), r9);
        ((c14.a) getLiveStatusDetectScheduler()).b.removeMessages(1);
        ((AosRecomendFeedViewModel) getVm()).onDestroy();
        return;
    L24:
        r13 = "";
        goto L25
    L20:
        r12 = null;
    L16:
        r9 = 0;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onPause() {
        super.onPause();
        getVideoPreRenderHelper().b = false;
        if (o() == false) goto L6;
        ((AosRecomendFeedViewModel) getVm()).setFeedVisible(false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onResume() {
        super.onResume();
        int r0 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.q.b;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.q.a = SystemClock.elapsedRealtime();
        getVideoPreRenderHelper().b = true;
        getLiveStatusDetectScheduler().b(true);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.e r1 = getContentShowReportHelper();
        r1.getClass();
        Intrinsics.checkNotNullParameter("homepage_hot", "enterFrom");
        if (r1.a == true) goto L6;
        r1.a = true;
        d14.a r2 = b14.a.a;
        b14.a.a(t24.a.class).H0();
    L6:
        if (o() == false) goto L9;
        ((AosRecomendFeedViewModel) getVm()).setFeedVisible(true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onStart() {
        super.onStart();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.m r0 = this.T;
        AoLogger.b(r0.a, new Object[]{"onPageShow"});
        r0.d = System.currentTimeMillis();
        ((AosRecomendFeedViewModel) getVm()).updatePalpableIndex(((AosRecomendFeedViewModel) getVm()).getCurrentIndex(), true);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onStop() {
        super.onStop();
        d14.a r0 = b14.a.a;
        if (b14.a.a(t24.a.class).g3() == false) goto L6;
        f0();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final boolean z() {
        return ((AosRecomendFeedViewModel) getVm()).getPageConfig().getNeedLoadMore();
    }

    public final Function1<String, Unit> getAction() {
        return this.v1;
    }

    public final Observer<Boolean> getEnterPinchObserver() {
        return this.p1;
    }

    public final r getRecommendFeedListener() {
        return this.L1;
    }

    /* JADX WARN: Type inference failed for: r4v14, types: [com.bytedance.awemeopen.apps.framework.feed.layout.m] */
    /* JADX WARN: Type inference failed for: r4v16, types: [com.bytedance.awemeopen.apps.framework.feed.layout.n] */
    /* JADX WARN: Type inference failed for: r4v17, types: [com.bytedance.awemeopen.apps.framework.feed.layout.o] */
    public AosRecommendFeedLayout(final Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        new LinkedHashMap();
        super(r4);
        this.P = AosExtConfig.b.m0();
        this.Q = "AosRecommendFeedFragment_" + System.currentTimeMillis() + '_' + hashCode();
        this.S = true;
        this.T = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.m();
        this.U = LazyKt.lazy(new AosRecommendFeedLayout$feedSeekBarHelper$2(r4, this));
        this.V = LazyKt.lazy(new AosRecommendFeedLayout$videoPreRenderHelper$2(this));
        this.W = LazyKt.lazy(new AosRecommendFeedLayout$videoSlideEventReportHelper$2(this));
        this.k0 = LazyKt.lazy(AosRecommendFeedLayout$contentShowReportHelper$2.INSTANCE);
        this.p0 = LazyKt.lazy(new AosRecommendFeedLayout$autoPlayHelper$2(this));
        this.H0 = LazyKt.lazy(AosRecommendFeedLayout$feedPageConfig$2.INSTANCE);
        this.L0 = LazyKt.lazy(new AosRecommendFeedLayout$liveStatusDetectScheduler$2(this));
        this.P0 = new m(this);
        this.V0 = new AosRecommendFeedLayout$userChangeListener$1(this);
        this.g1 = new n(this);
        this.h1 = new o(this);
        this.v1 = new AosRecommendFeedLayout$action$1(this);
        this.x1 = new AosRecommendFeedLayout$dislikeAction$1(this);
        this.y1 = AosRecommendFeedLayout$eventReportAction$1.INSTANCE;
        this.G1 = new AosRecommendFeedLayout$openSlideAction$1(this);
        this.H1 = new AosRecommendFeedLayout$closeSlideProfileAction$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b0(AosRecommendFeedLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        if (r5.getContext() == null) goto L7;
        FeedSeekBarHelper r0 = r5.getFeedSeekBarHelper();
        View r1 = r5.getLayoutRootView();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        int r2 = vz3.b.a;
        Context r3 = r5.getContext();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        r0.i((ViewGroup) r1, vz3.b.a((Activity) r3, ((AosRecomendFeedViewModel) r5.getVm()).getEnableBtmComment(), ((AosRecomendFeedViewModel) r5.getVm()).getPageConfig().getFullScreen(), ((AosRecomendFeedViewModel) r5.getVm()).getPageConfig().getBottomMarginPxIfNotFullScreen()));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void L(int r21) {
        boolean r2 = true;
        if (((AosRecomendFeedViewModel) getVm()).isNoAction() == false) goto L5;
        AosRecomendFeedViewModel r1 = (AosRecomendFeedViewModel) getVm();
        r1.setNoActionAccount(r1.getNoActionAccount() + 1);
    L6:
        ((AosRecomendFeedViewModel) getVm()).setNoAction(true);
        Integer r3 = (Integer) ((AosRecomendFeedViewModel) getVm()).getSelectedIndex().getValue();
        if (r3 != null) goto L10;
        r3 = 0;
    L10:
        if (r21 > r3.intValue()) goto L13;
        r2 = false;
    L13:
        ListState r4 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        jz3.a r5 = null;
        if (r4 == null) goto L20;
        List r6 = (List) r4.a;
        if (r6 == null) goto L20;
        jz3.a r7 = (jz3.a) CollectionsKt.getOrNull(r6, r21);
        if (r7 == null) goto L20;
        r14.c r8 = r7.a;
    L21:
        AosEventReporter r9 = AosEventReporter.a;
        String r10 = ((AosRecomendFeedViewModel) getVm()).sceneId();
        FeedPageConfig r11 = ((AosRecomendFeedViewModel) getVm()).getPageConfig();
        ListState r12 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r12 == null) goto L26;
        List r13 = (List) r12.a;
        if (r13 == null) goto L26;
        r5 = (jz3.a) CollectionsKt.getOrNull(r13, r21);
    L26:
        boolean r15 = getAutoPlayHelper().b.getAutoPlayState();
        int r16 = ((AosRecomendFeedViewModel) getVm()).getNoActionAccount();
        if (r8 == null) goto L29;
        boolean r17 = r8.t;
    L30:
        if (r2 == false) goto L32;
        String r0 = "up";
    L33:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r11, "pageConfig");
        Intrinsics.checkNotNullParameter(r0, "slideMode");
        if (r5 == null) goto L61;
        r14.c r14 = r5.a;
        if (r14 == null) goto L62;
        d14.a r18 = b14.a.a;
        t24.a r19 = b14.a.a(t24.a.class);
        if (r10 != null) goto L40;
        String r20 = "";
    L41:
        User r22 = r14.f();
        if (r22 == null) goto L47;
        String r23 = r22.u();
        if (r23 == null) goto L47;
        String r110 = r23;
    L48:
        String r111 = r14.c();
        String r24 = AosEventReporter.b(r14, r11);
        if (r24 != null) goto L51;
        String r112 = "";
    L52:
        a0 r25 = r14.d;
        if (r25 == null) goto L58;
        String r26 = r25.a();
        if (r26 == null) goto L58;
        String r113 = r26;
    L59:
        r19.y0(r20, r110, r111, r112, r113, AosEventReporter.c(r5.a), r15, r16, r17, r0, null);
        return;
    L58:
        r113 = "";
        goto L59
    L51:
        r112 = r24;
    L47:
        r110 = "";
        goto L48
    L40:
        r20 = r10;
        goto L41
    L62:
        return;
    L61:
        return;
    L32:
        r0 = "down";
        goto L33
    L29:
        r17 = false;
    L20:
        r8 = null;
        goto L21
    L5:
        ((AosRecomendFeedViewModel) getVm()).setNoActionAccount(0);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void M(boolean r4) {
        super.M(r4);
        boolean r0 = false;
        this.R = false;
        if (((AosRecomendFeedViewModel) getVm()).getPageConfig().isTeenagerModel() == false) goto L5;
        boolean r1 = false;
    L6:
        r r2 = this.L1;
        if (r2 == null) goto L9;
        r2.j(r1);
    L9:
        if (r4 == true) goto L11;
        return;
    L11:
        if (((AosRecomendFeedViewModel) getVm()).getEnableBtmComment() == false) goto L26;
        WriteCommentEntranceView r5 = this.Q1;
        if (r5 == null) goto L27;
        ViewGroup r3 = r5.g;
        if (r3 != null) goto L17;
    L19:
        if (r0 == true) goto L29;
        ViewGroup r6 = r5.g;
        if (r6 == null) goto L28;
        x54.b.a(r6);
        return;
    L28:
        return;
    L29:
        return;
    L17:
        if (r3.getVisibility() != 8) goto L19;
        r0 = true;
        goto L19
    L27:
        return;
    L26:
        return;
    L5:
        r1 = this.S;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void c(boolean r3) {
        this.g = r3;
        if (o() == false) goto L5;
        ((AosRecomendFeedViewModel) getVm()).getFeedHomeContainerDeliverHiddenState().setValue(Boolean.valueOf(r3));
    L5:
        if (r3 == false) goto L7;
        f0();
        return;
    L7:
        int r4 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.q.b;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.q.a = SystemClock.elapsedRealtime();
        d0();
    }

    public final int c0(jz3.a r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        r14.c r0 = r3.a;
        if (r0.e == false) goto L9;
        if (r3.b == null) goto L9;
        return 5;
    L9:
        if (r0.a == false) goto L12;
        return -1;
    L12:
        Integer r1 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.b.c(r0);
        if (r1 != null) goto L17;
        int r2 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h.a;
        return com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h.c(r3.a);
    L17:
        return r1.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCanScroll2Profile(boolean r2) {
        if (((AosRecomendFeedViewModel) getVm()).getPageConfig().isTeenagerModel() == false) goto L6;
        r2 = false;
    L6:
        if (this.R == false) goto L8;
        this.S = r2;
        return;
    L8:
        r r0 = this.L1;
        if (r0 == null) goto L13;
        r0.i(r2);
        return;
    }

    public final void setDebug(boolean r1) {
        this.k1 = r1;
    }

    public final void setEnterPinchObserver(Observer<Boolean> r1) {
        this.p1 = r1;
    }

    public final void setMultiTab(boolean r1) {
        this.M1 = r1;
    }

    public final void setRecommendFeedListener(r r1) {
        this.L1 = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final int y(List<jz3.a> r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        String r1 = ((AosRecomendFeedViewModel) getVm()).getPageConfig().getEnterAid();
        boolean r2 = true;
        if (r1 != null) goto L5;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L22;
        String r4 = ((AosRecomendFeedViewModel) getVm()).getPageConfig().getEnterHostGid();
        if (r4 != null) goto L15;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == true) goto L22;
    L52:
        Intrinsics.checkNotNullParameter(r9, "data");
        return 0;
    L15:
        if (r4.length() <= 0) goto L17;
        boolean r6 = true;
    L18:
        if (r6 != true) goto L20;
        r5 = true;
        goto L21
    L17:
        r6 = false;
    L22:
        String r7 = ((AosRecomendFeedViewModel) getVm()).getPageConfig().getEnterHostVideoSequence();
        if (r7 != null) goto L25;
    L30:
        boolean r8 = false;
    L31:
        if (r8 == true) goto L42;
        String r10 = ((AosRecomendFeedViewModel) getVm()).getPageConfig().getEnterAids();
        if (r10 != null) goto L35;
    L40:
        r2 = false;
    L41:
        if (r2 == false) goto L52;
    L35:
        if (r10.length() <= 0) goto L37;
        boolean r11 = true;
    L38:
        if (r11 != true) goto L40;
    L37:
        r11 = false;
    L42:
        Iterator<jz3.a> r12 = r9.iterator();
        int r13 = 0;
    L44:
        if (r12.hasNext() == false) goto L52;
        int r14 = r13 + 1;
        jz3.a r15 = r12.next();
        if (Intrinsics.areEqual(r15.a.c(), ((AosRecomendFeedViewModel) getVm()).getPageConfig().getEnterAid()) == true) goto L51;
        if (Intrinsics.areEqual(r15.a.c(), ((AosRecomendFeedViewModel) getVm()).getPageConfig().getEnterHostGid()) == true) goto L51;
        r13 = r14;
    L51:
        return r13;
    L25:
        if (r7.length() <= 0) goto L27;
        boolean r16 = true;
    L28:
        if (r16 != true) goto L30;
        r8 = true;
        goto L31
    L27:
        r16 = false;
        goto L28
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r17 = true;
    L8:
        if (r17 != true) goto L10;
        r3 = true;
        goto L11
    L7:
        r17 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout
    public final void V(int r5, jz3.a r6) {
        Intrinsics.checkNotNullParameter(r6, "model");
        super.V(r5, r6);
        this.b1 = r5;
        int r7 = ((AosRecomendFeedViewModel) getVm()).getCurrentSelectedIndex();
        int r0 = ((AosRecomendFeedViewModel) getVm()).getLastSelectedIndex();
        k54.c r1 = getFeedPageListener();
        if (r1 == null) goto L20;
        if (r7 <= r0) goto L6;
        boolean r2 = true;
    L7:
        ListState r3 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r3 == null) goto L17;
        List r4 = (List) r3.a;
        if (r4 == null) goto L17;
        jz3.a r8 = (jz3.a) CollectionsKt.getOrNull(r4, r7);
        if (r8 == null) goto L17;
        r14.c r9 = r8.a;
        if (r9 == null) goto L17;
        String r10 = r9.c();
        if (r10 == null) goto L17;
    L18:
        r1.e(r2, r10, new k54.a(c0(r6), Integer.valueOf(r6.a.q())));
        return;
    L17:
        r10 = "";
        goto L18
    L6:
        r2 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout
    public final void a0(int r3, jz3.a r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        getFeedSeekBarHelper().j(r4.a);
        this.T.b(r4.a);
        com.bytedance.awemeopen.apps.framework.player.d r5 = com.bytedance.awemeopen.apps.framework.player.d.a;
        com.bytedance.awemeopen.apps.framework.player.d.i(this.Q, r4.a);
        boolean r0 = true;
        getLiveStatusDetectScheduler().b(true);
        if (((AosRecomendFeedViewModel) getVm()).getPageConfig().isTeenagerModel() == false) goto L6;
        setCanScroll2Profile(false);
    L6:
        if (((AosRecomendFeedViewModel) getVm()).getEnableBtmComment() == false) goto L56;
        CommentInputContentViewModel.Companion.getClass();
        CommentInputContentViewModel r6 = CommentInputContentViewModel.a.a(this);
        if (r6 == null) goto L10;
        r6.resetAweme(r4.a.c());
    L10:
        CommentCommonDataViewModel.Companion.getClass();
        CommentCommonDataViewModel r7 = CommentCommonDataViewModel.a.a(this);
        if (r7 == null) goto L14;
        r7.setCurrentAweme(getAweme());
    L14:
        WriteCommentEntranceView r8 = this.Q1;
        if (r8 == null) goto L18;
        r8.a = r4.a.c();
    L18:
        WriteCommentEntranceView r9 = this.Q1;
        if (r9 == null) goto L21;
        r9.e();
    L21:
        int r10 = c0(r4);
        if (r10 != 1) goto L24;
    L27:
        boolean r11 = true;
    L28:
        if (r11 == false) goto L42;
        WriteCommentEntranceView r12 = this.Q1;
        if (r12 == null) goto L57;
        ViewGroup r13 = r12.g;
        if (r13 != null) goto L34;
    L36:
        r0 = false;
    L37:
        if (r0 == true) goto L62;
        ViewGroup r14 = r12.g;
        if (r14 == null) goto L58;
        x54.b.d(r14);
        return;
    L58:
        return;
    L62:
        return;
    L34:
        if (r13.getVisibility() != 0) goto L36;
    L57:
        return;
    L42:
        WriteCommentEntranceView r15 = this.Q1;
        if (r15 == null) goto L60;
        ViewGroup r16 = r15.g;
        if (r16 != null) goto L47;
    L49:
        r0 = false;
    L50:
        if (r0 == true) goto L63;
        ViewGroup r17 = r15.g;
        if (r17 == null) goto L61;
        x54.b.a(r17);
        return;
    L61:
        return;
    L63:
        return;
    L47:
        if (r16.getVisibility() != 8) goto L49;
    L60:
        return;
    L24:
        if (r10 == 3) goto L27;
        r11 = false;
        goto L28
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final /* bridge */ /* synthetic */ int u(int r1, jz3.a r2) {
        return c0(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final /* bridge */ /* synthetic */ void w(int r1, jz3.a r2) {
        V(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void F(List<jz3.a> r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r7, "data");
        if (((AosRecomendFeedViewModel) getVm()).isEnableSkeletonLoading() == false) goto L31;
        ListState r10 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r10 == null) goto L15;
        List r11 = (List) r10.a;
        if (r11 == null) goto L15;
        jz3.a r12 = (jz3.a) CollectionsKt.getOrNull(r11, ((AosRecomendFeedViewModel) getVm()).getCurrentIndex());
        if (r12 == null) goto L15;
        r14.c r13 = r12.a;
        if (r13 == null) goto L15;
        if (r13.b != true) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == false) goto L31;
        ListState r15 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r15 == null) goto L24;
        List r16 = (List) r15.a;
        if (r16 == null) goto L24;
        jz3.a r17 = (jz3.a) CollectionsKt.getOrNull(r16, ((AosRecomendFeedViewModel) getVm()).getCurrentIndex());
        if (r17 == null) goto L24;
        r14.c r18 = r17.a;
    L25:
        if (r18 == null) goto L28;
        r18.b = false;
    L28:
        getViewPager().y(((AosRecomendFeedViewModel) getVm()).getCurrentIndex(), true);
        AosPagerListViewModel.updateCurrentIndex$default((AosPagerListViewModel) getVm(), ((AosRecomendFeedViewModel) getVm()).getCurrentIndex(), true, false, 4, null);
        return;
    L24:
        r18 = null;
    L15:
        r14 = false;
    L31:
        if (this.P == false) goto L43;
        if (r9 == false) goto L43;
        int r19 = ((AosRecomendFeedViewModel) getVm()).getCurrentIndex() + 1;
        ListState r20 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r20 == null) goto L57;
        List r21 = (List) r20.a;
        if (r21 != null) goto L38;
        return;
    L38:
        if (((jz3.a) CollectionsKt.getOrNull(r21, r19)) == null) goto L59;
        getViewPager().y(r19, true);
        return;
    L59:
        return;
    L57:
        return;
    L43:
        if (this.A == true) goto L45;
        return;
    L45:
        if (((AosRecomendFeedViewModel) getVm()).getFixInitEmptyNotPlay() == true) goto L47;
        return;
    L47:
        if (((AosRecomendFeedViewModel) getVm()).getCurrentIndex() != 0) goto L62;
        ListState r22 = (ListState) ((AosRecomendFeedViewModel) getVm()).getDataList().getValue();
        if (r22 == null) goto L53;
        List r23 = (List) r22.a;
        if (r23 == null) goto L53;
        int r24 = r23.size();
    L54:
        if (r24 <= 0) goto L63;
        setInitDataEmpty(false);
        getViewPager().y(0, true);
        AosPagerListViewModel.updateCurrentIndex$default((AosPagerListViewModel) getVm(), 0, true, false, 4, null);
        return;
    L63:
        return;
    L53:
        r24 = 0;
        goto L54
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void N(List<jz3.a> r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        super.N(r2, r3, r4);
        this.R = false;
        r r5 = this.L1;
        if (r5 == null) goto L6;
        r5.f(this.S);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> s(ViewGroup r18, int r19, jz3.a r20) {
        jz3.a r0 = r20;
        Intrinsics.checkNotNullParameter(r18, "parent");
        Intrinsics.checkNotNullParameter(r0, "data");
        if (r19 != 5) goto L6;
        Context r2 = r18.getContext();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.f r1 = r0.b;
        Intrinsics.checkNotNull(r1);
        return new FeedDrawAdViewHolder(r2, r1, (AosRecomendFeedViewModel) getVm());
    L6:
        if (r19 != (-1)) goto L8;
        int r3 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h.a;
        FeedPagerListViewModel r4 = (FeedPagerListViewModel) getVm();
        Intrinsics.checkNotNullParameter(r18, "parent");
        Intrinsics.checkNotNullParameter(r4, "vm");
        LayoutInflater r5 = LayoutInflater.from(r18.getContext());
        int r6 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.e.f;
        return new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.e(r5.inflate(2131558664, r18, false), r4);
    L8:
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("comment_bottom_margin", Integer.valueOf(((AosRecomendFeedViewModel) getVm()).getPageConfig().getCommentBottomMargin()));
        int r7 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.b.a;
        FeedPagerListViewModel r13 = (FeedPagerListViewModel) getVm();
        Context r8 = getContext();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.app.Activity");
        Activity r15 = (Activity) r8;
        Context r9 = getContext();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.app.Activity");
        com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> r10 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.b.b(r18, r19, r13, r15, new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b((Activity) r9, getLayoutRootView(), r18, this, this, this.M1, r12, getWriteCommentHeight()), getFeedSeekBarHelper(), getVideoPreRenderHelper(), getFeedPageConfig(), this.Q);
        if (r10 != null) goto L12;
        int r11 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h.a;
        FeedPagerListViewModel r14 = (FeedPagerListViewModel) getVm();
        Context r16 = getContext();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.app.Activity");
        Activity r17 = (Activity) r16;
        Context r21 = getContext();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type android.app.Activity");
        r10 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h.a(r18, r19, r14, r17, new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b((Activity) r21, getLayoutRootView(), r18, this, this, this.M1, r12, getWriteCommentHeight()), getFeedSeekBarHelper(), getVideoPreRenderHelper(), getFeedPageConfig(), this.k1);
    L12:
        return r10;
    }
}
