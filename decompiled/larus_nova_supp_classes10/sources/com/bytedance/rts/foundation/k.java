package com.bytedance.rts.foundation;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k {
    public static final double b(IntCompanionObject r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(IntCompanionObject.INSTANCE, "<this>");
        return r2;
    }

    public static final void c(IntCompanionObject r0, int r1) {
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(IntCompanionObject.INSTANCE, "<this>");
    }

    public static final long d(IntCompanionObject r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(IntCompanionObject.INSTANCE, "<this>");
        return r2;
    }

    public static final Integer a(IntCompanionObject r2, String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "str");
        Intrinsics.checkNotNullParameter(IntCompanionObject.INSTANCE, "<this>");
        Intrinsics.checkNotNullParameter(r3, "str");
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L14:
        x r6 = l.a(r3, __RTS_internal_ParseOption.PARSE);     // Catch: NumberFormatException -> L13
        if (r6.c != __RTS_internal_ExplicitType.UNKNOWN) goto L11;
        return Integer.valueOf(CastIntegerProtector.parseInt(r6.a, CharsKt.checkRadix(r5)));
    L11:
        return null;
    L5:
        r5 = 10;
        goto L14
    }
}
