package com.bytedance.ee.bear.browser.view;

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
import com.bytedance.ee.bear.jsbridge.BridgeWebViewV2;

/* JADX INFO: loaded from: classes16.dex */
public class NestedScrollWebViewV2 extends BridgeWebViewV2 implements NestedScrollingChild {
    public final int[] F;
    public final int[] G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public NestedScrollingChildHelper f216652J;
    public boolean K;
    public VelocityTracker L;
    public int M;
    public int N;
    public int O;
    public OverScroller P;
    public int Q;
    public int R;
    public GestureDetector S;
    public boolean T;
    public b U;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestedScrollWebViewV2 f216653a;

        public a(NestedScrollWebViewV2 r100) {
            this.f216653a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            this.f216653a.T = true;
        }
    }

    public interface b {
        boolean onInterceptTouchEvent(MotionEvent r100);

        boolean onTouchEvent(MotionEvent r100);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return 0;
    }

    public final void r() {
        setOverScrollMode(2);
        this.P = new OverScroller(getContext());
        ViewConfiguration r100 = ViewConfiguration.get(getContext());
        this.M = r100.getScaledTouchSlop();
        this.Q = r100.getScaledMinimumFlingVelocity();
        this.R = r100.getScaledMaximumFlingVelocity();
        this.f216652J = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.S = new GestureDetector(getContext(), new a(this));
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f216652J.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f216652J.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f216652J.stopNestedScroll();
    }

    public int getScrollRange() {
        return computeVerticalScrollRange();
    }

    public NestedScrollWebViewV2(Context r100) {
        super(r100);
        this.F = new int[2];
        this.G = new int[2];
        this.K = false;
        this.N = -1;
        r();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        b r101 = this.U;
        if (r101 == null) goto L7;
        return r101.onInterceptTouchEvent(r100);
    L7:
        if (this.T == true) goto L58;
        if (isNestedScrollingEnabled() == false) goto L58;
        int r102 = r100.getAction();
        if (r102 == 2) goto L14;
    L16:
        int r103 = r102 & 255;
        if (r103 != 0) goto L19;
        this.T = false;
        this.H = (int) r100.getY();
        this.I = (int) r100.getX();
        this.N = r100.getPointerId(0);
        VelocityTracker r104 = this.L;
        if (r104 != null) goto L53;
        this.L = VelocityTracker.obtain();
    L54:
        this.L.addMovement(r100);
        this.P.computeScrollOffset();
        this.K = !this.P.isFinished();
        startNestedScroll(2);
    L56:
        return this.K;
    L53:
        r104.clear();
        goto L54
    L19:
        if (r103 == 1) goto L43;
        if (r103 != 2) goto L22;
        int r105 = this.N;
        if (r105 == (-1)) goto L56;
        int r106 = r100.findPointerIndex(r105);
        if (r106 != (-1)) goto L33;
        tt5.a.d("NestedWebViewV2", "Invalid pointerId=" + r105 + " in onInterceptTouchEvent");
        goto L56
    L33:
        int r107 = (int) r100.getY(r106);
        int r108 = (int) r100.getX(r106);
        if (Math.abs(r107 - this.H) <= this.M) goto L56;
        if ((2 & getNestedScrollAxes()) != 0) goto L56;
        this.K = true;
        this.H = r107;
        this.I = r108;
        if (this.L != null) goto L40;
        this.L = VelocityTracker.obtain();
    L40:
        this.L.addMovement(r100);
        this.O = 0;
        ViewParent r109 = getParent();
        if (r109 == null) goto L56;
        r109.requestDisallowInterceptTouchEvent(true);
        goto L56
    L22:
        if (r103 == 3) goto L43;
        if (r103 != 6) goto L56;
        s(r100);
    L43:
        this.T = false;
        this.K = false;
        this.N = -1;
        VelocityTracker r110 = this.L;
        if (r110 == null) goto L47;
        r110.recycle();
        this.L = null;
    L47:
        if (this.P.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L49;
        ViewCompat.postInvalidateOnAnimation(this);
    L49:
        stopNestedScroll();
        goto L56
    L14:
        if (this.K == false) goto L16;
        return true;
    L58:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        b r100 = this.U;
        if (r100 != null) goto L5;
        this.S.onTouchEvent(r110);
        if (isNestedScrollingEnabled() == true) goto L11;
        return super.onTouchEvent(r110);
    L11:
        if (this.L != null) goto L13;
        this.L = VelocityTracker.obtain();
    L13:
        MotionEvent r101 = MotionEvent.obtain(r110);
        int r102 = r110.getAction();     // Catch: Throwable -> L104
        if (r102 != 0) goto L18;
        this.O = 0;     // Catch: Throwable -> L104
        this.T = false;     // Catch: Throwable -> L104
    L18:
        if (this.T == false) goto L22;
        boolean r103 = super.onTouchEvent(r110);     // Catch: Throwable -> L104
        r101.recycle();
        return r103;
    L22:
        r101.offsetLocation(0.0f, this.O);     // Catch: Throwable -> L104
        if (r102 == 0) goto L87;
        if (r102 != 1) goto L28;
        this.T = false;     // Catch: Throwable -> L104
        if (this.K == false) goto L82;
        VelocityTracker r104 = this.L;     // Catch: Throwable -> L104
        r104.computeCurrentVelocity(1000, this.R);     // Catch: Throwable -> L104
        int r105 = (int) r104.getYVelocity(this.N);     // Catch: Throwable -> L104
        if (Math.abs(r105) <= this.Q) goto L80;
        q(-r105);     // Catch: Throwable -> L104
        goto L82
    L80:
        if (this.P.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L82;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: Throwable -> L104
    L82:
        this.N = -1;     // Catch: Throwable -> L104
        this.K = false;     // Catch: Throwable -> L104
        VelocityTracker r106 = this.L;     // Catch: Throwable -> L104
        if (r106 == null) goto L85;
        r106.recycle();     // Catch: Throwable -> L104
        this.L = null;     // Catch: Throwable -> L104
    L85:
        stopNestedScroll();     // Catch: Throwable -> L104
    L99:
        VelocityTracker r107 = this.L;     // Catch: Throwable -> L104
        if (r107 == null) goto L102;
        r107.addMovement(r101);     // Catch: Throwable -> L104
    L102:
        r101.recycle();
        return super.onTouchEvent(r110);
    L28:
        if (r102 != 2) goto L30;
        int r108 = r110.findPointerIndex(this.N);     // Catch: Throwable -> L104
        if (r108 != (-1)) goto L55;
        tt5.a.d("NestedWebViewV2", "Invalid pointerId=" + this.N + " in onTouchEvent");     // Catch: Throwable -> L104
        goto L99
    L55:
        int r109 = (int) r110.getY(r108);     // Catch: Throwable -> L104
        int r111 = (int) r110.getX(r108);     // Catch: Throwable -> L104
        int r112 = this.H - r109;     // Catch: Throwable -> L104
        int r113 = this.I - r111;     // Catch: Throwable -> L104
        if (this.K == true) goto L67;
        if (Math.abs(r112) <= this.M) goto L67;
        ViewParent r114 = getParent();     // Catch: Throwable -> L104
        if (r114 == null) goto L62;
        r114.requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L104
    L62:
        this.K = true;     // Catch: Throwable -> L104
        if (r112 <= 0) goto L65;
        r112 = r112 - this.M;     // Catch: Throwable -> L104
        goto L67
    L65:
        r112 = r112 + this.M;     // Catch: Throwable -> L104
    L67:
        if (this.K == false) goto L99;
        if (dispatchNestedPreScroll(r113, r112, this.G, this.F) == false) goto L71;
        int[] r115 = this.G;     // Catch: Throwable -> L104
        r113 = r113 - r115[0];     // Catch: Throwable -> L104
        r112 = r112 - r115[1];     // Catch: Throwable -> L104
        r101.offsetLocation(0.0f, this.F[1]);     // Catch: Throwable -> L104
        this.O += this.F[1];     // Catch: Throwable -> L104
    L71:
        int r116 = r112;
        int[] r117 = this.F;     // Catch: Throwable -> L104
        this.I = r111 - r117[0];     // Catch: Throwable -> L104
        this.H = r109 - r117[1];     // Catch: Throwable -> L104
        if (dispatchNestedScroll(0, 0, r113, r116, r117) == false) goto L99;
        int[] r118 = this.F;     // Catch: Throwable -> L104
        this.I = r111 - r118[0];     // Catch: Throwable -> L104
        int r119 = this.H;     // Catch: Throwable -> L104
        int r120 = r118[1];     // Catch: Throwable -> L104
        this.H = r119 - r120;     // Catch: Throwable -> L104
        r101.offsetLocation(0.0f, r120);     // Catch: Throwable -> L104
        this.O += this.F[1];     // Catch: Throwable -> L104
        goto L99
    L30:
        if (r102 != 3) goto L32;
        this.T = false;     // Catch: Throwable -> L104
        if (this.K == true) goto L44;
    L48:
        this.N = -1;     // Catch: Throwable -> L104
        this.K = false;     // Catch: Throwable -> L104
        VelocityTracker r121 = this.L;     // Catch: Throwable -> L104
        if (r121 == null) goto L51;
        r121.recycle();     // Catch: Throwable -> L104
        this.L = null;     // Catch: Throwable -> L104
    L51:
        stopNestedScroll();     // Catch: Throwable -> L104
        goto L99
    L44:
        if (getChildCount() <= 0) goto L48;
        if (this.P.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L48;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: Throwable -> L104
        goto L48
    L32:
        if (r102 != 5) goto L34;
        int r122 = r110.getActionIndex();     // Catch: Throwable -> L104
        this.I = (int) r110.getX(r122);     // Catch: Throwable -> L104
        this.H = (int) r110.getY(r122);     // Catch: Throwable -> L104
        this.N = r110.getPointerId(r122);     // Catch: Throwable -> L104
        goto L99
    L34:
        if (r102 != 6) goto L99;
        s(r110);     // Catch: Throwable -> L104
        int r123 = r110.findPointerIndex(this.N);     // Catch: Throwable -> L104
        if (r123 != (-1)) goto L39;
        tt5.a.d("NestedWebViewV2", "Invalid pointerId=" + this.N + " in ACTION_POINTER_UP");     // Catch: Throwable -> L104
        goto L99
    L39:
        this.I = (int) r110.getX(r123);     // Catch: Throwable -> L104
        this.H = (int) r110.getY(r123);     // Catch: Throwable -> L104
        goto L99
    L87:
        if (this.P.isFinished() == true) goto L89;
        boolean r124 = true;
    L90:
        this.K = r124;     // Catch: Throwable -> L104
        if (r124 == false) goto L96;
        ViewParent r125 = getParent();     // Catch: Throwable -> L104
        if (r125 == null) goto L96;
        r125.requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L104
    L96:
        if (this.P.isFinished() == true) goto L98;
        this.P.abortAnimation();     // Catch: Throwable -> L104
    L98:
        this.H = (int) r110.getY();     // Catch: Throwable -> L104
        this.I = (int) r110.getX();     // Catch: Throwable -> L104
        this.N = r110.getPointerId(0);     // Catch: Throwable -> L104
        startNestedScroll(2);     // Catch: Throwable -> L104
        goto L99
    L89:
        r124 = false;
    L104:
        th = move-exception;
        r101.recycle();
        throw th;
    L5:
        return r100.onTouchEvent(r110);
    }

    public final void q(int r110) {
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
        this.P.fling(getScrollX(), getScrollY(), 0, r110, 0, 0, 0, Math.max(0, getChildAt(0).getHeight() - r103), 0, r103 / 2);
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

    public final void s(MotionEvent r100) {
        int r101 = (r100.getAction() & 65280) >> 8;
        if (r100.getPointerId(r101) != this.N) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.I = (int) r100.getX(r102);
        this.H = (int) r100.getY(r102);
        this.N = r100.getPointerId(r102);
        VelocityTracker r103 = this.L;
        if (r103 == null) goto L12;
        r103.clear();
        return;
    L12:
        return;
    L6:
        r102 = 0;
        goto L7
    }

    public void setNestedScrollStrategy(b r100) {
        this.U = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f216652J.setNestedScrollingEnabled(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return this.f216652J.startNestedScroll(r100);
    }

    public final boolean t(MotionEvent r100) {
        return super.onInterceptTouchEvent(r100);
    }

    public final boolean u(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    public NestedScrollWebViewV2(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.F = new int[2];
        this.G = new int[2];
        this.K = false;
        this.N = -1;
        r();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f216652J.dispatchNestedPreFling(r100, r101);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f216652J.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return this.f216652J.dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.f216652J.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }
}
