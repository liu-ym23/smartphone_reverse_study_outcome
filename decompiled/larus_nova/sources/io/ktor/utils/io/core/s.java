package io.ktor.utils.io.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class s {
    public static final void a(a r100, int r101) {
        Intrinsics.checkNotNullParameter(null, "<this>");
        Intrinsics.checkNotNullParameter(r100, "src");
        io.ktor.utils.io.core.internal.c.c(null, 1, null);
        throw null;
    }

    public static /* synthetic */ void c(q r100, byte[] r101) {
        b(r100, r101, 0, r101.length - 0);
    }

    public static final void b(q r100, byte[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "src");
        io.ktor.utils.io.core.internal.a r104 = io.ktor.utils.io.core.internal.c.c(r100, 1, null);
    L15:
        int r105 = Math.min(r103, r104.f492024e - r104.f492022c);     // Catch: Throwable -> L12
        f.b(r104, r101, r102, r105);     // Catch: Throwable -> L12
        r102 = r102 + r105;     // Catch: Throwable -> L12
        r103 = r103 - r105;     // Catch: Throwable -> L12
        if (r103 <= 0) goto L6;
        boolean r106 = true;
    L7:
        if (r106 == false) goto L10;
        r104 = io.ktor.utils.io.core.internal.c.c(r100, 1, r104);     // Catch: Throwable -> L12
        goto L15
    L10:
        r100.a();
        return;
    L6:
        r106 = false;
    L12:
        th = move-exception;
        r100.a();
        throw th;
    }
}
