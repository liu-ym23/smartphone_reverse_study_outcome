package com.ss.android.lark.widget.photopicker.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public class TouchImageView extends AppCompatImageView {
    public static final /* synthetic */ int B = 0;
    public View.OnTouchListener A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f447679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Matrix f447680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Matrix f447681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public State f447682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f447683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f447684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f447685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f447686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f447687i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f447688j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f447689k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView.ScaleType f447690l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f447691m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f447692n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public i f447693o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f447694p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f447695q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f447696r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f447697s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f447698t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f447699u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f447700v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f447701w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ScaleGestureDetector f447702x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public GestureDetector f447703y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public GestureDetector.OnDoubleTapListener f447704z;

    public static final enum State extends Enum<State> {
        public static final State ANIMATE_ZOOM = null;
        public static final State DRAG = null;
        public static final State FLING = null;
        public static final State NONE = null;
        public static final State ZOOM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f447705a = null;

        static {
            State r100 = new State(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            State r101 = new State("DRAG", 1);
            DRAG = r101;
            State r102 = new State("ZOOM", 2);
            ZOOM = r102;
            State r103 = new State("FLING", 3);
            FLING = r103;
            State r104 = new State("ANIMATE_ZOOM", 4);
            ANIMATE_ZOOM = r104;
            f447705a = new State[]{r100, r101, r102, r103, r104};
        }

        public static State[] values() {
            return (State[]) f447705a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f447706a = null;

        static {
            int[] r100 = new int[ImageView.ScaleType.values().length];
            f447706a = r100;
            r100[ImageView.ScaleType.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f447706a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f447706a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f447706a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f447706a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OverScroller f447707a;

        public b(Context r100) {
            this.f447707a = new OverScroller(r100);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f447708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f447709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f447710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f447711d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f447712e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f447713f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AccelerateDecelerateInterpolator f447714g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final PointF f447715h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final PointF f447716i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ TouchImageView f447717j;

        public final void a() {
            float r100 = this.f447714g.getInterpolation(Math.min(1.0f, (System.currentTimeMillis() - this.f447708a) / 500.0f));
            float r101 = this.f447709b;
            double r102 = r101 + ((this.f447710c - r101) * r100);
            TouchImageView r103 = this.f447717j;
            r103.s(r102 / ((double) r103.f447679a), this.f447711d, this.f447712e, this.f447713f);
            PointF r104 = this.f447715h;
            float r105 = r104.x;
            PointF r106 = this.f447716i;
            float r107 = r105 + ((r106.x - r105) * r100);
            float r108 = r104.y;
            float r109 = r108 + ((r106.y - r108) * r100);
            PointF r110 = TouchImageView.n(this.f447717j, this.f447711d, this.f447712e);
            this.f447717j.f447680b.postTranslate(r107 - r110.x, r109 - r110.y);
            this.f447717j.p();
            TouchImageView r111 = this.f447717j;
            r111.setImageMatrix(r111.f447680b);
            this.f447717j.getClass();
            if (r100 >= 1.0f) goto L5;
            this.f447717j.postOnAnimation(this);
            return;
        L5:
            TouchImageView.j(this.f447717j, State.NONE);
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

        public c(TouchImageView r100, float r101, float r102, float r103, boolean r104) {
            this.f447717j = r100;
            this.f447714g = new AccelerateDecelerateInterpolator();
            TouchImageView.j(r100, State.ANIMATE_ZOOM);
            this.f447708a = System.currentTimeMillis();
            this.f447709b = r100.f447679a;
            this.f447710c = r101;
            this.f447713f = r104;
            PointF r105 = r100.v(r102, r103, false);
            float r106 = r105.x;
            this.f447711d = r106;
            float r107 = r105.y;
            this.f447712e = r107;
            this.f447715h = TouchImageView.n(r100, r106, r107);
            this.f447716i = new PointF(r100.f447694p / 2, r100.f447695q / 2);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f447718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f447719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f447720c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TouchImageView f447721d;

        public final void a() {
            TouchImageView r100 = this.f447721d;
            int r101 = TouchImageView.B;
            r100.getClass();
            if (this.f447718a.f447707a.isFinished() == false) goto L6;
            this.f447718a = null;
            return;
        L6:
            b r102 = this.f447718a;
            r102.f447707a.computeScrollOffset();
            if (r102.f447707a.computeScrollOffset() == false) goto L10;
            int r103 = this.f447718a.f447707a.getCurrX();
            int r104 = this.f447718a.f447707a.getCurrY();
            int r105 = r103 - this.f447719b;
            int r106 = r104 - this.f447720c;
            this.f447719b = r103;
            this.f447720c = r104;
            this.f447721d.f447680b.postTranslate(r105, r106);
            this.f447721d.q();
            TouchImageView r107 = this.f447721d;
            r107.setImageMatrix(r107.f447680b);
            this.f447721d.postOnAnimation(this);
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

        public d(TouchImageView r110, int r111, int r112) {
            this.f447721d = r110;
            TouchImageView.j(r110, State.FLING);
            this.f447718a = new b(r110.f447688j);
            r110.f447680b.getValues(r110.f447687i);
            float[] r100 = r110.f447687i;
            int r101 = (int) r100[2];
            int r102 = (int) r100[5];
            float r103 = TouchImageView.l(r110);
            int r104 = r110.f447694p;
            if (r103 <= r104) goto L5;
            int r105 = r104 - ((int) TouchImageView.l(r110));
            int r106 = 0;
        L6:
            float r107 = TouchImageView.m(r110);
            int r108 = r110.f447695q;
            if (r107 <= r108) goto L9;
            int r109 = r108 - ((int) TouchImageView.m(r110));
            int r113 = 0;
        L10:
            this.f447718a.f447707a.fling(r101, r102, r111, r112, r105, r106, r109, r113);
            this.f447719b = r101;
            this.f447720c = r102;
            return;
        L9:
            r109 = r102;
            r113 = r109;
            goto L10
        L5:
            r105 = r101;
            r106 = r105;
            goto L6
        }
    }

    public class e extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchImageView f447722a;

        public e(TouchImageView r100) {
            this.f447722a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            GestureDetector.OnDoubleTapListener r101 = this.f447722a.f447704z;
            if (r101 == null) goto L5;
            boolean r102 = r101.onDoubleTap(r100);
        L6:
            TouchImageView r103 = this.f447722a;
            if (r103.f447682d != State.NONE) goto L14;
            float r104 = r103.f447679a;
            float r105 = r103.f447683e;
            if (r104 != r105) goto L11;
            float r106 = r103.f447684f;
        L12:
            c r107 = new c(r103, r106, r100.getX(), r100.getY(), false);
            this.f447722a.postOnAnimation(r107);
            return true;
        L11:
            r106 = r105;
            goto L12
        L14:
            return r102;
        L5:
            r102 = false;
            goto L6
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTapEvent(MotionEvent r100) {
            GestureDetector.OnDoubleTapListener r101 = this.f447722a.f447704z;
            if (r101 != null) goto L5;
            return false;
        L5:
            return r101.onDoubleTapEvent(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            this.f447722a.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            TouchImageView r101 = this.f447722a;
            GestureDetector.OnDoubleTapListener r102 = r101.f447704z;
            if (r102 == null) goto L7;
            return r102.onSingleTapConfirmed(r100);
        L7:
            return r101.performClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            d r104 = this.f447722a.f447689k;
            if (r104 != null) goto L5;
        L7:
            TouchImageView r105 = this.f447722a;
            r105.f447689k = new d(r105, (int) r102, (int) r103);
            TouchImageView r106 = this.f447722a;
            r106.postOnAnimation(r106.f447689k);
            return super.onFling(r100, r101, r102, r103);
        L5:
            if (r104.f447718a == null) goto L7;
            TouchImageView.j(r104.f447721d, State.NONE);
            r104.f447718a.f447707a.forceFinished(true);
            goto L7
        }
    }

    public interface f {
    }

    public class g implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PointF f447723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TouchImageView f447724b;

        public g(TouchImageView r100) {
            this.f447724b = r100;
            this.f447723a = new PointF();
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            this.f447724b.f447702x.onTouchEvent(r101);
            this.f447724b.f447703y.onTouchEvent(r101);
            PointF r102 = new PointF(r101.getX(), r101.getY());
            State r103 = this.f447724b.f447682d;
            State r104 = State.NONE;
            if (r103 != r104) goto L5;
        L8:
            int r105 = r101.getAction();
            if (r105 == 0) goto L26;
            if (r105 != 1) goto L12;
        L25:
            TouchImageView.j(this.f447724b, r104);
        L32:
            TouchImageView r106 = this.f447724b;
            r106.setImageMatrix(r106.f447680b);
            View.OnTouchListener r107 = this.f447724b.A;
            if (r107 == null) goto L35;
            r107.onTouch(r100, r101);
        L35:
            this.f447724b.getClass();
            return true;
        L12:
            if (r105 != 2) goto L14;
            TouchImageView r108 = this.f447724b;
            if (r108.f447682d != State.DRAG) goto L32;
            float r109 = r102.x;
            PointF r110 = this.f447723a;
            float r111 = r109 - r110.x;
            float r112 = r102.y - r110.y;
            if (TouchImageView.l(r108) > r108.f447694p) goto L21;
            r111 = 0.0f;
        L21:
            TouchImageView r113 = this.f447724b;
            if (TouchImageView.m(r113) > r113.f447695q) goto L24;
            r112 = 0.0f;
        L24:
            this.f447724b.f447680b.postTranslate(r111, r112);
            this.f447724b.q();
            this.f447723a.set(r102.x, r102.y);
            goto L32
        L14:
            if (r105 == 6) goto L25;
        L26:
            this.f447723a.set(r102);
            d r114 = this.f447724b.f447689k;
            if (r114 != null) goto L29;
        L31:
            TouchImageView.j(this.f447724b, State.DRAG);
            goto L32
        L29:
            if (r114.f447718a == null) goto L31;
            TouchImageView.j(r114.f447721d, r104);
            r114.f447718a.f447707a.forceFinished(true);
            goto L31
        L5:
            if (r103 == State.DRAG) goto L8;
            if (r103 != State.FLING) goto L32;
            goto L8
        }
    }

    public class h extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchImageView f447725a;

        public h(TouchImageView r100) {
            this.f447725a = r100;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r100) {
            TouchImageView r101 = this.f447725a;
            double r102 = r100.getScaleFactor();
            float r103 = r100.getFocusX();
            float r104 = r100.getFocusY();
            int r105 = TouchImageView.B;
            r101.s(r102, r103, r104, true);
            this.f447725a.getClass();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector r100) {
            TouchImageView.j(this.f447725a, State.ZOOM);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector r100) {
            super.onScaleEnd(r100);
            TouchImageView.j(this.f447725a, State.NONE);
            TouchImageView r101 = this.f447725a;
            float r102 = r101.f447679a;
            float r103 = r101.f447684f;
            boolean r104 = true;
            if (r102 <= r103) goto L5;
        L4:
            float r105 = r103;
        L9:
            if (r104 == false) goto L12;
            this.f447725a.postOnAnimation(new c(r101, r105, r101.f447694p / 2, r101.f447695q / 2, true));
            return;
        L12:
            return;
        L5:
            r103 = r101.f447683e;
            if (r102 < r103) goto L4;
            r104 = false;
            r105 = r102;
            goto L9
        }
    }

    public class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f447726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f447727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f447728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView.ScaleType f447729d;

        public i(float r100, float r101, float r102, ImageView.ScaleType r103) {
            this.f447726a = r100;
            this.f447727b = r101;
            this.f447728c = r102;
            this.f447729d = r103;
        }
    }

    public void setOnTouchImageViewListener(f r100) {
    }

    private float getImageHeight() {
        return this.f447699u * this.f447679a;
    }

    private float getImageWidth() {
        return this.f447698t * this.f447679a;
    }

    public RectF getZoomedRect() {
        if (this.f447690l == ImageView.ScaleType.FIT_XY) goto L7;
        PointF r100 = v(0.0f, 0.0f, true);
        PointF r101 = v(this.f447694p, this.f447695q, true);
        float r102 = getDrawable().getIntrinsicWidth();
        float r103 = getDrawable().getIntrinsicHeight();
        return new RectF(r100.x / r102, r100.y / r103, r101.x / r102, r101.y / r103);
    L7:
        throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
    }

    public final void o() {
        Drawable r100 = getDrawable();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getIntrinsicWidth() != 0) goto L7;
        return;
    L7:
        if (r100.getIntrinsicHeight() != 0) goto L10;
        return;
    L10:
        if (this.f447680b != null) goto L12;
        return;
    L12:
        if (this.f447681c == null) goto L49;
        int r101 = r100.getIntrinsicWidth();
        int r102 = r100.getIntrinsicHeight();
        float r103 = r101;
        float r104 = this.f447694p / r103;
        float r105 = r102;
        float r106 = this.f447695q / r105;
        int r107 = a.f447706a[this.f447690l.ordinal()];
        boolean r110 = true;
        if (r107 == 1) goto L28;
        if (r107 != 2) goto L18;
        r104 = Math.max(r104, r106);
    L27:
        r106 = r104;
    L29:
        int r108 = this.f447694p;
        float r111 = r108 - (r104 * r103);
        int r112 = this.f447695q;
        float r113 = r112 - (r106 * r105);
        this.f447698t = r108 - r111;
        this.f447699u = r112 - r113;
        if (this.f447679a != 1.0f) goto L33;
        r110 = false;
    L33:
        if (r110 == true) goto L38;
        if (this.f447691m == true) goto L38;
        this.f447680b.setScale(r104, r106);
        this.f447680b.postTranslate(r111 / 2.0f, r113 / 2.0f);
        this.f447679a = 1.0f;
    L43:
        q();
        setImageMatrix(this.f447680b);
        return;
    L38:
        if (this.f447700v != 0.0f) goto L40;
    L41:
        r();
    L42:
        this.f447681c.getValues(this.f447687i);
        float[] r109 = this.f447687i;
        float r114 = this.f447698t / r103;
        float r115 = this.f447679a;
        r109[0] = r114 * r115;
        r109[4] = (this.f447699u / r105) * r115;
        float r116 = r109[2];
        float r117 = r109[5];
        w(2, r116, this.f447700v * r115, getImageWidth(), this.f447696r, this.f447694p, r101);
        w(5, r117, this.f447701w * this.f447679a, getImageHeight(), this.f447697s, this.f447695q, r102);
        this.f447680b.setValues(this.f447687i);
        goto L43
    L40:
        if (this.f447701w != 0.0f) goto L42;
    L18:
        if (r107 == 3) goto L25;
        if (r107 == 4) goto L24;
        if (r107 == 5) goto L29;
        throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
    L24:
        r104 = Math.min(r104, r106);
        goto L27
    L25:
        r104 = Math.min(1.0f, Math.min(r104, r106));
        goto L27
    L28:
        r104 = 1.0f;
        r106 = 1.0f;
        goto L29
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("instanceState", super.onSaveInstanceState());
        r100.putFloat("saveScale", this.f447679a);
        r100.putFloat("matchViewHeight", this.f447699u);
        r100.putFloat("matchViewWidth", this.f447698t);
        r100.putInt("viewWidth", this.f447694p);
        r100.putInt("viewHeight", this.f447695q);
        this.f447680b.getValues(this.f447687i);
        r100.putFloatArray("matrix", this.f447687i);
        r100.putBoolean("imageRendered", this.f447691m);
        return r100;
    }

    public final void q() {
        this.f447680b.getValues(this.f447687i);
        float[] r100 = this.f447687i;
        float r101 = r100[2];
        float r102 = r100[5];
        float r103 = this.f447694p;
        float r104 = getImageWidth();
        float r105 = r103 - r104;
        if (r104 > r103) goto L5;
        float r106 = r105;
        r105 = 0.0f;
    L7:
        if (r101 >= r105) goto L10;
        float r107 = (-r101) + r105;
    L13:
        float r108 = this.f447695q;
        float r109 = getImageHeight();
        float r110 = r108 - r109;
        if (r109 > r108) goto L16;
        float r111 = r110;
        r110 = 0.0f;
    L18:
        if (r102 >= r110) goto L21;
        float r112 = (-r102) + r110;
    L25:
        if (r107 == 0.0f) goto L27;
    L28:
        this.f447680b.postTranslate(r107, r112);
        return;
    L27:
        if (r112 != 0.0f) goto L28;
        return;
    L21:
        if (r102 <= r111) goto L23;
        r112 = (-r102) + r111;
        goto L25
    L23:
        r112 = 0.0f;
        goto L25
    L16:
        r111 = 0.0f;
        goto L18
    L10:
        if (r101 <= r106) goto L12;
        r107 = (-r101) + r106;
        goto L13
    L12:
        r107 = 0.0f;
        goto L13
    L5:
        r106 = 0.0f;
        goto L7
    }

    public final void r() {
        Matrix r100 = this.f447680b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f447695q != 0) goto L7;
        return;
    L7:
        if (this.f447694p == 0) goto L12;
        r100.getValues(this.f447687i);
        this.f447681c.setValues(this.f447687i);
        this.f447701w = this.f447699u;
        this.f447700v = this.f447698t;
        this.f447697s = this.f447695q;
        this.f447696r = this.f447694p;
        return;
    }

    public PointF getScrollPosition() {
        Drawable r100 = getDrawable();
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.getIntrinsicWidth();
        int r102 = r100.getIntrinsicHeight();
        PointF r103 = v(this.f447694p / 2, this.f447695q / 2, true);
        r103.x /= r101;
        r103.y /= r102;
        return r103;
    }

    public final void p() {
        q();
        this.f447680b.getValues(this.f447687i);
        float r100 = getImageWidth();
        int r101 = this.f447694p;
        if (r100 >= r101) goto L5;
        this.f447687i[2] = (r101 - getImageWidth()) / 2.0f;
    L5:
        float r102 = getImageHeight();
        int r103 = this.f447695q;
        if (r102 >= r103) goto L8;
        this.f447687i[5] = (r103 - getImageHeight()) / 2.0f;
    L8:
        this.f447680b.setValues(this.f447687i);
    }

    public float getCurrentZoom() {
        return this.f447679a;
    }

    public float getMaxZoom() {
        return this.f447684f;
    }

    public float getMinZoom() {
        return this.f447683e;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f447690l;
    }

    public TouchImageView(Context r100) {
        super(r100);
        this.f447704z = null;
        this.A = null;
        u(r100);
    }

    public static /* synthetic */ float l(TouchImageView r100) {
        return r100.getImageWidth();
    }

    public static /* synthetic */ float m(TouchImageView r100) {
        return r100.getImageHeight();
    }

    private void setState(State r100) {
        this.f447682d = r100;
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        this.f447680b.getValues(this.f447687i);
        float r101 = this.f447687i[2];
        if (getImageWidth() >= this.f447694p) goto L6;
        return false;
    L6:
        if (r101 < (-1.0f)) goto L10;
        if (r100 >= 0) goto L10;
        return false;
    L10:
        if (((Math.abs(r101) + this.f447694p) + 1.0f) < getImageWidth()) goto L13;
        if (r100 <= 0) goto L15;
        return false;
    L15:
        return true;
    L13:
        return true;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        r();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        this.f447692n = true;
        this.f447691m = true;
        i r101 = this.f447693o;
        if (r101 == null) goto L5;
        t(r101.f447726a, r101.f447727b, r101.f447728c, r101.f447729d);
        this.f447693o = null;
    L5:
        super.onDraw(r100);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof Bundle) == false) goto L6;
        Bundle r101 = (Bundle) r100;
        this.f447679a = r101.getFloat("saveScale");
        float[] r102 = r101.getFloatArray("matrix");
        this.f447687i = r102;
        this.f447681c.setValues(r102);
        this.f447701w = r101.getFloat("matchViewHeight");
        this.f447700v = r101.getFloat("matchViewWidth");
        this.f447697s = r101.getInt("viewHeight");
        this.f447696r = r101.getInt("viewWidth");
        this.f447691m = r101.getBoolean("imageRendered");
        super.onRestoreInstanceState(r101.getParcelable("instanceState"));
        return;
    L6:
        super.onRestoreInstanceState(r100);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        r();
        o();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        r();
        o();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r100) {
        super.setImageResource(r100);
        r();
        o();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r100) {
        super.setImageURI(r100);
        r();
        o();
    }

    public void setMaxZoom(float r100) {
        this.f447684f = r100;
        this.f447686h = r100 * 1.25f;
    }

    public void setMinZoom(float r100) {
        this.f447683e = r100;
        this.f447685g = r100 * 0.75f;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r100) {
        this.f447704z = r100;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r100) {
        this.A = r100;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r100) {
        if (r100 == ImageView.ScaleType.FIT_START) goto L14;
        if (r100 == ImageView.ScaleType.FIT_END) goto L14;
        ImageView.ScaleType r101 = ImageView.ScaleType.MATRIX;
        if (r100 != r101) goto L9;
        super.setScaleType(r101);
        return;
    L9:
        this.f447690l = r100;
        if (this.f447692n == false) goto L16;
        setZoom(this);
        return;
    L16:
        return;
    L14:
        throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
    }

    public void setZoom(TouchImageView r100) {
        PointF r101 = r100.getScrollPosition();
        t(r100.getCurrentZoom(), r101.x, r101.y, r100.getScaleType());
    }

    public final void u(Context r100) {
        super.setClickable(true);
        this.f447688j = r100;
        this.f447702x = new ScaleGestureDetector(r100, new h(this));
        this.f447703y = new GestureDetector(r100, new e(this));
        this.f447680b = new Matrix();
        this.f447681c = new Matrix();
        this.f447687i = new float[9];
        this.f447679a = 1.0f;
        if (this.f447690l != null) goto L5;
        this.f447690l = ImageView.ScaleType.FIT_CENTER;
    L5:
        this.f447683e = 1.0f;
        this.f447684f = 3.0f;
        this.f447685g = 0.75f;
        this.f447686h = 3.75f;
        setImageMatrix(this.f447680b);
        setScaleType(ImageView.ScaleType.MATRIX);
        setState(State.NONE);
        this.f447692n = false;
        super.setOnTouchListener(new g(this));
    }

    public void setZoom(float r100) {
        t(r100, 0.5f, 0.5f, this.f447690l);
    }

    public TouchImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f447704z = null;
        this.A = null;
        u(r100);
    }

    public static /* synthetic */ void j(TouchImageView r100, State r101) {
        r100.setState(r101);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        Drawable r102 = getDrawable();
        if (r102 != null) goto L5;
    L21:
        setMeasuredDimension(0, 0);
        return;
    L5:
        if (r102.getIntrinsicWidth() == 0) goto L21;
        if (r102.getIntrinsicHeight() == 0) goto L21;
        int r103 = r102.getIntrinsicWidth();
        int r104 = r102.getIntrinsicHeight();
        int r105 = View.MeasureSpec.getSize(r100);
        int r106 = View.MeasureSpec.getMode(r100);
        int r107 = View.MeasureSpec.getSize(r101);
        int r108 = View.MeasureSpec.getMode(r101);
        if (r106 == Integer.MIN_VALUE) goto L13;
        if (r106 == 0) goto L14;
        r103 = r105;
    L14:
        this.f447694p = r103;
        if (r108 == Integer.MIN_VALUE) goto L18;
        if (r108 == 0) goto L19;
        r104 = r107;
    L19:
        this.f447695q = r104;
        setMeasuredDimension(this.f447694p, r104);
        o();
        return;
    L18:
        r104 = Math.min(r104, r107);
        goto L19
    L13:
        r103 = Math.min(r103, r105);
        goto L14
    }

    public TouchImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f447704z = null;
        this.A = null;
        u(r100);
    }

    public static PointF n(TouchImageView r100, float r101, float r102) {
        r100.f447680b.getValues(r100.f447687i);
        return new PointF(r100.f447687i[2] + (r100.getImageWidth() * (r101 / r100.getDrawable().getIntrinsicWidth())), r100.f447687i[5] + (r100.getImageHeight() * (r102 / r100.getDrawable().getIntrinsicHeight())));
    }

    public final PointF v(float r100, float r101, boolean r102) {
        this.f447680b.getValues(this.f447687i);
        float r103 = getDrawable().getIntrinsicWidth();
        float r104 = getDrawable().getIntrinsicHeight();
        float[] r105 = this.f447687i;
        float r106 = r105[2];
        float r107 = r105[5];
        float r108 = ((r100 - r106) * r103) / getImageWidth();
        float r109 = ((r101 - r107) * r104) / getImageHeight();
        if (r102 == false) goto L6;
        r108 = Math.min(Math.max(r108, 0.0f), r103);
        r109 = Math.min(Math.max(r109, 0.0f), r104);
    L6:
        return new PointF(r108, r109);
    }

    public final void s(double r100, float r101, float r102, boolean r103) {
        if (r103 == false) goto L4;
        float r104 = this.f447685g;
        float r105 = this.f447686h;
    L5:
        float r106 = this.f447679a;
        float r107 = (float) (((double) r106) * r100);
        this.f447679a = r107;
        if (r107 <= r105) goto L9;
        this.f447679a = r105;
        r100 = r105 / r106;
    L11:
        float r108 = (float) r100;
        this.f447680b.postScale(r108, r108, r101, r102);
        p();
        return;
    L9:
        if (r107 >= r104) goto L11;
        this.f447679a = r104;
        r100 = r104 / r106;
        goto L11
    L4:
        r104 = this.f447683e;
        r105 = this.f447684f;
        goto L5
    }

    public final void t(float r100, float r101, float r102, ImageView.ScaleType r110) {
        if (this.f447692n == true) goto L7;
        this.f447693o = new i(r100, r101, r102, r110);
        return;
    L7:
        if (r110 == this.f447690l) goto L9;
        setScaleType(r110);
    L9:
        this.f447679a = 1.0f;
        o();
        s(r100, this.f447694p / 2, this.f447695q / 2, true);
        this.f447680b.getValues(this.f447687i);
        this.f447687i[2] = -((r101 * getImageWidth()) - (this.f447694p * 0.5f));
        this.f447687i[5] = -((r102 * getImageHeight()) - (this.f447695q * 0.5f));
        this.f447680b.setValues(this.f447687i);
        q();
        setImageMatrix(this.f447680b);
    }

    public final void w(int r100, float r101, float r102, float r103, int r104, int r105, int r106) {
        float r107 = r105;
        if (r103 >= r107) goto L6;
        float[] r108 = this.f447687i;
        r108[r100] = (r107 - (r106 * r108[0])) * 0.5f;
        return;
    L6:
        if (r101 <= 0.0f) goto L8;
        this.f447687i[r100] = -((r103 - r107) * 0.5f);
        return;
    L8:
        this.f447687i[r100] = -((((Math.abs(r101) + (r104 * 0.5f)) / r102) * r103) - (r107 * 0.5f));
    }
}
