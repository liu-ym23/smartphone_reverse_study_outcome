package com.ss.android.ugc.tools.view.style;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.tools.utils.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/tools/view/style/StyleRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "marginInPx", "", "setItemMargin", "", "itemShowBorder", "setItemShowBorder", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class StyleRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f454931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f454932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f454933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f454934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f454935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public StyleRecyclerView$syncItemDecoration$2 f454936f;

    public StyleRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StyleRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.recyclerview.widget.RecyclerView$ItemDecoration, com.ss.android.ugc.tools.view.style.StyleRecyclerView$syncItemDecoration$2] */
    public final void r() {
        StyleRecyclerView$syncItemDecoration$2 r100 = this.f454936f;
        if (r100 == null) goto L6;
        removeItemDecoration(r100);
    L6:
        if (this.f454935e == false) goto L17;
        int r101 = this.f454931a;
        if (r101 <= 0) goto L10;
        this.f454931a = r101 - (this.f454934d * 2);
    L10:
        int r102 = this.f454932b;
        if (r102 <= 0) goto L13;
        this.f454932b = r102 - this.f454934d;
    L13:
        int r103 = this.f454933c;
        if (r103 <= 0) goto L17;
        this.f454933c = r103 - this.f454934d;
    L17:
        if (this.f454931a == 0) goto L19;
    L22:
        ?? r104 = new StyleRecyclerView$syncItemDecoration$2(this);
        addItemDecoration(r104);
        Unit r105 = Unit.INSTANCE;
        this.f454936f = r104;
        return;
    L19:
        if (this.f454932b != 0) goto L22;
        if (this.f454933c != 0) goto L22;
    }

    public final void setItemMargin(int r100) {
        this.f454931a = r100;
        r();
    }

    public final void setItemShowBorder(boolean r100) {
        this.f454935e = r100;
        r();
    }

    public StyleRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f454934d = (int) i.a(r100, 2.0f);
        this.f454935e = true;
        GradientDrawable r103 = c.b(r100, r101, false);
        if (r103 == null) goto L5;
        setBackground(r103);
    L5:
        if (r101 == null) goto L7;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ts_background_color, R.attr.ts_circle, R.attr.ts_enable_background_color, R.attr.ts_enable_selection_tint_color, R.attr.ts_enable_text_color, R.attr.ts_enable_tint_color, R.attr.ts_first_item_margin, R.attr.ts_font_type, R.attr.ts_force_exclude_font_padding, R.attr.ts_force_include_font_padding, R.attr.ts_item_margin, R.attr.ts_item_show_border, R.attr.ts_last_item_margin, R.attr.ts_loading_border_radius, R.attr.ts_loading_circle_radius, R.attr.ts_margin_tax, R.attr.ts_round_radius, R.attr.ts_shape_mode, R.attr.ts_stroke_color, R.attr.ts_stroke_width, R.attr.ts_text_color, R.attr.ts_thumb_height, R.attr.ts_thumb_width, R.attr.ts_tint_color, R.attr.ts_tint_color_selected, R.attr.ts_tint_color_unselected, R.attr.ts_top_half_radius});
        this.f454931a = (int) r104.getDimension(10, 0.0f);
        this.f454932b = (int) r104.getDimension(6, 0.0f);
        this.f454933c = (int) r104.getDimension(12, 0.0f);
        this.f454934d = (int) r104.getDimension(15, i.a(r100, 2.0f));
        this.f454935e = r104.getBoolean(11, true);
        r104.recycle();
    L7:
        r();
    }

    public /* synthetic */ StyleRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
