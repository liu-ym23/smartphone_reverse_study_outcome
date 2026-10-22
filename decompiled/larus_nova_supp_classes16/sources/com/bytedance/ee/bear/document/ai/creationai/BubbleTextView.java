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
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.document.loading.SmallLoadingPlugin;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\n\u0010\u001e\u001a\u00020\u0007*\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/creationai/BubbleTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fillPaint", "Landroid/graphics/Paint;", "strokePaint", "bottomStrokePaint", "fillPath", "Landroid/graphics/Path;", "strokePath", "arrowWidth", "", "arrowHeight", "cornerRadius", "arrowOffsetFromRight", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "dpToPx", "dp", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BubbleTextView extends AppCompatTextView {
    public final Paint a;
    public final Paint b;
    public final Paint c;
    public final Path d;
    public final Path e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;

    public BubbleTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BubbleTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static float x(float r2) {
        Resources r0 = Resources.getSystem();
        return TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r14) {
        Intrinsics.checkNotNullParameter(r14, "canvas");
        this.d.reset();
        this.e.reset();
        float r0 = getWidth();
        float r9 = getHeight();
        float r10 = 2;
        float r11 = (r0 - this.i) - (this.f / r10);
        this.d.moveTo(r11, 0.0f);
        this.d.lineTo((this.f / r10) + r11, this.g);
        this.d.lineTo(r11 - (this.f / r10), this.g);
        Path r1 = this.d;
        float r3 = this.g;
        float r7 = this.h;
        r1.addRoundRect(0.0f, r3, r0, r9, r7, r7, Path.Direction.CW);
        this.d.close();
        Path r2 = this.e;
        float r4 = this.g;
        float r8 = this.h;
        r2.addRoundRect(0.0f, r4, r0, r9, r8, r8, Path.Direction.CW);
        this.e.moveTo(r11, 0.0f);
        this.e.lineTo(r11 - (this.f / r10), this.g);
        this.e.moveTo(r11, 0.0f);
        this.e.lineTo((this.f / r10) + r11, this.g);
        r14.drawPath(this.d, this.a);
        r14.drawPath(this.e, this.b);
        Path r5 = new Path();
        r5.moveTo(r11 - (this.f / r10), this.g);
        r5.lineTo(r11 + (this.f / r10), this.g);
        r14.drawPath(r5, this.c);
        super/*android.widget.TextView*/.onDraw(r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        int r5 = View.MeasureSpec.getSize(r3);
        if ((getParent() instanceof ViewGroup) == false) goto L7;
        ViewParent r0 = getParent();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup.LayoutParams r1 = ((ViewGroup) r0).getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        r5 = r5 - ((ViewGroup.MarginLayoutParams) r1).getMarginEnd();
    L7:
        float r6 = (r5 - this.i) - this.f;
        if (getPaint().measureText(getText().toString()) <= r6) goto L11;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) r6, ShareItemModel.SRC_TINT_UNDEFINED), r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BubbleTextView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        setLines(0);
        setMaxLines(SmallLoadingPlugin.DURATION_MAX);
        setEllipsize(null);
        setHorizontallyScrolling(false);
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.FILL);
        r8.setColor(d.c(r5, 2131100557));
        this.a = r8;
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.STROKE);
        r9.setStrokeWidth(x(1.0f) / 2);
        r9.setColor(d.c(r5, 2131103351));
        this.b = r9;
        Paint r10 = new Paint(1);
        r10.setStyle(Paint.Style.STROKE);
        r10.setStrokeWidth(x(1.0f));
        r10.setColor(d.c(r5, 2131100557));
        this.c = r10;
        this.d = new Path();
        this.e = new Path();
        this.f = x(16.0f);
        this.g = x(8.0f);
        this.h = x(8.0f);
        this.i = x(20.0f);
    }

    public /* synthetic */ BubbleTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
