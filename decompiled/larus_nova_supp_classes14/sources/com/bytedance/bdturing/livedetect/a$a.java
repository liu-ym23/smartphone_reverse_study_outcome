package com.bytedance.bdturing.livedetect;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a$a implements Runnable {
    public final /* synthetic */ a a;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.g() == true) goto L9;
        a.b(this.a);     // Catch: Throwable -> L6
        this.a.e("setting_update", null);     // Catch: Throwable -> L6
        return;
    }

    public a$a(a r1) {
        this.a = r1;
    }
}
