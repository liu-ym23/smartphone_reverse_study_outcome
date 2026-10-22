package com.larus.canvas.feature.component.resultdisplay.image.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/canvas/feature/component/resultdisplay/image/widget/RatioFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "targetWidth", "targetHeight", "setTargetSize", "", "width", "height", "checkRatio", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RatioFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f323621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f323622b;

    public static final class a {
    }

    static {
    }

    public RatioFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RatioFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a(int r100, int r101) {
        if (r100 == this.f323621a) goto L5;
    L6:
        this.f323621a = r100;
        this.f323622b = r101;
        if (r100 <= 0) goto L15;
        if (r101 <= 0) goto L15;
        double r102 = r101;
        double r103 = ((double) r100) / r102;
        if (r103 >= 0.4d) goto L13;
        this.f323621a = (int) (r102 * 0.4d);
        goto L15
    L13:
        if (r103 <= 3.0d) goto L15;
        this.f323622b = r100 / 3;
    L15:
        requestLayout();
        return;
    L5:
        if (r101 != this.f323622b) goto L6;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f323621a > 0) goto L5;
    L7:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (this.f323622b <= 0) goto L7;
        float r102 = Math.min(View.MeasureSpec.getSize(r100) / this.f323621a, View.MeasureSpec.getSize(r101) / this.f323622b);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (this.f323621a * r102), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (this.f323622b * r102), 1073741824));
    }

    public RatioFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f323621a = -1;
        this.f323622b = -1;
    }

    public /* synthetic */ RatioFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
