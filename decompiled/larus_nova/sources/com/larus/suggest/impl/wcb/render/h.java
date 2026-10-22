package com.larus.suggest.impl.wcb.render;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f370047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f370048b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f370047a == r101.f370047a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f370048b, r101.f370048b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f370047a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        p r102 = this.f370048b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "WcbAnimationDecision(enabled=" + this.f370047a + ", reusableTarget=" + this.f370048b + ')';
    }

    public h(boolean r100, p r101) {
        this.f370047a = r100;
        this.f370048b = r101;
    }
}
