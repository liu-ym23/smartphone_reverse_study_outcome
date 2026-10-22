package io.ktor.utils.io.core;

import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class f {
    public static final void a(io.ktor.utils.io.core.internal.a r100, byte[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        ByteBuffer r104 = r100.f492020a;
        int r105 = r100.f492021b;
        if ((r100.f492022c - r105) < r103) goto L13;
        Intrinsics.checkNotNullParameter(r104, "$this$copyTo");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if (r104.hasArray() == true) goto L7;
    L9:
        r104.duplicate().get(r101, r102, r103);
    L10:
        Unit r106 = Unit.INSTANCE;
        r100.c(r103);
        return;
    L7:
        if (r104.isReadOnly() == true) goto L9;
        System.arraycopy(r104.array(), r104.arrayOffset() + r105, r101, r102, r103);
        goto L10
    L13:
        throw new EOFException("Not enough bytes to read a byte array of size " + r103 + '.');
    }

    public static final void b(io.ktor.utils.io.core.internal.a r100, byte[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "source");
        ByteBuffer r104 = r100.f492020a;
        int r105 = r100.f492022c;
        int r106 = r100.f492024e - r105;
        if (r106 < r103) goto L7;
        ByteBuffer r107 = ByteBuffer.wrap(r101, r102, r103).slice().order(java.nio.ByteOrder.BIG_ENDIAN);
        ByteBuffer r108 = jsc.c.f500279b;
        Intrinsics.checkNotNullParameter(r107, "buffer");
        jsc.c.a(r107, r104, 0, r103, r105);
        r100.a(r103);
        return;
    L7:
        throw new InsufficientSpaceException("byte array", r103, r106);
    }
}
