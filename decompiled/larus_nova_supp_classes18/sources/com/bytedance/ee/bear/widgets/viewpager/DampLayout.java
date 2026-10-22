package com.bytedance.ee.bear.widgets.viewpager;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.NestedScrollingParent2;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import op5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DampLayout extends ConstraintLayout implements NestedScrollingParent2 {
    public final int a;
    public final int b;
    public final View c;
    public final View d;
    public b e;
    public int f;
    public a g;

    public interface a {
        void a();

        void b();
    }

    public class b extends ValueAnimator {
        public static final /* synthetic */ int c = 0;
        public View a;
        public final /* synthetic */ DampLayout b;

        public b(DampLayout r3) {
            this.b = r3;
            setInterpolator(new f());
            setDuration(700);
            addUpdateListener(new com.bytedance.ee.bear.widgets.viewpager.a(this));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        if (getScrollY() == 0) goto L6;
        scrollTo(0, 0);
        return;
    }

    public DampLayout(Context r2) {
        super(r2);
        this.a = n.d(120);
        this.b = n.d(60);
        this.e = null;
        this.f = 0;
        this.c = new View(r2);
        this.d = new View(r2);
    }

    public void setOnHeaderOrFooterListener(a r1) {
        this.g = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStopNestedScroll(View r6, int r7) {
        int r0 = getScrollY();
        if (r0 == 0) goto L5;
        b r1 = this.e;
        int r3 = b.c;
        r1.getClass();
        r1.setFloatValues(new float[]{r0, 0.0f});
        r1.a = r6;
        r1.start();
    L5:
        if (r7 != 0) goto L20;
        int r8 = this.b;
        if (r0 <= (-r8)) goto L9;
    L13:
        if (r0 >= r8) goto L15;
        return;
    L15:
        if (this.f <= 0) goto L24;
        a r9 = this.g;
        if (r9 == null) goto L25;
        r9.a();
        return;
    L25:
        return;
    L24:
        return;
    L9:
        if (this.f >= 0) goto L13;
        a r10 = this.g;
        if (r10 == null) goto L21;
        r10.b();
        return;
    L21:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void scrollTo(int r3, int r4) {
        int r0 = this.a;
        if (r4 >= (-r0)) goto L5;
        r4 = -r0;
    L7:
        super/*android.view.ViewGroup*/.scrollTo(r3, r4);
        return;
    L5:
        if (r4 <= r0) goto L7;
        r4 = r0;
        goto L7
    }

    public final void onNestedScrollAccepted(View r1, View r2, int r3, int r4) {
        b r5 = this.e;
        if (r5 != null) goto L5;
        this.e = new b(this);
        return;
    L5:
        r5.cancel();
    }

    public final boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        return r2 instanceof RecyclerView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNestedPreScroll(View r8, int r9, int r10, int[] r11, int r12) {
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f = r10;
        int r13 = -1;
        if (r10 > 0) goto L5;
    L9:
        boolean r2 = false;
    L10:
        if (r10 < 0) goto L12;
    L16:
        boolean r3 = false;
    L17:
        if (r10 < 0) goto L19;
    L23:
        boolean r4 = false;
    L24:
        if (r10 > 0) goto L26;
    L30:
        boolean r14 = false;
    L31:
        if (r2 == true) goto L35;
        if (r3 == true) goto L35;
        if (r4 == true) goto L35;
        if (r14 == true) goto L35;
        return;
    L35:
        this.e.cancel();
        if (r12 != 0) goto L42;
        int r15 = (int) (r10 * ((((this.a - Math.abs(getScrollY())) / this.a) * 0.7f) + 0.3f));
        if (r15 != 0) goto L41;
        if (r10 <= 0) goto L43;
        r13 = 1;
    L43:
        scrollBy(0, r13);
        r11[1] = r10;
        return;
    L41:
        r13 = r15;
        goto L43
    L42:
        r13 = r10;
        goto L43
    L26:
        if (getScrollY() >= this.a) goto L30;
        if (r8.canScrollVertically(1) == true) goto L30;
        r14 = true;
        goto L31
    L19:
        if (getScrollY() <= 0) goto L23;
        if (r8.canScrollVertically(1) == true) goto L23;
        r4 = true;
        goto L24
    L12:
        if (getScrollY() <= (-this.a)) goto L16;
        if (r8.canScrollVertically(-1) == true) goto L16;
        r3 = true;
        goto L17
    L5:
        if (getScrollY() >= 0) goto L9;
        if (r8.canScrollVertically(-1) == true) goto L9;
        r2 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (r6 == 1) goto L5;
        return;
    L5:
        if (getScrollY() == (-this.a)) goto L9;
        if (getScrollY() == this.a) goto L9;
        return;
    L9:
        if ((r1 instanceof RecyclerView) == false) goto L14;
        ((RecyclerView) r1).stopScroll();
        return;
    }
}
