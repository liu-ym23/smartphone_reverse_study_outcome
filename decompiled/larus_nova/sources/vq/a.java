package vq;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f556746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f556747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f556748c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f556746a == r101.f556746a) goto L8;
        return false;
    L8:
        if (this.f556747b == r101.f556747b) goto L10;
        return false;
    L10:
        if (this.f556748c == r101.f556748c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f556746a * 31) + this.f556747b) * 31) + this.f556748c;
    }

    public final String toString() {
        return "ABCParams(a=" + this.f556746a + ", b=" + this.f556747b + ", c=" + this.f556748c + ")";
    }

    public a(int r100, int r101, int r102) {
        this.f556746a = r100;
        this.f556747b = r101;
        this.f556748c = r102;
    }
}
