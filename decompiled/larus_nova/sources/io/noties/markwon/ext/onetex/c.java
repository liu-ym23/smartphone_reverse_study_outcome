package io.noties.markwon.ext.onetex;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spanned;

/* JADX INFO: loaded from: classes41.dex */
public final class c extends wsc.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f492398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f492399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f492400g;

    @Override // wsc.f
    public final void a(float r100) {
        Drawable r101 = this.f492398e.f561120e;
        if ((r101 instanceof g) == false) goto L6;
        ((g) r101).f492436g = r100;
        return;
    }

    public c(msc.s r100, b r101) {
        super(r100, r101);
        this.f492399f = new Paint(1);
        this.f492400g = 0;
        this.f492398e = r101;
    }

    @Override // wsc.f, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        if (this.f492398e.a() == false) goto L9;
        Rect r105 = this.f492398e.getBounds();
        if (r104 == null) goto L10;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = r105.height();
        int r108 = r106.descent;
        int r109 = r108 + ((r107 - (r108 - r106.ascent)) / 2);
        r104.descent = r109;
        int r110 = r109 - r105.height();
        r104.ascent = r110;
        r104.top = r110;
        r104.bottom = r104.descent;
    L10:
        return r105.right;
    L9:
        return (int) (r100.measureText(r101, r102, r103) + 0.5f);
    }

    @Override // wsc.f, android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r210, int r211, Paint r212) {
        b r100 = this.f492398e;
        int r101 = ftc.d.a(r110, r111);
        float r102 = r212.getTextSize();
        r100.f561122g = r101;
        r100.f561123h = r102;
        if (r100.f561124i == false) goto L5;
        r100.b();
    L5:
        b r103 = this.f492398e;
        io.noties.markwon.core.spans.o[] r104 = (io.noties.markwon.core.spans.o[]) ((Spanned) r111).getSpans(r112, r113, io.noties.markwon.core.spans.o.class);
        int r116 = 0;
        if (r104.length <= 0) goto L8;
        r103.setAlpha(r104[0].getAlpha());
    L10:
        if (r103.a() == false) goto L20;
        a(Math.max(r103.f561122g - r114, 0.0f));
        int r117 = r110.save();
        float r105 = r210;
        float r106 = ((r212.ascent() + r105) + (r105 + r212.descent())) / 2.0f;     // Catch: Throwable -> L17
        float r107 = r103.getBounds().centerY();     // Catch: Throwable -> L17
        Drawable r108 = r103.f561120e;     // Catch: Throwable -> L17
        if ((r108 instanceof g) == false) goto L15;
        r116 = ((g) r108).f492439j.getWidth();     // Catch: Throwable -> L17
    L15:
        this.f492399f.setColor(this.f492400g);     // Catch: Throwable -> L17
        r110.drawRect(r114, r115, r114 + r116, r211, this.f492399f);     // Catch: Throwable -> L17
        r110.translate(r114, (int) (r106 - r107));     // Catch: Throwable -> L17
        r103.draw(r110);     // Catch: Throwable -> L17
        r110.restoreToCount(r117);
        return;
    L17:
        th = move-exception;
        r110.restoreToCount(r117);
        throw th;
    L20:
        r110.drawText(r111, r112, r113, r114, (int) ((r115 + ((r211 - r115) / 2)) - (((r212.descent() + r212.ascent()) / 2.0f) + 0.5f)), r212);
        return;
    L8:
        r103.setAlpha(255);
        goto L10
    }
}
