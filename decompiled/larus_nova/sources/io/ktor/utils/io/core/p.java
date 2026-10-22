package io.ktor.utils.io.core;

import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class p {
    public static final short a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.f492041e;
        int r102 = r100.f492040d;
        if ((r101 - r102) <= 2) goto L5;
        r100.f492040d = r102 + 2;
        return r100.f492039c.getShort(r102);
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        io.ktor.utils.io.core.internal.a r103 = r100.m(2);
        if (r103 == null) goto L13;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        ByteBuffer r104 = r103.f492020a;
        int r105 = r103.f492021b;
        if ((r103.f492022c - r105) < 2) goto L12;
        Short r106 = Short.valueOf(r104.getShort(r105));
        r103.c(2);
        short r107 = r106.shortValue();
        io.ktor.utils.io.core.internal.c.a(r100, r103);
        return r107;
    L12:
        throw new EOFException("Not enough bytes to read a short integer of size 2.");
    L13:
        v.a(2);
        throw null;
    }
}
