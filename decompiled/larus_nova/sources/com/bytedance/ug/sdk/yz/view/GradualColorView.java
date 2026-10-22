package com.bytedance.ug.sdk.yz.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes22.dex */
public class GradualColorView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f272372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f272373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f272374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f272375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f272376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f272377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f272378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f272379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearGradient f272380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f272381j;

    public GradualColorView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        this.f272381j.setShader(this.f272380i);
        RectF r101 = this.f272379h;
        if (r101 == null) goto L6;
        float r102 = this.f272378g;
        r100.drawRoundRect(r101, r102, r102, this.f272381j);
        return;
    }

    public void setColors(int[] r100) {
        this.f272377f = r100;
    }

    public GradualColorView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public GradualColorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f272372a = 0;
        this.f272373b = 0;
        this.f272374c = 0;
        this.f272375d = 0;
        this.f272376e = false;
        Paint r103 = new Paint(1);
        this.f272381j = r103;
        if (r101 == null) goto L5;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.GradientColorAfterStart, R.attr.GradientColorBeforeEnd, R.attr.GradientColorEnd, R.attr.GradientColorStart, R.attr.GradientColorVertical, R.attr.GradientRound});
        this.f272372a = r104.getColor(3, 0);
        this.f272373b = r104.getColor(2, 0);
        this.f272374c = r104.getColor(0, 0);
        this.f272375d = r104.getColor(1, 0);
        this.f272376e = r104.getBoolean(4, false);
        Resources r105 = getContext().getResources();
        this.f272378g = r104.getDimension(5, (int) ((10.0f * WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density) + 0.5f));
    L5:
        r103.setAntiAlias(true);
        r103.setDither(true);
        r103.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r110, int r111, int r112, int r113) {
        super.onSizeChanged(r110, r111, r112, r113);
        float r100 = r110;
        float r114 = r111;
        this.f272379h = new RectF(0.0f, 0.0f, r100, r114);
        int[] r101 = this.f272377f;
        if (r101 != null) goto L5;
    L6:
        r101 = new int[]{this.f272372a, this.f272374c, this.f272375d, this.f272373b};
    L7:
        int[] r115 = r101;
        if (this.f272376e == false) goto L10;
        this.f272380i = new LinearGradient(0.0f, 0.0f, 0.0f, r114, r115, null, Shader.TileMode.CLAMP);
        return;
    L10:
        this.f272380i = new LinearGradient(0.0f, 0.0f, r100, 0.0f, r115, null, Shader.TileMode.CLAMP);
        return;
    L5:
        if (r101.length != 0) goto L7;
        goto L6
    }
}
