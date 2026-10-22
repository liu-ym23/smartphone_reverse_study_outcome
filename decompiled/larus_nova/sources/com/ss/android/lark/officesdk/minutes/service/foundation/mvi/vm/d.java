package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d<A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f433869a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f433869a, ((d) r100).f433869a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f433869a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "Tuple1(a=" + this.f433869a + ')';
    }

    public d(A r100) {
        this.f433869a = r100;
    }
}
