package com.ss.android.lark.passport.flow.mfa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f437925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f437926b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f437925a, r101.f437925a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f437926b, r101.f437926b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f437925a.hashCode() * 31) + this.f437926b.hashCode();
    }

    public final String toString() {
        return "FlowRsaInfo(publicKey=" + this.f437925a + ", rsaToken=" + this.f437926b + ')';
    }

    public x(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "publicKey");
        Intrinsics.checkNotNullParameter(r101, "rsaToken");
        this.f437925a = r100;
        this.f437926b = r101;
    }
}
