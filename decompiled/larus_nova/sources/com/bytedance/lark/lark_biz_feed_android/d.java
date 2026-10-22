package com.bytedance.lark.lark_biz_feed_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f253152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f253153b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f253152a == r101.f253152a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253153b, r101.f253153b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f253152a * 31) + this.f253153b.hashCode();
    }

    public final String toString() {
        return "BizError(code=" + this.f253152a + ", msg=" + this.f253153b + ')';
    }

    public d(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f253152a = r100;
        this.f253153b = r101;
    }
}
