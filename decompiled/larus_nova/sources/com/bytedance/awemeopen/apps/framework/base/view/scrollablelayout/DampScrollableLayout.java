package com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes14.dex */
public class DampScrollableLayout extends LinearLayout {
    public static final int N = 0;
    public boolean A;
    public boolean B;
    public final ValueAnimator C;
    public int D;
    public final List<View> E;
    public boolean F;
    public boolean G;
    public final a H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final List<d> f193457J;
    public d K;
    public final xx3.b L;
    public boolean M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scroller f193458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f193459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f193460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f193461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VelocityTracker f193462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f193463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f193464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f193465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f193466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f193467j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f193468k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f193469l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f193470m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f193471n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DmtViewPager f193472o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DIRECTION f193473p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f193474q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f193475r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f193476s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f193477t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f193478u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f193479v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f193480w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f193481x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f193482y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f193483z;

    public static final enum DIRECTION extends Enum<DIRECTION> {
        public static final DIRECTION DOWN = null;
        public static final DIRECTION UP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DIRECTION[] f193484a = null;

        static {
            DIRECTION r100 = new DIRECTION("UP", 0);
            UP = r100;
            DIRECTION r101 = new DIRECTION("DOWN", 1);
            DOWN = r101;
            f193484a = new DIRECTION[]{r100, r101};
        }

        public static DIRECTION[] values() {
            return (DIRECTION[]) f193484a.clone();
        }

        public static DIRECTION valueOf(String r100) {
            return (DIRECTION) r27.a.a(DIRECTION.class, r100);
        }

        public DIRECTION(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DampScrollableLayout f193485a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
        }

        public a(DampScrollableLayout r100) {
            this.f193485a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f193485a.D = r100;
        }
    }

    public class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DampScrollableLayout f193486a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public b(DampScrollableLayout r100) {
            this.f193486a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f193486a.B = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f193486a.B = false;
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f193487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f193488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DampScrollableLayout f193489c;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = r100.getAnimatedFraction();
            int r102 = this.f193487a;
            int r103 = this.f193488b;
            int r104 = ((int) ((r103 - r102) * (1.0f - r101))) + r102;
            if (r103 <= r102) goto L5;
            this.f193489c.b(0, Math.max(r102, r104));
            return;
        L5:
            this.f193489c.b(0, Math.min(r102, r104));
        }

