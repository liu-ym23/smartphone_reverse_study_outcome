package com.ss.android.lark.passportc.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.o f438460a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f438460a, ((e0) r100).f438460a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f438460a.hashCode();
    }

    public final String toString() {
        return "UserConventionDataStrong(convention=" + this.f438460a + ')';
    }

    public e0(com.ss.android.lark.passportc.api.o r100) {
        Intrinsics.checkNotNullParameter(r100, "convention");
        this.f438460a = r100;
    }
}
