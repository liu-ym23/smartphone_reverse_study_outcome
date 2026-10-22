package com.bytedance.android.shopping.orderlist.common.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonLog {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static final class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Function0 b;

        public a(String r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            dm.a.b r1 = dm.a.a;     // Catch: Exception -> L5
            dm.a.a("order_common_" + this.a).a((String) this.b.invoke());     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            ECExceptionMonitor.e(e);
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

    public static final class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Function0 b;

        public b(String r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            dm.a.b r1 = dm.a.a;     // Catch: Exception -> L5 Throwable -> L8
            dm.a.a("order_common_" + this.a).b((String) this.b.invoke(), null);     // Catch: Exception -> L5 Throwable -> L8
        L13:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L5:
            e = move-exception;
            ECExceptionMonitor.e(e);     // Catch: Throwable -> L8
            goto L13
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Function0 b;

        public c(String r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            dm.a.b r1 = dm.a.a;     // Catch: Exception -> L5
            dm.a.a("order_common_" + this.a).i((String) this.b.invoke());     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            ECExceptionMonitor.e(e);
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

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, OrderCommonLog$orderLogExecutor$2.INSTANCE);
        b = LazyKt.lazy(OrderCommonLog$isDebugOrLocalTest$2.INSTANCE);
    }

    public static void a(String r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        if (((Boolean) b.getValue()).booleanValue() == false) goto L6;
        ((ExecutorService) a.getValue()).execute(new a(r2, r3));
        return;
    }

    public static void b(String r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        ((ExecutorService) a.getValue()).execute(new b(r2, r3));
    }

    public static void c(String r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        ((ExecutorService) a.getValue()).execute(new c(r2, r3));
    }
}
