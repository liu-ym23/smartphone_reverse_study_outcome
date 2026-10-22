package com.bytedance.ee.bear.office.common.screenmenu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f235254d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u f235255e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u f235256f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScreenMenuBackgroundMode f235257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f235258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f235259c;

    public static final class a {
    }

    public u() {
        this(null, false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.f235257a == r101.f235257a) goto L12;
        return false;
    L12:
        if (this.f235258b == r101.f235258b) goto L15;
        return false;
    L15:
        if (this.f235259c == r101.f235259c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f235257a.hashCode() * 31;
        int r101 = 1231;
        if (this.f235258b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f235259c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ScreenMenuPresentation(backgroundMode=" + this.f235257a + ", showAnchorFocus=" + this.f235258b + ", closeOnBackgroundTouch=" + this.f235259c + ')';
    }

    static {
        f235254d = new u(null, false, 7);
        f235255e = new u(ScreenMenuBackgroundMode.BLUR_DIM, true, 4);
        f235256f = new u(ScreenMenuBackgroundMode.NONE, false, 4);
    }

    public u(ScreenMenuBackgroundMode r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r100 = ScreenMenuBackgroundMode.DIM;
    L5:
        boolean r103 = true;
        if ((r102 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r102 & 4) != 0) goto L12;
        r103 = false;
    L12:
        Intrinsics.checkNotNullParameter(r100, "backgroundMode");
        this.f235257a = r100;
        this.f235258b = r101;
        this.f235259c = r103;
    }
}
