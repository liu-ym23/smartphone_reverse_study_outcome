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
import com.larus.nova.R;
import xx3.b;

/* JADX INFO: loaded from: classes14.dex */
public class ScrollableLayout extends LinearLayout {
    public int A;
    public boolean B;
    public final b C;
    public boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scroller f193562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f193563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f193564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f193565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VelocityTracker f193566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f193567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f193568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f193569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f193570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f193571j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f193572k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f193573l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f193574m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f193575n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewPager f193576o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DIRECTION f193577p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f193578q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f193579r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f193580s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f193581t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f193582u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f193583v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f193584w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f193585x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f193586y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f193587z;

    public static final enum DIRECTION extends Enum<DIRECTION> {
        public static final DIRECTION DOWN = null;
        public static final DIRECTION UP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DIRECTION[] f193588a = null;

        static {
            DIRECTION r100 = new DIRECTION("UP", 0);
            UP = r100;
            DIRECTION r101 = new DIRECTION("DOWN", 1);
            DOWN = r101;
            f193588a = new DIRECTION[]{r100, r101};
        }

        public static DIRECTION[] values() {
            return (DIRECTION[]) f193588a.clone();
        }

        public static DIRECTION valueOf(String r100) {
            return (DIRECTION) r27.a.a(DIRECTION.class, r100);
        }

        public DIRECTION(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
    }

    public void setOnScrollListener(a r100) {
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f193562a.computeScrollOffset() == false) goto L30;
        int r100 = this.f193562a.getCurrY();
        int r101 = 0;
        if (this.f193577p != DIRECTION.UP) goto L22;
        if (this.f193586y < this.f193584w) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L20;
        int r103 = this.f193562a.getFinalY() - r100;
        int r104 = this.f193562a.getDuration() - this.f193562a.timePassed();
        b r105 = this.C;
        Scroller r106 = this.f193562a;
        if (r106 != null) goto L15;
    L18:
        r105.b(r101, r103, r104);
        this.f193562a.forceFinished(true);
        return;
    L15:
        if (this.f193579r < 14) goto L17;
        r101 = (int) r106.getCurrVelocity();
        goto L18
    L17:
        r101 = r103 / r104;
        goto L18
    L20:
        scrollTo(0, r100);
    L28:
        this.f193582u = r100;
        return;
    L9:
        r102 = false;
        goto L10
    L22:
        if (this.C.a() == false) goto L27;
        int r107 = r100 - this.f193582u;
        scrollTo(0, getScrollY() + r107);
        if (this.f193586y > this.f193583v) goto L27;
        this.f193562a.forceFinished(true);
        return;
    L27:
        invalidate();
        goto L28
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        View r100 = this.f193575n;
        if (r100 != null) goto L5;
    L7:
        int r101 = getChildCount();
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L15;
        View r103 = getChildAt(r102);
        if (r103 == null) goto L14;
        if ((r103 instanceof ViewPager) == false) goto L14;
        this.f193576o = (ViewPager) r103;
    L14:
        r102 = r102 + 1;
        goto L8
    L15:
        super.onFinishInflate();
        return;
    L5:
        if (r100.isClickable() == true) goto L7;
        this.f193575n.setClickable(true);
        goto L7
    }

    public int getCurScrollY() {
        return this.f193586y;
    }

    public b getHelper() {
        return this.C;
    }

    public int getMaxY() {
        return this.f193584w;
    }

    public int getMinY() {
        return this.f193583v;
    }

    public int getTabsMarginTop() {
        return this.f193585x;
    }

