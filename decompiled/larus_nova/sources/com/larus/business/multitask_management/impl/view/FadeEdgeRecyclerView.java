package com.larus.business.multitask_management.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0014J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/business/multitask_management/impl/view/FadeEdgeRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "edgeSizePx", "", "maskStopCount", "curvePower", "maskPaint", "Landroid/graphics/Paint;", "topGradient", "Landroid/graphics/LinearGradient;", "bottomGradient", "onSizeChanged", "", "w", "h", "oldw", "oldh", "updateGradients", "buildTopMaskStops", "Lcom/larus/business/multitask_management/impl/view/FadeEdgeRecyclerView$MaskStops;", "stopCount", BatteryTypeInf.BATTERY_POWER_LOCK, "buildBottomMaskStops", "easeIn", "t", "easeOut", "alphaToMaskColor", "alpha", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "MaskStops", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FadeEdgeRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f321130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f321131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f321132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f321133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearGradient f321134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearGradient f321135f;

    public FadeEdgeRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FadeEdgeRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        LinearGradient r100 = this.f321134e;
        LinearGradient r101 = this.f321135f;
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        if (getWidth() <= 0) goto L22;
        if (getHeight() <= 0) goto L22;
        boolean r102 = canScrollVertically(-1);
        boolean r103 = canScrollVertically(1);
        if (r102 == true) goto L15;
        if (r103 == true) goto L15;
        super.dispatchDraw(r110);
        return;
    L15:
        float r104 = Math.min(this.f321130a, getHeight() / 2.0f);
        int r105 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.dispatchDraw(r110);
        if (r102 == false) goto L18;
        this.f321133d.setShader(r100);
        r110.drawRect(0.0f, 0.0f, getWidth(), r104, this.f321133d);
    L18:
        if (r103 == false) goto L20;
        this.f321133d.setShader(r101);
        r110.drawRect(0.0f, getHeight() - r104, getWidth(), getHeight(), this.f321133d);
    L20:
        this.f321133d.setShader(null);
        r110.restoreToCount(r105);
        return;
    L22:
        super.dispatchDraw(r110);
    }

    public FadeEdgeRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f321130a = c7.b(16);
        this.f321131b = 8;
        this.f321132c = 3.0f;
        Paint r103 = new Paint(1);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f321133d = r103;
    }

    public /* synthetic */ FadeEdgeRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int r210, int r211, int r212, int r213) {
        super.onSizeChanged(r210, r211, r212, r213);
        if (r210 <= 0) goto L22;
        if (r211 <= 0) goto L22;
        float r100 = this.f321130a;
        float r101 = 0.0f;
        if (r100 <= 0.0f) goto L22;
        float r102 = r211;
        float r103 = Math.min(r100, r102 / 2.0f);
        int r104 = this.f321131b;
        float r105 = this.f321132c;
        int r106 = RangesKt.coerceAtLeast(r104, 2);
        int[] r110 = new int[r106];
        float[] r107 = new float[r106];
        int r108 = r106 - 1;
        float r111 = 1.0f;
        if (r108 < 0) goto L14;
        int r112 = 0;
    L11:
        float r113 = r112 / r108;
        double r109 = 1.0f - RangesKt.coerceIn(r113, r101, 1.0f);
        float r114 = r105;
        float r115 = 1.0f - ((float) Math.pow(r109, RangesKt.coerceAtLeast(r105, 1.0f)));
        r107[r112] = r113;
        r110[r112] = Color.argb((int) ((RangesKt.coerceIn(r115, 0.0f, 1.0f) * 255.0f) + 0.5f), 0, 0, 0);
        if (r112 == r108) goto L14;
        r112 = r112 + 1;
        r105 = r114;
        r101 = 0.0f;
    L14:
        Intrinsics.checkNotNullParameter(r110, "colors");
        Intrinsics.checkNotNullParameter(r107, "positions");
        int r116 = this.f321131b;
        float r117 = this.f321132c;
        int r118 = RangesKt.coerceAtLeast(r116, 2);
        int[] r119 = new int[r118];
        float[] r120 = new float[r118];
        int r121 = r118 - 1;
        if (r121 < 0) goto L20;
        int r122 = 0;
    L17:
        float r123 = r122 / r121;
        int r124 = r122;
        float r125 = r102;
        float r126 = 1.0f - ((float) Math.pow(RangesKt.coerceIn(r123, 0.0f, r111), RangesKt.coerceAtLeast(r117, r111)));
        r120[r124] = r123;
        r119[r124] = Color.argb((int) ((RangesKt.coerceIn(r126, 0.0f, 1.0f) * 255.0f) + 0.5f), 0, 0, 0);
        if (r124 == r121) goto L21;
        r122 = r124 + 1;
        r102 = r125;
        r111 = 1.0f;
    L21:
        Intrinsics.checkNotNullParameter(r119, "colors");
        Intrinsics.checkNotNullParameter(r120, "positions");
        this.f321134e = new LinearGradient(0.0f, 0.0f, 0.0f, r103, r110, r107, Shader.TileMode.CLAMP);
        this.f321135f = new LinearGradient(0.0f, r125 - r103, 0.0f, r125, r119, r120, Shader.TileMode.CLAMP);
        return;
    L20:
        r125 = r102;
    L22:
        this.f321134e = null;
        this.f321135f = null;
    }
}
