package com.bytedance.ee.bear.office.list.adapter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t implements Runnable {
    public final /* synthetic */ x a;
    public final /* synthetic */ OfficeLongPressMenuAction b;
    public final /* synthetic */ z c;

    public t(x r1, OfficeLongPressMenuAction r2, z r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.a(this.b, this.c);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
