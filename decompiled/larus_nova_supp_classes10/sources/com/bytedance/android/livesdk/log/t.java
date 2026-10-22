package com.bytedance.android.livesdk.log;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ u c;

    @Override // java.lang.Runnable
    public final void run() {
        u r0 = this.c;     // Catch: Throwable -> L4
        String r1 = this.a;     // Catch: Throwable -> L4
        Map r2 = this.b;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        u.m(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public t(u r1, String r2, Map r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
