package io.ktor.websocket;

import androidx.collection.SieveCacheKt;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class h {
    public static final io.ktor.utils.io.core.k a(io.ktor.utils.io.core.k r100, int r101) {
        long r102 = 4;
        jsc.b r103 = jsc.b.f500278a;
        if (r102 >= SieveCacheKt.NodeLinkMask) goto L18;
        ByteBuffer r104 = r103.b((int) r102);
        int r105 = 0;
        r104.putInt(0, r101);     // Catch: Throwable -> L15
        io.ktor.utils.io.core.j r106 = new io.ktor.utils.io.core.j(null);     // Catch: Throwable -> L15
        int r107 = (int) r100.k();     // Catch: Throwable -> L12
    L7:
        if (r105 >= r107) goto L9;
        r106.l((byte) (r100.readByte() ^ r104.get(r105 % 4)));     // Catch: Throwable -> L12
        r105 = r105 + 1;     // Catch: Throwable -> L12
        goto L7
    L9:
        io.ktor.utils.io.core.k r108 = r106.m();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r104, "instance");
        return r108;
    L12:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r103.a(r104);
        throw th;
    L18:
        io.ktor.utils.io.core.internal.b.a(r102, "size");
        throw null;
    }
}
