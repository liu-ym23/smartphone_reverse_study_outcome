package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f463102a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final byte[] f205a;

    static {
        f463102a = new a(new byte[0]);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m8795a() {
        byte[] r100 = this.f205a;
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    public int hashCode() {
        int r100 = this.f204a;
        if (r100 != 0) goto L11;
        byte[] r101 = this.f205a;
        int r102 = r101.length;
        int r103 = 0;
        int r104 = r102;
    L5:
        if (r103 >= r102) goto L7;
        r104 = (r104 * 31) + r101[r103];
        r103 = r103 + 1;
        goto L5
    L7:
        if (r104 != 0) goto L9;
        r100 = 1;
    L10:
        this.f204a = r100;
        goto L11
    L9:
        r100 = r104;
    L11:
        return r100;
    }

    public int a() {
        return this.f205a.length;
    }

    private a(byte[] r100) {
        this.f204a = 0;
        this.f205a = r100;
    }

    public static a a(byte[] r100) {
        return a(r100, 0, r100.length);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        byte[] r101 = this.f205a;
        int r102 = r101.length;
        byte[] r103 = ((a) r100).f205a;
        if (r102 == r103.length) goto L11;
        return false;
    L11:
        int r104 = 0;
    L12:
        if (r104 >= r102) goto L17;
        if (r101[r104] != r103[r104]) goto L15;
        r104 = r104 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    public static a a(byte[] r100, int r101, int r102) {
        byte[] r103 = new byte[r102];
        System.arraycopy(r100, r101, r103, 0, r102);
        return new a(r103);
    }
}
