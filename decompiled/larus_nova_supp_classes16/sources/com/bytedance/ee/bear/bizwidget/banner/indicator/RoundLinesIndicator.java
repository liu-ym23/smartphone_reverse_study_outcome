package com.bytedance.ee.bear.bizwidget.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.bytedance.ee.bear.bizwidget.banner.config.IndicatorConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RoundLinesIndicator extends BaseIndicator {
    public RoundLinesIndicator(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.ee.bear.bizwidget.banner.indicator.BaseIndicator, android.view.View
    public final void onDraw(Canvas r7) {
        super.onDraw(r7);
        IndicatorConfig r0 = this.a;
        if (r0.a > 1) goto L5;
        return;
    L5:
        this.b.setColor(r0.g);
        RectF r1 = new RectF(0.0f, 0.0f, r7.getWidth(), this.a.j);
        int r2 = this.a.i;
        r7.drawRoundRect(r1, r2, r2, this.b);
        this.b.setColor(this.a.h);
        IndicatorConfig r3 = this.a;
        int r4 = r3.b * r3.f;
        IndicatorConfig r5 = this.a;
        RectF r6 = new RectF(r4, 0.0f, r4 + r5.f, r5.j);
        int r8 = this.a.i;
        r7.drawRoundRect(r6, r8, r8, this.b);
    }

    public RoundLinesIndicator(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        IndicatorConfig r4 = this.a;
        int r5 = r4.a;
        if (r5 > 1) goto L5;
        return;
    L5:
        setMeasuredDimension(r4.f * r5, r4.j);
    }

    public RoundLinesIndicator(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b.setStyle(Paint.Style.FILL);
    }
}
