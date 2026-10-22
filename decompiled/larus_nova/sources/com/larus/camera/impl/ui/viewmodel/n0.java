package com.larus.camera.impl.ui.viewmodel;

/* JADX INFO: loaded from: classes26.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f322666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f322667b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (this.f322666a == r101.f322666a) goto L12;
        return false;
    L12:
        if (this.f322667b == r101.f322667b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f322666a * 31;
        long r101 = this.f322667b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "MutableIntState(state=" + this.f322666a + ", version=" + this.f322667b + ')';
    }

    public n0(int r100, long r101) {
        this.f322666a = r100;
        this.f322667b = r101;
    }
}
