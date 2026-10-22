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
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
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
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HomeSharedFragment extends g implements g0, wc5.f.a, dd5.p1, d0c.c {
    public static final /* synthetic */ int B = 0;

    @Inject
    public jdb.g A;
    public com.bytedance.ee.bear.list.homepage.title.b p;
    public SubMenuView q;
    public SubMenuViewPad r;
    public wa5.a s;
    public yc5.b t;
    public View u;
    public View v;
    public ConnectionService.NetworkState w;
    public int x;
    public FolderSortStrategy y;
    public t3 z;

    public class a implements yc5.b.a {
        public final /* synthetic */ HomeSharedFragment a;

        @Override // yc5.b.a
        public final String m6() {
            return "none";
        }

        @Override // yc5.b.a
        public final String getModule() {
            HomeSharedFragment r0 = this.a;
            int r1 = HomeSharedFragment.B;
            r0.getClass();
            return "shared";
        }

        public a(HomeSharedFragment r1) {
            this.a = r1;
        }
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

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    @Override // wc5.d
    public final void Cu() {
        t3 r0 = this.z;
        if (r0 == null) goto L8;
        com.bytedance.ee.bear.list.homepage.banner.a r1 = r0.e;
        if (r1 == null) goto L9;
        ((com.bytedance.ee.bear.list.homepage.banner.f) r1.getModel()).m5();
        return;
    L9:
        return;
    }

    @Override // wc5.f.a
    public final void Qi() {
        if (this.A.isCurrentEnable("ccm.space.disable_share_edittime_sort") == false) goto L5;
        int r1 = 1;
    L6:
        ConnectionService.NetworkState r2 = this.w;
        if (r2 != null) goto L9;
    L16:
        Context r3 = ((LazyBaseFragment) this).g;
        Toast.showFailureText(r3, r3.getString(2131887789), 0);
        return;
    L9:
        if (r2.a() == false) goto L16;
        lc5.p r4 = new lc5.p("ccm_space_shared_page_click", "shared", "sharetome", "filter", "ccm_space_header_filter_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null);
        lc5.f.a.I(r4);
        Bundle r5 = new Bundle();
        r5.putString("key_token", "shared");
        r5.putParcelable("key_sort_strategy", this.y);
        r5.putInt("key_default_sort_pos", r1);
        if (ca0() == true) goto L13;
    L15:
        ActionSheetDialogFragment.ba0(getActivity(), SortFragment.class, r5);
        return;
    L13:
        if (this.r == null) goto L15;
        ActionSheetDialogFragment.ca0(getActivity(), SortFragment.class, r5, this.r.getIvSortIcon());
        return;
    L5:
        r1 = 2;
        goto L6
    }

    public final void W90() {
        tt5.a.h("HomeSharedFragment", "onDestroyViewLazy()...");
    }

    @Override // wc5.f.a
    public final void eF() {
        ConnectionService.NetworkState r1 = this.w;
        if (r1 != null) goto L5;
    L12:
        Context r2 = ((LazyBaseFragment) this).g;
        Toast.showFailureText(r2, r2.getString(2131887789), 0);
        return;
    L5:
        if (r1.a() == false) goto L12;
        lc5.f.a.I(new lc5.p("ccm_space_shared_page_click", "shared", "sharetome", "filter", "ccm_space_header_filter_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null));
        Bundle r3 = getArguments();
        r3.putString("key_module", "shared");
        r3.putString("key_token", "shared");
        r3.putParcelable("key_sort_strategy", this.y);
        r3.putBoolean("key_sort_filter_enable", false);
        r3.putBoolean("key_reset_enable", false);
        r3.putBoolean("key_done_enable", false);
        r3.putBoolean("key_filter_folder", !qc5.a.d());
        if (ForsetiHelper.s(this) == true) goto L9;
    L11:
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r3);
        return;
    L9:
        if (this.r == null) goto L11;
        ActionSheetDialogFragment.ca0(getActivity(), SortAndFilterFragment.class, r3, this.r.getIvFilterIcon());
    }

    @Override // com.bytedance.ee.bear.list.share.g0
    public final void Ud() {
        if (qc5.a.h() == false) goto L5;
        return;
    L5:
        View r0 = this.v;
        if (r0 == null) goto L9;
        r0.setVisibility(0);
        return;
    }

    public final void Y90() {
        super.Y90();
        t3 r0 = this.z;
        if (r0 == null) goto L8;
        com.bytedance.ee.bear.list.homepage.banner.a r1 = r0.e;
        if (r1 == null) goto L9;
        ((com.bytedance.ee.bear.list.homepage.banner.f) r1.getModel()).m5();
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

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return getActivity().e9();
    L7:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.list.share.g
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onDestroy();
        tt5.a.h("HomeSharedFragment", "onDestroy()...");
        yc5.b r0 = this.t;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        t3 r1 = this.z;
        if (r1 == null) goto L14;
        com.bytedance.ee.bear.list.homepage.banner.a r2 = r1.e;
        if (r2 == null) goto L10;
        r2.destroy();
    L10:
        yc5.b r3 = r1.g;
        if (r3 == null) goto L13;
        r3.b();
    L13:
        dd5.s1.a.a.h(r1);
    L14:
        dd5.s1.a.a.h(this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m38provideComponent() {
        return provideComponent();
    }

    public HomeSharedFragment() {
    }

    @Override // dd5.p1
    public final void Mj(boolean r2) {
        this.q.b(r2);
    }

    public final void V90(Bundle r11) {
        Z90(2131563499);
        if ((getActivity() instanceof wc5.g) == false) goto L5;
        this.p = getActivity().getTitleBar();
    L5:
        SmartRefreshLayout r12 = findViewById(2131378171);
        wc5.e r0 = getChildFragmentManager().findFragmentById(2131378122);
        if (r0 == null) goto L9;
        r0.Co(r12);
    L9:
        if (da0() == true) goto L18;
        wa5.a r1 = findViewById(2131378060);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().a == false) goto L14;
        r1.setVisibility(0);
        this.s = r1;
    L15:
        wa5.a r2 = r12.getRefreshHeader();
        if ((r2 instanceof wa5.a) == false) goto L18;
        this.s.setCustomText(getString(2131887957));
        r2.setAssociatedHeader(this.s);
        goto L18
    L14:
        wa5.a r6 = findViewById(2131378061);
        r6.setVisibility(0);
        r1.setVisibility(8);
        this.s = r6;
    L18:
        findViewById(2131378183).addOnOffsetChangedListener(new b0(this));
        ce5.a r3 = new ce5.a(this);
        boolean r7 = qc5.a.d();
        View r8 = findViewById(2131374280);
        if (r7 == false) goto L21;
        int r9 = 0;
    L22:
        r8.setVisibility(r9);
        if (qc5.a.h() == false) goto L25;
        r8.setVisibility(8);
    L27:
        CollapsingToolbarLayout r10 = findViewById(2131378079);
        if (r10 == null) goto L52;
        ViewGroup r13 = this.s;
        if (r13 == null) goto L52;
        if ((r13 instanceof ViewGroup) == false) goto L52;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13.getLayoutParams();
        com.bytedance.ee.bear.list.homepage.title.b r15 = this.p;
        if (r15 == null) goto L43;
        if ((r15 instanceof com.bytedance.ee.bear.list.homepage.title.c) == false) goto L39;
    L48:
        r14.topMargin = 0;
    L49:
        this.s.setLayoutParams(r14);
        com.bytedance.ee.bear.list.homepage.title.b r16 = this.p;
        if (r16 == null) goto L52;
        r10.setMinimumHeight(r16.getTitleBarHeight());
        goto L52
    L39:
        if ((r15 instanceof MainTabTitleBar) == true) goto L48;
        if (r15.getTitleType() == HomeMainTitleBar.TitleType.SPACE_ROUTE.ordinal()) goto L48;
    L43:
        if (ca0() == true) goto L48;
        if (ForsetiHelper.s(this) == true) goto L48;
        r14.topMargin = getResources().getDimensionPixelSize(2131167715);
    L52:
        this.q = (SubMenuView) findViewById(2131374462);
        dd5.s1.a.a.a(this);
        if (ca0() == false) goto L62;
        this.q.setVisibility(8);
        if (getParentFragment() != null) goto L57;
    L59:
        SubMenuViewPad r17 = this.r;
        if (r17 == null) goto L64;
        r17.setViewDelegate(this);
        this.r.e();
    L64:
        if (da0() == false) goto L74;
        this.q.c();
        AppCompatImageView r18 = this.q.c;
        if (r18 == null) goto L68;
        r18.setVisibility(8);
    L68:
        findViewById(2131378060).setVisibility(8);
        findViewById(2131378170).setVisibility(8);
        findViewById(2131378061).setVisibility(8);
        findViewById(2131378079).setMinimumHeight(0);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().a == false) goto L71;
        DigitDanceHeader r4 = new DigitDanceHeader(getContext());
        r4.setCustomText(getString(2131887957));
    L72:
        r12.G(r4, com.bytedance.ee.util.ui.n.d(65));
        goto L74
    L71:
        r4 = new CircleRefreshHeader(getContext());
    L74:
        if (ca0() == false) goto L76;
    L77:
        findViewById(2131378079).setMinimumHeight(0);
    L78:
        this.t = new yc5.b(((LazyBaseFragment) this).g, r12, new a(this));
        this.u = findViewById(2131380933);
        this.v = findViewById(2131374421);
        findViewById(2131374653).setOnClickListener(new c0());
        com.bytedance.ee.bear.contract.j.a.a.a().observe(this, new z(this));
        if (getActivity() == null) goto L81;
        ((SortAndFilterViewModel) ViewModelProviders.of(getActivity()).get(SortAndFilterViewModel.class)).getSortStrategyLiveData().observe(this, new a0(this));
    L81:
        dd5.s1.a.a.a(this);
        return;
    L76:
        if (ForsetiHelper.s(this) == false) goto L78;
    L57:
        if (getParentFragment().getView() == null) goto L59;
        this.r = (SubMenuViewPad) getParentFragment().getView().findViewById(2131387539);
        goto L59
    L62:
        this.q.setViewDelegate(this);
        Mj(com.bytedance.ee.bear.list.t3.a);
        goto L64
    L25:
        if (r7 == false) goto L27;
        this.z = new t3(this, getContext(), r8, r3);
        goto L27
    L21:
        r9 = 8;
        goto L22
    }

    @Override // wc5.f.a
    public final void WU(boolean r15) {
        Mj(r15);
        dd5.s1.a.a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r15, "shared");
        lc5.r r16 = new lc5.r("ccm_space_shared_page_click", "shared", "sharetome", "", sbb.e.e.b, false, false, false, 0, "");
        lc5.f.a.O(r16);
    }

    @Override // com.bytedance.ee.bear.list.share.g
    public final void onAttach(Context r2) {
        super.onAttach(r2);
        tt5.a.h("HomeSharedFragment", "onAttach()...");
    }

    public final void onCreate(Bundle r2) {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onCreate(r2);
        tt5.a.h("HomeSharedFragment", "onCreate()...");
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().getWindow() != null) goto L7;
        return;
    L7:
        if (((Boolean) ForsetiHelper.k.getValue()).booleanValue() == false) goto L12;
        getActivity().getWindow().setSoftInputMode(32);
        return;
    }

    public final void onSaveInstanceState(Bundle r2) {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onSaveInstanceState(r2);
        tt5.a.h("HomeSharedFragment", "onSaveInstanceState()...");
    }

    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        if (r1 == true) goto L5;
        return;
    L5:
        if (ca0() == false) goto L11;
        SubMenuViewPad r2 = this.r;
        if (r2 == null) goto L12;
        r2.setViewDelegate(this);
        this.r.e();
        return;
    L12:
        return;
    }

    @Override // wc5.d
    public final void t(int r1, int r2) {
        if (da0() == false) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.list.homepage.title.b r3 = this.p;
        if (r3 == null) goto L9;
        r3.a(r2);
        return;
    }
}
