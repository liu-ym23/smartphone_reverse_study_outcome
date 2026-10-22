package r25;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.sync.i0;
import com.bytedance.ee.bear.document.offline.sync.j0;
import com.bytedance.ee.bear.document.offline.sync.l0;
import com.bytedance.ee.bear.document.offline.sync.o;
import com.bytedance.ee.bear.document.offline.sync.p;
import com.bytedance.ee.bear.document.offline.sync.q;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends j implements n.b {
    public static final Map<String, Long> j = null;
    public final BlockingQueue<OfflineDoc> d;
    public final BlockingQueue<OfflineDoc> e;
    public final Map<String, Long> f;
    public final boolean g;
    public q25.f h;
    public final Map<String, OfflineDoc> i;

    public class a implements p {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void a(String r2, long r3) {
            Map<String, Long> r0 = this.a.f;
            HashMap r1 = (HashMap) r0;
            r1.put(r2, Long.valueOf(r3));
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ e a;

        @Override // java.lang.Runnable
        public final void run() {
        L13:
            this.a.h();     // Catch: Throwable -> L4 Exception -> L6
            e r0 = this.a;     // Catch: Throwable -> L4 Exception -> L6
            e.j(r0, r0.d.take());     // Catch: Throwable -> L4 Exception -> L6
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        L6:
            e = move-exception;
            tt5.a.e("PreloadClientVarExecutor", "Consumer  e: ", e, false);     // Catch: Throwable -> L4
            goto L13
        }

        public b(e r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.contract.n.b
    public final void onPreloadStart(String r1) {
    }

    static {
        j = new ConcurrentHashMap();
    }

    public e() {
        int r0 = j0.a;
        if (t25.d.a() == false) goto L5;
        BlockingQueue<OfflineDoc> r1 = new PriorityBlockingQueue(11, i0.a);
    L6:
        this.d = r1;
        this.e = new LinkedBlockingQueue();
        this.f = new HashMap();
        this.g = w25.c.c();
        this.i = new ConcurrentHashMap();
        a r2 = new a(this);
        Iterator<q> r3 = ((com.bytedance.ee.bear.document.offline.sync.i) org.koin.java.a.a(com.bytedance.ee.bear.document.offline.sync.i.class)).a().values().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r3.next().j(r2);
        goto L8
    L10:
        return;
    L5:
        r1 = new LinkedBlockingQueue();
        goto L6
    }

    @Override // com.bytedance.ee.bear.contract.n.b
    public final void d(String r3) {
        if (((ConcurrentHashMap) this.i).containsKey(r3) == false) goto L6;
        k((OfflineDoc) ((ConcurrentHashMap) this.i).get(r3), 0);
        ((ConcurrentHashMap) this.i).remove(r3);
        return;
    }

    public final boolean l(OfflineDoc r11) {
        if (r11 != null) goto L6;
        tt5.a.k("PreloadClientVarExecutor", "The doc is null.");
        return false;
    L6:
        String r2 = r11.getObj_token();
        if (TextUtils.isEmpty(r2) == false) goto L10;
        tt5.a.k("PreloadClientVarExecutor", "The token is empty.");
        return false;
    L10:
        q r3 = l0.a(r11.getType());
        if (r3 != null) goto L14;
        tt5.a.h("PreloadClientVarExecutor", "This doc type has not preload strategy, doc type is " + r11.getType());
        return false;
    L14:
        r3.k();
        if (((HashMap) this.f).containsKey(r2) == false) goto L27;
        if ((System.currentTimeMillis() - ((Long) ((HashMap) this.f).get(r2)).longValue()) <= r3.a()) goto L19;
        boolean r4 = true;
    L20:
        r3.k();
        if (r4 == true) goto L27;
        if (r3.i() == false) goto L27;
        tt5.a.h("PreloadClientVarExecutor", du5.b.g(r11.getObj_token()) + " has memory cache, " + du5.b.g(r2));
        return false;
    L19:
        r4 = false;
    L27:
        if (r3.c(r11) == false) goto L30;
        tt5.a.h("PreloadClientVarExecutor", du5.b.g(r11.getObj_token()) + " need to preload.");
        return true;
    L30:
        tt5.a.h("PreloadClientVarExecutor", du5.b.g(r11.getObj_token()) + " not need to preload.");
        return false;
    }

    @Override // com.bytedance.ee.bear.contract.n.b
    public final void onPreloadFail(String r3) {
        if (((ConcurrentHashMap) this.i).containsKey(r3) == false) goto L6;
        k((OfflineDoc) ((ConcurrentHashMap) this.i).get(r3), -998);
        ((ConcurrentHashMap) this.i).remove(r3);
        return;
    }

    public static void j(e r7, OfflineDoc r8) {
        r7.getClass();
        q25.f r1 = r7.h;     // Catch: Exception -> L22
        if (r1 == null) goto L6;
        r1.c(r8);     // Catch: Exception -> L22
    L6:
        q r2 = l0.a(r8.getType());     // Catch: Exception -> L22
        if (r2 == null) goto L26;
        OfflineDoc r9 = r2.h(r8);     // Catch: Exception -> L22
        boolean r3 = r7.l(r9);     // Catch: Exception -> L22
        tt5.a.h("PreloadClientVarExecutor", du5.b.g(r9.getObj_token()) + " need to preload=" + r3);     // Catch: Exception -> L22
        if (r3 == false) goto L20;
        ((ConcurrentHashMap) j).put(r9.getObj_token(), Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L22
        if (r9.isOnlyPreLoadFeed() == false) goto L14;
        r7.k(r9, -999);     // Catch: Exception -> L22
        return;
    L14:
        if (r9.getType() == 16) goto L16;
    L18:
        OfflineDoc r4 = r9;
    L19:
        ((ConcurrentHashMap) r7.i).put(r4.getObj_token(), r4);     // Catch: Exception -> L22
        r2.b(r9, r7);     // Catch: Exception -> L22
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).g(r9.getObj_token(), r9.getType());     // Catch: Exception -> L22
        return;
    L16:
        if ((r2 instanceof o) == false) goto L18;
        r4 = ((o) r2).e(r9);     // Catch: Exception -> L22
        goto L19
    L20:
        r7.k(r9, -999);     // Catch: Exception -> L22
        return;
    L26:
        return;
    L22:
        e = move-exception;
        tt5.a.d("PreloadClientVarExecutor", "consume()... e = " + e);
        r7.k(r8, -998);
    }

    public final void k(OfflineDoc r2, int r3) {
        q25.f r0 = this.h;
        if (r0 == null) goto L9;
        if (r2 == null) goto L10;
        if (r3 != 0) goto L7;
        r0.a(r2);
        return;
    L7:
        r0.b(r2, r3);
        return;
    L10:
        return;
    }
}
