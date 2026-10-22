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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
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
    public final List<d> J;
    public d K;
    public final xx3.b L;
    public boolean M;
    public final Scroller a;
    public float b;
    public float c;
    public float d;
    public VelocityTracker e;
    public final int f;
    public final int g;
    public final int h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public View n;
    public DmtViewPager o;
    public DIRECTION p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public int z;

    public static final enum DIRECTION extends Enum<DIRECTION> {
        public static final DIRECTION DOWN = null;
        public static final DIRECTION UP = null;
        public static final /* synthetic */ DIRECTION[] a = null;

        static {
            DIRECTION r0 = new DIRECTION("UP", 0);
            UP = r0;
            DIRECTION r1 = new DIRECTION("DOWN", 1);
            DOWN = r1;
            a = new DIRECTION[]{r0, r1};
        }

        public static DIRECTION[] values() {
            return (DIRECTION[]) a.clone();
        }

        public static DIRECTION valueOf(String r1) {
            return (DIRECTION) r27.a.a(DIRECTION.class, r1);
        }

        public DIRECTION(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a implements ViewPager.OnPageChangeListener {
        public final /* synthetic */ DampScrollableLayout a;

        public final void onPageScrolled(int r1, float r2, int r3) {
        }

        public final void onPageSelected(int r1) {
        }

        public a(DampScrollableLayout r1) {
            this.a = r1;
        }

        public final void onPageScrollStateChanged(int r2) {
            this.a.D = r2;
        }
    }

    public class b implements Animator.AnimatorListener {
        public final /* synthetic */ DampScrollableLayout a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public b(DampScrollableLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            this.a.B = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.B = false;
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ DampScrollableLayout c;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            float r6 = r5.getAnimatedFraction();
            int r0 = this.a;
            int r1 = this.b;
            int r7 = ((int) ((r1 - r0) * (1.0f - r6))) + r0;
            if (r1 <= r0) goto L5;
            this.c.b(0, Math.max(r0, r7));
            return;
        L5:
            this.c.b(0, Math.min(r0, r7));
        }

        public c(DampScrollableLayout r1, int r2, int r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public interface d {
        boolean c();

        void d();

        void e(int r1);
    }

    static {
        N = x54.a.a(1200);
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.a.computeScrollOffset() == false) goto L36;
        int r0 = this.a.getCurrY();
        Objects.toString(this.p);
        DIRECTION r1 = this.p;
        DIRECTION r2 = DIRECTION.UP;
        int r3 = 0;
        if (r1 != r2) goto L15;
        if (this.x < this.v) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L13;
        int r5 = this.a.getFinalY() - r0;
        int r6 = this.a.getDuration() - this.a.timePassed();
        this.L.b((int) this.a.getCurrVelocity(), r5, r6);
        this.a.forceFinished(true);
        return;
    L13:
        scrollTo(0, r0);
        invalidate();
    L34:
        this.t = r0;
        return;
    L9:
        r4 = false;
        goto L10
    L15:
        if (this.L.a() == false) goto L33;
        int r7 = r0 - this.t;
        scrollTo(0, getScrollY() + r7);
        int r8 = this.a.getFinalY() - r0;
        int r9 = this.a.getDuration() - this.a.timePassed();
        if (this.a == null) goto L22;
        if (r9 == 0) goto L22;
        r3 = r8 / r9;
    L22:
        if (Math.abs(r3) < 1) goto L26;
        if (Math.abs(Math.max(this.a.getFinalY(), this.u) - this.x) < 5) goto L26;
    L30:
        if (this.x > this.u) goto L33;
        this.a.forceFinished(true);
        return;
    L26:
        if (this.x >= 0) goto L30;
        this.a.abortAnimation();
        Scroller r10 = this.a;
        int r11 = this.x;
        r10.startScroll(0, r11, 0, -r11, Math.abs(r11) * 2);
        this.p = r2;
        return;
    L33:
        invalidate();
        goto L34
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        View r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        int r1 = getChildCount();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L15;
        View r3 = getChildAt(r2);
        if (r3 == null) goto L14;
        if ((r3 instanceof DmtViewPager) == false) goto L14;
        DmtViewPager r4 = (DmtViewPager) r3;
        this.o = r4;
        r4.b(this.H);
    L14:
        r2 = r2 + 1;
        goto L8
    L15:
        super.onFinishInflate();
        return;
    L5:
        if (r0.isClickable() == true) goto L7;
        this.n.setClickable(true);
        goto L7
    }

    public int getCurScrollY() {
        return this.x;
    }

    public xx3.b getHelper() {
        return this.L;
    }

    public int getMaxY() {
        return this.v;
    }

    public int getMinY() {
        return this.u;
    }

    public int getTabsMarginTop() {
        return this.w;
    }

    public DampScrollableLayout(Context r2) {
        this(r2, null);
    }

    public final void d(d r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (((ArrayList) this.J).contains(r2) == true) goto L8;
        ((ArrayList) this.J).add(r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r20) {
        if (this.B == false) goto L6;
        return true;
    L6:
        if (this.F == false) goto L132;
        this.d = r20.getY();
        return true;
    L132:
    L129:
        e = move-exception;
        e.printStackTrace();
    L131:
        return true;
    L10:
        if (r20.getActionIndex() == 0) goto L12;
        return true;
    L12:
        float r2 = r20.getX();     // Catch: IllegalArgumentException -> L129
        float r4 = r20.getY();     // Catch: IllegalArgumentException -> L129
        int r5 = (int) Math.abs(r2 - this.b);     // Catch: IllegalArgumentException -> L129
        int r6 = (int) Math.abs(r4 - this.c);     // Catch: IllegalArgumentException -> L129
        int r7 = r20.getAction() & 255;     // Catch: IllegalArgumentException -> L129
        boolean r8 = false;
        if (r7 != 0) goto L15;
    L119:
        this.i = r20.getRawX();     // Catch: IllegalArgumentException -> L129
        this.j = r20.getRawY();     // Catch: IllegalArgumentException -> L129
        this.r = true;     // Catch: IllegalArgumentException -> L129
        this.s = true;     // Catch: IllegalArgumentException -> L129
        this.b = r2;     // Catch: IllegalArgumentException -> L129
        this.c = r4;     // Catch: IllegalArgumentException -> L129
        this.d = r4;     // Catch: IllegalArgumentException -> L129
        getScrollY();     // Catch: IllegalArgumentException -> L129
        int r3 = (int) r4;     // Catch: IllegalArgumentException -> L129
        if ((r3 + getScrollY()) > this.q) goto L122;
        r8 = true;
    L122:
        this.y = r8;     // Catch: IllegalArgumentException -> L129
        VelocityTracker r9 = this.e;     // Catch: IllegalArgumentException -> L129
        if (r9 != null) goto L125;
        this.e = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L129
    L126:
        this.e.addMovement(r20);     // Catch: IllegalArgumentException -> L129
        this.a.forceFinished(true);     // Catch: IllegalArgumentException -> L129
    L127:
        super.dispatchTouchEvent(r20);     // Catch: IllegalArgumentException -> L129
        goto L131
    L125:
        r9.clear();     // Catch: IllegalArgumentException -> L129
        goto L126
    L15:
        if (r7 != 1) goto L17;
    L62:
        d r10 = this.K;     // Catch: IllegalArgumentException -> L129
        if (r10 == null) goto L65;
        boolean r11 = r10.c();     // Catch: IllegalArgumentException -> L129
    L66:
        if (r11 == true) goto L72;
        Iterator r12 = ((ArrayList) this.J).iterator();     // Catch: IllegalArgumentException -> L129
    L69:
        if (r12.hasNext() == false) goto L72;
        r11 = ((d) r12.next()).c();     // Catch: IllegalArgumentException -> L129
        if (r11 == false) goto L69;
    L72:
        if (r11 == true) goto L127;
        if (getScrollY() >= 0) goto L79;
        this.p = DIRECTION.UP;     // Catch: IllegalArgumentException -> L129
        this.a.startScroll(0, getScrollY(), 0, -getScrollY(), -getScrollY());     // Catch: IllegalArgumentException -> L129
        getScrollY();     // Catch: IllegalArgumentException -> L129
        this.a.computeScrollOffset();     // Catch: IllegalArgumentException -> L129
        this.t = getScrollY();     // Catch: IllegalArgumentException -> L129
        invalidate();     // Catch: IllegalArgumentException -> L129
        if (r7 == 3) goto L127;
        return true;
    L79:
        int r13 = this.x;     // Catch: IllegalArgumentException -> L129
        if (r13 <= this.v) goto L85;
        if (this.D != 0) goto L85;
        scrollBy(0, (int) (r4 - this.d));     // Catch: IllegalArgumentException -> L129
    L85:
        if (this.s == false) goto L127;
        if (r6 > r5) goto L89;
        if (r13 >= 0) goto L127;
    L89:
        if (r6 <= this.f) goto L127;
        this.e.computeCurrentVelocity(ECDraweeView.SQUARE, this.h);     // Catch: IllegalArgumentException -> L129
        float r14 = -this.e.getYVelocity();
        if (this.D != 0) goto L112;
        if (Math.abs(r14) <= this.g) goto L112;
        if (r14 <= 0.0f) goto L97;
        DIRECTION r15 = DIRECTION.UP;     // Catch: IllegalArgumentException -> L129
    L98:
        this.p = r15;     // Catch: IllegalArgumentException -> L129
        if (r15 != DIRECTION.UP) goto L106;
        if (this.x < this.v) goto L103;
        boolean r16 = true;
    L104:
        if (r16 == false) goto L106;
    L107:
        boolean r17 = true;
    L109:
        if (r17 == true) goto L112;
        this.a.fling(0, getScrollY(), 0, (int) r14, 0, 0, -2147483647, Integer.MAX_VALUE);     // Catch: IllegalArgumentException -> L129
        this.t = getScrollY();     // Catch: IllegalArgumentException -> L129
        invalidate();     // Catch: IllegalArgumentException -> L129
        goto L112
    L103:
        r16 = false;
    L106:
        if (this.G == true) goto L107;
        r17 = false;
        goto L109
    L97:
        r15 = DIRECTION.DOWN;     // Catch: IllegalArgumentException -> L129
    L112:
        if (this.y == false) goto L114;
    L117:
        int r18 = r20.getAction();     // Catch: IllegalArgumentException -> L129
        r20.setAction(3);     // Catch: IllegalArgumentException -> L129
        boolean r19 = super.dispatchTouchEvent(r20);     // Catch: IllegalArgumentException -> L129
        r20.setAction(r18);     // Catch: IllegalArgumentException -> L129
        return r19;
    L114:
        if (this.x < this.v) goto L116;
        r8 = true;
    L116:
        if (r8 == true) goto L127;
    L65:
        r11 = false;
        goto L66
    L17:
        if (r7 == 2) goto L25;
        if (r7 == 3) goto L62;
        if (r7 == 5) goto L119;
        if (r7 == 6) goto L62;
    L25:
        if (this.e != null) goto L27;
        this.e = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L129
    L27:
        this.e.addMovement(r20);     // Catch: IllegalArgumentException -> L129
        float r21 = this.d - r4;     // Catch: IllegalArgumentException -> L129
        d r22 = this.K;     // Catch: IllegalArgumentException -> L129
        if (r22 == null) goto L30;
        r22.d();     // Catch: IllegalArgumentException -> L129
    L30:
        Iterator r23 = ((ArrayList) this.J).iterator();     // Catch: IllegalArgumentException -> L129
    L32:
        if (r23.hasNext() == false) goto L35;
        ((d) r23.next()).d();     // Catch: IllegalArgumentException -> L129
        goto L32
    L35:
        if (this.r == true) goto L37;
    L41:
        this.L.a();     // Catch: IllegalArgumentException -> L129
        if (this.G == false) goto L44;
    L59:
        this.d = r4;     // Catch: IllegalArgumentException -> L129
        this.k = r20.getRawX();     // Catch: IllegalArgumentException -> L129
        float r24 = r20.getRawY();     // Catch: IllegalArgumentException -> L129
        this.l = (int) (this.k - this.i);     // Catch: IllegalArgumentException -> L129
        float r25 = (int) (r24 - this.j);     // Catch: IllegalArgumentException -> L129
        this.m = r25;     // Catch: IllegalArgumentException -> L129
        if (Math.abs(r25) <= this.z) goto L127;
        Math.abs(this.m);     // Catch: IllegalArgumentException -> L129
        Math.abs(this.l);     // Catch: IllegalArgumentException -> L129
        goto L127
    L44:
        if (a(r20, r5, r6) == true) goto L59;
        if (r6 <= this.f) goto L59;
        if (this.x < this.v) goto L50;
        r8 = true;
    L50:
        if (r8 == true) goto L52;
    L53:
        DmtViewPager r26 = this.o;     // Catch: IllegalArgumentException -> L129
        if (r26 == null) goto L57;
        r26.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L129
    L57:
        if (this.D != 0) goto L59;
        scrollBy(r5, (int) (((double) r21) + 0.5d));     // Catch: IllegalArgumentException -> L129
        goto L59
    L52:
        if (this.L.a() == false) goto L59;
    L37:
        if (r5 <= this.f) goto L40;
        if (r5 <= r6) goto L40;
        this.r = false;     // Catch: IllegalArgumentException -> L129
        this.s = false;     // Catch: IllegalArgumentException -> L129
    L40:
        this.r = false;     // Catch: IllegalArgumentException -> L129
        this.s = true;     // Catch: IllegalArgumentException -> L129
        goto L41
    }

    public final void e(d r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (((ArrayList) this.J).contains(r2) == false) goto L8;
        ((ArrayList) this.J).remove(r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
    }

    public void setCanScroll(boolean r1) {
        this.B = !r1;
    }

    public void setCanScrollUp(boolean r3) {
        if (r3 == false) goto L5;
        this.v = this.q - this.w;
    L5:
        if (this.A == false) goto L7;
    L9:
        this.I = r3;
        if (r3 == true) goto L12;
        this.v = 0;
    L12:
        this.A = false;
        return;
    L7:
        if (this.I != r3) goto L9;
    }

    public void setChildViewPager(DmtViewPager r2) {
        this.o = r2;
        r2.b(this.H);
    }

    public void setMaxScrollHeight(int r3) {
        int r4 = Math.min(r3, this.q - this.w);
        this.v = r4;
        this.v = Math.max(r4, 0);
    }

    public void setMinY(int r1) {
        this.u = r1;
    }

    public void setOnScrollListener(d r1) {
        this.K = r1;
    }

    public void setPinOnSticked(boolean r1) {
        this.G = r1;
    }

    public void setScrollMinY(int r1) {
        this.z = r1;
    }

    public void setTabsMarginTop(int r1) {
        this.w = r1;
        this.A = true;
    }

    public void setVerticalAnimationStatus(boolean r1) {
        this.F = r1;
    }

    public DampScrollableLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void b(int r3, int r4) {
        this.x = r4;
        d r0 = this.K;
        if (r0 == null) goto L5;
        r0.e(r4);
    L5:
        Iterator r1 = ((ArrayList) this.J).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((d) r1.next()).e(r4);
        goto L7
    L9:
        if (r4 != 0) goto L11;
    L12:
        this.B = false;
    L13:
        super.scrollTo(r3, r4);
        return;
    L11:
        if (r4 > this.v) goto L13;
        goto L12
    }

    public final void c(int r3, int r4) {
        if (r3 != r4) goto L4;
        return;
    L4:
        this.B = true;
        this.C.cancel();
        this.C.removeAllUpdateListeners();
        this.C.addUpdateListener(new c(this, r4, r3));
        this.C.setDuration((Math.abs(r3 - r4) * ECDraweeView.SQUARE) / N);
        this.C.start();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r9) {
        View r2 = getChildAt(0);
        this.n = r2;
        if (r2 == null) goto L5;
        measureChildWithMargins(r2, r8, 0, 0, 0);
        this.q = this.n.getMeasuredHeight();
    L5:
        super.onMeasure(r8, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r9) + (this.q - this.w), 1073741824));
        if (this.M == true) goto L8;
        this.v = this.q - this.w;
        this.M = true;
    L8:
        this.B = false;
    }

    @Override // android.view.View
    public final void scrollBy(int r5, int r6) {
        if (this.x <= this.v) goto L32;
        if (r6 < 0) goto L6;
    L31:
        int r7 = 0;
    L44:
        if (r7 == 0) goto L47;
        super.scrollBy(0, r7);
        return;
    L47:
        return;
    L6:
        if (Math.abs(r5) >= this.f) goto L31;
        int r8 = this.x;
        int r9 = this.v;
        if (r8 >= r9) goto L10;
        b(0, 0);
        goto L31
    L10:
        xx3.b r0 = this.L;
        if (r0 == null) goto L26;
        xx3.b.a r1 = r0.a;
        if (r1 != null) goto L16;
        AdapterView r2 = null;
    L17:
        if (r2 != null) goto L20;
    L27:
        boolean r3 = false;
    L28:
        if (r3 == false) goto L30;
        c(r8, 0);
        goto L31
    L30:
        c(r8, r9);
        goto L31
    L20:
        if ((r2 instanceof AdapterView) == false) goto L25;
        if (r2.getChildCount() != 0) goto L27;
    L25:
        if (r2.getChildCount() != 0) goto L27;
    L16:
        r2 = r1.tA();
    L26:
        r3 = true;
        goto L28
    L32:
        int r10 = getScrollY();
        if (r6 >= 0) goto L37;
        int r4 = r10 + r6;
        if (r4 >= 0) goto L37;
        r6 = (int) ((r6 * 1.2f) * (1.0f - ((1.0f / this.u) * r4)));
    L37:
        int r11 = r6 + r10;
        int r12 = this.v;
        if (r11 < r12) goto L40;
    L39:
        r11 = r12;
    L43:
        r7 = r11 - r10;
        goto L44
    L40:
        r12 = this.u;
        if (r11 > r12) goto L43;
        goto L43
    }

    @Override // android.view.View
    public final void scrollTo(int r2, int r3) {
        int r0 = this.v;
        if (r3 < r0) goto L5;
    L4:
        r3 = r0;
    L8:
        b(r2, r3);
        return;
    L5:
        r0 = this.u;
        if (r3 > r0) goto L8;
        goto L8
    }

    public DampScrollableLayout(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.z = 10;
        this.A = false;
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{0, 1});
        this.C = r1;
        this.E = new ArrayList();
        this.F = false;
        this.G = false;
        this.H = new a(this);
        this.I = true;
        this.J = new ArrayList();
        this.M = false;
        this.L = new xx3.b();
        this.a = new Scroller(r5);
        ViewConfiguration r8 = ViewConfiguration.get(r5);
        this.f = r8.getScaledTouchSlop();
        this.g = r8.getScaledMinimumFlingVelocity();
        this.h = r8.getScaledMaximumFlingVelocity();
        setOrientation(1);
        TypedArray r9 = r5.obtainStyledAttributes(r6, new int[]{2130973938, 2130973939, 2130973940, 2130973941, 2130973942, 2130973943, 2130973944, 2130973945, 2130973946, 2130973947, 2130974462});
        this.w = (int) r9.getDimension(10, 0.0f);
        r9.recycle();
        r1.setInterpolator(new AccelerateDecelerateInterpolator());
        r1.addListener(new b(this));
    }

    public final boolean a(MotionEvent r9, int r10, int r11) {
        if (((ArrayList) this.E).isEmpty() == true) goto L29;
        int r0 = (int) r9.getRawX();
        int r12 = (int) r9.getRawY();
        Iterator r2 = ((ArrayList) this.E).iterator();
    L6:
        if (r2.hasNext() == false) goto L19;
        View r3 = (View) r2.next();
        if (r3 == null) goto L16;
        int[] r5 = new int[2];
        r3.getLocationOnScreen(r5);
        int r6 = r5[0];
        int r7 = r5[1];
        int r8 = r3.getMeasuredWidth() + r6;
        int r4 = r3.getMeasuredHeight() + r7;
        if (r12 < r7) goto L16;
        if (r12 > r4) goto L16;
        if (r0 < r6) goto L16;
        if (r0 > r8) goto L16;
        boolean r13 = true;
    L17:
        if (r13 == false) goto L6;
        boolean r14 = true;
    L20:
        if (r14 == false) goto L30;
        if (r11 >= r10) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L16:
        r13 = false;
        goto L17
    L19:
        r14 = false;
        goto L20
    L29:
        return false;
    }
}
