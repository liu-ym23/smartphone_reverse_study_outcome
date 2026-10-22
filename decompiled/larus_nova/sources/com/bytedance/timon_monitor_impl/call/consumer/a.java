package com.bytedance.timon_monitor_impl.call.consumer;

import com.bytedance.timonbase.report.TMDataCollector;
import hh7.c;
import hh7.d;
import hh7.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements b {

    /* JADX INFO: renamed from: com.bytedance.timon_monitor_impl.call.consumer.a$a, reason: collision with other inner class name */
    public static final class C3788a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.timon_monitor_impl.call.consumer.b
    public final void a(hh7.a r210) {
        if (Intrinsics.areEqual(r210.b(), "privacy_api_call") == false) goto L63;
        f r100 = r210.d();
        if (r100 == null) goto L64;
        String r101 = r210.c();
        int r102 = r100.a();
        boolean r103 = r100.j();
        String r104 = r100.c();
        String r105 = r100.f();
        long r106 = r210.a();
        boolean r107 = r100.k();
        List<c> r110 = r100.i();
        if (r110 == null) goto L15;
        c r111 = (c) CollectionsKt.firstOrNull(r110);
        if (r111 == null) goto L15;
        d r112 = r111.a();
        if (r112 == null) goto L15;
        Object r113 = r112.b();
        if (r113 == null) goto L15;
    L16:
        String r114 = e06.c.c(r113);
        List<c> r115 = r100.i();
        if (r115 == null) goto L25;
        c r116 = (c) CollectionsKt.firstOrNull(r115);
        if (r116 == null) goto L25;
        d r117 = r116.a();
        if (r117 == null) goto L25;
        Object r118 = r117.a();
        if (r118 == null) goto L25;
    L26:
        String r119 = e06.c.c(r118);
        String r120 = r100.h();
        Map<String, Object> r121 = r100.g();
        String r122 = r100.d();
        if (r122 != null) goto L30;
        r122 = "unknown";
    L30:
        TMDataCollector r123 = TMDataCollector.f270828e;
        if (r120 != null) goto L34;
        r120 = "";
    L34:
        String r124 = r122;
        String r125 = "privacy_api_call_monitor-" + r104 + ':' + r105;
        HashMap r126 = new HashMap();
        r126.put("id", r101);
        r126.put("rule_engine_param_className", r104);
        r126.put("rule_engine_param_method", r105);
        r126.put("rule_engine_param_apiId", String.valueOf(r102));
        r126.put("rule_engine_param_isReflection", String.valueOf(r103));
        r126.put("rule_engine_param_invokeTime", String.valueOf(r106));
        if (r107 == false) goto L37;
        String r108 = "1";
    L38:
        r126.put("rule_engine_param_isDowngrade", r108);
        if (r114 != null) goto L42;
        r114 = "";
    L42:
        r126.put("rule_engine_param_strategyNames", r114);
        if (r119 == null) goto L45;
        String r127 = r119;
    L46:
        r126.put("rule_engine_param_rulerKeys", r127);
        Iterator<Map.Entry<String, Object>> r109 = r121.entrySet().iterator();
    L48:
        if (r109.hasNext() == false) goto L54;
        Map.Entry<String, Object> r128 = r109.next();
        String r129 = r128.getKey();
        Object r130 = r128.getValue();
        if (r130 == null) goto L48;
        String r131 = r130.toString();
        if (r131 == null) goto L48;
        r126.put(r129, r131);
        goto L48
    L54:
        r126.put("privacy_api_call_data", e06.c.c(r100));
        HashMap r132 = new HashMap();
        r132.put("EventType", "Privacy-API-Call");
        r123.f("Privacy-API-Call", r120, r125, "privacy_api_call_monitor", r124, false, r126, r132, false);
        return;
    L45:
        r127 = "";
        goto L46
    L37:
        r108 = "0";
    L25:
        r118 = "";
    L15:
        r113 = "";
        goto L16
    L64:
        return;
    }
}
