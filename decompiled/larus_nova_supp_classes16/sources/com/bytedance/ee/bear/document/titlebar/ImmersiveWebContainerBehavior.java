package com.bytedance.ee.bear.document.titlebar;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Scroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.document.loading.SmallLoadingPlugin;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImmersiveWebContainerBehavior extends CoordinatorLayout.Behavior<View> {
    public int a;
    public int b;
    public Scroller c;
    public b d;
    public a e;
    public View f;
    public View g;
    public boolean h;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public int a;
        public int b;
        public int c;
        public int d;
        public ViewTreeObserver e;
        public final /* synthetic */ ImmersiveWebContainerBehavior f;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.e.isAlive() == true) goto L7;
            tt5.a.k("ImmersiveWebContainerBehavior", "viewTreeObserver isn't alive");
            return false;
        L7:
            if (this.a >= 0) goto L10;
            this.a = (int) (this.f.a * 0.8f);
        L10:
            if (Math.abs(this.f.b - this.b) <= this.a) goto L12;
            this.d = 0;
            this.c = 3;
            this.f.getClass();
        L12:
            ImmersiveWebContainerBehavior r0 = this.f;
            this.b = r0.b;
            if (this.d >= this.c) goto L16;
            r0.getClass();
            this.d++;
            return false;
        L16:
            r0.getClass();
            this.e.removeOnPreDrawListener(this);
            this.f.e = null;
            return true;
        }

        public a(ImmersiveWebContainerBehavior r1) {
            this.f = r1;
            this.a = -1;
            this.d = this.c;
        }
    }

    public class b implements Runnable {
        public final View a;
        public final View b;
        public final View c;
        public int d;
        public int e;
        public final /* synthetic */ ImmersiveWebContainerBehavior f;

        public final void a() {
            ImmersiveWebContainerBehavior r0 = this.f;
            int r1 = this.d;
            View r2 = this.c;
            r0.getClass();
            boolean r3 = true;
            if (r1 > 0) goto L6;
            r3 = true ^ r2.canScrollVertically(-1);
        L6:
            if (r3 == false) goto L10;
            ImmersiveWebContainerBehavior r4 = this.f;
            int r5 = r4.c.getCurrY() - this.e;
            int r6 = MathUtils.clamp(r4.b - r5, 0, r4.a);
            int r7 = r4.b - r6;
            r4.b = r6;
            if (r7 == 0) goto L10;
            this.f.b(this.a, this.b);
        L10:
            this.e = this.f.c.getCurrY();
            this.f.a(this.c);
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

        public b(ImmersiveWebContainerBehavior r1, View r2, View r3, View r4) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public final void onDetachedFromLayoutParams() {
        this.b = 0;
        View r0 = this.f;
        if (r0 == null) goto L7;
        View r1 = this.g;
        if (r1 == null) goto L7;
        b(r0, r1);
    L7:
        Scroller r2 = this.c;
        if (r2 == null) goto L10;
        r2.abortAnimation();
    L10:
        b r3 = this.d;
        if (r3 == null) goto L13;
        r3.b.removeCallbacks(r3);
    L13:
        a r4 = this.e;
        if (r4 == null) goto L21;
        ViewTreeObserver r5 = r4.e;
        if (r5 != null) goto L18;
        return;
    L18:
        if (r5.isAlive() == false) goto L23;
        r4.e.removeOnPreDrawListener(r4);
        return;
    L23:
        return;
    }

    public final boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5, int r6) {
        if ((r5 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ImmersiveWebContainerBehavior() {
        this.a = -1;
        this.h = true;
    }

    public final void a(View r5) {
        Scroller r0 = this.c;
        if (r0 != null) goto L14;
        return;
    L14:
        boolean r1 = r0.computeScrollOffset();     // Catch: ArrayIndexOutOfBoundsException -> L7
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        if (r5.isAttachedToWindow() == false) goto L17;
        ViewCompat.postOnAnimation(r5, this.d);
        return;
    L17:
        return;
    L7:
        e = move-exception;
        tt5.a.e("ImmersiveWebContainerBehavior", "computeScrollOffset error, timePassed can't be negative", e, false);
        r1 = false;
        goto L9
    }

    public final void b(View r5, View r6) {
        this.f = r5;
        this.g = r6;
        int r0 = r5.getHeight() - this.b;
        r6.measure(View.MeasureSpec.makeMeasureSpec(r6.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r0, 1073741824));
        r6.layout(0, r5.getTop() + this.b, r5.getRight(), r5.getBottom());
        if (this.e == null) goto L5;
        return;
    L5:
        if (this.h == false) goto L9;
        ViewTreeObserver r7 = r5.getViewTreeObserver();
        a r8 = new a(this);
        this.e = r8;
        r8.e = r7;
        r7.addOnPreDrawListener(r8);
        return;
    }

    public final boolean layoutDependsOn(CoordinatorLayout r1, View r2, View r3) {
        return r3 instanceof AppBarLayout;
    }

    public final boolean onDependentViewChanged(CoordinatorLayout r3, View r4, View r5) {
        if (this.a == r5.getMeasuredHeight()) goto L7;
        int r6 = r5.getMeasuredHeight();
        this.a = r6;
        this.b = r6;
        b(r3, r4);
        return false;
    L7:
        return false;
    }

    public final void onDependentViewRemoved(CoordinatorLayout r1, View r2, View r3) {
        if (r3.isAttachedToWindow() == true) goto L6;
        this.a = 0;
        this.b = 0;
        return;
    }

    public final boolean onInterceptTouchEvent(CoordinatorLayout r1, View r2, MotionEvent r3) {
        if (r3.getAction() != 0) goto L9;
        Scroller r4 = this.c;
        if (r4 == null) goto L10;
        r4.abortAnimation();
        return false;
    L10:
        return false;
    L9:
        return false;
    }

    public final boolean onNestedPreFling(CoordinatorLayout r10, View r11, View r12, float r13, float r14) {
        if (this.c != null) goto L5;
        this.c = new Scroller(r10.getContext());
    L5:
        b r16 = this.d;
        if (r16 == null) goto L8;
        r16.b.removeCallbacks(r16);
    L9:
        b r17 = this.d;
        r17.d = (int) r14;
        r17.e = 0;
        this.c.fling(0, r12.getScrollY(), 0, Math.round(r14), 0, 0, ShareItemModel.SRC_TINT_UNDEFINED, SmallLoadingPlugin.DURATION_MAX);
        a(r12);
        return false;
    L8:
        this.d = new b(this, r10, r11, r12);
        goto L9
    }

    public final boolean onMeasureChild(CoordinatorLayout r7, View r8, int r9, int r10, int r11, int r12) {
        if (this.a >= 0) goto L7;
        View r13 = r7.findViewById(2131369266);
        if (r13 == null) goto L7;
        int r14 = r13.getMeasuredHeight();
        this.a = r14;
        this.b = r14;
    L7:
        r7.onMeasureChild(r8, r9, r10, r11, this.b);
        return true;
    }

    public final void onNestedPreScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int[] r6, int r7) {
        if (r5 <= 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L11;
        int r9 = MathUtils.clamp(this.b - r5, 0, this.a);
        int r10 = this.b - r9;
        this.b = r9;
        r6[1] = r10;
        if (r10 == 0) goto L12;
        b(r1, r2);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r8 = !r3.canScrollVertically(-1);
        goto L6
    }
}
