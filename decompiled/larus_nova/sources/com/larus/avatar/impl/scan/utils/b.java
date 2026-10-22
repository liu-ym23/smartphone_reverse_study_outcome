package com.larus.avatar.impl.scan.utils;

import android.graphics.Bitmap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    public static final Bitmap a(Bitmap r100) {
        if (r100 != null) goto L5;
    L11:
        return null;
    L5:
        if (r100.isRecycled() == true) goto L11;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        return r100.copy(Bitmap.Config.ARGB_8888, true);
    L9:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final void b(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isRecycled() == true) goto L14;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        r100.recycle();     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    }
}
