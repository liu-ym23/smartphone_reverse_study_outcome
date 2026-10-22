package com.bytedance.android.shopping.card_list.monitor.error;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListRunCatchExtKt {
    public static final void a(String r1, String r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "errorMonitorType");
        Intrinsics.checkNotNullParameter(r3, "task");
        b(r1, r2, r3, CardListRunCatchExtKt$cardListRunCatch$1.INSTANCE);
    }

    public static final void b(String r3, String r4, Function0<Unit> r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "errorMonitorType");
        Intrinsics.checkNotNullParameter(r5, "task");
        Intrinsics.checkNotNullParameter(r6, "errorCatchTask");
        if (ECAppInfoService.e.i() == false) goto L16;
        r5.invoke();
        return;
    L16:
        r5.invoke();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Map<String, a> r0 = a.b;
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        Intrinsics.checkNotNullParameter(r3, "id");
        a r7 = (a) ((LinkedHashMap) a.b).get(r3);
        if (r7 == null) goto L14;
        r7.b(CardListErrorMonitorType.CRASH, "[errorMonitorType" + r4 + "]:" + th.getMessage(), null);
    L14:
        ECExceptionMonitor.f(th, "card_List-KIT-" + CardListErrorMonitorType.CRASH.getValue());
        r6.invoke();
    }
}
