package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class o {
    public static final int a(n r100, byte[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "dst");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r104 = true;
        io.ktor.utils.io.core.internal.a r105 = r100.m(1);
        int r106 = r103;
        if (r105 == null) goto L18;
    L26:
        int r107 = Math.min(r106, r105.f492022c - r105.f492021b);     // Catch: Throwable -> L22
        f.a(r105, r101, r102, r107);     // Catch: Throwable -> L22
        r106 = r106 - r107;
        r102 = r102 + r107;
        if (r106 <= 0) goto L9;
        boolean r108 = true;
    L10:
        if (r108 == false) goto L15;
        io.ktor.utils.io.core.internal.a r109 = io.ktor.utils.io.core.internal.c.b(r100, r105);     // Catch: Throwable -> L20
        if (r109 == null) goto L14;
        r105 = r109;
        goto L26
    L14:
        r104 = false;
    L20:
        th = th;
        r104 = false;
    L23:
        if (r104 == false) goto L25;
        io.ktor.utils.io.core.internal.c.a(r100, r105);
    L25:
        throw th;
    L15:
        if (r104 == false) goto L18;
        io.ktor.utils.io.core.internal.c.a(r100, r105);
        goto L18
    L9:
        r108 = false;
    L22:
        th = th;
    L18:
        return r103 - r106;
    }

    public static final long b(n r110, ByteBuffer r111, long r210, long r211) {
        Intrinsics.checkNotNullParameter(r110, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(r111, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r110, "<this>");
        io.ktor.utils.io.core.internal.a r100 = r110.m(1);
        if (r100 != null) goto L5;
        long r101 = r211;
    L20:
        long r102 = r211 - r101;
        if (r102 == 0) goto L23;
        return r102;
    L23:
        if (r110.i() == false) goto L46;
        return -1;
    L46:
        return r102;
    L5:
        long r112 = r210;
        r101 = r211;
        io.ktor.utils.io.core.internal.a r103 = r100;
    L41:
        int r104 = (int) Math.min(r101, r103.f492022c - r103.f492021b);     // Catch: Throwable -> L31
        long r113 = r104;
        long r114 = r101;
        io.ktor.utils.io.core.internal.a r115 = r103;
        jsc.c.b(r103.f492020a, r111, r103.f492021b, r113, r112);     // Catch: Throwable -> L29
        r115.c(r104);     // Catch: Throwable -> L29
        r101 = r114 - r113;
        r112 = r112 + r113;
        if (r101 <= 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L14;
        r103 = io.ktor.utils.io.core.internal.c.b(r110, r115);     // Catch: Throwable -> L27
        if (r103 != null) goto L41;
        boolean r116 = false;
    L18:
        if (r116 == false) goto L20;
        io.ktor.utils.io.core.internal.c.a(r110, r115);
    L27:
        th = th;
        boolean r117 = false;
    L34:
        if (r117 == false) goto L36;
        io.ktor.utils.io.core.internal.c.a(r110, r115);
    L36:
        throw th;
    L14:
        r116 = true;
        goto L18
    L12:
        r105 = false;
    L29:
        th = th;
    L33:
        r117 = true;
    L31:
        th = th;
        r115 = r103;
        goto L33
    }
}
