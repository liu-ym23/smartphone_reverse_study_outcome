package nr9;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f520244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f520245b;

    public b() {
        this(false, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f520244a == r101.f520244a) goto L12;
        return false;
    L12:
        if (this.f520245b == r101.f520245b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f520244a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f520245b;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "HotLaunchLandingConfig(enable=" + this.f520244a + ", interval=" + this.f520245b + ')';
    }

    public b(boolean r100, int r101) {
        this.f520244a = r100;
        this.f520245b = r101;
    }
}
