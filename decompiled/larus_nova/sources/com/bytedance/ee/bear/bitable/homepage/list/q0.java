package com.bytedance.ee.bear.bitable.homepage.list;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.preload.RecentListContainer;
import com.bytedance.ee.bear.list.recent.RecentDocumentItemDiffCallback;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class q0 extends com.bytedance.ee.bear.list.list.c<com.bytedance.ee.bear.list.recent.e.a> implements com.bytedance.ee.bear.list.recent.e, pd5.a.InterfaceC7184a {
    public final b E;
    public RecentListContainer F;
    public boolean G;
    public boolean H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public gd5.e f212847J;
    public final a K;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q0 f212848a;

        @Override // java.lang.Runnable
        public final void run() {
            gd5.e r100 = this.f212848a.f212847J;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(q0 r100) {
            this.f212848a = r100;
        }
    }

    public interface b {
        void m3();

        void onRefresh();

        void t(int r100, int r101);
    }

    public com.bytedance.ee.bear.list.list.d B3() {
        throw null;
    }

    public void F3() {
        throw null;
    }

    @Override // pd5.a.InterfaceC7184a
    public final void L2() {
        this.H = true;
        V2();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        return "recent";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String h2() {
        return "recent";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public String i2() {
        return "RecentDocumentView";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final com.bytedance.ee.bear.list.list.d n1() {
        this.f228583q = null;
        com.bytedance.ee.bear.list.list.d r100 = B3();
        U2(r100);
        s2(r100);
        return r100;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void B2() {
        super.B2();
        if ((this.f228570d.getParentFragment() instanceof wc5.c) == false) goto L5;
        this.f228576j = ((wc5.c) this.f228570d.getParentFragment()).xZ();
    L5:
        z2();
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        RecentListContainer r100 = (RecentListContainer) this.f228569c.findViewById(R.id.list_layout_root);
        this.F = r100;
        r100.setFirstPageViewListener(new n0(this));
        pd5.a.a(this);
        F3();
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        com.bytedance.ee.util.ui.m.e(this.K);
        this.F.setFirstPageViewListener(null);
        pd5.d.a.f528679a.f528678a = null;
        pd5.a.c(this);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void r() {
        super.r();
        com.bytedance.ee.bear.list.list.d r100 = this.f228583q;
        if (r100 == null) goto L6;
        r100.v(RecentSort.OPENED.getRank());
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean J2() {
        return this.H;
    }

    public final void I3(SmartRefreshLayout r100) {
        this.f228576j = r100;
        z2();
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void T1(Throwable r100) {
        super.T1(r100);
        gd5.e r101 = this.f212847J;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, gqa.d
    public final void d2(cqa.h r100) {
        super.d2(r100);
        b r101 = this.E;
        if (r101 == null) goto L6;
        r101.onRefresh();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public void j3(Throwable r100) {
        super.j3(r100);
        lc5.x.c().getClass();
        lc5.x.d(r100);
    }

    @Override // com.bytedance.ee.bear.list.list.c, pc5.i.c
    public final void k(rf5.d r100) {
        ((com.bytedance.ee.bear.list.recent.e.a) this.f228571e).k(r100);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public void l0(ArrayList<Document> r100) {
        lc5.x.c().a("fill_ui");
        super.l0(r100);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        tt5.a.h("BitableRecentBaseView", "setUserVisibleHint()...isVisibleToUser = " + r100);
        if (r100 == true) goto L5;
        return;
    L5:
        if ((this.f228570d.getParentFragment() instanceof wc5.c) == false) goto L7;
        this.f228576j = ((wc5.c) this.f228570d.getParentFragment()).xZ();
    L7:
        z2();
        F3();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r100, List<Document> r101) {
        return new RecentDocumentItemDiffCallback(r100, r101);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void T(int r100, int r101) {
        com.bytedance.ee.bear.list.list.c.q2();
        b r102 = this.E;
        if (r102 == null) goto L6;
        r102.t(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void k1(int r100, boolean r101) {
        super.k1(r100, r101);
        if (this.D.f23449d.isCurrentEnable("ccm.mobile.space_loading_after_db") == false) goto L5;
    L7:
        gd5.e r102 = this.f212847J;
        if (r102 == null) goto L11;
        r102.a();
        return;
    L11:
        return;
    L5:
        if (hu5.a.d(G()) == false) goto L7;
        this.f228577k.g();
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r110, int r111, Document r112, boolean r113) {
        super.Y(r110, r111, r112, r113);
        String r100 = r112.f227873d;
        int r101 = r112.getType();
        String r102 = r112.F;
        Boolean r103 = Boolean.valueOf(C2());
        if (C2() == false) goto L5;
        String r104 = "middle";
    L6:
        String r114 = r104;
        BitableRecentFragment r105 = ((BitableRecentFragment.BitableRecentView) this).R;
        r105.getClass();
        if ((r105 instanceof BitableHomeRecentFragment) == false) goto L9;
        String r106 = "ccm_base_homepage_filelist_click";
    L10:
        lc5.f.j(new lc5.p("lark_workspace_bitable_landing", "recent", "more", "ccm_space_right_click_menu_view", "recent", r100, r101, r102, r103, r114, r106));
        return;
    L9:
        r106 = "ccm_bitable_workspace_landing_page_click";
        goto L10
    L5:
        r104 = "suspend_create";
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r110, int r111, Document r112, boolean r113) {
        super.x0(r110, r111, r112, r113);
        String r100 = r112.f227873d;
        int r101 = r112.getType();
        String r102 = r112.F;
        Boolean r103 = Boolean.valueOf(C2());
        if (C2() == false) goto L5;
        String r104 = "middle";
    L6:
        String r114 = r104;
        BitableRecentFragment r105 = ((BitableRecentFragment.BitableRecentView) this).R;
        r105.getClass();
        if ((r105 instanceof BitableHomeRecentFragment) == false) goto L9;
        String r106 = "ccm_base_homepage_filelist_click";
    L10:
        lc5.f.j(new lc5.p("lark_workspace_bitable_landing", "recent", "delete", "ccm_space_delete_view", "recent", r100, r101, r102, r103, r114, r106));
        return;
    L9:
        r106 = "ccm_bitable_workspace_landing_page_click";
        goto L10
    L5:
        r104 = "suspend_create";
        goto L6
    }

    public q0(Context r100, View r101, LifeCycleFragment r102, b r103, ce5.a r104) {
        super(r100, r101, r102, r104);
        this.K = new a(this);
        this.E = r103;
    }
}
