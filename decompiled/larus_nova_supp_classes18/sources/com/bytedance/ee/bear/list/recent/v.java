package com.bytedance.ee.bear.list.recent;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.u3;
import com.bytedance.ee.bear.list.v3;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mc5.u1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v extends com.bytedance.ee.bear.list.list.a<z0> implements c, pd5.a.InterfaceC0287a {
    public gd5.d l;
    public final AtomicBoolean m;
    public boolean n;
    public boolean o;
    public Integer p;

    @Override // com.bytedance.ee.bear.list.list.a
    public final String L() {
        return "recent";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "RecentDocumentModel";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final Flowable<DocumentListInfo> C() {
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new p(this)).map(new q(this)).flatMap(new r(this)).doOnNext(new s()).doOnError(new t());
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String D() {
        if (DevicePerfManager.b.a.e.h == false) goto L6;
        return "30";
    L6:
        int r1 = -1;
        r1 = new JSONObject((String) com.bytedance.ee.bear.appsetting.c.a.a.d("ccm_mobile_workspace_config", "")).optInt("workspace_fetch_size", -1);     // Catch: Throwable -> L13
    L8:
        if (r1 > 0) goto L10;
        return "100";
    L10:
        return String.valueOf(r1);
    }

    @Override // pd5.a.InterfaceC0287a
    public final void L2() {
        this.l = new gd5.d(this, new u(this));
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final void create() {
        tt5.a.h("RecentDocumentModel", "create()...");
        if (this.m.get() == false) goto L6;
        tt5.a.h("RecentDocumentModel", "create()...already create, return...");
        return;
    L6:
        super.create();
        this.m.compareAndSet(false, true);
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final Flowable<ArrayList<Document>> g() {
        return ((z0) this.g).c();
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().c().a == false) goto L6;
        return "/api/explorer/recent/list/";
    L6:
        return "space/api/explorer/lean/browse/list/";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final com.bytedance.ee.bear.list.u o() {
        return new g();
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void onResume() {
        gd5.d r0 = this.l;
        if (r0 == null) goto L9;
        r0.getClass();
        tt5.a.h("RecentSyncManager", "onResume()...mIsHidden = " + r0.c);
        if (r0.c == false) goto L7;
        r0.a();
    L7:
        r0.c = false;
        return;
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void onStop() {
        gd5.d r0 = this.l;
        if (r0 == null) goto L6;
        r0.getClass();
        tt5.a.h("RecentSyncManager", "onStop()...");
        r0.c = true;
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final mc5.k p() {
        return new z0(this.k);
    }

    public final void u0() {
        if (this.n == true) goto L5;
        return;
    L5:
        FolderSortStrategy r0 = this.c;
        if (r0 == null) goto L8;
        int r1 = r0.e;
    L9:
        int r6 = r1;
        FolderSortStrategy r2 = this.c;
        if (r2 == null) goto L12;
        boolean r3 = r2.f;
    L13:
        FilterType r4 = FilterType.ALL;
        int r5 = r4.getType();
        String r7 = r4.getFileType();
        String r8 = r4.getForbiddenFileType();
        this.c = new FolderSortStrategy("recent", r5, r7, r8, r6, r3);
        return;
    L12:
        r3 = RecentSort.OPENED.getAsc();
        goto L13
    L8:
        r1 = RecentSort.OPENED.getRank();
        goto L9
    }

    public final void x0() {
        if (this.n == true) goto L5;
        return;
    L5:
        if (this.o == true) goto L14;
        Fragment r0 = this.a;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.getActivity() == null) goto L16;
        this.o = true;
        ((OfficeRecentFilterViewModel) new ViewModelProvider(this.a.getActivity()).get(OfficeRecentFilterViewModel.class)).getTabTypeLiveData().observe(this.a, new m(this));
        return;
    L16:
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final LiveData<ArrayList<Document>> X() {
        lc5.x.c().a("load_db_data");
        final mc5.j r0 = (mc5.j) this.k.a(mc5.j.class);
        if (AppInfoUtils.f().booleanValue() == false) goto L5;
        final LiveData r1 = r0.Fb();
        final MediatorLiveData r2 = new MediatorLiveData();
        tt5.a.h("RecentDocumentModel", "getListLiveData()...office initial source created, limit = 20, sourceHash = " + System.identityHashCode(r1) + ", modelHash = " + System.identityHashCode(this));
        r2.addSource(r1, new l(this, r2, r1, r0));
        return r2;
    L5:
        return Transformations.map(r0.c7(1), new j(this));
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final void destroy() {
        super.destroy();
        gd5.d r0 = this.l;
        if (r0 == null) goto L10;
        tt5.a.h("RecentSyncManager", "onDestroy()...");
        Disposable r1 = r0.d;
        if (r1 != null) goto L7;
    L9:
        this.l = null;
        goto L10
    L7:
        if (r1.isDisposed() == true) goto L9;
        r0.d.dispose();
    L10:
        ((z0) this.g).c.clear();
        pd5.a.c(this);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final NetService.f h() {
        u0();
        NetService.f r0 = super.h();
        boolean r1 = true;
        r0.b("type_opt", String.valueOf(1));
        if (TextUtils.equals(((NetService.e) r0).b, "/api/explorer/recent/list/") == false) goto L16;
        if (AppInfoUtils.f().booleanValue() == false) goto L8;
        u3.a(r0);
    L8:
        if (this.n == true) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L16;
        r0.b("tab_type", String.valueOf(this.p));
        goto L16
    L10:
        if (this.p == null) goto L12;
        r2 = true;
    L16:
        if (TextUtils.equals(k(), "/api/explorer/recent/list/") == false) goto L18;
        v3.a(r0);
    L18:
        StringBuilder r3 = new StringBuilder("buildRefreshRequest()...officeFilterEnabled = ");
        r3.append(this.n);
        r3.append(", officeFilterTabType = ");
        r3.append(this.p);
        r3.append(", hasOfficeRecentFilterTabType = ");
        if (this.n == true) goto L21;
    L23:
        r1 = false;
    L24:
        r3.append(r1);
        r3.append(", isOfficeSDK = ");
        r3.append(AppInfoUtils.f());
        r3.append(", sortStrategy = ");
        r3.append(this.c);
        r3.append(", modelHash = ");
        r3.append(System.identityHashCode(this));
        tt5.a.h("RecentDocumentModel", r3.toString());
        return r0;
    L21:
        if (this.p == null) goto L23;
        goto L23
    }

    public v(Context r3) {
        super(null, r3);
        this.m = new AtomicBoolean(false);
        this.n = false;
        this.o = false;
        this.p = null;
    }

    public final void B0(Fragment r2) {
        this.a = r2;
        h0();
        x0();
        u0();
        FolderSortStrategy r3 = this.c;
        if (r3 == null) goto L5;
        this.e.setSortStrategy(r3);
    L5:
        pd5.a.a(this);
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void c(String r2) {
        ((z0) this.g).delete(r2);
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void c4(ArrayList<Document> r4) {
        gd5.d r0 = this.l;
        if (r0 == null) goto L6;
        r0.getClass();
        tt5.a.h("RecentSyncManager", "setList()...size = " + hu5.a.c(r4));
        r0.b = r4;
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final void j0(FolderSortStrategy r3) {
        super.j0(r3);
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals("recent", r3.a) == false) goto L9;
        z0 r0 = (z0) this.g;
        r0.b = r0.e(r3);
        lc5.x.c().d = r3;
        return;
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void setUserVisibleHint(boolean r4) {
        gd5.d r0 = this.l;
        if (r0 == null) goto L12;
        tt5.a.h("RecentSyncManager", "setUserVisibleHint()...isVisibleToUser = " + r4);
        if (r4 == true) goto L7;
        r0.c = true;
        return;
    L7:
        if (r0.c == false) goto L9;
        r0.a();
    L9:
        r0.c = false;
        return;
    }

    public final ArrayList<Document> t0(List<u1> r11, String r12) {
        if (Y(r11) == false) goto L5;
        ArrayList<Document> r0 = u1.b(r11);
        tt5.a.h("RecentDocumentModel", "transformAndSort()...preFilter, inputSize = " + hu5.a.c(r11) + ", resultSize = " + hu5.a.c(r0) + ", sortStrategy = " + this.c + ", modelHash = " + System.identityHashCode(this));
    L20:
        tt5.a.h("RecentDocumentModel", "getListLiveData()...db callback, sourceType = " + r12 + ", inputSize = " + hu5.a.c(r11) + ", resultSize = " + hu5.a.c(r0) + ", officeFilterEnabled = " + this.n + ", officeFilterTabType = " + this.p + ", modelHash = " + System.identityHashCode(this));
        lc5.x.c().g("load_db_data", 0, hu5.a.c(r0));
        return r0;
    L5:
        ArrayList<Document> r1 = u1.b(r11);
        ArrayList<Document> r6 = zd5.c.a(this.c, r1);
        tt5.a.h("RecentDocumentModel", "transformAndSort()...after filter, inputSize = " + hu5.a.c(r11) + ", dbSize = " + hu5.a.c(r1) + ", filterSize = " + hu5.a.c(r6) + ", sortStrategy = " + this.c + ", modelHash = " + System.identityHashCode(this));
        if (hu5.a.d(r6) == false) goto L8;
        r0 = r6;
        goto L20
    L8:
        r0 = new ArrayList();
        ArrayList r5 = new ArrayList();
        ArrayList r7 = new ArrayList();
        Iterator<Document> r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L22;
        Document r9 = r8.next();
        if (r9.y2 == true) goto L13;
        r7.add(r9);
        goto L10
    L13:
        r5.add(r9);
        goto L10
    L22:
        Collections.sort(r5, new o());     // Catch: Exception -> L17
    L19:
        r0.addAll(r5);
        r0.addAll(r7);
    L17:
        e = move-exception;
        tt5.a.f("RecentDocumentModel", e, false);
        goto L19
    }

    public v(Fragment r1, Context r2, ce5.a r3) {
        super(r1, r2, r3);
        this.m = new AtomicBoolean(false);
        this.n = false;
        this.o = false;
        this.p = null;
        if (r1 == null) goto L6;
        B0(r1);
        return;
    }
}
