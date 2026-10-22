package com.larus.home.impl.main.side_bar;

import com.larus.home.impl.main.side_bar.view.group.render.z;

/* JADX INFO: loaded from: classes29.dex */
public final class a {
    public static final z a(uu9.c r100, uu9.c r101) {
        boolean r102 = false;
        if (r101 != null) goto L5;
        r101 = new uu9.c(0);
    L5:
        Integer r103 = null;
        if (r100 == null) goto L16;
        Integer r104 = Integer.valueOf(r100.a());
        if (r104.intValue() <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L14;
        r104 = null;
    L14:
        if (r104 == null) goto L16;
        int r106 = r104.intValue();
    L17:
        if (r100 == null) goto L27;
        Integer r107 = Integer.valueOf(r100.c());
        if (r107.intValue() <= 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L25;
        r107 = null;
    L25:
        if (r107 == null) goto L27;
        int r109 = r107.intValue();
    L28:
        if (r100 == null) goto L36;
        Integer r110 = Integer.valueOf(r100.b());
        if (r110.intValue() <= 0) goto L32;
        r102 = true;
    L32:
        if (r102 == false) goto L34;
        r103 = r110;
    L34:
        if (r103 == null) goto L36;
        int r111 = r103.intValue();
    L38:
        return new z(r106, r109, r111);
    L36:
        r111 = r101.b();
        goto L38
    L21:
        r108 = false;
    L27:
        r109 = r101.c();
        goto L28
    L10:
        r105 = false;
    L16:
        r106 = r101.a();
        goto L17
    }
}
