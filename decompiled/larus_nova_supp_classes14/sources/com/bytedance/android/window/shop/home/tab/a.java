package com.bytedance.android.window.shop.home.tab;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final AtomicInteger a;
    public final int b;
    public final Scheduler c;

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.home.tab.a$a, reason: collision with other inner class name */
    public final class RunnableC0033a implements Runnable {
        public final Function0<Unit> a;
        public final /* synthetic */ a b;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4 Exception -> L6
        L8:
            this.b.a.decrementAndGet();     // Catch: Throwable -> L9
            return;
        L6:
            e = move-exception;
            ECExceptionMonitor.e(e);     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            this.b.a.decrementAndGet();     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }

        public RunnableC0033a(a r2, Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r3, "realRunnable");
            this.b = r2;
            this.a = r3;
            r2.a.incrementAndGet();
        }
    }

    public a() {
        Scheduler r0 = Schedulers.computation();
        Intrinsics.checkNotNullParameter(r0, "scheduler");
        this.b = 10;
        this.c = r0;
        this.a = new AtomicInteger(0);
    }

    public final void a(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "runnable");
        if (this.a.get() <= this.b) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        this.c.scheduleDirect(new RunnableC0033a(this, r3));
        return;
    L8:
        r3.invoke();
        return;
    L5:
        r0 = false;
        goto L6
    }
}
