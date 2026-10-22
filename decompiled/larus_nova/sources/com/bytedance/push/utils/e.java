package com.bytedance.push.utils;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.agilelogger.ALog;
import com.ss.android.agilelogger.ALogConfig;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f267063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f267064b;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (f.f267069e != null) goto L9;
        f.f267069e = ALog.createInstance(this.f267063a, new ALogConfig.b(this.f267064b).a());     // Catch: Throwable -> L6
        return;
    }

    public e(String r100, Context r101) {
        this.f267063a = r100;
        this.f267064b = r101;
    }
}
