package com.facebook.fbui.textlayoutbuilder;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes23.dex */
public class ResourceTextLayoutHelper {
    private static final int DEFAULT_TEXT_SIZE_PX = 15;

    public ResourceTextLayoutHelper() {
    }

    public static void setTextAppearance(TextLayoutBuilder r100, Context r101, int r102) {
        TypedArray r103 = r101.obtainStyledAttributes(r102, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        ColorStateList r104 = r103.getColorStateList(3);
        int r105 = r103.getDimensionPixelSize(0, 0);
        int r106 = r103.getInt(6, 0);
        if (r106 == 0) goto L5;
        float r107 = r103.getFloat(7, 0.0f);
        float r108 = r103.getFloat(8, 0.0f);
        r100.setShadowLayer(r103.getFloat(9, 0.0f), r107, r108, r106);
    L5:
        int r109 = r103.getInt(2, -1);
        r103.recycle();
        if (r104 == null) goto L8;
        r100.setTextColor(r104);
    L8:
        if (r105 == 0) goto L10;
        r100.setTextSize(r105);
    L10:
        if (r109 == (-1)) goto L13;
        r100.setTypeface(Typeface.defaultFromStyle(r109));
        return;
    }

    public static void updateFromStyleResource(TextLayoutBuilder r100, Context r101, int r102) {
        updateFromStyleResource(r100, r101, 0, r102);
    }

    public static void updateFromStyleResource(TextLayoutBuilder r100, Context r101, int r102, int r103) {
        updateFromStyleResource(r100, r101, null, r102, r103);
    }

    public static void updateFromStyleResource(TextLayoutBuilder r110, Context r111, AttributeSet r112, int r113, int r210) {
        TypedArray r100 = r111.obtainStyledAttributes(r112, new int[]{R.attr.textAppearance, R.attr.textSize, R.attr.textStyle, R.attr.textColor, R.attr.ellipsize, R.attr.maxLines, R.attr.singleLine, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.breakStrategy, R.attr.hyphenationFrequency}, r113, r210);
        int r101 = r100.getResourceId(0, -1);
        if (r101 <= 0) goto L5;
        setTextAppearance(r110, r111, r101);
    L5:
        ColorStateList r102 = r100.getColorStateList(3);
        int r103 = r100.getDimensionPixelSize(1, 15);
        int r104 = r100.getInt(7, 0);
        float r105 = r100.getFloat(8, 0.0f);
        float r114 = r100.getFloat(9, 0.0f);
        float r106 = r100.getFloat(10, 0.0f);
        int r115 = r100.getInt(2, -1);
        int r116 = r100.getInt(4, 0);
        boolean r107 = r100.getBoolean(6, false);
        int r117 = r100.getInt(5, Integer.MAX_VALUE);
        int r118 = r100.getInt(11, -1);
        int r108 = r100.getInt(12, -1);
        r100.recycle();
        r110.setTextColor(r102);
        r110.setTextSize(r103);
        r110.setShadowLayer(r106, r105, r114, r104);
        if (r115 == (-1)) goto L8;
        r110.setTypeface(Typeface.defaultFromStyle(r115));
    L9:
        if (r116 <= 0) goto L12;
        if (r116 >= 4) goto L12;
        r110.setEllipsize(TextUtils.TruncateAt.values()[r116 - 1]);
    L13:
        r110.setSingleLine(r107);
        r110.setMaxLines(r117);
        if (r118 <= (-1)) goto L16;
        r110.setBreakStrategy(r118);
    L16:
        if (r108 <= (-1)) goto L19;
        r110.setHyphenationFrequency(r108);
        return;
    L19:
        return;
    L12:
        r110.setEllipsize(null);
        goto L13
    L8:
        r110.setTypeface(null);
        goto L9
    }
}
