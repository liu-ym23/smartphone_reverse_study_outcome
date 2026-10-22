package hl;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f485633a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (this.f485633a == ((d) r100).f485633a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f485633a;
    }

    public final String toString() {
        return "CartCountChangeEvent(count=" + this.f485633a + ")";
    }

    public d(int r100) {
        this.f485633a = r100;
    }
}
