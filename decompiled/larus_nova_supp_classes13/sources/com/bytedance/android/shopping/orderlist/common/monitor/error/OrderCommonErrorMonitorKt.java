package com.bytedance.android.shopping.orderlist.common.monitor.error;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonErrorMonitorKt {
    public static final void f(Function0<Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "block");
        r1.invoke();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (ECAppInfoService.e.isLocalTest() == true) goto L10;
        ECExceptionMonitor.e(e);
        return;
    L10:
        throw e;
    }

    public static final <T> T e(T r1, Function0<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        return (T) r2.invoke();
    L5:
        e = move-exception;
        if (ECAppInfoService.e.isLocalTest() == true) goto L10;
        ECExceptionMonitor.e(e);
        return r1;
    L10:
        throw e;
    }

    public static /* synthetic */ void b(a r1, String r2, String r3) {
        a(r1, r2, r3, MapsKt.emptyMap());
    }

    public static final void c(a r1, String r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "errorTag");
        Intrinsics.checkNotNullParameter(r3, "task");
        int r0 = OrderCommonErrorUtils.a;
        OrderCommonErrorUtils.b(r1, r2, r3, OrderCommonErrorMonitorKt$orderRunCatch$1.INSTANCE);
    }

    public static final void a(a r1, String r2, String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        OrderCommonErrorUtils.a(r1, r2, r3, r4);
    }

    public static final void d(a r1, String r2, Function0<Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "errorTag");
        Intrinsics.checkNotNullParameter(r3, "task");
        Intrinsics.checkNotNullParameter(r4, "errorCatchTask");
        OrderCommonErrorUtils.b(r1, r2, r3, r4);
    }
}
