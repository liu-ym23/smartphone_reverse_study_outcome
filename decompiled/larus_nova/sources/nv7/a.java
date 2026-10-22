package nv7;

import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f520909c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f520910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520911b;

    static {
        f520909c = new int[0];
    }

    public final Object clone() throws CloneNotSupportedException {
        return new a((int[]) this.f520910a.clone(), this.f520911b);
    }

    public final int hashCode() {
        return (this.f520911b * 31) + Arrays.hashCode(this.f520910a);
    }

    public final String toString() {
        int r100 = this.f520911b;
        StringBuilder r101 = new StringBuilder((r100 + (r100 / 8)) + 1);
        int r102 = 0;
    L4:
        if (r102 >= this.f520911b) goto L14;
        if ((r102 & 7) != 0) goto L9;
        r101.append(' ');
    L9:
        if (d(r102) == false) goto L11;
        char r103 = 'X';
    L12:
        r101.append(r103);
        r102 = r102 + 1;
        goto L4
    L11:
        r103 = '.';
        goto L12
    L14:
        return r101.toString();
    }

    public a() {
        this.f520911b = 0;
        this.f520910a = f520909c;
    }

    public final void a(boolean r100) {
        c(this.f520911b + 1);
        if (r100 == false) goto L5;
        int[] r101 = this.f520910a;
        int r102 = this.f520911b;
        int r103 = r102 / 32;
        r101[r103] = (1 << (r102 & 31)) | r101[r103];
    L5:
        this.f520911b++;
    }

    public final void c(int r100) {
        if (r100 <= (this.f520910a.length * 32)) goto L6;
        int[] r101 = new int[(((int) Math.ceil(r100 / 0.75f)) + 31) / 32];
        int[] r102 = this.f520910a;
        System.arraycopy(r102, 0, r101, 0, r102.length);
        this.f520910a = r101;
        return;
    }

    public final boolean d(int r100) {
        int r101 = this.f520910a[r100 / 32];
        if (((1 << (r100 & 31)) & r101) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == true) goto L5;
        return false;
    L5:
        a r101 = (a) r100;
        if (this.f520911b == r101.f520911b) goto L8;
        return false;
    L8:
        if (Arrays.equals(this.f520910a, r101.f520910a) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public a(int[] r100, int r101) {
        this.f520910a = r100;
        this.f520911b = r101;
    }

    public final void b(int r100, int r101) {
        if (r101 < 0) goto L14;
        if (r101 > 32) goto L14;
        int r102 = this.f520911b;
        c(r102 + r101);
        int r103 = r101 - 1;
    L6:
        if (r103 < 0) goto L11;
        if (((1 << r103) & r100) == 0) goto L10;
        int[] r104 = this.f520910a;
        int r105 = r102 / 32;
        r104[r105] = r104[r105] | (1 << (r102 & 31));
    L10:
        r102 = r102 + 1;
        r103 = r103 - 1;
        goto L6
    L11:
        this.f520911b = r102;
        return;
    L14:
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }
}
