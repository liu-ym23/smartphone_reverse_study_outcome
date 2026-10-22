package com.ss.android.lark.passport.flow.core.network.handler;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {
    static {
    }

    public static Integer a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        CodeHandlerAnno r101 = (CodeHandlerAnno) r100.getClass().getAnnotation(CodeHandlerAnno.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r101.code());
    }
}
