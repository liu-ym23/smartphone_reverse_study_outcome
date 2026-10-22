package com.bytedance.ee.bear.container;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f216745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f216746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f216747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f216748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f216749e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f216745a, r101.f216745a) == true) goto L12;
        return false;
    L12:
        if (this.f216746b == r101.f216746b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f216747c, r101.f216747c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f216748d, r101.f216748d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f216749e, r101.f216749e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f216745a.hashCode() * 31) + this.f216746b) * 31;
        Integer r101 = this.f216747c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f216748d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Function0<Unit> r108 = this.f216749e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContainerErrorState(msg='" + this.f216745a + "', iconRes=" + this.f216746b + ", code=" + this.f216747c + ", buttonTis=" + this.f216748d + ", action=" + this.f216749e + ')';
    }

    public c(String r100, int r101, Integer r102, String r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f216745a = r100;
        this.f216746b = r101;
        this.f216747c = r102;
        this.f216748d = r103;
        this.f216749e = r104;
    }
}
