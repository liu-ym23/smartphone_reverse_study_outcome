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
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.jsbridge.BridgeWebViewV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class NestedScrollWebViewV2 extends BridgeWebViewV2 implements NestedScrollingChild {
    public final int[] F;
    public final int[] G;
    public int H;
    public int I;
    public NestedScrollingChildHelper J;
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
        public final /* synthetic */ NestedScrollWebViewV2 a;

        public a(NestedScrollWebViewV2 r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r2) {
            this.a.T = true;
        }
    }

    public interface b {
        boolean onInterceptTouchEvent(MotionEvent r1);

        boolean onTouchEvent(MotionEvent r1);
    }

    public int getNestedScrollAxes() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r() {
        setOverScrollMode(2);
        this.P = new OverScroller(getContext());
        ViewConfiguration r0 = ViewConfiguration.get(getContext());
        this.M = r0.getScaledTouchSlop();
        this.Q = r0.getScaledMinimumFlingVelocity();
        this.R = r0.getScaledMaximumFlingVelocity();
        this.J = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.S = new GestureDetector(getContext(), new a(this));
    }

    public final boolean hasNestedScrollingParent() {
        return this.J.hasNestedScrollingParent();
    }

    public final boolean isNestedScrollingEnabled() {
        return this.J.isNestedScrollingEnabled();
    }

    public final void stopNestedScroll() {
        this.J.stopNestedScroll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getScrollRange() {
        return computeVerticalScrollRange();
    }

    public NestedScrollWebViewV2(Context r2) {
        super(r2);
        this.F = new int[2];
        this.G = new int[2];
        this.K = false;
        this.N = -1;
        r();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onInterceptTouchEvent(MotionEvent r8) {
        b r0 = this.U;
        if (r0 == null) goto L7;
        return r0.onInterceptTouchEvent(r8);
    L7:
        if (this.T == true) goto L58;
        if (isNestedScrollingEnabled() == false) goto L58;
        int r1 = r8.getAction();
        if (r1 == 2) goto L14;
    L16:
        int r2 = r1 & 255;
        if (r2 != 0) goto L19;
        this.T = false;
        this.H = (int) r8.getY();
        this.I = (int) r8.getX();
        this.N = r8.getPointerId(0);
        VelocityTracker r3 = this.L;
        if (r3 != null) goto L53;
        this.L = VelocityTracker.obtain();
    L54:
        this.L.addMovement(r8);
        this.P.computeScrollOffset();
        this.K = !this.P.isFinished();
        startNestedScroll(2);
    L56:
        return this.K;
    L53:
        r3.clear();
        goto L54
    L19:
        if (r2 == 1) goto L43;
        if (r2 != 2) goto L22;
        int r4 = this.N;
        if (r4 == (-1)) goto L56;
        int r5 = r8.findPointerIndex(r4);
        if (r5 != (-1)) goto L33;
        tt5.a.d("NestedWebViewV2", "Invalid pointerId=" + r4 + " in onInterceptTouchEvent");
        goto L56
    L33:
        int r6 = (int) r8.getY(r5);
        int r7 = (int) r8.getX(r5);
        if (Math.abs(r6 - this.H) <= this.M) goto L56;
        if ((2 & getNestedScrollAxes()) != 0) goto L56;
        this.K = true;
        this.H = r6;
        this.I = r7;
        if (this.L != null) goto L40;
        this.L = VelocityTracker.obtain();
    L40:
        this.L.addMovement(r8);
        this.O = 0;
        ViewParent r9 = getParent();
        if (r9 == null) goto L56;
        r9.requestDisallowInterceptTouchEvent(true);
        goto L56
    L22:
        if (r2 == 3) goto L43;
        if (r2 != 6) goto L56;
        s(r8);
    L43:
        this.T = false;
        this.K = false;
        this.N = -1;
        VelocityTracker r10 = this.L;
        if (r10 == null) goto L47;
        r10.recycle();
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
        return super/*android.webkit.WebView*/.onInterceptTouchEvent(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r18) {
        b r1 = this.U;
        if (r1 != null) goto L5;
        this.S.onTouchEvent(r18);
        if (isNestedScrollingEnabled() == true) goto L11;
        return super/*com.bytedance.ee.larkwebview.base.LarkWebView*/.onTouchEvent(r18);
    L11:
        if (this.L != null) goto L13;
        this.L = VelocityTracker.obtain();
    L13:
        MotionEvent r8 = MotionEvent.obtain(r18);
        int r2 = r18.getAction();     // Catch: Throwable -> L104
        if (r2 != 0) goto L18;
        this.O = 0;     // Catch: Throwable -> L104
        this.T = false;     // Catch: Throwable -> L104
    L18:
        if (this.T == false) goto L22;
        boolean r0 = super/*com.bytedance.ee.larkwebview.base.LarkWebView*/.onTouchEvent(r18);     // Catch: Throwable -> L104
        r8.recycle();
        return r0;
    L22:
        r8.offsetLocation(0.0f, this.O);     // Catch: Throwable -> L104
        if (r2 == 0) goto L87;
        if (r2 != 1) goto L28;
        this.T = false;     // Catch: Throwable -> L104
        if (this.K == false) goto L82;
        VelocityTracker r3 = this.L;     // Catch: Throwable -> L104
        r3.computeCurrentVelocity(UploadResult.UPLOAD_CACELL, this.R);     // Catch: Throwable -> L104
        int r4 = (int) r3.getYVelocity(this.N);     // Catch: Throwable -> L104
        if (Math.abs(r4) <= this.Q) goto L80;
        q(-r4);     // Catch: Throwable -> L104
        goto L82
    L80:
        if (this.P.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L82;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: Throwable -> L104
    L82:
        this.N = -1;     // Catch: Throwable -> L104
        this.K = false;     // Catch: Throwable -> L104
        VelocityTracker r5 = this.L;     // Catch: Throwable -> L104
        if (r5 == null) goto L85;
        r5.recycle();     // Catch: Throwable -> L104
        this.L = null;     // Catch: Throwable -> L104
    L85:
        stopNestedScroll();     // Catch: Throwable -> L104
    L99:
        VelocityTracker r6 = this.L;     // Catch: Throwable -> L104
        if (r6 == null) goto L102;
        r6.addMovement(r8);     // Catch: Throwable -> L104
    L102:
        r8.recycle();
        return super/*com.bytedance.ee.larkwebview.base.LarkWebView*/.onTouchEvent(r18);
    L28:
        if (r2 != 2) goto L30;
        int r7 = r18.findPointerIndex(this.N);     // Catch: Throwable -> L104
        if (r7 != (-1)) goto L55;
        tt5.a.d("NestedWebViewV2", "Invalid pointerId=" + this.N + " in onTouchEvent");     // Catch: Throwable -> L104
        goto L99
    L55:
        int r9 = (int) r18.getY(r7);     // Catch: Throwable -> L104
        int r12 = (int) r18.getX(r7);     // Catch: Throwable -> L104
        int r10 = this.H - r9;     // Catch: Throwable -> L104
        int r11 = this.I - r12;     // Catch: Throwable -> L104
        if (this.K == true) goto L67;
        if (Math.abs(r10) <= this.M) goto L67;
        ViewParent r13 = getParent();     // Catch: Throwable -> L104
        if (r13 == null) goto L62;
        r13.requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L104
    L62:
        this.K = true;     // Catch: Throwable -> L104
        if (r10 <= 0) goto L65;
        r10 = r10 - this.M;     // Catch: Throwable -> L104
        goto L67
    L65:
        r10 = r10 + this.M;     // Catch: Throwable -> L104
    L67:
        if (this.K == false) goto L99;
        if (dispatchNestedPreScroll(r11, r10, this.G, this.F) == false) goto L71;
        int[] r14 = this.G;     // Catch: Throwable -> L104
        r11 = r11 - r14[0];     // Catch: Throwable -> L104
        r10 = r10 - r14[1];     // Catch: Throwable -> L104
        r8.offsetLocation(0.0f, this.F[1]);     // Catch: Throwable -> L104
        this.O += this.F[1];     // Catch: Throwable -> L104
    L71:
        int r16 = r10;
        int[] r17 = this.F;     // Catch: Throwable -> L104
        this.I = r12 - r17[0];     // Catch: Throwable -> L104
        this.H = r9 - r17[1];     // Catch: Throwable -> L104
        if (dispatchNestedScroll(0, 0, r11, r16, r17) == false) goto L99;
        int[] r19 = this.F;     // Catch: Throwable -> L104
        this.I = r12 - r19[0];     // Catch: Throwable -> L104
        int r20 = this.H;     // Catch: Throwable -> L104
        int r21 = r19[1];     // Catch: Throwable -> L104
        this.H = r20 - r21;     // Catch: Throwable -> L104
        r8.offsetLocation(0.0f, r21);     // Catch: Throwable -> L104
        this.O += this.F[1];     // Catch: Throwable -> L104
        goto L99
    L30:
        if (r2 != 3) goto L32;
        this.T = false;     // Catch: Throwable -> L104
        if (this.K == true) goto L44;
    L48:
        this.N = -1;     // Catch: Throwable -> L104
        this.K = false;     // Catch: Throwable -> L104
        VelocityTracker r22 = this.L;     // Catch: Throwable -> L104
        if (r22 == null) goto L51;
        r22.recycle();     // Catch: Throwable -> L104
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
        if (r2 != 5) goto L34;
        int r23 = r18.getActionIndex();     // Catch: Throwable -> L104
        this.I = (int) r18.getX(r23);     // Catch: Throwable -> L104
        this.H = (int) r18.getY(r23);     // Catch: Throwable -> L104
        this.N = r18.getPointerId(r23);     // Catch: Throwable -> L104
        goto L99
    L34:
        if (r2 != 6) goto L99;
        s(r18);     // Catch: Throwable -> L104
        int r24 = r18.findPointerIndex(this.N);     // Catch: Throwable -> L104
        if (r24 != (-1)) goto L39;
        tt5.a.d("NestedWebViewV2", "Invalid pointerId=" + this.N + " in ACTION_POINTER_UP");     // Catch: Throwable -> L104
        goto L99
    L39:
        this.I = (int) r18.getX(r24);     // Catch: Throwable -> L104
        this.H = (int) r18.getY(r24);     // Catch: Throwable -> L104
        goto L99
    L87:
        if (this.P.isFinished() == true) goto L89;
        boolean r26 = true;
    L90:
        this.K = r26;     // Catch: Throwable -> L104
        if (r26 == false) goto L96;
        ViewParent r27 = getParent();     // Catch: Throwable -> L104
        if (r27 == null) goto L96;
        r27.requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L104
    L96:
        if (this.P.isFinished() == true) goto L98;
        this.P.abortAnimation();     // Catch: Throwable -> L104
    L98:
        this.H = (int) r18.getY();     // Catch: Throwable -> L104
        this.I = (int) r18.getX();     // Catch: Throwable -> L104
        this.N = r18.getPointerId(0);     // Catch: Throwable -> L104
        startNestedScroll(2);     // Catch: Throwable -> L104
        goto L99
    L89:
        r26 = false;
    L104:
        th = move-exception;
        r8.recycle();
        throw th;
    L5:
        return r1.onTouchEvent(r18);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q(int r16) {
        int r0 = getScrollY();
        if (r0 > 0) goto L6;
        if (r16 > 0) goto L6;
    L9:
        boolean r1 = false;
    L11:
        float r2 = r16;
        if (dispatchNestedPreFling(0.0f, r2) == true) goto L19;
        dispatchNestedFling(0.0f, r2, r1);
        if (r1 == true) goto L16;
        return;
    L16:
        if (getChildCount() <= 0) goto L21;
        int r3 = (getHeight() - getPaddingBottom()) - getPaddingTop();
        this.P.fling(getScrollX(), getScrollY(), 0, r16, 0, 0, 0, Math.max(0, getChildAt(0).getHeight() - r3), 0, r3 / 2);
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    L19:
        return;
    L6:
        if (r0 < getScrollRange()) goto L10;
        if (r16 >= 0) goto L9;
    L10:
        r1 = true;
        goto L11
    }

    public final void s(MotionEvent r4) {
        int r0 = (r4.getAction() & 65280) >> 8;
        if (r4.getPointerId(r0) != this.N) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.I = (int) r4.getX(r1);
        this.H = (int) r4.getY(r1);
        this.N = r4.getPointerId(r1);
        VelocityTracker r5 = this.L;
        if (r5 == null) goto L12;
        r5.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    public void setNestedScrollStrategy(b r1) {
        this.U = r1;
    }

    public void setNestedScrollingEnabled(boolean r2) {
        this.J.setNestedScrollingEnabled(r2);
    }

    public final boolean startNestedScroll(int r2) {
        return this.J.startNestedScroll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean t(MotionEvent r1) {
        return super/*android.webkit.WebView*/.onInterceptTouchEvent(r1);
    }

    public final boolean u(MotionEvent r1) {
        return super/*com.bytedance.ee.larkwebview.base.LarkWebView*/.onTouchEvent(r1);
    }

    public NestedScrollWebViewV2(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.F = new int[2];
        this.G = new int[2];
        this.K = false;
        this.N = -1;
        r();
    }

    public final boolean dispatchNestedPreFling(float r2, float r3) {
        return this.J.dispatchNestedPreFling(r2, r3);
    }

    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.J.dispatchNestedFling(r2, r3, r4);
    }

    public final boolean dispatchNestedPreScroll(int r2, int r3, int[] r4, int[] r5) {
        return this.J.dispatchNestedPreScroll(r2, r3, r4, r5);
    }

    public final boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.J.dispatchNestedScroll(r7, r8, r9, r10, r11);
    }
}
