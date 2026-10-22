package com.bytedance.bdp.appbase.ui.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes11.dex */
public class RoundedImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f201068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f201069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f201070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f201071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f201072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f201073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f201074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f201075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f201076i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f201077j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f201078k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float[] f201079l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float[] f201080m;

    public final void init() {
        this.f201075h = new RectF();
        this.f201076i = new RectF();
        this.f201079l = new float[8];
        this.f201080m = new float[8];
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        setLayerType(1, null);
        return;
    }

    public RoundedImageView(Context r100) {
        super(r100);
        this.f201068a = 0;
        this.f201072e = false;
        this.f201073f = -1;
        this.f201077j = new Path();
        this.f201078k = new Paint();
        init();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        r100.saveLayer(this.f201075h, null, 31);
        if (this.f201072e == true) goto L6;
        int r101 = this.f201069b;
        int r102 = this.f201074g;
        int r103 = this.f201070c;
        r100.scale(((r101 - (r102 * 2)) * 1.0f) / r101, ((r103 - (r102 * 2)) * 1.0f) / r103, r101 / 2.0f, r103 / 2.0f);
    L6:
        if (this.f201071d == false) goto L8;
        Path r104 = this.f201077j;
        int r105 = this.f201069b;
        int r106 = this.f201070c;
        r104.addCircle(r105 * 0.5f, r106 * 0.5f, Math.min(r105, r106) * 0.5f, Path.Direction.CCW);
    L9:
        r100.clipPath(this.f201077j);
        super.onDraw(r100);
        r100.restore();
        int r107 = this.f201074g;
        if (r107 <= 0) goto L17;
        int r108 = this.f201073f;
        RectF r109 = this.f201076i;
        float[] r110 = this.f201079l;
        this.f201077j.reset();
        this.f201078k.reset();
        this.f201078k.setAntiAlias(true);
        this.f201078k.setStyle(Paint.Style.FILL);
        this.f201078k.setStrokeWidth(r107);
        this.f201078k.setColor(r108);
        this.f201078k.setStyle(Paint.Style.STROKE);
        if (this.f201071d == false) goto L14;
        Path r111 = this.f201077j;
        int r112 = this.f201069b;
        int r113 = this.f201070c;
        r111.addCircle(r112 * 0.5f, r113 * 0.5f, (Math.min(r112, r113) - this.f201074g) * 0.5f, Path.Direction.CCW);
    L15:
        r100.drawPath(this.f201077j, this.f201078k);
        return;
    L14:
        this.f201077j.addRoundRect(r109, r110, Path.Direction.CCW);
        goto L15
    L17:
        return;
    L8:
        this.f201077j.addRoundRect(this.f201075h, this.f201080m, Path.Direction.CCW);
        goto L9
    }

    public void setBorderColor(int r100) {
        this.f201073f = r100;
    }

    public void setBorderWidth(float r100) {
        this.f201074g = (int) r100;
    }

    public void setCornerRadius(int r100) {
        this.f201068a = r100;
        int r101 = 0;
    L3:
        float[] r102 = this.f201079l;
        if (r101 >= r102.length) goto L6;
        float r103 = this.f201068a;
        r102[r101] = r103;
        this.f201080m[r101] = r103 - (this.f201074g / 2.0f);
        r101 = r101 + 1;
        goto L3
    }

    public void setIsInnerStrokes(boolean r100) {
        this.f201072e = r100;
    }

    public void setIsOval(boolean r100) {
        this.f201071d = r100;
    }

    public RoundedImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f201068a = 0;
        this.f201072e = false;
        this.f201073f = -1;
        this.f201077j = new Path();
        this.f201078k = new Paint();
        init();
    }

    public RoundedImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f201068a = 0;
        this.f201072e = false;
        this.f201073f = -1;
        this.f201077j = new Path();
        this.f201078k = new Paint();
        init();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f201069b = r100;
        this.f201070c = r101;
        float r104 = r100;
        float r105 = r101;
        this.f201075h.set(0.0f, 0.0f, r104, r105);
        RectF r106 = this.f201076i;
        float r107 = this.f201074g / 2.0f;
        r106.set(r107, r107, r104 - r107, r105 - r107);
        int r108 = 0;
    L3:
        float[] r109 = this.f201079l;
        if (r108 >= r109.length) goto L6;
        float r110 = this.f201068a;
        r109[r108] = r110;
        this.f201080m[r108] = r110 - (this.f201074g / 2.0f);
        r108 = r108 + 1;
        goto L3
    }
}
