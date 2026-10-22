package com.bytedance.ee.bear.document.titlebar;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Scroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class ImmersiveWebContainerBehavior extends CoordinatorLayout.Behavior<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f222130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f222131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Scroller f222132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f222133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f222134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f222135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f222136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f222137h;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f222138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f222139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f222140c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f222141d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewTreeObserver f222142e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ImmersiveWebContainerBehavior f222143f;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.f222142e.isAlive() == true) goto L7;
            tt5.a.k("ImmersiveWebContainerBehavior", "viewTreeObserver isn't alive");
            return false;
        L7:
            if (this.f222138a >= 0) goto L10;
            this.f222138a = (int) (this.f222143f.f222130a * 0.8f);
        L10:
            if (Math.abs(this.f222143f.f222131b - this.f222139b) <= this.f222138a) goto L12;
            this.f222141d = 0;
            this.f222140c = 3;
            this.f222143f.getClass();
        L12:
            ImmersiveWebContainerBehavior r100 = this.f222143f;
            this.f222139b = r100.f222131b;
            if (this.f222141d >= this.f222140c) goto L16;
            r100.getClass();
            this.f222141d++;
            return false;
        L16:
            r100.getClass();
            this.f222142e.removeOnPreDrawListener(this);
            this.f222143f.f222134e = null;
            return true;
        }

        public a(ImmersiveWebContainerBehavior r100) {
            this.f222143f = r100;
            this.f222138a = -1;
            this.f222141d = this.f222140c;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f222144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f222145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f222146c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f222147d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f222148e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ImmersiveWebContainerBehavior f222149f;

        public final void a() {
            ImmersiveWebContainerBehavior r100 = this.f222149f;
            int r101 = this.f222147d;
            View r102 = this.f222146c;
            r100.getClass();
            boolean r103 = true;
            if (r101 > 0) goto L6;
            r103 = true ^ r102.canScrollVertically(-1);
        L6:
            if (r103 == false) goto L10;
            ImmersiveWebContainerBehavior r104 = this.f222149f;
            int r105 = r104.f222132c.getCurrY() - this.f222148e;
            int r106 = MathUtils.clamp(r104.f222131b - r105, 0, r104.f222130a);
            int r107 = r104.f222131b - r106;
            r104.f222131b = r106;
            if (r107 == 0) goto L10;
            this.f222149f.b(this.f222144a, this.f222145b);
        L10:
            this.f222148e = this.f222149f.f222132c.getCurrY();
            this.f222149f.a(this.f222146c);
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

        public b(ImmersiveWebContainerBehavior r100, View r101, View r102, View r103) {
            this.f222149f = r100;
            this.f222144a = r101;
            this.f222145b = r102;
            this.f222146c = r103;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        this.f222131b = 0;
        View r100 = this.f222135f;
        if (r100 == null) goto L7;
        View r101 = this.f222136g;
        if (r101 == null) goto L7;
        b(r100, r101);
    L7:
        Scroller r102 = this.f222132c;
        if (r102 == null) goto L10;
        r102.abortAnimation();
    L10:
        b r103 = this.f222133d;
        if (r103 == null) goto L13;
        r103.f222145b.removeCallbacks(r103);
    L13:
        a r104 = this.f222134e;
        if (r104 == null) goto L21;
        ViewTreeObserver r105 = r104.f222142e;
        if (r105 != null) goto L18;
        return;
    L18:
        if (r105.isAlive() == false) goto L23;
        r104.f222142e.removeOnPreDrawListener(r104);
        return;
    L23:
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104, int r105) {
        if ((r104 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ImmersiveWebContainerBehavior() {
        this.f222130a = -1;
        this.f222137h = true;
    }

    public final void a(View r100) {
        Scroller r101 = this.f222132c;
        if (r101 != null) goto L14;
        return;
    L14:
        boolean r102 = r101.computeScrollOffset();     // Catch: ArrayIndexOutOfBoundsException -> L7
    L9:
        if (r102 == true) goto L11;
        return;
    L11:
        if (r100.isAttachedToWindow() == false) goto L17;
        ViewCompat.postOnAnimation(r100, this.f222133d);
        return;
    L17:
        return;
    L7:
        e = move-exception;
        tt5.a.e("ImmersiveWebContainerBehavior", "computeScrollOffset error, timePassed can't be negative", e, false);
        r102 = false;
        goto L9
    }

    public final void b(View r100, View r101) {
        this.f222135f = r100;
        this.f222136g = r101;
        int r102 = r100.getHeight() - this.f222131b;
        r101.measure(View.MeasureSpec.makeMeasureSpec(r101.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r102, 1073741824));
        r101.layout(0, r100.getTop() + this.f222131b, r100.getRight(), r100.getBottom());
        if (this.f222134e == null) goto L5;
        return;
    L5:
        if (this.f222137h == false) goto L9;
        ViewTreeObserver r103 = r100.getViewTreeObserver();
        a r104 = new a(this);
        this.f222134e = r104;
        r104.f222142e = r103;
        r103.addOnPreDrawListener(r104);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean layoutDependsOn(CoordinatorLayout r100, View r101, View r102) {
        return r102 instanceof AppBarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onDependentViewChanged(CoordinatorLayout r100, View r101, View r102) {
        if (this.f222130a == r102.getMeasuredHeight()) goto L7;
        int r103 = r102.getMeasuredHeight();
        this.f222130a = r103;
        this.f222131b = r103;
        b(r100, r101);
        return false;
    L7:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDependentViewRemoved(CoordinatorLayout r100, View r101, View r102) {
        if (r102.isAttachedToWindow() == true) goto L6;
        this.f222130a = 0;
        this.f222131b = 0;
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
        if (r102.getAction() != 0) goto L9;
        Scroller r103 = this.f222132c;
        if (r103 == null) goto L10;
        r103.abortAnimation();
        return false;
    L10:
        return false;
    L9:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r110, View r111, View r112, float r113, float r114) {
        if (this.f222132c != null) goto L5;
        this.f222132c = new Scroller(r110.getContext());
    L5:
        b r115 = this.f222133d;
        if (r115 == null) goto L8;
        r115.f222145b.removeCallbacks(r115);
    L9:
        b r116 = this.f222133d;
        r116.f222147d = (int) r114;
        r116.f222148e = 0;
        this.f222132c.fling(0, r112.getScrollY(), 0, Math.round(r114), 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        a(r112);
        return false;
    L8:
        this.f222133d = new b(this, r110, r111, r112);
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout r100, View r101, int r102, int r110, int r111, int r112) {
        if (this.f222130a >= 0) goto L7;
        View r113 = r100.findViewById(R.id.doc_appbar_layout);
        if (r113 == null) goto L7;
        int r114 = r113.getMeasuredHeight();
        this.f222130a = r114;
        this.f222131b = r114;
    L7:
        r100.onMeasureChild(r101, r102, r110, r111, this.f222131b);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
        if (r104 <= 0) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == false) goto L11;
        int r108 = MathUtils.clamp(this.f222131b - r104, 0, this.f222130a);
        int r109 = this.f222131b - r108;
        this.f222131b = r108;
        r105[1] = r109;
        if (r109 == 0) goto L12;
        b(r100, r101);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r107 = !r102.canScrollVertically(-1);
        goto L6
    }
}
