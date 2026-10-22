package com.bytedance.bdp.bdpbase.util;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class l {
    static {
    }

    @JvmStatic
    public static final String a(Throwable r100, int r101) {
        StackTraceElement[] r102 = r100.getStackTrace();
        StringBuilder r103 = new StringBuilder();
        int r104 = 0;
        int r105 = r101 + 0;
        if (r105 <= r102.length) goto L5;
        r105 = r102.length;
    L5:
        if (r105 <= 0) goto L11;
        r103.append(r102[0]);
    L7:
        r104 = r104 + 1;
        if (r104 >= r105) goto L11;
        r103.append(" ");
        r103.append(r102[r104]);
    L11:
        return r103.toString();
    }
}
