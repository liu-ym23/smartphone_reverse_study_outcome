package com.bytedance.dux.loading;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\u000b¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0007\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u00118\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u00118\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R$\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lcom/bytedance/dux/loading/LineLoadingView;", "Landroid/view/View;", "Landroid/graphics/RectF;", "b", "Landroid/graphics/RectF;", "getBoundsRect", "()Landroid/graphics/RectF;", "boundsRect", "c", "getIndicatorRect", "indicatorRect", "", "d", "I", "getBarHeight", "()I", "barHeight", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "getIndicatorPaint", "()Landroid/graphics/Paint;", "indicatorPaint", "f", "getBgPaint", "bgPaint", "value", "getProgress", "setProgress", "(I)V", "progress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public class LineLoadingView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f205245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f205246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f205247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f205248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f205249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f205250f;

    public LineLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LineLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getBarHeight() {
        return this.f205248d;
    }

    public final Paint getBgPaint() {
        return this.f205250f;
    }

    public final RectF getBoundsRect() {
        return this.f205246b;
    }

    public final Paint getIndicatorPaint() {
        return this.f205249e;
    }

    public final RectF getIndicatorRect() {
        return this.f205247c;
    }

    public final int getProgress() {
        return this.f205245a;
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.drawRect(this.f205246b, this.f205250f);
        r100.drawRect(this.f205247c, this.f205249e);
    }

    public final void setProgress(int r100) {
        this.f205245a = r100;
        this.f205247c.right = this.f205246b.right * (r100 / 100.0f);
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMinimumHeight(this.f205248d);
        super.onMeasure(r100, r101);
    }

    public LineLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f205246b = new RectF();
        this.f205247c = new RectF();
        Resources r103 = Resources.getSystem();
        this.f205248d = MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        Paint r104 = new Paint();
        r104.setColor((int) 4293634085L);
        this.f205249e = r104;
        Paint r105 = new Paint();
        r105.setColor(872415231);
        this.f205250f = r105;
    }

    public /* synthetic */ LineLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        RectF r104 = this.f205246b;
        int r105 = this.f205248d;
        float r106 = (r101 - r105) / 2.0f;
        r104.top = r106;
        float r107 = (r101 + r105) / 2.0f;
        r104.bottom = r107;
        float r108 = r100;
        r104.right = r108;
        RectF r109 = this.f205247c;
        r109.top = r106;
        r109.bottom = r107;
        r109.right = r108 * (this.f205245a / 100.0f);
        Objects.toString(r104);
        Objects.toString(this.f205247c);
    }
}
