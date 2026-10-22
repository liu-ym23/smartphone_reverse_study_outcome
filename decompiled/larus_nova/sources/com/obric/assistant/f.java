package com.obric.assistant;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f389201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraAuthTrustType f389202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraAuthTrustType f389203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f389204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f389205e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f389201a, r101.f389201a) == true) goto L12;
        return false;
    L12:
        if (this.f389202b == r101.f389202b) goto L15;
        return false;
    L15:
        if (this.f389203c == r101.f389203c) goto L18;
        return false;
    L18:
        if (this.f389204d == r101.f389204d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f389205e, r101.f389205e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f389201a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f389202b.hashCode()) * 31) + this.f389203c.hashCode()) * 31;
        if (this.f389204d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.f389205e;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraAuthTrustBuryPointState(sessionId=" + this.f389201a + ", originAuthType=" + this.f389202b + ", actualAuthType=" + this.f389203c + ", wearingState=" + this.f389204d + ", bluetoothEncryptId=" + this.f389205e + ')';
    }

    public f(String r100, DoraAuthTrustType r101, DoraAuthTrustType r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "originAuthType");
        Intrinsics.checkNotNullParameter(r102, "actualAuthType");
        this.f389201a = r100;
        this.f389202b = r101;
        this.f389203c = r102;
        this.f389204d = r103;
        this.f389205e = r104;
    }
}
