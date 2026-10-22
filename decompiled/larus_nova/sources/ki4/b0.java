package ki4;

/* JADX INFO: loaded from: classes15.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f503615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f503616b;

    public b0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (this.f503615a == r101.f503615a) goto L12;
        return false;
    L12:
        if (this.f503616b == r101.f503616b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f503615a * 31;
        if (this.f503616b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MaterialCursor(position=" + this.f503615a + ", hasNext=" + this.f503616b + ')';
    }

    public /* synthetic */ b0(int r100) {
        this(0, true);
    }

    public b0(int r100, boolean r101) {
        this.f503615a = r100;
        this.f503616b = r101;
    }
}