        public c(DampScrollableLayout r100, int r101, int r102) {
            this.f193489c = r100;
            this.f193487a = r101;
            this.f193488b = r102;
        }
    }

    public interface d {
        boolean c();

        void d();

        void e(int r100);
    }

    static {
        N = x54.a.a(1200);
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f193458a.computeScrollOffset() == false) goto L36;
        int r100 = this.f193458a.getCurrY();
        Objects.toString(this.f193473p);
        DIRECTION r101 = this.f193473p;
        DIRECTION r102 = DIRECTION.UP;
        int r103 = 0;
        if (r101 != r102) goto L15;
        if (this.f193481x < this.f193479v) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L13;
        int r105 = this.f193458a.getFinalY() - r100;
        int r106 = this.f193458a.getDuration() - this.f193458a.timePassed();
        this.L.b((int) this.f193458a.getCurrVelocity(), r105, r106);
        this.f193458a.forceFinished(true);
        return;
    L13:
        scrollTo(0, r100);
        invalidate();
    L34:
        this.f193477t = r100;
        return;
    L9:
        r104 = false;
        goto L10
    L15:
        if (this.L.a() == false) goto L33;
        int r107 = r100 - this.f193477t;
        scrollTo(0, getScrollY() + r107);
        int r108 = this.f193458a.getFinalY() - r100;
        int r109 = this.f193458a.getDuration() - this.f193458a.timePassed();
        if (this.f193458a == null) goto L22;
        if (r109 == 0) goto L22;
        r103 = r108 / r109;
    L22:
        if (Math.abs(r103) < 1) goto L26;
        if (Math.abs(Math.max(this.f193458a.getFinalY(), this.f193478u) - this.f193481x) < 5) goto L26;
    L30:
        if (this.f193481x > this.f193478u) goto L33;
        this.f193458a.forceFinished(true);
        return;
    L26:
        if (this.f193481x >= 0) goto L30;
        this.f193458a.abortAnimation();
        Scroller r110 = this.f193458a;
        int r111 = this.f193481x;
        r110.startScroll(0, r111, 0, -r111, Math.abs(r111) * 2);
        this.f193473p = r102;
        return;
    L33:
        invalidate();
        goto L34
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        View r100 = this.f193471n;
        if (r100 != null) goto L5;
    L7:
        int r101 = getChildCount();
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L15;
        View r103 = getChildAt(r102);
        if (r103 == null) goto L14;
        if ((r103 instanceof DmtViewPager) == false) goto L14;
        DmtViewPager r104 = (DmtViewPager) r103;
        this.f193472o = r104;
        r104.b(this.H);
    L14:
        r102 = r102 + 1;
        goto L8
    L15:
        super.onFinishInflate();
        return;
    L5:
        if (r100.isClickable() == true) goto L7;
        this.f193471n.setClickable(true);
        goto L7
    }

    public int getCurScrollY() {
        return this.f193481x;
    }

    public xx3.b getHelper() {
        return this.L;
    }

    public int getMaxY() {
        return this.f193479v;
    }

    public int getMinY() {
        return this.f193478u;
    }

    public int getTabsMarginTop() {
        return this.f193480w;
    }

    public DampScrollableLayout(Context r100) {
        this(r100, null);
    }

    public final void d(d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (((ArrayList) this.f193457J).contains(r100) == true) goto L8;
        ((ArrayList) this.f193457J).add(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r210) {
        if (this.B == false) goto L6;
        return true;
    L6:
        if (this.F == false) goto L132;
        this.f193461d = r210.getY();
        return true;
    L132:
    L129:
        e = move-exception;
        e.printStackTrace();
    L131:
        return true;
    L10:
        if (r210.getActionIndex() == 0) goto L12;
        return true;
    L12:
        float r100 = r210.getX();     // Catch: IllegalArgumentException -> L129
        float r101 = r210.getY();     // Catch: IllegalArgumentException -> L129
        int r102 = (int) Math.abs(r100 - this.f193459b);     // Catch: IllegalArgumentException -> L129
        int r103 = (int) Math.abs(r101 - this.f193460c);     // Catch: IllegalArgumentException -> L129
        int r104 = r210.getAction() & 255;     // Catch: IllegalArgumentException -> L129
        boolean r105 = false;
        if (r104 != 0) goto L15;
    L119:
        this.f193466i = r210.getRawX();     // Catch: IllegalArgumentException -> L129
        this.f193467j = r210.getRawY();     // Catch: IllegalArgumentException -> L129
        this.f193475r = true;     // Catch: IllegalArgumentException -> L129
        this.f193476s = true;     // Catch: IllegalArgumentException -> L129
        this.f193459b = r100;     // Catch: IllegalArgumentException -> L129
        this.f193460c = r101;     // Catch: IllegalArgumentException -> L129
        this.f193461d = r101;     // Catch: IllegalArgumentException -> L129
        getScrollY();     // Catch: IllegalArgumentException -> L129
        int r106 = (int) r101;     // Catch: IllegalArgumentException -> L129
        if ((r106 + getScrollY()) > this.f193474q) goto L122;
        r105 = true;
    L122:
        this.f193482y = r105;     // Catch: IllegalArgumentException -> L129
        VelocityTracker r107 = this.f193462e;     // Catch: IllegalArgumentException -> L129
        if (r107 != null) goto L125;
        this.f193462e = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L129
    L126:
        this.f193462e.addMovement(r210);     // Catch: IllegalArgumentException -> L129
        this.f193458a.forceFinished(true);     // Catch: IllegalArgumentException -> L129
    L127:
        super.dispatchTouchEvent(r210);     // Catch: IllegalArgumentException -> L129
        goto L131
    L125:
        r107.clear();     // Catch: IllegalArgumentException -> L129
        goto L126
    L15:
        if (r104 != 1) goto L17;
    L62:
        d r108 = this.K;     // Catch: IllegalArgumentException -> L129
        if (r108 == null) goto L65;
        boolean r109 = r108.c();     // Catch: IllegalArgumentException -> L129
    L66:
        if (r109 == true) goto L72;
        Iterator r110 = ((ArrayList) this.f193457J).iterator();     // Catch: IllegalArgumentException -> L129
    L69:
        if (r110.hasNext() == false) goto L72;
        r109 = ((d) r110.next()).c();     // Catch: IllegalArgumentException -> L129
        if (r109 == false) goto L69;
    L72:
        if (r109 == true) goto L127;
        if (getScrollY() >= 0) goto L79;
        this.f193473p = DIRECTION.UP;     // Catch: IllegalArgumentException -> L129
        this.f193458a.startScroll(0, getScrollY(), 0, -getScrollY(), -getScrollY());     // Catch: IllegalArgumentException -> L129
        getScrollY();     // Catch: IllegalArgumentException -> L129
        this.f193458a.computeScrollOffset();     // Catch: IllegalArgumentException -> L129
        this.f193477t = getScrollY();     // Catch: IllegalArgumentException -> L129
        invalidate();     // Catch: IllegalArgumentException -> L129
        if (r104 == 3) goto L127;
        return true;
    L79:
        int r111 = this.f193481x;     // Catch: IllegalArgumentException -> L129
        if (r111 <= this.f193479v) goto L85;
        if (this.D != 0) goto L85;
        scrollBy(0, (int) (r101 - this.f193461d));     // Catch: IllegalArgumentException -> L129
    L85:
        if (this.f193476s == false) goto L127;
        if (r103 > r102) goto L89;
        if (r111 >= 0) goto L127;
    L89:
        if (r103 <= this.f193463f) goto L127;
        this.f193462e.computeCurrentVelocity(1000, this.f193465h);     // Catch: IllegalArgumentException -> L129
        float r112 = -this.f193462e.getYVelocity();
        if (this.D != 0) goto L112;
        if (Math.abs(r112) <= this.f193464g) goto L112;
        if (r112 <= 0.0f) goto L97;
        DIRECTION r113 = DIRECTION.UP;     // Catch: IllegalArgumentException -> L129
    L98:
        this.f193473p = r113;     // Catch: IllegalArgumentException -> L129
        if (r113 != DIRECTION.UP) goto L106;
        if (this.f193481x < this.f193479v) goto L103;
        boolean r114 = true;
    L104:
        if (r114 == false) goto L106;
    L107:
        boolean r115 = true;
    L109:
        if (r115 == true) goto L112;
        this.f193458a.fling(0, getScrollY(), 0, (int) r112, 0, 0, -2147483647, Integer.MAX_VALUE);     // Catch: IllegalArgumentException -> L129
        this.f193477t = getScrollY();     // Catch: IllegalArgumentException -> L129
        invalidate();     // Catch: IllegalArgumentException -> L129
        goto L112
    L103:
        r114 = false;
    L106:
        if (this.G == true) goto L107;
        r115 = false;
        goto L109
    L97:
        r113 = DIRECTION.DOWN;     // Catch: IllegalArgumentException -> L129
    L112:
        if (this.f193482y == false) goto L114;
    L117:
        int r116 = r210.getAction();     // Catch: IllegalArgumentException -> L129
        r210.setAction(3);     // Catch: IllegalArgumentException -> L129
        boolean r117 = super.dispatchTouchEvent(r210);     // Catch: IllegalArgumentException -> L129
        r210.setAction(r116);     // Catch: IllegalArgumentException -> L129
        return r117;
    L114:
        if (this.f193481x < this.f193479v) goto L116;
        r105 = true;
    L116:
        if (r105 == true) goto L127;
    L65:
        r109 = false;
        goto L66
    L17:
        if (r104 == 2) goto L25;
        if (r104 == 3) goto L62;
        if (r104 == 5) goto L119;
        if (r104 == 6) goto L62;
    L25:
        if (this.f193462e != null) goto L27;
        this.f193462e = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L129
    L27:
        this.f193462e.addMovement(r210);     // Catch: IllegalArgumentException -> L129
        float r118 = this.f193461d - r101;     // Catch: IllegalArgumentException -> L129
        d r119 = this.K;     // Catch: IllegalArgumentException -> L129
        if (r119 == null) goto L30;
        r119.d();     // Catch: IllegalArgumentException -> L129
    L30:
        Iterator r120 = ((ArrayList) this.f193457J).iterator();     // Catch: IllegalArgumentException -> L129
    L32:
        if (r120.hasNext() == false) goto L35;
        ((d) r120.next()).d();     // Catch: IllegalArgumentException -> L129
        goto L32
    L35:
        if (this.f193475r == true) goto L37;
    L41:
        this.L.a();     // Catch: IllegalArgumentException -> L129
        if (this.G == false) goto L44;
    L59:
        this.f193461d = r101;     // Catch: IllegalArgumentException -> L129
        this.f193468k = r210.getRawX();     // Catch: IllegalArgumentException -> L129
        float r121 = r210.getRawY();     // Catch: IllegalArgumentException -> L129
        this.f193469l = (int) (this.f193468k - this.f193466i);     // Catch: IllegalArgumentException -> L129
        float r122 = (int) (r121 - this.f193467j);     // Catch: IllegalArgumentException -> L129
        this.f193470m = r122;     // Catch: IllegalArgumentException -> L129
        if (Math.abs(r122) <= this.f193483z) goto L127;
        Math.abs(this.f193470m);     // Catch: IllegalArgumentException -> L129
        Math.abs(this.f193469l);     // Catch: IllegalArgumentException -> L129
        goto L127
    L44:
        if (a(r210, r102, r103) == true) goto L59;
        if (r103 <= this.f193463f) goto L59;
        if (this.f193481x < this.f193479v) goto L50;
        r105 = true;
    L50:
        if (r105 == true) goto L52;
    L53:
        DmtViewPager r123 = this.f193472o;     // Catch: IllegalArgumentException -> L129
        if (r123 == null) goto L57;
        r123.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L129
    L57:
        if (this.D != 0) goto L59;
        scrollBy(r102, (int) (((double) r118) + 0.5d));     // Catch: IllegalArgumentException -> L129
        goto L59
    L52:
        if (this.L.a() == false) goto L59;
    L37:
        if (r102 <= this.f193463f) goto L40;
        if (r102 <= r103) goto L40;
        this.f193475r = false;     // Catch: IllegalArgumentException -> L129
        this.f193476s = false;     // Catch: IllegalArgumentException -> L129
    L40:
        this.f193475r = false;     // Catch: IllegalArgumentException -> L129
        this.f193476s = true;     // Catch: IllegalArgumentException -> L129
        goto L41
    }

    public final void e(d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (((ArrayList) this.f193457J).contains(r100) == false) goto L8;
        ((ArrayList) this.f193457J).remove(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
    }

    public void setCanScroll(boolean r100) {
        this.B = !r100;
    }

    public void setCanScrollUp(boolean r100) {
        if (r100 == false) goto L5;
        this.f193479v = this.f193474q - this.f193480w;
    L5:
        if (this.A == false) goto L7;
    L9:
        this.I = r100;
        if (r100 == true) goto L12;
        this.f193479v = 0;
    L12:
        this.A = false;
        return;
    L7:
        if (this.I != r100) goto L9;
    }

    public void setChildViewPager(DmtViewPager r100) {
        this.f193472o = r100;
        r100.b(this.H);
    }

    public void setMaxScrollHeight(int r100) {
        int r101 = Math.min(r100, this.f193474q - this.f193480w);
        this.f193479v = r101;
        this.f193479v = Math.max(r101, 0);
    }

    public void setMinY(int r100) {
        this.f193478u = r100;
    }

    public void setOnScrollListener(d r100) {
        this.K = r100;
    }

    public void setPinOnSticked(boolean r100) {
        this.G = r100;
    }

    public void setScrollMinY(int r100) {
        this.f193483z = r100;
    }

    public void setTabsMarginTop(int r100) {
        this.f193480w = r100;
        this.A = true;
    }

    public void setVerticalAnimationStatus(boolean r100) {
        this.F = r100;
    }

    public DampScrollableLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void b(int r100, int r101) {
        this.f193481x = r101;
        d r102 = this.K;
        if (r102 == null) goto L5;
        r102.e(r101);
    L5:
        Iterator r103 = ((ArrayList) this.f193457J).iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        ((d) r103.next()).e(r101);
        goto L7
    L9:
        if (r101 != 0) goto L11;
    L12:
        this.B = false;
    L13:
        super.scrollTo(r100, r101);
        return;
    L11:
        if (r101 > this.f193479v) goto L13;
        goto L12
    }

    public final void c(int r100, int r101) {
        if (r100 != r101) goto L4;
        return;
    L4:
        this.B = true;
        this.C.cancel();
        this.C.removeAllUpdateListeners();
        this.C.addUpdateListener(new c(this, r101, r100));
        this.C.setDuration((Math.abs(r100 - r101) * 1000) / N);
        this.C.start();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        View r102 = getChildAt(0);
        this.f193471n = r102;
        if (r102 == null) goto L5;
        measureChildWithMargins(r102, r100, 0, 0, 0);
        this.f193474q = this.f193471n.getMeasuredHeight();
    L5:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r101) + (this.f193474q - this.f193480w), 1073741824));
        if (this.M == true) goto L8;
        this.f193479v = this.f193474q - this.f193480w;
        this.M = true;
    L8:
        this.B = false;
    }

    @Override // android.view.View
    public final void scrollBy(int r100, int r101) {
        if (this.f193481x <= this.f193479v) goto L32;
        if (r101 < 0) goto L6;
    L31:
        int r102 = 0;
    L44:
        if (r102 == 0) goto L47;
        super.scrollBy(0, r102);
        return;
    L47:
        return;
    L6:
        if (Math.abs(r100) >= this.f193463f) goto L31;
        int r103 = this.f193481x;
        int r104 = this.f193479v;
        if (r103 >= r104) goto L10;
        b(0, 0);
        goto L31
    L10:
        xx3.b r105 = this.L;
        if (r105 == null) goto L26;
        xx3.b.a r106 = r105.f565327a;
        if (r106 != null) goto L16;
        ViewGroup r107 = null;
    L17:
        if (r107 != null) goto L20;
    L27:
        boolean r108 = false;
    L28:
        if (r108 == false) goto L30;
        c(r103, 0);
        goto L31
    L30:
        c(r103, r104);
        goto L31
    L20:
        if ((r107 instanceof AdapterView) == false) goto L25;
        if (((AdapterView) r107).getChildCount() != 0) goto L27;
    L25:
        if (r107.getChildCount() != 0) goto L27;
    L16:
        r107 = r106.tA();
    L26:
        r108 = true;
        goto L28
    L32:
        int r109 = getScrollY();
        if (r101 >= 0) goto L37;
        int r110 = r109 + r101;
        if (r110 >= 0) goto L37;
        r101 = (int) ((r101 * 1.2f) * (1.0f - ((1.0f / this.f193478u) * r110)));
    L37:
        int r111 = r101 + r109;
        int r112 = this.f193479v;
        if (r111 < r112) goto L40;
    L39:
        r111 = r112;
    L43:
        r102 = r111 - r109;
        goto L44
    L40:
        r112 = this.f193478u;
        if (r111 > r112) goto L43;
        goto L43
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        int r102 = this.f193479v;
        if (r101 < r102) goto L5;
    L4:
        r101 = r102;
    L8:
        b(r100, r101);
        return;
    L5:
        r102 = this.f193478u;
        if (r101 > r102) goto L8;
        goto L8
    }

    public DampScrollableLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193478u = 0;
        this.f193479v = 0;
        this.f193480w = 0;
        this.f193483z = 10;
        this.A = false;
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{0, 1});
        this.C = r103;
        this.E = new ArrayList();
        this.F = false;
        this.G = false;
        this.H = new a(this);
        this.I = true;
        this.f193457J = new ArrayList();
        this.M = false;
        this.L = new xx3.b();
        this.f193458a = new Scroller(r100);
        ViewConfiguration r104 = ViewConfiguration.get(r100);
        this.f193463f = r104.getScaledTouchSlop();
        this.f193464g = r104.getScaledMinimumFlingVelocity();
        this.f193465h = r104.getScaledMaximumFlingVelocity();
        setOrientation(1);
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.scrollable_autoMaxScroll, R.attr.scrollable_autoMaxScrollViewId, R.attr.scrollable_closeUpAnimationMillis, R.attr.scrollable_closeUpAnimatorInterpolator, R.attr.scrollable_considerIdleMillis, R.attr.scrollable_defaultCloseUp, R.attr.scrollable_friction, R.attr.scrollable_maxScroll, R.attr.scrollable_scrollerFlywheel, R.attr.scrollable_scrollingHeaderId, R.attr.tabs_marginTop});
        this.f193480w = (int) r105.getDimension(10, 0.0f);
        r105.recycle();
        r103.setInterpolator(new AccelerateDecelerateInterpolator());
        r103.addListener(new b(this));
    }

    public final boolean a(MotionEvent r100, int r110, int r111) {
        if (((ArrayList) this.E).isEmpty() == true) goto L29;
        int r101 = (int) r100.getRawX();
        int r102 = (int) r100.getRawY();
        Iterator r103 = ((ArrayList) this.E).iterator();
    L6:
        if (r103.hasNext() == false) goto L19;
        View r104 = (View) r103.next();
        if (r104 == null) goto L16;
        int[] r105 = new int[2];
        r104.getLocationOnScreen(r105);
        int r106 = r105[0];
        int r107 = r105[1];
        int r108 = r104.getMeasuredWidth() + r106;
        int r109 = r104.getMeasuredHeight() + r107;
        if (r102 < r107) goto L16;
        if (r102 > r109) goto L16;
        if (r101 < r106) goto L16;
        if (r101 > r108) goto L16;
        boolean r112 = true;
    L17:
        if (r112 == false) goto L6;
        boolean r113 = true;
    L20:
        if (r113 == false) goto L30;
        if (r111 >= r110) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L16:
        r112 = false;
        goto L17
    L19:
        r113 = false;
        goto L20
    L29:
        return false;
    }
}
