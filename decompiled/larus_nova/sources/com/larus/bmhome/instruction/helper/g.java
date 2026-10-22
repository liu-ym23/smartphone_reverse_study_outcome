package com.larus.bmhome.instruction.helper;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f312163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f312164b;

    public g() {
        this(false, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f312163a == r101.f312163a) goto L12;
        return false;
    L12:
        if (this.f312164b == r101.f312164b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f312163a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f312164b;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "PhotoPickerConfig(isMultiMode=" + this.f312163a + ", maxSelectCount=" + this.f312164b + ')';
    }

    public g(boolean r100, int r101) {
        this.f312163a = r100;
        this.f312164b = r101;
    }
}
