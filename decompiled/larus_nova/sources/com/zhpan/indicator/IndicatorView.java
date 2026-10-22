package com.zhpan.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import brc.e;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.zhpan.indicator.base.BaseIndicatorView;
import crc.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/zhpan/indicator/IndicatorView;", "Lcom/zhpan/indicator/base/BaseIndicatorView;", "Lcrc/a;", "options", "", "setIndicatorOptions", "", "orientation", "setOrientation", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "indicator_release"}, k = 1, mv = {1, 4, 0})
public final class IndicatorView extends BaseIndicatorView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f464577e;

    public IndicatorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IndicatorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.zhpan.indicator.base.BaseIndicatorView, com.zhpan.indicator.base.IIndicator
    public final void jg() {
        this.f464577e = new e(getMIndicatorOptions());
        super.jg();
    }

    @Override // com.zhpan.indicator.base.BaseIndicatorView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        this.f464577e.a(r100);
    }

    @Override // com.zhpan.indicator.base.BaseIndicatorView, com.zhpan.indicator.base.IIndicator
    public void setIndicatorOptions(a r100) {
        super.setIndicatorOptions(r100);
        this.f464577e.b(r100);
    }

    public final void setOrientation(int r100) {
        getMIndicatorOptions().f465139a = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        brc.a r102 = this.f464577e.f20206a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIDrawer");
    L5:
        a r103 = r102.f20201f;
        r102.f20197b = RangesKt.coerceAtLeast(r103.f465147i, r103.f465148j);
        a r104 = r102.f20201f;
        float r105 = RangesKt.coerceAtMost(r104.f465147i, r104.f465148j);
        r102.f20198c = r105;
        a r106 = r102.f20201f;
        if (r106.f465139a != 1) goto L8;
        brc.a.b r107 = r102.f20196a;
        int r108 = r102.b();
        a r109 = r102.f20201f;
        float r110 = r109.f465142d - 1;
        int r111 = ((int) (((r109.f465145g * r110) + r102.f20197b) + (r110 * r102.f20198c))) + 6;
        r107.f20202a = r108;
        r107.f20203b = r111;
    L9:
        brc.a.b r112 = r102.f20196a;
        setMeasuredDimension(r112.f20202a, r112.f20203b);
        return;
    L8:
        brc.a.b r113 = r102.f20196a;
        float r114 = r106.f465142d - 1;
        int r115 = ((int) (((r106.f465145g * r114) + r102.f20197b) + (r114 * r105))) + 6;
        int r116 = r102.b();
        r113.f20202a = r115;
        r113.f20203b = r116;
        goto L9
    }

    public IndicatorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a r103 = getMIndicatorOptions();
        if (r101 == null) goto L5;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.vpi_orientation, R.attr.vpi_rtl, R.attr.vpi_slide_mode, R.attr.vpi_slider_checked_color, R.attr.vpi_slider_normal_color, R.attr.vpi_slider_radius, R.attr.vpi_style});
        int r105 = r104.getInt(2, 0);
        int r106 = r104.getInt(6, 0);
        int r107 = r104.getColor(3, ColorProtector.parseColor("#6C6D72"));
        int r108 = r104.getColor(4, ColorProtector.parseColor("#8C18171C"));
        int r109 = r104.getInt(0, 0);
        float r110 = r104.getDimension(5, drc.a.a(8.0f));
        r103.f465144f = r107;
        r103.f465143e = r108;
        r103.f465139a = r109;
        r103.f465140b = r106;
        r103.f465141c = r105;
        float r111 = r110 * 2.0f;
        r103.f465147i = r111;
        r103.f465148j = r111;
        r104.recycle();
    L5:
        this.f464577e = new e(getMIndicatorOptions());
    }

    public /* synthetic */ IndicatorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.f464577e.getClass();
    }
}
