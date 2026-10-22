package com.bytedance.assem.jedi_vm.store;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f193098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f193099b;

    public static final class a extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f193100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f193101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f193102c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f193100a = true;
            this.f193101b.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f193100a;
        }

        public a(Handler r100, boolean r101) {
            this.f193101b = r100;
            this.f193102c = r101;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r102) {
            if (this.f193100a == true) goto L5;
            Runnable r103 = RxJavaPlugins.onSchedule(r100);
            boolean r104 = e.a();
            Handler r105 = this.f193101b;
            b r106 = new b(r105, r103, r104);
            if (r104 == false) goto L10;
            r106.run();
            return r106;
        L10:
            Message r107 = Message.obtain(r105, r106);
            r107.obj = this;
            if (this.f193102c == false) goto L13;
            r107.setAsynchronous(true);
        L13:
            this.f193101b.sendMessageDelayed(r107, r102.toMillis(r101));
            if (this.f193100a == false) goto L17;
            this.f193101b.removeCallbacks(r106);
            return Disposables.disposed();
        L17:
            return r106;
        L5:
            return Disposables.disposed();
        }
    }

    public static final class b implements Runnable, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f193103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f193104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f193105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f193106d;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.f193106d == true) goto L5;
            this.f193104b.removeCallbacks(this);
        L5:
            this.f193103a = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f193105c.run();     // Catch: Throwable -> L4
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
            return this.f193103a;
        }

        public b(Handler r100, Runnable r101, boolean r102) {
            this.f193104b = r100;
            this.f193105c = r101;
            this.f193106d = r102;
        }
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new a(this.f193098a, this.f193099b);
    }

    public d(Handler r100) {
        this.f193098a = r100;
        this.f193099b = false;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
        Runnable r103 = RxJavaPlugins.onSchedule(r100);
        boolean r104 = e.a();
        Handler r105 = this.f193098a;
        b r106 = new b(r105, r103, r104);
        if (r104 == false) goto L6;
        r106.run();
        return r106;
    L6:
        r105.postDelayed(r106, r102.toMillis(r101));
        return r106;
    }
}
