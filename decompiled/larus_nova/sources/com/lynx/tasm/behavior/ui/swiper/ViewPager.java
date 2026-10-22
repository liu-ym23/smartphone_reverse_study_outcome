package com.lynx.tasm.behavior.ui.swiper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public class ViewPager extends ViewGroup {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public final int G;
    public float H;
    public boolean H0;
    public float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f383003J;
    public float K;
    public b L;
    public boolean L0;
    public int M;
    public int N;
    public int O;
    public int P;
    public int P0;
    public int Q;
    public int R;
    public int S;
    public int T;
    public final List<d> U;
    public boolean V;
    public float V0;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f383004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f383005b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public float f383006b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f383007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f383008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f383009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f383010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f383011g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f383012g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f383013h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final GestureDetector f383014h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Scroller f383015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f383016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f383017k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f383018k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f383019l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f383020m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f383021n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f383022o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f383023p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f383024p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f383025q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f383026r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f383027s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f383028t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f383029u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f383030v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public e f383031w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f383032x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f383033y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f383034z;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager f383035a;

        public a(ViewPager r100) {
            this.f383035a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            this.f383035a.f383015i.abortAnimation();
            ViewPager r101 = this.f383035a;
            r101.F = 0;
            r101.D = true;
            r101.A = false;
            float r102 = r100.getX();
            r101.f383003J = r102;
            r101.H = r102;
            ViewPager r103 = this.f383035a;
            float r104 = r100.getY();
            r103.K = r104;
            r103.I = r104;
            ViewPager r105 = this.f383035a;
            r105.E = r100.getPointerId(r100.getActionIndex());
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            boolean r104 = super.onFling(r100, r101, r102, r103);
            if (this.f383035a.m() == false) goto L9;
            int r105 = this.f383035a.f383033y;
            if (r103 < (-r105)) goto L9;
            if (r103 > r105) goto L9;
        L14:
            return r104;
        L9:
            if (this.f383035a.m() == true) goto L15;
            int r106 = this.f383035a.f383032x;
            if (r102 < (-r106)) goto L15;
            if (r102 <= r106) goto L14;
        L15:
            ViewPager r107 = this.f383035a;
            r107.A = true;
            r107.f383015i.abortAnimation();
            ViewPager.a(this.f383035a, r102, r103);
            return super.onFling(r100, r101, r102, r103);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            ViewPager r104 = this.f383035a;
            if (r104.B == false) goto L5;
        L22:
            ViewPager r105 = this.f383035a;
            if (r105.B == false) goto L36;
            int r106 = r101.findPointerIndex(r105.E);
            float r107 = r101.getX(r106);
            float r108 = r101.getY(r106);
            ViewPager r109 = this.f383035a;
            float r110 = r109.H - r107;
            float r111 = r109.I - r108;
            float r112 = r109.F;
            if (r109.m() == false) goto L27;
            float r113 = r111;
        L28:
            r109.F = (int) (r112 + r113);
            ViewPager r114 = this.f383035a;
            r114.H = r107;
            r114.I = r108;
            if (r114.D == false) goto L32;
            r114.w();
            this.f383035a.D = false;
        L32:
            if (this.f383035a.m() == false) goto L34;
            this.f383035a.scrollBy(0, (int) (((double) r111) + 0.5d));
            goto L36
        L34:
            this.f383035a.scrollBy((int) (((double) r110) + 0.5d), 0);
            goto L36
        L27:
            r113 = r110;
        L36:
            return this.f383035a.B;
        L5:
            if (r101.findPointerIndex(r104.E) == (-1)) goto L7;
            float r115 = Math.abs(r102);
            float r116 = Math.abs(r103);
            if (this.f383035a.m() == false) goto L15;
            if (r116 <= r115) goto L15;
            if (this.f383035a.e((int) r103) == false) goto L15;
        L20:
            ViewPager r117 = this.f383035a;
            r117.B = true;
            ViewPager.b(r117);
            this.f383035a.r(true);
        L15:
            if (this.f383035a.m() == false) goto L17;
        L21:
            this.f383035a.r(false);
            goto L22
        L17:
            if (r115 <= r116) goto L21;
            if (this.f383035a.d((int) r102) == false) goto L21;
        L7:
            return super.onScroll(r100, r101, r102, r103);
        }
    }

    public interface b {
    }

    public static class c extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f383036a;

        public c() {
            super(-1, -1);
        }
    }

    public interface d {
        void a(boolean r100, boolean r101);

        void b(boolean r100, float r101, float r102);

        void c(int r100, boolean r101);

        void d(int r100);

        void e(int r100, boolean r101);

        void onPageScrollStateChanged(int r100);
    }

    public interface e {
        void a(View r100);

        void b(ViewPager r100, View r101, boolean r102, int r103);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        setScrollState(0);
        Scroller r100 = this.f383015i;
        if (r100 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r100.isFinished() == true) goto L7;
        this.f383015i.abortAnimation();
        goto L7
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f383015i.computeScrollOffset() == false) goto L18;
        if (m() == false) goto L7;
        int r100 = this.f383015i.getFinalY();
    L8:
        this.f383012g1 = r100;
        int r101 = getScrollX();
        int r102 = getScrollY();
        int r103 = this.f383015i.getCurrX();
        int r104 = this.f383015i.getCurrY();
        if (m() == false) goto L13;
        if (r102 == r104) goto L13;
        scrollTo(r101, r104);
    L16:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L13:
        if (m() == true) goto L16;
        if (r101 == r103) goto L16;
        scrollTo(r103, r102);
        goto L16
    L7:
        r100 = this.f383015i.getFinalX();
        goto L8
    L18:
        if (getChildCount() > 0) goto L20;
        return;
    L20:
        if (this.f383030v == 1) goto L52;
        int r105 = ((c) getCurrentView().getLayoutParams()).f383036a;
        this.f383010f = r105;
        if (this.f383011g == r105) goto L28;
        Iterator r106 = ((ArrayList) this.U).iterator();
    L25:
        if (r106.hasNext() == false) goto L28;
        ((d) r106.next()).e(this.f383010f, this.f383017k);
    L28:
        if (this.f383026r == false) goto L33;
        if (this.f383027s == false) goto L33;
        this.f383021n = false;
        this.f383027s = false;
        requestLayout();
    L33:
        if (this.f383017k == true) goto L42;
        if (this.f383016j == false) goto L42;
        Iterator r107 = ((ArrayList) this.U).iterator();
    L38:
        if (r107.hasNext() == false) goto L40;
        ((d) r107.next()).d(this.f383010f);
        goto L38
    L40:
        this.f383016j = false;
    L42:
        if (this.f383011g == (-1)) goto L44;
    L46:
        this.f383011g = this.f383010f;
        setScrollState(0);
        return;
    L44:
        if (this.f383010f == (-1)) goto L46;
        this.f383017k = false;
        goto L46
    }

    public final void f() {
        if (this.L != null) goto L5;
        return;
    L5:
        if (this.f383009e <= 0) goto L34;
        boolean r100 = false;
        if (this.f383005b == false) goto L9;
    L14:
        boolean r101 = true;
    L16:
        if (this.H0 == false) goto L19;
        if (r101 == true) goto L19;
        return;
    L19:
        u(this.N, r101);
        int r102 = this.f383013h;
        if (r102 != (-1)) goto L22;
    L24:
        r102 = this.f383010f;
        if (r102 != (-1)) goto L28;
        r102 = -1;
    L28:
        if (r102 >= 0) goto L30;
        return;
    L30:
        if (r102 >= this.f383009e) goto L36;
        t(r102, r100, 1);
        return;
    L36:
        return;
    L22:
        if (r102 == this.f383010f) goto L24;
        r100 = this.f383004a;
        goto L28
    L9:
        if (this.f383007c == true) goto L14;
        if (this.f383008d == true) goto L14;
        r101 = false;
        goto L16
    }

    public final boolean g() {
        if (this.V == true) goto L5;
    L28:
        return false;
    L5:
        if (this.f383021n == true) goto L28;
        if (this.f383017k == true) goto L28;
        float r100 = this.V0;
        if (r100 <= 0.0f) goto L28;
        if (r100 >= 1.0f) goto L28;
        if (this.L == null) goto L28;
        if (this.f383006b1 >= 0.0f) goto L20;
        if (this.f383009e < 2) goto L28;
    L22:
        if (this.f383008d == true) goto L28;
        if (this.f383005b == true) goto L28;
        if (this.f383007c == true) goto L28;
        return true;
    L20:
        if (this.f383009e < 3) goto L28;
        goto L28
    }

    public int getChildExpectSize() {
        int r100 = this.M;
        if (r100 <= 0) goto L6;
        return r100;
    L6:
        return getContentSize();
    }

    public final boolean h() {
        if (this.V == true) goto L5;
    L28:
        return false;
    L5:
        if (this.f383021n == true) goto L28;
        if (this.f383017k == true) goto L28;
        float r100 = this.f383006b1;
        if (r100 <= 0.0f) goto L28;
        if (r100 >= 1.0f) goto L28;
        if (this.L == null) goto L28;
        if (this.V0 >= 0.0f) goto L20;
        if (this.f383009e < 2) goto L28;
    L22:
        if (this.f383008d == true) goto L28;
        if (this.f383005b == true) goto L28;
        if (this.f383007c == true) goto L28;
        return true;
    L20:
        if (this.f383009e < 3) goto L28;
        goto L28
    }

    public final boolean l() {
        if (this.f383022o == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f383029u != 0) goto L7;
        return true;
    }

    public final boolean m() {
        if (this.f383029u == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void q() {
        if (this.f383009e >= 1) goto L5;
        return;
    L5:
        int r100 = getChildExpectSize();
        if (r100 > 0) goto L8;
        return;
    L8:
        int r101 = getScrollDistance();
        int r102 = this.R + r100;
        if (r102 > 0) goto L11;
        return;
    L11:
        int r103 = r101 / r102;
        int r104 = r101 % r102;
        if (l() == false) goto L39;
        if (this.f383021n == false) goto L28;
        if (r101 <= 0) goto L24;
        if (r104 == 0) goto L18;
        r103 = r103 + 1;
    L19:
        int r105 = (getWidth() + r101) - r104;
        if (r104 != 0) goto L22;
        int r106 = 0;
    L23:
        int r107 = r105 + r106;
    L25:
        int r108 = this.f383009e;
        int r109 = (r108 - r103) % r108;
        if (r109 >= 0) goto L37;
        r109 = r109 + r108;
    L37:
        int r110 = r107;
        int r111 = 0;
    L59:
        int r112 = Math.max(0, getPageGap()) + r101;
        ArrayList r113 = new ArrayList();
        if (this.f383023p == true) goto L81;
        List<View> r114 = getAllChildren();
    L62:
        View r115 = k(r109);
        r114.remove(r115);
        if (l() == false) goto L65;
        r111 = r110 - r100;
    L66:
        p(r115, r111, r110);
        v();
        if (l() == false) goto L71;
        if (r111 <= r101) goto L78;
        r110 = r111 - this.R;
    L74:
        int r116 = r109 + 1;
        int r117 = this.f383009e;
        if (r116 < r117) goto L79;
        if (this.f383021n == false) goto L78;
    L79:
        r109 = r116 % r117;
    L78:
        List r118 = r114;
    L135:
        Iterator r119 = r118.iterator();
    L137:
        if (r119.hasNext() == false) goto L143;
        View r120 = (View) r119.next();
        boolean r121 = this.f383023p;
        e r122 = this.f383031w;
        if (r122 == null) goto L141;
        r122.a(r120);
    L141:
        if (r121 == true) goto L137;
        removeView(r120);
        int r123 = ((c) r120.getLayoutParams()).f383036a;
        this.L.getClass();
        goto L137
    L143:
        return;
    L71:
        if (r110 >= r112) goto L78;
        r111 = this.R + r110;
        goto L74
    L65:
        r110 = r111 + r100;
        goto L66
    L81:
        if (this.f383021n == true) goto L116;
        int r124 = r109 - 1;
        int r125 = r111;
        int r126 = r110;
    L83:
        if (r124 < 0) goto L99;
        View r127 = k(r124);
        if (l() == false) goto L87;
        int r128 = r126 + this.R;
        int r129 = r128 + r100;
    L88:
        int r130 = r128;
        r126 = r129;
        r125 = r130;
        if (l() == false) goto L93;
        if ((r125 - this.R) < r112) goto L93;
    L96:
        r113.add(r127);
    L97:
        p(r127, r125, r126);
        r124 = r124 - 1;
    L93:
        if (l() == true) goto L97;
        if ((this.R + r126) > r101) goto L97;
    L87:
        r129 = r125 - this.R;
        r128 = r129 - r100;
    L99:
        if (r109 >= this.f383009e) goto L134;
        View r131 = k(r109);
        if (l() == false) goto L103;
        r111 = r110 - r100;
    L105:
        if (l() == false) goto L108;
        if (r110 > r101) goto L108;
    L110:
        r113.add(r131);
    L111:
        p(r131, r111, r110);
        if (l() == false) goto L114;
        r110 = r111 - this.R;
    L115:
        r109 = r109 + 1;
        goto L99
    L114:
        r111 = this.R + r110;
    L108:
        if (l() == true) goto L111;
        if (r111 < r112) goto L111;
    L103:
        r110 = r111 + r100;
    L134:
        v();
        r118 = r113;
        goto L135
    L116:
        int r132 = r109;
    L117:
        View r133 = k(r132);
        if (l() == false) goto L120;
        r111 = r110 - r100;
    L122:
        if (l() == false) goto L125;
        if (r110 > r101) goto L125;
    L127:
        r113.add(r133);
    L128:
        p(r133, r111, r110);
        if (l() == false) goto L131;
        r110 = r111 - this.R;
    L132:
        r132 = (r132 + 1) % this.f383009e;
        if (r132 != r109) goto L117;
    L131:
        r111 = this.R + r110;
    L125:
        if (l() == true) goto L128;
        if (r111 < r112) goto L128;
    L120:
        r110 = r111 + r100;
        goto L122
    L22:
        r106 = this.R + r100;
        goto L23
    L18:
        r103 = r103 % this.f383009e;
        goto L19
    L24:
        r107 = (getWidth() + r101) - r104;
        goto L25
    L28:
        int r134 = getPaddingRight() - this.N;
        int r135 = 0;
    L30:
        if (r135 >= (this.f383009e - 1)) goto L35;
        int r136 = r135 + 1;
        if (r101 < (((this.T - r134) + getWidth()) - (r136 * r102))) goto L36;
        r135 = r136;
    L36:
        r107 = ((this.T - r134) + getWidth()) - (r102 * r135);
        r109 = r135;
        goto L37
    L35:
        r135 = 0;
        goto L36
    L39:
        if (this.f383021n == false) goto L49;
        if (r101 >= 0) goto L48;
        if (r104 == 0) goto L43;
        r103 = r103 - 1;
    L43:
        int r137 = this.f383009e;
        r109 = ((r103 % r137) + r137) % r137;
        if (r104 != 0) goto L46;
        int r138 = -this.R;
    L47:
        r111 = ((r101 - r138) - r104) - this.R;
    L58:
        r110 = 0;
        goto L59
    L46:
        r138 = r100;
        goto L47
    L48:
        r109 = r103 % this.f383009e;
        r111 = r101 - r104;
        goto L58
    L49:
        int r139 = getPaddingLeft() + this.N;
        r109 = 0;
    L51:
        if (r109 >= this.f383009e) goto L56;
        int r140 = r109 + 1;
        if (r101 < ((this.S + r139) + (r140 * r102))) goto L57;
        r109 = r140;
    L57:
        r111 = (this.S + r139) + (r102 * r109);
        goto L58
    L56:
        r109 = 0;
        goto L57
    }

    public final void v() {
        if (this.f383031w == null) goto L30;
        int r100 = getChildCount() - 1;
    L5:
        if (r100 <= (-1)) goto L36;
        View r101 = getChildAt(r100);
        boolean r102 = true;
        if (g() == true) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L29;
        if (h() == true) goto L16;
    L18:
        r102 = false;
    L19:
        if (r102 == true) goto L29;
        if (r101 == null) goto L29;
        if (l() == false) goto L25;
        int r104 = (r101.getLeft() - getScrollX()) + getOffset();
        int r105 = getPaddingLeft();
    L28:
        this.f383031w.b(this, r101, m(), r104 - r105);
        goto L29
    L25:
        if (m() == false) goto L27;
        r104 = (r101.getTop() - getScrollY()) - getOffset();
        r105 = getPaddingTop();
        goto L28
    L27:
        r104 = (r101.getLeft() - getScrollX()) - getOffset();
        r105 = getPaddingLeft();
        goto L28
    L16:
        if (((c) r101.getLayoutParams()).f383036a != (this.f383009e - 1)) goto L18;
    L29:
        r100 = r100 - 1;
        goto L5
    L9:
        if (((c) r101.getLayoutParams()).f383036a != 0) goto L11;
        r103 = true;
        goto L12
    L36:
        return;
    }

    public final void w() {
        if (this.f383017k == false) goto L5;
        return;
    L5:
        if (this.f383016j == false) goto L7;
        return;
    L7:
        if (this.f383019l == true) goto L9;
    L11:
        boolean r100 = false;
    L12:
        Iterator r101 = ((ArrayList) this.U).iterator();
    L14:
        if (r101.hasNext() == false) goto L16;
        ((d) r101.next()).c(this.f383010f, r100);
        goto L14
    L16:
        this.f383016j = true;
        return;
    L9:
        if (this.f383030v != 1) goto L11;
        r100 = true;
        goto L12
    }

    private List<View> getAllChildren() {
        int r100 = getChildCount();
        LinkedList r101 = new LinkedList();
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101.add(getChildAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    private int getContentHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getContentSize() {
        if (m() == false) goto L6;
        return getContentHeight();
    L6:
        return getContentWidth();
    }

    private int getContentWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private View getCurrentView() {
        int r100 = getPile() + (getChildExpectSize() / 2);
        int r101 = getScrollDistance();
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L18;
        View r104 = getChildAt(r103);
        int r105 = j(r104) - r101;
        if (m() == false) goto L7;
        int r106 = r104.getBottom();
    L8:
        int r107 = r106 - r101;
        int r108 = this.F;
        if (r108 <= 0) goto L11;
        r107 = r107 + this.R;
    L13:
        if (r105 > r100) goto L16;
        if (r107 < r100) goto L16;
        return r104;
    L16:
        r103 = r103 + 1;
        goto L3
    L11:
        if (r108 >= 0) goto L13;
        r105 = r105 - this.R;
        goto L13
    L7:
        r106 = r104.getRight();
        goto L8
    L18:
        return getChildAt(0);
    }

    private int getPageGap() {
        if (m() == false) goto L7;
        int r100 = getHeight() - getPaddingBottom();
        int r101 = this.R;
    L6:
        return r100 - r101;
    L7:
        r100 = getWidth() - getPaddingRight();
        r101 = this.R;
        goto L6
    }

    private int getPile() {
        if (m() == false) goto L7;
        return getPaddingTop() + getOffset();
    L7:
        if (l() == false) goto L11;
        return ((getPaddingLeft() + getOffset()) + getWidth()) - getChildExpectSize();
    L11:
        return getPaddingLeft() + getOffset();
    }

    private int getScrollDistance() {
        if (m() == false) goto L6;
        return getScrollY();
    L6:
        return getScrollX();
    }

    public final void s() {
        boolean r100 = true;
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        View r101 = getCurrentView();
        int r102 = getScrollDistance();
        int r103 = j(r101) - r102;
        if (m() == false) goto L8;
        int r104 = r101.getBottom();
    L9:
        int r105 = r104 - r102;
        if (g() == true) goto L12;
    L14:
        boolean r106 = false;
    L16:
        if (r106 == false) goto L25;
        int r107 = getPile();
        if (m() == false) goto L21;
        this.f383015i.startScroll(0, r102, 0, (r105 + this.R) - r107, this.P0);
    L42:
        setScrollState(2);
        invalidate();
        return;
    L21:
        if (this.f383022o == false) goto L23;
        int r108 = getPile() + getChildExpectSize();
        this.f383015i.startScroll(r102, 0, (r103 - this.R) - r108, 0, this.P0);
        goto L42
    L23:
        this.f383015i.startScroll(r102, 0, (r105 + this.R) - r107, 0, this.P0);
        goto L42
    L25:
        if (h() == true) goto L27;
    L29:
        r100 = false;
    L30:
        if (r100 == false) goto L38;
        int r109 = getPile() + getChildExpectSize();
        if (m() == false) goto L35;
        this.f383015i.startScroll(0, r102, 0, (r103 - this.R) - r109, this.P0);
        goto L42
    L35:
        if (this.f383022o == false) goto L37;
        int r110 = getPile();
        this.f383015i.startScroll(r102, 0, (r105 + this.R) - r110, 0, this.P0);
        goto L42
    L37:
        this.f383015i.startScroll(r102, 0, (r103 - this.R) - r109, 0, this.P0);
        goto L42
    L38:
        int r111 = getPile() + (getChildExpectSize() / 2);
        int r112 = (r103 + r105) / 2;
        if (m() == false) goto L41;
        this.f383015i.startScroll(0, r102, 0, r112 - r111, this.f383028t);
        goto L42
    L41:
        this.f383015i.startScroll(r102, 0, r112 - r111, 0, this.f383028t);
        goto L42
    L27:
        if (((c) r101.getLayoutParams()).f383036a != (this.f383009e - 1)) goto L29;
    L12:
        if (((c) r101.getLayoutParams()).f383036a != 0) goto L14;
        r106 = true;
        goto L16
    L8:
        r104 = r101.getRight();
        goto L9
    }

    public b getAdapter() {
        return this.L;
    }

    public int getCurrentIndex() {
        return this.f383010f;
    }

    public int getOffset() {
        return this.N;
    }

    public int getTotalCount() {
        return this.f383009e;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
    }

    public ViewPager(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ void b(ViewPager r100) {
        r100.setScrollState(1);
    }

    private void setScrollState(int r100) {
        if (this.f383030v != r100) goto L5;
        return;
    L5:
        Iterator r101 = ((ArrayList) this.U).iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((d) r101.next()).onPageScrollStateChanged(r100);
        goto L7
    L9:
        this.f383030v = r100;
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f383019l == false) goto L7;
        if (d(r100) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.f383025q == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f383019l == false) goto L7;
        if (e(r100) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.f383025q == true) goto L8;
        return false;
    }

    public final boolean d(int r100) {
        if (m() == false) goto L5;
        return false;
    L5:
        if (this.L == null) goto L29;
        int r101 = this.f383009e;
        if (r101 <= 1) goto L30;
        int r102 = this.f383010f;
        if (r102 != (-1)) goto L11;
        return false;
    L11:
        if (this.f383021n == true) goto L26;
        if (r100 > 0) goto L14;
    L19:
        if (r100 < 0) goto L21;
        return false;
    L21:
        if (this.f383022o == true) goto L23;
        if (r102 > 0) goto L26;
        return false;
    L23:
        if (r102 < (r101 - 1)) goto L26;
        return false;
    L14:
        if (this.f383022o == false) goto L18;
        if (r102 <= 0) goto L19;
    L18:
        if (r102 >= (r101 - 1)) goto L19;
    L26:
        return true;
    L30:
        return false;
    L29:
        return false;
    }

    public final boolean e(int r100) {
        if (m() == true) goto L5;
        return false;
    L5:
        if (this.L == null) goto L20;
        int r101 = this.f383009e;
        if (r101 <= 1) goto L21;
        int r102 = this.f383010f;
        if (r102 != (-1)) goto L11;
        return false;
    L11:
        if (this.f383021n == true) goto L17;
        if (r100 > 0) goto L14;
    L15:
        if (r100 >= 0) goto L23;
        if (r102 > 0) goto L17;
        return false;
    L23:
        return false;
    L14:
        if (r102 >= (r101 - 1)) goto L15;
    L17:
        return true;
    L21:
        return false;
    L20:
        return false;
    }

    public final int j(View r100) {
        if (m() == false) goto L6;
        return r100.getTop();
    L6:
        return r100.getLeft();
    }

    public final View k(int r100) {
        int r101 = getChildCount() - 1;
    L4:
        if (r101 <= (-1)) goto L9;
        View r102 = getChildAt(r101);
        if (((c) r102.getLayoutParams()).f383036a == r100) goto L7;
        r101 = r101 - 1;
        goto L4
    L7:
        return r102;
    L9:
        View r103 = (View) ListProtector.get(((com.lynx.tasm.behavior.ui.swiper.e) this.L).f383074a.D, r100);
        c r104 = new c();
        r104.f383036a = r100;
        addViewInLayout(r103, 0, r104, true);
        n(r103);
        return r103;
    }

    public final void n(View r110) {
        if (m() == false) goto L14;
        c r100 = (c) r110.getLayoutParams();
        int r101 = ((ViewGroup.LayoutParams) r100).width;
        if (r101 < 0) goto L7;
        int r102 = View.MeasureSpec.makeMeasureSpec(r101, 1073741824);
    L13:
        int r103 = View.MeasureSpec.makeMeasureSpec(getChildExpectSize(), 1073741824);
    L23:
        r110.measure(r102, r103);
        return;
    L7:
        int r104 = Math.max(0, (getWidth() - getPaddingLeft()) - getPaddingRight());
        int r105 = ((ViewGroup.LayoutParams) r100).width;
        if (r105 != (-1)) goto L10;
        r102 = View.MeasureSpec.makeMeasureSpec(r104, 1073741824);
        goto L13
    L10:
        if (r105 != (-2)) goto L12;
        r102 = View.MeasureSpec.makeMeasureSpec(r104, Integer.MIN_VALUE);
        goto L13
    L12:
        r102 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        goto L13
    L14:
        r102 = View.MeasureSpec.makeMeasureSpec(getChildExpectSize(), 1073741824);
        c r106 = (c) r110.getLayoutParams();
        int r107 = ((ViewGroup.LayoutParams) r106).height;
        if (r107 < 0) goto L17;
        r103 = View.MeasureSpec.makeMeasureSpec(r107, 1073741824);
        goto L23
    L17:
        int r108 = Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom());
        int r109 = ((ViewGroup.LayoutParams) r106).height;
        if (r109 != (-1)) goto L20;
        r103 = View.MeasureSpec.makeMeasureSpec(r108, 1073741824);
        goto L23
    L20:
        if (r109 != (-2)) goto L22;
        r103 = View.MeasureSpec.makeMeasureSpec(r108, Integer.MIN_VALUE);
        goto L23
    L22:
        r103 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        goto L23
    }

    public final void o(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.E) goto L9;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.H = r100.getX(r102);
        this.I = r100.getY(r102);
        this.E = r100.getPointerId(r102);
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        if (this.f383019l == false) goto L5;
        int r100 = r110.getActionMasked();
        int r101 = r110.getActionIndex();
        if (r100 != 3) goto L9;
    L82:
        this.E = -1;
        this.B = false;
        this.C = false;
        this.A = false;
        this.D = false;
        this.F = 0;
        return false;
    L9:
        if (r100 == 1) goto L82;
        if (r100 == 0) goto L19;
        if (this.B == false) goto L16;
        return true;
    L16:
        if (this.C == false) goto L19;
        return false;
    L19:
        if (r100 == 0) goto L68;
        if (r100 != 2) goto L22;
        int r102 = this.E;
        if (r102 == (-1)) goto L81;
        int r103 = r110.findPointerIndex(r102);
        float r104 = r110.getX(r103);
        float r111 = r110.getY(r103);
        float r105 = r104 - this.H;
        float r106 = r111 - this.I;
        float r107 = r104 - this.f383003J;
        float r108 = r111 - this.K;
        if (m() == false) goto L34;
        float r109 = r106;
    L35:
        int r112 = (int) r109;
        if (this.f383020m == false) goto L43;
        if (r112 == 0) goto L43;
        if (c(this, m(), false, r112, (int) r104, (int) r111) == false) goto L43;
        this.H = r104;
        this.I = r111;
        this.C = true;
        return false;
    L43:
        if (m() == false) goto L57;
        if (Math.abs(r106) <= this.f383034z) goto L54;
        if (Math.abs(r106) <= (Math.abs(r107) * 0.5f)) goto L54;
        r(true);
        setScrollState(1);
        this.B = true;
        this.D = true;
        if (r106 <= 0.0f) goto L51;
        float r113 = this.K + this.f383034z;
    L52:
        this.I = r113;
        this.H = r104;
        goto L81
    L51:
        r113 = this.K - this.f383034z;
    L54:
        if (r107 <= this.f383034z) goto L81;
        this.C = true;
        goto L81
    L57:
        if (Math.abs(r105) <= this.f383034z) goto L66;
        if (Math.abs(r105) <= (Math.abs(r108) * 0.5f)) goto L66;
        r(true);
        setScrollState(1);
        this.B = true;
        this.D = true;
        if (r105 <= 0.0f) goto L63;
        float r114 = this.f383003J + this.f383034z;
    L64:
        this.H = r114;
        this.I = r111;
        goto L81
    L63:
        r114 = this.f383003J - this.f383034z;
    L66:
        if (r108 <= this.f383034z) goto L81;
        this.C = true;
        goto L81
    L34:
        r109 = r105;
    L81:
        return this.B;
    L22:
        if (r100 != 5) goto L24;
        this.E = r110.getPointerId(r101);
        goto L81
    L24:
        if (r100 != 6) goto L81;
        o(r110);
        goto L81
    L68:
        float r115 = r110.getX();
        this.f383003J = r115;
        this.H = r115;
        float r116 = r110.getY();
        this.K = r116;
        this.I = r116;
        this.E = r110.getPointerId(r101);
        this.B = false;
        this.C = false;
        this.D = false;
        this.A = false;
        this.F = 0;
        this.f383015i.computeScrollOffset();
        if (m() == false) goto L71;
        int r117 = this.f383015i.getFinalY();
        int r118 = this.f383015i.getCurrY();
    L72:
        int r119 = r117 - r118;
        if (this.L0 == false) goto L76;
        r(true);
    L76:
        if (this.f383030v != 2) goto L81;
        if (Math.abs(r119) <= this.G) goto L81;
        this.f383015i.abortAnimation();
        r(true);
        setScrollState(1);
        this.B = true;
        goto L81
    L71:
        r117 = this.f383015i.getFinalX();
        r118 = this.f383015i.getCurrX();
        goto L72
    L5:
        return super.onInterceptTouchEvent(r110);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        int r102 = r100.getActionMasked();
        if (r102 != 1) goto L5;
    L13:
        this.E = -1;
        if (this.A == true) goto L17;
        s();
    L17:
        if (this.f383019l == false) goto L21;
        return this.f383014h1.onTouchEvent(r100);
    L21:
        return super.onTouchEvent(r100);
    L5:
        if (r102 == 3) goto L13;
        if (r102 != 5) goto L9;
        this.E = r100.getPointerId(r101);
        this.H = r100.getX(r101);
        this.I = r100.getY(r101);
        goto L17
    L9:
        if (r102 != 6) goto L17;
        o(r100);
        goto L17
    }

    public final void r(boolean r100) {
        ViewParent r101 = getParent();
        if (r101 == null) goto L6;
        r101.requestDisallowInterceptTouchEvent(r100);
        return;
    }

    public void setAdapter(b r100) {
        if (this.L == null) goto L10;
        int r101 = getChildCount() - 1;
    L5:
        if (r101 <= (-1)) goto L11;
        View r102 = getChildAt(r101);
        e r103 = this.f383031w;
        if (r103 == null) goto L9;
        r103.a(r102);
    L9:
        removeView(r102);
        int r104 = ((c) r102.getLayoutParams()).f383036a;
        this.L.getClass();
        r101 = r101 - 1;
    L11:
        this.L = r100;
        if (r100 != null) goto L14;
        return;
    L14:
        this.f383009e = ((ArrayList) ((com.lynx.tasm.behavior.ui.swiper.e) r100).f383074a.D).size();
        return;
    L10:
        removeAllViews();
        goto L11
    }

    public void setAnimDuration(int r100) {
        this.f383028t = r100;
    }

    public void setBounceBeginThreshold(float r100) {
        if (r100 > 0.0f) goto L5;
    L7:
        this.V0 = -1.0f;
        return;
    L5:
        if (r100 >= 1.0f) goto L7;
        this.V0 = 1.0f - r100;
    }

    public void setBounceDuration(int r100) {
        this.P0 = r100;
    }

    public void setBounceEndThreshold(float r100) {
        if (r100 > 0.0f) goto L5;
    L7:
        this.f383006b1 = -1.0f;
        return;
    L5:
        if (r100 >= 1.0f) goto L7;
        this.f383006b1 = 1.0f - r100;
    }

    public void setEnableBounce(boolean r100) {
        this.V = r100;
    }

    public void setEnableNestedChild(boolean r100) {
        this.f383020m = r100;
    }

    public void setEnableViceLoop(boolean r100) {
        this.f383026r = r100;
    }

    public void setForceCanScroll(boolean r100) {
        this.f383025q = r100;
    }

    public void setHLayoutUpdated(boolean r100) {
        if (this.f383005b == false) goto L5;
        return;
    L5:
        this.f383005b = r100;
    }

    public void setHandleGesture(boolean r100) {
        this.L0 = r100;
    }

    public void setIgnoreLayoutUpdate(boolean r100) {
        this.H0 = r100;
    }

    public void setIsRTL(boolean r100) {
        this.f383022o = r100;
    }

    public void setKeepItemView(boolean r100) {
        this.f383023p = r100;
    }

    public void setLoop(boolean r100) {
        this.f383021n = r100;
        if (this.f383026r == true) goto L5;
        return;
    L5:
        if (this.L != null) goto L7;
        return;
    L7:
        if (this.f383009e > 1) goto L9;
        return;
    L9:
        if (this.f383010f == (-1)) goto L15;
        requestLayout();
        return;
    }

    public void setOrientation(int r100) {
        this.f383029u = r100;
    }

    public void setPageMargin(int r100) {
        if (r100 >= 0) goto L4;
        r100 = 0;
    L4:
        this.R = r100;
    }

    public void setPageSize(int r100) {
        this.M = r100;
    }

    public void setPropsUpdated(boolean r100) {
        if (this.f383008d == false) goto L5;
        return;
    L5:
        this.f383008d = r100;
    }

    public void setTouchable(boolean r100) {
        this.f383019l = r100;
    }

    public void setTransformer(e r100) {
        if (this.f383031w == null) goto L8;
        int r101 = getChildCount();
    L5:
        r101 = r101 - 1;
        if (r101 <= (-1)) goto L8;
        this.f383031w.a(getChildAt(r101));
    L8:
        this.f383031w = r100;
        v();
    }

    public void setVLayoutUpdated(boolean r100) {
        if (this.f383007c == false) goto L5;
        return;
    L5:
        this.f383007c = r100;
    }

    public ViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f383004a = false;
        this.f383005b = false;
        this.f383007c = false;
        this.f383008d = false;
        this.f383009e = 0;
        this.f383010f = -1;
        this.f383011g = -1;
        this.f383013h = -1;
        this.f383016j = false;
        this.f383017k = true;
        this.f383019l = true;
        this.f383020m = false;
        this.f383021n = false;
        this.f383022o = false;
        this.f383023p = false;
        this.f383025q = false;
        this.f383026r = false;
        this.f383027s = false;
        this.f383028t = 300;
        this.f383029u = 0;
        this.f383030v = 0;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = -1;
        this.F = 0;
        this.G = 0;
        this.H = 0.0f;
        this.I = 0.0f;
        this.f383003J = 0.0f;
        this.K = 0.0f;
        this.M = -1;
        this.N = 0;
        this.O = -1;
        this.P = -1;
        this.Q = -1;
        this.R = 0;
        this.S = Integer.MIN_VALUE;
        this.T = Integer.MAX_VALUE;
        this.V = false;
        this.W = false;
        this.f383018k0 = false;
        this.f383024p0 = false;
        this.H0 = false;
        this.L0 = true;
        this.P0 = 300;
        this.V0 = -1.0f;
        this.f383006b1 = -1.0f;
        this.f383012g1 = Integer.MIN_VALUE;
        this.f383014h1 = new GestureDetector(new a(this), new Handler(Looper.getMainLooper()));
        Resources r102 = getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        this.f383015i = new Scroller(r100, new LinearInterpolator());
        int r104 = (int) (600.0f * r103);
        this.f383033y = r104;
        this.f383032x = r104;
        this.f383034z = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.G = (int) (r103 * 2.0f);
        this.U = new ArrayList();
    }

    public final void i(int r100, boolean r101) {
        int r102 = 0;
        if (r101 == false) goto L21;
        if (l() == false) goto L13;
        if (this.f383021n == true) goto L9;
    L11:
        int r103 = r100 - 1;
    L19:
        t(r103, true, !l() ? 1 : 0);
        return;
    L9:
        if ((r100 - 1) >= 0) goto L11;
        r100 = this.f383009e;
        goto L11
    L13:
        if (this.f383021n == true) goto L15;
    L17:
        r102 = r100 + 1;
    L18:
        r103 = r102;
        goto L19
    L15:
        if ((r100 + 1) < this.f383009e) goto L17;
    L21:
        if (l() == false) goto L29;
        if (this.f383021n == true) goto L25;
    L27:
        r102 = r100 + 1;
    L34:
        t(r102, true, l() ? 1 : 0);
        return;
    L25:
        if ((r100 + 1) < this.f383009e) goto L27;
    L29:
        if (this.f383021n == true) goto L31;
    L33:
        r102 = r100 - 1;
        goto L34
    L31:
        if ((r100 - 1) >= 0) goto L33;
        r100 = this.f383009e;
        goto L33
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(ViewGroup.getDefaultSize(0, r100), ViewGroup.getDefaultSize(0, r101));
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        int r102 = getChildExpectSize() + this.R;
        int r103 = this.f383009e * r102;
        int r104 = getPaddingLeft() + this.N;
        boolean r105 = true;
        if (this.S != Integer.MIN_VALUE) goto L7;
        if (this.T != Integer.MAX_VALUE) goto L7;
    L14:
        boolean r106 = true;
    L15:
        this.O = r102;
        this.P = r103;
        this.Q = r104;
        if (r106 == false) goto L26;
        if (l() == false) goto L21;
        int r107 = getPaddingRight() - this.N;
        this.S = ((-(this.f383009e - 1)) * (getChildExpectSize() + this.R)) + r107;
        this.T = r107;
        goto L26
    L21:
        if (m() == false) goto L23;
        int r108 = getPaddingTop();
    L24:
        int r109 = r108 + this.N;
        this.S = -r109;
        this.T = ((this.f383009e - 1) * (getChildExpectSize() + this.R)) - r109;
        goto L26
    L23:
        r108 = getPaddingLeft();
    L26:
        if (this.f383021n == false) goto L28;
    L79:
        super.scrollTo(r100, r101);
        int r110 = getChildExpectSize() + this.R;
        int r111 = this.f383009e * r110;
        if (this.f383021n == false) goto L98;
        if (r111 <= 0) goto L98;
        if (r110 <= 0) goto L98;
        int r112 = getScrollDistance();
        if (l() == false) goto L91;
        int r113 = getPaddingRight() - this.N;
        int r114 = r112 - (r110 / 2);
        if (r114 < 0) goto L89;
        int r115 = r114 / r111;
        this.S = ((r115 * r111) + r110) + r113;
        this.T = ((r115 + 1) * r111) + r113;
        goto L98
    L89:
        this.S = (((-((Math.abs(r114) / r111) + 1)) * r111) + r110) + r113;
        this.T = ((-(Math.abs(r114) / r111)) * r111) + r113;
        goto L98
    L91:
        if (m() == false) goto L93;
        int r116 = getPaddingTop();
    L94:
        int r117 = r116 + this.N;
        int r118 = r112 + (r110 / 2);
        if (r118 < 0) goto L97;
        int r119 = r118 / r111;
        this.S = (r119 * r111) - r117;
        this.T = (((r119 + 1) * r111) - r110) - r117;
        goto L98
    L97:
        this.S = ((-((Math.abs(r118) / r111) + 1)) * r111) - r117;
        this.T = (((-(Math.abs(r118) / r111)) * r111) - r110) - r117;
        goto L98
    L93:
        r116 = getPaddingLeft();
    L98:
        q();
        if (this.f383017k == true) goto L113;
        if (this.f383016j == false) goto L113;
        if (this.f383019l == true) goto L105;
    L107:
        boolean r120 = false;
    L108:
        Iterator r121 = ((ArrayList) this.U).iterator();
    L110:
        if (r121.hasNext() == false) goto L113;
        ((d) r121.next()).b(r120, getScrollX(), getScrollY());
        goto L110
    L105:
        if (this.f383030v != 1) goto L107;
        r120 = true;
    L113:
        if (this.f383021n == false) goto L115;
        return;
    L115:
        if (this.W == false) goto L117;
    L118:
        s();
        if (this.f383024p0 == true) goto L129;
        boolean r122 = this.W;
        boolean r123 = this.f383018k0;
        if (this.f383017k == true) goto L129;
        if (this.f383016j == false) goto L129;
        Iterator r124 = ((ArrayList) this.U).iterator();
    L126:
        if (r124.hasNext() == false) goto L129;
        ((d) r124.next()).a(r122, r123);
    L129:
        if (this.W == false) goto L131;
    L134:
        this.f383024p0 = r105;
        this.W = false;
        this.f383018k0 = false;
        return;
    L131:
        if (this.f383018k0 == true) goto L134;
        r105 = false;
        goto L134
    L117:
        if (this.f383018k0 == false) goto L129;
    L28:
        if (m() == true) goto L30;
        int r125 = this.S;
        int r126 = this.T;
        if (g() == false) goto L55;
        if (this.f383022o == false) goto L53;
        r126 = (int) (this.T - (this.V0 * (getChildExpectSize() + this.R)));
        goto L55
    L53:
        r125 = (int) (this.S + (this.V0 * (getChildExpectSize() + this.R)));
    L55:
        if (h() == false) goto L61;
        if (this.f383022o == false) goto L59;
        r125 = (int) (this.S + (this.f383006b1 * (getChildExpectSize() + this.R)));
        goto L61
    L59:
        r126 = (int) (this.T - (this.f383006b1 * (getChildExpectSize() + this.R)));
    L61:
        if (g() == true) goto L63;
    L68:
        boolean r127 = false;
    L69:
        this.W = r127;
        if (h() == true) goto L72;
    L77:
        boolean r128 = false;
    L78:
        this.f383018k0 = r128;
        r100 = Math.min(Math.max(r100, r125), r126);
        goto L79
    L72:
        if (this.f383022o == false) goto L75;
        if (r100 > r125) goto L77;
    L76:
        r128 = true;
        goto L78
    L75:
        if (r100 < r126) goto L77;
    L63:
        if (this.f383022o == false) goto L66;
        if (r100 < r126) goto L68;
    L67:
        r127 = true;
        goto L69
    L66:
        if (r100 > r125) goto L68;
    L30:
        if (g() == false) goto L32;
        int r129 = (int) (this.S + (this.V0 * (getChildExpectSize() + this.R)));
    L34:
        if (h() == false) goto L36;
        int r130 = (int) (this.T - (this.f383006b1 * (getChildExpectSize() + this.R)));
    L38:
        if (g() == false) goto L41;
        if (r101 > r129) goto L41;
        boolean r131 = true;
    L42:
        this.W = r131;
        if (h() == false) goto L46;
        if (r101 < r130) goto L46;
        boolean r132 = true;
    L47:
        this.f383018k0 = r132;
        r101 = Math.min(Math.max(r101, r129), r130);
    L46:
        r132 = false;
    L41:
        r131 = false;
        goto L42
    L36:
        r130 = this.T;
        goto L38
    L32:
        r129 = this.S;
    L7:
        if (this.O != r102) goto L14;
        if (this.P != r103) goto L14;
        if (this.Q != r104) goto L14;
        r106 = false;
        goto L15
    }

    public final void u(int r100, boolean r101) {
        this.N = r100;
        if (r101 == true) goto L5;
        return;
    L5:
        if (m() == false) goto L7;
        scrollTo(0, -r100);
        return;
    L7:
        scrollTo(-r100, 0);
    }

    public static void a(ViewPager r100, float r110, float r111) {
        if (r100.getChildCount() >= 1) goto L6;
        return;
    L6:
        if (r100.m() == false) goto L8;
        r110 = r111;
    L8:
        int r112 = r100.getPile();
        int r101 = r100.getScrollDistance();
        int r102 = ((c) r100.getCurrentView().getLayoutParams()).f383036a;
        int r103 = 0;
        if (r110 >= 0.0f) goto L24;
        int r113 = r100.getChildCount();
        int r104 = Integer.MAX_VALUE;
    L11:
        if (r103 >= r113) goto L17;
        int r105 = r100.j(r100.getChildAt(r103)) - r101;
        if (r105 <= r112) goto L16;
        if (r105 >= r104) goto L16;
        r104 = r105;
    L16:
        r103 = r103 + 1;
        goto L11
    L17:
        if (r104 != Integer.MAX_VALUE) goto L20;
        r100.i(r102, true);
        return;
    L20:
        if (r100.m() == false) goto L22;
        r100.f383015i.startScroll(0, r101, 0, r104 - r112, r100.f383028t);
    L23:
        r100.setScrollState(2);
    L38:
        r100.invalidate();
        return;
    L22:
        r100.f383015i.startScroll(r101, 0, r104 - r112, 0, r100.f383028t);
        goto L23
    L24:
        int r114 = r100.getChildCount();
        int r106 = 0;
        int r107 = Integer.MIN_VALUE;
    L25:
        if (r106 >= r114) goto L31;
        int r108 = r100.j(r100.getChildAt(r106)) - r101;
        if (r108 >= r112) goto L30;
        if (r108 <= r107) goto L30;
        r107 = r108;
    L30:
        r106 = r106 + 1;
        goto L25
    L31:
        if (r107 != Integer.MIN_VALUE) goto L34;
        r100.i(r102, false);
        return;
    L34:
        if (r100.m() == false) goto L36;
        r100.f383015i.startScroll(0, r101, 0, r107 - r112, r100.f383028t);
    L37:
        r100.setScrollState(2);
        goto L38
    L36:
        r100.f383015i.startScroll(r101, 0, r107 - r112, 0, r100.f383028t);
        goto L37
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        throw new IllegalStateException();
    }

    public final void p(View r100, int r101, int r102) {
        if (m() == false) goto L5;
        int r103 = getPaddingLeft();
        int r104 = r100.getMeasuredWidth() + r103;
        int r105 = r101;
        r101 = r103;
        int r106 = r102;
        r102 = r104;
    L6:
        r100.layout(r101, r105, r102, r106);
        return;
    L5:
        r105 = getPaddingTop();
        r106 = r100.getMeasuredHeight() + r105;
        goto L6
    }

    public final void t(int r110, boolean r111, int r112) {
        boolean r100 = true;
        if (this.f383009e >= 1) goto L5;
        return;
    L5:
        if (getChildCount() < 1) goto L62;
        int r113 = MathUtils.clamp(r110, 0, this.f383009e - 1);
        View r101 = getCurrentView();
        int r102 = ((c) r101.getLayoutParams()).f383036a;
        if (r102 != r113) goto L10;
        return;
    L10:
        int r103 = getChildExpectSize();
        int r104 = getScrollDistance();
        int r105 = getPile() + (r103 / 2);
        int r106 = j(r101);
        if (m() == false) goto L13;
        int r107 = r101.getBottom();
    L14:
        int r108 = ((r106 + r107) / 2) - r104;
        int r109 = r103 + this.R;
        int r114 = (r113 - r102) * r109;
        boolean r115 = this.f383021n;
        if (r115 == false) goto L17;
    L18:
        if (r112 != 1) goto L22;
        if (r113 > r102) goto L25;
        int r116 = this.f383009e + r113;
    L26:
        r114 = (r116 - r102) * r109;
    L27:
        if (r115 == true) goto L36;
        this.f383027s = true;
        if (r112 != 1) goto L31;
        if (r113 >= r102) goto L31;
    L35:
        this.f383021n = r100;
    L31:
        if (r112 != 0) goto L34;
        if (r113 > r102) goto L35;
    L34:
        r100 = false;
    L36:
        w();
        if (l() == false) goto L44;
        Scroller r117 = this.f383015i;
        int r118 = (r108 - r105) - r114;
        if (r111 == false) goto L41;
        int r119 = this.f383028t;
    L42:
        r117.startScroll(r104, 0, r118, 0, r119);
    L55:
        setScrollState(2);
        if (m() == false) goto L58;
        int r120 = this.f383015i.getFinalY();
    L59:
        this.f383012g1 = r120;
        invalidate();
        return;
    L58:
        r120 = this.f383015i.getFinalX();
        goto L59
    L41:
        r119 = 0;
        goto L42
    L44:
        if (m() == false) goto L50;
        Scroller r121 = this.f383015i;
        int r122 = (r108 - r105) + r114;
        if (r111 == false) goto L48;
        int r123 = this.f383028t;
    L49:
        r121.startScroll(0, r104, 0, r122, r123);
        goto L55
    L48:
        r123 = 0;
        goto L49
    L50:
        Scroller r124 = this.f383015i;
        int r125 = r114 + (r108 - r105);
        if (r111 == false) goto L53;
        int r126 = this.f383028t;
    L54:
        r124.startScroll(r104, 0, r125, 0, r126);
        goto L55
    L53:
        r126 = 0;
    L25:
        r116 = r113;
        goto L26
    L22:
        if (r112 != 0) goto L27;
        if (r113 <= r102) goto L25;
        r116 = r113 - this.f383009e;
        goto L26
    L17:
        if (this.f383026r == false) goto L36;
    L13:
        r107 = r101.getRight();
        goto L14
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f383005b == false) goto L5;
    L6:
        f();
        this.f383005b = false;
        this.f383007c = false;
        return;
    L5:
        if (this.f383007c == true) goto L6;
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        int r104 = getPaddingLeft();
        super.setPadding(r100, r101, r102, r103);
        if (m() == false) goto L5;
        scrollBy(0, r104 - r100);
        return;
    L5:
        scrollBy(r104 - r100, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount() - 1;
    L3:
        if (r105 <= (-1)) goto L6;
        n(getChildAt(r105));
        r105 = r105 - 1;
        goto L3
    L6:
        if (this.f383008d == false) goto L8;
    L13:
        f();
        this.f383008d = false;
        this.f383005b = false;
        this.f383007c = false;
        return;
    L8:
        if (this.f383005b == true) goto L13;
        if (this.f383007c == true) goto L13;
        q();
    }

    public static boolean c(View r110, boolean r111, boolean r112, int r113, int r114, int r115) {
        if ((r110 instanceof ViewGroup) == false) goto L18;
        ViewGroup r100 = (ViewGroup) r110;
        int r116 = r110.getScrollX();
        int r117 = r110.getScrollY();
        int r118 = r100.getChildCount() - 1;
    L5:
        if (r118 < 0) goto L18;
        View r101 = r100.getChildAt(r118);
        int r102 = r114 + r116;
        if (r102 < r101.getLeft()) goto L17;
        if (r102 >= r101.getRight()) goto L17;
        int r103 = r115 + r117;
        if (r103 < r101.getTop()) goto L17;
        if (r103 >= r101.getBottom()) goto L17;
        if (c(r101, r111, true, r113, r102 - r101.getLeft(), r103 - r101.getTop()) == false) goto L17;
        return true;
    L17:
        r118 = r118 - 1;
    L18:
        if (r112 == false) goto L26;
        if (r111 == false) goto L24;
        if (r110.canScrollVertically(-r113) == false) goto L26;
        return true;
    L24:
        if (r110.canScrollHorizontally(-r113) == false) goto L26;
        return true;
    L26:
        return false;
    }
}
