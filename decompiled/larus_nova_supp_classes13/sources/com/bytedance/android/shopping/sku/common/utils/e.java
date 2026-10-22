package com.bytedance.android.shopping.sku.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static final a a = null;

    public static final class a extends Handler {
        public a(Looper r2) {
            Intrinsics.checkNotNullParameter(r2, "looper");
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            super.handleMessage(r2);     // Catch: Exception -> L5
            return;
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.invoke();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            this.a.invoke();
        }
    }

    public final class d implements Runnable {
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

    static {
        a = new a(Looper.getMainLooper());
    }

    public static void b(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r2.invoke();
        return;
    L8:
        a.post(new d(r2));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static Disposable a(com.bytedance.android.ec.core.async.b r2, long r3, Function0 r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r2, "disposableScope");
        Intrinsics.checkNotNullParameter(r5, "task");
        Intrinsics.checkNotNullParameter(r6, "errorTask");
        return com.bytedance.android.ec.core.async.a.a(Completable.timer(r3, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new b(r5), new c(r6)), r2);
    }
}
