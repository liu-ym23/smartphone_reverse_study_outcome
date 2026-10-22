package s9;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f541043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f541044b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f541043a == r101.f541043a) goto L12;
        return false;
    L12:
        if (this.f541044b == r101.f541044b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f541043a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f541044b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "Recorder(startTime=" + this.f541043a + ", endTime=" + this.f541044b + ')';
    }

    public f() {
        this.f541043a = 0;
        this.f541044b = 0;
    }
}
