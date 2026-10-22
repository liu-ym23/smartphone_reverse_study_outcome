package com.ss.android.ugc.aweme.thread;

import android.os.Build;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes40.dex */
class BaseThreadPoolExecutor extends PThreadPoolExecutor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Field f454279b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadPoolType f454280a;

    public final void e() {
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (f454279b == null) goto L5;
    L18:
        f454279b.set(ThreadMethodProxy.currentThread(), null);     // Catch: Exception -> L20
        return;
    L5:
        monitor-enter(BaseThreadPoolExecutor.class);     // Catch: Exception -> L20
    L15:
        th = move-exception;
        throw th;     // Catch: Exception -> L20
    L7:
        if (f454279b == null) goto L9;
    L13:
        monitor-exit(BaseThreadPoolExecutor.class);     // Catch: Throwable -> L15
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L11;
        f454279b = Thread.class.getDeclaredField("threadLocals");     // Catch: Throwable -> L15
    L12:
        f454279b.setAccessible(true);     // Catch: Throwable -> L15
        goto L13
    L11:
        f454279b = Thread.class.getDeclaredField("localValues");     // Catch: Throwable -> L15
        goto L12
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final void shutdown() {
        if (ThreadPoolHelper.g(this) == false) goto L5;
        return;
    L5:
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        if (ThreadPoolHelper.g(this) == false) goto L7;
        return Collections.emptyList();
    L7:
        return super.shutdownNow();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        if (ThreadPoolHelper.f454304a.f454314a.contains(this.f454280a) == false) goto L5;
        super.execute(new DelegateRunnable(r100, this));
        return;
    L5:
        super.execute(r100);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable r100, Throwable r101) {
        super.afterExecute(r100, r101);
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (Looper.myLooper() == null) goto L12;
        e();     // Catch: Exception -> L7
        return;
    }

    public BaseThreadPoolExecutor(ThreadPoolType r100, int r110, int r111, long r112, TimeUnit r113, BlockingQueue<Runnable> r114, ThreadFactory r115) {
        super(r110, r111, r112, r113, r114, r115);
        this.f454280a = r100;
    }

    public BaseThreadPoolExecutor(ThreadPoolType r110, int r111, int r112, long r113, TimeUnit r114, BlockingQueue<Runnable> r115, ThreadFactory r116, RejectedExecutionHandler r117) {
        super(r111, r112, r113, r114, r115, r116, r117);
        this.f454280a = r110;
    }
}
