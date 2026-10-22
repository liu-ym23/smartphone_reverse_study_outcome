package com.bytedance.ee.bear.office.list;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n {
    static {
    }

    public static boolean a(int r5, int r6) {
        if (r5 != 1024) goto L5;
    L12:
        boolean r1 = true;
    L14:
        if (r6 != (-1)) goto L16;
    L23:
        boolean r3 = true;
    L25:
        if (r5 == 3026) goto L27;
    L29:
        boolean r7 = false;
    L30:
        if (r1 == false) goto L32;
        if (r3 == false) goto L32;
        return true;
    L32:
        if (r7 == true) goto L37;
        return false;
    L37:
        return true;
    L27:
        if (r6 != 1028) goto L29;
        r7 = true;
        goto L30
    L16:
        if (r6 == 100) goto L23;
        if (r6 == 101) goto L23;
        if (r6 == 1027) goto L23;
        r3 = false;
        goto L25
    L5:
        if (r5 == 1029) goto L12;
        if (r5 == 1031) goto L12;
        if (r5 == 3025) goto L12;
        r1 = false;
        goto L14
    }
}
