package com.bytedance.android.shopping.sku.inner.function.business;

import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataSelfSaveBizFieldsCacheController;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends com.bytedance.kmp.ec.yata.event.common.a {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public j(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r12, "input");
        Intrinsics.checkNotNullParameter(r13, "chainNextCallback");
        SkuCommonLog.c("SkuYataSaveBizFieldsFunction", "SkuYataSaveBizFieldsFunction");
        Intrinsics.checkNotNullParameter(r12, "input");
        Map r0 = ((com.bytedance.kmp.ec.yata.chain.trigger.a) r12.e).a;
        if (r0 == null) goto L5;
        Object r4 = r0.get("common_self_save_biz_prefix");
    L7:
        if ((r4 instanceof String) == true) goto L9;
        r4 = null;
    L9:
        String r5 = (String) r4;
        if (r0 == null) goto L12;
        Object r1 = r0.get("common_self_save_biz_fields");
    L14:
        if ((r1 instanceof Map) == true) goto L16;
        r1 = null;
    L16:
        Map r2 = (Map) r1;
        if (r2 != null) goto L20;
        r2 = MapsKt.emptyMap();
    L20:
        if (r5 != null) goto L22;
    L25:
        boolean r7 = true;
    L26:
        if (r7 == false) goto L43;
        Object r3 = r12.p(Reflection.getOrCreateKotlinClass(String.class), "common_self_save_biz_prefix");
        if ((r3 instanceof String) == true) goto L30;
        r3 = null;
    L30:
        String r6 = (String) r3;
        if ((r6 instanceof String) == true) goto L33;
        r5 = null;
    L34:
        Object r14 = r12.p(Reflection.getOrCreateKotlinClass(Map.class), "common_self_save_biz_fields");
        if ((r14 instanceof Map) == true) goto L37;
        r14 = null;
    L37:
        Map r15 = (Map) r14;
        if ((r15 instanceof Map) == true) goto L40;
        r2 = null;
    L41:
        if (r2 != null) goto L43;
        r2 = MapsKt.emptyMap();
        goto L43
    L40:
        r2 = r15;
        goto L41
    L33:
        r5 = r6;
    L43:
        if (r5 == null) goto L60;
        HashMap r16 = new HashMap();
        Iterator r8 = r2.entrySet().iterator();
    L46:
        if (r8.hasNext() == false) goto L52;
        Map.Entry r9 = (Map.Entry) r8.next();
        if (Intrinsics.areEqual((String) r9.getKey(), "time") == false) goto L50;
        Object r10 = String.valueOf(System.currentTimeMillis() / ((long) 1000));
    L51:
        r16.put(r5 + '_' + ((String) r9.getKey()), String.valueOf(r10));
        goto L46
    L50:
        r10 = r9.getValue();
        goto L51
    L52:
        com.bytedance.android.shopping.sku.common.ability.c r11 = this.a.zJ();
        if (r11 == null) goto L58;
        SkuParams r17 = r11.a();
        if (r17 == null) goto L58;
        String r18 = r17.getPromotionId();
        if (r18 == null) goto L58;
    L59:
        Lazy r19 = SkuCommonLog.a;
        SkuCommonLog.c("SkuYataSaveBizFieldsFunction", "doAction key:".concat(r18));
        SkuYataSelfSaveBizFieldsCacheController.b(r18, r16);
    L58:
        r18 = "";
    L60:
        int r110 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r13.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L22:
        if (r5.length() == 0) goto L25;
        r7 = false;
        goto L26
    L12:
        r1 = null;
        goto L14
    L5:
        r4 = null;
        goto L7
    }
}
