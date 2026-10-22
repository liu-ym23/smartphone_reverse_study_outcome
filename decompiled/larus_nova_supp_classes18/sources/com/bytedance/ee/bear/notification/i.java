package com.bytedance.ee.bear.notification;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.notification.bean.Notification;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements Runnable {
    public final /* synthetic */ Observer a;
    public final /* synthetic */ g.a b;
    public final /* synthetic */ j c;

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a.a.observeForever(this.a);     // Catch: Throwable -> L4
        Map<g.a, Observer<Notification>> r0 = this.c.c;     // Catch: Throwable -> L4
        HashMap r1 = (HashMap) r0;     // Catch: Throwable -> L4
        r1.put(this.b, this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(j r1, h r2, f.b r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
