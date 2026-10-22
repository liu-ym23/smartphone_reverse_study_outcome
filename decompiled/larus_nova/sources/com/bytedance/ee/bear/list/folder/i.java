package com.bytedance.ee.bear.list.folder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.document.restore.DocDeletedCtrlView;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.bytedance.ee.bear.facade.common.widget.s;
import com.bytedance.ee.bear.facade.common.widget.t;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.create.x0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.homepage.HomeCoordinatorLayout;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadFailCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.more.more3.m;
import com.bytedance.ee.bear.list.sort.SortFragment;
import com.bytedance.ee.bear.list.sort.SortScene;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.x4;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.cert.manager.constants.EventConstant;
import dd5.d1;
import dd5.g1;
import dd5.s1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lc5.p;
import lc5.r;
import org.json.JSONObject;
import uc5.a5;
import uc5.b5;
import uc5.c5;
import uc5.d5;
import uc5.e5;
import uc5.y4;
import uc5.z4;

/* JADX INFO: loaded from: classes18.dex */
public final class i extends com.bytedance.ee.bear.list.list.c<e.a> implements e, g1, wc5.f.a {
    public final ed5.a E;
    public final ed5.b F;
    public HomeMainTitleBar G;
    public SubMenuView H;
    public View I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ForbiddenBannerView f228112J;
    public CommonCreateButton K;
    public x0 L;
    public final String M;
    public final String N;
    public String O;
    public boolean P;
    public boolean Q;
    public final String R;
    public final String S;
    public final int T;
    public yc5.b U;
    public Document V;
    public ShareFolderUserPermission W;
    public com.bytedance.ee.bear.b X;

    public class a implements LoadStateView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f228113a;

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void c() {
        }

        public a(i r100) {
            this.f228113a = r100;
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void b(View r100) {
            i.B3(this.f228113a, r100, true);
        }
    }

    public class b implements com.bytedance.ee.bear.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f228114a;

        @Override // com.bytedance.ee.bear.b.a
        public final void a() {
            this.f228114a.X.hide();
            ((e.a) this.f228114a.f228571e).onRefresh();
        }

