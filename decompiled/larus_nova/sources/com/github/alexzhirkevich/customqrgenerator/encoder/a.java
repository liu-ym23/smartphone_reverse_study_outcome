package com.github.alexzhirkevich.customqrgenerator.encoder;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static final com.github.alexzhirkevich.customqrgenerator.style.c a(QrCodeMatrix r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        int r100 = r111 - 1;
        int r101 = r112 - 1;
        int r102 = r111 + 1;
        int r103 = r112 + 1;
        return new com.github.alexzhirkevich.customqrgenerator.style.c(b(r110, r111, r112, r100, r101), b(r110, r111, r112, r102, r101), b(r110, r111, r112, r100, r112), b(r110, r111, r112, r111, r101), b(r110, r111, r112, r102, r112), b(r110, r111, r112, r100, r103), b(r110, r111, r112, r111, r103), b(r110, r111, r112, r102, r103));
    }

    public static final boolean b(QrCodeMatrix r100, int r101, int r102, int r103, int r104) {
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
        if (r100.a(r103, r104) != r100.a(r101, r102)) goto L5;
        boolean r106 = true;
    L6:
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(r106));     // Catch: Throwable -> L8
    L10:
        Boolean r108 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r107) == false) goto L14;
        r107 = r108;
    L14:
        return ((Boolean) r107).booleanValue();
    L5:
        r106 = false;
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
