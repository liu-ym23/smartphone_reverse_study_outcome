package com.bytedance.badger.t;

/* JADX INFO: loaded from: classes47.dex */
public final class i extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f199204a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L13:
        return true;
    L5:
        if ((r100 instanceof i) == true) goto L7;
    L12:
        return false;
    L7:
        if (this.f199204a != ((i) r100).f199204a) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
    L9:
        r101 = false;
        goto L10
    }

    public final int hashCode() {
        long r100 = this.f199204a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "LongVal(value=" + this.f199204a + ")";
    }

    public i(long r100) {
        this.f199204a = r100;
    }
}
