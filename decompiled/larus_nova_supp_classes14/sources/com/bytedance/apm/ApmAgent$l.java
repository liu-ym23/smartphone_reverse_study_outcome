package com.bytedance.apm;

import com.larus.apm.impl.protector.RunnableProtector;
import js3.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$l implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ JSONObject b;

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r0 = new c(this.a, this.b).a();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        ApmAgent.storeLogBypass("monitorExceptionLog", r0.toString());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public ApmAgent$l(String r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
    }
}
