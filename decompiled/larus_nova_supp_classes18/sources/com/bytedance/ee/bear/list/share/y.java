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
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y extends com.bytedance.ee.bear.list.list.c<n0.a> implements n0, wc5.f.a {
    public HomeMainTitleBar E;
    public SubMenuView F;
    public View G;
    public yc5.b H;
    public com.bytedance.ee.bear.list.create.x0 I;

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean H2(Document r1) {
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
        this.q = null;
        if (this.f == false) goto L5;
        com.bytedance.ee.bear.list.list.d r0 = new ShareFolderGridStyleAdapter(this.D);
    L6:
        U2(r0);
        s2(r0);
        return r0;
    L5:
        r0 = new ShareFolderListStyleAdapter(this.z, this.p, this.D, null);
        goto L6
    }

    @Override // wc5.f.a
    public final void Qi() {
        tt5.a.h("HistorySharedFolderView", "onClickSortMenu()...");
        if (D2() == false) goto L5;
        lc5.p r1 = new lc5.p("ccm_space_folder_click", "shared", "shared_folder", "filter", "ccm_space_header_filter_view", "", sbb.e.e.b, "", "", true, true, false, 0, Boolean.valueOf(C2()), "suspend_create", null);
        lc5.f.a.I(r1);
        Bundle r2 = new Bundle();
        r2.putString("key_token", "shared_folder");
        r2.putParcelable("key_sort_strategy", this.g);
        ActionSheetDialogFragment.ba0(this.d.getActivity(), SortFragment.class, r2);
        return;
    L5:
        Context r3 = this.b;
        Toast.showFailureText(r3, r3.getString(2131887789), 0);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        com.bytedance.ee.bear.list.loadstateview.h r1 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378179));
        this.k = r1;
        r1.a(EmptyCategory.SHARE);
        this.k.e(new s(this));
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void B2() {
        super.B2();
        cqa.h r0 = this.c.findViewById(2131378171);
        this.j = r0;
        wa5.a r1 = r0.getRefreshHeader();
        DigitDanceHeader r2 = this.c.findViewById(2131378060);
        if (r1 == null) goto L5;
        r1.setAssociatedHeader(r2);
        r2.setCustomText(this.b.getString(2131887920));
    L5:
        z2();
        this.G = this.c.findViewById(2131380933);
        tt5.a.h("HistorySharedFolderView", "initTitleBar()...");
        HomeCoordinatorLayout r3 = (HomeCoordinatorLayout) this.c.findViewById(2131378119);
        HomeMainTitleBar r4 = (HomeMainTitleBar) this.c.findViewById(2131378104);
        this.E = r4;
        r3.setMainTitle(r4);
        this.E.g();
        this.E.setTitle(this.b.getString(2131887267));
        this.E.setOnSearchBtnClickListener(new x(this));
        SubMenuView r5 = (SubMenuView) this.c.findViewById(2131374462);
        this.F = r5;
        r5.setViewDelegate(this);
        this.F.b(this.f);
        this.F.c();
        ((CommonCreateButton) this.c.findViewById(2131367552)).setOnClickListener(new w(this));
        qc5.a.k();
        if (this.d.getActivity() != null) goto L8;
        tt5.a.d("HistorySharedFolderView", "observeCreatePopupMenu()...activity is null");
    L9:
        this.c.findViewById(2131378183).addOnOffsetChangedListener(new t(this));
        this.H = new yc5.b(this.b, this.c, new v(this));
        lc5.f.p("shared", "shared_folder", "", true, "0", "0");
        return;
    L8:
        ViewModelProviders.of(this.d.getActivity()).get(SelectCreationMenuViewModel.class).getSelectedCreationTypeLiveData().observe(this.d, new u(this));
        goto L9
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void destroy() {
        super.destroy();
        yc5.b r0 = this.H;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, dd5.p1
    public final void Mj(boolean r2) {
        super.Mj(r2);
        this.F.b(r2);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void P2(FolderSortStrategy r4) {
        super.P2(r4);
        this.F.a(zd5.c.b(SortScene.FolderSort, r4.e, r4.f));
    }

    @Override // wc5.f.a
    public final void WU(boolean r15) {
        tt5.a.h("HistorySharedFolderView", "onClickGridMenu()...showGrid = " + r15);
        dd5.s1.a.a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r15, "shared_folder");
        lc5.f.a.O(new lc5.r("ccm_space_folder_click", "shared", "shared_folder", "", sbb.e.f.b, true, true, false, 0, ""));
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void h1(ConnectionService.NetworkState r3) {
        super.h1(r3);
        View r0 = this.G;
        if (r3.a() == false) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        this.F.setOffline(!r3.a());
        yc5.b r2 = this.H;
        if (r2 == null) goto L10;
        r2.c(r3);
        return;
    L10:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
        return new ShareFolderItemDiffCallback(r2, r3);
    }

    public y(Context r1, View r2, LifeCycleFragment r3, ce5.a r4) {
        super(r1, r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r20, int r21, Document r22, boolean r23) {
        super.Y(r20, r21, r22, r23);
        String r7 = r22.d;
        int r8 = r22.getType();
        String r9 = r22.F;
        if (r22.getType() != sbb.e.f.b) goto L5;
        boolean r18 = true;
    L6:
        boolean r11 = r18;
        lc5.p r12 = new lc5.p("ccm_space_folder_click", "shared", "shared_folder", "more", "ccm_space_right_click_menu_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", com.bytedance.ee.bear.list.t0.m(r22));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r21, int r22, Document r23, boolean r24) {
        tt5.a.h("HistorySharedFolderView", "onRightSlideMenuClick()...position = " + r22);
        ((n0.a) this.e).D(r23);
        if (r23.z == false) goto L5;
        String r3 = "remove_from_favorites";
    L6:
        String r7 = r3;
        String r9 = r23.d;
        int r10 = r23.getType();
        String r11 = r23.F;
        if (r23.getType() != sbb.e.f.b) goto L9;
        boolean r13 = true;
    L10:
        lc5.f.a.I(new lc5.p("ccm_space_folder_click", "shared", "shared_folder", r7, "none", r9, r10, r11, "", r13, FolderVersion.isShareFolder(r23.L1, r23.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", com.bytedance.ee.bear.list.t0.m(r23)));
        return;
    L9:
        r13 = false;
        goto L10
    L5:
        r3 = "add_to_favorites";
        goto L6
    }
}
