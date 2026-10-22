package com.bytedance.android.shopping.collect.monitor.error;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectRunCatchExtKt {
    public static final void a(String r4, String r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "errorTag");
        Intrinsics.checkNotNullParameter(r6, "task");
        CollectRunCatchExtKt$collectRunCatch$1 r2 = CollectRunCatchExtKt$collectRunCatch$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r5, "errorTag");
        Intrinsics.checkNotNullParameter(r6, "task");
        Intrinsics.checkNotNullParameter(r2, "errorCatchTask");
        if (ECAppInfoService.e.i() == false) goto L16;
        r6.invoke();
        return;
    L16:
        r6.invoke();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Map<String, a> r0 = a.b;
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        Intrinsics.checkNotNullParameter(r4, "id");
        a r7 = (a) ((LinkedHashMap) a.b).get(r4);
        if (r7 != null) goto L14;
        JSONObject r8 = new JSONObject();
        r8.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r8.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        Unit r1 = Unit.INSTANCE;
        r7 = new a(r8);
    L14:
        r7.b(CollectErrorMonitorType.CRASH, "【" + r5 + "】: " + th.getMessage(), null);
        ECExceptionMonitor.f(th, "collect组件化-".concat(r5));
        r2.invoke();
    }
}
