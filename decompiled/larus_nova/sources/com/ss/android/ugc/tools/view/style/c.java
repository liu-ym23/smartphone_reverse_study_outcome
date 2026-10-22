package com.ss.android.ugc.tools.view.style;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c {
    public static final void c(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$textBold");
        Typeface r101 = StyleCentre.a(FontType.MEDIUM.getFONT_NAME());
        if (r101 == null) goto L5;
        r100.setTypeface(r101);
        return;
    L5:
        r100.setTypeface(r100.getTypeface(), 1);
    }

    public static void a(TextView r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$initFontByAttributeSet");
        if (r101 == null) goto L5;
        TypedArray r102 = r100.getContext().obtainStyledAttributes(r101, new int[]{R.attr.ts_background_color, R.attr.ts_circle, R.attr.ts_enable_background_color, R.attr.ts_enable_selection_tint_color, R.attr.ts_enable_text_color, R.attr.ts_enable_tint_color, R.attr.ts_first_item_margin, R.attr.ts_font_type, R.attr.ts_force_exclude_font_padding, R.attr.ts_force_include_font_padding, R.attr.ts_item_margin, R.attr.ts_item_show_border, R.attr.ts_last_item_margin, R.attr.ts_loading_border_radius, R.attr.ts_loading_circle_radius, R.attr.ts_margin_tax, R.attr.ts_round_radius, R.attr.ts_shape_mode, R.attr.ts_stroke_color, R.attr.ts_stroke_width, R.attr.ts_text_color, R.attr.ts_thumb_height, R.attr.ts_thumb_width, R.attr.ts_tint_color, R.attr.ts_tint_color_selected, R.attr.ts_tint_color_unselected, R.attr.ts_top_half_radius});
        int r103 = r102.getInt(7, Integer.MIN_VALUE);
        r102.recycle();
    L7:
        if (r103 == Integer.MIN_VALUE) goto L11;
        StyleCentre r104 = StyleCentre.f454924d;
        r104.getClass();
        b r105 = (b) StyleCentre.f454922b.getValue(r104, StyleCentre.f454921a[0]);
        if (r105 == null) goto L14;
        Typeface r106 = r105.a();
    L15:
        if (r101 == null) goto L23;
        TypedArray r107 = r100.getContext().obtainStyledAttributes(r101, new int[]{R.attr.ts_background_color, R.attr.ts_circle, R.attr.ts_enable_background_color, R.attr.ts_enable_selection_tint_color, R.attr.ts_enable_text_color, R.attr.ts_enable_tint_color, R.attr.ts_first_item_margin, R.attr.ts_font_type, R.attr.ts_force_exclude_font_padding, R.attr.ts_force_include_font_padding, R.attr.ts_item_margin, R.attr.ts_item_show_border, R.attr.ts_last_item_margin, R.attr.ts_loading_border_radius, R.attr.ts_loading_circle_radius, R.attr.ts_margin_tax, R.attr.ts_round_radius, R.attr.ts_shape_mode, R.attr.ts_stroke_color, R.attr.ts_stroke_width, R.attr.ts_text_color, R.attr.ts_thumb_height, R.attr.ts_thumb_width, R.attr.ts_tint_color, R.attr.ts_tint_color_selected, R.attr.ts_tint_color_unselected, R.attr.ts_top_half_radius});
        boolean r108 = r107.getBoolean(9, false);
        r107.recycle();
        TypedArray r109 = r100.getContext().obtainStyledAttributes(r101, new int[]{R.attr.ts_background_color, R.attr.ts_circle, R.attr.ts_enable_background_color, R.attr.ts_enable_selection_tint_color, R.attr.ts_enable_text_color, R.attr.ts_enable_tint_color, R.attr.ts_first_item_margin, R.attr.ts_font_type, R.attr.ts_force_exclude_font_padding, R.attr.ts_force_include_font_padding, R.attr.ts_item_margin, R.attr.ts_item_show_border, R.attr.ts_last_item_margin, R.attr.ts_loading_border_radius, R.attr.ts_loading_circle_radius, R.attr.ts_margin_tax, R.attr.ts_round_radius, R.attr.ts_shape_mode, R.attr.ts_stroke_color, R.attr.ts_stroke_width, R.attr.ts_text_color, R.attr.ts_thumb_height, R.attr.ts_thumb_width, R.attr.ts_tint_color, R.attr.ts_tint_color_selected, R.attr.ts_tint_color_unselected, R.attr.ts_top_half_radius});
        boolean r110 = r109.getBoolean(8, false);
        r109.recycle();
        if (r106 == null) goto L20;
        if (r108 == false) goto L20;
        r100.setIncludeFontPadding(true);
    L20:
        if (r106 != null) goto L23;
        if (r110 == true) goto L23;
        r100.setIncludeFontPadding(true);
    L23:
        if (r106 == null) goto L26;
        r100.setTypeface(r106);
        return;
    L26:
        return;
    L14:
        r106 = null;
        goto L15
    L11:
        StyleCentre r111 = StyleCentre.f454924d;
        r111.getClass();
        Function0 r112 = (Function0) StyleCentre.f454923c.getValue(r111, StyleCentre.f454921a[1]);
        if (r112 == null) goto L14;
        r106 = (Typeface) r112.invoke();
        goto L15
    L5:
        r103 = Integer.MIN_VALUE;
        goto L7
    }

    public static final GradientDrawable b(Context r100, AttributeSet r101, boolean r110) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r102 = r100.getResources().getColor(R.color.tools_styleview_bg_primary);
        if (r101 == null) goto L8;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ts_background_color, R.attr.ts_circle, R.attr.ts_enable_background_color, R.attr.ts_enable_selection_tint_color, R.attr.ts_enable_text_color, R.attr.ts_enable_tint_color, R.attr.ts_first_item_margin, R.attr.ts_font_type, R.attr.ts_force_exclude_font_padding, R.attr.ts_force_include_font_padding, R.attr.ts_item_margin, R.attr.ts_item_show_border, R.attr.ts_last_item_margin, R.attr.ts_loading_border_radius, R.attr.ts_loading_circle_radius, R.attr.ts_margin_tax, R.attr.ts_round_radius, R.attr.ts_shape_mode, R.attr.ts_stroke_color, R.attr.ts_stroke_width, R.attr.ts_text_color, R.attr.ts_thumb_height, R.attr.ts_thumb_width, R.attr.ts_tint_color, R.attr.ts_tint_color_selected, R.attr.ts_tint_color_unselected, R.attr.ts_top_half_radius});
        boolean r104 = r103.getBoolean(1, false);
        float r105 = r103.getDimension(16, 0.0f);
        boolean r106 = r103.getBoolean(26, false);
        r102 = r103.getColor(0, r102);
        r110 = r103.getBoolean(2, r110);
        r103.recycle();
    L9:
        if (r110 == false) goto L19;
        a r107 = new a();
        r107.b(r102);
        r107.d(r102, 0);
        if (r104 == false) goto L13;
        r107.c(1);
    L18:
        return r107.a();
    L13:
        r107.c(0);
        if (r106 == false) goto L16;
        r107.f454978h = new float[]{r105, r105, r105, r105, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L18
    L16:
        r107.f454977g = Float.valueOf(r105);
        goto L18
    L19:
        return null;
    L8:
        r104 = false;
        r105 = 0.0f;
        r106 = false;
        goto L9
    }
}
