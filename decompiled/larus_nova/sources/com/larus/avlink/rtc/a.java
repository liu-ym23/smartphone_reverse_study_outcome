package com.larus.avlink.rtc;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f294453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f294454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f294455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f294456d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f294453a == r101.f294453a) goto L12;
        return false;
    L12:
        if (this.f294454b == r101.f294454b) goto L15;
        return false;
    L15:
        if (this.f294455c == r101.f294455c) goto L18;
        return false;
    L18:
        if (this.f294456d == r101.f294456d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f294453a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f294454b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f294455c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f294456d == true) goto L19;
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
        return "DoraRtcConfig(useQuicLink=" + this.f294453a + ", useRTCLink=" + this.f294454b + ", useRTCNewConn=" + this.f294455c + ", useMMTLink=" + this.f294456d + ')';
    }

    public a(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f294453a = r100;
        this.f294454b = r101;
        this.f294455c = r102;
        this.f294456d = r103;
    }
}
