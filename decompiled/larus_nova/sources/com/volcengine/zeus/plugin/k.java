package com.volcengine.zeus.plugin;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.log.ZeusLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f462810a;

    @Override // java.lang.Runnable
    public final void run() {
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    L20:
        return;
    L4:
        if (this.f462810a == true) goto L6;
        PolarisFileWrapper r100 = new PolarisFileWrapper(dqc.c.d());     // Catch: Throwable -> L12
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusScanRunnable listPluginDownloadDir, dir = " + r100);     // Catch: Throwable -> L12
        r100.listFiles(new j());     // Catch: Throwable -> L12
    L6:
        String r101 = dqc.c.g();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return;
    L9:
        if (GlobalParam.getInstance().isDebug() == false) goto L19;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L12
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusScanRunnable listPluginDownloadDir, dir = " + r102);     // Catch: Throwable -> L12
        r102.listFiles(new j());     // Catch: Throwable -> L12
        return;
    }

    static {
    }

    public k(boolean r100) {
        this.f462810a = r100;
    }
}
