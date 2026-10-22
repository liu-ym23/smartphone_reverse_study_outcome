package com.ss.android.ugc.aweme.thread;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes40.dex */
class DelegateRunnable implements Runnable, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f454281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseThreadPoolExecutor f454282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f454283c;

    public final int hashCode() {
        return this.f454281a.hashCode();
    }

    public final void a() {
        long r100 = SystemClock.uptimeMillis();
        ThreadMethodProxy.currentThread();     // Catch: Throwable -> L9
        if ((this.f454281a instanceof FutureTask) == false) goto L6;
        ThreadPoolHelper.f454305b.getClass();     // Catch: Throwable -> L9
    L6:
        TaskMonitor.Holder.f454303a.getClass();     // Catch: Throwable -> L9
        IThreadPoolMonitor r101 = ThreadPoolHelper.f454305b;     // Catch: Throwable -> L9
        r101.getClass();     // Catch: Throwable -> L9
        long r102 = r100 - this.f454283c;     // Catch: Throwable -> L9
        ThreadPoolInitConfig r103 = ThreadPoolHelper.f454304a;     // Catch: Throwable -> L9
        int r104 = (r102 > r103.f454316c ? 1 : (r102 == r103.f454316c ? 0 : -1));
        this.f454281a.run();     // Catch: Throwable -> L9
        int r105 = ((SystemClock.uptimeMillis() - r100) > r103.f454317d ? 1 : ((SystemClock.uptimeMillis() - r100) == r103.f454317d ? 0 : -1));
        r101.getClass();
        return;
    L9:
        th = move-exception;
        TaskMonitor.Holder.f454303a.getClass();
        ThreadPoolHelper.f454305b.getClass();
        throw th;
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

    @Override // java.lang.Comparable
    public final int compareTo(Object r100) {
        Runnable r101 = this.f454281a;
        if ((r101 instanceof Comparable) == true) goto L5;
        return 0;
    L5:
        if ((r100 instanceof DelegateRunnable) == true) goto L7;
        return 0;
    L7:
        return ((Comparable) r101).compareTo(((DelegateRunnable) r100).f454281a);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof DelegateRunnable) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f454281a.equals(((DelegateRunnable) r100).f454281a) == false) goto L7;
        return true;
    }

    public DelegateRunnable(Runnable r100, BaseThreadPoolExecutor r101) {
        this.f454281a = r100;
        this.f454282b = r101;
        this.f454283c = SystemClock.uptimeMillis();
    }
}
