package com.larus.kmp.voice_setting.voice.ui;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.TextUnit;

/* JADX INFO: loaded from: classes30.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f355023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f355024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f355025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f355026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f355027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f355028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f355029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f355030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f355031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f355032j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f355033k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f355034l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f355035m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f355036n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f355037o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Dp.m7549equalsimpl0(this.f355023a, r101.f355023a) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.f355024b, r101.f355024b) == true) goto L15;
        return false;
    L15:
        if (Dp.m7549equalsimpl0(this.f355025c, r101.f355025c) == true) goto L18;
        return false;
    L18:
        if (Dp.m7549equalsimpl0(this.f355026d, r101.f355026d) == true) goto L21;
        return false;
    L21:
        if (Dp.m7549equalsimpl0(this.f355027e, r101.f355027e) == true) goto L24;
        return false;
    L24:
        if (Dp.m7549equalsimpl0(this.f355028f, r101.f355028f) == true) goto L27;
        return false;
    L27:
        if (Dp.m7549equalsimpl0(this.f355029g, r101.f355029g) == true) goto L30;
        return false;
    L30:
        if (Dp.m7549equalsimpl0(this.f355030h, r101.f355030h) == true) goto L33;
        return false;
    L33:
        if (Dp.m7549equalsimpl0(this.f355031i, r101.f355031i) == true) goto L36;
        return false;
    L36:
        if (Dp.m7549equalsimpl0(this.f355032j, r101.f355032j) == true) goto L39;
        return false;
    L39:
        if (TextUnit.m7739equalsimpl0(this.f355033k, r101.f355033k) == true) goto L42;
        return false;
    L42:
        if (IntSize.m7717equalsimpl0(this.f355034l, r101.f355034l) == true) goto L45;
        return false;
    L45:
        if (this.f355035m == r101.f355035m) goto L48;
        return false;
    L48:
        if (this.f355036n == r101.f355036n) goto L51;
        return false;
    L51:
        if (this.f355037o == r101.f355037o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((((((Dp.m7550hashCodeimpl(this.f355023a) * 31) + Dp.m7550hashCodeimpl(this.f355024b)) * 31) + Dp.m7550hashCodeimpl(this.f355025c)) * 31) + Dp.m7550hashCodeimpl(this.f355026d)) * 31) + Dp.m7550hashCodeimpl(this.f355027e)) * 31) + Dp.m7550hashCodeimpl(this.f355028f)) * 31) + Dp.m7550hashCodeimpl(this.f355029g)) * 31) + Dp.m7550hashCodeimpl(this.f355030h)) * 31) + Dp.m7550hashCodeimpl(this.f355031i)) * 31) + Dp.m7550hashCodeimpl(this.f355032j)) * 31) + TextUnit.m7743hashCodeimpl(this.f355033k)) * 31) + IntSize.m7720hashCodeimpl(this.f355034l)) * 31) + this.f355035m) * 31) + this.f355036n) * 31) + this.f355037o;
    }

    public final String toString() {
        return "VoiceDropdownMenuMetrics(menuWidth=" + Dp.m7555toStringimpl(this.f355023a) + ", itemHeight=" + Dp.m7555toStringimpl(this.f355024b) + ", itemHorizontalPadding=" + Dp.m7555toStringimpl(this.f355025c) + ", itemVerticalPadding=" + Dp.m7555toStringimpl(this.f355026d) + ", iconSize=" + Dp.m7555toStringimpl(this.f355027e) + ", iconTextGap=" + Dp.m7555toStringimpl(this.f355028f) + ", cornerRadius=" + Dp.m7555toStringimpl(this.f355029g) + ", elevation=" + Dp.m7555toStringimpl(this.f355030h) + ", shadowPadding=" + Dp.m7555toStringimpl(this.f355031i) + ", dividerHeight=" + Dp.m7555toStringimpl(this.f355032j) + ", textSize=" + TextUnit.m7749toStringimpl(this.f355033k) + ", menuContentSizePx=" + IntSize.m7722toStringimpl(this.f355034l) + ", shadowPaddingPx=" + this.f355035m + ", screenPaddingPx=" + this.f355036n + ", anchorGapPx=" + this.f355037o + ')';
    }

    public o(float r100, float r101, float r102, float r103, float r104, float r105, float r110, float r111, float r112, float r113, long r114, long r115, int r116, int r117, int r210) {
        this.f355023a = r100;
        this.f355024b = r101;
        this.f355025c = r102;
        this.f355026d = r103;
        this.f355027e = r104;
        this.f355028f = r105;
        this.f355029g = r110;
        this.f355030h = r111;
        this.f355031i = r112;
        this.f355032j = r113;
        this.f355033k = r114;
        this.f355034l = r115;
        this.f355035m = r116;
        this.f355036n = r117;
        this.f355037o = r210;
    }
}
