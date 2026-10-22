package com.bytedance.locallife.live.util;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g0 implements pv6.c {
    public g0() {
    }

    @Override // pv6.c
    public final void a(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (r101 != null) goto L47;
    L24:
        Long r103 = null;
    L25:
        if (r101 == null) goto L29;
        Object r104 = r101.get("random_time");     // Catch: Exception -> L22
        if (r104 == null) goto L29;
        Integer r105 = Integer.valueOf(sv6.a.a(r104));     // Catch: Exception -> L22
    L31:
        if (r103 == null) goto L33;
        long r106 = r103.longValue();     // Catch: Exception -> L22
    L34:
        if (r105 == null) goto L36;
        int r107 = r105.intValue();     // Catch: Exception -> L22
    L37:
        nv6.c r108 = new nv6.c(r106, r107, 10);     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter("virgo", "<set-?>");     // Catch: Exception -> L22
        r108.f520898a = "virgo";     // Catch: Exception -> L22
        int r109 = sv6.b.f543666a;     // Catch: Exception -> L22
        if (r101 == null) goto L41;
        String r110 = r101.toString();     // Catch: Exception -> L22
        if (r110 == null) goto L41;
    L42:
        sv6.b.a("Unit-life_live_shelf_api_preload", r110, null);     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        sv6.b.b("life_live_shelf_api_preload", e);
        return;
    L41:
        r110 = "";
        goto L42
    L36:
        r107 = 0;
        goto L37
    L33:
        r106 = 300000;
    L29:
        r105 = null;
        goto L31
    L47:
        Object r111 = r101.get("age_limit");     // Catch: Exception -> L22
        if (r111 == null) goto L24;
        Intrinsics.checkNotNullParameter(r111, "<this>");     // Catch: Exception -> L22
        if ((r111 instanceof Long) == false) goto L11;
        long r112 = ((Number) r111).longValue();     // Catch: Exception -> L46
    L21:
        r103 = Long.valueOf(r112);     // Catch: Exception -> L22
    L11:
        if ((r111 instanceof Double) == false) goto L14;
        r112 = (long) ((Number) r111).doubleValue();     // Catch: Exception -> L46
        goto L21
    L14:
        if ((r111 instanceof String) == false) goto L17;
        r112 = CastLongProtector.parseLong((String) r111);     // Catch: Exception -> L46
        goto L21
    L17:
        if ((r111 instanceof Integer) == false) goto L20;
        r112 = 0;
        goto L21
    L19:
        r112 = ((Number) r111).intValue();     // Catch: Exception -> L46
    L20:
        r112 = 0;
        goto L21
    }
}
