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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends com.bytedance.ee.bear.list.list.c<e.a> implements e, g1, wc5.f.a {
    public final ed5.a E;
    public final ed5.b F;
    public HomeMainTitleBar G;
    public SubMenuView H;
    public View I;
    public ForbiddenBannerView J;
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
        public final /* synthetic */ i a;

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void c() {
        }

        public a(i r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void b(View r3) {
            i.B3(this.a, r3, true);
        }
    }

    public class b implements com.bytedance.ee.bear.b.a {
        public final /* synthetic */ i a;

        public final void a() {
            this.a.X.hide();
            ((e.a) this.a.e).onRefresh();
        }

        public b(i r1) {
            this.a = r1;
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
        this.q = null;
        com.bytedance.ee.bear.list.list.d r1 = d1.a(S1(), this.f, this.d, this.D);
        if (r1 != null) goto L5;
        this.F.d(null);
        if (this.f == false) goto L13;
        com.bytedance.ee.bear.list.list.d r0 = new FolderDetailGridStyleAdapter(S1(), this.P, this.D);
    L14:
        U2(r0);
        s2(r0);
        return r0;
    L13:
        r0 = new FolderDetailListStyleAdapter(S1(), this.z, this.p, this.P, this.D);
        goto L14
    L5:
        if ((r1 instanceof ed5.c) == false) goto L7;
        this.F.d((ed5.c) r1);
    L8:
        U2(r1);
        s2(r1);
        return r1;
    L7:
        this.F.d(null);
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String y1() {
        return "explorer";
    }

    public final void F3() {
        LifeCycleFragment r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0.getParentFragment() instanceof ed5.f) == false) goto L9;
        this.d.getParentFragment().It(this.E);
        return;
    }

    public final boolean I3() {
        if (this.Q == false) goto L5;
        return true;
    L5:
        PermissionRequest r0 = new PermissionRequest(new BaseEntity("", sbb.e.f, BizDomain.FileBizDomainCCM, ""), "CREATE_SUB_NODE");
        UserPermissionEntity r2 = new UserPermissionEntity(this.W, null);
        if (D2() == true) goto L8;
    L12:
        return false;
    L8:
        if (this.W == null) goto L12;
        if (((ph5.b) org.koin.java.a.a(ph5.b.class)).f(r0, r2).getAllow() == false) goto L12;
        return true;
    }

    public final void M3() {
        HomeMainTitleBar r0 = this.G;
        String r2 = this.O;
        boolean r3 = this.P;
        int r4 = x4.a;
        boolean r5 = x4.a(this.v);
        int r6 = SpaceTagType.e;
        SpaceTagType[] r1 = {SpaceTagType.Companion.f(r2, r3, r5)};
        SpaceTagTitleView r7 = r0.d;
        if (r7 == null) goto L6;
        r7.setLabels(r1);
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
        String r4 = S1();
        int r9 = sbb.e.e.b;
        String r11 = this.M;
        boolean r14 = !TextUtils.isEmpty(r11);
        int r15 = this.T;
        Boolean r16 = Boolean.valueOf(C2());
        if (C2() == false) goto L7;
        String r2 = "middle";
    L8:
        lc5.f.a.I(new p("ccm_space_folder_click", r4, "none", "filter", "ccm_space_header_filter_view", "", r9, "", r11, false, false, r14, r15, r16, r2, null));
        Bundle r1 = new Bundle();
        r1.putString("key_token", this.M);
        r1.putParcelable("key_sort_strategy", this.g);
        if (ForsetiHelper.s(this.d) == false) goto L15;
        SubMenuView r3 = this.H;
        if (r3 == null) goto L15;
        if (r3.getSortView() == null) goto L15;
        ActionSheetDialogFragment.ca0(this.d.getActivity(), SortFragment.class, r1, this.H.getSortView());
        return;
    L15:
        ActionSheetDialogFragment.ba0(this.d.getActivity(), SortFragment.class, r1);
        return;
    L7:
        r2 = "suspend_create";
        goto L8
    L16:
        Context r5 = this.b;
        Toast.showFailureText(r5, r5.getString(2131887789), 0);
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
        com.bytedance.ee.bear.b r0 = this.X;
        if (r0 == null) goto L11;
        r0.show();
        return;
    L11:
        return;
    L5:
        if ((this.c instanceof ViewGroup) == false) goto L7;
        DocDeletedCtrlView r1 = ((com.bytedance.ee.bear.c) org.koin.java.a.a(com.bytedance.ee.bear.c.class)).a(this.b);
        t45.c r2 = s45.p.a();
        sbb.e r3 = sbb.e.f;
        String r4 = r2.A9(r3.getType(), this.M);
        LifeCycleFragment r5 = this.d;
        r1.b(r5, r5.getViewLifecycleOwner(), r4);
        r1.setDelegate(new b(this));
        lc5.g r6 = new lc5.g(new JSONObject(), S1(), "none", this.M, r3.b, "", "", DocumentType.FOLDER_NAME, "");
        lc5.f.a r7 = lc5.f.a;
        r1.setReportCommonParams(lc5.f.a.h(r6));
        r1.a((ViewGroup) this.c, null);
        this.X = r1;
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.folder.e
    public final void j() {
        if (this.E.a == true) goto L5;
        return;
    L5:
        this.F.c();
        F3();
    }

    @Override // com.bytedance.ee.bear.list.folder.e
    public final boolean x() {
        return this.E.a;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        this.k = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378179));
        if (I3() == false) goto L5;
        this.k.a(EmptyCategory.FOLDER_NORMAL);
    L7:
        if (fw4.d.b(this.b) != NetworkType.NETWORK_NO) goto L9;
        this.k.h(LoadFailCategory.NO_NETWORK);
    L9:
        this.k.e(new z4(this));
        this.k.d(new a(this));
        return;
    L5:
        this.k.a(EmptyCategory.FOLDER_READONLY);
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void B2() {
        super.B2();
        this.j = this.c.findViewById(2131378171);
        if (uc5.d1.b(this.d) == true) goto L5;
    L7:
        wa5.a r0 = this.j.getRefreshHeader();
        DigitDanceHeader r3 = this.c.findViewById(2131378060);
        if (r0 == null) goto L10;
        r0.setAssociatedHeader(r3);
    L10:
        z2();
        this.I = this.c.findViewById(2131380933);
        ce5.a r1 = this.D;
        if (r1 != null) goto L13;
    L15:
        this.J = this.c.findViewById(2131378097);
    L16:
        this.J.setViewDelegate(this.e);
        tt5.a.h("SubFolderView", "initTitleBar()...");
        HomeCoordinatorLayout r2 = (HomeCoordinatorLayout) this.c.findViewById(2131378119);
        this.G = (HomeMainTitleBar) this.c.findViewById(2131378104);
        if (uc5.d1.b(this.d) == false) goto L21;
        tt5.a.h("SubFolderView", "initTitleBar()...hide native title bar in Office scene.");
        HomeMainTitleBar r4 = this.G;
        if (r4 == null) goto L25;
        r4.setVisibility(8);
    L25:
        this.H = (SubMenuView) this.c.findViewById(2131374462);
        if (uc5.d1.b(this.d) == false) goto L39;
        tt5.a.h("SubFolderView", "initSubMenuView()...hide native appbar in Office scene.");
        View r5 = this.c.findViewById(2131378060);
        if (r5 == null) goto L30;
        r5.setVisibility(8);
    L30:
        View r6 = this.c.findViewById(2131378183);
        if (r6 == null) goto L36;
        r6.setVisibility(8);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L36;
        r7.height = 0;
        r6.setLayoutParams(r7);
    L36:
        SubMenuView r8 = this.H;
        if (r8 == null) goto L40;
        r8.setVisibility(8);
    L40:
        this.K = (CommonCreateButton) this.c.findViewById(2131367552);
        if (uc5.d1.b(this.d) == false) goto L45;
        tt5.a.h("SubFolderView", "initCreateBtn()...hide native create button in Office scene.");
        CommonCreateButton r9 = this.K;
        if (r9 == null) goto L49;
        r9.setVisibility(8);
    L49:
        this.U = new yc5.b(this.b, this.c, new a5(this));
        return;
    L45:
        this.K.setOnClickListener(new b5(this));
        N3();
        if (this.d.getActivity() != null) goto L48;
        tt5.a.d("SubFolderView", "observeCreatePopupMenu()...activity is null");
        goto L49
    L48:
        ViewModelProviders.of(this.d.getActivity()).get(SelectCreationMenuViewModel.class).getSelectedCreationTypeLiveData().observe(this.d, new y4(this));
        goto L49
    L39:
        this.H.c();
        this.H.setViewDelegate(this);
        this.H.b(this.f);
        goto L40
    L21:
        r2.setMainTitle(this.G);
        this.G.h();
        this.G.setOnMoreViewClickListener(new c5(this));
        this.G.setTitle(this.N);
        this.G.setOnSearchBtnClickListener(new d5(this));
        this.G.setOnCreateViewClickListener(new e5(this));
        HashMap r10 = new HashMap();
        r10.put("module", S1());
        BaseTitleBar r11 = this.G.getTitleBar();
        if (r11 == null) goto L24;
        r11.setTag(2131388811, r10);
    L24:
        this.G.setLeftExtraClickListener(this.d);
        goto L25
    L13:
        if (r1.d.isEnable("ccm.platform.appeal_v2") == false) goto L15;
        this.J = this.c.findViewById(2131378100);
        goto L16
    L5:
        if (this.j == null) goto L7;
        tt5.a.h("SubFolderView", "initView()...disable inner refresh layout in Office scene.");
        this.j.j(false);
        this.j.g(false);
        goto L7
    }

    public final void O3() {
        N3();
        if (I3() == false) goto L6;
        this.k.f(EmptyCategory.FOLDER_NORMAL);
    L6:
        if (fw4.d.b(this.b) != NetworkType.NETWORK_NO) goto L13;
        com.bytedance.ee.bear.list.list.d r0 = this.q;
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.getData().size() != 0) goto L15;
        this.k.h(LoadFailCategory.NO_NETWORK);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void destroy() {
        super.destroy();
        yc5.b r0 = this.U;
        if (r0 == null) goto L6;
        r0.b();
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
        return this.b;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String v1() {
        return this.M;
    }

    @Override // com.bytedance.ee.bear.list.folder.e
    public final void F7(ShareFolderUserPermission r1) {
        this.W = r1;
        O3();
    }

    public final void J3(SmartRefreshLayout r3) {
        StringBuilder r0 = new StringBuilder("setRefreshLayout()...hasRefreshLayout = ");
        if (r3 == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        tt5.a.h("SubFolderView", r0.toString());
        this.j = r3;
        z2();
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, dd5.p1
    public final void Mj(boolean r2) {
        super.Mj(r2);
        this.H.b(r2);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void P2(FolderSortStrategy r4) {
        super.P2(r4);
        if (this.H != null) goto L5;
        return;
    L5:
        if (uc5.d1.b(this.d) == true) goto L9;
        this.H.a(zd5.c.b(SortScene.FolderSort, r4.e, r4.f));
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void W3(int r1) {
        v3(r1);
        M3();
    }

    @Override // wc5.f.a
    public final void WU(boolean r15) {
        tt5.a.h("SubFolderView", "onClickGridMenu()...showGrid = " + r15);
        s1.a.a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r15, S1());
        String r5 = S1();
        String r7 = this.M;
        lc5.f.a.O(new r("ccm_space_folder_click", r5, "none", r7, sbb.e.f.b, true, !this.Q, !TextUtils.isEmpty(r7), this.T, this.M));
    }

    @Override // com.bytedance.ee.bear.list.folder.e
    public final void f0(ForbiddenBannerView.ForbiddenState r4) {
        ce5.a r0 = this.D;
        if (r0 != null) goto L5;
    L7:
        this.J.o6(r4, new s(this.b));
        return;
    L5:
        if (r0.d.isEnable("ccm.platform.appeal_v2") == false) goto L7;
        t r1 = new t(this.b);
        r1.h = 2131889731;
        this.J.o6(r4, r1);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void h1(ConnectionService.NetworkState r4) {
        super.h1(r4);
        N3();
        this.G.setMoreViewEnable(D2());
        View r0 = this.I;
        if (r4.a() == false) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        this.H.setOffline(!r4.a());
        if (D2() == true) goto L9;
        this.J.setVisibility(8);
    L9:
        yc5.b r2 = this.U;
        if (r2 == null) goto L13;
        r2.c(r4);
        return;
    L13:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final int j2(ArrayList<Document> r4) {
        if (TextUtils.isEmpty(this.M) == true) goto L5;
        int r0 = 0;
        if (r4 == null) goto L15;
        Iterator<Document> r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L15;
        if (r5.next().getType() == sbb.e.f.b) goto L11;
        r0 = r0 + 1;
    L15:
        return r0;
    L5:
        return hu5.a.c(r4);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void j3(Throwable r3) {
        tt5.a.h("SubFolderView", "showLoadFail()...throwable = " + r3);
        if (ax4.d.b(r3, 3) == false) goto L6;
        this.k.h(LoadFailCategory.FOLDER_NOT_FOUND);
    L13:
        M3();
        return;
    L6:
        if (fw4.d.b(this.b) != NetworkType.NETWORK_NO) goto L12;
        com.bytedance.ee.bear.list.list.d r0 = this.q;
        if (r0 == null) goto L12;
        if (r0.getData().size() <= 0) goto L12;
        return;
    L12:
        this.k.b(r3);
        goto L13
    }

    @Override // com.bytedance.ee.bear.list.list.c, pc5.i.c
    public final void k(rf5.d r2) {
        ((e.a) this.e).k(r2);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void l0(ArrayList<Document> r2) {
        super.l0(r2);
        boolean r0 = this.E.a;
        if (r0 == false) goto L7;
        if (r0 == false) goto L10;
        this.F.e(r2);
        F3();
        return;
    L10:
        return;
    L7:
        F3();
    }

    @Override // com.bytedance.ee.bear.list.folder.e
    public final void u(Document r9) {
        if (this.V != null) goto L5;
        boolean r0 = true;
    L6:
        this.V = r9;
        if (r9 == null) goto L15;
        this.P = r9.x;
        this.O = r9.E2;
        this.Q = FolderVersion.isPersonalFolder(r9.L1, r9.P1);
        com.bytedance.ee.bear.list.list.d r2 = this.q;
        if ((r2 instanceof FolderDetailListStyleAdapter) == false) goto L11;
        ((FolderDetailListStyleAdapter) r2).p = this.P;
        r2.notifyDataSetChanged();
    L11:
        com.bytedance.ee.bear.list.list.d r3 = this.q;
        if ((r3 instanceof FolderDetailGridStyleAdapter) == false) goto L14;
        ((FolderDetailGridStyleAdapter) r3).i = this.P;
        r3.notifyDataSetChanged();
    L14:
        this.G.setTitle(t0.g(this.b, r9));
        M3();
        O3();
    L15:
        if (r0 == true) goto L17;
        return;
    L17:
        if (TextUtils.isEmpty(this.M) == false) goto L19;
        lc5.f.q((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1());
    L20:
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1());
        Document r10 = this.V;
        String r1 = "0";
        if (r10 != null) goto L23;
    L25:
        String r6 = "0";
    L26:
        Document r11 = this.V;
        if (r11 != null) goto L29;
    L31:
        lc5.f.p(S1(), "none", this.M, !this.Q, r6, r1);
        return;
    L29:
        if (TextUtils.isEmpty(r11.f) == true) goto L31;
        r1 = this.V.f;
        goto L31
    L23:
        if (TextUtils.isEmpty(r10.f) == true) goto L25;
        r6 = this.V.e;
        goto L26
    L19:
        com.bytedance.ee.bear.contract.d r12 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        String r4 = S1();
        String r5 = this.R;
        String r7 = this.S;
        lc5.f.a r8 = lc5.f.a;
        lc5.f.a.T(r12, r4, null, r5, r7);
        goto L20
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
        return new FolderDetailItemDiffCallback(r2, r3);
    }

    public static void B3(i r24, View r25, boolean r26) {
        r24.getClass();
        tt5.a.h("SubFolderView", "onMenuCreateClick()...");
        FragmentActivity r1 = r24.d.getActivity();
        if (r24.L != null) goto L6;
        r24.L = new x0();
    L6:
        if (r24.L.a(r1) == false) goto L8;
        tt5.a.h("SubFolderView", "create menu is already showing");
        return;
    L8:
        iw4.h r2 = new iw4.h();
        r2.i = r25;
        r2.b = r24.S1();
        r2.d = r24.R;
        String r3 = r24.M;
        r2.a = r3;
        r2.e = !TextUtils.isEmpty(r3);
        r2.f = r26;
        r2.g = true;
        if (r24.L != null) goto L11;
        r24.L = new x0();
    L11:
        x0 r4 = r24.L;
        SelectCreationMenuConfig r5 = new SelectCreationMenuConfig();
        r5.n = ((ww4.a) org.koin.java.a.a(ww4.a.class)).a().d().a;
        r5.l = t0.s();
        r5.o = true;
        com.bytedance.ee.bear.appsetting.c r6 = com.bytedance.ee.bear.appsetting.c.a.a;
        r5.q = r6.i("ccm.bitable.ccmspace.hassurvey.enable", false);
        r5.p = r6.f("spacekit.mobile.docx_create_enable");
        r5.k = true;
        r5.d = r24.D2();
        r5.a = r24.I3();
        r5.b = r24.I3();
        r5.e = r24.I3();
        r5.g = r24.I3();
        r5.f = r24.I3();
        r4.c(r1, r2, r5, null);
        String r9 = r24.S1();
        String r7 = r24.M;
        int r14 = sbb.e.f.b;
        boolean r18 = !r24.Q;
        boolean r19 = !TextUtils.isEmpty(r7);
        int r8 = r24.T;
        Boolean r21 = Boolean.valueOf(r24.C2());
        if (r24.C2() == false) goto L14;
        String r0 = "middle";
    L15:
        lc5.f.a.I(new p("ccm_space_folder_click", r9, "none", "create", "ccm_space_create_new_view", r7, r14, "", r7, true, r18, r19, r8, r21, r0, null));
        return;
    L14:
        r0 = "suspend_create";
        goto L15
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r20, int r21, Document r22, boolean r23) {
        super.Y(r20, r21, r22, r23);
        String r3 = S1();
        String r7 = r22.d;
        int r8 = r22.getType();
        String r9 = r22.F;
        String r10 = this.M;
        if (r22.getType() != sbb.e.f.b) goto L5;
        boolean r11 = true;
    L6:
        boolean r12 = FolderVersion.isShareFolder(r22.L1, r22.P1);
        boolean r13 = true ^ TextUtils.isEmpty(this.M);
        int r14 = this.T;
        Boolean r16 = Boolean.valueOf(C2());
        if (C2() == false) goto L9;
        String r17 = "middle";
    L10:
        p r15 = new p("ccm_space_folder_click", r3, "none", "more", "ccm_space_right_click_menu_view", r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, t0.m(r22));
        lc5.f.a.I(r15);
        return;
    L9:
        r17 = "suspend_create";
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void f3(Document r16, boolean r17, int r18, View r19) {
        com.bytedance.ee.bear.list.more.more3.t.e(new m(this.d, r16, this.v, S1(), "none", r17, this.e, "SubFolderView", this.M, this.W, Boolean.valueOf(!this.Q), r18), this.D, r19);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r20, int r21, Document r22, boolean r23) {
        super.x0(r20, r21, r22, r23);
        String r3 = S1();
        String r7 = r22.d;
        int r8 = r22.getType();
        String r9 = r22.F;
        String r10 = this.M;
        if (r22.getType() != sbb.e.f.b) goto L5;
        boolean r11 = true;
    L6:
        boolean r12 = FolderVersion.isShareFolder(r22.L1, r22.P1);
        boolean r13 = true ^ TextUtils.isEmpty(this.M);
        int r14 = this.T;
        Boolean r16 = Boolean.valueOf(C2());
        if (C2() == false) goto L9;
        String r17 = "middle";
    L10:
        p r15 = new p("ccm_space_folder_click", r3, "none", "delete", "ccm_space_delete_view", r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, t0.m(r22));
        lc5.f.a.I(r15);
        return;
    L9:
        r17 = "suspend_create";
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    public i(Context r1, View r2, LifeCycleFragment r3, String r4, String r5, boolean r6, boolean r7, String r8, String r9, int r10, ce5.a r11) {
        super(r1, r2, r3, r11);
        ed5.a r12 = new ed5.a();
        this.E = r12;
        this.F = new ed5.b(r12);
        this.M = r4;
        this.N = r5;
        this.P = r6;
        this.Q = r7;
        this.R = r8;
        this.S = r9;
        this.T = r10;
    }
}
