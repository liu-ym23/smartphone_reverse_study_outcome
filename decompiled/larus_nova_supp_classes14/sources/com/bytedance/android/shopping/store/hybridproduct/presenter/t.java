package com.bytedance.android.shopping.store.hybridproduct.presenter;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t {
    public static final rn.d a(dj3.c r18) {
        Intrinsics.checkNotNullParameter(r18, "config");
        List r2 = CollectionsKt.listOf(new sn.d.c(3000));
        int r3 = com.bytedance.android.ec.core.utils.s.a;
        Integer r4 = com.bytedance.android.ec.core.utils.s.b(r18.a());
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        int r7 = r5;
        float r6 = 11;
        float r8 = 12;
        tn.a.c r9 = new tn.a.c(10, 10, true, r7, new tn.a.a(r6, r6, r8, r8));
        rn.c[] r10 = new rn.c[3];
        r10[0] = new rn.b(new tn.a.b());
        List r11 = CollectionsKt.emptyList();
        Long r12 = r18.b();
        if (r12 == null) goto L9;
        int r13 = (int) r12.longValue();
    L10:
        int r14 = com.bytedance.android.ec.core.utils.s.a(r18.f(), -1);
        String r15 = r18.e();
        if (r15 != null) goto L13;
        r15 = "";
    L13:
        String r16 = r15;
        if (com.bytedance.android.shopping.extensions.k.h(r18.c()) <= 400) goto L16;
        boolean r17 = true;
    L17:
        r10[1] = new rn.f(r11, new tn.a.e(-2, r13, r14, r16, r17));
        r10[2] = new rn.b(new tn.a.b());
        return new rn.d(r2, r9, CollectionsKt.listOf(r10));
    L16:
        r17 = false;
        goto L17
    L9:
        r13 = 13;
        goto L10
    L5:
        r5 = (int) 3862510404L;
        goto L6
    }
}
