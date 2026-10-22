package com.bytedance.sdk.bridge.auth.privilege;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f269567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f269568b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f269567a.getSharedPreferences("JsBridgeAuthStore", 0).edit().putString("accessKeyContent", this.f269568b).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(Context r100, String r101) {
        this.f269567a = r100;
        this.f269568b = r101;
    }
}
