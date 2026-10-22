package com.bytedance.apm.config;

import com.bytedance.apm.ApmAgent;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ j$a b;

    public final void a() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("looper_monitor", this.a);     // Catch: JSONException -> L4
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L4
        r1.put("is_main_process", this.b.a.q);     // Catch: JSONException -> L4
        ApmAgent.monitorEvent("apm_cost", r1, r0, null);     // Catch: JSONException -> L4
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(j$a r1, long r2) {
        this.b = r1;
        this.a = r2;
    }
}
