package com.github.alexzhirkevich.customqrgenerator.vector.style;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class f {
    public static final boolean a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof e.b) == false) goto L5;
    L12:
        return true;
    L5:
        if ((r100 instanceof e.c) == true) goto L12;
        if ((r100 instanceof e.a) == true) goto L9;
    L11:
        return false;
    L9:
        if (((((e.a) r100).f274280a >> 24) & 255) != 0) goto L11;
        goto L11
    }
}
