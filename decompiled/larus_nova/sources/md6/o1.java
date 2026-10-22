package md6;

/* JADX INFO: loaded from: classes19.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f513414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f513415b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o1) == true) goto L8;
        return false;
    L8:
        o1 r101 = (o1) r100;
        if (this.f513414a == r101.f513414a) goto L12;
        return false;
    L12:
        if (this.f513415b == r101.f513415b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f513414a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f513415b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ScrollInfo(isScrolling=" + this.f513414a + ", isTouching=" + this.f513415b + ')';
    }

    public o1(boolean r100, boolean r101) {
        this.f513414a = r100;
        this.f513415b = r101;
    }
}
