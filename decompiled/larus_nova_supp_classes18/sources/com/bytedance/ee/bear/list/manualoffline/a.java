package com.bytedance.ee.bear.list.manualoffline;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.bytedance.ee.bear.list.list.c;
import com.bytedance.ee.bear.list.list.d;
import com.bytedance.ee.bear.list.list.f;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.loadstateview.h;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import gc5.t;
import id5.e;
import java.util.ArrayList;
import java.util.List;
import lc5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends c<f.a> implements e {
    public final InterfaceC0020a E;
    public final boolean F;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.manualoffline.a$a, reason: collision with other inner class name */
    public interface InterfaceC0020a {
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String S1() {
        return OperationName.OPERATION_OFFLINE_AVAILABLE;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        return "manual_offline";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "ManualOfflineDocumentView";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final d n1() {
        this.q = null;
        if (this.f == false) goto L5;
        d r0 = new GridStyleAdapter(OperationName.OPERATION_OFFLINE_AVAILABLE, this.D);
    L6:
        U2(r0);
        s2(r0);
        return r0;
    L5:
        r0 = new ManualOfflineDocumentListStyleAdapter(this.z, this.p, this.D, this.d);
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean p2() {
        return true;
    }

    public final void B3() {
        int r0 = t.a;
        if (qc5.a.a() == true) goto L6;
        tt5.a.h("ManualOfflineDocumentView", "getAndInitRefreshLayout()...AINoteUtils.isAiNotesEnabled() = false");
        return;
    L6:
        LifeCycleFragment r1 = this.d;
        if (r1 != null) goto L9;
    L13:
        z2();
        return;
    L9:
        if (r1.getParentFragment() == null) goto L13;
        if ((this.d.getParentFragment() instanceof wc5.c) == false) goto L13;
        this.j = this.d.getParentFragment().xZ();
        goto L13
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        h r1 = new h((LoadStateView) this.c.findViewById(2131378179));
        this.k = r1;
        r1.a(EmptyCategory.OFFLINE);
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
        B3();
        if (this.F == false) goto L6;
        lc5.f.r((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), OperationName.OPERATION_OFFLINE_AVAILABLE, "none", "home", null);
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), OperationName.OPERATION_OFFLINE_AVAILABLE);
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void onResume() {
        super.onResume();
        lc5.f.a.M("ccm_space_offline_page_view", OperationName.OPERATION_OFFLINE_AVAILABLE, "none", "");
    }

    public final void F3(SmartRefreshLayout r3) {
        tt5.a.h("ManualOfflineDocumentView", "setRefreshLayout()...refreshLayout = " + r3);
        this.j = r3;
        z2();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void d2(cqa.h r1) {
        super.d2(r1);
        InterfaceC0020a r2 = this.E;
        if (r2 == null) goto L6;
        r2.getClass();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void l0(ArrayList<Document> r2) {
        super.l0(r2);
        if (r2 != null) goto L5;
        int r3 = 0;
    L6:
        k1(r3, false);
        return;
    L5:
        r3 = r2.size();
        goto L6
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
        return new ManualOfflineItemDiffCallback(r2, r3);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void T(int r3, int r4) {
        c.q2();
        InterfaceC0020a r0 = this.E;
        if (r0 == null) goto L8;
        ManualOfflineDocumentFragment r1 = (ManualOfflineDocumentFragment) r0;
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
        p r12 = new p("ccm_space_offline_page_click", OperationName.OPERATION_OFFLINE_AVAILABLE, "none", "more", "ccm_space_right_click_menu_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", t0.m(r22));
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
        p r12 = new p("ccm_space_offline_page_click", OperationName.OPERATION_OFFLINE_AVAILABLE, "none", "more", "ccm_space_right_click_menu_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", t0.m(r22));
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
        p r12 = new p("ccm_space_offline_page_click", OperationName.OPERATION_OFFLINE_AVAILABLE, "none", "delete", "ccm_space_delete_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", t0.m(r22));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    public a(Context r1, View r2, LifeCycleFragment r3, InterfaceC0020a r4, ce5.a r5) {
        super(r1, r2, r3, r5);
        this.F = true;
        this.E = r4;
    }
}
