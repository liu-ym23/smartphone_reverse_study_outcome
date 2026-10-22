package eqa;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.legacy.widget.Space;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements gqa.a, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f473550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f473551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f473552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f473553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f473554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f473555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f473556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f473557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f473558i;

    public final boolean a() {
        if (this.f473557h == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f473558i.a(this.f473550a) == false) goto L7;
        return true;
    }

    public final boolean b() {
        if (this.f473556g == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f473558i.b(this.f473550a) == false) goto L7;
        return true;
    }

    public a(View r100) {
        this.f473555f = 0;
        this.f473556g = true;
        this.f473557h = true;
        this.f473558i = new d();
        this.f473552c = r100;
        this.f473551b = r100;
        this.f473550a = r100;
    }

    public final a e(int r100) {
        View r101 = this.f473552c;
        if (r101 == null) goto L13;
        if (r100 == 0) goto L15;
        if (r100 >= 0) goto L8;
        float r102 = hqa.b.f486829b;
        if (r101.canScrollVertically(1) == false) goto L8;
    L11:
        this.f473555f = r100;
        return this;
    L8:
        if (r100 <= 0) goto L16;
        View r103 = this.f473552c;
        float r104 = hqa.b.f486829b;
        if (r103.canScrollVertically(-1) == true) goto L11;
        return null;
    L16:
        return null;
    L15:
        return null;
    L13:
        return null;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        int r101 = ((Integer) r100.getAnimatedValue()).intValue();
        float r102 = (r101 - this.f473555f) * this.f473552c.getScaleY();     // Catch: Throwable -> L8
        View r103 = this.f473552c;     // Catch: Throwable -> L8
        if ((r103 instanceof AbsListView) == false) goto L6;
        float r104 = hqa.b.f486829b;     // Catch: Throwable -> L8
        ((AbsListView) r103).scrollListBy((int) r102);     // Catch: Throwable -> L8
    L12:
    L10:
        this.f473555f = r101;
        return;
    L6:
        r103.scrollBy(0, (int) r102);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public static View c(View r100, PointF r101, View r102) {
        if ((r100 instanceof ViewGroup) == false) goto L14;
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount();
        PointF r105 = new PointF();
    L5:
        if (r104 <= 0) goto L14;
        r104 = r104 - 1;
        View r106 = r103.getChildAt(r104);
        if (hqa.b.e(r103, r106, r101.x, r101.y, r105) == false) goto L5;
        if ((r106 instanceof ViewPager) == false) goto L11;
    L12:
        r101.offset(r105.x, r105.y);
        View r107 = c(r106, r101, r102);
        r101.offset(-r105.x, -r105.y);
        return r107;
    L11:
        if (hqa.b.d(r106) == false) goto L12;
        return r106;
    L14:
        return r102;
    }

    public final void d(int r100, int r101, int r102) {
        boolean r103 = true;
        if (r101 == (-1)) goto L11;
        View r104 = this.f473551b.findViewById(r101);
        if (r104 == null) goto L11;
        if (r100 <= 0) goto L9;
        r104.setTranslationY(r100);
        boolean r105 = true;
    L12:
        if (r102 == (-1)) goto L20;
        View r106 = this.f473551b.findViewById(r102);
        if (r106 == null) goto L20;
        if (r100 >= 0) goto L18;
        r106.setTranslationY(r100);
    L21:
        if (r103 == true) goto L23;
        this.f473551b.setTranslationY(r100);
    L24:
        View r107 = this.f473553d;
        if (r107 == null) goto L27;
        r107.setTranslationY(Math.max(0, r100));
    L27:
        View r108 = this.f473554e;
        if (r108 == null) goto L31;
        r108.setTranslationY(Math.min(0, r100));
        return;
    L31:
        return;
    L23:
        this.f473551b.setTranslationY(0.0f);
        goto L24
    L18:
        if (r106.getTranslationY() >= 0.0f) goto L20;
        r106.setTranslationY(0.0f);
    L20:
        r103 = r105;
        goto L21
    L9:
        if (r104.getTranslationY() <= 0.0f) goto L11;
        r104.setTranslationY(0.0f);
    L11:
        r105 = false;
        goto L12
    }

    public final void f(SmartRefreshLayout.j r110, View r111, View r112) {
        View r100 = this.f473550a;
        boolean r101 = r100.isInEditMode();
        View r102 = null;
    L4:
        if (r102 != null) goto L6;
    L9:
        if (r102 != null) goto L11;
        boolean r113 = true;
    L12:
        LinkedList r114 = new LinkedList();
        r114.add(r100);
        View r115 = null;
    L14:
        if (r114.size() <= 0) goto L29;
        if (r115 != null) goto L29;
        View r116 = (View) r114.poll();
        if (r116 == null) goto L14;
        if (r113 == true) goto L21;
        if (r116 != r100) goto L21;
    L24:
        if ((r116 instanceof ViewGroup) == false) goto L14;
        ViewGroup r117 = (ViewGroup) r116;
        int r118 = 0;
    L27:
        if (r118 >= r117.getChildCount()) goto L14;
        r114.add(r117.getChildAt(r118));
        r118 = r118 + 1;
    L21:
        if (hqa.b.d(r116) == false) goto L24;
        r115 = r116;
    L29:
        if (r115 != null) goto L31;
        r115 = r100;
    L31:
        if (r115 == r102) goto L32;
        if (r101 == true) goto L54;
    L52:
        th = move-exception;
        th.printStackTrace();
        goto L54
    L44:
        if ((r115 instanceof CoordinatorLayout) == false) goto L54;
        r110.f405930a.setNestedScrollingEnabled(false);     // Catch: Throwable -> L52
        ViewGroup r103 = (ViewGroup) r115;     // Catch: Throwable -> L52
        int r104 = r103.getChildCount();     // Catch: Throwable -> L52
    L46:
        r104 = r104 - 1;     // Catch: Throwable -> L52
        if (r104 < 0) goto L54;
        View r105 = r103.getChildAt(r104);     // Catch: Throwable -> L52
        if ((r105 instanceof AppBarLayout) == false) goto L46;
        ((AppBarLayout) r105).addOnOffsetChangedListener(new hqa.a(this));     // Catch: Throwable -> L52
    L54:
        r100 = r115;
        r102 = r100;
    L32:
        if (r102 == null) goto L34;
        this.f473552c = r102;
    L34:
        if (r111 != null) goto L36;
        if (r112 != null) goto L36;
        return;
    L36:
        this.f473553d = r111;
        this.f473554e = r112;
        FrameLayout r106 = new FrameLayout(this.f473550a.getContext());
        int r107 = r110.f405930a.getLayout().indexOfChild(this.f473550a);
        r110.f405930a.getLayout().removeView(this.f473550a);
        r106.addView(this.f473550a, 0, new ViewGroup.LayoutParams(-1, -1));
        r110.f405930a.getLayout().addView(r106, r107, this.f473550a.getLayoutParams());
        this.f473550a = r106;
        if (r111 == null) goto L39;
        r111.setTag("fixed-top");
        ViewGroup.LayoutParams r108 = r111.getLayoutParams();
        ViewGroup r109 = (ViewGroup) r111.getParent();
        int r119 = r109.indexOfChild(r111);
        r109.removeView(r111);
        r108.height = hqa.b.f(r111);
        r109.addView(new Space(this.f473550a.getContext()), r119, r108);
        r106.addView(r111, 1, r108);
    L39:
        if (r112 == null) goto L81;
        r112.setTag("fixed-bottom");
        ViewGroup.LayoutParams r120 = r112.getLayoutParams();
        ViewGroup r121 = (ViewGroup) r112.getParent();
        int r122 = r121.indexOfChild(r112);
        r121.removeView(r112);
        FrameLayout.LayoutParams r123 = new FrameLayout.LayoutParams(r120);
        r120.height = hqa.b.f(r112);
        r121.addView(new Space(this.f473550a.getContext()), r122, r120);
        r123.gravity = 80;
        r106.addView(r112, 1, r123);
        return;
    L81:
        return;
    L11:
        r113 = false;
        goto L12
    L6:
        if ((r102 instanceof NestedScrollingParent) == false) goto L32;
        if ((r102 instanceof NestedScrollingChild) == true) goto L32;
        goto L9
    }
}
