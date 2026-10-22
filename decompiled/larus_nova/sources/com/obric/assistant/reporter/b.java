package com.obric.assistant.reporter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {
    static {
    }

    public b() {
    }

    public static void a(String r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        boolean r103 = true;
    L9:
        Intrinsics.checkNotNullParameter(r100, "launchMethod");
        IObricReporter.f391335a.getClass();
        IObricReporter r104 = IObricReporter.a.a();
        if (r104 == null) goto L16;
        if (r101 != null) goto L14;
        r101 = r104.l();
    L14:
        r104.n(r100, r101, r103);
        return;
    L16:
        return;
    L8:
        r103 = false;
        goto L9
    }
}
