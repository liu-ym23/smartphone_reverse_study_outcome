package com.larus.bmhome.utils;

/* JADX INFO: loaded from: classes26.dex */
public final class d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f315001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f315002b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d4) == true) goto L8;
        return false;
    L8:
        d4 r101 = (d4) r100;
        if (this.f315001a == r101.f315001a) goto L12;
        return false;
    L12:
        if (this.f315002b == r101.f315002b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f315001a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.f315002b == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "VisitEventStep(triggerTime=" + this.f315001a + ", triggered=" + this.f315002b + ')';
    }

    public d4() {
        this.f315001a = 0;
        this.f315002b = false;
    }
}
