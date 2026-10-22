package com.bytedance.android.shopping.orderlist.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m {
    public static final a a = null;

    public static final class a extends Handler {
        public a(Looper r2) {
            Intrinsics.checkNotNullParameter(r2, "looper");
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            super.handleMessage(r3);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            OrderCommonErrorMonitorKt.b(null, "SERIOUS_BUSINESS_ERROR", "OrderCommonThreadUtils-safeHandler: " + e.getMessage());
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.invoke();
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final class e implements Runnable {
        public final /* synthetic */ Function0 a;

        public e(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
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
        a = new a(Looper.getMainLooper());
    }

    public static void b(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "task");
        com.bytedance.android.ec.hybrid.card.util.a.a(new d(r1));
    }

    public static void c(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r2.invoke();
        return;
    L8:
        a.post(new e(r2));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void a(c53.d r2, long r3, Function0 r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$delayInUI");
        Intrinsics.checkNotNullParameter(r5, "task");
        c53.c.a(Observable.timer(r3, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new b(r5), c.a), r2);
    }
}
