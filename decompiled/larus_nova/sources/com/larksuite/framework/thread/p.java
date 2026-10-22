package com.larksuite.framework.thread;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes24.dex */
public class p extends PThreadPoolExecutor implements t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static w f285793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static z f285794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f285795f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile Field f285796g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f285797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f285798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a0> f285799c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f285800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Callable f285801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p f285802c;

        @Override // com.larksuite.framework.thread.q, java.util.concurrent.Callable
        public T call() throws Exception {
            return (T) this.f285800a.call();
        L4:
            e = move-exception;
            Log.e("CoreThreadPool", "calltask exception, task name: " + this.f285801b.getClass());
            com.larksuite.framework.thread.a.c().a(e);
            com.larksuite.framework.thread.a.c().getClass();
            System.currentTimeMillis();
            throw e;
        }

        public a(p r100, c r101, Callable r102) {
            this.f285802c = r100;
            this.f285800a = r101;
            this.f285801b = r102;
        }
    }

    public static class b implements RejectedExecutionHandler {
        public b() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
            if ((r101 instanceof p) == false) goto L13;
            p r102 = (p) r101;
            ThreadFactory r103 = r102.getThreadFactory();
            if ((r103 instanceof n) == false) goto L8;
            ((n) r103).b();
        L8:
            if ((r100 instanceof k) == false) goto L10;
            Runnable r104 = ((k) r100).f285773b;
        L11:
            Log.e("CoreThreadPool", m.c(r104) + " be rejected , pool: " + r102.f285798b, new Throwable(), true);
            goto L13
        L10:
            r104 = r100;
        L13:
            if ((r101 instanceof d) == false) goto L15;
            p.e(r100);
            return;
        L15:
            w r105 = p.f285793d;
            if (r105 != null) goto L28;
            if (r105 != null) goto L28;
            monitor-enter(p.class);
        L25:
            th = move-exception;
            throw th;
        L21:
            if (p.f285793d != null) goto L23;
            PthreadHandlerThreadV2 r106 = new PthreadHandlerThreadV2("core-reject");     // Catch: Throwable -> L25
            ThreadMethodProxy.start(r106);     // Catch: Throwable -> L25
            p.f285793d = new w(r106.getLooper(), "core-reject");     // Catch: Throwable -> L25
        L23:
            monitor-exit(p.class);     // Catch: Throwable -> L25
        L28:
            w r107 = p.f285793d;
            if (r107 == null) goto L35;
            r107.post(r100);
            return;
        }
    }

    static {
        f285795f = new b();
    }

    @Override // com.larksuite.framework.thread.t
    public final List<a0> a() {
        List<a0> r100 = this.f285799c;
        monitor-enter(r100);
        LinkedList r101 = new LinkedList(this.f285799c);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final void g() {
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (f285796g == null) goto L5;
    L18:
        f285796g.set(ThreadMethodProxy.currentThread(), null);     // Catch: Exception -> L20
        return;
    L5:
        monitor-enter(p.class);     // Catch: Exception -> L20
    L15:
        th = move-exception;
        throw th;     // Catch: Exception -> L20
    L7:
        if (f285796g == null) goto L9;
    L13:
        monitor-exit(p.class);     // Catch: Throwable -> L15
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L11;
        f285796g = Thread.class.getDeclaredField("threadLocals");     // Catch: Throwable -> L15
    L12:
        f285796g.setAccessible(true);     // Catch: Throwable -> L15
        goto L13
    L11:
        f285796g = Thread.class.getDeclaredField("localValues");     // Catch: Throwable -> L15
        goto L12
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final void shutdown() {
        if (this.f285797a.contains(CoreThreadPool.DEFAULT_PREFIX) == false) goto L5;
        return;
    L5:
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if (this.f285797a.contains(CoreThreadPool.DEFAULT_PREFIX) == false) goto L7;
        return Collections.emptyList();
    L7:
        return super.shutdownNow();
    }

    @Override // com.larksuite.framework.thread.t
    public final String d() {
        return this.f285798b;
    }

    public static void e(Runnable r100) {
        if (f285794e == null) goto L5;
    L14:
        f285794e.execute(r100);
        return;
    L5:
        monitor-enter(p.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f285794e != null) goto L9;
        f285794e = new z(new LinkedBlockingDeque(512), new n("lk-reject", 1));     // Catch: Throwable -> L11
    L9:
        monitor-exit(p.class);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        if ((r100 instanceof FutureTask) == false) goto L6;
    L9:
        super.execute(r100);
        return;
    L6:
        if ((r100 instanceof k) == true) goto L9;
        r100 = new k(r100, this);
        goto L9
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable r100) {
        return new x(super.submit(new o(this, new k(r100, this), r100), null));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> r100) {
        return new x(super.submit(new a(this, new c(r100, this), r100)));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable r100, Throwable r101) {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (Looper.myLooper() == null) goto L11;
        g();     // Catch: Exception -> L6
        return;
    }

    @Override // com.larksuite.framework.thread.t
    public final void b(String r100, int r101) {
        List<a0> r102 = this.f285799c;
        monitor-enter(r102);
        ((LinkedList) this.f285799c).add(new a0(r100 + "#" + r101, ThreadMethodProxy.currentThread(), System.currentTimeMillis()));     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larksuite.framework.thread.t
    public final void c(String r100, int r101) {
        List<a0> r102 = this.f285799c;
        monitor-enter(r102);
        Iterator<a0> r103 = this.f285799c.iterator();     // Catch: Throwable -> L12
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

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable r100, T r101) {
        return new x(super.submit(new o(this, new k(r100, this), r100), r101));
    }

    public p(String r100, int r110, int r111, long r112, BlockingQueue<Runnable> r113, n r114) {
        super(r110, r111, r112, TimeUnit.SECONDS, r113, r114);
        this.f285799c = new LinkedList();
        setRejectedExecutionHandler(f285795f);
        this.f285797a = r100;
        this.f285798b = r100 + "-ThreadExecutor";
    }
}
