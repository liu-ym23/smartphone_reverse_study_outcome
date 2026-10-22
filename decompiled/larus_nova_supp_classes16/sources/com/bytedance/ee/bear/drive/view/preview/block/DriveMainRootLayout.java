package com.bytedance.ee.bear.drive.view.preview.block;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.util.ui.h;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveMainRootLayout extends FrameLayout {
    public static final int r = 0;
    public int a;
    public int b;
    public c55.b c;
    public long d;
    public View.OnClickListener e;
    public boolean f;
    public View g;
    public float h;
    public float i;
    public a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final Paint n;
    public final int o;
    public boolean p;
    public final b q;

    public interface a {
        boolean a(int r1);
    }

    public class b extends CountDownTimer {
        public final /* synthetic */ DriveMainRootLayout a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            tt5.a.h("DriveMainRootLayout", "create down event");
            DriveMainRootLayout r0 = this.a;
            r0.p = true;
            long r4 = System.currentTimeMillis();
            MotionEvent r1 = MotionEvent.obtain(r4, r4, 0, r0.h, r0.i, 0);
            r0.getRootView().dispatchTouchEvent(r1);
        }

        public b(DriveMainRootLayout r3, long r4) {
            this.a = r3;
            super(r4, 100);
        }
    }

    static {
        r = d.a(20);
    }

    public final void b() {
        this.a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.n.setColor(getResources().getColor(2131108718));
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setStrokeWidth(d.a(2));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.h("DriveMainRootLayout", "onDetachedFromWindow()");
    }

    public DriveMainRootLayout(Context r3) {
        super(r3);
        this.b = 0;
        this.n = new Paint(1);
        this.o = d.a(6);
        this.p = false;
        this.q = new b(this, ViewConfiguration.getLongPressTimeout());
        b();
    }

    public final boolean a(MotionEvent r7) {
        if ((SystemClock.uptimeMillis() - this.d) >= 500) goto L21;
        float r0 = this.h;
        float r1 = r7.getRawX();
        float r2 = this.i;
        float r8 = r7.getRawY();
        float r3 = Math.abs(r0 - r1);
        float r9 = Math.abs(r2 - r8);
        float r4 = 100;
        if (r3 <= r4) goto L7;
    L9:
        boolean r10 = false;
    L10:
        if (r10 == false) goto L21;
        if (this.f == false) goto L14;
    L20:
        tt5.a.h("DriveMainRootLayout", "pointInBlockFunc()");
        goto L21
    L14:
        if (this.e == null) goto L20;
        if (h.a(800) == false) goto L18;
        this.e.onClick(this);
    L19:
        return true;
    L18:
        tt5.a.k("DriveMainRootLayout", "dispatchClickEvent() isValidClick=false");
        goto L19
    L7:
        if (r9 > r4) goto L9;
        r10 = true;
    L21:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        int r4 = r10.getPointerId(0);     // Catch: Throwable -> L55
        int r5 = r10.getAction();     // Catch: Throwable -> L55
        if (r5 != 0) goto L6;
        this.h = r10.getRawX();     // Catch: Throwable -> L55
        this.i = r10.getRawY();     // Catch: Throwable -> L55
        tt5.a.h("DriveMainRootLayout", "dispatchTouchEvent() ACTION_DOWN x=" + this.h + " y=" + this.i);     // Catch: Throwable -> L55
        this.d = SystemClock.uptimeMillis();     // Catch: Throwable -> L55
        if (this.l == false) goto L48;
        if (r4 == 0) goto L34;
        tt5.a.h("DriveMainRootLayout", "dispatchTouchEvent() inBlock pointId != 0");     // Catch: Throwable -> L55
        return false;
    L34:
        c(this, r10.getRawX(), r10.getRawY());     // Catch: Throwable -> L55
        if (this.f == false) goto L42;
        boolean r11 = super.dispatchTouchEvent(r10);     // Catch: Throwable -> L55
        tt5.a.b("DriveMainRootLayout", "dispatchTouchEvent() ret=" + r11);     // Catch: Throwable -> L55
        c55.b r1 = this.c;     // Catch: Throwable -> L55
        if (r1 == null) goto L40;
        if (r11 == false) goto L40;
        r1.c(r11);     // Catch: Throwable -> L55
    L40:
        return r11;
    L42:
        if (this.p == false) goto L45;
        this.p = false;     // Catch: Throwable -> L55
        this.q.cancel();     // Catch: Throwable -> L55
        tt5.a.h("DriveMainRootLayout", "dispatchTouchEvent() long event");     // Catch: Throwable -> L55
        return false;
    L45:
        this.q.start();     // Catch: Throwable -> L55
        return true;
    L48:
        if (this.l == true) goto L50;
    L54:
        return super.dispatchTouchEvent(r10);
    L50:
        if (this.f == true) goto L54;
        getParent().requestDisallowInterceptTouchEvent(false);     // Catch: Throwable -> L55
        this.q.cancel();     // Catch: Throwable -> L55
        return false;
    L6:
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L48;
        if (r5 != 3) goto L54;
        if (this.l == false) goto L14;
        this.q.cancel();     // Catch: Throwable -> L55
    L14:
        this.f = false;     // Catch: Throwable -> L55
        goto L54
    L16:
        if (this.l == false) goto L54;
        this.q.cancel();     // Catch: Throwable -> L55
        c55.b r2 = this.c;     // Catch: Throwable -> L55
        if (r2 == null) goto L21;
        r2.c(false);     // Catch: Throwable -> L55
    L21:
        if (this.f == false) goto L25;
        this.f = false;     // Catch: Throwable -> L55
        return super.dispatchTouchEvent(r10);
    L25:
        if (a(r10) == false) goto L28;
        MotionEvent r12 = MotionEvent.obtain(r10);     // Catch: Throwable -> L55
        r12.setAction(3);     // Catch: Throwable -> L55
        return super.dispatchTouchEvent(r12);
    L28:
        return false;
    L55:
        th = move-exception;
        tt5.a.d("DriveMainRootLayout", th.getMessage());
        return false;
    }

    @Override // android.view.View
    public final void onDrawForeground(Canvas r10) {
        super.onDrawForeground(r10);
        if (this.m == false) goto L6;
        float r4 = getWidth();
        float r5 = getHeight();
        int r0 = this.o;
        r10.drawRoundRect(0.0f, 0.0f, r4, r5, r0, r0, this.n);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.l == true) goto L5;
        int r0 = (int) r10.getRawX();
        int r1 = (int) r10.getRawY();
        int r2 = r10.getAction();
        if (r2 != 0) goto L9;
        this.k = false;
    L48:
        return super.onInterceptTouchEvent(r10);
    L9:
        if (r2 == 1) goto L28;
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L48;
        this.d = 0;
        this.f = false;
        this.k = false;
        this.b = 0;
        goto L48
    L14:
        float r3 = this.h;
        float r4 = r0;
        float r5 = r3 - r4;
        int r7 = this.a;
        if (r5 <= r7) goto L18;
        this.b = 4;
        goto L48
    L18:
        if ((r4 - r3) > r7) goto L20;
        float r6 = this.i;
        float r8 = r1;
        if ((r6 - r8) <= r7) goto L26;
        this.b = 1;
        goto L48
    L26:
        if ((r8 - r6) <= r7) goto L48;
        this.b = 3;
        goto L48
    L20:
        if (r < r3) goto L48;
        this.b = 2;
        this.k = true;
        goto L48
    L28:
        int r9 = this.b;
        if (r9 == 2) goto L38;
        if (this.k == true) goto L38;
        if (r9 != 3) goto L42;
        a r11 = this.j;
        if (r11 == null) goto L42;
        boolean r12 = r11.a(r9);
    L43:
        this.k = false;
        this.f = false;
        this.b = 0;
        if (r12 == false) goto L48;
        return true;
    L42:
        r12 = false;
    L38:
        if (r < this.h) goto L42;
        a r13 = this.j;
        if (r13 == null) goto L42;
        r13.a(r9);
        goto L42
    L5:
        return super.onInterceptTouchEvent(r10);
    }

    public void setInBlock(boolean r1) {
        this.l = r1;
    }

    public void setInterceptClickListener(View.OnClickListener r1) {
        this.e = r1;
    }

    public void setShowBorder(boolean r1) {
        this.m = r1;
        setWillNotDraw(!r1);
        invalidate();
    }

    public void setSlideListener(a r1) {
        this.j = r1;
    }

    public void setTouchEventCallback(Bundle r2) {
        this.c = (c55.b) r2.getBinder("drive_touch_state_callback");
    }

    public DriveMainRootLayout(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.b = 0;
        this.n = new Paint(1);
        this.o = d.a(6);
        this.p = false;
        this.q = new b(this, ViewConfiguration.getLongPressTimeout());
        b();
    }

    public final void c(ViewGroup r7, float r8, float r9) {
        int r1 = 0;
    L4:
        if (r1 >= r7.getChildCount()) goto L22;
        View r2 = r7.getChildAt(r1);
        if (r2.getTag(2131370304) == null) goto L19;
        if (r2.getVisibility() != 0) goto L19;
        int[] r3 = new int[2];
        r2.getLocationOnScreen(r3);
        int r4 = r3[0];
        if (r8 < r4) goto L19;
        if (r8 > (r4 + r2.getWidth())) goto L19;
        int r5 = r3[1];
        if (r9 < r5) goto L19;
        if (r9 > (r5 + r2.getHeight())) goto L19;
        this.f = true;
        this.g = r2;
    L19:
        if ((r2 instanceof ViewGroup) == false) goto L21;
        c((ViewGroup) r2, r8, r9);
    L21:
        r1 = r1 + 1;
        goto L4
    }
}
