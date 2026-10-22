package com.obric.assistant.zeus.plugin;

import android.util.Log;
import com.larus.utils.logger.FLogger;
import com.volcengine.zeus.log.IZeusLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class i implements IZeusLogger {
    public i() {
    }

    @Override // com.volcengine.zeus.log.IZeusLogger
    public final void d(String r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        FLogger.a.d(r2, r3);
    }

    @Override // com.volcengine.zeus.log.IZeusLogger
    public final void i(String r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        FLogger.a.i(r2, r3);
    }

    @Override // com.volcengine.zeus.log.IZeusLogger
    public final void v(String r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        FLogger.a.v(r2, r3);
    }

    @Override // com.volcengine.zeus.log.IZeusLogger
    public final void w(String r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        FLogger.a.w(r2, r3);
    }

    @Override // com.volcengine.zeus.log.IZeusLogger
    public final void e(String r2, String r3, Throwable r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        FLogger.a.e(r2, r3, r4);
        if (r4 == null) goto L8;
        Log.getStackTraceString(r4);
        return;
    }

    @Override // com.volcengine.zeus.log.IZeusLogger
    public final void w(String r2, String r3, Throwable r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        FLogger.a.w(r2, r3, r4);
        if (r4 == null) goto L8;
        Log.getStackTraceString(r4);
        return;
    }
}
