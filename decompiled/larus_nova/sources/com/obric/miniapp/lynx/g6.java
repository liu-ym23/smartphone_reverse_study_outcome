package com.obric.miniapp.lynx;

import android.graphics.Rect;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxBaseUI f398114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f398116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f398117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f398118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f398119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f398120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f398121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f398122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f398123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f398124k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f398125l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f398126m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f398127n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f398128o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f398129p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f398130q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f398131r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f398132s;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g6) == true) goto L8;
        return false;
    L8:
        g6 r101 = (g6) r100;
        if (Intrinsics.areEqual(this.f398114a, r101.f398114a) == true) goto L12;
        return false;
    L12:
        if (this.f398115b == r101.f398115b) goto L15;
        return false;
    L15:
        if (this.f398116c == r101.f398116c) goto L18;
        return false;
    L18:
        if (this.f398117d == r101.f398117d) goto L21;
        return false;
    L21:
        if (this.f398118e == r101.f398118e) goto L24;
        return false;
    L24:
        if (this.f398119f == r101.f398119f) goto L27;
        return false;
    L27:
        if (this.f398120g == r101.f398120g) goto L30;
        return false;
    L30:
        if (this.f398121h == r101.f398121h) goto L33;
        return false;
    L33:
        if (this.f398122i == r101.f398122i) goto L36;
        return false;
    L36:
        if (this.f398123j == r101.f398123j) goto L39;
        return false;
    L39:
        if (this.f398124k == r101.f398124k) goto L42;
        return false;
    L42:
        if (this.f398125l == r101.f398125l) goto L45;
        return false;
    L45:
        if (this.f398126m == r101.f398126m) goto L48;
        return false;
    L48:
        if (this.f398127n == r101.f398127n) goto L51;
        return false;
    L51:
        if (this.f398128o == r101.f398128o) goto L54;
        return false;
    L54:
        if (this.f398129p == r101.f398129p) goto L57;
        return false;
    L57:
        if (this.f398130q == r101.f398130q) goto L60;
        return false;
    L60:
        if (this.f398131r == r101.f398131r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f398132s, r101.f398132s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((((((((((((((((((this.f398114a.hashCode() * 31) + this.f398115b) * 31) + this.f398116c) * 31) + this.f398117d) * 31) + this.f398118e) * 31) + this.f398119f) * 31) + this.f398120g) * 31) + this.f398121h) * 31) + this.f398122i) * 31) + this.f398123j) * 31) + this.f398124k) * 31) + this.f398125l) * 31) + this.f398126m) * 31) + this.f398127n) * 31) + this.f398128o) * 31) + this.f398129p) * 31) + this.f398130q) * 31) + this.f398131r) * 31;
        Rect r101 = this.f398132s;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SheetChildLayoutSnapshot(ui=" + this.f398114a + ", depth=" + this.f398115b + ", left=" + this.f398116c + ", top=" + this.f398117d + ", width=" + this.f398118e + ", height=" + this.f398119f + ", paddingLeft=" + this.f398120g + ", paddingTop=" + this.f398121h + ", paddingRight=" + this.f398122i + ", paddingBottom=" + this.f398123j + ", marginLeft=" + this.f398124k + ", marginTop=" + this.f398125l + ", marginRight=" + this.f398126m + ", marginBottom=" + this.f398127n + ", borderLeftWidth=" + this.f398128o + ", borderTopWidth=" + this.f398129p + ", borderRightWidth=" + this.f398130q + ", borderBottomWidth=" + this.f398131r + ", bound=" + this.f398132s + ')';
    }

    public g6(LynxBaseUI r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, int r211, Rect r212) {
        Intrinsics.checkNotNullParameter(r100, "ui");
        this.f398114a = r100;
        this.f398115b = r101;
        this.f398116c = r102;
        this.f398117d = r103;
        this.f398118e = r104;
        this.f398119f = r105;
        this.f398120g = r110;
        this.f398121h = r111;
        this.f398122i = r112;
        this.f398123j = r113;
        this.f398124k = r114;
        this.f398125l = r115;
        this.f398126m = r116;
        this.f398127n = r117;
        this.f398128o = r118;
        this.f398129p = r119;
        this.f398130q = r210;
        this.f398131r = r211;
        this.f398132s = r212;
    }
}
