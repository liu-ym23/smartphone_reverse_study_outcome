package nra;

import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.agilelogger.ALog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public c() {
    }

    public final void a() {
        com.bytedance.librarian.a.e(CloudControlInf.ALOG, true, ALog.sConfig.getContext());     // Catch: Throwable -> L5
        return;
    L5:
        Intrinsics.checkNotNullParameter(CloudControlInf.ALOG, "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> alog");
        com.bytedance.librarian.a.c(CloudControlInf.ALOG);
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> alog");
    }
}
