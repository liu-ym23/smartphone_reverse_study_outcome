package com.larksuite.framework.thread;

import android.os.Debug;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import io.reactivex.internal.schedulers.ExecutorScheduler;

/* JADX INFO: loaded from: classes24.dex */
public class k implements Runnable, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f285772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f285773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f285774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f285775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f285776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f285777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f285778g;

    public final void a() {
        Runnable r100 = this.f285773b;
        if ((r100 instanceof ExecutorScheduler.ExecutorWorker) == false) goto L5;
        r100.run();
        return;
    L5:
        long r101 = Debug.threadCpuTimeNanos();
        this.f285775d = SystemClock.uptimeMillis();
        t r102 = this.f285772a;     // Catch: Throwable -> L13 Exception -> L15
        if (r102 == null) goto L9;
        r102.b(this.f285773b.getClass().toString(), hashCode());     // Catch: Throwable -> L13 Exception -> L15
    L9:
        this.f285773b.run();     // Catch: Throwable -> L13 Exception -> L15
        t r103 = this.f285772a;
        if (r103 != null) goto L19;
    L20:
        this.f285776e = this.f285775d - this.f285774c;
        this.f285777f = SystemClock.uptimeMillis() - this.f285775d;
        this.f285778g = (Debug.threadCpuTimeNanos() - r101) / 1000000;
        this.f285774c = SystemClock.uptimeMillis();
        m.a(this.f285776e, this.f285777f, this.f285773b.getClass().toString(), this.f285772a);
        return;
    L19:
        r103.c(this.f285773b.getClass().toString(), hashCode());
        goto L20
    L15:
        e = move-exception;
        Log.e(e.getMessage(), e);     // Catch: Throwable -> L13
        r103 = this.f285772a;
        if (r103 == null) goto L20;
    L13:
        th = move-exception;
        t r104 = this.f285772a;
        if (r104 == null) goto L25;
        r104.c(this.f285773b.getClass().toString(), hashCode());
    L25:
        this.f285776e = this.f285775d - this.f285774c;
        this.f285777f = SystemClock.uptimeMillis() - this.f285775d;
        this.f285778g = (Debug.threadCpuTimeNanos() - r101) / 1000000;
        this.f285774c = SystemClock.uptimeMillis();
        m.a(this.f285776e, this.f285777f, this.f285773b.getClass().toString(), this.f285772a);
        throw th;
    }

    public final int hashCode() {
        return this.f285773b.hashCode();
    }

    @Override // java.lang.Runnable
    public void run() {
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
        Runnable r101 = this.f285773b;
        if ((r101 instanceof Comparable) == true) goto L5;
        return -1;
    L5:
        if ((r100 instanceof k) == true) goto L7;
        return -1;
    L7:
        return ((Comparable) r101).compareTo(((k) r100).f285773b);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof k) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f285773b.equals(((k) r100).f285773b) == false) goto L7;
        return true;
    }

    public k(Runnable r100, t r101) {
        this.f285775d = 0;
        this.f285774c = SystemClock.uptimeMillis();
        this.f285772a = r101;
        this.f285773b = r100;
    }
}
