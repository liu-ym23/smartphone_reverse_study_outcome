package com.bytedance.live.photoviewer.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.ranges.RangesKt;
import wj6.e;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/live/photoviewer/transition/TransitionLayout;", "Landroid/widget/FrameLayout;", "Lwj6/b;", "Lwj6/e;", "Lzj6/e;", "", "getDragFactor", "transitionView", "", "setDelegateDragTransitionView", "p", FaceService.girlLabel, "getEps", "()F", "setEps", "(F)V", "eps", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "photoviewer_release"}, k = 1, mv = {1, 4, 0})
public final class TransitionLayout extends FrameLayout implements wj6.b<e>, zj6.e {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f255694q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f255695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f255696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f255697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f255698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Matrix f255699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f255700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup.LayoutParams f255701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout.LayoutParams f255702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ValueAnimator f255703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f255704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f255705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public zj6.e f255706l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ValueAnimator f255707m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashSet<zj6.c> f255708n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f255709o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f255710p;

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TransitionLayout f255711a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        public a(TransitionLayout r100) {
            this.f255711a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            onAnimationEnd(r100);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Iterator<T> r101 = this.f255711a.f255708n.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((zj6.c) r101.next()).onTransitionEnd(this.f255711a.f255705k);
            goto L4
        L6:
            View r102 = this.f255711a.b();
            if (r102 == null) goto L9;
            r102.setLayoutParams(this.f255711a.f255701g);
        L9:
            this.f255711a.f255705k = -1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Iterator<T> r101 = this.f255711a.f255708n.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((zj6.c) r101.next()).onTransitionBegin(this.f255711a.f255705k);
            goto L4
        L6:
            TransitionLayout r102 = this.f255711a;
            if (r102.f255705k != 0) goto L13;
            View r103 = r102.b();
            if (r103 == null) goto L14;
            r102.f255701g = r103.getLayoutParams();
            r103.setLayoutParams(r102.f255702h);
            return;
        L14:
            return;
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TransitionLayout f255712a;

        public b(TransitionLayout r100) {
            this.f255712a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            TransitionLayout r101 = this.f255712a;
            int r102 = TransitionLayout.f255694q;
            View r103 = r101.b();
            if (r103 == null) goto L30;
            if (r100 == null) goto L6;
            Object r104 = r100.getAnimatedValue();
        L7:
            if (r104 == null) goto L29;
            float r105 = ((Float) r104).floatValue();
            TransitionLayout r106 = this.f255712a;
            Rect r107 = r106.f255697c;
            Rect r108 = r106.f255695a;
            int r109 = r108.left;
            Rect r110 = r106.f255696b;
            r107.left = (int) (r109 + ((r110.left - r109) * r105));
            int r111 = r108.top;
            r107.top = (int) (r111 + ((r110.top - r111) * r105));
            int r112 = r108.right;
            r107.right = (int) (r112 + ((r110.right - r112) * r105));
            int r113 = r108.bottom;
            r107.bottom = (int) (r113 + ((r110.bottom - r113) * r105));
            TransitionLayout.c(r107, r103);
            TransitionLayout r114 = this.f255712a;
            int r115 = r114.f255705k;
            if (r115 != 0) goto L11;
            Iterator<T> r116 = r114.f255708n.iterator();
        L25:
            if (r116.hasNext() == false) goto L36;
            ((zj6.c) r116.next()).onTransitionChanged(this.f255712a.f255705k, r105);
            goto L25
        L36:
            return;
        L11:
            if (r115 != 1) goto L13;
            Iterator<T> r117 = r114.f255708n.iterator();
        L21:
            if (r117.hasNext() == false) goto L35;
            zj6.c r118 = (zj6.c) r117.next();
            TransitionLayout r119 = this.f255712a;
            int r120 = r119.f255705k;
            float r121 = r119.f255709o;
            r118.onTransitionChanged(r120, r121 + ((1 - r121) * r105));
            goto L21
        L35:
            return;
        L13:
            if (r115 != 2) goto L27;
            Iterator<T> r122 = r114.f255708n.iterator();
        L17:
            if (r122.hasNext() == false) goto L34;
            zj6.c r123 = (zj6.c) r122.next();
            TransitionLayout r124 = this.f255712a;
            r123.onTransitionChanged(r124.f255705k, r124.f255709o * (1 - r105));
            goto L17
        L34:
            return;
        L27:
            return;
        L29:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
        L6:
            r104 = null;
            goto L7
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TransitionLayout f255713a;

        public c(TransitionLayout r100) {
            this.f255713a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            if (r100 == null) goto L4;
            Object r101 = r100.getAnimatedValue();
        L5:
            if (r101 == null) goto L11;
            float r102 = ((Float) r101).floatValue();
            TransitionLayout r103 = this.f255713a;
            int r104 = TransitionLayout.f255694q;
            View r105 = r103.b();
            if (r105 == null) goto L12;
            r105.setAlpha(r102);
            return;
        L12:
            return;
        L11:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
        L4:
            r101 = null;
            goto L5
        }
    }

    public TransitionLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TransitionLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final float getDragFactor() {
        float r100 = this.f255704j.f560036f;
        if (r100 > 0) goto L5;
        return 1.0f;
    L5:
        return 1 - RangesKt.coerceAtMost(r100 / 1300, 0.95f);
    }

    public final View b() {
        if (getChildCount() >= 2) goto L10;
        if (this.f255700f != null) goto L8;
        this.f255700f = getChildAt(0);
    L8:
        return this.f255700f;
    L10:
        throw new IllegalStateException("only allow one child view");
    }

    public final float getEps() {
        return this.f255710p;
    }

    @Override // zj6.e
    public final void a(zj6.c r100) {
        this.f255708n.remove(r100);
        zj6.e r101 = this.f255706l;
        if (r101 == null) goto L7;
        if (r101 == null) goto L8;
        r101.a(r100);
        return;
    L8:
        return;
    }

    @Override // zj6.e
    public final void d(zj6.c r100) {
        this.f255708n.add(r100);
        zj6.e r101 = this.f255706l;
        if (r101 == null) goto L7;
        if (r101 == null) goto L8;
        r101.d(r100);
        return;
    L8:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f255703i.isRunning() == false) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    @Override // wj6.b
    public final void onGestureBegin(e r100) {
        this.f255705k = -1;
    }

    @Override // wj6.b
    public final void onGestureEnd(e r100) {
        if (this.f255705k != 3) goto L14;
        Iterator<T> r101 = this.f255708n.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((zj6.c) r101.next()).onTransitionEnd(this.f255705k);
        goto L6
    L8:
        float r102 = getDragFactor();
        this.f255709o = r102;
        if (r102 >= this.f255710p) goto L11;
        this.f255695a.set(this.f255697c);
        this.f255699e.reset();
        this.f255699e.postScale(0.0f, 0.0f, this.f255697c.centerX(), this.f255697c.centerY());
        this.f255698d.set(this.f255696b);
        this.f255699e.mapRect(this.f255698d);
        Rect r103 = this.f255697c;
        RectF r104 = this.f255698d;
        r103.left = (int) r104.left;
        r103.top = (int) r104.top;
        r103.right = (int) r104.right;
        r103.bottom = (int) r104.bottom;
        this.f255696b.set(r103);
        this.f255705k = 2;
        this.f255703i.start();
        this.f255707m.start();
        return;
    L11:
        this.f255695a.set(this.f255697c);
        this.f255705k = 1;
        this.f255703i.start();
        return;
    }

    @Override // wj6.b
    public final void onGestureUpdate(e r100) {
        if (this.f255704j.f560042l != 4) goto L14;
        if (this.f255705k == 3) goto L14;
        this.f255705k = 3;
        Iterator<T> r101 = this.f255708n.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((zj6.c) r101.next()).onTransitionBegin(this.f255705k);
        goto L8
    L10:
        View r102 = b();
        if (r102 == null) goto L14;
        this.f255701g = r102.getLayoutParams();
        r102.setLayoutParams(this.f255702h);
    L14:
        if (this.f255705k != 3) goto L22;
        this.f255699e.reset();
        this.f255709o = getDragFactor();
        Matrix r103 = this.f255699e;
        e r104 = this.f255704j;
        r103.postTranslate(r104.f560035e, r104.f560036f);
        Matrix r105 = this.f255699e;
        float r106 = this.f255709o;
        r105.postScale(r106, r106, this.f255697c.centerX(), this.f255697c.centerY());
        this.f255698d.set(this.f255696b);
        this.f255699e.mapRect(this.f255698d);
        Rect r107 = this.f255697c;
        RectF r108 = this.f255698d;
        r107.left = (int) r108.left;
        r107.top = (int) r108.top;
        r107.right = (int) r108.right;
        r107.bottom = (int) r108.bottom;
        View r109 = b();
        if (r109 == null) goto L18;
        c(this.f255697c, r109);
    L18:
        Iterator<T> r110 = this.f255708n.iterator();
    L20:
        if (r110.hasNext() == false) goto L25;
        ((zj6.c) r110.next()).onTransitionChanged(this.f255705k, this.f255709o);
        goto L20
    L25:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f255706l != null) goto L12;
        if (r100 == null) goto L7;
        this.f255704j.b(r100);
    L7:
        if (this.f255705k != 3) goto L9;
        boolean r101 = true;
    L10:
        requestDisallowInterceptTouchEvent(r101);
        goto L12
    L9:
        r101 = false;
    L12:
        if (this.f255705k == 3) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f255705k != 3) goto L5;
        requestDisallowInterceptTouchEvent(true);
    L5:
        this.f255704j.b(r100);
        return true;
    }

    public final void setDelegateDragTransitionView(zj6.e r100) {
        this.f255706l = r100;
        Iterator<T> r101 = this.f255708n.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        zj6.c r102 = (zj6.c) r101.next();
        zj6.e r103 = this.f255706l;
        if (r103 == null) goto L4;
        r103.d(r102);
        goto L4
    }

    public final void setEps(float r100) {
        this.f255710p = r100;
    }

    public static void c(Rect r100, View r101) {
        r101.setX(r100.left);
        r101.setY(r100.top);
        r101.getLayoutParams().width = r100.width();
        r101.getLayoutParams().height = r100.height();
        r101.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        View r102 = b();
        if (r102 != null) goto L5;
        return;
    L5:
        if (this.f255705k != (-1)) goto L9;
        this.f255696b.set(0, 0, r102.getMeasuredWidth(), r102.getMeasuredHeight());
        return;
    }

    public TransitionLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f255695a = new Rect();
        this.f255696b = new Rect();
        this.f255697c = new Rect();
        this.f255698d = new RectF();
        this.f255699e = new Matrix();
        this.f255702h = new FrameLayout.LayoutParams(0, 0);
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f255703i = r103;
        e r104 = new e();
        this.f255704j = r104;
        this.f255705k = -1;
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f255707m = r105;
        this.f255708n = new LinkedHashSet();
        this.f255709o = 1.0f;
        c r106 = new c(this);
        b r107 = new b(this);
        a r108 = new a(this);
        if (r104.f560033c.contains(2) == true) goto L5;
        r104.f560033c.add(2);
    L5:
        r103.addUpdateListener(r107);
        r103.addListener(r108);
        r103.setDuration(250);
        r105.setDuration(250);
        r105.addUpdateListener(r106);
        r104.f560031a = this;
        this.f255710p = 0.7f;
    }

    public /* synthetic */ TransitionLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
