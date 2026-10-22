package com.ss.android.lark.cameraview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class a1 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f410859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f410860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f410861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f410862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f410863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f410864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f410865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f410866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f410867j;

    public a1(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f410858a != 1) goto L6;
        this.f410863f.setAntiAlias(true);
        this.f410863f.setColor(-287515428);
        this.f410863f.setStyle(Paint.Style.FILL);
        r110.drawCircle(this.f410860c, this.f410861d, this.f410862e, this.f410863f);
        this.f410863f.setColor(-15260619);
        this.f410863f.setStyle(Paint.Style.STROKE);
        this.f410863f.setStrokeWidth(this.f410865h);
        Path r100 = this.f410864g;
        float r101 = this.f410860c;
        float r102 = this.f410866i;
        r100.moveTo(r101 - (r102 / 2.0f), this.f410861d + r102);
        Path r103 = this.f410864g;
        float r104 = this.f410860c;
        float r105 = this.f410866i;
        r103.lineTo(r104 + r105, this.f410861d + r105);
        this.f410864g.arcTo(this.f410867j, 90.0f, -180.0f);
        Path r106 = this.f410864g;
        float r107 = this.f410860c;
        float r108 = this.f410866i;
        r106.lineTo(r107 - r108, this.f410861d - r108);
        r110.drawPath(this.f410864g, this.f410863f);
        this.f410863f.setStyle(Paint.Style.FILL);
        this.f410864g.reset();
        Path r109 = this.f410864g;
        float r111 = this.f410860c;
        float r112 = this.f410866i;
        r109.moveTo(r111 - r112, (float) (((double) this.f410861d) - (((double) r112) * 1.5d)));
        Path r113 = this.f410864g;
        float r114 = this.f410860c;
        float r115 = this.f410866i;
        r113.lineTo(r114 - r115, (float) (((double) this.f410861d) - (((double) r115) / 2.3d)));
        Path r116 = this.f410864g;
        double r117 = this.f410860c;
        float r118 = this.f410866i;
        r116.lineTo((float) (r117 - (((double) r118) * 1.6d)), this.f410861d - r118);
        this.f410864g.close();
        r110.drawPath(this.f410864g, this.f410863f);
    L6:
        if (this.f410858a != 2) goto L9;
        this.f410863f.setAntiAlias(true);
        this.f410863f.setColor(-1);
        this.f410863f.setStyle(Paint.Style.FILL);
        r110.drawCircle(this.f410860c, this.f410861d, this.f410862e, this.f410863f);
        this.f410863f.setAntiAlias(true);
        this.f410863f.setStyle(Paint.Style.STROKE);
        this.f410863f.setColor(-12024330);
        this.f410863f.setStrokeWidth(this.f410865h);
        this.f410864g.moveTo(this.f410860c - (this.f410859b / 6.0f), this.f410861d);
        Path r119 = this.f410864g;
        float r120 = this.f410860c;
        int r121 = this.f410859b;
        r119.lineTo(r120 - (r121 / 21.2f), this.f410861d + (r121 / 7.7f));
        Path r122 = this.f410864g;
        float r123 = this.f410860c;
        int r124 = this.f410859b;
        r122.lineTo(r123 + (r124 / 4.0f), this.f410861d - (r124 / 8.5f));
        Path r125 = this.f410864g;
        float r126 = this.f410860c;
        int r127 = this.f410859b;
        r125.lineTo(r126 - (r127 / 21.2f), this.f410861d + (r127 / 9.4f));
        this.f410864g.close();
        r110.drawPath(this.f410864g, this.f410863f);
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = this.f410859b;
        setMeasuredDimension(r102, r102);
    }

    public a1(Context r100, int r101, int r102) {
        super(r100);
        this.f410858a = r101;
        this.f410859b = r102;
        float r103 = r102;
        float r104 = r103 / 2.0f;
        this.f410862e = r104;
        this.f410860c = r104;
        this.f410861d = r104;
        this.f410863f = new Paint();
        this.f410864g = new Path();
        this.f410865h = r103 / 50.0f;
        float r105 = r102 / 12.0f;
        this.f410866i = r105;
        this.f410867j = new RectF(r104, r104 - r105, (2.0f * r105) + r104, r105 + r104);
    }
}
