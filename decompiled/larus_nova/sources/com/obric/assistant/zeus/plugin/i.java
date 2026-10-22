package com.obric.assistant.zeus.plugin;

import android.util.Log;
import com.larus.utils.logger.FLogger;
import com.volcengine.zeus.log.IZeusLogger;

/* JADX INFO: loaded from: classes.dex */
public final class i implements IZeusLogger {
    public i() {
    }

    @Override // com.volcengine.zeus.log.IZeusLogger
    public final void d(String r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        FLogger.f375446a.d(r100, r101);
    }

    @Override // com.volcengine.zeus.log.IZeusLogger
    public final void i(String r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        FLogger.f375446a.i(r100, r101);
    }

    @Override // com.volcengine.zeus.log.IZeusLogger
    public final void v(String r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        FLogger.f375446a.v(r100, r101);
    }

    @Override // com.volcengine.zeus.log.IZeusLogger
    public final void w(String r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        FLogger.f375446a.w(r100, r101);
    }

    @Override // com.volcengine.zeus.log.IZeusLogger
    public final void e(String r100, String r101, Throwable r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        FLogger.f375446a.e(r100, r101, r102);
        if (r102 == null) goto L8;
        Log.getStackTraceString(r102);
        return;
    }

    @Override // com.volcengine.zeus.log.IZeusLogger
    public final void w(String r100, String r101, Throwable r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        FLogger.f375446a.w(r100, r101, r102);
        if (r102 == null) goto L8;
        Log.getStackTraceString(r102);
        return;
    }
}
