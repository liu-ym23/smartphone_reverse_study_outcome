package com.obric.miniapp.utils;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f398463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f398464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f398465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f398466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f398467e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r101 = (d1) r100;
        if (Intrinsics.areEqual(this.f398463a, r101.f398463a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f398464b, r101.f398464b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f398465c, r101.f398465c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f398466d, r101.f398466d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f398467e, r101.f398467e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f398463a.hashCode() * 31) + Float.floatToIntBits(this.f398464b)) * 31) + Float.floatToIntBits(this.f398465c)) * 31) + Float.floatToIntBits(this.f398466d)) * 31) + Float.floatToIntBits(this.f398467e);
    }

    public final String toString() {
        return "PendingOutsideTap(focusedView=" + this.f398463a + ", downRawX=" + this.f398464b + ", downRawY=" + this.f398465c + ", windowX=" + this.f398466d + ", windowY=" + this.f398467e + ')';
    }

    public d1(View r100, float r101, float r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "focusedView");
        this.f398463a = r100;
        this.f398464b = r101;
        this.f398465c = r102;
        this.f398466d = r103;
        this.f398467e = r104;
    }
}
