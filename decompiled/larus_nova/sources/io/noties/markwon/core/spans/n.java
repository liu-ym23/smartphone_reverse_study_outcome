package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
public class n extends MetricAffectingSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final msc.s f492353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f492354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f492355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f492356d;

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        return 0;
    }

    public final void a(TextPaint r100) {
        msc.s r101 = this.f492353a;
        int r102 = this.f492356d;
        Typeface r103 = r101.f515562v;
        if (r103 != null) goto L5;
        r100.setFakeBoldText(true);
    L6:
        float[] r104 = r101.f515563w;
        if (r104 != null) goto L11;
        r104 = msc.s.B;
    L11:
        if (r104.length < r102) goto L15;
        r100.setTextSize(r100.getTextSize() * r104[r102 - 1]);
        return;
    L15:
        throw new IllegalStateException(String.format(Locale.US, "Supplied heading level: %d is invalid, where configured heading sizes are: `%s`", new Object[]{Integer.valueOf(r102), Arrays.toString(r104)}));
    L5:
        r100.setTypeface(r103);
        goto L6
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        a(r100);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r100) {
        a(r100);
    }

    public n(msc.s r100, int r101) {
        this.f492354b = p.f492357a;
        this.f492355c = p.f492359c;
        this.f492353a = r100;
        this.f492356d = r101;
    }

    public void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r110, int r111, boolean r112, Layout r113) {
        int r108 = this.f492356d;
        boolean r109 = true;
        if (r108 == 1) goto L7;
        if (r108 == 2) goto L7;
        return;
    L7:
        if ((r107 instanceof Spanned) == true) goto L9;
    L11:
        r109 = false;
    L12:
        if (r109 == false) goto L29;
        this.f492355c.set(r101);
        msc.s r114 = this.f492353a;
        Paint r115 = this.f492355c;
        int r116 = r114.f515561u;
        if (r116 != 0) goto L17;
        r116 = ftc.a.a(r115.getColor(), 75);
    L17:
        r115.setColor(r116);
        r115.setStyle(Paint.Style.FILL);
        int r117 = r114.f515560t;
        if (r117 < 0) goto L20;
        r115.setStrokeWidth(r117);
    L20:
        float r118 = this.f492355c.getStrokeWidth();
        if (r118 <= 0.0f) goto L30;
        int r119 = (int) ((r106 - r118) + 0.5f);
        if (r103 <= 0) goto L25;
        int r120 = r100.getWidth();
    L26:
        this.f492354b.set(r102, r119, r120, r106);
        r100.drawRect(this.f492354b, this.f492355c);
        return;
    L25:
        r120 = r102;
        r102 = r102 - r100.getWidth();
        goto L26
    L30:
        return;
    L29:
        return;
    L9:
        if (((Spanned) r107).getSpanEnd(this) != r111) goto L11;
        goto L11
    }
}
