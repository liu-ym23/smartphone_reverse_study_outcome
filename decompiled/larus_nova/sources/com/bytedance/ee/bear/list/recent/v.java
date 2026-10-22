package com.bytedance.ee.bear.list.recent;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.bdlocation.exception.BDLocationException;
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

/* JADX INFO: loaded from: classes18.dex */
public final class v extends com.bytedance.ee.bear.list.list.a<z0> implements c, pd5.a.InterfaceC7184a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public gd5.d f229324l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f229325m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f229326n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f229327o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f229328p;

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
        if (DevicePerfManager.b.f432386a.f432372e.f20370h == false) goto L6;
        return BDLocationException.ERROR_SDK_NO_PERMISSION;
    L6:
        int r100 = -1;
        r100 = new JSONObject((String) com.bytedance.ee.bear.appsetting.c.a.f206237a.d("ccm_mobile_workspace_config", "")).optInt("workspace_fetch_size", -1);     // Catch: Throwable -> L13
    L8:
        if (r100 > 0) goto L10;
        return "100";
    L10:
        return String.valueOf(r100);
    }

    @Override // pd5.a.InterfaceC7184a
    public final void L2() {
        this.f229324l = new gd5.d(this, new u(this));
    }

    @Override // com.bytedance.ee.bear.list.list.a, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        tt5.a.h("RecentDocumentModel", "create()...");
        if (this.f229325m.get() == false) goto L6;
        tt5.a.h("RecentDocumentModel", "create()...already create, return...");
        return;
    L6:
        super.create();
        this.f229325m.compareAndSet(false, true);
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final Flowable<ArrayList<Document>> g() {
        return ((z0) this.f228532g).c();
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().c().f217118a == false) goto L6;
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
        gd5.d r100 = this.f229324l;
        if (r100 == null) goto L9;
        r100.getClass();
        tt5.a.h("RecentSyncManager", "onResume()...mIsHidden = " + r100.f480938c);
        if (r100.f480938c == false) goto L7;
        r100.a();
    L7:
        r100.f480938c = false;
        return;
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void onStop() {
        gd5.d r100 = this.f229324l;
        if (r100 == null) goto L6;
        r100.getClass();
        tt5.a.h("RecentSyncManager", "onStop()...");
        r100.f480938c = true;
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final mc5.k p() {
        return new z0(this.f228536k);
    }

    public final void u0() {
        if (this.f229326n == true) goto L5;
        return;
    L5:
        FolderSortStrategy r100 = this.f228528c;
        if (r100 == null) goto L8;
        int r101 = r100.f227684e;
    L9:
        int r102 = r101;
        FolderSortStrategy r103 = this.f228528c;
        if (r103 == null) goto L12;
        boolean r104 = r103.f227685f;
    L13:
        FilterType r105 = FilterType.ALL;
        int r106 = r105.getType();
        String r107 = r105.getFileType();
        String r108 = r105.getForbiddenFileType();
        this.f228528c = new FolderSortStrategy("recent", r106, r107, r108, r102, r104);
        return;
    L12:
        r104 = RecentSort.OPENED.getAsc();
        goto L13
    L8:
        r101 = RecentSort.OPENED.getRank();
        goto L9
    }

    public final void x0() {
        if (this.f229326n == true) goto L5;
        return;
    L5:
        if (this.f229327o == true) goto L14;
        Fragment r100 = this.f228526a;
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.getActivity() == null) goto L16;
        this.f229327o = true;
        ((OfficeRecentFilterViewModel) new ViewModelProvider(this.f228526a.getActivity()).get(OfficeRecentFilterViewModel.class)).getTabTypeLiveData().observe(this.f228526a, new m(this));
        return;
    L16:
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final LiveData<ArrayList<Document>> X() {
        lc5.x.c().a("load_db_data");
        final mc5.j r100 = (mc5.j) this.f228536k.a(mc5.j.class);
        if (AppInfoUtils.f().booleanValue() == false) goto L5;
        final LiveData r101 = r100.Fb();
        final MediatorLiveData r102 = new MediatorLiveData();
        tt5.a.h("RecentDocumentModel", "getListLiveData()...office initial source created, limit = 20, sourceHash = " + System.identityHashCode(r101) + ", modelHash = " + System.identityHashCode(this));
        r102.addSource(r101, new l(this, r102, r101, r100));
        return r102;
    L5:
        return Transformations.map(r100.c7(1), new j(this));
    }

    @Override // com.bytedance.ee.bear.list.list.a, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        gd5.d r100 = this.f229324l;
        if (r100 == null) goto L10;
        tt5.a.h("RecentSyncManager", "onDestroy()...");
        Disposable r101 = r100.f480939d;
        if (r101 != null) goto L7;
    L9:
        this.f229324l = null;
        goto L10
    L7:
        if (r101.isDisposed() == true) goto L9;
        r100.f480939d.dispose();
    L10:
        ((z0) this.f228532g).f229336c.clear();
        pd5.a.c(this);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final NetService.f h() {
        u0();
        NetService.f r100 = super.h();
        boolean r101 = true;
        r100.b("type_opt", String.valueOf(1));
        if (TextUtils.equals(r100.f216905b, "/api/explorer/recent/list/") == false) goto L16;
        if (AppInfoUtils.f().booleanValue() == false) goto L8;
        u3.a(r100);
    L8:
        if (this.f229326n == true) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L16;
        r100.b("tab_type", String.valueOf(this.f229328p));
        goto L16
    L10:
        if (this.f229328p == null) goto L12;
        r102 = true;
    L16:
        if (TextUtils.equals(k(), "/api/explorer/recent/list/") == false) goto L18;
        v3.a(r100);
    L18:
        StringBuilder r103 = new StringBuilder("buildRefreshRequest()...officeFilterEnabled = ");
        r103.append(this.f229326n);
        r103.append(", officeFilterTabType = ");
        r103.append(this.f229328p);
        r103.append(", hasOfficeRecentFilterTabType = ");
        if (this.f229326n == true) goto L21;
    L23:
        r101 = false;
    L24:
        r103.append(r101);
        r103.append(", isOfficeSDK = ");
        r103.append(AppInfoUtils.f());
        r103.append(", sortStrategy = ");
        r103.append(this.f228528c);
        r103.append(", modelHash = ");
        r103.append(System.identityHashCode(this));
        tt5.a.h("RecentDocumentModel", r103.toString());
        return r100;
    L21:
        if (this.f229328p == null) goto L23;
        goto L23
    }

    public v(Context r100) {
        super(null, r100);
        this.f229325m = new AtomicBoolean(false);
        this.f229326n = false;
        this.f229327o = false;
        this.f229328p = null;
    }

    public final void B0(Fragment r100) {
        this.f228526a = r100;
        h0();
        x0();
        u0();
        FolderSortStrategy r101 = this.f228528c;
        if (r101 == null) goto L5;
        this.f228530e.setSortStrategy(r101);
    L5:
        pd5.a.a(this);
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void c(String r100) {
        ((z0) this.f228532g).delete(r100);
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void c4(ArrayList<Document> r100) {
        gd5.d r101 = this.f229324l;
        if (r101 == null) goto L6;
        r101.getClass();
        tt5.a.h("RecentSyncManager", "setList()...size = " + hu5.a.c(r100));
        r101.f480937b = r100;
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final void j0(FolderSortStrategy r100) {
        super.j0(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals("recent", r100.f227680a) == false) goto L9;
        z0 r101 = (z0) this.f228532g;
        r101.f229335b = r101.e(r100);
        lc5.x.c().f508600d = r100;
        return;
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void setUserVisibleHint(boolean r100) {
        gd5.d r101 = this.f229324l;
        if (r101 == null) goto L12;
        tt5.a.h("RecentSyncManager", "setUserVisibleHint()...isVisibleToUser = " + r100);
        if (r100 == true) goto L7;
        r101.f480938c = true;
        return;
    L7:
        if (r101.f480938c == false) goto L9;
        r101.a();
    L9:
        r101.f480938c = false;
        return;
    }

    public final ArrayList<Document> t0(List<u1> r110, String r111) {
        if (Y(r110) == false) goto L5;
        ArrayList<Document> r100 = u1.b(r110);
        tt5.a.h("RecentDocumentModel", "transformAndSort()...preFilter, inputSize = " + hu5.a.c(r110) + ", resultSize = " + hu5.a.c(r100) + ", sortStrategy = " + this.f228528c + ", modelHash = " + System.identityHashCode(this));
    L20:
        tt5.a.h("RecentDocumentModel", "getListLiveData()...db callback, sourceType = " + r111 + ", inputSize = " + hu5.a.c(r110) + ", resultSize = " + hu5.a.c(r100) + ", officeFilterEnabled = " + this.f229326n + ", officeFilterTabType = " + this.f229328p + ", modelHash = " + System.identityHashCode(this));
        lc5.x.c().g("load_db_data", 0, hu5.a.c(r100));
        return r100;
    L5:
        ArrayList<Document> r101 = u1.b(r110);
        ArrayList<Document> r102 = zd5.c.a(this.f228528c, r101);
        tt5.a.h("RecentDocumentModel", "transformAndSort()...after filter, inputSize = " + hu5.a.c(r110) + ", dbSize = " + hu5.a.c(r101) + ", filterSize = " + hu5.a.c(r102) + ", sortStrategy = " + this.f228528c + ", modelHash = " + System.identityHashCode(this));
        if (hu5.a.d(r102) == false) goto L8;
        r100 = r102;
        goto L20
    L8:
        r100 = new ArrayList();
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        Iterator<Document> r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L22;
        Document r106 = r105.next();
        if (r106.f227909y2 == true) goto L13;
        r104.add(r106);
        goto L10
    L13:
        r103.add(r106);
        goto L10
    L22:
        Collections.sort(r103, new o());     // Catch: Exception -> L17
    L19:
        r100.addAll(r103);
        r100.addAll(r104);
    L17:
        e = move-exception;
        tt5.a.f("RecentDocumentModel", e, false);
        goto L19
    }

    public v(Fragment r100, Context r101, ce5.a r102) {
        super(r100, r101, r102);
        this.f229325m = new AtomicBoolean(false);
        this.f229326n = false;
        this.f229327o = false;
        this.f229328p = null;
        if (r100 == null) goto L6;
        B0(r100);
        return;
    }
}
