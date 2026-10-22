package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Scroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.document.loading.SmallLoadingPlugin;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WebViewFooterBehavior extends FooterBehavior {
    public final int d;
    public int e;
    public Scroller f;
    public b g;
    public a h;
    public View i;
    public View j;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public int a;
        public int b;
        public int c;
        public int d;
        public ViewTreeObserver e;
        public final /* synthetic */ WebViewFooterBehavior f;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.a >= 0) goto L6;
            this.a = (int) (((double) this.f.d) * 0.8d);
        L6:
            if (Math.abs(this.f.e - this.b) <= this.a) goto L8;
            this.d = 0;
            this.c = 3;
            this.f.getClass();
        L8:
            WebViewFooterBehavior r0 = this.f;
            this.b = r0.e;
            if (this.d >= this.c) goto L12;
            r0.getClass();
            this.d++;
            return false;
        L12:
            r0.getClass();
            this.e.removeOnPreDrawListener(this);
            this.f.h = null;
            return true;
        }

        public a(WebViewFooterBehavior r1) {
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
        public final /* synthetic */ WebViewFooterBehavior f;

        public final void a() {
            WebViewFooterBehavior r0 = this.f;
            int r1 = this.d;
            View r2 = this.c;
            r0.getClass();
            boolean r3 = true;
            if (r1 > 0) goto L6;
            r3 = true ^ r2.canScrollVertically(-1);
        L6:
            if (r3 == false) goto L10;
            WebViewFooterBehavior r4 = this.f;
            int r5 = r4.f.getCurrY() - this.e;
            int r6 = MathUtils.clamp(r4.e - r5, 0, r4.d);
            int r7 = r4.e - r6;
            r4.e = r6;
            if (r7 == 0) goto L10;
            this.f.a(this.a);
        L10:
            this.e = this.f.f.getCurrY();
            WebViewFooterBehavior r8 = this.f;
            View r9 = this.c;
            Scroller r10 = r8.f;
            if (r10 != null) goto L14;
            return;
        L14:
            if (r10.computeScrollOffset() == false) goto L17;
            ViewCompat.postOnAnimation(r9, r8.g);
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

        public b(WebViewFooterBehavior r1, View r2, View r3, View r4) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public final void onDetachedFromLayoutParams() {
        this.e = 0;
        View r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        Scroller r1 = this.f;
        if (r1 == null) goto L10;
        r1.abortAnimation();
    L10:
        b r2 = this.g;
        if (r2 == null) goto L13;
        r2.b.removeCallbacks(r2);
    L13:
        a r3 = this.h;
        if (r3 == null) goto L19;
        ViewTreeObserver r4 = r3.e;
        if (r4 == null) goto L20;
        r4.removeOnPreDrawListener(r3);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (this.j == null) goto L7;
        a(r0);
        goto L7
    }

    public final boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5, int r6) {
        if ((r5 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public WebViewFooterBehavior(FooterBehavior.a r1) {
        super(r1);
        this.d = 150;
        this.e = 150;
    }

    public final void a(View r5) {
        this.i = r5;
        View r0 = r5.findViewById(2131370322);
        this.j = r0;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getPaddingBottom();
        this.j.setPadding(0, this.e, 0, r1);
        if (this.h != null) goto L9;
        ViewTreeObserver r6 = r5.getViewTreeObserver();
        a r2 = new a(this);
        this.h = r2;
        r2.e = r6;
        r6.addOnPreDrawListener(r2);
        return;
    }

    public final boolean onInterceptTouchEvent(CoordinatorLayout r1, View r2, MotionEvent r3) {
        if (r3.getAction() != 0) goto L9;
        Scroller r4 = this.f;
        if (r4 == null) goto L10;
        r4.abortAnimation();
        return false;
    L10:
        return false;
    L9:
        return false;
    }

    public final boolean onNestedPreFling(CoordinatorLayout r10, View r11, View r12, float r13, float r14) {
        if (this.f != null) goto L5;
        this.f = new Scroller(r10.getContext());
    L5:
        b r16 = this.g;
        if (r16 == null) goto L8;
        r16.b.removeCallbacks(r16);
    L9:
        b r17 = this.g;
        r17.d = (int) r14;
        r17.e = 0;
        this.f.fling(0, r12.getScrollY(), 0, Math.round(r14), 0, 0, ShareItemModel.SRC_TINT_UNDEFINED, SmallLoadingPlugin.DURATION_MAX);
        Scroller r18 = this.f;
        if (r18 != null) goto L13;
    L15:
        return false;
    L13:
        if (r18.computeScrollOffset() == false) goto L15;
        ViewCompat.postOnAnimation(r12, this.g);
        goto L15
    L8:
        this.g = new b(this, r10, r11, r12);
        goto L9
    }

    public final boolean onMeasureChild(CoordinatorLayout r1, View r2, int r3, int r4, int r5, int r6) {
        this.i = r1;
        r1.onMeasureChild(r2, r3, r4, r5, r6);
        return true;
    }

    public final void onNestedPreScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int[] r6, int r7) {
        if (r5 != (-2147483647)) goto L7;
        a(r1);
        return;
    L7:
        if (r5 <= 0) goto L9;
        boolean r8 = true;
    L10:
        if (r8 == false) goto L15;
        int r9 = MathUtils.clamp(this.e - r5, 0, this.d);
        int r10 = this.e - r9;
        this.e = r9;
        r6[1] = r10;
        if (r10 == 0) goto L16;
        a(r1);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        r8 = !r3.canScrollVertically(-1);
        goto L10
    }
}
