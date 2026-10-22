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
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class i3 extends com.bytedance.ee.bear.list.list.c<n0.a> implements n0, wc5.f.a, ed5.d {
    public HomeMainTitleBar E;
    public SubMenuView F;
    public SubMenuViewPad G;
    public CommonCreateButton H;
    public HomeCoordinatorLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public SmartRefreshLayout f229489J;
    public View K;
    public yc5.b L;
    public com.bytedance.ee.bear.list.create.x0 M;
    public final ed5.a N;
    public final ed5.b O;

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean H2(Document r100) {
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
        this.f228583q = null;
        com.bytedance.ee.bear.list.list.d r100 = dd5.d1.a("shared_folder", this.f228572f, this.f228570d, this.D);
        if (r100 != null) goto L5;
        this.O.d(null);
        if (this.f228572f == false) goto L13;
        com.bytedance.ee.bear.list.list.d r101 = new ShareFolderGridStyleAdapter(this.D);
    L14:
        U2(r101);
        s2(r101);
        return r101;
    L13:
        r101 = new ShareFolderListStyleAdapter(this.f228592z, this.f228582p, this.D, this.f228570d);
        goto L14
    L5:
        if ((r100 instanceof ed5.c) == false) goto L7;
        this.O.d((ed5.c) r100);
    L8:
        U2(r100);
        s2(r100);
        return r100;
    L7:
        this.O.d(null);
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean p2() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void I3() {
        LifeCycleFragment r100 = this.f228570d;
        if ((r100 instanceof ed5.f) == false) goto L5;
        ((ed5.f) r100).It(this.N);
        return;
    L5:
        if (r100 != 0) goto L7;
        return;
    L7:
        if ((r100.getParentFragment() instanceof ed5.f) == false) goto L12;
        ((ed5.f) this.f228570d.getParentFragment()).It(this.N);
        return;
    }

    @Override // wc5.f.a
    public final void Qi() {
        tt5.a.h("ShareFolderView", "onClickSortMenu()...");
        if (D2() == false) goto L10;
        lc5.p r100 = new lc5.p(J3(), "shared", "shared_folder", "filter", "ccm_space_header_filter_view", "", sbb.e.f541294e.f541317b, "", "", true, true, false, 0, Boolean.valueOf(C2()), "suspend_create", null);
        lc5.f.f508440a.I(r100);
        Bundle r101 = new Bundle();
        r101.putString("key_token", Z1());
        r101.putParcelable("key_sort_strategy", this.f228573g);
        if (ForsetiHelper.s(this.f228570d) == true) goto L7;
    L9:
        ActionSheetDialogFragment.ba0(this.f228570d.getActivity(), SortFragment.class, r101);
        return;
    L7:
        if (this.G == null) goto L9;
        ActionSheetDialogFragment.ca0(this.f228570d.getActivity(), SortFragment.class, r101, this.G.getIvSortIcon());
        return;
    L10:
        Context r102 = this.f228568b;
        Toast.showFailureText(r102, r102.getString(R.string.Doc_Facade_Offline), 0);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String W1() {
        return this.f228568b.getString(R.string.Doc_List_FolderRefreshTips);
    }

    @Override // ed5.d
    public final boolean ZT() {
        return this.N.f472208a;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        com.bytedance.ee.bear.list.loadstateview.h r100 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.f228569c.findViewById(R.id.list_state_view_root));
        this.f228577k = r100;
        r100.a(EmptyCategory.SHARE_FOLDER);
        this.f228577k.e(new d3(this));
    }

    @Override // ed5.d
    public final void xk() {
        if (this.N.f472208a == true) goto L5;
        return;
    L5:
        this.O.c();
        I3();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public void B2() {
        super.B2();
        cqa.h r100 = (cqa.h) this.f228569c.findViewById(R.id.list_refresh_layout);
        this.f228576j = r100;
        if (this.f229489J == null) goto L5;
    L7:
        wa5.a r101 = (wa5.a) r100.getRefreshHeader();
        DigitDanceHeader r102 = (DigitDanceHeader) this.f228569c.findViewById(R.id.list_appbar_refresh_header);
        if (r101 == null) goto L10;
        r101.setAssociatedHeader(r102);
    L10:
        z2();
        this.K = this.f228569c.findViewById(R.id.no_net_container);
        this.I = (HomeCoordinatorLayout) this.f228569c.findViewById(R.id.list_home_coordinator_layout);
        HomeMainTitleBar r103 = (HomeMainTitleBar) this.f228569c.findViewById(R.id.list_folder_title_bar);
        this.E = r103;
        r103.g();
        this.E.setTitle(this.f228568b.getString(R.string.Doc_List_ShareFolders));
        this.E.setOnSearchBtnClickListener(new g3(this));
        this.E.setOnCreateViewClickListener(new h3(this));
        HashMap r104 = new HashMap();
        r104.put(EventConstant.Key.MODULE, "shared");
        BaseTitleBar r105 = this.E.getTitleBar();
        if (r105 == null) goto L13;
        r105.setTag(R.id.title_bar_common_params, r104);
    L13:
        SubMenuView r106 = (SubMenuView) this.f228569c.findViewById(R.id.home_sub_title_view);
        this.F = r106;
        r106.c();
        this.F.setViewDelegate(this);
        this.F.b(this.f228572f);
        if (this.f228570d.getParentFragment() != null) goto L16;
    L18:
        CommonCreateButton r107 = (CommonCreateButton) this.f228569c.findViewById(R.id.common_create_button);
        this.H = r107;
        r107.setOnClickListener(new f3(this));
        if (this.f228570d.getActivity() != null) goto L21;
        tt5.a.d("ShareFolderView", "observeCreatePopupMenu()...activity is null");
    L22:
        this.L = new yc5.b(this.f228568b, this.f228569c, new e3(this));
        return;
    L21:
        ((SelectCreationMenuViewModel) ViewModelProviders.of(this.f228570d.getActivity()).get(SelectCreationMenuViewModel.class)).getSelectedCreationTypeLiveData().observe(this.f228570d, new c3(this));
        goto L22
    L16:
        if (this.f228570d.getParentFragment().getView() == null) goto L18;
        this.G = (SubMenuViewPad) this.f228570d.getParentFragment().getView().findViewById(R.id.sub_menu_view_pad);
        goto L18
    L5:
        if ((r100 instanceof SmartRefreshLayout) == false) goto L7;
        this.f229489J = (SmartRefreshLayout) r100;
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean E2() {
        if (ForsetiHelper.n() == false) goto L11;
        LifeCycleFragment r100 = this.f228570d;
        if (r100 == null) goto L11;
        if (r100.getParentFragment() == null) goto L11;
        if ((this.f228570d.getParentFragment() instanceof wc5.h) == false) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        lc5.f.q((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "shared_folder");
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "shared_folder");
        lc5.f.p("shared", "shared_folder", "", true, "0", "0");
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        yc5.b r100 = this.L;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    public static void B3(i3 r100) {
        tt5.a.h(r100.i2(), "closePopupMenu()...");
        if (r100.M != null) goto L5;
        r100.M = new com.bytedance.ee.bear.list.create.x0();
    L5:
        r100.M.a(r100.f228570d.getActivity());
    }

    public static void F3(i3 r210) {
        tt5.a.h(r210.i2(), "onMenuCreateClick()...");
        FragmentActivity r100 = r210.f228570d.getActivity();
        if (r210.M != null) goto L6;
        r210.M = new com.bytedance.ee.bear.list.create.x0();
    L6:
        if (r210.M.a(r100) == false) goto L8;
        tt5.a.h("ShareFolderView", "create menu is already showing");
        return;
    L8:
        iw4.h r101 = new iw4.h();
        r101.f496209b = "shared";
        r101.f496210c = "shared_folder";
        qc5.a.j();
        r101.f496214g = true;
        LifeCycleFragment r102 = r210.f228570d;
        if (r102 != null) goto L11;
    L13:
        Fragment r103 = null;
    L15:
        if (r210.M != null) goto L17;
        r210.M = new com.bytedance.ee.bear.list.create.x0();
    L17:
        com.bytedance.ee.bear.list.create.x0 r104 = r210.M;
        boolean r105 = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).d();
        boolean r106 = ((ww4.a) org.koin.java.a.a(ww4.a.class)).a().d().f217118a;
        SelectCreationMenuConfig r107 = new SelectCreationMenuConfig();
        r107.f216816l = com.bytedance.ee.bear.list.t0.s();
        if (r105 == true) goto L20;
    L23:
        boolean r108 = true;
    L24:
        r107.f216819o = r108;
        r107.f216820p = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("spacekit.mobile.docx_create_enable");
        r107.f216815k = true;
        r107.f216818n = r106;
        r107.f216808d = false;
        r107.f216810f = false;
        r107.f216811g = false;
        r104.c(r100, r101, r107, r103);
        lc5.p r109 = new lc5.p("ccm_space_folder_click", "shared", "shared_folder", "create", "ccm_space_create_new_view", "", sbb.e.f541295f.f541317b, "", "", true, true, false, 0, Boolean.valueOf(r210.C2()), "suspend_create", null);
        lc5.f.f508440a.I(r109);
        return;
    L20:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.spacekit.bitable.enable", true) == true) goto L23;
        r108 = false;
        goto L24
    L11:
        if (r102.getParentFragment() == null) goto L13;
        r103 = r210.f228570d.getParentFragment();
        goto L15
    }

    @Override // ed5.d
    public final void Dt(Document r100) {
        if ((this.f228583q instanceof ed5.c) == false) goto L10;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.N.f472208a == false) goto L12;
        this.O.f(r100);
        I3();
        return;
    L12:
        return;
    }

    public ArrayList<Document> M3(ArrayList<Document> r100) {
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        Iterator<Document> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Document r104 = r103.next();
        if (r104.P0 == true) goto L7;
        r101.add(r104);
        goto L4
    L7:
        r102.add(r104);
        goto L4
    L9:
        ArrayList<Document> r105 = new ArrayList(r101);
        if (CollectionUtils.isNotEmpty(r102) == false) goto L12;
        r105.add(new TitleDocument());
    L12:
        r105.addAll(r102);
        return r105;
    }

    @Override // com.bytedance.ee.bear.list.list.c, dd5.p1
    public final void Mj(boolean r100) {
        super.Mj(r100);
        HomeMainTitleBar r101 = this.E;
        r101.f228361m = r100;
        if (r101.f228354f != null) goto L5;
        r101.f228354f = new AppCompatImageView(r101.getContext());
    L5:
        AppCompatImageView r102 = r101.f228354f;
        if (r101.f228361m == false) goto L8;
        int r103 = R.drawable.ud_icon_disorder_list_outlined;
    L9:
        r102.setBackgroundResource(r103);
        com.bytedance.ee.util.ui.l.b(r101.f228354f, R.color.facade_selector_icon_n1);
        this.F.b(r100);
        return;
    L8:
        r103 = R.drawable.ud_icon_borders_outlined;
        goto L9
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void P2(FolderSortStrategy r100) {
        super.P2(r100);
        SubMenuView r101 = this.F;
        if (r101 == null) goto L5;
        r101.a(zd5.c.b(SortScene.FolderSort, r100.f227684e, r100.f227685f));
    L5:
        SubMenuViewPad r102 = this.G;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r100.f227684e == 5) goto L10;
        boolean r103 = true;
    L11:
        r102.setSelectedSortState(r103);
        SubMenuViewPad r104 = this.G;
        zd5.c.b(SortScene.FolderSort, r100.f227684e, r100.f227685f);
        r104.getClass();
        return;
    L10:
        r103 = false;
        goto L11
    }

    @Override // wc5.f.a
    public final void WU(boolean r110) {
        tt5.a.h("ShareFolderView", "onClickGridMenu()...showGrid = " + r110);
        dd5.s1.a.f468004a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r110, "shared_folder");
        lc5.f.f508440a.O(new lc5.r(J3(), "shared", "shared_folder", "", sbb.e.f541295f.f541317b, true, true, false, 0, ""));
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final GridLayoutManager.SpanSizeLookup c2(GridLayoutManager r100) {
        return new ShareFolderListSpanSizeLookup(this.f228583q, r100);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void h1(ConnectionService.NetworkState r100) {
        super.h1(r100);
        View r101 = this.K;
        if (r100.a() == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        SubMenuView r103 = this.F;
        if (r103 == null) goto L9;
        r103.setOffline(!r100.a());
    L9:
        yc5.b r104 = this.L;
        if (r104 == null) goto L13;
        r104.c(r100);
        return;
    L13:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void l0(ArrayList<Document> r100) {
        if (r100 != null) goto L5;
        tt5.a.h(i2(), "showList()...list is null");
        return;
    L5:
        ArrayList<Document> r101 = dd5.a.a(r100, this.D.f23449d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible"));
        if (r101 != null) goto L8;
        r101 = new ArrayList(r100);
    L11:
        ArrayList<Document> r102 = M3(r101);
        super.l0(r102);
        r3(r100.size(), r101.size(), r102.size());
        if (this.N.f472208a == false) goto L14;
        this.O.e(r102);
    L14:
        I3();
        return;
    L8:
        int r103 = r100.size();
        int r104 = r101.size();
        if (r104 == r103) goto L11;
        tt5.a.h(i2(), "ai_artifact_folder_display_filter_before_hidden_group, rawSize=" + r103 + ", visibleSize=" + r104);
        goto L11
    }

    @Override // ed5.d
    public final void sT(Document r100) {
        if ((this.f228583q instanceof ed5.c) == true) goto L5;
        return;
    L5:
        this.O.b(r100);
        I3();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r100, List<Document> r101) {
        return new ShareFolderItemDiffCallback(r100, r101);
    }

    @Override // ed5.d
    public final boolean KL(ListSelectPanelAction r100, List<Document> r101, ed5.g r102) {
        if ((this.f228583q instanceof com.bytedance.ee.bear.list.list.d) == false) goto L17;
        if (r101 == null) goto L17;
        if (r101.size() != 1) goto L17;
        if (r100 == ListSelectPanelAction.SHARE) goto L12;
        return false;
    L12:
        if (r102.f472214a == false) goto L14;
        boolean r103 = true;
    L15:
        B0(this.f228569c, -1, (Document) ListProtector.get(r101, 0), r103);
        return true;
    L14:
        r103 = false;
    L17:
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void P(View r210, int r211, Document r212) {
        super.P(r210, r211, r212);
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

    public i3(Context r100, View r101, LifeCycleFragment r102, ce5.a r103) {
        super(r100, r101, r102, r103);
        ed5.a r104 = new ed5.a();
        this.N = r104;
        this.O = new ed5.b(r104);
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
        tt5.a.h(i2(), "onRightSlideMenuClick()...position = " + r211);
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
