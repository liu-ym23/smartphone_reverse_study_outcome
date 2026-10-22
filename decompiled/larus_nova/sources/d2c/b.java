package d2c;

import java.util.Arrays;
import tb2.c;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f466581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f466582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f466583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f466584d;

    public final Object clone() throws CloneNotSupportedException {
        return new b(this.f466581a, this.f466582b, this.f466583c, (int[]) this.f466584d.clone());
    }

    public final int hashCode() {
        int r100 = this.f466581a;
        return (((((((r100 * 31) + r100) * 31) + this.f466582b) * 31) + this.f466583c) * 31) + Arrays.hashCode(this.f466584d);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder(this.f466582b * (this.f466581a + 1));
        int r101 = 0;
    L4:
        if (r101 >= this.f466582b) goto L15;
        int r102 = 0;
    L7:
        if (r102 >= this.f466581a) goto L13;
        if (a(r102, r101) == false) goto L11;
        String r103 = "X ";
    L12:
        r100.append(r103);
        r102 = r102 + 1;
        goto L7
    L11:
        r103 = c.DEFAULT_TEXT;
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
        if (this.f466581a == r101.f466581a) goto L8;
        return false;
    L8:
        if (this.f466582b == r101.f466582b) goto L10;
        return false;
    L10:
        if (this.f466583c == r101.f466583c) goto L12;
        return false;
    L12:
        if (Arrays.equals(this.f466584d, r101.f466584d) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public b(int r100, int r101) {
        if (r100 < 1) goto L8;
        if (r101 < 1) goto L8;
        this.f466581a = r100;
        this.f466582b = r101;
        int r102 = (r100 + 31) / 32;
        this.f466583c = r102;
        this.f466584d = new int[r102 * r101];
        return;
    L8:
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    public final boolean a(int r100, int r101) {
        int r102 = (r101 * this.f466583c) + (r100 / 32);
        if (((this.f466584d[r102] >>> (r100 & 31)) & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public b(int r100, int r101, int r102, int[] r103) {
        this.f466581a = r100;
        this.f466582b = r101;
        this.f466583c = r102;
        this.f466584d = r103;
    }
}
