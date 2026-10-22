package kd5;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.drive.DriveManualResponseEntity;
import com.bytedance.ee.bear.contract.offline.OfflineCacheConfig;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.offlinecache.UpdateStatusRequest;
import com.bytedance.ee.bear.list.offlinecache.UpdateStatusResponse;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c2 {
    public static final boolean w = false;
    public static final boolean x = false;
    public final AtomicBoolean a;
    public final AtomicBoolean b;
    public com.bytedance.ee.bear.contract.j c;
    public boolean d;
    public final CompositeDisposable e;
    public g2 f;
    public String g;
    public final List<Document> h;
    public final List<OfflineDoc> i;
    public final List<OfflineDoc> j;
    public final List<OfflineDoc> k;
    public final ConcurrentHashMap<String, String> l;
    public LiveData<ConnectionService.NetworkState> m;
    public final f n;
    public final c o;
    public final e p;
    public id5.m q;
    public final List<Document> r;
    public final OfflineCacheConfig s;
    public final boolean t;
    public boolean u;
    public final b v;

    public class a implements com.bytedance.ee.bear.h.a {
        public final /* synthetic */ Document a;
        public final /* synthetic */ com.bytedance.ee.bear.contract.j0 b;
        public final /* synthetic */ c2 c;

        public final void a(final DriveManualResponseEntity r4) {
            if (r4.a != 1) goto L8;
            Document r0 = this.a;
            r0.Z = String.valueOf(r4.g);
            final com.bytedance.ee.bear.contract.j0 r1 = this.b;
            if (r1.f != null) goto L7;
            return;
        L7:
            final Document r2 = this.a;
            com.bytedance.ee.util.ui.m.a(new a2(this, r1, r2, r4));
            return;
        L8:
            c2.b(this.c, this.b, r4);
        }

        public a(c2 r1, Document r2, com.bytedance.ee.bear.contract.j0 r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ c2 a;

        @Override // java.lang.Runnable
        public final void run() {
            Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).subscribe(new h2(this), new i2());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(c2 r1) {
            this.a = r1;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ c2 a;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("OfflineCacheManager", "BackgroundSleepRunnable()...");     // Catch: Throwable -> L4
            this.a.b.compareAndSet(false, true);     // Catch: Throwable -> L4
            c2 r0 = this.a;     // Catch: Throwable -> L4
            r0.t(r0.k, false);     // Catch: Throwable -> L4
            c2.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(c2 r1) {
            this.a = r1;
        }
    }

    public static class d implements NetService.c<Result<String>> {
        public d() {
        }

        public final Result<String> parse(String r5) {
            Result<String> r0 = new Result();
            JSONObject r1 = new JSONObject(r5);     // Catch: Exception -> L10
            r0.code = JSONObjectProtectorUtils.getInt(r1, "code");     // Catch: Exception -> L10
            JSONObject r6 = r1.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L10
            if (r0.code != 0) goto L12;
            if (r6 == null) goto L12;
            JSONObject r7 = r6.optJSONObject("offline_status");     // Catch: Exception -> L10
            if (r7 == null) goto L12;
            r0.data = r7.toString();     // Catch: Exception -> L10
        L12:
            return r0;
        L10:
            e = move-exception;
            tt5.a.e("OfflineCacheManager", "parse: ", e, false);
            goto L12
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ c2 a;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("OfflineCacheManager", "JobRunnable()...");     // Catch: Throwable -> L4
            c2 r0 = this.a;     // Catch: Throwable -> L4
            r0.t(r0.i, true);     // Catch: Throwable -> L4
            c2 r1 = this.a;     // Catch: Throwable -> L4
            r1.t(r1.j, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(c2 r1) {
            this.a = r1;
        }
    }

    public class f implements Observer<ConnectionService.NetworkState> {
        public final /* synthetic */ c2 a;

        public f(c2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            ConnectionService.NetworkState r9 = (ConnectionService.NetworkState) r8;
            tt5.a.h("OfflineCacheManager", "on Network Changed...");
            boolean r0 = true;
            if (r9 != null) goto L5;
        L12:
            c2 r1 = this.a;
            if (r9 != null) goto L15;
        L18:
            r1.d = r0;
            return;
        L15:
            if (r9.a() == false) goto L18;
            r0 = false;
            goto L18
        L5:
            if (r9.a() == false) goto L12;
            if (this.a.a.compareAndSet(false, true) == false) goto L9;
            final c2 r3 = this.a;
            r3.getClass();
            tt5.a.h("OfflineCacheManager", "registerListeners()...");
            Disposable r4 = Flowable.just("").subscribeOn(fo5.d.b()).map(new e0()).map(new f0(r3)).subscribe(new h0(), new i0());
            r3.e.add(r4);
            Disposable r5 = Flowable.just("").subscribeOn(fo5.d.b()).map(new n()).map(new o(r3)).subscribe(new p(), new q());
            r3.e.add(r5);
            Disposable r2 = Flowable.just("").subscribeOn(fo5.d.b()).map(new k()).map(new v(r3)).subscribe(new g0(), new r0());
            r3.e.add(r2);
        L9:
            c2 r6 = this.a;
            com.bytedance.ee.util.ui.m.e(r6.p);
            com.bytedance.ee.util.ui.m.b(r6.p, 0);
            c2 r7 = this.a;
            if (r7.d == false) goto L12;
            r7.q(r9.c());
            this.a.o();
            goto L12
        }
    }

    public static class g implements com.bytedance.ee.bear.contract.n.c {
        public final WeakReference<c2> a;

        public final void a() {
            c2 r0 = this.a.get();
            if (r0 == null) goto L5;
            tt5.a.h("OfflineCacheManager", " registerRNConnectCallback()...connected");
            com.bytedance.ee.util.ui.m.e(r0.p);
            com.bytedance.ee.util.ui.m.b(r0.p, 0);
            return;
        L5:
            tt5.a.k("OfflineCacheManager", "connected: manualOfflineManager is null");
        }

        public final void disconnect() {
            tt5.a.h("OfflineCacheManager", "registerRNConnectCallback()...disconnect");
        }

        public g(c2 r2) {
            this.a = new WeakReference(r2);
        }
    }

    public static class h implements NetService.c<Result<UpdateStatusResponse>> {
        public h() {
        }

        public final Result<UpdateStatusResponse> parse(String r5) {
            Result<UpdateStatusResponse> r0 = new Result();
            JSONObject r1 = new JSONObject(r5);     // Catch: Exception -> L8
            r0.code = JSONObjectProtectorUtils.getInt(r1, "code");     // Catch: Exception -> L8
            JSONObject r6 = r1.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L8
            if (r0.code != 0) goto L10;
            if (r6 == null) goto L10;
            r0.data = (Serializable) new Gson().fromJson(r6.toString(), UpdateStatusResponse.class);     // Catch: Exception -> L8
        L10:
            return r0;
        L8:
            e = move-exception;
            tt5.a.e("OfflineCacheManager", "parse: ", e, false);
            goto L10
        }
    }

    static {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        w = r0.h("ccm.mobile.offline_list_sync_enabled");
        x = r0.h("ccm.mobile.docx.enable_offline_preload_subblocks_opt");
    }

    public final void c() {
        tt5.a.h("OfflineCacheManager", "checkManualOfflineCache()... = ");
        Disposable r0 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new q0(this)).observeOn(fo5.d.d()).subscribe(new s0(this), new t0());
        this.e.add(r0);
    }

    public final void d() {
        tt5.a.h("OfflineCacheManager", "doPreloadManualOfflineList()...preloadManualOfflineList = " + this.u);
        if (this.u == false) goto L5;
        return;
    L5:
        this.u = true;
        if (this.q != null) goto L8;
        id5.m r0 = new id5.m(LarkContext.getApplication());
        this.q = r0;
        r0.create();
    L8:
        final id5.m r1 = this.q;
        this.e.add(r1.w().a(r1.h()).observeOn(fo5.d.b()).flatMap(new id5.k(r1)).subscribe(new l1(this), new m1()));
    }

    public final void g() {
        tt5.a.h("OfflineCacheManager", "initData()...");
        Disposable r0 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new r(this)).observeOn(fo5.d.d()).subscribe(new s(this), new t());
        this.e.add(r0);
    }

    public final ArrayList<Document> i() {
        if (w == false) goto L7;
        return mc5.u1.b(mc5.m.a(this).bb());
    L7:
        return mc5.u1.b(mc5.m.a(this).Nc());
    }

    public final void o() {
        StringBuilder r0 = new StringBuilder("preloadManualOfflineList()...sManualOfflineStatus = ");
        boolean r1 = w;
        r0.append(r1);
        tt5.a.h("OfflineCacheManager", r0.toString());
        if (r1 == false) goto L6;
        Disposable r2 = Flowable.just("").observeOn(fo5.d.c()).subscribe(new c0(this), new d0());
        this.e.add(r2);
        return;
    }

    public c2() {
        this.a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.e = new CompositeDisposable();
        this.h = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.k = new CopyOnWriteArrayList();
        this.l = new ConcurrentHashMap();
        this.n = new f(this);
        this.o = new c(this);
        this.p = new e(this);
        this.r = new CopyOnWriteArrayList();
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.s = r0.c("offline_cache_config", OfflineCacheConfig.class, new OfflineCacheConfig());
        this.t = r0.h("ccm.mobile.docx.offline_preload_subblocks_enable");
        this.u = false;
        this.v = new b(this);
    }

    public static void a(c2 r2) {
        r2.getClass();
        tt5.a.h("OfflineCacheManager", "clear()...");
        com.bytedance.ee.util.ui.m.e(r2.p);
        com.bytedance.ee.util.ui.m.e(r2.v);
        ((CopyOnWriteArrayList) r2.h).clear();
        ((CopyOnWriteArrayList) r2.i).clear();
        ((CopyOnWriteArrayList) r2.j).clear();
        ((CopyOnWriteArrayList) r2.k).clear();
        r2.e.clear();
        ((CopyOnWriteArrayList) r2.r).clear();
        r2.q = null;
    }

    public final void k(Document r8) {
        if (r8.getType() != 16) goto L5;
        String r0 = r8.G1;
    L7:
        if (r8.getType() != 16) goto L9;
        int r9 = r8.y1;
    L10:
        int r2 = 0;
    L12:
        if (r2 >= ((CopyOnWriteArrayList) this.h).size()) goto L20;
        if (TextUtils.equals(((Document) ListProtector.get(this.h, r2)).d, r0) == true) goto L19;
        if (TextUtils.equals(((Document) ListProtector.get(this.h, r2)).G1, r0) == true) goto L19;
        r2 = r2 + 1;
    L19:
        tt5.a.h("OfflineCacheManager", "onCancelManualOffline()...withWatchedIndex = " + r2);
    L21:
        if (r2 == (-1)) goto L23;
        ListProtector.remove(this.h, r2);
    L23:
        int r3 = 0;
    L25:
        if (r3 >= ((CopyOnWriteArrayList) this.i).size()) goto L30;
        if (TextUtils.equals(((OfflineDoc) ListProtector.get(this.i, r3)).getToken(), r0) == true) goto L28;
        r3 = r3 + 1;
        goto L25
    L28:
        tt5.a.h("OfflineCacheManager", "onCancelManualOffline()...needWatchedIndex = " + r3);
    L31:
        if (r3 == (-1)) goto L33;
        ListProtector.remove(this.i, r3);
    L33:
        int r4 = 0;
    L35:
        if (r4 >= ((CopyOnWriteArrayList) this.k).size()) goto L40;
        if (TextUtils.equals(((OfflineDoc) ListProtector.get(this.k, r4)).getToken(), r0) == true) goto L38;
        r4 = r4 + 1;
        goto L35
    L38:
        tt5.a.h("OfflineCacheManager", "onCancelManualOffline()...watchedSuccessIndex = " + r4);
    L41:
        if (r4 == (-1)) goto L43;
        ListProtector.remove(this.k, r4);
    L43:
        int r5 = 0;
    L45:
        if (r5 >= ((CopyOnWriteArrayList) this.j).size()) goto L50;
        if (TextUtils.equals(((OfflineDoc) ListProtector.get(this.j, r5)).getToken(), r0) == true) goto L48;
        r5 = r5 + 1;
        goto L45
    L48:
        boolean r6 = true;
    L51:
        if (r6 == false) goto L53;
        return;
    L53:
        if (lbb.a.a(r0) == true) goto L66;
        ((CopyOnWriteArrayList) this.j).add(new OfflineDoc(r0, r9));
        t(this.j, false);
        tt5.a.h("OfflineCacheManager", "onCancelManualOffline()...existUnWatchedList");
        return;
    L66:
        return;
    L50:
        r6 = false;
        goto L51
    L40:
        r4 = -1;
        goto L41
    L30:
        r3 = -1;
        goto L31
    L20:
        r2 = -1;
        goto L21
    L9:
        r9 = r8.getType();
        goto L10
    L5:
        r0 = r8.d;
        goto L7
    }

    public final void m(OfflineDoc r6) {
        int r1 = 0;
        int r2 = -1;
    L4:
        if (r1 >= ((CopyOnWriteArrayList) this.j).size()) goto L9;
        if (TextUtils.equals(r6.getToken(), ((OfflineDoc) ListProtector.get(this.j, r1)).getToken()) == false) goto L8;
        tt5.a.h("OfflineCacheManager", "onUnWatchedSuccess()...index = " + r1);
        r2 = r1;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 == (-1)) goto L15;
        ListProtector.remove(this.j, r2);
        return;
    }

    public final void n(OfflineDoc r6) {
        int r1 = 0;
        int r2 = -1;
    L4:
        if (r1 >= ((CopyOnWriteArrayList) this.i).size()) goto L9;
        if (TextUtils.equals(r6.getToken(), ((OfflineDoc) ListProtector.get(this.i, r1)).getToken()) == false) goto L8;
        tt5.a.h("OfflineCacheManager", "onWatchedSuccess()...index = " + r1);
        r2 = r1;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 == (-1)) goto L12;
        ListProtector.remove(this.i, r2);
    L12:
        if (((CopyOnWriteArrayList) this.k).contains(r6) == true) goto L18;
        ((CopyOnWriteArrayList) this.k).add(r6);
        return;
    }

    public final void p(Document r6) {
        tt5.a.h("OfflineCacheManager", "produce()...");
        Iterator r0 = ((CopyOnWriteArrayList) this.i).iterator();
    L3:
        boolean r2 = true;
        if (r0.hasNext() == false) goto L8;
        if (TextUtils.equals(((OfflineDoc) r0.next()).getToken(), r6.d) == false) goto L3;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L17:
        Iterator r3 = ((CopyOnWriteArrayList) this.h).iterator();
    L19:
        if (r3.hasNext() == false) goto L23;
        if (TextUtils.equals(((Document) r3.next()).d, r6.d) == false) goto L19;
    L24:
        if (r2 == false) goto L26;
        return;
    L26:
        if (r6.w == false) goto L28;
        int r4 = 7;
    L29:
        r6.v = r4;
        ((CopyOnWriteArrayList) this.h).add(r6);
        return;
    L28:
        r4 = 5;
        goto L29
    L23:
        r2 = false;
        goto L24
    L11:
        if (lbb.a.a(r6.d) == true) goto L17;
        if (16 != r6.getType()) goto L15;
        OfflineDoc r5 = new OfflineDoc(r6.G1, r6.y1);
        ((CopyOnWriteArrayList) this.i).add(r5);
        this.l.put(r6.G1, r6.d);
    L16:
        t(this.i, true);
        goto L17
    L15:
        OfflineDoc r7 = new OfflineDoc(r6.d, r6.getType());
        ((CopyOnWriteArrayList) this.i).add(r7);
        goto L16
    L8:
        r1 = false;
        goto L9
    }

    public final void q(final boolean r13) {
        tt5.a.h("OfflineCacheManager", "reManualOfflineDownload()...isWifi = " + r13 + "  mDocxBlockOptimize = " + x);
        Iterator r0 = ((CopyOnWriteArrayList) this.h).iterator();
    L4:
        if (r0.hasNext() == false) goto L24;
        final Document r1 = (Document) r0.next();
        if (r1.v == 7) goto L13;
        if (r1.w == false) goto L10;
        int r3 = 7;
    L11:
        r1.v = r3;
        goto L13
    L10:
        r3 = 5;
    L13:
        if (r1.v != 5) goto L19;
        if (r1.k0 == false) goto L17;
        if (r13 == false) goto L19;
    L17:
        f(new com.bytedance.ee.bear.contract.j0(false, false, "", false, r1, null), false, false, 0);
    L19:
        if (w == false) goto L4;
        if (r1.v != 7) goto L4;
        this.e.add(Flowable.just("").observeOn(fo5.d.c()).subscribe(new y1(this, r1), new z1()));
        goto L4
    L24:
        if (x == false) goto L34;
        this.e.add(Flowable.just("").observeOn(fo5.d.c()).subscribe(new l(this, r13), new m()));
        return;
    }

    public static void j(String r3, int r4) {
        tt5.a.h("OfflineCacheManager", "SpaceNotificationService notifyManualOffline Status, objToken:" + du5.b.i(r3) + ", newStatus:" + r4);
        Iterator<WeakReference<dd5.j1>> r0 = dd5.s1.a.a.i.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        WeakReference<dd5.j1> r1 = r0.next();
        if (r1 == null) goto L4;
        if (r1.get() == null) goto L4;
        r1.get().C6(r3, r4);
        goto L4
    }

    public final void l(JSONObject r3, final boolean r4) {
        final JSONArray r5 = r3.optJSONArray("tokens");
        if (r5 == null) goto L6;
        Disposable r6 = Flowable.just(r5).observeOn(fo5.d.b()).map(new e1(r5)).filter(new f1()).flatMap(new g1(this, r4)).subscribe(new h1(), new i1());
        this.e.add(r6);
        return;
    }

    public final void r(List r9, final a1 r10) {
        tt5.a.h("OfflineCacheManager", "updateManualOfflineStatus updateStatusList: " + r9);
        if (hu5.a.d(r9) == false) goto L7;
        if (r10 == null) goto L29;
        r10.invoke();
        return;
    L29:
        return;
    L7:
        NetService.f r0 = new NetService.f("/space/api/platform/offline_list/update");
        ((NetService.e) r0).c = 1;
        JSONObject r2 = new JSONObject();
        JSONArray r3 = new JSONArray();     // Catch: Exception -> L17
        Iterator r11 = ((ArrayList) r9).iterator();     // Catch: Exception -> L17
    L10:
        if (r11.hasNext() == false) goto L15;
        UpdateStatusRequest r4 = (UpdateStatusRequest) r11.next();     // Catch: Exception -> L17
        String r5 = r4.getToken();     // Catch: Exception -> L17
        Parcelable.Creator<Document> r6 = Document.CREATOR;     // Catch: Exception -> L17
        if (lbb.a.a(r5) == false) goto L13;
        tt5.a.h("OfflineCacheManager", "updateManualOfflineStatus has fake_token: ");     // Catch: Exception -> L17
        goto L10
    L13:
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L17
        r7.put(ResourceData.KEY_TOKEN, r4.getToken());     // Catch: Exception -> L17
        r7.put("obj_type", r4.getObjType());     // Catch: Exception -> L17
        r7.put("action", r4.getAction());     // Catch: Exception -> L17
        r3.put(r7);     // Catch: Exception -> L17
        goto L10
    L15:
        r2.put("obj_list", r3);     // Catch: Exception -> L17
    L19:
        ((NetService.e) r0).j = r2.toString();
        ((NetService) e0c.k.a(LarkContext.getApplication(), NetService.class)).Vc(new h()).a(r0).subscribe(new j1(this, r10), new k1(r10));
        return;
    L17:
        e = move-exception;
        tt5.a.f("OfflineCacheManager", e, false);
        goto L19
    }

    public final void s(Document r4, int r5) {
        r4.v = r5;
        Iterator r6 = ((CopyOnWriteArrayList) this.h).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Document r0 = (Document) r6.next();
        if (TextUtils.equals(r4.d, r0.d) == false) goto L4;
        r0.v = r4.v;
        goto L4
    }

    public final void t(final List<OfflineDoc> r3, final boolean r4) {
        tt5.a.h("OfflineCacheManager", "watchDocs()...watch = " + r4 + ", size = " + hu5.a.c(r3));
        if (this.c.getNetworkState().a() == true) goto L7;
        tt5.a.h("OfflineCacheManager", "watchDocs()...offline");
        return;
    L7:
        if (hu5.a.f(r3) == false) goto L9;
        this.e.add(Flowable.just("").subscribeOn(fo5.d.b()).map(new c1()).map(new n1(r4, r3)).subscribe(new w1(), new x1()));
        return;
    L9:
        tt5.a.h("OfflineCacheManager", "watchDocs()...list is empty");
    }

    public static void b(c2 r8, final com.bytedance.ee.bear.contract.j0 r9, final DriveManualResponseEntity r10) {
        r8.getClass();
        tt5.a.h("OfflineCacheManager", "updateDriveDownloadStatus()...status = " + r10.a);
        Document r3 = r9.e;
        int r0 = r10.a;
        int r1 = 5;
        if (r0 == 0) goto L23;
        if (r0 == 5) goto L16;
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L31;
        j(r3.d, 6);
        r8.s(r3, 6);
        return;
    L31:
        return;
    L12:
        if (r9.f == null) goto L14;
        com.bytedance.ee.util.ui.m.a(new v1(r9, r10));
    L14:
        r9.e.Z = String.valueOf(r10.g);
        r8.h(r3, r9.b, r9.d, r9.c, false);
        return;
    L16:
        if (r3.k0 == false) goto L19;
        mc5.m.a(r8).V9(r3.d);
    L19:
        if (16 != r3.getType()) goto L21;
        mc5.m.a(r8).B3(r3.d);
        mc5.m.a(r8).B3(r3.G1);
    L21:
        j(r3.d, 7);
        r8.s(r3, 7);
        return;
    L23:
        if (r10.e == 508) goto L26;
        r1 = 8;
    L26:
        j(r3.d, r1);
        r8.s(r3, r1);
    }

    public final void e(String r3, int r4, int r5) {
        if (w == true) goto L6;
        tt5.a.h("OfflineCacheManager", "doStatusManualOffline fg close ");
        return;
    L6:
        mc5.m.a(this).da(r3, r4, r5);
        if (this.c.getNetworkState().a() == false) goto L10;
        ArrayList r0 = new ArrayList();
        r0.add(new UpdateStatusRequest(r3, Integer.valueOf(r4), Integer.valueOf(r5)));
        r(r0, null);
        return;
    }

    public final void f(final com.bytedance.ee.bear.contract.j0 r10, boolean r11, final boolean r12, int r13) {
        Document r0 = r10.e;
        if (r0 != null) goto L6;
        tt5.a.k("OfflineCacheManager", "download()...module = " + r10.c + ", document = null");
        return;
    L6:
        tt5.a.h("OfflineCacheManager", "download()...module = " + r10.c + ", type = " + r0.getType());
        if (r0.getType() == 16) goto L9;
    L11:
        boolean r3 = false;
    L13:
        if (r0.getType() == sbb.e.l.b) goto L20;
        if (r3 == true) goto L20;
        tt5.a.h("OfflineCacheManager", "docsDownload()...module = " + r10.c + ", type = " + r10.e.getType());
        final Document r8 = r10.e;
        final OfflineDoc r5 = new OfflineDoc(r8.d, com.bytedance.ee.bear.list.t0.i(r8), r8.getType(), "tab_manual_offline");
        if (r11 == false) goto L19;
        r5.setTriggerTime(SystemClock.uptimeMillis());
    L19:
        r5.setDownloadStatus(r13);
        this.e.add(Flowable.just("").subscribeOn(fo5.d.b()).map(new w0()).map(new x0(this, r5, r12, r10, r8)).subscribe(new y0(), new z0()));
        return;
    L20:
        pw4.d r14 = new pw4.d();
        if (r3 == false) goto L23;
        String r15 = r0.G1;
    L24:
        r14.a = r15;
        r14.b = r0.p;
        Bundle r16 = new Bundle();
        r14.c = r16;
        r16.putString("module", r10.c);
        ((com.bytedance.ee.bear.h) org.koin.java.a.a(com.bytedance.ee.bear.h.class)).j3(r10.a, r14, new a(this, r0, r10));
        return;
    L23:
        r15 = r0.d;
        goto L24
    L9:
        if (r0.y1 != 12) goto L11;
        r3 = true;
        goto L13
    }

    public final void h(final Document r9, final boolean r10, final boolean r11, final String r12, boolean r13) {
        Disposable r14 = Flowable.just(r9).observeOn(fo5.d.b()).subscribe(new k0(this, r9, r11, r10, r12), new l0(r11, r10, r12, r9));
        this.e.add(r14);
        if (r13 == true) goto L5;
    L10:
        j(r9.d, 5);
        return;
    L5:
        if (r9.v != 7) goto L7;
    L8:
        j(r9.d, 7);
        return;
    L7:
        if (r9.w == false) goto L10;
        goto L8
    }
}
