package io.ktor.utils.io.core;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class g {
    public static final io.ktor.utils.io.core.internal.a a(ByteBuffer r100, io.ktor.utils.io.pool.e<io.ktor.utils.io.core.internal.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        ByteBuffer r102 = jsc.c.f500279b;
        ByteBuffer r103 = r100.slice().order(java.nio.ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullParameter(r103, "buffer");
        return new io.ktor.utils.io.core.internal.a(r103, null, r101);
    }

    public static final void c(io.ktor.utils.io.core.internal.a r100, ByteBuffer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        r100.f(r101.limit());
        r100.b(r101.position());
    }

    public static final void b(a r100, ByteBuffer r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "dst");
        ByteBuffer r103 = r100.f492020a;
        int r104 = r100.f492021b;
        if ((r100.f492022c - r104) < r102) goto L12;
        int r105 = r101.limit();
        r101.limit(r101.position() + r102);     // Catch: Throwable -> L8
        jsc.d.a(r103, r101, r104);     // Catch: Throwable -> L8
        r101.limit(r105);
        Unit r106 = Unit.INSTANCE;
        r100.c(r102);
        return;
    L8:
        th = move-exception;
        r101.limit(r105);
        throw th;
    L12:
        throw new EOFException("Not enough bytes to read a buffer content of size " + r102 + '.');
    }
}
