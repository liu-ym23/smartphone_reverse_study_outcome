package fub;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f478923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f478924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f478925c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f478923a == r101.f478923a) goto L12;
        return false;
    L12:
        if (this.f478924b == r101.f478924b) goto L15;
        return false;
    L15:
        if (this.f478925c == r101.f478925c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f478923a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f478924b;
        return ((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f478925c;
    }

    public final String toString() {
        return "RecordingUploadProgress(bytesUploaded=" + this.f478923a + ", bytesTotal=" + this.f478924b + ", progressPercent=" + this.f478925c + ')';
    }

    public d(long r100, long r101, int r102) {
        this.f478923a = r100;
        this.f478924b = r101;
        this.f478925c = r102;
    }
}
