package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes35.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f461861a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f461862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f461863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static HandlerThread f461864d;

    /* JADX INFO: renamed from: com.tencent.open.utils.l$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Queue<Runnable> f461865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Runnable f461866b;

        public synchronized void a() {
            monitor-enter(this);
            Runnable r100 = this.f461865a.poll();     // Catch: Throwable -> L8
            this.f461866b = r100;     // Catch: Throwable -> L8
            if (r100 == null) goto L6;
            l.f461861a.execute(r100);     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private a() {
            this.f461865a = new LinkedList();
        }

        public /* synthetic */ a(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable r100) {
            monitor-enter(this);
            this.f461865a.offer(new AnonymousClass1(this, r100));     // Catch: Throwable -> L8
            if (this.f461866b != null) goto L6;
            a();     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public l() {
    }

    static {
        f461862b = new Object();
        f461861a = c();
    }

    public static Handler a() {
        if (f461863c != null) goto L13;
        monitor-enter(l.class);
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("SDK_SUB");     // Catch: Throwable -> L9
        f461864d = r100;     // Catch: Throwable -> L9
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L9
        f461863c = new Handler(f461864d.getLooper());     // Catch: Throwable -> L9
        monitor-exit(l.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f461863c;
    }

    public static Executor b() {
        return new a(null);
    }

    private static Executor c() {
        return new PThreadPoolExecutor(0, 3, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("/open/utils/l"));
    }

    public static void a(Runnable r100) {
        f461861a.execute(r100);     // Catch: RejectedExecutionException -> L4
        return;
    }

    public static void b(Runnable r100) {
        a().post(r100);
    }
}
