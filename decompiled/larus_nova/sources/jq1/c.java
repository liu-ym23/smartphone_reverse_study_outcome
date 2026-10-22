package jq1;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f500020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f500021b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f500020a == r101.f500020a) goto L8;
        return false;
    L8:
        if (this.f500021b == r101.f500021b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f500020a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f500021b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "ReplayLocalProgress(duration=" + this.f500020a + ", ts=" + this.f500021b + ")";
    }

    public c(long r100, long r101) {
        this.f500020a = r100;
        this.f500021b = r101;
    }
}
