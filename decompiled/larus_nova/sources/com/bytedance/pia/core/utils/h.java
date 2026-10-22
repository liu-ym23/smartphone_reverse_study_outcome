package com.bytedance.pia.core.utils;

import java.io.InputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes21.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final String a(i47.e r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        String r102 = r100.getEncoding();     // Catch: Throwable -> L9
    L7:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r103) == false) goto L14;
        r103 = null;
    L14:
        String r104 = (String) r103;
        if (r100 == null) goto L22;
        InputStream r105 = r100.getData();
        if (r105 != null) goto L19;
        return null;
    L19:
        return StreamUtils.b(r105, r104);
    L22:
        return null;
    L6:
        r102 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
