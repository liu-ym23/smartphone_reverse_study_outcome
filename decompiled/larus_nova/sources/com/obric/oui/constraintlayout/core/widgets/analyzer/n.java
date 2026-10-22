package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f399811f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<ConstraintWidget> f399812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f399813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f399814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<a> f399815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f399816e;

    public static class a {
        public a(ConstraintWidget r100, com.obric.oui.constraintlayout.core.c r101) {
            new WeakReference(r100);
            ConstraintAnchor r102 = r100.L;
            r101.getClass();
            com.obric.oui.constraintlayout.core.c.n(r102);
            com.obric.oui.constraintlayout.core.c.n(r100.M);
            com.obric.oui.constraintlayout.core.c.n(r100.N);
            com.obric.oui.constraintlayout.core.c.n(r100.O);
            com.obric.oui.constraintlayout.core.c.n(r100.P);
        }
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        int r101 = this.f399814c;
        if (r101 != 0) goto L6;
        String r102 = "Horizontal";
    L12:
        r100.append(r102);
        r100.append(" [");
        r100.append(this.f399813b);
        r100.append("] <");
        String r103 = r100.toString();
        Iterator<ConstraintWidget> r104 = this.f399812a.iterator();
    L14:
        if (r104.hasNext() == false) goto L17;
        r103 = r103 + " " + r104.next().f399726m0;
        goto L14
    L17:
        return r103 + " >";
    L6:
        if (r101 != 1) goto L9;
        r102 = "Vertical";
        goto L12
    L9:
        if (r101 != 2) goto L11;
        r102 = "Both";
        goto L12
    L11:
        r102 = "Unknown";
        goto L12
    }

    public n(int r100) {
        this.f399812a = new ArrayList();
        this.f399813b = -1;
        this.f399815d = null;
        this.f399816e = -1;
        int r101 = f399811f;
        f399811f = r101 + 1;
        this.f399813b = r101;
        this.f399814c = r100;
    }

    public final boolean a(ConstraintWidget r100) {
        if (this.f399812a.contains(r100) == false) goto L6;
        return false;
    L6:
        this.f399812a.add(r100);
        return true;
    }

    public final void b(ArrayList<n> r100) {
        int r101 = this.f399812a.size();
        if (this.f399816e == (-1)) goto L12;
        if (r101 <= 0) goto L12;
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L12;
        n r103 = (n) ListProtector.get(r100, r102);
        if (this.f399816e != r103.f399813b) goto L11;
        d(this.f399814c, r103);
    L11:
        r102 = r102 + 1;
    L12:
        if (r101 != 0) goto L18;
        r100.remove(this);
        return;
    }

    public final int c(com.obric.oui.constraintlayout.core.c r100, int r110) {
        int r101 = 0;
        if (this.f399812a.size() != 0) goto L5;
        return 0;
    L5:
        ArrayList<ConstraintWidget> r102 = this.f399812a;
        com.obric.oui.constraintlayout.core.widgets.d r103 = (com.obric.oui.constraintlayout.core.widgets.d) ((ConstraintWidget) ListProtector.get(r102, 0)).X;
        r100.t();
        r103.d(r100, false);
        int r104 = 0;
    L7:
        if (r104 >= r102.size()) goto L9;
        ((ConstraintWidget) ListProtector.get(r102, r104)).d(r100, false);
        r104 = r104 + 1;
        goto L7
    L9:
        if (r110 != 0) goto L14;
        if (r103.G0 <= 0) goto L14;
        com.obric.oui.constraintlayout.core.widgets.b.a(r103, r100, r102, 0);
    L14:
        if (r110 == 1) goto L16;
    L31:
        r100.p();     // Catch: Exception -> L20
    L22:
        this.f399815d = new ArrayList();
    L24:
        if (r101 >= r102.size()) goto L26;
        this.f399815d.add(new a((ConstraintWidget) ListProtector.get(r102, r101), r100));
        r101 = r101 + 1;
        goto L24
    L26:
        if (r110 != 0) goto L28;
        int r111 = com.obric.oui.constraintlayout.core.c.n(r103.L);
        int r105 = com.obric.oui.constraintlayout.core.c.n(r103.N);
        r100.t();
    L30:
        return r105 - r111;
    L28:
        r111 = com.obric.oui.constraintlayout.core.c.n(r103.M);
        r105 = com.obric.oui.constraintlayout.core.c.n(r103.O);
        r100.t();
    L20:
        e = move-exception;
        System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        goto L22
    L16:
        if (r103.H0 <= 0) goto L31;
        com.obric.oui.constraintlayout.core.widgets.b.a(r103, r100, r102, 1);
        goto L31
    }

    public final void d(int r100, n r101) {
        Iterator<ConstraintWidget> r102 = this.f399812a.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        ConstraintWidget r103 = r102.next();
        r101.a(r103);
        if (r100 == 0) goto L7;
        r103.f399746w0 = r101.f399813b;
        goto L4
    L7:
        r103.f399744v0 = r101.f399813b;
        goto L4
    L9:
        this.f399816e = r101.f399813b;
    }
}
