package com.bytedance.ee.bear.list.folder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.lazy.LazyFragment;
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
import com.bytedance.ee.bear.list.sort.SortScene;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import dd5.p1;
import dd5.s1;
import lc5.p;
import lc5.r;
import uc5.a2;
import uc5.b2;
import uc5.c2;

/* JADX INFO: loaded from: classes18.dex */
public class HomePersonalFragment extends LazyFragment implements wc5.d, wc5.f.a, p1 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f228018w = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.ee.bear.list.homepage.title.b f228019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SubMenuView f228020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SubMenuViewPad f228021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public wa5.a f228022q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public yc5.b f228023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f228024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ConnectionService.NetworkState f228025t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f228026u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FolderSortStrategy f228027v;

    public class a implements yc5.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HomePersonalFragment f228028a;

        @Override // yc5.b.a
        public final String m6() {
            return "none";
        }

        @Override // yc5.b.a
        public final String getModule() {
            HomePersonalFragment r100 = this.f228028a;
            int r101 = HomePersonalFragment.f228018w;
            r100.getClass();
            return WikiSpaceType.PERSONAL;
        }

        public a(HomePersonalFragment r100) {
            this.f228028a = r100;
        }
    }

    @Override // wc5.d
    public final void Cu() {
    }

    public String ca0() {
        return "my_root";
    }

    public int getContentViewLayoutId() {
        return R.layout.list_home_personal;
    }

    @Override // wc5.f.a
    public final void Qi() {
        ConnectionService.NetworkState r100 = this.f228025t;
        if (r100 != null) goto L5;
    L12:
        Context r101 = this.f226431g;
        Toast.showFailureText(r101, r101.getString(R.string.Doc_Facade_Offline), 0);
        return;
    L5:
        if (r100.a() == false) goto L12;
        qc5.a.j();
        p r102 = new p("ccm_space_drive_page_click", WikiSpaceType.PERSONAL, "none", "filter", "ccm_space_header_filter_view", "", sbb.e.f541294e.f541317b, "", "", false, false, false, 0, null, "", null);
        lc5.f.f508440a.I(r102);
        Bundle r103 = new Bundle();
        r103.putString("key_token", ca0());
        r103.putInt("key_default_sort_pos", 0);
        r103.putParcelable("key_sort_strategy", this.f228027v);
        if (ForsetiHelper.s(this) == true) goto L9;
    L11:
        ActionSheetDialogFragment.ba0(getActivity(), SortFragment.class, r103);
        return;
    L9:
        if (this.f228021p == null) goto L11;
        ActionSheetDialogFragment.ca0(getActivity(), SortFragment.class, r103, this.f228021p.getIvSortIcon());
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment
    public final void W90() {
        tt5.a.h("HomePersonalFragment", "onDestroyViewLazy()...");
    }

    @Override // wc5.f.a
    public final void eF() {
        ConnectionService.NetworkState r100 = this.f228025t;
        if (r100 != null) goto L5;
    L7:
        Context r101 = this.f226431g;
        Toast.showFailureText(r101, r101.getString(R.string.Doc_Facade_Offline), 0);
        return;
    L5:
        if (r100.a() == false) goto L7;
        qc5.a.j();
        p r102 = new p("ccm_space_drive_page_click", WikiSpaceType.PERSONAL, "none", "filter", "ccm_space_header_filter_view", "", sbb.e.f541294e.f541317b, "", "", false, false, false, 0, null, "", null);
        lc5.f.f508440a.I(r102);
        Bundle r103 = getArguments();
        r103.putString("key_module", WikiSpaceType.PERSONAL);
        r103.putString("key_token", ca0());
        r103.putParcelable("key_sort_strategy", this.f228027v);
        r103.putBoolean("key_sort_filter_enable", false);
        r103.putBoolean("key_filter_folder", true);
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r103);
    }

    public final boolean da0() {
        if (ForsetiHelper.n() == true) goto L5;
    L9:
        return false;
    L5:
        if (getParentFragment() == null) goto L9;
        if ((getParentFragment() instanceof wc5.h) == false) goto L9;
        return true;
    }

    public final boolean ea0() {
        if (qc5.a.c() == true) goto L7;
        if (qc5.a.h() == true) goto L7;
    L11:
        return false;
    L7:
        if (getParentFragment() == null) goto L11;
        if ((getParentFragment() instanceof HomeDriveFragment) == false) goto L11;
        return true;
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("HomePersonalFragment", "onDestroy()...");
        yc5.b r100 = this.f228023r;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        s1.a.f468004a.h(this);
    }

    public HomePersonalFragment() {
    }

    public SortScene ba0() {
        return SortScene.FolderSort;
    }

    @Override // dd5.p1
    public final void Mj(boolean r100) {
        this.f228020o.b(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment
    public final void V90(Bundle r110) {
        Z90(getContentViewLayoutId());
        if ((getActivity() instanceof wc5.g) == false) goto L5;
        this.f228019n = ((wc5.g) getActivity()).getTitleBar();
    L5:
        SmartRefreshLayout r111 = (SmartRefreshLayout) findViewById(R.id.list_refresh_layout);
        wc5.e r100 = (wc5.e) getChildFragmentManager().findFragmentById(R.id.list_home_sub_fragment);
        if (r100 == null) goto L9;
        r100.Co(r111);
    L9:
        if (ea0() == true) goto L18;
        View r101 = findViewById(R.id.list_appbar_refresh_header);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().f217118a == false) goto L14;
        r101.setVisibility(0);
        this.f228022q = (wa5.a) r101;
    L15:
        cqa.e r102 = r111.getRefreshHeader();
        if ((r102 instanceof wa5.a) == false) goto L18;
        this.f228022q.setCustomText(getString(R.string.Doc_List_RefreshDocTips));
        ((wa5.a) r102).setAssociatedHeader(this.f228022q);
        goto L18
    L14:
        View r103 = findViewById(R.id.list_appbar_refresh_lean_header);
        r103.setVisibility(0);
        r101.setVisibility(8);
        this.f228022q = (wa5.a) r103;
    L18:
        ((AppBarLayout) findViewById(R.id.list_sub_menu_layout)).addOnOffsetChangedListener(new c2(this));
        CollapsingToolbarLayout r104 = (CollapsingToolbarLayout) findViewById(R.id.list_collapsing_layout);
        if (r104 == null) goto L41;
        Object r105 = this.f228022q;
        if (r105 == null) goto L41;
        if ((r105 instanceof ViewGroup) == false) goto L41;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) ((ViewGroup) r105).getLayoutParams();
        com.bytedance.ee.bear.list.homepage.title.b r107 = this.f228019n;
        if (r107 == null) goto L34;
        if ((r107 instanceof com.bytedance.ee.bear.list.homepage.title.c) == false) goto L30;
    L35:
        r106.topMargin = 0;
    L37:
        ((ViewGroup) this.f228022q).setLayoutParams(r106);
        com.bytedance.ee.bear.list.homepage.title.b r108 = this.f228019n;
        if (r108 == null) goto L41;
        r104.setMinimumHeight(r108.getTitleBarHeight());
        goto L41
    L30:
        if ((r107 instanceof MainTabTitleBar) == true) goto L35;
        if (r107.getTitleType() == HomeMainTitleBar.TitleType.SPACE_ROUTE.ordinal()) goto L35;
    L34:
        if (da0() == true) goto L35;
        r106.topMargin = getResources().getDimensionPixelSize(R.dimen.list_home_title_search_height);
    L41:
        if (da0() == true) goto L43;
    L50:
        SubMenuView r109 = (SubMenuView) findViewById(R.id.home_sub_title_view);
        this.f228020o = r109;
        r109.c();
        this.f228020o.setViewDelegate(this);
        Mj(t3.f229771a);
        if (ea0() == false) goto L53;
    L54:
        findViewById(R.id.list_appbar_refresh_header).setVisibility(8);
        findViewById(R.id.list_refresh_header).setVisibility(8);
        findViewById(R.id.list_appbar_refresh_lean_header).setVisibility(8);
        findViewById(R.id.list_collapsing_layout).setMinimumHeight(0);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().f217118a == false) goto L57;
        wa5.a r112 = new DigitDanceHeader(getContext());
        r112.setCustomText(getString(R.string.Doc_List_RefreshDocTips));
    L58:
        r111.G(r112, n.d(65));
    L60:
        if (da0() == false) goto L62;
        this.f228020o.setVisibility(8);
    L62:
        this.f228023r = new yc5.b(this.f226431g, r111, new a(this));
        this.f228024s = findViewById(R.id.no_net_container);
        j.a.f217090a.a().observe(this, new b2(this));
        if (getActivity() == null) goto L65;
        ((SortAndFilterViewModel) ViewModelProviders.of(getActivity()).get(SortAndFilterViewModel.class)).getSortStrategyLiveData().observe(this, new a2(this));
    L65:
        s1.a.f468004a.a(this);
        return;
    L57:
        r112 = new CircleRefreshHeader(getContext());
        goto L58
    L53:
        if (da0() == false) goto L60;
    L43:
        if (getParentFragment() != null) goto L45;
    L47:
        SubMenuViewPad r113 = this.f228021p;
        if (r113 == null) goto L50;
        r113.setViewDelegate(this);
        this.f228021p.c();
        s1.a.f468004a.a(this);
        goto L50
    L45:
        if (getParentFragment().getView() == null) goto L47;
        this.f228021p = (SubMenuViewPad) getParentFragment().getView().findViewById(R.id.sub_menu_view_pad);
        goto L47
    }

    @Override // wc5.f.a
    public final void WU(boolean r110) {
        Mj(r110);
        s1.a.f468004a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r110, WikiSpaceType.PERSONAL);
        qc5.a.j();
        r r111 = new r("ccm_space_drive_page_click", WikiSpaceType.PERSONAL, "none", "", sbb.e.f541294e.f541317b, false, false, false, 0, "");
        lc5.f.f508440a.O(r111);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
        tt5.a.h("HomePersonalFragment", "onAttach()...");
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        tt5.a.h("HomePersonalFragment", "onCreate()...");
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().getWindow() != null) goto L7;
        return;
    L7:
        if (ForsetiHelper.s(this) == true) goto L12;
        getActivity().getWindow().setSoftInputMode(32);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        tt5.a.h("HomePersonalFragment", "onSaveInstanceState()...");
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment, androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        if (r100 == true) goto L5;
        return;
    L5:
        if (da0() == false) goto L12;
        SubMenuViewPad r101 = this.f228021p;
        if (r101 == null) goto L13;
        if (r101 == null) goto L14;
        r101.setViewDelegate(this);
        this.f228021p.c();
        s1.a.f468004a.a(this);
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // wc5.d
    public final void t(int r100, int r101) {
        if (ea0() == false) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.list.homepage.title.b r102 = this.f228019n;
        if (r102 == null) goto L9;
        r102.a(r101);
        return;
    }
}
