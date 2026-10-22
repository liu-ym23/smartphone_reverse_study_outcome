package com.ss.android.lark.passportc.internal;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<com.ss.android.lark.passportc.api.o> f438459a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f438459a, ((d0) r100).f438459a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f438459a.hashCode();
    }

    public final String toString() {
        return "UserConventionData(convention=" + this.f438459a + ')';
    }

    public d0(WeakReference<com.ss.android.lark.passportc.api.o> r100) {
        Intrinsics.checkNotNullParameter(r100, "convention");
        this.f438459a = r100;
    }
}
