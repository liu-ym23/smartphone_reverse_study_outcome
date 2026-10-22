package com.bytedance.ee.bear.office.common.screenmenu;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements fk5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f235197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f235198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f235199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f235200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f235201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f235202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f235203g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f235197a == r101.f235197a) goto L12;
        return false;
    L12:
        if (this.f235198b == r101.f235198b) goto L15;
        return false;
    L15:
        if (this.f235199c == r101.f235199c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f235200d, r101.f235200d) == true) goto L21;
        return false;
    L21:
        if (this.f235201e == r101.f235201e) goto L24;
        return false;
    L24:
        if (this.f235202f == r101.f235202f) goto L27;
        return false;
    L27:
        if (this.f235203g == r101.f235203g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f235197a * 31) + this.f235198b) * 31) + this.f235199c) * 31;
        Drawable r101 = this.f235200d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f235201e) * 31) + this.f235202f) * 31;
        if (this.f235203g == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MenuDivider(id=" + this.f235197a + ", backgroundColor=" + this.f235198b + ", backgroundDrawableRes=" + this.f235199c + ", backgroundDrawable=" + this.f235200d + ", height=" + this.f235201e + ", width=" + this.f235202f + ", removeAroundDivider=" + this.f235203g + ')';
    }

    @Override // fk5.a
    public final boolean a() {
        return this.f235203g;
    }

    @Override // fk5.a
    public final int getId() {
        return this.f235197a;
    }

    public c(int r100, int r101, int r102, int r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 16) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 32) == 0) goto L12;
        r103 = 0;
    L12:
        if ((r104 & 64) == 0) goto L14;
        boolean r105 = true;
    L15:
        this.f235197a = r100;
        this.f235198b = 0;
        this.f235199c = r101;
        this.f235200d = null;
        this.f235201e = r102;
        this.f235202f = r103;
        this.f235203g = r105;
        return;
    L14:
        r105 = false;
        goto L15
    }
}
