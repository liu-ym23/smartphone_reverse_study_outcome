package io.supercharge.shimmerlayout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes41.dex */
public class ShimmerLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f495158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f495159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f495160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f495161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f495162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f495163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Canvas f495164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f495165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f495166i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f495167j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f495168k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f495169l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f495170m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f495171n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f495172o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f495173p;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShimmerLayout f495174a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f495174a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f495174a.c();
            return true;
        }

        public a(ShimmerLayout r100) {
            this.f495174a = r100;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f495175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f495176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ShimmerLayout f495177c;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            ShimmerLayout r101 = this.f495177c;
            r101.f495158a = this.f495175a + ((Integer) r100.getAnimatedValue()).intValue();
            ShimmerLayout r102 = this.f495177c;
            if ((r102.f495158a + this.f495176b) < 0) goto L6;
            r102.invalidate();
            return;
        }

        public b(ShimmerLayout r100, int r101, int r102) {
            this.f495177c = r100;
            this.f495175a = r101;
            this.f495176b = r102;
        }
    }

    private float[] getGradientColorDistribution() {
        float[] r100 = {0.0f, 0.5f - (r1 / 2.0f), (r1 / 2.0f) + 0.5f, 1.0f};
        float r101 = this.f495172o;
        return r100;
    }

    private Bitmap getMaskBitmap() {
        if (this.f495163f != null) goto L10;
        int r100 = this.f495159b.width();
        int r101 = getHeight();
        Bitmap r102 = Bitmap.createBitmap(r100, r101, Bitmap.Config.ALPHA_8);     // Catch: OutOfMemoryError -> L7
    L8:
        this.f495163f = r102;
    L7:
        System.gc();
        r102 = null;
    L10:
        return this.f495163f;
    }

    private Animator getShimmerAnimation() {
        ValueAnimator r100 = this.f495161d;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.f495159b != null) goto L8;
        this.f495159b = new Rect(0, 0, (int) ((((double) ((getWidth() / 2) * this.f495171n)) / Math.cos(Math.toRadians(Math.abs(this.f495170m)))) + (((double) getHeight()) * Math.tan(Math.toRadians(Math.abs(this.f495170m))))), getHeight());
    L8:
        int r101 = getWidth();
        if (getWidth() <= this.f495159b.width()) goto L11;
        int r102 = -r101;
    L12:
        int r103 = this.f495159b.width();
        int r104 = r101 - r102;
        int[] r105 = new int[2];
        if (this.f495165h == false) goto L15;
        r105[0] = r104;
        r105[1] = 0;
        ValueAnimator r106 = ValueAnimator.ofInt(r105);
    L16:
        this.f495161d = r106;
        r106.setDuration(this.f495168k);
        this.f495161d.setRepeatCount(-1);
        this.f495161d.addUpdateListener(new b(this, r102, r103));
        return this.f495161d;
    L15:
        r105[0] = 0;
        r105[1] = r104;
        r106 = ValueAnimator.ofInt(r105);
        goto L16
    L11:
        r102 = -this.f495159b.width();
        goto L12
    }

    public final void a() {
        if (this.f495166i == false) goto L6;
        b();
        c();
        return;
    }

    public final void b() {
        ValueAnimator r100 = this.f495161d;
        if (r100 == null) goto L5;
        r100.end();
        this.f495161d.removeAllUpdateListeners();
    L5:
        this.f495161d = null;
        this.f495160c = null;
        this.f495166i = false;
        this.f495164g = null;
        Bitmap r101 = this.f495163f;
        if (r101 == null) goto L9;
        r101.recycle();
        this.f495163f = null;
        return;
    }

    public final void c() {
        if (this.f495166i == false) goto L6;
        return;
    L6:
        if (getWidth() != 0) goto L9;
        this.f495173p = new a(this);
        getViewTreeObserver().addOnPreDrawListener(this.f495173p);
        return;
    L9:
        getShimmerAnimation().start();
        this.f495166i = true;
    }

    public final void d() {
        if (this.f495173p == null) goto L5;
        getViewTreeObserver().removeOnPreDrawListener(this.f495173p);
    L5:
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    public ShimmerLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        if (this.f495166i == true) goto L5;
    L24:
        super.dispatchDraw(r110);
        return;
    L5:
        if (getWidth() <= 0) goto L24;
        if (getHeight() <= 0) goto L24;
        super.dispatchDraw(r110);
        Bitmap r100 = getMaskBitmap();
        this.f495162e = r100;
        if (r100 != null) goto L13;
        return;
    L13:
        if (this.f495164g != null) goto L15;
        this.f495164g = new Canvas(this.f495162e);
    L15:
        this.f495164g.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f495164g.save();
        this.f495164g.translate(-this.f495158a, 0.0f);
        super.dispatchDraw(this.f495164g);
        this.f495164g.restore();
        if (this.f495160c != null) goto L23;
        int r101 = this.f495169l;
        int r102 = Color.argb(0, Color.red(r101), Color.green(r101), Color.blue(r101));
        float r103 = (getWidth() / 2) * this.f495171n;
        if (this.f495170m < 0) goto L21;
        float r104 = getHeight();
    L22:
        float r105 = ((float) Math.cos(Math.toRadians(this.f495170m))) * r103;
        float r111 = r104 + (((float) Math.sin(Math.toRadians(this.f495170m))) * r103);
        int r106 = this.f495169l;
        LinearGradient r107 = new LinearGradient(0.0f, r104, r105, r111, new int[]{r102, r106, r106, r102}, getGradientColorDistribution(), Shader.TileMode.CLAMP);
        Bitmap r108 = this.f495162e;
        Shader.TileMode r109 = Shader.TileMode.CLAMP;
        ComposeShader r112 = new ComposeShader(r107, new BitmapShader(r108, r109, r109), PorterDuff.Mode.DST_IN);
        Paint r113 = new Paint();
        this.f495160c = r113;
        r113.setAntiAlias(true);
        this.f495160c.setDither(true);
        this.f495160c.setFilterBitmap(true);
        this.f495160c.setShader(r112);
        goto L23
    L21:
        r104 = 0.0f;
    L23:
        r110.save();
        r110.translate(this.f495158a, 0.0f);
        Rect r114 = this.f495159b;
        r110.drawRect(r114.left, 0.0f, r114.width(), this.f495159b.height(), this.f495160c);
        r110.restore();
        this.f495162e = null;
    }

    public void setAnimationReversed(boolean r100) {
        this.f495165h = r100;
        a();
    }

    public void setGradientCenterColorWidth(float r100) {
        if (r100 <= 0.0f) goto L9;
        if (1.0f <= r100) goto L9;
        this.f495172o = r100;
        a();
        return;
    L9:
        throw new IllegalArgumentException(String.format("gradientCenterColorWidth value must be higher than %d and less than %d", new Object[]{(byte) 0, (byte) 1}));
    }

    public void setMaskWidth(float r100) {
        if (r100 <= 0.0f) goto L9;
        if (1.0f < r100) goto L9;
        this.f495171n = r100;
        a();
        return;
    L9:
        throw new IllegalArgumentException(String.format("maskWidth value must be higher than %d and less or equal to %d", new Object[]{(byte) 0, (byte) 1}));
    }

    public void setShimmerAngle(int r100) {
        if (r100 < (-45)) goto L8;
        if (45 < r100) goto L8;
        this.f495170m = r100;
        a();
        return;
    L8:
        throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", new Object[]{(byte) -45, (byte) 45}));
    }

    public void setShimmerAnimationDuration(int r100) {
        this.f495168k = r100;
        a();
    }

    public void setShimmerColor(int r100) {
        this.f495169l = r100;
        a();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 == 0) goto L5;
        d();
        return;
    L5:
        if (this.f495167j == false) goto L9;
        c();
        return;
    }

    public ShimmerLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ShimmerLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setWillNotDraw(false);
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.shimmer_angle, R.attr.shimmer_animation_duration, R.attr.shimmer_auto_start, R.attr.shimmer_color, R.attr.shimmer_gradient_center_color_width, R.attr.shimmer_mask_width, R.attr.shimmer_reverse_animation}, 0, 0);
        this.f495170m = r103.getInteger(0, 20);     // Catch: Throwable -> L14
        this.f495168k = r103.getInteger(1, 1500);     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 23) goto L6;
        int r104 = getContext().getColor(R.color.shimmer_color);     // Catch: Throwable -> L14
    L7:
        this.f495169l = r103.getColor(3, r104);     // Catch: Throwable -> L14
        boolean r105 = r103.getBoolean(2, false);     // Catch: Throwable -> L14
        this.f495167j = r105;     // Catch: Throwable -> L14
        this.f495171n = r103.getFloat(5, 0.5f);     // Catch: Throwable -> L14
        this.f495172o = r103.getFloat(4, 0.1f);     // Catch: Throwable -> L14
        this.f495165h = r103.getBoolean(6, false);     // Catch: Throwable -> L14
        r103.recycle();
        setMaskWidth(this.f495171n);
        setGradientCenterColorWidth(this.f495172o);
        setShimmerAngle(this.f495170m);
        if (r105 == true) goto L11;
        return;
    L11:
        if (getVisibility() != 0) goto L20;
        c();
        return;
    L20:
        return;
    L6:
        r104 = getResources().getColor(R.color.shimmer_color);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r103.recycle();
        throw th;
    }
}
