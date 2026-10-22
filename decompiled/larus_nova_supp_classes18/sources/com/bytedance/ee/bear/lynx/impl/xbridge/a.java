package com.bytedance.ee.bear.lynx.impl.xbridge;

import com.bytedance.ies.xbridge.XReadableMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final Number a(XReadableMap r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "key");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Integer.valueOf(r4.getInt(r5)));     // Catch: Throwable -> L5
    L7:
        Object r2 = null;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        Integer r3 = (Integer) r1;
        if (r3 == null) goto L13;
        int r6 = r3.intValue();
    L34:
        Object r7 = Result.constructor-impl(Double.valueOf(r4.getDouble(r5)));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r7) == true) goto L22;
        r2 = r7;
    L22:
        Double r8 = (Double) r2;
        if (r8 == null) goto L25;
        double r9 = r8.doubleValue();
    L27:
        if (Double.compare(r6, r9) == 0) goto L38;
        long r10 = (long) r9;
        if (Double.compare(r9, r10) != 0) goto L33;
        return Long.valueOf(r10);
    L33:
        return Double.valueOf(r9);
    L38:
        return Integer.valueOf(r6);
    L25:
        r9 = 0.0d;
    L16:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L13:
        r6 = 0;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
