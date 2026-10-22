package com.bytedance.kmp.network.multinet;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiNetStateValue f252533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MultiNetStateValue f252534b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f252533a == r101.f252533a) goto L12;
        return false;
    L12:
        if (this.f252534b == r101.f252534b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f252533a.hashCode() * 31) + this.f252534b.hashCode();
    }

    public final String toString() {
        return "MultiNetState(preState=" + this.f252533a + ", curState=" + this.f252534b + ')';
    }

    public a(MultiNetStateValue r100, MultiNetStateValue r101) {
        Intrinsics.checkNotNullParameter(r100, "preState");
        Intrinsics.checkNotNullParameter(r101, "curState");
        this.f252533a = r100;
        this.f252534b = r101;
    }
}
