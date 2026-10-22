package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f571889a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n3) == true) goto L6;
        return false;
    L6:
        if (this.f571889a == ((n3) r100).f571889a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f571889a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "VrLandscapeEnterImmersedMode(isHide=" + this.f571889a + ")";
    }

    public n3(boolean r100) {
        this.f571889a = r100;
    }
}
