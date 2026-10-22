package com.bytedance.ee.bear.bizwidget.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.ee.bear.bizwidget.banner.config.IndicatorConfig;
import com.larus.nova.R;
import cu5.c;
import qv4.a;

/* JADX INFO: loaded from: classes16.dex */
public class BaseIndicator extends View implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IndicatorConfig f216356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f216357b;

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager.e
    public final void onPageScrollStateChanged(int r100) {
    }

    @Override // qv4.a
    public View getIndicatorView() {
        if (this.f216356a.f216351l == false) goto L19;
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-2, c.b(8));
        IndicatorConfig r101 = this.f216356a;
        int r102 = r101.f216342c;
        if (r102 != 0) goto L7;
        r100.gravity = 8388691;
    L14:
        r100.leftMargin = r101.a().f216352a;
        r100.rightMargin = this.f216356a.a().f216354c;
        r100.topMargin = this.f216356a.a().f216353b;
        r100.bottomMargin = this.f216356a.a().f216355d;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        setLayoutParams(r103);
        FrameLayout r104 = new FrameLayout(getContext());
        if ((getParent() instanceof ViewGroup) == false) goto L17;
        ((ViewGroup) getParent()).removeView(this);
    L17:
        r104.setLayoutParams(r100);
        r104.setPadding(c.b(3), 0, c.b(3), 0);
        r104.setBackground(getContext().getDrawable(R.drawable.indicator_bg));
        r104.addView(this, r103);
        return r104;
    L7:
        if (r102 != 1) goto L9;
        r100.gravity = 81;
        goto L14
    L9:
        if (r102 != 2) goto L14;
        r100.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        goto L14
    L19:
        return this;
    }

    @Override // qv4.a
    public IndicatorConfig getIndicatorConfig() {
        return this.f216356a;
    }

    public BaseIndicator(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        if ((getParent() instanceof FrameLayout) == true) goto L5;
        return;
    L5:
        if (this.f216356a.f216340a > 1) goto L7;
        ((View) getParent()).setBackground(null);
        return;
    L7:
        ((View) getParent()).setBackground(getContext().getDrawable(R.drawable.indicator_bg));
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager.e
    public final void onPageSelected(int r100) {
        this.f216356a.f216341b = r100;
        invalidate();
    }

    public BaseIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager.e
    public final void a(int r100, float r101) {
        invalidate();
    }

    @Override // qv4.a
    public final void b(int r100, int r101) {
        IndicatorConfig r102 = this.f216356a;
        r102.f216340a = r100;
        r102.f216341b = r101;
        requestLayout();
    }

    public BaseIndicator(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        IndicatorConfig r103 = new IndicatorConfig();
        this.f216356a = r103;
        Paint r104 = new Paint();
        this.f216357b = r104;
        r104.setAntiAlias(true);
        r104.setColor(r103.f216346g);
    }
}
