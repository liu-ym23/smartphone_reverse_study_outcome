package com.larus.dora.impl.onboarding.g.v2.viewmodel;

/* JADX INFO: loaded from: classes27.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f336828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f336829b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f336828a == r101.f336828a) goto L12;
        return false;
    L12:
        if (this.f336829b == r101.f336829b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f336828a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f336829b;
        return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "State(state=" + this.f336828a + ", ts=" + this.f336829b + ')';
    }

    public q(boolean r100) {
        long r101 = System.currentTimeMillis();
        this.f336828a = r100;
        this.f336829b = r101;
    }
}
