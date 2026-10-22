package com.bytedance.ee.bear.bitable.homepage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.homepage.chart.ChartConfig;
import com.bytedance.ee.bear.bitable.homepage.chart.home.ChartListDecoration;
import com.bytedance.ee.bear.bitable.homepage.chart.home.ChartListViewModel;
import com.bytedance.ee.bear.bitable.homepage.chart.home.ChartReportHelper$observeDataSetChanged$1;
import com.bytedance.ee.bear.bitable.homepage.chart.home.ChartReportHelper$observeRecyclerViewScrolled$1;
import com.bytedance.ee.bear.bitable.homepage.chart.home.edit.ChartItemTouchHelper;
import com.bytedance.ee.bear.bitable.homepage.chart.home.edit.ChartTouchCallback;
import com.bytedance.ee.bear.bitable.homepage.chart.widget.stickyheader.StickyLinearLayoutManager;
import com.bytedance.ee.bear.bitable.homepage.recommend.widget.BitableRecommendHeaderView;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes15.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 d2\u00020\u00012\u00020\u0002:\u0002cdB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010I\u001a\u00020JH\u0016J\u0012\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J$\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u001a\u0010U\u001a\u00020L2\u0006\u0010V\u001a\u00020P2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010W\u001a\u00020LH\u0016J\b\u0010X\u001a\u00020LH\u0002J\u0010\u0010Y\u001a\u00020L2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020LH\u0002J\b\u0010[\u001a\u00020LH\u0002J\u0006\u0010\\\u001a\u00020\fJ\u0018\u0010]\u001a\u00020L2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0002J\u000e\u0010b\u001a\u00020L2\u0006\u0010S\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b\"\u0010#R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001b\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001b\u001a\u0004\b2\u00103R\u001e\u00105\u001a\u0002068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001b\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u001b\u001a\u0004\bF\u0010G¨\u0006e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/BitableHomePageFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "rvWaterfall", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "refreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "homeViewContainer", "Lcom/bytedance/ee/bear/bitable/homepage/IHomeViewContainer;", "isVisibleToUser", "", "scrollOffset", "", "Ljava/lang/Integer;", "homeViewV4Delegate", "Lcom/bytedance/ee/bear/bitable/homepage/IBitableHomeV4Delegate;", "getHomeViewV4Delegate", "()Lcom/bytedance/ee/bear/bitable/homepage/IBitableHomeV4Delegate;", "setHomeViewV4Delegate", "(Lcom/bytedance/ee/bear/bitable/homepage/IBitableHomeV4Delegate;)V", "chartListViewModel", "Lcom/bytedance/ee/bear/bitable/homepage/chart/home/ChartListViewModel;", "getChartListViewModel", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/home/ChartListViewModel;", "chartListViewModel$delegate", "Lkotlin/Lazy;", "statisticService", "Lcom/bytedance/ee/bear/bitable/statistic/IBitableStatisticService;", "fpsTrace", "Lcom/bytedance/ee/bear/bitable/statistic/IBitableFpsTrace;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "chartDataFetcher", "Lcom/bytedance/ee/bear/bitable/homepage/chart/datasource/IChartDataFetcher;", "getChartDataFetcher", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/datasource/IChartDataFetcher;", "setChartDataFetcher", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/datasource/IChartDataFetcher;)V", "chartDataFetcherHelper", "Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartDataFetcherHelper;", "getChartDataFetcherHelper", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartDataFetcherHelper;", "chartDataFetcherHelper$delegate", "chartReportHelper", "Lcom/bytedance/ee/bear/bitable/homepage/chart/home/ChartReportHelper;", "getChartReportHelper", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/home/ChartReportHelper;", "chartReportHelper$delegate", "lynxContainerProvider", "Lcom/bytedance/ee/bear/bitable/homepage/chart/container/IChartLynxContainerProvider;", "getLynxContainerProvider", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/container/IChartLynxContainerProvider;", "setLynxContainerProvider", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/container/IChartLynxContainerProvider;)V", "adapter", "Lcom/bytedance/ee/bear/bitable/homepage/BitableHomePageAdapter;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "chartItemTouchHelper", "Lcom/bytedance/ee/bear/bitable/homepage/chart/home/edit/ChartItemTouchHelper;", "getChartItemTouchHelper", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/home/edit/ChartItemTouchHelper;", "chartItemTouchHelper$delegate", "chartListDecoration", "Lcom/bytedance/ee/bear/bitable/homepage/chart/home/ChartListDecoration;", "getChartListDecoration", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/home/ChartListDecoration;", "chartListDecoration$delegate", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", LiveCommonConstants.REASON_ON_DEDTROY, "initRefreshLayout", "setUserVisibleHint", "initRecyclerView", "observe", "tryExitEditMode", "updateChartData", "chartToken", "", "chartData", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/HomepageChartData;", "setHomeViewContainer", "RecentItemTouchListener", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableHomePageFragment extends Hilt_BitableHomePageFragment implements d0c.c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f212176w = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonRecyclerView f212177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SmartRefreshLayout f212178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k0 f212179h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f212180i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j0 f212181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f212182k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.statistic.m f212183l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.statistic.c f212184m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f212185n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Inject
    public com.bytedance.ee.bear.bitable.homepage.chart.datasource.e f212186o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f212187p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f212188q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Inject
    public ks4.k f212189r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public BitableHomePageAdapter f212190s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public StickyLinearLayoutManager f212191t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f212192u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f212193v;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/BitableHomePageFragment$RecentItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "homeViewContainer", "Lcom/bytedance/ee/bear/bitable/homepage/IHomeViewContainer;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/bytedance/ee/bear/bitable/homepage/IHomeViewContainer;)V", "startY", "", "targetItemView", "Landroid/view/View;", "onInterceptTouchEvent", "", "rv", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "findChildViewUnder", "x", "y", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecentItemTouchListener implements RecyclerView.OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final void onRequestDisallowInterceptTouchEvent(boolean r100) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final void onTouchEvent(RecyclerView r100, MotionEvent r101) {
            Intrinsics.checkNotNullParameter(r100, "rv");
            Intrinsics.checkNotNullParameter(r101, "e");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
            Intrinsics.checkNotNullParameter(r100, "rv");
            Intrinsics.checkNotNullParameter(r101, "e");
            int r102 = r101.getAction();
            if (r102 != 0) goto L5;
            r101.getRawY();
            r101.getX();
            r101.getY();
            throw null;
        L5:
            if (r102 != 2) goto L12;
            r101.getRawY();
            return false;
        L12:
            return false;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final com.bytedance.ee.bear.bitable.homepage.chart.datasource.e T90() {
        com.bytedance.ee.bear.bitable.homepage.chart.datasource.e r100 = this.f212186o;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("chartDataFetcher");
        return null;
    }

    public final ChartListViewModel U90() {
        return (ChartListViewModel) this.f212182k.getValue();
    }

    public BitableHomePageFragment() {
        this.f212180i = 0;
        this.f212182k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChartListViewModel.class), new BitableHomePageFragment$special$$inlined$activityViewModels$default$1(this), new BitableHomePageFragment$special$$inlined$activityViewModels$default$2(this));
        this.f212185n = LazyKt.lazy(BitableHomePageFragment$mainHandler$2.INSTANCE);
        this.f212187p = LazyKt.lazy(new BitableHomePageFragment$chartDataFetcherHelper$2(this));
        this.f212188q = LazyKt.lazy(BitableHomePageFragment$chartReportHelper$2.INSTANCE);
        this.f212192u = LazyKt.lazy(BitableHomePageFragment$chartItemTouchHelper$2.INSTANCE);
        this.f212193v = LazyKt.lazy(BitableHomePageFragment$chartListDecoration$2.INSTANCE);
    }

    public final boolean V90() {
        if (Intrinsics.areEqual(U90().isEditModeLiveData().getValue(), Boolean.TRUE) == false) goto L6;
        U90().changeEditMode();
        return true;
    L6:
        return false;
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        BitableHomePageAdapter r100 = this.f212190s;
        ks4.k r101 = null;
        if (r100 == null) goto L9;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r100 = null;
    L6:
        Disposable r102 = r100.f212165l.f551482b;
        if (r102 == null) goto L9;
        r102.dispose();
    L9:
        ks4.k r103 = this.f212189r;
        if (r103 == null) goto L12;
        r101 = r103;
    L13:
        r101.reset();
        com.bytedance.ee.bear.bitable.statistic.c r104 = this.f212184m;
        if (r104 == null) goto L17;
        r104.b(Boolean.TRUE);
        return;
    L17:
        return;
    L12:
        Intrinsics.throwUninitializedPropertyAccessException("lynxContainerProvider");
        goto L13
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f212179h == null) goto L5;
    L10:
        T90().c(this);
        U90().setHomePageDelegate(this.f212181j);
        ChartListViewModel.fetchData$default(U90(), true, true, false, 4, null);
        this.f212183l = (com.bytedance.ee.bear.bitable.statistic.m) ClaymoreServiceLoader.loadFirst(com.bytedance.ee.bear.bitable.statistic.m.class);
        return;
    L5:
        if ((getParentFragment() instanceof k0) == false) goto L7;
        ActivityResultCaller r101 = getParentFragment();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.homepage.IHomeViewContainer");
        this.f212179h = (k0) r101;
        goto L10
    L7:
        tt5.a.d("BitableHomePageFragment", "homeViewContainer can not initialized, finish");
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L10;
        r102.finish();
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        if (r100 == false) goto L23;
        Integer r101 = this.f212180i;
        if (r101 != null) goto L8;
    L12:
        j0 r102 = this.f212181j;
        if (r102 == null) goto L15;
        r102.X9(1, false);
    L15:
        Context r103 = getContext();
        if (r103 == null) goto L24;
        Resources r104 = r103.getResources();
        if (r104 == null) goto L25;
        j0 r105 = this.f212181j;
        if (r105 == null) goto L26;
        r105.Y9(r104.getString(R.string.Bitable_Home_Base_Tab));
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L8:
        if (r101.intValue() != 0) goto L12;
        j0 r106 = this.f212181j;
        if (r106 == null) goto L15;
        r106.X9(0, false);
        goto L15
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new BitableHomePageFragment$observe$1(this, null));
        U90().getAllChartListLiveData().observe(getViewLifecycleOwner(), new o(this));
        U90().isEditModeLiveData().observe(getViewLifecycleOwner(), new p(this));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new BitableHomePageFragment$observe$4(this, null));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new BitableHomePageFragment$observe$5(this, null));
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        int r100 = 0;
        View r113 = r110.inflate(R.layout.fragment_bitable_home_page, r111, false);
        this.f212178g = (SmartRefreshLayout) r113.findViewById(R.id.hp_refresh_layout);
        this.f212177f = (CommonRecyclerView) r113.findViewById(R.id.hp_rv_waterfall);
        FrameLayout r114 = (FrameLayout) r113.findViewById(R.id.hp_rv_container);
        int r101 = getResources().getDimensionPixelSize(R.dimen.bitable_cell_page_horizon_margin);     // Catch: Resources.NotFoundException -> L5
    L7:
        ViewGroup.LayoutParams r102 = r114.getLayoutParams();
        CommonRecyclerView r103 = null;
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r102;
    L11:
        if (r104 == null) goto L13;
        r104.setMargins(r101, 0, r101, 0);
        r114.setLayoutParams(r104);
    L13:
        SmartRefreshLayout r115 = this.f212178g;
        if (r115 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r115 = null;
    L16:
        r115.W = new m(this);
        BitableRecommendHeaderView r116 = new BitableRecommendHeaderView(requireContext(), null, 6, 0);
        SmartRefreshLayout r105 = this.f212178g;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r105 = null;
    L19:
        r105.G(r116, -2);
        ViewGroup.LayoutParams r117 = r116.getIvLoading().getLayoutParams();
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r117;
    L23:
        if (r118 == null) goto L25;
        r118.bottomMargin = UIHelper.getDimens(R.dimen.dp_16);
    L25:
        SmartRefreshLayout r119 = this.f212178g;
        if (r119 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r119 = null;
    L28:
        r119.g(false);
        SmartRefreshLayout r120 = this.f212178g;
        if (r120 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r120 = null;
    L31:
        r120.I = false;
        SmartRefreshLayout r121 = this.f212178g;
        if (r121 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r121 = null;
    L34:
        r121.f405859J = false;
        CommonRecyclerView r122 = this.f212177f;
        if (r122 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
        r122 = null;
    L37:
        DefaultItemAnimator r106 = new DefaultItemAnimator();
        r106.setAddDuration(150);
        r106.setRemoveDuration(150);
        r106.setChangeDuration(150);
        r106.setMoveDuration(150);
        r122.setItemAnimator(r106);
        com.bytedance.ee.bear.bitable.statistic.m r123 = this.f212183l;
        if (r123 == null) goto L40;
        com.bytedance.ee.bear.bitable.statistic.c r124 = r123.createDefaultFpsTrace("native_home_homepage", true, true, null);
    L41:
        this.f212184m = r124;
        if (r124 == null) goto L47;
        CommonRecyclerView r107 = this.f212177f;
        if (r107 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
        r107 = null;
    L46:
        r124.f(r107);
    L47:
        CommonRecyclerView r125 = this.f212177f;
        if (r125 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
        r125 = null;
    L50:
        r125.setHasFixedSize(true);
        CommonRecyclerView r126 = this.f212177f;
        if (r126 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
        r126 = null;
    L53:
        r126.setSceneTag("bitable_homepage_with_charts");
        FragmentActivity r108 = requireActivity();
        k0 r109 = this.f212179h;
        if (r109 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("homeViewContainer");
        k0 r127 = null;
    L57:
        this.f212190s = new BitableHomePageAdapter(r108, r127, U90(), T90(), this.f212181j);
        CommonRecyclerView r128 = this.f212177f;
        if (r128 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
        r128 = null;
    L60:
        BitableHomePageAdapter r129 = this.f212190s;
        if (r129 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r129 = null;
    L63:
        r128.setAdapter(r129);
        CommonRecyclerView r130 = this.f212177f;
        if (r130 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
        r130 = null;
    L66:
        Context r131 = r130.getContext();
        BitableHomePageAdapter r132 = this.f212190s;
        if (r132 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r132 = null;
    L69:
        f r133 = r132.f212160g;
        BitableHomePageAdapter r134 = this.f212190s;
        if (r134 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r134 = null;
    L72:
        this.f212191t = new StickyLinearLayoutManager(r131, r133, r134.f212159f);
        CommonRecyclerView r135 = this.f212177f;
        if (r135 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
        r135 = null;
    L75:
        StickyLinearLayoutManager r136 = this.f212191t;
        if (r136 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r136 = null;
    L78:
        r135.setLayoutManager(r136);
        CommonRecyclerView r137 = this.f212177f;
        if (r137 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
        r137 = null;
    L81:
        r137.addItemDecoration((ChartListDecoration) this.f212193v.getValue());
        BitableHomePageAdapter r138 = this.f212190s;
        if (r138 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r138 = null;
    L84:
        ChartItemTouchHelper r139 = (ChartItemTouchHelper) this.f212192u.getValue();
        r138.f212170q = r139;
        if (r139 == null) goto L87;
        l r140 = r138.f212168o;
        Intrinsics.checkNotNullParameter(r140, "moveListener");
        ChartTouchCallback r141 = r139.f212535a;
        r141.getClass();
        Intrinsics.checkNotNullParameter(r140, "moveListener");
        r141.f212537b = r140;
    L87:
        ChartItemTouchHelper r142 = (ChartItemTouchHelper) this.f212192u.getValue();
        CommonRecyclerView r143 = this.f212177f;
        if (r143 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
        r143 = null;
    L90:
        r142.attachToRecyclerView(r143);
        com.bytedance.ee.bear.bitable.homepage.chart.i r144 = (com.bytedance.ee.bear.bitable.homepage.chart.i) this.f212187p.getValue();
        CommonRecyclerView r145 = this.f212177f;
        if (r145 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
        r145 = null;
    L93:
        BitableHomePageAdapter r146 = this.f212190s;
        if (r146 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r146 = null;
    L96:
        r144.b(r145, r146);
        final com.bytedance.ee.bear.bitable.homepage.chart.home.a r147 = (com.bytedance.ee.bear.bitable.homepage.chart.home.a) this.f212188q.getValue();
        CommonRecyclerView r148 = this.f212177f;
        if (r148 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
        r148 = null;
    L99:
        BitableHomePageAdapter r149 = this.f212190s;
        if (r149 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r149 = null;
    L102:
        j0 r150 = this.f212181j;
        if (r150 == null) goto L105;
        String r151 = r150.W9();
    L106:
        j0 r152 = this.f212181j;
        if (r152 == null) goto L109;
        String r153 = r152.Z9();
    L110:
        r147.getClass();
        Intrinsics.checkNotNullParameter(r148, "recyclerView");
        Intrinsics.checkNotNullParameter(r149, "chartEntityProvider");
        r147.f212496a = r148;
        r147.f212499d = r149;
        r147.f212500e = r151;
        r147.f212501f = r153;
        RecyclerView.Adapter<?> r154 = r148.getAdapter();
        if (r154 != null) goto L119;
        LarkAppContext.Companion.getClass();
        if (DevEnvUtil.isDebugMode(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L118;
        if (DevEnvUtil.isDevelopPackage(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L118;
        tt5.a.e("ChartReportHelper", "recyclerView must have an adapter", new RuntimeException("recyclerView must have an adapter"), false);
    L135:
        ChartConfig r155 = (ChartConfig) SettingManager.getInstance().get(ChartConfig.class);
        if (r155 != null) goto L138;
        r155 = new ChartConfig();
    L138:
        int r156 = com.bytedance.ee.bear.bitable.homepage.chart.utils.b.f212636b;
        if (com.bytedance.ee.bear.bitable.homepage.chart.utils.b.a(requireContext()) <= (((long) r155.g()) * 1073741824)) goto L141;
        r100 = r155.f();
    L141:
        tt5.a.h("BitableHomePageFragment", "setItemViewCacheSize " + r100);
        CommonRecyclerView r157 = this.f212177f;
        if (r157 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
        r157 = null;
    L144:
        r157.setItemViewCacheSize(r100);
        CommonRecyclerView r158 = this.f212177f;
        if (r158 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("rvWaterfall");
    L148:
        r103.addOnScrollListener(new BitableHomePageFragment$initRecyclerView$2(this));
        Intrinsics.checkNotNull(r113);
        return r113;
    L147:
        r103 = r158;
    L118:
        throw new RuntimeException("recyclerView must have an adapter");
    L119:
        r147.f212498c = r154;
        RecyclerView.LayoutManager r159 = r148.getLayoutManager();
        if ((r159 instanceof LinearLayoutManager) == true) goto L128;
        LarkAppContext.Companion.getClass();
        if (DevEnvUtil.isDebugMode(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L127;
        if (DevEnvUtil.isDevelopPackage(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L127;
        tt5.a.e("ChartReportHelper", "recyclerView must use LinearLayoutManager", new RuntimeException("recyclerView must use LinearLayoutManager"), false);
    L127:
        throw new RuntimeException("recyclerView must use LinearLayoutManager");
    L128:
        r147.f212497b = (LinearLayoutManager) r159;
        r147.c();
        RecyclerView.Adapter<?> r160 = r147.f212498c;
        if (r160 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r160 = null;
    L131:
        r160.registerAdapterDataObserver(new ChartReportHelper$observeDataSetChanged$1(r147));
        r147.c();
        RecyclerView r161 = r147.f212496a;
        if (r161 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r161 = null;
    L134:
        r161.addOnScrollListener(new ChartReportHelper$observeRecyclerViewScrolled$1(r147));
        goto L135
    L109:
        r153 = null;
        goto L110
    L105:
        r151 = null;
        goto L106
    L56:
        r127 = r109;
        goto L57
    L40:
        r124 = null;
        goto L41
    L22:
        r118 = null;
        goto L23
    L10:
        r104 = null;
    L5:
        e = move-exception;
        tt5.a.e("BitableHomePageFragment", "getDimensionPixelSize bitable_cell_page_horizon_margin failed, fallback 16dp", e, false);
        r101 = UIHelper.dp2px(16.0f);
        goto L7
    }
}
