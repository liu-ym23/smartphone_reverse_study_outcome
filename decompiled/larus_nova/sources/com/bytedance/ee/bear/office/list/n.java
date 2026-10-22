package com.bytedance.ee.bear.office.list;

/* JADX INFO: loaded from: classes18.dex */
public final class n {
    static {
    }

    public static boolean a(int r100, int r101) {
        if (r100 != 1024) goto L5;
    L12:
        boolean r102 = true;
    L14:
        if (r101 != (-1)) goto L16;
    L23:
        boolean r103 = true;
    L25:
        if (r100 == 3026) goto L27;
    L29:
        boolean r104 = false;
    L30:
        if (r102 == false) goto L32;
        if (r103 == false) goto L32;
        return true;
    L32:
        if (r104 == true) goto L37;
        return false;
    L37:
        return true;
    L27:
        if (r101 != 1028) goto L29;
        r104 = true;
        goto L30
    L16:
        if (r101 == 100) goto L23;
        if (r101 == 101) goto L23;
        if (r101 == 1027) goto L23;
        r103 = false;
        goto L25
    L5:
        if (r100 == 1029) goto L12;
        if (r100 == 1031) goto L12;
        if (r100 == 3025) goto L12;
        r102 = false;
        goto L14
    }
}
