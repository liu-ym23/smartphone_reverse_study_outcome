package ksc;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import jsc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CharBuffer f505998a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteBuffer f505999b = null;

    static {
        f505998a = CharBuffer.allocate(0);
        ByteBuffer r100 = ByteBuffer.allocate(0);
        Intrinsics.checkNotNull(r100);
        f505999b = r100;
    }

    public static final void d(CoderResult r100) {
        r100.throwException();     // Catch: MalformedInputException -> L4
        return;
    L4:
        e = move-exception;
        String r101 = e.getMessage();
        if (r101 != null) goto L9;
        r101 = "Failed to decode bytes";
    L9:
        throw new io.ktor.utils.io.charsets.MalformedInputException(r101);
    }

    public static final boolean a(CharsetEncoder r100, io.ktor.utils.io.core.internal.a r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "dst");
        ByteBuffer r102 = r101.f492020a;
        int r103 = r101.f492022c;
        int r104 = r101.f492024e - r103;
        ByteBuffer r105 = jsc.c.f500279b;
        ByteBuffer r106 = d.c(r102, r103, r104);
        Intrinsics.checkNotNullParameter(r106, "buffer");
        boolean r107 = true;
        CoderResult r108 = r100.encode(f505998a, r106, true);
        if (r108.isMalformed() == false) goto L5;
    L6:
        d(r108);
    L7:
        boolean r109 = r108.isUnderflow();
        if (r106.limit() == r104) goto L11;
        r107 = false;
    L11:
        if (r107 == false) goto L15;
        r101.a(r106.position());
        return r109;
    L15:
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    L5:
        if (r108.isUnmappable() == false) goto L7;
        goto L6
    }

    public static final byte[] c(CharsetEncoder r100, CharSequence r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "input");
        boolean r103 = false;
        if ((r101 instanceof String) == true) goto L5;
        ByteBuffer r104 = r100.encode(CharBuffer.wrap(r101, 0, r102));
        if (r104.hasArray() == true) goto L13;
    L19:
        byte[] r105 = null;
    L20:
        if (r105 != null) goto L23;
        byte[] r106 = new byte[r104.remaining()];
        r104.get(r106);
        return r106;
    L23:
        return r105;
    L13:
        if (r104.arrayOffset() != 0) goto L19;
        r105 = r104.array();
        if (r105.length != r104.remaining()) goto L17;
        r103 = true;
    L17:
        if (r103 == false) goto L19;
    L5:
        if (r102 == r101.length()) goto L7;
        String r107 = ((String) r101).substring(0, r102);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.lang.String");
        return r107.getBytes(r100.charset());
    L7:
        return ((String) r101).getBytes(r100.charset());
    }

    public static final int b(CharsetEncoder r100, CharSequence r101, int r102, int r103, io.ktor.utils.io.core.internal.a r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r104, "dst");
        CharBuffer r105 = CharBuffer.wrap(r101, r102, r103);
        int r106 = r105.remaining();
        ByteBuffer r107 = r104.f492020a;
        int r108 = r104.f492022c;
        int r109 = r104.f492024e - r108;
        ByteBuffer r110 = jsc.c.f500279b;
        ByteBuffer r111 = d.c(r107, r108, r109);
        Intrinsics.checkNotNullParameter(r111, "buffer");
        boolean r112 = false;
        CoderResult r113 = r100.encode(r105, r111, false);
        if (r113.isMalformed() == false) goto L5;
    L6:
        d(r113);
    L8:
        if (r111.limit() != r109) goto L10;
        r112 = true;
    L10:
        if (r112 == false) goto L14;
        r104.a(r111.position());
        return r106 - r105.remaining();
    L14:
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    L5:
        if (r113.isUnmappable() == false) goto L8;
        goto L6
    }
}
