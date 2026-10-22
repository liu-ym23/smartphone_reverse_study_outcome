package com.larus.dora.obric.onboarding;

/* JADX INFO: loaded from: classes27.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f340844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f340845b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f340844a == r101.f340844a) goto L12;
        return false;
    L12:
        if (this.f340845b == r101.f340845b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f340844a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f340845b;
        return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "State(state=" + this.f340844a + ", ts=" + this.f340845b + ')';
    }

    public e(boolean r100) {
        long r101 = System.currentTimeMillis();
        this.f340844a = r100;
        this.f340845b = r101;
    }
}
