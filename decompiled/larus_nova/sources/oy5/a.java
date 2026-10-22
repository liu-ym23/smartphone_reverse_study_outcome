package oy5;

import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.buffer.impl.MMapBuffer;
import com.bytedance.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f527127a = 0;

    static {
    }

    public static ny5.a a(File r100, long r101) throws IOException {
        if (r101 <= 0) goto L25;
        com.bytedance.geckox.b r102 = com.bytedance.geckox.b.a.f245076a;
        GeckoGlobalConfig r103 = com.bytedance.geckox.b.a();
        if (r103 != null) goto L12;
    L27:
        ny5.a r104 = new MMapBuffer(r101, r100);     // Catch: Exception -> L15
    L19:
        return r104;
    L15:
        e = move-exception;
        GeckoLogger.w("mmap failed: " + r100.exists() + '-' + r100.length() + '-' + r101 + '-' + e.getMessage());
    L23:
        r104 = new c(r101, r100);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        throw new RuntimeException("RAFBuffer failed! file: " + r100.getAbsolutePath() + '-' + e.getMessage(), e);
    L12:
        if (r103.isUseMMap() == false) goto L23;
    L25:
        return new b(r100);
    L6:
        e = move-exception;
        throw new IOException("create FileBuffer failed! file:" + r100.getAbsolutePath() + " caused by:" + e.getMessage(), e);
    }
}
