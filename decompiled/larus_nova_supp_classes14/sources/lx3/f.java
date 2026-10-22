package lx3;

import android.os.Handler;
import android.os.Message;
import com.bytedance.applog.log.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final List<String> n = null;
    public boolean a;
    public volatile boolean b;
    public boolean c;
    public long d;
    public k e;
    public e f;
    public final d g;
    public final List<k> h;
    public boolean i;
    public volatile ow3.b j;
    public final com.bytedance.applog.b k;
    public final a l;
    public final b m;

    public class a implements Runnable {
        public final /* synthetic */ f a;

        public final void a() {
            n r0 = this.a.k.t0;
            List<String> r1 = f.n;
            StringBuilder r2 = new StringBuilder("[Task] closeCurrentSession currentSession is null : ");
            if (this.a.e != null) goto L5;
            boolean r3 = true;
        L6:
            r2.append(r3);
            r0.k(0, r1, r2.toString(), new Object[0]);
            f r4 = this.a;
            if (r4.e != null) goto L9;
            r4.k.t0.f(0, r1, "[Task] closeCurrentSession found that currentSession is null", new Object[0]);
            return;
        L9:
            if (r4.i == false) goto L11;
            r4.k.t0.k(0, r1, "[Task] is fired : so save session to Db", new Object[0]);
            f r5 = this.a;
            r5.g.c(r5.e);
        L12:
            f r6 = this.a;
            r6.e = null;
            r6.g.a();
            return;
        L11:
            r4.k.t0.k(0, r1, "[Task] is not fired : so save session in pendingSessions", new Object[0]);
            f r7 = this.a;
            List<k> r8 = r7.h;
            ArrayList r9 = (ArrayList) r8;
            r9.add(r7.e);
            goto L12
        L5:
            r3 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(f r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ f a;

        public final void a() {
            f r0 = this.a;
            r0.i = true;
            r0.k.t0.k(0, f.n, "[Task] fire pending Sessions", new Object[0]);
            Iterator r1 = new ArrayList(this.a.h).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            k r2 = (k) r1.next();
            this.a.g.c(r2);
            goto L4
        L6:
            ((ArrayList) this.a.h).clear();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(f r1) {
            this.a = r1;
        }
    }

    static {
        n = Collections.singletonList("TaskPresenter");
    }

    public final Handler b() {
        if (this.f != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f != null) goto L8;
        this.f = new e(this, l.d().getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f;
    }

    public static void a(f r2, String r3) {
        Handler r4 = r2.b();
        r4.removeMessages(1);
        r4.sendMessageDelayed(Message.obtain(r4, 1, r3), 5000);
    }

    public f(com.bytedance.applog.b r4, jx3.b r5, zw3.d r6) {
        this.a = false;
        this.b = false;
        this.c = true;
        this.d = System.currentTimeMillis();
        this.h = new ArrayList();
        this.i = false;
        this.l = new a(this);
        this.m = new b(this);
        this.k = r4;
        this.g = new d(r4, r5, r6);
    }
}
