package wu7;

import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;

/* JADX INFO: loaded from: classes23.dex */
public abstract class f extends Drawable implements ValueAnimator.AnimatorUpdateListener, Animatable, Drawable.Callback {
    public static final b A = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Rect f561440s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final c f561441t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f561442u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final e f561443v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final h f561444w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final i f561445x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final k f561446y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f561447z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f561448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f561449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f561450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f561451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f561452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f561453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f561454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f561455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f561456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f561457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f561458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f561459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f561460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f561461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f561462o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Rect f561463p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Camera f561464q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Matrix f561465r;

    public static class a extends uu7.a<f> {
        public a() {
            super("scale");
        }

        @Override // android.util.Property
        public final Float get(Object r100) {
            return Float.valueOf(((f) r100).f561448a);
        }

        @Override // uu7.a
        public final void a(f r100, float r101) {
            r100.g(r101);
        }
    }

    public static class b extends uu7.b<f> {
        public b() {
            super("alpha");
        }

        @Override // android.util.Property
        public final Integer get(Object r100) {
            return Integer.valueOf(((f) r100).f561462o);
        }

        @Override // uu7.b
        public final void a(f r100, int r101) {
            r100.setAlpha(r101);
        }
    }

    public static class c extends uu7.b<f> {
        public c() {
            super("rotateX");
        }

        @Override // android.util.Property
        public final Integer get(Object r100) {
            return Integer.valueOf(((f) r100).f561454g);
        }

        @Override // uu7.b
        public final void a(f r100, int r101) {
            r100.f561454g = r101;
        }
    }

    public static class d extends uu7.b<f> {
        public d() {
            super("rotate");
        }

        @Override // android.util.Property
        public final Integer get(Object r100) {
            return Integer.valueOf(((f) r100).f561458k);
        }

        @Override // uu7.b
        public final void a(f r100, int r101) {
            r100.f561458k = r101;
        }
    }

    public static class e extends uu7.b<f> {
        public e() {
            super("rotateY");
        }

        @Override // android.util.Property
        public final Integer get(Object r100) {
            return Integer.valueOf(((f) r100).f561455h);
        }

        @Override // uu7.b
        public final void a(f r100, int r101) {
            r100.f561455h = r101;
        }
    }

    /* JADX INFO: renamed from: wu7.f$f, reason: collision with other inner class name */
    public static class C8163f extends uu7.b<f> {
        public C8163f() {
            super("translateX");
        }

        @Override // android.util.Property
        public final Integer get(Object r100) {
            return Integer.valueOf(((f) r100).f561456i);
        }

        @Override // uu7.b
        public final void a(f r100, int r101) {
            r100.f561456i = r101;
        }
    }

    public static class g extends uu7.b<f> {
        public g() {
            super("translateY");
        }

        @Override // android.util.Property
        public final Integer get(Object r100) {
            return Integer.valueOf(((f) r100).f561457j);
        }

        @Override // uu7.b
        public final void a(f r100, int r101) {
            r100.f561457j = r101;
        }
    }

    public static class h extends uu7.a<f> {
        public h() {
            super("translateXPercentage");
        }

        @Override // android.util.Property
        public final Float get(Object r100) {
            return Float.valueOf(((f) r100).f561459l);
        }

        @Override // uu7.a
        public final void a(f r100, float r101) {
            r100.f561459l = r101;
        }
    }

    public static class i extends uu7.a<f> {
        public i() {
            super("translateYPercentage");
        }

        @Override // android.util.Property
        public final Float get(Object r100) {
            return Float.valueOf(((f) r100).f561460m);
        }

        @Override // uu7.a
        public final void a(f r100, float r101) {
            r100.f561460m = r101;
        }
    }

    public static class j extends uu7.a<f> {
        public j() {
            super(LiveDegradeFpsAnimator.SCALE_X);
        }

        @Override // android.util.Property
        public final Float get(Object r100) {
            return Float.valueOf(((f) r100).f561449b);
        }

        @Override // uu7.a
        public final void a(f r100, float r101) {
            r100.f561449b = r101;
        }
    }

    public static class k extends uu7.a<f> {
        public k() {
            super(LiveDegradeFpsAnimator.SCALE_Y);
        }

