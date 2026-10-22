package com.bytedance.lynx.webview.internal;

import android.os.Trace;
import com.bytedance.lynx.webview.TTWebSdk;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class k implements Runnable {
    public static void a() {
        l17.k.d(new String[]{"TT_WEBVIEW", "auto launchRenderProcess"});
        Trace.beginSection("launchRenderProcess");
        TTWebSdk.launchRenderProcess();     // Catch: Throwable -> L5 Exception -> L7
    L10:
        Trace.endSection();
        return;
    L5:
        th = move-exception;
        Trace.endSection();
        throw th;
    L7:
        e = move-exception;
        l17.k.b(new String[]{"TT_WEBVIEW", "launchRenderProcess error:" + e.toString()});     // Catch: Throwable -> L5
        e.printStackTrace();     // Catch: Throwable -> L5
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public k() {
    }
}
