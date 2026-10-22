package com.larksuite.framework.thread;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f285721d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f285722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, s> f285723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BlockingQueue<s> f285724c;

    /* JADX INFO: renamed from: com.larksuite.framework.thread.a$a, reason: collision with other inner class name */
    public class RunnableC3928a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f285725a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f285725a.getClass();     // Catch: Throwable -> L4
            System.currentTimeMillis();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC3928a(a r100) {
            this.f285725a = r100;
        }
    }

    public static a c() {
        if (f285721d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f285721d != null) goto L9;
        f285721d = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f285721d;
    }

    public a() {
        this.f285722a = new Object();
        this.f285723b = new ConcurrentHashMap();
        this.f285724c = new LinkedBlockingQueue();
        System.currentTimeMillis();
        new RunnableC3928a(this);
    }

    public final synchronized void a(Throwable r100) {
        monitor-enter(this);
        Map<Integer, s> r101 = this.f285723b;     // Catch: Throwable -> L11
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;     // Catch: Throwable -> L11
        if (((s) r102.get(Integer.valueOf(r100.hashCode()))) != null) goto L9;
        Exception r103 = (Exception) r100;     // Catch: Throwable -> L11
        System.currentTimeMillis();     // Catch: Throwable -> L11
        s r104 = new s();     // Catch: Throwable -> L11
        Map<Integer, s> r105 = this.f285723b;     // Catch: Throwable -> L11
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;     // Catch: Throwable -> L11
        r106.put(Integer.valueOf(r100.hashCode()), r104);     // Catch: Throwable -> L11
        ((LinkedBlockingQueue) this.f285724c).put(r104);     // Catch: InterruptedException -> L8 Throwable -> L11
    L8:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(Throwable r100) {
        monitor-enter(this);
        Map<Integer, s> r101 = this.f285723b;     // Catch: Throwable -> L8
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;     // Catch: Throwable -> L8
        s r103 = (s) r102.get(Integer.valueOf(r100.hashCode()));     // Catch: Throwable -> L8
        if (r103 == null) goto L6;
        ((LinkedBlockingQueue) this.f285724c).remove(r103);     // Catch: Throwable -> L8
        Map<Integer, s> r104 = this.f285723b;     // Catch: Throwable -> L8
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;     // Catch: Throwable -> L8
        r105.remove(Integer.valueOf(r100.hashCode()));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
