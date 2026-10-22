package com.bytedance.kmp.ec.yata.store.node;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f251785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f251786b;

    public final int hashCode() {
        int r100 = this.f251785a * 31;
        T r101 = this.f251786b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof d) == false) goto L9;
        d r101 = (d) r100;
        if (this.f251785a != r101.f251785a) goto L9;
        if (Intrinsics.areEqual(this.f251786b, r101.f251786b) == false) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int r100, a r101) {
        this.f251785a = r100;
        this.f251786b = r101;
    }
}
