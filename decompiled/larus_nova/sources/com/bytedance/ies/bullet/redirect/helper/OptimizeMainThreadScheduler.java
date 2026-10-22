package com.bytedance.ies.bullet.redirect.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.crash.dumper.Scraps;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class OptimizeMainThreadScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f247724a = null;

    public static final class a extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f247725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f247726b;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f247726b = true;
            this.f247725a.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f247726b;
        }

        public a(Handler r100) {
            Intrinsics.checkNotNullParameter(r100, "handler");
            this.f247725a = r100;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r102) {
            Intrinsics.checkNotNullParameter(r100, "run");
            Intrinsics.checkNotNullParameter(r102, Scraps.INNER_UNIT);
            if (this.f247726b == true) goto L5;
            Runnable r103 = RxJavaPlugins.onSchedule(r100);
            Lazy r104 = OptimizeMainThreadScheduler.f247724a;
            if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
            boolean r105 = true;
        L10:
            if (r105 == true) goto L12;
        L15:
            c r106 = new c(this.f247725a, r103);
            Message r107 = Message.obtain(this.f247725a, r106);
            r107.obj = this;
            this.f247725a.sendMessageDelayed(r107, r102.toMillis(r101));
            if (this.f247726b == false) goto L19;
            this.f247725a.removeCallbacks(r106);
            return Disposables.disposed();
        L19:
            return r106;
        L12:
            if (r101 != 0) goto L15;
            r103.run();
            return Disposables.disposed();
        L9:
            r105 = false;
            goto L10
        L5:
            return Disposables.disposed();
        }
    }

    public static final class b extends Scheduler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f247727a;

        public b() {
            Handler r100 = new Handler(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(r100, "handler");
            this.f247727a = r100;
        }

        @Override // io.reactivex.Scheduler
        public final Scheduler.Worker createWorker() {
            return new a(this.f247727a);
        }

        @Override // io.reactivex.Scheduler
        public final Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
            Intrinsics.checkNotNullParameter(r100, "run");
            Intrinsics.checkNotNullParameter(r102, Scraps.INNER_UNIT);
            Runnable r103 = RxJavaPlugins.onSchedule(r100);
            Lazy r104 = OptimizeMainThreadScheduler.f247724a;
            if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
            boolean r105 = true;
        L6:
            if (r105 == true) goto L8;
        L11:
            c r106 = new c(this.f247727a, r103);
            Message r107 = Message.obtain(this.f247727a, r106);
            this.f247727a.sendMessageDelayed(r107, r102.toMillis(r101));
            return r106;
        L8:
            if (r101 != 0) goto L11;
            r103.run();
            return Disposables.disposed();
        L5:
            r105 = false;
            goto L6
        }
    }

    public static final class c implements Runnable, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f247728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f247729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f247730c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f247728a.removeCallbacks(this);
            this.f247730c = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f247729b.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            RxJavaPlugins.onError(th);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f247730c;
        }

        public c(Handler r100, Runnable r101) {
            Intrinsics.checkNotNullParameter(r100, "handler");
            Intrinsics.checkNotNullParameter(r101, "delegate");
            this.f247728a = r100;
            this.f247729b = r101;
        }
    }

    public OptimizeMainThreadScheduler() {
    }

    static {
        f247724a = LazyKt.lazy(OptimizeMainThreadScheduler$mainThread$2.INSTANCE);
    }
}
