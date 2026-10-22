package com.ss.android.lark.thirdshare.panel.content;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0014J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-H\u0014R$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u001f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$¨\u0006."}, d2 = {"Lcom/ss/android/lark/thirdshare/panel/content/PagerIndicator;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "indicatorIndex", "getIndicatorIndex", "()I", "setIndicatorIndex", "(I)V", "pageCount", "getPageCount", "setPageCount", "indicatorSize", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "getIndicatorSize", "()Lcom/larksuite/component/universe_design/dimension/UDDimension;", "indicatorPadding", "getIndicatorPadding", "indicatorBackgroundColor", "getIndicatorBackgroundColor", "indicatorColor", "getIndicatorColor", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "third-share-panel_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PagerIndicator extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f441265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f441266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UDDimension.Dp f441267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UDDimension.Dp f441268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f441269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f441270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f441271g;

    private final Paint getPaint() {
        return (Paint) this.f441271g.getValue();
    }

    public final int getIndicatorBackgroundColor() {
        return this.f441269e;
    }

    public final int getIndicatorColor() {
        return this.f441270f;
    }

    public final int getIndicatorIndex() {
        return this.f441265a;
    }

    public final UDDimension getIndicatorPadding() {
        return this.f441268d;
    }

    public final UDDimension getIndicatorSize() {
        return this.f441267c;
    }

    public final int getPageCount() {
        return this.f441266b;
    }

    public PagerIndicator(Context r100) {
        super(r100);
        this.f441267c = new UDDimension.Dp(4);
        this.f441268d = new UDDimension.Dp(4);
        this.f441269e = UDColorUtils.getColor(getContext(), R.color.icon_disable);
        this.f441270f = UDColorUtils.getColor(getContext(), R.color.primary_fill_default);
        this.f441271g = LazyKt.lazy(LazyThreadSafetyMode.NONE, PagerIndicator$paint$2.INSTANCE);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = this.f441268d.toPixels(getContext());
        float r102 = 2;
        float r103 = this.f441267c.toPixels(getContext()) / r102;
        int r104 = this.f441266b;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        if (r105 != this.f441265a) goto L7;
        getPaint().setColor(this.f441270f);
    L8:
        r100.drawCircle((((r102 * r103) + r101) * r105) + r103, r103, r103, getPaint());
        r105 = r105 + 1;
        goto L3
    L7:
        getPaint().setColor(this.f441269e);
        goto L8
    }

    public final void setIndicatorIndex(int r100) {
        if (r100 == this.f441265a) goto L6;
        this.f441265a = r100;
        invalidate();
        return;
    }

    public final void setPageCount(int r100) {
        if (r100 == this.f441266b) goto L6;
        this.f441266b = r100;
        requestLayout();
        return;
    }

    public PagerIndicator(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f441267c = new UDDimension.Dp(4);
        this.f441268d = new UDDimension.Dp(4);
        this.f441269e = UDColorUtils.getColor(getContext(), R.color.icon_disable);
        this.f441270f = UDColorUtils.getColor(getContext(), R.color.primary_fill_default);
        this.f441271g = LazyKt.lazy(LazyThreadSafetyMode.NONE, PagerIndicator$paint$2.INSTANCE);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        if (r102 == Integer.MIN_VALUE) goto L7;
        if (r102 != 0) goto L8;
        r103 = (int) ((this.f441267c.toPixels(getContext()) * this.f441266b) + (this.f441268d.toPixels(getContext()) * (this.f441266b - 1)));
    L8:
        int r104 = View.MeasureSpec.getMode(r101);
        int r105 = View.MeasureSpec.getSize(r101);
        if (r104 == Integer.MIN_VALUE) goto L13;
        if (r104 != 0) goto L14;
        r105 = (int) this.f441267c.toPixels(getContext());
    L14:
        setMeasuredDimension(r103, r105);
        return;
    L13:
        r105 = Math.min(r105, (int) this.f441267c.toPixels(getContext()));
        goto L14
    L7:
        r103 = Math.min(r103, (int) ((this.f441267c.toPixels(getContext()) * this.f441266b) + (this.f441268d.toPixels(getContext()) * (this.f441266b - 1))));
        goto L8
    }

    public PagerIndicator(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f441267c = new UDDimension.Dp(4);
        this.f441268d = new UDDimension.Dp(4);
        this.f441269e = UDColorUtils.getColor(getContext(), R.color.icon_disable);
        this.f441270f = UDColorUtils.getColor(getContext(), R.color.primary_fill_default);
        this.f441271g = LazyKt.lazy(LazyThreadSafetyMode.NONE, PagerIndicator$paint$2.INSTANCE);
    }
}
