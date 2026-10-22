package com.bytedance.ee.bear.list.star;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.list.d;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.loadstateview.h;
import com.bytedance.ee.bear.list.t0;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import dd5.d1;
import ed5.f;
import java.util.ArrayList;
import java.util.List;
import lc5.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class b extends com.bytedance.ee.bear.list.list.c<c.a> implements c {
    public final a E;
    public final ed5.a F;
    public final ed5.b G;
    public boolean H;

    public interface a {
        void t(int r1, int r2);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean H2(Document r1) {
        return false;
    }

    public String I3() {
        return "ccm_space_favorites_page_click";
    }

    public String J3() {
        return "";
    }

    public String M3() {
        return "";
    }

    public String O3() {
        return "ccm_space_favorites_page_view";
    }

    public String Q3() {
        return "";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public String S1() {
        return "favorites";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        return "star";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "FavoriteView";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final d n1() {
        this.q = null;
        d r0 = N3();
        U2(r0);
        s2(r0);
        return r0;
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
        if ((r0.getParentFragment() instanceof f) == false) goto L9;
        this.d.getParentFragment().It(this.F);
        return;
    }

    public d N3() {
        d r0 = d1.a("none", this.f, this.d, this.D);
        if (r0 != null) goto L5;
        this.G.d(null);
        if (this.f == false) goto L13;
        return new FavoriteGridStyleAdapter(S1(), this.D);
    L13:
        return new FavoriteListStyleAdapter(S1(), this.z, this.p, this.D, this.d);
    L5:
        if ((r0 instanceof ed5.c) == false) goto L7;
        this.G.d((ed5.c) r0);
    L8:
        return r0;
    L7:
        this.G.d(null);
        goto L8
    }

    public void V3() {
        lc5.f.r((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1(), "none", "home", null);
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1());
    }

    public final void j() {
        if (this.F.a == true) goto L5;
        return;
    L5:
        this.G.c();
        B3();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        h r1 = new h((LoadStateView) this.c.findViewById(2131378179));
        this.k = r1;
        r1.a(EmptyCategory.FAVORITE_NORMAL);
        this.k.e(new ae5.h(this));
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
        if (this.H == false) goto L6;
        V3();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void onResume() {
        super.onResume();
        if (this.H == false) goto L6;
        String r2 = O3();
        String r3 = S1();
        String r5 = Q3();
        String r6 = J3();
        String r7 = M3();
        lc5.f.a.N(r2, r3, "none", r5, r6, r7);
        return;
    }

    public final void F3(Document r2) {
        if ((this.q instanceof ed5.c) == true) goto L5;
        return;
    L5:
        this.G.b(r2);
        B3();
    }

    public final void Y3(SmartRefreshLayout r1) {
        this.j = r1;
        z2();
    }

    public final void Z3(Document r2) {
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

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public void l0(ArrayList<Document> r2) {
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

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
        return new FavoriteItemDiffCallback(r2, r3);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void T(int r2, int r3) {
        com.bytedance.ee.bear.list.list.c.q2();
        a r0 = this.E;
        if (r0 == null) goto L6;
        r0.t(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void P(View r20, int r21, Document r22) {
        super.P(r20, r21, r22);
        String r2 = I3();
        String r3 = S1();
        String r7 = r22.d;
        int r8 = r22.getType();
        String r9 = r22.F;
        if (r22.getType() != e.f.b) goto L5;
        boolean r18 = true;
    L6:
        boolean r11 = r18;
        p r12 = new p(r2, r3, "none", "more", "ccm_space_right_click_menu_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(hu5.a.d(G())), "suspend_create", t0.m(r22));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r20, int r21, Document r22, boolean r23) {
        super.Y(r20, r21, r22, r23);
        String r2 = I3();
        String r3 = S1();
        String r7 = r22.d;
        int r8 = r22.getType();
        String r9 = r22.F;
        if (r22.getType() != e.f.b) goto L5;
        boolean r18 = true;
    L6:
        boolean r11 = r18;
        p r12 = new p(r2, r3, "none", "more", "ccm_space_right_click_menu_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(hu5.a.d(G())), "suspend_create", t0.m(r22));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r21, int r22, Document r23, boolean r24) {
        tt5.a.h("FavoriteView", "onRightSlideMenuClick()...position = " + r22);
        ((c.a) this.e).D(r23);
        String r4 = I3();
        String r5 = S1();
        if (r23.z == false) goto L5;
        String r3 = "remove_from_favorites";
    L6:
        String r7 = r3;
        String r9 = r23.d;
        int r10 = r23.getType();
        String r11 = r23.F;
        if (r23.getType() != e.f.b) goto L9;
        boolean r13 = true;
    L10:
        lc5.f.a.I(new p(r4, r5, "none", r7, "none", r9, r10, r11, "", r13, FolderVersion.isShareFolder(r23.L1, r23.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", t0.m(r23)));
        return;
    L9:
        r13 = false;
        goto L10
    L5:
        r3 = "add_to_favorites";
        goto L6
    }

    public b(Context r1, View r2, LifeCycleFragment r3, a r4, ce5.a r5) {
        super(r1, r2, r3, r5);
        ed5.a r6 = new ed5.a();
        this.F = r6;
        this.G = new ed5.b(r6);
        this.H = true;
        this.E = r4;
    }
}
