package u7;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f549027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f549028b;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f549027a == r101.f549027a) goto L12;
        return false;
    L12:
        if (this.f549028b == r101.f549028b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f549027a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f549028b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlavorModel(isLynx=" + this.f549027a + ", isDouyin=" + this.f549028b + ')';
    }

    public /* synthetic */ c(int r100) {
        this(false, true);
    }

    public c(boolean r100, boolean r101) {
        this.f549027a = r100;
        this.f549028b = r101;
    }
}
