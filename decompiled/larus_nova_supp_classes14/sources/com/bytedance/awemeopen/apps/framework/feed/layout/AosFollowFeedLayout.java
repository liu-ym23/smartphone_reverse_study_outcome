package com.bytedance.awemeopen.apps.framework.feed.layout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.awemeopen.apps.framework.feed.home.AosHomeFeedActivity;
import com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosFollowFeedViewModel;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.SlideEventReportHelper;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.feed.widget.LiveSkyLightTouchLayout;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.player.AutoPlayHelper;
import com.bytedance.awemeopen.apps.framework.player.VideoPreRenderHelper;
import com.bytedance.awemeopen.bizmodels.ad.CsjAdScene;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.servicesapi.livepreview.AoLiveService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t*\u0001/\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001DJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0012\u001a\u0004\b1\u00102R*\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010C\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosFollowFeedLayout;", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosFeedPagerListLayout;", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/AosFollowFeedViewModel;", "Landroid/view/View$OnClickListener;", "", "scrollable", "", "setCanScroll2Profile", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/s;", "P", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/s;", "getIFeedsHomeLayout", "()Lcom/bytedance/awemeopen/apps/framework/feed/layout/s;", "setIFeedsHomeLayout", "(Lcom/bytedance/awemeopen/apps/framework/feed/layout/s;)V", "iFeedsHomeLayout", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;", "x1", "Lkotlin/Lazy;", "getFeedSeekBarHelper", "()Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;", "feedSeekBarHelper", "Lcom/bytedance/awemeopen/apps/framework/player/VideoPreRenderHelper;", "y1", "getVideoPreRenderHelper", "()Lcom/bytedance/awemeopen/apps/framework/player/VideoPreRenderHelper;", "videoPreRenderHelper", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/helper/SlideEventReportHelper;", "G1", "getVideoSlideEventReportHelper", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/helper/SlideEventReportHelper;", "videoSlideEventReportHelper", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/helper/e;", "H1", "getContentShowReportHelper", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/helper/e;", "contentShowReportHelper", "Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;", "L1", "getAutoPlayHelper", "()Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;", "autoPlayHelper", "Lvz3/c;", "M1", "getFeedPageConfig", "()Lvz3/c;", "feedPageConfig", "com/bytedance/awemeopen/apps/framework/feed/layout/AosFollowFeedLayout$liveStatusDetectScheduler$2$a", "P1", "getLiveStatusDetectScheduler", "()Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosFollowFeedLayout$liveStatusDetectScheduler$2$a;", "liveStatusDetectScheduler", "Landroidx/lifecycle/Observer;", "V1", "Landroidx/lifecycle/Observer;", "getEnterPinchObserver", "()Landroidx/lifecycle/Observer;", "setEnterPinchObserver", "(Landroidx/lifecycle/Observer;)V", "enterPinchObserver", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/r;", "g2", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/r;", "getRecommendFeedListener", "()Lcom/bytedance/awemeopen/apps/framework/feed/layout/r;", "setRecommendFeedListener", "(Lcom/bytedance/awemeopen/apps/framework/feed/layout/r;)V", "recommendFeedListener", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosFollowFeedLayout extends AosFeedPagerListLayout<AosFollowFeedViewModel> implements View.OnClickListener {
    public static final /* synthetic */ int h2 = 0;
    public final Lazy G1;
    public boolean H0;
    public final Lazy H1;
    public boolean L0;
    public final Lazy L1;
    public final Lazy M1;
    public s P;
    public boolean P0;
    public final Lazy P1;
    public FrameLayout Q;
    public final com.bytedance.awemeopen.apps.framework.feed.layout.c Q1;
    public com.bytedance.awemeopen.apps.framework.feed.follow.c R;
    public ViewGroup S;
    public final Function2<String, String, Unit> S1;
    public FrameLayout T;
    public final d T1;
    public LiveSkyLightTouchLayout U;
    public ViewGroup V;
    public boolean V0;
    public Observer<Boolean> V1;
    public final boolean W;
    public boolean b1;
    public final b b2;
    public List<? extends jz3.a> g1;
    public r g2;
    public boolean h1;
    public final String k0;
    public int k1;
    public boolean p0;
    public final y24.d p1;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.m v1;
    public final Lazy x1;
    public final Lazy y1;

    public static final class a {
    }

    public static final class b implements y24.c {
        public final /* synthetic */ AosFollowFeedLayout a;

        public b(AosFollowFeedLayout r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(String r6, int r7) {
            boolean r0 = false;
            if (r6 != null) goto L5;
        L10:
            boolean r2 = false;
        L11:
            if (r2 == false) goto L14;
            if (r7 != 1) goto L14;
            this.a.V0 = true;
            return;
        L14:
            if (r6 != null) goto L16;
        L21:
            if (r0 == false) goto L46;
            if (r7 != 0) goto L47;
            AosFollowFeedLayout r8 = this.a;
            r8.b1 = true;
            ListState r1 = (ListState) ((AosFollowFeedViewModel) r8.getVm()).getDataList().getValue();
            ArrayList r3 = null;
            if (r1 == null) goto L38;
            List r4 = (List) r1.a;
            if (r4 == null) goto L38;
            ArrayList r5 = new ArrayList();
            Iterator r9 = r4.iterator();
        L29:
            if (r9.hasNext() == false) goto L37;
            Object r10 = r9.next();
            User r11 = ((jz3.a) r10).a.f();
            if (r11 == null) goto L33;
            String r12 = r11.u();
        L35:
            if (Intrinsics.areEqual(r12, r6) == false) goto L29;
            r5.add(r10);
            goto L29
        L33:
            r12 = null;
            goto L35
        L37:
            r3 = r5;
        L38:
            r8.g1 = r3;
            return;
        L47:
            return;
        L46:
            return;
        L16:
            if (r6.length() <= 0) goto L18;
            boolean r13 = true;
        L19:
            if (r13 != true) goto L21;
            r0 = true;
            goto L21
        L18:
            r13 = false;
            goto L19
        L5:
            if (r6.length() <= 0) goto L7;
            boolean r14 = true;
        L8:
            if (r14 != true) goto L10;
            r2 = true;
            goto L11
        L7:
            r14 = false;
            goto L8
        }
    }

    public static final class c implements FeedSeekBarHelper.b {
        public c() {
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

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void O() {
        boolean r0 = true;
        this.p0 = true;
        r r1 = this.g2;
        if (r1 == null) goto L5;
        r0 = r1.e();
    L5:
        this.h1 = r0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final int f() {
        return 2131558670;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final boolean l() {
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final Class<AosFollowFeedViewModel> m() {
        return AosFollowFeedViewModel.class;
    }

    private final AutoPlayHelper getAutoPlayHelper() {
        return (AutoPlayHelper) this.L1.getValue();
    }

    private final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.e getContentShowReportHelper() {
        return (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.e) this.H1.getValue();
    }

    private final vz3.c getFeedPageConfig() {
        return (vz3.c) this.M1.getValue();
    }

    private final FeedSeekBarHelper getFeedSeekBarHelper() {
        return (FeedSeekBarHelper) this.x1.getValue();
    }

    private final AosFollowFeedLayout$liveStatusDetectScheduler$2.a getLiveStatusDetectScheduler() {
        return (AosFollowFeedLayout$liveStatusDetectScheduler$2.a) this.P1.getValue();
    }

    private final VideoPreRenderHelper getVideoPreRenderHelper() {
        return (VideoPreRenderHelper) this.y1.getValue();
    }

    private final SlideEventReportHelper getVideoSlideEventReportHelper() {
        return (SlideEventReportHelper) this.G1.getValue();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void C() {
        d14.a r0 = b14.a.a;
        b14.a.a(l24.a.class).O0(getContext(), this.k0, CsjAdScene.FIT_CONTAINER_FOLLOW, getLayoutRootView().getWidth(), getLayoutRootView().getHeight());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void D() {
        if (this.H0 == false) goto L6;
        this.H0 = false;
    L6:
        if (this.L0 == false) goto L8;
        this.L0 = false;
    L8:
        f0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c0() {
        if (this.b1 == false) goto L52;
        List<? extends jz3.a> r0 = this.g1;
        boolean r1 = true;
        if (r0 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L53;
        ListState r3 = (ListState) ((AosFollowFeedViewModel) getVm()).getDataList().getValue();
        if (r3 == null) goto L16;
        List r4 = (List) r3.a;
        if (r4 == null) goto L16;
        List<? extends jz3.a> r5 = this.g1;
        Intrinsics.checkNotNull(r5);
        r4.removeAll(r5);
    L16:
        this.b1 = false;
        this.g1 = null;
        ListState r6 = (ListState) ((AosFollowFeedViewModel) getVm()).getDataList().getValue();
        if (r6 == null) goto L23;
        List r7 = (List) r6.a;
        if (r7 == null) goto L23;
        if (r7.isEmpty() != true) goto L23;
        boolean r8 = true;
    L24:
        if (r8 == false) goto L27;
        i0();
        return;
    L27:
        ListState r9 = (ListState) ((AosFollowFeedViewModel) getVm()).getDataList().getValue();
        if (r9 == null) goto L37;
        List r10 = (List) r9.a;
        if (r10 == null) goto L37;
        Iterator r11 = r10.iterator();
    L33:
        if (r11.hasNext() == false) goto L37;
        if (((jz3.a) r11.next()).a.S() == true) goto L33;
        r1 = false;
    L37:
        if (r1 == false) goto L45;
        ListState r12 = (ListState) ((AosFollowFeedViewModel) getVm()).getDataList().getValue();
        if (r12 == null) goto L43;
        List r13 = (List) r12.a;
        if (r13 == null) goto L43;
        r13.clear();
    L43:
        getViewPager().getAdapter().notifyDataSetChanged();
        i0();
        return;
    L45:
        this.k1 = ((AosFollowFeedViewModel) getVm()).dataSize();
        getViewPager().getAdapter().notifyDataSetChanged();
        AosPagerListViewModel.updateCurrentIndex$default((AosPagerListViewModel) getVm(), ((AosFollowFeedViewModel) getVm()).getCurrentIndex(), true, false, 4, null);
        return;
    L23:
        r8 = false;
        goto L24
    L53:
        return;
    L7:
        if ((!r0.isEmpty()) != true) goto L9;
        r2 = true;
        goto L10
    }

    public final void d0() {
        d14.a r0 = b14.a.a;
        k34.b r1 = b14.a.a(k34.b.class);
        Context r2 = getContext();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.Activity");
        int r3 = com.bytedance.awemeopen.bizmodels.user.a.a;
        r1.l0(new com.bytedance.awemeopen.bizmodels.user.f((Activity) r2, "click_report", null), new AosFollowFeedLayout$gotoLogin$1(this));
        b14.a.a(t24.a.class).b2("unauth", "immediate_relevance");
    }

    public final void f0() {
        if (this.P0 == true) goto L11;
        FrameLayout r0 = this.T;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
        r0 = null;
    L7:
        r0.setVisibility(8);
        if (getFeedSeekBarHelper().c() == true) goto L12;
        getFeedSeekBarHelper().a();
        return;
    L12:
        return;
    }

    public final void h0() {
        Bundle r0 = new Bundle();
        r0.putInt("background_color", ColorProtector.parseColor("#161616"));
        r0.putString("enter_from_merge", "homepage_follow");
        r0.putInt("live_nick_name_color", ColorProtector.parseColor("#E6FFFFFF"));
        r0.putInt("live_use_new_style", 1);
        AoLiveService r1 = AoLive.a;
        Intrinsics.checkNotNullParameter(getContext(), "context");
        Intrinsics.checkNotNullParameter(r0, "liveBundle");
        AoLiveService r2 = AoLive.a;
        Intrinsics.checkNotNull(r2);
        r2.q0();
        FrameLayout r3 = this.Q;
        FrameLayout r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSkyLightTopContainer");
        r3 = null;
    L5:
        r3.addView(null);
        FrameLayout r5 = this.Q;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSkyLightTopContainer");
    L9:
        this.R = new com.bytedance.awemeopen.apps.framework.feed.follow.c(r4);
        return;
    L8:
        r4 = r5;
        goto L9
    }

    public final void i0() {
        if (this.P0 == false) goto L5;
        return;
    L5:
        this.L0 = true;
        FrameLayout r2 = null;
        View r0 = LayoutInflater.from(getContext()).inflate(2131558643, null);
        FrameLayout r1 = this.T;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
        r1 = null;
    L8:
        r1.removeAllViews();
        FrameLayout r3 = this.T;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
        r3 = null;
    L11:
        r3.addView(r0);
        FrameLayout r4 = this.T;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
        r4 = null;
    L14:
        r4.setVisibility(0);
        FrameLayout r5 = this.T;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
    L18:
        r2.findViewById(2131380925).setOnClickListener(new g(this));
        d14.a r6 = b14.a.a;
        b14.a.a(t24.a.class).h("no_following");
        getFeedSeekBarHelper().b();
        return;
    L17:
        r2 = r5;
        goto L18
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final List<Integer> v() {
        AoLiveService r0 = AoLive.a;
        if (r0 == null) goto L5;
        boolean r1 = r0.E1();
    L7:
        if (r1 == true) goto L14;
        if (r1 == true) goto L13;
        return CollectionsKt.mutableListOf(new Integer[]{2});
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        return new ArrayList();
    L5:
        r1 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void e() {
        super.e();
        getLayoutRootView().post(new f(this));
        d14.a r0 = b14.a.a;
        b14.a.a(c34.a.class).i();
        ((AosFollowFeedViewModel) getVm()).getFeedPlayerHelper().c(com.bytedance.awemeopen.apps.framework.player.d.a);
        ((AosFollowFeedViewModel) getVm()).getFeedPlayerHelper().c(getVideoPreRenderHelper());
        com.bytedance.awemeopen.apps.framework.player.d.a(this.k0, ((AosFollowFeedViewModel) getVm()).getFeedPlayerHelper());
        this.Q = (FrameLayout) getRootView().findViewById(2131372734);
        this.S = (ViewGroup) getRootView().findViewById(2131372728);
        this.U = (LiveSkyLightTouchLayout) getRootView().findViewById(2131372733);
        this.V = (ViewGroup) getRootView().findViewById(2131378880);
        TextView r1 = (TextView) getRootView().findViewById(2131391475);
        this.T = (FrameLayout) getRootView().findViewById(2131387485);
        ViewGroup r2 = this.S;
        String r3 = null;
        FrameLayout r4 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFeedScrollableContainer");
        r2 = null;
    L5:
        r2.setOnClickListener(this);
        getViewPager().setOnClickListener(this);
        ViewGroup r5 = this.V;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("buttonContainer");
        r5 = null;
    L8:
        r5.setOnClickListener(this);
        LiveSkyLightTouchLayout r6 = this.U;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFlContentContainer");
        r6 = null;
    L11:
        r6.setScrollPredicate(AosFollowFeedLayout$initView$3.INSTANCE);
        LiveSkyLightTouchLayout r7 = this.U;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFlContentContainer");
        r7 = null;
    L14:
        r7.setCallBack(new AosFollowFeedLayout$initView$4(this));
        k34.b r8 = b14.a.a(k34.b.class);
        if (r8.isLogin() == true) goto L27;
        this.P0 = true;
        View r9 = LayoutInflater.from(getContext()).inflate(2131558642, null);
        FrameLayout r10 = this.T;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
        r10 = null;
    L19:
        r10.removeAllViews();
        FrameLayout r11 = this.T;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
        r11 = null;
    L22:
        r11.addView(r9);
        FrameLayout r12 = this.T;
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
    L26:
        r4.setVisibility(0);
        b14.a.a(t24.a.class).h("unauth");
        d0();
        g0("null");
    L32:
        if (AoLive.b() == false) goto L35;
        h0();
        return;
    L35:
        return;
    L25:
        r4 = r12;
        goto L26
    L27:
        com.bytedance.awemeopen.bizmodels.user.c r13 = r8.getAccessToken();
        if (r13 == null) goto L30;
        r3 = r13.a;
    L30:
        g0(r3);
        goto L32
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void h() {
        super.h();
        ((AosFollowFeedViewModel) getVm()).setContentScene("follow");
        d14.a r0 = b14.a.a;
        b14.a.a(t24.a.class).H1(this.T1);
        b14.a.a(t24.a.class).v0();
        getFeedSeekBarHelper().f();
        FeedSeekBarHelper r1 = getFeedSeekBarHelper();
        c r2 = new c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "callback");
        r1.D = r2;
        VerticalViewPager r3 = getViewPager();
        r3.c(getFeedSeekBarHelper());
        r3.c(getVideoPreRenderHelper());
        r3.c(getVideoSlideEventReportHelper());
        r3.c(getAutoPlayHelper());
        AosFollowFeedViewModel r4 = (AosFollowFeedViewModel) getVm();
        if (r4 == null) goto L6;
        r4.setFeedSeekBarHelper(getFeedSeekBarHelper());
    L6:
        AosFollowFeedViewModel r5 = (AosFollowFeedViewModel) getVm();
        if (AosExtConfig.b.W1().a == true) goto L9;
    L11:
        boolean r6 = false;
    L12:
        r5.setEnableFollowChannel(r6);
        b14.a.a(k34.b.class).Q0(this.S1);
        this.p1.R2(this.b2);
        AosFollowFeedViewModel r7 = (AosFollowFeedViewModel) getVm();
        AutoPlayHelper r8 = getAutoPlayHelper();
        r8.e.observe(this, this.Q1);
        r7.setAutoPlayHelper(r8);
        boolean r9 = getContext() instanceof AosHomeFeedActivity;
        r r10 = this.g2;
        if (r10 == null) goto L15;
        r10.onBind();
    L15:
        Observer<Boolean> r11 = new e(this);
        this.V1 = r11;
        ((AosFollowFeedViewModel) getVm()).getEnterPinchMode().observe(this, r11);
        return;
    L9:
        if (((AosFollowFeedViewModel) getVm()).getPageConfig().getUselessFollowChannel() == true) goto L11;
        r6 = true;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void i() {
        super.i();
        Observer<Boolean> r0 = this.V1;
        if (r0 == null) goto L7;
        DiscardFirstValueLiveData<Boolean> r1 = ((AosFollowFeedViewModel) getVm()).getEnterPinchMode();
        if (r1 == null) goto L7;
        r1.removeObserver(r0);
    L7:
        VerticalViewPager r2 = getViewPager();
        r2.v(getFeedSeekBarHelper());
        r2.v(getVideoPreRenderHelper());
        r2.v(getVideoSlideEventReportHelper());
        r2.v(getAutoPlayHelper());
        AutoPlayHelper r3 = ((AosFollowFeedViewModel) getVm()).getAutoPlayHelper();
        if (r3 == null) goto L12;
        MutableLiveData<Integer> r4 = r3.e;
        if (r4 == null) goto L12;
        r4.removeObserver(this.Q1);
    L12:
        AutoPlayHelper r5 = ((AosFollowFeedViewModel) getVm()).getAutoPlayHelper();
        if (r5 == null) goto L15;
        r5.b();
    L15:
        d14.a r6 = b14.a.a;
        b14.a.a(k34.b.class).I1(this.S1);
        this.p1.r2(this.b2);
        r r7 = this.g2;
        if (r7 == null) goto L18;
        r7.c();
    L18:
        b14.a.a(t24.a.class).z0(this.T1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void j() {
        super.j();
        ((AosFollowFeedViewModel) getVm()).setPageKey(this.k0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onDestroy() {
        super.onDestroy();
        ((AosFollowFeedViewModel) getVm()).getFeedPlayerHelper().g(com.bytedance.awemeopen.apps.framework.player.d.a);
        com.bytedance.awemeopen.apps.framework.player.d.b(this.k0);
        getFeedSeekBarHelper().g();
        VideoPreRenderHelper r0 = getVideoPreRenderHelper();
        ((AosFollowFeedViewModel) getVm()).getFeedPlayerHelper().g(r0);
        r0.c.clear();
        ListState r1 = (ListState) ((AosFollowFeedViewModel) getVm()).getDataList().getValue();
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
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.m r6 = this.v1;
        Context r7 = getContext();
        String r8 = ((AosFollowFeedViewModel) getVm()).sceneId();
        String r10 = ((AosFollowFeedViewModel) getVm()).getPageConfig().getEnterAid();
        r14.c r11 = getAweme();
        if (r11 == null) goto L20;
        String r12 = r11.c();
    L22:
        if (Intrinsics.areEqual(r10, r12) == false) goto L24;
        String r13 = ((AosFollowFeedViewModel) getVm()).getPageConfig().getEnterHostGid();
    L25:
        r6.a(r7, r8, r13, getAweme(), r9);
        ((c14.a) getLiveStatusDetectScheduler()).b.removeMessages(1);
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
        if (o() == false) goto L6;
        getVideoPreRenderHelper().b = false;
        ((AosFollowFeedViewModel) getVm()).setFeedVisible(false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onResume() {
        super.onResume();
        c0();
        getVideoPreRenderHelper().b = true;
        getLiveStatusDetectScheduler().b(true);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.e r0 = getContentShowReportHelper();
        r0.getClass();
        Intrinsics.checkNotNullParameter("homepage_hot", "enterFrom");
        if (r0.a == true) goto L6;
        r0.a = true;
        d14.a r1 = b14.a.a;
        b14.a.a(t24.a.class).H0();
    L6:
        if (o() == false) goto L9;
        ((AosFollowFeedViewModel) getVm()).setFeedVisible(true);
    L9:
        if (this.L0 == true) goto L11;
        return;
    L11:
        if (this.V0 == false) goto L15;
        ((AosFollowFeedViewModel) getVm()).retry();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onStart() {
        super.onStart();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.m r0 = this.v1;
        AoLogger.b(r0.a, new Object[]{"onPageShow"});
        r0.d = System.currentTimeMillis();
        ((AosFollowFeedViewModel) getVm()).updatePalpableIndex(((AosFollowFeedViewModel) getVm()).getCurrentIndex(), true);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void E() {
        f0();
    }

    public final Observer<Boolean> getEnterPinchObserver() {
        return this.V1;
    }

    public final s getIFeedsHomeLayout() {
        return this.P;
    }

    public final r getRecommendFeedListener() {
        return this.g2;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onCreate() {
        super.onCreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b0(AosFollowFeedLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        FeedSeekBarHelper r0 = r5.getFeedSeekBarHelper();
        View r1 = r5.getLayoutRootView();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        int r2 = vz3.b.a;
        Context r3 = r5.getContext();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        r0.i((ViewGroup) r1, vz3.b.a((Activity) r3, false, ((AosFollowFeedViewModel) r5.getVm()).getPageConfig().getFullScreen(), ((AosFollowFeedViewModel) r5.getVm()).getPageConfig().getBottomMarginPxIfNotFullScreen()));
    }

    public static void g0(final String r3) {
        boolean r0 = false;
        if (r3 != null) goto L5;
    L10:
        if (r0 == false) goto L13;
        HashMap r1 = new HashMap();
        r1.put("access-token", new AosFollowFeedLayout$reFreshToken$1(r3));
        r1.put("Content-Type", AosFollowFeedLayout$reFreshToken$2.INSTANCE);
        Function0 r4 = AoNet.a;
        Intrinsics.checkNotNullParameter(r1, "params");
        HashMap r2 = a64.a.a;
        Intrinsics.checkNotNullParameter(r1, "params");
        a64.a.a.putAll(r1);
        return;
    L13:
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 != true) goto L10;
        r0 = true;
        goto L10
    L7:
        r5 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setCanScroll2Profile(boolean r2) {
        if (((AosFollowFeedViewModel) getVm()).getPageConfig().isTeenagerModel() == false) goto L6;
        r2 = false;
    L6:
        if (this.p0 == false) goto L8;
        this.h1 = r2;
        return;
    L8:
        r r0 = this.g2;
        if (r0 == null) goto L13;
        r0.i(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void M(boolean r2) {
        super.M(r2);
        boolean r3 = false;
        this.p0 = false;
        if (((AosFollowFeedViewModel) getVm()).getPageConfig().isTeenagerModel() == true) goto L6;
        r3 = this.h1;
    L6:
        r r0 = this.g2;
        if (r0 == null) goto L10;
        r0.j(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void c(boolean r3) {
        this.g = r3;
        if (o() == false) goto L8;
        ((AosFollowFeedViewModel) getVm()).getFeedHomeContainerDeliverHiddenState().setValue(Boolean.valueOf(r3));
        if (r3 == true) goto L9;
        c0();
        return;
    L9:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (r7 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == false) goto L30;
        com.bytedance.awemeopen.apps.framework.feed.follow.c r9 = this.R;
        LiveSkyLightTouchLayout r2 = null;
        if (r9 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSkyLightHelper");
        r9 = null;
    L12:
        ViewGroup r3 = this.S;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFeedScrollableContainer");
        r3 = null;
    L15:
        FrameLayout r4 = this.Q;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mSkyLightTopContainer");
        r4 = null;
    L18:
        com.bytedance.awemeopen.apps.framework.feed.follow.c.a(r9, r3, 0.0f, r4.getHeight());
        com.bytedance.awemeopen.apps.framework.feed.follow.c r10 = this.R;
        if (r10 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSkyLightHelper");
        r10 = null;
    L21:
        r10.d = true;
        ViewGroup r11 = this.V;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("buttonContainer");
        r11 = null;
    L24:
        r11.setVisibility(8);
        LiveSkyLightTouchLayout r12 = this.U;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mFlContentContainer");
    L28:
        r2.setNeedIntercept(true);
        d14.a r13 = b14.a.a;
        b14.a.a(t24.a.class).b1();
        return;
    L27:
        r2 = r12;
        goto L28
    L30:
        return;
    L5:
        if (r7.getId() != 2131378880) goto L7;
        r8 = true;
        goto L8
    }

    public final void setEnterPinchObserver(Observer<Boolean> r1) {
        this.V1 = r1;
    }

    public final void setIFeedsHomeLayout(s r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.P = r2;
    }

    public final void setRecommendFeedListener(r r1) {
        this.g2 = r1;
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.bytedance.awemeopen.apps.framework.feed.layout.c] */
    /* JADX WARN: Type inference failed for: r3v16, types: [com.bytedance.awemeopen.apps.framework.feed.layout.d] */
    public AosFollowFeedLayout(final Context r3, s r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "iFeedsHomeLayout");
        new LinkedHashMap();
        super(r3);
        this.P = r4;
        this.W = AosExtConfig.b.m0();
        this.k0 = "AosRecommendFeedFragment_" + System.currentTimeMillis() + '_' + hashCode();
        this.h1 = true;
        this.k1 = -1;
        d14.a r5 = b14.a.a;
        this.p1 = b14.a.a(y24.d.class);
        this.v1 = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.m();
        this.x1 = LazyKt.lazy(new AosFollowFeedLayout$feedSeekBarHelper$2(r3, this));
        this.y1 = LazyKt.lazy(new AosFollowFeedLayout$videoPreRenderHelper$2(this));
        this.G1 = LazyKt.lazy(new AosFollowFeedLayout$videoSlideEventReportHelper$2(this));
        this.H1 = LazyKt.lazy(AosFollowFeedLayout$contentShowReportHelper$2.INSTANCE);
        this.L1 = LazyKt.lazy(new AosFollowFeedLayout$autoPlayHelper$2(this));
        this.M1 = LazyKt.lazy(AosFollowFeedLayout$feedPageConfig$2.INSTANCE);
        this.P1 = LazyKt.lazy(new AosFollowFeedLayout$liveStatusDetectScheduler$2(this));
        this.Q1 = new com.bytedance.awemeopen.apps.framework.feed.layout.c(this);
        this.S1 = new AosFollowFeedLayout$userChangeListener$1(this);
        this.T1 = new d(this);
        this.b2 = new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout
    public final void a0(int r4, jz3.a r5) {
        Intrinsics.checkNotNullParameter(r5, "model");
        getFeedSeekBarHelper().j(r5.a);
        this.v1.b(r5.a);
        com.bytedance.awemeopen.apps.framework.player.d r6 = com.bytedance.awemeopen.apps.framework.player.d.a;
        com.bytedance.awemeopen.apps.framework.player.d.i(this.k0, r5.a);
        getLiveStatusDetectScheduler().b(true);
        if (((AosFollowFeedViewModel) getVm()).getPageConfig().isTeenagerModel() == false) goto L6;
        setCanScroll2Profile(false);
    L6:
        if (r5.f == false) goto L25;
        this.H0 = true;
        FrameLayout r0 = null;
        View r7 = LayoutInflater.from(getContext()).inflate(2131558644, null);
        FrameLayout r8 = this.T;
        if (r8 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
        r8 = null;
    L10:
        r8.removeAllViews();
        FrameLayout r9 = this.T;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
        r9 = null;
    L13:
        r9.addView(r7);
        FrameLayout r10 = this.T;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
        r10 = null;
    L16:
        r10.setVisibility(0);
        FrameLayout r11 = this.T;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
    L20:
        View r12 = r0.findViewById(2131377379);
        if (r12 == null) goto L23;
        r12.setOnClickListener(new h(this));
    L23:
        d14.a r13 = b14.a.a;
        b14.a.a(t24.a.class).h("play_finish_30");
        getLoadMoreLayout().g();
        return;
    L19:
        r0 = r11;
        goto L20
    L25:
        if (this.H0 == false) goto L29;
        this.H0 = false;
        f0();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final int u(int r1, jz3.a r2) {
        jz3.a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "data");
        int r4 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.b.a;
        Integer r5 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.b.c(r3.a);
        if (r5 != null) goto L7;
        int r6 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h.a;
        return com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h.c(r3.a);
    L7:
        return r5.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void F(List<jz3.a> r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r4, "data");
        FrameLayout r1 = null;
        jz3.a r2 = null;
        r2 = null;
        if (this.k1 != ((AosFollowFeedViewModel) getVm()).dataSize()) goto L33;
        if ((!r4.isEmpty()) == false) goto L9;
        if (((jz3.a) CollectionsKt.last(r4)).f == false) goto L9;
        return;
    L9:
        if (this.H0 == true) goto L53;
        ListState r7 = (ListState) ((AosFollowFeedViewModel) getVm()).getDataList().getValue();
        if (r7 == null) goto L16;
        List r8 = (List) r7.a;
        if (r8 == null) goto L16;
        jz3.a r9 = (jz3.a) CollectionsKt.getOrNull(r8, 0);
    L17:
        if (r9 == null) goto L21;
        r14.c r10 = r9.a;
        if (r10 == null) goto L21;
        r2 = new jz3.a(r10.b(), null, 14);
    L21:
        if (r2 == null) goto L24;
        r2.f = true;
    L24:
        if (r2 == null) goto L30;
        ListState r11 = (ListState) ((AosFollowFeedViewModel) getVm()).getDataList().getValue();
        if (r11 == null) goto L30;
        List r12 = (List) r11.a;
        if (r12 == null) goto L30;
        r12.add(r2);
    L30:
        getViewPager().getAdapter().notifyDataSetChanged();
        this.k1 = ((AosFollowFeedViewModel) getVm()).dataSize();
        ((AosFollowFeedViewModel) getVm()).setShouldOpenPreLoad(false);
        return;
    L16:
        r9 = null;
        goto L17
    L53:
        return;
    L33:
        if ((!r4.isEmpty()) == true) goto L35;
    L41:
        this.k1 = ((AosFollowFeedViewModel) getVm()).dataSize();
        if (this.W == false) goto L54;
        if (r6 == false) goto L55;
        int r13 = ((AosFollowFeedViewModel) getVm()).getCurrentIndex() + 1;
        ListState r14 = (ListState) ((AosFollowFeedViewModel) getVm()).getDataList().getValue();
        if (r14 == null) goto L56;
        List r15 = (List) r14.a;
        if (r15 != null) goto L49;
        return;
    L49:
        if (((jz3.a) CollectionsKt.getOrNull(r15, r13)) == null) goto L58;
        getViewPager().y(r13, true);
        return;
    L58:
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L35:
        if (this.P0 == true) goto L41;
        FrameLayout r16 = this.T;
        if (r16 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("stubHintFollowPageView");
    L40:
        r1.setVisibility(8);
        goto L41
    L39:
        r1 = r16;
        goto L40
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final void N(List<jz3.a> r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        super.N(r2, r3, r4);
        this.p0 = false;
        ((AosFollowFeedViewModel) getVm()).setShouldOpenPreLoad(true);
        this.k1 = ((AosFollowFeedViewModel) getVm()).dataSize();
        if (r2.isEmpty() == false) goto L6;
        i0();
    L8:
        ViewGroup r5 = this.V;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("buttonContainer");
        r5 = null;
    L11:
        r5.getVisibility();
        r r6 = this.g2;
        if (r6 == null) goto L15;
        r6.f(this.h1);
        return;
    L15:
        return;
    L6:
        if (this.L0 == false) goto L8;
        this.L0 = false;
        f0();
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> s(ViewGroup r17, int r18, jz3.a r19) {
        Intrinsics.checkNotNullParameter(r17, "parent");
        Intrinsics.checkNotNullParameter(r19, "data");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("comment_bottom_margin", Integer.valueOf(((AosFollowFeedViewModel) getVm()).getPageConfig().getCommentBottomMargin()));
        int r1 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.b.a;
        FeedPagerListViewModel r2 = (FeedPagerListViewModel) getVm();
        Context r3 = getContext();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        Activity r13 = (Activity) r3;
        Context r4 = getContext();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> r5 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.b.b(r17, r18, r2, r13, new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b((Activity) r4, getLayoutRootView(), r17, this, this, r0, 0, 160), getFeedSeekBarHelper(), getVideoPreRenderHelper(), getFeedPageConfig(), this.k0);
        if (r5 != null) goto L6;
        int r6 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h.a;
        FeedPagerListViewModel r7 = (FeedPagerListViewModel) getVm();
        Context r8 = getContext();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.app.Activity");
        Activity r14 = (Activity) r8;
        Context r9 = getContext();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.app.Activity");
        return com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h.b(r17, r18, r7, r14, new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b((Activity) r9, getLayoutRootView(), r17, this, this, r0, 0, 160), getFeedSeekBarHelper(), getVideoPreRenderHelper(), getFeedPageConfig());
    L6:
        return r5;
    }
}
