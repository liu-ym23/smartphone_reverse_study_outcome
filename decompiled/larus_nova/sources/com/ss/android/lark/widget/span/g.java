package com.ss.android.lark.widget.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class g extends DynamicDrawableSpan implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f448676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f448677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f448678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f448679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f448680e;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.widget.span.t
    public final int getPaddingLeft() {
        return 0;
    }

    @Override // com.ss.android.lark.widget.span.t
    public final int getPaddingRight() {
        return 0;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        return this.f448678c;
    }

    @Override // com.ss.android.lark.widget.span.t
    public final int getPaddingBottom() {
        return this.f448677b;
    }

    @Override // com.ss.android.lark.widget.span.t
    public final int getPaddingTop() {
        return this.f448676a;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public final int getVerticalAlignment() {
        return this.f448680e;
    }

    public g(Drawable r100) {
        this.f448678c = r100;
        this.f448679d = new Rect();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Drawable r105 = this.f448678c;
        if (r105 != null) goto L5;
        return 0;
    L5:
        Rect r106 = this.f448679d;
        r106.set(r105.getBounds());
        t.a.a(this, r106);
        if (r104 == null) goto L9;
        int r107 = -r106.bottom;
        r104.ascent = r107;
        r104.descent = 0;
        r104.top = r107;
        r104.bottom = 0;
    L9:
        return r106.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r110) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r110, "paint");
        Drawable r108 = this.f448678c;
        if (r108 != null) goto L5;
        return;
    L5:
        r100.save();
        Rect r109 = this.f448679d;
        r109.set(r108.getBounds());
        t.a.a(this, r109);
        int r111 = (r107 - r109.bottom) + this.f448676a;
        int r112 = this.f448680e;
        if (r112 != 1) goto L9;
        r111 = r111 - r110.getFontMetricsInt().descent;
    L11:
        r100.translate(r104 + 0, r111);
        r108.draw(r100);
        r100.restore();
        return;
    L9:
        if (r112 != 2) goto L11;
        r111 = (r105 + ((r107 - r105) / 2)) - (r109.height() / 2);
        goto L11
    }
}
