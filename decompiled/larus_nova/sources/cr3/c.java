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

/* JADX INFO: loaded from: classes14.dex */
public final class c extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f465049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f465050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f465051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f465052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PointF f465053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PointF f465054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PointF f465055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PointF f465056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f465057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f465058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f465059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PathMeasure f465060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Path f465061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Path f465062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f465063o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f465064p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function0<b> f465065q;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f465064p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 255 - this.f465049a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f465063o;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        Rect r100 = getBounds();
        b r101 = this.f465065q.invoke();
        int r102 = r100.centerX();
        Float r103 = null;
        if (b.a(r102, r101.f465043a, r101.f465046d) == false) goto L6;
        Integer r104 = r101.f465046d;
    L12:
        if (r104 == null) goto L30;
        int r105 = r104.intValue();
        int r106 = r100.centerX();
        if (b.a(r106, r101.f465043a, r101.f465046d) == false) goto L17;
        r103 = r101.f465043a;
    L22:
        if (r103 == null) goto L31;
        float r107 = r103.floatValue();
        float r108 = (r100.centerX() - r107) / r105;
        float r109 = r107 + (r105 / 2);
        int r110 = (int) (r109 - (r100.width() / 2));
        int r111 = (int) (r109 + (r100.width() / 2));
        int r112 = r100.bottom;
        r100.offset(0, -((int) this.f465064p));
        float r113 = (r111 - r110) / this.f465050b;
        this.f465061m.reset();
        Path r114 = this.f465061m;
        PointF r115 = this.f465051c;
        r114.moveTo(r115.x * r113, r115.y * r113);
        Path r116 = this.f465061m;
        PointF r117 = this.f465052d;
        float r118 = r117.x * r113;
        float r119 = r117.y * r113;
        PointF r120 = this.f465053e;
        float r121 = r120.x * r113;
        float r122 = r120.y * r113;
        PointF r123 = this.f465054f;
        r116.cubicTo(r118, r119, r121, r122, r123.x * r113, r123.y * r113);
        Path r124 = this.f465061m;
        PointF r125 = this.f465055g;
        float r211 = r125.x * r113;
        float r212 = r125.y * r113;
        PointF r126 = this.f465056h;
        float r213 = r126.x * r113;
        float r214 = r126.y * r113;
        PointF r127 = this.f465057i;
        r124.cubicTo(r211, r212, r213, r214, r127.x * r113, r127.y * r113);
        float r128 = r110;
        this.f465061m.offset(r128, r100.top);
        float r129 = r112;
        this.f465049a.setShader(new LinearGradient(r128, r129, (r111 + r128) - r128, r129, this.f465058j, this.f465059k, Shader.TileMode.CLAMP));
        this.f465060l.setPath(this.f465061m, false);
        float r130 = RangesKt.coerceAtLeast((r108 - 0.5f) / 0.5f, 0.0f);
        float r131 = RangesKt.coerceAtMost(r108 / 0.5f, 1.0f);
        if (r131 <= r130) goto L33;
        this.f465062n.reset();
        PathMeasure r132 = this.f465060l;
        if (r132.getSegment(r132.getLength() * r130, this.f465060l.getLength() * r131, this.f465062n, true) == false) goto L32;
        r210.drawPath(this.f465062n, this.f465049a);
        return;
    L32:
        return;
    L33:
        return;
    L31:
        return;
    L17:
        if (b.a(r106, r101.f465044b, r101.f465047e) == false) goto L20;
        r103 = r101.f465044b;
        goto L22
    L20:
        if (b.a(r106, r101.f465045c, r101.f465048f) == false) goto L22;
        r103 = r101.f465045c;
        goto L22
    L30:
        return;
    L6:
        if (b.a(r102, r101.f465044b, r101.f465047e) == false) goto L9;
        r104 = r101.f465047e;
        goto L12
    L9:
        if (b.a(r102, r101.f465045c, r101.f465048f) == false) goto L11;
        r104 = r101.f465048f;
        goto L12
    L11:
        r104 = null;
        goto L12
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        if (r100.width() <= 0) goto L5;
        int r101 = (r100.left + r100.right) / 2;
        int r102 = this.f465063o;
        r100.set(r101 - (r102 / 2), r100.top, r101 + (r102 / 2), r100.bottom);
    L5:
        r100.bottom = r100.top + 20;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f465049a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f465049a.setColorFilter(r100);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
        unscheduleSelf(r101);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
        scheduleSelf(r101, r102);
    }

    public c(int r100, float r101, float r102, Function0<b> r103) {
        Intrinsics.checkNotNullParameter(r103, "tabScrollStateProvider");
        this.f465063o = r100;
        this.f465064p = r102;
        this.f465065q = r103;
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        r104.setStrokeCap(Paint.Cap.ROUND);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(r101);
        Unit r105 = Unit.INSTANCE;
        this.f465049a = r104;
        this.f465050b = 32;
        PointF r106 = new PointF(2.0f, 2.9048f);
        this.f465051c = r106;
        this.f465052d = r106;
        this.f465053e = new PointF(7.8333f, 5.3691f);
        this.f465054f = new PointF(16.7778f, 2.9048f);
        this.f465055g = new PointF(24.1667f, 0.869f);
        PointF r107 = new PointF(30.0f, 2.9048f);
        this.f465056h = r107;
        this.f465057i = r107;
        this.f465058j = 1895772996;
        this.f465059k = (int) 4294914884L;
        this.f465060l = new PathMeasure();
        this.f465061m = new Path();
        this.f465062n = new Path();
        new Rect();
    }
}
