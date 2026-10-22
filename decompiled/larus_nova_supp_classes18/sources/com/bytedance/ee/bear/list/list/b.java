package com.bytedance.ee.bear.list.list;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.homepage.list.a0;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.p0;
import com.bytedance.ee.bear.contract.q0;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.e;
import com.bytedance.ee.bear.list.list.f;
import com.bytedance.ee.bear.list.list.f.a;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.bytedance.ee.util.ui.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dd5.b0;
import dd5.c0;
import dd5.d0;
import dd5.e0;
import dd5.f0;
import dd5.g0;
import dd5.h0;
import dd5.i0;
import dd5.j0;
import dd5.j1;
import dd5.k;
import dd5.k0;
import dd5.l;
import dd5.l0;
import dd5.l1;
import dd5.m0;
import dd5.n0;
import dd5.p;
import dd5.q;
import dd5.q1;
import dd5.r;
import dd5.s;
import dd5.s1;
import dd5.t;
import dd5.u;
import dd5.v;
import dd5.w;
import dd5.x;
import dd5.y;
import dd5.z;
import id5.o;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mc5.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class b<M extends com.bytedance.ee.bear.list.list.e, V extends com.bytedance.ee.bear.list.list.f<VD>, VD extends com.bytedance.ee.bear.list.list.f.a> extends BasePresenter<M, V, VD> implements com.bytedance.ee.bear.list.list.f.a, com.bytedance.ee.bear.list.list.e.a, l1, j1, q1 {
    public final Context a;
    public final Fragment b;
    public List<String> c;
    public f d;
    public final List<Document> e;
    public C0018b f;
    public final Map<String, Integer> g;
    public final d h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public long m;
    public long n;
    public long o;
    public ConnectionService.NetworkState p;
    public final b<M, V, VD>.c q;
    public AccountService.Account r;
    public a s;
    public final CompositeDisposable t;
    public final a4 u;
    public LiveData<ArrayList<Document>> v;
    public final int w;
    public ce5.a x;

    public static class a extends com.bytedance.ee.bear.contract.c {
        public final WeakReference<b<com.bytedance.ee.bear.list.list.e, com.bytedance.ee.bear.list.list.f<com.bytedance.ee.bear.list.list.f.a>, com.bytedance.ee.bear.list.list.f.a>> b;

        public a(b r2) {
            this.b = new WeakReference(r2);
        }

        public final void b(AccountService.Account r5) {
            tt5.a.h("BaseListPresenter", "onChangeInUi()...account = " + r5);
            if (r5 != null) goto L7;
            tt5.a.h("BaseListPresenter", "onChangeInUi()...account is null");
            return;
        L7:
            if (this.b.get() != null) goto L10;
            tt5.a.h("BaseListPresenter", "presenterRef.get() is null");
            return;
        L10:
            b<com.bytedance.ee.bear.list.list.e, com.bytedance.ee.bear.list.list.f<com.bytedance.ee.bear.list.list.f.a>, com.bytedance.ee.bear.list.list.f.a> r0 = this.b.get();
            AccountService.Account r2 = r0.r;
            if (r2 != null) goto L13;
        L16:
            tt5.a.h("BaseListPresenter", "accountChangeToRefreshList, uid=" + r5.uid);
            r0.r = r5;
            LiveData<ArrayList<Document>> r6 = r0.v;
            if (r6 == null) goto L19;
            r6.removeObservers(r0.b);
        L19:
            r0.Z8();
            r0.R8();
            ((com.bytedance.ee.bear.list.list.e) r0.getModel()).r2();
            return;
        L13:
            if (TextUtils.equals(r2.uid, r5.uid) == false) goto L16;
            tt5.a.h(r0.M8(), "onChangeInUi()...account is the same");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.list.b$b, reason: collision with other inner class name */
    public static class C0018b implements n.a {
        public final WeakReference<b> a;

        public C0018b(b r2) {
            this.a = new WeakReference(r2);
        }

        public final void a(OfflineDoc r3) {
            tt5.a.h("BaseListPresenter", "BackgroundSyncDocumentsCallback onChange()...offlineDoc = " + r3);
            WeakReference<b> r0 = this.a;
            if (r0 != null) goto L5;
        L9:
            tt5.a.h("BaseListPresenter", "BackgroundSyncDocumentsCallback onChange()...presenterRef or presenterRef.get() is null");
            return;
        L5:
            if (r0.get() == null) goto L9;
            this.a.get().x2(r3);
        }
    }

    public class c implements Observer<ArrayList<Document>> {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r12) {
            ArrayList<Document> r13 = (ArrayList) r12;
            long r0 = System.currentTimeMillis();
            String r2 = this.a.M8();
            StringBuilder r3 = new StringBuilder("office_folder_load_trace db_callback, module=");
            r3.append(this.a.J8());
            r3.append(", listSize = ");
            r3.append(hu5.a.c(r13));
            r3.append(", hasNetworkReturn = ");
            r3.append(this.a.i);
            r3.append(", hasDatabaseReturnBefore = ");
            r3.append(this.a.j);
            r3.append(", sinceCreate = ");
            long r4 = this.a.m;
            long r6 = -1;
            if (r4 <= 0) goto L5;
            long r5 = r0 - r4;
        L6:
            r3.append(r5);
            r3.append(", sinceObserveStart = ");
            long r7 = this.a.n;
            if (r7 <= 0) goto L9;
            long r8 = r0 - r7;
        L10:
            r3.append(r8);
            r3.append(", sinceObserveRegistered = ");
            long r9 = this.a.o;
            if (r9 <= 0) goto L13;
            r6 = r0 - r9;
        L13:
            r3.append(r6);
            r3.append(", presenterHash = ");
            r3.append(System.identityHashCode(this.a));
            r3.append(", fragmentHash = ");
            r3.append(System.identityHashCode(this.a.b));
            tt5.a.h(r2, r3.toString());
            b r1 = this.a;
            r1.j = true;
            r1.S8(r13);
            return;
        L9:
            r8 = -1;
            goto L10
        L5:
            r5 = -1;
            goto L6
        }
    }

    public static class d extends q0 {
        public final WeakReference<b> a;

        public d(b r2) {
            this.a = new WeakReference(r2);
        }

        public final void b(final String r3, final String r4) {
            tt5.a.h("BaseListPresenter", "onRename()...");
            WeakReference<b> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L10;
            final b r1 = this.a.get();
            m.a(new h0(r1, r3, r4));
            return;
        }

        public final void e(final String r3, final boolean r4) {
            tt5.a.h("BaseListPresenter", "onStar()...isStar = " + r4);
            WeakReference<b> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L10;
            final b r1 = this.a.get();
            m.a(new i0(r1, r3, r4));
            return;
        }

        public final void f(final String r3, final boolean r4) {
            tt5.a.h("BaseListPresenter", "onPin()...isPin = " + r4);
            WeakReference<b> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L10;
            final b r1 = this.a.get();
            m.a(new j0(r1, r3, r4));
            return;
        }
    }

    public class e implements Observer<ConnectionService.NetworkState> {
        public final /* synthetic */ b a;

        public e(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            b r0 = this.a;
            r0.T8((ConnectionService.NetworkState) r2);
        }
    }

    public static class f implements n.e {
        public final WeakReference<b> a;

        public f(b r2) {
            this.a = new WeakReference(r2);
        }

        public final void a(final List<String> r5) {
            tt5.a.h("BaseListPresenter", "UnSyncDocumentsCallback onChange()...list size = " + hu5.a.c(r5));
            WeakReference<b> r0 = this.a;
            if (r0 != null) goto L5;
        L9:
            tt5.a.h("BaseListPresenter", "UnSyncDocumentsCallback onChange()...presenterRef or presenterRef.get() is null");
            return;
        L5:
            if (r0.get() == null) goto L9;
            final b r1 = this.a.get();
            r1.t.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new k0(this, r5, r1), new l0(r1)));
        }

        public final void b(final List<String> r5) {
            tt5.a.h("BaseListPresenter", "UnSyncDocumentsCallback onRemove()...list size = " + hu5.a.c(r5));
            WeakReference<b> r0 = this.a;
            if (r0 != null) goto L5;
        L9:
            tt5.a.h("BaseListPresenter", "UnSyncDocumentsCallback onRemove()...presenterRef or presenterRef.get() is null");
            return;
        L5:
            if (r0.get() == null) goto L9;
            final b r1 = this.a.get();
            r1.t.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new m0(r5, r1), new n0(r1)));
        }

        public static void c(b r7, boolean r8) {
            List<Document> r0 = ((com.bytedance.ee.bear.list.list.f) r7.getView()).G();
            if (hu5.a.f(r0) == false) goto L26;
            Iterator<String> r1 = r7.c.iterator();
        L6:
            if (r1.hasNext() == false) goto L34;
            String r2 = r1.next();
            int r3 = 0;
        L9:
            if (r3 >= r0.size()) goto L6;
            Document r4 = (Document) ListProtector.get(r0, r3);
            if (TextUtils.equals(r2, r4.d) == true) goto L19;
            if (TextUtils.equals(r2, r4.u) == true) goto L19;
            if (TextUtils.equals(r2, r4.G1) == true) goto L19;
            r3 = r3 + 1;
        L19:
            if (r8 == false) goto L21;
            r4.v = 3;
        L25:
            tt5.a.h(r7.M8(), "UnSyncDocumentsCallback onChange()...position = " + r3 + ", state = " + r4.v);
            ((com.bytedance.ee.bear.list.list.f) r7.getView()).h5(r3, r4);
            goto L6
        L21:
            int r5 = r4.v;
            if (r5 == 2) goto L25;
            if (r5 == 3) goto L25;
            r4.v = 1;
            goto L25
        L34:
            return;
        }
    }

    public abstract String J8();

    public abstract String K8();

    public String L8() {
        return "none";
    }

    public abstract String M8();

    public boolean P8() {
        return !(this instanceof o);
    }

    public void U8(String r1, boolean r2) {
    }

    public void V8(String r1, String r2) {
    }

    public void W8(String r1, boolean r2) {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    private void N8() {
        this.p = com.bytedance.ee.bear.contract.j.a.a.getNetworkState();
        this.r = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).G2();
        Disposable r0 = Flowable.just("").subscribeOn(fo5.d.b()).map(new g0()).observeOn(fo5.d.d()).subscribe(new k(this), new l());
        this.t.add(r0);
    }

    private void Y8() {
        ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).Pe(this.s);
        com.bytedance.ee.bear.contract.j.a.a.a().observe(this.b, new e(this));
        s1.a.a.a(this);
        tt5.a.h(M8(), "registerRemoteCallback()...");
        this.t.add(Flowable.just("").subscribeOn(fo5.d.b()).map(new dd5.m()).map(new dd5.n(this)).subscribe(new dd5.o(this), new p(this)));
        this.t.add(Flowable.just("").subscribeOn(fo5.d.b()).map(new q()).map(new r(this)).subscribe(new a0(), new s(this)));
    }

    public final List<Document> I8() {
        ArrayList r0 = new ArrayList();
        if (hu5.a.d(((com.bytedance.ee.bear.list.list.f) getView()).G()) == false) goto L5;
        return r0;
    L5:
        Iterator<Document> r1 = ((com.bytedance.ee.bear.list.list.f) getView()).G().iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Document r2 = r1.next();
        if (r2.getType() != sbb.e.l.b) goto L7;
        r0.add(r2);
        goto L7
    L11:
        return r0;
    }

    public final boolean Q8() {
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L5;
        return true;
    L5:
        return false;
    }

    public final void Z8() {
        if (this.x.d.isCurrentEnable("ccm.mobile.space_loading_after_db") == false) goto L6;
        this.j = false;
        this.k = false;
        this.l = -1;
        return;
    }

    public final boolean O8() {
        return hu5.a.d(((com.bytedance.ee.bear.list.list.f) getView()).G());
    }

    public final void R8() {
        this.n = System.currentTimeMillis();
        this.v = null;
        tt5.a.h(M8(), "office_folder_load_trace db_read_start, module=" + J8() + ", presenterHash = " + System.identityHashCode(this) + ", modelHash = " + System.identityHashCode(getModel()) + ", fragmentHash = " + System.identityHashCode(this.b) + ", thread = " + ThreadMethodProxy.currentThread().getName());
        LiveData<ArrayList<Document>> r0 = ((com.bytedance.ee.bear.list.list.e) getModel()).X();
        this.v = r0;
        if (r0 == null) goto L5;
        r0.observe(this.b, this.q);
        this.o = System.currentTimeMillis();
        return;
    L5:
        tt5.a.h(M8(), "observeDatabase()...mListLiveData is null");
    }

    public final void X8() {
        tt5.a.h(M8(), "preloadDocuments()...");
        this.t.add(((com.bytedance.ee.bear.list.list.f) getView()).A7(this.w).subscribe(new e0(this), new f0(this)));
    }

    @Override // com.bytedance.ee.bear.list.list.e.a
    public final void a5() {
        tt5.a.h(M8(), "onListChangeNotify()");
        ((com.bytedance.ee.bear.list.list.f) getView()).k3();
    }

    public final void b9() {
        this.m = System.currentTimeMillis();
        N8();
        tt5.a.h(M8(), "office_folder_load_trace loading_start, source=create, module=" + J8() + ", presenterHash = " + System.identityHashCode(this) + ", fragmentHash = " + System.identityHashCode(this.b));
        ((com.bytedance.ee.bear.list.list.f) getView()).j8();
        Z8();
        R8();
        ((com.bytedance.ee.bear.list.list.e) getModel()).x8(this);
        ((com.bytedance.ee.bear.list.list.e) getModel()).r2();
        Y8();
    }

    public void create() {
        super.create();
        b9();
    }

    public void destroy() {
        super.destroy();
        tt5.a.h(M8(), "destroy()...");
        LiveData<ArrayList<Document>> r0 = this.v;
        if (r0 == null) goto L5;
        r0.removeObservers(this.b);
    L5:
        ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).qc(this.s);
        this.s = null;
        s1.a.a.h(this);
        Flowable.just("").subscribeOn(fo5.d.b()).map(new dd5.j()).map(new u(this)).subscribe(new z(this), new dd5.a0(this));
        Flowable.just("").subscribeOn(fo5.d.b()).map(new b0()).map(new c0(this)).subscribe(new a0(), new d0(this));
        this.t.clear();
        this.t.clear();
    }

    public final String getSource() {
        return t0.o(((com.bytedance.ee.bear.list.list.f) getView()).G1());
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void onLoadMore() {
        tt5.a.h(M8(), "onLoadMore()...");
        ((com.bytedance.ee.bear.list.list.e) getModel()).e3();
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void onRefresh() {
        tt5.a.h(M8(), "onRefresh()...");
        Z8();
        ((com.bytedance.ee.bear.list.list.e) getModel()).r2();
    }

    public void onResume() {
        tt5.a.h(M8(), "onResume()...");
        ((com.bytedance.ee.bear.list.list.f) getView()).onResume();
    }

    @Override // dd5.q1
    public void r() {
        tt5.a.h(M8(), "onTenantChanged()...");
        BearExecutors.f().execute(new t(this));
    }

    public final void H8() {
        super.create();
    }

    @Override // com.bytedance.ee.bear.list.list.e.a
    public final void R6(Throwable r4) {
        tt5.a.e(M8(), "onLoadMoreFailed()...", r4, false);
        ((com.bytedance.ee.bear.list.list.f) getView()).E3(r4);
    }

    public void S8(ArrayList<Document> r13) {
        boolean r1 = true;
        if (hu5.a.d(r13) == true) goto L30;
        Iterator<Document> r0 = r13.iterator();
    L7:
        if (r0.hasNext() == false) goto L30;
        Document r3 = r0.next();
        Integer r4 = (Integer) ((HashMap) this.g).get(r3.d);
        if (r4 != null) goto L11;
        r3.p0 = false;
    L16:
        Iterator<String> r5 = this.c.iterator();
    L18:
        if (r5.hasNext() == false) goto L24;
        String r6 = r5.next();
        if (TextUtils.equals(r6, r3.d) == true) goto L23;
        if (TextUtils.equals(r6, r3.u) == false) goto L18;
    L23:
        r3.v = 1;
        tt5.a.h(M8(), "setDocumentListSyncState()...needSyncState = " + r3.v);
    L24:
        Iterator r7 = ((ArrayList) this.e).iterator();
    L26:
        if (r7.hasNext() == false) goto L7;
        Document r8 = (Document) r7.next();
        if (r8.equals(r3) == false) goto L26;
        r3.v = r8.v;
        tt5.a.h(M8(), "setDocumentListSyncState()...backgroundSyncState = " + r3.v);
        goto L7
    L11:
        r3.p0 = true;
        if (x1.a(r4.intValue()) == false) goto L14;
        r3.v = 7;
    L15:
        tt5.a.h(M8(), "setDocumentListSyncState()...manualOfflineState = " + r3.v);
        goto L16
    L14:
        r3.v = r4.intValue();
    L30:
        boolean r2 = this.x.d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible");
        if (hu5.a.d(r13) == false) goto L33;
        int r9 = 0;
    L58:
        if (hu5.a.f(r13) == false) goto L61;
        if (r9 != 0) goto L61;
    L63:
        if (r9 <= 0) goto L65;
        tt5.a.h(M8(), "office_folder_load_trace loading_end, source=db_non_empty, module=" + J8() + ", listSize = " + r9 + ", hasNetworkReturn = " + this.i + ", presenterHash = " + System.identityHashCode(this));
        ((com.bytedance.ee.bear.list.list.f) getView()).W3(r9);
    L65:
        boolean r10 = this.x.d.isCurrentEnable("ccm.mobile.space_loading_after_db");
        if (r1 == false) goto L69;
        tt5.a.h(M8(), "ai_artifact_folder_display_filter loading_end, module=" + J8() + ", rawSize=" + hu5.a.c(r13) + ", visibleSize=0, presenterHash=" + System.identityHashCode(this));
        ((com.bytedance.ee.bear.list.list.f) getView()).W3(0);
    L83:
        ((com.bytedance.ee.bear.list.list.f) getView()).l0(r13);
        return;
    L69:
        if (r10 == false) goto L79;
        if (r9 != 0) goto L83;
        if (this.k == false) goto L83;
        boolean r11 = hu5.a.f(((com.bytedance.ee.bear.list.list.f) getView()).G());
        if (this.l == 0) goto L78;
        if (r11 == true) goto L78;
        tt5.a.h(M8(), "doc_tab_loading_trace event=keep_loading_db_empty_but_network_non_empty, module=" + J8() + ", listSize = " + r9 + ", hasNetworkReturn = " + this.i + ", hasRefreshSuccess = " + this.k + ", lastRefreshSize = " + this.l + ", presenterHash = " + System.identityHashCode(this));
    L78:
        tt5.a.h(M8(), "office_folder_load_trace loading_end, source=db_empty_after_network, module=" + J8() + ", listSize = " + r9 + ", hasNetworkReturn = " + this.i + ", hasRefreshSuccess = " + this.k + ", lastRefreshSize = " + this.l + ", loadingAfterDbEnable = " + r10 + ", presenterHash = " + System.identityHashCode(this));
        ((com.bytedance.ee.bear.list.list.f) getView()).W3(0);
        goto L83
    L79:
        if (r9 != 0) goto L83;
        if (this.i == false) goto L83;
        tt5.a.h(M8(), "office_folder_load_trace loading_end, source=db_empty_after_network, module=" + J8() + ", listSize = " + r9 + ", hasNetworkReturn = " + this.i + ", loadingAfterDbEnable = " + r10 + ", presenterHash = " + System.identityHashCode(this));
        ((com.bytedance.ee.bear.list.list.f) getView()).W3(0);
    L61:
        r1 = false;
        goto L63
    L33:
        r9 = r13.size();
        if (r2 == true) goto L58;
        Iterator<Document> r12 = r13.iterator();
        int r14 = r9;
    L38:
        if (r12.hasNext() == false) goto L54;
        Document r15 = r12.next();
        if (r15 == null) goto L51;
        int r16 = r15.getType();
        long r17 = r15.G;
        if (r16 == 0) goto L44;
    L48:
        boolean r18 = false;
    L49:
        if (r18 == false) goto L51;
        boolean r19 = true;
    L52:
        if (r19 == false) goto L38;
        r14 = r14 - 1;
        goto L38
    L44:
        if (r17 != 140) goto L46;
    L47:
        r18 = true;
        goto L49
    L46:
        if (r17 != 141) goto L48;
    L51:
        r19 = false;
        goto L52
    L54:
        if (r14 == r9) goto L56;
        tt5.a.h(M8(), "ai_artifact_folder_display_filter, module=" + J8() + ", rawSize=" + r9 + ", visibleSize=" + r14 + ", presenterHash=" + System.identityHashCode(this));
    L56:
        r9 = r14;
        goto L58
    }

    public void T8(ConnectionService.NetworkState r4) {
        if (r4 != null) goto L5;
        tt5.a.h(M8(), "onChanged()...networkState is null");
        return;
    L5:
        tt5.a.h(M8(), "onChanged()...networkState = " + r4.getType());
        ConnectionService.NetworkState r0 = this.p;
        if (r0 != null) goto L8;
    L11:
        this.p = r4;
        return;
    L8:
        if (r0.getType() != r4.getType()) goto L11;
        tt5.a.h(M8(), "onChanged()...networkState is same type");
    }

    public void a9(Document r2) {
        tt5.a.h(M8(), "responseDeleteClick()...");
    }

    public final void c9(ArrayList<Document> r3) {
        this.m = System.currentTimeMillis();
        N8();
        ((com.bytedance.ee.bear.list.list.e) getModel()).x8(this);
        Y8();
        if (r3 != null) goto L5;
        r3 = new ArrayList();
    L5:
        this.j = true;
        ((com.bytedance.ee.bear.list.list.f) getView()).W3(r3.size());
        S8(r3);
        R8();
    }

    @Override // com.bytedance.ee.bear.list.list.e.a
    public final void h4(boolean r4) {
        tt5.a.h(M8(), "onLoadMoreSuccess()...hasMore = " + r4);
        ((com.bytedance.ee.bear.list.list.f) getView()).A6(r4);
        X8();
    }

    public void p2(Throwable r4) {
        tt5.a.e(M8(), "onRefreshFailed()...", r4, false);
        ((com.bytedance.ee.bear.list.list.f) getView()).T1(r4);
        this.i = true;
        if (hu5.a.d(((com.bytedance.ee.bear.list.list.f) getView()).G()) == true) goto L5;
        return;
    L5:
        if (this.j == true) goto L7;
        return;
    L7:
        if (ax4.d.b(r4, 900099021) == true) goto L12;
        tt5.a.h(M8(), "office_folder_load_trace loading_end, source=network_fail, module=" + J8() + ", hasDatabaseReturn = " + this.j + ", presenterHash = " + System.identityHashCode(this));
        ((com.bytedance.ee.bear.list.list.f) getView()).j3(r4);
        return;
    }

    public void setUserVisibleHint(boolean r4) {
        tt5.a.h(M8(), "setUserVisibleHint()...isVisibleToUser = " + r4);
        ((com.bytedance.ee.bear.list.list.f) getView()).setUserVisibleHint(r4);
    }

    public void u8(Document r11) {
        tt5.a.h(M8(), "onShareClick()...");
        t0.y(new p0(this.b.getActivity(), r11, this.r, J8(), L8(), getSource(), this.b));
    }

    public void x2(final OfflineDoc r4) {
        this.t.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new v(this, r4), new w(this)));
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void y7(Document r11) {
        tt5.a.h(M8(), "onDeleteClick()...");
        if (P8() == false) goto L8;
        if (t0.b(this.a, r11, "delete_source") == false) goto L8;
        return;
    L8:
        if (r11.getType() != sbb.e.g.b) goto L10;
    L11:
        String r0 = r11.a;
        if (r0 != null) goto L14;
    L18:
        boolean r1 = false;
    L19:
        if (r1 == false) goto L22;
        return;
    L22:
        if (Q8() == false) goto L24;
    L27:
        a9(r11);
        lc5.f.l(new lc5.n((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.r, "delete", r11, J8(), t0.o(((com.bytedance.ee.bear.list.list.f) getView()).G1())));
        return;
    L24:
        if ((this instanceof o) == true) goto L27;
        Context r12 = this.a;
        Toast.showFailureText(r12, r12.getString(2131887215), 0);
        return;
    L14:
        if (TextUtils.equals(r0.trim(), "!~!~193278~!~!") == false) goto L18;
        if (((com.bytedance.ee.bear.contract.z) org.koin.java.a.a(com.bytedance.ee.bear.contract.z.class)).isDebugEnabled(this.a) == false) goto L18;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/debug/activity").m(268435456).e();
        r1 = true;
        goto L19
    L10:
        if (r11.getType() != sbb.e.o.b) goto L18;
        goto L11
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void C(RecyclerView r3, int r4) {
        tt5.a.b(M8(), "onScrollStateChanged()...newState = " + r4);
        if (r4 != 0) goto L6;
        X8();
        return;
    }

    @Override // dd5.j1
    public final void C6(final String r4, final int r5) {
        tt5.a.h(M8(), "onManualOfflineStatusChange()...newStatus = " + r5);
        this.t.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new x(this, r4, r5), new y(this)));
    }

    public void s8(int r7, boolean r8) {
        int r0 = hu5.a.c(((com.bytedance.ee.bear.list.list.f) getView()).G());
        boolean r1 = this.x.d.isCurrentEnable("ccm.mobile.space_loading_after_db");
        tt5.a.h(M8(), "onRefreshSuccess()...hasMore = " + r8 + ", size = " + r7 + ", adapterSize = " + r0 + ", hasDatabaseReturn = " + this.j + ", loadingAfterDbEnable = " + r1);
        ((com.bytedance.ee.bear.list.list.f) getView()).k1(r7, r8);
        this.i = true;
        if (r1 == false) goto L6;
        this.k = true;
        this.l = r7;
    L6:
        if (hu5.a.d(((com.bytedance.ee.bear.list.list.f) getView()).G()) == false) goto L15;
        tt5.a.h(M8(), "office_folder_load_trace loading_end, source=network_empty_success, module=" + J8() + ", refreshSize = " + r7 + ", hasMore = " + r8 + ", hasDatabaseReturn = " + this.j + ", loadingAfterDbEnable = " + r1 + ", presenterHash = " + System.identityHashCode(this));
        if (r1 == true) goto L11;
        ((com.bytedance.ee.bear.list.list.f) getView()).W3(r7);
        goto L15
    L11:
        if (this.j == false) goto L14;
        if (r7 != 0) goto L14;
        ((com.bytedance.ee.bear.list.list.f) getView()).W3(0);
    L14:
        tt5.a.h(M8(), "doc_tab_loading_trace event=keep_loading_wait_db, module=" + J8() + ", refreshSize=" + r7 + ", hasDatabaseReturn=" + this.j + ", presenterHash=" + System.identityHashCode(this));
    L15:
        X8();
    }

    public b(V r1, M r2, Context r3, Fragment r4, ce5.a r5) {
        super(r2, r1);
        this.c = new ArrayList();
        this.d = new f(this);
        this.e = new ArrayList();
        this.f = new C0018b(this);
        this.g = new HashMap();
        this.h = new d(this);
        this.l = -1;
        this.q = new c(this);
        this.s = new a(this);
        this.t = new CompositeDisposable();
        this.w = 8;
        this.a = r3;
        this.b = r4;
        this.u = (a4) org.koin.java.a.a(a4.class);
        this.x = r5;
    }
}
