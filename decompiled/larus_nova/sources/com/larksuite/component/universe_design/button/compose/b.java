package com.larksuite.component.universe_design.button.compose;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f284611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f284612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f284613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f284614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextStyle f284615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f284616f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Dp.m7549equalsimpl0(this.f284611a, r101.f284611a) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.f284612b, r101.f284612b) == true) goto L15;
        return false;
    L15:
        if (Dp.m7549equalsimpl0(this.f284613c, r101.f284613c) == true) goto L18;
        return false;
    L18:
        if (this.f284614d == r101.f284614d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f284615e, r101.f284615e) == true) goto L24;
        return false;
    L24:
        if (this.f284616f == r101.f284616f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((Dp.m7550hashCodeimpl(this.f284611a) * 31) + Dp.m7550hashCodeimpl(this.f284612b)) * 31) + Dp.m7550hashCodeimpl(this.f284613c)) * 31;
        int r101 = 1231;
        if (this.f284614d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f284615e.hashCode()) * 31;
        if (this.f284616f == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "UDButtonSizeSpec(height=" + Dp.m7555toStringimpl(this.f284611a) + ", minWidth=" + Dp.m7555toStringimpl(this.f284612b) + ", horizontalPadding=" + Dp.m7555toStringimpl(this.f284613c) + ", fillMaxWidth=" + this.f284614d + ", textStyle=" + this.f284615e + ", custom=" + this.f284616f + ')';
    }

    public /* synthetic */ b(float r100, float r101, float r110, boolean r111, TextStyle r112) {
        this(r100, r101, r110, r111, r112, false);
    }

    public b(float r100, float r101, float r102, boolean r103, TextStyle r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r104, "textStyle");
        this.f284611a = r100;
        this.f284612b = r101;
        this.f284613c = r102;
        this.f284614d = r103;
        this.f284615e = r104;
        this.f284616f = r105;
    }
}
