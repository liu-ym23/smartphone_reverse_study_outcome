package com.bytedance.lark.lark_biz_feed_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f253163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f253164b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (this.f253163a == r101.f253163a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253164b, r101.f253164b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f253163a * 31) + this.f253164b.hashCode();
    }

    public final String toString() {
        return "LarkFeedListContext(filterType=" + this.f253163a + ", containerScope=" + this.f253164b + ')';
    }

    public f0(l r100) {
        Intrinsics.checkNotNullParameter(r100, "containerScope");
        this.f253163a = 0;
        this.f253164b = r100;
    }
}
