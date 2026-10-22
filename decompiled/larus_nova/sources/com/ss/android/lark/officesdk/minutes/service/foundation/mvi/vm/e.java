package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f433870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f433871b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f433870a, r101.f433870a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f433871b, r101.f433871b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f433870a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f433871b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Tuple2(a=" + this.f433870a + ", b=" + this.f433871b + ')';
    }

    public e(A r100, B r101) {
        this.f433870a = r100;
        this.f433871b = r101;
    }
}
