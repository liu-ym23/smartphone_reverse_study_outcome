package com.larus.paging;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q {
    public static final boolean a(f1 r100, f1 r101, LoadType r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "loadType");
        if (r101 != null) goto L6;
        return true;
    L6:
        if ((r101 instanceof f1.b) == false) goto L11;
        if ((r100 instanceof f1.a) == false) goto L11;
        return true;
    L11:
        if ((r100 instanceof f1.b) == false) goto L16;
        if ((r101 instanceof f1.a) == false) goto L16;
    L14:
        return false;
    L16:
        if (r100.f363843c == r101.f363843c) goto L19;
        return true;
    L19:
        if (r100.f363844d == r101.f363844d) goto L22;
        return true;
    L22:
        if (r101.a(r102) <= r100.a(r102)) goto L14;
        return true;
    }
}
