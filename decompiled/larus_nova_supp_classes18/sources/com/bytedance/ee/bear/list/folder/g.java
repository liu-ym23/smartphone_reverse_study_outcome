package com.bytedance.ee.bear.list.folder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import dd5.d1;
import java.util.ArrayList;
import java.util.List;
import lc5.p;
import uc5.k3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class g extends com.bytedance.ee.bear.list.list.c<d.a> implements d {
    public final b E;
    public final ed5.a F;
    public final ed5.b G;

    public class a implements LoadStateView.a {
        public final /* synthetic */ g a;

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void c() {
        }

        public final void d() {
            b r0 = this.a.E;
            if (r0 == null) goto L6;
            r0.m3();
            return;
        }

        public a(g r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void b(View r1) {
            d();
        }
    }

    public interface b {
        void m3();

        void onRefresh();

        void t(int r1, int r2);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String S1() {
        return WikiSpaceType.PERSONAL;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public String Z1() {
        return "my_root";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public String i2() {
        return "MyRootFolderView";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public com.bytedance.ee.bear.list.list.d n1() {
        this.q = null;
        com.bytedance.ee.bear.list.list.d r1 = d1.a("my_root_folder", this.f, this.d, this.D);
        if (r1 != null) goto L5;
        this.G.d(null);
        if (this.f == false) goto L13;
        com.bytedance.ee.bear.list.list.d r0 = new GridStyleAdapter(WikiSpaceType.PERSONAL, this.D);
    L14:
        U2(r0);
        s2(r0);
        return r0;
    L13:
        r0 = new MyRootFolderListStyleAdapter(WikiSpaceType.PERSONAL, this.z, this.p, this.D, this.d);
        goto L14
    L5:
        if ((r1 instanceof ed5.c) == false) goto L7;
        this.G.d((ed5.c) r1);
    L8:
        U2(r1);
        s2(r1);
        return r1;
    L7:
        this.G.d(null);
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean p2() {
        return true;
    }

    public final void B3() {
        LifeCycleFragment r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0.getParentFragment() instanceof ed5.f) == false) goto L9;
        this.d.getParentFragment().It(this.F);
        return;
    }

    public final void I3() {
        lc5.f.r((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), WikiSpaceType.PERSONAL, "none", "home", null);
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), WikiSpaceType.PERSONAL);
    }

    @Override // com.bytedance.ee.bear.list.folder.d
    public final void j() {
        if (this.F.a == true) goto L5;
        return;
    L5:
        this.G.c();
        B3();
    }

    @Override // com.bytedance.ee.bear.list.folder.d
    public final boolean x() {
        return this.F.a;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public void x2() {
        com.bytedance.ee.bear.list.loadstateview.h r1 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378179));
        this.k = r1;
        r1.a(EmptyCategory.MY_SPACE_NORMAL);
        this.k.e(new k3(this));
        this.k.d(new a(this));
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean E2() {
        if (ForsetiHelper.n() == false) goto L13;
        LifeCycleFragment r0 = this.d;
        if (r0 == null) goto L13;
        if (r0.getParentFragment() == null) goto L13;
        if (this.d.getParentFragment().getParentFragment() == null) goto L13;
        if ((this.d.getParentFragment().getParentFragment() instanceof wc5.h) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void create() {
        super.create();
        I3();
    }

    @Override // com.bytedance.ee.bear.list.list.c, pc5.i.c
    public final void j0() {
        super.j0();
        d2(null);
    }

    public final void F3(Document r2) {
        if ((this.q instanceof ed5.c) == true) goto L5;
        return;
    L5:
        this.G.b(r2);
        B3();
    }

    public final void J3(SmartRefreshLayout r4) {
        tt5.a.h(i2(), "setRefreshLayout()...refreshLayout = " + r4);
        this.j = r4;
        z2();
    }

    public final void M3(Document r2) {
        if ((this.q instanceof ed5.c) == false) goto L10;
        if (r2 != null) goto L6;
        return;
    L6:
        if (this.F.a == false) goto L12;
        this.G.f(r2);
        B3();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public void P2(FolderSortStrategy r2) {
        super.P2(r2);
        if (r2.getType() == FilterType.ALL.getType()) goto L5;
        this.k.f(EmptyCategory.MY_SPACE_FILTER);
        return;
    L5:
        this.k.f(EmptyCategory.MY_SPACE_NORMAL);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void d2(cqa.h r1) {
        super.d2(r1);
        b r2 = this.E;
        if (r2 == null) goto L6;
        r2.onRefresh();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, pc5.i.c
    public final void k(rf5.d r2) {
        ((d.a) this.e).k(r2);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void l0(ArrayList<Document> r2) {
        super.l0(r2);
        boolean r0 = this.F.a;
        if (r0 == false) goto L7;
        if (r0 == false) goto L10;
        this.G.e(r2);
        B3();
        return;
    L10:
        return;
    L7:
        B3();
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        if (r1 == false) goto L6;
        I3();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
        return new FolderDetailItemDiffCallback(r2, r3);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void T(int r2, int r3) {
        com.bytedance.ee.bear.list.list.c.q2();
        b r0 = this.E;
        if (r0 == null) goto L6;
        r0.t(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void k1(int r1, boolean r2) {
        super.k1(r1, r2);
        if (this.D.d.isCurrentEnable("ccm.mobile.space_loading_after_db") == false) goto L5;
        return;
    L5:
        if (hu5.a.d(G()) == false) goto L9;
        this.k.g();
        return;
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
        p r12 = new p("ccm_space_personal_page_click", WikiSpaceType.PERSONAL, "none", "more", "ccm_space_right_click_menu_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", t0.m(r22));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
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
        p r12 = new p("ccm_space_personal_page_click", WikiSpaceType.PERSONAL, "none", "more", "ccm_space_right_click_menu_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", t0.m(r22));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r20, int r21, Document r22, boolean r23) {
        super.x0(r20, r21, r22, r23);
        String r6 = r22.d;
        int r7 = r22.getType();
        String r8 = r22.F;
        if (r22.getType() != sbb.e.f.b) goto L5;
        boolean r10 = true;
    L6:
        boolean r11 = FolderVersion.isShareFolder(r22.L1, r22.P1);
        Boolean r14 = Boolean.valueOf(C2());
        if (C2() == false) goto L9;
        String r16 = "middle";
    L10:
        p r15 = new p("ccm_space_personal_page_click", WikiSpaceType.PERSONAL, "none", "delete", "ccm_space_delete_view", r6, r7, r8, "", r10, r11, false, 0, r14, r16, t0.m(r22));
        lc5.f.a.I(r15);
        return;
    L9:
        r16 = "suspend_create";
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    public g(Context r1, View r2, LifeCycleFragment r3, b r4, ce5.a r5) {
        super(r1, r2, r3, r5);
        ed5.a r6 = new ed5.a();
        this.F = r6;
        this.G = new ed5.b(r6);
        this.E = r4;
    }
}
