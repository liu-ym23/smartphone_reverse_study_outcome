package m81;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f512443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f512444b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f512443a == r101.f512443a) goto L8;
        return false;
    L8:
        if (this.f512444b == r101.f512444b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f512443a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f512444b;
    }

    public final String toString() {
        return "roomId: " + this.f512443a + ", orientation: " + this.f512444b;
    }

    public a(long r100, int r101) {
        this.f512443a = r100;
        this.f512444b = r101;
    }
}
