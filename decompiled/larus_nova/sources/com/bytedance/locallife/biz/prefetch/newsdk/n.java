package com.bytedance.locallife.biz.prefetch.newsdk;

import com.bytedance.retrofit2.SsResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f256969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SsResponse<?> f256970b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f256969a == r101.f256969a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f256970b, r101.f256970b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f256969a * 31) + this.f256970b.hashCode();
    }

    public final String toString() {
        return "PrefetchResult(code=" + this.f256969a + ", ssResponse=" + this.f256970b + ')';
    }

    public n(int r100, SsResponse<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "ssResponse");
        this.f256969a = r100;
        this.f256970b = r101;
    }
}
