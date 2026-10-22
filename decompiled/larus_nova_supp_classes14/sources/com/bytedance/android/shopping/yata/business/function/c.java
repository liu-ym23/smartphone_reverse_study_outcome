package com.bytedance.android.shopping.yata.business.function;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends com.bytedance.kmp.ec.yata.event.common.a {
    public final kl3.a a;

    public static final class a {
    }

    static {
    }

    public c(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r5, final Function1 r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r6, "chainNextCallback");
        ll3.a.a("selfDelay", "selfDelay starts");
        Map r1 = this.a.c().a(r5);
        if (r1 == null) goto L5;
        Object r2 = r1.get("duration");
    L7:
        if ((r2 instanceof Integer) == true) goto L9;
        r2 = null;
    L9:
        Integer r3 = (Integer) r2;
        if (this.a.d().c(r3) == true) goto L13;
        ll3.b.a(this.a, "selfDelay", "duration is not positive", r5);
        int r7 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r6.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L13:
        kl3.e r8 = this.a.f();
        Intrinsics.checkNotNull(r3);
        r8.a(r3.intValue(), new SelfDelayFunction$onExecuteAsync$1(r6));
        return;
    L5:
        r2 = null;
        goto L7
    }
}
