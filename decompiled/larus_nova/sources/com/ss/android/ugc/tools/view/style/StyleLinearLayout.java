package com.ss.android.ugc.tools.view.style;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/tools/view/style/StyleLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public class StyleLinearLayout extends LinearLayout {
    public StyleLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StyleLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public StyleLinearLayout(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        GradientDrawable r112 = null;
        if (r100 == null) goto L17;
        int r101 = r100.getResources().getColor(R.color.tools_styleview_bg_primary);
        if (r110 == null) goto L8;
        TypedArray r102 = r100.obtainStyledAttributes(r110, new int[]{R.attr.ts_background_color, R.attr.ts_circle, R.attr.ts_enable_background_color, R.attr.ts_enable_selection_tint_color, R.attr.ts_enable_text_color, R.attr.ts_enable_tint_color, R.attr.ts_first_item_margin, R.attr.ts_font_type, R.attr.ts_force_exclude_font_padding, R.attr.ts_force_include_font_padding, R.attr.ts_item_margin, R.attr.ts_item_show_border, R.attr.ts_last_item_margin, R.attr.ts_loading_border_radius, R.attr.ts_loading_circle_radius, R.attr.ts_margin_tax, R.attr.ts_round_radius, R.attr.ts_shape_mode, R.attr.ts_stroke_color, R.attr.ts_stroke_width, R.attr.ts_text_color, R.attr.ts_thumb_height, R.attr.ts_thumb_width, R.attr.ts_tint_color, R.attr.ts_tint_color_selected, R.attr.ts_tint_color_unselected, R.attr.ts_top_half_radius});
        boolean r113 = r102.getBoolean(1, false);
        float r103 = r102.getDimension(16, 0.0f);
        boolean r104 = r102.getBoolean(26, false);
        r101 = r102.getColor(0, r101);
        boolean r105 = r102.getBoolean(2, true);
        r102.recycle();
    L9:
        if (r105 == false) goto L17;
        a r106 = new a();
        r106.b(r101);
        r106.d(r101, 0);
        if (r113 == false) goto L13;
        r106.c(1);
    L18:
        if (r106 == null) goto L20;
        r112 = r106.a();
    L20:
        setBackground(r112);
        return;
    L13:
        r106.c(0);
        if (r104 == false) goto L16;
        r106.f454978h = new float[]{r103, r103, r103, r103, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L18
    L16:
        r106.f454977g = Float.valueOf(r103);
        goto L18
    L8:
        r113 = false;
        r103 = 0.0f;
        r104 = false;
        r105 = true;
    L17:
        r106 = null;
        goto L18
    }

    public /* synthetic */ StyleLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
