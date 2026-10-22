package com.larus.bmhome.view.screenmenu;

/* JADX INFO: loaded from: classes26.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f317313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f317314b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (this.f317313a == r101.f317313a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f317314b, r101.f317314b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f317313a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + Float.floatToIntBits(this.f317314b);
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "MenuExtra(isEnabled=" + this.f317313a + ", alpha=" + this.f317314b + ')';
    }

    public k0() {
        this(true, 1.0f);
    }

    public k0(boolean r100, float r101) {
        this.f317313a = r100;
        this.f317314b = r101;
    }
}
