package com.bytedance.locallife.biz.utils;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/* JADX INFO: loaded from: classes21.dex */
class SpanUtils$CustomTypefaceSpan extends TypefaceSpan {
    public SpanUtils$CustomTypefaceSpan() {
        throw null;
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        a(r100, null);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        a(r100, null);
    }

    public static void a(Paint r100, Typeface r101) {
        Typeface r102 = r100.getTypeface();
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = r103 & (~r101.getStyle());
        if ((r104 & 1) == 0) goto L10;
        r100.setFakeBoldText(true);
    L10:
        if ((r104 & 2) == 0) goto L12;
        r100.setTextSkewX(-0.25f);
    L12:
        r100.getShader();
        r100.setTypeface(r101);
        return;
    L5:
        r103 = r102.getStyle();
        goto L6
    }
}
