package com.larus.bmhome.block.holder.deepthink;

import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class j0 {
    public static final jc8.d a(jc8.k r100, jc8.a r101) {
        Intrinsics.checkNotNullParameter(r101, "blockModel");
        if (r100 == null) goto L38;
        tb8.a r102 = (tb8.a) r100.a(tb8.a.class);
        if (r102 == null) goto L38;
        boolean r103 = r102.f545277e;
        fh8.d r104 = r102.f545278f;
        boolean r105 = false;
        if (r104 == null) goto L10;
        boolean r106 = r104.b();
    L11:
        boolean r107 = r101.m();
        boolean r108 = r101.n();
        if (r106 == false) goto L16;
        if (r103 == false) goto L16;
        r105 = true;
    L16:
        if (r107 == false) goto L25;
        if (r108 == false) goto L25;
        int r109 = c7.b(16);
        int r110 = c7.b(12);
        int r111 = c7.b(16);
        if (r105 == false) goto L21;
        int r112 = 40;
    L23:
        return new jc8.d(r109, r110, r111, c7.b(r112));
    L21:
        r112 = 14;
    L25:
        if (r107 == true) goto L27;
        if (r108 == false) goto L36;
        int r113 = c7.b(16);
        int r114 = c7.b(6);
        int r115 = c7.b(16);
        if (r105 == false) goto L32;
        int r116 = 40;
    L34:
        return new jc8.d(r113, r114, r115, c7.b(r116));
    L32:
        r116 = 14;
        goto L34
    L36:
        return new jc8.d(c7.b(16), c7.b(6), c7.b(16), c7.b(6));
    L27:
        return new jc8.d(c7.b(16), c7.b(12), c7.b(16), c7.b(6));
    L10:
        r106 = false;
    L38:
        return jc8.e.d(r101);
    }
}
