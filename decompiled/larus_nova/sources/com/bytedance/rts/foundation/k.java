package com.bytedance.rts.foundation;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class k {
    public static final double b(IntCompanionObject r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(IntCompanionObject.INSTANCE, "<this>");
        return r101;
    }

    public static final void c(IntCompanionObject r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(IntCompanionObject.INSTANCE, "<this>");
    }

    public static final long d(IntCompanionObject r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(IntCompanionObject.INSTANCE, "<this>");
        return r101;
    }

    public static final Integer a(IntCompanionObject r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "str");
        Intrinsics.checkNotNullParameter(IntCompanionObject.INSTANCE, "<this>");
        Intrinsics.checkNotNullParameter(r101, "str");
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L14:
        x r104 = l.a(r101, __RTS_internal_ParseOption.PARSE);     // Catch: NumberFormatException -> L13
        if (r104.f267597c != __RTS_internal_ExplicitType.UNKNOWN) goto L11;
        return Integer.valueOf(CastIntegerProtector.parseInt(r104.f267595a, CharsKt.checkRadix(r103)));
    L11:
        return null;
    L5:
        r103 = 10;
        goto L14
    }
}
