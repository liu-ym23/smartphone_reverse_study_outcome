package com.larus.im.internal.core.message.converter;

import juc.d;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> String a(T r110, d<T> r111) {
        Intrinsics.checkNotNullParameter(r111, "serializer");
        if (r110 != 0) goto L29;
        return "";
    L29:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        wt7.a.f561230a.getClass();     // Catch: Throwable -> L7
        Object r112 = Result.m9449constructorimpl(wt7.c.b(r110, r111));     // Catch: Throwable -> L7
    L9:
        Throwable r101 = Result.m9452exceptionOrNullimpl(r112);
        if (r101 == null) goto L22;
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L22;
        com.larus.im.internal.delegate.a r102 = com.larus.im.internal.delegate.a.f348188b;
        StringBuilder r103 = new StringBuilder("convert2Json failed, obj: ");
        if ((r110 instanceof vt7.b) == false) goto L16;
        vt7.b r104 = (vt7.b) r110;
    L17:
        if (r104 == null) goto L19;
        String r113 = CollectionsKt.joinToString$default(r104, null, null, null, 0, null, null, 63, null);
    L20:
        r103.append(r113);
        r103.append(" stack: ");
        r103.append(ExceptionsKt.stackTraceToString(r101));
        r102.e("convert2Json", r103.toString());
        goto L22
    L19:
        r113 = null;
        goto L20
    L16:
        r104 = null;
    L22:
        if (Result.m9455isFailureimpl(r112) == false) goto L24;
        r112 = null;
    L24:
        String r114 = (String) r112;
        if (r114 != null) goto L28;
        return "";
    L28:
        return r114;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
