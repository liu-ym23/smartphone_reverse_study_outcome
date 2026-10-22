package com.larus.bmhome.chat.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i1 {
    public static final boolean a(wh8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.f559714g;
        if (r101 != null) goto L6;
    L8:
        return false;
    L6:
        if (r101.intValue() != 1) goto L8;
        return true;
    }

    public static final boolean b(wh8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.f559714g;
        if (r101 != null) goto L6;
    L7:
        Integer r102 = r100.f559714g;
        if (r102 != null) goto L11;
    L13:
        return false;
    L11:
        if (r102.intValue() != 10) goto L13;
    L14:
        return true;
    L6:
        if (r101.intValue() == 9) goto L14;
        goto L7
    }
}
