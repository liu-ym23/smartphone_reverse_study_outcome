package com.bytedance.rts.foundation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l {
    public static final x a(String r100, __RTS_internal_ParseOption r101) {
        Intrinsics.checkNotNullParameter(r100, "s");
        Intrinsics.checkNotNullParameter(r101, "opt");
        x r102 = new x();
        if (r.b(r100, "i32") == false) goto L5;
    L30:
        String r103 = r.e(r100, 0, r100.length() - 3);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f267595a = r103;
        __RTS_internal_ExplicitType r104 = __RTS_internal_ExplicitType.INT_32;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f267597c = r104;
        return r102;
    L5:
        if (r.b(r100, "I32") == true) goto L30;
        if (r.b(r100, "i64") == false) goto L10;
    L28:
        String r105 = r.e(r100, 0, r100.length() - 3);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r102.f267595a = r105;
        __RTS_internal_ExplicitType r106 = __RTS_internal_ExplicitType.INT_64;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r102.f267597c = r106;
        return r102;
    L10:
        if (r.b(r100, "I64") == true) goto L28;
        if (r.b(r100, "f32") == false) goto L15;
    L26:
        String r107 = r.e(r100, 0, r100.length() - 3);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r102.f267595a = r107;
        __RTS_internal_ExplicitType r108 = __RTS_internal_ExplicitType.FLOAT_32;
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r102.f267597c = r108;
        return r102;
    L15:
        if (r.b(r100, "F32") == true) goto L26;
        if (r.b(r100, "f64") == false) goto L20;
    L24:
        String r109 = r.e(r100, 0, r100.length() - 3);
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r102.f267595a = r109;
        __RTS_internal_ExplicitType r110 = __RTS_internal_ExplicitType.FLOAT_64;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r102.f267597c = r110;
        return r102;
    L20:
        if (r.b(r100, "F64") == true) goto L24;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r102.f267595a = r100;
        return r102;
    }
}
