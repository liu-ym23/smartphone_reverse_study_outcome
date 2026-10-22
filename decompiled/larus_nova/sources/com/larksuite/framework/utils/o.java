package com.larksuite.framework.utils;

import com.ss.android.lark.log.Log;
import java.io.Closeable;

/* JADX INFO: loaded from: classes24.dex */
public final class o {
    public static final void a(Closeable... r100) {
        if (r100.length <= 0) goto L15;
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L22;
        Closeable r103 = r100[r102];
        if (r103 == null) goto L14;
        r103.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Log.d("IoStreamUtils", th.toString());
    L14:
        r102 = r102 + 1;
        goto L6
    L22:
        return;
    }
}