        public b(i r100) {
            this.f228114a = r100;
        }
    }

    @Override // wc5.f.a
    public final void eF() {
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "SubFolderView";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final com.bytedance.ee.bear.list.list.d n1() {
        this.f228583q = null;
        com.bytedance.ee.bear.list.list.d r100 = d1.a(S1(), this.f228572f, this.f228570d, this.D);
        if (r100 != null) goto L5;
        this.F.d(null);
        if (this.f228572f == false) goto L13;
        com.bytedance.ee.bear.list.list.d r101 = new FolderDetailGridStyleAdapter(S1(), this.P, this.D);
    L14:
        U2(r101);
        s2(r101);
        return r101;
    L13:
        r101 = new FolderDetailListStyleAdapter(S1(), this.f228592z, this.f228582p, this.P, this.D);
        goto L14
    L5:
        if ((r100 instanceof ed5.c) == false) goto L7;
        this.F.d((ed5.c) r100);
    L8:
        U2(r100);
        s2(r100);
        return r100;
    L7:
        this.F.d(null);
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String y1() {
        return FileInfoPuller.CALLER_EXPLORER;
    }

    public final void F3() {
        LifeCycleFragment r100 = this.f228570d;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100.getParentFragment() instanceof ed5.f) == false) goto L9;
        ((ed5.f) this.f228570d.getParentFragment()).It(this.E);
        return;
    }

    public final boolean I3() {
        if (this.Q == false) goto L5;
        return true;
    L5:
        PermissionRequest r100 = new PermissionRequest(new BaseEntity("", sbb.e.f541295f, BizDomain.FileBizDomainCCM, ""), "CREATE_SUB_NODE");
        UserPermissionEntity r101 = new UserPermissionEntity(this.W, null);
        if (D2() == true) goto L8;
    L12:
        return false;
    L8:
        if (this.W == null) goto L12;
        if (((ph5.b) org.koin.java.a.a(ph5.b.class)).f(r100, r101).getAllow() == false) goto L12;
        return true;
    }

    public final void M3() {
        HomeMainTitleBar r100 = this.G;
        String r101 = this.O;
        boolean r102 = this.P;
        int r103 = x4.f229847a;
        boolean r104 = x4.a(this.f228588v);
        int r105 = SpaceTagType.f240339e;
        SpaceTagType[] r106 = {SpaceTagType.Companion.f(r101, r102, r104)};
        SpaceTagTitleView r107 = r100.f228352d;
        if (r107 == null) goto L6;
        r107.setLabels(r106);
        return;
    }

    public final void N3() {
        if (this.K != null) goto L5;
        return;
    L5:
        if (this.G == null) goto L10;
        qc5.a.k();
        this.K.setEnabled(I3());
        return;
    }

    @Override // dd5.g1
    public final void Q2() {
        tt5.a.h("SubFolderView", "onCreatePersonalFolder()...");
        d2(null);
    }

    @Override // wc5.f.a
    public final void Qi() {
        tt5.a.h("SubFolderView", "onClickSortMenu()...");
        if (D2() == false) goto L16;
        String r100 = S1();
        int r101 = sbb.e.f541294e.f541317b;
        String r110 = this.M;
        boolean r111 = !TextUtils.isEmpty(r110);
        int r112 = this.T;
        Boolean r113 = Boolean.valueOf(C2());
        if (C2() == false) goto L7;
        String r102 = "middle";
    L8:
        lc5.f.f508440a.I(new p("ccm_space_folder_click", r100, "none", "filter", "ccm_space_header_filter_view", "", r101, "", r110, false, false, r111, r112, r113, r102, null));
        Bundle r103 = new Bundle();
        r103.putString("key_token", this.M);
        r103.putParcelable("key_sort_strategy", this.f228573g);
        if (ForsetiHelper.s(this.f228570d) == false) goto L15;
        SubMenuView r104 = this.H;
        if (r104 == null) goto L15;
        if (r104.getSortView() == null) goto L15;
        ActionSheetDialogFragment.ca0(this.f228570d.getActivity(), SortFragment.class, r103, this.H.getSortView());
        return;
    L15:
        ActionSheetDialogFragment.ba0(this.f228570d.getActivity(), SortFragment.class, r103);
        return;
    L7:
        r102 = "suspend_create";
        goto L8
    L16:
        Context r105 = this.f228568b;
        Toast.showFailureText(r105, r105.getString(R.string.Doc_Facade_Offline), 0);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String S1() {
        if (this.Q == false) goto L6;
        return "personal_subfolder";
    L6:
        return "shared_subfolder";
    }

    @Override // com.bytedance.ee.bear.list.folder.e
    public final void Z0() {
        if (this.X == null) goto L5;
    L7:
        com.bytedance.ee.bear.b r100 = this.X;
        if (r100 == null) goto L11;
        r100.show();
        return;
    L11:
        return;
    L5:
        if ((this.f228569c instanceof ViewGroup) == false) goto L7;
        DocDeletedCtrlView r101 = ((com.bytedance.ee.bear.c) org.koin.java.a.a(com.bytedance.ee.bear.c.class)).a(this.f228568b);
        t45.c r102 = s45.p.a();
        sbb.e r103 = sbb.e.f541295f;
        String r104 = r102.A9(r103.getType(), this.M);
        LifeCycleFragment r105 = this.f228570d;
        r101.b(r105, r105.getViewLifecycleOwner(), r104);
        r101.setDelegate(new b(this));
        lc5.g r106 = new lc5.g(new JSONObject(), S1(), "none", this.M, r103.f541317b, "", "", DocumentType.FOLDER_NAME, "");
        lc5.f.a r107 = lc5.f.f508440a;
        r101.setReportCommonParams(lc5.f.a.h(r106));
        r101.a((ViewGroup) this.f228569c, null);
        this.X = r101;
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.folder.e
    public final void j() {
        if (this.E.f472208a == true) goto L5;
        return;
    L5:
        this.F.c();
        F3();
    }

    @Override // com.bytedance.ee.bear.list.folder.e
    public final boolean x() {
        return this.E.f472208a;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        this.f228577k = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.f228569c.findViewById(R.id.list_state_view_root));
        if (I3() == false) goto L5;
        this.f228577k.a(EmptyCategory.FOLDER_NORMAL);
    L7:
        if (fw4.d.b(this.f228568b) != NetworkType.NETWORK_NO) goto L9;
        this.f228577k.h(LoadFailCategory.NO_NETWORK);
    L9:
        this.f228577k.e(new z4(this));
        this.f228577k.d(new a(this));
        return;
    L5:
        this.f228577k.a(EmptyCategory.FOLDER_READONLY);
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void B2() {
        super.B2();
        this.f228576j = (cqa.h) this.f228569c.findViewById(R.id.list_refresh_layout);
        if (uc5.d1.b(this.f228570d) == true) goto L5;
    L7:
        wa5.a r100 = (wa5.a) this.f228576j.getRefreshHeader();
        DigitDanceHeader r101 = (DigitDanceHeader) this.f228569c.findViewById(R.id.list_appbar_refresh_header);
        if (r100 == null) goto L10;
        r100.setAssociatedHeader(r101);
    L10:
        z2();
        this.I = this.f228569c.findViewById(R.id.no_net_container);
        ce5.a r102 = this.D;
        if (r102 != null) goto L13;
    L15:
        this.f228112J = (ForbiddenBannerView) this.f228569c.findViewById(R.id.list_folder_forbidden);
    L16:
        this.f228112J.setViewDelegate((ForbiddenBannerView.a) this.f228571e);
        tt5.a.h("SubFolderView", "initTitleBar()...");
        HomeCoordinatorLayout r103 = (HomeCoordinatorLayout) this.f228569c.findViewById(R.id.list_home_coordinator_layout);
        this.G = (HomeMainTitleBar) this.f228569c.findViewById(R.id.list_folder_title_bar);
        if (uc5.d1.b(this.f228570d) == false) goto L21;
        tt5.a.h("SubFolderView", "initTitleBar()...hide native title bar in Office scene.");
        HomeMainTitleBar r104 = this.G;
        if (r104 == null) goto L25;
        r104.setVisibility(8);
    L25:
        this.H = (SubMenuView) this.f228569c.findViewById(R.id.home_sub_title_view);
        if (uc5.d1.b(this.f228570d) == false) goto L39;
        tt5.a.h("SubFolderView", "initSubMenuView()...hide native appbar in Office scene.");
        View r105 = this.f228569c.findViewById(R.id.list_appbar_refresh_header);
        if (r105 == null) goto L30;
        r105.setVisibility(8);
    L30:
        View r106 = this.f228569c.findViewById(R.id.list_sub_menu_layout);
        if (r106 == null) goto L36;
        r106.setVisibility(8);
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L36;
        r107.height = 0;
        r106.setLayoutParams(r107);
    L36:
        SubMenuView r108 = this.H;
        if (r108 == null) goto L40;
        r108.setVisibility(8);
    L40:
        this.K = (CommonCreateButton) this.f228569c.findViewById(R.id.common_create_button);
        if (uc5.d1.b(this.f228570d) == false) goto L45;
        tt5.a.h("SubFolderView", "initCreateBtn()...hide native create button in Office scene.");
        CommonCreateButton r109 = this.K;
        if (r109 == null) goto L49;
        r109.setVisibility(8);
    L49:
        this.U = new yc5.b(this.f228568b, this.f228569c, new a5(this));
        return;
    L45:
        this.K.setOnClickListener(new b5(this));
        N3();
        if (this.f228570d.getActivity() != null) goto L48;
        tt5.a.d("SubFolderView", "observeCreatePopupMenu()...activity is null");
        goto L49
    L48:
        ((SelectCreationMenuViewModel) ViewModelProviders.of(this.f228570d.getActivity()).get(SelectCreationMenuViewModel.class)).getSelectedCreationTypeLiveData().observe(this.f228570d, new y4(this));
        goto L49
    L39:
        this.H.c();
        this.H.setViewDelegate(this);
        this.H.b(this.f228572f);
        goto L40
    L21:
        r103.setMainTitle(this.G);
        this.G.h();
        this.G.setOnMoreViewClickListener(new c5(this));
        this.G.setTitle(this.N);
        this.G.setOnSearchBtnClickListener(new d5(this));
        this.G.setOnCreateViewClickListener(new e5(this));
        HashMap r110 = new HashMap();
        r110.put(EventConstant.Key.MODULE, S1());
        BaseTitleBar r111 = this.G.getTitleBar();
        if (r111 == null) goto L24;
        r111.setTag(R.id.title_bar_common_params, r110);
    L24:
        this.G.setLeftExtraClickListener(this.f228570d);
        goto L25
    L13:
        if (r102.f23449d.isEnable("ccm.platform.appeal_v2") == false) goto L15;
        this.f228112J = (ForbiddenBannerView) this.f228569c.findViewById(R.id.list_folder_new_forbidden);
        goto L16
    L5:
        if (this.f228576j == null) goto L7;
        tt5.a.h("SubFolderView", "initView()...disable inner refresh layout in Office scene.");
        this.f228576j.j(false);
        this.f228576j.g(false);
        goto L7
    }

    public final void O3() {
        N3();
        if (I3() == false) goto L6;
        this.f228577k.f(EmptyCategory.FOLDER_NORMAL);
    L6:
        if (fw4.d.b(this.f228568b) != NetworkType.NETWORK_NO) goto L13;
        com.bytedance.ee.bear.list.list.d r100 = this.f228583q;
        if (r100 != null) goto L10;
        return;
    L10:
        if (r100.getData().size() != 0) goto L15;
        this.f228577k.h(LoadFailCategory.NO_NETWORK);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        yc5.b r100 = this.U;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, pc5.i.c
    public final void j0() {
        super.j0();
        d2(null);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        return this.M;
    }

    public Context getContext() {
        return this.f228568b;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String v1() {
        return this.M;
    }

    @Override // com.bytedance.ee.bear.list.folder.e
    public final void F7(ShareFolderUserPermission r100) {
        this.W = r100;
        O3();
    }

    public final void J3(SmartRefreshLayout r100) {
        StringBuilder r101 = new StringBuilder("setRefreshLayout()...hasRefreshLayout = ");
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        tt5.a.h("SubFolderView", r101.toString());
        this.f228576j = r100;
        z2();
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, dd5.p1
    public final void Mj(boolean r100) {
        super.Mj(r100);
        this.H.b(r100);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void P2(FolderSortStrategy r100) {
        super.P2(r100);
        if (this.H != null) goto L5;
        return;
    L5:
        if (uc5.d1.b(this.f228570d) == true) goto L9;
        this.H.a(zd5.c.b(SortScene.FolderSort, r100.f227684e, r100.f227685f));
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void W3(int r100) {
        v3(r100);
        M3();
    }

    @Override // wc5.f.a
    public final void WU(boolean r110) {
        tt5.a.h("SubFolderView", "onClickGridMenu()...showGrid = " + r110);
        s1.a.f468004a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r110, S1());
        String r100 = S1();
        String r101 = this.M;
        lc5.f.f508440a.O(new r("ccm_space_folder_click", r100, "none", r101, sbb.e.f541295f.f541317b, true, !this.Q, !TextUtils.isEmpty(r101), this.T, this.M));
    }

    @Override // com.bytedance.ee.bear.list.folder.e
    public final void f0(ForbiddenBannerView.ForbiddenState r100) {
        ce5.a r101 = this.D;
        if (r101 != null) goto L5;
    L7:
        this.f228112J.o6(r100, new s(this.f228568b));
        return;
    L5:
        if (r101.f23449d.isEnable("ccm.platform.appeal_v2") == false) goto L7;
        t r102 = new t(this.f228568b);
        r102.f226720h = R.string.LarkCCM_Security_FolderShareSuspend_UserAgreeMent_Banner;
        this.f228112J.o6(r100, r102);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void h1(ConnectionService.NetworkState r100) {
        super.h1(r100);
        N3();
        this.G.setMoreViewEnable(D2());
        View r101 = this.I;
        if (r100.a() == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        this.H.setOffline(!r100.a());
        if (D2() == true) goto L9;
        this.f228112J.setVisibility(8);
    L9:
        yc5.b r103 = this.U;
        if (r103 == null) goto L13;
        r103.c(r100);
        return;
    L13:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final int j2(ArrayList<Document> r100) {
        if (TextUtils.isEmpty(this.M) == true) goto L5;
        int r101 = 0;
        if (r100 == null) goto L15;
        Iterator<Document> r102 = r100.iterator();
    L11:
        if (r102.hasNext() == false) goto L15;
        if (r102.next().getType() == sbb.e.f541295f.f541317b) goto L11;
        r101 = r101 + 1;
    L15:
        return r101;
    L5:
        return hu5.a.c(r100);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void j3(Throwable r100) {
        tt5.a.h("SubFolderView", "showLoadFail()...throwable = " + r100);
        if (ax4.d.b(r100, 3) == false) goto L6;
        this.f228577k.h(LoadFailCategory.FOLDER_NOT_FOUND);
    L13:
        M3();
        return;
    L6:
        if (fw4.d.b(this.f228568b) != NetworkType.NETWORK_NO) goto L12;
        com.bytedance.ee.bear.list.list.d r101 = this.f228583q;
        if (r101 == null) goto L12;
        if (r101.getData().size() <= 0) goto L12;
        return;
    L12:
        this.f228577k.b(r100);
        goto L13
    }

    @Override // com.bytedance.ee.bear.list.list.c, pc5.i.c
    public final void k(rf5.d r100) {
        ((e.a) this.f228571e).k(r100);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void l0(ArrayList<Document> r100) {
        super.l0(r100);
        boolean r101 = this.E.f472208a;
        if (r101 == false) goto L7;
        if (r101 == false) goto L10;
        this.F.e(r100);
        F3();
        return;
    L10:
        return;
    L7:
        F3();
    }

    @Override // com.bytedance.ee.bear.list.folder.e
    public final void u(Document r100) {
        if (this.V != null) goto L5;
        boolean r101 = true;
    L6:
        this.V = r100;
        if (r100 == null) goto L15;
        this.P = r100.f227904x;
        this.O = r100.E2;
        this.Q = FolderVersion.isPersonalFolder(r100.L1, r100.P1);
        com.bytedance.ee.bear.list.list.d r102 = this.f228583q;
        if ((r102 instanceof FolderDetailListStyleAdapter) == false) goto L11;
        ((FolderDetailListStyleAdapter) r102).f227968p = this.P;
        r102.notifyDataSetChanged();
    L11:
        com.bytedance.ee.bear.list.list.d r103 = this.f228583q;
        if ((r103 instanceof FolderDetailGridStyleAdapter) == false) goto L14;
        ((FolderDetailGridStyleAdapter) r103).f227960i = this.P;
        r103.notifyDataSetChanged();
    L14:
        this.G.setTitle(t0.g(this.f228568b, r100));
        M3();
        O3();
    L15:
        if (r101 == true) goto L17;
        return;
    L17:
        if (TextUtils.isEmpty(this.M) == false) goto L19;
        lc5.f.q((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1());
    L20:
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1());
        Document r104 = this.V;
        String r105 = "0";
        if (r104 != null) goto L23;
    L25:
        String r106 = "0";
    L26:
        Document r107 = this.V;
        if (r107 != null) goto L29;
    L31:
        lc5.f.p(S1(), "none", this.M, !this.Q, r106, r105);
        return;
    L29:
        if (TextUtils.isEmpty(r107.f227875f) == true) goto L31;
        r105 = this.V.f227875f;
        goto L31
    L23:
        if (TextUtils.isEmpty(r104.f227875f) == true) goto L25;
        r106 = this.V.f227874e;
        goto L26
    L19:
        com.bytedance.ee.bear.contract.d r108 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        String r109 = S1();
        String r110 = this.R;
        String r111 = this.S;
        lc5.f.a r112 = lc5.f.f508440a;
        lc5.f.a.T(r108, r109, null, r110, r111);
        goto L20
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r100, List<Document> r101) {
        return new FolderDetailItemDiffCallback(r100, r101);
    }

    public static void B3(i r210, View r211, boolean r212) {
        r210.getClass();
        tt5.a.h("SubFolderView", "onMenuCreateClick()...");
        FragmentActivity r100 = r210.f228570d.getActivity();
        if (r210.L != null) goto L6;
        r210.L = new x0();
    L6:
        if (r210.L.a(r100) == false) goto L8;
        tt5.a.h("SubFolderView", "create menu is already showing");
        return;
    L8:
        iw4.h r101 = new iw4.h();
        r101.f496216i = r211;
        r101.f496209b = r210.S1();
        r101.f496211d = r210.R;
        String r102 = r210.M;
        r101.f496208a = r102;
        r101.f496212e = !TextUtils.isEmpty(r102);
        r101.f496213f = r212;
        r101.f496214g = true;
        if (r210.L != null) goto L11;
        r210.L = new x0();
    L11:
        x0 r103 = r210.L;
        SelectCreationMenuConfig r104 = new SelectCreationMenuConfig();
        r104.f216818n = ((ww4.a) org.koin.java.a.a(ww4.a.class)).a().d().f217118a;
        r104.f216816l = t0.s();
        r104.f216819o = true;
        com.bytedance.ee.bear.appsetting.c r105 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        r104.f216821q = r105.i("ccm.bitable.ccmspace.hassurvey.enable", false);
        r104.f216820p = r105.f("spacekit.mobile.docx_create_enable");
        r104.f216815k = true;
        r104.f216808d = r210.D2();
        r104.f216805a = r210.I3();
        r104.f216806b = r210.I3();
        r104.f216809e = r210.I3();
        r104.f216811g = r210.I3();
        r104.f216810f = r210.I3();
        r103.c(r100, r101, r104, null);
        String r106 = r210.S1();
        String r107 = r210.M;
        int r110 = sbb.e.f541295f.f541317b;
        boolean r111 = !r210.Q;
        boolean r112 = !TextUtils.isEmpty(r107);
        int r108 = r210.T;
        Boolean r213 = Boolean.valueOf(r210.C2());
        if (r210.C2() == false) goto L14;
        String r109 = "middle";
    L15:
        lc5.f.f508440a.I(new p("ccm_space_folder_click", r106, "none", "create", "ccm_space_create_new_view", r107, r110, "", r107, true, r111, r112, r108, r213, r109, null));
        return;
    L14:
        r109 = "suspend_create";
        goto L15
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r210, int r211, Document r212, boolean r213) {
        super.Y(r210, r211, r212, r213);
        String r100 = S1();
        String r101 = r212.f227873d;
        int r102 = r212.getType();
        String r103 = r212.F;
        String r110 = this.M;
        if (r212.getType() != sbb.e.f541295f.f541317b) goto L5;
        boolean r111 = true;
    L6:
        boolean r112 = FolderVersion.isShareFolder(r212.L1, r212.P1);
        boolean r113 = true ^ TextUtils.isEmpty(this.M);
        int r114 = this.T;
        Boolean r115 = Boolean.valueOf(C2());
        if (C2() == false) goto L9;
        String r116 = "middle";
    L10:
        p r117 = new p("ccm_space_folder_click", r100, "none", "more", "ccm_space_right_click_menu_view", r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, t0.m(r212));
        lc5.f.f508440a.I(r117);
        return;
    L9:
        r116 = "suspend_create";
        goto L10
    L5:
        r111 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void f3(Document r110, boolean r111, int r112, View r113) {
        com.bytedance.ee.bear.list.more.more3.t.e(new m(this.f228570d, r110, this.f228588v, S1(), "none", r111, this.f228571e, "SubFolderView", this.M, this.W, Boolean.valueOf(!this.Q), r112), this.D, r113);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r210, int r211, Document r212, boolean r213) {
        super.x0(r210, r211, r212, r213);
        String r100 = S1();
        String r101 = r212.f227873d;
        int r102 = r212.getType();
        String r103 = r212.F;
        String r110 = this.M;
        if (r212.getType() != sbb.e.f541295f.f541317b) goto L5;
        boolean r111 = true;
    L6:
        boolean r112 = FolderVersion.isShareFolder(r212.L1, r212.P1);
        boolean r113 = true ^ TextUtils.isEmpty(this.M);
        int r114 = this.T;
        Boolean r115 = Boolean.valueOf(C2());
        if (C2() == false) goto L9;
        String r116 = "middle";
    L10:
        p r117 = new p("ccm_space_folder_click", r100, "none", "delete", "ccm_space_delete_view", r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, t0.m(r212));
        lc5.f.f508440a.I(r117);
        return;
    L9:
        r116 = "suspend_create";
        goto L10
    L5:
        r111 = false;
        goto L6
    }

    public i(Context r100, View r101, LifeCycleFragment r102, String r103, String r104, boolean r105, boolean r106, String r107, String r108, int r110, ce5.a r111) {
        super(r100, r101, r102, r111);
        ed5.a r109 = new ed5.a();
        this.E = r109;
        this.F = new ed5.b(r109);
        this.M = r103;
        this.N = r104;
        this.P = r105;
        this.Q = r106;
        this.R = r107;
        this.S = r108;
        this.T = r110;
    }
}
