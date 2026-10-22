package com.bytedance.android.shopping.sku.common.monitor.error;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuRunCatchExtKt {
    public static final void a(String r1, String r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "errorTag");
        Intrinsics.checkNotNullParameter(r3, "task");
        b(r1, r2, r3, SkuRunCatchExtKt$skuRunCatch$1.INSTANCE);
    }

    public static final void b(String r3, String r4, Function0<Unit> r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "errorTag");
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
        if (r7 != null) goto L14;
        JSONObject r8 = new JSONObject();
        r8.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r8.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        Unit r1 = Unit.INSTANCE;
        r7 = new a(r8);
    L14:
        r7.a(SkuErrorMonitorType.CRASH, "【" + r4 + "】: " + th.getMessage(), null);
        ECExceptionMonitor.f(th, "Sku组件化-".concat(r4));
        r6.invoke();
    }
}
