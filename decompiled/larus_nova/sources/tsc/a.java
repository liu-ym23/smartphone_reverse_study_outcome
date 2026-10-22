package tsc;

import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a {
    public static void a(lsc.y r100, char r101) {
        r100.append(r101);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
