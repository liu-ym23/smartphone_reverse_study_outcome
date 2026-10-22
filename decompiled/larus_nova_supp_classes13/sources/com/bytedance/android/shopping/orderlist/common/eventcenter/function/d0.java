package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d0 extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a a;

    public static final class a {
    }

    static {
    }

    public d0(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r8) {
        Intrinsics.checkNotNullParameter(r8, "input");
        Object r0 = r8.p(Reflection.getOrCreateKotlinClass(String.class), "scene_code");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        Object r3 = r8.p(Reflection.getOrCreateKotlinClass(List.class), "params");
        if ((r3 instanceof List) == true) goto L11;
        r3 = null;
    L11:
        List r4 = (List) r3;
        if (r4 != null) goto L14;
        r4 = CollectionsKt.emptyList();
    L14:
        Object r9 = r8.p(Reflection.getOrCreateKotlinClass(Boolean.class), "clear");
        if ((r9 instanceof Boolean) == true) goto L17;
        r9 = null;
    L17:
        Boolean r10 = (Boolean) r9;
        if (r10 == null) goto L20;
        boolean r11 = r10.booleanValue();
    L21:
        Map<String, Map<String, Object>> r5 = this.a.P0();
        if (r11 == false) goto L26;
        r5.clear();
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L26:
        if (Intrinsics.areEqual(r1, "") == false) goto L30;
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "scene_code is null", null, null, 57);
    L30:
        if (r5.containsKey(r1) == true) goto L34;
        int r14 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "scene_code is wrong", null, null, 57);
    L34:
        if (r4.isEmpty() == false) goto L37;
        r5.remove(r1);
        int r15 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L37:
        Iterator r16 = r4.iterator();
    L39:
        if (r16.hasNext() == false) goto L43;
        String r2 = (String) r16.next();
        Map<String, Object> r6 = r5.get(r1);
        if (r6 == null) goto L39;
        r6.remove(r2);
        goto L39
    L43:
        int r17 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L20:
        r11 = false;
        goto L21
    }
}
