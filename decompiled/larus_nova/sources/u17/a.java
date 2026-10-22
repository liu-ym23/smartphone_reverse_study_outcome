package u17;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.IOOMCallback;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements IOOMCallback {
    public a() {
    }

    @Override // com.bytedance.crash.IOOMCallback
    public final void onCrash(CrashType r100, Throwable r101, Thread r102, long r103) {
    L9:
        th = move-exception;
        r17.c.b("onCrash_exception " + th.getMessage(), new Object[0]);     // Catch: Throwable -> L13
        HashMap<String, Object> r104 = new HashMap();     // Catch: Throwable -> L13
        r104.put("http_error_message", th.getMessage());     // Catch: Throwable -> L13
        x17.a.f562123j.b("onCrash_exception", r104);     // Catch: Throwable -> L13
    L25:
        Thread.sleep(2000);     // Catch: InterruptedException -> L16
        return;
    L27:
        return;
    L13:
        th = move-exception;
        Thread.sleep(2000);     // Catch: InterruptedException -> L17
    L15:
        throw th;
    L4:
        if (s17.c.b().c() == true) goto L6;
        s17.c.b().a();     // Catch: Throwable -> L9
        s17.c.b().d();     // Catch: Throwable -> L9
        x17.a r105 = x17.a.f562123j;     // Catch: Throwable -> L9
        r105.f562125b = "oomDump";     // Catch: Throwable -> L9
        r105.c("oomDump");     // Catch: Throwable -> L9
        s17.d.f().c(r103);     // Catch: Throwable -> L9
    L22:
        goto L25
    L6:
        x17.a.f562123j.c("hasDumpFile");     // Catch: Throwable -> L9
        goto L22
    }
}
