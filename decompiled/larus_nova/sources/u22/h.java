package u22;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f548423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f548424b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (this.f548423a == r101.f548423a) goto L8;
        return false;
    L8:
        if (this.f548424b == r101.f548424b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f548423a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f548424b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "PSMessageClickEvent(opType=" + this.f548423a + ", messageId=" + this.f548424b + ")";
    }

    public h(long r100, long r101) {
        this.f548423a = r100;
        this.f548424b = r101;
    }
}
