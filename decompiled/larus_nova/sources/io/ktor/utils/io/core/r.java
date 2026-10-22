package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class r {
    public static final void a(j r100, ByteBuffer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "bb");
        int r102 = r101.limit();
        io.ktor.utils.io.core.internal.a r103 = io.ktor.utils.io.core.internal.c.c(r100, 1, null);
    L12:
        int r104 = Math.min(r101.remaining(), r103.f492024e - r103.f492022c);     // Catch: Throwable -> L9
        r101.limit(r101.position() + r104);     // Catch: Throwable -> L9
        e.a(r103, r101);     // Catch: Throwable -> L9
        r101.limit(r102);     // Catch: Throwable -> L9
        if (r101.hasRemaining() == false) goto L7;
        r103 = io.ktor.utils.io.core.internal.c.c(r100, 1, r103);     // Catch: Throwable -> L9
        goto L12
    L7:
        r100.a();
        return;
    L9:
        th = move-exception;
        r100.a();
        throw th;
    }
}
