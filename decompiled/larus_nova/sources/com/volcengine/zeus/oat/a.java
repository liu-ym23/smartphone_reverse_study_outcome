package com.volcengine.zeus.oat;

import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import mqc.i;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputStream f462721a;

    public final void a() {
        BufferedReader r100 = new BufferedReader(new InputStreamReader(this.f462721a));
    L16:
        String r101 = r100.readLine();     // Catch: Throwable -> L8 IOException -> L10
        if (r101 == null) goto L7;
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "exec cmd info : " + r101);     // Catch: Throwable -> L8 IOException -> L10
    L7:
        i.a(r100);
        return;
    L10:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : " + e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        i.a(r100);
        throw th;
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

    public a(InputStream r100) {
        this.f462721a = r100;
    }
}
