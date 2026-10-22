package com.bytedance.locallife.biz.prefetch.newsdk;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class m<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f256966c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f256967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f256968b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f256967a, r101.f256967a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f256968b, r101.f256968b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f256967a.hashCode() * 31;
        T r101 = this.f256968b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "PrefetchRequestData(key=" + this.f256967a + ", data=" + this.f256968b + ')';
    }

    public m(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f256967a = r100;
        this.f256968b = r101;
    }
}
