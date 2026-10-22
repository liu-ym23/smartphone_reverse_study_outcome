package com.lynx.tasm.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes32.dex */
public final class c extends PhantomReference<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue<Object> f381858c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f381859d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<c> f381860e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<c> f381861f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f381862g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f381863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f381864b;

    public static class a extends PthreadThreadV2 {
        public a() {
            super("CleanupReference");
        }

        public static void l() {
        L20:
            c r100 = (c) c.f381858c.remove();     // Catch: Exception -> L16
            Object r101 = c.f381859d;     // Catch: Exception -> L16
            monitor-enter(r101);     // Catch: Exception -> L16
        L5:
            if (r100.f381863a == true) goto L7;
            c.f381862g.offer(r100);     // Catch: Throwable -> L13
        L8:
            c r102 = (c) c.f381862g.poll();     // Catch: Throwable -> L13
            if (r102 == null) goto L11;
            TraceEvent.beginSection("CleanupReference.ReaperThread.runCleanupTask");     // Catch: Throwable -> L13
            c.a(r102, c.f381861f);     // Catch: Throwable -> L13
            TraceEvent.endSection("CleanupReference.ReaperThread.runCleanupTask");     // Catch: Throwable -> L13
            goto L8
        L11:
            monitor-exit(r101);     // Catch: Throwable -> L13
            goto L20
        L7:
            Message.obtain(b.f381865a, 2, r100).sendToTarget();     // Catch: Throwable -> L13
            r101.wait(500);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;     // Catch: Exception -> L16
        L16:
            e = move-exception;
            LLog.e("CleanupReference", "Queue remove exception:" + e.toString());
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
        public static final a f381865a = null;

        public static class a extends Handler {
            public a(Looper r100) {
                super(r100);
            }

            @Override // android.os.Handler
            public final void handleMessage(Message r100) {
                TraceEvent.beginSection("CleanupReference.LazyHolder.handleMessage");     // Catch: Throwable -> L24
                c r101 = (c) r100.obj;     // Catch: Throwable -> L24
                int r102 = r100.what;     // Catch: Throwable -> L24
                if (r102 != 1) goto L5;
                ((HashSet) c.f381860e).add(r101);     // Catch: Throwable -> L24
            L9:
                Object r103 = c.f381859d;     // Catch: Throwable -> L24
                monitor-enter(r103);     // Catch: Throwable -> L24
            L27:
                c r104 = (c) c.f381858c.poll();     // Catch: Throwable -> L21
                if (r104 == null) goto L17;
                if (r104.f381863a == false) goto L15;
                c.a(r104, c.f381860e);     // Catch: Throwable -> L21
                goto L27
            L15:
                c.f381862g.offer(r104);     // Catch: Throwable -> L21
                goto L27
            L17:
                c.f381859d.notifyAll();     // Catch: Throwable -> L21
                monitor-exit(r103);     // Catch: Throwable -> L21
                TraceEvent.endSection("CleanupReference.LazyHolder.handleMessage");
                return;
            L21:
                th = move-exception;
                throw th;     // Catch: Throwable -> L24
            L5:
                if (r102 == 2) goto L7;
                LLog.e("CleanupReference", String.format("Bad message=%d", new Object[]{Integer.valueOf(r102)}));     // Catch: Throwable -> L24
                goto L9
            L7:
                c.a(r101, c.f381860e);     // Catch: Throwable -> L24
            L24:
                th = move-exception;
                TraceEvent.endSection("CleanupReference.LazyHolder.handleMessage");
                throw th;
            }
        }

        static {
            f381865a = new a(Looper.getMainLooper());
        }
    }

    static {
        f381858c = new ReferenceQueue();
        f381859d = new Object();
        a r100 = new a();
        r100.setDaemon(true);
        ThreadMethodProxy.start(r100);
        f381860e = new HashSet();
        f381861f = ConcurrentHashMap.newKeySet();
        f381862g = new ConcurrentLinkedQueue();
    }

    public c(Object r100, Runnable r101) {
        super(r100, f381858c);
        this.f381864b = r101;
        this.f381863a = true;
        Message r102 = Message.obtain(b.f381865a, 1, this);
        if (Looper.myLooper() != r102.getTarget().getLooper()) goto L5;
        r102.getTarget().handleMessage(r102);
        r102.recycle();
        return;
    L5:
        r102.sendToTarget();
    }

    public static void a(c r100, Set r101) {
        r100.getClass();
        r101.remove(r100);
        Runnable r102 = r100.f381864b;
        r100.f381864b = null;
        if (r102 == null) goto L5;
        r102.run();
    L5:
        r100.clear();
    }
}
