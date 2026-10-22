package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class h {
    public static n a(ConstraintWidget r100, int r101, ArrayList<n> r102, n r110) {
        if (r101 != 0) goto L4;
        int r103 = r100.f399744v0;
    L5:
        int r104 = 0;
        if (r103 == (-1)) goto L19;
        if (r110 != null) goto L9;
    L10:
        int r105 = 0;
    L12:
        if (r105 >= r102.size()) goto L22;
        n r106 = (n) ListProtector.get(r102, r105);
        if (r106.f399813b == r103) goto L15;
        r105 = r105 + 1;
        goto L12
    L15:
        if (r110 == null) goto L17;
        r110.d(r101, r106);
        r102.remove(r110);
    L17:
        r110 = r106;
    L22:
        if (r110 != null) goto L51;
        if ((r100 instanceof ula.b) == false) goto L47;
        ula.b r107 = (ula.b) r100;
        int r108 = 0;
    L27:
        if (r108 >= r107.f550643y0) goto L38;
        ConstraintWidget r109 = r107.f550642x0[r108];
        if (r101 != 0) goto L33;
        int r111 = r109.f399744v0;
        if (r111 == (-1)) goto L33;
    L39:
        if (r111 == (-1)) goto L47;
        int r112 = 0;
    L42:
        if (r112 >= r102.size()) goto L47;
        n r113 = (n) ListProtector.get(r102, r112);
        if (r113.f399813b == r111) goto L45;
        r112 = r112 + 1;
        goto L42
    L45:
        r110 = r113;
    L33:
        if (r101 != 1) goto L37;
        r111 = r109.f399746w0;
        if (r111 != (-1)) goto L39;
    L37:
        r108 = r108 + 1;
        goto L27
    L38:
        r111 = -1;
    L47:
        if (r110 != null) goto L49;
        r110 = new n(r101);
    L49:
        r102.add(r110);
    L51:
        if (r110.a(r100) == true) goto L53;
    L62:
        return r110;
    L53:
        if ((r100 instanceof com.obric.oui.constraintlayout.core.widgets.f) == false) goto L58;
        com.obric.oui.constraintlayout.core.widgets.f r114 = (com.obric.oui.constraintlayout.core.widgets.f) r100;
        ConstraintAnchor r115 = r114.A0;
        if (r114.B0 != 0) goto L57;
        r104 = 1;
    L57:
        r115.c(r104, r102, r110);
    L58:
        if (r101 != 0) goto L60;
        r100.f399744v0 = r110.f399813b;
        r100.L.c(r101, r102, r110);
        r100.N.c(r101, r102, r110);
    L61:
        r100.S.c(r101, r102, r110);
        goto L62
    L60:
        r100.f399746w0 = r110.f399813b;
        r100.M.c(r101, r102, r110);
        r100.P.c(r101, r102, r110);
        r100.O.c(r101, r102, r110);
        goto L61
    L9:
        if (r103 != r110.f399813b) goto L10;
    L19:
        if (r103 == (-1)) goto L22;
        return r110;
    L4:
        r103 = r100.f399746w0;
        goto L5
    }

    public static boolean b(ConstraintWidget.DimensionBehaviour r100, ConstraintWidget.DimensionBehaviour r101, ConstraintWidget.DimensionBehaviour r102, ConstraintWidget.DimensionBehaviour r103) {
        ConstraintWidget.DimensionBehaviour r104 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r102 == r104) goto L11;
        ConstraintWidget.DimensionBehaviour r105 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r102 == r105) goto L11;
        if (r102 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L10;
        if (r100 != r105) goto L11;
    L10:
        boolean r106 = false;
    L12:
        if (r103 == r104) goto L20;
        ConstraintWidget.DimensionBehaviour r107 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r103 == r107) goto L20;
        if (r103 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L19;
        if (r101 != r107) goto L20;
    L19:
        boolean r108 = false;
    L21:
        if (r106 == true) goto L25;
        if (r108 == true) goto L25;
        return false;
    L25:
        return true;
    L20:
        r108 = true;
    L11:
        r106 = true;
        goto L12
    }
}
