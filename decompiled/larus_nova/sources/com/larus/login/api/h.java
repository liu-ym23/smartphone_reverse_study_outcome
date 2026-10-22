package com.larus.login.api;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f357037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<g0, Unit> f357038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<g0, Unit> f357039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<g0, Unit> f357040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<DismissReason, Unit> f357041e;

    public h() {
        this(null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f357037a, r101.f357037a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f357038b, r101.f357038b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f357039c, r101.f357039c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f357040d, r101.f357040d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f357041e, r101.f357041e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f357037a.hashCode() * 31;
        Function1<g0, Unit> r101 = this.f357038b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Function1<g0, Unit> r105 = this.f357039c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Function1<g0, Unit> r108 = this.f357040d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Function1<DismissReason, Unit> r111 = this.f357041e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BinderConfig(basicConfig=" + this.f357037a + ", onClickConfirm=" + this.f357038b + ", onClickCancel=" + this.f357039c + ", onClickClose=" + this.f357040d + ", onDismissWithReason=" + this.f357041e + ')';
    }

    public h(i r110, u r111, Function1 r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        i r100 = new i(null, null, null, null, null, null, false, null, null, false, 32767);
    L7:
        if ((r113 & 2) == 0) goto L9;
        Function1<g0, Unit> r101 = new e();
    L10:
        Function1 r102 = null;
        if ((r113 & 4) == 0) goto L13;
        Function1<g0, Unit> r103 = new f();
    L15:
        if ((r113 & 8) == 0) goto L17;
        Function1<g0, Unit> r104 = new g();
    L19:
        if ((r113 & 16) != 0) goto L22;
        r102 = r112;
    L22:
        Intrinsics.checkNotNullParameter(r100, "basicConfig");
        this.f357037a = r100;
        this.f357038b = r101;
        this.f357039c = r103;
        this.f357040d = r104;
        this.f357041e = r102;
        return;
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
