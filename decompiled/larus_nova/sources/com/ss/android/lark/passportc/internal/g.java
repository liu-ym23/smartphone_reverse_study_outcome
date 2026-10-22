package com.ss.android.lark.passportc.internal;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<com.ss.android.lark.passportc.api.n> f438462a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f438462a, ((g) r100).f438462a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f438462a.hashCode();
    }

    public final String toString() {
        return "ConventionData(convention=" + this.f438462a + ')';
    }

    public g(WeakReference<com.ss.android.lark.passportc.api.n> r100) {
        Intrinsics.checkNotNullParameter(r100, "convention");
        this.f438462a = r100;
    }
}
