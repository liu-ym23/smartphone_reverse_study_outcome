package wk;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f560066a;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (this.f560066a == ((d) r100).f560066a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f560066a;
    }

    public final String toString() {
        return "ModifiedPromotionEvent(num=" + this.f560066a + ")";
    }

    public d(int r100) {
        this.f560066a = r100;
    }
}
