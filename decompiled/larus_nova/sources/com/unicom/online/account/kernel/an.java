package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: classes41.dex */
public final class an {
    public static Boolean a(String r100) {
        if (r100 == null) goto L13;
        if (r100.length() == 0) goto L13;
        if (r100.trim().length() == 0) goto L13;
        if ("null".equals(r100) == true) goto L13;
        return Boolean.FALSE;
    L13:
        return Boolean.TRUE;
    }

    public static Boolean b(String r100) {
        if (r100 == null) goto L15;
        if (r100.length() == 0) goto L15;
        if (r100.trim().length() == 0) goto L15;
        if ("null".equals(r100) == true) goto L15;
        if (r100.equals("") == true) goto L15;
        return Boolean.TRUE;
    L15:
        return Boolean.FALSE;
    }
}
