package com.obric.oui.orecyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
public final class GridLayoutManager extends LinearLayoutManager {
    public boolean C;
    public int D;
    public int[] E;
    public View[] F;
    public final SparseIntArray G;
    public final SparseIntArray H;
    public final a I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Rect f401554J;

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f401555e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f401556f;

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f401555e = -1;
            this.f401556f = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.f401555e = -1;
            this.f401556f = 0;
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.f401555e = -1;
            this.f401556f = 0;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f401555e = -1;
            this.f401556f = 0;
        }
    }

    public static final class a extends b {
        public a() {
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseIntArray f401557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseIntArray f401558b;

        public static int a(int r100, int r101) {
            int r102 = 0;
            int r103 = 0;
            int r104 = 0;
        L4:
            if (r102 >= r100) goto L12;
            r103 = r103 + 1;
            if (r103 != r101) goto L8;
            r104 = r104 + 1;
            r103 = 0;
        L10:
            r102 = r102 + 1;
            goto L4
        L8:
            if (r103 <= r101) goto L10;
            r104 = r104 + 1;
            r103 = 1;
            goto L10
        L12:
            if ((r103 + 1) > r101) goto L14;
            return r104;
        L14:
            return r104 + 1;
        }

        public final void b() {
            this.f401557a.clear();
        }

        public b() {
            this.f401557a = new SparseIntArray();
            this.f401558b = new SparseIntArray();
        }
    }

    public GridLayoutManager() {
        super(1);
        this.C = false;
        this.D = -1;
        this.G = new SparseIntArray();
        this.H = new SparseIntArray();
        a r100 = new a();
        this.I = r100;
        this.f401554J = new Rect();
        if (2 == this.D) goto L7;
        this.C = true;
        this.D = 2;
        r100.b();
        f0();
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void S() {
        this.I.b();
        this.I.f401558b.clear();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void T() {
        this.I.b();
        this.I.f401558b.clear();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void U() {
        this.I.b();
        this.I.f401558b.clear();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void V() {
        this.I.b();
        this.I.f401558b.clear();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void W() {
        this.I.b();
        this.I.f401558b.clear();
    }

    public final void d1() {
        if (this.f401559n != 1) goto L5;
        int r100 = this.f401672l - D();
        int r101 = C();
    L6:
        W0(r100 - r101);
        return;
    L5:
        r100 = this.f401673m - B();
        r101 = E();
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager, com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final RecyclerView.LayoutParams q() {
        if (this.f401559n != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager, com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final boolean t0() {
        if (this.f401569x == null) goto L5;
    L7:
        return false;
    L5:
        if (this.C == true) goto L7;
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager
    public final void S0(boolean r100) {
        if (r100 == true) goto L6;
        super.S0(false);
        return;
    L6:
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public final void W0(int r100) {
        int[] r101 = this.E;
        int r102 = this.D;
        int r103 = 1;
        if (r101 != null) goto L5;
    L8:
        r101 = new int[r102 + 1];
    L9:
        int r104 = 0;
        r101[0] = 0;
        int r105 = r100 / r102;
        int r106 = r100 % r102;
        int r107 = 0;
    L10:
        if (r103 > r102) goto L18;
        r104 = r104 + r106;
        if (r104 > 0) goto L14;
    L16:
        int r108 = r105;
    L17:
        r107 = r107 + r108;
        r101[r103] = r107;
        r103 = r103 + 1;
        goto L10
    L14:
        if ((r102 - r104) >= r106) goto L16;
        r108 = r105 + 1;
        r104 = r104 - r102;
        goto L17
    L18:
        this.E = r101;
        return;
    L5:
        if (r101.length != (r102 + 1)) goto L8;
        if (r101[r101.length - 1] == r100) goto L9;
        goto L8
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager, com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void Y(RecyclerView.v r100) {
        super.Y(r100);
        this.C = false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final boolean e(RecyclerView.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager, com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final int j(RecyclerView.v r100) {
        return x0(r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager, com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final int k(RecyclerView.v r100) {
        return y0(r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager, com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final int m(RecyclerView.v r100) {
        return x0(r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager, com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final int n(RecyclerView.v r100) {
        return y0(r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final RecyclerView.LayoutParams s(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L7:
        return new LayoutParams(r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final int G(RecyclerView.q r100, RecyclerView.v r101) {
        if (this.f401559n != 0) goto L7;
        return this.D;
    L7:
        if (r101.b() >= 1) goto L11;
        return 0;
    L11:
        return Y0(r100, r101, r101.b() - 1) + 1;
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager, com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void X(RecyclerView.q r100, RecyclerView.v r101) {
        if (r101.f401712g == false) goto L7;
        int r102 = u();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L7;
        LayoutParams r104 = (LayoutParams) t(r103).getLayoutParams();
        int r105 = r104.a();
        this.G.put(r105, r104.f401556f);
        this.H.put(r105, r104.f401555e);
        r103 = r103 + 1;
    L7:
        super.X(r100, r101);
        this.G.clear();
        this.H.clear();
    }

    public final int X0(int r100, int r101) {
        if (this.f401559n == 1) goto L5;
    L8:
        int[] r102 = this.E;
        return r102[r101 + r100] - r102[r100];
    L5:
        if (L0() == false) goto L8;
        int[] r103 = this.E;
        int r104 = this.D;
        return r103[r104 - r100] - r103[(r104 - r100) - r101];
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final RecyclerView.LayoutParams r(Context r100, AttributeSet r101) {
        return new LayoutParams(r100, r101);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final int w(RecyclerView.q r100, RecyclerView.v r101) {
        if (this.f401559n != 1) goto L7;
        return this.D;
    L7:
        if (r101.b() >= 1) goto L11;
        return 0;
    L11:
        return Y0(r100, r101, r101.b() - 1) + 1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void P(RecyclerView.q r100, RecyclerView.v r101, AccessibilityNodeInfoCompat r102) {
        super.P(r100, r101, r102);
        r102.setClassName(GridView.class.getName());
    }

    public final int Y0(RecyclerView.q r100, RecyclerView.v r101, int r102) {
        if (r101.f401712g == true) goto L6;
        a r103 = this.I;
        int r104 = this.D;
        r103.getClass();
        return b.a(r102, r104);
    L6:
        int r105 = r100.b(r102);
        if (r105 == (-1)) goto L9;
        a r106 = this.I;
        int r107 = this.D;
        r106.getClass();
        return b.a(r105, r107);
    L9:
        return 0;
    }

    public final int Z0(RecyclerView.q r100, RecyclerView.v r101, int r102) {
        if (r101.f401712g == true) goto L6;
        a r103 = this.I;
        int r104 = this.D;
        r103.getClass();
        return r102 % r104;
    L6:
        int r105 = this.H.get(r102, -1);
        if (r105 == (-1)) goto L9;
        return r105;
    L9:
        int r106 = r100.b(r102);
        if (r106 == (-1)) goto L12;
        a r107 = this.I;
        int r108 = this.D;
        r107.getClass();
        return r106 % r108;
    L12:
        return 0;
    }

    public final int a1(RecyclerView.q r100, RecyclerView.v r101, int r102) {
        if (r101.f401712g == true) goto L6;
        this.I.getClass();
        return 1;
    L6:
        int r103 = this.G.get(r102, -1);
        if (r103 == (-1)) goto L10;
        return r103;
    L10:
        if (r100.b(r102) == (-1)) goto L12;
        this.I.getClass();
        return 1;
    L12:
        return 1;
    }

    public final void b1(View r100, int r110, boolean r111) {
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        Rect r102 = r101.f401652b;
        int r103 = ((r102.top + r102.bottom) + ((ViewGroup.MarginLayoutParams) r101).topMargin) + ((ViewGroup.MarginLayoutParams) r101).bottomMargin;
        int r104 = ((r102.left + r102.right) + ((ViewGroup.MarginLayoutParams) r101).leftMargin) + ((ViewGroup.MarginLayoutParams) r101).rightMargin;
        int r105 = X0(r101.f401555e, r101.f401556f);
        if (this.f401559n != 1) goto L5;
        int r112 = RecyclerView.k.v(r105, r110, r104, ((ViewGroup.MarginLayoutParams) r101).width, false);
        int r106 = RecyclerView.k.v(this.f401561p.k(), this.f401671k, r103, ((ViewGroup.MarginLayoutParams) r101).height, true);
    L6:
        c1(r100, r112, r106, r111);
        return;
    L5:
        int r113 = RecyclerView.k.v(r105, r110, r103, ((ViewGroup.MarginLayoutParams) r101).height, false);
        int r107 = RecyclerView.k.v(this.f401561p.k(), this.f401670j, r104, ((ViewGroup.MarginLayoutParams) r101).width, true);
        r106 = r113;
        r112 = r107;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager, com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final int h0(int r100, RecyclerView.q r101, RecyclerView.v r102) {
        d1();
        View[] r103 = this.F;
        if (r103 != null) goto L5;
    L6:
        this.F = new View[this.D];
    L8:
        return super.h0(r100, r101, r102);
    L5:
        if (r103.length == this.D) goto L8;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager, com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final int j0(int r100, RecyclerView.q r101, RecyclerView.v r102) {
        d1();
        View[] r103 = this.F;
        if (r103 != null) goto L5;
    L6:
        this.F = new View[this.D];
    L8:
        return super.j0(r100, r101, r102);
    L5:
        if (r103.length == this.D) goto L8;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void m0(Rect r100, int r101, int r102) {
        if (this.E != null) goto L5;
        super.m0(r100, r101, r102);
    L5:
        int r103 = C() + D();
        int r104 = E() + B();
        if (this.f401559n != 1) goto L8;
        int r105 = RecyclerView.k.f(r102, r100.height() + r104, ViewCompat.getMinimumHeight(this.f401662b));
        int[] r106 = this.E;
        int r107 = RecyclerView.k.f(r101, r106[r106.length - 1] + r103, ViewCompat.getMinimumWidth(this.f401662b));
    L9:
        RecyclerView.g(this.f401662b, r107, r105);
        return;
    L8:
        r107 = RecyclerView.k.f(r101, r100.width() + r103, ViewCompat.getMinimumWidth(this.f401662b));
        int[] r108 = this.E;
        r105 = RecyclerView.k.f(r102, r108[r108.length - 1] + r104, ViewCompat.getMinimumHeight(this.f401662b));
        goto L9
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager
    public final void v0(RecyclerView.v r100, LinearLayoutManager.c r101, RecyclerView.k.c r102) {
        int r103 = this.D;
        int r104 = 0;
    L4:
        if (r104 >= this.D) goto L14;
        int r105 = r101.f401587d;
        if (r105 >= 0) goto L8;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == false) goto L18;
        if (r103 <= 0) goto L19;
        ((s.b) r102).a(r101.f401587d, Math.max(0, r101.f401590g));
        this.I.getClass();
        r103 = r103 - 1;
        r101.f401587d += r101.f401588e;
        r104 = r104 + 1;
        goto L4
    L19:
        return;
    L18:
        return;
    L8:
        if (r105 >= r100.b()) goto L10;
        r106 = true;
        goto L11
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager
    public final View G0(RecyclerView.q r100, RecyclerView.v r110, boolean r111, boolean r112) {
        int r113 = u();
        int r101 = 1;
        if (r112 == false) goto L5;
        int r114 = u() - 1;
        int r115 = -1;
        r101 = -1;
    L6:
        int r102 = r110.b();
        A0();
        int r103 = this.f401561p.j();
        int r104 = this.f401561p.f();
        View r105 = null;
        View r106 = null;
    L7:
        if (r114 == r115) goto L27;
        View r107 = t(r114);
        int r108 = RecyclerView.k.F(r107);
        if (r108 < 0) goto L26;
        if (r108 >= r102) goto L26;
        if (Z0(r100, r110, r108) != 0) goto L26;
        if (((RecyclerView.LayoutParams) r107.getLayoutParams()).b() == false) goto L19;
        if (r106 != null) goto L26;
        r106 = r107;
        goto L26
    L19:
        if (this.f401561p.d(r107) < r104) goto L21;
    L24:
        if (r105 != null) goto L26;
        r105 = r107;
        goto L26
    L21:
        if (this.f401561p.a(r107) < r103) goto L24;
        return r107;
    L26:
        r114 = r114 + r101;
        goto L7
    L27:
        if (r105 == null) goto L30;
        return r105;
    L30:
        return r106;
    L5:
        r115 = r113;
        r114 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v42 */
    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager
    public final void M0(RecyclerView.q r110, RecyclerView.v r210, LinearLayoutManager.c r211, LinearLayoutManager.b r212) {
        int r100 = this.f401561p.i();
        if (r100 == 1073741824) goto L5;
        boolean r101 = true;
    L7:
        if (u() <= 0) goto L9;
        int r111 = this.E[this.D];
    L10:
        if (r101 == false) goto L13;
        d1();
    L13:
        if (r211.f401588e != 1) goto L15;
        boolean r112 = true;
    L16:
        int r113 = this.D;
        if (r112 == true) goto L19;
        r113 = Z0(r110, r210, r211.f401587d) + a1(r110, r210, r211.f401587d);
    L19:
        int r114 = 0;
    L21:
        if (r114 >= this.D) goto L41;
        int r115 = r211.f401587d;
        if (r115 >= 0) goto L25;
    L27:
        boolean r116 = false;
    L28:
        if (r116 == false) goto L41;
        if (r113 <= 0) goto L41;
        int r117 = r211.f401587d;
        int r118 = a1(r110, r210, r117);
        if (r118 > this.D) goto L40;
        r113 = r113 - r118;
        if (r113 < 0) goto L41;
        View r102 = r211.b(r110);
        if (r102 == null) goto L41;
        this.F[r114] = r102;
        r114 = r114 + 1;
        goto L21
    L40:
        throw new IllegalArgumentException("Item at position " + r117 + " requires " + r118 + " spans but GridLayoutManager has only " + this.D + " spans.");
    L25:
        if (r115 >= r210.b()) goto L27;
        r116 = true;
    L41:
        if (r114 != 0) goto L45;
        r212.f401581b = true;
        return;
    L45:
        if (r112 == false) goto L47;
        int r119 = r114;
        int r120 = 0;
        int r121 = 0;
        int r122 = 1;
    L48:
        if (r120 == r119) goto L50;
        View r103 = this.F[r120];
        LayoutParams r104 = (LayoutParams) r103.getLayoutParams();
        int r105 = a1(r110, r210, RecyclerView.k.F(r103));
        r104.f401556f = r105;
        r104.f401555e = r121;
        r121 = r121 + r105;
        r120 = r120 + r122;
        goto L48
    L50:
        float r106 = 0.0f;
        int r107 = 0;
        int r108 = 0;
    L51:
        if (r107 >= r114) goto L72;
        View r109 = this.F[r107];
        if (r211.f401594k != null) goto L57;
        if (r112 == false) goto L56;
        ?? r123 = 0;
        a(r109, -1, false);
    L61:
        Rect r124 = this.f401554J;
        RecyclerView r125 = this.f401662b;
        if (r125 != null) goto L64;
        r124.set(r123, r123, r123, r123);
    L65:
        b1(r109, r100, r123);
        int r126 = this.f401561p.b(r109);
        if (r126 <= r108) goto L68;
        r108 = r126;
    L68:
        float r127 = (this.f401561p.c(r109) * 1.0f) / ((LayoutParams) r109.getLayoutParams()).f401556f;
        if (r127 <= r106) goto L71;
        r106 = r127;
    L71:
        r107 = r107 + 1;
        goto L51
    L64:
        r124.set(r125.F(r109));
        goto L65
    L56:
        r123 = 0;
        a(r109, 0, false);
        goto L61
    L57:
        r123 = 0;
        r123 = 0;
        if (r112 == false) goto L60;
        a(r109, -1, true);
        goto L61
    L60:
        a(r109, 0, true);
        goto L61
    L72:
        if (r101 == false) goto L79;
        W0(Math.max(Math.round(r106 * this.D), r111));
        r108 = 0;
        int r128 = 0;
    L74:
        if (r128 >= r114) goto L79;
        View r129 = this.F[r128];
        b1(r129, 1073741824, true);
        int r130 = this.f401561p.b(r129);
        if (r130 <= r108) goto L78;
        r108 = r130;
    L78:
        r128 = r128 + 1;
    L79:
        int r131 = 0;
    L80:
        if (r131 >= r114) goto L90;
        View r132 = this.F[r131];
        if (this.f401561p.b(r132) == r108) goto L89;
        LayoutParams r133 = (LayoutParams) r132.getLayoutParams();
        Rect r134 = r133.f401652b;
        int r135 = ((r134.top + r134.bottom) + ((ViewGroup.MarginLayoutParams) r133).topMargin) + ((ViewGroup.MarginLayoutParams) r133).bottomMargin;
        int r136 = ((r134.left + r134.right) + ((ViewGroup.MarginLayoutParams) r133).leftMargin) + ((ViewGroup.MarginLayoutParams) r133).rightMargin;
        int r137 = X0(r133.f401555e, r133.f401556f);
        if (this.f401559n != 1) goto L86;
        int r138 = RecyclerView.k.v(r137, 1073741824, r136, ((ViewGroup.MarginLayoutParams) r133).width, false);
        int r139 = View.MeasureSpec.makeMeasureSpec(r108 - r135, 1073741824);
    L87:
        c1(r132, r138, r139, true);
        goto L89
    L86:
        int r140 = View.MeasureSpec.makeMeasureSpec(r108 - r136, 1073741824);
        r139 = RecyclerView.k.v(r137, 1073741824, r135, ((ViewGroup.MarginLayoutParams) r133).height, false);
        r138 = r140;
    L89:
        r131 = r131 + 1;
        goto L80
    L90:
        r212.f401580a = r108;
        if (this.f401559n != 1) goto L98;
        if (r211.f401589f != (-1)) goto L95;
        int r141 = r211.f401585b;
        int r142 = r141 - r108;
    L96:
        int r143 = r142;
        int r144 = 0;
        int r145 = r141;
        int r146 = 0;
    L102:
        int r147 = r145;
        int r148 = 0;
    L103:
        if (r148 >= r114) goto L122;
        View r149 = this.F[r148];
        LayoutParams r150 = (LayoutParams) r149.getLayoutParams();
        if (this.f401559n == 1) goto L107;
        r143 = E() + this.E[r150.f401555e];
        r147 = this.f401561p.c(r149) + r143;
    L111:
        RecyclerView.k.K(r149, r144, r143, r146, r147);
        if (r150.b() == false) goto L114;
    L120:
        r212.f401582c = true;
    L121:
        r212.f401583d = r149.hasFocusable() | r212.f401583d;
        r148 = r148 + 1;
        goto L103
    L114:
        if ((r150.f401651a.f401737j & 2) == 0) goto L116;
        boolean r151 = true;
    L117:
        if (r151 == false) goto L121;
    L116:
        r151 = false;
        goto L117
    L107:
        if (L0() == false) goto L109;
        r146 = C() + this.E[this.D - r150.f401555e];
        r144 = r146 - this.f401561p.c(r149);
        goto L111
    L109:
        r144 = this.E[r150.f401555e] + C();
        r146 = this.f401561p.c(r149) + r144;
        goto L111
    L122:
        Arrays.fill(this.F, null);
        return;
    L95:
        int r152 = r211.f401585b;
        r142 = r152;
        r141 = r108 + r152;
        goto L96
    L98:
        if (r211.f401589f != (-1)) goto L100;
        r146 = r211.f401585b;
        int r153 = r146 - r108;
    L101:
        r144 = r153;
        r143 = 0;
        r145 = 0;
        goto L102
    L100:
        int r154 = r211.f401585b;
        r153 = r154;
        r146 = r108 + r154;
        goto L101
    L47:
        r120 = r114 - 1;
        r119 = -1;
        r121 = 0;
        r122 = -1;
        goto L48
    L15:
        r112 = false;
        goto L16
    L9:
        r111 = 0;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager, com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final View N(View r210, int r211, RecyclerView.q r212, RecyclerView.v r213) {
        RecyclerView.q r100 = r212;
        RecyclerView.v r101 = r213;
        RecyclerView r102 = this.f401662b;
        View r103 = null;
        if (r102 == null) goto L10;
        View r104 = r102.v(r210);
        if (r104 == null) goto L10;
        if (this.f401661a.k(r104) == true) goto L10;
    L11:
        if (r104 != null) goto L13;
        return null;
    L13:
        LayoutParams r105 = (LayoutParams) r104.getLayoutParams();
        int r106 = r105.f401555e;
        int r107 = r105.f401556f + r106;
        if (super.N(r210, r211, r212, r213) != null) goto L17;
        return null;
    L17:
        if (z0(r211) != 1) goto L19;
        boolean r108 = true;
    L21:
        if (r108 == this.f401564s) goto L23;
        boolean r109 = true;
    L25:
        if (r109 == false) goto L27;
        int r110 = u() - 1;
        int r111 = -1;
        int r112 = -1;
    L29:
        if (this.f401559n == 1) goto L31;
    L33:
        boolean r113 = false;
    L34:
        int r114 = Y0(r100, r101, r110);
        int r115 = r110;
        int r116 = r112;
        int r117 = -1;
        int r118 = 0;
        int r119 = 0;
        int r120 = -1;
        View r121 = null;
    L35:
        if (r115 == r111) goto L93;
        int r122 = r111;
        int r123 = Y0(r100, r101, r115);
        View r124 = t(r115);
        if (r124 == r104) goto L93;
        if (r124.hasFocusable() == false) goto L45;
        if (r123 == r114) goto L45;
        if (r103 != null) goto L93;
        View r125 = r104;
        View r214 = r121;
        int r126 = r118;
    L91:
        r118 = r126;
        r121 = r214;
    L92:
        r115 = r115 + r116;
        r100 = r212;
        r101 = r213;
        r111 = r122;
        r104 = r125;
    L45:
        LayoutParams r127 = (LayoutParams) r124.getLayoutParams();
        int r128 = r127.f401555e;
        r125 = r104;
        int r129 = r127.f401556f + r128;
        if (r124.hasFocusable() == false) goto L51;
        if (r128 != r106) goto L51;
        if (r129 != r107) goto L51;
        return r124;
    L51:
        if (r124.hasFocusable() == false) goto L54;
        if (r103 != null) goto L54;
    L56:
        r214 = r121;
    L66:
        r126 = r118;
        boolean r130 = true;
    L86:
        if (r130 == false) goto L91;
        if (r124.hasFocusable() == false) goto L90;
        int r131 = r127.f401555e;
        r118 = Math.min(r129, r107) - Math.max(r128, r106);
        r120 = r131;
        r121 = r214;
        r103 = r124;
        goto L92
    L90:
        int r132 = r127.f401555e;
        r119 = Math.min(r129, r107) - Math.max(r128, r106);
        r117 = r132;
        r118 = r126;
        r121 = r124;
    L54:
        if (r124.hasFocusable() == true) goto L57;
        if (r121 == null) goto L56;
    L57:
        r214 = r121;
        int r133 = Math.min(r129, r107) - Math.max(r128, r106);
        if (r124.hasFocusable() == false) goto L67;
        if (r133 > r118) goto L66;
        if (r133 != r118) goto L84;
        if (r128 <= r120) goto L64;
        boolean r134 = true;
    L65:
        if (r113 != r134) goto L84;
    L64:
        r134 = false;
    L84:
        r126 = r118;
    L85:
        r130 = false;
        goto L86
    L67:
        if (r103 != null) goto L84;
        r126 = r118;
        if (this.f401663c.b(r124) == true) goto L71;
    L73:
        boolean r135 = false;
    L75:
        if ((!r135) == false) goto L85;
        if (r133 > r119) goto L83;
        if (r133 != r119) goto L85;
        if (r128 <= r117) goto L81;
        boolean r136 = true;
    L82:
        if (r113 != r136) goto L85;
    L81:
        r136 = false;
    L83:
        r130 = true;
        goto L86
    L71:
        if (this.f401664d.b(r124) == false) goto L73;
        r135 = true;
    L93:
        View r215 = r121;
        if (r103 == null) goto L97;
        return r103;
    L97:
        return r215;
    L31:
        if (L0() == false) goto L33;
        r113 = true;
        goto L34
    L27:
        r111 = u();
        r110 = 0;
        r112 = 1;
        goto L29
    L23:
        r109 = false;
        goto L25
    L19:
        r108 = false;
    L10:
        r104 = null;
        goto L11
    }

    @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager
    public final void N0(RecyclerView.q r100, RecyclerView.v r101, LinearLayoutManager.a r102, int r103) {
        d1();
        if (r101.b() > 0) goto L5;
    L22:
        View[] r104 = this.F;
        if (r104 != null) goto L25;
    L26:
        this.F = new View[this.D];
        return;
    L25:
        if (r104.length != this.D) goto L26;
        return;
    L5:
        if (r101.f401712g == true) goto L22;
        if (r103 != 1) goto L9;
        boolean r105 = true;
    L10:
        int r106 = Z0(r100, r101, r102.f401576b);
        if (r105 == false) goto L16;
    L12:
        if (r106 <= 0) goto L22;
        int r107 = r102.f401576b;
        if (r107 <= 0) goto L22;
        int r108 = r107 - 1;
        r102.f401576b = r108;
        r106 = Z0(r100, r101, r108);
        goto L12
    L16:
        int r109 = r101.b() - 1;
        int r110 = r102.f401576b;
    L17:
        if (r110 >= r109) goto L21;
        int r111 = r110 + 1;
        int r112 = Z0(r100, r101, r111);
        if (r112 <= r106) goto L21;
        r110 = r111;
        r106 = r112;
    L21:
        r102.f401576b = r110;
        goto L22
    L9:
        r105 = false;
        goto L10
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void R(RecyclerView.q r100, RecyclerView.v r101, View r110, AccessibilityNodeInfoCompat r111) {
        ViewGroup.LayoutParams r102 = r110.getLayoutParams();
        if ((r102 instanceof LayoutParams) == true) goto L6;
        Q(r110, r111);
        return;
    L6:
        LayoutParams r103 = (LayoutParams) r102;
        int r104 = Y0(r100, r101, r103.a());
        if (this.f401559n != 0) goto L9;
        r111.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r103.f401555e, r103.f401556f, r104, 1, false, false));
        return;
    L9:
        r111.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r104, 1, r103.f401555e, r103.f401556f, false, false));
    }

    public final void c1(View r100, int r101, int r102, boolean r103) {
        RecyclerView.LayoutParams r104 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        if (r103 == true) goto L5;
        boolean r105 = p0(r100, r101, r102, r104);
    L14:
        if (r105 == false) goto L17;
        r100.measure(r101, r102);
        return;
    L17:
        return;
    L5:
        if (this.f401666f == true) goto L7;
    L12:
        r105 = true;
        goto L14
    L7:
        if (RecyclerView.k.J(r100.getMeasuredWidth(), r101, ((ViewGroup.MarginLayoutParams) r104).width) == false) goto L12;
        if (RecyclerView.k.J(r100.getMeasuredHeight(), r102, ((ViewGroup.MarginLayoutParams) r104).height) == false) goto L12;
        r105 = false;
        goto L14
    }
}
