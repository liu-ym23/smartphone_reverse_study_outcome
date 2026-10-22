package com.bytedance.ee.bear.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f216755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f216756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f216757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f216758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f216759e;

    public w() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f216755a, r101.f216755a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f216756b, r101.f216756b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f216757c, r101.f216757c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f216758d, r101.f216758d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f216759e, r101.f216759e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        g r100 = this.f216755a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        e r104 = this.f216756b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        d r107 = this.f216757c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        c r110 = this.f216758d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        a r113 = this.f216759e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "State(titleBarState=" + this.f216755a + ", loadingState=" + this.f216756b + ", loadingLayoutState=" + this.f216757c + ", errorState=" + this.f216758d + ", addFragmentState=" + this.f216759e + ')';
    }

    public /* synthetic */ w(g r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null, null, null, null);
    }

    public w(g r100, e r101, d r102, c r103, a r104) {
        this.f216755a = r100;
        this.f216756b = r101;
        this.f216757c = r102;
        this.f216758d = r103;
        this.f216759e = r104;
    }

    public static w a(w r100, g r101, e r102, d r103, c r110, a r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f216755a;
    L5:
        g r104 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f216756b;
    L8:
        e r105 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.f216757c;
    L11:
        d r106 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.f216758d;
    L14:
        c r107 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.f216759e;
    L17:
        r100.getClass();
        return new w(r104, r105, r106, r107, r111);
    }
}
