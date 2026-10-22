package tqc;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f547259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f547260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f547261c;

    public final int hashCode() {
        return (((this.f547259a * 31) + this.f547260b) * 31) + this.f547261c;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (b.class != r100.getClass()) goto L21;
        b r101 = (b) r100;
        if (this.f547259a == r101.f547259a) goto L14;
        return false;
    L14:
        if (this.f547260b == r101.f547260b) goto L17;
        return false;
    L17:
        if (this.f547261c == r101.f547261c) goto L22;
        return false;
    L22:
        return true;
    }

    public b(int r100, int r101, int r102) {
        this.f547259a = r100;
        this.f547260b = r101;
        this.f547261c = r102;
    }
}
