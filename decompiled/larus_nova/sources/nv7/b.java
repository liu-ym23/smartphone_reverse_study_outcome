package nv7;

import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f520912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f520914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f520915d;

    public final int[] c() {
        int r100 = this.f520912a;
        int r101 = this.f520913b;
        int r102 = -1;
        int r103 = -1;
        int r104 = 0;
    L4:
        if (r104 >= this.f520913b) goto L34;
        int r105 = 0;
    L6:
        int r106 = this.f520914c;
        if (r105 >= r106) goto L33;
        int r107 = this.f520915d[(r106 * r104) + r105];
        if (r107 == 0) goto L32;
        if (r104 >= r101) goto L12;
        r101 = r104;
    L12:
        if (r104 <= r103) goto L14;
        r103 = r104;
    L14:
        int r108 = r105 * 32;
        if (r108 >= r100) goto L24;
        int r109 = 0;
    L18:
        if ((r107 << (31 - r109)) != 0) goto L20;
        r109 = r109 + 1;
        goto L18
    L20:
        int r110 = r109 + r108;
        if (r110 >= r100) goto L24;
        r100 = r110;
    L24:
        if ((r108 + 31) <= r102) goto L32;
        int r111 = 31;
    L27:
        if ((r107 >>> r111) != 0) goto L29;
        r111 = r111 - 1;
        goto L27
    L29:
        int r112 = r108 + r111;
        if (r112 <= r102) goto L32;
        r102 = r112;
    L32:
        r105 = r105 + 1;
        goto L6
    L33:
        r104 = r104 + 1;
        goto L4
    L34:
        if (r102 < r100) goto L39;
        if (r103 >= r101) goto L38;
        return null;
    L38:
        return new int[]{r100, r101, (r102 - r100) + 1, (r103 - r101) + 1};
    L39:
        return null;
    }

    public final Object clone() throws CloneNotSupportedException {
        return new b(this.f520912a, this.f520913b, this.f520914c, (int[]) this.f520915d.clone());
    }

    public final int hashCode() {
        int r100 = this.f520912a;
        return (((((((r100 * 31) + r100) * 31) + this.f520913b) * 31) + this.f520914c) * 31) + Arrays.hashCode(this.f520915d);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder(this.f520913b * (this.f520912a + 1));
        int r101 = 0;
    L4:
        if (r101 >= this.f520913b) goto L15;
        int r102 = 0;
    L7:
        if (r102 >= this.f520912a) goto L13;
        if (b(r102, r101) == false) goto L11;
        String r103 = "X ";
    L12:
        r100.append(r103);
        r102 = r102 + 1;
        goto L7
    L11:
        r103 = tb2.c.DEFAULT_TEXT;
        goto L12
    L13:
        r100.append("\n");
        r101 = r101 + 1;
        goto L4
    L15:
        return r100.toString();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
        return false;
    L5:
        b r101 = (b) r100;
        if (this.f520912a == r101.f520912a) goto L8;
        return false;
    L8:
        if (this.f520913b == r101.f520913b) goto L10;
        return false;
    L10:
        if (this.f520914c == r101.f520914c) goto L12;
        return false;
    L12:
        if (Arrays.equals(this.f520915d, r101.f520915d) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public b(int r100, int r101) {
        if (r100 < 1) goto L8;
        if (r101 < 1) goto L8;
        this.f520912a = r100;
        this.f520913b = r101;
        int r102 = (r100 + 31) / 32;
        this.f520914c = r102;
        this.f520915d = new int[r102 * r101];
        return;
    L8:
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    public final void a(int r100, int r101) {
        int r102 = (r101 * this.f520914c) + (r100 / 32);
        int[] r103 = this.f520915d;
        int r104 = 1 << (r100 & 31);
        r103[r102] = r104 ^ r103[r102];
    }

    public final boolean b(int r100, int r101) {
        int r102 = (r101 * this.f520914c) + (r100 / 32);
        if (((this.f520915d[r102] >>> (r100 & 31)) & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final void d(int r100, int r101) {
        int r102 = (r101 * this.f520914c) + (r100 / 32);
        int[] r103 = this.f520915d;
        int r104 = 1 << (r100 & 31);
        r103[r102] = r104 | r103[r102];
    }

    public b(int r100, int r101, int r102, int[] r103) {
        this.f520912a = r100;
        this.f520913b = r101;
        this.f520914c = r102;
        this.f520915d = r103;
    }

    public final void e(int r100, int r101, int r110, int r111) {
        if (r101 < 0) goto L22;
        if (r100 < 0) goto L22;
        if (r111 < 1) goto L20;
        if (r110 < 1) goto L20;
        int r112 = r110 + r100;
        int r113 = r111 + r101;
        if (r113 > this.f520913b) goto L18;
        if (r112 > this.f520912a) goto L18;
    L11:
        if (r101 >= r113) goto L16;
        int r102 = this.f520914c * r101;
        int r103 = r100;
    L13:
        if (r103 >= r112) goto L15;
        int[] r104 = this.f520915d;
        int r105 = (r103 / 32) + r102;
        r104[r105] = r104[r105] | (1 << (r103 & 31));
        r103 = r103 + 1;
        goto L13
    L15:
        r101 = r101 + 1;
        goto L11
    L16:
        return;
    L18:
        throw new IllegalArgumentException("The region must fit inside the matrix");
    L20:
        throw new IllegalArgumentException("Height and width must be at least 1");
    L22:
        throw new IllegalArgumentException("Left and top must be nonnegative");
    }
}
