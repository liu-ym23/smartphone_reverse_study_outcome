package com.bytedance.ee.bear.bitable.fieldedit.view.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public class GradientOffsetView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f211720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f211721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f211722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f211723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f211724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f211725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f211726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f211727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearGradient f211728i;

    public final void a() {
        LinearGradient r100 = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f211721b, this.f211722c, Shader.TileMode.CLAMP);
        this.f211728i = r100;
        this.f211720a.setShader(r100);
        postInvalidate();
    }

    public int[] getColors() {
        return this.f211721b;
    }

    public float[] getOffsets() {
        return this.f211722c;
    }

    public GradientOffsetView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.f211728i == null) goto L6;
        float r101 = getWidth() / 2.0f;
        r100.drawCircle(r101, getHeight() / 2.0f, r101, this.f211720a);
        return;
    }

    public GradientOffsetView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public GradientOffsetView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f211723d = -1;
        this.f211724e = -1;
        this.f211725f = 1;
        this.f211726g = -1;
        this.f211727h = false;
        this.f211720a = new Paint(1);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.f211723d = r101;
        this.f211724e = r102;
        this.f211725f = r103;
        this.f211726g = r104;
        if (r101 == (-1)) goto L8;
        if (r102 == (-1)) goto L8;
        if (r103 == (-1)) goto L8;
        if (r104 == (-1)) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L11;
        return;
    L11:
        if (this.f211727h == false) goto L15;
        a();
        this.f211727h = false;
        return;
    L15:
        return;
    L8:
        r105 = false;
        goto L9
    }
}
