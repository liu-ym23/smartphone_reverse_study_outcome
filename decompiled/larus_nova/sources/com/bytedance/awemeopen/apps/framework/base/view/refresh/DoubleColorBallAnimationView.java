package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public class DoubleColorBallAnimationView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f193329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f193330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f193331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PorterDuffXfermode f193332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f193333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f193334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f193335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f193336h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f193337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f193338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f193339k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f193340l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f193341m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f193342n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f193343o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f193344p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f193345q;

    public final void d() {
        this.f193339k = false;
        this.f193335g = false;
        this.f193333e = 0.0f;
    }

    public final void a() {
        this.f193340l = -1;
        if (this.f193341m > 0) goto L5;
        setProgressBarInfo(getContext().getResources().getDimensionPixelSize(R.dimen.aos_annie_loading_side));
    L5:
        int r100 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.f193341m <= r100) goto L10;
        if (r100 <= 0) goto L10;
        setProgressBarInfo(r100);
    L10:
        if (this.f193331c != null) goto L12;
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        r101.setDither(true);
        r101.setStyle(Paint.Style.FILL);
        this.f193331c = r101;
    L12:
        this.f193335g = true;
    }

    public final void c() {
        a();
        this.f193339k = true;
        this.f193334f = true;
        postInvalidate();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f193337i == true) goto L5;
        return;
    L5:
        if (this.f193338j == false) goto L9;
        c();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f193338j = this.f193339k;
        d();
    }

    public DoubleColorBallAnimationView(Context r100) {
        this(r100, null);
        b(r100);
    }

    public final void b(Context r100) {
        this.f193329a = ContextCompat.getColor(r100, R.color.aos_annie_loading_color1);
        this.f193330b = ContextCompat.getColor(r100, R.color.aos_annie_loading_color2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f193339k == true) goto L7;
        if (this.f193334f == false) goto L7;
        return;
    L7:
        if (this.f193335g == false) goto L36;
        boolean r100 = false;
        if (this.f193334f == false) goto L18;
        long r101 = System.nanoTime() / 1000000;
        if (this.f193340l >= 0) goto L14;
        this.f193340l = r101;
    L14:
        float r102 = (r101 - this.f193340l) / 400.0f;
        this.f193333e = r102;
        int r103 = (int) r102;
        if (((this.f193336h + r103) & 1) != 1) goto L17;
        r100 = true;
    L17:
        this.f193333e = r102 - r103;
    L18:
        float r104 = this.f193333e;
        if (r104 >= 0.5f) goto L21;
        float r105 = (r104 * 2.0f) * r104;
    L22:
        int r106 = this.f193341m;
        int r107 = r110.saveLayer(0.0f, 0.0f, r106, r106, this.f193331c, 31);
        float r108 = (this.f193345q * r105) + this.f193344p;
        if (r105 >= 0.5f) goto L25;
        float r109 = r105 * 2.0f;
    L26:
        float r111 = this.f193343o;
        float r112 = ((0.25f * r109) * r111) + r111;
        Paint r113 = this.f193331c;
        if (r100 == false) goto L29;
        int r114 = this.f193330b;
    L30:
        r113.setColor(r114);
        r110.drawCircle(r108, this.f193342n, r112, this.f193331c);
        float r115 = this.f193341m - r108;
        float r116 = this.f193343o;
        float r117 = r116 - ((r109 * 0.375f) * r116);
        Paint r118 = this.f193331c;
        if (r100 == false) goto L33;
        int r119 = this.f193329a;
    L34:
        r118.setColor(r119);
        this.f193331c.setXfermode(this.f193332d);
        r110.drawCircle(r115, this.f193342n, r117, this.f193331c);
        this.f193331c.setXfermode(null);
        r110.restoreToCount(r107);
        postInvalidateDelayed(17);
        return;
    L33:
        r119 = this.f193330b;
        goto L34
    L29:
        r114 = this.f193329a;
        goto L30
    L25:
        r109 = 2.0f - (r105 * 2.0f);
        goto L26
    L21:
        r105 = ((r104 * 2.0f) * (2.0f - r104)) - 1.0f;
        goto L22
    }

    public void setCycleBias(int r100) {
        this.f193336h = r100;
    }

    public void setProgress(float r100) {
        if (this.f193335g == true) goto L5;
        a();
    L5:
        this.f193333e = r100;
        this.f193339k = false;
        this.f193334f = false;
        postInvalidate();
    }

    public void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L5;
        this.f193341m = r100;
        this.f193342n = r100 / 2.0f;
        float r101 = (r100 >> 1) * 0.32f;
        this.f193343o = r101;
        float r102 = (r100 * 0.16f) + r101;
        this.f193344p = r102;
        this.f193345q = r100 - (r102 * 2.0f);
        return;
    }

    public void setResumeWhenAttached(boolean r100) {
        this.f193337i = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        c();
        return;
    L5:
        d();
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
        b(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = Math.min(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        if (this.f193341m <= r102) goto L7;
        if (r102 <= 0) goto L8;
        setProgressBarInfo(r102);
        return;
    L8:
        return;
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193332d = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.f193334f = false;
        this.f193335g = false;
        this.f193336h = 0;
        this.f193337i = false;
        this.f193338j = false;
        this.f193339k = false;
        this.f193340l = -1;
        this.f193341m = -1;
        b(r100);
    }
}
