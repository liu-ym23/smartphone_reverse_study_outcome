package com.larus.office.plugins.preview;

/* JADX INFO: loaded from: classes30.dex */
public final class k0 {
    public static final Integer a(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        r100 = null;
    L11:
        if (r100 != null) goto L13;
        return null;
    L13:
        return Integer.valueOf(r100.hashCode());
    L7:
        r101 = false;
        goto L8
    }
}
