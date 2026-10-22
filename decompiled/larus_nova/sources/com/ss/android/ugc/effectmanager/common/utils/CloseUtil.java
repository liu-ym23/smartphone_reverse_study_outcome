package com.ss.android.ugc.effectmanager.common.utils;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes40.dex */
public class CloseUtil {
    public CloseUtil() {
    }

    public static void close(Closeable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }
}
