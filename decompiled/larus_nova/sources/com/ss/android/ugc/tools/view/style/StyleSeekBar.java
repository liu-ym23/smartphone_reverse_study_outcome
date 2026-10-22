package com.ss.android.ugc.tools.view.style;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.core.view.GravityCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.filter.widget.FilterBeautySeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/tools/view/style/StyleSeekBar;", "Lcom/ss/android/ugc/aweme/filter/widget/FilterBeautySeekBar;", "", "progress", "", "setProgress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class StyleSeekBar extends FilterBeautySeekBar {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ClipDrawable f454938p;

    public StyleSeekBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StyleSeekBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r100) {
        super.setProgress(r100);
        ClipDrawable r101 = this.f454938p;
        if (r101 == null) goto L6;
        r101.setLevel((r100 * 10000) / getMax());
        return;
    }

    public StyleSeekBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (r101 == null) goto L5;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ts_background_color, R.attr.ts_circle, R.attr.ts_enable_background_color, R.attr.ts_enable_selection_tint_color, R.attr.ts_enable_text_color, R.attr.ts_enable_tint_color, R.attr.ts_first_item_margin, R.attr.ts_font_type, R.attr.ts_force_exclude_font_padding, R.attr.ts_force_include_font_padding, R.attr.ts_item_margin, R.attr.ts_item_show_border, R.attr.ts_last_item_margin, R.attr.ts_loading_border_radius, R.attr.ts_loading_circle_radius, R.attr.ts_margin_tax, R.attr.ts_round_radius, R.attr.ts_shape_mode, R.attr.ts_stroke_color, R.attr.ts_stroke_width, R.attr.ts_text_color, R.attr.ts_thumb_height, R.attr.ts_thumb_width, R.attr.ts_tint_color, R.attr.ts_tint_color_selected, R.attr.ts_tint_color_unselected, R.attr.ts_top_half_radius});
        int r104 = (int) r103.getDimension(16, 0.0f);
        int r105 = (int) r103.getDimension(22, 0.0f);
        int r106 = (int) r103.getDimension(21, 0.0f);
        r103.recycle();
    L6:
        int r107 = ColorProtector.parseColor("#FFFFFFFF");
        a r108 = new a();
        r108.c(1);
        r108.b(r107);
        r108.d(r107, 0);
        r108.f454975e = Integer.valueOf(r105);
        r108.f454976f = Integer.valueOf(r106);
        setThumb(r108.a());
        setSplitTrack(true);
        int r109 = getResources().getColor(R.color.tools_std_primary);
        a r110 = new a();
        r110.c(0);
        r110.b(r109);
        r110.d(r109, 0);
        float r111 = r104;
        r110.f454977g = Float.valueOf(r111);
        ClipDrawable r112 = new ClipDrawable(r110.a(), GravityCompat.START, 1);
        this.f454938p = r112;
        r112.setLevel((getProgress() * 10000) / getMax());
        int r113 = getResources().getColor(R.color.tools_std_const_text_inverse_5);
        a r114 = new a();
        r114.c(0);
        r114.b(r113);
        r114.d(r113, 0);
        r114.f454977g = Float.valueOf(r111);
        setProgressDrawable(new LayerDrawable(new Drawable[]{r114.a(), r112}));
        return;
    L5:
        r104 = 0;
        r106 = 0;
        r105 = 0;
        goto L6
    }

    public /* synthetic */ StyleSeekBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = android.R.attr.seekBarStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }
}
