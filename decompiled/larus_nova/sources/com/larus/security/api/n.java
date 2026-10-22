package com.larus.security.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f367877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f367878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f367879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f367880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f367881e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f367877a == r101.f367877a) goto L12;
        return false;
    L12:
        if (this.f367878b == r101.f367878b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f367879c, r101.f367879c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f367880d, r101.f367880d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f367881e, r101.f367881e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f367877a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f367878b;
        int r102 = ((((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f367879c.hashCode()) * 31;
        l r103 = this.f367880d;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f367881e;
        if (r107 == null) goto L15;
        r104 = r107.hashCode();
    L15:
        return r106 + r104;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "TtCnpaManualWriteResult(success=" + this.f367877a + ", errorCode=" + this.f367878b + ", errorDesc=" + this.f367879c + ", manifest=" + this.f367880d + ", rawJsonManifest=" + this.f367881e + ')';
    }

    public n(boolean r100, long r101, String r102, l r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "errorDesc");
        this.f367877a = r100;
        this.f367878b = r101;
        this.f367879c = r102;
        this.f367880d = r103;
        this.f367881e = r104;
    }
}
