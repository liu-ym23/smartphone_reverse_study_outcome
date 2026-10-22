package com.bytedance.ee.bear.document.ai.creationai;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\n\u0010\u001e\u001a\u00020\u0007*\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/creationai/BubbleTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fillPaint", "Landroid/graphics/Paint;", "strokePaint", "bottomStrokePaint", "fillPath", "Landroid/graphics/Path;", "strokePath", "arrowWidth", "", "arrowHeight", "cornerRadius", "arrowOffsetFromRight", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "dpToPx", "dp", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BubbleTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f218770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f218771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f218772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f218773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f218774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f218775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f218776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f218777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f218778i;

    public BubbleTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BubbleTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static float x(float r100) {
        Resources r101 = Resources.getSystem();
        return TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        this.f218773d.reset();
        this.f218774e.reset();
        float r100 = getWidth();
        float r101 = getHeight();
        float r111 = 2;
        float r112 = (r100 - this.f218778i) - (this.f218775f / r111);
        this.f218773d.moveTo(r112, 0.0f);
        this.f218773d.lineTo((this.f218775f / r111) + r112, this.f218776g);
        this.f218773d.lineTo(r112 - (this.f218775f / r111), this.f218776g);
        Path r102 = this.f218773d;
        float r103 = this.f218776g;
        float r104 = this.f218777h;
        r102.addRoundRect(0.0f, r103, r100, r101, r104, r104, Path.Direction.CW);
        this.f218773d.close();
        Path r105 = this.f218774e;
        float r106 = this.f218776g;
        float r107 = this.f218777h;
        r105.addRoundRect(0.0f, r106, r100, r101, r107, r107, Path.Direction.CW);
        this.f218774e.moveTo(r112, 0.0f);
        this.f218774e.lineTo(r112 - (this.f218775f / r111), this.f218776g);
        this.f218774e.moveTo(r112, 0.0f);
        this.f218774e.lineTo((this.f218775f / r111) + r112, this.f218776g);
        r110.drawPath(this.f218773d, this.f218770a);
        r110.drawPath(this.f218774e, this.f218771b);
        Path r108 = new Path();
        r108.moveTo(r112 - (this.f218775f / r111), this.f218776g);
        r108.lineTo(r112 + (this.f218775f / r111), this.f218776g);
        r110.drawPath(r108, this.f218772c);
        super.onDraw(r110);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getSize(r100);
        if ((getParent() instanceof ViewGroup) == false) goto L7;
        ViewParent r103 = getParent();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup.LayoutParams r104 = ((ViewGroup) r103).getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        r102 = r102 - ((ViewGroup.MarginLayoutParams) r104).getMarginEnd();
    L7:
        float r105 = (r102 - this.f218778i) - this.f218775f;
        if (getPaint().measureText(getText().toString()) <= r105) goto L11;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) r105, Integer.MIN_VALUE), r101);
        return;
    }

    public BubbleTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setLines(0);
        setMaxLines(Integer.MAX_VALUE);
        setEllipsize(null);
        setHorizontallyScrolling(false);
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.FILL);
        r103.setColor(d.c(r100, R.color.bg_float));
        this.f218770a = r103;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(x(1.0f) / 2);
        r104.setColor(d.c(r100, R.color.line_border_card));
        this.f218771b = r104;
        Paint r105 = new Paint(1);
        r105.setStyle(Paint.Style.STROKE);
        r105.setStrokeWidth(x(1.0f));
        r105.setColor(d.c(r100, R.color.bg_float));
        this.f218772c = r105;
        this.f218773d = new Path();
        this.f218774e = new Path();
        this.f218775f = x(16.0f);
        this.f218776g = x(8.0f);
        this.f218777h = x(8.0f);
        this.f218778i = x(20.0f);
    }

    public /* synthetic */ BubbleTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
