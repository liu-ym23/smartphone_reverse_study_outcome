package com.ss.android.lark.widget.codeblock.theme;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f445728a;

    public b(int r100) {
        this.f445728a = r100;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        if (r105 != null) goto L4;
        return;
    L4:
        int r106 = r105.descent;
        int r107 = r106 - r105.ascent;
        if (r107 >= 0) goto L7;
        return;
    L7:
        if (r107 != 0) goto L10;
        r105.descent = this.f445728a;
        r105.ascent = 0;
        return;
    L10:
        int r108 = MathKt.roundToInt(r106 * ((this.f445728a * 1.0f) / r107));
        r105.descent = r108;
        r105.ascent = r108 - this.f445728a;
    }
}
