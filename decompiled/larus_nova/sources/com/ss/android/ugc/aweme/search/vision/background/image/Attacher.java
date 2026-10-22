package com.ss.android.ugc.aweme.search.vision.background.image;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAbility;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.utils.ScreenUtils;
import com.ss.android.ugc.aweme.search.vision.result.panel.PhotoSearchBottomPanelViewModel;
import fua.a;
import fua.d;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes40.dex */
public class Attacher implements a, View.OnTouchListener, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f453434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f453435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Interpolator f453436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f453437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f453438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f453439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f453440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f453441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ScaleDragDetector f453442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GestureDetectorCompat f453443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f453444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f453445l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f453446m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Matrix f453447n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f453448o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f453449p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final WeakReference<DraweeView<GenericDraweeHierarchy>> f453450q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public PhotoSearchBottomPanelViewModel f453451r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View.OnLongClickListener f453452s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public OnViewDragListener f453453t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final PointF f453454u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f453455v;

    public class AnimatedZoomRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f453457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f453458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f453459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f453460d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f453461e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Attacher f453462f;

        public final void a() {
            DraweeView<GenericDraweeHierarchy> r100 = this.f453462f.f();
            if (r100 != null) goto L5;
            return;
        L5:
            float r101 = ((AccelerateDecelerateInterpolator) this.f453462f.f453436c).getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f453459c) * 1.0f) / this.f453462f.f453441h));
            float r102 = this.f453460d;
            float r103 = (r102 + ((this.f453461e - r102) * r101)) / this.f453462f.g();
            Attacher r104 = this.f453462f;
            float r105 = this.f453457a;
            float r106 = this.f453458b;
            if (r104.g() >= r104.f453440g) goto L8;
        L9:
            r104.f453447n.postScale(r103, r103, r105, r106);
            r104.b();
        L11:
            if (r101 >= 1.0f) goto L14;
            this.f453462f.getClass();
            r100.postOnAnimation(this);
            return;
        L14:
            return;
        L8:
            if (r103 >= 1.0f) goto L11;
            goto L9
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

        public AnimatedZoomRunnable(Attacher r100, float r101, float r102, float r103) {
            this.f453462f = r100;
            this.f453457a = r103;
            this.f453458b = 0.0f;
            this.f453459c = System.currentTimeMillis();
            this.f453460d = r101;
            this.f453461e = r102;
        }
    }

    public final boolean c() {
        RectF r100 = e(this.f453447n);
        if (r100 != null) goto L5;
        return false;
    L5:
        float r101 = r100.height();
        float r102 = r100.width();
        DraweeView<GenericDraweeHierarchy> r103 = f();
        if (r103 == null) goto L8;
        int r104 = (r103.getHeight() - r103.getPaddingTop()) - r103.getPaddingBottom();
    L9:
        float r105 = r104;
        float r106 = 0.0f;
        if (r101 > r105) goto L12;
        float r107 = r100.top;
        if (r107 <= 0.0f) goto L24;
    L23:
        float r108 = -r107;
    L29:
        DraweeView<GenericDraweeHierarchy> r109 = f();
        if (r109 == null) goto L32;
        int r110 = (r109.getWidth() - r109.getPaddingLeft()) - r109.getPaddingRight();
    L33:
        float r111 = r110;
        if (r102 > r111) goto L36;
        r106 = ((r111 - r102) / 2.0f) - r100.left;
        this.f453446m = 2;
    L51:
        if (this.f453446m == 3) goto L53;
        this.f453447n.postTranslate(r106, r108);
    L53:
        PointF r112 = this.f453454u;
        r112.x = r106;
        r112.y = r108;
        return true;
    L36:
        float r113 = r100.left;
        if (r113 <= 0.0f) goto L39;
        r106 = -r113;
        this.f453446m = 0;
        goto L51
    L39:
        float r114 = r100.right;
        if (r114 >= r111) goto L42;
        r106 = r111 - r114;
        this.f453446m = 1;
        goto L51
    L42:
        this.f453446m = -1;
        if (r108 <= 0.0f) goto L48;
        if (r108 > this.f453451r.getBottomHeight()) goto L48;
        this.f453446m = 3;
    L48:
        if (r108 <= this.f453451r.getBottomHeight()) goto L51;
        r108 = r108 - this.f453451r.getBottomHeight();
        goto L51
    L32:
        r110 = 0;
        goto L33
    L24:
        if (r104 > 0) goto L26;
    L28:
        r108 = 0.0f;
        goto L29
    L26:
        if (r100.bottom >= this.f453451r.getDraweeViewHeight()) goto L28;
        r108 = this.f453451r.getDraweeViewHeight() - r100.bottom;
        goto L29
    L12:
        if (r101 >= r105) goto L15;
        r105 = (r105 - r101) / 2.0f;
        float r115 = r100.top;
    L14:
        r108 = r105 - r115;
        goto L29
    L15:
        r107 = r100.top;
        if (r107 > 0.0f) goto L23;
        r115 = r100.bottom;
        if (r115 >= r105) goto L28;
    L8:
        r104 = 0;
        goto L9
    }

    public final DraweeView<GenericDraweeHierarchy> f() {
        return this.f453450q.get();
    }

    public final float g() {
        this.f453447n.getValues(this.f453434a);
        float r100 = (float) Math.pow(this.f453434a[0], 2.0d);
        this.f453447n.getValues(this.f453434a);
        return (float) Math.sqrt(r100 + ((float) Math.pow(this.f453434a[3], 2.0d)));
    }

    public final void b() {
        DraweeView<GenericDraweeHierarchy> r100 = f();
        if (r100 != null) goto L6;
        return;
    L6:
        if (c() == false) goto L9;
        r100.invalidate();
        return;
    }

    public Attacher(DraweeView<GenericDraweeHierarchy> r100) {
        this.f453434a = new float[9];
        this.f453435b = new RectF();
        this.f453436c = new AccelerateDecelerateInterpolator();
        this.f453437d = 0.0f;
        this.f453438e = 1.0f;
        this.f453439f = 1.75f;
        this.f453440g = 3.0f;
        this.f453441h = 200;
        this.f453444k = false;
        this.f453445l = true;
        this.f453446m = 2;
        this.f453447n = new Matrix();
        this.f453448o = -1;
        this.f453449p = -1;
        this.f453451r = null;
        this.f453454u = new PointF();
        this.f453450q = new WeakReference(r100);
        ((GenericDraweeHierarchy) r100.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START);
        r100.setOnTouchListener(this);
        this.f453442i = new ScaleDragDetector(r100.getContext(), this);
        this.f453443j = new GestureDetectorCompat(r100.getContext(), new AnonymousClass1(this));
    }

    @Override // fua.d
    public final void a(float r100) {
        if (this.f453455v == true) goto L5;
        return;
    L5:
        DraweeView<GenericDraweeHierarchy> r101 = f();
        if (r101 == null) goto L23;
        this.f453442i.getClass();
        this.f453447n.postTranslate(0.0f, r100);
        b();
        OnViewDragListener r102 = this.f453453t;
        if (r102 == null) goto L10;
        PointF r103 = this.f453454u;
        r102.a(r103.x + 0.0f, r100 + r103.y);
    L10:
        ViewParent r104 = r101.getParent();
        if (r104 != null) goto L14;
        return;
    L14:
        if (this.f453445l == false) goto L21;
        this.f453442i.getClass();
        if (this.f453444k == true) goto L21;
        if (this.f453446m != 2) goto L25;
        r104.requestDisallowInterceptTouchEvent(false);
        return;
    L25:
        return;
    L21:
        r104.requestDisallowInterceptTouchEvent(true);
        return;
    }

    public final RectF e(Matrix r100) {
        DraweeView<GenericDraweeHierarchy> r101 = f();
        if (r101 == null) goto L16;
        int r102 = this.f453449p;
        if (r102 == (-1)) goto L7;
    L9:
        this.f453435b.set(0.0f, 0.0f, r102, this.f453448o);
        ((GenericDraweeHierarchy) r101.getHierarchy()).getActualImageBounds(this.f453435b);
        r100.mapRect(this.f453435b);
        if (r101.getWidth() <= 0) goto L15;
        if (r101.getHeight() <= 0) goto L15;
        int[] r103 = new int[2];
        r101.getLocationOnScreen(r103);
        this.f453435b.offset(0.0f, r103[1]);
    L15:
        return this.f453435b;
    L7:
        if (this.f453448o != (-1)) goto L9;
        return null;
    L16:
        return null;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        boolean r102 = false;
        if (this.f453451r.getBottomStatus() != 3) goto L5;
    L61:
        r100.getParent().requestDisallowInterceptTouchEvent(false);
        return false;
    L5:
        if (this.f453451r.getBottomStatus() == 4) goto L61;
        if (this.f453451r.getBottomStatus() == 7) goto L61;
        if (r101.getAction() == 0) goto L12;
    L17:
        int r103 = MotionEventCompat.getActionMasked(r101);
        if (r103 == 0) goto L25;
        if (r103 == 1) goto L22;
        if (r103 == 3) goto L22;
    L28:
        this.f453442i.getClass();
        ScaleDragDetector r104 = this.f453442i;
        boolean r105 = r104.f453476d;
        int r106 = r101.getAction();
        if (r106 == 0) goto L50;
        if (r106 != 1) goto L32;
    L47:
        VelocityTracker r107 = r104.f453475c;
        if (r107 == null) goto L54;
        r107.recycle();
        r104.f453475c = null;
    L54:
        this.f453442i.getClass();
        if (r105 == false) goto L57;
    L59:
        this.f453444k = r102;
        this.f453443j.onTouchEvent(r101);
        return true;
    L57:
        if (this.f453442i.f453476d == true) goto L59;
        r102 = true;
        goto L59
    L32:
        if (r106 == 2) goto L35;
        if (r106 == 3) goto L47;
    L35:
        float r108 = r101.getY();
        float r109 = r108 - r104.f453477e;
        if (r104.f453476d == true) goto L43;
        if (Math.abs(r109) < r104.f453473a) goto L40;
        boolean r110 = true;
    L41:
        r104.f453476d = r110;
        goto L43
    L40:
        r110 = false;
    L43:
        if (r104.f453476d == false) goto L54;
        r104.f453474b.a(r109);
        r104.f453477e = r108;
        VelocityTracker r111 = r104.f453475c;
        if (r111 == null) goto L54;
        r111.addMovement(r101);
        goto L54
    L50:
        VelocityTracker r112 = VelocityTracker.obtain();
        r104.f453475c = r112;
        if (r112 == null) goto L53;
        r112.addMovement(r101);
    L53:
        r104.f453477e = r101.getY();
        r104.f453476d = false;
    L22:
        ViewParent r113 = r100.getParent();
        if (r113 == null) goto L28;
        r113.requestDisallowInterceptTouchEvent(false);
        goto L28
    L25:
        ViewParent r114 = r100.getParent();
        if (r114 == null) goto L28;
        r114.requestDisallowInterceptTouchEvent(true);
        goto L28
    L12:
        if (this.f453451r.getBottomStatus() != 5) goto L17;
        if (this.f453451r.isPointAtIndicatorRectF(f().getContext(), r101) == false) goto L17;
        r100.getParent().requestDisallowInterceptTouchEvent(false);
        return false;
    }

    @Override // fua.a
    public void update(int r100, int r101) {
        this.f453449p = r100;
        this.f453448o = r101;
        if (r100 != (-1)) goto L6;
        if (r101 != (-1)) goto L6;
        return;
    L6:
        DraweeView<GenericDraweeHierarchy> r102 = f();
        if (r102 == null) goto L14;
        TradeSearch.f453393a.getClass();
        ITradeSearchHostService r103 = TradeSearch.b(0);
        if (r103 == null) goto L14;
        ITradeSearchHostAbility r104 = r103.getITradeSearchHostAbility();
        Resources r105 = r102.getContext().getResources();
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());
        int r107 = (int) (((ScreenUtils.a(r104.getApplicationContext()) * 1.0f) / this.f453448o) * this.f453449p);
        int r108 = r106.widthPixels;
        if (r107 >= r108) goto L14;
        float r109 = (r108 * 1.0f) / r107;
    L16:
        if (r109 <= 1.0f) goto L20;
        c();
        RectF r110 = e(this.f453447n);
        if (r110 == null) goto L20;
        this.f453438e = 1.0f * r109;
        this.f453439f = 1.75f * r109;
        this.f453440g = 3.0f * r109;
        r102.post(new AnimatedZoomRunnable(this, r109, r109, r110.centerX()));
    L20:
        this.f453447n.reset();
        c();
        if (r102 == null) goto L23;
        r102.invalidate();
    L23:
        this.f453437d = r109;
        return;
    L14:
        r109 = 1.0f;
        goto L16
    }

    public static void d(float r100, float r101, float r102) {
        if (r100 >= r101) goto L10;
        if (r101 >= r102) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
    L10:
        throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
    }
}
