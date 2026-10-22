package com.larus.avlink.record.page;

/* JADX INFO: loaded from: classes25.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f294279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f294280b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o1) == true) goto L8;
        return false;
    L8:
        o1 r101 = (o1) r100;
        if (this.f294279a == r101.f294279a) goto L12;
        return false;
    L12:
        if (this.f294280b == r101.f294280b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f294279a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f294280b;
        return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "UploadResult(isSuccess=" + this.f294279a + ", time=" + this.f294280b + ')';
    }

    public o1(long r100) {
        this.f294279a = false;
        this.f294280b = r100;
    }
}
