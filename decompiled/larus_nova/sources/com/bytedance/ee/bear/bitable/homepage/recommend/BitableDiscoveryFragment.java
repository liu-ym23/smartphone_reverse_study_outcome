package com.bytedance.ee.bear.bitable.homepage.recommend;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.KeyEventDispatcher;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.homepage.j0;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u001fH\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0016J\u001a\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\rH\u0016J\n\u00103\u001a\u0004\u0018\u000104H\u0016J\n\u00105\u001a\u0004\u0018\u000104H\u0016J\b\u00106\u001a\u00020\rH\u0016J\b\u00107\u001a\u00020\u001bH\u0016J\u0010\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020<H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006>"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableDiscoveryFragment;", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendFragment;", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableDiscoveryDelegate;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "presenter", "Lcom/bytedance/ee/bear/templates/center/list/base/BaseTemplateListPresenter;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/bytedance/ee/bear/templates/center/list/base/BaseTemplateListModel;", "templateView", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/BaseHomePageDiscoveryTemplateListView;", "enableFeeds", "", "useTemplateAsDefaultTab", "firstDataInited", "templateRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "templateLoadView", "Lcom/bytedance/ee/bear/list/loadstateview/LoadStateView;", "userFgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "getUserFgService", "()Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "setUserFgService", "(Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;)V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "inflateRootView", "initData", "bindViews", "rootView", "initFeedMode", "onDiscoveryTabClick", "tab", "Lcom/bytedance/ee/bear/templates/data/CategoryTab;", "onTemplateLoadFinish", "isSuccess", "params", "Lcom/bytedance/ee/bear/bitable/homepage/reporter/BitableHomePageV4ConsumerParams;", "isFeedsTabEnable", "getTraceId", "", "getContainerEnv", "enableDefaultTabAsTemplate", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableDiscoveryFragment extends Hilt_BitableDiscoveryFragment implements e, d0c.c {
    public s G;
    public HomePageDiscoveryTemplateListModel H;
    public t I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f212941J;
    public boolean K;
    public boolean L;
    public SmartRefreshLayout M;
    public LoadStateView N;

    @Inject
    public jdb.g O;

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

    @Override // com.bytedance.ee.bear.bitable.homepage.recommend.e
    public final String W9() {
        j0 r100 = this.f212967f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.W9();
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.recommend.e
    public final String getTraceId() {
        j0 r100 = this.f212967f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTraceId();
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendFragment
    public final void initData() {
        if (this.f212941J == true) goto L5;
    L13:
        tt5.a.h("BitableDiscoveryFragment", "enableFeeds :" + this.f212941J);
        return;
    L5:
        if (this.K == true) goto L13;
        if (this.L == false) goto L11;
        tt5.a.h("BitableDiscoveryFragment", "firstDataInited :" + this.L);
        return;
    L11:
        this.L = true;
        super.initData();
    }

    @Override // d0c.c
    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L6;
        KeyEventDispatcher.Component r100 = getActivity();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");
        return ((d0c.c) r100).e9();
    L6:
        return new ce5.a().f23447b;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        j0 r100 = this.f212967f;
        boolean r101 = false;
        if (r100 == null) goto L10;
        String r102 = r100.W9();
        if (r102 == null) goto L10;
        if (r102.equals("larktab_bitable") != true) goto L10;
        r101 = true;
    L10:
        if (r101 == false) goto L12;
        TemplateReportV2 r103 = TemplateReportV2.f238768a;
        Intrinsics.checkNotNullParameter("base_hp_recommend_larktab_bitable", "<set-?>");
        TemplateReportV2.f238770c = "base_hp_recommend_larktab_bitable";
        return;
    L12:
        TemplateReportV2 r104 = TemplateReportV2.f238768a;
        Intrinsics.checkNotNullParameter("base_hp_recommend_workbench", "<set-?>");
        TemplateReportV2.f238770c = "base_hp_recommend_workbench";
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public BitableDiscoveryFragment() {
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.recommend.e
    public final boolean YG() {
        return this.K;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.recommend.e
    public final boolean tc() {
        return this.f212941J;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendFragment
    public final void bindViews(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        if (this.f212941J == true) goto L8;
        SmartRefreshLayout r101 = xZ();
        if (r101 == null) goto L10;
        r101.setVisibility(8);
        return;
    L10:
        return;
    L8:
        super.bindViews(r100);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        s r101 = this.G;
        if (r101 == null) goto L8;
        t r102 = r101.f213058n;
        if (r102 == null) goto L9;
        r102.b();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendFragment, com.bytedance.ee.bear.bitable.homepage.recommend.SpaceBaseTabFragment, com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        jdb.g r101 = this.O;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("userFgService");
        r101 = null;
    L6:
        this.K = r101.isEnable("base.homepage.custom.discovery.tab");
        super.onCreate(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.recommend.e
    public final void xv(CategoryTab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        tt5.a.h("BitableDiscoveryFragment", "onDiscoveryTabClick: " + r100.getSource());
        ViewGroup r101 = null;
        if (r100.getSource() != 99) goto L15;
        this.K = false;
        initData();
        SmartRefreshLayout r102 = xZ();
        if (r102 == null) goto L7;
        r102.setVisibility(0);
    L7:
        SmartRefreshLayout r103 = this.M;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("templateRefreshLayout");
        r103 = null;
    L10:
        r103.setVisibility(8);
        LoadStateView r104 = this.N;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("templateLoadView");
    L14:
        r101.setVisibility(8);
        U90(false);
        return;
    L13:
        r101 = r104;
        goto L14
    L15:
        SmartRefreshLayout r105 = xZ();
        if (r105 == null) goto L18;
        r105.setVisibility(8);
    L18:
        SmartRefreshLayout r106 = this.M;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("templateRefreshLayout");
    L22:
        r101.setVisibility(0);
        U90(true);
        return;
    L21:
        r101 = r106;
        goto L22
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendFragment
    public final View W90(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.fragment_bitable_recommend_v5, r101, false);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.H = new HomePageDiscoveryTemplateListModel(requireActivity());
        this.I = new t(requireActivity(), this, r100, this);
        Context r102 = getContext();
        if (r102 == null) goto L5;
        String r103 = r102.getString(R.string.Doc_List_v4TemplateGallery);
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        tt5.a.h("BitableDiscoveryFragment", "onViewCreated: tabName=" + r103 + ", context=" + getContext() + ", isAdded=" + isAdded() + ", activity=" + getActivity());
        HomePageDiscoveryTemplateListModel r104 = this.H;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.homepage.recommend.HomePageDiscoveryTemplateListModel");
        t r105 = this.I;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.homepage.recommend.HomePageDiscoveryTemplateListView");
        s r106 = new s(this, r104, r105, r103);
        this.G = r106;
        r106.create();
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.recommend.e
    public final void rt(boolean r100, ws4.b r101) {
        j0 r102 = this.f212967f;
        if (r102 == null) goto L6;
        r102.aa(r100, "", r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.recommend.BitableRecommendFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = super.onCreateView(r100, r101, r102);
        this.M = (SmartRefreshLayout) r103.findViewById(R.id.refreshLayout);
        this.N = (LoadStateView) r103.findViewById(R.id.loadStateView);
        return r103;
    }
}
