package com.bytedance.ee.bear.widgets.viewpager;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.NestedScrollingParent2;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import op5.f;

/* JADX INFO: loaded from: classes18.dex */
public class DampLayout extends ConstraintLayout implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f240354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f240355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f240356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f240357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f240358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f240359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f240360g;

    public interface a {
        void a();

        void b();
    }

    public class b extends ValueAnimator {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f240361c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f240362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DampLayout f240363b;

        public b(DampLayout r100) {
            this.f240363b = r100;
            setInterpolator(new f());
            setDuration(700);
            addUpdateListener(new com.bytedance.ee.bear.widgets.viewpager.a(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getScrollY() == 0) goto L6;
        scrollTo(0, 0);
        return;
    }

    public DampLayout(Context r100) {
        super(r100);
        this.f240354a = n.d(120);
        this.f240355b = n.d(60);
        this.f240358e = null;
        this.f240359f = 0;
        this.f240356c = new View(r100);
        this.f240357d = new View(r100);
    }

    public void setOnHeaderOrFooterListener(a r100) {
        this.f240360g = r100;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        int r102 = getScrollY();
        if (r102 == 0) goto L5;
        b r103 = this.f240358e;
        int r104 = b.f240361c;
        r103.getClass();
        r103.setFloatValues(new float[]{r102, 0.0f});
        r103.f240362a = r100;
        r103.start();
    L5:
        if (r101 != 0) goto L20;
        int r105 = this.f240355b;
        if (r102 <= (-r105)) goto L9;
    L13:
        if (r102 >= r105) goto L15;
        return;
    L15:
        if (this.f240359f <= 0) goto L24;
        a r106 = this.f240360g;
        if (r106 == null) goto L25;
        r106.a();
        return;
    L25:
        return;
    L24:
        return;
    L9:
        if (this.f240359f >= 0) goto L13;
        a r107 = this.f240360g;
        if (r107 == null) goto L21;
        r107.b();
        return;
    L21:
        return;
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        int r102 = this.f240354a;
        if (r101 >= (-r102)) goto L5;
        r101 = -r102;
    L7:
        super.scrollTo(r100, r101);
        return;
    L5:
        if (r101 <= r102) goto L7;
        r101 = r102;
        goto L7
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        b r104 = this.f240358e;
        if (r104 != null) goto L5;
        this.f240358e = new b(this);
        return;
    L5:
        r104.cancel();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        return r101 instanceof RecyclerView;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r110, int[] r111, int r112) {
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f240359f = r110;
        int r102 = -1;
        if (r110 > 0) goto L5;
    L9:
        boolean r103 = false;
    L10:
        if (r110 < 0) goto L12;
    L16:
        boolean r104 = false;
    L17:
        if (r110 < 0) goto L19;
    L23:
        boolean r105 = false;
    L24:
        if (r110 > 0) goto L26;
    L30:
        boolean r106 = false;
    L31:
        if (r103 == true) goto L35;
        if (r104 == true) goto L35;
        if (r105 == true) goto L35;
        if (r106 == true) goto L35;
        return;
    L35:
        this.f240358e.cancel();
        if (r112 != 0) goto L42;
        int r107 = (int) (r110 * ((((this.f240354a - Math.abs(getScrollY())) / this.f240354a) * 0.7f) + 0.3f));
        if (r107 != 0) goto L41;
        if (r110 <= 0) goto L43;
        r102 = 1;
    L43:
        scrollBy(0, r102);
        r111[1] = r110;
        return;
    L41:
        r102 = r107;
        goto L43
    L42:
        r102 = r110;
        goto L43
    L26:
        if (getScrollY() >= this.f240354a) goto L30;
        if (r100.canScrollVertically(1) == true) goto L30;
        r106 = true;
        goto L31
    L19:
        if (getScrollY() <= 0) goto L23;
        if (r100.canScrollVertically(1) == true) goto L23;
        r105 = true;
        goto L24
    L12:
        if (getScrollY() <= (-this.f240354a)) goto L16;
        if (r100.canScrollVertically(-1) == true) goto L16;
        r104 = true;
        goto L17
    L5:
        if (getScrollY() >= 0) goto L9;
        if (r100.canScrollVertically(-1) == true) goto L9;
        r103 = true;
        goto L10
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (r105 == 1) goto L5;
        return;
    L5:
        if (getScrollY() == (-this.f240354a)) goto L9;
        if (getScrollY() == this.f240354a) goto L9;
        return;
    L9:
        if ((r100 instanceof RecyclerView) == false) goto L14;
        ((RecyclerView) r100).stopScroll();
        return;
    }
}
