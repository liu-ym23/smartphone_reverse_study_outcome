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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements View.OnTouchListener, View.OnLayoutChangeListener {
    public final Interpolator a;
    public int b;
    public float c;
    public float d;
    public float e;
    public boolean f;
    public boolean g;
    public final ImageView h;
    public final GestureDetector i;
    public final s95.b j;
    public final Matrix k;
    public final Matrix l;
    public final Matrix m;
    public final RectF n;
    public final float[] o;
    public bm5.a p;
    public View.OnClickListener q;
    public View.OnLongClickListener r;
    public bm5.b s;
    public n65.b.a t;
    public f u;
    public boolean v;
    public final ImageView.ScaleType w;
    public float x;
    public float y;
    public final a z;

    public class a implements s95.c {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        public final void a(float r5, float r6, float r7) {
            float r0 = this.a.g();
            j r1 = this.a;
            if (r0 <= r1.d) goto L5;
        L6:
            float r2 = this.a.g();
            j r3 = this.a;
            if (r2 <= r3.d) goto L11;
            if (r5 > 1.0f) goto L11;
        L14:
            this.a.getClass();
            this.a.m.postScale(r5, r5, r6, r7);
            this.a.a();
            return;
        L11:
            if (r3.g() < this.a.c) goto L13;
            return;
        L13:
            if (r5 >= 1.0f) goto L14;
            return;
        L5:
            if (r1.g() >= this.a.c) goto L14;
            goto L6
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ j a;

        public b(j r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r2) {
            j r3 = this.a;
            View.OnLongClickListener r0 = r3.r;
            if (r0 == null) goto L6;
            r0.onLongClick(r3.h);
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            this.a.getClass();
            return false;
        }
    }

    public class c implements GestureDetector.OnDoubleTapListener {
        public final /* synthetic */ j a;

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTapEvent(MotionEvent r1) {
            return false;
        }

        public c(j r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r6) {
            float r1 = this.a.g();     // Catch: ArrayIndexOutOfBoundsException -> L8
            float r2 = r6.getX();     // Catch: ArrayIndexOutOfBoundsException -> L8
            float r7 = r6.getY();     // Catch: ArrayIndexOutOfBoundsException -> L8
            j r3 = this.a;     // Catch: ArrayIndexOutOfBoundsException -> L8
            float r4 = r3.e;     // Catch: ArrayIndexOutOfBoundsException -> L8
            if (r1 >= r4) goto L6;
            r3.i(r4, r2, r7, true);     // Catch: ArrayIndexOutOfBoundsException -> L8
        L9:
            goto L7
        L6:
            r3.i(r3.c, r2, r7, true);     // Catch: ArrayIndexOutOfBoundsException -> L8
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r4) {
            j r0 = this.a;
            View.OnClickListener r1 = r0.q;
            if (r1 == null) goto L5;
            r1.onClick(r0.h);
        L5:
            RectF r2 = this.a.c();
            float r3 = r4.getX();
            float r5 = r4.getY();
            this.a.getClass();
            if (r2 != null) goto L8;
            return false;
        L8:
            if (r2.contains(r3, r5) == false) goto L11;
            r2.width();
            r2.height();
            this.a.getClass();
            return true;
        L11:
            this.a.getClass();
            return false;
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImageView.ScaleType.values().length];
            a = r0;
            r0[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[ImageView.ScaleType.FIT_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[ImageView.ScaleType.FIT_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class e implements Runnable {
        public final float a;
        public final float b;
        public final long c;
        public final float d;
        public final float e;
        public final /* synthetic */ j f;

        public final void a() {
            float r0 = ((AccelerateDecelerateInterpolator) this.f.a).getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.c) * 1.0f) / this.f.b));
            float r2 = this.d;
            this.f.z.a((r2 + ((this.e - r2) * r0)) / this.f.g(), this.a, this.b);
            if (r0 >= 1.0f) goto L5;
            this.f.h.postOnAnimation(this);
        L5:
            this.f.h();
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

        public e(j r1, float r2, float r3, float r4, float r5) {
            this.f = r1;
            this.a = r4;
            this.b = r5;
            this.c = System.currentTimeMillis();
            this.d = r2;
            this.e = r3;
        }
    }

    public class f implements Runnable {
        public final OverScroller a;
        public int b;
        public int c;
        public final /* synthetic */ j d;

        public final void a() {
            if (this.a.isFinished() == false) goto L7;
            this.d.h();
            return;
        L7:
            if (this.a.computeScrollOffset() == false) goto L10;
            int r0 = this.a.getCurrX();
            int r1 = this.a.getCurrY();
            this.d.m.postTranslate(this.b - r0, this.c - r1);
            this.d.a();
            this.b = r0;
            this.c = r1;
            this.d.h.postOnAnimation(this);
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

        public f(j r1, Context r2) {
            this.d = r1;
            this.a = new OverScroller(r2);
        }
    }

    public final Matrix e() {
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    public final float g() {
        this.m.getValues(this.o);
        float r0 = (float) Math.pow(this.o[0], 2.0d);
        this.m.getValues(this.o);
        return (float) Math.sqrt(r0 + ((float) Math.pow(this.o[3], 2.0d)));
    }

    public final void h() {
        n65.b.a r0 = this.t;
        if (r0 == null) goto L6;
        ((n65.a.C0260a) r0).a();
        return;
    }

    public void update() {
        if (this.v == false) goto L5;
        k(this.h.getDrawable());
    L11:
        h();
        return;
    L5:
        this.m.postRotate(0.0f);
        a();
        Matrix r0 = e();
        this.h.setImageMatrix(r0);
        if (this.p == null) goto L10;
        RectF r1 = d(r0);
        if (r1 == null) goto L10;
        ((l) this.p).a(r1);
    L10:
        b();
        goto L11
    }

    public final void a() {
        if (b() == false) goto L10;
        Matrix r0 = e();
        this.h.setImageMatrix(r0);
        if (this.p == null) goto L11;
        RectF r1 = d(r0);
        if (r1 == null) goto L12;
        ((l) this.p).a(r1);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final boolean b() {
        RectF r0 = d(e());
        if (r0 != null) goto L6;
        return false;
    L6:
        float r1 = r0.height();
        float r2 = r0.width();
        ImageView r3 = this.h;
        float r4 = (r3.getHeight() - r3.getPaddingTop()) - r3.getPaddingBottom();
        float r5 = 0.0f;
        if (r1 > r4) goto L14;
        int r8 = d.a[this.w.ordinal()];
        if (r8 == 2) goto L13;
        if (r8 == 3) goto L12;
        r4 = (r4 - r1) / 2.0f;
        float r6 = r0.top;
    L19:
        float r7 = r4 - r6;
    L21:
        float r9 = f(this.h);
        if (r2 > r9) goto L29;
        int r10 = d.a[this.w.ordinal()];
        if (r10 == 2) goto L28;
        if (r10 == 3) goto L27;
        r9 = (r9 - r2) / 2.0f;
        float r11 = r0.left;
    L34:
        r5 = r9 - r11;
    L35:
        this.m.postTranslate(r5, r7);
        return true;
    L27:
        r9 = r9 - r2;
        r11 = r0.left;
        goto L34
    L28:
        r5 = -r0.left;
        goto L35
    L29:
        float r12 = r0.left;
        if (r12 <= 0.0f) goto L32;
        r5 = -r12;
        goto L35
    L32:
        r11 = r0.right;
        if (r11 >= r9) goto L35;
    L12:
        r4 = r4 - r1;
        r6 = r0.top;
        goto L19
    L13:
        float r13 = r0.top;
    L16:
        r7 = -r13;
        goto L21
    L14:
        r13 = r0.top;
        if (r13 > 0.0f) goto L16;
        r6 = r0.bottom;
        if (r6 < r4) goto L19;
        r7 = 0.0f;
        goto L21
    }

    public final RectF c() {
        b();
        return d(e());
    }

    public j(ImageView r4) {
        this.a = new AccelerateDecelerateInterpolator();
        this.b = 200;
        this.c = 1.0f;
        this.d = 10.0f;
        this.e = 2.0f;
        this.f = true;
        this.g = false;
        this.k = new Matrix();
        this.l = new Matrix();
        this.m = new Matrix();
        this.n = new RectF();
        this.o = new float[9];
        this.v = true;
        this.w = ImageView.ScaleType.FIT_CENTER;
        a r0 = new a(this);
        this.z = r0;
        this.h = r4;
        r4.setOnTouchListener(this);
        r4.addOnLayoutChangeListener(this);
        if (r4.isInEditMode() == false) goto L5;
        return;
    L5:
        this.j = new s95.b(r4.getContext(), r0);
        GestureDetector r1 = new GestureDetector(r4.getContext(), new b(this));
        this.i = r1;
        r1.setOnDoubleTapListener(new c(this));
    }

    public static int f(ImageView r2) {
        return (r2.getWidth() - r2.getPaddingLeft()) - r2.getPaddingRight();
    }

    public final RectF d(Matrix r5) {
        Drawable r0 = this.h.getDrawable();
        if (r0 == null) goto L6;
        this.n.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        r5.mapRect(this.n);
        return this.n;
    L6:
        return null;
    }

    public final void k(Drawable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        float r0 = f(this.h);
        ImageView r1 = this.h;
        float r2 = (r1.getHeight() - r1.getPaddingTop()) - r1.getPaddingBottom();
        int r3 = r10.getIntrinsicWidth();
        int r11 = r10.getIntrinsicHeight();
        this.k.reset();
        float r4 = r3;
        float r5 = r0 / r4;
        float r12 = r11;
        float r6 = r2 / r12;
        ImageView.ScaleType r7 = this.w;
        if (r7 != ImageView.ScaleType.CENTER) goto L8;
        this.k.postTranslate((r0 - r4) / 2.0f, (r2 - r12) / 2.0f);
    L29:
        this.m.postRotate(0.0f);
        a();
        Matrix r13 = e();
        this.h.setImageMatrix(r13);
        if (this.p == null) goto L34;
        RectF r14 = d(r13);
        if (r14 == null) goto L34;
        ((l) this.p).a(r14);
    L34:
        b();
        return;
    L8:
        if (r7 != ImageView.ScaleType.CENTER_CROP) goto L11;
        float r8 = Math.max(r5, r6);
        this.k.postScale(r8, r8);
        this.k.postTranslate((r0 - (r4 * r8)) / 2.0f, (r2 - (r12 * r8)) / 2.0f);
        goto L29
    L11:
        if (r7 != ImageView.ScaleType.CENTER_INSIDE) goto L13;
        float r9 = Math.min(1.0f, Math.min(r5, r6));
        this.k.postScale(r9, r9);
        this.k.postTranslate((r0 - (r4 * r9)) / 2.0f, (r2 - (r12 * r9)) / 2.0f);
        goto L29
    L13:
        RectF r16 = new RectF(0.0f, 0.0f, r4, r12);
        RectF r17 = new RectF(0.0f, 0.0f, r0, r2);
        if ((((int) 0.0f) % 180) == 0) goto L16;
        r16 = new RectF(0.0f, 0.0f, r12, r4);
    L16:
        int r18 = d.a[this.w.ordinal()];
        if (r18 != 1) goto L19;
        this.k.setRectToRect(r16, r17, Matrix.ScaleToFit.CENTER);
        goto L29
    L19:
        if (r18 != 2) goto L21;
        this.k.setRectToRect(r16, r17, Matrix.ScaleToFit.START);
        goto L29
    L21:
        if (r18 != 3) goto L23;
        this.k.setRectToRect(r16, r17, Matrix.ScaleToFit.END);
        goto L29
    L23:
        if (r18 != 4) goto L29;
        this.k.setRectToRect(r16, r17, Matrix.ScaleToFit.FILL);
        goto L29
    }

    public final void j(float r4, boolean r5) {
        i(r4, this.h.getRight() / 2.0f, this.h.getBottom() / 2.0f, r5);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r11, MotionEvent r12) {
        boolean r1 = false;
        if (this.v == true) goto L5;
        return false;
    L5:
        if (((ImageView) r11).getDrawable() == null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L71;
        int r2 = r12.getAction();
        if (r2 == 0) goto L34;
        if (r2 != 1) goto L13;
    L15:
        float r3 = g();
        this.y = r3;
        if (this.s == null) goto L24;
        float r4 = this.x;
        int r5 = iu5.c.a;
        if (Math.abs(r4 - r3) >= 1.0E-8f) goto L20;
        boolean r6 = true;
    L21:
        if (r6 == true) goto L24;
        bm5.b r7 = this.s;
        m r8 = (m) r7;
        r8.a(this.x, this.y);
        goto L24
    L20:
        r6 = false;
    L24:
        if (g() >= this.c) goto L29;
        RectF r9 = c();
        if (r9 == null) goto L40;
        r11.post(new e(this, g(), this.c, r9.centerX(), r9.centerY()));
    L33:
        boolean r13 = true;
    L41:
        s95.b r10 = this.j;
        if (r10 == null) goto L61;
        boolean r14 = r10.c.isInProgress();
        s95.b r16 = this.j;
        boolean r17 = r16.e;
        r16.c.onTouchEvent(r12);     // Catch: IllegalArgumentException -> L46
        r16.a(r12);     // Catch: IllegalArgumentException -> L46
    L47:
        if (r14 == false) goto L49;
    L51:
        boolean r18 = false;
    L52:
        if (r17 == false) goto L54;
    L56:
        boolean r19 = false;
    L57:
        if (r18 == false) goto L60;
        if (r19 == false) goto L60;
        r1 = true;
    L60:
        this.g = r1;
        boolean r20 = true;
    L62:
        GestureDetector r110 = this.i;
        if (r110 != null) goto L65;
        return r20;
    L65:
        if (r110.onTouchEvent(r12) == false) goto L73;
        return true;
    L73:
        return r20;
    L54:
        if (this.j.e == true) goto L56;
        r19 = true;
        goto L57
    L49:
        if (this.j.c.isInProgress() == true) goto L51;
        r18 = true;
        goto L52
    L61:
        r20 = r13;
    L40:
        r13 = false;
        goto L41
    L29:
        if (g() <= this.d) goto L40;
        RectF r21 = c();
        if (r21 == null) goto L40;
        r11.post(new e(this, g(), this.d, r21.centerX(), r21.centerY()));
        goto L33
    L13:
        if (r2 == 3) goto L15;
    L34:
        this.x = g();
        ViewParent r111 = r11.getParent();
        if (r111 == null) goto L37;
        r111.requestDisallowInterceptTouchEvent(true);
    L37:
        f r112 = this.u;
        if (r112 == null) goto L40;
        r112.a.forceFinished(true);
        this.u = null;
        goto L40
    L71:
        return false;
    L7:
        r0 = false;
        goto L8
    }

    public final void i(float r9, float r10, float r11, boolean r12) {
        float r0 = this.c;
        if (r9 >= r0) goto L5;
    L4:
        float r5 = r0;
    L9:
        if (r12 == false) goto L11;
        this.h.post(new e(this, g(), r5, r10, r11));
    L12:
        h();
        return;
    L11:
        this.m.setScale(r5, r5, r10, r11);
        a();
        goto L12
    L5:
        r0 = this.d;
        if (r9 > r0) goto L4;
        r5 = r9;
        goto L9
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r2 != r6) goto L6;
        if (r3 != r7) goto L6;
        if (r4 != r8) goto L6;
        if (r5 != r9) goto L6;
        return;
    L6:
        k(this.h.getDrawable());
    }
}
