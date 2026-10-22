package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class f6 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f398086a;

    public f6(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        View r102 = getChildAt(0);
        if (r102 != null) goto L5;
    L36:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (r102.getVisibility() == 8) goto L36;
        int r103 = View.MeasureSpec.getMode(r100);
        int r104 = View.MeasureSpec.getSize(r100);
        if (r103 != 0) goto L10;
        int r105 = 0;
    L11:
        int r106 = this.f398086a;
        if (r106 <= 0) goto L14;
        int r107 = RangesKt.coerceAtLeast((r106 - getPaddingTop()) - getPaddingBottom(), 0);
    L15:
        if (r103 != 0) goto L17;
        int r108 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L18:
        if (r107 < 0) goto L20;
        int r109 = View.MeasureSpec.makeMeasureSpec(r107, Integer.MIN_VALUE);
    L21:
        r102.measure(r108, r109);
        if (r103 != 0) goto L24;
        r104 = (r102.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight();
    L24:
        int r110 = (r102.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom();
        if (r107 < 0) goto L27;
        r110 = RangesKt.coerceAtMost(r110, this.f398086a);
    L27:
        setMeasuredDimension(r104, RangesKt.coerceAtLeast(r110, getSuggestedMinimumHeight()));
        String r111 = r102.getClass().getSimpleName();
        FLogger r112 = FLogger.f375446a;
        StringBuilder r113 = new StringBuilder("onMeasure self=");
        r113.append(getMeasuredWidth());
        r113.append(Permission.EXECUTE);
        r113.append(r110);
        r113.append(", widthSpec=");
        r113.append(View.MeasureSpec.toString(r100));
        r113.append(", heightSpec=");
        r113.append(View.MeasureSpec.toString(r101));
        r113.append(", bodyMaxHeightPx=");
        r113.append(this.f398086a);
        r113.append(", child=");
        r113.append(r111);
        r113.append(':');
        r113.append(r102.getMeasuredWidth());
        r113.append(Permission.EXECUTE);
        r113.append(r102.getMeasuredHeight());
        r113.append(" lp=");
        ViewGroup.LayoutParams r114 = r102.getLayoutParams();
        Integer r115 = null;
        if (r114 == null) goto L30;
        Integer r116 = Integer.valueOf(r114.width);
    L31:
        r113.append(r116);
        r113.append(Permission.EXECUTE);
        ViewGroup.LayoutParams r117 = r102.getLayoutParams();
        if (r117 == null) goto L34;
        r115 = Integer.valueOf(r117.height);
    L34:
        r113.append(r115);
        r112.i("SheetBodyContainerView", r113.toString());
        getMeasuredWidth();
        View.MeasureSpec.toString(r100);
        View.MeasureSpec.toString(r101);
        r102.getMeasuredWidth();
        r102.getMeasuredHeight();
        r102.getLayoutParams();
        r102.getLayoutParams();
        return;
    L30:
        r116 = null;
        goto L31
    L20:
        r109 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L21
    L17:
        r108 = View.MeasureSpec.makeMeasureSpec(r105, 1073741824);
        goto L18
    L14:
        r107 = -1;
        goto L15
    L10:
        r105 = RangesKt.coerceAtLeast((r104 - getPaddingLeft()) - getPaddingRight(), 0);
        goto L11
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        View r105 = getChildAt(0);
        if (r105 != null) goto L5;
        return;
    L5:
        int r106 = getPaddingLeft();
        int r107 = getPaddingTop();
        r105.layout(r106, r107, (r103 - r101) - getPaddingRight(), r105.getMeasuredHeight() + r107);
    }
}
