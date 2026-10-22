package com.bytedance.awemeopen.apps.framework.feed.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.AosSeriesRefactorService;
import com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager;
import com.bytedance.awemeopen.apps.framework.feed.follow.HomeTopTabItemView;
import com.bytedance.awemeopen.apps.framework.feed.follow.MainTabStripScrollView;
import com.bytedance.awemeopen.apps.framework.feed.follow.MultiTabPageAdapter;
import com.bytedance.awemeopen.apps.framework.feed.follow.NoScrollViewPager;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxBadgeView;
import com.bytedance.awemeopen.apps.framework.feed.home.AosFeedsHomeFragment;
import com.bytedance.awemeopen.apps.framework.feed.home.FeedHomeContainerViewModel;
import com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosFeedsChannelFragment;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.utils.k0;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.apps.framework.utils.reporter.HostCommonParamProvider;
import com.bytedance.awemeopen.apps.framework.utils.y;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.export.api.series.homepage.SeriesHomePageConfig;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.awemeopen.servicesapi.livepreview.AoLiveService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0014\u0018\u00010\u0001J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\u00068F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u00108\u001a\b\u0012\u0004\u0012\u000201008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010@\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010H\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosFeedsHomeLayout;", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosBaseLayout;", "Lcom/bytedance/awemeopen/apps/framework/feed/home/FeedHomeContainerViewModel;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/s;", "", "getRecommendIndex", "getFollowChannelIndex", "", "getCurrentEnterFrom", "Landroid/os/Bundle;", "bundle", "", "setArguments", "Landroidx/fragment/app/Fragment;", "getParentFragment", "Lk54/c;", "listener", "setFeedPageListener", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "getSelectedFeedLayout", "Ljz3/b;", "feedContext", "setFeedListContext", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/AosFeedsChannelFragment;", "i", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/AosFeedsChannelFragment;", "getAosFeedsChannelFragment", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/AosFeedsChannelFragment;", "setAosFeedsChannelFragment", "(Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/AosFeedsChannelFragment;)V", "aosFeedsChannelFragment", "j", "I", "getCurrentSeletecdIndex", "()I", "setCurrentSeletecdIndex", "(I)V", "currentSeletecdIndex", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/r;", "k", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/r;", "getRecommendFeedListener", "()Lcom/bytedance/awemeopen/apps/framework/feed/layout/r;", "setRecommendFeedListener", "(Lcom/bytedance/awemeopen/apps/framework/feed/layout/r;)V", "recommendFeedListener", "", "Landroid/view/View;", "r", "Ljava/util/List;", "getFeedPages", "()Ljava/util/List;", "setFeedPages", "(Ljava/util/List;)V", "feedPages", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosFollowFeedLayout;", "s", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosFollowFeedLayout;", "getAosFollowFeedLayout", "()Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosFollowFeedLayout;", "setAosFollowFeedLayout", "(Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosFollowFeedLayout;)V", "aosFollowFeedLayout", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosRecommendFeedLayout;", "t", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosRecommendFeedLayout;", "getAosRecommendFeedLayout", "()Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosRecommendFeedLayout;", "setAosRecommendFeedLayout", "(Lcom/bytedance/awemeopen/apps/framework/feed/layout/AosRecommendFeedLayout;)V", "aosRecommendFeedLayout", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class AosFeedsHomeLayout extends AosBaseLayout<FeedHomeContainerViewModel> implements ViewPager.OnPageChangeListener, View.OnClickListener, s {
    public AosFeedsChannelFragment i;
    public int j;
    public r k;
    public View l;
    public com.bytedance.awemeopen.apps.framework.feed.follow.j m;
    public MainTabStripScrollView n;
    public NoScrollViewPager o;
    public ViewGroup p;
    public View q;
    public List<View> r;
    public AosFollowFeedLayout s;
    public AosRecommendFeedLayout t;
    public AosBaseLayout<? extends AosViewModel> u;
    public MultiTabPageAdapter v;
    public FeedPageConfig w;
    public long x;
    public HostCommonParamProvider y;
    public jz3.b z;

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final int f() {
        return 2131558674;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void h() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final Class<FeedHomeContainerViewModel> m() {
        return FeedHomeContainerViewModel.class;
    }

    public final void onPageScrollStateChanged(int r1) {
    }

    public final void onPageScrolled(int r1, float r2, int r3) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.s
    public final void a() {
        ViewGroup r0 = this.p;
        ViewGroup r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r0 = null;
    L6:
        if (r0.getChildCount() <= 2) goto L13;
        ViewGroup r2 = this.p;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
    L11:
        v(r1.getChildAt(getRecommendIndex() + 1));
        return;
    L10:
        r1 = r2;
        goto L11
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void e() {
        j04.a r0 = j04.b.a;
        FeedPageConfig r1 = this.w;
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(r1.getClickFeedTimeStamp());
    L6:
        j04.b.a("enter_play", r2);
        u();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final int getCurrentSeletecdIndex() {
        return RangesKt.coerceAtLeast(RangesKt.coerceAtMost(this.j, this.r.size() - 1), 0);
    }

    public Fragment getParentFragment() {
        AosFeedsChannelFragment r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getParentFragment();
    }

    public final AosBaseLayout<? extends AosViewModel> getSelectedFeedLayout() {
        if (this.r.isEmpty() == true) goto L5;
        View r0 = (View) ListProtector.get(this.r, getCurrentSeletecdIndex());
        if ((r0 instanceof AosRecommendFeedLayout) == false) goto L11;
        return this.t;
    L11:
        if ((r0 instanceof AosFollowFeedLayout) == false) goto L15;
        return this.s;
    L15:
        return this.u;
    L5:
        return this.t;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void i() {
        d14.a r0 = b14.a.a;
        b14.a.a(t24.a.class).z0(this.y);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final boolean l() {
        FeedPageConfig r0 = this.w;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return false;
    L11:
        if ((getContext() instanceof Activity) == false) goto L14;
        int r2 = w04.a.a;
        return w04.a.b((Activity) getContext());
    L14:
        return false;
    L5:
        if (r0.getShouldPaddingStatusBarHeight() == true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean r() {
        if (AosExtConfig.b.W1().a == false) goto L13;
        FeedPageConfig r0 = this.w;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.getUselessFollowChannel() == true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    public final boolean s() {
        FeedPageConfig r0 = this.w;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getShowSeriesChannel() != true) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [android.view.View, android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.awemeopen.apps.framework.feed.follow.HomeTopTabItemView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r1v47, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v18, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r5v20, types: [com.bytedance.awemeopen.apps.framework.feed.follow.j] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v33 */
    public final void u() {
        if (r() == false) goto L5;
    L11:
        getVm().setMultiTab(true);
        View r1 = findViewById(2131392622);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.follow.NoScrollViewPager");
        this.o = (NoScrollViewPager) r1;
        View r2 = findViewById(2131387491);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.follow.MainTabStripScrollView");
        this.n = (MainTabStripScrollView) r2;
        NoScrollViewPager r3 = this.o;
        AttributeSet r4 = null;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r3 = null;
    L14:
        int r5 = 0;
        r3.setVisibility(0);
        MainTabStripScrollView r6 = this.n;
        String r7 = "scrollView";
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        r6 = null;
    L17:
        r6.setVisibility(0);
        View r8 = LayoutInflater.from(getContext()).inflate(2131558638, null);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r9 = (ViewGroup) r8;
        this.p = r9;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r9 = null;
    L20:
        this.q = r9.findViewById(2131392600);
        ArrayList r10 = new ArrayList();
        AosRecommendFeedLayout r11 = new AosRecommendFeedLayout(getContext());
        r11.setArguments(getBundle());
        r11.setMultiTab(true);
        r11.setRecommendFeedListener(this.k);
        r11.b();
        this.r.add(r11);
        jz3.b r12 = this.z;
        if (r12 == null) goto L23;
        r11.setFeedListContext(r12);
    L23:
        this.t = r11;
        String r13 = "推荐";
        r10.add("推荐");
        if (r() == false) goto L29;
        AosFollowFeedLayout r14 = new AosFollowFeedLayout(getContext(), this);
        r14.setArguments(getBundle());
        r14.setRecommendFeedListener(this.k);
        ListProtector.add(this.r, 0, r14);
        r14.setViewModelStoreOwner(getViewModelStoreOwner());
        jz3.b r15 = this.z;
        if (r15 == null) goto L28;
        r14.setFeedListContext(r15);
    L28:
        this.s = r14;
        ListProtector.add(r10, 0, "关注");
    L29:
        String r16 = "短剧";
        if (s() == false) goto L47;
        FeedPageConfig r17 = this.w;
        if (r17 == null) goto L35;
        SeriesHomePageConfig r18 = r17.getSeriesConfig();
        if (r18 == null) goto L35;
    L36:
        FeedPageConfig r19 = this.w;
        if (r19 == null) goto L39;
        boolean r110 = r19.getShowBackButton();
    L40:
        r18.setShowBackButton(r110);
        AosSeriesRefactorService r20 = (AosSeriesRefactorService) BdpManager.getInst().getService(AosSeriesRefactorService.class);
        if (r20 == null) goto L43;
        getContext();
        getViewModelStoreOwner();
        AosBaseLayout<? extends AosViewModel> r21 = r20.w1();
    L44:
        this.u = r21;
        if (r21 == null) goto L47;
        ListProtector.add(this.r, 0, r21);
        ListProtector.add(r10, 0, "短剧");
        goto L47
    L43:
        r21 = null;
        goto L44
    L39:
        r110 = true;
    L35:
        r18 = new SeriesHomePageConfig();
    L47:
        this.v = new MultiTabPageAdapter(this.r);
        NoScrollViewPager r22 = this.o;
        if (r22 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r22 = null;
    L50:
        r22.setAdapter(this.v);
        NoScrollViewPager r23 = this.o;
        if (r23 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r23 = null;
    L53:
        r23.setOnPageChangeListener(this);
        View r111 = this.q;
        if (r111 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("tabIndicator");
        r111 = null;
    L56:
        this.m = new com.bytedance.awemeopen.apps.framework.feed.follow.j(r111);
        ViewGroup r24 = this.p;
        if (r24 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r24 = null;
    L59:
        r24.removeAllViews();
        ViewGroup r25 = this.p;
        if (r25 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r25 = null;
    L62:
        View r112 = this.q;
        if (r112 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("tabIndicator");
        r112 = null;
    L65:
        r25.addView(r112);
        ArrayList r26 = new ArrayList();
        int r113 = com.bytedance.awemeopen.apps.framework.feed.follow.k.a;
        Iterator r114 = r10.iterator();
        ?? r115 = 0;
    L67:
        if (r114.hasNext() == false) goto L107;
        String r116 = (String) r114.next();
        Context r27 = getContext();
        if (r27 == null) goto L71;
        ?? r117 = new HomeTopTabItemView(r27, r4, 6, r5);
    L72:
        if (r117 == 0) goto L76;
        r117.setId(r117.hashCode());
    L76:
        if (r10.size() != 2) goto L82;
        if (Intrinsics.areEqual(r116, r13) == false) goto L82;
        if (r117 == 0) goto L82;
        r117.c.setVisibility(8);
    L82:
        if (r10.size() == 3) goto L84;
    L89:
        RelativeLayout.LayoutParams r28 = new RelativeLayout.LayoutParams(-2, -1);
        ViewGroup r29 = this.p;
        ?? r30 = r29;
        if (r29 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r30 = 0;
    L92:
        r30.addView(r117, r28);
        if (r117 == 0) goto L96;
        int r31 = com.bytedance.awemeopen.apps.framework.feed.follow.h.a;
        Resources r32 = Resources.getSystem();
        r117.setTextSize((int) (((double) 0.5f) + (((double) 17) * ((double) WindowDisplayMetricsOverride.apply(r32, r32.getDisplayMetrics()).density))));
    L96:
        if (r117 == 0) goto L98;
        r117.setText(r116);
    L98:
        if (r117 == 0) goto L100;
        r117.setOnClickListener(this);
    L100:
        if (r115 == 0) goto L104;
        if (r117 == 0) goto L104;
        RelativeLayout.LayoutParams r33 = (RelativeLayout.LayoutParams) r117.getLayoutParams();
        r33.addRule(1, r115.getId());
        r33.addRule(17, r115.getId());
        r117.setLayoutParams(r33);
    L104:
        if (r117 == 0) goto L106;
        r26.add(r117);
    L106:
        r7 = r7;
        r115 = r117;
        r13 = r13;
        r16 = r16;
        r114 = r114;
        r4 = null;
        r5 = 0;
        goto L67
    L84:
        if (Intrinsics.areEqual(r116, r13) == false) goto L86;
    L87:
        if (r117 == 0) goto L89;
        r117.c.setVisibility(8);
        goto L89
    L86:
        if (Intrinsics.areEqual(r116, r16) == false) goto L89;
    L71:
        r117 = r4;
        goto L72
    L107:
        String r118 = r7;
        if (r10.size() != 2) goto L113;
        MainTabStripScrollView r34 = this.n;
        if (r34 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException(r118);
        r34 = null;
    L112:
        Resources r35 = Resources.getSystem();
        r34.setPadding(0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 21, WindowDisplayMetricsOverride.apply(r35, r35.getDisplayMetrics()))), 0);
    L113:
        ViewGroup r36 = this.p;
        if (r36 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r36 = null;
    L117:
        if (r36.getChildCount() <= 2) goto L140;
        ViewGroup r37 = this.p;
        if (r37 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r37 = null;
    L121:
        ?? r38 = r37.getChildAt(getRecommendIndex() + 1);
        Intrinsics.checkNotNull(r38, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.follow.HomeTopTabItemView");
        HomeTopTabItemView r39 = (HomeTopTabItemView) r38;
        r39.b.setAlpha(1.0f);
        x54.b.b(r39.a);
        com.bytedance.awemeopen.apps.framework.feed.follow.j r40 = this.m;
        ?? r41 = r40;
        if (r40 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorManager");
        r41 = 0;
    L124:
        r41.a(r38);
        NoScrollViewPager r42 = this.o;
        if (r42 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r42 = null;
    L127:
        r42.setCurrentItemWithoutScroll(getRecommendIndex());
        this.l = r38;
        if (r() == false) goto L133;
        if (s() == false) goto L133;
        int r43 = 2;
    L139:
        this.j = r43;
    L133:
        if (r() == false) goto L135;
    L138:
        r43 = 1;
        goto L139
    L135:
        if (s() == true) goto L138;
        r43 = 0;
    L140:
        ViewGroup r44 = this.p;
        if (r44 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r44 = null;
    L143:
        removeView(r44);
        MainTabStripScrollView r45 = this.n;
        if (r45 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException(r118);
        r45 = null;
    L146:
        ViewGroup r46 = this.p;
        if (r46 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r46 = null;
    L149:
        r45.addView(r46);
        MainTabStripScrollView r47 = this.n;
        if (r47 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException(r118);
        r47 = null;
    L152:
        NoScrollViewPager r48 = this.o;
        if (r48 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r48 = null;
    L155:
        Resources r49 = Resources.getSystem();
        int r50 = MathKt.roundToInt(TypedValue.applyDimension(1, 44, WindowDisplayMetricsOverride.apply(r49, r49.getDisplayMetrics())));
        int r51 = r26.size();
        r47.f = r48;
        r47.h = r26;
        r47.i = r50;
        r47.j = r51;
        AoLogger.g("MainTabStripScrollView", new Object[]{"setupMainTabStrip called"});
        DmtViewPager r52 = r47.f;
        if (r52 == null) goto L160;
        List<ViewPager.OnPageChangeListener> r53 = r52.k0;
        if (r53 == null) goto L160;
        ((ArrayList) r53).remove(r47);
    L160:
        DmtViewPager r54 = r47.f;
        if (r54 != null) goto L163;
    L166:
        r47.c();
        r47.d();
        d14.a r55 = b14.a.a;
        if (b14.a.a(k34.b.class).isLogin() == true) goto L169;
        return;
    L169:
        if (k0.c(z54.a.b("recommend_feed").getLong("recommend_feed_show_red_point", 0), System.currentTimeMillis()) == false) goto L171;
        return;
    L171:
        ViewGroup r56 = this.p;
        if (r56 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r56 = null;
    L175:
        if (r56.getChildCount() <= 1) goto L190;
        if (getFollowChannelIndex() == (-1)) goto L190;
        ViewGroup r57 = this.p;
        if (r57 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r57 = null;
    L181:
        Object r58 = r57.getChildAt(getFollowChannelIndex() + 1);
        Intrinsics.checkNotNull(r58, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.follow.HomeTopTabItemView");
        HomeTopTabItemView r59 = (HomeTopTabItemView) r58;
        Integer r60 = 0;
        if (r60 == null) goto L187;
        r59.getClass();
        if (r60.intValue() <= 0) goto L187;
        DuxBadgeView r61 = r59.a;
        Intrinsics.checkNotNull(r61);
        r61.setMode(2);
        DuxBadgeView r62 = r59.a;
        Intrinsics.checkNotNull(r62);
        r62.setCount(r60.intValue());
    L188:
        x54.b.d(r59.a);
    L187:
        DuxBadgeView r63 = r59.a;
        Intrinsics.checkNotNull(r63);
        r63.setMode(1);
    L190:
        if (AoLive.b() == true) goto L192;
        z54.a.b("recommend_feed").edit().putLong("recommend_feed_show_red_point", System.currentTimeMillis()).apply();
        return;
    L192:
        Bundle r64 = new Bundle();
        r64.putInt("live_use_new_style", 1);
        Intrinsics.checkNotNullParameter(getContext(), "context");
        Intrinsics.checkNotNullParameter(r64, "liveBundle");
        AoLiveService r65 = AoLive.a;
        Intrinsics.checkNotNull(r65);
        r65.q0();
        throw null;
    L163:
        if (r54.k0 != null) goto L165;
        r54.k0 = new ArrayList();
    L165:
        ((ArrayList) r54.k0).add(r47);
        goto L166
    L5:
        if (s() == true) goto L11;
        FrameLayout r66 = (FrameLayout) findViewById(2131384828);
        AosRecommendFeedLayout r67 = new AosRecommendFeedLayout(getContext());
        r67.setRecommendFeedListener(this.k);
        r67.setArguments(getBundle());
        r67.setViewModelStoreOwner(getViewModelStoreOwner());
        r67.b();
        r66.addView(r67);
        jz3.b r68 = this.z;
        if (r68 == null) goto L9;
        r67.setFeedListContext(r68);
    L9:
        this.t = r67;
    }

    private final String getCurrentEnterFrom() {
        AosBaseLayout<? extends AosViewModel> r0 = getSelectedFeedLayout();
        if ((r0 instanceof AosRecommendFeedLayout) == false) goto L7;
        return "homepage_hot";
    L7:
        if ((r0 instanceof AosFollowFeedLayout) == false) goto L10;
        return "homepage_follow";
    L10:
        return "playlet";
    }

    private final int getFollowChannelIndex() {
        if (r() == true) goto L7;
        return -1;
    L7:
        return s() ? 1 : 0;
    }

    private final int getRecommendIndex() {
        if (r() == false) goto L9;
        if (s() == false) goto L9;
        return 2;
    L9:
        if (r() == false) goto L11;
        return 1;
    L11:
        if (s() == true) goto L17;
        return 0;
    L17:
        return 1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final boolean g() {
        AosBaseLayout<? extends AosViewModel> r0 = getSelectedFeedLayout();
        boolean r1 = r0 instanceof AosRecommendFeedLayout;
        if (r1 == true) goto L5;
    L7:
        FeedPageConfig r3 = this.w;
        if (r3 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L15;
        return false;
    L15:
        JSONObject r5 = AoSettings.a("ao_back_detain_config");
        if (r5 == null) goto L18;
        Boolean r6 = Boolean.valueOf(r5.optBoolean("enable_config", false));
    L20:
        if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L23;
        return false;
    L23:
        if ((System.currentTimeMillis() - this.x) > 2000) goto L25;
        return false;
    L25:
        if (r1 == false) goto L27;
        r0.g();
    L28:
        this.x = System.currentTimeMillis();
        return true;
    L27:
        a();
        zx3.a.c(getContext(), 2131894448).d();
        d14.a r2 = b14.a.a;
        b14.a.a(t24.a.class).t1(getCurrentEnterFrom());
        goto L28
    L18:
        r6 = null;
        goto L20
    L10:
        if (r3.getIgnoreOnBackTest() != true) goto L12;
        r4 = true;
        goto L13
    L5:
        if (((AosRecommendFeedLayout) r0).W() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void k() {
        Bundle r0 = getBundle();
        if (r0 == null) goto L6;
        FeedPageConfig r1 = (FeedPageConfig) r0.getParcelable("FEED_PAGE_CONFIG_CONFIG_KEY");
        if (r1 == null) goto L6;
    L7:
        this.w = r1;
        FeedPageConfig r2 = this.w;
        if (r2 == null) goto L10;
        JSONObject r3 = r2.getHostCommonParams();
    L11:
        this.y = new HostCommonParamProvider(r3);
        d14.a r4 = b14.a.a;
        b14.a.a(t24.a.class).H1(this.y);
        return;
    L10:
        r3 = null;
    L6:
        r1 = new FeedPageConfig();
        goto L7
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onCreate() {
        super.onCreate();
        AosRecommendFeedLayout r0 = this.t;
        if (r0 == null) goto L6;
        r0.onCreate();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onDestroy() {
        super.onDestroy();
        if (r() == false) goto L5;
    L10:
        Iterator<T> r0 = this.r.iterator();
    L12:
        if (r0.hasNext() == false) goto L23;
        View r1 = (View) r0.next();
        if ((r1 instanceof AosBaseLayout) == false) goto L12;
        ((AosBaseLayout) r1).onDestroy();
        goto L12
    L23:
        return;
    L5:
        if (s() == true) goto L10;
        AosRecommendFeedLayout r2 = this.t;
        if (r2 == null) goto L16;
        r2.onDestroy();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onPause() {
        super.onPause();
        if (r() == false) goto L5;
    L10:
        View r0 = (View) ListProtector.get(this.r, getCurrentSeletecdIndex());
        if ((r0 instanceof AosBaseLayout) == false) goto L16;
        ((AosBaseLayout) r0).onPause();
        return;
    L16:
        return;
    L5:
        if (s() == true) goto L10;
        AosRecommendFeedLayout r1 = this.t;
        if (r1 == null) goto L14;
        r1.onPause();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onResume() {
        super.onResume();
        if (r() == false) goto L5;
    L10:
        View r0 = (View) ListProtector.get(this.r, getCurrentSeletecdIndex());
        if ((r0 instanceof AosBaseLayout) == false) goto L16;
        ((AosBaseLayout) r0).onResume();
        return;
    L16:
        return;
    L5:
        if (s() == true) goto L10;
        AosRecommendFeedLayout r1 = this.t;
        if (r1 == null) goto L14;
        r1.onResume();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onStart() {
        super.onStart();
        if (r() == false) goto L5;
    L10:
        View r0 = (View) ListProtector.get(this.r, getCurrentSeletecdIndex());
        if ((r0 instanceof AosBaseLayout) == false) goto L16;
        ((AosBaseLayout) r0).onStart();
        return;
    L16:
        return;
    L5:
        if (s() == true) goto L10;
        AosRecommendFeedLayout r1 = this.t;
        if (r1 == null) goto L14;
        r1.onStart();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onStop() {
        super.onStop();
        if (r() == false) goto L5;
    L10:
        View r0 = (View) ListProtector.get(this.r, getCurrentSeletecdIndex());
        if ((r0 instanceof AosBaseLayout) == false) goto L16;
        ((AosBaseLayout) r0).onStop();
        return;
    L16:
        return;
    L5:
        if (s() == true) goto L10;
        AosRecommendFeedLayout r1 = this.t;
        if (r1 == null) goto L14;
        r1.onStop();
        return;
    }

    public final AosFeedsChannelFragment getAosFeedsChannelFragment() {
        return this.i;
    }

    public final AosFollowFeedLayout getAosFollowFeedLayout() {
        return this.s;
    }

    public final AosRecommendFeedLayout getAosRecommendFeedLayout() {
        return this.t;
    }

    public final List<View> getFeedPages() {
        return this.r;
    }

    public final r getRecommendFeedListener() {
        return this.k;
    }

    public static void p(AosFeedsHomeLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (com.bytedance.awemeopen.apps.framework.card.d.a == true) goto L5;
        return;
    L5:
        if (r2.getCurrentSeletecdIndex() != 0) goto L14;
        ViewGroup r0 = r2.p;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r0 = null;
    L9:
        r2.v(r0.getChildAt(r2.getRecommendIndex() + 1));
        AosRecommendFeedLayout r3 = r2.t;
        if (r3 == null) goto L15;
        r3.d0();
        return;
    L15:
        return;
    }

    public static void w(AosBaseLayout r0) {
        if (r0 == null) goto L4;
        r0.onPause();
    L4:
        if (r0 == null) goto L7;
        r0.onStop();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void c(boolean r3) {
        this.g = r3;
        if (r() == false) goto L5;
    L10:
        View r0 = (View) ListProtector.get(this.r, getCurrentSeletecdIndex());
        if ((r0 instanceof AosBaseLayout) == false) goto L13;
        ((AosBaseLayout) r0).c(r3);
    L13:
        post(new a(this));
        return;
    L5:
        if (s() == true) goto L10;
        AosRecommendFeedLayout r1 = this.t;
        if (r1 == null) goto L15;
        r1.c(r3);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (y.a(r2) == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r2, this.l) == false) goto L8;
        return;
    L8:
        v(r2);
    }

    public final void onPageSelected(int r5) {
        Fragment r0 = getParentFragment();
        if ((r0 instanceof AosFeedsHomeFragment) == false) goto L5;
        AosFeedsHomeFragment r1 = (AosFeedsHomeFragment) r0;
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
    L15:
        this.j = r5;
        if (s() == false) goto L20;
        if (r5 != 0) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == false) goto L28;
        w(this.s);
        w(this.t);
        AosBaseLayout<? extends AosViewModel> r6 = this.u;
        if (r6 == null) goto L25;
        r6.onStart();
    L25:
        if (r6 == null) goto L75;
        r6.onResume();
        return;
    L75:
        return;
    L28:
        if (r() == true) goto L31;
    L36:
        boolean r4 = false;
    L37:
        if (r4 == false) goto L53;
        AosFollowFeedLayout r7 = this.s;
        if (r7 != null) goto L41;
    L43:
        if (r2 == false) goto L47;
        AosFollowFeedLayout r8 = this.s;
        if (r8 == null) goto L47;
        r8.b();
    L47:
        w(this.u);
        w(this.t);
        AosFollowFeedLayout r9 = this.s;
        if (r9 == null) goto L50;
        r9.onStart();
    L50:
        if (r9 == null) goto L77;
        r9.onResume();
        return;
    L77:
        return;
    L41:
        if ((!r7.getCreated()) != true) goto L43;
        r2 = true;
        goto L43
    L53:
        if (r() == false) goto L60;
        if (s() == false) goto L60;
        if (r5 == 2) goto L67;
    L68:
        if (r2 == false) goto L79;
        w(this.u);
        w(this.s);
        AosRecommendFeedLayout r10 = this.t;
        if (r10 == null) goto L72;
        r10.onStart();
    L72:
        if (r10 == null) goto L80;
        r10.onResume();
        return;
    L80:
        return;
    L79:
        return;
    L67:
        r2 = true;
    L60:
        if (r() == false) goto L62;
    L66:
        if (r5 != 1) goto L68;
    L62:
        if (s() == true) goto L66;
        if (r5 != 0) goto L68;
    L31:
        if (s() == false) goto L34;
        if (r5 != 1) goto L36;
    L35:
        r4 = true;
        goto L37
    L34:
        if (r5 != 0) goto L36;
    L20:
        r3 = false;
        goto L21
    L9:
        if (s() == false) goto L13;
        if (r5 != 0) goto L13;
        boolean r11 = false;
    L14:
        r1.fa0(r11);
    L13:
        r11 = true;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public final void setAosFeedsChannelFragment(AosFeedsChannelFragment r1) {
        this.i = r1;
    }

    public final void setAosFollowFeedLayout(AosFollowFeedLayout r1) {
        this.s = r1;
    }

    public final void setAosRecommendFeedLayout(AosRecommendFeedLayout r1) {
        this.t = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void setArguments(Bundle r1) {
        setBundle(r1);
    }

    public final void setCurrentSeletecdIndex(int r1) {
        this.j = r1;
    }

    public final void setFeedListContext(jz3.b r3) {
        Intrinsics.checkNotNullParameter(r3, "feedContext");
        this.z = r3;
        final Function0<? extends o54.a> r0 = r3.a;
        r3.a = new AosFeedsHomeLayout$setFeedListContext$wrap$1(this, r0);
        AosRecommendFeedLayout r1 = this.t;
        if (r1 == null) goto L5;
        r1.setFeedListContext(r3);
    L5:
        AosFollowFeedLayout r2 = this.s;
        if (r2 == null) goto L9;
        r2.setFeedListContext(r3);
        return;
    }

    public final void setFeedPageListener(k54.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        AosFollowFeedLayout r0 = this.s;
        if (r0 == null) goto L5;
        r0.setFeedPageListener(r2);
    L5:
        AosRecommendFeedLayout r1 = this.t;
        if (r1 == null) goto L9;
        r1.setFeedPageListener(r2);
        return;
    }

    public final void setFeedPages(List<View> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.r = r2;
    }

    public final void setRecommendFeedListener(r r1) {
        this.k = r1;
    }

    public final void t(Boolean r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r() == false) goto L6;
    L11:
        View r0 = (View) ListProtector.get(this.r, getCurrentSeletecdIndex());
        if ((r0 instanceof AosBaseLayout) == false) goto L18;
        ((AosBaseLayout) r0).c(r3.booleanValue());
        return;
    L18:
        return;
    L6:
        if (s() == true) goto L11;
        AosRecommendFeedLayout r1 = this.t;
        if (r1 == null) goto L16;
        r1.c(r3.booleanValue());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(View r8) {
        ViewGroup r0 = this.p;
        MainTabStripScrollView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerView");
        r0 = null;
    L5:
        int r2 = r0.indexOfChild(r8) - 1;
        d14.a r3 = b14.a.a;
        t24.a r4 = b14.a.a(t24.a.class);
        boolean r5 = true;
        if (s() == false) goto L10;
        if (r2 != 0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L14;
        String r7 = "playlet";
    L26:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.follow.HomeTopTabItemView");
        HomeTopTabItemView r9 = (HomeTopTabItemView) r8;
        r4.V0(r7, x54.b.c(r9.getBadgeView()) ? 1 : 0);
        NoScrollViewPager r10 = this.o;
        if (r10 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r10 = null;
    L29:
        r10.A(r2, false);
        com.bytedance.awemeopen.apps.framework.feed.follow.j r11 = this.m;
        if (r11 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorManager");
        r11 = null;
    L32:
        r11.a(r8);
        if ((r8 instanceof HomeTopTabItemView) == true) goto L36;
        r9 = null;
    L36:
        if (r9 == null) goto L38;
        r9.b.setAlpha(1.0f);
        x54.b.b(r9.a);
    L38:
        View r12 = this.l;
        if ((r12 instanceof HomeTopTabItemView) == false) goto L41;
        HomeTopTabItemView r13 = (HomeTopTabItemView) r12;
    L42:
        if (r13 == null) goto L44;
        r13.b.setAlpha(0.6f);
    L44:
        this.l = r8;
        if (n0.c(getContext()) == false) goto L47;
        return;
    L47:
        if (s() == true) goto L49;
        return;
    L49:
        if (r2 != 0) goto L65;
        View r14 = this.q;
        if (r14 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("tabIndicator");
        r14 = null;
    L53:
        r14.setBackground(ContextCompat.getDrawable(getContext(), 2131231468));
        MainTabStripScrollView r15 = this.n;
        if (r15 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
    L57:
        List<View> r16 = r1.getTabViewList();
        if (r16 == null) goto L92;
        Iterator<T> r17 = r16.iterator();
    L61:
        if (r17.hasNext() == false) goto L94;
        View r18 = (View) r17.next();
        if ((r18 instanceof HomeTopTabItemView) == false) goto L61;
        ((HomeTopTabItemView) r18).setTextColor(ContextCompat.getColor(getContext(), 2131100046));
        goto L61
    L94:
        return;
    L92:
        return;
    L56:
        r1 = r15;
        goto L57
    L65:
        View r19 = this.q;
        if (r19 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("tabIndicator");
        r19 = null;
    L68:
        r19.setBackground(ContextCompat.getDrawable(getContext(), 2131231467));
        MainTabStripScrollView r20 = this.n;
        if (r20 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
    L72:
        List<View> r21 = r1.getTabViewList();
        if (r21 == null) goto L93;
        Iterator<T> r22 = r21.iterator();
    L76:
        if (r22.hasNext() == false) goto L95;
        View r23 = (View) r22.next();
        if ((r23 instanceof HomeTopTabItemView) == false) goto L76;
        ((HomeTopTabItemView) r23).setTextColor(ContextCompat.getColor(getContext(), 2131099738));
        goto L76
    L95:
        return;
    L93:
        return;
    L71:
        r1 = r20;
        goto L72
    L41:
        r13 = null;
        goto L42
    L14:
        if (r() == true) goto L17;
    L22:
        r5 = false;
    L23:
        if (r5 == false) goto L25;
        r7 = "homepage_follow";
        goto L26
    L25:
        r7 = "homepage_hot";
        goto L26
    L17:
        if (s() == false) goto L20;
        if (r2 != 1) goto L22;
    L20:
        if (r2 != 0) goto L22;
    L10:
        r6 = false;
        goto L11
    }

    public AosFeedsHomeLayout(Context r2, AosFeedsChannelFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        this.i = r3;
        this.j = 1;
        this.r = new ArrayList();
    }
}
