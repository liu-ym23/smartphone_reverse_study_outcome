package com.bytedance.ee.bear.bizwidget.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.bytedance.ee.bear.bizwidget.banner.config.IndicatorConfig;

/* JADX INFO: loaded from: classes16.dex */
public class CircleIndicator extends BaseIndicator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f216358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f216359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f216360e;

    public CircleIndicator(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.bizwidget.banner.indicator.BaseIndicator, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = this.f216356a.f216340a;
        if (r101 > 1) goto L5;
        return;
    L5:
        float r102 = 0.0f;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L19;
        Paint r104 = this.f216357b;
        IndicatorConfig r105 = this.f216356a;
        if (r105.f216341b != r103) goto L10;
        int r106 = r105.f216347h;
    L11:
        r104.setColor(r106);
        IndicatorConfig r107 = this.f216356a;
        int r108 = r107.f216341b;
        if (r108 != r103) goto L14;
        int r109 = r107.f216345f;
    L15:
        if (r108 != r103) goto L17;
        int r110 = this.f216359d;
    L18:
        float r111 = r110;
        r100.drawCircle(r102 + r111, this.f216360e, r111, this.f216357b);
        r102 = r102 + (r109 + this.f216356a.f216343d);
        r103 = r103 + 1;
        goto L6
    L17:
        r110 = this.f216358c;
        goto L18
    L14:
        r109 = r107.f216344e;
        goto L15
    L10:
        r106 = r105.f216346g;
        goto L11
    }

    public CircleIndicator(Context r100, AttributeSet r101) {
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
        int r104 = r102.f216344e / 2;
        this.f216358c = r104;
        int r105 = r102.f216345f / 2;
        this.f216359d = r105;
        this.f216360e = Math.max(r105, r104);
        int r106 = r103 - 1;
        IndicatorConfig r107 = this.f216356a;
        int r108 = r107.f216343d * r106;
        int r109 = r107.f216345f;
        int r110 = r107.f216344e;
        setMeasuredDimension((r108 + r109) + (r106 * r110), Math.max(r110, r109));
    }

    public CircleIndicator(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        IndicatorConfig r103 = this.f216356a;
        this.f216358c = r103.f216344e / 2;
        this.f216359d = r103.f216345f / 2;
    }
}
