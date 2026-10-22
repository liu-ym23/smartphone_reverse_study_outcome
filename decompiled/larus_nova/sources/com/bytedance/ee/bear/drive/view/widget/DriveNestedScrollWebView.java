package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes16.dex */
class DriveNestedScrollWebView extends b implements NestedScrollingChild {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f225900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f225901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f225902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public NestedScrollingChildHelper f225903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f225904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VelocityTracker f225905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f225906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f225907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f225908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OverScroller f225909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f225910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f225911l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public GestureDetector f225912m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f225913n;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveNestedScrollWebView f225914a;

        public a(DriveNestedScrollWebView r100) {
            this.f225914a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            this.f225914a.f225913n = true;
        }
    }

    private void b() {
        setOverScrollMode(2);
        this.f225909j = new OverScroller(getContext());
        ViewConfiguration r100 = ViewConfiguration.get(getContext());
        this.f225906g = r100.getScaledTouchSlop();
        this.f225910k = r100.getScaledMinimumFlingVelocity();
        this.f225911l = r100.getScaledMaximumFlingVelocity();
        this.f225903d = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.f225912m = new GestureDetector(getContext(), new a(this));
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return 0;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f225903d.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f225903d.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f225903d.stopNestedScroll();
    }

    int getScrollRange() {
        return computeVerticalScrollRange();
    }

    public DriveNestedScrollWebView(Context r100) {
        super(new com.ss.android.lark.officewebview.util.d(r100));
        this.f225900a = new int[2];
        this.f225901b = new int[2];
        this.f225904e = false;
        this.f225907h = -1;
        b();
    }

    private void c(MotionEvent r100) {
        int r101 = (r100.getAction() & 65280) >> 8;
        if (r100.getPointerId(r101) != this.f225907h) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.f225902c = (int) r100.getY(r102);
        this.f225907h = r100.getPointerId(r102);
        VelocityTracker r103 = this.f225905f;
        if (r103 == null) goto L12;
        r103.clear();
        return;
    L12:
        return;
    L6:
        r102 = 0;
        goto L7
    }

    public final void a(int r110) {
        int r100 = getScrollY();
        if (r100 > 0) goto L6;
        if (r110 > 0) goto L6;
    L9:
        boolean r101 = false;
    L11:
        float r102 = r110;
        if (dispatchNestedPreFling(0.0f, r102) == true) goto L19;
        dispatchNestedFling(0.0f, r102, r101);
        if (r101 == true) goto L16;
        return;
    L16:
        if (getChildCount() <= 0) goto L21;
        int r103 = (getHeight() - getPaddingBottom()) - getPaddingTop();
        this.f225909j.fling(getScrollX(), getScrollY(), 0, r110, 0, 0, 0, Math.max(0, getChildAt(0).getHeight() - r103), 0, r103 / 2);
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    L19:
        return;
    L6:
        if (r100 < getScrollRange()) goto L10;
        if (r110 >= 0) goto L9;
    L10:
        r101 = true;
        goto L11
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f225913n == true) goto L54;
        if (isNestedScrollingEnabled() == false) goto L54;
        int r101 = r100.getAction();
        if (r101 == 2) goto L10;
    L12:
        int r102 = r101 & 255;
        if (r102 != 0) goto L15;
        this.f225913n = false;
        this.f225902c = (int) r100.getY();
        this.f225907h = r100.getPointerId(0);
        VelocityTracker r103 = this.f225905f;
        if (r103 != null) goto L49;
        this.f225905f = VelocityTracker.obtain();
    L50:
        this.f225905f.addMovement(r100);
        this.f225909j.computeScrollOffset();
        this.f225904e = !this.f225909j.isFinished();
        startNestedScroll(2);
    L52:
        return this.f225904e;
    L49:
        r103.clear();
        goto L50
    L15:
        if (r102 == 1) goto L39;
        if (r102 != 2) goto L18;
        int r104 = this.f225907h;
        if (r104 == (-1)) goto L52;
        int r105 = r100.findPointerIndex(r104);
        if (r105 != (-1)) goto L29;
        tt5.a.d("NestedWebViewV2", "Invalid pointerId=" + r104 + " in onInterceptTouchEvent");
        goto L52
    L29:
        int r106 = (int) r100.getY(r105);
        if (Math.abs(r106 - this.f225902c) <= this.f225906g) goto L52;
        if ((2 & getNestedScrollAxes()) != 0) goto L52;
        this.f225904e = true;
        this.f225902c = r106;
        if (this.f225905f != null) goto L36;
        this.f225905f = VelocityTracker.obtain();
    L36:
        this.f225905f.addMovement(r100);
        this.f225908i = 0;
        ViewParent r107 = getParent();
        if (r107 == null) goto L52;
        r107.requestDisallowInterceptTouchEvent(true);
        goto L52
    L18:
        if (r102 == 3) goto L39;
        if (r102 != 6) goto L52;
        c(r100);
    L39:
        this.f225913n = false;
        this.f225904e = false;
        this.f225907h = -1;
        VelocityTracker r108 = this.f225905f;
        if (r108 == null) goto L43;
        r108.recycle();
        this.f225905f = null;
    L43:
        if (this.f225909j.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L45;
        ViewCompat.postInvalidateOnAnimation(this);
    L45:
        stopNestedScroll();
        goto L52
    L10:
        if (this.f225904e == false) goto L12;
        return true;
    L54:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        this.f225912m.onTouchEvent(r110);
        if (isNestedScrollingEnabled() == true) goto L7;
        return super.onTouchEvent(r110);
    L7:
        if (this.f225905f != null) goto L9;
        this.f225905f = VelocityTracker.obtain();
    L9:
        MotionEvent r100 = MotionEvent.obtain(r110);
        int r101 = r110.getAction();     // Catch: Throwable -> L100
        if (r101 != 0) goto L14;
        this.f225908i = 0;     // Catch: Throwable -> L100
        this.f225913n = false;     // Catch: Throwable -> L100
    L14:
        if (this.f225913n == false) goto L18;
        boolean r102 = super.onTouchEvent(r110);     // Catch: Throwable -> L100
        r100.recycle();
        return r102;
    L18:
        r100.offsetLocation(0.0f, this.f225908i);     // Catch: Throwable -> L100
        if (r101 == 0) goto L83;
        if (r101 != 1) goto L24;
        this.f225913n = false;     // Catch: Throwable -> L100
        if (this.f225904e == false) goto L78;
        VelocityTracker r103 = this.f225905f;     // Catch: Throwable -> L100
        r103.computeCurrentVelocity(1000, this.f225911l);     // Catch: Throwable -> L100
        int r104 = (int) r103.getYVelocity(this.f225907h);     // Catch: Throwable -> L100
        if (Math.abs(r104) <= this.f225910k) goto L76;
        a(-r104);     // Catch: Throwable -> L100
        goto L78
    L76:
        if (this.f225909j.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L78;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: Throwable -> L100
    L78:
        this.f225907h = -1;     // Catch: Throwable -> L100
        this.f225904e = false;     // Catch: Throwable -> L100
        VelocityTracker r105 = this.f225905f;     // Catch: Throwable -> L100
        if (r105 == null) goto L81;
        r105.recycle();     // Catch: Throwable -> L100
        this.f225905f = null;     // Catch: Throwable -> L100
    L81:
        stopNestedScroll();     // Catch: Throwable -> L100
    L95:
        VelocityTracker r106 = this.f225905f;     // Catch: Throwable -> L100
        if (r106 == null) goto L98;
        r106.addMovement(r100);     // Catch: Throwable -> L100
    L98:
        r100.recycle();
        return super.onTouchEvent(r110);
    L24:
        if (r101 != 2) goto L26;
        int r107 = r110.findPointerIndex(this.f225907h);     // Catch: Throwable -> L100
        if (r107 != (-1)) goto L51;
        tt5.a.d("NestedWebViewV2", "Invalid pointerId=" + this.f225907h + " in onTouchEvent");     // Catch: Throwable -> L100
        goto L95
    L51:
        int r108 = (int) r110.getY(r107);     // Catch: Throwable -> L100
        int r109 = this.f225902c - r108;     // Catch: Throwable -> L100
        if (this.f225904e == true) goto L63;
        if (Math.abs(r109) <= this.f225906g) goto L63;
        ViewParent r111 = getParent();     // Catch: Throwable -> L100
        if (r111 == null) goto L58;
        r111.requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L100
    L58:
        this.f225904e = true;     // Catch: Throwable -> L100
        if (r109 <= 0) goto L61;
        r109 = r109 - this.f225906g;     // Catch: Throwable -> L100
        goto L63
    L61:
        r109 = r109 + this.f225906g;     // Catch: Throwable -> L100
    L63:
        if (this.f225904e == false) goto L95;
        if (dispatchNestedPreScroll(0, r109, this.f225901b, this.f225900a) == false) goto L67;
        r109 = r109 - this.f225901b[1];     // Catch: Throwable -> L100
        r100.offsetLocation(0.0f, this.f225900a[1]);     // Catch: Throwable -> L100
        this.f225908i += this.f225900a[1];     // Catch: Throwable -> L100
    L67:
        this.f225902c = r108 - this.f225900a[1];     // Catch: Throwable -> L100
        int r112 = getScrollY() - getScrollY();     // Catch: Throwable -> L100
        if (dispatchNestedScroll(0, r112, 0, r109 - r112, this.f225900a) == false) goto L95;
        int r113 = this.f225902c;     // Catch: Throwable -> L100
        int r114 = this.f225900a[1];     // Catch: Throwable -> L100
        this.f225902c = r113 - r114;     // Catch: Throwable -> L100
        r100.offsetLocation(0.0f, r114);     // Catch: Throwable -> L100
        this.f225908i += this.f225900a[1];     // Catch: Throwable -> L100
        goto L95
    L26:
        if (r101 != 3) goto L28;
        this.f225913n = false;     // Catch: Throwable -> L100
        if (this.f225904e == true) goto L40;
    L44:
        this.f225907h = -1;     // Catch: Throwable -> L100
        this.f225904e = false;     // Catch: Throwable -> L100
        VelocityTracker r115 = this.f225905f;     // Catch: Throwable -> L100
        if (r115 == null) goto L47;
        r115.recycle();     // Catch: Throwable -> L100
        this.f225905f = null;     // Catch: Throwable -> L100
    L47:
        stopNestedScroll();     // Catch: Throwable -> L100
        goto L95
    L40:
        if (getChildCount() <= 0) goto L44;
        if (this.f225909j.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L44;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: Throwable -> L100
        goto L44
    L28:
        if (r101 != 5) goto L30;
        int r116 = r110.getActionIndex();     // Catch: Throwable -> L100
        this.f225902c = (int) r110.getY(r116);     // Catch: Throwable -> L100
        this.f225907h = r110.getPointerId(r116);     // Catch: Throwable -> L100
        goto L95
    L30:
        if (r101 != 6) goto L95;
        c(r110);     // Catch: Throwable -> L100
        int r117 = r110.findPointerIndex(this.f225907h);     // Catch: Throwable -> L100
        if (r117 != (-1)) goto L35;
        tt5.a.d("NestedWebViewV2", "Invalid pointerId=" + this.f225907h + " in ACTION_POINTER_UP");     // Catch: Throwable -> L100
        goto L95
    L35:
        this.f225902c = (int) r110.getY(r117);     // Catch: Throwable -> L100
        goto L95
    L83:
        if (this.f225909j.isFinished() == true) goto L85;
        boolean r118 = true;
    L86:
        this.f225904e = r118;     // Catch: Throwable -> L100
        if (r118 == false) goto L92;
        ViewParent r119 = getParent();     // Catch: Throwable -> L100
        if (r119 == null) goto L92;
        r119.requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L100
    L92:
        if (this.f225909j.isFinished() == true) goto L94;
        this.f225909j.abortAnimation();     // Catch: Throwable -> L100
    L94:
        this.f225902c = (int) r110.getY();     // Catch: Throwable -> L100
        this.f225907h = r110.getPointerId(0);     // Catch: Throwable -> L100
        startNestedScroll(2);     // Catch: Throwable -> L100
        goto L95
    L85:
        r118 = false;
    L100:
        th = move-exception;
        r100.recycle();
        throw th;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f225903d.setNestedScrollingEnabled(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return this.f225903d.startNestedScroll(r100);
    }

    public DriveNestedScrollWebView(Context r100, AttributeSet r101) {
        super(new com.ss.android.lark.officewebview.util.d(r100), r101);
        this.f225900a = new int[2];
        this.f225901b = new int[2];
        this.f225904e = false;
        this.f225907h = -1;
        b();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f225903d.dispatchNestedPreFling(r100, r101);
    }

    public DriveNestedScrollWebView(Context r100, AttributeSet r101, int r102) {
        super(new com.ss.android.lark.officewebview.util.d(r100), r101, r102);
        this.f225900a = new int[2];
        this.f225901b = new int[2];
        this.f225904e = false;
        this.f225907h = -1;
        b();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f225903d.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return this.f225903d.dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.f225903d.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }
}
