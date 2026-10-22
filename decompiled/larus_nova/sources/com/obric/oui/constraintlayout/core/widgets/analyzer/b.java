package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<ConstraintWidget> f399779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f399780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.obric.oui.constraintlayout.core.widgets.d f399781c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f399782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f399783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f399784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f399785d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f399786e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f399787f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f399788g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f399789h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f399790i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f399791j;

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.widgets.analyzer.b$b, reason: collision with other inner class name */
    public interface InterfaceC4669b {
    }

    public b(com.obric.oui.constraintlayout.core.widgets.d r100) {
        this.f399779a = new ArrayList();
        this.f399780b = new a();
        this.f399781c = r100;
    }

    public final void c(com.obric.oui.constraintlayout.core.widgets.d r100) {
        this.f399779a.clear();
        int r101 = r100.f550644x0.size();
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L11;
        ConstraintWidget r103 = (ConstraintWidget) ListProtector.get(r100.f550644x0, r102);
        ConstraintWidget.DimensionBehaviour[] r104 = r103.W;
        ConstraintWidget.DimensionBehaviour r105 = r104[0];
        ConstraintWidget.DimensionBehaviour r106 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r105 != r106) goto L8;
    L9:
        this.f399779a.add(r103);
    L10:
        r102 = r102 + 1;
        goto L4
    L8:
        if (r104[1] != r106) goto L10;
    L11:
        r100.f399835z0.f399795b = true;
    }

    public final boolean a(InterfaceC4669b r100, ConstraintWidget r101, int r102) {
        a r103 = this.f399780b;
        ConstraintWidget.DimensionBehaviour[] r104 = r101.W;
        r103.f399782a = r104[0];
        boolean r105 = true;
        r103.f399783b = r104[1];
        r103.f399784c = r101.t();
        a r106 = this.f399780b;
        r106.f399785d = r101.n();
        a r107 = this.f399780b;
        r107.f399790i = false;
        r107.f399791j = r102;
        ConstraintWidget.DimensionBehaviour r108 = r107.f399782a;
        ConstraintWidget.DimensionBehaviour r109 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r108 != r109) goto L5;
        boolean r110 = true;
    L7:
        if (r107.f399783b != r109) goto L9;
        boolean r111 = true;
    L11:
        if (r110 == true) goto L13;
    L15:
        boolean r112 = false;
    L16:
        if (r111 == true) goto L18;
    L20:
        boolean r113 = false;
    L22:
        if (r112 == true) goto L24;
    L26:
        if (r113 == true) goto L28;
    L30:
        ((ConstraintLayout.b) r100).b(r101, r107);
        r101.Q(this.f399780b.f399786e);
        r101.N(this.f399780b.f399787f);
        a r114 = this.f399780b;
        r101.G = r114.f399789h;
        int r115 = r114.f399788g;
        r101.f399710e0 = r115;
        if (r115 > 0) goto L34;
        r105 = false;
    L34:
        r101.G = r105;
        r114.f399791j = 0;
        return r114.f399790i;
    L28:
        if (r101.f399743v[1] != 4) goto L30;
        r107.f399783b = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L30
    L24:
        if (r101.f399743v[0] != 4) goto L26;
        r107.f399782a = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L26
    L18:
        if (r101.f399702a0 <= 0.0f) goto L20;
        r113 = true;
        goto L22
    L13:
        if (r101.f399702a0 <= 0.0f) goto L15;
        r112 = true;
        goto L16
    L9:
        r111 = false;
        goto L11
    L5:
        r110 = false;
        goto L7
    }

    public final void b(com.obric.oui.constraintlayout.core.widgets.d r100, int r101, int r102, int r103) {
        r100.getClass();
        int r104 = r100.f399712f0;
        int r105 = r100.f399714g0;
        r100.f399712f0 = 0;
        r100.f399714g0 = 0;
        r100.Q(r102);
        r100.N(r103);
        if (r104 >= 0) goto L5;
        r100.f399712f0 = 0;
    L6:
        if (r105 >= 0) goto L8;
        r100.f399714g0 = 0;
    L9:
        com.obric.oui.constraintlayout.core.widgets.d r106 = this.f399781c;
        r106.A0 = r101;
        r106.T();
        return;
    L8:
        r100.f399714g0 = r105;
        goto L9
    L5:
        r100.f399712f0 = r104;
        goto L6
    }
}
