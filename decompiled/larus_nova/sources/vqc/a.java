package vqc;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    public static void a(Closeable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof Closeable) == false) goto L11;
        r100.close();     // Catch: IOException -> L7
        return;
    L12:
        return;
    }
}
