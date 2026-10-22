package d2c;

import java.util.Arrays;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f466579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f466580b;

    public final Object clone() throws CloneNotSupportedException {
        return new a((int[]) this.f466579a.clone(), this.f466580b);
    }

    public final int hashCode() {
        return (this.f466580b * 31) + Arrays.hashCode(this.f466579a);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder(this.f466580b);
        int r101 = 0;
    L4:
        if (r101 >= this.f466580b) goto L14;
        if ((r101 & 7) != 0) goto L9;
        r100.append(' ');
    L9:
        if (d(r101) == false) goto L11;
        char r102 = 'X';
    L12:
        r100.append(r102);
        r101 = r101 + 1;
        goto L4
    L11:
        r102 = '.';
        goto L12
    L14:
        return r100.toString();
    }

    public a() {
        this.f466580b = 0;
        this.f466579a = new int[1];
    }

    public final void a(boolean r100) {
        c(this.f466580b + 1);
        if (r100 == false) goto L5;
        int[] r101 = this.f466579a;
        int r102 = this.f466580b;
        int r103 = r102 / 32;
        r101[r103] = (1 << (r102 & 31)) | r101[r103];
    L5:
        this.f466580b++;
    }

    public final void c(int r100) {
        int[] r101 = this.f466579a;
        if (r100 <= (r101.length * 32)) goto L6;
        int[] r102 = new int[(r100 + 31) / 32];
        System.arraycopy(r101, 0, r102, 0, r101.length);
        this.f466579a = r102;
        return;
    }

    public final boolean d(int r100) {
        int r101 = this.f466579a[r100 / 32];
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
        if (this.f466580b == r101.f466580b) goto L8;
        return false;
    L8:
        if (Arrays.equals(this.f466579a, r101.f466579a) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public a(int[] r100, int r101) {
        this.f466579a = r100;
        this.f466580b = r101;
    }

    public final void b(int r100, int r101) {
        if (r101 < 0) goto L14;
        if (r101 > 32) goto L14;
        c(this.f466580b + r101);
    L6:
        if (r101 <= 0) goto L12;
        boolean r102 = true;
        if (((r100 >> (r101 - 1)) & 1) == 1) goto L11;
        r102 = false;
    L11:
        a(r102);
        r101 = r101 - 1;
        goto L6
    L12:
        return;
    L14:
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }
}
