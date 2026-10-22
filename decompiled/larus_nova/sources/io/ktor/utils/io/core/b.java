package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b {
    public static final int a(a r100, a r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        int r103 = Math.min(r101.f492022c - r101.f492021b, r102);
        int r104 = r100.f492024e;
        int r105 = r100.f492022c;
        int r106 = r104 - r105;
        if (r106 > r103) goto L11;
        int r107 = r100.f492025f;
        if ((r106 + (r107 - r104)) < r103) goto L10;
        if (((r105 + r103) - r104) <= 0) goto L11;
        r100.f492024e = r107;
        goto L11
    L10:
        throw new IllegalArgumentException("Can't append buffer: not enough free space at the end");
    L11:
        ByteBuffer r108 = r100.f492020a;
        jsc.c.a(r101.f492020a, r108, r101.f492021b, r103, r105);
        r101.c(r103);
        r100.a(r103);
        return r103;
    }
}
