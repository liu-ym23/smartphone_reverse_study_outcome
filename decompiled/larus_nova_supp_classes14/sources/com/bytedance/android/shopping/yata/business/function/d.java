package com.bytedance.android.shopping.yata.business.function;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends com.bytedance.kmp.ec.yata.event.common.a {
    public final kl3.a a;

    public static final class a {
    }

    static {
    }

    public d(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r5, Function1 r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r6, "chainNextCallback");
        ll3.a.a("selfLoading", "selfLoading starts");
        Map r7 = this.a.c().a(r5);
        if (r7 == null) goto L5;
        Object r8 = r7.get("flag");
    L7:
        if ((r8 instanceof Boolean) == true) goto L10;
        r8 = null;
    L10:
        if (this.a.d().d((Boolean) r8) == false) goto L12;
        this.a.b().l(true);
    L13:
        ll3.a.a("selfLoading", "selfLoading finishes");
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r6.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L12:
        this.a.b().l(false);
        goto L13
    L5:
        r8 = null;
        goto L7
    }
}
