package com.bytedance.android.livesdk.log;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ Object[] e;
    public final /* synthetic */ u f;

    @Override // java.lang.Runnable
    public final void run() {
        this.f.n(this.a, this.b, this.c, this.d, this.e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public s(u r1, String r2, boolean r3, boolean r4, Map r5, Object[] r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
