package io.ktor.utils.io.core;

import androidx.collection.SieveCacheKt;
import io.ktor.utils.io.core.internal.UTF8Kt;
import java.io.EOFException;
import java.nio.charset.Charset;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes41.dex */
public final class v {
    public static final void a(int r100) {
        throw new EOFException("Premature end of stream: expected " + r100 + " bytes");
    }

    public static byte[] b(k r100) {
        long r101 = r100.k();
        if (r101 > SieveCacheKt.NodeLinkMask) goto L36;
        int r102 = (int) r101;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r102 == 0) goto L34;
        byte[] r103 = new byte[r102];
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "dst");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r104 = true;
        io.ktor.utils.io.core.internal.a r105 = r100.m(1);
        if (r105 == null) goto L22;
        int r106 = 0;
    L39:
        int r107 = Math.min(r102, r105.f492022c - r105.f492021b);     // Catch: Throwable -> L29
        f.a(r105, r103, r106, r107);     // Catch: Throwable -> L29
        r102 = r102 - r107;
        r106 = r106 + r107;
        if (r102 <= 0) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == false) goto L20;
        io.ktor.utils.io.core.internal.a r109 = io.ktor.utils.io.core.internal.c.b(r100, r105);     // Catch: Throwable -> L27
        if (r109 == null) goto L19;
        r105 = r109;
        goto L39
    L19:
        r104 = false;
    L27:
        th = move-exception;
        th = th;
        r104 = false;
    L30:
        if (r104 == false) goto L32;
        io.ktor.utils.io.core.internal.c.a(r100, r105);
    L32:
        throw th;
    L20:
        if (r104 == false) goto L22;
        io.ktor.utils.io.core.internal.c.a(r100, r105);
        goto L22
    L14:
        r108 = false;
    L29:
        th = th;
    L22:
        if (r102 <= 0) goto L43;
        a(r102);
        throw null;
    L43:
        return r103;
    L34:
        return io.ktor.utils.io.core.internal.c.f492033a;
    L36:
        throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
    }

    public static /* synthetic */ void d(j r100, CharSequence r101) {
        c(r100, r101, 0, r101.length(), Charsets.UTF_8);
    }

    public static final void c(q r100, CharSequence r101, int r102, int r110, Charset r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r111, "charset");
        if (r111 != Charsets.UTF_8) goto L20;
        io.ktor.utils.io.core.internal.a r112 = io.ktor.utils.io.core.internal.c.c(r100, 1, null);
    L22:
        int r103 = r102;
        int r104 = UTF8Kt.b(r112.f492020a, r101, r103, r110, r112.f492022c, r112.f492024e);     // Catch: Throwable -> L17
        short r105 = UShort.m9730constructorimpl((short) (r104 >>> 16));     // Catch: Throwable -> L17
        int r106 = r105 & 65535;     // Catch: Throwable -> L17
        r102 = r102 + r106;     // Catch: Throwable -> L17
        r112.a(UShort.m9730constructorimpl((short) (r104 & 65535)) & 65535);     // Catch: Throwable -> L17
        if (r106 != 0) goto L9;
        if (r102 >= r110) goto L9;
        int r107 = 8;
    L12:
        if (r107 <= 0) goto L15;
        r112 = io.ktor.utils.io.core.internal.c.c(r100, r107, r112);     // Catch: Throwable -> L17
        goto L22
    L15:
        r100.a();
        return;
    L9:
        if (r102 >= r110) goto L11;
        r107 = 1;
        goto L12
    L11:
        r107 = 0;
    L17:
        th = move-exception;
        r100.a();
        throw th;
    L20:
        ksc.b.c(r111.newEncoder(), r100, r101, r102, r110);
    }
}
