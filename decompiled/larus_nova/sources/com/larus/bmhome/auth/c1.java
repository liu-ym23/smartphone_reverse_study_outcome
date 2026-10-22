package com.larus.bmhome.auth;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LaunchBiz f295750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f295751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f295752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f295753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f295754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f295755f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c1) == true) goto L8;
        return false;
    L8:
        c1 r101 = (c1) r100;
        if (this.f295750a == r101.f295750a) goto L12;
        return false;
    L12:
        if (this.f295751b == r101.f295751b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295752c, r101.f295752c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295753d, r101.f295753d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295754e, r101.f295754e) == true) goto L24;
        return false;
    L24:
        if (this.f295755f == r101.f295755f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f295750a.hashCode() * 31) + this.f295751b) * 31) + this.f295752c.hashCode()) * 31;
        T r101 = this.f295753d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Throwable r105 = this.f295754e;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        if (this.f295755f == false) goto L13;
        int r107 = 1231;
    L15:
        return r106 + r107;
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LaunchResult(biz=" + this.f295750a + ", status=" + this.f295751b + ", source=" + this.f295752c + ", data=" + this.f295753d + ", error=" + this.f295754e + ", fromCache=" + this.f295755f + ')';
    }

    public c1(LaunchBiz r100, int r101, String r102, T r103, Throwable r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r102, "source");
        this.f295750a = r100;
        this.f295751b = r101;
        this.f295752c = r102;
        this.f295753d = r103;
        this.f295754e = r104;
        this.f295755f = r105;
    }

    public /* synthetic */ c1(LaunchBiz r100, int r101, String r110, Object r111, boolean r112, int r113) {
        if ((r113 & 8) == 0) goto L5;
        r111 = null;
    L5:
        Object r102 = r111;
        if ((r113 & 32) == 0) goto L8;
        boolean r103 = false;
    L9:
        this(r100, r101, r110, r102, null, r103);
        return;
    L8:
        r103 = r112;
        goto L9
    }

    public static c1 a(c1 r100, int r101, String r102, Object r103, Throwable r110, boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        LaunchBiz r104 = r100.f295750a;
    L7:
        if ((r112 & 2) == 0) goto L9;
        r101 = r100.f295751b;
    L9:
        int r105 = r101;
        if ((r112 & 4) == 0) goto L12;
        r102 = r100.f295752c;
    L12:
        String r106 = r102;
        if ((r112 & 8) == 0) goto L15;
        r103 = r100.f295753d;
    L15:
        Object r107 = r103;
        if ((r112 & 16) == 0) goto L18;
        r110 = r100.f295754e;
    L18:
        Throwable r108 = r110;
        if ((r112 & 32) == 0) goto L21;
        r111 = r100.f295755f;
    L21:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "biz");
        Intrinsics.checkNotNullParameter(r106, "source");
        LaunchBiz r109 = r104;
        return new c1(r109, r105, r106, r107, r108, r111);
    L5:
        r104 = null;
        goto L7
    }
}
