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

/* JADX INFO: loaded from: classes16.dex */
public class OfficeImmersiveWebContainerBehavior extends CoordinatorLayout.Behavior<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f222158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f222159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Scroller f222160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f222161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f222162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f222163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f222164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f222165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f222166i;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f222167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f222168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f222169c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f222170d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewTreeObserver f222171e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ OfficeImmersiveWebContainerBehavior f222172f;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.f222171e.isAlive() == true) goto L7;
            tt5.a.k("ImmersiveWebContainerBehavior", "viewTreeObserver isn't alive");
            return false;
        L7:
            if (this.f222167a >= 0) goto L10;
            this.f222167a = (int) (this.f222172f.f222158a * 0.8f);
        L10:
            if (Math.abs(this.f222172f.f222159b - this.f222168b) <= this.f222167a) goto L12;
            this.f222170d = 0;
            this.f222169c = 3;
            this.f222172f.a(new j(this));
        L12:
            OfficeImmersiveWebContainerBehavior r100 = this.f222172f;
            this.f222168b = r100.f222159b;
            if (this.f222170d >= this.f222169c) goto L16;
            r100.a(new k());
            this.f222170d++;
            return false;
        L16:
            r100.a(new l());
            this.f222171e.removeOnPreDrawListener(this);
            this.f222172f.f222162e = null;
            return true;
        }

        public a(OfficeImmersiveWebContainerBehavior r100) {
            this.f222172f = r100;
            this.f222167a = -1;
            this.f222170d = this.f222169c;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f222173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f222174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f222175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f222176d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f222177e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ OfficeImmersiveWebContainerBehavior f222178f;

        public final void a() {
            OfficeImmersiveWebContainerBehavior r100 = this.f222178f;
            int r101 = this.f222176d;
            View r102 = this.f222175c;
            r100.getClass();
            boolean r103 = true;
            if (r101 > 0) goto L6;
            r100.a(new f(r102));
            r103 = true ^ r102.canScrollVertically(-1);
        L6:
            if (r103 == false) goto L10;
            OfficeImmersiveWebContainerBehavior r104 = this.f222178f;
            int r105 = r104.f222160c.getCurrY() - this.f222177e;
            int r106 = MathUtils.clamp(r104.f222159b - r105, 0, r104.f222158a);
            int r107 = r104.f222159b - r106;
            r104.f222159b = r106;
            if (r107 == 0) goto L10;
            this.f222178f.c(this.f222173a, this.f222174b);
        L10:
            this.f222177e = this.f222178f.f222160c.getCurrY();
            this.f222178f.b(this.f222175c);
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

        public b(OfficeImmersiveWebContainerBehavior r100, View r101, View r102, View r103) {
            this.f222178f = r100;
            this.f222173a = r101;
            this.f222174b = r102;
            this.f222175c = r103;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        this.f222159b = 0;
        View r100 = this.f222163f;
        if (r100 == null) goto L7;
        View r101 = this.f222164g;
        if (r101 == null) goto L7;
        c(r100, r101);
    L7:
        Scroller r102 = this.f222160c;
        if (r102 == null) goto L10;
        r102.abortAnimation();
    L10:
        b r103 = this.f222161d;
        if (r103 == null) goto L13;
        r103.f222174b.removeCallbacks(r103);
    L13:
        a r104 = this.f222162e;
        if (r104 == null) goto L21;
        ViewTreeObserver r105 = r104.f222171e;
        if (r105 != null) goto L18;
        return;
    L18:
        if (r105.isAlive() == false) goto L23;
        r104.f222171e.removeOnPreDrawListener(r104);
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

    public OfficeImmersiveWebContainerBehavior(AppBarLayout r100) {
        this.f222158a = -1;
        this.f222165h = true;
        this.f222166i = r100;
    }

    public final void a(Runnable r100) {
        if (eu5.c.c() == false) goto L6;
        r100.run();
        return;
    }

    public final void b(View r100) {
        Scroller r101 = this.f222160c;
        if (r101 != null) goto L14;
        return;
    L14:
        boolean r102 = r101.computeScrollOffset();     // Catch: ArrayIndexOutOfBoundsException -> L7
    L9:
        if (r102 == true) goto L11;
        return;
    L11:
        if (r100.isAttachedToWindow() == false) goto L17;
        ViewCompat.postOnAnimation(r100, this.f222161d);
        return;
    L17:
        return;
    L7:
        e = move-exception;
        tt5.a.e("ImmersiveWebContainerBehavior", "computeScrollOffset error, timePassed can't be negative", e, false);
        r102 = false;
        goto L9
    }

    public final void c(View r100, View r101) {
        a(new i(this));
        this.f222163f = r100;
        this.f222164g = r101;
        int r102 = r100.getHeight() - this.f222159b;
        r101.measure(View.MeasureSpec.makeMeasureSpec(r101.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r102, 1073741824));
        r101.layout(0, r100.getTop() + this.f222159b, r100.getRight(), r100.getBottom());
        if (this.f222162e == null) goto L5;
        return;
    L5:
        if (this.f222165h == false) goto L9;
        ViewTreeObserver r103 = r100.getViewTreeObserver();
        a r104 = new a(this);
        this.f222162e = r104;
        r104.f222171e = r103;
        r103.addOnPreDrawListener(r104);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean layoutDependsOn(CoordinatorLayout r100, View r101, View r102) {
        return r102 instanceof AppBarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onDependentViewChanged(CoordinatorLayout r100, View r101, View r102) {
        if (this.f222158a == r102.getMeasuredHeight()) goto L7;
        int r103 = r102.getMeasuredHeight();
        this.f222158a = r103;
        this.f222159b = r103;
        c(r100, r101);
        return false;
    L7:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDependentViewRemoved(CoordinatorLayout r100, View r101, View r102) {
        if (r102.isAttachedToWindow() == true) goto L6;
        this.f222158a = 0;
        this.f222159b = 0;
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
        if (r102.getAction() != 0) goto L9;
        Scroller r103 = this.f222160c;
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
        if (this.f222160c != null) goto L5;
        this.f222160c = new Scroller(r110.getContext());
    L5:
        b r115 = this.f222161d;
        if (r115 == null) goto L8;
        r115.f222174b.removeCallbacks(r115);
    L9:
        b r116 = this.f222161d;
        r116.f222176d = (int) r114;
        r116.f222177e = 0;
        this.f222160c.fling(0, r112.getScrollY(), 0, Math.round(r114), 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        b(r112);
        return false;
    L8:
        this.f222161d = new b(this, r110, r111, r112);
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout r100, View r101, int r102, int r110, int r111, int r112) {
        if (this.f222158a >= 0) goto L7;
        a(new g());
        View r113 = this.f222166i;
        if (r113 == null) goto L7;
        int r114 = r113.getMeasuredHeight();
        this.f222158a = r114;
        this.f222159b = r114;
    L7:
        a(new h(this));
        r100.onMeasureChild(r101, r102, r110, r111, this.f222159b);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
        if (r104 <= 0) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == false) goto L11;
        int r108 = MathUtils.clamp(this.f222159b - r104, 0, this.f222158a);
        int r109 = this.f222159b - r108;
        this.f222159b = r108;
        r105[1] = r109;
        if (r109 == 0) goto L12;
        c(r100, r101);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        a(new f(r102));
        r107 = !r102.canScrollVertically(-1);
        goto L6
    }
}
