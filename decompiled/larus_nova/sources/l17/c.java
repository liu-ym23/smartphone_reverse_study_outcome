package l17;

import com.bytedance.lynx.webview.internal.TTWebContext;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {
    public c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        TTWebContext.h().p().r();     // Catch: Throwable -> L4 Exception -> L6
    L17:
        return;
    L6:
        e = move-exception;
        k.b(new String[]{"onConfigLoaded", e.toString()});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
