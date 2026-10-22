package com.ss.android.lark.passportc.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.n f438467a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f438467a, ((h) r100).f438467a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f438467a.hashCode();
    }

    public final String toString() {
        return "ConventionDataStrong(convention=" + this.f438467a + ')';
    }

    public h(com.ss.android.lark.passportc.api.n r100) {
        Intrinsics.checkNotNullParameter(r100, "convention");
        this.f438467a = r100;
    }
}
