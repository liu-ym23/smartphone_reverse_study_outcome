package jgc;

import java.io.Closeable;

/* JADX INFO: loaded from: classes38.dex */
public final class e {
    public static void a(Closeable r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.close();     // Catch: Exception -> L6
        return;
    }
}
