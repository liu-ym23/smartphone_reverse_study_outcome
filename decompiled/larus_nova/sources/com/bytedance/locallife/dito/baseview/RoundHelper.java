package com.bytedance.locallife.dito.baseview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class RoundHelper {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f257301n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f257302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f257303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f257304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f257305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f257306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f257307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f257308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f257309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f257310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f257311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f257312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f257313l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f257314m;

    public static final class a {
    }

    static {
        f257301n = ColorProtector.parseColor("#00000000");
    }

    public final Paint b() {
        return (Paint) this.f257302a.getValue();
    }

    public final float[] c() {
        return (float[]) this.f257307f.getValue();
    }

    public RoundHelper() {
        this.f257302a = LazyKt.lazy(RoundHelper$mPaint$2.INSTANCE);
        this.f257303b = LazyKt.lazy(RoundHelper$mRectF$2.INSTANCE);
        this.f257304c = LazyKt.lazy(RoundHelper$mPath$2.INSTANCE);
        this.f257305d = LazyKt.lazy(RoundHelper$mTempPath$2.INSTANCE);
        this.f257306e = LazyKt.lazy(RoundHelper$mXfermode$2.INSTANCE);
        this.f257307f = LazyKt.lazy(RoundHelper$mRadii$2.INSTANCE);
        Paint r100 = new Paint();
        r100.setStyle(Paint.Style.STROKE);
        r100.setAntiAlias(true);
        this.f257310i = r100;
        this.f257311j = new RectF();
        this.f257312k = new Path();
    }

    public final void a(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        boolean r101 = this.f257308g;
        if (r101 == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return;
    L11:
        if (r101 == false) goto L18;
        ((Path) this.f257304c.getValue()).reset();
        b().reset();
        b().setAntiAlias(true);
        b().setStyle(Paint.Style.FILL);
        b().setXfermode((Xfermode) this.f257306e.getValue());
        ((Path) this.f257304c.getValue()).addRoundRect((RectF) this.f257303b.getValue(), c(), Path.Direction.CCW);
        if (Build.VERSION.SDK_INT < 23) goto L15;
        ((Path) this.f257305d.getValue()).reset();
        ((Path) this.f257305d.getValue()).addRect((RectF) this.f257303b.getValue(), Path.Direction.CCW);
        ((Path) this.f257305d.getValue()).op((Path) this.f257304c.getValue(), Path.Op.DIFFERENCE);
        r100.drawPath((Path) this.f257305d.getValue(), b());
    L16:
        b().setXfermode(null);
        goto L18
    L15:
        r100.drawPath((Path) this.f257304c.getValue(), b());
    L18:
        if (this.f257314m == false) goto L24;
        this.f257312k.reset();
        if (this.f257308g == false) goto L22;
        this.f257312k.addRoundRect(this.f257311j, c(), Path.Direction.CCW);
    L23:
        r100.drawPath(this.f257312k, this.f257310i);
        goto L24
    L22:
        this.f257312k.addRect(this.f257311j, Path.Direction.CCW);
    L24:
        r100.restore();
        return;
    L5:
        if (this.f257314m == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof ViewGroup) == true) goto L5;
    L7:
        this.f257309h = r100;
        return;
    L5:
        if (r100.getBackground() != null) goto L7;
        r100.setBackgroundColor(f257301n);
        goto L7
    }

    public final void f(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f257308g == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        r100.saveLayer((RectF) this.f257303b.getValue(), null, 31);
        return;
    L12:
        return;
    L5:
        if (this.f257314m == true) goto L8;
        r101 = false;
        goto L9
    }

    public final void g(float r100) {
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        this.f257308g = r101;
        c()[0] = r100;
        c()[1] = r100;
        c()[2] = r100;
        c()[3] = r100;
        c()[4] = r100;
        c()[5] = r100;
        c()[6] = r100;
        c()[7] = r100;
        View r102 = this.f257309h;
        if (r102 == null) goto L10;
        r102.invalidate();
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void e(int r100, int r101) {
        float r102 = r100;
        float r103 = r101;
        ((RectF) this.f257303b.getValue()).set(0.0f, 0.0f, r102, r103);
        float r104 = this.f257313l / 2.0f;
        this.f257311j.set(r104, r104, r102 - r104, r103 - r104);
    }

    public final void h(float r100, float r101, float r102, float r103) {
        this.f257308g = true;
        c()[0] = r100;
        c()[1] = r100;
        c()[2] = r101;
        c()[3] = r101;
        c()[4] = r102;
        c()[5] = r102;
        c()[6] = r103;
        c()[7] = r103;
        View r104 = this.f257309h;
        if (r104 == null) goto L6;
        r104.invalidate();
        return;
    }
}
