package com.bytedance.apm;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$n implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ JSONObject b;

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;     // Catch: Throwable -> L11
        JSONObject r1 = this.b;     // Catch: Throwable -> L11
        if (r1 != null) goto L16;
        r1 = null;
    L8:
        if (r1 == null) goto L14;
        ApmAgent.storeLogBypass("monitorCommonLog", r1.toString());     // Catch: Throwable -> L11
        return;
    L14:
        return;
    L16:
        r1.put("log_type", r0);     // Catch: JSONException -> L6 Throwable -> L11
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }

    public ApmAgent$n(String r1, JSONObject r2, boolean r3) {
        this.a = r1;
        this.b = r2;
    }
}
