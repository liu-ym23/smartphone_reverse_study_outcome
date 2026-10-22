package com.bytedance.ee.bear.bitable.homepage.list;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mc5.u1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class w extends com.bytedance.ee.bear.list.list.a<com.bytedance.ee.bear.list.recent.z0> implements com.bytedance.ee.bear.list.recent.c, pd5.a.InterfaceC7184a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public v0 f212862l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f212863m;

    @Override // com.bytedance.ee.bear.list.list.a
    public final String L() {
        return "recent";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "BitableRecentBaseModel";
    }

    public com.bytedance.ee.bear.list.recent.z0 t0() {
        throw null;
    }

    public int u0() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final Flowable<DocumentListInfo> C() {
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new o(this)).map(new p(this)).flatMap(new q(this)).doOnNext(new r()).doOnError(new s());
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
        this.f212862l = new v0(this, new u(this));
    }

    @Override // com.bytedance.ee.bear.list.list.a, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        tt5.a.h("BitableRecentBaseModel", "create()...");
        if (this.f212863m.get() == false) goto L6;
        tt5.a.h("BitableRecentBaseModel", "create()...already create, return...");
        return;
    L6:
        super.create();
        this.f212863m.compareAndSet(false, true);
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final Flowable<ArrayList<Document>> g() {
        return ((com.bytedance.ee.bear.list.recent.z0) this.f228532g).c();
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
        return new com.bytedance.ee.bear.list.recent.g();
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void onResume() {
        v0 r100 = this.f212862l;
        if (r100 == null) goto L9;
        r100.getClass();
        tt5.a.h("BitableRecentSyncManager", "onResume()...mIsHidden = " + r100.f212858c);
        if (r100.f212858c == false) goto L7;
        r100.a();
    L7:
        r100.f212858c = false;
        return;
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void onStop() {
        v0 r100 = this.f212862l;
        if (r100 == null) goto L6;
        r100.getClass();
        tt5.a.h("BitableRecentSyncManager", "onStop()...");
        r100.f212858c = true;
        return;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.ee.bear.bitable.homepage.list.m] */
    @Override // com.bytedance.ee.bear.list.list.e
    public LiveData<ArrayList<Document>> X() {
        lc5.x.c().a("load_db_data");
        LiveData<List<u1>> r100 = ((mc5.j) this.f228536k.a(mc5.j.class)).c7(u0());
        ?? r101 = new m(this);
        MediatorLiveData r102 = new MediatorLiveData();
        r102.addSource(r100, new v(r102, r101));
        return r102;
    }

    @Override // com.bytedance.ee.bear.list.list.a, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        v0 r100 = this.f212862l;
        if (r100 == null) goto L10;
        tt5.a.h("BitableRecentSyncManager", "onDestroy()...");
        Disposable r101 = r100.f212859d;
        if (r101 != null) goto L7;
    L9:
        this.f212862l = null;
        goto L10
    L7:
        if (r101.isDisposed() == true) goto L9;
        r100.f212859d.dispose();
    L10:
        ((com.bytedance.ee.bear.list.recent.z0) this.f228532g).f229336c.clear();
        pd5.a.c(this);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final NetService.f h() {
        NetService.f r100 = super.h();
        r100.b("type_opt", String.valueOf(1));
        return r100;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public /* bridge */ /* synthetic */ mc5.k p() {
        return t0();
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void c(String r100) {
        ((com.bytedance.ee.bear.list.recent.z0) this.f228532g).delete(r100);
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void c4(ArrayList<Document> r100) {
        v0 r101 = this.f212862l;
        if (r101 == null) goto L6;
        r101.getClass();
        tt5.a.h("BitableRecentSyncManager", "setList()...size = " + hu5.a.c(r100));
        r101.f212857b = r100;
        return;
    }

    @Override // com.bytedance.ee.bear.list.recent.c
    public final void setUserVisibleHint(boolean r100) {
        v0 r101 = this.f212862l;
        if (r101 == null) goto L12;
        tt5.a.h("BitableRecentSyncManager", "setUserVisibleHint()...isVisibleToUser = " + r100);
        if (r100 == true) goto L7;
        r101.f212858c = true;
        return;
    L7:
        if (r101.f212858c == false) goto L9;
        r101.a();
    L9:
        r101.f212858c = false;
        return;
    }

    public w(Fragment r100, Context r101) {
        super(r100, r101);
        this.f212863m = new AtomicBoolean(false);
        if (r100 == null) goto L9;
        this.f228526a = r100;
        h0();
        FolderSortStrategy r102 = this.f228528c;
        if (r102 == null) goto L7;
        this.f228530e.setSortStrategy(r102);
    L7:
        pd5.a.a(this);
        return;
    }
}
