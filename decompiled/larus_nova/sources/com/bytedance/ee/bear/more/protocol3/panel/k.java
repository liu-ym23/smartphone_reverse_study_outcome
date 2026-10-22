package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f234984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<x, String> f234985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<x, Integer> f234986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<x, Integer> f234987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<x, Integer> f234988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ItemUIStyle f234989f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f234984a, r101.f234984a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234985b, r101.f234985b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234986c, r101.f234986c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f234987d, r101.f234987d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234988e, r101.f234988e) == true) goto L24;
        return false;
    L24:
        if (this.f234989f == r101.f234989f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        q r100 = this.f234984a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function1<x, String> r104 = this.f234985b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function1<x, Integer> r107 = this.f234986c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Function1<x, Integer> r110 = this.f234987d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Function1<x, Integer> r113 = this.f234988e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ItemUIStyle r116 = this.f234989f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ItemOverride(delegate=" + this.f234984a + ", titleProvider=" + this.f234985b + ", iconProvider=" + this.f234986c + ", iconTintProvider=" + this.f234987d + ", disableIconTintProvider=" + this.f234988e + ", style=" + this.f234989f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(q r100, Function1<? super x, String> r101, Function1<? super x, Integer> r102, Function1<? super x, Integer> r103, Function1<? super x, Integer> r104, ItemUIStyle r105) {
        this.f234984a = r100;
        this.f234985b = r101;
        this.f234986c = r102;
        this.f234987d = r103;
        this.f234988e = r104;
        this.f234989f = r105;
    }
}
