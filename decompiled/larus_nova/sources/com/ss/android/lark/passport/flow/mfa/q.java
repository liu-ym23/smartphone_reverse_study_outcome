package com.ss.android.lark.passport.flow.mfa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f437910a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f437910a, ((q) r100).f437910a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f437910a.hashCode();
    }

    public final String toString() {
        return "FlowMfaStartResult(mfaToken=" + this.f437910a + ')';
    }

    public q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mfaToken");
        this.f437910a = r100;
    }
}
