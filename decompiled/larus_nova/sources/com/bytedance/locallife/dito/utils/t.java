package com.bytedance.locallife.dito.utils;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes21.dex */
public final class t extends Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f258716a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f258717b = null;

    public static final class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f258718a = null;

        /* JADX INFO: renamed from: com.bytedance.locallife.dito.utils.t$a$a, reason: collision with other inner class name */
        public static final class RunnableC3662a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f258719a;

            /* JADX INFO: renamed from: com.bytedance.locallife.dito.utils.t$a$a$a, reason: collision with other inner class name */
            public static final class RunnableC3663a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Runnable f258720a;

                public RunnableC3663a(Runnable r100) {
                    this.f258720a = r100;
                }

                public final void a() {
                    rq6.a r100 = rq6.a.f538927a;
                    r100.c("DitoChunkFrontExp", "POST两次开始执行 hash:" + this.f258720a.hashCode());
                    this.f258720a.run();
                    r100.c("DitoChunkFrontExp", "[Done]POST两次执行 hash:" + this.f258720a.hashCode());
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
            }

            public RunnableC3662a(Runnable r100) {
                this.f258719a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                t.f258717b.post(new RunnableC3663a(this.f258719a));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        static {
            f258718a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            t.f258717b.post(new RunnableC3662a(r100));
        }
    }

    static {
        f258716a = new t();
        f258717b = new Handler(Looper.getMainLooper());
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new ExecutorScheduler.ExecutorWorker(a.f258718a, true);
    }

    public t() {
    }
}
