package com.obric.assistant.common.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    static {
    }

    @JvmStatic
    public static final boolean a(Context r100) {
        if (r100 == null) goto L33;
    L31:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L21
        if (Build.VERSION.SDK_INT < 28) goto L18;
        boolean r102 = Intrinsics.areEqual(r100.getPackageName(), Application.getProcessName());     // Catch: Throwable -> L21
    L19:
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L21
    L23:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L26;
        FLogger.f375446a.w("ObricProcessUtils", "isMainProcessSafe failed: " + r104.getMessage(), r104);
    L26:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L30;
        r103 = r105;
    L30:
        return ((Boolean) r103).booleanValue();
    L18:
        r102 = ita.k.i(r100);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L33:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L5
        Object r108 = Result.m9449constructorimpl(AppHost.f326268a.getApplication());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r108) == false) goto L10;
        r108 = null;
    L10:
        r100 = (Application) r108;
        if (r100 != null) goto L31;
        return false;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
