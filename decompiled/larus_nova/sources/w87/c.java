package w87;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
