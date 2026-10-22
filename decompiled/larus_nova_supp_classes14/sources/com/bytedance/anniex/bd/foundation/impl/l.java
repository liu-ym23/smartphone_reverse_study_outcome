package com.bytedance.anniex.bd.foundation.impl;

import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class l {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public l(String r9) {
        Intrinsics.checkNotNullParameter(r9, "rgba");
        Intrinsics.checkNotNullParameter(r9, "hex");
        if (com.bytedance.rts.foundation.r.g(r9, "#") == false) goto L6;
        r9 = com.bytedance.rts.foundation.r.e(r9, 1, r9.length());
    L6:
        if (r9.length() != 3) goto L9;
        r9 = com.bytedance.rts.foundation.j.g(com.bytedance.rts.foundation.j.h(com.bytedance.rts.foundation.r.f(r9, "", -1), BDAnnieXSLBaseColorKt$normalizeRgba$1.INSTANCE), "") + "ff";
    L14:
        IntCompanionObject r0 = IntCompanionObject.INSTANCE;
        int r3 = 0;
        Integer r5 = com.bytedance.rts.foundation.k.a(r0, com.bytedance.rts.foundation.r.e(r9, 0, 2), 16);
        if (r5 == null) goto L17;
        int r6 = r5.intValue();
    L18:
        this.a = r6;
        Integer r4 = com.bytedance.rts.foundation.k.a(r0, com.bytedance.rts.foundation.r.e(r9, 2, 4), 16);
        if (r4 == null) goto L21;
        int r7 = r4.intValue();
    L22:
        this.b = r7;
        Integer r2 = com.bytedance.rts.foundation.k.a(r0, com.bytedance.rts.foundation.r.e(r9, 4, 6), 16);
        if (r2 == null) goto L25;
        r3 = r2.intValue();
    L25:
        this.c = r3;
        Integer r10 = com.bytedance.rts.foundation.k.a(r0, com.bytedance.rts.foundation.r.e(r9, 6, 8), 16);
        if (r10 == null) goto L28;
        int r11 = r10.intValue();
    L29:
        this.d = r11;
        return;
    L28:
        r11 = 255;
        goto L29
    L21:
        r7 = 0;
        goto L22
    L17:
        r6 = 0;
        goto L18
    L9:
        if (r9.length() != 4) goto L12;
        r9 = com.bytedance.rts.foundation.j.g(com.bytedance.rts.foundation.j.h(com.bytedance.rts.foundation.r.f(r9, "", -1), BDAnnieXSLBaseColorKt$normalizeRgba$2.INSTANCE), "");
        goto L14
    L12:
        if (r9.length() != 6) goto L14;
        r9 = r9.concat("ff");
        goto L14
    }

    public l(int r1, int r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
