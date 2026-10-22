package com.larus.home.impl.main.side_bar.view.group.render;

/* JADX INFO: loaded from: classes29.dex */
public final class a0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final String a(eb9.o r100) {
        DATA r101 = r100.f471909c;
        if ((r101 instanceof com.larus.home.impl.main.side_bar.data.j0) == false) goto L5;
        com.larus.home.impl.main.side_bar.data.j0 r102 = (com.larus.home.impl.main.side_bar.data.j0) r101;
    L6:
        if (r102 == null) goto L18;
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.d r103 = r102.f344513h;
        if (r103 == null) goto L19;
        String r104 = r103.f345406a;
        if (r104 != null) goto L12;
        return null;
    L12:
        if (r104.length() <= 0) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == true) goto L17;
        return null;
    L17:
        return r104;
    L14:
        r105 = false;
        goto L15
    L19:
        return null;
    L18:
        return null;
    L5:
        r102 = null;
        goto L6
    }
}
