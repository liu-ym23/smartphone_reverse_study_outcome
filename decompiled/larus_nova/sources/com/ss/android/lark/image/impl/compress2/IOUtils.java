package com.ss.android.lark.image.impl.compress2;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes36.dex */
class IOUtils {
    public static void closeSafety(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
