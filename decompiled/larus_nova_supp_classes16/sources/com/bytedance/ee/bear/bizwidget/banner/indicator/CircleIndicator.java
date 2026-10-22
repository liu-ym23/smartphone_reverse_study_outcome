package com.bytedance.ee.bear.bizwidget.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.bytedance.ee.bear.bizwidget.banner.config.IndicatorConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CircleIndicator extends BaseIndicator {
    public int c;
    public int d;
    public int e;

    public CircleIndicator(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.ee.bear.bizwidget.banner.indicator.BaseIndicator, android.view.View
    public final void onDraw(Canvas r9) {
        super.onDraw(r9);
        int r0 = this.a.a;
        if (r0 > 1) goto L5;
        return;
    L5:
        float r1 = 0.0f;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L19;
        Paint r3 = this.b;
        IndicatorConfig r4 = this.a;
        if (r4.b != r2) goto L10;
        int r5 = r4.h;
    L11:
        r3.setColor(r5);
        IndicatorConfig r6 = this.a;
        int r7 = r6.b;
        if (r7 != r2) goto L14;
        int r8 = r6.f;
    L15:
        if (r7 != r2) goto L17;
        int r10 = this.d;
    L18:
        float r11 = r10;
        r9.drawCircle(r1 + r11, this.e, r11, this.b);
        r1 = r1 + (r8 + this.a.d);
        r2 = r2 + 1;
        goto L6
    L17:
        r10 = this.c;
        goto L18
    L14:
        r8 = r6.e;
        goto L15
    L10:
        r5 = r4.g;
        goto L11
    }

    public CircleIndicator(Context r2, AttributeSet r3) {
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
        int r1 = r5.e / 2;
        this.c = r1;
        int r7 = r5.f / 2;
        this.d = r7;
        this.e = Math.max(r7, r1);
        int r8 = r6 - 1;
        IndicatorConfig r9 = this.a;
        int r0 = r9.d * r8;
        int r2 = r9.f;
        int r10 = r9.e;
        setMeasuredDimension((r0 + r2) + (r8 * r10), Math.max(r10, r2));
    }

    public CircleIndicator(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        IndicatorConfig r4 = this.a;
        this.c = r4.e / 2;
        this.d = r4.f / 2;
    }
}
