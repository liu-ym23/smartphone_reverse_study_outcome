package xs1;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f564940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f564941b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.f564940a == r101.f564940a) goto L8;
        return false;
    L8:
        if (this.f564941b == r101.f564941b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f564940a * 31;
        long r101 = this.f564941b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "AnchorProbePopupConfig(popupTimes=" + this.f564940a + ", popupTimestamp=" + this.f564941b + ")";
    }

    public b() {
        this.f564940a = 0;
        this.f564941b = 0;
    }
}
