package q4a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.util.AnimaXLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends PhantomReference<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue<Object> f531710c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f531711d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<a> f531712e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<a> f531713f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f531714g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f531715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f531716b;

    /* JADX INFO: renamed from: q4a.a$a, reason: collision with other inner class name */
    public static class C7280a extends PthreadThreadV2 {
        public C7280a() {
            super("CleanupReference");
        }

        public static void l() {
        L20:
            a r100 = (a) a.f531710c.remove();     // Catch: Exception -> L16
            Object r101 = a.f531711d;     // Catch: Exception -> L16
            monitor-enter(r101);     // Catch: Exception -> L16
        L5:
            if (r100.f531715a == true) goto L7;
            a.f531714g.offer(r100);     // Catch: Throwable -> L13
        L8:
            a r102 = (a) a.f531714g.poll();     // Catch: Throwable -> L13
            if (r102 == null) goto L11;
            r102.b(a.f531713f);     // Catch: Throwable -> L13
            goto L8
        L11:
            monitor-exit(r101);     // Catch: Throwable -> L13
            goto L20
        L7:
            Message.obtain(b.f531717a, 2, r100).sendToTarget();     // Catch: Throwable -> L13
            r101.wait(500);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;     // Catch: Exception -> L16
        L16:
            e = move-exception;
            AnimaXLog.a("CleanupReference", "Queue remove exception:" + e.toString());
            goto L20
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HandlerC7281a f531717a = null;

        /* JADX INFO: renamed from: q4a.a$b$a, reason: collision with other inner class name */
        public static class HandlerC7281a extends Handler {
            public HandlerC7281a(Looper r100) {
                super(r100);
            }

            @Override // android.os.Handler
            public final void handleMessage(Message r100) {
                a r101 = (a) r100.obj;
                int r102 = r100.what;
                if (r102 != 1) goto L5;
                ((HashSet) a.f531712e).add(r101);
            L9:
                Object r103 = a.f531711d;
                monitor-enter(r103);
            L23:
                a r104 = (a) a.f531710c.poll();     // Catch: Throwable -> L20
                if (r104 == null) goto L17;
                if (r104.f531715a == false) goto L15;
                r104.b(a.f531712e);     // Catch: Throwable -> L20
                goto L23
            L15:
                a.f531714g.offer(r104);     // Catch: Throwable -> L20
                goto L23
            L17:
                a.f531711d.notifyAll();     // Catch: Throwable -> L20
                monitor-exit(r103);     // Catch: Throwable -> L20
                return;
            L20:
                th = move-exception;
                throw th;
            L5:
                if (r102 == 2) goto L7;
                AnimaXLog.a("CleanupReference", String.format("Bad message=%d", new Object[]{Integer.valueOf(r102)}));
                goto L9
            L7:
                r101.b(a.f531712e);
                goto L9
            }
        }

        static {
            f531717a = new HandlerC7281a(Looper.getMainLooper());
        }
    }

    static {
        f531710c = new ReferenceQueue();
        f531711d = new Object();
        C7280a r100 = new C7280a();
        r100.setDaemon(true);
        ThreadMethodProxy.start(r100);
        f531712e = new HashSet();
        f531713f = ConcurrentHashMap.newKeySet();
        f531714g = new ConcurrentLinkedQueue();
    }

    public final void a(int r100) {
        Message r101 = Message.obtain(b.f531717a, r100, this);
        if (Looper.myLooper() != r101.getTarget().getLooper()) goto L5;
        r101.getTarget().handleMessage(r101);
        r101.recycle();
        return;
    L5:
        r101.sendToTarget();
    }

    public final void b(Set<a> r100) {
        if (r100.remove(this) == true) goto L5;
        return;
    L5:
        Runnable r101 = this.f531716b;
        this.f531716b = null;
        if (r101 == null) goto L8;
        r101.run();
    L8:
        clear();
    }

    public a(Object r100, Runnable r101) {
        super(r100, f531710c);
        this.f531716b = r101;
        this.f531715a = true;
        a(1);
    }
}
