package com.bytedance.android.shopping.buynow.utils;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;

    public k(String r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.ec.sdk.helper.i r0 = com.bytedance.android.ec.sdk.helper.i.a;     // Catch: Throwable -> L7
        Context r1 = ECAppInfoService.e.getApplicationContext();     // Catch: Throwable -> L7
        String r2 = this.a;     // Catch: Throwable -> L7
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.e(r1, r2, this.b, this.c);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
