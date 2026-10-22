package xr4;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f564854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f564855b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f564854a == r101.f564854a) goto L12;
        return false;
    L12:
        if (this.f564855b == r101.f564855b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f564854a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f564855b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SoloBaseTenantInfo(isSoloBaseSuite=" + this.f564854a + ", isSoloBaseUser=" + this.f564855b + ')';
    }

    public a(boolean r100, boolean r101) {
        this.f564854a = r100;
        this.f564855b = r101;
    }
}
