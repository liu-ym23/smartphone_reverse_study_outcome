package z6a;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes32.dex */
public final class e extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f570563a;

    public e(float r100) {
        this.f570563a = r100;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        if (Float.isNaN(this.f570563a) == true) goto L6;
        r100.setLetterSpacing(this.f570563a / r100.getTextSize());
        return;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        if (Float.isNaN(this.f570563a) == true) goto L6;
        r100.setLetterSpacing(this.f570563a / r100.getTextSize());
        return;
    }
}
