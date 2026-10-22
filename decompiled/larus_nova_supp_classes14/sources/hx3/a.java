package hx3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final boolean a = false;
    public static final a b = null;

    public a() {
    }

    public static long c(long r5, long r7) {
        long r6 = (r5 ^ r7) * (-7070675565921424023L);
        long r8 = ((r6 ^ (r6 >>> 47)) ^ r7) * (-7070675565921424023L);
        return (r8 ^ (r8 >>> 47)) * (-7070675565921424023L);
    }

    public static long d(long r3, long r5, long r7) {
        long r4 = (r3 ^ r5) * r7;
        long r6 = ((r4 ^ (r4 >>> 47)) ^ r5) * r7;
        return (r6 ^ (r6 >>> 47)) * r7;
    }

    public static long e(long r2, int r4) {
        if (r4 == 0) goto L6;
        long r0 = r2 >>> r4;
        return (r2 << (64 - r4)) | r0;
    L6:
        return r2;
    }

    static {
        a = !"little".equals(System.getProperty("sun.cpu.endian"));
        b = new a();
    }

    public static int a(byte[] r6, int r7) {
        boolean r0 = a;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= 4) goto L6;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L13;
        int r5 = r2 + 1;
        if (r0 == false) goto L12;
        r2 = 3 - r2;
    L12:
        r3 = r3 | ((r6[r2 + r7] & 255) << (r2 * 8));
        r2 = r5;
        goto L4
    L13:
        return r3;
    L6:
        r4 = false;
        goto L7
    }

    public static long b(byte[] r11, int r12) {
        boolean r0 = a;
        long r1 = 0;
        int r4 = 0;
    L4:
        if (r4 >= 8) goto L6;
        boolean r6 = true;
    L7:
        if (r6 == false) goto L13;
        int r7 = r4 + 1;
        if (r0 == false) goto L12;
        r4 = 7 - r4;
    L12:
        r1 = r1 | ((((long) r11[r4 + r12]) & 255) << (r4 * 8));
        r4 = r7;
        goto L4
    L13:
        return r1;
    L6:
        r6 = false;
        goto L7
    }

    public static b f(byte[] r6, int r7, long r8, long r10) {
        long r0 = b(r6, r7);
        long r2 = b(r6, r7 + 8);
        long r4 = b(r6, r7 + 16);
        long r9 = b(r6, r7 + 24);
        long r11 = r8 + r0;
        long r3 = (r2 + r11) + r4;
        long r12 = e((r10 + r11) + r9, 21) + e(r3, 44);
        return new b(r3 + r9, r12 + r11);
    }
}
