package com.lynx.smartrefresh.layout.footer;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.graphics.ColorUtils;
import com.larus.nova.R;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import m6a.e;
import m6a.i;
import p6a.b;

/* JADX INFO: loaded from: classes32.dex */
public class BallPulseFooter extends b implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f381551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f381552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f381553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f381554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f381555h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f381556i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f381557j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f381558k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TimeInterpolator f381559l;

    public BallPulseFooter(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        int r100 = getWidth();
        int r101 = getHeight();
        float r102 = Math.min(r100, r101);
        float r103 = this.f381556i;
        float r104 = (r102 - (r103 * 2.0f)) / 6.0f;
        float r105 = r104 * 2.0f;
        float r106 = (r100 / 2.0f) - (r103 + r105);
        float r107 = r101 / 2.0f;
        long r108 = System.currentTimeMillis();
        int r109 = 0;
    L4:
        if (r109 >= 3) goto L14;
        int r111 = r109 + 1;
        long r112 = (r108 - this.f381557j) - ((long) (r111 * 120));
        if (r112 <= 0) goto L8;
        float r113 = (r112 % 750) / 750.0f;
    L9:
        float r114 = ((AccelerateDecelerateInterpolator) this.f381559l).getInterpolation(r113);
        r110.save();
        float r115 = r109;
        r110.translate(((r105 * r115) + r106) + (this.f381556i * r115), r107);
        if (r114 >= 0.5d) goto L12;
        float r116 = 1.0f - ((r114 * 2.0f) * 0.7f);
        r110.scale(r116, r116);
    L13:
        r110.drawCircle(0.0f, 0.0f, r104, this.f381553f);
        r110.restore();
        r109 = r111;
        goto L4
    L12:
        float r117 = ((r114 * 2.0f) * 0.7f) - 0.4f;
        r110.scale(r117, r117);
        goto L13
    L8:
        r113 = 0.0f;
        goto L9
    L14:
        super.dispatchDraw(r110);
        if (this.f381558k == false) goto L21;
        invalidate();
        return;
    }

    @Override // p6a.b, m6a.g
    public void setPrimaryColors(int... r100) {
        if (this.f381552e == true) goto L11;
        if (r100.length <= 1) goto L11;
        int r101 = r100[0];
        this.f381555h = r101;
        this.f381552e = true;
        if (this.f381558k == false) goto L9;
        this.f381553f.setColor(r101);
    L9:
        this.f381552e = false;
    L11:
        if (this.f381551d == false) goto L13;
        return;
    L13:
        if (r100.length <= 1) goto L18;
        int r102 = r100[1];
        this.f381554g = r102;
        this.f381551d = true;
        if (this.f381558k == true) goto L22;
        this.f381553f.setColor(r102);
    L22:
        this.f381551d = false;
        return;
    L18:
        if (r100.length <= 0) goto L22;
        int r103 = ColorUtils.compositeColors(-1711276033, r100[0]);
        this.f381554g = r103;
        this.f381551d = true;
        if (this.f381558k == true) goto L22;
        this.f381553f.setColor(r103);
        goto L22
    }

    public BallPulseFooter(Context r100, AttributeSet r101) {
        super(r100, r101, 0);
        this.f381554g = -1118482;
        this.f381555h = -1615546;
        this.f381557j = 0;
        this.f381558k = false;
        this.f381559l = new AccelerateDecelerateInterpolator();
        setMinimumHeight(r6a.b.c(60.0f));
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.srlAnimatingColor, R.attr.srlClassicsSpinnerStyle, R.attr.srlNormalColor});
        Paint r103 = new Paint();
        this.f381553f = r103;
        r103.setColor(-1);
        r103.setStyle(Paint.Style.FILL);
        r103.setAntiAlias(true);
        this.f527945b = n6a.b.f518183d;
        this.f527945b = n6a.b.f518187h[r102.getInt(1, 0)];
        if (r102.hasValue(2) == false) goto L8;
        int r104 = r102.getColor(2, 0);
        this.f381554g = r104;
        this.f381551d = true;
        if (this.f381558k == true) goto L8;
        r103.setColor(r104);
    L8:
        if (r102.hasValue(0) == false) goto L12;
        int r105 = r102.getColor(0, 0);
        this.f381555h = r105;
        this.f381552e = true;
        if (this.f381558k == false) goto L12;
        r103.setColor(r105);
    L12:
        r102.recycle();
        this.f381556i = r6a.b.c(4.0f);
    }

    @Override // p6a.b, m6a.g
    public final int e(SmartRefreshLayout r100, boolean r101) {
        this.f381558k = false;
        this.f381557j = 0;
        this.f381553f.setColor(this.f381554g);
        return 0;
    }

    @Override // p6a.b, m6a.g
    public final void n(i r100, int r101, int r102) {
        if (this.f381558k == false) goto L5;
        return;
    L5:
        invalidate();
        this.f381558k = true;
        this.f381557j = System.currentTimeMillis();
        this.f381553f.setColor(this.f381555h);
    }
}
