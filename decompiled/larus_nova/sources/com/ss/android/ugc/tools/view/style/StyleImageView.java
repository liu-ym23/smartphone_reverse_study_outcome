package com.ss.android.ugc.tools.view.style;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\f¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/tools/view/style/StyleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "selectedStatus", "", "setSelected", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "enable", "setEnableTint", "setEnableSelectionTint", "", "color", "setDefaultTintColor", "setSelectTintColor", "setUnSelectTintColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public class StyleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f454925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f454926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f454927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f454928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f454929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f454930f;

    public StyleImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StyleImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void j(Drawable r100) {
        if (this.f454925a == false) goto L9;
        int r101 = this.f454930f;
        if (r100 == null) goto L8;
        r100 = r100.mutate();
        r100.setColorFilter(new PorterDuffColorFilter(r101, PorterDuff.Mode.SRC_IN));
    L8:
        super.setImageDrawable(r100);
        return;
    L9:
        super.setImageDrawable(r100);
    }

    public final void setDefaultTintColor(int r100) {
        this.f454927c = r100;
    }

    public final void setEnableSelectionTint(boolean r100) {
        this.f454926b = r100;
        if (r100 == true) goto L6;
        this.f454930f = this.f454927c;
        return;
    }

    public final void setEnableTint(boolean r100) {
        boolean r101 = this.f454925a;
        this.f454925a = r100;
        if (r101 == true) goto L7;
        if (r100 == false) goto L8;
        j(getDrawable());
        return;
    L8:
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        j(r100);
    }

    public final void setSelectTintColor(int r100) {
        this.f454928d = r100;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        if (this.f454926b == false) goto L9;
        if (r100 == false) goto L6;
        int r101 = this.f454928d;
    L7:
        this.f454930f = r101;
        j(getDrawable());
        return;
    L6:
        r101 = this.f454929e;
        goto L7
    }

    public final void setUnSelectTintColor(int r100) {
        this.f454929e = r100;
    }

    public StyleImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (r101 == null) goto L5;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ts_background_color, R.attr.ts_circle, R.attr.ts_enable_background_color, R.attr.ts_enable_selection_tint_color, R.attr.ts_enable_text_color, R.attr.ts_enable_tint_color, R.attr.ts_first_item_margin, R.attr.ts_font_type, R.attr.ts_force_exclude_font_padding, R.attr.ts_force_include_font_padding, R.attr.ts_item_margin, R.attr.ts_item_show_border, R.attr.ts_last_item_margin, R.attr.ts_loading_border_radius, R.attr.ts_loading_circle_radius, R.attr.ts_margin_tax, R.attr.ts_round_radius, R.attr.ts_shape_mode, R.attr.ts_stroke_color, R.attr.ts_stroke_width, R.attr.ts_text_color, R.attr.ts_thumb_height, R.attr.ts_thumb_width, R.attr.ts_tint_color, R.attr.ts_tint_color_selected, R.attr.ts_tint_color_unselected, R.attr.ts_top_half_radius});
        this.f454925a = r103.getBoolean(5, true);
        this.f454926b = r103.getBoolean(3, true);
        this.f454927c = r103.getColor(23, r100.getResources().getColor(R.color.tools_styleview_text_selected));
        this.f454928d = r103.getColor(24, r100.getResources().getColor(R.color.tools_styleview_text_selected));
        this.f454929e = r103.getColor(25, r100.getResources().getColor(R.color.tools_styleview_text_unselected));
        r103.recycle();
    L6:
        this.f454930f = this.f454927c;
        if (this.f454925a == false) goto L10;
        j(getDrawable());
        return;
    L10:
        return;
    L5:
        this.f454925a = true;
        this.f454926b = true;
        this.f454927c = r100.getResources().getColor(R.color.tools_styleview_text_selected);
        this.f454928d = r100.getResources().getColor(R.color.tools_styleview_text_selected);
        this.f454929e = r100.getResources().getColor(R.color.tools_styleview_text_unselected);
        goto L6
    }

    public /* synthetic */ StyleImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
