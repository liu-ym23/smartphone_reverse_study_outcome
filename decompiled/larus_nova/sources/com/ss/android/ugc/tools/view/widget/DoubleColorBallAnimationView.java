package com.ss.android.ugc.tools.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes40.dex */
public class DoubleColorBallAnimationView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f455030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f455031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f455032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PorterDuffXfermode f455033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f455034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f455035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f455036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f455037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f455038i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f455039j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f455040k;

    public final void b() {
        this.f455035f = -1;
        if (this.f455036g > 0) goto L5;
        setProgressBarInfo(getContext().getResources().getDimensionPixelSize(R.dimen.tools_default_loading_side));
    L5:
        int r100 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.f455036g <= r100) goto L10;
        if (r100 <= 0) goto L10;
        setProgressBarInfo(r100);
    L10:
        if (this.f455032c != null) goto L12;
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        r101.setDither(true);
        r101.setStyle(Paint.Style.FILL);
        this.f455032c = r101;
    L12:
        this.f455034e = true;
        postInvalidate();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() != 0) goto L6;
        b();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f455034e = false;
    }

    public DoubleColorBallAnimationView(Context r100) {
        this(r100, null);
        a(r100);
    }

    public final void a(Context r100) {
        this.f455030a = ContextCompat.getColor(r100, R.color.tools_loading_color1);
        this.f455031b = ContextCompat.getColor(r100, R.color.tools_loading_color2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f455034e == true) goto L5;
        return;
    L5:
        long r100 = System.nanoTime() / 1000000;
        if (this.f455035f >= 0) goto L8;
        this.f455035f = r100;
    L8:
        float r101 = (r100 - this.f455035f) / 400.0f;
        int r102 = (int) r101;
        boolean r103 = true;
        if ((r102 & 1) == 1) goto L12;
        r103 = false;
    L12:
        float r104 = r101 - r102;
        float r105 = r104 * 2.0f;
        if (r104 >= 0.5d) goto L15;
        float r106 = r105 * r104;
    L16:
        int r107 = this.f455036g;
        int r108 = r110.saveLayer(0.0f, 0.0f, r107, r107, this.f455032c, 31);
        float r109 = (this.f455040k * r106) + this.f455039j;
        if (r106 >= 0.5d) goto L19;
        float r111 = r106 * 2.0f;
    L20:
        float r112 = this.f455038i;
        float r113 = ((0.25f * r111) * r112) + r112;
        Paint r114 = this.f455032c;
        if (r103 == false) goto L23;
        int r115 = this.f455031b;
    L24:
        r114.setColor(r115);
        r110.drawCircle(r109, this.f455037h, r113, this.f455032c);
        float r116 = this.f455036g - r109;
        float r117 = this.f455038i;
        float r118 = r117 - ((r111 * 0.375f) * r117);
        Paint r119 = this.f455032c;
        if (r103 == false) goto L27;
        int r120 = this.f455030a;
    L28:
        r119.setColor(r120);
        this.f455032c.setXfermode(this.f455033d);
        r110.drawCircle(r116, this.f455037h, r118, this.f455032c);
        this.f455032c.setXfermode(null);
        r110.restoreToCount(r108);
        postInvalidateDelayed(17);
        return;
    L27:
        r120 = this.f455031b;
        goto L28
    L23:
        r115 = this.f455030a;
        goto L24
    L19:
        r111 = 2.0f - (r106 * 2.0f);
        goto L20
    L15:
        r106 = (r105 * (2.0f - r104)) - 1.0f;
        goto L16
    }

    public void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L5;
        this.f455036g = r100;
        this.f455037h = r100 / 2.0f;
        float r101 = (r100 >> 1) * 0.32f;
        this.f455038i = r101;
        float r102 = (r100 * 0.16f) + r101;
        this.f455039j = r102;
        this.f455040k = r100 - (r102 * 2.0f);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        b();
        return;
    L5:
        this.f455034e = false;
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
        a(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = Math.min(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        if (this.f455036g <= r102) goto L7;
        if (r102 <= 0) goto L8;
        setProgressBarInfo(r102);
        return;
    L8:
        return;
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f455033d = new PorterDuffXfermode(PorterDuff.Mode.DARKEN);
        this.f455034e = false;
        this.f455035f = -1;
        this.f455036g = -1;
        a(r100);
    }
}
