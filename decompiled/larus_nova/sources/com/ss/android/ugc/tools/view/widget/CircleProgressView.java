package com.ss.android.ugc.tools.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R\"\u0010\u000b\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/CircleProgressView;", "Landroid/view/View;", "", "progress", "", "setProgress", "maxProgress", "setMaxProgress", "color", "setBgCircleColor", "setProgressColor", "width", "setCircleWidth", "setBgCircleWidth", "angle", "setStartAngle", "", "radius", "setCircleRadius", "c", "I", "getWidth$lib_runtime_release", "()I", "setWidth$lib_runtime_release", "(I)V", "d", "getHeight$lib_runtime_release", "setHeight$lib_runtime_release", "height", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class CircleProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f454994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f454995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f454996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f454997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f454998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f454999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f455000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f455001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f455002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f455003j;

    public final int getHeight$lib_runtime_release() {
        return this.f454997d;
    }

    public final int getWidth$lib_runtime_release() {
        return this.f454996c;
    }

    public CircleProgressView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        float r100 = this.f455002i;
        if (r100 <= 0) goto L5;
        RectF r101 = this.f455003j;
        int r102 = this.f454996c;
        r101.set((r102 / 2) - r100, (this.f454997d / 2) - r100, (r102 / 2) + r100, (r102 / 2) + r100);
    L6:
        RectF r103 = this.f455003j;
        float r104 = this.f455000g - 90;
        float r105 = ((this.f454998e * 1.0f) / this.f454999f) * 360;
        Paint r111 = this.f454995b;
        if (r111 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L9:
        r110.drawArc(r103, r104, r105, false, r111);
        return;
    L5:
        RectF r106 = this.f455003j;
        int r107 = this.f455001h;
        r106.set(r107, r107, this.f454996c - r107, this.f454997d - r107);
        goto L6
    }

    public final void setBgCircleColor(int r100) {
        Paint r101 = this.f454994a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r101.setColor(r100);
    }

    public final void setBgCircleWidth(int r100) {
        this.f455001h = r100 / 2;
        Paint r101 = this.f454994a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r101.setStrokeWidth(r100);
    }

    public final void setCircleRadius(float r100) {
        this.f455002i = r100;
    }

    public final void setCircleWidth(int r100) {
        Paint r101 = this.f454995b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L5:
        r101.setStrokeWidth(r100);
    }

    public final void setHeight$lib_runtime_release(int r100) {
        this.f454997d = r100;
    }

    public final void setMaxProgress(int r100) {
        this.f454999f = r100;
    }

    public final void setProgress(int r100) {
        this.f454998e = r100;
        invalidate();
    }

    public final void setProgressColor(int r100) {
        Paint r101 = this.f454995b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L5:
        r101.setColor(r100);
    }

    public final void setStartAngle(int r100) {
        this.f455000g = r100;
    }

    public final void setWidth$lib_runtime_release(int r100) {
        this.f454996c = r100;
    }

    public CircleProgressView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f454999f = 100;
        Paint r102 = new Paint();
        this.f454994a = r102;
        r102.setAntiAlias(true);
        Paint r103 = this.f454994a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r103.setStyle(Paint.Style.STROKE);
        Paint r104 = this.f454994a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L8:
        Paint r105 = new Paint(r104);
        this.f454995b = r105;
        r105.setStrokeCap(Paint.Cap.ROUND);
        if (r101 == null) goto L11;
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ts_background_color, R.attr.ts_circle, R.attr.ts_enable_background_color, R.attr.ts_enable_selection_tint_color, R.attr.ts_enable_text_color, R.attr.ts_enable_tint_color, R.attr.ts_first_item_margin, R.attr.ts_font_type, R.attr.ts_force_exclude_font_padding, R.attr.ts_force_include_font_padding, R.attr.ts_item_margin, R.attr.ts_item_show_border, R.attr.ts_last_item_margin, R.attr.ts_loading_border_radius, R.attr.ts_loading_circle_radius, R.attr.ts_margin_tax, R.attr.ts_round_radius, R.attr.ts_shape_mode, R.attr.ts_stroke_color, R.attr.ts_stroke_width, R.attr.ts_text_color, R.attr.ts_thumb_height, R.attr.ts_thumb_width, R.attr.ts_tint_color, R.attr.ts_tint_color_selected, R.attr.ts_tint_color_unselected, R.attr.ts_top_half_radius});
        this.f455002i = r106.getDimension(14, 0.0f);
        r106.recycle();
    L11:
        this.f455003j = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f454996c = View.MeasureSpec.getSize(r100);
        this.f454997d = View.MeasureSpec.getSize(r101);
    }
}
