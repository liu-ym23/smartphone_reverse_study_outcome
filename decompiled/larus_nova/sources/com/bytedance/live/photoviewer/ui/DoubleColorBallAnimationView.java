package com.bytedance.live.photoviewer.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public class DoubleColorBallAnimationView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f255723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f255724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f255725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PorterDuffXfermode f255726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f255727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f255728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f255729g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f255730h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f255731i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f255732j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f255733k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f255734l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f255735m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f255736n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f255737o;

    public final void a() {
        this.f255732j = -1;
        if (this.f255733k > 0) goto L5;
        setProgressBarInfo(getContext().getResources().getDimensionPixelSize(R.dimen.default_loading_side));
    L5:
        int r100 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.f255733k <= r100) goto L10;
        if (r100 <= 0) goto L10;
        setProgressBarInfo(r100);
    L10:
        if (this.f255725c != null) goto L12;
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        r101.setDither(true);
        r101.setStyle(Paint.Style.FILL);
        this.f255725c = r101;
    L12:
        this.f255729g = true;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f255731i = false;
        this.f255729g = false;
        this.f255727e = 0.0f;
    }

    public DoubleColorBallAnimationView(Context r100) {
        this(r100, null);
        b(r100);
    }

    public final void b(Context r100) {
        this.f255723a = ContextCompat.getColor(r100, R.color.uikit_loading_color1);
        this.f255724b = ContextCompat.getColor(r100, R.color.uikit_loading_color2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f255731i == true) goto L7;
        if (this.f255728f == false) goto L7;
        return;
    L7:
        if (this.f255729g == false) goto L36;
        boolean r100 = false;
        if (this.f255728f == false) goto L18;
        long r101 = System.nanoTime() / 1000000;
        if (this.f255732j >= 0) goto L14;
        this.f255732j = r101;
    L14:
        float r102 = (r101 - this.f255732j) / 400.0f;
        this.f255727e = r102;
        int r103 = (int) r102;
        if (((this.f255730h + r103) & 1) != 1) goto L17;
        r100 = true;
    L17:
        this.f255727e = r102 - r103;
    L18:
        float r104 = this.f255727e;
        float r105 = r104 * 2.0f;
        if (r104 >= 0.5d) goto L21;
        float r106 = r105 * r104;
    L22:
        int r107 = this.f255733k;
        int r108 = r110.saveLayer(0.0f, 0.0f, r107, r107, this.f255725c, 31);
        float r109 = (this.f255737o * r106) + this.f255736n;
        if (r106 >= 0.5d) goto L25;
        float r111 = r106 * 2.0f;
    L26:
        float r112 = this.f255735m;
        float r113 = ((0.25f * r111) * r112) + r112;
        Paint r114 = this.f255725c;
        if (r100 == false) goto L29;
        int r115 = this.f255724b;
    L30:
        r114.setColor(r115);
        r110.drawCircle(r109, this.f255734l, r113, this.f255725c);
        float r116 = this.f255733k - r109;
        float r117 = this.f255735m;
        float r118 = r117 - ((r111 * 0.375f) * r117);
        Paint r119 = this.f255725c;
        if (r100 == false) goto L33;
        int r120 = this.f255723a;
    L34:
        r119.setColor(r120);
        this.f255725c.setXfermode(this.f255726d);
        r110.drawCircle(r116, this.f255734l, r118, this.f255725c);
        this.f255725c.setXfermode(null);
        r110.restoreToCount(r108);
        postInvalidateDelayed(17);
        return;
    L33:
        r120 = this.f255724b;
        goto L34
    L29:
        r115 = this.f255723a;
        goto L30
    L25:
        r111 = 2.0f - (r106 * 2.0f);
        goto L26
    L21:
        r106 = (r105 * (2.0f - r104)) - 1.0f;
        goto L22
    }

    public void setCycleBias(int r100) {
        this.f255730h = r100;
    }

    public void setProgress(float r100) {
        if (this.f255729g == true) goto L5;
        a();
    L5:
        this.f255727e = r100;
        this.f255731i = false;
        this.f255728f = false;
        postInvalidate();
    }

    public void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L5;
        this.f255733k = r100;
        this.f255734l = r100 / 2.0f;
        float r101 = (r100 >> 1) * 0.32f;
        this.f255735m = r101;
        float r102 = (r100 * 0.16f) + r101;
        this.f255736n = r102;
        this.f255737o = r100 - (r102 * 2.0f);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        a();
        this.f255731i = true;
        this.f255728f = true;
        postInvalidate();
        return;
    L5:
        this.f255731i = false;
        this.f255729g = false;
        this.f255727e = 0.0f;
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
        b(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = Math.min(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        if (this.f255733k <= r102) goto L7;
        if (r102 <= 0) goto L8;
        setProgressBarInfo(r102);
        return;
    L8:
        return;
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f255726d = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.f255728f = false;
        this.f255729g = false;
        this.f255730h = 0;
        this.f255731i = false;
        this.f255732j = -1;
        this.f255733k = -1;
        b(r100);
    }
}
