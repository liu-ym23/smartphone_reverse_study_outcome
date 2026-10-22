package com.larus.common.account.bdauth.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final za7.c f325944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f325945b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f325944a, r101.f325944a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f325945b, r101.f325945b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f325944a.hashCode() * 31) + this.f325945b.hashCode();
    }

    public final String toString() {
        return "BDAuthorizePrepareData(authInfoResponse=" + this.f325944a + ", accountSnapshot=" + this.f325945b + ')';
    }

    public e(za7.c r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "authInfoResponse");
        Intrinsics.checkNotNullParameter(r101, "accountSnapshot");
        this.f325944a = r100;
        this.f325945b = r101;
    }
}
