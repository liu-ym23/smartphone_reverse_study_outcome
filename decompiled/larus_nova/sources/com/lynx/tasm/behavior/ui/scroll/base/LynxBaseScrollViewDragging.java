package com.lynx.tasm.behavior.ui.scroll.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes32.dex */
public class LynxBaseScrollViewDragging extends LynxBaseScrollViewScrolling implements h7a.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f382948k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f382949l;

    public class a implements com.lynx.tasm.behavior.ui.scroll.base.d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxBaseScrollViewDragging f382950a;

        public a(LynxBaseScrollViewDragging r100) {
            this.f382950a = r100;
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.base.d.c
        public final void a(boolean r100) {
            if (r100 == false) goto L5;
            this.f382950a.i(0);
            return;
        }
    }

    public class b implements com.lynx.tasm.behavior.ui.scroll.base.d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxBaseScrollViewNestedInternal f382951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxBaseScrollViewDragging f382952b;

        @Override // com.lynx.tasm.behavior.ui.scroll.base.d.c
        public final void a(boolean r100) {
            if (r100 == false) goto L8;
            LynxBaseScrollViewDragging r101 = this.f382952b;
            if (r101.f382967a.i(this.f382951a, r101.f382969c, new h7a.a(this)) == true) goto L9;
            this.f382952b.i(0);
            return;
        L9:
            return;
        }

        public b(LynxBaseScrollViewDragging r100, LynxBaseScrollViewNestedInternal r101) {
            this.f382952b = r100;
            this.f382951a = r101;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f382953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f382954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f382955c;

        public c(int r100, int r101, int r102) {
            this.f382953a = r100;
            this.f382954b = r101;
            this.f382955c = r102;
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f382956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f382957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f382958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f382959d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f382960e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public VelocityTracker f382961f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int[] f382962g;

        public d() {
            this.f382960e = -1;
            this.f382962g = new int[2];
        }
    }

    @Override // h7a.b
    public View getView() {
        return this;
    }

    public int[] k(int r100, int r101, int r102, int[] r103) {
        return new int[2];
    }

    @Override // h7a.b
    public boolean startNestedScroll(int r100, int r101) {
        return false;
    }

    public void stopNestedScroll(int r100) {
    }

    private void l() {
        VelocityTracker r100 = this.f382948k.f382961f;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        getParent().requestDisallowInterceptTouchEvent(false);
    }

    public int getNestedScrollAxis() {
        if (this.f382969c == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // h7a.b
    public final int[] b(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = getScrollOffsetVertically();
    L5:
        if (r100 == false) goto L7;
        int[] r102 = getScrollRangeVertically();
    L8:
        boolean r103 = this.f382968b;
        if (r103 == false) goto L14;
        int r104 = r102[0];
        if (r101 >= r104) goto L13;
        int r105 = r101 - 50;
    L16:
        if (r103 == false) goto L21;
        int r106 = r102[1];
        if (r101 <= r106) goto L20;
        int r107 = r101 + 50;
    L23:
        return new int[]{r105, r107};
    L20:
        r107 = r106 + 300;
        goto L23
    L21:
        r107 = r102[1];
        goto L23
    L13:
        r105 = r104 - 300;
        goto L16
    L14:
        r105 = r102[0];
        goto L16
    L7:
        r102 = getScrollRangeHorizontally();
        goto L8
    L4:
        r101 = getScrollOffsetHorizontally();
        goto L5
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        d r101 = this.f382948k;
        if (r101.f382961f != null) goto L5;
        r101.f382961f = VelocityTracker.obtain();
    L5:
        this.f382948k.f382961f.addMovement(r100);
        int r102 = r100.getActionMasked();
        if (r102 == 0) goto L51;
        if (r102 == 1) goto L50;
        if (r102 == 2) goto L23;
        if (r102 != 3) goto L11;
        l();
        i(0);
    L57:
        if (this.f382974h != 1) goto L60;
        return true;
    L60:
        return false;
    L11:
        if (r102 != 5) goto L13;
        d r103 = this.f382948k;
        r103.f382960e = r100.getPointerId(0);
        d r104 = this.f382948k;
        int r105 = (int) (r100.getX() + 0.5f);
        r104.f382958c = r105;
        r104.f382956a = r105;
        d r106 = this.f382948k;
        int r107 = (int) (r100.getY() + 0.5f);
        r106.f382959d = r107;
        r106.f382957b = r107;
        goto L57
    L13:
        if (r102 != 6) goto L57;
        int r108 = r100.getActionIndex();
        int r109 = r100.getPointerId(r108);
        d r110 = this.f382948k;
        if (r109 != r110.f382960e) goto L57;
        if (r108 != 0) goto L19;
        int r111 = 1;
    L20:
        r110.f382960e = r100.getPointerId(r111);
        d r112 = this.f382948k;
        int r113 = (int) (r100.getX(r111) + 0.5f);
        r112.f382958c = r113;
        r112.f382956a = r113;
        d r114 = this.f382948k;
        int r115 = (int) (r100.getY(r111) + 0.5f);
        r114.f382959d = r115;
        r114.f382957b = r115;
        goto L57
    L19:
        r111 = 0;
        goto L20
    L23:
        int r116 = this.f382948k.f382960e;
        if (r116 == (-1)) goto L57;
        int r117 = r100.findPointerIndex(r116);
        if (r117 >= 0) goto L29;
        return false;
    L29:
        int r118 = (int) (r100.getX(r117) + 0.5f);
        int r119 = (int) (r100.getY(r117) + 0.5f);
        if (this.f382974h == 1) goto L57;
        d r120 = this.f382948k;
        int r121 = r118 - r120.f382956a;
        int r122 = r119 - r120.f382957b;
        if (this.f382969c == true) goto L34;
    L38:
        boolean r123 = false;
    L40:
        if (this.f382969c == false) goto L42;
    L46:
        boolean r124 = false;
    L47:
        if (r123 == true) goto L49;
        if (r124 == false) goto L57;
    L49:
        d r125 = this.f382948k;
        r125.f382958c = r118;
        r125.f382959d = r119;
        i(1);
        goto L57
    L42:
        if (Math.abs(r121) <= this.f382949l.f382953a) goto L46;
        if ((getNestedScrollAxes() & 1) != 0) goto L46;
        r124 = true;
        goto L47
    L34:
        if (Math.abs(r122) <= this.f382949l.f382953a) goto L38;
        if ((getNestedScrollAxes() & 2) != 0) goto L38;
        r123 = true;
        goto L40
    L50:
        this.f382948k.f382961f.clear();
        stopNestedScroll(0);
        goto L57
    L51:
        d r126 = this.f382948k;
        r126.f382960e = r100.getPointerId(0);
        d r127 = this.f382948k;
        int r128 = (int) (r100.getX() + 0.5f);
        r127.f382958c = r128;
        r127.f382956a = r128;
        d r129 = this.f382948k;
        int r130 = (int) (r100.getY() + 0.5f);
        r129.f382959d = r130;
        r129.f382957b = r130;
        int r131 = this.f382974h;
        if (r131 == 3) goto L54;
        if (r131 == 2) goto L54;
    L55:
        startNestedScroll(getNestedScrollAxis(), 0);
    L54:
        getParent().requestDisallowInterceptTouchEvent(true);
        i(1);
        goto L55
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        d r100 = this.f382948k;
        if (r100.f382961f != null) goto L5;
        r100.f382961f = VelocityTracker.obtain();
    L5:
        int r101 = r110.getActionMasked();
        boolean r102 = false;
        if (r101 != 0) goto L8;
        int[] r103 = this.f382948k.f382962g;
        r103[1] = 0;
        r103[0] = 0;
        this.f382967a.g(false);
        startNestedScroll(getNestedScrollAxis(), 0);
    L8:
        MotionEvent r104 = MotionEvent.obtain(r110);
        int[] r105 = this.f382948k.f382962g;
        r104.offsetLocation(r105[0], r105[1]);
        if (r101 != 0) goto L11;
        this.f382948k.f382960e = r110.getPointerId(0);
        d r106 = this.f382948k;
        int r107 = (int) (r110.getX() + 0.5f);
        r106.f382958c = r107;
        r106.f382956a = r107;
        d r108 = this.f382948k;
        int r111 = (int) (r110.getY() + 0.5f);
        r108.f382959d = r111;
        r108.f382957b = r111;
    L98:
        if (r102 == true) goto L100;
        this.f382948k.f382961f.addMovement(r104);
    L100:
        r104.recycle();
        return true;
    L11:
        if (r101 != 1) goto L13;
        this.f382948k.f382961f.addMovement(r104);
        this.f382948k.f382961f.computeCurrentVelocity(1000, this.f382949l.f382955c);
        float r109 = 0.0f;
        if (this.f382969c == true) goto L76;
        d r112 = this.f382948k;
        float r113 = -r112.f382961f.getXVelocity(r112.f382960e);
    L78:
        if (this.f382969c == false) goto L81;
        d r114 = this.f382948k;
        r109 = -r114.f382961f.getYVelocity(r114.f382960e);
    L81:
        if (Math.abs(r113) >= 600.0f) goto L83;
        boolean r115 = true;
    L85:
        if ((r115 & (!this.f382969c)) == true) goto L93;
        if (Math.abs(r109) < 600.0f) goto L89;
    L91:
        this.f382967a.e((int) r113, (int) r109, new b(this, (LynxBaseScrollViewNestedInternal) this));
        i(3);
    L96:
        l();
        r102 = true;
        goto L98
    L89:
        if (this.f382969c == false) goto L91;
    L93:
        if (this.f382967a.i((LynxBaseScrollViewNestedInternal) this, this.f382969c, new a(this)) == false) goto L95;
        i(3);
        goto L96
    L95:
        i(0);
        goto L96
    L83:
        r115 = false;
        goto L85
    L76:
        r113 = 0.0f;
        goto L78
    L13:
        if (r101 == 2) goto L28;
        if (r101 != 3) goto L16;
        l();
        i(0);
        goto L98
    L16:
        if (r101 != 5) goto L18;
        int r116 = r110.getActionIndex();
        this.f382948k.f382960e = r110.getPointerId(r116);
        d r117 = this.f382948k;
        int r118 = (int) (r110.getX(r116) + 0.5f);
        r117.f382958c = r118;
        r117.f382956a = r118;
        d r119 = this.f382948k;
        int r120 = (int) (r110.getY(r116) + 0.5f);
        r119.f382959d = r120;
        r119.f382957b = r120;
        goto L98
    L18:
        if (r101 != 6) goto L98;
        int r121 = r110.getActionIndex();
        int r122 = r110.getPointerId(r121);
        d r123 = this.f382948k;
        if (r122 != r123.f382960e) goto L98;
        if (r121 != 0) goto L24;
        int r124 = 1;
    L25:
        r123.f382960e = r110.getPointerId(r124);
        d r125 = this.f382948k;
        int r126 = (int) (r110.getX(r124) + 0.5f);
        r125.f382958c = r126;
        r125.f382956a = r126;
        d r127 = this.f382948k;
        int r128 = (int) (r110.getY(r124) + 0.5f);
        r127.f382959d = r128;
        r127.f382957b = r128;
        goto L98
    L24:
        r124 = 0;
        goto L25
    L28:
        int r129 = this.f382948k.f382960e;
        if (r129 == (-1)) goto L98;
        int r130 = r110.findPointerIndex(r129);
        if (r130 >= 0) goto L34;
        return false;
    L34:
        int r131 = (int) (r110.getX(r130) + 0.5f);
        int r132 = (int) (r110.getY(r130) + 0.5f);
        d r133 = this.f382948k;
        int r134 = r133.f382958c - r131;
        int r135 = r133.f382959d - r132;
        if (this.f382974h != 1) goto L37;
        boolean r136 = true;
    L38:
        if (r136 == false) goto L40;
    L54:
        if (r136 == false) goto L98;
        if (getParent() == null) goto L58;
        getParent().requestDisallowInterceptTouchEvent(true);
    L58:
        i(1);
        int[] r137 = {0, 0};
        boolean r138 = this.f382969c;
        if (r138 == false) goto L61;
        int r139 = 0;
    L62:
        if (r138 == false) goto L64;
        int r140 = r135;
    L65:
        int[] r141 = k(r139, r140, 0, r137);
        r104.offsetLocation(r137[0], r137[1]);
        d r142 = this.f382948k;
        int r143 = r137[0];
        r142.f382958c = r131 - r143;
        int r144 = r137[1];
        r142.f382959d = r132 - r144;
        int[] r145 = r142.f382962g;
        r145[0] = r145[0] + r143;
        r145[1] = r145[1] + r144;
        boolean r146 = this.f382969c;
        if (r146 == true) goto L68;
    L69:
        if (r146 == true) goto L98;
        if (r141[0] == r134) goto L98;
    L72:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L98
    L68:
        if (r141[1] != r135) goto L72;
    L64:
        r140 = 0;
        goto L65
    L61:
        r139 = r134;
        goto L62
    L40:
        if (this.f382969c == false) goto L47;
        int r147 = Math.abs(r135);
        int r148 = this.f382949l.f382953a;
        if (r147 <= r148) goto L47;
        if (r135 <= 0) goto L45;
        r135 = r135 - r148;
    L53:
        r136 = true;
        goto L54
    L45:
        r135 = r135 + r148;
    L47:
        if (this.f382969c == true) goto L54;
        int r149 = Math.abs(r134);
        int r150 = this.f382949l.f382953a;
        if (r149 <= r150) goto L54;
        if (r134 <= 0) goto L52;
        r134 = r134 - r150;
        goto L53
    L52:
        r134 = r134 + r150;
        goto L53
    L37:
        r136 = false;
        goto L38
    }

    @Override // h7a.b
    public final boolean a(int r100, int[] r101) {
        if (r100 > r101[1]) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // h7a.b
    public final boolean c(int r100, int[] r101) {
        if (r100 >= r101[0]) goto L6;
        return true;
    L6:
        return false;
    }

    public LynxBaseScrollViewDragging(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f382948k = new d();
        ViewConfiguration r103 = ViewConfiguration.get(getContext());
        this.f382949l = new c(r103.getScaledWindowTouchSlop(), r103.getScaledMinimumFlingVelocity(), r103.getScaledMaximumFlingVelocity());
    }
}
