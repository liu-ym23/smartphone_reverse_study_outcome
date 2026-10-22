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
import com.larus.nova.R;
import y9c.d;

/* JADX INFO: loaded from: classes16.dex */
public class DriveMainRootLayout extends FrameLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f224780r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f224781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f224782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c55.b f224783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f224784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View.OnClickListener f224785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f224786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f224787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f224788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f224789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f224790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f224791k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f224792l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f224793m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f224794n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f224795o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f224796p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f224797q;

    public interface a {
        boolean a(int r100);
    }

    public class b extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveMainRootLayout f224798a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            tt5.a.h("DriveMainRootLayout", "create down event");
            DriveMainRootLayout r100 = this.f224798a;
            r100.f224796p = true;
            long r101 = System.currentTimeMillis();
            MotionEvent r102 = MotionEvent.obtain(r101, r101, 0, r100.f224788h, r100.f224789i, 0);
            r100.getRootView().dispatchTouchEvent(r102);
        }

        public b(DriveMainRootLayout r100, long r101) {
            this.f224798a = r100;
            super(r101, 100);
        }
    }

    static {
        f224780r = d.a(20);
    }

    public final void b() {
        this.f224781a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f224794n.setColor(getResources().getColor(R.color.ud_N300));
        this.f224794n.setStyle(Paint.Style.STROKE);
        this.f224794n.setStrokeWidth(d.a(2));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.h("DriveMainRootLayout", "onDetachedFromWindow()");
    }

    public DriveMainRootLayout(Context r100) {
        super(r100);
        this.f224782b = 0;
        this.f224794n = new Paint(1);
        this.f224795o = d.a(6);
        this.f224796p = false;
        this.f224797q = new b(this, ViewConfiguration.getLongPressTimeout());
        b();
    }

    public final boolean a(MotionEvent r100) {
        if ((SystemClock.uptimeMillis() - this.f224784d) >= 500) goto L21;
        float r101 = this.f224788h;
        float r102 = r100.getRawX();
        float r103 = this.f224789i;
        float r104 = r100.getRawY();
        float r105 = Math.abs(r101 - r102);
        float r106 = Math.abs(r103 - r104);
        float r107 = 100;
        if (r105 <= r107) goto L7;
    L9:
        boolean r108 = false;
    L10:
        if (r108 == false) goto L21;
        if (this.f224786f == false) goto L14;
    L20:
        tt5.a.h("DriveMainRootLayout", "pointInBlockFunc()");
        goto L21
    L14:
        if (this.f224785e == null) goto L20;
        if (h.a(800) == false) goto L18;
        this.f224785e.onClick(this);
    L19:
        return true;
    L18:
        tt5.a.k("DriveMainRootLayout", "dispatchClickEvent() isValidClick=false");
        goto L19
    L7:
        if (r106 > r107) goto L9;
        r108 = true;
    L21:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        int r100 = r110.getPointerId(0);     // Catch: Throwable -> L55
        int r101 = r110.getAction();     // Catch: Throwable -> L55
        if (r101 != 0) goto L6;
        this.f224788h = r110.getRawX();     // Catch: Throwable -> L55
        this.f224789i = r110.getRawY();     // Catch: Throwable -> L55
        tt5.a.h("DriveMainRootLayout", "dispatchTouchEvent() ACTION_DOWN x=" + this.f224788h + " y=" + this.f224789i);     // Catch: Throwable -> L55
        this.f224784d = SystemClock.uptimeMillis();     // Catch: Throwable -> L55
        if (this.f224792l == false) goto L48;
        if (r100 == 0) goto L34;
        tt5.a.h("DriveMainRootLayout", "dispatchTouchEvent() inBlock pointId != 0");     // Catch: Throwable -> L55
        return false;
    L34:
        c(this, r110.getRawX(), r110.getRawY());     // Catch: Throwable -> L55
        if (this.f224786f == false) goto L42;
        boolean r111 = super.dispatchTouchEvent(r110);     // Catch: Throwable -> L55
        tt5.a.b("DriveMainRootLayout", "dispatchTouchEvent() ret=" + r111);     // Catch: Throwable -> L55
        c55.b r102 = this.f224783c;     // Catch: Throwable -> L55
        if (r102 == null) goto L40;
        if (r111 == false) goto L40;
        r102.c(r111);     // Catch: Throwable -> L55
    L40:
        return r111;
    L42:
        if (this.f224796p == false) goto L45;
        this.f224796p = false;     // Catch: Throwable -> L55
        this.f224797q.cancel();     // Catch: Throwable -> L55
        tt5.a.h("DriveMainRootLayout", "dispatchTouchEvent() long event");     // Catch: Throwable -> L55
        return false;
    L45:
        this.f224797q.start();     // Catch: Throwable -> L55
        return true;
    L48:
        if (this.f224792l == true) goto L50;
    L54:
        return super.dispatchTouchEvent(r110);
    L50:
        if (this.f224786f == true) goto L54;
        getParent().requestDisallowInterceptTouchEvent(false);     // Catch: Throwable -> L55
        this.f224797q.cancel();     // Catch: Throwable -> L55
        return false;
    L6:
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L48;
        if (r101 != 3) goto L54;
        if (this.f224792l == false) goto L14;
        this.f224797q.cancel();     // Catch: Throwable -> L55
    L14:
        this.f224786f = false;     // Catch: Throwable -> L55
        goto L54
    L16:
        if (this.f224792l == false) goto L54;
        this.f224797q.cancel();     // Catch: Throwable -> L55
        c55.b r103 = this.f224783c;     // Catch: Throwable -> L55
        if (r103 == null) goto L21;
        r103.c(false);     // Catch: Throwable -> L55
    L21:
        if (this.f224786f == false) goto L25;
        this.f224786f = false;     // Catch: Throwable -> L55
        return super.dispatchTouchEvent(r110);
    L25:
        if (a(r110) == false) goto L28;
        MotionEvent r112 = MotionEvent.obtain(r110);     // Catch: Throwable -> L55
        r112.setAction(3);     // Catch: Throwable -> L55
        return super.dispatchTouchEvent(r112);
    L28:
        return false;
    L55:
        th = move-exception;
        tt5.a.d("DriveMainRootLayout", th.getMessage());
        return false;
    }

    @Override // android.view.View
    public final void onDrawForeground(Canvas r110) {
        super.onDrawForeground(r110);
        if (this.f224793m == false) goto L6;
        float r100 = getWidth();
        float r101 = getHeight();
        int r102 = this.f224795o;
        r110.drawRoundRect(0.0f, 0.0f, r100, r101, r102, r102, this.f224794n);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        if (this.f224792l == true) goto L5;
        int r100 = (int) r110.getRawX();
        int r101 = (int) r110.getRawY();
        int r102 = r110.getAction();
        if (r102 != 0) goto L9;
        this.f224791k = false;
    L48:
        return super.onInterceptTouchEvent(r110);
    L9:
        if (r102 == 1) goto L28;
        if (r102 == 2) goto L14;
        if (r102 != 3) goto L48;
        this.f224784d = 0;
        this.f224786f = false;
        this.f224791k = false;
        this.f224782b = 0;
        goto L48
    L14:
        float r103 = this.f224788h;
        float r104 = r100;
        float r105 = r103 - r104;
        int r106 = this.f224781a;
        if (r105 <= r106) goto L18;
        this.f224782b = 4;
        goto L48
    L18:
        if ((r104 - r103) > r106) goto L20;
        float r107 = this.f224789i;
        float r108 = r101;
        if ((r107 - r108) <= r106) goto L26;
        this.f224782b = 1;
        goto L48
    L26:
        if ((r108 - r107) <= r106) goto L48;
        this.f224782b = 3;
        goto L48
    L20:
        if (f224780r < r103) goto L48;
        this.f224782b = 2;
        this.f224791k = true;
        goto L48
    L28:
        int r109 = this.f224782b;
        if (r109 == 2) goto L38;
        if (this.f224791k == true) goto L38;
        if (r109 != 3) goto L42;
        a r111 = this.f224790j;
        if (r111 == null) goto L42;
        boolean r112 = r111.a(r109);
    L43:
        this.f224791k = false;
        this.f224786f = false;
        this.f224782b = 0;
        if (r112 == false) goto L48;
        return true;
    L42:
        r112 = false;
    L38:
        if (f224780r < this.f224788h) goto L42;
        a r113 = this.f224790j;
        if (r113 == null) goto L42;
        r113.a(r109);
        goto L42
    L5:
        return super.onInterceptTouchEvent(r110);
    }

    public void setInBlock(boolean r100) {
        this.f224792l = r100;
    }

    public void setInterceptClickListener(View.OnClickListener r100) {
        this.f224785e = r100;
    }

    public void setShowBorder(boolean r100) {
        this.f224793m = r100;
        setWillNotDraw(!r100);
        invalidate();
    }

    public void setSlideListener(a r100) {
        this.f224790j = r100;
    }

    public void setTouchEventCallback(Bundle r100) {
        this.f224783c = (c55.b) r100.getBinder("drive_touch_state_callback");
    }

    public DriveMainRootLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f224782b = 0;
        this.f224794n = new Paint(1);
        this.f224795o = d.a(6);
        this.f224796p = false;
        this.f224797q = new b(this, ViewConfiguration.getLongPressTimeout());
        b();
    }

    public final void c(ViewGroup r100, float r101, float r102) {
        int r103 = 0;
    L4:
        if (r103 >= r100.getChildCount()) goto L22;
        View r104 = r100.getChildAt(r103);
        if (r104.getTag(R.id.drive_preview_block_fun_location_tag) == null) goto L19;
        if (r104.getVisibility() != 0) goto L19;
        int[] r105 = new int[2];
        r104.getLocationOnScreen(r105);
        int r106 = r105[0];
        if (r101 < r106) goto L19;
        if (r101 > (r106 + r104.getWidth())) goto L19;
        int r107 = r105[1];
        if (r102 < r107) goto L19;
        if (r102 > (r107 + r104.getHeight())) goto L19;
        this.f224786f = true;
        this.f224787g = r104;
    L19:
        if ((r104 instanceof ViewGroup) == false) goto L21;
        c((ViewGroup) r104, r101, r102);
    L21:
        r103 = r103 + 1;
        goto L4
    }
}
