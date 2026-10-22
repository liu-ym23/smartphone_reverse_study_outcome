package com.bytedance.ee.bear.lark;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelFactory;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.CircleRefreshHeader;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.bytedance.ee.bear.lark.sidebar.SidebarDocTabFragment;
import com.bytedance.ee.bear.lark.tab.SpaceBaseTabFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.create.x0;
import com.bytedance.ee.bear.list.homepage.tab.HomeSubMenuView;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabAdapter;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.sort.SortAndFilterFragment;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.templates.recommend.NewRecommendTemplateViewModel;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.storage.LarkKVStorage;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dd5.p1;
import dd5.s1;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocTabFragment extends SpaceBaseTabFragment implements wc5.g, wc5.d, p1, wc5.f.a, wc5.c, pd5.a.a, d0c.c {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public ViewTreeObserver.OnPreDrawListener B;
    public final a C;
    public com.bytedance.ee.bear.list.homepage.title.c g;
    public com.ss.android.lark.maintab.export.d h;
    public bd5.s i;
    public bd5.q j;
    public i k;
    public boolean l;
    public com.bytedance.ee.bear.lark.header.g m;
    public CommonCreateButton n;
    public ViewPager o;
    public HomeTabAdapter p;
    public HomeSubMenuView q;
    public SmartRefreshLayout r;
    public SortAndFilterViewModel s;
    public SelectCreationMenuViewModel t;
    public NewRecommendTemplateViewModel u;
    public x0 v;
    public FolderSortStrategy w;
    public FolderSortStrategy x;
    public int y;
    public final CompositeDisposable z;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ DocTabFragment a;

        public a(DocTabFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r5) {
            tt5.a.h("DocTabFragment", "onViewAttachedToWindow() called with: v = [" + r5 + "]");
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.isAttachedToWindow() == false) goto L21;
            DocTabFragment r6 = this.a;
            int r0 = DocTabFragment.D;
            if (r6.getView() == null) goto L22;
            View r1 = r6.getView();
            if (r1.isAttachedToWindow() == false) goto L25;
            ViewTreeObserver r2 = r1.getViewTreeObserver();
            if (r6.B != null) goto L14;
            r6.B = new w(r6, r2);
        L14:
            tt5.a.h("DocTabFragment", "addOnPreDrawListener: viewTreeObserver:" + r2);
            if (r2.isAlive() == false) goto L23;
            ViewTreeObserver.OnPreDrawListener r7 = r6.B;
            if (r7 == null) goto L24;
            r2.addOnPreDrawListener(r7);
            return;
        L24:
            return;
        L23:
            return;
        L25:
            return;
        L22:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            tt5.a.h("DocTabFragment", "onViewDetachedFromWindow() called with: v = [" + r3 + "]");
            DocTabFragment r4 = this.a;
            int r0 = DocTabFragment.D;
            r4.ya0();
        }
    }

    public class b extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ DocTabFragment c;

        public b(DocTabFragment r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            DocTabFragment.T90(this.c, r2);
        }
    }

    public class c implements ViewPager.OnPageChangeListener {
        public final HomeTabAdapter a;
        public final /* synthetic */ DocTabFragment b;

        public final void onPageScrollStateChanged(int r1) {
        }

        public final void onPageScrolled(int r1, float r2, int r3) {
        }

        public final void onPageSelected(int r3) {
            tt5.a.h("DocTabFragment", "onPageSelected()...position = " + r3);
            if (r3 >= 0) goto L5;
        L15:
            tt5.a.h("DocTabFragment", "illegal position");
            return;
        L5:
            if (r3 >= this.a.getCount()) goto L15;
            DocTabFragment r0 = this.b;
            r0.y = r3;
            ad5.e r4 = this.a.f(r3);
            if (r4 != null) goto L10;
        L12:
            boolean r5 = false;
        L13:
            r0.Aa0(r5);
            return;
        L10:
            if (r4.a == HomeTabEnum.PIN.id) goto L12;
            r5 = true;
            goto L13
        }

        public c(DocTabFragment r1, HomeTabAdapter r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d implements xc5.b.b {
        public final /* synthetic */ DocTabFragment a;

        public d(DocTabFragment r1) {
            this.a = r1;
        }

        public final void a(int r12) {
            tt5.a.h("DocTabFragment", "onTabSelected()...index = " + r12);
            DocTabFragment r0 = this.a;
            if (r0.y != r12) goto L5;
            return;
        L5:
            lc5.f.j(new lc5.p(r0.fa0(), this.a.m6(), this.a.ga0(r12), this.a.da0(), this.a.m6(), this.a.aa0(), this.a.W9(), this.a.ba0()));
            this.a.o.setCurrentItem(r12);
            com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
            String r2 = this.a.ga0(r12);
            Intrinsics.checkNotNullParameter(r1, "analyticService");
            Intrinsics.checkNotNullParameter(r2, "tabType");
            JSONObject r3 = new JSONObject();
            r3.put("tab_type", r2);
            if (qc5.a.h() == false) goto L8;
            String r4 = "new_format";
        L9:
            r3.put("space_version", r4);
            r1.a("tab_click", r3);
            DocTabFragment.U90(this.a);
            this.a.xa0(r12);
            return;
        L8:
            r4 = "original";
            goto L9
        }
    }

    public final void Cu() {
    }

    public void Qi() {
    }

    public String W9() {
        return "";
    }

    public String aa0() {
        return "ccm_space_home_page_click";
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public String ba0() {
        return "";
    }

    public String ca0() {
        return "ccm_space_home_page_click";
    }

    public String da0() {
        return "ccm_space_home_page_view";
    }

    public String fa0() {
        return "home";
    }

    public String ga0(int r2) {
        if (r2 != 1) goto L5;
        return "quick_access";
    L5:
        return "recent";
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public void ja0(com.bytedance.ee.bear.list.homepage.title.b r1) {
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public void pa0() {
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public void va0() {
    }

    public void xa0(int r1) {
    }

    private void za0() {
        this.n.setEnableStyle(!na0());
        e.b(this.n.getCreateButton(), e.a(), !na0());
    }

    public void L2() {
        com.bytedance.ee.bear.contract.j r0 = com.bytedance.ee.bear.contract.j.a.a;
        if (r0 == null) goto L5;
        r0.a().observe(getViewLifecycleOwner(), new u(this));
    L5:
        qa0();
        ra0();
        tt5.a.h("DocTabFragment", "pullUser()...");
        Disposable r1 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).filter(new v()).flatMap(new j()).subscribe(new k(), new l());
        this.z.add(r1);
    }

    public final void W90() {
        tt5.a.h("DocTabFragment", "closePopupMenu()...");
        if (this.v != null) goto L5;
        this.v = new x0();
    L5:
        this.v.a(getActivity());
    }

    public com.bytedance.ee.bear.lark.header.h Z90() {
        return new com.bytedance.ee.bear.lark.header.a(this);
    }

    public void eF() {
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L5;
        Bundle r0 = getArguments();
        r0.putString("key_module", fa0());
        r0.putString("key_sub_module", m6());
        r0.putString("key_token", "recent");
        r0.putBoolean("key_sort_asc_enable", false);
        r0.putInt("key_sort_title_res", 2131887915);
        r0.putParcelable("key_sort_strategy", this.w);
        r0.putInt("key_default_sort_pos", 2);
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r0);
    L6:
        lc5.f.j(new lc5.p(fa0(), m6(), PanelData.TAB_FILTER, "ccm_space_header_filter_view", m6(), aa0()));
        return;
    L5:
        Toast.showFailureText(getContext(), getString(2131887789), 0);
        goto L6
    }

    public ad5.f ea0() {
        return new ad5.d();
    }

    public ViewGroup getRootView() {
        int r0 = zb5.a.C0334a.a;
        tt5.a.h("SpaceUIPreloader", "getMainTabView()...layoutView = null");
        tt5.a.h("SpaceReport", "hasCache = false");
        return x.a(getContext());
    }

    public String m6() {
        if (this.y != 1) goto L6;
        return "quick_access";
    L6:
        return "recent";
    }

    public boolean na0() {
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

    public void onDestroyView() {
        tt5.a.h("DocTabFragment", "onDestroyView()...");
        this.l = false;
        ld5.a.a();
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onDestroyView();
        ((yw4.a) org.koin.java.a.a(yw4.a.class)).a("ccm_space_home");
        pd5.a.c(this);
        com.bytedance.ee.bear.lark.header.g r0 = this.m;
        if (r0 == null) goto L5;
        r0.destroy();
        this.m = null;
    L5:
        int r1 = zb5.a.C0334a.a;
        tt5.a.h("SpaceUIPreloader", "clear()...");
        if (getView() == null) goto L9;
        getView().removeOnAttachStateChangeListener(this.C);
        ya0();
        return;
    }

    public void wa0() {
        s1.a.a.b();
        lc5.x.c().b();
        pd5.e.b(getContext()).a();
        tt5.a.h("DocTabFragment", "onReleaseResource()...");
    }

    public DocTabFragment() {
        this.y = 0;
        CompositeDisposable r0 = new CompositeDisposable();
        this.z = r0;
        this.A = true;
        this.C = new a(this);
        tt5.a.h("DocTabFragment", "DocTabFragment()...");
        tt5.a.h("DocTabFragment", "preloadAsyncJob()...");
        r0.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new p(), new q()));
        this.f = new f(this);
    }

    public void V90() {
        z.b().getClass();
        z.a(new String[]{"key_open_finish_recent"});
    }

    public final Bundle X90() {
        if (getArguments() == null) goto L5;
        PassportcConvention.h(getArguments(), e9());
    L7:
        return getArguments();
    L5:
        Bundle r0 = new Bundle();
        PassportcConvention.h(r0, e9());
        setArguments(r0);
        goto L7
    }

    public UserSession e9() {
        return PassportcConvention.b(this);
    L5:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.lark.tab.SpaceBaseTabFragment
    public final void onDestroy() {
        super.onDestroy();
        s1.a.a.h(this);
        if (this.z.isDisposed() == true) goto L5;
        this.z.clear();
    L5:
        wa0();
        tt5.a.h("DocTabFragment", "onDestroy()...");
    }

    public void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        tt5.a.h("DocTabFragment", "onPause()...");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).p("space_list", null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("DocTabFragment", th, false);
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        tt5.a.h("DocTabFragment", "onResume");
        String r3 = da0();
        String r4 = fa0();
        String r5 = m6();
        String r6 = m6();
        String r7 = W9();
        String r8 = ba0();
        lc5.f.a.N(r3, r4, r5, r6, r7, r8);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).k("space_list");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("DocTabFragment", th, false);
    }

    public final void onStop() {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onStop();
        tt5.a.h("DocTabFragment", "onStop()...");
        lc5.x.c().b();
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m419provideComponent() {
        return provideComponent();
    }

    public final void qa0() {
        if (getActivity() != null) goto L7;
        tt5.a.d("DocTabFragment", "observeCreatePopupMenu()...activity is null");
        return;
    L7:
        if (this.t != null) goto L9;
        this.t = (SelectCreationMenuViewModel) ViewModelProviders.of(getActivity()).get(SelectCreationMenuViewModel.class);
    L9:
        this.t.getSelectedCreationTypeLiveData().observe(getViewLifecycleOwner(), new n(this));
    }

    public final void ra0() {
        if (getActivity() != null) goto L7;
        tt5.a.d("DocTabFragment", "observeNewTemplateSelect()...activity is null");
        return;
    L7:
        if (this.u != null) goto L9;
        this.u = ViewModelProviders.of(getActivity()).get(NewRecommendTemplateViewModel.class);
    L9:
        this.u.getSelectedTemplate().observe(getViewLifecycleOwner(), new o(this));
    }

    public final void sa0() {
        if (getActivity() != null) goto L7;
        tt5.a.d("DocTabFragment", "observeSortAndFilter()...activity is null");
        return;
    L7:
        if (this.s != null) goto L9;
        this.s = ViewModelProviders.of(getActivity()).get(SortAndFilterViewModel.class);
    L9:
        this.s.getSortStrategyLiveData().observe(getViewLifecycleOwner(), new s(this));
    }

    public final void ya0() {
        if (getView() == null) goto L13;
        View r0 = getView();
        if (r0.isAttachedToWindow() == true) goto L7;
        return;
    L7:
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        tt5.a.h("DocTabFragment", "removeOnPreDrawListener: viewTreeObserver:" + r1);
        if (r1.isAlive() == false) goto L14;
        ViewTreeObserver.OnPreDrawListener r2 = this.B;
        if (r2 == null) goto L15;
        r1.removeOnPreDrawListener(r2);
        this.B = null;
        return;
    L15:
        return;
    L14:
        return;
    }

    public final com.bytedance.ee.bear.list.homepage.title.b getTitleBar() {
        return this.g;
    }

    public SmartRefreshLayout xZ() {
        return this.r;
    }

    public static void U90(DocTabFragment r7) {
        String r1 = r7.da0();
        String r2 = r7.fa0();
        String r3 = r7.m6();
        String r4 = r7.m6();
        String r5 = r7.W9();
        String r6 = r7.ba0();
        lc5.f.a.N(r1, r2, r3, r4, r5, r6);
    }

    private void ta0(View r3) {
        if (na0() == false) goto L6;
        Context r4 = getContext();
        int r0 = com.bytedance.ee.bear.content.creation.location.a.a;
        Toast.showWarningText(r4, getString(com.bytedance.ee.bear.content.creation.location.a.a().b), 0);
        return;
    L6:
        onMenuCreateClick(r3);
    }

    public void Aa0(boolean r3) {
        tt5.a.h("DocTabFragment", "updateHomeSubMenuView()...visible = " + r3);
        if (r3 == false) goto L5;
        HomeSubMenuView r4 = this.q;
        r4.getClass();
        tt5.a.h("HomeSubMenuView", "showFilter()...");
        r4.c(r4.b, true);
        r4.setOffline(r4.h);
        return;
    L5:
        HomeSubMenuView r5 = this.q;
        r5.getClass();
        tt5.a.h("HomeSubMenuView", "hideFilter()...");
        r5.c(r5.b, false);
    }

    public void Mj(boolean r2) {
        this.q.b(r2);
        t3.a = r2;
    }

    public final void WU(boolean r11) {
        tt5.a.h("DocTabFragment", "onClickGrid()...showGrid = " + r11);
        Mj(r11);
        s1.a.a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r11, m6());
        lc5.f.a.G(fa0(), m6(), m6(), ca0(), W9(), ba0());
    }

    public final String Y90(FolderSortStrategy r5) {
        String r0 = "";
        if (r5 != null) goto L5;
        return "";
    L5:
        FilterType r1 = FilterType.getFilterByType(r5.getType(), r5.c, r5.d);
        if (r1 == FilterType.ALL) goto L8;
        r0 = getString(r1.getResId());
    L8:
        RecentSort r6 = RecentSort.getSort(r5.e);
        if (r6 != RecentSort.OPENED) goto L12;
        return r0;
    L12:
        if (TextUtils.isEmpty(r0) == true) goto L15;
        r0 = r0 + "、";
    L15:
        return r0 + getString(r6.getResId());
    }

    public void ha0(ViewGroup r2) {
        this.n = r2.findViewById(2131367552);
        pa0();
        za0();
        this.n.setOnClickListener(new b(this));
    }

    public final void ia0(View r3) {
        tt5.a.h("DocTabFragment", "initHeader()...");
        if (this.m != null) goto L5;
        tt5.a.h("DocTabFragment", "mHeaderManager is null, init");
        com.bytedance.ee.bear.lark.header.g r0 = new com.bytedance.ee.bear.lark.header.g(Z90(), this);
        this.m = r0;
        r0.f((ViewGroup) r3.findViewById(2131378117));
    L5:
        ka0(r3);
    }

    public void ka0(View r7) {
        SmartRefreshLayout r0 = r7.findViewById(2131378171);
        DigitDanceHeader r1 = new DigitDanceHeader(getContext());
        r1.setId(2131378060);
        r1.setLayoutParams(new LinearLayout.LayoutParams(-1, y9c.d.a(60)));
        r1.setCustomText(com.bytedance.ee.util.ui.n.x(getContext(), 2131887957));
        if (DevicePerfManager.b.a.e.h == false) goto L5;
        r0.G(new CircleRefreshHeader(getContext()), y9c.d.a(60));
    L6:
        ((LinearLayout) r7.findViewById(2131378117)).setBackground(getContext().getResources().getDrawable(2131100548, null));
        CollapsingToolbarLayout r8 = r7.findViewById(2131378079);
        AppBarLayout.LayoutParams r2 = r8.getLayoutParams();
        r2.setScrollFlags(11);
        r8.setLayoutParams(r2);
        return;
    L5:
        r0.G(r1, y9c.d.a(60));
        goto L6
    }

    public final void la0(View r9) {
        bd5.s r0 = new bd5.s();
        this.i = r0;
        this.j = new bd5.q(r0);
        this.g = new com.bytedance.ee.bear.list.homepage.title.c(r9.getContext(), this.h, this.i, this.j, this.k);
        com.ss.android.lark.maintab.export.d r10 = this.h;
        if (r10 == null) goto L5;
        r10.a();
    L5:
        this.g.d(this.k);
        pa0();
        boolean r11 = this instanceof SidebarDocTabFragment;
        if (r11 == false) goto L8;
        this.g.c(new t(this));
    L8:
        com.bytedance.ee.bear.list.homepage.title.c r1 = this.g;
        pa0();
        r1.e(false, r11);
        this.g.setTitle(getString(2131887987));
        ja0(this.g);
    }

    public void ma0(ViewGroup r9) {
        tt5.a.h("DocTabFragment", "initView()...rootView = " + r9);
        la0(r9);
        ia0(r9);
        tt5.a.h("DocTabFragment", "initRefreshLayout()...");
        this.r = r9.findViewById(2131378171);
        com.bytedance.ee.bear.lark.header.b r0 = (com.bytedance.ee.bear.lark.header.b) this.m.e(com.bytedance.ee.bear.lark.header.b.class);
        if (r0 != null) goto L5;
        tt5.a.d("DocTabFragment", "initRefreshLayout()...digitalRefreshHeader is null");
    L6:
        this.o = r9.findViewById(2131378123);
        List r1 = ea0().a(false);
        HomeTabAdapter r2 = new HomeTabAdapter(getChildFragmentManager(), getContext(), r1, X90());
        this.p = r2;
        this.o.setAdapter(r2);
        this.o.setCurrentItem(this.y);
        this.o.setOffscreenPageLimit(1);
        this.o.addOnPageChangeListener(new c(this, this.p));
        HomeSubMenuView r3 = r9.findViewById(2131374462);
        this.q = r3;
        r3.setViewDelegate(this);
        MagicIndicator r4 = this.q.getMagicIndicator();
        wuc.a r5 = new wuc.a(getContext());
        r5.setAdapter(new xc5.b(getContext(), r4, r1, new d(this)));
        r4.setNavigator(r5);
        Mj(LarkKVStorage.h(new com.ss.android.lark.storage.a(Biz.DOCS.getValue()), true).getBoolean("is_grid", false));
        s1.a.a.a(this);
        ha0(r9);
        sa0();
        pd5.a.a(this);
        this.l = true;
        sa5.t.a();
        if (this.A == false) goto L10;
        lc5.x.c().h("doc_tab_fragment_init");
        return;
    L10:
        return;
    L5:
        r0.d(this.r);
        goto L6
    }

    public void oa0(Boolean r2) {
        CommonCreateButton r0 = this.n;
        if (r2.booleanValue() == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public void onMenuCreateClick(View r12) {
        tt5.a.h("DocTabFragment", "onMenuCreateClick()...");
        FragmentActivity r1 = getActivity();
        if (this.v != null) goto L6;
        this.v = new x0();
    L6:
        if (this.v.a(r1) == false) goto L9;
        tt5.a.h("DocTabFragment", "create menu is already showing");
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
        r10.b = fa0();
        r10.c = m6();
        if (r12 != null) goto L23;
        r5 = true;
    L23:
        r10.f = r5;
        qc5.a.j();
        r10.g = true;
        if (this.v != null) goto L26;
        this.v = new x0();
    L26:
        this.v.c(r1, r10, r3, this);
        lc5.f.j(new lc5.p(fa0(), m6(), "create", "ccm_space_create_new_view", m6(), aa0()));
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
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onSaveInstanceState(r2);
        tt5.a.h("DocTabFragment", "onSaveInstanceState()...");
    }

    public void setUserVisibleHint(boolean r3) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r3);
        tt5.a.h("DocTabFragment", "  setUserVisibleHint  isVisibleToUser: " + r3);
        if (this.l == true) goto L6;
        tt5.a.h("DocTabFragment", "setUserVisibleHint: have not init so skip");
        return;
    L6:
        com.bytedance.ee.bear.lark.header.g r0 = this.m;
        if (r0 == null) goto L9;
        r0.setUserVisibleHint(r3);
    L9:
        HomeTabAdapter r1 = this.p;
        if (r1 == null) goto L14;
        Fragment r2 = r1.c;
        if (r2 == null) goto L14;
        r2.setUserVisibleHint(r3);
    L14:
        if (r3 == true) goto L16;
        W90();
        lc5.x.c().b();
        return;
    L16:
        if (this.A == false) goto L20;
        lc5.f.k((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "applicationToMainShow");
        return;
    }

    public void ua0(FolderSortStrategy r3) {
        tt5.a.h("DocTabFragment", "onFilterChanged()...");
        if (r3 != null) goto L7;
        tt5.a.h("DocTabFragment", "onFilterChanged()...sortStrategy is null");
        this.w = r3;
        this.x = r3;
        this.q.e(Y90(r3));
        return;
    L7:
        if (TextUtils.equals("recent", r3.a) == false) goto L10;
        this.w = r3;
    L12:
        this.q.e(Y90(r3));
        return;
    L10:
        if (TextUtils.equals("manual_offline", r3.a) == false) goto L12;
        this.x = r3;
        goto L12
    }

    public static /* synthetic */ void S90(DocTabFragment r2, ConnectionService.NetworkState r3) {
        r2.getClass();
        tt5.a.h("DocTabFragment", "on network changed, state = " + r3);
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        HomeSubMenuView r0 = r2.q;
        if (r0 == null) goto L13;
        r0.setOffline(r4);
    L13:
        if (r2.n == null) goto L16;
        r2.za0();
        return;
    L16:
        return;
    L5:
        if (r3.a() == false) goto L8;
        r4 = false;
        goto L9
    }

    public static /* synthetic */ void T90(DocTabFragment r0, View r1) {
        r0.ta0(r1);
    }

    public void onViewCreated(View r2, Bundle r3) {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onViewCreated(r2, r3);
        if (ForsetiHelper.n() == false) goto L7;
        ForsetiViewModel r4 = (ForsetiViewModel) new ViewModelProvider(this, new ForsetiViewModelFactory(requireActivity())).get(ForsetiViewModel.class);
        if (r4 == null) goto L7;
        r4.getViewMode().observe(getViewLifecycleOwner(), new m(this));
    L7:
        tt5.a.h("DocTabFragment", "onViewCreated");
    }

    public final void t(int r1, int r2) {
        com.bytedance.ee.bear.list.homepage.title.c r3 = this.g;
        if (r3 == null) goto L6;
        r3.a(r2);
        return;
    }

    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        tt5.a.h("DocTabFragment", "onCreateView");
        if (this.A == false) goto L5;
        lc5.f.k((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "applicationToMain");
        lc5.x.c().a("inflate_doc_tab_layout");
    L5:
        ((yw4.a) org.koin.java.a.a(yw4.a.class)).b("ccm_space_home", getContext(), new x15.a());
        ViewGroup r7 = getRootView();
        if (this.A == false) goto L8;
        lc5.x.c().g("inflate_doc_tab_layout", 0, 0);
        com.bytedance.ee.bear.contract.d r8 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        lc5.f.a r9 = lc5.f.a;
        Intrinsics.checkNotNullParameter(r8, "analyticService");
        r8.h("list_file");
        lc5.f.a.c(r8, "list_file", "start_time", String.valueOf(System.currentTimeMillis()));
    L8:
        ma0(r7);
        if (r7 == null) goto L11;
        r7.addOnAttachStateChangeListener(this.C);
    L11:
        return r7;
    }
}
