package nv6;

/* JADX INFO: loaded from: classes21.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f520906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f520907b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f520906a == r101.f520906a) goto L12;
        return false;
    L12:
        if (this.f520907b == r101.f520907b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f520906a * 31;
        if (this.f520907b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "GoodsShelvesTabFilterData(listTab=" + this.f520906a + ", needShowing=" + this.f520907b + ')';
    }

    public m(int r100, boolean r101) {
        this.f520906a = r100;
        this.f520907b = r101;
    }
}
