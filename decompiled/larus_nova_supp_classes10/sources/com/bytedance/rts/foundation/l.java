package com.bytedance.rts.foundation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l {
    public static final x a(String r3, __RTS_internal_ParseOption r4) {
        Intrinsics.checkNotNullParameter(r3, "s");
        Intrinsics.checkNotNullParameter(r4, "opt");
        x r5 = new x();
        if (r.b(r3, "i32") == false) goto L5;
    L30:
        String r6 = r.e(r3, 0, r3.length() - 3);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.a = r6;
        __RTS_internal_ExplicitType r7 = __RTS_internal_ExplicitType.INT_32;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r5.c = r7;
        return r5;
    L5:
        if (r.b(r3, "I32") == true) goto L30;
        if (r.b(r3, "i64") == false) goto L10;
    L28:
        String r8 = r.e(r3, 0, r3.length() - 3);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r5.a = r8;
        __RTS_internal_ExplicitType r9 = __RTS_internal_ExplicitType.INT_64;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r5.c = r9;
        return r5;
    L10:
        if (r.b(r3, "I64") == true) goto L28;
        if (r.b(r3, "f32") == false) goto L15;
    L26:
        String r10 = r.e(r3, 0, r3.length() - 3);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r5.a = r10;
        __RTS_internal_ExplicitType r11 = __RTS_internal_ExplicitType.FLOAT_32;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r5.c = r11;
        return r5;
    L15:
        if (r.b(r3, "F32") == true) goto L26;
        if (r.b(r3, "f64") == false) goto L20;
    L24:
        String r12 = r.e(r3, 0, r3.length() - 3);
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r5.a = r12;
        __RTS_internal_ExplicitType r13 = __RTS_internal_ExplicitType.FLOAT_64;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r5.c = r13;
        return r5;
    L20:
        if (r.b(r3, "F64") == true) goto L24;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r5.a = r3;
        return r5;
    }
}
