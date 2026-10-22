package com.obric.miniapp.lynx;

import android.graphics.Rect;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxBaseUI f398087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f398089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f398090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f398091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f398092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f398093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f398094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f398095i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f398096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f398097k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f398098l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f398099m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f398100n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f398101o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f398102p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f398103q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f398104r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f398105s;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f398087a, r101.f398087a) == true) goto L12;
        return false;
    L12:
        if (this.f398088b == r101.f398088b) goto L15;
        return false;
    L15:
        if (this.f398089c == r101.f398089c) goto L18;
        return false;
    L18:
        if (this.f398090d == r101.f398090d) goto L21;
        return false;
    L21:
        if (this.f398091e == r101.f398091e) goto L24;
        return false;
    L24:
        if (this.f398092f == r101.f398092f) goto L27;
        return false;
    L27:
        if (this.f398093g == r101.f398093g) goto L30;
        return false;
    L30:
        if (this.f398094h == r101.f398094h) goto L33;
        return false;
    L33:
        if (this.f398095i == r101.f398095i) goto L36;
        return false;
    L36:
        if (this.f398096j == r101.f398096j) goto L39;
        return false;
    L39:
        if (this.f398097k == r101.f398097k) goto L42;
        return false;
    L42:
        if (this.f398098l == r101.f398098l) goto L45;
        return false;
    L45:
        if (this.f398099m == r101.f398099m) goto L48;
        return false;
    L48:
        if (this.f398100n == r101.f398100n) goto L51;
        return false;
    L51:
        if (this.f398101o == r101.f398101o) goto L54;
        return false;
    L54:
        if (this.f398102p == r101.f398102p) goto L57;
        return false;
    L57:
        if (this.f398103q == r101.f398103q) goto L60;
        return false;
    L60:
        if (this.f398104r == r101.f398104r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f398105s, r101.f398105s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((((((((((((((((((this.f398087a.hashCode() * 31) + this.f398088b) * 31) + this.f398089c) * 31) + this.f398090d) * 31) + this.f398091e) * 31) + this.f398092f) * 31) + this.f398093g) * 31) + this.f398094h) * 31) + this.f398095i) * 31) + this.f398096j) * 31) + this.f398097k) * 31) + this.f398098l) * 31) + this.f398099m) * 31) + this.f398100n) * 31) + this.f398101o) * 31) + this.f398102p) * 31) + this.f398103q) * 31) + this.f398104r) * 31;
        Rect r101 = this.f398105s;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DialogChildLayoutSnapshot(ui=" + this.f398087a + ", depth=" + this.f398088b + ", left=" + this.f398089c + ", top=" + this.f398090d + ", width=" + this.f398091e + ", height=" + this.f398092f + ", paddingLeft=" + this.f398093g + ", paddingTop=" + this.f398094h + ", paddingRight=" + this.f398095i + ", paddingBottom=" + this.f398096j + ", marginLeft=" + this.f398097k + ", marginTop=" + this.f398098l + ", marginRight=" + this.f398099m + ", marginBottom=" + this.f398100n + ", borderLeftWidth=" + this.f398101o + ", borderTopWidth=" + this.f398102p + ", borderRightWidth=" + this.f398103q + ", borderBottomWidth=" + this.f398104r + ", bound=" + this.f398105s + ')';
    }

    public g(LynxBaseUI r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, int r211, Rect r212) {
        Intrinsics.checkNotNullParameter(r100, "ui");
        this.f398087a = r100;
        this.f398088b = r101;
        this.f398089c = r102;
        this.f398090d = r103;
        this.f398091e = r104;
        this.f398092f = r105;
        this.f398093g = r110;
        this.f398094h = r111;
        this.f398095i = r112;
        this.f398096j = r113;
        this.f398097k = r114;
        this.f398098l = r115;
        this.f398099m = r116;
        this.f398100n = r117;
        this.f398101o = r118;
        this.f398102p = r119;
        this.f398103q = r210;
        this.f398104r = r211;
        this.f398105s = r212;
    }
}
