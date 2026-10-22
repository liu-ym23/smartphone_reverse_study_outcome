package com.larksuite.component.universe_design.util;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f285486a = null;

    static {
        f285486a = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    }

    @JvmStatic
    public static final int a(int r100, int r101) {
        if (r101 <= 12) goto L5;
        r100 = r100 + 1;
        r101 = 1;
    L7:
        int[] r102 = f285486a;
        if ((r100 % 4) != 0) goto L12;
        if ((r100 % 100) == 0) goto L12;
    L13:
        r102[1] = 29;
    L21:
        return r102[r101 - 1];
    L18:
        e = move-exception;
        e.getStackTrace();
        return 0;
    L12:
        if ((r100 % 400) == 0) goto L13;
        r102[1] = 28;
        goto L21
    L5:
        if (r101 >= 1) goto L7;
        r100 = r100 - 1;
        r101 = 12;
        goto L7
    }
}
