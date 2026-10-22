package com.larus.avlink.gallery.view;

import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f293046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f293047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f293048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f293049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f293050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f293051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f293052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f293053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f293054i;

    public y() {
        this(0);
    }

    public static y a(boolean r110, String r111, int r112, int r113, int r114, String r115, boolean r116, boolean r117, Function0 r118) {
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r115, "buttonText");
        Intrinsics.checkNotNullParameter(r118, "onButtonClick");
        return new y(r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f293046a == r101.f293046a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f293047b, r101.f293047b) == true) goto L15;
        return false;
    L15:
        if (this.f293048c == r101.f293048c) goto L18;
        return false;
    L18:
        if (this.f293049d == r101.f293049d) goto L21;
        return false;
    L21:
        if (this.f293050e == r101.f293050e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f293051f, r101.f293051f) == true) goto L27;
        return false;
    L27:
        if (this.f293052g == r101.f293052g) goto L30;
        return false;
    L30:
        if (this.f293053h == r101.f293053h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f293054i, r101.f293054i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f293046a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((((((((r101 * 31) + this.f293047b.hashCode()) * 31) + this.f293048c) * 31) + this.f293049d) * 31) + this.f293050e) * 31) + this.f293051f.hashCode()) * 31;
        if (this.f293052g == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f293053h == true) goto L15;
        r100 = 1237;
    L15:
        return ((r104 + r100) * 31) + this.f293054i.hashCode();
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BannerState(isVisible=" + this.f293046a + ", title=" + this.f293047b + ", titleDrawable=" + this.f293048c + ", bgDrawable=" + this.f293049d + ", btnColor=" + this.f293050e + ", buttonText=" + this.f293051f + ", showCloseBtn=" + this.f293052g + ", showRotate=" + this.f293053h + ", onButtonClick=" + this.f293054i + ')';
    }

    public /* synthetic */ y(int r110) {
        this(false, "", R.drawable.larus_ic_album_sync, R.color.larus_additional_orange, R.color.larus_neutral_70, "", false, false, new x());
    }

    public y(boolean r100, String r101, int r102, int r103, int r104, String r105, boolean r106, boolean r107, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r105, "buttonText");
        Intrinsics.checkNotNullParameter(r110, "onButtonClick");
        this.f293046a = r100;
        this.f293047b = r101;
        this.f293048c = r102;
        this.f293049d = r103;
        this.f293050e = r104;
        this.f293051f = r105;
        this.f293052g = r106;
        this.f293053h = r107;
        this.f293054i = r110;
    }
}
