package com.bytedance.common.jato.boost;

import android.os.Build;

/* JADX INFO: loaded from: classes15.dex */
public class MtkDispatcherOpt {
    private static int isOpted = -1;

    public MtkDispatcherOpt() {
    }

    private static native boolean nativeOpt();

    public static boolean opt() {
        String r100 = Build.HARDWARE;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.startsWith("mt") == false) goto L19;
        int r101 = isOpted;
        if (r101 == (-1)) goto L12;
        if (r101 != 1) goto L16;
        return true;
    L16:
        return false;
    L12:
        boolean r102 = nativeOpt();
        isOpted = r102 ? 1 : 0;
        if (r102 != true) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }
}
