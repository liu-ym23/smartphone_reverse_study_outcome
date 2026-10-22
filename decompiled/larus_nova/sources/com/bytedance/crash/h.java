package com.bytedance.crash;

import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes6.dex */
public final class h {
    public static void a() {
        if (wg4.a.a() == true) goto L5;
        return;
    L5:
        if (wg4.a.f559547a.f559553b == null) goto L14;
        ALog.e("Logger", "app happen crash, upload alog");     // Catch: Throwable -> L8
        ALog.asyncFlush();     // Catch: Throwable -> L8
        ObricAlogServiceDelegate.f387841b.e();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        ch4.c.c(th);
        return;
    }
}
