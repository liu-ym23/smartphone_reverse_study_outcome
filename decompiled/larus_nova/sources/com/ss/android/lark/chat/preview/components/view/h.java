package com.ss.android.lark.chat.preview.components.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes35.dex */
public final class h extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f416212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f416213b;

    public h(g r100) {
        this.f416212a = new Paint();
        this.f416213b = r100;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        this.f416212a.set(r100);
        if (r104 == null) goto L6;
        this.f416212a.getFontMetricsInt(r104);
        Rect r105 = this.f416213b.getBounds();
        int r106 = r104.descent - r104.ascent;
        int r107 = ((int) 0.0f) / 2;
        int r108 = r104.top;
        r104.ascent = Math.min(r108, ((r106 - r105.bottom) / 2) + r108) - r107;
        int r109 = r104.bottom;
        int r110 = Math.max(r109, ((r105.bottom - r106) / 2) + r109) + r107;
        r104.descent = r110;
        r104.top = r104.ascent;
        r104.bottom = r110;
    L6:
        return this.f416213b.getBounds().right;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        r100.save();
        r100.translate(r104, ((r107 - this.f416213b.getBounds().bottom) + r105) / 2);
        this.f416213b.draw(r100);
        r100.restore();
    }
}
