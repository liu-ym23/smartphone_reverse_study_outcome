package com.larus.common_ui.dbx.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f327021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f327022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f327023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f327024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f327025e;

    public final void a() {
        if (this.f327024d == true) goto L5;
    L19:
        ValueAnimator r100 = this.f327023c;
        if (r100 == null) goto L22;
        r100.cancel();
    L22:
        this.f327023c = null;
        return;
    L5:
        if (isAttachedToWindow() == false) goto L19;
        if (isShown() == false) goto L19;
        if (getWindowVisibility() != 0) goto L19;
        ValueAnimator r101 = this.f327023c;
        if (r101 == null) goto L15;
        boolean r102 = true;
        if (r101.isRunning() != true) goto L15;
    L16:
        if (r102 == true) goto L25;
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        r103.setDuration(1000);
        r103.setRepeatCount(-1);
        r103.setInterpolator(new LinearInterpolator());
        r103.addUpdateListener(new a(this));
        r103.start();
        this.f327023c = r103;
        return;
    L25:
        return;
    L15:
        r102 = false;
        goto L16
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator r100 = this.f327023c;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f327023c = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    public final int getRingColor() {
        return this.f327025e;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Paint r101 = new Paint(1);
        r101.setStyle(Paint.Style.STROKE);
        r101.setStrokeCap(Paint.Cap.ROUND);
        this.f327021a = r101;
        this.f327022b = new RectF();
        this.f327025e = -16777216;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        float r100 = Math.min(getWidth(), getHeight());
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        float r101 = 0.12f * r100;
        this.f327021a.setStrokeWidth(r101);
        float r102 = getWidth() / 2.0f;
        float r103 = getHeight() / 2.0f;
        this.f327021a.setShader(new SweepGradient(r102, r103, new int[]{this.f327025e & 16777215, this.f327025e}, new float[]{0.0f, 1.0f}));
        float r104 = (r100 - r101) / 2.0f;
        this.f327022b.set(r102 - r104, r103 - r104, r102 + r104, r103 + r104);
        r110.drawArc(this.f327022b, 0.0f, 360.0f, false, this.f327021a);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        a();
    }

    public final void setRingColor(int r100) {
        this.f327025e = r100;
        invalidate();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        a();
    }
}
