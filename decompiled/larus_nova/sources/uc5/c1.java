package uc5;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
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
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class c1 extends com.bytedance.ee.bear.list.list.c<f2.a> implements f2, dd5.g1, wc5.f.a {
    public final ed5.a E;
    public final ed5.b F;
    public HomeMainTitleBar G;
    public SubMenuView H;
    public View I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ForbiddenBannerView f549478J;
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c1 f549479a;

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void c() {
        }

        public final void d() {
            c1.B3(this.f549479a, true);
        }

        public a(c1 r100) {
            this.f549479a = r100;
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void b(View r100) {
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
        this.f228583q = null;
        com.bytedance.ee.bear.list.list.d r100 = dd5.d1.a(S1(), this.f228572f, this.f228570d, this.D);
        if (r100 != null) goto L5;
        this.F.d(null);
        if (this.f228572f == false) goto L13;
        FolderDetailGridStyleAdapter r101 = new FolderDetailGridStyleAdapter(S1(), this.Q, this.D);
        r101.f227959h = this;
        com.bytedance.ee.bear.list.list.d r102 = r101;
    L14:
        U2(r102);
        s2(r102);
        return r102;
    L13:
        FolderDetailListStyleAdapter r103 = new FolderDetailListStyleAdapter(S1(), this.f228592z, this.f228582p, this.Q, this.D);
        r103.f227967o = this;
        r102 = r103;
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
        HomeMainTitleBar r100 = this.G;
        boolean r101 = true;
        SpaceTagType[] r102 = new SpaceTagType[1];
        if (this.Q == false) goto L7;
        int r103 = com.bytedance.ee.bear.list.x4.f229847a;
        if (com.bytedance.ee.bear.list.x4.a(this.f228588v) == false) goto L7;
    L8:
        int r104 = SpaceTagType.f240339e;
        r102[0] = SpaceTagType.Companion.c(r101);
        SpaceTagTitleView r105 = r100.f228352d;
        if (r105 == null) goto L12;
        r105.setLabels(r102);
        return;
    L12:
        return;
    L7:
        r101 = false;
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
        String r100 = S1();
        int r101 = sbb.e.f541294e.f541317b;
        String r110 = this.N;
        boolean r111 = !TextUtils.isEmpty(r110);
        int r112 = this.U;
        Boolean r113 = Boolean.valueOf(C2());
        if (C2() == false) goto L7;
        String r102 = "middle";
    L8:
        lc5.f.f508440a.I(new lc5.p("ccm_space_folder_click", r100, "none", "filter", "ccm_space_header_filter_view", "", r101, "", r110, false, false, r111, r112, r113, r102, null));
        Bundle r103 = new Bundle();
        r103.putString("key_token", Z1());
        r103.putParcelable("key_sort_strategy", this.f228573g);
        ActionSheetDialogFragment.ba0(this.f228570d.getActivity(), SortFragment.class, r103);
        return;
    L7:
        r102 = "suspend_create";
        goto L8
    L9:
        Context r104 = this.f228568b;
        Toast.showFailureText(r104, r104.getString(R.string.Doc_Facade_Offline), 0);
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
        return this.f228568b.getString(R.string.Doc_List_FolderRefreshTips);
    L6:
        return super.W1();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        if (TextUtils.isEmpty(this.N) == false) goto L6;
        return RootDescription.ROOT_ELEMENT;
    L6:
        return this.N;
    }

    @Override // uc5.f2
    public final void j() {
        if (this.E.f472208a == true) goto L5;
        return;
    L5:
        this.F.c();
        F3();
    }

    @Override // uc5.f2
    public final boolean x() {
        return this.E.f472208a;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        this.f228577k = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.f228569c.findViewById(R.id.list_state_view_root));
        if (I3() == false) goto L5;
        this.f228577k.a(EmptyCategory.FOLDER_NORMAL);
    L6:
        this.f228577k.e(new w0(this));
        this.f228577k.d(new a(this));
        return;
    L5:
        this.f228577k.a(EmptyCategory.FOLDER_READONLY);
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void B2() {
        super.B2();
        this.f228576j = (cqa.h) this.f228569c.findViewById(R.id.list_refresh_layout);
        if (d1.b(this.f228570d) == true) goto L5;
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
        this.f549478J = (ForbiddenBannerView) this.f228569c.findViewById(R.id.list_folder_forbidden);
    L16:
        this.f549478J.setViewDelegate((ForbiddenBannerView.a) this.f228571e);
        tt5.a.h("FolderDetailView", "initTitleBar()...");
        HomeCoordinatorLayout r103 = (HomeCoordinatorLayout) this.f228569c.findViewById(R.id.list_home_coordinator_layout);
        this.G = (HomeMainTitleBar) this.f228569c.findViewById(R.id.list_folder_title_bar);
        if (d1.b(this.f228570d) == false) goto L21;
        tt5.a.h("FolderDetailView", "initTitleBar()...hide native title bar in Office scene.");
        HomeMainTitleBar r104 = this.G;
        if (r104 == null) goto L29;
        r104.setVisibility(8);
    L29:
        this.H = (SubMenuView) this.f228569c.findViewById(R.id.home_sub_title_view);
        if (d1.b(this.f228570d) == false) goto L43;
        tt5.a.h("FolderDetailView", "initSubMenuView()...hide native appbar in Office scene.");
        View r105 = this.f228569c.findViewById(R.id.list_appbar_refresh_header);
        if (r105 == null) goto L34;
        r105.setVisibility(8);
    L34:
        View r106 = this.f228569c.findViewById(R.id.list_sub_menu_layout);
        if (r106 == null) goto L40;
        r106.setVisibility(8);
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L40;
        r107.height = 0;
        r106.setLayoutParams(r107);
    L40:
        SubMenuView r108 = this.H;
        if (r108 == null) goto L44;
        r108.setVisibility(8);
    L44:
        this.K = (CommonCreateButton) this.f228569c.findViewById(R.id.common_create_button);
        if (d1.b(this.f228570d) == false) goto L49;
        tt5.a.h("FolderDetailView", "initCreateBtn()...hide native create button in Office scene.");
        CommonCreateButton r109 = this.K;
        if (r109 == null) goto L53;
        r109.setVisibility(8);
    L53:
        this.L = new yc5.b(this.f228568b, this.f228569c, new x0(this));
        return;
    L49:
        this.K.setOnClickListener(new y0(this));
        N3();
        if (this.f228570d.getActivity() != null) goto L52;
        tt5.a.d("FolderDetailView", "observeCreatePopupMenu()...activity is null");
        goto L53
    L52:
        ((SelectCreationMenuViewModel) ViewModelProviders.of(this.f228570d.getActivity()).get(SelectCreationMenuViewModel.class)).getSelectedCreationTypeLiveData().observe(this.f228570d, new v0(this));
        goto L53
    L43:
        this.H.c();
        this.H.setViewDelegate(this);
        this.H.b(this.f228572f);
        goto L44
    L21:
        r103.setMainTitle(this.G);
        if (TextUtils.isEmpty(this.N) == false) goto L24;
        this.G.g();
    L25:
        this.G.setOnMoreViewClickListener(new z0(this));
        this.G.setTitle(this.O);
        this.G.setOnSearchBtnClickListener(new a1(this));
        this.G.setOnCreateViewClickListener(new b1(this));
        HashMap r110 = new HashMap();
        r110.put(EventConstant.Key.MODULE, S1());
        BaseTitleBar r111 = this.G.getTitleBar();
        if (r111 == null) goto L28;
        r111.setTag(R.id.title_bar_common_params, r110);
    L28:
        this.G.setLeftExtraClickListener(this.f228570d);
        goto L29
    L24:
        this.G.h();
        goto L25
    L13:
        if (r102.f23449d.isEnable("ccm.platform.appeal_v2") == false) goto L15;
        this.f549478J = (ForbiddenBannerView) this.f228569c.findViewById(R.id.list_folder_new_forbidden);
        goto L16
    L5:
        if (this.f228576j == null) goto L7;
        tt5.a.h("FolderDetailView", "initView()...disable inner refresh layout in Office scene.");
        this.f228576j.j(false);
        this.f228576j.g(false);
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        yc5.b r100 = this.L;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, pc5.i.c
    public final void j0() {
        super.j0();
        d2(null);
    }

    public Context getContext() {
        return this.f228568b;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String v1() {
        return this.N;
    }

    public final void J3(SmartRefreshLayout r100) {
        StringBuilder r101 = new StringBuilder("setRefreshLayout()...hasRefreshLayout = ");
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        tt5.a.h("FolderDetailView", r101.toString());
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
        if (d1.b(this.f228570d) == true) goto L9;
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
        dd5.s1.a.f468004a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r110, S1());
        String r100 = S1();
        String r101 = this.N;
        lc5.f.f508440a.O(new lc5.r("ccm_space_folder_click", r100, "none", r101, sbb.e.f541295f.f541317b, true, !this.R, !TextUtils.isEmpty(r101), this.U, this.N));
    }

    @Override // uc5.f2
    public final void f0(ForbiddenBannerView.ForbiddenState r100) {
        tt5.a.h("FolderDetailView", "showForbidden()...state = " + r100.ordinal());
        ce5.a r101 = this.D;
        if (r101 != null) goto L5;
    L7:
        this.f549478J.o6(r100, new com.bytedance.ee.bear.facade.common.widget.s(this.f228568b));
        return;
    L5:
        if (r101.f23449d.isEnable("ccm.platform.appeal_v2") == false) goto L7;
        new com.bytedance.ee.bear.facade.common.widget.t(this.f228568b).f226720h = R.string.LarkCCM_Security_FolderShareSuspend_UserAgreeMent_Banner;
        this.f549478J.o6(r100, new com.bytedance.ee.bear.facade.common.widget.t(this.f228568b));
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
        this.f549478J.setVisibility(8);
    L9:
        yc5.b r103 = this.L;
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
        if (TextUtils.isEmpty(this.N) == true) goto L5;
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
        tt5.a.h("FolderDetailView", "showLoadFail()...throwable = " + r100);
        if (ax4.d.b(r100, 3) == false) goto L5;
        this.f228577k.h(LoadFailCategory.FOLDER_NOT_FOUND);
    L6:
        M3();
        return;
    L5:
        this.f228577k.b(r100);
        goto L6
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

    @Override // uc5.f2
    public final void u(Document r100) {
        if (this.V != null) goto L5;
        boolean r101 = true;
    L6:
        this.V = r100;
        if (r100 == null) goto L20;
        this.P = r100.U;
        this.Q = r100.f227904x;
        this.R = FolderVersion.isPersonalFolder(r100.L1, r100.P1);
        com.bytedance.ee.bear.list.list.d r102 = this.f228583q;
        if ((r102 instanceof FolderDetailListStyleAdapter) == false) goto L11;
        ((FolderDetailListStyleAdapter) r102).f227968p = this.Q;
        r102.notifyDataSetChanged();
    L11:
        com.bytedance.ee.bear.list.list.d r103 = this.f228583q;
        if ((r103 instanceof FolderDetailGridStyleAdapter) == false) goto L15;
        ((FolderDetailGridStyleAdapter) r103).f227960i = this.Q;
        r103.notifyDataSetChanged();
    L15:
        if (r100.getType() == 4) goto L17;
        this.G.setTitle(com.bytedance.ee.bear.list.t0.g(this.f228568b, r100));
    L17:
        N3();
        M3();
        if (I3() == false) goto L20;
        this.f228577k.f(EmptyCategory.FOLDER_NORMAL);
    L20:
        if (r101 == true) goto L22;
        return;
    L22:
        if (TextUtils.isEmpty(this.N) == false) goto L24;
        lc5.f.q((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1());
    L25:
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1());
        lc5.f.p(S1(), "none", this.N, !this.R, "0", "0");
        return;
    L24:
        com.bytedance.ee.bear.contract.d r104 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        String r105 = S1();
        String r106 = this.S;
        String r107 = this.T;
        lc5.f.a r108 = lc5.f.f508440a;
        lc5.f.a.T(r104, r105, null, r106, r107);
        goto L25
    L5:
        r101 = false;
        goto L6
    }

    public static void B3(c1 r210, boolean r211) {
        r210.getClass();
        tt5.a.h("FolderDetailView", "onMenuCreateClick()...");
        FragmentActivity r100 = r210.f228570d.getActivity();
        if (r210.M != null) goto L6;
        r210.M = new com.bytedance.ee.bear.list.create.x0();
    L6:
        if (r210.M.a(r100) == false) goto L8;
        tt5.a.h("FolderDetailView", "create menu is already showing");
        return;
    L8:
        iw4.h r101 = new iw4.h();
        r101.f496209b = r210.S1();
        r101.f496211d = r210.S;
        String r102 = r210.N;
        r101.f496208a = r102;
        r101.f496212e = !TextUtils.isEmpty(r102);
        r101.f496213f = r211;
        boolean r103 = false;
        r101.f496214g = false;
        if (r210.M != null) goto L11;
        r210.M = new com.bytedance.ee.bear.list.create.x0();
    L11:
        com.bytedance.ee.bear.list.create.x0 r104 = r210.M;
        boolean r105 = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).d();
        SelectCreationMenuConfig r106 = new SelectCreationMenuConfig();
        r106.f216818n = ((ww4.a) org.koin.java.a.a(ww4.a.class)).a().d().f217118a;
        r106.f216816l = com.bytedance.ee.bear.list.t0.s();
        if (r105 == true) goto L14;
    L15:
        r103 = true;
    L16:
        r106.f216819o = r103;
        r106.f216820p = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("spacekit.mobile.docx_create_enable");
        r106.f216815k = true;
        r106.f216808d = r210.D2();
        r106.f216805a = r210.I3();
        r106.f216806b = r210.I3();
        r106.f216809e = r210.I3();
        r106.f216811g = r210.I3();
        r106.f216810f = r210.I3();
        r104.c(r100, r101, r106, null);
        String r110 = r210.S1();
        String r107 = r210.N;
        int r111 = sbb.e.f541295f.f541317b;
        boolean r112 = !r210.R;
        boolean r212 = !TextUtils.isEmpty(r107);
        int r108 = r210.U;
        Boolean r213 = Boolean.valueOf(r210.C2());
        if (r210.C2() == false) goto L19;
        String r109 = "middle";
    L20:
        lc5.f.f508440a.I(new lc5.p("ccm_space_folder_click", r110, "none", "create", "ccm_space_create_new_view", r107, r111, "", r107, true, r112, r212, r108, r213, r109, null));
        return;
    L19:
        r109 = "suspend_create";
        goto L20
    L14:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.spacekit.bitable.enable", true) == false) goto L16;
        goto L15
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r100, List<Document> r101) {
        return new FolderDetailItemDiffCallback(r100, r101);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r210, int r211, Document r212, boolean r213) {
        super.Y(r210, r211, r212, r213);
        String r100 = S1();
        String r101 = r212.f227873d;
        int r102 = r212.getType();
        String r103 = r212.F;
        String r110 = this.N;
        if (r212.getType() != sbb.e.f541295f.f541317b) goto L5;
        boolean r111 = true;
    L6:
        boolean r112 = FolderVersion.isShareFolder(r212.L1, r212.P1);
        boolean r113 = true ^ TextUtils.isEmpty(this.N);
        int r114 = this.U;
        Boolean r115 = Boolean.valueOf(C2());
        if (C2() == false) goto L9;
        String r116 = "middle";
    L10:
        lc5.p r117 = new lc5.p("ccm_space_folder_click", r100, "none", "more", "ccm_space_right_click_menu_view", r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, com.bytedance.ee.bear.list.t0.m(r212));
        lc5.f.f508440a.I(r117);
        return;
    L9:
        r116 = "suspend_create";
        goto L10
    L5:
        r111 = false;
        goto L6
    }

    @Override // uc5.l3
    public final void u0(View r100, int r101, Document r102, boolean r103) {
        ((f2.a) this.f228571e).u0(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r210, int r211, Document r212, boolean r213) {
        super.x0(r210, r211, r212, r213);
        String r100 = S1();
        String r101 = r212.f227873d;
        int r102 = r212.getType();
        String r103 = r212.F;
        String r110 = this.N;
        if (r212.getType() != sbb.e.f541295f.f541317b) goto L5;
        boolean r111 = true;
    L6:
        boolean r112 = FolderVersion.isShareFolder(r212.L1, r212.P1);
        boolean r113 = true ^ TextUtils.isEmpty(this.N);
        int r114 = this.U;
        Boolean r115 = Boolean.valueOf(C2());
        if (C2() == false) goto L9;
        String r116 = "middle";
    L10:
        lc5.p r117 = new lc5.p("ccm_space_folder_click", r100, "none", "delete", "ccm_space_delete_view", r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, com.bytedance.ee.bear.list.t0.m(r212));
        lc5.f.f508440a.I(r117);
        return;
    L9:
        r116 = "suspend_create";
        goto L10
    L5:
        r111 = false;
        goto L6
    }

    public c1(Context r100, View r101, LifeCycleFragment r102, String r103, String r104, int r105, boolean r106, boolean r107, String r108, String r110, int r111, ce5.a r112) {
        super(r100, r101, r102, r112);
        ed5.a r109 = new ed5.a();
        this.E = r109;
        this.F = new ed5.b(r109);
        this.N = r103;
        this.O = r104;
        this.P = r105;
        this.Q = r106;
        this.R = r107;
        this.S = r108;
        this.T = r110;
        this.U = r111;
    }
}
