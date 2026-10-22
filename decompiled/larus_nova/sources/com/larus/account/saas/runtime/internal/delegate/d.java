package com.larus.account.saas.runtime.internal.delegate;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f286471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f286472b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f286471a, r101.f286471a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f286472b, r101.f286472b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f286471a.hashCode() * 31) + this.f286472b.hashCode();
    }

    public final String toString() {
        return "SaasLoginProtocol(name=" + this.f286471a + ", url=" + this.f286472b + ')';
    }

    public d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f286471a = r100;
        this.f286472b = r101;
    }
}
