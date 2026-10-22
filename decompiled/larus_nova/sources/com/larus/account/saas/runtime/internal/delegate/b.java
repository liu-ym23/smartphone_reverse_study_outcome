package com.larus.account.saas.runtime.internal.delegate;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f286467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f286468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f286469c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f286467a, r101.f286467a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f286468b, r101.f286468b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f286469c, r101.f286469c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f286467a.hashCode() * 31) + this.f286468b.hashCode()) * 31) + this.f286469c.hashCode();
    }

    public final String toString() {
        return "SaasLoginContext(appName=" + this.f286467a + ", serviceAgreement=" + this.f286468b + ", privacyPolicy=" + this.f286469c + ')';
    }

    public b(String r100, d r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "appName");
        Intrinsics.checkNotNullParameter(r101, "serviceAgreement");
        Intrinsics.checkNotNullParameter(r102, "privacyPolicy");
        this.f286467a = r100;
        this.f286468b = r101;
        this.f286469c = r102;
    }
}
