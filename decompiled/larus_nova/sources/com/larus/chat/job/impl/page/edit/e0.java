package com.larus.chat.job.impl.page.edit;

/* JADX INFO: loaded from: classes26.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f325245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f325246b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (this.f325245a == r101.f325245a) goto L12;
        return false;
    L12:
        if (this.f325246b == r101.f325246b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f325245a * 31) + this.f325246b;
    }

    public final String toString() {
        return "ChatJobEditTime(hourOfDay=" + this.f325245a + ", minute=" + this.f325246b + ')';
    }

    public e0(int r100, int r101) {
        this.f325245a = r100;
        this.f325246b = r101;
    }
}
