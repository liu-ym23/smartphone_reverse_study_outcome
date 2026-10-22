package com.larus.im.internal.network;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f349037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f349038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f349039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f349040d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f349037a, r101.f349037a) == true) goto L12;
        return false;
    L12:
        if (this.f349038b == r101.f349038b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f349039c, r101.f349039c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f349040d, r101.f349040d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f349037a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f349038b) * 31;
        String r104 = this.f349039c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Throwable r107 = this.f349040d;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "HttpResult(data=" + this.f349037a + ", code=" + this.f349038b + ", msg=" + this.f349039c + ", exception=" + this.f349040d + ')';
    }

    public b(T r100, int r101, String r102, Throwable r103) {
        this.f349037a = r100;
        this.f349038b = r101;
        this.f349039c = r102;
        this.f349040d = r103;
    }

    public /* synthetic */ b(Object r100, int r101, String r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102, null);
    }
}
