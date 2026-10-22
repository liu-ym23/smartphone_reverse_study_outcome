package io.ktor.utils.io.core;

import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class i {
    public static final void a(k r100, ByteBuffer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "dst");
    L4:
        if (r101.hasRemaining() == false) goto L14;
        io.ktor.utils.io.core.internal.a r102 = r100.l();
        if (r102 == null) goto L14;
        int r103 = r101.remaining();
        int r104 = r102.f492022c - r102.f492021b;
        if (r103 < r104) goto L12;
        g.b(r102, r101, r104);
        r100.r(r102);
        goto L4
    L12:
        g.b(r102, r101, r103);
        r100.f492040d = r102.f492021b;
    L14:
        if (r101.hasRemaining() == true) goto L17;
        return;
    L17:
        throw new EOFException("Not enough data in packet to fill buffer: " + r101.remaining() + " more bytes required");
    }
}
