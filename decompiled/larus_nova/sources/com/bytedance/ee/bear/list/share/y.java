package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.homepage.HomeCoordinatorLayout;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.sort.SortFragment;
import com.bytedance.ee.bear.list.sort.SortScene;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class y extends com.bytedance.ee.bear.list.list.c<n0.a> implements n0, wc5.f.a {
    public HomeMainTitleBar E;
    public SubMenuView F;
    public View G;
    public yc5.b H;
    public com.bytedance.ee.bear.list.create.x0 I;

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean H2(Document r100) {
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String S1() {
        return "shared";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        return "shared_folder";
    }

    @Override // wc5.f.a
    public final void eF() {
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String h2() {
        return "shared_folder";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "HistorySharedFolderView";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final com.bytedance.ee.bear.list.list.d n1() {
        this.f228583q = null;
        if (this.f228572f == false) goto L5;
        com.bytedance.ee.bear.list.list.d r100 = new ShareFolderGridStyleAdapter(this.D);
    L6:
        U2(r100);
        s2(r100);
        return r100;
    L5:
        r100 = new ShareFolderListStyleAdapter(this.f228592z, this.f228582p, this.D, null);
        goto L6
    }

    @Override // wc5.f.a
    public final void Qi() {
        tt5.a.h("HistorySharedFolderView", "onClickSortMenu()...");
        if (D2() == false) goto L5;
        lc5.p r100 = new lc5.p("ccm_space_folder_click", "shared", "shared_folder", "filter", "ccm_space_header_filter_view", "", sbb.e.f541294e.f541317b, "", "", true, true, false, 0, Boolean.valueOf(C2()), "suspend_create", null);
        lc5.f.f508440a.I(r100);
        Bundle r101 = new Bundle();
        r101.putString("key_token", "shared_folder");
        r101.putParcelable("key_sort_strategy", this.f228573g);
        ActionSheetDialogFragment.ba0(this.f228570d.getActivity(), SortFragment.class, r101);
        return;
    L5:
        Context r102 = this.f228568b;
        Toast.showFailureText(r102, r102.getString(R.string.Doc_Facade_Offline), 0);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        com.bytedance.ee.bear.list.loadstateview.h r100 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.f228569c.findViewById(R.id.list_state_view_root));
        this.f228577k = r100;
        r100.a(EmptyCategory.SHARE);
        this.f228577k.e(new s(this));
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void B2() {
        super.B2();
        cqa.h r100 = (cqa.h) this.f228569c.findViewById(R.id.list_refresh_layout);
        this.f228576j = r100;
        wa5.a r101 = (wa5.a) r100.getRefreshHeader();
        DigitDanceHeader r102 = (DigitDanceHeader) this.f228569c.findViewById(R.id.list_appbar_refresh_header);
        if (r101 == null) goto L5;
        r101.setAssociatedHeader(r102);
        r102.setCustomText(this.f228568b.getString(R.string.Doc_List_FolderRefreshTips));
    L5:
        z2();
        this.G = this.f228569c.findViewById(R.id.no_net_container);
        tt5.a.h("HistorySharedFolderView", "initTitleBar()...");
        HomeCoordinatorLayout r103 = (HomeCoordinatorLayout) this.f228569c.findViewById(R.id.list_home_coordinator_layout);
        HomeMainTitleBar r104 = (HomeMainTitleBar) this.f228569c.findViewById(R.id.list_folder_title_bar);
        this.E = r104;
        r103.setMainTitle(r104);
        this.E.g();
        this.E.setTitle(this.f228568b.getString(R.string.CreationMobile_ECM_FileMigration_Path_title));
        this.E.setOnSearchBtnClickListener(new x(this));
        SubMenuView r105 = (SubMenuView) this.f228569c.findViewById(R.id.home_sub_title_view);
        this.F = r105;
        r105.setViewDelegate(this);
        this.F.b(this.f228572f);
        this.F.c();
        ((CommonCreateButton) this.f228569c.findViewById(R.id.common_create_button)).setOnClickListener(new w(this));
        qc5.a.k();
        if (this.f228570d.getActivity() != null) goto L8;
        tt5.a.d("HistorySharedFolderView", "observeCreatePopupMenu()...activity is null");
    L9:
        ((AppBarLayout) this.f228569c.findViewById(R.id.list_sub_menu_layout)).addOnOffsetChangedListener(new t(this));
        this.H = new yc5.b(this.f228568b, this.f228569c, new v(this));
        lc5.f.p("shared", "shared_folder", "", true, "0", "0");
        return;
    L8:
        ((SelectCreationMenuViewModel) ViewModelProviders.of(this.f228570d.getActivity()).get(SelectCreationMenuViewModel.class)).getSelectedCreationTypeLiveData().observe(this.f228570d, new u(this));
        goto L9
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        yc5.b r100 = this.H;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, dd5.p1
    public final void Mj(boolean r100) {
        super.Mj(r100);
        this.F.b(r100);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void P2(FolderSortStrategy r100) {
        super.P2(r100);
        this.F.a(zd5.c.b(SortScene.FolderSort, r100.f227684e, r100.f227685f));
    }

    @Override // wc5.f.a
    public final void WU(boolean r110) {
        tt5.a.h("HistorySharedFolderView", "onClickGridMenu()...showGrid = " + r110);
        dd5.s1.a.f468004a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r110, "shared_folder");
        lc5.f.f508440a.O(new lc5.r("ccm_space_folder_click", "shared", "shared_folder", "", sbb.e.f541295f.f541317b, true, true, false, 0, ""));
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void h1(ConnectionService.NetworkState r100) {
        super.h1(r100);
        View r101 = this.G;
        if (r100.a() == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        this.F.setOffline(!r100.a());
        yc5.b r103 = this.H;
        if (r103 == null) goto L10;
        r103.c(r100);
        return;
    L10:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r100, List<Document> r101) {
        return new ShareFolderItemDiffCallback(r100, r101);
    }

    public y(Context r100, View r101, LifeCycleFragment r102, ce5.a r103) {
        super(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r210, int r211, Document r212, boolean r213) {
        super.Y(r210, r211, r212, r213);
        String r100 = r212.f227873d;
        int r101 = r212.getType();
        String r102 = r212.F;
        if (r212.getType() != sbb.e.f541295f.f541317b) goto L5;
        boolean r110 = true;
    L6:
        boolean r111 = r110;
        lc5.p r112 = new lc5.p("ccm_space_folder_click", "shared", "shared_folder", "more", "ccm_space_right_click_menu_view", r100, r101, r102, "", r111, FolderVersion.isShareFolder(r212.L1, r212.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", com.bytedance.ee.bear.list.t0.m(r212));
        lc5.f.f508440a.I(r112);
        return;
    L5:
        r110 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r210, int r211, Document r212, boolean r213) {
        tt5.a.h("HistorySharedFolderView", "onRightSlideMenuClick()...position = " + r211);
        ((n0.a) this.f228571e).D(r212);
        if (r212.f227910z == false) goto L5;
        String r100 = "remove_from_favorites";
    L6:
        String r101 = r100;
        String r102 = r212.f227873d;
        int r110 = r212.getType();
        String r111 = r212.F;
        if (r212.getType() != sbb.e.f541295f.f541317b) goto L9;
        boolean r112 = true;
    L10:
        lc5.f.f508440a.I(new lc5.p("ccm_space_folder_click", "shared", "shared_folder", r101, "none", r102, r110, r111, "", r112, FolderVersion.isShareFolder(r212.L1, r212.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", com.bytedance.ee.bear.list.t0.m(r212)));
        return;
    L9:
        r112 = false;
        goto L10
    L5:
        r100 = "add_to_favorites";
        goto L6
    }
}
