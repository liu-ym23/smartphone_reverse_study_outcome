package com.ttnet.org.chromium.base;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes41.dex */
public class StreamUtil {
    public StreamUtil() {
    }

    public static void closeQuietly(Closeable r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.close();     // Catch: IOException -> L6
        return;
    }

    public static void closeQuietly(ZipFile r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.close();     // Catch: IOException -> L6
        return;
    }
}
