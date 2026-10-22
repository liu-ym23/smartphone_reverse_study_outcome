package com.bytedance.assem.jedi_vm.store;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends Scheduler {
    public final Handler a;
    public final boolean b;

    public static final class a extends Scheduler.Worker {
        public volatile boolean a;
        public final Handler b;
        public final boolean c;

        public final void dispose() {
            this.a = true;
            this.b.removeCallbacksAndMessages(this);
        }

        public final boolean isDisposed() {
            return this.a;
        }

        public a(Handler r1, boolean r2) {
            this.b = r1;
            this.c = r2;
        }

        public final Disposable schedule(Runnable r4, long r5, TimeUnit r7) {
            if (this.a == true) goto L5;
            Runnable r6 = RxJavaPlugins.onSchedule(r4);
            boolean r0 = e.a();
            Handler r2 = this.b;
            b r1 = new b(r2, r6, r0);
            if (r0 == false) goto L10;
            r1.run();
            return r1;
        L10:
            Message r8 = Message.obtain(r2, r1);
            r8.obj = this;
            if (this.c == false) goto L13;
            r8.setAsynchronous(true);
        L13:
            this.b.sendMessageDelayed(r8, r7.toMillis(r5));
            if (this.a == false) goto L17;
            this.b.removeCallbacks(r1);
            return Disposables.disposed();
        L17:
            return r1;
        L5:
            return Disposables.disposed();
        }
    }

    public static final class b implements Runnable, Disposable {
        public volatile boolean a;
        public final Handler b;
        public final Runnable c;
        public final boolean d;

        public final void dispose() {
            if (this.d == true) goto L5;
            this.b.removeCallbacks(this);
        L5:
            this.a = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.c.run();     // Catch: Throwable -> L4
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

        public final boolean isDisposed() {
            return this.a;
        }

        public b(Handler r1, Runnable r2, boolean r3) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public final Scheduler.Worker createWorker() {
        return new a(this.a, this.b);
    }

    public d(Handler r1) {
        this.a = r1;
        this.b = false;
    }

    public final Disposable scheduleDirect(Runnable r4, long r5, TimeUnit r7) {
        Runnable r6 = RxJavaPlugins.onSchedule(r4);
        boolean r0 = e.a();
        Handler r2 = this.a;
        b r1 = new b(r2, r6, r0);
        if (r0 == false) goto L6;
        r1.run();
        return r1;
    L6:
        r2.postDelayed(r1, r7.toMillis(r5));
        return r1;
    }
}
