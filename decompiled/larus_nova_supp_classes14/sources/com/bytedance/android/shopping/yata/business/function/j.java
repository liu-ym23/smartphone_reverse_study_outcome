package com.bytedance.android.shopping.yata.business.function;

import com.bytedance.android.shopping.yata.business.function.common.RegexCheck;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends com.bytedance.kmp.ec.yata.event.common.b {
    public final kl3.a a;

    public static final class a {
    }

    static {
    }

    public j(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r9) {
        Intrinsics.checkNotNullParameter(r9, "input");
        Map r0 = this.a.c().a(r9);
        if (r0 == null) goto L5;
        Object r1 = r0.get("regex_rules");
    L7:
        if ((r1 instanceof List) == true) goto L9;
        r1 = null;
    L9:
        List r4 = (List) r1;
        Map r5 = this.a.c().b(r9);
        String r7 = this.a.c().c(r9);
        int r2 = RegexCheck.a;
        if (RegexCheck.a("selfRegexCheck", this.a, r4, r5, r9, r7) == false) goto L13;
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L13:
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, true, "no match", null, null, 57);
    L5:
        r1 = null;
        goto L7
    }
}
