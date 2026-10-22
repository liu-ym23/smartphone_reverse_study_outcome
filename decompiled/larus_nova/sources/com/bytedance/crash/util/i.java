package com.bytedance.crash.util;

import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }
}
