package am3;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static boolean a(g r3) throws IOException {
        int r4 = r3.i();
        if (r4 != 0) goto L6;
        return false;
    L6:
        if (r4 != 1) goto L9;
        return true;
    L9:
        throw new IOException(String.format("Invalid boolean value 0x%02x", new Object[]{Integer.valueOf(r4)}));
    }

    public static byte[] b(g r2) throws IOException {
        long r0 = r2.b();
        return r2.b.readByteArray(r0);
    }

    public static String c(g r2) throws IOException {
        long r0 = r2.b();
        return r2.b.readUtf8(r0);
    }

    public static void e(g r6) throws IOException {
        int r0 = r6.i;
        if (r0 != 0) goto L5;
        r6.j();
        return;
    L5:
        if (r0 != 1) goto L7;
        r6.c += 8;
        r6.b.c(8);
        r6.a(1);
        return;
    L7:
        if (r0 != 2) goto L9;
        r6.b.c(r6.b());
        return;
    L9:
        if (r0 != 5) goto L13;
        r6.c += 4;
        r6.b.c(4);
        r6.a(5);
        return;
    L13:
        throw new IllegalStateException("Unexpected field encoding found!");
    }

    public static void d(g.a r5, g r6) throws IOException {
        if (r5 == null) goto L8;
        long r0 = r6.c;
        long r2 = r5.a;
        if (r0 < r2) goto L6;
        boolean r7 = false;
    L7:
        if (r7 == false) goto L8;
        return;
    L6:
        r6.b.c(r2 - r0);
        r6.c = r5.a;
        r6.d = r5.b;
        r6.e = r5.c;
        r6.f = r5.d;
        r6.g = r5.e;
        r6.h = r5.f;
        r6.i = r5.g;
        r7 = true;
    L8:
        e(r6);
    }
}
