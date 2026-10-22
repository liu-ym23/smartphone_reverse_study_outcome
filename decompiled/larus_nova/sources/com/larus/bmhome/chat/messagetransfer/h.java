package com.larus.bmhome.chat.messagetransfer;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f307341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f307342b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f307341a == r101.f307341a) goto L12;
        return false;
    L12:
        if (this.f307342b == r101.f307342b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f307341a * 31;
        long r101 = this.f307342b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "ForwardLimitSelectionStats(selectCount=" + this.f307341a + ", selectSizeBytes=" + this.f307342b + ')';
    }

    public h(int r100, long r101) {
        this.f307341a = r100;
        this.f307342b = r101;
    }
}
