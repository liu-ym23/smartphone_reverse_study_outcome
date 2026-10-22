package com.bytedance.commerce.base.preview.view.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes15.dex */
public class PhotoView extends AppCompatImageView {
    public float A;
    public float B;
    public final RectF C;
    public final RectF D;
    public final RectF E;
    public final RectF F;
    public final RectF G;
    public final PointF H;
    public final PointF I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final PointF f202804J;
    public final j K;
    public RectF L;
    public yf4.a M;
    public long N;
    public Runnable O;
    public View.OnLongClickListener P;
    public final a Q;
    public final b R;
    public final c S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f202805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f202806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f202807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f202808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f202809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Matrix f202810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Matrix f202811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Matrix f202812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Matrix f202813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View.OnClickListener f202814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView.ScaleType f202815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f202816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f202817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f202818n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f202819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f202820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f202821q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f202822r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f202823s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f202824t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f202825u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f202826v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f202827w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f202828x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f202829y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f202830z;

    public class a implements ScaleGestureDetector.OnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f202831a;

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector r100) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector r100) {
        }

        public a(PhotoView r100) {
            this.f202831a = r100;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r100) {
            float r101 = r100.getScaleFactor();
            if (Float.isNaN(r101) == false) goto L5;
        L13:
            return false;
        L5:
            if (Float.isInfinite(r101) == true) goto L13;
            PhotoView r102 = this.f202831a;
            float r103 = r102.f202828x * r101;
            r102.f202828x = r103;
            if (r103 <= 1.0f) goto L10;
            r102.f202822r = true;
        L11:
            r102.f202811g.postScale(r101, r101, r100.getFocusX(), r100.getFocusY());
            this.f202831a.o();
            return true;
        L10:
            r102.f202822r = false;
            goto L11
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f202832a;

        @Override // java.lang.Runnable
        public final void run() {
            PhotoView r100 = this.f202832a;     // Catch: Throwable -> L6
            View.OnClickListener r101 = r100.f202814j;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.onClick(r100);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(PhotoView r100) {
            this.f202832a = r100;
        }
    }

    public class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f202833a;

        public c(PhotoView r100) {
            this.f202833a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r110) {
            this.f202833a.K.c();
            RectF r100 = this.f202833a.E;
            float r101 = r100.left + (r100.width() / 2.0f);
            RectF r102 = this.f202833a.E;
            float r103 = r102.top + (r102.height() / 2.0f);
            this.f202833a.I.set(r101, r103);
            this.f202833a.f202804J.set(r101, r103);
            PhotoView r104 = this.f202833a;
            r104.f202829y = 0;
            r104.f202830z = 0;
            if (r104.f202822r == false) goto L5;
            float r111 = r104.f202828x;
            float r105 = 1.0f;
        L6:
            this.f202833a.f202813i.reset();
            PhotoView r106 = this.f202833a;
            Matrix r107 = r106.f202813i;
            RectF r108 = r106.D;
            r107.postTranslate(-r108.left, -r108.top);
            PhotoView r109 = this.f202833a;
            Matrix r112 = r109.f202813i;
            PointF r113 = r109.f202804J;
            r112.postTranslate(r113.x, r113.y);
            PhotoView r114 = this.f202833a;
            r114.f202813i.postTranslate(-r114.A, -r114.B);
            PhotoView r115 = this.f202833a;
            Matrix r116 = r115.f202813i;
            float r117 = r115.f202827w;
            PointF r118 = r115.f202804J;
            r116.postRotate(r117, r118.x, r118.y);
            PhotoView r119 = this.f202833a;
            Matrix r120 = r119.f202813i;
            PointF r121 = r119.I;
            r120.postScale(r105, r105, r121.x, r121.y);
            PhotoView r122 = this.f202833a;
            r122.f202813i.postTranslate(r122.f202829y, r122.f202830z);
            PhotoView r123 = this.f202833a;
            r123.f202813i.mapRect(r123.F, r123.D);
            PhotoView r124 = this.f202833a;
            r124.n(r124.F);
            PhotoView r125 = this.f202833a;
            r125.f202822r = !r125.f202822r;
            j r126 = r125.K;
            r126.f202842d.startScroll((int) (r111 * 10000.0f), 0, (int) ((r105 - r111) * 10000.0f), 0, r126.f202852n.f202805a);
            j r127 = this.f202833a.K;
            r127.f202839a = true;
            r127.f202852n.post(r127);
            return false;
        L5:
            float r128 = r104.f202828x;
            float r129 = r104.f202806b;
            r104.I.set(r110.getX(), r110.getY());
            r111 = r128;
            r105 = r129;
            goto L6
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            if (this.f202833a.K.f202841c.isFinished() == true) goto L5;
            PhotoView r101 = this.f202833a;
            r101.f202824t = true;
            r101.K.f202841c.forceFinished(true);
        L5:
            PhotoView r102 = this.f202833a;
            r102.f202819o = false;
            r102.f202816l = false;
            r102.f202823s = false;
            r102.removeCallbacks(r102.R);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            PhotoView r101 = this.f202833a;
            View.OnLongClickListener r102 = r101.P;
            if (r102 == null) goto L6;
            r102.onLongClick(r101);
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            PhotoView r101 = this.f202833a;
            if (r101.f202824t == true) goto L5;
            r101.postDelayed(r101.R, 250);
        L5:
            this.f202833a.f202824t = false;
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r210, MotionEvent r211, float r212, float r310) {
            PhotoView r100 = this.f202833a;
            if (r100.f202816l == false) goto L6;
            return false;
        L6:
            if (r100.f202825u == true) goto L11;
            if (r100.f202826v == true) goto L11;
            return false;
        L11:
            if (r100.K.f202839a == false) goto L13;
            return false;
        L13:
            float r101 = Math.round(r100.E.left);
            PhotoView r102 = this.f202833a;
            if (r101 < r102.C.left) goto L16;
        L19:
            float r103 = 0.0f;
        L20:
            float r104 = Math.round(this.f202833a.E.top);
            PhotoView r105 = this.f202833a;
            if (r104 < r105.C.top) goto L23;
        L26:
            float r106 = 0.0f;
        L27:
            PhotoView r107 = this.f202833a;
            if (r107.f202823s == false) goto L30;
        L31:
            float r108 = r107.f202827w;
            float r109 = ((int) (r108 / 90.0f)) * 90;
            float r110 = r108 % 90.0f;
            if (r110 <= 45.0f) goto L35;
            r109 = r109 + 90.0f;
        L37:
            j r111 = r107.K;
            int r112 = (int) r108;
            r111.f202844f.startScroll(r112, 0, ((int) r109) - r112, 0, r111.f202852n.f202805a);
            this.f202833a.f202827w = r109;
        L38:
            PhotoView r113 = this.f202833a;
            r113.n(r113.E);
            j r114 = this.f202833a.K;
            r114.getClass();
            if (r103 >= 0.0f) goto L41;
            int r115 = Integer.MAX_VALUE;
        L42:
            r114.f202846h = r115;
            PhotoView r116 = r114.f202852n;
            if (r103 <= 0.0f) goto L45;
            float r117 = Math.abs(r116.E.left);
        L46:
            int r118 = (int) r117;
            if (r103 >= 0.0f) goto L49;
            r118 = Integer.MAX_VALUE - r118;
        L49:
            if (r103 >= 0.0f) goto L51;
            int r119 = r118;
        L52:
            if (r103 >= 0.0f) goto L54;
            int r120 = Integer.MAX_VALUE;
        L55:
            if (r103 >= 0.0f) goto L58;
            r118 = Integer.MAX_VALUE - r119;
        L58:
            if (r106 >= 0.0f) goto L60;
            int r121 = Integer.MAX_VALUE;
        L61:
            r114.f202847i = r121;
            PhotoView r122 = r114.f202852n;
            if (r106 <= 0.0f) goto L64;
            float r123 = Math.abs(r122.E.top);
        L65:
            int r124 = (int) r123;
            if (r106 >= 0.0f) goto L68;
            r124 = Integer.MAX_VALUE - r124;
        L68:
            if (r106 >= 0.0f) goto L70;
            int r125 = r124;
        L71:
            if (r106 >= 0.0f) goto L73;
            int r126 = Integer.MAX_VALUE;
        L74:
            if (r106 >= 0.0f) goto L76;
            r124 = Integer.MAX_VALUE - r125;
        L76:
            if (r103 != 0.0f) goto L78;
            int r213 = 0;
            int r214 = 0;
        L79:
            if (r106 != 0.0f) goto L81;
            int r215 = 0;
            int r216 = 0;
        L82:
            OverScroller r127 = r114.f202841c;
            int r128 = r114.f202846h;
            int r129 = r114.f202847i;
            int r130 = (int) r103;
            int r131 = (int) r106;
            int r132 = Math.abs(r118);
            int r133 = r114.f202852n.f202807c;
            if (r132 >= (r133 * 2)) goto L85;
            int r217 = 0;
        L86:
            int r134 = Math.abs(r124);
            int r135 = r114.f202852n.f202807c;
            if (r134 >= (r135 * 2)) goto L89;
            int r218 = 0;
        L90:
            r127.fling(r128, r129, r130, r131, r213, r214, r215, r216, r217, r218);
            j r136 = this.f202833a.K;
            r136.f202839a = true;
            r136.f202852n.post(r136);
            return super.onFling(r210, r211, r212, r310);
        L89:
            r218 = r135;
            goto L90
        L85:
            r217 = r133;
            goto L86
        L81:
            r215 = r125;
            r216 = r126;
            goto L82
        L78:
            r213 = r119;
            r214 = r120;
            goto L79
        L73:
            r126 = r124;
            goto L74
        L70:
            r125 = 0;
            goto L71
        L64:
            r123 = r122.E.bottom - r122.C.bottom;
            goto L65
        L60:
            r121 = 0;
            goto L61
        L54:
            r120 = r118;
            goto L55
        L51:
            r119 = 0;
            goto L52
        L45:
            r117 = r116.E.right - r116.C.right;
            goto L46
        L41:
            r115 = 0;
            goto L42
        L35:
            if (r110 >= (-45.0f)) goto L37;
            r109 = r109 - 90.0f;
            goto L37
        L30:
            if ((r107.f202827w % 90.0f) == 0.0f) goto L38;
        L23:
            if (Math.round(r105.E.bottom) <= this.f202833a.C.bottom) goto L26;
            r106 = r310;
            goto L27
        L16:
            if (Math.round(r102.E.right) <= this.f202833a.C.right) goto L19;
            r103 = r212;
            goto L20
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            j r104 = this.f202833a.K;
            if (r104.f202839a == false) goto L6;
            r104.c();
        L6:
            if (this.f202833a.l(r102) == true) goto L8;
            PhotoView r105 = this.f202833a;
            if (r105.f202825u == false) goto L21;
        L24:
            PhotoView.j(r105);
            PhotoView r106 = this.f202833a;
            if (r106.f202816l == false) goto L27;
        L36:
            PhotoView r107 = this.f202833a;
            r107.f202829y = (int) (r107.f202829y - r102);
            r107.f202811g.postTranslate(-r102, 0.0f);
            this.f202833a.f202819o = true;
        L38:
            if (this.f202833a.m(r103) == true) goto L40;
            PhotoView r108 = this.f202833a;
            if (r108.f202826v == false) goto L53;
        L56:
            PhotoView.j(r108);
            PhotoView r109 = this.f202833a;
            if (r109.f202816l == false) goto L59;
        L68:
            this.f202833a.f202811g.postTranslate(0.0f, -r103);
            PhotoView r110 = this.f202833a;
            r110.f202830z = (int) (r110.f202830z - r103);
            r110.f202819o = true;
        L69:
            this.f202833a.o();
            return true;
        L59:
            if (r103 >= 0.0f) goto L64;
            float r111 = r109.E.top;
            float r112 = r111 - r103;
            float r113 = r109.G.top;
            if (r112 <= r113) goto L64;
            r103 = r103 * (Math.abs(Math.abs(r111 - r113) - r109.f202808d) / r109.f202808d);
        L64:
            if (r103 <= 0.0f) goto L68;
            PhotoView r114 = this.f202833a;
            float r115 = r114.E.bottom;
            float r116 = r115 - r103;
            float r117 = r114.G.bottom;
            if (r116 >= r117) goto L68;
            r103 = r103 * (Math.abs(Math.abs(r115 - r117) - r114.f202808d) / r114.f202808d);
            goto L68
        L53:
            if (r108.f202819o == true) goto L56;
            if (r108.f202816l == false) goto L69;
        L40:
            if (r103 >= 0.0f) goto L45;
            PhotoView r118 = this.f202833a;
            float r119 = r118.E.top;
            if ((r119 - r103) <= r118.C.top) goto L45;
            r103 = r119;
        L45:
            if (r103 <= 0.0f) goto L49;
            PhotoView r120 = this.f202833a;
            float r121 = r120.E.bottom;
            float r122 = r121 - r103;
            float r123 = r120.C.bottom;
            if (r122 >= r123) goto L49;
            r103 = r121 - r123;
        L49:
            this.f202833a.f202811g.postTranslate(0.0f, -r103);
            PhotoView r124 = this.f202833a;
            r124.f202830z = (int) (r124.f202830z - r103);
            goto L69
        L27:
            if (r102 >= 0.0f) goto L32;
            float r125 = r106.E.left;
            float r126 = r125 - r102;
            float r127 = r106.G.left;
            if (r126 <= r127) goto L32;
            r102 = r102 * (Math.abs(Math.abs(r125 - r127) - r106.f202808d) / r106.f202808d);
        L32:
            if (r102 <= 0.0f) goto L36;
            PhotoView r128 = this.f202833a;
            float r129 = r128.E.right;
            float r130 = r129 - r102;
            float r131 = r128.G.right;
            if (r130 >= r131) goto L36;
            r102 = r102 * (Math.abs(Math.abs(r129 - r131) - r128.f202808d) / r128.f202808d);
            goto L36
        L21:
            if (r105.f202816l == true) goto L24;
            if (r105.f202819o == false) goto L38;
        L8:
            if (r102 >= 0.0f) goto L13;
            PhotoView r132 = this.f202833a;
            float r133 = r132.E.left;
            if ((r133 - r102) <= r132.C.left) goto L13;
            r102 = r133;
        L13:
            if (r102 <= 0.0f) goto L17;
            PhotoView r134 = this.f202833a;
            float r135 = r134.E.right;
            float r136 = r135 - r102;
            float r137 = r134.C.right;
            if (r136 >= r137) goto L17;
            r102 = r135 - r137;
        L17:
            this.f202833a.f202811g.postTranslate(-r102, 0.0f);
            PhotoView r138 = this.f202833a;
            r138.f202829y = (int) (r138.f202829y - r102);
            goto L38
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f202834a = null;

        static {
            int[] r100 = new int[ImageView.ScaleType.values().length];
            f202834a = r100;
            r100[ImageView.ScaleType.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f202834a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f202834a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f202834a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f202834a[ImageView.ScaleType.FIT_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f202834a[ImageView.ScaleType.FIT_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f202834a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public interface e {
        float a();
    }

    public class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f202835a;

        @Override // com.bytedance.commerce.base.preview.view.image.PhotoView.e
        public final float a() {
            return this.f202835a.E.bottom;
        }

        public f(PhotoView r100) {
            this.f202835a = r100;
        }
    }

    public class g implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Interpolator f202836a;

        public g() {
            this.f202836a = new DecelerateInterpolator();
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            Interpolator r101 = this.f202836a;
            if (r101 != null) goto L5;
            return r100;
        L5:
            return r101.getInterpolation(r100);
        }
    }

    public class h implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f202837a;

        @Override // com.bytedance.commerce.base.preview.view.image.PhotoView.e
        public final float a() {
            RectF r100 = this.f202837a.E;
            return (r100.top + r100.bottom) / 2.0f;
        }

        public h(PhotoView r100) {
            this.f202837a = r100;
        }
    }

    public class i implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f202838a;

        @Override // com.bytedance.commerce.base.preview.view.image.PhotoView.e
        public final float a() {
            return this.f202838a.E.top;
        }

        public i(PhotoView r100) {
            this.f202838a = r100;
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f202839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OverScroller f202840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OverScroller f202841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Scroller f202842d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Scroller f202843e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Scroller f202844f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public e f202845g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f202846h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f202847i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f202848j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f202849k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final RectF f202850l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final g f202851m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ PhotoView f202852n;

        public final void a() {
            this.f202852n.f202811g.reset();
            PhotoView r100 = this.f202852n;
            Matrix r101 = r100.f202811g;
            RectF r102 = r100.D;
            r101.postTranslate(-r102.left, -r102.top);
            PhotoView r103 = this.f202852n;
            Matrix r104 = r103.f202811g;
            PointF r105 = r103.f202804J;
            r104.postTranslate(r105.x, r105.y);
            PhotoView r106 = this.f202852n;
            r106.f202811g.postTranslate(-r106.A, -r106.B);
            PhotoView r107 = this.f202852n;
            Matrix r108 = r107.f202811g;
            float r109 = r107.f202827w;
            PointF r110 = r107.f202804J;
            r108.postRotate(r109, r110.x, r110.y);
            PhotoView r111 = this.f202852n;
            Matrix r112 = r111.f202811g;
            float r113 = r111.f202828x;
            PointF r114 = r111.I;
            r112.postScale(r113, r113, r114.x, r114.y);
            PhotoView r115 = this.f202852n;
            r115.f202811g.postTranslate(r115.f202829y, r115.f202830z);
            this.f202852n.o();
        }

        public final void b() {
            boolean r100 = false;
            boolean r101 = true;
            if (this.f202842d.computeScrollOffset() == false) goto L5;
            this.f202852n.f202828x = this.f202842d.getCurrX() / 10000.0f;
            boolean r102 = false;
        L7:
            if (this.f202840b.computeScrollOffset() == false) goto L10;
            int r103 = this.f202840b.getCurrX() - this.f202848j;
            int r104 = this.f202840b.getCurrY() - this.f202849k;
            PhotoView r105 = this.f202852n;
            r105.f202829y += r103;
            r105.f202830z += r104;
            this.f202848j = this.f202840b.getCurrX();
            this.f202849k = this.f202840b.getCurrY();
            r102 = false;
        L10:
            if (this.f202841c.computeScrollOffset() == false) goto L13;
            int r106 = this.f202841c.getCurrX() - this.f202846h;
            int r107 = this.f202841c.getCurrY() - this.f202847i;
            this.f202846h = this.f202841c.getCurrX();
            this.f202847i = this.f202841c.getCurrY();
            PhotoView r108 = this.f202852n;
            r108.f202829y += r106;
            r108.f202830z += r107;
            r102 = false;
        L13:
            if (this.f202844f.computeScrollOffset() == false) goto L16;
            this.f202852n.f202827w = this.f202844f.getCurrX();
            r102 = false;
        L16:
            if (this.f202843e.computeScrollOffset() == false) goto L18;
        L19:
            float r109 = this.f202843e.getCurrX() / 10000.0f;
            float r110 = this.f202843e.getCurrY() / 10000.0f;
            PhotoView r111 = this.f202852n;
            Matrix r112 = r111.f202813i;
            RectF r113 = r111.E;
            r112.setScale(r109, r110, (r113.left + r113.right) / 2.0f, this.f202845g.a());
            PhotoView r114 = this.f202852n;
            r114.f202813i.mapRect(this.f202850l, r114.E);
            if (r109 != 1.0f) goto L23;
            RectF r115 = this.f202850l;
            RectF r116 = this.f202852n.C;
            r115.left = r116.left;
            r115.right = r116.right;
        L23:
            if (r110 != 1.0f) goto L25;
            RectF r117 = this.f202850l;
            RectF r118 = this.f202852n.C;
            r117.top = r118.top;
            r117.bottom = r118.bottom;
        L25:
            this.f202852n.L = this.f202850l;
        L26:
            if (r102 == true) goto L30;
            a();
            if (this.f202839a == false) goto L54;
            this.f202852n.post(this);
            return;
        L54:
            return;
        L30:
            this.f202839a = false;
            PhotoView r119 = this.f202852n;
            if (r119.f202825u == false) goto L39;
            RectF r120 = r119.E;
            float r121 = r120.left;
            if (r121 <= 0.0f) goto L36;
            r119.f202829y = (int) (r119.f202829y - r121);
        L38:
            r100 = true;
            goto L39
        L36:
            if (r120.right >= r119.C.width()) goto L38;
            PhotoView r122 = this.f202852n;
            r122.f202829y -= (int) (r122.C.width() - this.f202852n.E.right);
        L39:
            PhotoView r123 = this.f202852n;
            if (r123.f202826v == false) goto L47;
            RectF r124 = r123.E;
            float r125 = r124.top;
            if (r125 <= 0.0f) goto L45;
            r123.f202830z = (int) (r123.f202830z - r125);
        L48:
            if (r101 == false) goto L50;
            a();
        L50:
            this.f202852n.invalidate();
            Runnable r126 = this.f202852n.O;
            if (r126 == null) goto L56;
            r126.run();
            this.f202852n.O = null;
            return;
        L56:
            return;
        L45:
            if (r124.bottom >= r123.C.height()) goto L48;
            PhotoView r127 = this.f202852n;
            r127.f202830z -= (int) (r127.C.height() - this.f202852n.E.bottom);
            goto L48
        L47:
            r101 = r100;
            goto L48
        L18:
            if (this.f202852n.L == null) goto L26;
        L5:
            r102 = true;
            goto L7
        }

        public final void c() {
            this.f202852n.removeCallbacks(this);
            this.f202840b.abortAnimation();
            this.f202842d.abortAnimation();
            this.f202841c.abortAnimation();
            this.f202844f.abortAnimation();
            this.f202839a = false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(PhotoView r100) {
            this.f202852n = r100;
            this.f202850l = new RectF();
            g r101 = new g();
            this.f202851m = r101;
            Context r102 = r100.getContext();
            this.f202840b = new OverScroller(r102, r101);
            this.f202842d = new Scroller(r102, r101);
            this.f202841c = new OverScroller(r102, r101);
            this.f202843e = new Scroller(r102, r101);
            this.f202844f = new Scroller(r102, r101);
        }
    }

    public int getDefaultAnimaDuring() {
        return 340;
    }

    public yf4.a getInfo() {
        RectF r100 = new RectF();
        int[] r101 = new int[2];
        r101[0] = r101[0] + getLeft();
        r101[1] = r101[1] + getTop();
        Object r102 = getParent();
    L4:
        if ((r102 instanceof View) == false) goto L9;
        View r103 = (View) r102;
        if (r103.getId() == 16908290) goto L10;
        r101[0] = r101[0] - r103.getScrollX();
        r101[1] = r101[1] - r103.getScrollY();
        r101[0] = r101[0] + r103.getLeft();
        r101[1] = r101[1] + r103.getTop();
        r102 = r103.getParent();
    L10:
        float r104 = r101[0];
        RectF r105 = this.E;
        float r106 = r105.left + r104;
        float r107 = r101[1];
        r100.set(r106, r105.top + r107, r104 + r105.right, r107 + r105.bottom);
        return new yf4.a(r100, this.E, this.C, this.D, this.H, this.f202827w, this.f202815k);
    L9:
        r101[0] = (int) (r101[0] + 0.5f);
        r101[1] = (int) (r101[1] + 0.5f);
        goto L10
    }

    public final void init() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
        if (this.f202815k != null) goto L5;
        this.f202815k = ImageView.ScaleType.CENTER_INSIDE;
    L5:
        new GestureDetector(getContext(), this.S);
        new ScaleGestureDetector(getContext(), this.Q);
        Resources r100 = getResources();
        float r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
        this.f202807c = (int) (30.0f * r101);
        this.f202808d = (int) (r101 * 140.0f);
        this.f202805a = 340;
        this.f202806b = 2.5f;
    }

    public final void o() {
        this.f202812h.set(this.f202810f);
        this.f202812h.postConcat(this.f202811g);
        setImageMatrix(this.f202812h);
        this.f202811g.mapRect(this.E, this.D);
        boolean r100 = true;
        if (this.E.width() <= this.C.width()) goto L5;
        boolean r101 = true;
    L6:
        this.f202825u = r101;
        if (this.E.height() > this.C.height()) goto L10;
        r100 = false;
    L10:
        this.f202826v = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void r() {
        if (this.f202817m == true) goto L6;
        return;
    L6:
        if (this.f202818n == true) goto L8;
        return;
    L8:
        this.f202810f.reset();
        this.f202811g.reset();
        this.f202822r = false;
        Drawable r100 = getDrawable();
        int r101 = getWidth();
        int r102 = getHeight();
        int r103 = q(r100);
        int r104 = p(r100);
        float r105 = r103;
        float r106 = r104;
        this.D.set(0.0f, 0.0f, r105, r106);
        int r107 = (r101 - r103) / 2;
        int r110 = (r102 - r104) / 2;
        if (r103 <= r101) goto L11;
        float r108 = r101 / r105;
    L12:
        if (r104 <= r102) goto L14;
        float r109 = r102 / r106;
    L16:
        if (r108 < r109) goto L19;
        r108 = r109;
    L19:
        this.f202810f.reset();
        this.f202810f.postTranslate(r107, r110);
        Matrix r111 = this.f202810f;
        PointF r112 = this.H;
        r111.postScale(r108, r108, r112.x, r112.y);
        this.f202810f.mapRect(this.D);
        this.A = this.D.width() / 2.0f;
        this.B = this.D.height() / 2.0f;
        this.I.set(this.H);
        this.f202804J.set(this.I);
        o();
        switch(d.f202834a[this.f202815k.ordinal()]) {
            case 1: goto L45;
            case 2: goto L36;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            default: goto L59;
        };
    L22:
        float r113 = this.C.width() / this.E.width();
        float r114 = this.C.height() / this.E.height();
        Matrix r115 = this.f202811g;
        PointF r116 = this.H;
        r115.postScale(r113, r114, r116.x, r116.y);
        o();
        t();
        goto L59
    L23:
        s();
        float r117 = this.C.bottom - this.E.bottom;
        this.f202830z = (int) (this.f202830z + r117);
        this.f202811g.postTranslate(0.0f, r117);
        o();
        t();
        goto L59
    L24:
        s();
        float r118 = -this.E.top;
        this.f202830z = (int) (this.f202830z + r118);
        this.f202811g.postTranslate(0.0f, r118);
        o();
        t();
        goto L59
    L25:
        s();
    L59:
        this.f202820p = true;
        if (this.M != null) goto L62;
    L89:
        this.M = null;
        if (r104 <= (r103 * 3)) goto L93;
        this.f202811g.postTranslate(0.0f, -this.E.top);
        this.f202830z = (int) (this.f202830z - this.E.top);
        o();
        return;
    L93:
        return;
    L62:
        if ((System.currentTimeMillis() - this.N) >= this.f202809e) goto L89;
        yf4.a r119 = this.M;
        if (this.f202820p == false) goto L88;
        this.f202811g.reset();
        o();
        this.f202828x = 1.0f;
        this.f202829y = 0;
        this.f202830z = 0;
        yf4.a r120 = getInfo();
        float r121 = r119.f567446b.width() / r120.f567446b.width();
        float r122 = r119.f567446b.height() / r120.f567446b.height();
        if (r121 < r122) goto L69;
        r121 = r122;
    L69:
        RectF r123 = r119.f567445a;
        float r124 = r123.left + (r123.width() / 2.0f);
        RectF r125 = r119.f567445a;
        float r126 = r125.top + (r125.height() / 2.0f);
        this.f202811g.reset();
        Matrix r127 = this.f202811g;
        RectF r128 = this.D;
        r127.postTranslate(-r128.left, -r128.top);
        this.f202811g.postTranslate(r124 - (this.D.width() / 2.0f), r126 - (this.D.height() / 2.0f));
        this.f202811g.postScale(r121, r121, r124, r126);
        this.f202811g.postRotate(r119.f567448d, r124, r126);
        o();
        this.I.set(r124, r126);
        this.f202804J.set(r124, r126);
        j r129 = this.K;
        PointF r130 = this.H;
        int r131 = (int) (r130.x - r124);
        int r132 = (int) (r130.y - r126);
        r129.f202848j = 0;
        r129.f202849k = 0;
        r129.f202840b.startScroll(0, 0, r131, r132, r129.f202852n.f202805a);
        j r133 = this.K;
        r133.f202842d.startScroll((int) (r121 * 10000.0f), 0, (int) ((1.0f - r121) * 10000.0f), 0, r133.f202852n.f202805a);
        j r134 = this.K;
        int r135 = (int) r119.f567448d;
        r134.f202844f.startScroll(r135, 0, 0 - r135, 0, r134.f202852n.f202805a);
        if (r119.f567447c.width() >= r119.f567446b.width()) goto L72;
    L73:
        float r136 = r119.f567447c.width() / r119.f567446b.width();
        float r137 = r119.f567447c.height() / r119.f567446b.height();
        if (r136 <= 1.0f) goto L77;
        r136 = 1.0f;
    L77:
        if (r137 <= 1.0f) goto L79;
        r137 = 1.0f;
    L79:
        ImageView.ScaleType r138 = r119.f567449e;
        if (r138 != ImageView.ScaleType.FIT_START) goto L83;
        e r139 = new i(this);
    L86:
        j r140 = this.K;
        r140.f202843e.startScroll((int) (r136 * 10000.0f), (int) (r137 * 10000.0f), (int) ((1.0f - r136) * 10000.0f), (int) ((1.0f - r137) * 10000.0f), this.f202805a / 3);
        r140.f202845g = r139;
        Matrix r141 = this.f202813i;
        RectF r142 = this.E;
        r141.setScale(r136, r137, (r142.left + r142.right) / 2.0f, r139.a());
        this.f202813i.mapRect(this.K.f202850l, this.E);
        this.L = this.K.f202850l;
    L87:
        j r143 = this.K;
        r143.f202839a = true;
        r143.f202852n.post(r143);
        goto L89
    L83:
        if (r138 != ImageView.ScaleType.FIT_END) goto L85;
        r139 = new f(this);
        goto L86
    L85:
        r139 = new h(this);
        goto L86
    L72:
        if (r119.f567447c.height() >= r119.f567446b.height()) goto L87;
    L88:
        this.M = r119;
        this.N = System.currentTimeMillis();
        goto L89
    L27:
        if (this.E.width() <= this.C.width()) goto L29;
    L30:
        float r144 = this.C.width() / this.E.width();
        float r145 = this.C.height() / this.E.height();
        if (r144 < r145) goto L34;
        r144 = r145;
    L34:
        this.f202828x = r144;
        Matrix r146 = this.f202811g;
        PointF r147 = this.H;
        r146.postScale(r144, r144, r147.x, r147.y);
        o();
        t();
        goto L59
    L29:
        if (this.E.height() <= this.C.height()) goto L59;
    L36:
        if (this.E.width() >= this.C.width()) goto L38;
    L39:
        float r148 = this.C.width() / this.E.width();
        float r149 = this.C.height() / this.E.height();
        if (r148 > r149) goto L43;
        r148 = r149;
    L43:
        this.f202828x = r148;
        Matrix r150 = this.f202811g;
        PointF r151 = this.H;
        r150.postScale(r148, r148, r151.x, r151.y);
        o();
        t();
        goto L59
    L38:
        if (this.E.height() >= this.C.height()) goto L59;
    L45:
        if (this.f202817m == false) goto L59;
        if (this.f202818n == false) goto L59;
        Drawable r152 = getDrawable();
        int r153 = q(r152);
        int r154 = p(r152);
        float r155 = r153;
        if (r155 <= this.C.width()) goto L53;
    L54:
        float r156 = r155 / this.E.width();
        float r157 = r154 / this.E.height();
        if (r156 > r157) goto L58;
        r156 = r157;
    L58:
        this.f202828x = r156;
        Matrix r158 = this.f202811g;
        PointF r159 = this.H;
        r158.postScale(r156, r156, r159.x, r159.y);
        o();
        t();
        goto L59
    L53:
        if (r154 <= this.C.height()) goto L59;
    L14:
        r109 = 1.0f;
        goto L16
    L11:
        r108 = 1.0f;
        goto L12
    }

    public final void s() {
        if (this.E.width() >= this.C.width()) goto L6;
        float r100 = this.C.width() / this.E.width();
        this.f202828x = r100;
        Matrix r101 = this.f202811g;
        PointF r102 = this.H;
        r101.postScale(r100, r100, r102.x, r102.y);
        o();
        t();
        return;
    }

    public final void t() {
        Drawable r100 = getDrawable();
        this.D.set(0.0f, 0.0f, q(r100), p(r100));
        this.f202810f.set(this.f202812h);
        this.f202810f.mapRect(this.D);
        this.A = this.D.width() / 2.0f;
        this.B = this.D.height() / 2.0f;
        this.f202828x = 1.0f;
        this.f202829y = 0;
        this.f202830z = 0;
        this.f202811g.reset();
    }

    public int getAnimaDuring() {
        return this.f202805a;
    }

    public float getMaxScale() {
        return this.f202806b;
    }

    public PhotoView(Context r100) {
        super(r100);
        this.f202807c = 0;
        this.f202808d = 0;
        this.f202809e = 500;
        this.f202810f = new Matrix();
        this.f202811g = new Matrix();
        this.f202812h = new Matrix();
        this.f202813i = new Matrix();
        this.f202828x = 1.0f;
        this.C = new RectF();
        this.D = new RectF();
        this.E = new RectF();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new PointF();
        this.I = new PointF();
        this.f202804J = new PointF();
        this.K = new j(this);
        this.Q = new a(this);
        this.R = new b(this);
        this.S = new c(this);
        init();
    }

    public static void j(PhotoView r100) {
        if (r100.f202819o == true) goto L28;
        RectF r101 = r100.C;
        RectF r102 = r100.E;
        RectF r103 = r100.G;
        float r104 = r101.left;
        float r105 = r102.left;
        if (r104 > r105) goto L8;
        r104 = r105;
    L8:
        float r106 = r101.right;
        float r107 = r102.right;
        if (r106 < r107) goto L13;
        r106 = r107;
    L13:
        if (r104 <= r106) goto L15;
        r103.set(0.0f, 0.0f, 0.0f, 0.0f);
        return;
    L15:
        float r108 = r101.top;
        float r109 = r102.top;
        if (r108 > r109) goto L19;
        r108 = r109;
    L19:
        float r110 = r101.bottom;
        float r111 = r102.bottom;
        if (r110 < r111) goto L24;
        r110 = r111;
    L24:
        if (r108 <= r110) goto L26;
        r103.set(0.0f, 0.0f, 0.0f, 0.0f);
        return;
    L26:
        r103.set(r104, r108, r106, r110);
        return;
    }

    public static int p(Drawable r100) {
        int r101 = r100.getIntrinsicHeight();
        if (r101 > 0) goto L5;
        r101 = r100.getMinimumHeight();
    L5:
        if (r101 <= 0) goto L7;
        return r101;
    L7:
        return r100.getBounds().height();
    }

    public static int q(Drawable r100) {
        int r101 = r100.getIntrinsicWidth();
        if (r101 > 0) goto L5;
        r101 = r100.getMinimumWidth();
    L5:
        if (r101 <= 0) goto L7;
        return r101;
    L7:
        return r100.getBounds().width();
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f202816l == false) goto L7;
        return true;
    L7:
        return l(r100);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f202816l == false) goto L7;
        return true;
    L7:
        return m(r100);
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        RectF r101 = this.L;
        if (r101 == null) goto L5;
        r100.clipRect(r101);
        this.L = null;
    L5:
        super.draw(r100);
    }

    public final boolean l(float r100) {
        if (this.E.width() > this.C.width()) goto L6;
        return false;
    L6:
        if (r100 >= 0.0f) goto L11;
        if ((Math.round(this.E.left) - r100) < this.C.left) goto L11;
        return false;
    L11:
        if (r100 > 0.0f) goto L13;
        return true;
    L13:
        if ((Math.round(this.E.right) - r100) > this.C.right) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean m(float r100) {
        if (this.E.height() > this.C.height()) goto L6;
        return false;
    L6:
        if (r100 >= 0.0f) goto L11;
        if ((Math.round(this.E.top) - r100) < this.C.top) goto L11;
        return false;
    L11:
        if (r100 > 0.0f) goto L13;
        return true;
    L13:
        if ((Math.round(this.E.bottom) - r100) > this.C.bottom) goto L17;
        return false;
    L17:
        return true;
    }

    public final void n(RectF r110) {
        boolean r100 = true;
        if (r110.width() <= this.C.width()) goto L5;
        float r101 = r110.left;
        RectF r102 = this.C;
        float r103 = r102.left;
        if (r101 <= r103) goto L13;
        float r104 = r101 - r103;
    L16:
        int r105 = (int) r104;
    L19:
        if (r110.height() <= this.C.height()) goto L21;
        float r106 = r110.top;
        RectF r107 = this.C;
        float r108 = r107.top;
        if (r106 <= r108) goto L29;
        int r111 = (int) (r106 - r108);
    L33:
        if (r105 != 0) goto L36;
        if (r111 != 0) goto L36;
        return;
    L36:
        if (this.K.f202841c.isFinished() == true) goto L38;
        this.K.f202841c.abortAnimation();
    L38:
        j r109 = this.K;
        r109.f202848j = 0;
        r109.f202849k = 0;
        r109.f202840b.startScroll(0, 0, -r105, -r111, r109.f202852n.f202805a);
        return;
    L29:
        float r112 = r110.bottom;
        float r113 = r107.bottom;
        if (r112 >= r113) goto L32;
        r111 = (int) (r112 - r113);
    L32:
        r111 = 0;
        goto L33
    L21:
        if (Math.abs(Math.round(r110.top) - ((this.C.height() - r110.height()) / 2.0f)) < 1.0f) goto L24;
        r100 = false;
    L24:
        if (r100 == true) goto L32;
        r111 = -((int) (((this.C.height() - r110.height()) / 2.0f) - r110.top));
        goto L33
    L13:
        float r114 = r110.right;
        float r115 = r102.right;
        if (r114 >= r115) goto L17;
        r104 = r114 - r115;
    L17:
        r105 = 0;
        goto L19
    L5:
        if (Math.abs(Math.round(r110.left) - ((this.C.width() - r110.width()) / 2.0f)) >= 1.0f) goto L7;
        boolean r116 = true;
    L8:
        if (r116 == true) goto L17;
        r105 = -((int) (((this.C.width() - r110.width()) / 2.0f) - r110.left));
        goto L19
    L7:
        r116 = false;
        goto L8
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean r100) {
        super.setAdjustViewBounds(r100);
        this.f202821q = r100;
    }

    public void setAnimaDuring(int r100) {
        this.f202805a = r100;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        boolean r101 = false;
        if (r100 != null) goto L7;
        this.f202817m = false;
        return;
    L7:
        if (r100.getIntrinsicHeight() <= 0) goto L11;
        if (r100.getIntrinsicWidth() <= 0) goto L11;
    L19:
        r101 = true;
    L20:
        if (r101 == true) goto L23;
        return;
    L23:
        if (this.f202817m == true) goto L25;
        this.f202817m = true;
    L25:
        r();
        return;
    L11:
        if (r100.getMinimumWidth() <= 0) goto L15;
        if (r100.getMinimumHeight() > 0) goto L19;
    L15:
        if (r100.getBounds().width() <= 0) goto L20;
        if (r100.getBounds().height() > 0) goto L19;
        goto L19
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r100) {
        Drawable r101 = getResources().getDrawable(r100);     // Catch: Exception -> L4
    L5:
        setImageDrawable(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public void setInterpolator(Interpolator r100) {
        this.K.f202851m.f202836a = r100;
    }

    public void setMaxAnimFromWaiteTime(int r100) {
        this.f202809e = r100;
    }

    public void setMaxScale(float r100) {
        this.f202806b = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        super.setOnClickListener(r100);
        this.f202814j = r100;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        this.P = r100;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r100) {
        ImageView.ScaleType r101 = this.f202815k;
        this.f202815k = r100;
        if (r101 == r100) goto L6;
        r();
        return;
    }

    public PhotoView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f202807c = 0;
        this.f202808d = 0;
        this.f202809e = 500;
        this.f202810f = new Matrix();
        this.f202811g = new Matrix();
        this.f202812h = new Matrix();
        this.f202813i = new Matrix();
        this.f202828x = 1.0f;
        this.C = new RectF();
        this.D = new RectF();
        this.E = new RectF();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new PointF();
        this.I = new PointF();
        this.f202804J = new PointF();
        this.K = new j(this);
        this.Q = new a(this);
        this.R = new b(this);
        this.S = new c(this);
        init();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r110, int r111) {
        if (this.f202817m == true) goto L6;
        super.onMeasure(r110, r111);
        return;
    L6:
        Drawable r100 = getDrawable();
        int r101 = q(r100);
        int r102 = p(r100);
        int r103 = View.MeasureSpec.getSize(r110);
        int r104 = View.MeasureSpec.getSize(r111);
        int r112 = View.MeasureSpec.getMode(r110);
        int r113 = View.MeasureSpec.getMode(r111);
        ViewGroup.LayoutParams r105 = getLayoutParams();
        if (r105 != null) goto L9;
        r105 = new ViewGroup.LayoutParams(-2, -2);
    L9:
        int r106 = r105.width;
        if (r106 != (-1)) goto L13;
        if (r112 == 0) goto L18;
    L19:
        int r114 = r105.height;
        if (r114 != (-1)) goto L23;
        if (r113 != 0) goto L30;
    L28:
        r104 = r102;
    L30:
        if (this.f202821q == false) goto L43;
        float r115 = r101;
        float r107 = r102;
        float r108 = r103;
        float r109 = r104;
        if ((r115 / r107) == (r108 / r109)) goto L43;
        float r116 = r109 / r107;
        float r117 = r108 / r115;
        if (r116 < r117) goto L37;
        r116 = r117;
    L37:
        if (r106 == (-1)) goto L40;
        r103 = (int) (r115 * r116);
    L40:
        if (r114 == (-1)) goto L43;
        r104 = (int) (r107 * r116);
    L43:
        setMeasuredDimension(r103, r104);
        return;
    L23:
        if (r113 == 1073741824) goto L30;
        if (r113 != Integer.MIN_VALUE) goto L28;
        if (r102 <= r104) goto L28;
    L18:
        r103 = r101;
        goto L19
    L13:
        if (r112 == 1073741824) goto L19;
        if (r112 != Integer.MIN_VALUE) goto L18;
        if (r101 <= r103) goto L18;
        goto L18
    }

    public PhotoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f202807c = 0;
        this.f202808d = 0;
        this.f202809e = 500;
        this.f202810f = new Matrix();
        this.f202811g = new Matrix();
        this.f202812h = new Matrix();
        this.f202813i = new Matrix();
        this.f202828x = 1.0f;
        this.C = new RectF();
        this.D = new RectF();
        this.E = new RectF();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new PointF();
        this.I = new PointF();
        this.f202804J = new PointF();
        this.K = new j(this);
        this.Q = new a(this);
        this.R = new b(this);
        this.S = new c(this);
        init();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = r100;
        float r105 = r101;
        this.C.set(0.0f, 0.0f, r104, r105);
        this.H.set(r104 * 0.5f, r105 * 0.5f);
        if (this.f202818n == true) goto L6;
        this.f202818n = true;
        r();
        return;
    }
}
