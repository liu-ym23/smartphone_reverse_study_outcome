package z98;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f571057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f571058b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f571057a == r101.f571057a) goto L12;
        return false;
    L12:
        if (this.f571058b == r101.f571058b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f571057a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f571058b;
        return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraImageState(success=" + this.f571057a + ", timeStamp=" + this.f571058b + ')';
    }

    public d(boolean r100, long r101) {
        this.f571057a = r100;
        this.f571058b = r101;
    }
}
