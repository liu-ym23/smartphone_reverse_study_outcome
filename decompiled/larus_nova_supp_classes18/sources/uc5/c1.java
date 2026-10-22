package uc5;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.folder.FolderDetailGridStyleAdapter;
import com.bytedance.ee.bear.list.folder.FolderDetailItemDiffCallback;
import com.bytedance.ee.bear.list.folder.FolderDetailListStyleAdapter;
import com.bytedance.ee.bear.list.homepage.HomeCoordinatorLayout;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadFailCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.sort.SortFragment;
import com.bytedance.ee.bear.list.sort.SortScene;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c1 extends com.bytedance.ee.bear.list.list.c<f2.a> implements f2, dd5.g1, wc5.f.a {
    public final ed5.a E;
    public final ed5.b F;
    public HomeMainTitleBar G;
    public SubMenuView H;
    public View I;
    public ForbiddenBannerView J;
    public CommonCreateButton K;
    public yc5.b L;
    public com.bytedance.ee.bear.list.create.x0 M;
    public final String N;
    public final String O;
    public int P;
    public boolean Q;
    public boolean R;
    public final String S;
    public final String T;
    public final int U;
    public Document V;

    public class a implements LoadStateView.a {
        public final /* synthetic */ c1 a;

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void c() {
        }

        public final void d() {
            c1.B3(this.a, true);
        }

        public a(c1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void b(View r1) {
            d();
        }
    }

    @Override // wc5.f.a
    public final void eF() {
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "FolderDetailView";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final com.bytedance.ee.bear.list.list.d n1() {
        this.q = null;
        com.bytedance.ee.bear.list.list.d r1 = dd5.d1.a(S1(), this.f, this.d, this.D);
        if (r1 != null) goto L5;
        this.F.d(null);
        if (this.f == false) goto L13;
        FolderDetailGridStyleAdapter r0 = new FolderDetailGridStyleAdapter(S1(), this.Q, this.D);
        r0.h = this;
        com.bytedance.ee.bear.list.list.d r2 = r0;
    L14:
        U2(r2);
        s2(r2);
        return r2;
    L13:
        FolderDetailListStyleAdapter r3 = new FolderDetailListStyleAdapter(S1(), this.z, this.p, this.Q, this.D);
        r3.o = this;
        r2 = r3;
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
        if (this.R == false) goto L6;
        return true;
    L6:
        if (D2() == true) goto L8;
    L10:
        return false;
    L8:
        if (this.P != 2) goto L10;
        return true;
    }

    public final void M3() {
        HomeMainTitleBar r0 = this.G;
        boolean r1 = true;
        SpaceTagType[] r2 = new SpaceTagType[1];
        if (this.Q == false) goto L7;
        int r3 = com.bytedance.ee.bear.list.x4.a;
        if (com.bytedance.ee.bear.list.x4.a(this.v) == false) goto L7;
    L8:
        int r4 = SpaceTagType.e;
        r2[0] = SpaceTagType.Companion.c(r1);
        SpaceTagTitleView r5 = r0.d;
        if (r5 == null) goto L12;
        r5.setLabels(r2);
        return;
    L12:
        return;
    L7:
        r1 = false;
        goto L8
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
        tt5.a.h("FolderDetailView", "onCreatePersonalFolder()...");
        d2(null);
    }

    @Override // wc5.f.a
    public final void Qi() {
        tt5.a.h("FolderDetailView", "onClickSortMenu()...");
        if (D2() == false) goto L9;
        String r4 = S1();
        int r9 = sbb.e.e.b;
        String r11 = this.N;
        boolean r14 = !TextUtils.isEmpty(r11);
        int r15 = this.U;
        Boolean r16 = Boolean.valueOf(C2());
        if (C2() == false) goto L7;
        String r2 = "middle";
    L8:
        lc5.f.a.I(new lc5.p("ccm_space_folder_click", r4, "none", "filter", "ccm_space_header_filter_view", "", r9, "", r11, false, false, r14, r15, r16, r2, null));
        Bundle r1 = new Bundle();
        r1.putString("key_token", Z1());
        r1.putParcelable("key_sort_strategy", this.g);
        ActionSheetDialogFragment.ba0(this.d.getActivity(), SortFragment.class, r1);
        return;
    L7:
        r2 = "suspend_create";
        goto L8
    L9:
        Context r3 = this.b;
        Toast.showFailureText(r3, r3.getString(2131887789), 0);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String S1() {
        if (TextUtils.isEmpty(this.N) == false) goto L7;
        return WikiSpaceType.PERSONAL;
    L7:
        if (this.R == false) goto L10;
        return "personal_subfolder";
    L10:
        return "shared_subfolder";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String W1() {
        if (TextUtils.isEmpty(this.N) == false) goto L6;
        return this.b.getString(2131887920);
    L6:
        return super.W1();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        if (TextUtils.isEmpty(this.N) == false) goto L6;
        return "root";
    L6:
        return this.N;
    }

    @Override // uc5.f2
    public final void j() {
        if (this.E.a == true) goto L5;
        return;
    L5:
        this.F.c();
        F3();
    }

    @Override // uc5.f2
    public final boolean x() {
        return this.E.a;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        this.k = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378179));
        if (I3() == false) goto L5;
        this.k.a(EmptyCategory.FOLDER_NORMAL);
    L6:
        this.k.e(new w0(this));
        this.k.d(new a(this));
        return;
    L5:
        this.k.a(EmptyCategory.FOLDER_READONLY);
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void B2() {
        super.B2();
        this.j = this.c.findViewById(2131378171);
        if (d1.b(this.d) == true) goto L5;
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
        tt5.a.h("FolderDetailView", "initTitleBar()...");
        HomeCoordinatorLayout r2 = (HomeCoordinatorLayout) this.c.findViewById(2131378119);
        this.G = (HomeMainTitleBar) this.c.findViewById(2131378104);
        if (d1.b(this.d) == false) goto L21;
        tt5.a.h("FolderDetailView", "initTitleBar()...hide native title bar in Office scene.");
        HomeMainTitleBar r4 = this.G;
        if (r4 == null) goto L29;
        r4.setVisibility(8);
    L29:
        this.H = (SubMenuView) this.c.findViewById(2131374462);
        if (d1.b(this.d) == false) goto L43;
        tt5.a.h("FolderDetailView", "initSubMenuView()...hide native appbar in Office scene.");
        View r5 = this.c.findViewById(2131378060);
        if (r5 == null) goto L34;
        r5.setVisibility(8);
    L34:
        View r6 = this.c.findViewById(2131378183);
        if (r6 == null) goto L40;
        r6.setVisibility(8);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L40;
        r7.height = 0;
        r6.setLayoutParams(r7);
    L40:
        SubMenuView r8 = this.H;
        if (r8 == null) goto L44;
        r8.setVisibility(8);
    L44:
        this.K = (CommonCreateButton) this.c.findViewById(2131367552);
        if (d1.b(this.d) == false) goto L49;
        tt5.a.h("FolderDetailView", "initCreateBtn()...hide native create button in Office scene.");
        CommonCreateButton r9 = this.K;
        if (r9 == null) goto L53;
        r9.setVisibility(8);
    L53:
        this.L = new yc5.b(this.b, this.c, new x0(this));
        return;
    L49:
        this.K.setOnClickListener(new y0(this));
        N3();
        if (this.d.getActivity() != null) goto L52;
        tt5.a.d("FolderDetailView", "observeCreatePopupMenu()...activity is null");
        goto L53
    L52:
        ViewModelProviders.of(this.d.getActivity()).get(SelectCreationMenuViewModel.class).getSelectedCreationTypeLiveData().observe(this.d, new v0(this));
        goto L53
    L43:
        this.H.c();
        this.H.setViewDelegate(this);
        this.H.b(this.f);
        goto L44
    L21:
        r2.setMainTitle(this.G);
        if (TextUtils.isEmpty(this.N) == false) goto L24;
        this.G.g();
    L25:
        this.G.setOnMoreViewClickListener(new z0(this));
        this.G.setTitle(this.O);
        this.G.setOnSearchBtnClickListener(new a1(this));
        this.G.setOnCreateViewClickListener(new b1(this));
        HashMap r10 = new HashMap();
        r10.put("module", S1());
        BaseTitleBar r11 = this.G.getTitleBar();
        if (r11 == null) goto L28;
        r11.setTag(2131388811, r10);
    L28:
        this.G.setLeftExtraClickListener(this.d);
        goto L29
    L24:
        this.G.h();
        goto L25
    L13:
        if (r1.d.isEnable("ccm.platform.appeal_v2") == false) goto L15;
        this.J = this.c.findViewById(2131378100);
        goto L16
    L5:
        if (this.j == null) goto L7;
        tt5.a.h("FolderDetailView", "initView()...disable inner refresh layout in Office scene.");
        this.j.j(false);
        this.j.g(false);
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void destroy() {
        super.destroy();
        yc5.b r0 = this.L;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, pc5.i.c
    public final void j0() {
        super.j0();
        d2(null);
    }

    public Context getContext() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String v1() {
        return this.N;
    }

    public final void J3(SmartRefreshLayout r3) {
        StringBuilder r0 = new StringBuilder("setRefreshLayout()...hasRefreshLayout = ");
        if (r3 == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        tt5.a.h("FolderDetailView", r0.toString());
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
        if (d1.b(this.d) == true) goto L9;
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
        dd5.s1.a.a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r15, S1());
        String r5 = S1();
        String r7 = this.N;
        lc5.f.a.O(new lc5.r("ccm_space_folder_click", r5, "none", r7, sbb.e.f.b, true, !this.R, !TextUtils.isEmpty(r7), this.U, this.N));
    }

    @Override // uc5.f2
    public final void f0(ForbiddenBannerView.ForbiddenState r4) {
        tt5.a.h("FolderDetailView", "showForbidden()...state = " + r4.ordinal());
        ce5.a r0 = this.D;
        if (r0 != null) goto L5;
    L7:
        this.J.o6(r4, new com.bytedance.ee.bear.facade.common.widget.s(this.b));
        return;
    L5:
        if (r0.d.isEnable("ccm.platform.appeal_v2") == false) goto L7;
        new com.bytedance.ee.bear.facade.common.widget.t(this.b).h = 2131889731;
        this.J.o6(r4, new com.bytedance.ee.bear.facade.common.widget.t(this.b));
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
        yc5.b r2 = this.L;
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
        if (TextUtils.isEmpty(this.N) == true) goto L5;
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
        tt5.a.h("FolderDetailView", "showLoadFail()...throwable = " + r3);
        if (ax4.d.b(r3, 3) == false) goto L5;
        this.k.h(LoadFailCategory.FOLDER_NOT_FOUND);
    L6:
        M3();
        return;
    L5:
        this.k.b(r3);
        goto L6
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

    @Override // uc5.f2
    public final void u(Document r9) {
        if (this.V != null) goto L5;
        boolean r0 = true;
    L6:
        this.V = r9;
        if (r9 == null) goto L20;
        this.P = r9.U;
        this.Q = r9.x;
        this.R = FolderVersion.isPersonalFolder(r9.L1, r9.P1);
        com.bytedance.ee.bear.list.list.d r2 = this.q;
        if ((r2 instanceof FolderDetailListStyleAdapter) == false) goto L11;
        ((FolderDetailListStyleAdapter) r2).p = this.Q;
        r2.notifyDataSetChanged();
    L11:
        com.bytedance.ee.bear.list.list.d r3 = this.q;
        if ((r3 instanceof FolderDetailGridStyleAdapter) == false) goto L15;
        ((FolderDetailGridStyleAdapter) r3).i = this.Q;
        r3.notifyDataSetChanged();
    L15:
        if (r9.getType() == 4) goto L17;
        this.G.setTitle(com.bytedance.ee.bear.list.t0.g(this.b, r9));
    L17:
        N3();
        M3();
        if (I3() == false) goto L20;
        this.k.f(EmptyCategory.FOLDER_NORMAL);
    L20:
        if (r0 == true) goto L22;
        return;
    L22:
        if (TextUtils.isEmpty(this.N) == false) goto L24;
        lc5.f.q((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1());
    L25:
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1());
        lc5.f.p(S1(), "none", this.N, !this.R, "0", "0");
        return;
    L24:
        com.bytedance.ee.bear.contract.d r10 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        String r1 = S1();
        String r4 = this.S;
        String r5 = this.T;
        lc5.f.a r6 = lc5.f.a;
        lc5.f.a.T(r10, r1, null, r4, r5);
        goto L25
    L5:
        r0 = false;
        goto L6
    }

    public static void B3(c1 r25, boolean r26) {
        r25.getClass();
        tt5.a.h("FolderDetailView", "onMenuCreateClick()...");
        FragmentActivity r1 = r25.d.getActivity();
        if (r25.M != null) goto L6;
        r25.M = new com.bytedance.ee.bear.list.create.x0();
    L6:
        if (r25.M.a(r1) == false) goto L8;
        tt5.a.h("FolderDetailView", "create menu is already showing");
        return;
    L8:
        iw4.h r2 = new iw4.h();
        r2.b = r25.S1();
        r2.d = r25.S;
        String r3 = r25.N;
        r2.a = r3;
        r2.e = !TextUtils.isEmpty(r3);
        r2.f = r26;
        boolean r4 = false;
        r2.g = false;
        if (r25.M != null) goto L11;
        r25.M = new com.bytedance.ee.bear.list.create.x0();
    L11:
        com.bytedance.ee.bear.list.create.x0 r5 = r25.M;
        boolean r6 = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).d();
        SelectCreationMenuConfig r7 = new SelectCreationMenuConfig();
        r7.n = ((ww4.a) org.koin.java.a.a(ww4.a.class)).a().d().a;
        r7.l = com.bytedance.ee.bear.list.t0.s();
        if (r6 == true) goto L14;
    L15:
        r4 = true;
    L16:
        r7.o = r4;
        r7.p = com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.docx_create_enable");
        r7.k = true;
        r7.d = r25.D2();
        r7.a = r25.I3();
        r7.b = r25.I3();
        r7.e = r25.I3();
        r7.g = r25.I3();
        r7.f = r25.I3();
        r5.c(r1, r2, r7, null);
        String r10 = r25.S1();
        String r8 = r25.N;
        int r15 = sbb.e.f.b;
        boolean r19 = !r25.R;
        boolean r20 = !TextUtils.isEmpty(r8);
        int r9 = r25.U;
        Boolean r22 = Boolean.valueOf(r25.C2());
        if (r25.C2() == false) goto L19;
        String r0 = "middle";
    L20:
        lc5.f.a.I(new lc5.p("ccm_space_folder_click", r10, "none", "create", "ccm_space_create_new_view", r8, r15, "", r8, true, r19, r20, r9, r22, r0, null));
        return;
    L19:
        r0 = "suspend_create";
        goto L20
    L14:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.spacekit.bitable.enable", true) == false) goto L16;
        goto L15
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
        return new FolderDetailItemDiffCallback(r2, r3);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r20, int r21, Document r22, boolean r23) {
        super.Y(r20, r21, r22, r23);
        String r3 = S1();
        String r7 = r22.d;
        int r8 = r22.getType();
        String r9 = r22.F;
        String r10 = this.N;
        if (r22.getType() != sbb.e.f.b) goto L5;
        boolean r11 = true;
    L6:
        boolean r12 = FolderVersion.isShareFolder(r22.L1, r22.P1);
        boolean r13 = true ^ TextUtils.isEmpty(this.N);
        int r14 = this.U;
        Boolean r16 = Boolean.valueOf(C2());
        if (C2() == false) goto L9;
        String r17 = "middle";
    L10:
        lc5.p r15 = new lc5.p("ccm_space_folder_click", r3, "none", "more", "ccm_space_right_click_menu_view", r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, com.bytedance.ee.bear.list.t0.m(r22));
        lc5.f.a.I(r15);
        return;
    L9:
        r17 = "suspend_create";
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    @Override // uc5.l3
    public final void u0(View r2, int r3, Document r4, boolean r5) {
        ((f2.a) this.e).u0(r2, r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r20, int r21, Document r22, boolean r23) {
        super.x0(r20, r21, r22, r23);
        String r3 = S1();
        String r7 = r22.d;
        int r8 = r22.getType();
        String r9 = r22.F;
        String r10 = this.N;
        if (r22.getType() != sbb.e.f.b) goto L5;
        boolean r11 = true;
    L6:
        boolean r12 = FolderVersion.isShareFolder(r22.L1, r22.P1);
        boolean r13 = true ^ TextUtils.isEmpty(this.N);
        int r14 = this.U;
        Boolean r16 = Boolean.valueOf(C2());
        if (C2() == false) goto L9;
        String r17 = "middle";
    L10:
        lc5.p r15 = new lc5.p("ccm_space_folder_click", r3, "none", "delete", "ccm_space_delete_view", r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, com.bytedance.ee.bear.list.t0.m(r22));
        lc5.f.a.I(r15);
        return;
    L9:
        r17 = "suspend_create";
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    public c1(Context r1, View r2, LifeCycleFragment r3, String r4, String r5, int r6, boolean r7, boolean r8, String r9, String r10, int r11, ce5.a r12) {
        super(r1, r2, r3, r12);
        ed5.a r13 = new ed5.a();
        this.E = r13;
        this.F = new ed5.b(r13);
        this.N = r4;
        this.O = r5;
        this.P = r6;
        this.Q = r7;
        this.R = r8;
        this.S = r9;
        this.T = r10;
        this.U = r11;
    }
}
