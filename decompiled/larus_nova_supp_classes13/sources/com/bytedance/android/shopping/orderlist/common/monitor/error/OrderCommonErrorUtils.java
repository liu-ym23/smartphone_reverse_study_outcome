package com.bytedance.android.shopping.orderlist.common.monitor.error;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonErrorUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(a r8, final String r9, final String r10, Map r11) {
        Intrinsics.checkNotNullParameter(r11, "extraParams");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.b("OrderCommonErrorUtils", new OrderCommonErrorUtils$logForError$1(r9, r10));
        JSONObject r1 = new JSONObject();
        if (r8 == null) goto L10;
        Map<String, Object> r2 = r8.c();
        if (r2 == null) goto L10;
        Iterator<Map.Entry<String, Object>> r3 = r2.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry<String, Object> r4 = r3.next();
        r1.put(r4.getKey(), r4.getValue());
    L10:
        Iterator r12 = r11.entrySet().iterator();
    L12:
        if (r12.hasNext() == false) goto L15;
        Map.Entry r5 = (Map.Entry) r12.next();
        r1.put((String) r5.getKey(), r5.getValue());
        goto L12
    L15:
        if (r8 == null) goto L21;
        Map<String, ? extends Object> r6 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r7 = ig3.b.a.entrySet().iterator();
    L18:
        if (r7.hasNext() == false) goto L20;
        Map.Entry<String, String> r13 = r7.next();
        r6.put(r13.getKey(), r13.getValue());
        goto L18
    L20:
        r6.put("error_type", r9);
        r6.put("error_msg", r10);
        r6.put("extra", r1);
        Unit r14 = Unit.INSTANCE;
        r8.b("yata_order_list_monitor", r6);
        return;
    L21:
        g r15 = g.a;
        JSONObject r16 = new JSONObject();
        Iterator<Map.Entry<String, String>> r17 = ig3.b.a.entrySet().iterator();
    L23:
        if (r17.hasNext() == false) goto L25;
        Map.Entry<String, String> r18 = r17.next();
        r16.put(r18.getKey(), r18.getValue());
        goto L23
    L25:
        r16.put("error_type", r9);
        r16.put("error_msg", r10);
        r16.put("extra", r1);
        Unit r19 = Unit.INSTANCE;
        r15.logV3("yata_order_list_monitor", r16);
    }

    public static void b(a r3, String r4, Function0 r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r4, "errorTag");
        Intrinsics.checkNotNullParameter(r5, "originTask");
        Intrinsics.checkNotNullParameter(r6, "errorCatchTask");
        if (ECAppInfoService.e.i() == false) goto L10;
        r5.invoke();
        return;
    L10:
        r5.invoke();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a(r3, "CRASH", r4 + ": " + th.getMessage(), MapsKt.emptyMap());
        StringBuilder r7 = new StringBuilder("Yata订单列表组件化-");
        r7.append(r4);
        ECExceptionMonitor.f(th, r7.toString());
        r6.invoke();
    }
}
