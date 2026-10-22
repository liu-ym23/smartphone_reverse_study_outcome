package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class m0 extends o70.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f571878a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m0) == true) goto L6;
        return false;
    L6:
        if (this.f571878a == ((m0) r100).f571878a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f571878a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "HideShortTouchAreaEvent(shouldHideShortTouchAreaEvent=" + this.f571878a + ")";
    }

    public m0(boolean r100) {
        this.f571878a = r100;
    }
}
