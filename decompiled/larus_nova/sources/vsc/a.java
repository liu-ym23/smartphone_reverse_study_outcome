package vsc;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends MetricAffectingSpan {
    public a() {
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        r100.setTextSize(r100.getTextSize() * 0.75f);
        r100.baselineShift -= (int) (r100.ascent() / 2.0f);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        r100.setTextSize(r100.getTextSize() * 0.75f);
        r100.baselineShift -= (int) (r100.ascent() / 2.0f);
    }
}
