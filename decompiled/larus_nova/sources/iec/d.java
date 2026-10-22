package iec;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f489514a;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (this.f489514a == ((d) r100).f489514a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f489514a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "ColumnsDigestParams(showDigest=" + this.f489514a + ')';
    }

    public d(int r100) {
        this.f489514a = true;
    }
}
