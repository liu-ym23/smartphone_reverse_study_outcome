package de8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d {
    public static final long a(c r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.f468098n;
    }

    public static final String b(Boolean r100) {
        if (r100 == null) goto L7;
        r100.booleanValue();
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L6;
        return "1";
    L6:
        return "0";
    L7:
        return null;
    }
}
