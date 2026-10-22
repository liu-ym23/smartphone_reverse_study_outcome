package io.ktor.websocket;

import io.ktor.utils.io.core.p;
import io.ktor.utils.io.core.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static final CloseReason a(c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f492170c.length >= 2) goto L5;
        return null;
    L5:
        io.ktor.utils.io.core.j r101 = new io.ktor.utils.io.core.j(null);
        s.c(r101, r100.f492170c);     // Catch: Throwable -> L9
        io.ktor.utils.io.core.k r102 = r101.m();     // Catch: Throwable -> L9
        return new CloseReason(p.a(r102), io.ktor.utils.io.core.n.p(r102));
    L9:
        th = move-exception;
        r101.close();
        throw th;
    }
}
