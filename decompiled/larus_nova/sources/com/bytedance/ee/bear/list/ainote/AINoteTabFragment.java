package com.bytedance.ee.bear.list.ainote;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.lazy.LazyFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.CircleRefreshHeader;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.bytedance.ee.bear.list.ainote.filter.AINoteFilterFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.list.homepage.title.MainTabTitleBar;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.list.homepage.title.b;
import com.bytedance.ee.bear.list.homepage.title.c;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import dd5.p1;
import dd5.s1;
import gc5.q;
import gc5.r;
import gc5.s;
import gc5.t;
import kotlin.jvm.internal.Intrinsics;
import lc5.p;
import wc5.d;
import wc5.e;
import wc5.f;
import wc5.g;
import wc5.h;

/* JADX INFO: loaded from: classes18.dex */
public class AINoteTabFragment extends LazyFragment implements d, f.a, p1 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f227611y = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f227612n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SubMenuView f227613o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SubMenuViewPad f227614p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public wa5.a f227615q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public yc5.b f227616r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f227617s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ConnectionService.NetworkState f227618t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f227619u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FolderSortStrategy f227620v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f227621w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f227622x;

    public class a implements yc5.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteTabFragment f227623a;

        @Override // yc5.b.a
        public final String m6() {
            return "none";
        }

        @Override // yc5.b.a
        public final String getModule() {
            return this.f227623a.ca0();
        }

        public a(AINoteTabFragment r100) {
            this.f227623a = r100;
        }
    }

    @Override // wc5.d
    public final void Cu() {
    }

    public final void ba0() {
        this.f227622x = true;
        ConnectionService.NetworkState r100 = this.f227618t;
        if (r100 != null) goto L5;
    L12:
        Context r101 = this.f226431g;
        Toast.showFailureText(r101, r101.getString(R.string.Doc_Facade_Offline), 0);
        return;
    L5:
        if (r100.a() == false) goto L12;
        Bundle r102 = getArguments();
        r102.putString("key_module", ca0());
        r102.putString("key_token", da0());
        r102.putParcelable("key_sort_strategy", this.f227620v);
        r102.putBoolean("key_sort_filter_enable", false);
        if (ga0() == true) goto L9;
    L11:
        ActionSheetDialogFragment.ba0(getActivity(), AINoteFilterFragment.class, r102);
        return;
    L9:
        if (ForsetiHelper.s(this) == false) goto L11;
        ActionSheetDialogFragment.ca0(getActivity(), AINoteFilterFragment.class, r102, this.f227614p.getIvFilterIcon());
    }

    public String ca0() {
        return "ai_notes";
    }

    public String da0() {
        return "owned_by_me";
    }

    public int getContentViewLayoutId() {
        return R.layout.list_ai_note_personal;
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment
    public final void W90() {
        tt5.a.h("AINoteTabFragment", "onDestroyViewLazy()...");
    }

    public final void fa0() {
        SubMenuViewPad r100 = this.f227614p;
        if (r100 == null) goto L17;
        r100.setViewDelegate(this);
        SubMenuViewPad r101 = this.f227614p;
        if (r101.f228398h != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
    L7:
        AppCompatImageView r102 = r101.f228398h;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
        r102 = null;
    L10:
        r102.setVisibility(8);
        if (t.b() == false) goto L13;
    L15:
        s1.a.f468004a.a(this);
        return;
    L13:
        if (t.c() == true) goto L15;
        this.f227614p.c();
        goto L15
    }

    public AINoteTabFragment() {
        this.f227621w = "other";
        this.f227622x = false;
    }

    public void ea0() {
        if (ga0() == true) goto L5;
    L10:
        SubMenuView r100 = (SubMenuView) findViewById(R.id.home_sub_title_view);
        this.f227613o = r100;
        r100.c();
        if (t.b() == false) goto L13;
    L22:
        this.f227613o.setViewDelegate(this);
        Mj(t3.f229771a);
        return;
    L13:
        if (t.c() == true) goto L22;
        if (this.f227613o.getSortView() == null) goto L22;
        TextView r101 = this.f227613o.f228382a;
        if (r101 == null) goto L19;
        r101.setOnClickListener(null);
    L19:
        AppCompatImageView r102 = this.f227613o.f228385d;
        if (r102 == null) goto L22;
        r102.setVisibility(8);
        goto L22
    L5:
        if (getParentFragment() != null) goto L7;
    L9:
        fa0();
        goto L10
    L7:
        if (getParentFragment().getView() == null) goto L9;
        this.f227614p = (SubMenuViewPad) getParentFragment().getView().findViewById(R.id.sub_menu_view_pad);
        goto L9
    }

    public final boolean ga0() {
        if (ForsetiHelper.n() == true) goto L5;
    L9:
        return false;
    L5:
        if (getParentFragment() == null) goto L9;
        if ((getParentFragment() instanceof h) == false) goto L9;
        return true;
    }

    public final boolean ha0() {
        if (getParentFragment() != null) goto L5;
    L7:
        return false;
    L5:
        if ((getParentFragment() instanceof AINoteFragment) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("AINoteTabFragment", "onDestroy()...");
        yc5.b r100 = this.f227616r;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        s1.a.f468004a.h(this);
    }

    @Override // wc5.f.a
    public final void Qi() {
        ba0();
    }

    @Override // wc5.f.a
    public void eF() {
        ba0();
    }

    @Override // dd5.p1
    public void Mj(boolean r100) {
        this.f227613o.b(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment
    public final void V90(Bundle r110) {
        Z90(getContentViewLayoutId());
        if ((getActivity() instanceof g) == false) goto L6;
        this.f227612n = ((g) getActivity()).getTitleBar();
    L6:
        if (getArguments() == null) goto L8;
        this.f227621w = getArguments().getString("extra_from", "other");
    L8:
        SmartRefreshLayout r111 = (SmartRefreshLayout) findViewById(R.id.list_refresh_layout);
        e r100 = (e) getChildFragmentManager().findFragmentById(R.id.list_home_sub_fragment);
        if (r100 == null) goto L12;
        r100.Co(r111);
    L12:
        if (ha0() == true) goto L21;
        View r101 = findViewById(R.id.list_appbar_refresh_header);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().f217118a == false) goto L17;
        r101.setVisibility(0);
        this.f227615q = (wa5.a) r101;
    L18:
        cqa.e r102 = r111.getRefreshHeader();
        if ((r102 instanceof wa5.a) == false) goto L21;
        this.f227615q.setCustomText(getString(R.string.Doc_List_RefreshDocTips));
        ((wa5.a) r102).setAssociatedHeader(this.f227615q);
        goto L21
    L17:
        View r103 = findViewById(R.id.list_appbar_refresh_lean_header);
        r103.setVisibility(0);
        r101.setVisibility(8);
        this.f227615q = (wa5.a) r103;
    L21:
        ((AppBarLayout) findViewById(R.id.list_sub_menu_layout)).addOnOffsetChangedListener(new s(this));
        if (((CollapsingToolbarLayout) findViewById(R.id.list_collapsing_layout)) == null) goto L41;
        Object r104 = this.f227615q;
        if (r104 == null) goto L41;
        if ((r104 instanceof ViewGroup) == false) goto L41;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) ((ViewGroup) r104).getLayoutParams();
        b r106 = this.f227612n;
        if (r106 == null) goto L37;
        if ((r106 instanceof c) == false) goto L33;
    L38:
        r105.topMargin = 0;
    L40:
        ((ViewGroup) this.f227615q).setLayoutParams(r105);
        goto L41
    L33:
        if ((r106 instanceof MainTabTitleBar) == true) goto L38;
        if (r106.getTitleType() == HomeMainTitleBar.TitleType.SPACE_ROUTE.ordinal()) goto L38;
    L37:
        if (ga0() == true) goto L38;
        r105.topMargin = getResources().getDimensionPixelSize(R.dimen.list_home_title_search_height);
    L41:
        ea0();
        if (ha0() == false) goto L44;
    L45:
        findViewById(R.id.list_appbar_refresh_header).setVisibility(8);
        findViewById(R.id.list_refresh_header).setVisibility(8);
        findViewById(R.id.list_appbar_refresh_lean_header).setVisibility(8);
        findViewById(R.id.list_collapsing_layout).setMinimumHeight(0);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().f217118a == false) goto L48;
        wa5.a r107 = new DigitDanceHeader(getContext());
        r107.setCustomText(getString(R.string.Doc_List_RefreshDocTips));
    L49:
        r111.G(r107, n.d(65));
    L51:
        if (ga0() == false) goto L53;
        this.f227613o.setVisibility(8);
    L53:
        this.f227616r = new yc5.b(this.f226431g, r111, new a(this));
        this.f227617s = findViewById(R.id.no_net_container);
        j.a.f217090a.a().observe(this, new r(this));
        if (getActivity() == null) goto L56;
        ((SortAndFilterViewModel) ViewModelProviders.of(getActivity()).get(SortAndFilterViewModel.class)).getSortStrategyLiveData().observe(this, new q(this));
    L56:
        s1.a.f468004a.a(this);
        return;
    L48:
        r107 = new CircleRefreshHeader(getContext());
        goto L49
    L44:
        if (ga0() == false) goto L51;
        goto L45
    }

    @Override // wc5.f.a
    public void WU(boolean r110) {
        Mj(r110);
        s1.a.f468004a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r110, ca0());
        lc5.r r111 = new lc5.r("ccm_space_ai_notes_click", ca0(), "none", "", sbb.e.f541294e.f541317b, false, false, false, 0, "");
        lc5.f.f508440a.O(r111);
    }

    public final void ia0(FolderSortStrategy r210) {
        this.f227620v = r210;
        if (r210 != null) goto L6;
        SubMenuView.FilterState r100 = SubMenuView.FilterState.DEFAULT;
    L9:
        if (r210 != null) goto L11;
        String r101 = "";
    L13:
        if (ga0() == false) goto L17;
        SubMenuViewPad r102 = this.f227614p;
        if (r102 == null) goto L17;
        r102.setFilterState(r100);
    L18:
        tt5.a.h("AINoteTabFragment", "reportChooseFilter()...isClickFilter is " + this.f227622x);
        if (this.f227622x == false) goto L39;
        p r103 = new p("ccm_space_ai_notes_click", ca0(), "none", "filter", "", "", sbb.e.f541294e.f541317b, "", "", false, false, false, 0, null, "", null);
        FilterType r104 = t.a(this.f227620v);
        if (r104 != FilterType.AI_NOTE_ALL) goto L25;
    L36:
        String r105 = "all";
    L37:
        lc5.f.f508440a.l(r103, "filter_name", r105, this.f227621w);
        return;
    L25:
        if (r104 != FilterType.AI_NOTE_MEETING_NOTE) goto L28;
        r105 = "meeting_notes";
        goto L37
    L28:
        if (r104 != FilterType.AI_NOTE_RECORD_NOTE) goto L31;
        r105 = "record_notes";
        goto L37
    L31:
        if (r104 != FilterType.AI_NOTE_WEEKLY_RECAP) goto L34;
        r105 = "weekly_notes";
        goto L37
    L34:
        if (r104 != FilterType.AI_NOTE_MONTHLY_SUMMARY) goto L36;
        r105 = "monthly_notes";
        goto L37
    L39:
        return;
    L17:
        this.f227613o.setFilterState(r100);
        this.f227613o.a(r101);
        goto L18
    L11:
        r101 = getString(FilterType.getAINoteFilterByType(r210.getType(), r210.f227682c, r210.f227683d).getResId());
        goto L13
    L6:
        if (FilterType.getAINoteFilterByType(r210.getType(), r210.f227682c, r210.f227683d) != FilterType.AI_NOTE_ALL) goto L8;
        r100 = SubMenuView.FilterState.DEFAULT;
        goto L9
    L8:
        r100 = SubMenuView.FilterState.CHECKED;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
        tt5.a.h("AINoteTabFragment", "onAttach()...");
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        tt5.a.h("AINoteTabFragment", "onCreate()...");
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
        tt5.a.h("AINoteTabFragment", "onSaveInstanceState()...");
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment, androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        if (r100 == true) goto L5;
        return;
    L5:
        if (ga0() == true) goto L7;
        return;
    L7:
        if (this.f227614p == null) goto L12;
        fa0();
        return;
    }

    @Override // wc5.d
    public final void t(int r100, int r101) {
        if (ha0() == false) goto L5;
        return;
    L5:
        b r102 = this.f227612n;
        if (r102 == null) goto L9;
        r102.a(r101);
        return;
    }
}
