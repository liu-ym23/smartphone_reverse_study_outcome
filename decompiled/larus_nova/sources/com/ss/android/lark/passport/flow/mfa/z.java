package com.ss.android.lark.passport.flow.mfa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f437939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f437940b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f437939a, r101.f437939a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f437940b, r101.f437940b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f437939a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f437940b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "IdpReportInfo(idpType=" + this.f437939a + ", hasTenantDomain=" + this.f437940b + ')';
    }

    public z(String r100, Boolean r101) {
        this.f437939a = r100;
        this.f437940b = r101;
    }
}
