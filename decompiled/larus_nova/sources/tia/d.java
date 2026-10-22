package tia;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f546289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f546290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f546291c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f546289a == r101.f546289a) goto L12;
        return false;
    L12:
        if (this.f546290b == r101.f546290b) goto L15;
        return false;
    L15:
        if (this.f546291c == r101.f546291c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f546289a * 31;
        long r101 = this.f546290b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f546291c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "CaptureReadResult(readSize=" + this.f546289a + ", nextCursorMs=" + this.f546290b + ", missingMs=" + this.f546291c + ')';
    }

    public d(int r100, long r101, long r102) {
        this.f546289a = r100;
        this.f546290b = r101;
        this.f546291c = r102;
    }
}
