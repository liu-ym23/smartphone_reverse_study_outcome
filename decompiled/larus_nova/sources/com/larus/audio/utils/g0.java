package com.larus.audio.utils;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 {
    public static final String a(CharSequence r100) {
        x58.a r101 = m58.h.f512130a;
        m58.b r102 = m58.h.f512140k;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L14;
        if (r102 == null) goto L14;
        return r102.c(r100, true, false);
    L14:
        if (r100 != null) goto L18;
        return null;
    L18:
        return r100.toString();
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public static final String b(CharSequence r100) {
        x58.a r101 = m58.h.f512130a;
        m58.b r102 = m58.h.f512140k;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L14;
        if (r102 == null) goto L14;
        return r102.c(r100, false, true);
    L14:
        if (r100 != null) goto L18;
        return null;
    L18:
        return r100.toString();
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
