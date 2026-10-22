package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r4 extends com.bytedance.ee.bear.list.list.c<p0.a> implements p0 {
    public final a E;
    public final ed5.a F;
    public final ed5.b G;

    public interface a {
    }

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
        return "shared";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "SharedView";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final com.bytedance.ee.bear.list.list.d n1() {
        this.q = null;
        com.bytedance.ee.bear.list.list.d r1 = dd5.d1.a("shared", this.f, this.d, this.D);
        if (r1 != null) goto L5;
        this.G.d(null);
        if (this.f == false) goto L13;
        com.bytedance.ee.bear.list.list.d r0 = new GridStyleAdapter("shared", this.D);
    L14:
        U2(r0);
        s2(r0);
        return r0;
    L13:
        r0 = new SharedListStyleAdapter(this.z, this.p, this.D, this.d);
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

    public final void F3() {
        lc5.f.r((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "shared", "none", "home", null);
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "shared");
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        com.bytedance.ee.bear.list.loadstateview.h r1 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378179));
        this.k = r1;
        r1.a(EmptyCategory.SHARE);
        this.k.e(new q4(this));
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
        F3();
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void onResume() {
        super.onResume();
        lc5.f.a.M("ccm_space_shared_page_view", "shared", "none", "");
    }

    public final void I3(SmartRefreshLayout r3) {
        tt5.a.h("SharedView", "setRefreshLayout()...refreshLayout = " + r3);
        this.j = r3;
        z2();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void d2(cqa.h r2) {
        super.d2(r2);
        a r3 = this.E;
        if (r3 == null) goto L8;
        SharedFragment r4 = (SharedFragment) r3;
        if ((r4.getParentFragment() instanceof wc5.d) == false) goto L9;
        r4.getParentFragment().Cu();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void l0(ArrayList<Document> r2) {
        super.l0(r2);
        if (this.F.a == false) goto L5;
        this.G.e(r2);
    L5:
        B3();
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        if (r1 == false) goto L6;
        F3();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
        return new ShareDocumentItemDiffCallback(r2, r3);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void T(int r3, int r4) {
        com.bytedance.ee.bear.list.list.c.q2();
        a r0 = this.E;
        if (r0 == null) goto L8;
        SharedFragment r1 = (SharedFragment) r0;
        if ((r1.getParentFragment() instanceof wc5.d) == false) goto L9;
        r1.getParentFragment().t(r3, r4);
        return;
    L9:
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
        lc5.p r12 = new lc5.p("ccm_space_shared_page_click", "shared", "none", "more", "ccm_space_right_click_menu_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", com.bytedance.ee.bear.list.t0.m(r22));
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
        lc5.p r12 = new lc5.p("ccm_space_shared_page_click", "shared", "none", "more", "ccm_space_right_click_menu_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", com.bytedance.ee.bear.list.t0.m(r22));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r21, int r22, Document r23, boolean r24) {
        ((p0.a) this.e).D(r23);
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
        lc5.p r2 = new lc5.p("ccm_space_shared_page_click", "shared", "none", r7, "none", r9, r10, r11, "", r13, FolderVersion.isShareFolder(r23.L1, r23.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", com.bytedance.ee.bear.list.t0.m(r23));
        lc5.f.a.I(r2);
        return;
    L9:
        r13 = false;
        goto L10
    L5:
        r3 = "add_to_favorites";
        goto L6
    }

    public r4(Context r1, View r2, LifeCycleFragment r3, a r4, ce5.a r5) {
        super(r1, r2, r3, r5);
        ed5.a r6 = new ed5.a();
        this.F = r6;
        this.G = new ed5.b(r6);
        this.E = r4;
    }
}
