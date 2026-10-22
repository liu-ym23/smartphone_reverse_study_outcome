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
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
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
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import dd5.p1;
import dd5.s1;
import lc5.p;
import lc5.r;
import uc5.a2;
import uc5.b2;
import uc5.c2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HomePersonalFragment extends LazyFragment implements wc5.d, wc5.f.a, p1 {
    public static final /* synthetic */ int w = 0;
    public com.bytedance.ee.bear.list.homepage.title.b n;
    public SubMenuView o;
    public SubMenuViewPad p;
    public wa5.a q;
    public yc5.b r;
    public View s;
    public ConnectionService.NetworkState t;
    public int u;
    public FolderSortStrategy v;

    public class a implements yc5.b.a {
        public final /* synthetic */ HomePersonalFragment a;

        @Override // yc5.b.a
        public final String m6() {
            return "none";
        }

        @Override // yc5.b.a
        public final String getModule() {
            HomePersonalFragment r0 = this.a;
            int r1 = HomePersonalFragment.w;
            r0.getClass();
            return WikiSpaceType.PERSONAL;
        }

        public a(HomePersonalFragment r1) {
            this.a = r1;
        }
    }

    @Override // wc5.d
    public final void Cu() {
    }

    public String ca0() {
        return "my_root";
    }

    public int getContentViewLayoutId() {
        return 2131563497;
    }

    @Override // wc5.f.a
    public final void Qi() {
        ConnectionService.NetworkState r1 = this.t;
        if (r1 != null) goto L5;
    L12:
        Context r2 = ((LazyBaseFragment) this).g;
        Toast.showFailureText(r2, r2.getString(2131887789), 0);
        return;
    L5:
        if (r1.a() == false) goto L12;
        qc5.a.j();
        p r3 = new p("ccm_space_drive_page_click", WikiSpaceType.PERSONAL, "none", "filter", "ccm_space_header_filter_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null);
        lc5.f.a.I(r3);
        Bundle r4 = new Bundle();
        r4.putString("key_token", ca0());
        r4.putInt("key_default_sort_pos", 0);
        r4.putParcelable("key_sort_strategy", this.v);
        if (ForsetiHelper.s(this) == true) goto L9;
    L11:
        ActionSheetDialogFragment.ba0(getActivity(), SortFragment.class, r4);
        return;
    L9:
        if (this.p == null) goto L11;
        ActionSheetDialogFragment.ca0(getActivity(), SortFragment.class, r4, this.p.getIvSortIcon());
    }

    public final void W90() {
        tt5.a.h("HomePersonalFragment", "onDestroyViewLazy()...");
    }

    @Override // wc5.f.a
    public final void eF() {
        ConnectionService.NetworkState r1 = this.t;
        if (r1 != null) goto L5;
    L7:
        Context r2 = ((LazyBaseFragment) this).g;
        Toast.showFailureText(r2, r2.getString(2131887789), 0);
        return;
    L5:
        if (r1.a() == false) goto L7;
        qc5.a.j();
        p r3 = new p("ccm_space_drive_page_click", WikiSpaceType.PERSONAL, "none", "filter", "ccm_space_header_filter_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null);
        lc5.f.a.I(r3);
        Bundle r4 = getArguments();
        r4.putString("key_module", WikiSpaceType.PERSONAL);
        r4.putString("key_token", ca0());
        r4.putParcelable("key_sort_strategy", this.v);
        r4.putBoolean("key_sort_filter_enable", false);
        r4.putBoolean("key_filter_folder", true);
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r4);
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

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onDestroy();
        tt5.a.h("HomePersonalFragment", "onDestroy()...");
        yc5.b r0 = this.r;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        s1.a.a.h(this);
    }

    public HomePersonalFragment() {
    }

    public SortScene ba0() {
        return SortScene.FolderSort;
    }

    @Override // dd5.p1
    public final void Mj(boolean r2) {
        this.o.b(r2);
    }

    public final void V90(Bundle r11) {
        Z90(getContentViewLayoutId());
        if ((getActivity() instanceof wc5.g) == false) goto L5;
        this.n = getActivity().getTitleBar();
    L5:
        SmartRefreshLayout r12 = findViewById(2131378171);
        wc5.e r0 = getChildFragmentManager().findFragmentById(2131378122);
        if (r0 == null) goto L9;
        r0.Co(r12);
    L9:
        if (ea0() == true) goto L18;
        wa5.a r1 = findViewById(2131378060);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().a == false) goto L14;
        r1.setVisibility(0);
        this.q = r1;
    L15:
        wa5.a r2 = r12.getRefreshHeader();
        if ((r2 instanceof wa5.a) == false) goto L18;
        this.q.setCustomText(getString(2131887957));
        r2.setAssociatedHeader(this.q);
        goto L18
    L14:
        wa5.a r6 = findViewById(2131378061);
        r6.setVisibility(0);
        r1.setVisibility(8);
        this.q = r6;
    L18:
        findViewById(2131378183).addOnOffsetChangedListener(new c2(this));
        CollapsingToolbarLayout r7 = findViewById(2131378079);
        if (r7 == null) goto L41;
        ViewGroup r8 = this.q;
        if (r8 == null) goto L41;
        if ((r8 instanceof ViewGroup) == false) goto L41;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
        com.bytedance.ee.bear.list.homepage.title.b r10 = this.n;
        if (r10 == null) goto L34;
        if ((r10 instanceof com.bytedance.ee.bear.list.homepage.title.c) == false) goto L30;
    L35:
        r9.topMargin = 0;
    L37:
        this.q.setLayoutParams(r9);
        com.bytedance.ee.bear.list.homepage.title.b r13 = this.n;
        if (r13 == null) goto L41;
        r7.setMinimumHeight(r13.getTitleBarHeight());
        goto L41
    L30:
        if ((r10 instanceof MainTabTitleBar) == true) goto L35;
        if (r10.getTitleType() == HomeMainTitleBar.TitleType.SPACE_ROUTE.ordinal()) goto L35;
    L34:
        if (da0() == true) goto L35;
        r9.topMargin = getResources().getDimensionPixelSize(2131167715);
    L41:
        if (da0() == true) goto L43;
    L50:
        SubMenuView r14 = (SubMenuView) findViewById(2131374462);
        this.o = r14;
        r14.c();
        this.o.setViewDelegate(this);
        Mj(t3.a);
        if (ea0() == false) goto L53;
    L54:
        findViewById(2131378060).setVisibility(8);
        findViewById(2131378170).setVisibility(8);
        findViewById(2131378061).setVisibility(8);
        findViewById(2131378079).setMinimumHeight(0);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().a == false) goto L57;
        DigitDanceHeader r3 = new DigitDanceHeader(getContext());
        r3.setCustomText(getString(2131887957));
    L58:
        r12.G(r3, n.d(65));
    L60:
        if (da0() == false) goto L62;
        this.o.setVisibility(8);
    L62:
        this.r = new yc5.b(((LazyBaseFragment) this).g, r12, new a(this));
        this.s = findViewById(2131380933);
        j.a.a.a().observe(this, new b2(this));
        if (getActivity() == null) goto L65;
        ((SortAndFilterViewModel) ViewModelProviders.of(getActivity()).get(SortAndFilterViewModel.class)).getSortStrategyLiveData().observe(this, new a2(this));
    L65:
        s1.a.a.a(this);
        return;
    L57:
        r3 = new CircleRefreshHeader(getContext());
        goto L58
    L53:
        if (da0() == false) goto L60;
    L43:
        if (getParentFragment() != null) goto L45;
    L47:
        SubMenuViewPad r15 = this.p;
        if (r15 == null) goto L50;
        r15.setViewDelegate(this);
        this.p.c();
        s1.a.a.a(this);
        goto L50
    L45:
        if (getParentFragment().getView() == null) goto L47;
        this.p = (SubMenuViewPad) getParentFragment().getView().findViewById(2131387539);
        goto L47
    }

    @Override // wc5.f.a
    public final void WU(boolean r15) {
        Mj(r15);
        s1.a.a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r15, WikiSpaceType.PERSONAL);
        qc5.a.j();
        r r16 = new r("ccm_space_drive_page_click", WikiSpaceType.PERSONAL, "none", "", sbb.e.e.b, false, false, false, 0, "");
        lc5.f.a.O(r16);
    }

    public final void onAttach(Context r2) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        tt5.a.h("HomePersonalFragment", "onAttach()...");
    }

    public final void onCreate(Bundle r2) {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onCreate(r2);
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

    public final void onSaveInstanceState(Bundle r2) {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onSaveInstanceState(r2);
        tt5.a.h("HomePersonalFragment", "onSaveInstanceState()...");
    }

    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        if (r1 == true) goto L5;
        return;
    L5:
        if (da0() == false) goto L12;
        SubMenuViewPad r2 = this.p;
        if (r2 == null) goto L13;
        if (r2 == null) goto L14;
        r2.setViewDelegate(this);
        this.p.c();
        s1.a.a.a(this);
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // wc5.d
    public final void t(int r1, int r2) {
        if (ea0() == false) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.list.homepage.title.b r3 = this.n;
        if (r3 == null) goto L9;
        r3.a(r2);
        return;
    }
}
