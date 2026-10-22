package a35;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.sync.OfflineDbConfig;
import com.bytedance.ee.bear.document.offline.sync.sync.SyncStatusModel;
import com.larksuite.framework.thread.CoreThreadPool;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y implements d0 {
    public static OfflineDbConfig w;
    public static volatile y x;
    public static final boolean y = false;
    public Context a;
    public final OfflineDoc b;
    public OfflineDoc c;
    public volatile boolean d;
    public final Handler e;
    public a0 f;
    public final List<OfflineDoc> g;
    public LiveData<List<String>> h;
    public final b0 i;
    public final List<String> j;
    public int k;
    public final List<com.bytedance.ee.bear.contract.n.e> l;
    public final List<com.bytedance.ee.bear.contract.n.a> m;
    public com.bytedance.ee.bear.contract.j n;
    public h0 o;
    public com.bytedance.ee.bear.contract.d p;
    public LiveData<ConnectionService.NetworkState> q;
    public boolean r;
    public boolean s;
    public final a t;
    public final b u;
    public final a35.a v;

    public class a implements Observer<List<String>> {
        public final /* synthetic */ y a;

        public a(y r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            final List r4 = (List) r3;
            Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).subscribe(new w(this, r4), new x());
        }
    }

    public class b implements Observer<ConnectionService.NetworkState> {
        public final /* synthetic */ y a;

        public b(y r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ConnectionService.NetworkState r4 = (ConnectionService.NetworkState) r3;
            tt5.a.b("SyncOfflineDataManager", "network changed!");
            this.a.r = r4.a();
            y r0 = this.a;
            if (r0.s == false) goto L5;
            y.c(r0);
        L5:
            this.a.s = !r4.a();
        }
    }

    static {
        w = new OfflineDbConfig();
        y = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.mobile.background.sync.opt");
    }

    public static y e() {
        if (x != null) goto L15;
        monitor-enter(y.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (x != null) goto L9;
        x = new y();     // Catch: Throwable -> L11
    L9:
        monitor-exit(y.class);     // Catch: Throwable -> L11
    L15:
        return x;
    }

    public final boolean f() {
        boolean r0 = this.g.isEmpty();
        if (r0 == true) goto L6;
        tt5.a.h("SyncOfflineDataManager", "hasSyncTask(): " + this.g.size());
    L6:
        return !r0;
    }

    public final void h() {
        a0 r0 = this.f;
        if (r0 == null) goto L6;
        r0.sendEmptyMessage(1);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [a35.a] */
    public y() {
        OfflineDoc r0 = new OfflineDoc();
        this.b = r0;
        this.c = r0;
        this.e = new Handler(Looper.getMainLooper());
        this.g = Collections.synchronizedList(new LinkedList());
        this.i = new b0();
        this.j = new CopyOnWriteArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.s = true;
        this.t = new a(this);
        this.u = new b(this);
        this.v = new a35.a(this);
        this.a = eu5.b.a;
        com.bytedance.ee.bear.contract.j r1 = com.bytedance.ee.bear.contract.j.a.a;
        this.n = r1;
        this.q = r1.a();
        this.p = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        this.f = new a0(this, CoreThreadPool.getBackgroundHandler().getLooper());
        h0 r2 = (h0) org.koin.java.a.a(h0.class);
        this.o = r2;
        r2.Pe(new p(this));
        com.bytedance.ee.util.ui.m.a(new q(this));
        OfflineDbConfig r3 = (OfflineDbConfig) com.bytedance.ee.bear.appsetting.c.a.a.c("offline_db_config", OfflineDbConfig.class, new OfflineDbConfig());
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.offline_db_size <= 0) goto L9;
        w = r3;
        tt5.a.h("SyncOfflineDataManager", "OfflineDbConfig " + w);
        return;
    }

    public static void c(final y r2) {
        if (r2.r == false) goto L6;
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new s()).subscribe(new t(r2), new u());
        return;
    }

    @Override // a35.d0
    public final void a(SyncStatusModel r9) {
        if (r9 != null) goto L7;
        tt5.a.b("SyncOfflineDataManager", "sync status data is empty -- ignore");
        return;
    L7:
        if (TextUtils.equals(r9.objToken, this.c.getObj_token()) == false) goto L9;
    L12:
        com.bytedance.apm.util.n<Boolean, Integer> r1 = this.i.b(this.c);
        tt5.a.h("SyncOfflineDataManager", "notifySyncStatus    FEdata.status: " + r9.status + "    FEdata.objToken: " + du5.b.e(r9.objToken) + "    mCurrentOpenDoc.token: " + du5.b.e(this.c.getObj_token()) + "    mRetryTime: " + r1.b + "    code: " + r9.code);
        int r2 = r9.status;
        if (r2 != 0) goto L16;
        c0.a(this.p, this.c, ((Integer) r1.b).intValue(), 0);
        this.i.f(this.c.getObj_token());
        this.e.removeCallbacks(this.v);
        g(3);
        OfflineDoc r10 = this.c;
        this.c = this.b;
        this.g.remove(r10);
        this.d = false;
        h();
        return;
    L16:
        if (r2 == 1) goto L18;
        if (r2 == 2) goto L38;
        if (r2 != 3) goto L37;
        g(2);
        return;
    L37:
        return;
    L38:
        return;
    L18:
        if (TextUtils.equals(d25.d.d, r9.objToken) == false) goto L20;
    L21:
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).l(r9.code, null);
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).h(r9.code, null, false);
    L22:
        c0.a(this.p, this.c, ((Integer) r1.b).intValue(), 1);
        this.e.removeCallbacks(this.v);
        if (((Boolean) r1.a).booleanValue() == false) goto L25;
        tt5.a.b("SyncOfflineDataManager", "doc :" + du5.b.e(this.c.getObj_token()) + " able to retry");
        this.i.a(this.c);
        g(1);
    L26:
        OfflineDoc r11 = this.c;
        this.c = this.b;
        this.g.remove(r11);
        this.d = false;
        h();
        if (this.f.hasMessages(2) == true) goto L35;
        this.f.sendEmptyMessageDelayed(2, 60000);
        return;
    L35:
        return;
    L25:
        tt5.a.b("SyncOfflineDataManager", "doc :" + du5.b.e(this.c.getObj_token()) + " exceed retry limit, mark failed");
        g(4);
        goto L26
    L20:
        if (TextUtils.equals(d25.d.e, r9.objToken) == false) goto L22;
    L9:
        if (r9.status != 0) goto L12;
        this.i.f(r9.objToken);
    }

    public final Flowable<Long> d(final long r3) {
        return Flowable.just("").observeOn(fo5.d.b()).map(new l(this, r3)).doOnError(new o());
    }

    public final void g(int r4) {
        tt5.a.h("SyncOfflineDataManager", "notifySyncStateChanged... status = " + r4);
        OfflineDoc r0 = this.c;
        if (r0 != this.b) goto L6;
        tt5.a.h("SyncOfflineDataManager", "notifySyncStateChanged: mCurrentOpenDoc == EMPTY_OFFLINE_DOC");
        return;
    L6:
        r0.setSyncState(r4);
        List<com.bytedance.ee.bear.contract.n.a> r5 = this.m;
        if (r5 == null) goto L14;
        Iterator r6 = new ArrayList(r5).iterator();
    L10:
        if (r6.hasNext() == false) goto L20;
        com.bytedance.ee.bear.contract.n.a r1 = (com.bytedance.ee.bear.contract.n.a) r6.next();
        if (r1 == null) goto L10;
        r1.a(this.c);
        goto L10
    L20:
        return;
    }

    public final void i(List<OfflineDoc> r3) {
        tt5.a.h("SyncOfflineDataManager", "uploadDocs... raw docList size: " + r3.size());
        Flowable.fromIterable(r3).subscribeOn(fo5.d.a()).filter(new e(this)).collect(new f(this), new g(this)).subscribe(new h(this), new i());
    }

    public static void b(final y r3, String r4, List r5, final OfflineDoc r6) {
        r3.getClass();
        if (r6 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r4, r6.getObj_token()) == false) goto L9;
        tt5.a.k("SyncOfflineDataManager", "beginSync() equals with foreground webview mCurrentToken " + du5.b.g(r6.getObj_token()));
        r3.i.f(r6.getObj_token());
        r3.g.remove(r6);
        r3.h();
        return;
    L9:
        if (y == false) goto L16;
        if (hu5.a.f(r5) == false) goto L16;
        if (((CopyOnWriteArrayList) r5).contains(r6.getObj_token()) == false) goto L16;
        tt5.a.k("SyncOfflineDataManager", "beginSync() equals with foreground webview  v2 mCurrentToken " + du5.b.g(r6.getObj_token()));
        r3.i.f(r6.getObj_token());
        r3.g.remove(r6);
        r3.h();
        return;
    L16:
        if (((CopyOnWriteArrayList) r3.j).contains(r6.getObj_token()) == true) goto L18;
        tt5.a.k("SyncOfflineDataManager", "beginSync() mNeedSyncTokens not contain mCurrentToken " + du5.b.g(r6.getObj_token()));
        r3.g.remove(r6);
        r3.h();
        return;
    L18:
        final com.bytedance.apm.util.n<Boolean, Integer> r7 = r3.i.b(r6);
        if (((Boolean) r7.a).booleanValue() == true) goto L21;
        tt5.a.k("SyncOfflineDataManager", "beginSync() retry recorder rejects :" + du5.b.g(r6.getObj_token()));
        r3.g.remove(r6);
        r3.h();
        return;
    L21:
        r3.d = true;
        r3.c = r6;
        tt5.a.h("SyncOfflineDataManager", "startRnSync " + du5.b.g(r6.getObj_token()) + " : " + du5.b.g(r4));
        ((com.bytedance.ee.bear.rn.j) org.koin.java.a.a(com.bytedance.ee.bear.rn.j.class)).d(new n(r3, r6, r7)).subscribe(new k(), new m());
    }
}
