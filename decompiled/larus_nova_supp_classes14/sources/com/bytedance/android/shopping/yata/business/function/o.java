package com.bytedance.android.shopping.yata.business.function;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends com.bytedance.kmp.ec.yata.event.common.b {
    public final kl3.a a;

    public static final class a {
    }

    static {
    }

    public o(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Map r0 = this.a.c().a(r7);
        if (r0 == null) goto L5;
        Object r1 = r0.get("event_name");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        Map r3 = this.a.c().a(r7);
        if (r3 == null) goto L12;
        Object r4 = r3.get("event_params");
    L14:
        if ((r4 instanceof Map) == true) goto L16;
        r4 = null;
    L16:
        Map r5 = (Map) r4;
        Map r6 = this.a.c().a(r7);
        if (r6 == null) goto L19;
        Object r8 = r6.get("event_params_keys");
    L21:
        if ((r8 instanceof List) == true) goto L23;
        r8 = null;
    L23:
        List r9 = (List) r8;
        if (this.a.d().b(r2) == false) goto L27;
        ll3.b.a(this.a, "selfSendEvent", "event_name is empty", r7);
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "event_name is empty", null, null, 57);
    L27:
        if (r5 == null) goto L30;
        Map r11 = MapsKt.toMutableMap(r5);
        if (r11 == null) goto L30;
    L31:
        if (r9 == null) goto L36;
        Iterator r12 = r9.iterator();
    L34:
        if (r12.hasNext() == false) goto L36;
        String r13 = (String) r12.next();
        r11.put(r13, this.a.b().d(r13));
    L36:
        com.bytedance.android.shopping.buynow.yata.abilities.d r14 = this.a.a();
        Intrinsics.checkNotNull(r2);
        r14.a(r2, r11);
        int r15 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L30:
        r11 = new LinkedHashMap();
        goto L31
    L19:
        r8 = null;
        goto L21
    L12:
        r4 = null;
        goto L14
    L5:
        r1 = null;
        goto L7
    }
}
