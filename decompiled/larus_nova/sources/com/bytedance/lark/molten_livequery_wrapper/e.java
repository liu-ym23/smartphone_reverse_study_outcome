package com.bytedance.lark.molten_livequery_wrapper;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f253397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f253398b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f253397a == r101.f253397a) goto L12;
        return false;
    L12:
        if (this.f253398b == r101.f253398b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f253397a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f253398b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "IndexPath(index=" + this.f253397a + ", section=" + this.f253398b + ')';
    }

    public e(long r100, long r101) {
        this.f253397a = r100;
        this.f253398b = r101;
    }
}
