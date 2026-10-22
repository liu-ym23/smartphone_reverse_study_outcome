package io.ktor.utils.io.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class h {
    public static final io.ktor.utils.io.core.internal.a a(io.ktor.utils.io.core.internal.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
    L3:
        io.ktor.utils.io.core.internal.a r101 = r100.i();
        if (r101 == null) goto L5;
        r100 = r101;
        goto L3
    L5:
        return r100;
    }

    public static final long c(io.ktor.utils.io.core.internal.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        long r101 = 0;
    L3:
        r101 = r101 + ((long) (r100.f492022c - r100.f492021b));
        r100 = r100.i();
        if (r100 != null) goto L3;
        return r101;
    }

    public static final void b(io.ktor.utils.io.core.internal.a r100, io.ktor.utils.io.pool.e<io.ktor.utils.io.core.internal.a> r101) {
        Intrinsics.checkNotNullParameter(r101, "pool");
    L3:
        if (r100 == null) goto L5;
        io.ktor.utils.io.core.internal.a r102 = r100.g();
        r100.k(r101);
        r100 = r102;
        goto L3
    }
}
