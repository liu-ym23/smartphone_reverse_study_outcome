package ksc;

import io.ktor.utils.io.core.j;
import io.ktor.utils.io.core.k;
import io.ktor.utils.io.core.q;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import jsc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b {
    public static final String a(CharsetDecoder r110, k r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "input");
        long r100 = r112;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        if ((r111 instanceof k) == false) goto L5;
        long r101 = r111.k();
    L6:
        StringBuilder r102 = new StringBuilder((int) Math.min(r100, r101));
        CharBuffer r103 = a.f505998a;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "input");
        Intrinsics.checkNotNullParameter(r102, "dst");
        CharBuffer r104 = CharBuffer.allocate(8192);
        Intrinsics.checkNotNullParameter(r111, "<this>");
        boolean r105 = true;
        io.ktor.utils.io.core.internal.a r106 = r111.m(1);
        int r107 = 0;
        if (r106 == null) goto L61;
        int r108 = 1;
        int r109 = 0;
        int r113 = 1;
    L83:
        int r114 = r106.f492022c;     // Catch: Throwable -> L75
        int r115 = r106.f492021b;     // Catch: Throwable -> L75
        int r116 = r114 - r115;
        if (r116 < r108) goto L43;
        int r117 = r112 - r109;
        if (r117 != 0) goto L79;
        r108 = 0;
    L38:
        r116 = r106.f492022c - r106.f492021b;
        goto L43
    L79:
        ByteBuffer r118 = d.c(r106.f492020a, r115, r116);     // Catch: Throwable -> L41
        Intrinsics.checkNotNullParameter(r118, "buffer");     // Catch: Throwable -> L41
        r104.clear();     // Catch: Throwable -> L41
        if (r117 >= 8192) goto L19;
        r104.limit(r117);     // Catch: Throwable -> L41
    L19:
        CoderResult r119 = r110.decode(r118, r104, false);     // Catch: Throwable -> L41
        r104.flip();     // Catch: Throwable -> L41
        r109 = r109 + r104.remaining();     // Catch: Throwable -> L41
        r102.append(r104);     // Catch: Throwable -> L41
        if (r119.isMalformed() == false) goto L22;
    L23:
        a.d(r119);     // Catch: Throwable -> L41
    L25:
        if (r119.isUnderflow() == true) goto L27;
    L29:
        r113 = 1;
    L31:
        if (r118.limit() != r116) goto L33;
        boolean r120 = true;
    L34:
        if (r120 == false) goto L40;
        r106.c(r118.position());     // Catch: Throwable -> L41
        r108 = r113;
        goto L38
    L40:
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());     // Catch: Throwable -> L41
    L33:
        r120 = false;
        goto L34
    L27:
        if (r118.hasRemaining() == false) goto L29;
        r113 = r113 + 1;     // Catch: Throwable -> L41
        goto L31
    L22:
        if (r119.isUnmappable() == false) goto L25;
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L75
    L43:
        if (r116 == 0) goto L81;
        if (r116 >= r108) goto L49;
    L52:
        io.ktor.utils.io.core.internal.c.a(r111, r106);     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r111, "<this>");     // Catch: Throwable -> L45
        io.ktor.utils.io.core.internal.a r121 = r111.m(r108);     // Catch: Throwable -> L45
    L53:
        if (r121 == null) goto L58;
        r106 = r121;
        if (r108 > 0) goto L83;
        r107 = 1;
    L58:
        if (r107 == 0) goto L60;
        io.ktor.utils.io.core.internal.c.a(r111, r106);
    L60:
        r107 = r109;
        goto L61
    L49:
        if ((r106.f492025f - r106.f492024e) < 8) goto L52;
        r121 = r106;
        goto L53
    L81:
        r121 = io.ktor.utils.io.core.internal.c.b(r111, r106);     // Catch: Throwable -> L45
    L45:
        th = th;
        r105 = false;
    L76:
        if (r105 == false) goto L78;
        io.ktor.utils.io.core.internal.c.a(r111, r106);
    L78:
        throw th;
    L75:
        th = th;
    L61:
        r104.clear();
        int r122 = r112 - r107;
        if (r122 == 0) goto L73;
        if (r122 >= 8192) goto L65;
        r104.limit(r122);
    L65:
        CoderResult r123 = r110.decode(a.f505999b, r104, true);
        r104.flip();
        r107 = r107 + r104.remaining();
        r102.append(r104);
        if (r123.isUnmappable() == false) goto L68;
    L69:
        a.d(r123);
    L71:
        if (r123.isOverflow() == true) goto L61;
    L68:
        if (r123.isMalformed() == false) goto L71;
    L73:
        return r102.toString();
    L5:
        r101 = Math.max(r111.k(), 16);
        goto L6
    }

    public static final k b(CharsetEncoder r100, CharSequence r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "input");
        j r104 = new j(null);
        c(r100, r104, r101, r102, r103);     // Catch: Throwable -> L5
        return r104.m();
    L5:
        th = move-exception;
        r104.close();
        throw th;
    }

    public static final void c(CharsetEncoder r100, q r101, CharSequence r102, int r103, int r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r102, "input");
        if (r103 < r110) goto L5;
        return;
    L5:
        io.ktor.utils.io.core.internal.a r104 = io.ktor.utils.io.core.internal.c.c(r101, 1, null);
    L44:
        int r105 = a.b(r100, r102, r103, r110, r104);     // Catch: Throwable -> L39
        if (r105 < 0) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == false) goto L38;
        r103 = r103 + r105;     // Catch: Throwable -> L39
        if (r103 < r110) goto L14;
        int r107 = 0;
    L17:
        if (r107 <= 0) goto L20;
        r104 = io.ktor.utils.io.core.internal.c.c(r101, r107, r104);     // Catch: Throwable -> L39
        goto L44
    L20:
        r101.a();
        io.ktor.utils.io.core.internal.a r108 = io.ktor.utils.io.core.internal.c.c(r101, 1, null);
        int r109 = 1;
    L42:
        if (a.a(r100, r108) == false) goto L24;
        r109 = 0;
    L25:
        if (r109 <= 0) goto L27;
        boolean r111 = true;
    L28:
        if (r111 == false) goto L33;
        r108 = io.ktor.utils.io.core.internal.c.c(r101, 1, r108);     // Catch: Throwable -> L31
        goto L42
    L33:
        r101.a();
        return;
    L27:
        r111 = false;
        goto L28
    L24:
        r109 = r109 + 1;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r101.a();
        throw th;
    L14:
        if (r105 != 0) goto L16;
        r107 = 8;
        goto L17
    L16:
        r107 = 1;
        goto L17
    L38:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L39
    L9:
        r106 = false;
    L39:
        th = move-exception;
        r101.a();
        throw th;
    }
}
