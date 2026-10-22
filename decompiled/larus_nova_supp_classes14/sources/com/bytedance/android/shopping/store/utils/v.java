package com.bytedance.android.shopping.store.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static u a(Map r12, Boolean r13) {
        Object r0 = null;
        if (r12 == null) goto L9;
        String r1 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r12, "index", null);
        if (r1 == null) goto L9;
        Integer r2 = StringsKt.toIntOrNull(r1);
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
    L10:
        if (r12 == null) goto L12;
        String r4 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r12, "btm_id", null);
    L13:
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        String r5 = r4;
        if (r12 == null) goto L18;
        Object r14 = r12.get("product");
    L20:
        if ((r14 instanceof Map) == true) goto L22;
        r14 = null;
    L22:
        Map r6 = (Map) r14;
        if (r6 == null) goto L25;
        Object r15 = r6.get("log_extra");
    L27:
        if ((r15 instanceof Map) == true) goto L29;
        r15 = null;
    L29:
        Map r7 = (Map) r15;
        if (r6 == null) goto L32;
        Object r16 = r6.get("biz_extra");
    L34:
        if ((r16 instanceof Map) == true) goto L36;
        r16 = null;
    L36:
        Map r8 = (Map) r16;
        if (r6 == null) goto L39;
        Object r17 = r6.get("base_info");
    L41:
        if ((r17 instanceof Map) == true) goto L43;
        r17 = null;
    L43:
        Map r18 = (Map) r17;
        if (r18 == null) goto L48;
        Object r19 = r18.get("product_id");
        if (r19 == null) goto L48;
        String r110 = r19.toString();
    L49:
        String r9 = com.bytedance.android.shopping.extensions.k.j(r110);
        if (r6 == null) goto L52;
        Object r111 = r6.get("track_info");
    L54:
        if ((r111 instanceof Map) == true) goto L56;
        r111 = null;
    L56:
        Map r112 = (Map) r111;
        if (r112 == null) goto L59;
        Object r113 = r112.get("standard_chain_param");
    L61:
        if ((r113 instanceof Map) == true) goto L63;
        r113 = null;
    L63:
        Map r10 = (Map) r113;
        if (r13 == null) goto L72;
        boolean r114 = r13.booleanValue();
        int r115 = p.a;
        Intrinsics.checkNotNullParameter(r5, "rawBtm");
        if (r114 == false) goto L68;
        String r116 = r5;
    L69:
        if (r116 == null) goto L72;
        String r11 = r116;
    L73:
        if (r8 == null) goto L75;
        Object r117 = r8.get("detail_url");
    L77:
        if ((r117 instanceof String) == false) goto L81;
        r0 = r117;
    L81:
        return new u(r3, r5, r11, r6, r7, r8, r9, r10, (String) r0);
    L75:
        r117 = null;
        goto L77
    L68:
        r116 = r5 + "_i" + r3;
    L72:
        r11 = r5;
        goto L73
    L59:
        r113 = null;
        goto L61
    L52:
        r111 = null;
    L48:
        r110 = null;
        goto L49
    L39:
        r17 = null;
        goto L41
    L32:
        r16 = null;
        goto L34
    L25:
        r15 = null;
        goto L27
    L18:
        r14 = null;
        goto L20
    L12:
        r4 = null;
    L9:
        r3 = 0;
        goto L10
    }
}
