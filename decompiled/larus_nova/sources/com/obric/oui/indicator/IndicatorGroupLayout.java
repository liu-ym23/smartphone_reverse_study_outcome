package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.obric.oui.common.style.r;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR.\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\f¨\u0006!"}, d2 = {"Lcom/obric/oui/indicator/IndicatorGroupLayout;", "Landroid/widget/LinearLayout;", "", "draw", "", "setDrawBackground", "", "d", "I", "getCornerRadius", "()I", "setCornerRadius", "(I)V", "cornerRadius", "value", "e", "Ljava/lang/Integer;", "getFixedContentWidthPx", "()Ljava/lang/Integer;", "setFixedContentWidthPx", "(Ljava/lang/Integer;)V", "fixedContentWidthPx", "f", "getBgColor", "setBgColor", "bgColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class IndicatorGroupLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f401166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f401167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f401168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f401169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f401170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f401171f;

    public IndicatorGroupLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IndicatorGroupLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getBgColor() {
        return this.f401171f;
    }

    public final int getCornerRadius() {
        return this.f401169d;
    }

    public final Integer getFixedContentWidthPx() {
        return this.f401170e;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f401168c == false) goto L5;
        this.f401166a.set(0.0f, 0.0f, getWidth(), getHeight());
        r.e(r100, this.f401166a, this.f401169d * 1.0f, this.f401167b);
    L5:
        super.onDraw(r100);
    }

    public final void setBgColor(int r100) {
        if (this.f401171f == r100) goto L5;
        this.f401171f = r100;
    L5:
        this.f401167b.setColor(r100);
    }

    public final void setCornerRadius(int r100) {
        this.f401169d = r100;
    }

    public final void setDrawBackground(boolean r100) {
        this.f401168c = r100;
        invalidate();
    }

    public final void setFixedContentWidthPx(Integer r100) {
        if (Intrinsics.areEqual(this.f401170e, r100) == true) goto L6;
        this.f401170e = r100;
        requestLayout();
        invalidate();
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        Integer r102 = this.f401170e;
        if (r102 != null) goto L5;
        return;
    L5:
        int r103 = r102.intValue();
        int r104 = LinearLayout.resolveSize((getPaddingLeft() + r103) + getPaddingRight(), r100);
        if (getMeasuredWidth() == r104) goto L9;
        setMeasuredDimension(r104, getMeasuredHeight());
        return;
    }

    public IndicatorGroupLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f401166a = new RectF();
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.FILL);
        this.f401167b = r103;
        setBackgroundColor(0);
    }

    public /* synthetic */ IndicatorGroupLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
