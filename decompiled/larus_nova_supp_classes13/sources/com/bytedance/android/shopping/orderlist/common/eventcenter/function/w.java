package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.orderlist.common.controller.OrderCommonPageConfig;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a a;
    public final AndroidYaTaInstance b;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderCommonTransformLocationFunction", OrderCommonTransformLocationFunction$onExecuteSync$1.INSTANCE);
        Map r1 = r7.q();
        if (r1 == null) goto L5;
        Object r2 = r1.get("match_vo");
    L7:
        if ((r2 instanceof Map) == true) goto L9;
        r2 = null;
    L9:
        Map r3 = (Map) r2;
        if (r1 == null) goto L12;
        Object r4 = r1.get("slice_key");
    L14:
        if ((r4 instanceof String) == true) goto L16;
        r4 = null;
    L16:
        String r5 = (String) r4;
        boolean r6 = true;
        if (r3 != null) goto L19;
    L22:
        boolean r8 = true;
    L23:
        if (r8 == true) goto L52;
        if (r3 == null) goto L26;
        Object r9 = r3.get("component_id");
    L27:
        final String r10 = (String) r9;
        AndroidYaTaInstance r11 = this.b;
        if (r11 == null) goto L32;
        com.bytedance.kmp.ec.yata.store.node.c r12 = (com.bytedance.kmp.ec.yata.store.node.c) CollectionsKt.firstOrNull(r11.q(new OrderCommonTransformLocationFunction$findTargetView$targetNodeKey$1(r10)));
        if (r12 == null) goto L32;
        String r13 = r12.getKey();
    L33:
        if (r13 != null) goto L35;
    L38:
        boolean r14 = true;
    L39:
        if (r14 == true) goto L44;
        AndroidYaTaInstance r15 = this.b;
        if (r15 == null) goto L44;
        View r16 = r15.K(r13);
    L45:
        if (r16 == null) goto L51;
        if (r5 == null) goto L51;
        if (this.a.f() == null) goto L50;
        r16 = SlcRenderContext.f(r16, r5);
        goto L51
    L50:
        r16 = null;
    L51:
        Map<?, ?> r17 = d(r16);
    L70:
        if (r17 != null) goto L72;
    L75:
        if (r6 == false) goto L78;
        OrderCommonErrorMonitorKt.b(this.a.E0(), "SELF_FUN_ERROR", "boundingRect is empty in selfTransformLocation");
        int r18 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "boundingRect is empty in selfTransformLocation", null, null, 57);
    L78:
        OrderCommonLog.c("selfTransformLocation", OrderCommonTransformLocationFunction$onExecuteSync$4.INSTANCE);
        int r19 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("boundingRect", r17)), null, 5);
    L72:
        if (r17.isEmpty() == true) goto L75;
        r6 = false;
    L44:
        r16 = null;
        goto L45
    L35:
        if (r13.length() == 0) goto L38;
        r14 = false;
    L32:
        r13 = null;
        goto L33
    L26:
        r9 = null;
        goto L27
    L52:
        com.bytedance.kmp.ec.yata.event.common.f r20 = r7.d;
        com.bytedance.kmp.ec.yata.common.platform.o r21 = r20.b;
        if (r21 == null) goto L56;
        View r22 = r21.a;
        if (r22 == null) goto L56;
    L63:
        if (r22 == null) goto L68;
        if (r5 == null) goto L68;
        if (this.a.f() == null) goto L68;
        View r23 = SlcRenderContext.f(r22, r5);
    L69:
        r17 = d(r23);
    L68:
        r23 = null;
    L56:
        AndroidYaTaInstance r24 = this.b;
        if (r24 == null) goto L62;
        String r25 = r20.c;
        if (r25 != null) goto L61;
        r25 = "";
    L61:
        r22 = r24.K(r25);
        goto L63
    L62:
        r22 = null;
        goto L63
    L19:
        if (r3.isEmpty() == true) goto L22;
        r8 = false;
        goto L23
    L12:
        r4 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    public final Map<?, ?> d(View r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        View r1 = this.a.T0();
        if (r1 != null) goto L8;
        return null;
    L8:
        com.bytedance.android.ecom.arch.slice.render.context.b r2 = OrderCommonPageConfig.b(false);
        int r3 = e(r8, r1);
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("width", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r8.getWidth()), r2))), TuplesKt.to("height", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r8.getHeight()), r2))), TuplesKt.to("top", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(f(r8, r1)), r2))), TuplesKt.to("left", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r3), r2)))});
    }

    public w(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2, AndroidYaTaInstance r3) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
        this.b = r3;
    }

    public static int e(View r2, View r3) {
        if (r2 != null) goto L4;
        return 0;
    L4:
        if (Intrinsics.areEqual(r2.getParent(), r3) == true) goto L6;
        int r0 = r2.getLeft();
        Object r4 = r2.getParent();
        if ((r4 instanceof View) == true) goto L11;
        r4 = null;
    L11:
        return r0 + e((View) r4, r3);
    L6:
        return r2.getLeft();
    }

    public static int f(View r2, View r3) {
        if (r2 != null) goto L4;
        return 0;
    L4:
        if (Intrinsics.areEqual(r2.getParent(), r3) == true) goto L6;
        int r0 = r2.getTop();
        Object r4 = r2.getParent();
        if ((r4 instanceof View) == true) goto L11;
        r4 = null;
    L11:
        return r0 + f((View) r4, r3);
    L6:
        return r2.getTop();
    }
}
