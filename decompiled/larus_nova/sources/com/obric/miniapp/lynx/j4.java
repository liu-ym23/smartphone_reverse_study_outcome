package com.obric.miniapp.lynx;

import android.graphics.Rect;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxBaseUI f398157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f398159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f398160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f398161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f398162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f398163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f398164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f398165i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f398166j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f398167k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f398168l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f398169m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f398170n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f398171o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f398172p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f398173q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f398174r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f398175s;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j4) == true) goto L8;
        return false;
    L8:
        j4 r101 = (j4) r100;
        if (Intrinsics.areEqual(this.f398157a, r101.f398157a) == true) goto L12;
        return false;
    L12:
        if (this.f398158b == r101.f398158b) goto L15;
        return false;
    L15:
        if (this.f398159c == r101.f398159c) goto L18;
        return false;
    L18:
        if (this.f398160d == r101.f398160d) goto L21;
        return false;
    L21:
        if (this.f398161e == r101.f398161e) goto L24;
        return false;
    L24:
        if (this.f398162f == r101.f398162f) goto L27;
        return false;
    L27:
        if (this.f398163g == r101.f398163g) goto L30;
        return false;
    L30:
        if (this.f398164h == r101.f398164h) goto L33;
        return false;
    L33:
        if (this.f398165i == r101.f398165i) goto L36;
        return false;
    L36:
        if (this.f398166j == r101.f398166j) goto L39;
        return false;
    L39:
        if (this.f398167k == r101.f398167k) goto L42;
        return false;
    L42:
        if (this.f398168l == r101.f398168l) goto L45;
        return false;
    L45:
        if (this.f398169m == r101.f398169m) goto L48;
        return false;
    L48:
        if (this.f398170n == r101.f398170n) goto L51;
        return false;
    L51:
        if (this.f398171o == r101.f398171o) goto L54;
        return false;
    L54:
        if (this.f398172p == r101.f398172p) goto L57;
        return false;
    L57:
        if (this.f398173q == r101.f398173q) goto L60;
        return false;
    L60:
        if (this.f398174r == r101.f398174r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f398175s, r101.f398175s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((((((((((((((((((this.f398157a.hashCode() * 31) + this.f398158b) * 31) + this.f398159c) * 31) + this.f398160d) * 31) + this.f398161e) * 31) + this.f398162f) * 31) + this.f398163g) * 31) + this.f398164h) * 31) + this.f398165i) * 31) + this.f398166j) * 31) + this.f398167k) * 31) + this.f398168l) * 31) + this.f398169m) * 31) + this.f398170n) * 31) + this.f398171o) * 31) + this.f398172p) * 31) + this.f398173q) * 31) + this.f398174r) * 31;
        Rect r101 = this.f398175s;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MenuChildLayoutSnapshot(ui=" + this.f398157a + ", depth=" + this.f398158b + ", left=" + this.f398159c + ", top=" + this.f398160d + ", width=" + this.f398161e + ", height=" + this.f398162f + ", paddingLeft=" + this.f398163g + ", paddingTop=" + this.f398164h + ", paddingRight=" + this.f398165i + ", paddingBottom=" + this.f398166j + ", marginLeft=" + this.f398167k + ", marginTop=" + this.f398168l + ", marginRight=" + this.f398169m + ", marginBottom=" + this.f398170n + ", borderLeftWidth=" + this.f398171o + ", borderTopWidth=" + this.f398172p + ", borderRightWidth=" + this.f398173q + ", borderBottomWidth=" + this.f398174r + ", bound=" + this.f398175s + ')';
    }

    public j4(LynxBaseUI r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, int r211, Rect r212) {
        Intrinsics.checkNotNullParameter(r100, "ui");
        this.f398157a = r100;
        this.f398158b = r101;
        this.f398159c = r102;
        this.f398160d = r103;
        this.f398161e = r104;
        this.f398162f = r105;
        this.f398163g = r110;
        this.f398164h = r111;
        this.f398165i = r112;
        this.f398166j = r113;
        this.f398167k = r114;
        this.f398168l = r115;
        this.f398169m = r116;
        this.f398170n = r117;
        this.f398171o = r118;
        this.f398172p = r119;
        this.f398173q = r210;
        this.f398174r = r211;
        this.f398175s = r212;
    }
}
