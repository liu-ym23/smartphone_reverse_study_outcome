package com.larus.network.http;

import com.larus.network.bean.BizResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<BizResponse<T>> f360137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<BizResponse<T>> f360138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f360139c;

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f360137a, r101.f360137a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f360138b, r101.f360138b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f360139c, r101.f360139c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f360137a.hashCode() * 31) + this.f360138b.hashCode()) * 31;
        T r101 = this.f360139c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AsyncData(async=" + this.f360137a + ", lastAsync=" + this.f360138b + ", data=" + this.f360139c + ')';
    }

    public /* synthetic */ b(f r100, int r101) {
        a r102 = r100;
        if ((r101 & 1) == 0) goto L6;
        r102 = z.f360206d;
    L6:
        if ((r101 & 2) == 0) goto L8;
        z r103 = z.f360206d;
    L9:
        this(r102, r103, null);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public b(a<BizResponse<T>> r100, a<BizResponse<T>> r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "async");
        Intrinsics.checkNotNullParameter(r101, "lastAsync");
        this.f360137a = r100;
        this.f360138b = r101;
        this.f360139c = r102;
    }

    public static b a(b r100, a r101, a r102) {
        T r103 = r100.f360139c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "async");
        Intrinsics.checkNotNullParameter(r102, "lastAsync");
        return new b(r101, r102, r103);
    }
}
