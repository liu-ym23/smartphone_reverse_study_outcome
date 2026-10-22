package com.ss.android.lark.vote.message.cell;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ImageSpan {
    public a(UDTagsDrawable r100) {
        super(r100);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Drawable r109 = getDrawable();
        Paint.FontMetrics r110 = r108.getFontMetrics();
        float r111 = r106;
        int r112 = (int) (((((r110.ascent + r111) + r111) + r110.descent) / 2.0f) - ((r109.getBounds().bottom + r109.getBounds().top) / 2));
        r100.save();
        r100.translate(r104, r112);
        r109.draw(r100);
        r100.restore();
    }
}
