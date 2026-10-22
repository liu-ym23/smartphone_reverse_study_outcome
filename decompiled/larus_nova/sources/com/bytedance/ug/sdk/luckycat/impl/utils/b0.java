package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f271512a;

    public b0() {
        this.f271512a = "UG容器域名白名单拦截(appSettings)";
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f(), this.f271512a, 1).show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
