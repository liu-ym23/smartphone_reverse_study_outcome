package com.huawei.secure.android.common.util;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes23.dex */
public abstract class SafePrintException {
    public SafePrintException() {
    }

    private static boolean a(String r110) {
        String[] r100 = {"java.io.FileNotFoundException", "java.util.jar.JarException", "java.util.MissingResourceException", "java.security.acl.NotOwnerException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.net.BindException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.sql.SQLException"};
        int r101 = 0;
    L4:
        if (r101 >= 10) goto L10;
        if (r110.contains(r100[r101]) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static String getStackTrace(String r100, Throwable r101) {
        StringBuilder r102 = new StringBuilder();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r102.append(r100);
        r102.append(" ");
    L5:
        r102.append("Exception: ");
        r102.append(r101.getClass().getName());
        r102.append('\n');
        if (a(r101.getClass().getCanonicalName()) == true) goto L14;
        StackTraceElement[] r103 = r101.getStackTrace();
        if (r103 != null) goto L10;
        r102.append("Stack trace is NULL!\n");
        goto L14
    L10:
        int r104 = r103.length;
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L14;
        r102.append(r103[r105].toString());
        r102.append('\n');
        r105 = r105 + 1;
    L14:
        return r102.toString();
    }

    public static void print(String r100, String r101, Throwable r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        getStackTrace(r101, r102);
    }
}
