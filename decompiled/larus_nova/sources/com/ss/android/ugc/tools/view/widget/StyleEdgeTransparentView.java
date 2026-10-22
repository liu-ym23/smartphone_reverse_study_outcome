package com.ss.android.ugc.tools.view.widget;

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
import com.larus.nova.R;
import com.ss.android.ugc.tools.utils.i;

/* JADX INFO: loaded from: classes40.dex */
public class StyleEdgeTransparentView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f455067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f455068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f455069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f455070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f455071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f455072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f455073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f455074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f455075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f455076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f455077k;

    public StyleEdgeTransparentView(Context r100) {
        this(r100, null);
    }

    public void setDrawSize(float r110) {
        this.f455069c = r110;
        this.f455067a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f455069c, this.f455076j, this.f455077k, Shader.TileMode.CLAMP));
        invalidate();
    }

    public StyleEdgeTransparentView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public StyleEdgeTransparentView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f455070d = 1;
        this.f455071e = 1 << 1;
        this.f455072f = 1 << 2;
        this.f455073g = 1 << 3;
        this.f455076j = new int[]{-1, 0};
        this.f455077k = new float[]{0.0f, 1.0f};
        Paint r103 = new Paint(1);
        this.f455067a = r103;
        r103.setStyle(Paint.Style.FILL);
        this.f455067a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.style_edge_position, R.attr.style_edge_width});
        this.f455068b = r104.getInt(0, 0);
        this.f455069c = r104.getDimension(1, i.a(getContext(), 20.0f));
        r104.recycle();
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r110, View r111, long r112) {
        int r100 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        boolean r113 = super.drawChild(r110, r111, r112);
        int r114 = this.f455068b;
        if (r114 != 0) goto L5;
    L6:
        r110.drawRect(0.0f, -3.0f, this.f455074h, this.f455069c, this.f455067a);
    L7:
        int r115 = this.f455068b;
        if (r115 != 0) goto L10;
    L11:
        int r116 = r110.save();
        r110.rotate(180.0f, this.f455074h / 2, this.f455075i / 2);
        r110.drawRect(0.0f, -3.0f, this.f455074h, this.f455069c, this.f455067a);
        r110.restoreToCount(r116);
    L12:
        int r117 = (this.f455075i - this.f455074h) / 2;
        int r118 = this.f455068b;
        if (r118 != 0) goto L15;
    L16:
        int r119 = r110.save();
        r110.rotate(90.0f, this.f455074h / 2, this.f455075i / 2);
        r110.translate(0.0f, r117);
        r110.drawRect(0 - r117, -3.0f, this.f455074h + r117, this.f455069c, this.f455067a);
        r110.restoreToCount(r119);
    L17:
        int r120 = this.f455068b;
        if (r120 != 0) goto L20;
    L21:
        int r121 = r110.save();
        r110.rotate(270.0f, this.f455074h / 2, this.f455075i / 2);
        r110.translate(0.0f, r117);
        r110.drawRect(0 - r117, -3.0f, this.f455074h + r117, this.f455069c, this.f455067a);
        r110.restoreToCount(r121);
    L22:
        r110.restoreToCount(r100);
        return r113;
    L20:
        if ((r120 & this.f455073g) == 0) goto L22;
    L15:
        if ((r118 & this.f455072f) == 0) goto L17;
    L10:
        if ((r115 & this.f455071e) == 0) goto L12;
    L5:
        if ((r114 & this.f455070d) == 0) goto L7;
        goto L6
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        this.f455067a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f455069c, this.f455076j, this.f455077k, Shader.TileMode.CLAMP));
        this.f455074h = getWidth();
        this.f455075i = getHeight();
    }
}
