package com.larksuite.framework.thread;

import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes24.dex */
public class g extends PThreadScheduledThreadPoolExecutor implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f285751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f285752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a0> f285753c;

    @Override // com.larksuite.framework.thread.t
    public final List<a0> a() {
        List<a0> r100 = this.f285753c;
        monitor-enter(r100);
        LinkedList r101 = new LinkedList(this.f285753c);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larksuite.framework.thread.t
    public final String d() {
        return this.f285751a;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final <V> Future<V> submit(Callable<V> r100) {
        return new x(super.submit(new e(new c(r100, this), r100)));
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable r100) {
        return new x(super.submit(e(r100, null, -1), null));
    }

    @Override // com.larksuite.framework.thread.t
    public final void b(String r100, int r101) {
        List<a0> r102 = this.f285753c;
        monitor-enter(r102);
        ((LinkedList) this.f285753c).add(new a0(r100 + "#" + r101, ThreadMethodProxy.currentThread(), System.currentTimeMillis()));     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larksuite.framework.thread.t
    public final void c(String r100, int r101) {
        List<a0> r102 = this.f285753c;
        monitor-enter(r102);
        Iterator<a0> r103 = this.f285753c.iterator();     // Catch: Throwable -> L12
    L6:
        if (r103.hasNext() == false) goto L10;
        if (TextUtils.equals(r103.next().f285726a, r100 + "#" + r101) == false) goto L6;
        r103.remove();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final <V> Future<V> submit(Runnable r100, V r101) {
        return new x(super.submit(e(r100, null, -1), r101));
    }

    public g(String r100, int r101, n r102) {
        super(r101, r102);
        this.f285752b = 5000;
        this.f285753c = new LinkedList();
        this.f285751a = r100 + "-ScheduleExecutor";
        this.f285752b = 5000;
        setRejectedExecutionHandler(p.f285795f);
    }

    public final qqb.b e(Runnable r100, TimeUnit r101, long r102) {
        if (r101 != null) goto L4;
        k r103 = new k(r100, this);
    L6:
        return qqb.c.a(new f(r103, r100));
    L4:
        r103 = new o28.a(r100, this);
        goto L6
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor, java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public final <V> ScheduledFuture<V> schedule(Callable<V> r100, long r101, TimeUnit r102) {
        return new y(super.schedule(new e(new c(r100, this), r100), r101, r102));
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor, java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> schedule(Runnable r100, long r101, TimeUnit r102) {
        return new y(super.schedule(e(r100, r102, r101), r101, r102));
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor, java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable r100, long r101, long r110, TimeUnit r111) {
        return new y(super.scheduleAtFixedRate(e(r100, r111, r110), r101, r110, r111));
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor, java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable r100, long r101, long r110, TimeUnit r111) {
        return new y(super.scheduleWithFixedDelay(e(r100, r111, r110), r101, r110, r111));
    }
}
