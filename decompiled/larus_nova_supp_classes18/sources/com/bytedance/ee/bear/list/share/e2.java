package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e2 extends com.bytedance.ee.bear.list.list.c<com.bytedance.ee.bear.list.list.f.a> implements k0 {
    public final a E;

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
        return "shared_file";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String h2() {
        return "sharetome";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "ShareDocumentView";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final com.bytedance.ee.bear.list.list.d n1() {
        this.q = null;
        if (this.f == false) goto L5;
        com.bytedance.ee.bear.list.list.d r0 = new GridStyleAdapter("sharetome", this.D);
    L6:
        U2(r0);
        s2(r0);
        return r0;
    L5:
        r0 = new ShareDocumentListStyleAdapter(this.z, this.p, this.D);
        goto L6
    }

    public final void B3() {
        lc5.f.r((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "shared", "sharetome", "home", null);
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "sharetome");
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        com.bytedance.ee.bear.list.loadstateview.h r1 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378179));
        this.k = r1;
        r1.a(EmptyCategory.SHARE);
        this.k.e(new d2(this));
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void create() {
        super.create();
        B3();
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void onResume() {
        super.onResume();
        lc5.f.a.M("ccm_space_shared_page_view", "shared", "sharetome", "");
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void d2(cqa.h r2) {
        super.d2(r2);
        a r3 = this.E;
        if (r3 == null) goto L8;
        ShareDocumentFragment r4 = (ShareDocumentFragment) r3;
        if ((r4.getParentFragment() instanceof wc5.d) == false) goto L9;
        r4.getParentFragment().Cu();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        if (r1 == false) goto L6;
        B3();
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
        ShareDocumentFragment r1 = (ShareDocumentFragment) r0;
        if ((r1.getParentFragment() instanceof wc5.d) == false) goto L9;
        r1.getParentFragment().t(r3, r4);
        return;
    L9:
        return;
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
        lc5.p r12 = new lc5.p("ccm_space_shared_page_click", "shared", "sharetome", "more", "ccm_space_right_click_menu_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", com.bytedance.ee.bear.list.t0.m(r22));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r20, int r21, Document r22, boolean r23) {
        super.x0(r20, r21, r22, r23);
        String r7 = r22.d;
        int r8 = r22.getType();
        String r9 = r22.F;
        if (r22.getType() != sbb.e.f.b) goto L5;
        boolean r18 = true;
    L6:
        boolean r11 = r18;
        lc5.p r12 = new lc5.p("ccm_space_shared_page_click", "shared", "sharetome", "delete", "ccm_space_delete_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", com.bytedance.ee.bear.list.t0.m(r22));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    public e2(Context r1, View r2, LifeCycleFragment r3, a r4, ce5.a r5) {
        super(r1, r2, r3, r5);
        this.E = r4;
    }
}
