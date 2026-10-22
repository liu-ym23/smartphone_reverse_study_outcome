package com.bytedance.ee.bear.bizwidget.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.bytedance.ee.bear.bizwidget.banner.config.IndicatorConfig;

/* JADX INFO: loaded from: classes16.dex */
public class RectangleIndicator extends BaseIndicator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f216361c;

    public RectangleIndicator(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.bizwidget.banner.indicator.BaseIndicator, android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        int r100 = this.f216356a.f216340a;
        if (r100 > 1) goto L5;
        return;
    L5:
        int r101 = 0;
        float r102 = 0.0f;
    L6:
        if (r101 >= r100) goto L20;
        Paint r103 = this.f216357b;
        IndicatorConfig r104 = this.f216356a;
        if (r104.f216341b != r101) goto L10;
        int r105 = r104.f216347h;
    L11:
        r103.setColor(r105);
        IndicatorConfig r106 = this.f216356a;
        if (r106.f216341b != r101) goto L14;
        int r107 = r106.f216345f;
    L15:
        this.f216361c.set(r102, 0.0f, r107 + r102, r106.f216349j);
        IndicatorConfig r108 = this.f216356a;
        if (r108.f216341b != r101) goto L18;
        RectF r109 = this.f216361c;
        int r111 = r108.f216348i;
        r110.drawRoundRect(r109, r111, r111, this.f216357b);
    L19:
        r102 = r102 + (r107 + this.f216356a.f216343d);
        r101 = r101 + 1;
        goto L6
    L18:
        int r112 = r108.f216344e;
        r110.drawCircle((r112 / 2) + r102, r108.f216349j / 2, r112 / 2, this.f216357b);
        goto L19
    L14:
        r107 = r106.f216344e;
        goto L15
    L10:
        r105 = r104.f216346g;
        goto L11
    }

    public RectangleIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        IndicatorConfig r102 = this.f216356a;
        int r103 = r102.f216340a;
        if (r103 > 1) goto L5;
        return;
    L5:
        int r104 = r103 - 1;
        setMeasuredDimension(((r102.f216343d * r104) + (r102.f216344e * r104)) + r102.f216345f, r102.f216349j);
    }

    public RectangleIndicator(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f216361c = new RectF();
    }
}
