package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
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
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.list.list.multiselect.ListSelectPanelAction;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.sort.SortFragment;
import com.bytedance.ee.bear.list.sort.SortScene;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class i3 extends com.bytedance.ee.bear.list.list.c<n0.a> implements n0, wc5.f.a, ed5.d {
    public HomeMainTitleBar E;
    public SubMenuView F;
    public SubMenuViewPad G;
    public CommonCreateButton H;
    public HomeCoordinatorLayout I;
    public SmartRefreshLayout J;
    public View K;
    public yc5.b L;
    public com.bytedance.ee.bear.list.create.x0 M;
    public final ed5.a N;
    public final ed5.b O;

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean H2(Document r1) {
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean J2() {
        return false;
    }

    public String J3() {
        return "ccm_space_folder_click";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String S1() {
        return "shared";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public String Z1() {
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
    public String i2() {
        return "ShareFolderView";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final com.bytedance.ee.bear.list.list.d n1() {
        this.q = null;
        com.bytedance.ee.bear.list.list.d r1 = dd5.d1.a("shared_folder", this.f, this.d, this.D);
        if (r1 != null) goto L5;
        this.O.d(null);
        if (this.f == false) goto L13;
        com.bytedance.ee.bear.list.list.d r0 = new ShareFolderGridStyleAdapter(this.D);
    L14:
        U2(r0);
        s2(r0);
        return r0;
    L13:
        r0 = new ShareFolderListStyleAdapter(this.z, this.p, this.D, this.d);
        goto L14
    L5:
        if ((r1 instanceof ed5.c) == false) goto L7;
        this.O.d((ed5.c) r1);
    L8:
        U2(r1);
        s2(r1);
        return r1;
    L7:
        this.O.d(null);
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean p2() {
        return true;
    }

    private void I3() {
        ed5.f r0 = this.d;
        if ((r0 instanceof ed5.f) == false) goto L5;
        r0.It(this.N);
        return;
    L5:
        if (r0 != null) goto L7;
        return;
    L7:
        if ((r0.getParentFragment() instanceof ed5.f) == false) goto L12;
        this.d.getParentFragment().It(this.N);
        return;
    }

    @Override // wc5.f.a
    public final void Qi() {
        tt5.a.h("ShareFolderView", "onClickSortMenu()...");
        if (D2() == false) goto L10;
        lc5.p r1 = new lc5.p(J3(), "shared", "shared_folder", "filter", "ccm_space_header_filter_view", "", sbb.e.e.b, "", "", true, true, false, 0, Boolean.valueOf(C2()), "suspend_create", null);
        lc5.f.a.I(r1);
        Bundle r2 = new Bundle();
        r2.putString("key_token", Z1());
        r2.putParcelable("key_sort_strategy", this.g);
        if (ForsetiHelper.s(this.d) == true) goto L7;
    L9:
        ActionSheetDialogFragment.ba0(this.d.getActivity(), SortFragment.class, r2);
        return;
    L7:
        if (this.G == null) goto L9;
        ActionSheetDialogFragment.ca0(this.d.getActivity(), SortFragment.class, r2, this.G.getIvSortIcon());
        return;
    L10:
        Context r3 = this.b;
        Toast.showFailureText(r3, r3.getString(2131887789), 0);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String W1() {
        return this.b.getString(2131887920);
    }

    @Override // ed5.d
    public final boolean ZT() {
        return this.N.a;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        com.bytedance.ee.bear.list.loadstateview.h r1 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378179));
        this.k = r1;
        r1.a(EmptyCategory.SHARE_FOLDER);
        this.k.e(new d3(this));
    }

    @Override // ed5.d
    public final void xk() {
        if (this.N.a == true) goto L5;
        return;
    L5:
        this.O.c();
        I3();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public void B2() {
        super.B2();
        SmartRefreshLayout r0 = (cqa.h) this.c.findViewById(2131378171);
        this.j = r0;
        if (this.J == null) goto L5;
    L7:
        wa5.a r1 = r0.getRefreshHeader();
        DigitDanceHeader r2 = this.c.findViewById(2131378060);
        if (r1 == null) goto L10;
        r1.setAssociatedHeader(r2);
    L10:
        z2();
        this.K = this.c.findViewById(2131380933);
        this.I = (HomeCoordinatorLayout) this.c.findViewById(2131378119);
        HomeMainTitleBar r3 = (HomeMainTitleBar) this.c.findViewById(2131378104);
        this.E = r3;
        r3.g();
        this.E.setTitle(this.b.getString(2131887978));
        this.E.setOnSearchBtnClickListener(new g3(this));
        this.E.setOnCreateViewClickListener(new h3(this));
        HashMap r4 = new HashMap();
        r4.put("module", "shared");
        BaseTitleBar r5 = this.E.getTitleBar();
        if (r5 == null) goto L13;
        r5.setTag(2131388811, r4);
    L13:
        SubMenuView r6 = (SubMenuView) this.c.findViewById(2131374462);
        this.F = r6;
        r6.c();
        this.F.setViewDelegate(this);
        this.F.b(this.f);
        if (this.d.getParentFragment() != null) goto L16;
    L18:
        CommonCreateButton r7 = (CommonCreateButton) this.c.findViewById(2131367552);
        this.H = r7;
        r7.setOnClickListener(new f3(this));
        if (this.d.getActivity() != null) goto L21;
        tt5.a.d("ShareFolderView", "observeCreatePopupMenu()...activity is null");
    L22:
        this.L = new yc5.b(this.b, this.c, new e3(this));
        return;
    L21:
        ViewModelProviders.of(this.d.getActivity()).get(SelectCreationMenuViewModel.class).getSelectedCreationTypeLiveData().observe(this.d, new c3(this));
        goto L22
    L16:
        if (this.d.getParentFragment().getView() == null) goto L18;
        this.G = (SubMenuViewPad) this.d.getParentFragment().getView().findViewById(2131387539);
        goto L18
    L5:
        if ((r0 instanceof SmartRefreshLayout) == false) goto L7;
        this.J = r0;
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean E2() {
        if (ForsetiHelper.n() == false) goto L11;
        LifeCycleFragment r0 = this.d;
        if (r0 == null) goto L11;
        if (r0.getParentFragment() == null) goto L11;
        if ((this.d.getParentFragment() instanceof wc5.h) == false) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void create() {
        super.create();
        lc5.f.q((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "shared_folder");
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "shared_folder");
        lc5.f.p("shared", "shared_folder", "", true, "0", "0");
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void destroy() {
        super.destroy();
        yc5.b r0 = this.L;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public static void B3(i3 r2) {
        tt5.a.h(r2.i2(), "closePopupMenu()...");
        if (r2.M != null) goto L5;
        r2.M = new com.bytedance.ee.bear.list.create.x0();
    L5:
        r2.M.a(r2.d.getActivity());
    }

    public static void F3(i3 r27) {
        tt5.a.h(r27.i2(), "onMenuCreateClick()...");
        FragmentActivity r1 = r27.d.getActivity();
        if (r27.M != null) goto L6;
        r27.M = new com.bytedance.ee.bear.list.create.x0();
    L6:
        if (r27.M.a(r1) == false) goto L8;
        tt5.a.h("ShareFolderView", "create menu is already showing");
        return;
    L8:
        iw4.h r2 = new iw4.h();
        r2.b = "shared";
        r2.c = "shared_folder";
        qc5.a.j();
        r2.g = true;
        LifeCycleFragment r4 = r27.d;
        if (r4 != null) goto L11;
    L13:
        Fragment r5 = null;
    L15:
        if (r27.M != null) goto L17;
        r27.M = new com.bytedance.ee.bear.list.create.x0();
    L17:
        com.bytedance.ee.bear.list.create.x0 r6 = r27.M;
        boolean r7 = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).d();
        boolean r8 = ((ww4.a) org.koin.java.a.a(ww4.a.class)).a().d().a;
        SelectCreationMenuConfig r9 = new SelectCreationMenuConfig();
        r9.l = com.bytedance.ee.bear.list.t0.s();
        if (r7 == true) goto L20;
    L23:
        boolean r10 = true;
    L24:
        r9.o = r10;
        r9.p = com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.docx_create_enable");
        r9.k = true;
        r9.n = r8;
        r9.d = false;
        r9.f = false;
        r9.g = false;
        r6.c(r1, r2, r9, r5);
        lc5.p r3 = new lc5.p("ccm_space_folder_click", "shared", "shared_folder", "create", "ccm_space_create_new_view", "", sbb.e.f.b, "", "", true, true, false, 0, Boolean.valueOf(r27.C2()), "suspend_create", null);
        lc5.f.a.I(r3);
        return;
    L20:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.spacekit.bitable.enable", true) == true) goto L23;
        r10 = false;
        goto L24
    L11:
        if (r4.getParentFragment() == null) goto L13;
        r5 = r27.d.getParentFragment();
        goto L15
    }

    @Override // ed5.d
    public final void Dt(Document r2) {
        if ((this.q instanceof ed5.c) == false) goto L10;
        if (r2 != null) goto L6;
        return;
    L6:
        if (this.N.a == false) goto L12;
        this.O.f(r2);
        I3();
        return;
    L12:
        return;
    }

    public ArrayList<Document> M3(ArrayList<Document> r5) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<Document> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Document r2 = r6.next();
        if (r2.P0 == true) goto L7;
        r0.add(r2);
        goto L4
    L7:
        r1.add(r2);
        goto L4
    L9:
        ArrayList<Document> r7 = new ArrayList(r0);
        if (CollectionUtils.isNotEmpty(r1) == false) goto L12;
        r7.add(new TitleDocument());
    L12:
        r7.addAll(r1);
        return r7;
    }

    @Override // com.bytedance.ee.bear.list.list.c, dd5.p1
    public final void Mj(boolean r4) {
        super.Mj(r4);
        HomeMainTitleBar r0 = this.E;
        r0.m = r4;
        if (r0.f != null) goto L5;
        r0.f = new AppCompatImageView(r0.getContext());
    L5:
        AppCompatImageView r1 = r0.f;
        if (r0.m == false) goto L8;
        int r2 = 2131254229;
    L9:
        r1.setBackgroundResource(r2);
        com.bytedance.ee.util.ui.l.b(r0.f, 2131101926);
        this.F.b(r4);
        return;
    L8:
        r2 = 2131253870;
        goto L9
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void P2(FolderSortStrategy r5) {
        super.P2(r5);
        SubMenuView r0 = this.F;
        if (r0 == null) goto L5;
        r0.a(zd5.c.b(SortScene.FolderSort, r5.e, r5.f));
    L5:
        SubMenuViewPad r1 = this.G;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r5.e == 5) goto L10;
        boolean r2 = true;
    L11:
        r1.setSelectedSortState(r2);
        SubMenuViewPad r3 = this.G;
        zd5.c.b(SortScene.FolderSort, r5.e, r5.f);
        r3.getClass();
        return;
    L10:
        r2 = false;
        goto L11
    }

    @Override // wc5.f.a
    public final void WU(boolean r15) {
        tt5.a.h("ShareFolderView", "onClickGridMenu()...showGrid = " + r15);
        dd5.s1.a.a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r15, "shared_folder");
        lc5.f.a.O(new lc5.r(J3(), "shared", "shared_folder", "", sbb.e.f.b, true, true, false, 0, ""));
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final GridLayoutManager.SpanSizeLookup c2(GridLayoutManager r3) {
        return new ShareFolderListSpanSizeLookup(this.q, r3);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void h1(ConnectionService.NetworkState r3) {
        super.h1(r3);
        View r0 = this.K;
        if (r3.a() == false) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        SubMenuView r2 = this.F;
        if (r2 == null) goto L9;
        r2.setOffline(!r3.a());
    L9:
        yc5.b r4 = this.L;
        if (r4 == null) goto L13;
        r4.c(r3);
        return;
    L13:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void l0(ArrayList<Document> r7) {
        if (r7 != null) goto L5;
        tt5.a.h(i2(), "showList()...list is null");
        return;
    L5:
        ArrayList<Document> r0 = dd5.a.a(r7, this.D.d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible"));
        if (r0 != null) goto L8;
        r0 = new ArrayList(r7);
    L11:
        ArrayList<Document> r1 = M3(r0);
        super.l0(r1);
        r3(r7.size(), r0.size(), r1.size());
        if (this.N.a == false) goto L14;
        this.O.e(r1);
    L14:
        I3();
        return;
    L8:
        int r2 = r7.size();
        int r3 = r0.size();
        if (r3 == r2) goto L11;
        tt5.a.h(i2(), "ai_artifact_folder_display_filter_before_hidden_group, rawSize=" + r2 + ", visibleSize=" + r3);
        goto L11
    }

    @Override // ed5.d
    public final void sT(Document r2) {
        if ((this.q instanceof ed5.c) == true) goto L5;
        return;
    L5:
        this.O.b(r2);
        I3();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
        return new ShareFolderItemDiffCallback(r2, r3);
    }

    @Override // ed5.d
    public final boolean KL(ListSelectPanelAction r4, List<Document> r5, ed5.g r6) {
        if ((this.q instanceof com.bytedance.ee.bear.list.list.d) == false) goto L17;
        if (r5 == null) goto L17;
        if (r5.size() != 1) goto L17;
        if (r4 == ListSelectPanelAction.SHARE) goto L12;
        return false;
    L12:
        if (r6.a == false) goto L14;
        boolean r7 = true;
    L15:
        B0(this.c, -1, (Document) ListProtector.get(r5, 0), r7);
        return true;
    L14:
        r7 = false;
    L17:
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void P(View r20, int r21, Document r22) {
        super.P(r20, r21, r22);
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

    public i3(Context r1, View r2, LifeCycleFragment r3, ce5.a r4) {
        super(r1, r2, r3, r4);
        ed5.a r5 = new ed5.a();
        this.N = r5;
        this.O = new ed5.b(r5);
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
        tt5.a.h(i2(), "onRightSlideMenuClick()...position = " + r22);
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
