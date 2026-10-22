package com.obric.assistant;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f389304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f389305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f389306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f389307d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f389304a == r101.f389304a) goto L12;
        return false;
    L12:
        if (this.f389305b == r101.f389305b) goto L15;
        return false;
    L15:
        if (this.f389306c == r101.f389306c) goto L18;
        return false;
    L18:
        if (this.f389307d == r101.f389307d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f389304a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f389305b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f389306c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f389307d == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraAuthTrustState(voicePassed=" + this.f389304a + ", biometricPassed=" + this.f389305b + ", phoneUnlocked=" + this.f389306c + ", isDoraWearOn=" + this.f389307d + ')';
    }

    public g(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f389304a = r100;
        this.f389305b = r101;
        this.f389306c = r102;
        this.f389307d = r103;
    }
}
