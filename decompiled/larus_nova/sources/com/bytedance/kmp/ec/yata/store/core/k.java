package com.bytedance.kmp.ec.yata.store.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f251745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public aa6.b f251746b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f251745a, r101.f251745a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f251746b, r101.f251746b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f251745a.hashCode() * 31) + this.f251746b.hashCode();
    }

    public final String toString() {
        return "YataProtocolContext(storeContext=" + this.f251745a + ", currentProtocol=" + this.f251746b + ')';
    }

    public k(m r100, aa6.b r101) {
        Intrinsics.checkNotNullParameter(r100, "storeContext");
        Intrinsics.checkNotNullParameter(r101, "currentProtocol");
        this.f251745a = r100;
        this.f251746b = r101;
    }
}
