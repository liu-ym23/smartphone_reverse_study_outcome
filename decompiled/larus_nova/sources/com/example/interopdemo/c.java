package com.example.interopdemo;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f274032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f274033b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f274032a == r101.f274032a) goto L12;
        return false;
    L12:
        if (this.f274033b == r101.f274033b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f274032a * 31) + this.f274033b;
    }

    public final String toString() {
        return "NativeMultiNetState(preState=" + this.f274032a + ", curState=" + this.f274033b + ')';
    }

    public c() {
        this.f274032a = 0;
        this.f274033b = 0;
    }
}
