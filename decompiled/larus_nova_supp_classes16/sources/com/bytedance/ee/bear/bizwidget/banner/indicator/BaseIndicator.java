package com.bytedance.ee.bear.bizwidget.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bizwidget.banner.config.IndicatorConfig;
import cu5.c;
import qv4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BaseIndicator extends View implements a {
    public final IndicatorConfig a;
    public final Paint b;

    public final void onPageScrollStateChanged(int r1) {
    }

    @Override // qv4.a
    public View getIndicatorView() {
        if (this.a.l == false) goto L19;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, c.b(8));
        IndicatorConfig r1 = this.a;
        int r3 = r1.c;
        if (r3 != 0) goto L7;
        r0.gravity = 8388691;
    L14:
        r0.leftMargin = r1.a().a;
        r0.rightMargin = this.a.a().c;
        r0.topMargin = this.a.a().b;
        r0.bottomMargin = this.a.a().d;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, -2);
        r2.gravity = 17;
        setLayoutParams(r2);
        FrameLayout r4 = new FrameLayout(getContext());
        if ((getParent() instanceof ViewGroup) == false) goto L17;
        ((ViewGroup) getParent()).removeView(this);
    L17:
        r4.setLayoutParams(r0);
        r4.setPadding(c.b(3), 0, c.b(3), 0);
        r4.setBackground(getContext().getDrawable(2131238267));
        r4.addView(this, r2);
        return r4;
    L7:
        if (r3 != 1) goto L9;
        r0.gravity = 81;
        goto L14
    L9:
        if (r3 != 2) goto L14;
        r0.gravity = 8388693;
        goto L14
    L19:
        return this;
    }

    @Override // qv4.a
    public IndicatorConfig getIndicatorConfig() {
        return this.a;
    }

    public BaseIndicator(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas r3) {
        super.onDraw(r3);
        if ((getParent() instanceof FrameLayout) == true) goto L5;
        return;
    L5:
        if (this.a.a > 1) goto L7;
        ((View) getParent()).setBackground(null);
        return;
    L7:
        ((View) getParent()).setBackground(getContext().getDrawable(2131238267));
    }

    public final void onPageSelected(int r2) {
        this.a.b = r2;
        invalidate();
    }

    public BaseIndicator(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void a(int r1, float r2) {
        invalidate();
    }

    @Override // qv4.a
    public final void b(int r2, int r3) {
        IndicatorConfig r0 = this.a;
        r0.a = r2;
        r0.b = r3;
        requestLayout();
    }

    public BaseIndicator(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        IndicatorConfig r4 = new IndicatorConfig();
        this.a = r4;
        Paint r5 = new Paint();
        this.b = r5;
        r5.setAntiAlias(true);
        r5.setColor(r4.g);
    }
}
