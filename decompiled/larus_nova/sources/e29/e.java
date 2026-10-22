package e29;

/* JADX INFO: loaded from: classes27.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f470844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f470845b;

    public e() {
        this(false, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f470844a == r101.f470844a) goto L12;
        return false;
    L12:
        if (this.f470845b == r101.f470845b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f470844a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f470845b;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "CommunityHostUiPolicy(useHostChrome=" + this.f470844a + ", tabListEndMargin=" + this.f470845b + ')';
    }

    public final boolean a(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        return false;
    L4:
        if (this.f470844a == true) goto L6;
        return true;
    }

    public e(boolean r100, int r101) {
        this.f470844a = r100;
        this.f470845b = r101;
    }
}
