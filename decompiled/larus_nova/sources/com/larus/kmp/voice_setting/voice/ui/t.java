package com.larus.kmp.voice_setting.voice.ui;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f355057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f355058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Alignment f355059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FontWeight f355060d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Dp.m7549equalsimpl0(this.f355057a, r101.f355057a) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.f355058b, r101.f355058b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f355059c, r101.f355059c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f355060d, r101.f355060d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((Dp.m7550hashCodeimpl(this.f355057a) * 31) + Dp.m7550hashCodeimpl(this.f355058b)) * 31) + this.f355059c.hashCode()) * 31) + this.f355060d.hashCode();
    }

    public final String toString() {
        return "VoicePlatformUiTokens(doubleTabRowHorizontalPadding=" + Dp.m7555toStringimpl(this.f355057a) + ", doubleTabItemHorizontalPadding=" + Dp.m7555toStringimpl(this.f355058b) + ", rowAddButtonContentAlignment=" + this.f355059c + ", editAreaLabelFontWeight=" + this.f355060d + ')';
    }

    public t() {
        float r100 = Dp.m7544constructorimpl(12);
        float r101 = Dp.m7544constructorimpl(12);
        Alignment r102 = Alignment.Companion.getCenterStart();
        FontWeight r103 = FontWeight.Companion.getBold();
        Intrinsics.checkNotNullParameter(r102, "rowAddButtonContentAlignment");
        Intrinsics.checkNotNullParameter(r103, "editAreaLabelFontWeight");
        this.f355057a = r100;
        this.f355058b = r101;
        this.f355059c = r102;
        this.f355060d = r103;
    }
}
