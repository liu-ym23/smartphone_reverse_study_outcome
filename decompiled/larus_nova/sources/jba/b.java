package jba;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f498044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f498045b;

    public b() {
        this(0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f498044a == r101.f498044a) goto L12;
        return false;
    L12:
        if (this.f498045b == r101.f498045b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f498044a * 31) + this.f498045b;
    }

    public final String toString() {
        return "ObricHorizontalCutoutInsets(left=" + this.f498044a + ", right=" + this.f498045b + ')';
    }

    public b(int r100, int r101) {
        this.f498044a = r100;
        this.f498045b = r101;
    }
}
