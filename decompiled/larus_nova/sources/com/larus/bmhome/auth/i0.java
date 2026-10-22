package com.larus.bmhome.auth;

/* JADX INFO: loaded from: classes25.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f295805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f295806b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (this.f295805a == r101.f295805a) goto L12;
        return false;
    L12:
        if (this.f295806b == r101.f295806b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f295805a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.f295806b == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "FullCacheWritePlan(version=" + this.f295805a + ", clearStaleConversation=" + this.f295806b + ')';
    }

    public i0(long r100, boolean r101) {
        this.f295805a = r100;
        this.f295806b = r101;
    }
}
