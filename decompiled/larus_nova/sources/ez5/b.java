package ez5;

import com.bytedance.geckox.logger.GeckoLogger;
import java.io.Closeable;
import java.io.IOException;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final void a(Closeable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        GeckoLogger.e("close:", e);
    }
}
