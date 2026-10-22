package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes37.dex */
public abstract class ClearCacheDynamicDrawableSpan extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f439388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<Drawable> f439389b;

    public @interface AlignmentType {
    }

    public abstract Drawable b();

    public final Drawable a() {
        WeakReference<Drawable> r100 = this.f439389b;
        if (r100 == null) goto L5;
        Drawable r101 = r100.get();
    L6:
        if (r101 != null) goto L9;
        Drawable r102 = b();
        this.f439389b = new WeakReference(r102);
        return r102;
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public ClearCacheDynamicDrawableSpan(int r100) {
        this.f439388a = r100;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Rect r105 = a().getBounds();
        if (r104 == null) goto L6;
        int r106 = -r105.bottom;
        r104.ascent = r106;
        r104.descent = 0;
        r104.top = r106;
        r104.bottom = 0;
    L6:
        return r105.right;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Drawable r109 = a();
        r100.save();
        int r110 = r107 - r109.getBounds().bottom;
        int r111 = this.f439388a;
        if (r111 != 1) goto L6;
        r110 = r110 - r108.getFontMetricsInt().descent;
    L8:
        r100.translate(r104, r110);
        r109.draw(r100);
        r100.restore();
        return;
    L6:
        if (r111 != 2) goto L8;
        r110 = (r105 + ((r107 - r105) / 2)) - (r109.getBounds().height() / 2);
        goto L8
    }
}
