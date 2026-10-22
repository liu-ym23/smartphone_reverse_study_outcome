package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes41.dex */
public final class e extends MetricAffectingSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final msc.s f492333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f492334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f492335c;

    public e(msc.s r100) {
        this.f492334b = p.f492357a;
        this.f492335c = p.f492359c;
        this.f492333a = r100;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        return this.f492333a.f515557q;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        this.f492333a.a(r100);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        this.f492333a.a(r100);
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r110, int r111, boolean r112, Layout r113) {
        this.f492335c.setStyle(Paint.Style.FILL);
        Paint r108 = this.f492335c;
        msc.s r109 = this.f492333a;
        int r114 = r109.f515556p;
        if (r114 != 0) goto L6;
        r114 = r109.f515555o;
    L6:
        if (r114 != 0) goto L9;
        r114 = ftc.a.a(r101.getColor(), 25);
    L9:
        r108.setColor(r114);
        if (r103 <= 0) goto L12;
        int r115 = r100.getWidth();
    L13:
        this.f492334b.set(r102, r104, r115, r106);
        r100.drawRect(this.f492334b, this.f492335c);
        return;
    L12:
        r102 = r102 - r100.getWidth();
        r115 = r102;
        goto L13
    }
}
