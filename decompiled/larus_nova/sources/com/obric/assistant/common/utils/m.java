package com.obric.assistant.common.utils;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f387884a = null;

    static {
        f387884a = new m();
    }

    public m() {
    }

    public static boolean a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(StringsKt.equals(t9a.b.b().b().f(), "NON_EEA", true)));     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L9;
        FLogger.f375446a.w("ObricRegionUtils", "isHK failed", r102);
    L9:
        Boolean r103 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L13;
        r101 = r103;
    L13:
        return ((Boolean) r101).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
