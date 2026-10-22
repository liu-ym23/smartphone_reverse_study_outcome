package com.ss.android.lark.passport.flow.mfa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f437885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f437886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f437887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f437888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f437889e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f437885a, r101.f437885a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f437886b, r101.f437886b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f437887c, r101.f437887c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f437888d, r101.f437888d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f437889e, r101.f437889e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f437885a.hashCode() * 31;
        String r101 = this.f437886b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f437887c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f437888d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f437889e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MultiVerifyReportInfo(factorType=" + this.f437885a + ", flowType=" + this.f437886b + ", stepName=" + this.f437887c + ", stepOrigin=" + this.f437888d + ", mfaReason=" + this.f437889e + ')';
    }

    public a0(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "factorType");
        this.f437885a = r100;
        this.f437886b = r101;
        this.f437887c = r102;
        this.f437888d = r103;
        this.f437889e = r104;
    }
}
