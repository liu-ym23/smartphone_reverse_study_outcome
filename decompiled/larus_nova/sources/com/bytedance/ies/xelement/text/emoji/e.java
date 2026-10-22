package com.bytedance.ies.xelement.text.emoji;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f250382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f250383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f250384c;

    public e(Drawable r100, Integer r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super(r100);
        this.f250382a = r101;
        this.f250383b = r102;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Integer r105 = this.f250382a;
        if (r105 == null) goto L13;
        int r106 = r103 - r102;
        if (r105 == null) goto L10;
        if (r105.intValue() == r106) goto L13;
    L10:
        if (this.f250384c == false) goto L13;
        return 0;
    L13:
        Rect r107 = getDrawable().getBounds();
        if (r104 == null) goto L17;
        Paint.FontMetricsInt r108 = r100.getFontMetricsInt();
        int r109 = r108.bottom - r108.top;
        int r110 = (r107.bottom - r107.top) / 2;
        int r111 = r109 / 4;
        int r112 = r110 - r111;
        int r113 = -(r110 + r111);
        r104.ascent = r113;
        r104.top = r113;
        r104.bottom = r112;
        r104.descent = r112;
    L17:
        return r107.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Integer r109 = this.f250382a;
        if (r109 == null) goto L13;
        int r110 = r103 - r102;
        if (r109 == null) goto L10;
        if (r109.intValue() == r110) goto L13;
    L10:
        if (this.f250384c == false) goto L13;
        this.f250384c = false;
        return;
    L13:
        Drawable r111 = getDrawable();
        Paint.FontMetricsInt r112 = r108.getFontMetricsInt();
        int r113 = ((((r112.descent + r106) + r106) + r112.ascent) / 2) - (r111.getBounds().bottom / 2);
        r100.save();
        r100.translate(r104 + 0, r113);
        r111.draw(r100);
        r100.restore();
        Integer r114 = this.f250382a;
        if (r114 == null) goto L22;
        int r115 = r103 - r102;
        if (r114 != null) goto L19;
    L20:
        this.f250384c = true;
        return;
    L19:
        if (r114.intValue() != r115) goto L20;
        return;
    }
}
