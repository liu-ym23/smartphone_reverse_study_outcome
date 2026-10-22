package com.facebook.widget.text.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes23.dex */
public class BetterImageSpan extends ReplacementSpan {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    private final int mAlignment;
    private Rect mBounds;
    private final Drawable mDrawable;
    private final Paint.FontMetricsInt mFontMetricsInt;
    private int mHeight;
    private int mWidth;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BetterImageSpanAlignment {
    }

    public static final int normalizeAlignment(int r100) {
        if (r100 != 0) goto L4;
        return 0;
    L4:
        if (r100 == 2) goto L7;
        return 1;
    L7:
        return 2;
    }

    public void updateBounds() {
        Rect r100 = this.mDrawable.getBounds();
        this.mBounds = r100;
        this.mWidth = r100.width();
        this.mHeight = this.mBounds.height();
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public BetterImageSpan(Drawable r100) {
        this(r100, 1);
    }

    private int getOffsetAboveBaseline(Paint.FontMetricsInt r100) {
        int r101 = this.mAlignment;
        if (r101 == 0) goto L11;
        if (r101 != 2) goto L7;
        int r102 = r100.descent;
        int r103 = r100.ascent;
        return r103 + (((r102 - r103) - this.mHeight) / 2);
    L7:
        return -this.mHeight;
    L11:
        return r100.descent - this.mHeight;
    }

    public BetterImageSpan(Drawable r100, int r101) {
        this.mFontMetricsInt = new Paint.FontMetricsInt();
        this.mDrawable = r100;
        this.mAlignment = r101;
        updateBounds();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        updateBounds();
        if (r104 == null) goto L5;
        int r105 = getOffsetAboveBaseline(r104);
        int r106 = this.mHeight + r105;
        if (r105 >= r104.ascent) goto L10;
        r104.ascent = r105;
    L10:
        if (r105 >= r104.top) goto L13;
        r104.top = r105;
    L13:
        if (r106 <= r104.descent) goto L16;
        r104.descent = r106;
    L16:
        if (r106 <= r104.bottom) goto L19;
        r104.bottom = r106;
    L19:
        return this.mWidth;
    L5:
        return this.mWidth;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        r108.getFontMetricsInt(this.mFontMetricsInt);
        int r109 = r106 + getOffsetAboveBaseline(this.mFontMetricsInt);
        r100.translate(r104, r109);
        this.mDrawable.draw(r100);
        r100.translate(-r104, -r109);
    }
}
