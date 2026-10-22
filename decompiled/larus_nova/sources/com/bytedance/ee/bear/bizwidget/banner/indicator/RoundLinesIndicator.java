package com.bytedance.ee.bear.bizwidget.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.bytedance.ee.bear.bizwidget.banner.config.IndicatorConfig;

/* JADX INFO: loaded from: classes16.dex */
public class RoundLinesIndicator extends BaseIndicator {
    public RoundLinesIndicator(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.bizwidget.banner.indicator.BaseIndicator, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        IndicatorConfig r101 = this.f216356a;
        if (r101.f216340a > 1) goto L5;
        return;
    L5:
        this.f216357b.setColor(r101.f216346g);
        RectF r102 = new RectF(0.0f, 0.0f, r100.getWidth(), this.f216356a.f216349j);
        int r103 = this.f216356a.f216348i;
        r100.drawRoundRect(r102, r103, r103, this.f216357b);
        this.f216357b.setColor(this.f216356a.f216347h);
        IndicatorConfig r104 = this.f216356a;
        int r105 = r104.f216341b * r104.f216345f;
        IndicatorConfig r106 = this.f216356a;
        RectF r107 = new RectF(r105, 0.0f, r105 + r106.f216345f, r106.f216349j);
        int r108 = this.f216356a.f216348i;
        r100.drawRoundRect(r107, r108, r108, this.f216357b);
    }

    public RoundLinesIndicator(Context r100, AttributeSet r101) {
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
        setMeasuredDimension(r102.f216345f * r103, r102.f216349j);
    }

    public RoundLinesIndicator(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f216357b.setStyle(Paint.Style.FILL);
    }
}
