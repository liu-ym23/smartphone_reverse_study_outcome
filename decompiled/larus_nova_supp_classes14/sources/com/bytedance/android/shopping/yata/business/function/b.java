package com.bytedance.android.shopping.yata.business.function;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends com.bytedance.kmp.ec.yata.event.common.b {
    public final kl3.a a;

    public static final class a {
    }

    static {
    }

    public b(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Map r0 = this.a.c().a(r7);
        if (r0 == null) goto L5;
        Object r2 = r0.get("match_vo");
    L7:
        if ((r2 instanceof Map) == true) goto L9;
        r2 = null;
    L9:
        final Map r3 = (Map) r2;
        if (r0 == null) goto L12;
        Object r4 = r0.get("trigger_params");
    L14:
        if ((r4 instanceof Map) == true) goto L16;
        r4 = null;
    L16:
        Map r5 = (Map) r4;
        if (r0 == null) goto L19;
        Object r1 = r0.get("trigger_type");
    L21:
        if ((r1 instanceof String) == true) goto L23;
        r1 = null;
    L23:
        String r6 = (String) r1;
        List r8 = this.a.c().d(new SelfCrossTriggerFunction$onExecuteSync$matchVoNodes$1(r3));
        if (r8.isEmpty() == false) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L30;
        ll3.b.a(this.a, "selfCrossTrigger", "matchVoNodes is null", r7);
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "matchVoNodes is null", null, null, 57);
    L30:
        Iterator r11 = r8.iterator();
    L32:
        if (r11.hasNext() == false) goto L34;
        this.a.c().h(((com.bytedance.kmp.ec.yata.store.node.c) r11.next()).getKey(), r6, r5);
        goto L32
    L34:
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L26:
        r9 = false;
        goto L27
    L19:
        r1 = null;
        goto L21
    L12:
        r4 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }
}
