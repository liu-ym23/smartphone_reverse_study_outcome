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
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class DriveNestedScrollWebView extends b implements NestedScrollingChild {
    public final int[] a;
    public final int[] b;
    public int c;
    public NestedScrollingChildHelper d;
    public boolean e;
    public VelocityTracker f;
    public int g;
    public int h;
    public int i;
    public OverScroller j;
    public int k;
    public int l;
    public GestureDetector m;
    public boolean n;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ DriveNestedScrollWebView a;

        public a(DriveNestedScrollWebView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r2) {
            this.a.n = true;
        }
    }

    private void b() {
        setOverScrollMode(2);
        this.j = new OverScroller(getContext());
        ViewConfiguration r0 = ViewConfiguration.get(getContext());
        this.g = r0.getScaledTouchSlop();
        this.k = r0.getScaledMinimumFlingVelocity();
        this.l = r0.getScaledMaximumFlingVelocity();
        this.d = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.m = new GestureDetector(getContext(), new a(this));
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return 0;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.d.hasNestedScrollingParent();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.d.isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.d.stopNestedScroll();
    }

    int getScrollRange() {
        return computeVerticalScrollRange();
    }

    public DriveNestedScrollWebView(Context r2) {
        super(new com.ss.android.lark.officewebview.util.d(r2));
        this.a = new int[2];
        this.b = new int[2];
        this.e = false;
        this.h = -1;
        b();
    }

    private void c(MotionEvent r4) {
        int r0 = (r4.getAction() & 65280) >> 8;
        if (r4.getPointerId(r0) != this.h) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.c = (int) r4.getY(r1);
        this.h = r4.getPointerId(r1);
        VelocityTracker r5 = this.f;
        if (r5 == null) goto L12;
        r5.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    public final void a(int r16) {
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
        this.j.fling(getScrollX(), getScrollY(), 0, r16, 0, 0, 0, Math.max(0, getChildAt(0).getHeight() - r3), 0, r3 / 2);
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

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        if (this.n == true) goto L54;
        if (isNestedScrollingEnabled() == false) goto L54;
        int r0 = r8.getAction();
        if (r0 == 2) goto L10;
    L12:
        int r1 = r0 & 255;
        if (r1 != 0) goto L15;
        this.n = false;
        this.c = (int) r8.getY();
        this.h = r8.getPointerId(0);
        VelocityTracker r2 = this.f;
        if (r2 != null) goto L49;
        this.f = VelocityTracker.obtain();
    L50:
        this.f.addMovement(r8);
        this.j.computeScrollOffset();
        this.e = !this.j.isFinished();
        startNestedScroll(2);
    L52:
        return this.e;
    L49:
        r2.clear();
        goto L50
    L15:
        if (r1 == 1) goto L39;
        if (r1 != 2) goto L18;
        int r3 = this.h;
        if (r3 == (-1)) goto L52;
        int r5 = r8.findPointerIndex(r3);
        if (r5 != (-1)) goto L29;
        tt5.a.d("NestedWebViewV2", "Invalid pointerId=" + r3 + " in onInterceptTouchEvent");
        goto L52
    L29:
        int r4 = (int) r8.getY(r5);
        if (Math.abs(r4 - this.c) <= this.g) goto L52;
        if ((2 & getNestedScrollAxes()) != 0) goto L52;
        this.e = true;
        this.c = r4;
        if (this.f != null) goto L36;
        this.f = VelocityTracker.obtain();
    L36:
        this.f.addMovement(r8);
        this.i = 0;
        ViewParent r9 = getParent();
        if (r9 == null) goto L52;
        r9.requestDisallowInterceptTouchEvent(true);
        goto L52
    L18:
        if (r1 == 3) goto L39;
        if (r1 != 6) goto L52;
        c(r8);
    L39:
        this.n = false;
        this.e = false;
        this.h = -1;
        VelocityTracker r10 = this.f;
        if (r10 == null) goto L43;
        r10.recycle();
        this.f = null;
    L43:
        if (this.j.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L45;
        ViewCompat.postInvalidateOnAnimation(this);
    L45:
        stopNestedScroll();
        goto L52
    L10:
        if (this.e == false) goto L12;
        return true;
    L54:
        return super.onInterceptTouchEvent(r8);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r17) {
        this.m.onTouchEvent(r17);
        if (isNestedScrollingEnabled() == true) goto L7;
        return super.onTouchEvent(r17);
    L7:
        if (this.f != null) goto L9;
        this.f = VelocityTracker.obtain();
    L9:
        MotionEvent r8 = MotionEvent.obtain(r17);
        int r1 = r17.getAction();     // Catch: Throwable -> L100
        if (r1 != 0) goto L14;
        this.i = 0;     // Catch: Throwable -> L100
        this.n = false;     // Catch: Throwable -> L100
    L14:
        if (this.n == false) goto L18;
        boolean r0 = super.onTouchEvent(r17);     // Catch: Throwable -> L100
        r8.recycle();
        return r0;
    L18:
        r8.offsetLocation(0.0f, this.i);     // Catch: Throwable -> L100
        if (r1 == 0) goto L83;
        if (r1 != 1) goto L24;
        this.n = false;     // Catch: Throwable -> L100
        if (this.e == false) goto L78;
        VelocityTracker r2 = this.f;     // Catch: Throwable -> L100
        r2.computeCurrentVelocity(UploadResult.UPLOAD_CACELL, this.l);     // Catch: Throwable -> L100
        int r3 = (int) r2.getYVelocity(this.h);     // Catch: Throwable -> L100
        if (Math.abs(r3) <= this.k) goto L76;
        a(-r3);     // Catch: Throwable -> L100
        goto L78
    L76:
        if (this.j.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L78;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: Throwable -> L100
    L78:
        this.h = -1;     // Catch: Throwable -> L100
        this.e = false;     // Catch: Throwable -> L100
        VelocityTracker r4 = this.f;     // Catch: Throwable -> L100
        if (r4 == null) goto L81;
        r4.recycle();     // Catch: Throwable -> L100
        this.f = null;     // Catch: Throwable -> L100
    L81:
        stopNestedScroll();     // Catch: Throwable -> L100
    L95:
        VelocityTracker r5 = this.f;     // Catch: Throwable -> L100
        if (r5 == null) goto L98;
        r5.addMovement(r8);     // Catch: Throwable -> L100
    L98:
        r8.recycle();
        return super.onTouchEvent(r17);
    L24:
        if (r1 != 2) goto L26;
        int r6 = r17.findPointerIndex(this.h);     // Catch: Throwable -> L100
        if (r6 != (-1)) goto L51;
        tt5.a.d("NestedWebViewV2", "Invalid pointerId=" + this.h + " in onTouchEvent");     // Catch: Throwable -> L100
        goto L95
    L51:
        int r7 = (int) r17.getY(r6);     // Catch: Throwable -> L100
        int r9 = this.c - r7;     // Catch: Throwable -> L100
        if (this.e == true) goto L63;
        if (Math.abs(r9) <= this.g) goto L63;
        ViewParent r10 = getParent();     // Catch: Throwable -> L100
        if (r10 == null) goto L58;
        r10.requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L100
    L58:
        this.e = true;     // Catch: Throwable -> L100
        if (r9 <= 0) goto L61;
        r9 = r9 - this.g;     // Catch: Throwable -> L100
        goto L63
    L61:
        r9 = r9 + this.g;     // Catch: Throwable -> L100
    L63:
        if (this.e == false) goto L95;
        if (dispatchNestedPreScroll(0, r9, this.b, this.a) == false) goto L67;
        r9 = r9 - this.b[1];     // Catch: Throwable -> L100
        r8.offsetLocation(0.0f, this.a[1]);     // Catch: Throwable -> L100
        this.i += this.a[1];     // Catch: Throwable -> L100
    L67:
        this.c = r7 - this.a[1];     // Catch: Throwable -> L100
        int r11 = getScrollY() - getScrollY();     // Catch: Throwable -> L100
        if (dispatchNestedScroll(0, r11, 0, r9 - r11, this.a) == false) goto L95;
        int r12 = this.c;     // Catch: Throwable -> L100
        int r13 = this.a[1];     // Catch: Throwable -> L100
        this.c = r12 - r13;     // Catch: Throwable -> L100
        r8.offsetLocation(0.0f, r13);     // Catch: Throwable -> L100
        this.i += this.a[1];     // Catch: Throwable -> L100
        goto L95
    L26:
        if (r1 != 3) goto L28;
        this.n = false;     // Catch: Throwable -> L100
        if (this.e == true) goto L40;
    L44:
        this.h = -1;     // Catch: Throwable -> L100
        this.e = false;     // Catch: Throwable -> L100
        VelocityTracker r14 = this.f;     // Catch: Throwable -> L100
        if (r14 == null) goto L47;
        r14.recycle();     // Catch: Throwable -> L100
        this.f = null;     // Catch: Throwable -> L100
    L47:
        stopNestedScroll();     // Catch: Throwable -> L100
        goto L95
    L40:
        if (getChildCount() <= 0) goto L44;
        if (this.j.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L44;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: Throwable -> L100
        goto L44
    L28:
        if (r1 != 5) goto L30;
        int r16 = r17.getActionIndex();     // Catch: Throwable -> L100
        this.c = (int) r17.getY(r16);     // Catch: Throwable -> L100
        this.h = r17.getPointerId(r16);     // Catch: Throwable -> L100
        goto L95
    L30:
        if (r1 != 6) goto L95;
        c(r17);     // Catch: Throwable -> L100
        int r18 = r17.findPointerIndex(this.h);     // Catch: Throwable -> L100
        if (r18 != (-1)) goto L35;
        tt5.a.d("NestedWebViewV2", "Invalid pointerId=" + this.h + " in ACTION_POINTER_UP");     // Catch: Throwable -> L100
        goto L95
    L35:
        this.c = (int) r17.getY(r18);     // Catch: Throwable -> L100
        goto L95
    L83:
        if (this.j.isFinished() == true) goto L85;
        boolean r19 = true;
    L86:
        this.e = r19;     // Catch: Throwable -> L100
        if (r19 == false) goto L92;
        ViewParent r20 = getParent();     // Catch: Throwable -> L100
        if (r20 == null) goto L92;
        r20.requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L100
    L92:
        if (this.j.isFinished() == true) goto L94;
        this.j.abortAnimation();     // Catch: Throwable -> L100
    L94:
        this.c = (int) r17.getY();     // Catch: Throwable -> L100
        this.h = r17.getPointerId(0);     // Catch: Throwable -> L100
        startNestedScroll(2);     // Catch: Throwable -> L100
        goto L95
    L85:
        r19 = false;
    L100:
        th = move-exception;
        r8.recycle();
        throw th;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.d.setNestedScrollingEnabled(r2);
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r2) {
        return this.d.startNestedScroll(r2);
    }

    public DriveNestedScrollWebView(Context r2, AttributeSet r3) {
        super(new com.ss.android.lark.officewebview.util.d(r2), r3);
        this.a = new int[2];
        this.b = new int[2];
        this.e = false;
        this.h = -1;
        b();
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float r2, float r3) {
        return this.d.dispatchNestedPreFling(r2, r3);
    }

    public DriveNestedScrollWebView(Context r2, AttributeSet r3, int r4) {
        super(new com.ss.android.lark.officewebview.util.d(r2), r3, r4);
        this.a = new int[2];
        this.b = new int[2];
        this.e = false;
        this.h = -1;
        b();
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.d.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int r2, int r3, int[] r4, int[] r5) {
        return this.d.dispatchNestedPreScroll(r2, r3, r4, r5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.d.dispatchNestedScroll(r7, r8, r9, r10, r11);
    }
}
