package com.bytedance.locallife.dito.utils;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f258684a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f258685b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedBlockingQueue<Runnable> f258686c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f258687d;

    /* JADX INFO: renamed from: com.bytedance.locallife.dito.utils.a$a, reason: collision with other inner class name */
    public static final class ExecutorC3661a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ExecutorC3661a f258688a = null;

        static {
            f258688a = new ExecutorC3661a();
        }

        public ExecutorC3661a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            LinkedBlockingQueue<Runnable> r101 = a.f258686c;
            r101.offer(r100);
            a.f258684a.getClass();
            if (a.f258687d == false) goto L5;
            a.f258685b.post(b.f258689a);
            return;
        L5:
            Runnable r102 = r101.poll();
            if (r102 == null) goto L11;
            a.f258687d = true;
            a.f258685b.postAtFrontOfQueue(new c(r102));
            return;
        }
    }

    static {
        f258684a = new a();
        f258685b = new Handler(Looper.getMainLooper());
        f258686c = new LinkedBlockingQueue();
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new ExecutorScheduler.ExecutorWorker(ExecutorC3661a.f258688a, true);
    }

    public a() {
    }

    public static void b(boolean r100) {
        Runnable r101 = f258686c.poll();
        if (r101 == null) goto L5;
        rq6.a r102 = rq6.a.f538927a;
        r102.c("DitoChunkFrontExp", "插入开始执行 inPost:" + r100 + " hash:" + r101.hashCode());
        r101.run();
        r102.c("DitoChunkFrontExp", "【Done】插入执行 inPost:" + r100 + " hash:" + r101.hashCode());
        b(false);
        return;
    L5:
        f258687d = false;
    }
}
