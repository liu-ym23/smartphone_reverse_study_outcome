package com.bytedance.android.shopping.slice.elements.bgdecorprojection;

import android.graphics.Bitmap;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final long a(Bitmap r4) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        if ((!r4.isRecycled()) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L21;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(Long.valueOf(r4.getAllocationByteCount()));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == false) goto L17;
        r5 = 0L;
    L17:
        return ((Number) r5).longValue();
    L11:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L21:
        return 0;
    }

    public static final void b(Bitmap r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if ((!r1.isRecycled()) == true) goto L7;
        r1 = null;
    L7:
        if (r1 == null) goto L11;
        r1.recycle();
        return;
    }
}
