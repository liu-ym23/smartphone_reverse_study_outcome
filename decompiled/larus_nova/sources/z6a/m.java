package z6a;

import android.graphics.Rect;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes32.dex */
public final class m extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f570599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7a.b f570600b;

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
    }

    public m(a7a.b r100) {
        this.f570599a = new Rect();
        this.f570600b = r100;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        if (this.f570599a.width() != 0) goto L5;
        return;
    L5:
        if (this.f570599a.height() == 0) goto L10;
        this.f570600b.setBounds(this.f570599a);
        r100.setShader(this.f570600b.f2071b);
        return;
    }
}
