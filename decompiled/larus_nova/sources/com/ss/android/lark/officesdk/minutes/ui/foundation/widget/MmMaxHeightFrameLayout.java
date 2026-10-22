package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmMaxHeightFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "maxHeightPx", "getMaxHeightPx", "()I", "setMaxHeightPx", "(I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "constrainHeightSpec", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MmMaxHeightFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f435654a;

    public MmMaxHeightFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmMaxHeightFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getMaxHeightPx() {
        return this.f435654a;
    }

    public final void setMaxHeightPx(int r100) {
        Integer r101 = Integer.valueOf(r100);
        if (r101.intValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L11;
        int r103 = r101.intValue();
    L13:
        if (this.f435654a != r103) goto L15;
        return;
    L15:
        this.f435654a = r103;
        requestLayout();
        return;
    L11:
        r103 = Integer.MAX_VALUE;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f435654a == Integer.MAX_VALUE) goto L14;
        int r102 = View.MeasureSpec.getMode(r101);
        int r103 = View.MeasureSpec.getSize(r101);
        if (r102 == Integer.MIN_VALUE) goto L13;
        if (r102 != 0) goto L9;
        r101 = View.MeasureSpec.makeMeasureSpec(this.f435654a, Integer.MIN_VALUE);
        goto L14
    L9:
        if (r102 != 1073741824) goto L14;
        r101 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r103, this.f435654a), 1073741824);
        goto L14
    L13:
        r101 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r103, this.f435654a), Integer.MIN_VALUE);
    L14:
        super.onMeasure(r100, r101);
    }

    public MmMaxHeightFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f435654a = Integer.MAX_VALUE;
    }

    public /* synthetic */ MmMaxHeightFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
