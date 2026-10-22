package com.google.android.material.resources;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: classes23.dex */
public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    private Typeface font;
    public final String fontFamily;
    private final int fontFamilyResourceId;
    private boolean fontResolved;
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    public final ColorStateList textColor;
    public final ColorStateList textColorHint;
    public final ColorStateList textColorLink;
    public final float textSize;
    public final int textStyle;
    public final int typeface;

    private void createFallbackTypeface() {
        if (this.font != null) goto L6;
        this.font = Typeface.create(this.fontFamily, this.textStyle);
    L6:
        if (this.font != null) goto L21;
        int r100 = this.typeface;
        if (r100 != 1) goto L10;
        this.font = Typeface.SANS_SERIF;
    L17:
        Typeface r101 = this.font;
        if (r101 == null) goto L22;
        this.font = Typeface.create(r101, this.textStyle);
        return;
    L22:
        return;
    L10:
        if (r100 != 2) goto L12;
        this.font = Typeface.SERIF;
        goto L17
    L12:
        if (r100 == 3) goto L14;
        this.font = Typeface.DEFAULT;
        goto L17
    L14:
        this.font = Typeface.MONOSPACE;
        goto L17
    }

    public static /* synthetic */ void access$200(TextAppearance r100) {
        r100.createFallbackTypeface();
    }

    public Typeface getFont(Context r100) {
        if (this.fontResolved == false) goto L7;
        return this.font;
    L7:
        if (r100.isRestricted() == false) goto L16;
    L13:
        createFallbackTypeface();
        this.fontResolved = true;
        return this.font;
    L16:
        Typeface r101 = ResourcesCompat.getFont(r100, this.fontFamilyResourceId);     // Catch: Exception -> L12 Throwable -> L15
        this.font = r101;     // Catch: Exception -> L12 Throwable -> L15
        if (r101 == null) goto L13;
        this.font = Typeface.create(r101, this.textStyle);     // Catch: Exception -> L12 Throwable -> L15
        goto L13
    }

    public TextAppearance(Context r100, int r101) {
        this.fontResolved = false;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        this.textSize = r102.getDimension(0, 0.0f);
        this.textColor = MaterialResources.getColorStateList(r100, r102, 3);
        this.textColorHint = MaterialResources.getColorStateList(r100, r102, 4);
        this.textColorLink = MaterialResources.getColorStateList(r100, r102, 5);
        this.textStyle = r102.getInt(2, 0);
        this.typeface = r102.getInt(1, 1);
        int r103 = MaterialResources.getIndexWithValue(r102, 12, 10);
        this.fontFamilyResourceId = r102.getResourceId(r103, 0);
        this.fontFamily = r102.getString(r103);
        this.textAllCaps = r102.getBoolean(14, false);
        this.shadowColor = MaterialResources.getColorStateList(r100, r102, 6);
        this.shadowDx = r102.getFloat(7, 0.0f);
        this.shadowDy = r102.getFloat(8, 0.0f);
        this.shadowRadius = r102.getFloat(9, 0.0f);
        r102.recycle();
    }

    public static /* synthetic */ Typeface access$002(TextAppearance r100, Typeface r101) {
        r100.font = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(TextAppearance r100, boolean r101) {
        r100.fontResolved = r101;
        return r101;
    }

    public void updateTextPaintMeasureState(TextPaint r100, Typeface r101) {
        r100.setTypeface(r101);
        int r102 = this.textStyle;
        int r103 = (~r101.getStyle()) & r102;
        if ((r103 & 1) == 0) goto L5;
        boolean r104 = true;
    L6:
        r100.setFakeBoldText(r104);
        if ((r103 & 2) == 0) goto L9;
        float r105 = -0.25f;
    L10:
        r100.setTextSkewX(r105);
        r100.setTextSize(this.textSize);
        return;
    L9:
        r105 = 0.0f;
        goto L10
    L5:
        r104 = false;
        goto L6
    }

    public void getFontAsync(Context r100, final TextPaint r101, final ResourcesCompat.FontCallback r102) {
        if (this.fontResolved == false) goto L6;
        updateTextPaintMeasureState(r101, this.font);
        return;
    L6:
        createFallbackTypeface();
        if (r100.isRestricted() == false) goto L15;
        this.fontResolved = true;
        updateTextPaintMeasureState(r101, this.font);
        return;
    L15:
        ResourcesCompat.getFont(r100, this.fontFamilyResourceId, new AnonymousClass1(this, r101, r102), null);     // Catch: Exception -> L12 Throwable -> L14
    L17:
        return;
    L18:
        return;
    }

    public void updateDrawState(Context r100, TextPaint r101, ResourcesCompat.FontCallback r102) {
        updateMeasureState(r100, r101, r102);
        ColorStateList r103 = this.textColor;
        if (r103 == null) goto L5;
        int r104 = r103.getColorForState(r101.drawableState, r103.getDefaultColor());
    L6:
        r101.setColor(r104);
        float r105 = this.shadowRadius;
        float r106 = this.shadowDx;
        float r107 = this.shadowDy;
        ColorStateList r108 = this.shadowColor;
        if (r108 == null) goto L9;
        int r109 = r108.getColorForState(r101.drawableState, r108.getDefaultColor());
    L10:
        r101.setShadowLayer(r105, r106, r107, r109);
        return;
    L9:
        r109 = 0;
        goto L10
    L5:
        r104 = -16777216;
        goto L6
    }

    public void updateMeasureState(Context r100, TextPaint r101, ResourcesCompat.FontCallback r102) {
        if (TextAppearanceConfig.shouldLoadFontSynchronously() == false) goto L5;
        updateTextPaintMeasureState(r101, getFont(r100));
        return;
    L5:
        getFontAsync(r100, r101, r102);
        if (this.fontResolved == true) goto L10;
        updateTextPaintMeasureState(r101, this.font);
        return;
    }
}
