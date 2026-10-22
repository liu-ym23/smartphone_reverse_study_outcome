package com.bytedance.lynx.webview.adblock;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class e extends WeakReference<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReferenceQueue<Object> f265066b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f265067c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<e> f265068d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f265069a;

    public class a extends PthreadThreadV2 {
        public a() {
            super("TTCleanupReference");
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
        L18:
            e r100 = (e) e.f265066b.remove();     // Catch: Exception -> L15 Throwable -> L10
            Object r101 = e.f265067c;     // Catch: Exception -> L15 Throwable -> L10
            monitor-enter(r101);     // Catch: Exception -> L15 Throwable -> L10
            Message.obtain(b.f265070a, 2, r100).sendToTarget();     // Catch: Throwable -> L7
            r101.wait(500);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;     // Catch: Exception -> L15 Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f265070a = null;

        public class a extends Handler {
            public a(Looper r100) {
                super(r100);
            }

            @Override // android.os.Handler
            public final void handleMessage(Message r100) {
                e r101 = (e) r100.obj;
                int r102 = r100.what;
                if (r102 != 1) goto L5;
                ((HashSet) e.f265068d).add(r101);
            L12:
                Object r103 = e.f265067c;
                monitor-enter(r103);
            L26:
                e r104 = (e) e.f265066b.poll();     // Catch: Throwable -> L23
                if (r104 == null) goto L20;
                ((HashSet) e.f265068d).remove(r104);     // Catch: Throwable -> L23
                Runnable r105 = r104.f265069a;     // Catch: Throwable -> L23
                r104.f265069a = null;     // Catch: Throwable -> L23
                if (r105 == null) goto L19;
                r105.run();     // Catch: Throwable -> L23
            L19:
                r104.clear();     // Catch: Throwable -> L23
                goto L26
            L20:
                e.f265067c.notifyAll();     // Catch: Throwable -> L23
                monitor-exit(r103);     // Catch: Throwable -> L23
                return;
            L23:
                th = move-exception;
                throw th;
            L5:
                if (r102 != 2) goto L12;
                ReferenceQueue<Object> r106 = e.f265066b;
                r101.getClass();
                ((HashSet) e.f265068d).remove(r101);
                Runnable r107 = r101.f265069a;
                r101.f265069a = null;
                if (r107 == null) goto L10;
                r107.run();
            L10:
                r101.clear();
                goto L12
            }
        }

        static {
            Object r100 = d.f265064a;
            monitor-enter(r100);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (d.f265065b != null) goto L7;
            d.f265065b = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
        L7:
            Handler r101 = d.f265065b;     // Catch: Throwable -> L11
            monitor-exit(r100);     // Catch: Throwable -> L11
            f265070a = new a(r101.getLooper());
        }
    }

    static {
        f265066b = new ReferenceQueue();
        f265067c = new Object();
        a r100 = new a();
        r100.setDaemon(true);
        ThreadMethodProxy.start(r100);
        f265068d = new HashSet();
    }

    public final void a(int r100) {
        Message r101 = Message.obtain(b.f265070a, r100, this);
        if (Looper.myLooper() != r101.getTarget().getLooper()) goto L5;
        r101.getTarget().handleMessage(r101);
        r101.recycle();
        return;
    L5:
        r101.sendToTarget();
    }

    public e(Object r100, TTWebViewAdblockWrapper.a r101) {
        super(r100, f265066b);
        this.f265069a = r101;
        a(1);
    }
}
