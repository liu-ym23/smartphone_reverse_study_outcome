package com.larus.avlink.plugins;

/* JADX INFO: loaded from: classes25.dex */
public final class v2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f294102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f294103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f294104c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v2) == true) goto L8;
        return false;
    L8:
        v2 r101 = (v2) r100;
        if (this.f294102a == r101.f294102a) goto L12;
        return false;
    L12:
        if (this.f294103b == r101.f294103b) goto L15;
        return false;
    L15:
        if (this.f294104c == r101.f294104c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f294102a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f294103b) * 31) + this.f294104c;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraSamiTimeoutConfig(enable=" + this.f294102a + ", startSessionTimeoutSeconds=" + this.f294103b + ", startSessionTimeoutOnRadioSeconds=" + this.f294104c + ')';
    }

    public v2(boolean r100, int r101, int r102) {
        this.f294102a = r100;
        this.f294103b = r101;
        this.f294104c = r102;
    }
}
