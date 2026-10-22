package com.bytedance.ee.bear.list.list;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.f.a;
import com.bytedance.ee.bear.list.listitem.ListGridItemDecoration;
import com.bytedance.ee.bear.list.listitem.ListStyleItemDecoration;
import com.bytedance.ee.bear.list.more.more3.m;
import com.bytedance.ee.bear.list.more.more3.t;
import com.bytedance.ee.bear.list.share.y;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ee.bear.widgets.q;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import dd5.o0;
import dd5.p0;
import dd5.p1;
import dd5.q0;
import dd5.r0;
import dd5.s0;
import dd5.s1;
import dd5.t0;
import dd5.t1;
import dd5.u0;
import dd5.v0;
import dd5.w0;
import gc5.v;
import io.reactivex.Flowable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lc5.n;
import lc5.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class c<VD extends f.a> implements f<VD>, p1, gqa.d, gqa.b, d.a, d.b, d.c, BaseRecyclerView.a, ed5.e {
    public boolean A;
    public boolean B;
    public volatile boolean C;
    public final ce5.a D;
    public boolean a;
    public final Context b;
    public final View c;
    public final LifeCycleFragment d;
    public VD e;
    public boolean f;
    public FolderSortStrategy g;
    public SortAndFilterViewModel h;
    public BaseRecyclerView i;
    public cqa.h j;
    public com.bytedance.ee.bear.list.loadstateview.h k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public DocsLinearLayoutManager p;
    public d q;
    public boolean r;
    public ListGridItemDecoration s;
    public ListStyleItemDecoration t;
    public pc5.i u;
    public AccountService.Account v;
    public q w;
    public final a x;
    public int y;
    public String z;

    public static class a extends com.bytedance.ee.bear.contract.c {
        public final WeakReference<c> b;

        public a(c r2) {
            this.b = new WeakReference(r2);
        }

        public final void b(AccountService.Account r4) {
            tt5.a.h("BaseListView", "onChangeInUi()...account = " + r4);
            if (r4 != null) goto L5;
        L24:
            tt5.a.h("BaseListView", "invalid account, return");
            return;
        L5:
            if (r4.hasLogin() == false) goto L24;
            WeakReference<c> r0 = this.b;
            if (r0 != null) goto L10;
        L22:
            tt5.a.h("BaseListView", "onChangeInUi()...viewRef = null");
            return;
        L10:
            if (r0.get() == null) goto L22;
            c r1 = this.b.get();
            AccountService.Account r2 = r1.v;
            if (r2 != null) goto L15;
        L20:
            r1.v = r4;
            r1.q.L(r4);
            r1.V2();
            return;
        L15:
            if (TextUtils.equals(r2.uid, r4.uid) == false) goto L20;
            if (r1.v.state == (-1)) goto L19;
            return;
        L19:
            if (r4.state == 1) goto L20;
        }
    }

    public class b implements ListUpdateCallback {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void onInserted(int r3, int r4) {
            if (r3 != this.a.q.getData().size()) goto L5;
            this.a.q.notifyDataSetChanged();
            return;
        L5:
            d r0 = this.a.q;
            r0.notifyItemRangeInserted(r0.getHeaderLayoutCount() + r3, r4);
            if (r3 != 0) goto L10;
            this.a.i.scrollToPosition(0);
            return;
        }

        public final void onMoved(int r3, int r4) {
            d r0 = this.a.q;
            r0.notifyItemMoved(r3 + r0.getHeaderLayoutCount(), r4 + this.a.q.getHeaderLayoutCount());
        }

        public final void onRemoved(int r3, int r4) {
            d r0 = this.a.q;
            r0.notifyItemRangeRemoved(r3 + r0.getHeaderLayoutCount(), r4);
        }

        public final void onChanged(int r3, int r4, Object r5) {
            d r0 = this.a.q;
            r0.notifyItemRangeChanged(r3 + r0.getHeaderLayoutCount(), r4, r5);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.list.c$c, reason: collision with other inner class name */
    public class C0019c extends RecyclerView.OnScrollListener {
        public final /* synthetic */ c a;

        public C0019c(c r1) {
            this.a = r1;
        }

        public final void onScrollStateChanged(RecyclerView r4, int r5) {
            super.onScrollStateChanged(r4, r5);
            tt5.a.h(this.a.i2(), "count = " + r4.getAdapter().getItemCount() + "    newState: " + r5);
            this.a.e.C(r4, r5);
        }
    }

    public boolean E2() {
        return false;
    }

    public boolean H2(Document r1) {
        return !(this instanceof com.bytedance.ee.bear.list.manualoffline.a);
    }

    public boolean J2() {
        return !(this instanceof y);
    }

    public abstract String S1();

    public abstract String Z1();

    @Override // com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void a0() {
    }

    public String h2() {
        return "none";
    }

    public abstract String i2();

    public void k(rf5.d r1) {
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public void k3() {
    }

    public d n1() {
        this.q = null;
        if (this.f == false) goto L5;
        d r0 = new GridStyleAdapter(S1(), this.D);
    L6:
        U2(r0);
        s2(r0);
        return r0;
    L5:
        r0 = new ListStyleAdapter(S1(), this.z, this.p, this.D, this.d);
        goto L6
    }

    public boolean p2() {
        return this instanceof v;
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public void r() {
        this.g = null;
        if (this.h == null) goto L5;
        this.h = null;
    L5:
        K2();
    }

    public String v1() {
        return "all_files_token";
    }

    public abstract void x2();

    public String y1() {
        return "workspace";
    }

    private void K2() {
        if (this.d.getActivity() != null) goto L7;
        tt5.a.d(i2(), "observeSortAndFilter()...activity is null");
        return;
    L7:
        if (this.h != null) goto L9;
        this.h = (SortAndFilterViewModel) ViewModelProviders.of(this.d.getActivity()).get(SortAndFilterViewModel.class);
    L9:
        this.h.getSortStrategyLiveData().observe(this.d, new v0(this));
    }

    public final boolean D2() {
        return com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public final List<Document> G() {
        return this.q.getData();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void S0() {
        CommonRecyclerView r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (r0 != null) goto L8;
    L11:
        int r2 = this.l + Math.max(this.o, 0);
        BaseRecyclerView r3 = this.i;
        if (this.o <= 0) goto L14;
    L16:
        r1 = false;
    L17:
        r3.setClipToPadding(r1);
        CommonRecyclerView r4 = this.i;
        r4.setPadding(r4.getPaddingLeft(), this.i.getPaddingTop(), this.i.getPaddingRight(), r2);
        return;
    L14:
        if (this.m == false) goto L16;
    L8:
        if (this.n == true) goto L11;
        this.l = r0.getPaddingBottom();
        this.m = this.i.getClipToPadding();
        this.n = true;
        goto L11
    }

    public final String V0() {
        BaseRecyclerView r0 = this.i;
        if (r0 != null) goto L5;
        RecyclerView.Adapter r1 = null;
    L6:
        int r2 = -1;
        if (r1 != null) goto L9;
        int r3 = -1;
    L10:
        d r4 = this.q;
        if (r4 != null) goto L13;
        int r5 = -1;
    L14:
        CommonRecyclerView r6 = this.i;
        if (r6 != null) goto L17;
        int r7 = -1;
    L18:
        com.bytedance.ee.bear.list.loadstateview.h r8 = this.k;
        if (r8 == null) goto L23;
        r2 = r8.a.getVisibility();
    L23:
        return "adapterSize = " + r5 + ", recyclerItemCount = " + r3 + ", recyclerVisibility = " + r7 + ", loadStateVisibility = " + r2 + ", viewHash = " + System.identityHashCode(this) + ", adapterHash = " + System.identityHashCode(this.q) + ", recyclerHash = " + System.identityHashCode(this.i) + ", loadStateWrapperHash = " + System.identityHashCode(this.k) + ", ownerFragmentHash = " + System.identityHashCode(this.d);
    L17:
        r7 = r6.getVisibility();
        goto L18
    L13:
        r5 = hu5.a.c(r4.getData());
        goto L14
    L9:
        r3 = r1.getItemCount();
        goto L10
    L5:
        r1 = r0.getAdapter();
        goto L6
    }

    public String W1() {
        return this.b.getString(2131887957);
    }

    public void Z2() {
        tt5.a.h("BaseListView", "setRefreshListener :" + this);
        this.j.d(this);
    }

    public void create() {
        this.z = ((i0) org.koin.java.a.a(i0.class)).a();
        this.v = ((h0) org.koin.java.a.a(h0.class)).G2();
        B2();
        s1.a.a.a(this);
        ((h0) org.koin.java.a.a(h0.class)).Pe(this.x);
        com.bytedance.ee.bear.contract.j.a.a.a().observe(this.d, new p0(this));
        oc5.d.a.a.a.observe(this.d, new q0(this));
        K2();
        V2();
        Mj(t3.a);
        tt5.a.h(i2(), "create()...mLocale = " + this.z);
        if (E2() == false) goto L8;
        BaseRecyclerView r0 = this.i;
        if (r0 == null) goto L9;
        r0.addItemDecoration(new MarginDividerItemDecoration(this.b, 24, 24));
        return;
    L9:
        return;
    }

    public final void e1() {
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L10;
        Flowable r0 = Flowable.just("").observeOn(fo5.d.c()).map(new r0(this)).observeOn(fo5.d.d());
        d r2 = this.q;
        if (r2 == null) goto L7;
        List<Document> r3 = r2.getData();
    L8:
        r0.map(new t1(r3)).subscribe(new s0(this), new t0());
        return;
    L7:
        r3 = null;
        goto L8
    }

    public static void q2() {
        if (SwipeMenuLayout.getViewCache() == null) goto L6;
        SwipeMenuLayout.getViewCache().b();
        return;
    }

    public void B2() {
        y2();
        x2();
    }

    public final boolean C2() {
        return hu5.a.d(G());
    }

    public final void V2() {
        tt5.a.h(i2(), "registerDriveUploadListener()...");
        if (J2() == true) goto L5;
        return;
    L5:
        if (this.u != null) goto L15;
        pc5.i r0 = new pc5.i(this.b);
        this.u = r0;
        r0.setViewDelegate(this);
        if (p2() == false) goto L15;
        if (ForsetiHelper.s(this.d) == false) goto L15;
        ForsetiViewModel r1 = ForsetiHelper.j(this.d);
        if (r1 == null) goto L15;
        r1.getViewMode().observe(this.d, new o0(this));
    L15:
        this.u.a(v1(), y1(), "");
    }

    public void destroy() {
        tt5.a.h(i2(), "destroy()...");
        s1.a.a.h(this);
        if (J2() == false) goto L8;
        pc5.i r0 = this.u;
        if (r0 != null) goto L7;
        tt5.a.h(i2(), "unRegisterDriveUploadListener()...driveUploadView is null");
        goto L8
    L7:
        r0.b();
        this.u.setViewDelegate(null);
        this.u = null;
    L8:
        ((h0) org.koin.java.a.a(h0.class)).qc(this.x);
    }

    public final void h3() {
        q2();
        d r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getItemCount() <= 0) goto L9;
        this.i.smoothScrollToPosition(0);
        return;
    }

    public void j0() {
        tt5.a.h(i2(), "hideUploadView()...");
        pc5.i r0 = this.u;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getParent() == null) goto L9;
        this.q.removeHeaderView(this.u);
        this.q.notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public void j8() {
        tt5.a.h(i2(), "showLoadDataAnim()...");
        this.k.j();
    }

    public final void l1() {
        tt5.a.h(i2(), "checkSecretKeyDelete()...isSecretKeyDelete=" + this.C);
        if (this.C == false) goto L6;
        d2(this.j);
        this.C = false;
        return;
    }

    @Override // pc5.i.c
    public final void o0() {
        tt5.a.h(i2(), "showUploadView()...");
        pc5.i r0 = this.u;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getParent() != null) goto L9;
        this.q.addHeaderView(this.u);
        this.q.notifyDataSetChanged();
        this.i.smoothScrollToPosition(0);
        this.k.c(this.q.getItemCount());
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public void onResume() {
        tt5.a.h(i2(), "onResume()...");
        h1(com.bytedance.ee.bear.contract.j.a.a.getNetworkState());
        l1();
        this.a = true;
    }

    @Override // com.bytedance.ee.bear.list.list.d.b
    public final boolean t0() {
        return E2();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup, com.bytedance.ee.bear.widgets.BaseRecyclerView] */
    public final void y2() {
        tt5.a.h(i2(), "initRecyclerView()...");
        ?? r0 = (BaseRecyclerView) this.c.findViewById(2131378168);
        this.i = r0;
        if (r0 != 0) goto L5;
    L8:
        BaseRecyclerView r1 = this.i;
        StringBuilder r2 = new StringBuilder("bear_space_list_");
        r2.append(S1());
        r2.append("_");
        if (this.f == false) goto L11;
        String r3 = "grid";
    L12:
        r2.append(r3);
        String r4 = r2.toString();
        if ((r1 instanceof CommonRecyclerView) == false) goto L15;
        r1.setSceneTag(r4);
    L15:
        this.i.setItemAnimator(null);
        this.p = new DocsLinearLayoutManager(this.b);
        this.s = new ListGridItemDecoration(this.b);
        this.t = new ListStyleItemDecoration();
        this.i.setLayoutManager(this.p);
        this.i.addItemDecoration(this.t);
        this.i.addOnScrollListener(new C0019c(this));
        RecyclerView.Adapter r5 = n1();
        this.q = r5;
        if ((r5 instanceof RecyclerView.Adapter) == false) goto L18;
        this.i.setAdapter(r5);
    L19:
        this.i.setNestScrollListener(this);
        S0();
        return;
    L18:
        iu5.d.a(i2(), new IllegalArgumentException("adapter is not extends RecyclerView.Adapter"));
        goto L19
    L11:
        r3 = SegmentStyle.FONT_STYLE_NORMAL;
        goto L12
    L5:
        if (this.n == true) goto L8;
        this.l = r0.getPaddingBottom();
        this.m = this.i.getClipToPadding();
        this.n = true;
        goto L8
    }

    public void z2() {
        tt5.a.h(i2(), "initRefreshLayout()...");
        cqa.h r0 = this.j;
        if (r0 != null) goto L6;
        tt5.a.h(i2(), "initRefreshLayout()...refreshLayout = null");
        return;
    L6:
        r0.e(new LoadMoreFooter(this.b));
        this.j.g(this.A);
        Z2();
        this.j.i(this);
        if ((this.j.getRefreshHeader() instanceof wa5.a) == false) goto L10;
        this.j.getRefreshHeader().setCustomText(W1());
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public final boolean G1() {
        return this.f;
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public final void A6(boolean r4) {
        tt5.a.h(i2(), "loadMoreSuccess()...hasMore = " + r4);
        this.A = r4;
        cqa.h r0 = this.j;
        if (r0 == null) goto L7;
        r0.f(0);
        if (r4 == true) goto L7;
        this.j.b(0, true);
    L7:
        s3(r4);
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public final Flowable<List<Document>> A7(final int r5) {
        final BaseRecyclerView r0 = this.i;
        final List<Document> r1 = this.q.getData();
        String[] r2 = com.bytedance.ee.bear.list.t0.a;
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).map(new com.bytedance.ee.bear.list.h0(r0, r1, r5));
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public final void E3(Throwable r4) {
        tt5.a.h(i2(), "loadMoreFailed()...throwable = " + r4);
        A6(false);
    }

    public void Mj(boolean r5) {
        tt5.a.h(i2(), "onSwitchGrid()...grid = " + r5);
        if (this.f != r5) goto L5;
        return;
    L5:
        this.f = r5;
        int r0 = this.i.getLayoutManager().findFirstVisibleItemPosition();
        List<Document> r1 = this.q.getData();
        d r2 = n1();
        this.q = r2;
        r2.setData(r1);
        FolderSortStrategy r3 = this.g;
        if (r3 == null) goto L8;
        this.q.v(r3.e);
    L8:
        this.i.setAdapter(this.q);
        if (r5 == false) goto L11;
        int r4 = w0.a;
        GridLayoutManager r6 = new GridLayoutManager(this.b, w0.a(ContextsKt.findActivity(this.b)));
        r6.setSpanSizeLookup(c2(r6));
        this.i.setLayoutManager(r6);
        this.i.removeItemDecoration(this.t);
        this.i.addItemDecoration(this.s);
    L12:
        this.q.notifyDataSetChanged();
        this.i.scrollToPosition(r0);
        x.c().e = r5;
        return;
    L11:
        this.i.setLayoutManager(this.p);
        this.i.removeItemDecoration(this.s);
        this.i.addItemDecoration(this.t);
        goto L12
    }

    public final void O0(cqa.h r1) {
        this.e.onLoadMore();
    }

    public void P2(FolderSortStrategy r4) {
        tt5.a.h(i2(), "onFilterChanged()...sortStrategy = " + r4);
        this.q.v(r4.e);
        this.g = r4;
        this.r = true;
        this.i.scrollToPosition(0);
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public void T1(Throwable r4) {
        tt5.a.h(i2(), "refreshFailed()...throwable = " + r4);
        cqa.h r5 = this.j;
        if (r5 == null) goto L6;
        r5.a();
        W2(false);
        return;
    }

    public final void U2(d r3) {
        pc5.i r0 = this.u;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getParent() == null) goto L9;
        ((ViewGroup) this.u.getParent()).removeView(this.u);
        r3.addHeaderView(this.u);
        return;
    }

    public void W2(boolean r2) {
        cqa.h r0 = this.j;
        if (r0 == null) goto L6;
        r0.c();
        this.j.g(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public void W3(int r1) {
        v3(r1);
    }

    public void X2(int r2) {
        cqa.h r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0.getRefreshHeader() instanceof wa5.a) == false) goto L9;
        this.j.getRefreshHeader().setStartNumber(r2);
        return;
    }

    @Override // ed5.e
    public final void c10(int r2) {
        this.o = Math.max(r2, 0);
        S0();
    }

    public GridLayoutManager.SpanSizeLookup c2(GridLayoutManager r3) {
        return new BaseListSpanSizeLookup(this.q, r3);
    }

    public void d2(cqa.h r4) {
        tt5.a.h(i2(), "onRefresh()...refreshLayoutHash = " + System.identityHashCode(r4) + ", selfRefreshLayoutHash = " + System.identityHashCode(this.j) + ", " + V0());
        cqa.h r5 = this.j;
        if (r5 == null) goto L5;
        r5.c();
    L5:
        this.e.onRefresh();
    }

    public void h1(ConnectionService.NetworkState r4) {
        tt5.a.h(i2(), "checkConnection()...changed networkState = " + r4);
        e1();
        if (r4 != null) goto L5;
        return;
    L5:
        this.q.x0(r4.a());
        this.q.notifyDataSetChanged();
        cqa.h r0 = this.j;
        if (r0 == null) goto L9;
        r0.j(r4.a());
        return;
    }

    public int j2(ArrayList<Document> r1) {
        return hu5.a.c(r1);
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public void j3(Throwable r4) {
        tt5.a.h(i2(), "showLoadFail()...throwable = " + r4);
        this.k.b(r4);
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public void l0(ArrayList<Document> r11) {
        ArrayList<Document> r0 = dd5.a.a(r11, this.D.d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible"));
        int r1 = hu5.a.c(this.q.getData());
        int r2 = hu5.a.c(r0);
        int r12 = hu5.a.c(r11);
        if (r12 == r2) goto L6;
        tt5.a.h(i2(), "ai_artifact_folder_display_filter, rawSize=" + r12 + ", visibleSize=" + r2);
    L6:
        if (this.r == true) goto L10;
        if (r1 != r2) goto L10;
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
        tt5.a.h(i2(), "showList()...before, inputSize = " + r2 + ", adapterSize = " + r1 + ", refreshListAll = " + this.r + ", " + V0());
    L14:
        if (r1 == r2) goto L17;
        tt5.a.h(i2(), "showList()...documentList size " + r2 + ", mRefreshListAll = " + this.r);
    L17:
        if (this.r == false) goto L19;
        this.q.setData(r0);
        this.q.notifyDataSetChanged();
        this.r = false;
    L21:
        if (this.y != 0) goto L27;
        cqa.h r4 = this.j;
        if (r4 == null) goto L27;
        if ((r4.getRefreshHeader() instanceof DigitDanceHeader) == false) goto L27;
        this.j.getRefreshHeader().setStartNumber(j2(r0));
    L27:
        e1();
        r3(r12, r2, r2);
        if (r3 == false) goto L31;
        tt5.a.h(i2(), "showList()...after, inputSize = " + r2 + ", adapterSize = " + hu5.a.c(this.q.getData()) + ", " + V0());
        return;
    L31:
        return;
    L19:
        DiffUtil.calculateDiff(Q1(this.q.getData(), r0), false).dispatchUpdatesTo(new b(this));
        this.q.setData(r0);
    L10:
        r3 = true;
        goto L12
    }

    public void s2(d r3) {
        r3.L(this.v);
        r3.x0(D2());
        if ((r3 instanceof ListStyleAdapter) == false) goto L5;
        ListStyleAdapter.c r1 = new u0(this);
        ((ListStyleAdapter) r3).m = r1;
    L5:
        r3.I(this);
        r3.o0(this);
        r3.M0(this);
    }

    public void s3(boolean r5) {
        ListStyleItemDecoration r0 = this.t;
        if (r0 == null) goto L5;
        tt5.a.h("ListStyleItemDecoration", "setHasMore()...hasMore = " + r5);
        r0.a = r5;
    L5:
        ListGridItemDecoration r1 = this.s;
        if (r1 == null) goto L9;
        tt5.a.h("ListGridItemDecoration", "setHasMore()...hasMore = " + r5);
        r1.d = r5;
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public final void s6(boolean r4) {
        tt5.a.h(i2(), "showLoadingDialog()...show = " + r4);
        if (r4 == true) goto L5;
        q r5 = this.w;
        if (r5 == null) goto L13;
        r5.a();
        return;
    L13:
        return;
    L5:
        if (this.w != null) goto L7;
        this.w = new q(this.b);
    L7:
        this.w.e();
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public void setUserVisibleHint(boolean r4) {
        tt5.a.h(i2(), "setUserVisibleHint()...isVisibleToUser = " + r4);
        if (r4 == true) goto L5;
        q2();
        return;
    L5:
        if (this.q == null) goto L9;
        h1(com.bytedance.ee.bear.contract.j.a.a.getNetworkState());
        return;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.e = (VD) r1;
    }

    public final void v3(int r4) {
        tt5.a.h(i2(), "showLoadSuccess()...size = " + r4 + ", headerCount = " + this.q.getHeaderLayoutCount() + ", " + V0());
        this.k.c(r4 + this.q.getHeaderLayoutCount());
    }

    public DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
        return new BaseListItemDiffCallback(r2, r3);
    }

    public void T(int r1, int r2) {
        q2();
    }

    @Override // com.bytedance.ee.bear.list.list.d.c
    public void h0(Document r4, boolean r5) {
        if (r5 == false) goto L12;
        com.bytedance.ee.bear.contract.d r6 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        String r0 = S1();
        lc5.f.a r1 = lc5.f.a;
        Intrinsics.checkNotNullParameter(r6, "analyticService");
        Intrinsics.checkNotNullParameter(r0, "module");
        Intrinsics.checkNotNullParameter(r4, "item");
        HashMap r2 = new HashMap();
        r2.put("module", r0);
        r2.put("file_type", sbb.e.c(r4.getType()));
        String r7 = r4.x1;
        if (r7 != null) goto L6;
        r7 = "";
    L6:
        r2.put("appid", r7);
        if (qc5.a.h() == false) goto L9;
        String r8 = "new_format";
    L10:
        r2.put("space_version", r8);
        lc5.f.a.D(r6, "show_left_slide", r2);
        return;
    L9:
        r8 = "original";
        goto L10
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public final void h5(int r4, Document r5) {
        tt5.a.h(i2(), "notifyItemChanged()...position = " + r4);
        if (hu5.a.a(r4, this.q.getData()) == false) goto L6;
        this.q.p2(r4, r5);
        return;
    L6:
        tt5.a.h(i2(), "notifyItemChanged()...illegal arguments, position = " + r4 + ", item = " + r5);
    }

    @Override // com.bytedance.ee.bear.list.list.f
    public void k1(int r4, boolean r5) {
        tt5.a.h(i2(), "refreshSuccess() size = " + r4 + ", hasMore = " + r5 + ", " + V0());
        this.y = r4;
        this.A = r5;
        X2(r4);
        cqa.h r6 = this.j;
        if (r6 == null) goto L5;
        r6.a();
        W2(r5);
    L5:
        s3(r5);
    }

    public void P(View r3, int r4, Document r5) {
        tt5.a.h("BaseListView", "onRightMoreButtonClick()...position = " + r4);
        f3(r5, true, r4, r3);
        lc5.f.d((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1(), r5);
    }

    public final void r3(int r7, int r8, int r9) {
        boolean r0 = true;
        if (r7 == r8) goto L5;
        boolean r2 = true;
    L7:
        if (this.B == false) goto L10;
        if (r9 <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r2 == true) goto L13;
        if (r3 == true) goto L13;
        return;
    L13:
        tt5.a.h(i2(), "sync_load_state_after_display_filter, rawSize=" + r7 + ", filteredSize=" + r8 + ", visibleSize=" + r9 + ", hasMore=" + this.A);
        v3(r9);
        if (r2 == false) goto L17;
        if (r9 != 0) goto L17;
    L18:
        this.B = r0;
        return;
    L17:
        r0 = false;
    L10:
        r3 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    public c(Context r3, View r4, LifeCycleFragment r5, ce5.a r6) {
        this.a = false;
        this.x = new a(this);
        this.y = 0;
        this.C = false;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.D = r6;
    }

    @Override // com.bytedance.ee.bear.list.list.d.b
    public final void B0(View r2, int r3, Document r4, boolean r5) {
        if (com.bytedance.ee.bear.list.t0.b(this.b, r4, "share") == false) goto L5;
        return;
    L5:
        tt5.a.h(i2(), "onCenterSlideMenuClick()...position = " + r3);
        this.e.u8(r4);
    }

    @Override // com.bytedance.ee.bear.list.list.d.a
    public void D(View r3, int r4, Document r5, boolean r6) {
        tt5.a.h(i2(), "onItemClick()...position = " + r4 + "mDelegate:" + this.e);
        this.e.h3(r5, r4, r6);
    }

    public void Y(View r8, int r9, Document r10, boolean r11) {
        tt5.a.h("BaseListView", "onLeftSlideMenuClick()...position = " + r9);
        f3(r10, r11, r9, r8);
        if (r11 == false) goto L5;
        lc5.f.d((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1(), r10);
        return;
    L5:
        lc5.f.l(new n((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.v, "more", r10, S1(), com.bytedance.ee.bear.list.t0.o(false)));
    }

    public void f3(Document r10, boolean r11, int r12, View r13) {
        LifeCycleFragment r1 = this.d;
        AccountService.Account r3 = this.v;
        String r4 = S1();
        String r5 = h2();
        VD r7 = this.e;
        String r8 = i2();
        Intrinsics.checkNotNullParameter(r1, "fragment");
        Intrinsics.checkNotNullParameter(r10, "document");
        Intrinsics.checkNotNullParameter(r3, "account");
        t.e(new m(r1, r10, r3, r4, r5, r11, r7, r8), this.D, r13);
    }

    public void x0(View r2, int r3, Document r4, boolean r5) {
        if (H2(r4) == true) goto L5;
    L7:
        tt5.a.h(i2(), "onRightSlideMenuClick()...position = " + r3);
        this.e.y7(r4);
        return;
    L5:
        if (com.bytedance.ee.bear.list.t0.b(this.b, r4, "delete_source") == false) goto L7;
    }
}
