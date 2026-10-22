package com.larus.contextwindow.impl.membership;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f330388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f330389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f330390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f330391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f330392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f330393f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f330388a == r101.f330388a) goto L12;
        return false;
    L12:
        if (this.f330389b == r101.f330389b) goto L15;
        return false;
    L15:
        if (this.f330390c == r101.f330390c) goto L18;
        return false;
    L18:
        if (this.f330391d == r101.f330391d) goto L21;
        return false;
    L21:
        if (this.f330392e == r101.f330392e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f330393f, r101.f330393f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f330388a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f330389b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f330390c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f330391d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f330392e == true) goto L22;
        r100 = 1237;
    L22:
        int r109 = (r108 + r100) * 31;
        String r110 = this.f330393f;
        if (r110 != null) goto L25;
        int r111 = 0;
    L27:
        return r109 + r111;
    L25:
        r111 = r110.hashCode();
        goto L27
    L17:
        r107 = 1237;
        goto L18
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
        return "MembershipQuotaRequestInputs(contextWindowEnabled=" + this.f330388a + ", membershipQuotaEnabled=" + this.f330389b + ", isOversea=" + this.f330390c + ", isLoggedIn=" + this.f330391d + ", isMinor=" + this.f330392e + ", accountId=" + this.f330393f + ')';
    }

    public j(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, String r105) {
        this.f330388a = r100;
        this.f330389b = r101;
        this.f330390c = r102;
        this.f330391d = r103;
        this.f330392e = r104;
        this.f330393f = r105;
    }
}
