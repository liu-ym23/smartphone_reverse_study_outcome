package com.bytedance.android.shopping.yata.business.function;

import android.view.View;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q extends com.bytedance.kmp.ec.yata.event.common.b {
    public final kl3.a a;

    public static final class a {
    }

    static {
    }

    public q(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r8) {
        Intrinsics.checkNotNullParameter(r8, "input");
        ll3.a.a("selfTransformLocation", "SelfTransformLocation starts");
        Map r1 = this.a.c().a(r8);
        if (r1 == null) goto L5;
        Object r3 = r1.get("match_vo");
    L7:
        if ((r3 instanceof Map) == true) goto L9;
        r3 = null;
    L9:
        Map r4 = (Map) r3;
        if (r1 == null) goto L12;
        Object r5 = r1.get("slice_key");
    L14:
        if ((r5 instanceof String) == true) goto L16;
        r5 = null;
    L16:
        String r6 = (String) r5;
        if (r1 == null) goto L19;
        Object r2 = r1.get("ignore_null");
    L21:
        if ((r2 instanceof Boolean) == true) goto L23;
        r2 = null;
    L23:
        boolean r7 = Intrinsics.areEqual((Boolean) r2, Boolean.TRUE);
        if (r4 != null) goto L26;
    L29:
        boolean r9 = true;
    L30:
        if (r9 == true) goto L36;
        View r10 = this.a.b().b(r4);
        if (r10 == null) goto L35;
        if (r6 == null) goto L35;
        r10 = this.a.r().a(r10, r6);
    L35:
        Map r11 = this.a.b().c(r10);
    L41:
        if (r7 == false) goto L43;
    L46:
        ll3.a.a("selfTransformLocation", "SelfTransformLocation finishes");
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("boundingRect", r11)), null, 5);
    L43:
        if (this.a.d().b(r11) == false) goto L46;
        ll3.b.a(this.a, "selfTransformLocation", "boundingRect is empty", r8);
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "boundingRect is empty", null, null, 57);
    L36:
        View r14 = this.a.c().f(r8);
        if (r14 == null) goto L40;
        if (r6 == null) goto L40;
        r14 = this.a.r().a(r14, r6);
    L40:
        r11 = this.a.b().c(r14);
        goto L41
    L26:
        if (r4.isEmpty() == true) goto L29;
        r9 = false;
        goto L30
    L19:
        r2 = null;
        goto L21
    L12:
        r5 = null;
        goto L14
    L5:
        r3 = null;
        goto L7
    }
}
