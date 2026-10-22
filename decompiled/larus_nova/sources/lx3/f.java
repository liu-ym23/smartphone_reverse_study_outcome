package lx3;

import android.os.Handler;
import android.os.Message;
import com.bytedance.applog.log.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final List<String> f511129n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f511130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f511131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f511132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f511133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f511134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f511135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f511136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<k> f511137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f511138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile ow3.b f511139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.applog.b f511140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f511141l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f511142m;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f511143a;

        public final void a() {
            n r100 = this.f511143a.f511140k.f192434t0;
            List<String> r101 = f.f511129n;
            StringBuilder r102 = new StringBuilder("[Task] closeCurrentSession currentSession is null : ");
            if (this.f511143a.f511134e != null) goto L5;
            boolean r103 = true;
        L6:
            r102.append(r103);
            r100.k(0, r101, r102.toString(), new Object[0]);
            f r104 = this.f511143a;
            if (r104.f511134e != null) goto L9;
            r104.f511140k.f192434t0.f(0, r101, "[Task] closeCurrentSession found that currentSession is null", new Object[0]);
            return;
        L9:
            if (r104.f511138i == false) goto L11;
            r104.f511140k.f192434t0.k(0, r101, "[Task] is fired : so save session to Db", new Object[0]);
            f r105 = this.f511143a;
            r105.f511136g.c(r105.f511134e);
        L12:
            f r106 = this.f511143a;
            r106.f511134e = null;
            r106.f511136g.a();
            return;
        L11:
            r104.f511140k.f192434t0.k(0, r101, "[Task] is not fired : so save session in pendingSessions", new Object[0]);
            f r107 = this.f511143a;
            List<k> r108 = r107.f511137h;
            ArrayList r109 = (ArrayList) r108;
            r109.add(r107.f511134e);
            goto L12
        L5:
            r103 = false;
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

        public a(f r100) {
            this.f511143a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f511144a;

        public final void a() {
            f r100 = this.f511144a;
            r100.f511138i = true;
            r100.f511140k.f192434t0.k(0, f.f511129n, "[Task] fire pending Sessions", new Object[0]);
            Iterator r101 = new ArrayList(this.f511144a.f511137h).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            k r102 = (k) r101.next();
            this.f511144a.f511136g.c(r102);
            goto L4
        L6:
            ((ArrayList) this.f511144a.f511137h).clear();
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

        public b(f r100) {
            this.f511144a = r100;
        }
    }

    static {
        f511129n = Collections.singletonList("TaskPresenter");
    }

    public final Handler b() {
        if (this.f511135f != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f511135f != null) goto L8;
        this.f511135f = new e(this, l.d().getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f511135f;
    }

    public static void a(f r100, String r101) {
        Handler r102 = r100.b();
        r102.removeMessages(1);
        r102.sendMessageDelayed(Message.obtain(r102, 1, r101), 5000);
    }

    public f(com.bytedance.applog.b r100, jx3.b r101, zw3.d r102) {
        this.f511130a = false;
        this.f511131b = false;
        this.f511132c = true;
        this.f511133d = System.currentTimeMillis();
        this.f511137h = new ArrayList();
        this.f511138i = false;
        this.f511141l = new a(this);
        this.f511142m = new b(this);
        this.f511140k = r100;
        this.f511136g = new d(r100, r101, r102);
    }
}
