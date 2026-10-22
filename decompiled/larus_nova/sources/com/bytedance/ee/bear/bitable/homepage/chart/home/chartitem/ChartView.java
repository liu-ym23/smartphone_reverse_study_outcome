package com.bytedance.ee.bear.bitable.homepage.chart.home.chartitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.ChartItemView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/home/chartitem/ChartView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dragIcon", "Landroid/widget/ImageView;", "getDragIcon", "()Landroid/widget/ImageView;", "dragIcon$delegate", "Lkotlin/Lazy;", "deleteIcon", "getDeleteIcon", "deleteIcon$delegate", "chartTitle", "Landroidx/appcompat/widget/AppCompatTextView;", "getChartTitle", "()Landroidx/appcompat/widget/AppCompatTextView;", "chartTitle$delegate", "header", "Landroid/view/View;", "getHeader", "()Landroid/view/View;", "header$delegate", "chartItemView", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView;", "getChartItemView", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView;", "chartItemView$delegate", "chartContainer", "getChartContainer", "()Landroid/widget/FrameLayout;", "chartContainer$delegate", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChartView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f212503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f212504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f212505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f212506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f212507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f212508f;

    public ChartView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChartView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final FrameLayout getChartContainer() {
        return (FrameLayout) this.f212508f.getValue();
    }

    public final ChartItemView getChartItemView() {
        return (ChartItemView) this.f212507e.getValue();
    }

    public final AppCompatTextView getChartTitle() {
        return (AppCompatTextView) this.f212505c.getValue();
    }

    public final ImageView getDeleteIcon() {
        return (ImageView) this.f212504b.getValue();
    }

    public final ImageView getDragIcon() {
        return (ImageView) this.f212503a.getValue();
    }

    public final View getHeader() {
        return (View) this.f212506d.getValue();
    }

    public ChartView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f212503a = LazyKt.lazy(new ChartView$dragIcon$2(this));
        this.f212504b = LazyKt.lazy(new ChartView$deleteIcon$2(this));
        this.f212505c = LazyKt.lazy(new ChartView$chartTitle$2(this));
        this.f212506d = LazyKt.lazy(new ChartView$header$2(this));
        this.f212507e = LazyKt.lazy(new ChartView$chartItemView$2(r100));
        this.f212508f = LazyKt.lazy(new ChartView$chartContainer$2(this));
        LayoutInflater.from(r100).inflate(R.layout.bitable_chart_home_item, this, true);
        getChartContainer().addView(getChartItemView(), new FrameLayout.LayoutParams(-1, -1));
    }

    public /* synthetic */ ChartView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
