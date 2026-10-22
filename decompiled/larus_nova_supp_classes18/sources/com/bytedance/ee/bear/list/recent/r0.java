package com.bytedance.ee.bear.list.recent;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.listsync.entity.SyncPushConfig;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.preload.RecentListContainer;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r0 extends com.bytedance.ee.bear.list.list.c<d.a> implements d, pd5.a.InterfaceC0287a {
    public final c E;
    public final ed5.a F;
    public final ed5.b G;
    public RecentListContainer H;
    public i I;
    public boolean J;
    public boolean K;
    public boolean L;
    public long M;
    public gd5.e N;
    public final a O;

    public class a implements Runnable {
        public final /* synthetic */ r0 a;

        @Override // java.lang.Runnable
        public final void run() {
            gd5.e r0 = this.a.N;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(r0 r1) {
            this.a = r1;
        }
    }

    public class b implements LoadStateView.a {
        public final /* synthetic */ r0 a;

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void c() {
        }

        public final void d() {
            c r0 = this.a.E;
            if (r0 == null) goto L15;
            RecentDocumentFragment r1 = (RecentDocumentFragment) r0;
            r1.getClass();
            tt5.a.h("RecentDocumentFragment", "onCreateBtnClick()...");
            if (r1.getParentFragment() == null) goto L12;
            if (r1.getParentFragment().getParentFragment() == null) goto L12;
            if ((r1.getParentFragment().getParentFragment() instanceof wc5.g) == false) goto L12;
            wc5.g r2 = r1.getParentFragment().getParentFragment();
            r2.onMenuCreateClick(r2.getTitleBar().getCreateView());
        L12:
            if ((r1.getParentFragment() instanceof wc5.g) == false) goto L16;
            r1.getParentFragment().onMenuCreateClick(null);
            return;
        L16:
            return;
        }

        public b(r0 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void b(View r1) {
            d();
        }
    }

    public interface c {
    }

    @Override // pd5.a.InterfaceC0287a
    public final void L2() {
        this.K = true;
        V2();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String S1() {
        return "home";
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
    public final String i2() {
        return "RecentDocumentView";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final com.bytedance.ee.bear.list.list.d n1() {
        this.q = null;
        com.bytedance.ee.bear.list.list.d r1 = dd5.d1.a("recent", this.f, this.d, this.D);
        if (r1 != null) goto L5;
        this.G.d(null);
        if (this.f == false) goto L11;
        com.bytedance.ee.bear.list.list.d r0 = new RecentDocumentGridStyleAdapter(this.D);
    L12:
        r1 = r0;
    L13:
        U2(r1);
        s2(r1);
        return r1;
    L11:
        r0 = new RecentDocumentListStyleAdapter(this.z, this.p, this.D, this.d, this.I);
        goto L12
    L5:
        if ((r1 instanceof ed5.c) == false) goto L7;
        this.G.d((ed5.c) r1);
        goto L13
    L7:
        this.G.d(null);
        goto L13
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean p2() {
        return true;
    }

    public final void B3() {
        com.bytedance.ee.bear.list.list.d r0 = this.q;
        if ((r0 instanceof ed5.c) == false) goto L6;
        ed5.c r1 = (ed5.c) r0;
        r1.t0(this.F.a);
        ed5.a r2 = this.F;
        r2.getClass();
        r1.C0(new LinkedHashSet(r2.b));
    L6:
        if (this.i != null) goto L8;
    L10:
        LifeCycleFragment r3 = this.d;
        if (r3 != null) goto L13;
        return;
    L13:
        if ((r3.getParentFragment() instanceof ed5.f) == false) goto L17;
        this.d.getParentFragment().It(this.F);
        return;
    L17:
        return;
    L8:
        if (this.F.a == true) goto L10;
        c10(0);
        goto L10
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void Z2() {
        c r0 = this.E;
        if ((r0 instanceof RecentDocumentFragment) == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L12;
        tt5.a.h("RecentDocumentView", "setRefreshListener()...office wrapped list, bind self refresh listener.");
        super.Z2();
        return;
    L12:
        if (qc5.a.f() == true) goto L14;
    L17:
        super.Z2();
        return;
    L14:
        if (E2() == true) goto L17;
        tt5.a.h("RecentDocumentView", "setRefreshListener()...sidebar refresh delegated to parent.");
        return;
    L5:
        if (((RecentDocumentFragment) r0).V90() == false) goto L7;
        r1 = true;
        goto L9
    }

    @Override // com.bytedance.ee.bear.list.recent.d
    public final void j() {
        if (this.F.a == true) goto L5;
        return;
    L5:
        this.G.c();
        B3();
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void k3() {
        if (com.bytedance.ee.util.ui.b.a(this.d.getActivity()) == true) goto L6;
        tt5.a.k("RecentDocumentView", "showRefreshTipsToast() activity is not active");
        return;
    L6:
        long r2 = System.currentTimeMillis();
        if ((r2 - this.M) >= SyncPushConfig.instance().getMinimum_tip_interval()) goto L11;
        tt5.a.h("RecentDocumentView", "showRefreshTipsToast()...too often, minimum_tip_interval = " + SyncPushConfig.instance().getMinimum_tip_interval());
        return;
    L11:
        if (this.N != null) goto L19;
        LifeCycleFragment r0 = this.d;
        if (r0 == null) goto L19;
        if (r0.getActivity() == null) goto L19;
        if (this.d.getActivity().findViewById(2131378120) == null) goto L19;
        this.N = new gd5.e(this.b);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.bottomMargin = y9c.d.a(60);
        r1.gravity = 81;
        ((ViewGroup) this.d.getActivity().findViewById(2131378120)).addView(this.N, r1);
        this.N.setOnClickListener(new q0(this));
    L19:
        gd5.e r3 = this.N;
        if (r3 == null) goto L22;
        r3.a.setVisibility(8);
        r3.b.setVisibility(0);
        r3.setVisibility(0);
        this.M = r2;
    L22:
        com.bytedance.ee.util.ui.m.b(this.O, SyncPushConfig.instance().getRefresh_tip_duration());
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        com.bytedance.ee.bear.list.loadstateview.h r1 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378179));
        this.k = r1;
        r1.a(EmptyCategory.RECENT_NORMAL);
        this.k.e(new p0(this));
        this.k.d(new b(this));
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void B2() {
        super.B2();
        if ((this.d.getParentFragment() instanceof wc5.c) == false) goto L5;
        this.j = this.d.getParentFragment().xZ();
    L5:
        z2();
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
        this.I = new i(this.D);
        RecentListContainer r0 = (RecentListContainer) this.c.findViewById(2131378147);
        this.H = r0;
        r0.setFirstPageViewListener(new o0(this));
        pd5.a.a(this);
        lc5.f.r((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "home", "recent", null, null);
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "recent");
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void destroy() {
        super.destroy();
        com.bytedance.ee.util.ui.m.e(this.O);
        this.H.setFirstPageViewListener(null);
        pd5.d.a.a.a = null;
        pd5.a.c(this);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void r() {
        super.r();
        com.bytedance.ee.bear.list.list.d r0 = this.q;
        if (r0 == null) goto L6;
        r0.v(RecentSort.OPENED.getRank());
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean J2() {
        return this.K;
    }

    public final void F3(Document r10) {
        String r3 = r10.d;
        int r4 = r10.getType();
        String r5 = r10.F;
        Boolean r6 = Boolean.valueOf(C2());
        if (C2() == false) goto L5;
        String r11 = "middle";
    L6:
        lc5.f.j(new lc5.p("more", "ccm_space_right_click_menu_view", r3, r4, r5, r6, r11));
        return;
    L5:
        r11 = "suspend_create";
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean H2(Document r2) {
        i r0 = this.I;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a(r2) == false) goto L7;
        return true;
    }

    public final void I3(SmartRefreshLayout r1) {
        this.j = r1;
        z2();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void P2(FolderSortStrategy r2) {
        super.P2(r2);
        if (this.L == true) goto L6;
        this.r = false;
    L6:
        if (r2.getType() == FilterType.ALL.getType()) goto L8;
        this.k.f(EmptyCategory.RECENT_FILTER);
        return;
    L8:
        this.k.f(EmptyCategory.RECENT_NORMAL);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void T1(Throwable r1) {
        super.T1(r1);
        this.L = true;
        gd5.e r2 = this.N;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void d2(cqa.h r3) {
        super.d2(r3);
        c r4 = this.E;
        if (r4 == null) goto L8;
        RecentDocumentFragment r5 = (RecentDocumentFragment) r4;
        r5.getClass();
        tt5.a.h("RecentDocumentFragment", "onRefresh()...source = parentHomeRefresh, fragmentHash = " + System.identityHashCode(r5) + ", presenterHash = " + System.identityHashCode(r5.h));
        if ((r5.getParentFragment() instanceof wc5.d) == false) goto L9;
        r5.getParentFragment().Cu();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void j3(Throwable r2) {
        super.j3(r2);
        lc5.x.c().getClass();
        lc5.x.d(r2);
    }

    @Override // com.bytedance.ee.bear.list.list.c, pc5.i.c
    public final void k(rf5.d r2) {
        ((d.a) this.e).k(r2);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void l0(ArrayList<Document> r3) {
        lc5.x.c().a("fill_ui");
        super.l0(r3);
        boolean r0 = this.F.a;
        if (r0 == false) goto L7;
        if (r0 == false) goto L10;
        this.G.e(r3);
        B3();
        return;
    L10:
        return;
    L7:
        B3();
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void setUserVisibleHint(boolean r4) {
        super.setUserVisibleHint(r4);
        tt5.a.h("RecentDocumentView", "setUserVisibleHint()...isVisibleToUser = " + r4);
        if (r4 == true) goto L5;
        return;
    L5:
        if ((this.d.getParentFragment() instanceof wc5.c) == false) goto L7;
        this.j = this.d.getParentFragment().xZ();
    L7:
        z2();
        lc5.f.r((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "home", "recent", null, null);
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "recent");
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
        return new RecentDocumentItemDiffCallback(r2, r3);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void T(int r3, int r4) {
        com.bytedance.ee.bear.list.list.c.q2();
        c r0 = this.E;
        if (r0 == null) goto L8;
        RecentDocumentFragment r1 = (RecentDocumentFragment) r0;
        if ((r1.getParentFragment() instanceof wc5.d) == false) goto L9;
        r1.getParentFragment().t(r3, r4);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void k1(int r1, boolean r2) {
        super.k1(r1, r2);
        if (this.D.d.isCurrentEnable("ccm.mobile.space_loading_after_db") == false) goto L5;
    L7:
        this.L = true;
        gd5.e r3 = this.N;
        if (r3 == null) goto L11;
        r3.a();
        return;
    L11:
        return;
    L5:
        if (hu5.a.d(G()) == false) goto L7;
        this.k.g();
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void P(View r1, int r2, Document r3) {
        super.P(r1, r2, r3);
        F3(r3);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.a
    public final void D(View r2, int r3, Document r4, boolean r5) {
        if ((this.q instanceof ed5.c) == true) goto L5;
    L8:
        super.D(r2, r3, r4, r5);
        return;
    L5:
        if (this.F.a == false) goto L8;
        this.G.f(r4);
        B3();
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r1, int r2, Document r3, boolean r4) {
        super.Y(r1, r2, r3, r4);
        F3(r3);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r9, int r10, Document r11, boolean r12) {
        super.x0(r9, r10, r11, r12);
        if (this.D.d.isCurrentEnable("ccm.workspace.recent_delete_enable") == true) goto L5;
    L7:
        String r13 = "ccm_space_delete_view";
    L8:
        String r2 = r13;
        String r3 = r11.d;
        int r4 = r11.getType();
        String r5 = r11.F;
        Boolean r6 = Boolean.valueOf(C2());
        if (C2() == false) goto L11;
        String r14 = "middle";
    L12:
        lc5.f.j(new lc5.p("delete", r2, r3, r4, r5, r6, r14));
        return;
    L11:
        r14 = "suspend_create";
        goto L12
    L5:
        if (TextUtils.equals(this.D.b.b, r11.e) == false) goto L7;
        r13 = "ccm_space_delete_or_remove_view";
        goto L8
    }

    public r0(Context r1, View r2, LifeCycleFragment r3, c r4, ce5.a r5) {
        super(r1, r2, r3, r5);
        ed5.a r6 = new ed5.a();
        this.F = r6;
        this.G = new ed5.b(r6);
        this.O = new a(this);
        this.E = r4;
    }
}
