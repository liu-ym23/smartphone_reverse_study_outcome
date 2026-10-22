package com.larus.audio.utils;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes24.dex */
public final class k0 {
    public static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }
}
