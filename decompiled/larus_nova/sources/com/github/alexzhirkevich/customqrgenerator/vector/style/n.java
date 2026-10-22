package com.github.alexzhirkevich.customqrgenerator.vector.style;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f274307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f274308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f274309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f274310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f274311e;

    public n() {
        this(null, null, null, 31);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r100 = ((((((this.f274307a.hashCode() * 31) + this.f274308b.hashCode()) * 31) + this.f274309c.hashCode()) * 31) + this.f274310d.hashCode()) * 31;
        boolean r101 = this.f274311e;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "QrVectorShapes(darkPixel=" + this.f274307a + ", lightPixel=" + this.f274308b + ", ball=" + this.f274309c + ", frame=" + this.f274310d + ", centralSymmetry=" + this.f274311e + ')';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f274307a, r101.f274307a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f274308b, r101.f274308b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f274309c, r101.f274309c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f274310d, r101.f274310d) == true) goto L21;
        return false;
    L21:
        if (this.f274311e == r101.f274311e) goto L23;
        return false;
    L23:
        return true;
    }

    public n(p19.a r100, d.b r101, h.c r102, int r103) {
        l r104 = r100;
        if ((r103 & 1) == 0) goto L6;
        r104 = l.a.f274305b;
    L6:
        if ((r103 & 2) == 0) goto L8;
        l.a r105 = l.a.f274305b;
    L9:
        d r106 = r101;
        if ((r103 & 4) == 0) goto L12;
        r106 = d.c.f274278b;
    L12:
        h r107 = r102;
        if ((r103 & 8) == 0) goto L16;
        r107 = h.b.f274289a;
    L16:
        if ((r103 & 16) == 0) goto L18;
        boolean r108 = true;
    L19:
        Intrinsics.checkNotNullParameter(r104, "darkPixel");
        Intrinsics.checkNotNullParameter(r105, "lightPixel");
        Intrinsics.checkNotNullParameter(r106, "ball");
        Intrinsics.checkNotNullParameter(r107, "frame");
        this.f274307a = r104;
        this.f274308b = r105;
        this.f274309c = r106;
        this.f274310d = r107;
        this.f274311e = r108;
        return;
    L18:
        r108 = false;
        goto L19
    L8:
        r105 = null;
        goto L9
    }
}
