package com.obric.oui.orecyclerview.widget;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class p extends g0 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static com.obric.oui.orecyclerview.base.e f401863s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static TimeInterpolator f401864t;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<RecyclerView.y> f401865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<RecyclerView.y> f401866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<b> f401867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<a> f401868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<ArrayList<RecyclerView.y>> f401869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<ArrayList<b>> f401870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<ArrayList<a>> f401871n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<RecyclerView.y> f401872o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<RecyclerView.y> f401873p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<RecyclerView.y> f401874q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList<RecyclerView.y> f401875r;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.y f401876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.y f401877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f401878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f401879d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f401880e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f401881f;

        public final String toString() {
            return "ChangeInfo{oldHolder=" + this.f401876a + ", newHolder=" + this.f401877b + ", fromX=" + this.f401878c + ", fromY=" + this.f401879d + ", toX=" + this.f401880e + ", toY=" + this.f401881f + '}';
        }

        public a(RecyclerView.y r100, RecyclerView.y r101, int r102, int r103, int r104, int r105) {
            this.f401876a = r100;
            this.f401877b = r101;
            this.f401878c = r102;
            this.f401879d = r103;
            this.f401880e = r104;
            this.f401881f = r105;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.y f401882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f401883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f401884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f401885d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f401886e;

        public b(RecyclerView.y r100, int r101, int r102, int r103, int r104) {
            this.f401882a = r100;
            this.f401883b = r101;
            this.f401884c = r102;
            this.f401885d = r103;
            this.f401886e = r104;
        }
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public final void f() {
        int r100 = this.f401867j.size();
    L3:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        b r101 = (b) ListProtector.get(this.f401867j, r100);
        View r102 = r101.f401882a.f401728a;
        r102.setTranslationY(0.0f);
        r102.setTranslationX(0.0f);
        c(r101.f401882a);
        ListProtector.remove(this.f401867j, r100);
        goto L3
    L6:
        int r103 = this.f401865h.size();
    L7:
        r103 = r103 - 1;
        if (r103 < 0) goto L10;
        c((RecyclerView.y) ListProtector.get(this.f401865h, r103));
        ListProtector.remove(this.f401865h, r103);
        goto L7
    L10:
        int r104 = this.f401866i.size();
    L11:
        r104 = r104 - 1;
        if (r104 < 0) goto L14;
        RecyclerView.y r105 = (RecyclerView.y) ListProtector.get(this.f401866i, r104);
        r105.f401728a.setAlpha(1.0f);
        c(r105);
        ListProtector.remove(this.f401866i, r104);
        goto L11
    L14:
        int r106 = this.f401868k.size();
    L15:
        r106 = r106 - 1;
        if (r106 < 0) goto L24;
        a r107 = (a) ListProtector.get(this.f401868k, r106);
        RecyclerView.y r108 = r107.f401876a;
        if (r108 == null) goto L20;
        l(r107, r108);
    L20:
        RecyclerView.y r109 = r107.f401877b;
        if (r109 == null) goto L15;
        l(r107, r109);
        goto L15
    L24:
        this.f401868k.clear();
        if (g() == true) goto L27;
        return;
    L27:
        int r110 = this.f401870m.size();
    L28:
        r110 = r110 - 1;
        if (r110 < 0) goto L38;
        ArrayList r111 = (ArrayList) ListProtector.get(this.f401870m, r110);
        int r112 = r111.size();
    L31:
        r112 = r112 - 1;
        if (r112 < 0) goto L28;
        b r113 = (b) ListProtector.get(r111, r112);
        View r114 = r113.f401882a.f401728a;
        r114.setTranslationY(0.0f);
        r114.setTranslationX(0.0f);
        c(r113.f401882a);
        ListProtector.remove(r111, r112);
        if (r111.isEmpty() == false) goto L31;
        this.f401870m.remove(r111);
        goto L31
    L38:
        int r115 = this.f401869l.size();
    L39:
        r115 = r115 - 1;
        if (r115 < 0) goto L49;
        ArrayList r116 = (ArrayList) ListProtector.get(this.f401869l, r115);
        int r117 = r116.size();
    L42:
        r117 = r117 - 1;
        if (r117 < 0) goto L39;
        RecyclerView.y r118 = (RecyclerView.y) ListProtector.get(r116, r117);
        r118.f401728a.setAlpha(1.0f);
        c(r118);
        ListProtector.remove(r116, r117);
        if (r116.isEmpty() == false) goto L42;
        this.f401869l.remove(r116);
        goto L42
    L49:
        int r119 = this.f401871n.size();
    L50:
        r119 = r119 - 1;
        if (r119 < 0) goto L66;
        ArrayList r120 = (ArrayList) ListProtector.get(this.f401871n, r119);
        int r121 = r120.size();
    L53:
        r121 = r121 - 1;
        if (r121 < 0) goto L50;
        a r122 = (a) ListProtector.get(r120, r121);
        RecyclerView.y r123 = r122.f401876a;
        if (r123 == null) goto L58;
        l(r122, r123);
    L58:
        RecyclerView.y r124 = r122.f401877b;
        if (r124 == null) goto L62;
        l(r122, r124);
    L62:
        if (r120.isEmpty() == false) goto L53;
        this.f401871n.remove(r120);
        goto L53
    L66:
        i(this.f401874q);
        i(this.f401873p);
        i(this.f401872o);
        i(this.f401875r);
        d();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public final boolean g() {
        if (this.f401866i.isEmpty() == true) goto L5;
    L26:
        return true;
    L5:
        if (this.f401868k.isEmpty() == false) goto L26;
        if (this.f401867j.isEmpty() == false) goto L26;
        if (this.f401865h.isEmpty() == false) goto L26;
        if (this.f401873p.isEmpty() == false) goto L26;
        if (this.f401874q.isEmpty() == false) goto L26;
        if (this.f401872o.isEmpty() == false) goto L26;
        if (this.f401875r.isEmpty() == false) goto L26;
        if (this.f401870m.isEmpty() == false) goto L26;
        if (this.f401869l.isEmpty() == false) goto L26;
        if (this.f401871n.isEmpty() == false) goto L26;
        return false;
    }

    public p() {
        this.f401865h = new ArrayList();
        this.f401866i = new ArrayList();
        this.f401867j = new ArrayList();
        this.f401868k = new ArrayList();
        this.f401869l = new ArrayList();
        this.f401870m = new ArrayList();
        this.f401871n = new ArrayList();
        this.f401872o = new ArrayList();
        this.f401873p = new ArrayList();
        this.f401874q = new ArrayList();
        this.f401875r = new ArrayList();
    }

    public final void j() {
        if (g() == true) goto L6;
        d();
        return;
    }

    public static void i(List r100) {
        ArrayList r101 = (ArrayList) r100;
        int r102 = r101.size();
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L6;
        ((RecyclerView.y) ListProtector.get(r101, r102)).f401728a.animate().cancel();
        goto L3
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public final void e(RecyclerView.y r100) {
        View r101 = r100.f401728a;
        r101.animate().cancel();
        int r102 = this.f401867j.size();
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L9;
        if (((b) ListProtector.get(this.f401867j, r102)).f401882a != r100) goto L3;
        r101.setTranslationY(0.0f);
        r101.setTranslationX(0.0f);
        c(r100);
        ListProtector.remove(this.f401867j, r102);
        goto L3
    L9:
        k(this.f401868k, r100);
        if (this.f401865h.remove(r100) == false) goto L13;
        r101.setAlpha(1.0f);
        c(r100);
    L13:
        if (this.f401866i.remove(r100) == false) goto L15;
        r101.setAlpha(1.0f);
        c(r100);
    L15:
        int r103 = this.f401871n.size() - 1;
    L16:
        if (r103 < 0) goto L21;
        ArrayList r104 = (ArrayList) ListProtector.get(this.f401871n, r103);
        k(r104, r100);
        if (r104.isEmpty() == false) goto L20;
        ListProtector.remove(this.f401871n, r103);
    L20:
        r103 = r103 - 1;
        goto L16
    L21:
        int r105 = this.f401870m.size() - 1;
    L22:
        if (r105 < 0) goto L32;
        ArrayList r106 = (ArrayList) ListProtector.get(this.f401870m, r105);
        int r107 = r106.size() - 1;
    L24:
        if (r107 < 0) goto L31;
        if (((b) ListProtector.get(r106, r107)).f401882a == r100) goto L27;
        r107 = r107 - 1;
        goto L24
    L27:
        r101.setTranslationY(0.0f);
        r101.setTranslationX(0.0f);
        c(r100);
        ListProtector.remove(r106, r107);
        if (r106.isEmpty() == false) goto L31;
        ListProtector.remove(this.f401870m, r105);
    L31:
        r105 = r105 - 1;
        goto L22
    L32:
        int r108 = this.f401869l.size() - 1;
    L33:
        if (r108 < 0) goto L40;
        ArrayList r109 = (ArrayList) ListProtector.get(this.f401869l, r108);
        if (r109.remove(r100) == false) goto L39;
        r101.setAlpha(1.0f);
        c(r100);
        if (r109.isEmpty() == false) goto L39;
        ListProtector.remove(this.f401869l, r108);
    L39:
        r108 = r108 - 1;
        goto L33
    L40:
        this.f401874q.remove(r100);
        this.f401872o.remove(r100);
        this.f401875r.remove(r100);
        this.f401873p.remove(r100);
        j();
    }

    public final void m(RecyclerView.y r100) {
        if (f401863s != null) goto L6;
        f401863s = new com.obric.oui.orecyclerview.base.e();
    L6:
        if (f401864t != null) goto L8;
        f401864t = new LinearInterpolator();
    L8:
        r100.f401728a.animate().setInterpolator(f401863s);
        e(r100);
    }

    public final void k(List<a> r100, RecyclerView.y r101) {
        int r102 = r100.size();
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L12;
        a r103 = (a) ListProtector.get(r100, r102);
        if (l(r103, r101) == false) goto L3;
        if (r103.f401876a != null) goto L3;
        if (r103.f401877b != null) goto L3;
        r100.remove(r103);
        goto L3
    }

    public final boolean l(a r100, RecyclerView.y r101) {
        if (r100.f401877b != r101) goto L6;
        r100.f401877b = null;
    L8:
        r101.f401728a.setAlpha(1.0f);
        r101.f401728a.setTranslationX(0.0f);
        r101.f401728a.setTranslationY(0.0f);
        c(r101);
        return true;
    L6:
        if (r100.f401876a != r101) goto L10;
        r100.f401876a = null;
        goto L8
    L10:
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.g0
    public final boolean h(RecyclerView.y r100, int r110, int r111, int r112, int r113) {
        View r101 = r100.f401728a;
        int r102 = r110 + ((int) r101.getTranslationX());
        int r103 = r111 + ((int) r100.f401728a.getTranslationY());
        m(r100);
        int r114 = r112 - r102;
        int r115 = r113 - r103;
        if (r114 != 0) goto L7;
        if (r115 != 0) goto L7;
        c(r100);
        return false;
    L7:
        if (r114 == 0) goto L9;
        r101.setTranslationX(-r114);
    L9:
        if (r115 == 0) goto L11;
        r101.setTranslationY(-r115);
    L11:
        this.f401867j.add(new b(r100, r102, r103, r112, r113));
        return true;
    }
}
