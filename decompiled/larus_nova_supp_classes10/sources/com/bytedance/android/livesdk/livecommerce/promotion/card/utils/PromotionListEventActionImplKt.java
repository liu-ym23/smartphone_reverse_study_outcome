package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import java.util.Map;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PromotionListEventActionImplKt {
    public static final void a(final sg2.v r7, com.bytedance.android.livesdk.livecommerce.promotion.card.e r8, String r9) {
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        if (r8 == null) goto L11;
        String r2 = r7.d;
        Map<String, String> r3 = r7.g();
        com.bytedance.android.ec.common.api.jump.model.g r1 = r7.e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class));
        if (r1 == null) goto L7;
        ql.a r4 = r1.a;
    L8:
        boolean r10 = r8.a(r2, r3, r9, r4, new PromotionListEventActionImplKt$saveByIntercept$1(r7, r0));
        boolean r5 = true;
        if (r10 != true) goto L11;
    L12:
        r0.element = r5;
        if (r5 == false) goto L15;
        return;
    L15:
        r7.i(r9);
        return;
    L7:
        r4 = null;
    L11:
        r5 = false;
        goto L12
    }
}
