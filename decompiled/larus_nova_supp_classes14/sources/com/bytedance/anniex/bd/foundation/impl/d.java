package com.bytedance.anniex.bd.foundation.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Locale;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final String a(int r5) {
        int r0 = com.bytedance.rts.foundation.c.a;
        int r1 = com.bytedance.rts.foundation.h.a;
        return com.bytedance.rts.foundation.r.a("0123456789ABCDEF", (int) Math.floor(com.bytedance.rts.foundation.k.b(IntCompanionObject.INSTANCE, r5) / ((double) 16))) + com.bytedance.rts.foundation.r.a("0123456789ABCDEF", r5 % 16);
    }

    public static final boolean b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "str");
        if (Intrinsics.areEqual(r7, "") == false) goto L5;
        return false;
    L5:
        String r8 = StringsKt.trim(r7).toString();
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        String r9 = r8.toUpperCase(Locale.ROOT);
        boolean r2 = com.bytedance.rts.foundation.r.g(r9, "#");
        Object r10 = r9;
        if (r2 == false) goto L8;
        r10 = ListProtector.get(com.bytedance.rts.foundation.r.f(r9, "#", -1), 1);
    L8:
        String r11 = (String) r10;
        int r0 = r11.length();
        if (r0 != 3) goto L11;
    L17:
        int r3 = 0;
    L18:
        if (r3 >= r0) goto L30;
        String r4 = com.bytedance.rts.foundation.r.a(r11, r3);
        int r5 = 0;
    L21:
        if (r5 >= 16) goto L26;
        if (Intrinsics.areEqual(r4, com.bytedance.rts.foundation.r.a("0123456789ABCDEF", r5)) == true) goto L24;
        r5 = r5 + 1;
        goto L21
    L24:
        boolean r6 = true;
    L27:
        if (r6 == false) goto L28;
        r3 = r3 + 1;
        goto L18
    L28:
        return false;
    L26:
        r6 = false;
        goto L27
    L30:
        return true;
    L11:
        if (r0 == 4) goto L17;
        if (r0 == 6) goto L17;
        if (r0 == 8) goto L17;
        return false;
    }
}
