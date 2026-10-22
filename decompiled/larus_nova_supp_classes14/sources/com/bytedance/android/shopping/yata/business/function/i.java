package com.bytedance.android.shopping.yata.business.function;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends com.bytedance.kmp.ec.yata.event.common.b {
    public final kl3.a a;

    public static final class a {
    }

    static {
    }

    public i(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r13) {
        Intrinsics.checkNotNullParameter(r13, "input");
        Object r0 = r13.p(Reflection.getOrCreateKotlinClass(String.class), "field_path");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (this.a.d().b(r1) == false) goto L9;
        ll3.b.a(this.a, "selfReadFieldAndTrigger", "field_path is empty", r13);
        int r14 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "field_path is empty", null, null, 57);
    L9:
        Object r2 = this.a.d().a(this.a.c().b(r13), r1, null);
        if (this.a.d().b(r2) == false) goto L13;
        ll3.b.a(this.a, "selfReadFieldAndTrigger", "target " + r1 + " is empty", r13);
        int r15 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "target " + r1 + " is empty", null, null, 57);
    L13:
        String r16 = this.a.c().c(r13);
        com.bytedance.android.shopping.buynow.yata.abilities.l r3 = this.a.c();
        if (r2 == null) goto L16;
        String r4 = r2.toString();
    L17:
        r3.h(r16, r4, null);
        int r17 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L16:
        r4 = null;
        goto L17
    }
}
