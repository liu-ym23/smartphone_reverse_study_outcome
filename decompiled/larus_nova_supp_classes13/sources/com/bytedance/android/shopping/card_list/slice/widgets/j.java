package com.bytedance.android.shopping.card_list.slice.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ProgressBar;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends ProgressBar {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public Paint j;
    public Paint k;
    public Paint l;
    public Paint m;
    public Paint n;
    public int o;
    public final SlcTemplateContext p;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Paint r0 = new Paint();
        r0.setColor(this.c);
        r0.setStyle(Paint.Style.STROKE);
        r0.setAntiAlias(true);
        r0.setStrokeWidth(this.a);
        Unit r2 = Unit.INSTANCE;
        this.j = r0;
        Paint r1 = new Paint();
        r1.setColor(this.h);
        r1.setStyle(Paint.Style.STROKE);
        r1.setStrokeWidth(this.g);
        r1.setAntiAlias(true);
        this.l = r1;
        Paint r3 = new Paint();
        r3.setColor(ColorProtector.parseColor("#FFFFFFFF"));
        r3.setStyle(Paint.Style.FILL);
        r3.setAntiAlias(true);
        this.m = r3;
        Paint r4 = new Paint();
        r4.setColor(this.f);
        r4.setStyle(Paint.Style.STROKE);
        r4.setAntiAlias(true);
        r4.setStrokeWidth(this.b);
        this.n = r4;
        Paint r5 = new Paint();
        r5.setStyle(Paint.Style.STROKE);
        r5.setAntiAlias(true);
        r5.setStrokeWidth(this.b);
        this.k = r5;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putParcelable("state", super.onSaveInstanceState());
        r0.putInt("circle_ring_color", this.h);
        r0.putInt("circle_ring_width", this.g);
        r0.putInt("circle_ring_radius", this.i);
        r0.putInt("lt_gradient_color", this.d);
        r0.putInt("rb_gradient_color", this.e);
        r0.putInt("reach_bar_size", this.b);
        r0.putInt("reach_bar_bg_color", this.f);
        r0.putInt("normal_bar_color", this.c);
        r0.putInt("normal_bar_height", this.a);
        return r0;
    }

    public final SlcTemplateContext getSlcTemplateContext() {
        return this.p;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDraw(Canvas r24) {
        Intrinsics.checkNotNullParameter(r24, "canvas");
        r24.save();
        r24.translate(getPaddingLeft(), getHeight() / 2);
        int r1 = this.i * 2;
        float r2 = (getProgress() * 1.0f) / getMax();
        int r3 = this.o;
        float r4 = r3 - r1;
        float r5 = r2 * r4;
        float r9 = r1;
        if ((r5 + r9) < r3) goto L5;
        float r20 = r4;
        boolean r21 = false;
    L6:
        float r6 = 0;
        if (r20 >= r6) goto L9;
    L26:
        if (r21 == false) goto L30;
        float r7 = r20 + r9;
        Paint r8 = this.j;
        if (r8 == null) goto L30;
        r24.drawLine(r7, 0.0f, this.o, 0.0f, r8);
    L30:
        r24.restore();
        return;
    L9:
        if (r20 <= r6) goto L19;
        Paint r10 = this.n;
        if (r10 == null) goto L13;
        r24.drawLine(0.0f, 0.0f, r20, 0.0f, r10);
    L13:
        int r11 = this.b;
        float r12 = 0.0f;
        LinearGradient r13 = new LinearGradient(0.0f, (-r11) / 2.0f, r20, r11 / 2.0f, CollectionsKt.toIntArray(CollectionsKt.listOf(new Integer[]{Integer.valueOf(this.d), Integer.valueOf(this.e)})), CollectionsKt.toFloatArray(CollectionsKt.listOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.66f)})), Shader.TileMode.CLAMP);
        Paint r14 = this.k;
        if (r14 == null) goto L16;
        r14.setShader(r13);
    L16:
        Paint r15 = this.k;
        if (r15 == null) goto L20;
        r24.drawLine(0.0f, 0.0f, r20, 0.0f, r15);
    L20:
        Paint r16 = this.m;
        if (r16 == null) goto L23;
        r24.drawCircle(r20 + (r9 / 2.0f), r12, this.i, r16);
    L23:
        Paint r17 = this.l;
        if (r17 == null) goto L26;
        r24.drawCircle(r20 + (r9 / 2.0f), r12, this.i - (this.g / 2.0f), r17);
        goto L26
    L19:
        r12 = 0.0f;
        goto L20
    L5:
        r20 = r5;
        r21 = true;
        goto L6
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onRestoreInstanceState(Parcelable r4) {
        if ((r4 instanceof Bundle) == false) goto L6;
        Bundle r5 = (Bundle) r4;
        this.h = r5.getInt("circle_ring_color");
        this.g = r5.getInt("circle_ring_width");
        this.i = r5.getInt("circle_ring_radius");
        this.d = r5.getInt("lt_gradient_color");
        this.e = r5.getInt("rb_gradient_color");
        this.b = r5.getInt("reach_bar_size");
        this.f = r5.getInt("reach_bar_bg_color");
        this.c = r5.getInt("normal_bar_color");
        this.a = r5.getInt("normal_bar_height");
        CollectionsKt.listOf(new Integer[]{Integer.valueOf(this.d), Integer.valueOf(this.e)});
        a();
        super.onRestoreInstanceState(r5.getParcelable("state"));
        return;
    L6:
        super.onRestoreInstanceState(r4);
    }

    public j(Context r3, SlcTemplateContext r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "slcTemplateContext");
        super(r3, null, 0);
        this.p = r4;
        this.a = SlcDimensExtensionsKt.a(4, r4.m());
        this.b = Math.round(SlcDimensExtensionsKt.c(4, r4.m()));
        this.g = SlcDimensExtensionsKt.a(2, r4.m());
        this.i = SlcDimensExtensionsKt.a(Double.valueOf(4.5d), r4.m());
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onMeasure(int r4, int r5) {
        int r6 = View.MeasureSpec.getSize(r4);
        int r0 = this.i * 2;
        setMeasuredDimension(r6, ProgressBar.resolveSize((Math.max(Math.max(this.a, this.b), r0) + getPaddingTop()) + getPaddingBottom(), r5));
        this.o = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }
}