    public ScrollableLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        float r100 = r110.getX();     // Catch: IllegalArgumentException -> L89
        float r101 = r110.getY();     // Catch: IllegalArgumentException -> L89
        int r102 = (int) Math.abs(r100 - this.f193563b);     // Catch: IllegalArgumentException -> L89
        int r103 = (int) Math.abs(r101 - this.f193564c);     // Catch: IllegalArgumentException -> L89
        int r104 = r110.getAction();     // Catch: IllegalArgumentException -> L89
        boolean r105 = false;
        if (r104 != 0) goto L6;
        this.f193570i = r110.getRawX();     // Catch: IllegalArgumentException -> L89
        this.f193571j = r110.getRawY();     // Catch: IllegalArgumentException -> L89
        this.f193580s = true;     // Catch: IllegalArgumentException -> L89
        this.f193581t = true;     // Catch: IllegalArgumentException -> L89
        this.f193563b = r100;     // Catch: IllegalArgumentException -> L89
        this.f193564c = r101;     // Catch: IllegalArgumentException -> L89
        this.f193565d = r101;     // Catch: IllegalArgumentException -> L89
        getScrollY();     // Catch: IllegalArgumentException -> L89
        int r106 = (int) r101;     // Catch: IllegalArgumentException -> L89
        if ((r106 + getScrollY()) > this.f193578q) goto L82;
        r105 = true;
    L82:
        this.f193587z = r105;     // Catch: IllegalArgumentException -> L89
        VelocityTracker r107 = this.f193566e;     // Catch: IllegalArgumentException -> L89
        if (r107 != null) goto L85;
        this.f193566e = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L89
    L86:
        this.f193566e.addMovement(r110);     // Catch: IllegalArgumentException -> L89
        this.f193562a.forceFinished(true);     // Catch: IllegalArgumentException -> L89
    L87:
        super.dispatchTouchEvent(r110);     // Catch: IllegalArgumentException -> L89
    L91:
        return true;
    L85:
        r107.clear();     // Catch: IllegalArgumentException -> L89
        goto L86
    L6:
        if (r104 == 1) goto L52;
        if (r104 == 2) goto L21;
        if (r104 != 3) goto L87;
        if (this.f193581t == false) goto L87;
        if (this.f193587z == false) goto L87;
        int r108 = this.f193567f;     // Catch: IllegalArgumentException -> L89
        if (r102 > r108) goto L18;
        if (r103 <= r108) goto L87;
    L18:
        int r109 = r110.getAction();     // Catch: IllegalArgumentException -> L89
        r110.setAction(3);     // Catch: IllegalArgumentException -> L89
        boolean r111 = super.dispatchTouchEvent(r110);     // Catch: IllegalArgumentException -> L89
        r110.setAction(r109);     // Catch: IllegalArgumentException -> L89
        return r111;
    L21:
        if (this.f193566e != null) goto L23;
        this.f193566e = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L89
    L23:
        this.f193566e.addMovement(r110);     // Catch: IllegalArgumentException -> L89
        float r112 = this.f193565d - r101;     // Catch: IllegalArgumentException -> L89
        if (this.f193580s == false) goto L33;
        int r113 = this.f193567f;     // Catch: IllegalArgumentException -> L89
        if (r102 <= r113) goto L29;
        if (r102 <= r103) goto L29;
        this.f193580s = false;     // Catch: IllegalArgumentException -> L89
        this.f193581t = false;     // Catch: IllegalArgumentException -> L89
    L29:
        if (r103 <= r113) goto L33;
        if (r103 <= r102) goto L33;
        this.f193580s = false;     // Catch: IllegalArgumentException -> L89
        this.f193581t = true;     // Catch: IllegalArgumentException -> L89
    L33:
        if (this.f193581t == true) goto L35;
    L48:
        this.f193565d = r101;     // Catch: IllegalArgumentException -> L89
        this.f193572k = r110.getRawX();     // Catch: IllegalArgumentException -> L89
        float r114 = r110.getRawY();     // Catch: IllegalArgumentException -> L89
        this.f193573l = (int) (this.f193572k - this.f193570i);     // Catch: IllegalArgumentException -> L89
        float r115 = (int) (r114 - this.f193571j);     // Catch: IllegalArgumentException -> L89
        this.f193574m = r115;     // Catch: IllegalArgumentException -> L89
        if (Math.abs(r115) <= this.A) goto L87;
        Math.abs(this.f193574m);     // Catch: IllegalArgumentException -> L89
        Math.abs(this.f193573l);     // Catch: IllegalArgumentException -> L89
        goto L87
    L35:
        if (r103 <= this.f193567f) goto L48;
        if (r103 <= r102) goto L48;
        if (this.f193586y < this.f193584w) goto L40;
        boolean r116 = true;
    L41:
        if (r116 == true) goto L43;
    L44:
        ViewPager r117 = this.f193576o;     // Catch: IllegalArgumentException -> L89
        if (r117 == null) goto L47;
        r117.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L89
    L47:
        scrollBy(0, (int) (r112 + 0.5f));     // Catch: IllegalArgumentException -> L89
        goto L48
    L43:
        if (this.C.a() == false) goto L48;
    L40:
        r116 = false;
        goto L41
    L52:
        if (this.f193581t == false) goto L87;
        if (r103 <= r102) goto L87;
        if (r103 <= this.f193567f) goto L87;
        this.f193566e.computeCurrentVelocity(1000, this.f193569h);     // Catch: IllegalArgumentException -> L89
        float r118 = -this.f193566e.getYVelocity();
        if (Math.abs(r118) <= this.f193568g) goto L72;
        if (r118 <= 0.0f) goto L61;
        DIRECTION r119 = DIRECTION.UP;     // Catch: IllegalArgumentException -> L89
    L62:
        this.f193577p = r119;     // Catch: IllegalArgumentException -> L89
        if (r119 == DIRECTION.UP) goto L65;
    L70:
        this.f193562a.fling(0, getScrollY(), 0, (int) r118, 0, 0, -2147483647, Integer.MAX_VALUE);     // Catch: IllegalArgumentException -> L89
        this.f193562a.computeScrollOffset();     // Catch: IllegalArgumentException -> L89
        this.f193582u = getScrollY();     // Catch: IllegalArgumentException -> L89
        invalidate();     // Catch: IllegalArgumentException -> L89
        goto L72
    L65:
        if (this.f193586y < this.f193584w) goto L67;
        boolean r120 = true;
    L68:
        if (r120 == false) goto L70;
    L67:
        r120 = false;
        goto L68
    L61:
        r119 = DIRECTION.DOWN;     // Catch: IllegalArgumentException -> L89
    L72:
        if (this.f193587z == false) goto L74;
    L77:
        int r121 = r110.getAction();     // Catch: IllegalArgumentException -> L89
        r110.setAction(3);     // Catch: IllegalArgumentException -> L89
        boolean r122 = super.dispatchTouchEvent(r110);     // Catch: IllegalArgumentException -> L89
        r110.setAction(r121);     // Catch: IllegalArgumentException -> L89
        return r122;
    L74:
        if (this.f193586y < this.f193584w) goto L76;
        r105 = true;
    L76:
        if (r105 == true) goto L87;
    L89:
        e = move-exception;
        e.printStackTrace();
        goto L91
    }

    public void setCanScrollUp(boolean r100) {
        if (this.B != r100) goto L5;
        return;
    L5:
        this.B = r100;
        if (r100 == false) goto L9;
        this.f193584w = this.f193578q - this.f193585x;
        return;
    L9:
        if (this.f193586y == 0) goto L11;
        scrollTo(0, 0);
    L11:
        this.f193584w = 0;
    }

    public void setMaxScrollHeight(int r100) {
        int r101 = Math.min(r100, this.f193578q - this.f193585x);
        this.f193584w = r101;
        this.f193584w = Math.max(r101, 0);
    }

    public void setMinY(int r100) {
        this.f193583v = r100;
    }

    public void setScrollMinY(int r100) {
        this.A = r100;
    }

    public void setTabsMarginTop(int r100) {
        this.f193585x = r100;
    }

    public ScrollableLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        View r102 = getChildAt(0);
        this.f193575n = r102;
        if (r102 == null) goto L5;
        measureChildWithMargins(r102, r100, 0, 0, 0);
        this.f193578q = this.f193575n.getMeasuredHeight();
    L5:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r101) + (this.f193578q - this.f193585x), 1073741824));
        if (this.D == true) goto L9;
        this.f193584w = this.f193578q - this.f193585x;
        this.D = true;
    L9:
        if (this.B == true) goto L12;
        this.f193584w = 0;
        return;
    }

    @Override // android.view.View
    public final void scrollBy(int r100, int r101) {
        int r102 = getScrollY();
        if ((r102 + r101) >= 0) goto L5;
        r101 = r101 / 3;
    L5:
        int r103 = r101 + r102;
        int r104 = this.f193584w;
        if (r103 < r104) goto L8;
    L7:
        r103 = r104;
    L11:
        super.scrollBy(r100, r103 - r102);
        return;
    L8:
        r104 = this.f193583v;
        if (r103 > r104) goto L11;
        goto L11
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        int r102 = this.f193584w;
        if (r101 < r102) goto L5;
    L4:
        r101 = r102;
    L8:
        this.f193586y = r101;
        super.scrollTo(r100, r101);
        return;
    L5:
        r102 = this.f193583v;
        if (r101 > r102) goto L8;
        goto L8
    }

    public ScrollableLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193583v = 0;
        this.f193584w = 0;
        this.f193585x = 0;
        this.A = 10;
        this.B = true;
        this.D = false;
        this.C = new b();
        this.f193562a = new Scroller(r100);
        ViewConfiguration r103 = ViewConfiguration.get(r100);
        this.f193567f = r103.getScaledTouchSlop();
        this.f193568g = r103.getScaledMinimumFlingVelocity();
        this.f193569h = r103.getScaledMaximumFlingVelocity();
        this.f193579r = Build.VERSION.SDK_INT;
        setOrientation(1);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.scrollable_autoMaxScroll, R.attr.scrollable_autoMaxScrollViewId, R.attr.scrollable_closeUpAnimationMillis, R.attr.scrollable_closeUpAnimatorInterpolator, R.attr.scrollable_considerIdleMillis, R.attr.scrollable_defaultCloseUp, R.attr.scrollable_friction, R.attr.scrollable_maxScroll, R.attr.scrollable_scrollerFlywheel, R.attr.scrollable_scrollingHeaderId, R.attr.tabs_marginTop});
        this.f193585x = (int) r104.getDimension(10, 0.0f);
        r104.recycle();
    }
}
