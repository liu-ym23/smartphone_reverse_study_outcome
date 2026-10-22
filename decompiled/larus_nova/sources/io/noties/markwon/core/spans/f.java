package io.noties.markwon.core.spans;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes41.dex */
public final class f extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final msc.s f492336a;

    public f(msc.s r100) {
        this.f492336a = r100;
    }

    public final void a(TextPaint r100) {
        msc.s r101 = this.f492336a;
        int r102 = r101.f515553m;
        if (r102 == 0) goto L5;
        r100.setColor(r102);
    L5:
        Typeface r103 = r101.f515558r;
        if (r103 == null) goto L10;
        r100.setTypeface(r103);
        int r104 = r101.f515559s;
        if (r104 <= 0) goto L15;
        r100.setTextSize(r104);
        return;
    L15:
        return;
    L10:
        r100.setTypeface(Typeface.MONOSPACE);
        int r105 = r101.f515559s;
        if (r105 <= 0) goto L13;
        r100.setTextSize(r105);
        return;
    L13:
        r100.setTextSize(r100.getTextSize() * 0.87f);
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        a(r100);
        int r101 = this.f492336a.f515555o;
        if (r101 != 0) goto L6;
        r101 = ftc.a.a(r100.getColor(), 25);
    L6:
        r100.bgColor = r101;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        a(r100);
    }
}
