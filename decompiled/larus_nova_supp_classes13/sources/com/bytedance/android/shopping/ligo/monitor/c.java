package com.bytedance.android.shopping.ligo.monitor;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final Map<String, Map<String, Long>> a;
    public final com.bytedance.android.shopping.ligo.monitor.a b;

    public static final class a {
    }

    static {
    }

    public c(com.bytedance.android.shopping.ligo.monitor.a r2) {
        Intrinsics.checkNotNullParameter(r2, "eventTracker");
        this.b = r2;
        this.a = new LinkedHashMap();
    }

    public final void a(ll.a r2) {
        Intrinsics.checkNotNullParameter(r2, "dynamicRegion");
        c(r2.e(), "load_start");
    }

    public final void b(ll.a r6) {
        Intrinsics.checkNotNullParameter(r6, "dynamicRegion");
        c(r6.e(), "on_load_success");
        String r0 = r6.e();
        if (r0 == null) goto L13;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(b.a(r6));
        Map r7 = (Map) ((LinkedHashMap) this.a).get(r0);
        if (r7 == null) goto L10;
        Iterator r8 = r7.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) r8.next();
        r1.put(r2.getKey(), String.valueOf(((Number) r2.getValue()).longValue()));
    L10:
        this.b.b("livesdk_ligo_load_perf", r1);
        return;
    }

    public final void c(String r14, String r15) {
        if (r14 != null) goto L67;
        return;
    L67:
    L64:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L5:
        if (this.a.containsKey(r14) == true) goto L7;
        this.a.put(r14, new LinkedHashMap());     // Catch: Exception -> L64
    L7:
        long r0 = System.currentTimeMillis();     // Catch: Exception -> L64
        Map r2 = (Map) ((LinkedHashMap) this.a).get(r14);     // Catch: Exception -> L64
        if (r2 == null) goto L10;
        Long r3 = (Long) r2.put(r15, Long.valueOf(r0));     // Catch: Exception -> L64
    L10:
        int r4 = r15.hashCode();     // Catch: Exception -> L64
        boolean r5 = true;
        Long r8 = null;
        if (r4 == (-335641590)) goto L33;
        if (r4 == 1140590858) goto L17;
        return;
    L17:
        if (r15.equals("on_template_loaded") == false) goto L68;
        Map r16 = (Map) ((LinkedHashMap) this.a).get(r14);     // Catch: Exception -> L64
        if (r16 == null) goto L69;
        Long r17 = (Long) r16.get("load_start");     // Catch: Exception -> L64
        if (r17 != null) goto L23;
        return;
    L23:
        if (r17.longValue() > 0) goto L26;
        r5 = false;
    L26:
        if (r5 == false) goto L28;
        r8 = r17;
    L28:
        if (r8 == null) goto L71;
        long r6 = r8.longValue();     // Catch: Exception -> L64
        Map r18 = (Map) ((LinkedHashMap) this.a).get(r14);     // Catch: Exception -> L64
        if (r18 == null) goto L72;
        Long r19 = (Long) r18.put("template_load_cost", Long.valueOf(r0 - r6));     // Catch: Exception -> L64
        return;
    L72:
        return;
    L71:
        return;
    L69:
        return;
    L68:
        return;
    L33:
        if (r15.equals("on_load_success") == false) goto L74;
        Map r110 = (Map) ((LinkedHashMap) this.a).get(r14);     // Catch: Exception -> L64
        if (r110 == null) goto L49;
        Long r111 = (Long) r110.get("on_template_loaded");     // Catch: Exception -> L64
        if (r111 == null) goto L49;
        if (r111.longValue() <= 0) goto L41;
        boolean r7 = true;
    L42:
        if (r7 == true) goto L45;
        r111 = null;
    L45:
        if (r111 == null) goto L49;
        long r11 = r111.longValue();     // Catch: Exception -> L64
        Map r112 = (Map) ((LinkedHashMap) this.a).get(r14);     // Catch: Exception -> L64
        if (r112 == null) goto L49;
        Long r113 = (Long) r112.put("load_page_cost", Long.valueOf(r0 - r11));     // Catch: Exception -> L64
        goto L49
    L41:
        r7 = false;
    L49:
        Map r114 = (Map) ((LinkedHashMap) this.a).get(r14);     // Catch: Exception -> L64
        if (r114 == null) goto L75;
        Long r115 = (Long) r114.get("load_start");     // Catch: Exception -> L64
        if (r115 != null) goto L54;
        return;
    L54:
        if (r115.longValue() > 0) goto L57;
        r5 = false;
    L57:
        if (r5 == false) goto L59;
        r8 = r115;
    L59:
        if (r8 == null) goto L77;
        long r9 = r8.longValue();     // Catch: Exception -> L64
        Map r116 = (Map) ((LinkedHashMap) this.a).get(r14);     // Catch: Exception -> L64
        if (r116 == null) goto L78;
        Long r117 = (Long) r116.put("load_duration", Long.valueOf(r0 - r9));     // Catch: Exception -> L64
        return;
    L78:
        return;
    L77:
        return;
    L75:
        return;
    }
}
