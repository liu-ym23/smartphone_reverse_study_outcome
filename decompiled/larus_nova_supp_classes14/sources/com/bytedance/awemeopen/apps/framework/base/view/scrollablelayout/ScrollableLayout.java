package com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import xx3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ScrollableLayout extends LinearLayout {
    public int A;
    public boolean B;
    public final b C;
    public boolean D;
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
    public ViewPager o;
    public DIRECTION p;
    public int q;
    public final int r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public boolean z;

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

    public interface a {
    }

    public void setOnScrollListener(a r1) {
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.a.computeScrollOffset() == false) goto L30;
        int r0 = this.a.getCurrY();
        int r3 = 0;
        if (this.p != DIRECTION.UP) goto L22;
        if (this.y < this.w) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L20;
        int r2 = this.a.getFinalY() - r0;
        int r4 = this.a.getDuration() - this.a.timePassed();
        b r5 = this.C;
        Scroller r6 = this.a;
        if (r6 != null) goto L15;
    L18:
        r5.b(r3, r2, r4);
        this.a.forceFinished(true);
        return;
    L15:
        if (this.r < 14) goto L17;
        r3 = (int) r6.getCurrVelocity();
        goto L18
    L17:
        r3 = r2 / r4;
        goto L18
    L20:
        scrollTo(0, r0);
    L28:
        this.u = r0;
        return;
    L9:
        r1 = false;
        goto L10
    L22:
        if (this.C.a() == false) goto L27;
        int r7 = r0 - this.u;
        scrollTo(0, getScrollY() + r7);
        if (this.y > this.v) goto L27;
        this.a.forceFinished(true);
        return;
    L27:
        invalidate();
        goto L28
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
        ViewPager r3 = getChildAt(r2);
        if (r3 == null) goto L14;
        if ((r3 instanceof ViewPager) == false) goto L14;
        this.o = r3;
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
        return this.y;
    }

    public b getHelper() {
        return this.C;
    }

    public int getMaxY() {
        return this.w;
    }

    public int getMinY() {
        return this.v;
    }

    public int getTabsMarginTop() {
        return this.x;
    }

    public ScrollableLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r19) {
        float r3 = r19.getX();     // Catch: IllegalArgumentException -> L89
        float r4 = r19.getY();     // Catch: IllegalArgumentException -> L89
        int r5 = (int) Math.abs(r3 - this.b);     // Catch: IllegalArgumentException -> L89
        int r6 = (int) Math.abs(r4 - this.c);     // Catch: IllegalArgumentException -> L89
        int r7 = r19.getAction();     // Catch: IllegalArgumentException -> L89
        boolean r8 = false;
        if (r7 != 0) goto L6;
        this.i = r19.getRawX();     // Catch: IllegalArgumentException -> L89
        this.j = r19.getRawY();     // Catch: IllegalArgumentException -> L89
        this.s = true;     // Catch: IllegalArgumentException -> L89
        this.t = true;     // Catch: IllegalArgumentException -> L89
        this.b = r3;     // Catch: IllegalArgumentException -> L89
        this.c = r4;     // Catch: IllegalArgumentException -> L89
        this.d = r4;     // Catch: IllegalArgumentException -> L89
        getScrollY();     // Catch: IllegalArgumentException -> L89
        int r9 = (int) r4;     // Catch: IllegalArgumentException -> L89
        if ((r9 + getScrollY()) > this.q) goto L82;
        r8 = true;
    L82:
        this.z = r8;     // Catch: IllegalArgumentException -> L89
        VelocityTracker r10 = this.e;     // Catch: IllegalArgumentException -> L89
        if (r10 != null) goto L85;
        this.e = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L89
    L86:
        this.e.addMovement(r19);     // Catch: IllegalArgumentException -> L89
        this.a.forceFinished(true);     // Catch: IllegalArgumentException -> L89
    L87:
        super.dispatchTouchEvent(r19);     // Catch: IllegalArgumentException -> L89
    L91:
        return true;
    L85:
        r10.clear();     // Catch: IllegalArgumentException -> L89
        goto L86
    L6:
        if (r7 == 1) goto L52;
        if (r7 == 2) goto L21;
        if (r7 != 3) goto L87;
        if (this.t == false) goto L87;
        if (this.z == false) goto L87;
        int r11 = this.f;     // Catch: IllegalArgumentException -> L89
        if (r5 > r11) goto L18;
        if (r6 <= r11) goto L87;
    L18:
        int r12 = r19.getAction();     // Catch: IllegalArgumentException -> L89
        r19.setAction(3);     // Catch: IllegalArgumentException -> L89
        boolean r13 = super.dispatchTouchEvent(r19);     // Catch: IllegalArgumentException -> L89
        r19.setAction(r12);     // Catch: IllegalArgumentException -> L89
        return r13;
    L21:
        if (this.e != null) goto L23;
        this.e = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L89
    L23:
        this.e.addMovement(r19);     // Catch: IllegalArgumentException -> L89
        float r14 = this.d - r4;     // Catch: IllegalArgumentException -> L89
        if (this.s == false) goto L33;
        int r15 = this.f;     // Catch: IllegalArgumentException -> L89
        if (r5 <= r15) goto L29;
        if (r5 <= r6) goto L29;
        this.s = false;     // Catch: IllegalArgumentException -> L89
        this.t = false;     // Catch: IllegalArgumentException -> L89
    L29:
        if (r6 <= r15) goto L33;
        if (r6 <= r5) goto L33;
        this.s = false;     // Catch: IllegalArgumentException -> L89
        this.t = true;     // Catch: IllegalArgumentException -> L89
    L33:
        if (this.t == true) goto L35;
    L48:
        this.d = r4;     // Catch: IllegalArgumentException -> L89
        this.k = r19.getRawX();     // Catch: IllegalArgumentException -> L89
        float r16 = r19.getRawY();     // Catch: IllegalArgumentException -> L89
        this.l = (int) (this.k - this.i);     // Catch: IllegalArgumentException -> L89
        float r17 = (int) (r16 - this.j);     // Catch: IllegalArgumentException -> L89
        this.m = r17;     // Catch: IllegalArgumentException -> L89
        if (Math.abs(r17) <= this.A) goto L87;
        Math.abs(this.m);     // Catch: IllegalArgumentException -> L89
        Math.abs(this.l);     // Catch: IllegalArgumentException -> L89
        goto L87
    L35:
        if (r6 <= this.f) goto L48;
        if (r6 <= r5) goto L48;
        if (this.y < this.w) goto L40;
        boolean r18 = true;
    L41:
        if (r18 == true) goto L43;
    L44:
        ViewPager r20 = this.o;     // Catch: IllegalArgumentException -> L89
        if (r20 == null) goto L47;
        r20.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L89
    L47:
        scrollBy(0, (int) (r14 + 0.5f));     // Catch: IllegalArgumentException -> L89
        goto L48
    L43:
        if (this.C.a() == false) goto L48;
    L40:
        r18 = false;
        goto L41
    L52:
        if (this.t == false) goto L87;
        if (r6 <= r5) goto L87;
        if (r6 <= this.f) goto L87;
        this.e.computeCurrentVelocity(ECDraweeView.SQUARE, this.h);     // Catch: IllegalArgumentException -> L89
        float r21 = -this.e.getYVelocity();
        if (Math.abs(r21) <= this.g) goto L72;
        if (r21 <= 0.0f) goto L61;
        DIRECTION r22 = DIRECTION.UP;     // Catch: IllegalArgumentException -> L89
    L62:
        this.p = r22;     // Catch: IllegalArgumentException -> L89
        if (r22 == DIRECTION.UP) goto L65;
    L70:
        this.a.fling(0, getScrollY(), 0, (int) r21, 0, 0, -2147483647, Integer.MAX_VALUE);     // Catch: IllegalArgumentException -> L89
        this.a.computeScrollOffset();     // Catch: IllegalArgumentException -> L89
        this.u = getScrollY();     // Catch: IllegalArgumentException -> L89
        invalidate();     // Catch: IllegalArgumentException -> L89
        goto L72
    L65:
        if (this.y < this.w) goto L67;
        boolean r23 = true;
    L68:
        if (r23 == false) goto L70;
    L67:
        r23 = false;
        goto L68
    L61:
        r22 = DIRECTION.DOWN;     // Catch: IllegalArgumentException -> L89
    L72:
        if (this.z == false) goto L74;
    L77:
        int r24 = r19.getAction();     // Catch: IllegalArgumentException -> L89
        r19.setAction(3);     // Catch: IllegalArgumentException -> L89
        boolean r25 = super.dispatchTouchEvent(r19);     // Catch: IllegalArgumentException -> L89
        r19.setAction(r24);     // Catch: IllegalArgumentException -> L89
        return r25;
    L74:
        if (this.y < this.w) goto L76;
        r8 = true;
    L76:
        if (r8 == true) goto L87;
    L89:
        e = move-exception;
        e.printStackTrace();
        goto L91
    }

    public void setCanScrollUp(boolean r2) {
        if (this.B != r2) goto L5;
        return;
    L5:
        this.B = r2;
        if (r2 == false) goto L9;
        this.w = this.q - this.x;
        return;
    L9:
        if (this.y == 0) goto L11;
        scrollTo(0, 0);
    L11:
        this.w = 0;
    }

    public void setMaxScrollHeight(int r3) {
        int r4 = Math.min(r3, this.q - this.x);
        this.w = r4;
        this.w = Math.max(r4, 0);
    }

    public void setMinY(int r1) {
        this.v = r1;
    }

    public void setScrollMinY(int r1) {
        this.A = r1;
    }

    public void setTabsMarginTop(int r1) {
        this.x = r1;
    }

    public ScrollableLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r9) {
        View r2 = getChildAt(0);
        this.n = r2;
        if (r2 == null) goto L5;
        measureChildWithMargins(r2, r8, 0, 0, 0);
        this.q = this.n.getMeasuredHeight();
    L5:
        super.onMeasure(r8, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r9) + (this.q - this.x), 1073741824));
        if (this.D == true) goto L9;
        this.w = this.q - this.x;
        this.D = true;
    L9:
        if (this.B == true) goto L12;
        this.w = 0;
        return;
    }

    @Override // android.view.View
    public final void scrollBy(int r3, int r4) {
        int r0 = getScrollY();
        if ((r0 + r4) >= 0) goto L5;
        r4 = r4 / 3;
    L5:
        int r5 = r4 + r0;
        int r1 = this.w;
        if (r5 < r1) goto L8;
    L7:
        r5 = r1;
    L11:
        super.scrollBy(r3, r5 - r0);
        return;
    L8:
        r1 = this.v;
        if (r5 > r1) goto L11;
        goto L11
    }

    @Override // android.view.View
    public final void scrollTo(int r2, int r3) {
        int r0 = this.w;
        if (r3 < r0) goto L5;
    L4:
        r3 = r0;
    L8:
        this.y = r3;
        super.scrollTo(r2, r3);
        return;
    L5:
        r0 = this.v;
        if (r3 > r0) goto L8;
        goto L8
    }

    public ScrollableLayout(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.A = 10;
        this.B = true;
        this.D = false;
        this.C = new b();
        this.a = new Scroller(r4);
        ViewConfiguration r7 = ViewConfiguration.get(r4);
        this.f = r7.getScaledTouchSlop();
        this.g = r7.getScaledMinimumFlingVelocity();
        this.h = r7.getScaledMaximumFlingVelocity();
        this.r = Build.VERSION.SDK_INT;
        setOrientation(1);
        TypedArray r8 = r4.obtainStyledAttributes(r5, new int[]{2130973938, 2130973939, 2130973940, 2130973941, 2130973942, 2130973943, 2130973944, 2130973945, 2130973946, 2130973947, 2130974462});
        this.x = (int) r8.getDimension(10, 0.0f);
        r8.recycle();
    }
}
