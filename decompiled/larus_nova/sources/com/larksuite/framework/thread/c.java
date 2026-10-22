package com.larksuite.framework.thread;

import android.os.Debug;
import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes24.dex */
public final class c<V> implements Callable<V>, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f285741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<V> f285742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f285743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f285744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f285745e;

    public final int hashCode() {
        return this.f285742b.hashCode();
    }

    @Override // java.util.concurrent.Callable
    public V call() throws Exception {
        this.f285744d = SystemClock.uptimeMillis();
        long r100 = Debug.threadCpuTimeNanos();
        if (CoreThreadPool.sAppFront == true) goto L12;
        Log.i("CoreThreadPool CoreCallableTask", this.f285742b.getClass() + " background executor");
    L12:
        this.f285741a.b(this.f285742b.getClass().toString(), hashCode());     // Catch: Throwable -> L9
        V r101 = this.f285742b.call();     // Catch: Throwable -> L9
        this.f285741a.c(this.f285742b.getClass().toString(), hashCode());
        this.f285745e = SystemClock.uptimeMillis();
        long r102 = (Debug.threadCpuTimeNanos() - r100) / 1000000;
        long r103 = this.f285744d;
        m.a(r103 - this.f285743c, this.f285745e - r103, this.f285742b.getClass().toString(), this.f285741a);
        return r101;
    L9:
        th = move-exception;
        this.f285741a.c(this.f285742b.getClass().toString(), hashCode());
        this.f285745e = SystemClock.uptimeMillis();
        long r104 = (Debug.threadCpuTimeNanos() - r100) / 1000000;
        long r105 = this.f285744d;
        m.a(r105 - this.f285743c, this.f285745e - r105, this.f285742b.getClass().toString(), this.f285741a);
        throw th;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r100) {
        Callable<V> r101 = this.f285742b;
        if ((r101 instanceof Comparable) == true) goto L5;
        return -1;
    L5:
        if ((r100 instanceof c) == true) goto L7;
        return -1;
    L7:
        return ((Comparable) r101).compareTo(((c) r100).f285742b);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f285742b.equals(((c) r100).f285742b) == false) goto L7;
        return true;
    }

    public c(Callable<V> r100, t r101) {
        this.f285744d = 0;
        this.f285745e = 0;
        this.f285743c = SystemClock.uptimeMillis();
        this.f285741a = r101;
        this.f285742b = r100;
    }
}
