package com.bytedance.apm;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$t implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ float c;

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;     // Catch: Throwable -> L9
        String r1 = this.b;     // Catch: Throwable -> L9
        float r2 = this.c;     // Catch: Throwable -> L9
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L9
        r3.put("type", r0);     // Catch: JSONException -> L5 Throwable -> L9
        r3.put("key", r1);     // Catch: JSONException -> L5 Throwable -> L9
        r3.put("value", r2);     // Catch: JSONException -> L5 Throwable -> L9
    L6:
        if (r3 == null) goto L12;
        ApmAgent.storeLogBypass("monitorDirectOnTimer", r3.toString());     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L5:
        r3 = null;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }

    public ApmAgent$t(String r1, String r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
