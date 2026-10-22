package bm3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public byte[] a;
    public int b;

    public static int b(int r1) {
        if ((r1 & (-128)) != 0) goto L7;
        return 1;
    L7:
        if ((r1 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r1) != 0) goto L15;
        return 3;
    L15:
        if ((r1 & (-268435456)) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public a() {
    }

    public static int a(String r7) {
        int r0 = r7.length();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L26;
        char r3 = r7.charAt(r1);
        if (r3 >= 128) goto L8;
    L6:
        r2 = r2 + 1;
    L25:
        r1 = r1 + 1;
        goto L3
    L8:
        if (r3 >= 2048) goto L11;
        r2 = r2 + 2;
        goto L25
    L11:
        if (r3 >= 55296) goto L13;
    L24:
        r2 = r2 + 3;
        goto L25
    L13:
        if (r3 > 57343) goto L24;
        if (r3 > 56319) goto L6;
        int r4 = r1 + 1;
        if (r4 >= r0) goto L6;
        if (r7.charAt(r4) < 56320) goto L6;
        if (r7.charAt(r4) > 57343) goto L6;
        r2 = r2 + 4;
        r1 = r4;
        goto L25
    L26:
        return r2;
    }

    public final void c(int r4) {
    L3:
        if ((r4 & (-128)) == 0) goto L5;
        byte[] r0 = this.a;
        int r1 = this.b;
        this.b = r1 + 1;
        r0[r1] = (byte) ((r4 & 127) | 128);
        r4 = r4 >>> 7;
        goto L3
    L5:
        byte[] r2 = this.a;
        int r3 = this.b;
        this.b = r3 + 1;
        r2[r3] = (byte) r4;
    }

    public final void d(long r6) {
    L3:
        if (((-128) & r6) == 0) goto L5;
        byte[] r0 = this.a;
        int r1 = this.b;
        this.b = r1 + 1;
        r0[r1] = (byte) ((((int) r6) & 127) | 128);
        r6 = r6 >>> 7;
        goto L3
    L5:
        byte[] r2 = this.a;
        int r3 = this.b;
        this.b = r3 + 1;
        r2[r3] = (byte) r6;
    }
}
