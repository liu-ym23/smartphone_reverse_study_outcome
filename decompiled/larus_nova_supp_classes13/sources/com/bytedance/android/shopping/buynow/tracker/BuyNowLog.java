package com.bytedance.android.shopping.buynow.tracker;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyNowLog {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(BuyNowLog$isDebugOrLocalTest$2.INSTANCE);
    }

    public static void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        dm.a.b r4 = dm.a.a;     // Catch: Throwable -> L5
        dm.a.a("buynow_" + r2).a(r3);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L13;
        ECExceptionMonitor.e(r6);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void b(String r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L4:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L15;
        dm.a.b r1 = dm.a.a;     // Catch: Exception -> L10
        dm.a.b r4 = dm.a.a("buynow_".concat(r2));     // Catch: Exception -> L10
        String r5 = (String) r3.invoke();     // Catch: Exception -> L10
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r4.a(r5);     // Catch: Exception -> L10
        return;
    }

    public static void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        dm.a.b r4 = dm.a.a;     // Catch: Throwable -> L5
        dm.a.a("buynow_".concat(r2)).b(r3, null);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L13;
        ECExceptionMonitor.e(r6);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        dm.a.b r4 = dm.a.a;     // Catch: Throwable -> L5
        dm.a.a("buynow_".concat(r2)).i(r3);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L13;
        ECExceptionMonitor.e(r6);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
