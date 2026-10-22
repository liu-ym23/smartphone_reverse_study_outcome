package wr9;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f560891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f560892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f560893c;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f560891a == r101.f560891a) goto L12;
        return false;
    L12:
        if (this.f560892b == r101.f560892b) goto L15;
        return false;
    L15:
        if (this.f560893c == r101.f560893c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f560891a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f560892b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f560893c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "PowerStateMonitorConfig(cpuSampleIntervalMs=" + this.f560891a + ", deviceSampleIntervalMs=" + this.f560892b + ", staleAfterMs=" + this.f560893c + ')';
    }

    public g(int r100) {
        this.f560891a = 1000;
        this.f560892b = 1000;
        this.f560893c = 5000;
    }
}