        @Override // android.util.Property
        public final Float get(Object r100) {
            return Float.valueOf(((f) r100).f561450c);
        }

        @Override // uu7.a
        public final void a(f r100, float r101) {
            r100.f561450c = r101;
        }
    }

    public abstract void b(Canvas r100);

    public abstract int c();

    public abstract ValueAnimator d();

    public abstract void e(int r100);

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
    }

    static {
        f561440s = new Rect();
        f561441t = new c();
        f561442u = new d();
        f561443v = new e();
        new C8163f();
        new g();
        f561444w = new h();
        f561445x = new i();
        new j();
        f561446y = new k();
        f561447z = new a();
        A = new b();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ValueAnimator r100 = this.f561461n;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isRunning() == false) goto L7;
        return true;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        ValueAnimator r100 = this.f561461n;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        return;
    L11:
        if (this.f561461n != null) goto L13;
        this.f561461n = d();
    L13:
        ValueAnimator r102 = this.f561461n;
        if (r102 == null) goto L16;
        r102.addUpdateListener(this);
        this.f561461n.setStartDelay(this.f561453f);
    L16:
        ValueAnimator r103 = this.f561461n;
        this.f561461n = r103;
        if (r103 != null) goto L20;
        return;
    L20:
        if (r103.isStarted() == true) goto L22;
        r103.start();
    L22:
        invalidateSelf();
        return;
    L5:
        if (r100.isStarted() == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ValueAnimator r100 = this.f561461n;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        this.f561461n.removeAllUpdateListeners();
        this.f561461n.end();
        this.f561448a = 1.0f;
        this.f561454g = 0;
        this.f561455h = 0;
        this.f561456i = 0;
        this.f561457j = 0;
        this.f561458k = 0;
        this.f561459l = 0.0f;
        this.f561460m = 0.0f;
        return;
    L11:
        return;
    L5:
        if (r100.isStarted() == false) goto L7;
        r101 = true;
        goto L8
    }

    public f() {
        this.f561448a = 1.0f;
        this.f561449b = 1.0f;
        this.f561450c = 1.0f;
        this.f561462o = 255;
        this.f561463p = f561440s;
        this.f561464q = new Camera();
        this.f561465r = new Matrix();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f561462o;
    }

    public static Rect a(Rect r100) {
        int r101 = Math.min(r100.width(), r100.height());
        int r102 = r100.centerX();
        int r103 = r100.centerY();
        int r104 = r101 / 2;
        return new Rect(r102 - r104, r103 - r104, r102 + r104, r103 + r104);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        int r101 = this.f561456i;
        if (r101 != 0) goto L5;
        r101 = (int) (getBounds().width() * this.f561459l);
    L5:
        int r102 = this.f561457j;
        if (r102 != 0) goto L8;
        r102 = (int) (getBounds().height() * this.f561460m);
    L8:
        r100.translate(r101, r102);
        r100.scale(this.f561449b, this.f561450c, this.f561451d, this.f561452e);
        r100.rotate(this.f561458k, this.f561451d, this.f561452e);
        if (this.f561454g == 0) goto L11;
    L12:
        this.f561464q.save();
        this.f561464q.rotateX(this.f561454g);
        this.f561464q.rotateY(this.f561455h);
        this.f561464q.getMatrix(this.f561465r);
        this.f561465r.preTranslate(-this.f561451d, -this.f561452e);
        this.f561465r.postTranslate(this.f561451d, this.f561452e);
        this.f561464q.restore();
        r100.concat(this.f561465r);
    L13:
        b(r100);
        return;
    L11:
        if (this.f561455h == 0) goto L13;
        goto L12
    }

    public final void g(float r100) {
        this.f561448a = r100;
        this.f561449b = r100;
        this.f561450c = r100;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        invalidateSelf();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Drawable.Callback r101 = getCallback();
        if (r101 == null) goto L6;
        r101.invalidateDrawable(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        f(r100.left, r100.top, r100.right, r100.bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.f561462o = r100;
    }

    public final void f(int r100, int r101, int r102, int r103) {
        Rect r104 = new Rect(r100, r101, r102, r103);
        this.f561463p = r104;
        this.f561451d = r104.centerX();
        this.f561452e = this.f561463p.centerY();
    }
}
