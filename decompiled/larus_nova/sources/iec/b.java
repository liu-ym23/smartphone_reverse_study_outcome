package iec;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f489512a;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.f489512a == ((b) r100).f489512a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f489512a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "AtDigestParams(isOrigin=" + this.f489512a + ')';
    }

    public b(int r100) {
        this.f489512a = true;
    }
}
