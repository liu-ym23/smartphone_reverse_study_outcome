package com.bytedance.ee.bear.list.manualoffline;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.list.homepage.title.MainTabTitleBar;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.list.homepage.title.b;
import com.bytedance.ee.bear.list.homepage.title.c;
import com.bytedance.ee.bear.list.sort.SortAndFilterFragment;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.sort.SortFragment;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import dd5.p1;
import dd5.s1;
import lc5.p;
import lc5.r;
import sbb.e;
import wc5.d;
import wc5.f;
import wc5.g;
import wc5.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HomeOfflineFragment extends BaseFragment implements f.a, d, p1 {
    public static final /* synthetic */ int m = 0;
    public b e;
    public SubMenuView f;
    public SubMenuViewPad g;
    public wa5.a h;
    public yc5.b i;
    public View j;
    public int k;
    public FolderSortStrategy l;

    public class a implements yc5.b.a {
        public final /* synthetic */ HomeOfflineFragment a;

        @Override // yc5.b.a
        public final String m6() {
            return "none";
        }

        @Override // yc5.b.a
        public final String getModule() {
            HomeOfflineFragment r0 = this.a;
            int r1 = HomeOfflineFragment.m;
            r0.getClass();
            return OperationName.OPERATION_OFFLINE_AVAILABLE;
        }

        public a(HomeOfflineFragment r1) {
            this.a = r1;
        }
    }

    @Override // wc5.d
    public final void Cu() {
    }

    @Override // wc5.f.a
    public final void Qi() {
        p r15 = new p("ccm_space_offline_page_click", OperationName.OPERATION_OFFLINE_AVAILABLE, "", "filter", "ccm_space_header_filter_view", "", e.e.b, "", "", false, false, false, 0, null, "", null);
        lc5.f.a.I(r15);
        Bundle r1 = new Bundle();
        r1.putString("key_token", "manual_offline");
        r1.putParcelable("key_sort_strategy", this.l);
        r1.putBoolean("key_sort_asc_enable", false);
        if (ForsetiHelper.s(this) == true) goto L5;
    L7:
        ActionSheetDialogFragment.ba0(getActivity(), SortFragment.class, r1);
        return;
    L5:
        if (this.g == null) goto L7;
        ActionSheetDialogFragment.ca0(getActivity(), SortFragment.class, r1, this.g.getIvSortIcon());
    }

    @Override // wc5.f.a
    public final void eF() {
        p r15 = new p("ccm_space_offline_page_click", OperationName.OPERATION_OFFLINE_AVAILABLE, "", "filter", "ccm_space_header_filter_view", "", e.e.b, "", "", false, false, false, 0, null, "", null);
        lc5.f.a.I(r15);
        Bundle r1 = getArguments();
        r1.putString("key_module", OperationName.OPERATION_OFFLINE_AVAILABLE);
        r1.putString("key_token", "manual_offline");
        r1.putParcelable("key_sort_strategy", this.l);
        r1.putBoolean("key_sort_filter_enable", false);
        r1.putBoolean("key_reset_enable", false);
        r1.putBoolean("key_done_enable", false);
        if (ForsetiHelper.s(this) == true) goto L5;
    L7:
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r1);
        return;
    L5:
        if (this.g == null) goto L7;
        ActionSheetDialogFragment.ca0(getActivity(), SortAndFilterFragment.class, r1, this.g.getIvFilterIcon());
    }

    public final boolean U90() {
        if (ForsetiHelper.n() == true) goto L5;
    L9:
        return false;
    L5:
        if (getParentFragment() == null) goto L9;
        if ((getParentFragment() instanceof h) == false) goto L9;
        return true;
    }

    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("HomeOfflineFragment", "onDestroy()...");
        yc5.b r0 = this.i;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        s1.a.a.h(this);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        tt5.a.h("HomeOfflineFragment", "onDestroyView()...");
    }

    public HomeOfflineFragment() {
    }

    @Override // dd5.p1
    public final void Mj(boolean r2) {
        this.f.b(r2);
    }

    @Override // wc5.f.a
    public final void WU(boolean r15) {
        Mj(r15);
        s1.a.a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r15, OperationName.OPERATION_OFFLINE_AVAILABLE);
        r r16 = new r("ccm_space_offline_page_click", OperationName.OPERATION_OFFLINE_AVAILABLE, "", "", e.e.b, false, false, false, 0, "");
        lc5.f.a.O(r16);
    }

    public final void onAttach(Context r2) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        tt5.a.h("HomeOfflineFragment", "onAttach()...");
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        tt5.a.h("HomeOfflineFragment", "onCreate()...");
    }

    public final void onSaveInstanceState(Bundle r2) {
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(r2);
        tt5.a.h("HomeOfflineFragment", "onSaveInstanceState()...");
    }

    public final void onViewCreated(View r7, Bundle r8) {
        super.onViewCreated(r7, r8);
        tt5.a.h("HomeOfflineFragment", "onViewCreated()...");
        if ((getActivity() instanceof g) == false) goto L5;
        this.e = getActivity().getTitleBar();
    L5:
        SmartRefreshLayout r9 = r7.findViewById(2131378171);
        wc5.e r0 = getChildFragmentManager().findFragmentById(2131378122);
        if (r0 == null) goto L8;
        r0.Co(r9);
    L8:
        wa5.a r1 = r9.findViewById(2131378060);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().a == false) goto L11;
        r1.setVisibility(0);
        this.h = r1;
    L12:
        wa5.a r2 = r9.getRefreshHeader();
        if ((r2 instanceof wa5.a) == false) goto L16;
        this.h.setCustomText(getString(2131887957));
        r2.setAssociatedHeader(this.h);
    L16:
        if (U90() == false) goto L18;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        r3.topMargin = 0;
        r1.setLayoutParams(r3);
    L18:
        r7.findViewById(2131378183).addOnOffsetChangedListener(new id5.b(this));
        CollapsingToolbarLayout r4 = r7.findViewById(2131378079);
        if (r4 == null) goto L43;
        ViewGroup r5 = this.h;
        if (r5 == null) goto L43;
        if ((r5 instanceof ViewGroup) == false) goto L43;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5.getLayoutParams();
        b r10 = this.e;
        if (r10 == null) goto L34;
        if ((r10 instanceof c) == false) goto L30;
    L39:
        r6.topMargin = 0;
    L40:
        this.h.setLayoutParams(r6);
        b r11 = this.e;
        if (r11 == null) goto L43;
        r4.setMinimumHeight(r11.getTitleBarHeight());
        goto L43
    L30:
        if ((r10 instanceof MainTabTitleBar) == true) goto L39;
        if (r10.getTitleType() == HomeMainTitleBar.TitleType.SPACE_ROUTE.ordinal()) goto L39;
    L34:
        if (U90() == true) goto L39;
        if (ForsetiHelper.s(this) == true) goto L39;
        r6.topMargin = getResources().getDimensionPixelSize(2131167715);
    L43:
        this.f = (SubMenuView) r7.findViewById(2131374462);
        s1.a.a.a(this);
        if (U90() == true) goto L46;
        this.f.setViewDelegate(this);
        Mj(t3.a);
    L54:
        this.i = new yc5.b(getContext(), r9, new a(this));
        this.j = r7.findViewById(2131380933);
        j.a.a.a().observe(getViewLifecycleOwner(), new id5.d(this));
        if (getActivity() == null) goto L57;
        ((SortAndFilterViewModel) new ViewModelProvider(getActivity()).get(SortAndFilterViewModel.class)).getSortStrategyLiveData().observe(getViewLifecycleOwner(), new id5.c(this));
    L57:
        s1.a.a.a(this);
        return;
    L46:
        if (getParentFragment() != null) goto L48;
    L52:
        this.f.setVisibility(8);
        goto L54
    L48:
        if (getParentFragment().getView() == null) goto L52;
        SubMenuViewPad r12 = (SubMenuViewPad) getParentFragment().getView().findViewById(2131387539);
        this.g = r12;
        if (r12 == null) goto L52;
        r12.setViewDelegate(this);
        goto L52
    L11:
        wa5.a r13 = r9.findViewById(2131378061);
        r13.setVisibility(0);
        r1.setVisibility(8);
        this.h = r13;
        goto L12
    }

    @Override // wc5.d
    public final void t(int r1, int r2) {
        b r3 = this.e;
        if (r3 == null) goto L6;
        r3.a(r2);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131563496, r3, false);
    }
}
