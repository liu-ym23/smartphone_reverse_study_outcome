package jba;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f498042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f498043b;

    public a() {
        this(0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f498042a == r101.f498042a) goto L12;
        return false;
    L12:
        if (this.f498043b == r101.f498043b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f498042a * 31) + this.f498043b;
    }

    public final String toString() {
        return "ObricConsumedNavigationBarInsets(right=" + this.f498042a + ", bottom=" + this.f498043b + ')';
    }

    public a(int r100, int r101) {
        this.f498042a = r100;
        this.f498043b = r101;
    }
}
