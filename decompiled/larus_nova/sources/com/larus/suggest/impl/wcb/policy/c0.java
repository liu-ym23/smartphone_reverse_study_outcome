package com.larus.suggest.impl.wcb.policy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f369963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f369964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f369965c;

    public /* synthetic */ c0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (this.f369963a == r101.f369963a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f369964b, r101.f369964b) == true) goto L15;
        return false;
    L15:
        if (this.f369965c == r101.f369965c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f369963a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f369964b.hashCode()) * 31;
        if (this.f369965c == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "WcbResponseValidation(errorCode=" + this.f369963a + ", errorMessage=" + this.f369964b + ", interceptResponse=" + this.f369965c + ')';
    }

    public c0(long r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        this.f369963a = r100;
        this.f369964b = r101;
        this.f369965c = r102;
    }
}
