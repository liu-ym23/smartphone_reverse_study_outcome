package com.bytedance.crash.util;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f203416a = null;

    static {
        f203416a = new o();
    }

    public o() {
    }

    public static long a(File r100) {
        long r101 = 0;
        if (r100.exists() == true) goto L5;
        return 0;
    L5:
        if (r100.isDirectory() == false) goto L11;
        File[] r102 = r100.listFiles();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L9;
        r101 = r101 + a(r102[r104]);
        r104 = r104 + 1;
        goto L7
    L9:
        return r101;
    L11:
        return r100.length() / 1024;
    }
}
