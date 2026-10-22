package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ClipView;", "Landroid/view/View;", "Lkotlin/Triple;", "Landroid/graphics/Path;", "", "", "getArcLine", "Landroid/graphics/Paint;", "a", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint", "i", "F", "getRadius", "()F", "radius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClipView extends View {
    public final Paint a;
    public final Paint b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;

    public static final class a {
        public final float a;
        public final float b;
        public final float c;

        public final float[] a(float r7) {
            float r0 = r7 - this.b;
            float r1 = Math.abs(r0);
            float r2 = this.c;
            if (r1 <= r2) goto L6;
            ECExceptionMonitor.e(new IllegalArgumentException("y: " + r7 + " out of circle"));
            float r3 = this.a;
            return new float[]{r3, r3};
        L6:
            float r8 = (float) Math.sqrt((r2 * r2) - (r0 * r0));
            float r4 = this.a;
            return new float[]{r4 - r8, r4 + r8};
        }

        public a(float r1, float r2, float r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    private final Triple<Path, float[], Float> getArcLine() {
        if ((this.e - this.f) != this.c) goto L6;
        Path r1 = new Path();
        r1.moveTo(this.d - this.f, this.c);
        r1.lineTo(this.d + this.f, this.c);
        Unit r2 = Unit.INSTANCE;
        float r3 = this.d;
        float r6 = this.f;
        float r4 = r3 + r6;
        return new Triple(r1, new float[]{r3 - r6, r4}, Float.valueOf(r4));
    L6:
        Path r5 = new Path();
        r5.moveTo(this.g, this.c);
        float r7 = this.d;
        float r8 = this.e;
        float r9 = this.f;
        a r10 = new a(r7, r8, r9);
        float[] r11 = r10.a(this.c);
        float[] r12 = r10.a(this.h);
        float r13 = r11[0];
        float r14 = this.c;
        float r15 = -1;
        float r16 = r15 / ((r8 - r14) / (r7 - r13));
        float r17 = r11[1];
        float r18 = r15 / ((r8 - r14) / (r7 - r17));
        r5.moveTo(this.g, r14);
        float r19 = this.c;
        r5.quadTo((r19 - (r14 - (r13 * r16))) / r16, r19, r12[0], this.h);
        PointF r110 = new PointF(r12[0], this.h);
        Intrinsics.checkNotNullParameter(r110, "point");
        float r20 = (float) ((((double) ((float) Math.atan((r110.y - r8) / (r110.x - r7)))) / 6.283185307179586d) * ((double) 360));
        r5.addArc(new RectF(r7 - r9, r8 - r9, r7 + r9, r8 + r9), 180 + r20, (90 - r20) * 2);
        float r21 = (r7 - this.g) + r7;
        r5.moveTo(r21, this.c);
        float r22 = this.c;
        r5.quadTo((r22 - (r14 - (r17 * r18))) / r18, r22, r12[1], this.h);
        return new Triple(r5, r12, Float.valueOf(r21));
    }

    public final Paint getPaint() {
        return this.a;
    }

    public final float getRadius() {
        return this.i;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.onDraw(r13);
        Triple<Path, float[], Float> r1 = getArcLine();
        Path r2 = (Path) r1.component1();
        float[] r3 = (float[]) r1.component2();
        float r4 = ((Number) r1.component3()).floatValue();
        Path r5 = new Path();
        r5.moveTo(this.g, this.c);
        r5.lineTo(r3[0], this.h);
        r5.lineTo(r3[0], this.c);
        r5.lineTo(this.g, this.c);
        Path r6 = new Path();
        r6.moveTo(r4, this.c);
        r6.lineTo(r3[1], this.h);
        r6.lineTo(r3[1], this.c);
        r6.lineTo(r4, this.c);
        Path r7 = new Path();
        r7.moveTo(r3[0], this.h);
        r7.lineTo(r3[1], this.h);
        r7.lineTo(r3[1], this.c);
        r7.lineTo(r3[0], this.c);
        r7.lineTo(r3[0], this.h);
        Path r8 = new Path();
        r8.addPath(r2);
        r8.addPath(r5);
        r8.addPath(r6);
        r8.addPath(r7);
        r13.drawPath(r8, this.b);
        r13.drawPath(r2, this.a);
        float r9 = getWidth();
        float r10 = getHeight();
        float r11 = this.c;
        Path r12 = new Path();
        r12.moveTo(this.i, r11);
        float r14 = 2;
        float r15 = this.i * r14;
        r12.arcTo(new RectF(0.0f, r11, r15, r15 + r11), 270.0f, -90.0f, true);
        r12.lineTo(0.0f, r10 - this.i);
        float r16 = this.i * r14;
        r12.arcTo(new RectF(0.0f, r10 - r16, r16, r10), 180.0f, -90.0f, true);
        r12.lineTo(r9 - this.i, r10);
        float r17 = this.i * r14;
        r12.arcTo(new RectF(r9 - r17, r10 - r17, r9, r10), 90.0f, -90.0f, true);
        r12.lineTo(r9, this.i + r11);
        float r18 = this.i * r14;
        r12.arcTo(new RectF(r9 - r18, r11, r9, r18 + r11), 0.0f, -90.0f, true);
        r12.lineTo(this.i, r11);
        r13.drawPath(r12, this.a);
        float r19 = this.i;
        Paint r20 = this.b;
        int r21 = com.bytedance.android.ec.window.base.utils.c.a;
        Intrinsics.checkNotNullParameter(r13, "$this$drawRoundRectCompat");
        Intrinsics.checkNotNullParameter(r20, "paint");
        r13.drawRoundRect(0.0f, r11, r9, r10, r19, r19, r20);
    }

    public ClipView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "attrs");
        super(r4, r5);
        Paint r6 = new Paint();
        r6.setStyle(Paint.Style.STROKE);
        r6.setColor(-1);
        r6.setAntiAlias(true);
        r6.setStrokeWidth(r4.getResources().getDimension(2131165372));
        Unit r7 = Unit.INSTANCE;
        this.a = r6;
        Paint r8 = new Paint();
        r8.setStyle(Paint.Style.FILL);
        r8.setAntiAlias(true);
        r8.setColor(-1);
        this.b = r8;
        float r9 = com.bytedance.android.shopping.extensions.b.b(18);
        this.c = r9;
        float r10 = com.bytedance.android.shopping.extensions.b.b(53);
        this.d = r10;
        float r1 = com.bytedance.android.shopping.extensions.b.b(38);
        this.e = r1;
        float r0 = com.bytedance.android.shopping.extensions.b.b(38);
        this.f = r0;
        this.g = r10 - r0;
        this.h = r9 - ((r9 - (r1 - r0)) * 0.25f);
        this.i = com.bytedance.android.shopping.extensions.b.b(12);
    }
}
