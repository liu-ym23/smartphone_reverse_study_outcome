package io.ktor.utils.io;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes41.dex */
public final class l {
    public static final int b(p r100, ByteBuffer r101) {
        int r102 = c(r100, r101);
        if (r102 == (-1)) goto L10;
        if (r102 < r101.remaining()) goto L11;
        r100.a(r101.remaining());
        return r101.remaining();
    L11:
        return r102;
    L10:
        throw new IOException("Failed to skip delimiter: actual bytes differ from delimiter bytes");
    }

    public static final int c(p r100, ByteBuffer r101) {
        ByteBuffer r102 = r100.b(0, 1);
        if (r102 != null) goto L5;
        return 0;
    L5:
        int r103 = io.ktor.utils.io.internal.l.b(r102, r101);
        if (r103 == 0) goto L8;
        return -1;
    L8:
        int r104 = Math.min(r102.remaining() - r103, r101.remaining());
        int r105 = r101.remaining() - r104;
        if (r105 <= 0) goto L17;
        ByteBuffer r106 = r100.b(r103 + r104, r105);
        if (r106 != null) goto L14;
        return r104;
    L14:
        if (io.ktor.utils.io.internal.l.e(r106, r101, r104) == true) goto L17;
        return -1;
    L17:
        return r101.remaining();
    }

    public static final int a(p r100, ByteBuffer r101, ByteBuffer r102) {
        boolean r103 = false;
        ByteBuffer r104 = r100.b(0, 1);
        if (r104 == null) goto L28;
        int r105 = io.ktor.utils.io.internal.l.b(r104, r101);
        if (r105 == (-1)) goto L21;
        int r106 = Math.min(r104.remaining() - r105, r101.remaining());
        int r107 = r101.remaining() - r106;
        if (r107 != 0) goto L10;
        int r108 = io.ktor.utils.io.internal.l.d(r102, r104, r104.position() + r105);
    L18:
        r103 = true;
    L22:
        r100.a(r108);
        if (r103 == false) goto L26;
        return -r108;
    L26:
        return r108;
    L10:
        ByteBuffer r109 = r104.duplicate();
        ByteBuffer r110 = r100.b(r105 + r106, 1);
        if (r110 != null) goto L14;
        r108 = io.ktor.utils.io.internal.l.d(r102, r109, r109.position() + r105);
        goto L22
    L14:
        if (io.ktor.utils.io.internal.l.e(r110, r101, r106) == true) goto L16;
        r108 = io.ktor.utils.io.internal.l.d(r102, r109, (r109.position() + r105) + 1);
        goto L22
    L16:
        if (r110.remaining() < r107) goto L19;
        r108 = io.ktor.utils.io.internal.l.d(r102, r109, r109.position() + r105);
        goto L18
    L19:
        r108 = io.ktor.utils.io.internal.l.d(r102, r109, r109.position() + r105);
        goto L22
    L21:
        r108 = io.ktor.utils.io.internal.l.c(r102, r104, r104.remaining());
        goto L22
    L28:
        return 0;
    }
}
