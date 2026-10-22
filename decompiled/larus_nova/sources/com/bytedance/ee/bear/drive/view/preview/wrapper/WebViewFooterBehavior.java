package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Scroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class WebViewFooterBehavior extends FooterBehavior {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f225762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f225763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Scroller f225764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f225765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f225766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f225767i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f225768j;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f225769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f225770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f225771c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f225772d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewTreeObserver f225773e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ WebViewFooterBehavior f225774f;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.f225769a >= 0) goto L6;
            this.f225769a = (int) (((double) this.f225774f.f225762d) * 0.8d);
        L6:
            if (Math.abs(this.f225774f.f225763e - this.f225770b) <= this.f225769a) goto L8;
            this.f225772d = 0;
            this.f225771c = 3;
            this.f225774f.getClass();
        L8:
            WebViewFooterBehavior r100 = this.f225774f;
            this.f225770b = r100.f225763e;
            if (this.f225772d >= this.f225771c) goto L12;
            r100.getClass();
            this.f225772d++;
            return false;
        L12:
            r100.getClass();
            this.f225773e.removeOnPreDrawListener(this);
            this.f225774f.f225766h = null;
            return true;
        }

        public a(WebViewFooterBehavior r100) {
            this.f225774f = r100;
            this.f225769a = -1;
            this.f225772d = this.f225771c;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f225775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f225776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f225777c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f225778d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f225779e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ WebViewFooterBehavior f225780f;

        public final void a() {
            WebViewFooterBehavior r100 = this.f225780f;
            int r101 = this.f225778d;
            View r102 = this.f225777c;
            r100.getClass();
            boolean r103 = true;
            if (r101 > 0) goto L6;
            r103 = true ^ r102.canScrollVertically(-1);
        L6:
            if (r103 == false) goto L10;
            WebViewFooterBehavior r104 = this.f225780f;
            int r105 = r104.f225764f.getCurrY() - this.f225779e;
            int r106 = MathUtils.clamp(r104.f225763e - r105, 0, r104.f225762d);
            int r107 = r104.f225763e - r106;
            r104.f225763e = r106;
            if (r107 == 0) goto L10;
            this.f225780f.a(this.f225775a);
        L10:
            this.f225779e = this.f225780f.f225764f.getCurrY();
            WebViewFooterBehavior r108 = this.f225780f;
            View r109 = this.f225777c;
            Scroller r110 = r108.f225764f;
            if (r110 != null) goto L14;
            return;
        L14:
            if (r110.computeScrollOffset() == false) goto L17;
            ViewCompat.postOnAnimation(r109, r108.f225765g);
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

        public b(WebViewFooterBehavior r100, View r101, View r102, View r103) {
            this.f225780f = r100;
            this.f225775a = r101;
            this.f225776b = r102;
            this.f225777c = r103;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        this.f225763e = 0;
        View r100 = this.f225767i;
        if (r100 != null) goto L5;
    L7:
        Scroller r101 = this.f225764f;
        if (r101 == null) goto L10;
        r101.abortAnimation();
    L10:
        b r102 = this.f225765g;
        if (r102 == null) goto L13;
        r102.f225776b.removeCallbacks(r102);
    L13:
        a r103 = this.f225766h;
        if (r103 == null) goto L19;
        ViewTreeObserver r104 = r103.f225773e;
        if (r104 == null) goto L20;
        r104.removeOnPreDrawListener(r103);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (this.f225768j == null) goto L7;
        a(r100);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104, int r105) {
        if ((r104 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public WebViewFooterBehavior(FooterBehavior.a r100) {
        super(r100);
        this.f225762d = 150;
        this.f225763e = 150;
    }

    public final void a(View r100) {
        this.f225767i = r100;
        View r101 = r100.findViewById(R.id.drive_sdk_preview_viewpager);
        this.f225768j = r101;
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = r101.getPaddingBottom();
        this.f225768j.setPadding(0, this.f225763e, 0, r102);
        if (this.f225766h != null) goto L9;
        ViewTreeObserver r103 = r100.getViewTreeObserver();
        a r104 = new a(this);
        this.f225766h = r104;
        r104.f225773e = r103;
        r103.addOnPreDrawListener(r104);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
        if (r102.getAction() != 0) goto L9;
        Scroller r103 = this.f225764f;
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
        if (this.f225764f != null) goto L5;
        this.f225764f = new Scroller(r110.getContext());
    L5:
        b r115 = this.f225765g;
        if (r115 == null) goto L8;
        r115.f225776b.removeCallbacks(r115);
    L9:
        b r116 = this.f225765g;
        r116.f225778d = (int) r114;
        r116.f225779e = 0;
        this.f225764f.fling(0, r112.getScrollY(), 0, Math.round(r114), 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Scroller r117 = this.f225764f;
        if (r117 != null) goto L13;
    L15:
        return false;
    L13:
        if (r117.computeScrollOffset() == false) goto L15;
        ViewCompat.postOnAnimation(r112, this.f225765g);
        goto L15
    L8:
        this.f225765g = new b(this, r110, r111, r112);
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout r100, View r101, int r102, int r103, int r104, int r105) {
        this.f225767i = r100;
        r100.onMeasureChild(r101, r102, r103, r104, r105);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
        if (r104 != (-2147483647)) goto L7;
        a(r100);
        return;
    L7:
        if (r104 <= 0) goto L9;
        boolean r107 = true;
    L10:
        if (r107 == false) goto L15;
        int r108 = MathUtils.clamp(this.f225763e - r104, 0, this.f225762d);
        int r109 = this.f225763e - r108;
        this.f225763e = r108;
        r105[1] = r109;
        if (r109 == 0) goto L16;
        a(r100);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        r107 = !r102.canScrollVertically(-1);
        goto L10
    }
}
