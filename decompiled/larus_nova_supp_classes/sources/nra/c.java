package nra;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.ss.android.agilelogger.ALog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public c() {
    }

    public final void a() {
        a.e("alog", true, ALog.sConfig.getContext());     // Catch: Throwable -> L5
        return;
    L5:
        Intrinsics.checkNotNullParameter("alog", "libName");
        FLogger r1 = FLogger.a;
        r1.i("Librarian_loadLib", "loadLibrary start libName -> alog");
        a.c("alog");
        r1.i("Librarian_loadLib", "loadLibrary success by librarian -> alog");
    }
}
