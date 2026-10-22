package hx3;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f487488a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f487489b = null;

    public a() {
    }

    public static long c(long r100, long r101) {
        long r102 = (r100 ^ r101) * (-7070675565921424023L);
        long r103 = ((r102 ^ (r102 >>> 47)) ^ r101) * (-7070675565921424023L);
        return (r103 ^ (r103 >>> 47)) * (-7070675565921424023L);
    }

    public static long d(long r100, long r101, long r102) {
        long r103 = (r100 ^ r101) * r102;
        long r104 = ((r103 ^ (r103 >>> 47)) ^ r101) * r102;
        return (r104 ^ (r104 >>> 47)) * r102;
    }

    public static long e(long r100, int r101) {
        if (r101 == 0) goto L6;
        long r102 = r100 >>> r101;
        return (r100 << (64 - r101)) | r102;
    L6:
        return r100;
    }

    static {
        f487488a = !"little".equals(System.getProperty("sun.cpu.endian"));
        f487489b = new a();
    }

    public static int a(byte[] r100, int r101) {
        boolean r102 = f487488a;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= 4) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L13;
        int r106 = r103 + 1;
        if (r102 == false) goto L12;
        r103 = 3 - r103;
    L12:
        r104 = r104 | ((r100[r103 + r101] & 255) << (r103 * 8));
        r103 = r106;
        goto L4
    L13:
        return r104;
    L6:
        r105 = false;
        goto L7
    }

    public static long b(byte[] r110, int r111) {
        boolean r100 = f487488a;
        long r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= 8) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L13;
        int r104 = r102 + 1;
        if (r100 == false) goto L12;
        r102 = 7 - r102;
    L12:
        r101 = r101 | ((((long) r110[r102 + r111]) & 255) << (r102 * 8));
        r102 = r104;
        goto L4
    L13:
        return r101;
    L6:
        r103 = false;
        goto L7
    }

    public static b f(byte[] r100, int r101, long r102, long r110) {
        long r103 = b(r100, r101);
        long r104 = b(r100, r101 + 8);
        long r105 = b(r100, r101 + 16);
        long r106 = b(r100, r101 + 24);
        long r107 = r102 + r103;
        long r108 = (r104 + r107) + r105;
        long r111 = e((r110 + r107) + r106, 21) + e(r108, 44);
        return new b(r108 + r106, r111 + r107);
    }
}
