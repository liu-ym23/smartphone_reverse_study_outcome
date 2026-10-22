package com.obric.assistant.common.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import ita.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class l {
    static {
    }

    @JvmStatic
    public static final boolean a(Context r4) {
        if (r4 == null) goto L33;
    L31:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        if (Build.VERSION.SDK_INT < 28) goto L18;
        boolean r5 = Intrinsics.areEqual(r4.getPackageName(), Application.getProcessName());     // Catch: Throwable -> L21
    L19:
        Object r6 = Result.m49constructorimpl(Boolean.valueOf(r5));     // Catch: Throwable -> L21
    L23:
        Throwable r1 = Result.m52exceptionOrNullimpl(r6);
        if (r1 == null) goto L26;
        FLogger.a.w("ObricProcessUtils", "isMainProcessSafe failed: " + r1.getMessage(), r1);
    L26:
        Boolean r2 = Boolean.FALSE;
        if (Result.m55isFailureimpl(r6) == false) goto L30;
        r6 = r2;
    L30:
        return ((Boolean) r6).booleanValue();
    L18:
        r5 = k.i(r4);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L23
    L33:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.m49constructorimpl(AppHost.a.getApplication());     // Catch: Throwable -> L5
    L8:
        if (Result.m55isFailureimpl(r8) == false) goto L10;
        r8 = null;
    L10:
        r4 = (Application) r8;
        if (r4 != null) goto L31;
        return false;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
