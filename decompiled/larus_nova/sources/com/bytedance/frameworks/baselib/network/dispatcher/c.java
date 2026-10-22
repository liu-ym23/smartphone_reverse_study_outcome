package com.bytedance.frameworks.baselib.network.dispatcher;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsRunnable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicInteger f244657f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f244658g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHandler f244659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PThreadPoolExecutor f244660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PThreadPoolExecutor f244661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PThreadPoolExecutor f244662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PThreadPoolExecutor f244663e;

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f244664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f244665b;

        /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.dispatcher.c$a$a, reason: collision with other inner class name */
        public class C3500a extends PthreadThreadV2 {
            @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
            public final void run() {
                Process.setThreadPriority(10);     // Catch: Throwable -> L5
                super.run();     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L9;
                return;
            L9:
                throw th;
            }

            public C3500a(Runnable r100, String r101) {
                super(r100, r101);
            }
        }

        public a(String r100) {
            this.f244664a = new AtomicInteger(1);
            this.f244665b = "ApiExecutor";
            if (TextUtils.isEmpty(r100) == true) goto L6;
            this.f244665b = r100;
            return;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            C3500a r101 = new C3500a(r100, this.f244665b + "#" + this.f244664a.getAndIncrement());
            r101.setDaemon(false);
            return r101;
        }
    }

    public final synchronized ExecutorService c() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f244661c != null) goto L6;
        kx5.c.c().getClass();     // Catch: Throwable -> L9
        this.f244661c = null;     // Catch: Throwable -> L9
        PThreadPoolExecutor r100 = new PThreadPoolExecutor(kx5.c.c().f506562a, kx5.c.c().f506564c, kx5.c.c().f506567f, TimeUnit.SECONDS, new PriorityBlockingQueue(), new a("NetNormal"));     // Catch: Throwable -> L9
        this.f244661c = r100;     // Catch: Throwable -> L9
        r100.allowCoreThreadTimeOut(kx5.c.c().f506569h);     // Catch: Throwable -> L9
    L6:
        PThreadPoolExecutor r101 = this.f244661c;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r101;
    }

    public final synchronized ExecutorService d() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f244660b != null) goto L6;
        kx5.c.c().getClass();     // Catch: Throwable -> L9
        this.f244660b = null;     // Catch: Throwable -> L9
        kx5.c.c().getClass();     // Catch: Throwable -> L9
        this.f244660b = new PThreadPoolExecutor(0, Integer.MAX_VALUE, kx5.c.c().f506566e, TimeUnit.SECONDS, new SynchronousQueue(), new a("NetImmediate"));     // Catch: Throwable -> L9
    L6:
        PThreadPoolExecutor r100 = this.f244660b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final synchronized ExecutorService e() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f244663e != null) goto L6;
        kx5.c.c().getClass();     // Catch: Throwable -> L9
        this.f244663e = null;     // Catch: Throwable -> L9
        kx5.c.c().getClass();     // Catch: Throwable -> L9
        kx5.c.c().getClass();     // Catch: Throwable -> L9
        kx5.c.c().getClass();     // Catch: Throwable -> L9
        PThreadPoolExecutor r100 = new PThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new PriorityBlockingQueue(), new a("NetLowest"));     // Catch: Throwable -> L9
        this.f244663e = r100;     // Catch: Throwable -> L9
        r100.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L9
    L6:
        PThreadPoolExecutor r101 = this.f244663e;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r101;
    }

    static {
        f244657f = new AtomicInteger();
        f244658g = new c();
    }

    public c() {
        this.f244659a = new WeakHandler(Looper.getMainLooper(), this);
    }

    public final void a(kx5.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.f506556b.get() == true) goto L21;
        r100.b(f244657f.incrementAndGet());
        if (r100.getPriority() != IRequest.Priority.IMMEDIATE) goto L10;
        d().execute(r100);
        return;
    L10:
        if (r100.getPriority() != IRequest.Priority.LOWEST) goto L12;
        e().execute(r100);
        return;
    L12:
        long r101 = r100.f506557c;
        if (r101 <= 0) goto L15;
        Message r102 = Message.obtain();
        r102.what = 0;
        r102.obj = r100;
        this.f244659a.sendMessageDelayed(r102, r101);
        return;
    L15:
        f(this.f244661c, r100);
        c().execute(r100);
        return;
    }

    public final void b(com.bytedance.frameworks.baselib.network.dispatcher.a r110) {
        if (r110.f506556b.get() == false) goto L5;
        return;
    L5:
        r110.f506558d = f244657f.incrementAndGet();
        IRequest.Priority r100 = r110.f244654f;
        if (r100 != IRequest.Priority.IMMEDIATE) goto L9;
        d().execute(r110);
        return;
    L9:
        if (r100 != IRequest.Priority.LOWEST) goto L11;
        e().execute(r110);
        return;
    L11:
        long r101 = r110.f506557c;
        if (r101 <= 0) goto L14;
        Message r102 = Message.obtain();
        r102.what = 1;
        r102.obj = r110;
        this.f244659a.sendMessageDelayed(r102, r101);
        return;
    L14:
        f(this.f244662d, r110);
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L17:
        if (this.f244662d != null) goto L19;
        kx5.c.c().getClass();     // Catch: Throwable -> L23
        this.f244662d = null;     // Catch: Throwable -> L23
        PThreadPoolExecutor r103 = new PThreadPoolExecutor(kx5.c.c().f506563b, kx5.c.c().f506565d, kx5.c.c().f506568g, TimeUnit.SECONDS, new PriorityBlockingQueue(), new a("NetDownload"));     // Catch: Throwable -> L23
        this.f244662d = r103;     // Catch: Throwable -> L23
        r103.allowCoreThreadTimeOut(kx5.c.c().f506569h);     // Catch: Throwable -> L23
    L19:
        PThreadPoolExecutor r104 = this.f244662d;     // Catch: Throwable -> L23
        monitor-exit(this);
        r104.execute(r110);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 == null) goto L21;
        Object r101 = r100.obj;
        if ((r101 instanceof Runnable) == false) goto L22;
        int r102 = r100.what;     // Catch: Throwable -> L14
        if (r102 != 0) goto L9;
        f(this.f244661c, (kx5.a) r101);     // Catch: Throwable -> L14
        c().execute((Runnable) r100.obj);     // Catch: Throwable -> L14
    L17:
        return;
    L9:
        if (r102 != 1) goto L17;
        f(this.f244662d, (kx5.a) r101);     // Catch: Throwable -> L14
        d().execute((Runnable) r100.obj);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L22:
        return;
    }

    public static void f(PThreadPoolExecutor r100, kx5.a r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r101 instanceof com.bytedance.frameworks.baselib.network.dispatcher.a) == false) goto L12;
        int r102 = r100.getQueue().size();
        Runnable r103 = ((com.bytedance.frameworks.baselib.network.dispatcher.a) r101).f244653e;
        if ((r103 instanceof SsRunnable) == false) goto L13;
        RetrofitMetrics r104 = ((SsRunnable) r103).getRetrofitMetrics();
        if (r104 == null) goto L14;
        r104.setBlockingQueueSize(r102);
        return;
    L14:
        return;
    L13:
        return;
    }
}
