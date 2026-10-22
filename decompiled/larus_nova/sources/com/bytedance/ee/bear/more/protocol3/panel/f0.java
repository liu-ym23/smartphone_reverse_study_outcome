package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f0 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ItemUIStyle f234960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<x, String> f234961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<x, Integer> f234962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<x, Integer> f234963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<x, Integer> f234964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f234965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q f234966g;

    public f0() {
        this(null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (this.f234960a == r101.f234960a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234961b, r101.f234961b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234962c, r101.f234962c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f234963d, r101.f234963d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234964e, r101.f234964e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f234965f, r101.f234965f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f234966g, r101.f234966g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        ItemUIStyle r100 = this.f234960a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function1<x, String> r104 = this.f234961b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function1<x, Integer> r107 = this.f234962c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Function1<x, Integer> r110 = this.f234963d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Function1<x, Integer> r113 = this.f234964e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f234965f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        q r119 = this.f234966g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "StandardOverrideFactory(style=" + this.f234960a + ", titleProvider=" + this.f234961b + ", iconProvider=" + this.f234962c + ", iconTintProvider=" + this.f234963d + ", disableIconTintProvider=" + this.f234964e + ", itemId=" + this.f234965f + ", hostDelegate=" + this.f234966g + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0(ItemUIStyle r100, Function1<? super x, String> r101, Function1<? super x, Integer> r102, Function1<? super x, Integer> r103, Function1<? super x, Integer> r104, String r105, q r106) {
        this.f234960a = r100;
        this.f234961b = r101;
        this.f234962c = r102;
        this.f234963d = r103;
        this.f234964e = r104;
        this.f234965f = r105;
        this.f234966g = r106;
    }
}
