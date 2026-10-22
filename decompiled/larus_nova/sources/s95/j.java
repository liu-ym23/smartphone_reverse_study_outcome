package s95;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import com.larus.apm.impl.protector.RunnableProtector;
import r95.l;
import r95.m;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Interpolator f541078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f541079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f541080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f541081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f541082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f541083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f541084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f541085h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final GestureDetector f541086i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s95.b f541087j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Matrix f541088k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f541089l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Matrix f541090m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f541091n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f541092o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public bm5.a f541093p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View.OnClickListener f541094q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View.OnLongClickListener f541095r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public bm5.b f541096s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public n65.b.a f541097t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f f541098u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f541099v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ImageView.ScaleType f541100w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f541101x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f541102y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a f541103z;

    public class a implements s95.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f541104a;

        public a(j r100) {
            this.f541104a = r100;
        }

        public final void a(float r100, float r101, float r102) {
            float r103 = this.f541104a.g();
            j r104 = this.f541104a;
            if (r103 <= r104.f541081d) goto L5;
        L6:
            float r105 = this.f541104a.g();
            j r106 = this.f541104a;
            if (r105 <= r106.f541081d) goto L11;
            if (r100 > 1.0f) goto L11;
        L14:
            this.f541104a.getClass();
            this.f541104a.f541090m.postScale(r100, r100, r101, r102);
            this.f541104a.a();
            return;
        L11:
            if (r106.g() < this.f541104a.f541080c) goto L13;
            return;
        L13:
            if (r100 >= 1.0f) goto L14;
            return;
        L5:
            if (r104.g() >= this.f541104a.f541080c) goto L14;
            goto L6
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f541105a;

        public b(j r100) {
            this.f541105a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            j r101 = this.f541105a;
            View.OnLongClickListener r102 = r101.f541095r;
            if (r102 == null) goto L6;
            r102.onLongClick(r101.f541085h);
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            this.f541105a.getClass();
            return false;
        }
    }

    public class c implements GestureDetector.OnDoubleTapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f541106a;

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTapEvent(MotionEvent r100) {
            return false;
        }

        public c(j r100) {
            this.f541106a = r100;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            float r101 = this.f541106a.g();     // Catch: ArrayIndexOutOfBoundsException -> L8
            float r102 = r100.getX();     // Catch: ArrayIndexOutOfBoundsException -> L8
            float r103 = r100.getY();     // Catch: ArrayIndexOutOfBoundsException -> L8
            j r104 = this.f541106a;     // Catch: ArrayIndexOutOfBoundsException -> L8
            float r105 = r104.f541082e;     // Catch: ArrayIndexOutOfBoundsException -> L8
            if (r101 >= r105) goto L6;
            r104.i(r105, r102, r103, true);     // Catch: ArrayIndexOutOfBoundsException -> L8
        L9:
            goto L7
        L6:
            r104.i(r104.f541080c, r102, r103, true);     // Catch: ArrayIndexOutOfBoundsException -> L8
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            j r101 = this.f541106a;
            View.OnClickListener r102 = r101.f541094q;
            if (r102 == null) goto L5;
            r102.onClick(r101.f541085h);
        L5:
            RectF r103 = this.f541106a.c();
            float r104 = r100.getX();
            float r105 = r100.getY();
            this.f541106a.getClass();
            if (r103 != null) goto L8;
            return false;
        L8:
            if (r103.contains(r104, r105) == false) goto L11;
            r103.width();
            r103.height();
            this.f541106a.getClass();
            return true;
        L11:
            this.f541106a.getClass();
            return false;
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f541107a = null;

        static {
            int[] r100 = new int[ImageView.ScaleType.values().length];
            f541107a = r100;
            r100[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f541107a[ImageView.ScaleType.FIT_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f541107a[ImageView.ScaleType.FIT_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f541107a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f541108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f541109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f541110c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f541111d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f541112e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ j f541113f;

        public final void a() {
            float r100 = ((AccelerateDecelerateInterpolator) this.f541113f.f541078a).getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f541110c) * 1.0f) / this.f541113f.f541079b));
            float r101 = this.f541111d;
            this.f541113f.f541103z.a((r101 + ((this.f541112e - r101) * r100)) / this.f541113f.g(), this.f541108a, this.f541109b);
            if (r100 >= 1.0f) goto L5;
            this.f541113f.f541085h.postOnAnimation(this);
        L5:
            this.f541113f.h();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(j r100, float r101, float r102, float r103, float r104) {
            this.f541113f = r100;
            this.f541108a = r103;
            this.f541109b = r104;
            this.f541110c = System.currentTimeMillis();
            this.f541111d = r101;
            this.f541112e = r102;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OverScroller f541114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f541115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f541116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f541117d;

        public final void a() {
            if (this.f541114a.isFinished() == false) goto L7;
            this.f541117d.h();
            return;
        L7:
            if (this.f541114a.computeScrollOffset() == false) goto L10;
            int r100 = this.f541114a.getCurrX();
            int r101 = this.f541114a.getCurrY();
            this.f541117d.f541090m.postTranslate(this.f541115b - r100, this.f541116c - r101);
            this.f541117d.a();
            this.f541115b = r100;
            this.f541116c = r101;
            this.f541117d.f541085h.postOnAnimation(this);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(j r100, Context r101) {
            this.f541117d = r100;
            this.f541114a = new OverScroller(r101);
        }
    }

    public final Matrix e() {
        this.f541089l.set(this.f541088k);
        this.f541089l.postConcat(this.f541090m);
        return this.f541089l;
    }

    public final float g() {
        this.f541090m.getValues(this.f541092o);
        float r100 = (float) Math.pow(this.f541092o[0], 2.0d);
        this.f541090m.getValues(this.f541092o);
        return (float) Math.sqrt(r100 + ((float) Math.pow(this.f541092o[3], 2.0d)));
    }

    public final void h() {
        n65.b.a r100 = this.f541097t;
        if (r100 == null) goto L6;
        ((n65.a.C6901a) r100).a();
        return;
    }

    public void update() {
        if (this.f541099v == false) goto L5;
        k(this.f541085h.getDrawable());
    L11:
        h();
        return;
    L5:
        this.f541090m.postRotate(0.0f);
        a();
        Matrix r100 = e();
        this.f541085h.setImageMatrix(r100);
        if (this.f541093p == null) goto L10;
        RectF r101 = d(r100);
        if (r101 == null) goto L10;
        ((l) this.f541093p).a(r101);
    L10:
        b();
        goto L11
    }

    public final void a() {
        if (b() == false) goto L10;
        Matrix r100 = e();
        this.f541085h.setImageMatrix(r100);
        if (this.f541093p == null) goto L11;
        RectF r101 = d(r100);
        if (r101 == null) goto L12;
        ((l) this.f541093p).a(r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final boolean b() {
        RectF r100 = d(e());
        if (r100 != null) goto L6;
        return false;
    L6:
        float r101 = r100.height();
        float r102 = r100.width();
        ImageView r103 = this.f541085h;
        float r104 = (r103.getHeight() - r103.getPaddingTop()) - r103.getPaddingBottom();
        float r105 = 0.0f;
        if (r101 > r104) goto L14;
        int r106 = d.f541107a[this.f541100w.ordinal()];
        if (r106 == 2) goto L13;
        if (r106 == 3) goto L12;
        r104 = (r104 - r101) / 2.0f;
        float r107 = r100.top;
    L19:
        float r108 = r104 - r107;
    L21:
        float r109 = f(this.f541085h);
        if (r102 > r109) goto L29;
        int r110 = d.f541107a[this.f541100w.ordinal()];
        if (r110 == 2) goto L28;
        if (r110 == 3) goto L27;
        r109 = (r109 - r102) / 2.0f;
        float r111 = r100.left;
    L34:
        r105 = r109 - r111;
    L35:
        this.f541090m.postTranslate(r105, r108);
        return true;
    L27:
        r109 = r109 - r102;
        r111 = r100.left;
        goto L34
    L28:
        r105 = -r100.left;
        goto L35
    L29:
        float r112 = r100.left;
        if (r112 <= 0.0f) goto L32;
        r105 = -r112;
        goto L35
    L32:
        r111 = r100.right;
        if (r111 >= r109) goto L35;
    L12:
        r104 = r104 - r101;
        r107 = r100.top;
        goto L19
    L13:
        float r113 = r100.top;
    L16:
        r108 = -r113;
        goto L21
    L14:
        r113 = r100.top;
        if (r113 > 0.0f) goto L16;
        r107 = r100.bottom;
        if (r107 < r104) goto L19;
        r108 = 0.0f;
        goto L21
    }

    public final RectF c() {
        b();
        return d(e());
    }

    public j(ImageView r100) {
        this.f541078a = new AccelerateDecelerateInterpolator();
        this.f541079b = 200;
        this.f541080c = 1.0f;
        this.f541081d = 10.0f;
        this.f541082e = 2.0f;
        this.f541083f = true;
        this.f541084g = false;
        this.f541088k = new Matrix();
        this.f541089l = new Matrix();
        this.f541090m = new Matrix();
        this.f541091n = new RectF();
        this.f541092o = new float[9];
        this.f541099v = true;
        this.f541100w = ImageView.ScaleType.FIT_CENTER;
        a r101 = new a(this);
        this.f541103z = r101;
        this.f541085h = r100;
        r100.setOnTouchListener(this);
        r100.addOnLayoutChangeListener(this);
        if (r100.isInEditMode() == false) goto L5;
        return;
    L5:
        this.f541087j = new s95.b(r100.getContext(), r101);
        GestureDetector r102 = new GestureDetector(r100.getContext(), new b(this));
        this.f541086i = r102;
        r102.setOnDoubleTapListener(new c(this));
    }

    public static int f(ImageView r100) {
        return (r100.getWidth() - r100.getPaddingLeft()) - r100.getPaddingRight();
    }

    public final RectF d(Matrix r100) {
        Drawable r101 = this.f541085h.getDrawable();
        if (r101 == null) goto L6;
        this.f541091n.set(0.0f, 0.0f, r101.getIntrinsicWidth(), r101.getIntrinsicHeight());
        r100.mapRect(this.f541091n);
        return this.f541091n;
    L6:
        return null;
    }

    public final void k(Drawable r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        float r100 = f(this.f541085h);
        ImageView r101 = this.f541085h;
        float r102 = (r101.getHeight() - r101.getPaddingTop()) - r101.getPaddingBottom();
        int r103 = r110.getIntrinsicWidth();
        int r111 = r110.getIntrinsicHeight();
        this.f541088k.reset();
        float r104 = r103;
        float r105 = r100 / r104;
        float r112 = r111;
        float r106 = r102 / r112;
        ImageView.ScaleType r107 = this.f541100w;
        if (r107 != ImageView.ScaleType.CENTER) goto L8;
        this.f541088k.postTranslate((r100 - r104) / 2.0f, (r102 - r112) / 2.0f);
    L29:
        this.f541090m.postRotate(0.0f);
        a();
        Matrix r113 = e();
        this.f541085h.setImageMatrix(r113);
        if (this.f541093p == null) goto L34;
        RectF r114 = d(r113);
        if (r114 == null) goto L34;
        ((l) this.f541093p).a(r114);
    L34:
        b();
        return;
    L8:
        if (r107 != ImageView.ScaleType.CENTER_CROP) goto L11;
        float r108 = Math.max(r105, r106);
        this.f541088k.postScale(r108, r108);
        this.f541088k.postTranslate((r100 - (r104 * r108)) / 2.0f, (r102 - (r112 * r108)) / 2.0f);
        goto L29
    L11:
        if (r107 != ImageView.ScaleType.CENTER_INSIDE) goto L13;
        float r109 = Math.min(1.0f, Math.min(r105, r106));
        this.f541088k.postScale(r109, r109);
        this.f541088k.postTranslate((r100 - (r104 * r109)) / 2.0f, (r102 - (r112 * r109)) / 2.0f);
        goto L29
    L13:
        RectF r115 = new RectF(0.0f, 0.0f, r104, r112);
        RectF r116 = new RectF(0.0f, 0.0f, r100, r102);
        if ((((int) 0.0f) % 180) == 0) goto L16;
        r115 = new RectF(0.0f, 0.0f, r112, r104);
    L16:
        int r117 = d.f541107a[this.f541100w.ordinal()];
        if (r117 != 1) goto L19;
        this.f541088k.setRectToRect(r115, r116, Matrix.ScaleToFit.CENTER);
        goto L29
    L19:
        if (r117 != 2) goto L21;
        this.f541088k.setRectToRect(r115, r116, Matrix.ScaleToFit.START);
        goto L29
    L21:
        if (r117 != 3) goto L23;
        this.f541088k.setRectToRect(r115, r116, Matrix.ScaleToFit.END);
        goto L29
    L23:
        if (r117 != 4) goto L29;
        this.f541088k.setRectToRect(r115, r116, Matrix.ScaleToFit.FILL);
        goto L29
    }

    public final void j(float r100, boolean r101) {
        i(r100, this.f541085h.getRight() / 2.0f, this.f541085h.getBottom() / 2.0f, r101);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        boolean r100 = false;
        if (this.f541099v == true) goto L5;
        return false;
    L5:
        if (((ImageView) r110).getDrawable() == null) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L71;
        int r102 = r111.getAction();
        if (r102 == 0) goto L34;
        if (r102 != 1) goto L13;
    L15:
        float r103 = g();
        this.f541102y = r103;
        if (this.f541096s == null) goto L24;
        float r104 = this.f541101x;
        int r105 = iu5.c.f495800a;
        if (Math.abs(r104 - r103) >= 1.0E-8f) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == true) goto L24;
        bm5.b r107 = this.f541096s;
        m r108 = (m) r107;
        r108.a(this.f541101x, this.f541102y);
        goto L24
    L20:
        r106 = false;
    L24:
        if (g() >= this.f541080c) goto L29;
        RectF r109 = c();
        if (r109 == null) goto L40;
        r110.post(new e(this, g(), this.f541080c, r109.centerX(), r109.centerY()));
    L33:
        boolean r112 = true;
    L41:
        s95.b r113 = this.f541087j;
        if (r113 == null) goto L61;
        boolean r114 = r113.f541070c.isInProgress();
        s95.b r115 = this.f541087j;
        boolean r116 = r115.f541072e;
        r115.f541070c.onTouchEvent(r111);     // Catch: IllegalArgumentException -> L46
        r115.a(r111);     // Catch: IllegalArgumentException -> L46
    L47:
        if (r114 == false) goto L49;
    L51:
        boolean r117 = false;
    L52:
        if (r116 == false) goto L54;
    L56:
        boolean r118 = false;
    L57:
        if (r117 == false) goto L60;
        if (r118 == false) goto L60;
        r100 = true;
    L60:
        this.f541084g = r100;
        boolean r119 = true;
    L62:
        GestureDetector r120 = this.f541086i;
        if (r120 != null) goto L65;
        return r119;
    L65:
        if (r120.onTouchEvent(r111) == false) goto L73;
        return true;
    L73:
        return r119;
    L54:
        if (this.f541087j.f541072e == true) goto L56;
        r118 = true;
        goto L57
    L49:
        if (this.f541087j.f541070c.isInProgress() == true) goto L51;
        r117 = true;
        goto L52
    L61:
        r119 = r112;
    L40:
        r112 = false;
        goto L41
    L29:
        if (g() <= this.f541081d) goto L40;
        RectF r121 = c();
        if (r121 == null) goto L40;
        r110.post(new e(this, g(), this.f541081d, r121.centerX(), r121.centerY()));
        goto L33
    L13:
        if (r102 == 3) goto L15;
    L34:
        this.f541101x = g();
        ViewParent r122 = r110.getParent();
        if (r122 == null) goto L37;
        r122.requestDisallowInterceptTouchEvent(true);
    L37:
        f r123 = this.f541098u;
        if (r123 == null) goto L40;
        r123.f541114a.forceFinished(true);
        this.f541098u = null;
        goto L40
    L71:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    public final void i(float r100, float r110, float r111, boolean r112) {
        float r101 = this.f541080c;
        if (r100 >= r101) goto L5;
    L4:
        float r102 = r101;
    L9:
        if (r112 == false) goto L11;
        this.f541085h.post(new e(this, g(), r102, r110, r111));
    L12:
        h();
        return;
    L11:
        this.f541090m.setScale(r102, r102, r110, r111);
        a();
        goto L12
    L5:
        r101 = this.f541081d;
        if (r100 > r101) goto L4;
        r102 = r100;
        goto L9
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if (r101 != r105) goto L6;
        if (r102 != r106) goto L6;
        if (r103 != r107) goto L6;
        if (r104 != r108) goto L6;
        return;
    L6:
        k(this.f541085h.getDrawable());
    }
}
