package com.lynx.textra;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import java.util.Objects;

/* JADX INFO: loaded from: classes32.dex */
public class JavaTypeface {
    private float dpi;
    public Font mFont;
    public FontKey mFontKey;
    private final Paint.FontMetrics mFontMetrics;
    public int mIndex;
    public long mNativeHandler;
    private float mTextSize;
    public Typeface mTypeface;

    public static class FontKey {
        String mFontFamily;
        int mFontWeight;
        boolean mItalic;

        public int hashCode() {
            return Objects.hash(new Object[]{this.mFontFamily, Integer.valueOf(this.mFontWeight), Boolean.valueOf(this.mItalic)});
        }

        public FontKey() {
            this.mFontFamily = "";
            this.mFontWeight = 400;
            this.mItalic = false;
        }

        public boolean equals(Object r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            if (getClass() != r100.getClass()) goto L19;
            FontKey r101 = (FontKey) r100;
            if (this.mFontWeight == r101.mFontWeight) goto L10;
            return false;
        L10:
            if (this.mItalic == r101.mItalic) goto L12;
            return false;
        L12:
            if (Objects.equals(this.mFontFamily, r101.mFontFamily) == false) goto L18;
            return true;
        L18:
            return false;
        L19:
            return false;
        }
    }

    public native void BindNativeHandler(long r100, JavaTypeface r101, int r102);

    public int hashCode() {
        return Objects.hash(new Object[]{this.mFontKey});
    }

    public float[] GetFontMetrics(float r100) {
        float[] r101 = new float[2];
        float r102 = this.mTextSize;
        if (r102 != 0.0f) goto L5;
    L8:
        TTText.mPainter.setTypeface(this.mTypeface);
        TTText.mPainter.setTextSize(TTTextUtils.Dp2Px(r100));
        TTText.mPainter.getFontMetrics(this.mFontMetrics);
        this.dpi = TTTextUtils.density_;
    L9:
        this.mTextSize = r100;
        r101[0] = TTTextUtils.Px2Dp(this.mFontMetrics.ascent);
        r101[1] = TTTextUtils.Px2Dp(this.mFontMetrics.descent);
        return r101;
    L5:
        if (this.dpi != TTTextUtils.density_) goto L8;
        float r103 = r100 / r102;
        Paint.FontMetrics r104 = this.mFontMetrics;
        r104.ascent *= r103;
        r104.descent *= r103;
        goto L9
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L15;
        if (this.mFontKey == ((JavaTypeface) r100).mFontKey) goto L16;
        return false;
    L16:
        return true;
    }

    public float[] GetTextBounds(char[] r100, float r101) {
        Paint r102 = TTText.mPainter;
        Rect r103 = new Rect();
        r102.setTypeface(this.mTypeface);
        r102.setTextSize(r101);
        r102.getTextBounds(r100, 0, r100.length, r103);
        return new float[]{r103.left, r103.top, r103.right, r103.bottom};
    }

    public JavaTypeface(int r100, Typeface r101, FontKey r102, long r103) {
        this.mTypeface = null;
        this.mFont = null;
        this.mFontMetrics = new Paint.FontMetrics();
        this.mTextSize = 0.0f;
        this.dpi = 1.0f;
        this.mIndex = r100;
        this.mTypeface = r101;
        this.mFontKey = r102;
        this.mNativeHandler = r103;
        GetFontMetrics(24.0f);
        BindNativeHandler(r103, this, this.mIndex);
    }

    public JavaTypeface(int r100, Font r101, FontKey r102, long r103) {
        this.mTypeface = null;
        this.mFont = null;
        this.mFontMetrics = new Paint.FontMetrics();
        this.mTextSize = 0.0f;
        this.dpi = 1.0f;
        this.mIndex = r100;
        this.mFont = r101;
        this.mFontKey = r102;
        this.mNativeHandler = r103;
        BindNativeHandler(r103, this, r100);
    }
}
