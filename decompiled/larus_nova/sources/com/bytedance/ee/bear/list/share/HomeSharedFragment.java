package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.CircleRefreshHeader;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.drive.HomeDriveFragment;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.list.homepage.title.MainTabTitleBar;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.list.sort.SortAndFilterFragment;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.sort.SortFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class HomeSharedFragment extends g implements g0, wc5.f.a, dd5.p1, d0c.c {
    public static final /* synthetic */ int B = 0;

    @Inject
    public jdb.g A;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.ee.bear.list.homepage.title.b f229401p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SubMenuView f229402q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public SubMenuViewPad f229403r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public wa5.a f229404s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public yc5.b f229405t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f229406u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f229407v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ConnectionService.NetworkState f229408w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f229409x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public FolderSortStrategy f229410y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public t3 f229411z;

    public class a implements yc5.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HomeSharedFragment f229412a;

        @Override // yc5.b.a
        public final String m6() {
            return "none";
        }

        @Override // yc5.b.a
        public final String getModule() {
            HomeSharedFragment r100 = this.f229412a;
            int r101 = HomeSharedFragment.B;
            r100.getClass();
            return "shared";
        }

        public a(HomeSharedFragment r100) {
            this.f229412a = r100;
        }
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

    @Override // wc5.d
    public final void Cu() {
        t3 r100 = this.f229411z;
        if (r100 == null) goto L8;
        com.bytedance.ee.bear.list.homepage.banner.a r101 = r100.f23388e;
        if (r101 == null) goto L9;
        ((com.bytedance.ee.bear.list.homepage.banner.f) r101.getModel()).m5();
        return;
    L9:
        return;
    }

    @Override // wc5.f.a
    public final void Qi() {
        if (this.A.isCurrentEnable("ccm.space.disable_share_edittime_sort") == false) goto L5;
        int r100 = 1;
    L6:
        ConnectionService.NetworkState r101 = this.f229408w;
        if (r101 != null) goto L9;
    L16:
        Context r102 = this.f226431g;
        Toast.showFailureText(r102, r102.getString(R.string.Doc_Facade_Offline), 0);
        return;
    L9:
        if (r101.a() == false) goto L16;
        lc5.p r103 = new lc5.p("ccm_space_shared_page_click", "shared", "sharetome", "filter", "ccm_space_header_filter_view", "", sbb.e.f541294e.f541317b, "", "", false, false, false, 0, null, "", null);
        lc5.f.f508440a.I(r103);
        Bundle r104 = new Bundle();
        r104.putString("key_token", "shared");
        r104.putParcelable("key_sort_strategy", this.f229410y);
        r104.putInt("key_default_sort_pos", r100);
        if (ca0() == true) goto L13;
    L15:
        ActionSheetDialogFragment.ba0(getActivity(), SortFragment.class, r104);
        return;
    L13:
        if (this.f229403r == null) goto L15;
        ActionSheetDialogFragment.ca0(getActivity(), SortFragment.class, r104, this.f229403r.getIvSortIcon());
        return;
    L5:
        r100 = 2;
        goto L6
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment
    public final void W90() {
        tt5.a.h("HomeSharedFragment", "onDestroyViewLazy()...");
    }

    @Override // wc5.f.a
    public final void eF() {
        ConnectionService.NetworkState r100 = this.f229408w;
        if (r100 != null) goto L5;
    L12:
        Context r101 = this.f226431g;
        Toast.showFailureText(r101, r101.getString(R.string.Doc_Facade_Offline), 0);
        return;
    L5:
        if (r100.a() == false) goto L12;
        lc5.f.f508440a.I(new lc5.p("ccm_space_shared_page_click", "shared", "sharetome", "filter", "ccm_space_header_filter_view", "", sbb.e.f541294e.f541317b, "", "", false, false, false, 0, null, "", null));
        Bundle r102 = getArguments();
        r102.putString("key_module", "shared");
        r102.putString("key_token", "shared");
        r102.putParcelable("key_sort_strategy", this.f229410y);
        r102.putBoolean("key_sort_filter_enable", false);
        r102.putBoolean("key_reset_enable", false);
        r102.putBoolean("key_done_enable", false);
        r102.putBoolean("key_filter_folder", !qc5.a.d());
        if (ForsetiHelper.s(this) == true) goto L9;
    L11:
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r102);
        return;
    L9:
        if (this.f229403r == null) goto L11;
        ActionSheetDialogFragment.ca0(getActivity(), SortAndFilterFragment.class, r102, this.f229403r.getIvFilterIcon());
    }

    @Override // com.bytedance.ee.bear.list.share.g0
    public final void Ud() {
        if (qc5.a.h() == false) goto L5;
        return;
    L5:
        View r100 = this.f229407v;
        if (r100 == null) goto L9;
        r100.setVisibility(0);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment
    public final void Y90() {
        super.Y90();
        t3 r100 = this.f229411z;
        if (r100 == null) goto L8;
        com.bytedance.ee.bear.list.homepage.banner.a r101 = r100.f23388e;
        if (r101 == null) goto L9;
        ((com.bytedance.ee.bear.list.homepage.banner.f) r101.getModel()).m5();
        return;
    L9:
        return;
    }

    public final boolean ca0() {
        if (ForsetiHelper.n() == true) goto L5;
    L9:
        return false;
    L5:
        if (getParentFragment() == null) goto L9;
        if ((getParentFragment() instanceof wc5.h) == false) goto L9;
        return true;
    }

    public final boolean da0() {
        if (qc5.a.c() == true) goto L5;
    L9:
        return false;
    L5:
        if (getParentFragment() == null) goto L9;
        if ((getParentFragment() instanceof HomeDriveFragment) == false) goto L9;
        return true;
    }

    @Override // d0c.c
    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return ((d0c.c) getActivity()).e9();
    L7:
        return new ce5.a().f23447b;
    }

    @Override // com.bytedance.ee.bear.list.share.g, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("HomeSharedFragment", "onDestroy()...");
        yc5.b r100 = this.f229405t;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        t3 r101 = this.f229411z;
        if (r101 == null) goto L14;
        com.bytedance.ee.bear.list.homepage.banner.a r102 = r101.f23388e;
        if (r102 == null) goto L10;
        r102.destroy();
    L10:
        yc5.b r103 = r101.f23390g;
        if (r103 == null) goto L13;
        r103.b();
    L13:
        dd5.s1.a.f468004a.h(r101);
    L14:
        dd5.s1.a.f468004a.h(this);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public HomeSharedFragment() {
    }

    @Override // dd5.p1
    public final void Mj(boolean r100) {
        this.f229402q.b(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment
    public final void V90(Bundle r110) {
        Z90(R.layout.list_home_shared);
        if ((getActivity() instanceof wc5.g) == false) goto L5;
        this.f229401p = ((wc5.g) getActivity()).getTitleBar();
    L5:
        SmartRefreshLayout r111 = (SmartRefreshLayout) findViewById(R.id.list_refresh_layout);
        wc5.e r100 = (wc5.e) getChildFragmentManager().findFragmentById(R.id.list_home_sub_fragment);
        if (r100 == null) goto L9;
        r100.Co(r111);
    L9:
        if (da0() == true) goto L18;
        View r101 = findViewById(R.id.list_appbar_refresh_header);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().f217118a == false) goto L14;
        r101.setVisibility(0);
        this.f229404s = (wa5.a) r101;
    L15:
        cqa.e r102 = r111.getRefreshHeader();
        if ((r102 instanceof wa5.a) == false) goto L18;
        this.f229404s.setCustomText(getString(R.string.Doc_List_RefreshDocTips));
        ((wa5.a) r102).setAssociatedHeader(this.f229404s);
        goto L18
    L14:
        View r103 = findViewById(R.id.list_appbar_refresh_lean_header);
        r103.setVisibility(0);
        r101.setVisibility(8);
        this.f229404s = (wa5.a) r103;
    L18:
        ((AppBarLayout) findViewById(R.id.list_sub_menu_layout)).addOnOffsetChangedListener(new b0(this));
        ce5.a r104 = new ce5.a(this);
        boolean r105 = qc5.a.d();
        View r106 = findViewById(R.id.header_banner_view);
        if (r105 == false) goto L21;
        int r107 = 0;
    L22:
        r106.setVisibility(r107);
        if (qc5.a.h() == false) goto L25;
        r106.setVisibility(8);
    L27:
        CollapsingToolbarLayout r108 = (CollapsingToolbarLayout) findViewById(R.id.list_collapsing_layout);
        if (r108 == null) goto L52;
        Object r109 = this.f229404s;
        if (r109 == null) goto L52;
        if ((r109 instanceof ViewGroup) == false) goto L52;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) ((ViewGroup) r109).getLayoutParams();
        com.bytedance.ee.bear.list.homepage.title.b r113 = this.f229401p;
        if (r113 == null) goto L43;
        if ((r113 instanceof com.bytedance.ee.bear.list.homepage.title.c) == false) goto L39;
    L48:
        r112.topMargin = 0;
    L49:
        ((ViewGroup) this.f229404s).setLayoutParams(r112);
        com.bytedance.ee.bear.list.homepage.title.b r114 = this.f229401p;
        if (r114 == null) goto L52;
        r108.setMinimumHeight(r114.getTitleBarHeight());
        goto L52
    L39:
        if ((r113 instanceof MainTabTitleBar) == true) goto L48;
        if (r113.getTitleType() == HomeMainTitleBar.TitleType.SPACE_ROUTE.ordinal()) goto L48;
    L43:
        if (ca0() == true) goto L48;
        if (ForsetiHelper.s(this) == true) goto L48;
        r112.topMargin = getResources().getDimensionPixelSize(R.dimen.list_home_title_search_height);
    L52:
        this.f229402q = (SubMenuView) findViewById(R.id.home_sub_title_view);
        dd5.s1.a.f468004a.a(this);
        if (ca0() == false) goto L62;
        this.f229402q.setVisibility(8);
        if (getParentFragment() != null) goto L57;
    L59:
        SubMenuViewPad r115 = this.f229403r;
        if (r115 == null) goto L64;
        r115.setViewDelegate(this);
        this.f229403r.e();
    L64:
        if (da0() == false) goto L74;
        this.f229402q.c();
        AppCompatImageView r116 = this.f229402q.f228384c;
        if (r116 == null) goto L68;
        r116.setVisibility(8);
    L68:
        findViewById(R.id.list_appbar_refresh_header).setVisibility(8);
        findViewById(R.id.list_refresh_header).setVisibility(8);
        findViewById(R.id.list_appbar_refresh_lean_header).setVisibility(8);
        findViewById(R.id.list_collapsing_layout).setMinimumHeight(0);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().f217118a == false) goto L71;
        wa5.a r117 = new DigitDanceHeader(getContext());
        r117.setCustomText(getString(R.string.Doc_List_RefreshDocTips));
    L72:
        r111.G(r117, com.bytedance.ee.util.ui.n.d(65));
        goto L74
    L71:
        r117 = new CircleRefreshHeader(getContext());
    L74:
        if (ca0() == false) goto L76;
    L77:
        findViewById(R.id.list_collapsing_layout).setMinimumHeight(0);
    L78:
        this.f229405t = new yc5.b(this.f226431g, r111, new a(this));
        this.f229406u = findViewById(R.id.no_net_container);
        this.f229407v = findViewById(R.id.history_shared_folder);
        findViewById(R.id.hyperlink).setOnClickListener(new c0());
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(this, new z(this));
        if (getActivity() == null) goto L81;
        ((SortAndFilterViewModel) ViewModelProviders.of(getActivity()).get(SortAndFilterViewModel.class)).getSortStrategyLiveData().observe(this, new a0(this));
    L81:
        dd5.s1.a.f468004a.a(this);
        return;
    L76:
        if (ForsetiHelper.s(this) == false) goto L78;
    L57:
        if (getParentFragment().getView() == null) goto L59;
        this.f229403r = (SubMenuViewPad) getParentFragment().getView().findViewById(R.id.sub_menu_view_pad);
        goto L59
    L62:
        this.f229402q.setViewDelegate(this);
        Mj(com.bytedance.ee.bear.list.t3.f229771a);
        goto L64
    L25:
        if (r105 == false) goto L27;
        this.f229411z = new t3(this, getContext(), r106, r104);
        goto L27
    L21:
        r107 = 8;
        goto L22
    }

    @Override // wc5.f.a
    public final void WU(boolean r110) {
        Mj(r110);
        dd5.s1.a.f468004a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r110, "shared");
        lc5.r r111 = new lc5.r("ccm_space_shared_page_click", "shared", "sharetome", "", sbb.e.f541294e.f541317b, false, false, false, 0, "");
        lc5.f.f508440a.O(r111);
    }

    @Override // com.bytedance.ee.bear.list.share.g, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
        tt5.a.h("HomeSharedFragment", "onAttach()...");
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        tt5.a.h("HomeSharedFragment", "onCreate()...");
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().getWindow() != null) goto L7;
        return;
    L7:
        if (((Boolean) ForsetiHelper.f216449k.getValue()).booleanValue() == false) goto L12;
        getActivity().getWindow().setSoftInputMode(32);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        tt5.a.h("HomeSharedFragment", "onSaveInstanceState()...");
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment, androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        if (r100 == true) goto L5;
        return;
    L5:
        if (ca0() == false) goto L11;
        SubMenuViewPad r101 = this.f229403r;
        if (r101 == null) goto L12;
        r101.setViewDelegate(this);
        this.f229403r.e();
        return;
    L12:
        return;
    }

    @Override // wc5.d
    public final void t(int r100, int r101) {
        if (da0() == false) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.list.homepage.title.b r102 = this.f229401p;
        if (r102 == null) goto L9;
        r102.a(r101);
        return;
    }
}
