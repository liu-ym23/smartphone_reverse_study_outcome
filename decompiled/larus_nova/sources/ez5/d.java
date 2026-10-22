package ez5;

import android.content.Context;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    static {
    }

    public static void a(String r100) {
        com.bytedance.geckox.b r101 = com.bytedance.geckox.b.a.f245076a;
        GeckoGlobalConfig r102 = com.bytedance.geckox.b.a();
        if (r102 == null) goto L5;
        Context r103 = r102.getContext();
    L6:
        if (r103 != null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r104 = FLogger.f375446a;
        r104.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r100));
        com.bytedance.librarian.a.c(r100);
        r104.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r100));
        return;
    L8:
        com.bytedance.librarian.a.e(r100, true, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
