package com.larus.avlink.record.page;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f294215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f294216b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f294215a == r101.f294215a) goto L12;
        return false;
    L12:
        if (this.f294216b == r101.f294216b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f294215a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f294216b;
        return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeleteResult(isSuccess=" + this.f294215a + ", time=" + this.f294216b + ')';
    }

    public c(boolean r100, long r101) {
        this.f294215a = r100;
        this.f294216b = r101;
    }
}
