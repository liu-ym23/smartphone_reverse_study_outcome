package com.larksuite.framework.thread;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes24.dex */
public final class n implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f285781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f285782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f285783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadGroup f285784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f285785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentLinkedQueue<WeakReference<Thread>> f285786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f285787g;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f285788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f285789b;

        @Override // java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(this.f285788a);     // Catch: SecurityException -> L5 IllegalArgumentException -> L7 Throwable -> L11
        L9:
            this.f285789b.run();     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        L7:
            e = move-exception;
            Log.e("CoreThreadFactory", "AdjustPoolThreadPriority run: ", e);     // Catch: Throwable -> L11
        L5:
            e = move-exception;
            Log.e("CoreThreadFactory", "AdjustPoolThreadPriority run: ", e);     // Catch: Throwable -> L11
            goto L9
        }

        public a(int r100, Runnable r101) {
            this.f285788a = r100;
            this.f285789b = r101;
        }
    }

    public final void b() {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if ((System.currentTimeMillis() - this.f285787g) >= 5000) goto L9;
        Log.w("CoreThreadFactory", "threadpool print stack too frequency! poolname is: " + this.f285782b);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        this.f285787g = System.currentTimeMillis();     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        Iterator<WeakReference<Thread>> r100 = this.f285786f.iterator();     // Catch: Throwable -> L21
    L12:
        if (r100.hasNext() == false) goto L37;
        Thread r101 = r100.next().get();     // Catch: Throwable -> L21
        if (r101 == null) goto L19;
        if (ThreadMethodProxy.isAlive(r101) == false) goto L19;
        a(r101);     // Catch: Throwable -> L21
    L19:
        r100.remove();     // Catch: Throwable -> L21
        goto L12
    L37:
        return;
    L21:
        th = move-exception;
        Log.e("CoreThreadFactory", "printThreadFactoryThreads exception", th, true);
    }

    public n(String r100) {
        this(r100, 10);
    }

    public static void a(Thread r100) {
        StackTraceElement[] r101 = r100.getStackTrace();
        Throwable r102 = new Throwable();
        r102.setStackTrace(r101);
        int r103 = r101.length;
        boolean r104 = false;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L8;
        StackTraceElement r106 = r101[r105];
        if ((r106.getClassName() + "." + r106.getMethodName()).contains("java.util.concurrent.ThreadPoolExecutor.getTask") == true) goto L9;
        r105 = r105 + 1;
    L9:
        Log.e("CoreThreadFactory", "thread: " + r100.getName() + ", stackTrace is： ", r102, r104);
        return;
    L8:
        r104 = true;
        goto L9
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(this.f285784d, new a(this.f285785e, r100), this.f285782b + "-" + this.f285781a.getAndIncrement(), 0);
        r101.setDaemon(this.f285783c);
        this.f285786f.add(new WeakReference(r101));
        return r101;
    }

    public n(String r100, int r101) {
        this.f285781a = new AtomicInteger(1);
        this.f285786f = new ConcurrentLinkedQueue();
        this.f285787g = 0;
        if (r101 >= 19) goto L13;
        if (r101 < (-4)) goto L13;
        this.f285782b = r100;
        this.f285783c = false;
        this.f285785e = r101;
        SecurityManager r102 = System.getSecurityManager();
        if (r102 != null) goto L9;
        ThreadGroup r103 = ThreadMethodProxy.currentThread().getThreadGroup();
    L10:
        this.f285784d = r103;
        return;
    L9:
        r103 = r102.getThreadGroup();
    L13:
        throw new IllegalArgumentException("CoreThreadFactory priority is not illegal! please use android.os.Process define priority!");
    }
}
