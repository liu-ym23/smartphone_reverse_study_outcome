package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a a;

    public static final class a {
    }

    static {
    }

    public a0(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Object r0 = r7.p(Reflection.getOrCreateKotlinClass(String.class), "scene_code");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        Object r3 = r7.p(Reflection.getOrCreateKotlinClass(Map.class), "params");
        if (TypeIntrinsics.isMutableMap(r3) == true) goto L11;
        r3 = null;
    L11:
        Map<String, Object> r4 = (Map) r3;
        if (r4 != null) goto L14;
        r4 = new LinkedHashMap();
    L14:
        Object r8 = r7.p(Reflection.getOrCreateKotlinClass(Boolean.class), "overwrite");
        if ((r8 instanceof Boolean) == true) goto L17;
        r8 = null;
    L17:
        Boolean r9 = (Boolean) r8;
        if (r9 == null) goto L20;
        boolean r10 = r9.booleanValue();
    L21:
        Map<String, Map<String, Object>> r5 = this.a.P0();
        if (Intrinsics.areEqual(r1, "") == false) goto L25;
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "scene_code is null", null, null, 57);
    L25:
        if (r10 == false) goto L27;
        r5.clear();
    L27:
        r5.put(r1, r4);
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L20:
        r10 = false;
        goto L21
    }
}
