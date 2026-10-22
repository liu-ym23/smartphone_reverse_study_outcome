package zn8;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f572962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f572963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f572964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f572965d;

    public l() {
        this(false, false, false, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f572962a == r101.f572962a) goto L12;
        return false;
    L12:
        if (this.f572963b == r101.f572963b) goto L15;
        return false;
    L15:
        if (this.f572964c == r101.f572964c) goto L18;
        return false;
    L18:
        if (this.f572965d == r101.f572965d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f572962a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f572963b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f572964c == true) goto L15;
        r100 = 1237;
    L15:
        return ((r104 + r100) * 31) + this.f572965d;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SizeData(isHead=" + this.f572962a + ", isTail=" + this.f572963b + ", showVideoTitle=" + this.f572964c + ", maxWidth=" + this.f572965d + ')';
    }

    public l(boolean r100, boolean r101, boolean r102, int r103) {
        this.f572962a = r100;
        this.f572963b = r101;
        this.f572964c = r102;
        this.f572965d = r103;
    }
}
