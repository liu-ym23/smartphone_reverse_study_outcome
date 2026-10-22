package com.bytedance.ee.bear.lark.space;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.CircleRefreshHeader;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.create.x0;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabAdapter;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.list.recent.RecentDocumentFragment;
import com.bytedance.ee.bear.list.sort.SortAndFilterFragment;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.templates.recommend.NewRecommendTemplateViewModel;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.ApiUtils;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dd5.p1;
import dd5.s1;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import lc5.p;
import lc5.x;
import sa5.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PadRecentDocumentFragment extends BaseFragment implements wc5.g, wc5.d, p1, wc5.f.a, wc5.c, pd5.a.a, d0c.c {
    public static final /* synthetic */ int w = 0;
    public boolean e;
    public com.bytedance.ee.bear.lark.header.g f;
    public CommonCreateButton g;
    public ViewPager h;
    public HomeTabAdapter i;
    public SmartRefreshLayout j;
    public SortAndFilterViewModel k;
    public SelectCreationMenuViewModel l;
    public NewRecommendTemplateViewModel m;
    public x0 n;
    public FolderSortStrategy o;
    public int p;
    public final CompositeDisposable q;
    public final boolean r;
    public m s;
    public SubMenuViewPad t;
    public i u;
    public ForsetiViewMode v;

    public class a implements ViewPager.OnPageChangeListener {
        public final HomeTabAdapter a;
        public final /* synthetic */ PadRecentDocumentFragment b;

        public final void onPageScrollStateChanged(int r1) {
        }

        public final void onPageScrolled(int r1, float r2, int r3) {
        }

        public final void onPageSelected(int r4) {
            tt5.a.h("PadRecentDocumentFragment", "onPageSelected()...position = " + r4);
            if (r4 >= 0) goto L5;
        L15:
            tt5.a.h("PadRecentDocumentFragment", "illegal position");
            return;
        L5:
            if (r4 >= this.a.getCount()) goto L15;
            PadRecentDocumentFragment r0 = this.b;
            r0.p = r4;
            ad5.e r5 = this.a.f(r4);
            if (r5 != null) goto L10;
        L12:
            boolean r6 = false;
        L13:
            r0.getClass();
            tt5.a.h("PadRecentDocumentFragment", "updateHomeSubMenuView()...visible = " + r6);
            return;
        L10:
            if (r5.a == HomeTabEnum.PIN.id) goto L12;
            r6 = true;
            goto L13
        }

        public a(PadRecentDocumentFragment r1, HomeTabAdapter r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final void Cu() {
    }

    public final void Qi() {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final com.bytedance.ee.bear.list.homepage.title.b getTitleBar() {
        return null;
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final void t(int r1, int r2) {
    }

    public final void L2() {
        com.bytedance.ee.bear.contract.j r0 = com.bytedance.ee.bear.contract.j.a.a;
        if (r0 == null) goto L6;
        r0.a().observe(getViewLifecycleOwner(), new k(this));
    L6:
        if (getActivity() != null) goto L9;
        tt5.a.d("PadRecentDocumentFragment", "observeCreatePopupMenu()...activity is null");
    L13:
        if (getActivity() != null) goto L16;
        tt5.a.d("PadRecentDocumentFragment", "observeNewTemplateSelect()...activity is null");
    L19:
        tt5.a.h("PadRecentDocumentFragment", "pullUser()...");
        Disposable r1 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).filter(new e()).flatMap(new f()).subscribe(new g(), new h());
        this.q.add(r1);
        return;
    L16:
        if (this.m != null) goto L18;
        this.m = ViewModelProviders.of(getActivity()).get(NewRecommendTemplateViewModel.class);
    L18:
        this.m.getSelectedTemplate().observe(getViewLifecycleOwner(), new j(this));
        goto L19
    L9:
        if (this.l != null) goto L11;
        this.l = (SelectCreationMenuViewModel) ViewModelProviders.of(getActivity()).get(SelectCreationMenuViewModel.class);
    L11:
        this.l.getSelectedCreationTypeLiveData().observe(getViewLifecycleOwner(), new c(this));
        goto L13
    }

    public final void U90() {
        tt5.a.h("PadRecentDocumentFragment", "closePopupMenu()...");
        if (this.n != null) goto L5;
        this.n = new x0();
    L5:
        this.n.a(getActivity());
    }

    public final boolean W90() {
        com.bytedance.ee.bear.contract.j r0 = com.bytedance.ee.bear.contract.j.a.a;
        if (r0 == null) goto L8;
        r0.getNetworkState();
        boolean r1 = r0.getNetworkState().a();
        int r2 = com.bytedance.ee.bear.content.creation.location.a.a;
        if (com.bytedance.ee.bear.content.creation.location.a.a().a == false) goto L8;
        if (r1 == true) goto L8;
        return true;
    L8:
        return false;
    }

    public final void eF() {
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L5;
        Bundle r0 = getArguments();
        r0.putString("key_module", "home");
        r0.putString("key_sub_module", m6());
        r0.putString("key_token", "recent");
        r0.putBoolean("key_sort_asc_enable", false);
        r0.putInt("key_sort_title_res", 2131887915);
        r0.putParcelable("key_sort_strategy", this.o);
        r0.putInt("key_default_sort_pos", 2);
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r0);
    L6:
        lc5.f.j(new p("home", m6(), PanelData.TAB_FILTER, "ccm_space_header_filter_view", m6(), "ccm_space_home_page_click"));
        return;
    L5:
        Toast.showFailureText(getContext(), getString(2131887789), 0);
        goto L6
    }

    public final String m6() {
        if (this.p != 1) goto L6;
        return "quick_access";
    L6:
        return "recent";
    }

    public final void onDestroyView() {
        tt5.a.h("PadRecentDocumentFragment", "onDestroyView()...this:" + hashCode());
        this.e = false;
        ld5.a.a();
        super.onDestroyView();
        ((yw4.a) org.koin.java.a.a(yw4.a.class)).a("ccm_space_home");
        pd5.a.c(this);
        com.bytedance.ee.bear.lark.header.g r2 = this.f;
        if (r2 == null) goto L5;
        r2.destroy();
        this.f = null;
    L5:
        int r3 = zb5.a.C0334a.a;
        tt5.a.h("SpaceUIPreloader", "clear()...");
    L18:
        th = move-exception;
        tt5.a.e("PadRecentDocumentFragment", "removePlaceModeChangedListener error:", th, false);
        return;
    L7:
        if (ForsetiHelper.n() == true) goto L9;
        return;
    L9:
        if (this.u == null) goto L24;
        sua.a r4 = (sua.a) ApiUtils.getApi(sua.a.class);     // Catch: Throwable -> L18
        if (r4 != null) goto L13;
        return;
    L13:
        if (requireActivity().isFinishing() == true) goto L26;
        tua.b r5 = r4.tryGetChainManager(requireActivity());     // Catch: Throwable -> L18
        if (r5 == null) goto L27;
        r5.e(this.u);     // Catch: Throwable -> L18
        this.u = null;     // Catch: Throwable -> L18
        return;
    L27:
        return;
    L26:
        return;
    }

    public PadRecentDocumentFragment() {
        this.p = 0;
        CompositeDisposable r0 = new CompositeDisposable();
        this.q = r0;
        this.r = true;
        this.t = null;
        this.v = ForsetiViewMode.UNKNOWN;
        tt5.a.h("PadRecentDocumentFragment", "DocTabFragment()...");
        tt5.a.h("PadRecentDocumentFragment", "preloadAsyncJob()...");
        r0.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new b(), new d()));
    }

    public final void V90() {
        if (getParentFragment() != null) goto L5;
    L7:
        SubMenuViewPad r0 = this.t;
        if (r0 == null) goto L13;
        m r1 = this.s;
        if (r1 == null) goto L14;
        r0.setViewDelegate(r1);
        this.t.e();
        s1.a.a.a(this);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (getParentFragment().getView() == null) goto L7;
        this.t = getParentFragment().getView().findViewById(2131387539);
        goto L7
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    L5:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        s1.a.a.h(this);
        if (this.q.isDisposed() == true) goto L5;
        this.q.clear();
    L5:
        x.c().b();
        pd5.e.b(getContext()).a();
        tt5.a.h("PadRecentDocumentFragment", "onReleaseResource()...");
        tt5.a.h("PadRecentDocumentFragment", "onDestroy()...");
    }

    public final void onPause() {
        super.onPause();
        tt5.a.h("PadRecentDocumentFragment", "onPause()...");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).p("space_list", null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("PadRecentDocumentFragment", th, false);
    }

    public final void onResume() {
        super.onResume();
        String r3 = m6();
        String r4 = m6();
        lc5.f.a.N("ccm_space_home_page_view", "home", r3, r4, "", "");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).k("space_list");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("PadRecentDocumentFragment", th, false);
    }

    public final void onStop() {
        super.onStop();
        tt5.a.h("PadRecentDocumentFragment", "onStop()...");
        x.c().b();
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m434provideComponent() {
        return provideComponent();
    }

    public final SmartRefreshLayout xZ() {
        return this.j;
    }

    public final void Mj(boolean r1) {
        t3.a = r1;
    }

    public final void WU(boolean r11) {
        tt5.a.h("PadRecentDocumentFragment", "onClickGrid()...showGrid = " + r11);
        t3.a = r11;
        s1.a.a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r11, m6());
        lc5.f.a.G("home", m6(), m6(), "ccm_space_home_page_click", "", "");
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final void onMenuCreateClick(View r12) {
        tt5.a.h("PadRecentDocumentFragment", "onMenuCreateClick()...");
        FragmentActivity r1 = getActivity();
        if (this.n != null) goto L6;
        this.n = new x0();
    L6:
        if (this.n.a(r1) == false) goto L9;
        tt5.a.h("PadRecentDocumentFragment", "create menu is already showing");
        return;
    L9:
        boolean r0 = ((ww4.a) org.koin.java.a.a(ww4.a.class)).a().d().a;
        boolean r2 = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).d();
        SelectCreationMenuConfig r3 = new SelectCreationMenuConfig();
        r3.k = true;
        r3.l = t0.s();
        boolean r5 = false;
        if (r2 == true) goto L12;
    L15:
        boolean r4 = true;
    L16:
        r3.o = r4;
        com.bytedance.ee.bear.appsetting.c r6 = com.bytedance.ee.bear.appsetting.c.a.a;
        r3.p = r6.f("spacekit.mobile.docx_create_enable");
        r3.n = r0;
        r3.q = r6.i("ccm.bitable.ccmspace.hassurvey.enable", false);
        int r7 = com.bytedance.ee.bear.content.creation.location.a.a;
        r3.i = com.bytedance.ee.bear.content.creation.location.a.g();
        r3.b = com.bytedance.ee.bear.content.creation.location.a.i();
        r3.e = com.bytedance.ee.bear.content.creation.location.a.h();
        r3.h = com.bytedance.ee.bear.content.creation.location.a.f();
        r3.j = true;
        com.bytedance.ee.bear.content.creation.location.a.b r8 = com.bytedance.ee.bear.content.creation.location.a.j();
        if (r8.a == false) goto L19;
        boolean r9 = r8.b;
    L20:
        r3.a = r9;
        r3.d = true;
        r3.f = true;
        r3.g = true;
        iw4.h r10 = new iw4.h();
        r10.b = "home";
        r10.c = m6();
        if (r12 != null) goto L23;
        r5 = true;
    L23:
        r10.f = r5;
        qc5.a.j();
        r10.g = true;
        if (this.n != null) goto L26;
        this.n = new x0();
    L26:
        this.n.c(r1, r10, r3, this);
        lc5.f.j(new p("home", m6(), "create", "ccm_space_create_new_view", m6(), "ccm_space_home_page_click"));
        return;
    L19:
        r9 = false;
        goto L20
    L12:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.spacekit.bitable.enable", true) == true) goto L15;
        r4 = false;
        goto L16
    }

    public final void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        tt5.a.h("PadRecentDocumentFragment", "onSaveInstanceState()...");
    }

    public final void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        tt5.a.h("PadRecentDocumentFragment", "  setUserVisibleHint  isVisibleToUser: " + r3);
        if (r3 == false) goto L8;
        if (this.t == null) goto L8;
        V90();
    L8:
        if (this.e == true) goto L11;
        tt5.a.h("PadRecentDocumentFragment", "setUserVisibleHint: have not init so skip");
        return;
    L11:
        com.bytedance.ee.bear.lark.header.g r0 = this.f;
        if (r0 == null) goto L14;
        r0.setUserVisibleHint(r3);
    L14:
        HomeTabAdapter r1 = this.i;
        if (r1 == null) goto L19;
        Fragment r2 = r1.c;
        if (r2 == null) goto L19;
        r2.setUserVisibleHint(r3);
    L19:
        if (r3 == true) goto L21;
        U90();
        x.c().b();
        return;
    L21:
        if (this.r == false) goto L25;
        lc5.f.k((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "applicationToMainShow");
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        tt5.a.h("PadRecentDocumentFragment", "notifyFirstFrameDraw()...");
        View r4 = getView();
        if (r4 == null) goto L6;
        r4.getViewTreeObserver().addOnPreDrawListener(new n(r4));
        return;
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.bytedance.ee.bear.lark.space.i, com.ss.android.lark.api.ui.j] */
    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        tt5.a.h("PadRecentDocumentFragment", "onCreateView() called with: this:+" + hashCode() + "inflater = [" + r10 + "], container = [" + r11 + "], savedInstanceState = [" + r12 + "]");
        if (this.r == false) goto L5;
        lc5.f.k((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "applicationToMain");
        x.c().a("inflate_doc_tab_layout");
    L5:
        ((yw4.a) org.koin.java.a.a(yw4.a.class)).b("ccm_space_home", getContext(), new x15.a());
        int r13 = zb5.a.C0334a.a;
        tt5.a.h("SpaceUIPreloader", "getMainTabView()...layoutView = null");
        tt5.a.h("PadRecentDocumentFragment", "hasCache = false");
        ViewGroup r14 = com.bytedance.ee.bear.lark.x.a(getContext());
        if (this.r == false) goto L8;
        x.c().g("inflate_doc_tab_layout", 0, 0);
        com.bytedance.ee.bear.contract.d r16 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        lc5.f.a r0 = lc5.f.a;
        Intrinsics.checkNotNullParameter(r16, "analyticService");
        r16.h("list_file");
        lc5.f.a.c(r16, "list_file", "start_time", String.valueOf(System.currentTimeMillis()));
    L8:
        this.s = new m(this);
        tt5.a.h("PadRecentDocumentFragment", "initView()...rootView = " + r14);
        tt5.a.h("PadRecentDocumentFragment", "initHeader()...");
        if (this.f != null) goto L11;
        tt5.a.h("PadRecentDocumentFragment", "mHeaderManager is null, init");
        com.bytedance.ee.bear.lark.header.g r17 = new com.bytedance.ee.bear.lark.header.g(null, this);
        this.f = r17;
        r17.f((ViewGroup) r14.findViewById(2131378117));
    L11:
        r14.setPadding(0, y9c.d.a(65), 0, 0);
        SmartRefreshLayout r3 = r14.findViewById(2131378171);
        DigitDanceHeader r4 = new DigitDanceHeader(getContext());
        r4.setId(2131378060);
        r4.setLayoutParams(new LinearLayout.LayoutParams(-1, y9c.d.a(60)));
        r4.setCustomText(com.bytedance.ee.util.ui.n.x(getContext(), 2131887957));
        if (DevicePerfManager.b.a.e.h == false) goto L14;
        r3.G(new CircleRefreshHeader(getContext()), y9c.d.a(60));
    L15:
        LinearLayout r2 = (LinearLayout) r14.findViewById(2131378117);
        if (getContext() != null) goto L18;
    L22:
        CollapsingToolbarLayout r1 = r14.findViewById(2131378079);
        AppBarLayout.LayoutParams r5 = r1.getLayoutParams();
        r5.setScrollFlags(11);
        r1.setLayoutParams(r5);
        r1.setMinimumHeight(0);
        tt5.a.h("PadRecentDocumentFragment", "initRefreshLayout()...");
        this.j = r14.findViewById(2131378171);
        com.bytedance.ee.bear.lark.header.b r18 = (com.bytedance.ee.bear.lark.header.b) this.f.e(com.bytedance.ee.bear.lark.header.b.class);
        if (r18 != null) goto L25;
        tt5.a.d("PadRecentDocumentFragment", "initRefreshLayout()...digitalRefreshHeader is null");
    L26:
        this.h = r14.findViewById(2131378123);
        ArrayList r19 = new ArrayList();
        r19.add(new ad5.e(HomeTabEnum.RECENT.id, 2131887956, RecentDocumentFragment.class.getName()));
        FragmentManager r6 = getChildFragmentManager();
        Context r7 = getContext();
        if (getArguments() == null) goto L29;
        PassportcConvention.h(getArguments(), e9());
    L30:
        HomeTabAdapter r8 = new HomeTabAdapter(r6, r7, r19, getArguments());
        this.i = r8;
        this.h.setAdapter(r8);
        this.h.setCurrentItem(this.p);
        this.h.setOffscreenPageLimit(1);
        this.h.addOnPageChangeListener(new a(this, this.i));
        t3.a = LarkKVStorage.h(new com.ss.android.lark.storage.a(Biz.DOCS.getValue()), true).getBoolean("is_grid", false);
        s1.a.a.a(this);
        CommonCreateButton r110 = r14.findViewById(2131367552);
        this.g = r110;
        if (r110 == null) goto L34;
        r110.setVisibility(8);
    L34:
        if (getActivity() != null) goto L37;
        tt5.a.d("PadRecentDocumentFragment", "observeSortAndFilter()...activity is null");
    L40:
        pd5.a.a(this);
        this.e = true;
        t.a();
        if (this.r == false) goto L43;
        x.c().h("doc_tab_fragment_init");
    L43:
        V90();
        if (ForsetiHelper.n() == true) goto L56;
    L55:
        return r14;
    L56:
        sua.a r111 = (sua.a) ApiUtils.getApi(sua.a.class);     // Catch: Throwable -> L53
        if (r111 == null) goto L55;
        if (requireActivity().isFinishing() == true) goto L55;
        tua.b r112 = r111.tryGetChainManager(requireActivity());     // Catch: Throwable -> L53
        if (r112 == null) goto L55;
        ?? r9 = new i(this);     // Catch: Throwable -> L53
        this.u = r9;     // Catch: Throwable -> L53
        r112.P(r9);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        tt5.a.e("PadRecentDocumentFragment", "observeForsetiMode", th, false);
        goto L55
    L37:
        if (this.k != null) goto L39;
        this.k = ViewModelProviders.of(getActivity()).get(SortAndFilterViewModel.class);
    L39:
        this.k.getSortStrategyLiveData().observe(getViewLifecycleOwner(), new l(this));
        goto L40
    L29:
        Bundle r20 = new Bundle();
        PassportcConvention.h(r20, e9());
        setArguments(r20);
        goto L30
    L25:
        r18.d(this.j);
        goto L26
    L18:
        if (getContext().getResources() == null) goto L22;
        Drawable r21 = getContext().getResources().getDrawable(2131100548, null);
        if (r21 == null) goto L22;
        r2.setBackground(r21);
        goto L22
    L14:
        r3.G(r4, y9c.d.a(60));
        goto L15
    }
}
