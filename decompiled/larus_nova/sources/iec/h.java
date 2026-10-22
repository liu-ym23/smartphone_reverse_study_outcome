package iec;

/* JADX INFO: loaded from: classes38.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f489537a;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (this.f489537a == ((h) r100).f489537a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f489537a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "TableDigestParams(showDigest=" + this.f489537a + ')';
    }

    public h(int r100) {
        this.f489537a = true;
    }
}
