package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import android.graphics.Color;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g0 extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a a;

    public static final class a {
    }

    static {
    }

    public g0(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
    }

    public static Integer d(Object r4) {
        if ((r4 instanceof Number) == true) goto L29;
        Object r2 = null;
        if ((r4 instanceof String) == false) goto L26;
        String r5 = (String) r4;
        if (r5 == null) goto L24;
        String r6 = StringsKt.trim(r5).toString();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        if (StringsKt.startsWith$default(r6, "#", false, 2, null) == true) goto L14;
        r6 = "#" + r6;     // Catch: Throwable -> L16
    L14:
        Object r7 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r6)));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r7) == true) goto L30;
        r2 = r7;
    L30:
        return (Integer) r2;
    L16:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L26:
        return null;
    L29:
        return Integer.valueOf(((Number) r4).intValue());
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r21) {
        Intrinsics.checkNotNullParameter(r21, "input");
        Map r0 = r21.q();     // Catch: Exception -> L104
        if (r0 != null) goto L6;
        r0 = MapsKt.emptyMap();     // Catch: Exception -> L104
    L6:
        Object r3 = r0.get("tab_id");     // Catch: Exception -> L104
        Object r4 = r0.get("visible");     // Catch: Exception -> L104
        if ((r4 instanceof Boolean) == true) goto L9;
        r4 = null;
    L9:
        Boolean r5 = (Boolean) r4;     // Catch: Exception -> L104
        Object r6 = r0.get("text");     // Catch: Exception -> L104
        Object r7 = r0.get("auto_close_time");     // Catch: Exception -> L104
        Object r8 = r0.get("click_to_close");     // Catch: Exception -> L104
        if ((r8 instanceof Boolean) == true) goto L12;
        r8 = null;
    L12:
        Boolean r9 = (Boolean) r8;     // Catch: Exception -> L104
        Object r1 = r0.get("bg_color");     // Catch: Exception -> L104
        if ((r3 instanceof Number) == false) goto L22;
        Double r10 = Double.valueOf(((Number) r3).doubleValue());     // Catch: Exception -> L104
        if ((!Double.isNaN(r10.doubleValue())) == true) goto L19;
        r10 = null;
    L19:
        if (r10 == null) goto L35;
        Integer r11 = Integer.valueOf((int) r10.doubleValue());     // Catch: Exception -> L104
    L36:
        if (r11 != null) goto L39;
        OrderCommonErrorMonitorKt.b(this.a.E0(), "SELF_FUN_ERROR", "OrderSelfTabBubbleFunction invalid tab_id");     // Catch: Exception -> L104
        int r2 = com.bytedance.kmp.ec.yata.chain.event.b.h;     // Catch: Exception -> L104
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "invalid tab_id", null, null, 57);
    L39:
        if (r5 != null) goto L43;
        OrderCommonErrorMonitorKt.b(this.a.E0(), "SELF_FUN_ERROR", "OrderSelfTabBubbleFunction invalid visible");     // Catch: Exception -> L104
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;     // Catch: Exception -> L104
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "invalid visible", null, null, 57);
    L43:
        if ((r6 instanceof String) == true) goto L45;
        r6 = null;
    L45:
        String r13 = (String) r6;     // Catch: Exception -> L104
        if (r13 == null) goto L48;
        String r14 = StringsKt.trim(r13).toString();     // Catch: Exception -> L104
    L49:
        if (r14 != null) goto L52;
        r14 = "";
    L52:
        if (r5.booleanValue() == false) goto L61;
        if (r14.length() != 0) goto L56;
        boolean r15 = true;
    L57:
        if (r15 == false) goto L61;
        OrderCommonErrorMonitorKt.b(this.a.E0(), "SELF_FUN_ERROR", "OrderSelfTabBubbleFunction text required when visible=true");     // Catch: Exception -> L104
        int r16 = com.bytedance.kmp.ec.yata.chain.event.b.h;     // Catch: Exception -> L104
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "text required when visible=true", null, null, 57);
    L56:
        r15 = false;
    L61:
        if ((r7 instanceof Number) == false) goto L69;
        Double r17 = Double.valueOf(((Number) r7).doubleValue());     // Catch: Exception -> L104
        if ((!Double.isNaN(r17.doubleValue())) == true) goto L66;
        r17 = null;
    L66:
        if (r17 == null) goto L82;
        Long r18 = Long.valueOf((long) r17.doubleValue());     // Catch: Exception -> L104
    L83:
        Integer r19 = d(r1);     // Catch: Exception -> L104
        if (r19 == null) goto L86;
        int r20 = r19.intValue();     // Catch: Exception -> L104
    L87:
        int r110 = r20;
        int r111 = r11.intValue();     // Catch: Exception -> L104
        boolean r112 = r5.booleanValue();     // Catch: Exception -> L104
        if (r5.booleanValue() == false) goto L90;
        String r113 = r14;
    L92:
        if (r5.booleanValue() == false) goto L97;
        if (r18 == null) goto L97;
        if (r18.longValue() <= 0) goto L97;
        Long r114 = r18;
    L99:
        if (r5.booleanValue() == false) goto L101;
        Boolean r115 = r9;
    L102:
        s0.a(new com.bytedance.android.shopping.orderlist.list.slice.elements.tab.e(r111, r112, r113, r114, r115, r110));     // Catch: Exception -> L104
        int r22 = com.bytedance.kmp.ec.yata.chain.event.b.h;     // Catch: Exception -> L104
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L101:
        r115 = null;
    L97:
        r114 = null;
        goto L99
    L90:
        r113 = null;
        goto L92
    L86:
        r20 = (int) 4281940804L;     // Catch: Exception -> L104
    L82:
        r18 = null;
        goto L83
    L69:
        if ((r7 instanceof String) == false) goto L82;
        String r23 = (String) r7;     // Catch: Exception -> L104
        if (r23 == null) goto L81;
        Double r24 = StringsKt.toDoubleOrNull(StringsKt.trim(r23).toString());     // Catch: Exception -> L104
        if (r24 == null) goto L82;
        if ((!Double.isNaN(r24.doubleValue())) == true) goto L78;
        r24 = null;
    L78:
        if (r24 == null) goto L82;
        r18 = Long.valueOf((long) r24.doubleValue());     // Catch: Exception -> L104
        goto L83
    L81:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L104
    L48:
        r14 = null;
    L35:
        r11 = null;
        goto L36
    L22:
        if ((r3 instanceof String) == false) goto L35;
        String r25 = (String) r3;     // Catch: Exception -> L104
        if (r25 == null) goto L34;
        Double r26 = StringsKt.toDoubleOrNull(StringsKt.trim(r25).toString());     // Catch: Exception -> L104
        if (r26 == null) goto L35;
        if ((!Double.isNaN(r26.doubleValue())) == true) goto L31;
        r26 = null;
    L31:
        if (r26 == null) goto L35;
        r11 = Integer.valueOf((int) r26.doubleValue());     // Catch: Exception -> L104
        goto L36
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L104
    L104:
        e = move-exception;
        OrderCommonErrorMonitorKt.b(this.a.E0(), "SELF_FUN_ERROR", "OrderSelfTabBubbleFunction exception: " + e.getMessage());
        int r27 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "exception: " + e.getMessage(), null, null, 57);
    }
}
