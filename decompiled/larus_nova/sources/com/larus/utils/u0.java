package com.larus.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class u0 {
    public static final String a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r101 = new StringBuilder();
        String r102 = r100.getMessage();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.append(r102);
        r101.append("\n");
        StackTraceElement[] r103 = r100.getStackTrace();
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L9;
        r101.append(r103[r105].toString());
        r101.append("\n");
        r105 = r105 + 1;
        goto L6
    L9:
        return r101.toString();
    }
}
