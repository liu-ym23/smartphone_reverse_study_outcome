package com.larus.asr;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes24.dex */
public final class a2 {
    public static final Integer a(Context r100, Integer r101) {
        if (r101 == null) goto L14;
        r101.intValue();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        Object r103 = Result.m9449constructorimpl(Integer.valueOf(ContextCompat.getColor(r100, r101.intValue())));     // Catch: Throwable -> L6
    L8:
        Object r104 = r101;
        if (Result.m9455isFailureimpl(r103) == true) goto L13;
        r104 = r103;
    L13:
        return (Integer) r104;
    L6:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    L14:
        return null;
    }
}
