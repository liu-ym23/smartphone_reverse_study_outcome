package com.bytedance.ee.bear.bizwidget.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.bytedance.ee.bear.bizwidget.banner.config.IndicatorConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RectangleIndicator extends BaseIndicator {
    public final RectF c;

    public RectangleIndicator(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.ee.bear.bizwidget.banner.indicator.BaseIndicator, android.view.View
    public final void onDraw(Canvas r10) {
        super.onDraw(r10);
        int r0 = this.a.a;
        if (r0 > 1) goto L5;
        return;
    L5:
        int r2 = 0;
        float r3 = 0.0f;
    L6:
        if (r2 >= r0) goto L20;
        Paint r4 = this.b;
        IndicatorConfig r5 = this.a;
        if (r5.b != r2) goto L10;
        int r6 = r5.h;
    L11:
        r4.setColor(r6);
        IndicatorConfig r7 = this.a;
        if (r7.b != r2) goto L14;
        int r8 = r7.f;
    L15:
        this.c.set(r3, 0.0f, r8 + r3, r7.j);
        IndicatorConfig r9 = this.a;
        if (r9.b != r2) goto L18;
        RectF r11 = this.c;
        int r12 = r9.i;
        r10.drawRoundRect(r11, r12, r12, this.b);
    L19:
        r3 = r3 + (r8 + this.a.d);
        r2 = r2 + 1;
        goto L6
    L18:
        int r13 = r9.e;
        r10.drawCircle((r13 / 2) + r3, r9.j / 2, r13 / 2, this.b);
        goto L19
    L14:
        r8 = r7.e;
        goto L15
    L10:
        r6 = r5.g;
        goto L11
    }

    public RectangleIndicator(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        IndicatorConfig r5 = this.a;
        int r6 = r5.a;
        if (r6 > 1) goto L5;
        return;
    L5:
        int r7 = r6 - 1;
        setMeasuredDimension(((r5.d * r7) + (r5.e * r7)) + r5.f, r5.j);
    }

    public RectangleIndicator(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = new RectF();
    }
}
