package com.bytedance.common.profilesdk.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes15.dex */
public final class IoUtil {
    public static void close(ZipFile r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.close();     // Catch: IOException -> L6
        return;
    }

    public static void close(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }
}
