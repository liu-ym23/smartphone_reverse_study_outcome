package z6a;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class k extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f570589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f570590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f570591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f570592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f570593e;

    public k() {
        this.f570591c = 0;
        this.f570593e = 1.0E21f;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r110) {
        Paint.FontMetricsInt r100 = r110.getFontMetricsInt();
        if (this.f570593e == 1.0E21f) goto L13;
        if (r100 == null) goto L13;
        c r101 = this.f570592d;
        if (r101 == null) goto L13;
        float r102 = ((Float) ListProtector.get(r101.f570560a, 1)).floatValue() - ((Float) ListProtector.get(this.f570592d.f570560a, 0)).floatValue();
        int r103 = this.f570589a;
        if (r103 != 4) goto L11;
        this.f570591c = -((int) ((((Math.ceil(this.f570593e) - ((double) r102)) / 2.0d) + ((double) r100.ascent)) - ((double) ((Float) ListProtector.get(this.f570592d.f570560a, 0)).floatValue())));
        goto L13
    L11:
        if (r103 != 7) goto L13;
        this.f570591c = (int) (((Math.ceil(this.f570593e) - ((double) r102)) / 2.0d) + ((double) ((-r100.descent) + ((Float) ListProtector.get(this.f570592d.f570560a, 1)).floatValue())));
    L13:
        r110.baselineShift = this.f570591c;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Paint.FontMetricsInt r101 = r100.getFontMetricsInt();
        if (r101 == null) goto L8;
        c r102 = this.f570592d;
        if (r102 == null) goto L9;
        int r103 = ((int) r102.a(this.f570589a, this.f570590b, r101.ascent, r101.descent)) - r101.ascent;
        this.f570591c = r103;
        r100.baselineShift = r103;
        return;
    L9:
        return;
    }
}
