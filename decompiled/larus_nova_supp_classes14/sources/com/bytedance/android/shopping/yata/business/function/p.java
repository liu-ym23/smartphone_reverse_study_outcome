package com.bytedance.android.shopping.yata.business.function;

import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p extends com.bytedance.kmp.ec.yata.event.common.a {
    public final kl3.a a;

    public static final class a {
    }

    static {
    }

    public p(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, final Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        Map r0 = this.a.c().a(r7);
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("tt_pay_params");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r0 == null) goto L12;
        Object r4 = r0.get("success_code");
    L14:
        if ((r4 instanceof List) == false) goto L17;
        r1 = r4;
    L17:
        final List r5 = (List) r1;
        JSONObject r6 = this.a.d().e(r3);
        if (this.a.d().b(r6) == false) goto L21;
        ll3.b.a(this.a, "selfTTPay", "ttpay params is empty", r7);
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "ttpay params is empty", null, null, 57));
        return;
    L21:
        kl3.c r10 = this.a.e();
        Intrinsics.checkNotNull(r6);
        r10.a(r6, new SelfTTPayFunction$onExecuteAsync$1(r5, r8));
        return;
    L12:
        r4 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }
}
