package com.bytedance.apm;

import com.bytedance.apm.config.d;
import com.larus.apm.impl.protector.RunnableProtector;
import jt3.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$a implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ JSONObject b;

    @Override // java.lang.Runnable
    public final void run() {
        d r0 = this.a;     // Catch: Throwable -> L4
        a.d(new lt3.a(r0.a, r0.b, null, r0.c, r0.d, this.b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ApmAgent$a(d r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
    }
}
