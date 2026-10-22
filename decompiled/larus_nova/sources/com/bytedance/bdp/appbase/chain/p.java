package com.bytedance.bdp.appbase.chain;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f200759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f200760b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L10;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f200759a, r101.f200759a) == true) goto L8;
        return false;
    L8:
        if (this.f200760b == r101.f200760b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Object r100 = this.f200759a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f200760b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "LockConfig(lock=" + this.f200759a + ", limit=" + this.f200760b + ")";
    }

    public p(Object r100, int r101) {
        this.f200759a = r100;
        this.f200760b = r101;
    }
}
