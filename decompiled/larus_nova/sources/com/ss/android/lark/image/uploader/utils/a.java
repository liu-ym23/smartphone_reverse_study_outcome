package com.ss.android.lark.image.uploader.utils;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    static {
    }

    public static void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        int r101 = c.f426438a;
        c.b("IOUtils", "closeSafety err:" + e, null, false);
        return;
    }
}
