package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.obric.oui.color.i0;
import com.obric.oui.color.j0;
import com.obric.oui.color.k0;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class f {
    public static final c a(e r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        ColorStateList r100 = r210.f401463a;
        kma.b r101 = r210.f401464b;
        if (r101 != null) goto L5;
        kma.a r102 = null;
    L6:
        com.obric.oui.color.b[] r103 = r210.f401465c;
        if (r103 != null) goto L9;
        com.obric.oui.color.a[] r104 = null;
    L10:
        kma.d r105 = r210.f401466d;
        if (r105 != null) goto L13;
        kma.c r106 = null;
    L14:
        j0 r107 = r210.f401467e;
        if (r107 != null) goto L17;
        i0 r108 = null;
    L18:
        kma.b r109 = r210.f401468f;
        if (r109 != null) goto L21;
        kma.a r110 = null;
    L22:
        com.obric.oui.blur.b r111 = r210.f401469g;
        if (r111 != null) goto L25;
        com.obric.oui.blur.a r112 = null;
    L26:
        Float r113 = r210.f401470h;
        com.obric.oui.shadow.b[] r114 = r210.f401471i;
        if (r114 != null) goto L29;
        com.obric.oui.shadow.a[] r115 = null;
    L30:
        com.obric.oui.fluid.b r116 = r210.f401472j;
        if (r116 != null) goto L33;
        com.obric.oui.fluid.a r117 = null;
    L35:
        return new c(r100, r102, r104, r106, r108, r110, r112, r113, r115, r117);
    L33:
        r117 = com.obric.oui.fluid.c.a(r116);
        goto L35
    L29:
        r115 = c(r114);
        goto L30
    L25:
        Intrinsics.checkNotNullParameter(r111, "<this>");
        r112 = new com.obric.oui.blur.a(r111.f398871a, r111.f398872b, r111.f398873c, r111.f398874d, r111.f398875e);
        goto L26
    L21:
        Intrinsics.checkNotNullParameter(r109, "<this>");
        int r118 = kma.a.f504112b;
        Intrinsics.checkNotNullParameter(r109, "core");
        r110 = new kma.a(r109);
        goto L22
    L17:
        r108 = k0.a(r107);
        goto L18
    L13:
        Intrinsics.checkNotNullParameter(r105, "<this>");
        int r119 = kma.c.f504119b;
        Intrinsics.checkNotNullParameter(r105, "core");
        r106 = new kma.c(r105);
        goto L14
    L9:
        r104 = com.obric.oui.color.c.a(r103);
        goto L10
    L5:
        Intrinsics.checkNotNullParameter(r101, "<this>");
        int r120 = kma.a.f504112b;
        Intrinsics.checkNotNullParameter(r101, "core");
        r102 = new kma.a(r101);
        goto L6
    }

    public static final c[] b(e[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(a(r100[r103]));
        r103 = r103 + 1;
        goto L3
    L5:
        Object[] r104 = r101.toArray(new c[0]);
        if (r104 == null) goto L10;
        return (c[]) r104;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final com.obric.oui.shadow.a[] c(com.obric.oui.shadow.b[] r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        ArrayList r100 = new ArrayList(r110.length);
        int r101 = r110.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        com.obric.oui.shadow.b r103 = r110[r102];
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r100.add(new com.obric.oui.shadow.a(r103.f402807a, r103.f402808b, r103.f402809c, r103.f402810d, r103.f402811e, r103.f402812f));
        r102 = r102 + 1;
        goto L3
    L5:
        Object[] r111 = r100.toArray(new com.obric.oui.shadow.a[0]);
        if (r111 == null) goto L10;
        return (com.obric.oui.shadow.a[]) r111;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
