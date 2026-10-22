package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public class StyleEdgeTransparentView2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f195282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f195283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f195284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f195285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f195286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f195287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f195288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f195289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f195290i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f195291j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f195292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f195293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int[] f195294m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float[] f195295n;

    public StyleEdgeTransparentView2(Context r100) {
        this(r100, null);
    }

    public void setDrawSize(float r100) {
        this.f195284c = r100;
        invalidate();
    }

    public void setLeftDrawSize(float r100) {
        this.f195285d = r100;
        invalidate();
    }

    public void setRightDrawSize(float r100) {
        this.f195286e = r100;
        invalidate();
    }

    public StyleEdgeTransparentView2(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public StyleEdgeTransparentView2(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f195287f = 1;
        this.f195288g = 1 << 1;
        this.f195289h = 1 << 2;
        this.f195290i = 1 << 3;
        this.f195291j = 1 << 4;
        this.f195294m = new int[]{-1, 0};
        this.f195295n = new float[]{0.0f, 1.0f};
        Paint r103 = new Paint(1);
        this.f195282a = r103;
        r103.setStyle(Paint.Style.FILL);
        this.f195282a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.style_edge_position, R.attr.style_edge_width});
        this.f195283b = r104.getInt(0, 0);
        this.f195284c = r104.getDimension(1, n0.a(getContext(), 0.0f));
        r104.recycle();
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r210, View r211, long r212) {
        if ((this.f195283b & this.f195291j) != 0) goto L5;
        int r100 = r210.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        boolean r101 = super.drawChild(r210, r211, r212);
        int r102 = this.f195283b;
        if (r102 != 0) goto L9;
    L10:
        r210.drawRect(0.0f, -3.0f, this.f195292k, this.f195284c, this.f195282a);
    L11:
        int r103 = this.f195283b;
        if (r103 != 0) goto L14;
    L15:
        int r110 = r210.save();
        r210.rotate(180.0f, this.f195292k / 2, this.f195293l / 2);
        r210.drawRect(0.0f, -3.0f, this.f195292k, this.f195284c, this.f195282a);
        r210.restoreToCount(r110);
    L16:
        int r111 = (this.f195293l - this.f195292k) / 2;
        int r104 = this.f195283b;
        if (r104 != 0) goto L19;
    L20:
        int r112 = r210.save();
        r210.rotate(90.0f, this.f195292k / 2, this.f195293l / 2);
        r210.translate(0.0f, r111);
        float r105 = this.f195284c;
        float r106 = this.f195286e;
        if (r106 <= 0.0f) goto L23;
        this.f195282a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r106, this.f195294m, this.f195295n, Shader.TileMode.CLAMP));
        float r107 = r106;
    L24:
        r210.drawRect(0 - r111, -3.0f, this.f195292k + r111, r107, this.f195282a);
        r210.restoreToCount(r112);
    L25:
        int r108 = this.f195283b;
        if (r108 != 0) goto L28;
    L29:
        int r113 = r210.save();
        r210.rotate(270.0f, this.f195292k / 2, this.f195293l / 2);
        r210.translate(0.0f, r111);
        float r109 = this.f195284c;
        float r114 = this.f195285d;
        if (r114 <= 0.0f) goto L32;
        this.f195282a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r114, this.f195294m, this.f195295n, Shader.TileMode.CLAMP));
        float r115 = r114;
    L33:
        r210.drawRect(0 - r111, -3.0f, this.f195292k + r111, r115, this.f195282a);
        r210.restoreToCount(r113);
    L34:
        r210.restoreToCount(r100);
        return r101;
    L32:
        r115 = r109;
        goto L33
    L28:
        if ((r108 & this.f195290i) == 0) goto L34;
    L23:
        r107 = r105;
        goto L24
    L19:
        if ((r104 & this.f195289h) == 0) goto L25;
    L14:
        if ((r103 & this.f195288g) == 0) goto L16;
    L9:
        if ((r102 & this.f195287f) == 0) goto L11;
    L5:
        return super.drawChild(r210, r211, r212);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        this.f195282a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f195284c, this.f195294m, this.f195295n, Shader.TileMode.CLAMP));
        this.f195292k = getWidth();
        this.f195293l = getHeight();
    }
}
