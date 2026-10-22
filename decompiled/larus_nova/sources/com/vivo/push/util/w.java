package com.vivo.push.util;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes41.dex */
public final class w {
    public static boolean a(Activity r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 <= 34) goto L16;
        if (r100.isInMultiWindowMode() == false) goto L10;
        return true;
    L10:
        if (b(r100) == true) goto L20;
        return false;
    L20:
        return true;
    L16:
        if (r101 >= 24) goto L18;
        return false;
    L18:
        return r100.isInMultiWindowMode();
    }

    private static boolean b(Activity r100) {
        Window r101 = r100.getWindow();
        Class<?> r102 = r101.getClass();     // Catch: Exception -> L27
        Method r103 = null;
        if (r102.getSuperclass() == null) goto L13;
        Method[] r104 = r102.getSuperclass().getDeclaredMethods();     // Catch: Exception -> L27
        int r105 = r104.length;     // Catch: Exception -> L27
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L13;
        Method r107 = r104[r106];     // Catch: Exception -> L27
        if (r107 == null) goto L12;
        if ("getWindowControllerCallback".equals(r107.getName()) == false) goto L12;
        r103 = r107;
    L12:
        r106 = r106 + 1;     // Catch: Exception -> L27
    L13:
        if (r103 == null) goto L25;
        Object r108 = r103.invoke(r101, new Object[0]);     // Catch: Exception -> L27
        if (r108 == null) goto L39;
        Method[] r109 = r108.getClass().getDeclaredMethods();     // Catch: Exception -> L27
        int r110 = r109.length;     // Catch: Exception -> L27
        int r111 = 0;
    L17:
        if (r111 >= r110) goto L40;
        Method r112 = r109[r111];     // Catch: Exception -> L27
        if (r112 == null) goto L23;
        if ("isInVivoFreeformMode".equals(r112.getName()) == false) goto L23;
        r103 = r112;
    L23:
        r111 = r111 + 1;     // Catch: Exception -> L27
        goto L17
    L40:
        return ((Boolean) r103.invoke(r108, new Object[0])).booleanValue();
    L39:
        return false;
    L25:
        t.a("MultiWindowUtils", "<isWindowModeFreeForm> registerActivityObserver not implement in IActivityManager");     // Catch: Exception -> L27
        return false;
    L27:
        e = move-exception;
        t.a("MultiWindowUtils", "<isWindowModeFreeForm> registerActivityObserver-e = ", e);
        return false;
    }
}
