package com.bytedance.ee.bear.onboarding.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import j08.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MaskView extends View {
    public Paint a;
    public PorterDuffXfermode b;
    public RectF c;
    public int d;
    public int e;
    public int f;

    public MaskView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        super.onDraw(r9);
        this.a.setXfermode(null);
        this.a.setColor(this.e);
        r9.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.a);
        this.a.setXfermode(this.b);
        this.a.setColor(this.f);
        RectF r0 = this.c;
        int r1 = this.d;
        r9.drawRoundRect(r0, r1, r1, this.a);
    }

    public void setHighRect(RectF r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.c = r1;
        invalidate();
    }

    public void setHighlightRectRadius(int r1) {
        this.d = r1;
    }

    public void setMaskColor(int r1) {
        this.e = r1;
    }

    public MaskView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public MaskView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = new RectF();
        this.e = b.b(getResources().getColor(2131103451), 0.1f);
        this.f = getResources().getColor(2131103546);
        Resources r4 = getResources();
        this.d = (int) (WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density * 8.0f);
        Paint r5 = new Paint();
        this.a = r5;
        r5.setAntiAlias(true);
        this.a.setDither(true);
        this.a.setStyle(Paint.Style.FILL);
        this.b = new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
        setLayerType(1, null);
    }
}
