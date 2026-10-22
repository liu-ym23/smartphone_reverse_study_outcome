package q25;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.q0;
import com.bytedance.ee.bear.document.offline.sync.i0;
import com.bytedance.ee.bear.document.offline.sync.j0;
import com.bytedance.ee.bear.document.offline.sync.o;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import r25.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends j implements e.a {
    public static final Map<String, Long> n = null;
    public final BlockingQueue<OfflineDoc> d;
    public CountDownLatch e;
    public OfflineDoc f;
    public final e g;
    public volatile boolean h;
    public final Map<String, AtomicInteger> i;
    public f j;
    public final boolean k;
    public final AtomicInteger l;
    public o m;

    public class a extends q0 {
        public final /* synthetic */ i a;

        @Override // com.bytedance.ee.bear.contract.q0, com.bytedance.ee.bear.contract.c0.d
        public final void g() {
            this.a.h = true;
        }

        @Override // com.bytedance.ee.bear.contract.q0, com.bytedance.ee.bear.contract.c0.d
        public final void h() {
            CountDownLatch r0 = this.a.e;
            if (r0 == null) goto L5;
            r0.countDown();
        L5:
            this.a.h = false;
        }

        public a(i r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ i a;

        /* JADX INFO: Infinite loop detected, blocks: 33, insns: 0 */
        public final void a() {
        L22:
            i r0 = this.a;     // Catch: Exception -> L20
            if (r0.h == true) goto L5;
        L7:
            this.a.h();     // Catch: Exception -> L20
            if (this.a.h == true) goto L9;
            i r1 = this.a;     // Catch: Exception -> L20
            i.j(r1, r1.d.take());     // Catch: Exception -> L20
            goto L22
        L9:
            this.a.l.decrementAndGet();     // Catch: Exception -> L20
            i r2 = this.a;     // Catch: Exception -> L20
            Iterator r3 = r2.d.iterator();     // Catch: Exception -> L20
        L11:
            if (r3.hasNext() == false) goto L15;
            OfflineDoc r4 = (OfflineDoc) r3.next();     // Catch: Exception -> L20
            if (r4.isCanPreloadIfFileOpen() == false) goto L11;
            r2.d.remove(r4);     // Catch: Exception -> L20
        L16:
            if (r4 == null) goto L22;
            i.j(this.a, r4);     // Catch: Exception -> L20
            goto L22
        L15:
            r4 = null;
            goto L16
        L5:
            if (r0.l.get() > 0) goto L7;
            CountDownLatch r5 = new CountDownLatch(1);     // Catch: Exception -> L20
            r0.e = r5;     // Catch: Exception -> L20
            r5.await();     // Catch: Exception -> L20
        L20:
            e = move-exception;
            tt5.a.d("PreloadHtmlCacheExecutor", "Consumer  e: " + e.getMessage());
            goto L22
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(i r1) {
            this.a = r1;
        }
    }

    static {
        n = new ConcurrentHashMap();
    }

    public i() {
        int r0 = j0.a;
        if (t25.d.a() == false) goto L5;
        BlockingQueue<OfflineDoc> r1 = new PriorityBlockingQueue(11, i0.a);
    L6:
        this.d = r1;
        this.e = new CountDownLatch(1);
        this.h = false;
        this.i = new ConcurrentHashMap();
        this.k = w25.c.c();
        this.l = new AtomicInteger(0);
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).w(new a(this));
        this.g = new e();
        return;
    L5:
        r1 = new LinkedBlockingQueue();
        goto L6
    }

    public static void j(i r4, OfflineDoc r5) {
        r4.getClass();
        tt5.a.k("PreloadHtmlCacheExecutor", "consume " + du5.b.k(r5.getObj_token()) + "from:" + r5.getFrom_source() + " subFrom: " + r5.getSubFrom());
        if (r4.h == true) goto L5;
    L7:
        f r0 = r4.j;
        if (r0 == null) goto L10;
        r0.c(r5);
    L10:
        ((ConcurrentHashMap) n).put(r5.getObj_token(), Long.valueOf(System.currentTimeMillis()));
        r4.f = r5;
        r4.g.b(r5, r4);
        return;
    L5:
        if (r5.isCanPreloadIfFileOpen() == true) goto L7;
    }

    @Override // q25.e.a
    public final void f(int r2, OfflineDoc r3) {
        f r0 = this.j;
        if (r0 == null) goto L8;
        if (r2 != 0) goto L6;
        r0.a(r3);
        return;
    L6:
        r0.b(r3, r2);
        return;
    }

    @Override // q25.e.a
    public final void g(int r2, OfflineDoc r3) {
        f r0 = this.j;
        if (r0 == null) goto L8;
        if (r2 != 0) goto L6;
        r0.a(r3);
        return;
    L6:
        r0.b(r3, r2);
        return;
    }

    @Override // q25.e.a
    public final void b(int r1, Throwable r2, OfflineDoc r3) {
        f r4 = this.j;
        if (r4 == null) goto L8;
        if (r1 != 0) goto L6;
        r4.a(r3);
        return;
    L6:
        r4.b(r3, r1);
        return;
    }
}
