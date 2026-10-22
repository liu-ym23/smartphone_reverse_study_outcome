package com.facebook.fbui.textlayoutbuilder;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import androidx.collection.LruCache;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public class TextLayoutBuilder {
    public static final int DEFAULT_MAX_LINES = Integer.MAX_VALUE;
    private static final int EMS = 1;
    public static final int MEASURE_MODE_AT_MOST = 2;
    public static final int MEASURE_MODE_EXACTLY = 1;
    public static final int MEASURE_MODE_UNSPECIFIED = 0;
    private static final int PIXELS = 2;
    static final LruCache<Integer, Layout> sCache = null;
    private GlyphWarmer mGlyphWarmer;
    private int mMaxWidth;
    private int mMaxWidthMode;
    private int mMinWidth;
    private int mMinWidthMode;
    final Params mParams;
    private Layout mSavedLayout;
    private boolean mShouldCacheLayout;
    private boolean mShouldWarmText;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MeasureMode {
    }

    public static class Params {
        Layout.Alignment alignment;
        int breakStrategy;
        ColorStateList color;
        TextUtils.TruncateAt ellipsize;
        int hyphenationFrequency;
        boolean includePadding;
        int justificationMode;
        int[] leftIndents;
        boolean mForceNewPaint;
        int mShadowColor;
        float mShadowDx;
        float mShadowDy;
        float mShadowRadius;
        int maxLines;
        int measureMode;
        TextPaint paint;
        int[] rightIndents;
        boolean singleLine;
        float spacingAdd;
        float spacingMult;
        CharSequence text;
        TextDirectionHeuristicCompat textDirection;
        int width;

        public void createNewPaintIfNeeded() {
            if (this.mForceNewPaint == false) goto L6;
            TextPaint r100 = new TextPaint(this.paint);
            r100.set(this.paint);
            this.paint = r100;
            this.mForceNewPaint = false;
            return;
        }

        public int getLineHeight() {
            return Math.round((this.paint.getFontMetricsInt(null) * this.spacingMult) + this.spacingAdd);
        }

        public int hashCode() {
            int r100 = (((this.paint.getColor() + 31) * 31) + Float.floatToIntBits(this.paint.getTextSize())) * 31;
            int r101 = 0;
            if (this.paint.getTypeface() == null) goto L5;
            int r102 = this.paint.getTypeface().hashCode();
        L6:
            int r103 = (((((((((r100 + r102) * 31) + Float.floatToIntBits(this.mShadowDx)) * 31) + Float.floatToIntBits(this.mShadowDy)) * 31) + Float.floatToIntBits(this.mShadowRadius)) * 31) + this.mShadowColor) * 31;
            TextPaint r104 = this.paint;
            int r105 = (((((((((((((((r103 + r104.linkColor) * 31) + Float.floatToIntBits(r104.density)) * 31) + Arrays.hashCode(this.paint.drawableState)) * 31) + this.width) * 31) + this.measureMode) * 31) + Float.floatToIntBits(this.spacingMult)) * 31) + Float.floatToIntBits(this.spacingAdd)) * 31) + (this.includePadding ? 1 : 0)) * 31;
            TextUtils.TruncateAt r106 = this.ellipsize;
            if (r106 == null) goto L9;
            int r107 = r106.hashCode();
        L10:
            int r108 = (((((r105 + r107) * 31) + (this.singleLine ? 1 : 0)) * 31) + this.maxLines) * 31;
            Layout.Alignment r109 = this.alignment;
            if (r109 == null) goto L13;
            int r110 = r109.hashCode();
        L14:
            int r111 = (r108 + r110) * 31;
            TextDirectionHeuristicCompat r112 = this.textDirection;
            if (r112 == null) goto L17;
            int r113 = r112.hashCode();
        L18:
            int r114 = (((((((((r111 + r113) * 31) + this.breakStrategy) * 31) + this.hyphenationFrequency) * 31) + Arrays.hashCode(this.leftIndents)) * 31) + Arrays.hashCode(this.rightIndents)) * 31;
            CharSequence r115 = this.text;
            if (r115 == null) goto L22;
            r101 = r115.hashCode();
        L22:
            return r114 + r101;
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public Params() {
            this.paint = new TextPaint(1);
            this.spacingMult = 1.0f;
            this.spacingAdd = 0.0f;
            this.includePadding = true;
            this.ellipsize = null;
            this.singleLine = false;
            this.maxLines = Integer.MAX_VALUE;
            this.alignment = Layout.Alignment.ALIGN_NORMAL;
            this.textDirection = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
            this.breakStrategy = 0;
            this.hyphenationFrequency = 0;
            this.justificationMode = 0;
            this.mForceNewPaint = false;
        }
    }

    static {
        sCache = new LruCache(100);
    }

    public Layout build() {
        if (this.mShouldCacheLayout == false) goto L7;
        Layout r100 = this.mSavedLayout;
        if (r100 == null) goto L7;
        return r100;
    L7:
        BoringLayout.Metrics r101 = null;
        if (TextUtils.isEmpty(this.mParams.text) == false) goto L10;
        return null;
    L10:
        boolean r102 = false;
        if (this.mShouldCacheLayout == false) goto L18;
        CharSequence r103 = this.mParams.text;
        if ((r103 instanceof Spannable) == false) goto L18;
        if (((ClickableSpan[]) ((Spannable) r103).getSpans(0, r103.length() - 1, ClickableSpan.class)).length <= 0) goto L18;
        r102 = true;
    L18:
        if (this.mShouldCacheLayout == false) goto L24;
        if (r102 == true) goto L24;
        int r104 = this.mParams.hashCode();
        Layout r105 = sCache.get(Integer.valueOf(r104));
        if (r105 == null) goto L23;
        return r105;
    L23:
        int r106 = r104;
    L25:
        Params r107 = this.mParams;
        if (r107.singleLine == false) goto L28;
        int r108 = 1;
    L29:
        if (r108 == 1) goto L77;
    L37:
        BoringLayout.Metrics r110 = r101;
        Params r109 = this.mParams;
        int r111 = r109.measureMode;
        if (r111 == 0) goto L46;
        if (r111 != 1) goto L41;
        int r112 = r109.width;
    L47:
        int r113 = this.mParams.getLineHeight();
        if (this.mMaxWidthMode != 1) goto L50;
        int r114 = Math.min(r112, this.mMaxWidth * r113);
    L52:
        if (this.mMinWidthMode != 1) goto L54;
        int r115 = Math.max(r114, this.mMinWidth * r113);
    L55:
        int r116 = r115;
        if (r110 == null) goto L81;
        Params r117 = this.mParams;
        Layout r118 = BoringLayout.make(r117.text, r117.paint, r116, r117.alignment, r117.spacingMult, r117.spacingAdd, r110, r117.includePadding, r117.ellipsize, r116);
    L61:
        if (this.mShouldCacheLayout == false) goto L64;
        if (r102 == true) goto L64;
        this.mSavedLayout = r118;
        sCache.put(Integer.valueOf(r106), r118);
    L64:
        this.mParams.mForceNewPaint = true;
        if (this.mShouldWarmText == false) goto L69;
        GlyphWarmer r119 = this.mGlyphWarmer;
        if (r119 == null) goto L69;
        r119.warmLayout(r118);
    L69:
        return r118;
    L81:
        CharSequence r120 = this.mParams.text;     // Catch: IndexOutOfBoundsException -> L72
        int r121 = r120.length();     // Catch: IndexOutOfBoundsException -> L72
        Params r122 = this.mParams;     // Catch: IndexOutOfBoundsException -> L72
        r118 = StaticLayoutHelper.make(r120, 0, r121, r122.paint, r116, r122.alignment, r122.spacingMult, r122.spacingAdd, r122.includePadding, r122.ellipsize, r116, r108, r122.textDirection, r122.breakStrategy, r122.hyphenationFrequency, r122.justificationMode, r122.leftIndents, r122.rightIndents);     // Catch: IndexOutOfBoundsException -> L70
    L70:
        e = e;
    L73:
        Params r123 = this.mParams;
        CharSequence r124 = r123.text;
        if ((r124 instanceof String) == true) goto L76;
        r123.text = r124.toString();
        goto L81
    L76:
        throw e;
    L72:
        e = e;
        goto L73
    L54:
        r115 = Math.max(r114, this.mMinWidth);
        goto L55
    L50:
        r114 = Math.min(r112, this.mMaxWidth);
        goto L52
    L41:
        if (r111 != 2) goto L44;
        r112 = Math.min((int) Math.ceil(Layout.getDesiredWidth(r109.text, r109.paint)), this.mParams.width);
        goto L47
    L44:
        throw new IllegalStateException("Unexpected measure mode " + this.mParams.measureMode);
    L46:
        r112 = (int) Math.ceil(Layout.getDesiredWidth(r109.text, r109.paint));
        goto L47
    L77:
        r101 = BoringLayout.isBoring(r107.text, r107.paint);     // Catch: NullPointerException -> L32
    L32:
        e = move-exception;
        if (Build.VERSION.SDK_INT < 23) goto L37;
        throw e;
    L28:
        r108 = r107.maxLines;
    L24:
        r106 = -1;
        goto L25
    }

    public Layout.Alignment getAlignment() {
        return this.mParams.alignment;
    }

    public int getBreakStrategy() {
        return this.mParams.breakStrategy;
    }

    public float getDensity() {
        return this.mParams.paint.density;
    }

    public int[] getDrawableState() {
        return this.mParams.paint.drawableState;
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.mParams.ellipsize;
    }

    public int getHyphenationFrequency() {
        return this.mParams.hyphenationFrequency;
    }

    public boolean getIncludeFontPadding() {
        return this.mParams.includePadding;
    }

    public int getJustificationMode() {
        return this.mParams.justificationMode;
    }

    public int[] getLeftIndents() {
        return this.mParams.leftIndents;
    }

    public float getLetterSpacing() {
        return this.mParams.paint.getLetterSpacing();
    }

    public int getLinkColor() {
        return this.mParams.paint.linkColor;
    }

    public int getMaxEms() {
        if (this.mMaxWidthMode == 1) goto L7;
        return -1;
    L7:
        return this.mMaxWidth;
    }

    public int getMaxLines() {
        return this.mParams.maxLines;
    }

    public int getMaxWidth() {
        if (this.mMaxWidthMode == 2) goto L7;
        return -1;
    L7:
        return this.mMaxWidth;
    }

    public int getMinEms() {
        if (this.mMinWidthMode == 1) goto L7;
        return -1;
    L7:
        return this.mMinWidth;
    }

    public int getMinWidth() {
        if (this.mMinWidthMode == 2) goto L7;
        return -1;
    L7:
        return this.mMinWidth;
    }

    public int[] getRightIndents() {
        return this.mParams.rightIndents;
    }

    public boolean getSingleLine() {
        return this.mParams.singleLine;
    }

    public CharSequence getText() {
        return this.mParams.text;
    }

    public int getTextColor() {
        return this.mParams.paint.getColor();
    }

    public TextDirectionHeuristicCompat getTextDirection() {
        return this.mParams.textDirection;
    }

    public float getTextSize() {
        return this.mParams.paint.getTextSize();
    }

    public float getTextSpacingExtra() {
        return this.mParams.spacingAdd;
    }

    public float getTextSpacingMultiplier() {
        return this.mParams.spacingMult;
    }

    public Typeface getTypeface() {
        return this.mParams.paint.getTypeface();
    }

    public TextLayoutBuilder() {
        this.mMinWidth = 0;
        this.mMinWidthMode = 2;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxWidthMode = 2;
        this.mParams = new Params();
        this.mSavedLayout = null;
        this.mShouldCacheLayout = true;
        this.mShouldWarmText = false;
    }

    public GlyphWarmer getGlyphWarmer() {
        return this.mGlyphWarmer;
    }

    public boolean getShouldCacheLayout() {
        return this.mShouldCacheLayout;
    }

    public boolean getShouldWarmText() {
        return this.mShouldWarmText;
    }

    public TextLayoutBuilder setAlignment(Layout.Alignment r100) {
        Params r101 = this.mParams;
        if (r101.alignment == r100) goto L5;
        r101.alignment = r100;
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setBreakStrategy(int r100) {
        Params r101 = this.mParams;
        if (r101.breakStrategy == r100) goto L5;
        r101.breakStrategy = r100;
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setDensity(float r100) {
        Params r101 = this.mParams;
        if (r101.paint.density == r100) goto L5;
        r101.createNewPaintIfNeeded();
        this.mParams.paint.density = r100;
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setDrawableState(int[] r100) {
        this.mParams.createNewPaintIfNeeded();
        Params r101 = this.mParams;
        r101.paint.drawableState = r100;
        ColorStateList r102 = r101.color;
        if (r102 != null) goto L5;
    L7:
        return this;
    L5:
        if (r102.isStateful() == false) goto L7;
        int r103 = this.mParams.color.getColorForState(r100, 0);
        this.mParams.paint.setColor(r103);
        this.mSavedLayout = null;
        goto L7
    }

    public TextLayoutBuilder setEllipsize(TextUtils.TruncateAt r100) {
        Params r101 = this.mParams;
        if (r101.ellipsize == r100) goto L5;
        r101.ellipsize = r100;
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setGlyphWarmer(GlyphWarmer r100) {
        this.mGlyphWarmer = r100;
        return this;
    }

    public TextLayoutBuilder setHyphenationFrequency(int r100) {
        Params r101 = this.mParams;
        if (r101.hyphenationFrequency == r100) goto L7;
        r101.hyphenationFrequency = r100;
        if (Build.VERSION.SDK_INT < 23) goto L7;
        this.mSavedLayout = null;
    L7:
        return this;
    }

    public TextLayoutBuilder setIncludeFontPadding(boolean r100) {
        Params r101 = this.mParams;
        if (r101.includePadding == r100) goto L5;
        r101.includePadding = r100;
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setJustificationMode(int r100) {
        Params r101 = this.mParams;
        if (r101.justificationMode == r100) goto L7;
        r101.justificationMode = r100;
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        this.mSavedLayout = null;
    L7:
        return this;
    }

    public TextLayoutBuilder setLetterSpacing(float r100) {
        if (getLetterSpacing() == r100) goto L5;
        this.mParams.createNewPaintIfNeeded();
        this.mParams.paint.setLetterSpacing(r100);
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setLinkColor(int r100) {
        Params r101 = this.mParams;
        if (r101.paint.linkColor == r100) goto L5;
        r101.createNewPaintIfNeeded();
        this.mParams.paint.linkColor = r100;
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setMaxEms(int r100) {
        this.mMaxWidth = r100;
        this.mMaxWidthMode = 1;
        return this;
    }

    public TextLayoutBuilder setMaxLines(int r100) {
        Params r101 = this.mParams;
        if (r101.maxLines == r100) goto L5;
        r101.maxLines = r100;
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setMaxWidth(int r100) {
        this.mMaxWidth = r100;
        this.mMaxWidthMode = 2;
        return this;
    }

    public TextLayoutBuilder setMinEms(int r100) {
        this.mMinWidth = r100;
        this.mMinWidthMode = 1;
        return this;
    }

    public TextLayoutBuilder setMinWidth(int r100) {
        this.mMinWidth = r100;
        this.mMinWidthMode = 2;
        return this;
    }

    public TextLayoutBuilder setShouldCacheLayout(boolean r100) {
        this.mShouldCacheLayout = r100;
        return this;
    }

    public TextLayoutBuilder setShouldWarmText(boolean r100) {
        this.mShouldWarmText = r100;
        return this;
    }

    public TextLayoutBuilder setSingleLine(boolean r100) {
        Params r101 = this.mParams;
        if (r101.singleLine == r100) goto L5;
        r101.singleLine = r100;
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setText(CharSequence r100) {
        CharSequence r101 = this.mParams.text;
        if (r100 == r101) goto L10;
        if (r100 == null) goto L9;
        if (r101 == null) goto L9;
        if (r100.equals(r101) == true) goto L10;
    L9:
        this.mParams.text = r100;
        this.mSavedLayout = null;
    L10:
        return this;
    }

    public TextLayoutBuilder setTextColor(ColorStateList r100) {
        this.mParams.createNewPaintIfNeeded();
        Params r101 = this.mParams;
        r101.color = r100;
        TextPaint r102 = r101.paint;
        if (r100 == null) goto L5;
        int r103 = r100.getDefaultColor();
    L6:
        r102.setColor(r103);
        this.mSavedLayout = null;
        return this;
    L5:
        r103 = -16777216;
        goto L6
    }

    public TextLayoutBuilder setTextDirection(TextDirectionHeuristicCompat r100) {
        Params r101 = this.mParams;
        if (r101.textDirection == r100) goto L5;
        r101.textDirection = r100;
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setTextSize(int r100) {
        float r101 = r100;
        if (this.mParams.paint.getTextSize() == r101) goto L5;
        this.mParams.createNewPaintIfNeeded();
        this.mParams.paint.setTextSize(r101);
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setTextSpacingExtra(float r100) {
        Params r101 = this.mParams;
        if (r101.spacingAdd == r100) goto L5;
        r101.spacingAdd = r100;
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setTextSpacingMultiplier(float r100) {
        Params r101 = this.mParams;
        if (r101.spacingMult == r100) goto L5;
        r101.spacingMult = r100;
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setTextStyle(int r100) {
        return setTypeface(Typeface.defaultFromStyle(r100));
    }

    public TextLayoutBuilder setTypeface(Typeface r100) {
        if (this.mParams.paint.getTypeface() == r100) goto L5;
        this.mParams.createNewPaintIfNeeded();
        this.mParams.paint.setTypeface(r100);
        this.mSavedLayout = null;
    L5:
        return this;
    }

    public TextLayoutBuilder setWidth(int r100) {
        if (r100 > 0) goto L4;
        int r101 = 0;
    L6:
        return setWidth(r100, r101);
    L4:
        r101 = 1;
        goto L6
    }

    public TextLayoutBuilder setTextColor(int r100) {
        this.mParams.createNewPaintIfNeeded();
        Params r101 = this.mParams;
        r101.color = null;
        r101.paint.setColor(r100);
        this.mSavedLayout = null;
        return this;
    }

    public TextLayoutBuilder setIndents(int[] r100, int[] r101) {
        Params r102 = this.mParams;
        r102.leftIndents = r100;
        r102.rightIndents = r101;
        this.mSavedLayout = null;
        return this;
    }

    public TextLayoutBuilder setWidth(int r100, int r101) {
        Params r102 = this.mParams;
        if (r102.width == r100) goto L5;
    L6:
        r102.width = r100;
        r102.measureMode = r101;
        this.mSavedLayout = null;
    L7:
        return this;
    L5:
        if (r102.measureMode == r101) goto L7;
        goto L6
    }

    public TextLayoutBuilder setShadowLayer(float r100, float r101, float r102, int r103) {
        this.mParams.createNewPaintIfNeeded();
        Params r104 = this.mParams;
        r104.mShadowRadius = r100;
        r104.mShadowDx = r101;
        r104.mShadowDy = r102;
        r104.mShadowColor = r103;
        r104.paint.setShadowLayer(r100, r101, r102, r103);
        this.mSavedLayout = null;
        return this;
    }
}
