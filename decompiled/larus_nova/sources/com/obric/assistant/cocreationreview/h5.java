package com.obric.assistant.cocreationreview;

/* JADX INFO: loaded from: classes32.dex */
public final class h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f387303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f387304b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h5) == true) goto L8;
        return false;
    L8:
        h5 r101 = (h5) r100;
        if (this.f387303a == r101.f387303a) goto L12;
        return false;
    L12:
        if (this.f387304b == r101.f387304b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f387303a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f387304b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "LabelingObserveWindow(earliestTimeMillis=" + this.f387303a + ", latestTimeMillis=" + this.f387304b + ')';
    }

    public h5(long r100, long r101) {
        this.f387303a = r100;
        this.f387304b = r101;
    }
}
