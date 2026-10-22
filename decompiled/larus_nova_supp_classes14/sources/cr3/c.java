package cr3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends Drawable implements Drawable.Callback {
    public final Paint a;
    public final int b;
    public final PointF c;
    public final PointF d;
    public final PointF e;
    public final PointF f;
    public final PointF g;
    public final PointF h;
    public final PointF i;
    public final int j;
    public final int k;
    public final PathMeasure l;
    public final Path m;
    public final Path n;
    public final int o;
    public final float p;
    public final Function0<b> q;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 255 - this.a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r27) {
        Intrinsics.checkNotNullParameter(r27, "canvas");
        Rect r2 = getBounds();
        b r3 = (b) this.q.invoke();
        int r4 = r2.centerX();
        Float r6 = null;
        if (b.a(r4, r3.a, r3.d) == false) goto L6;
        Integer r5 = r3.d;
    L12:
        if (r5 == null) goto L30;
        int r7 = r5.intValue();
        int r8 = r2.centerX();
        if (b.a(r8, r3.a, r3.d) == false) goto L17;
        r6 = r3.a;
    L22:
        if (r6 == null) goto L31;
        float r9 = r6.floatValue();
        float r10 = (r2.centerX() - r9) / r7;
        float r11 = r9 + (r7 / 2);
        int r12 = (int) (r11 - (r2.width() / 2));
        int r13 = (int) (r11 + (r2.width() / 2));
        int r14 = r2.bottom;
        r2.offset(0, -((int) this.p));
        float r15 = (r13 - r12) / this.b;
        this.m.reset();
        Path r16 = this.m;
        PointF r17 = this.c;
        r16.moveTo(r17.x * r15, r17.y * r15);
        Path r18 = this.m;
        PointF r19 = this.d;
        float r110 = r19.x * r15;
        float r111 = r19.y * r15;
        PointF r20 = this.e;
        float r112 = r20.x * r15;
        float r113 = r20.y * r15;
        PointF r21 = this.f;
        r18.cubicTo(r110, r111, r112, r113, r21.x * r15, r21.y * r15);
        Path r22 = this.m;
        PointF r114 = this.g;
        float r23 = r114.x * r15;
        float r24 = r114.y * r15;
        PointF r115 = this.h;
        float r25 = r115.x * r15;
        float r26 = r115.y * r15;
        PointF r116 = this.i;
        r22.cubicTo(r23, r24, r25, r26, r116.x * r15, r116.y * r15);
        float r117 = r12;
        this.m.offset(r117, r2.top);
        float r118 = r14;
        this.a.setShader(new LinearGradient(r117, r118, (r13 + r117) - r117, r118, this.j, this.k, Shader.TileMode.CLAMP));
        this.l.setPath(this.m, false);
        float r28 = RangesKt.coerceAtLeast((r10 - 0.5f) / 0.5f, 0.0f);
        float r29 = RangesKt.coerceAtMost(r10 / 0.5f, 1.0f);
        if (r29 <= r28) goto L33;
        this.n.reset();
        PathMeasure r30 = this.l;
        if (r30.getSegment(r30.getLength() * r28, this.l.getLength() * r29, this.n, true) == false) goto L32;
        r27.drawPath(this.n, this.a);
        return;
    L32:
        return;
    L33:
        return;
    L31:
        return;
    L17:
        if (b.a(r8, r3.b, r3.e) == false) goto L20;
        r6 = r3.b;
        goto L22
    L20:
        if (b.a(r8, r3.c, r3.f) == false) goto L22;
        r6 = r3.c;
        goto L22
    L30:
        return;
    L6:
        if (b.a(r4, r3.b, r3.e) == false) goto L9;
        r5 = r3.e;
        goto L12
    L9:
        if (b.a(r4, r3.c, r3.f) == false) goto L11;
        r5 = r3.f;
        goto L12
    L11:
        r5 = null;
        goto L12
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "who");
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r5) {
        Intrinsics.checkNotNullParameter(r5, "bounds");
        if (r5.width() <= 0) goto L5;
        int r0 = (r5.left + r5.right) / 2;
        int r1 = this.o;
        r5.set(r0 - (r1 / 2), r5.top, r0 + (r1 / 2), r5.bottom);
    L5:
        r5.bottom = r5.top + 20;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r2, Runnable r3) {
        Intrinsics.checkNotNullParameter(r2, "who");
        Intrinsics.checkNotNullParameter(r3, "what");
        unscheduleSelf(r3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r2, Runnable r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "who");
        Intrinsics.checkNotNullParameter(r3, "what");
        scheduleSelf(r3, r4);
    }

    public c(int r2, float r3, float r4, Function0<b> r5) {
        Intrinsics.checkNotNullParameter(r5, "tabScrollStateProvider");
        this.o = r2;
        this.p = r4;
        this.q = r5;
        Paint r6 = new Paint();
        r6.setAntiAlias(true);
        r6.setStrokeCap(Paint.Cap.ROUND);
        r6.setStyle(Paint.Style.STROKE);
        r6.setStrokeWidth(r3);
        Unit r7 = Unit.INSTANCE;
        this.a = r6;
        this.b = 32;
        PointF r8 = new PointF(2.0f, 2.9048f);
        this.c = r8;
        this.d = r8;
        this.e = new PointF(7.8333f, 5.3691f);
        this.f = new PointF(16.7778f, 2.9048f);
        this.g = new PointF(24.1667f, 0.869f);
        PointF r9 = new PointF(30.0f, 2.9048f);
        this.h = r9;
        this.i = r9;
        this.j = 1895772996;
        this.k = (int) 4294914884L;
        this.l = new PathMeasure();
        this.m = new Path();
        this.n = new Path();
        new Rect();
    }
}
