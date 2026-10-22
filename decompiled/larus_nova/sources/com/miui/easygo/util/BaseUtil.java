package com.miui.easygo.util;

/* JADX INFO: loaded from: classes32.dex */
class BaseUtil {
    public BaseUtil() {
    }

    public static boolean isNullOrEmpty(String[] r100) {
        if (r100 == null) goto L19;
        int r101 = 0;
    L6:
        if (r101 >= r100.length) goto L14;
        String r102 = r100[r101];
        if (r102 == null) goto L13;
        if (r102.isEmpty() == true) goto L13;
        r101 = r101 + 1;
    L13:
        return true;
    L14:
        return false;
    L19:
        return true;
    }
}
