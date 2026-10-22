package com.larus.uaigc.createpage.component.helper;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f371579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f371580b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f371579a == r101.f371579a) goto L12;
        return false;
    L12:
        if (this.f371580b == r101.f371580b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f371579a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f371580b;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "PhotoPickerConfig(isMultiMode=" + this.f371579a + ", maxSelectCount=" + this.f371580b + ')';
    }

    public b(int r100) {
        this.f371579a = false;
        this.f371580b = 0;
    }
}
