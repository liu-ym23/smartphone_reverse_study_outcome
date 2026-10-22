package com.dtf.face.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes22.dex */
public class NearFarHoleView extends CircleHoleView {
    public RectF holeRectF;
    public float ratio;
    private int startAngle;
    private float strokeCenterX;
    private float strokeCenterY;
    private int[] strokeColorSweep;
    private SweepGradient strokeGradient;
    private Paint strokePaint;
    private int strokeWidth;

    private void initStokePaint() {
        Paint r100 = new Paint();
        this.strokePaint = r100;
        r100.setAntiAlias(true);
        this.strokePaint.setDither(true);
        this.strokePaint.setFilterBitmap(true);
        this.strokePaint.setStyle(Paint.Style.STROKE);
        this.strokePaint.setStrokeCap(Paint.Cap.ROUND);
        this.strokePaint.setStrokeWidth(this.strokeWidth);
        this.strokePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    }

    @Override // com.dtf.face.ui.widget.CircleHoleView
    public Bitmap createMask1() {
        Bitmap r100 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r101 = new Canvas(r100);
        Paint r102 = new Paint(1);
        r102.setAntiAlias(true);
        r102.setColor(-1);
        float r103 = getWidth();
        float r104 = getHeight();
        float r105 = this.leftAttr;
        float r106 = 0.0f;
        if (r105 > (-1.0f)) goto L7;
        r105 = 0.0f;
    L7:
        if (this.holeHCenter == false) goto L11;
        r105 = (r103 / 2.0f) - (this.widthAttr / 2.0f);
        if (r105 >= 0.0f) goto L11;
    L12:
        float r107 = this.strokeWidth / 2;
        if (r106 >= r107) goto L15;
        r106 = r107;
    L15:
        float r108 = (r104 / 2.0f) - (this.heightAttr / 2.0f);
        if (r108 >= r107) goto L18;
        r108 = r107;
    L18:
        float r109 = this.widthAttr;
        if (r109 <= (-1.0f)) goto L21;
        float r110 = r106 + r109;
    L22:
        float r111 = this.ratio * r109;
        this.heightAttr = r111;
        float r112 = r103 + r108;
        if (r111 <= (-1.0f)) goto L26;
        r112 = r108 + r111;
    L26:
        if ((r107 + r112) <= getHeight()) goto L28;
        r112 = getHeight() - (this.strokeWidth / 2);
    L28:
        RectF r113 = new RectF(r106, r108, r110, r112);
        this.holeRectF = r113;
        r101.drawOval(r113, r102);
        return r100;
    L21:
        r110 = r103;
    L11:
        r106 = r105;
        goto L12
    }

    public float getHeightAttr() {
        return this.heightAttr;
    }

    public float getWidthAttr() {
        return this.widthAttr;
    }

    @Override // com.dtf.face.ui.widget.CircleHoleView
    public void drawStroke(Canvas r110) {
        RectF r100 = this.holeRectF;
        if (r100 != null) goto L5;
        return;
    L5:
        float r101 = r100.left;
        float r102 = this.strokeWidth / 2;
        float r103 = r101 - r102;
        float r104 = r100.top;
        float r105 = r104 - r102;
        float r106 = r100.right;
        float r107 = r106 + r102;
        float r108 = r100.bottom;
        float r109 = r102 + r108;
        float r111 = (r101 + r106) / 2.0f;
        if (this.strokeCenterX == r111) goto L8;
    L9:
        this.strokeCenterX = r111;
        this.strokeCenterY = (r104 + r108) / 2.0f;
        this.strokeGradient = new SweepGradient(this.strokeCenterX, this.strokeCenterY, this.strokeColorSweep, null);
    L11:
        if (this.strokeGradient != null) goto L13;
        return;
    L13:
        Matrix r112 = new Matrix();
        r112.setRotate(this.startAngle % 360, this.strokeCenterX, this.strokeCenterY);
        this.strokeGradient.setLocalMatrix(r112);
        this.strokePaint.setShader(this.strokeGradient);
        r110.drawArc(new RectF(r103, r105, r107, r109), (this.startAngle + 2) % 360, 360.0f, false, this.strokePaint);
        this.startAngle++;
        postInvalidateDelayed(0);
        return;
    L8:
        if (this.strokeCenterY == ((r104 + r108) / 2.0f)) goto L11;
        goto L9
    }

    public void setRatio(float r100) {
        this.ratio = r100;
    }

    @Override // com.dtf.face.ui.widget.CircleHoleView
    public CircleHoleView setWidthAttr(float r100) {
        this.widthAttr = r100 - this.strokeWidth;
        return this;
    }

    public NearFarHoleView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.ratio = 1.0f;
        this.strokeWidth = 0;
        this.startAngle = 1;
        this.strokeColorSweep = new int[2];
        this.strokeCenterX = 0.0f;
        this.strokeCenterY = 0.0f;
        initStokePaint();
    }

    public void setStokeStyle(int r100, int r101, int r102) {
        this.strokeWidth = r100;
        int[] r103 = this.strokeColorSweep;
        r103[0] = r102;
        r103[1] = r101;
        this.strokePaint.setColor(r101);
        this.strokePaint.setStrokeWidth(r100);
    }
}
