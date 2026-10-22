package com.bytedance.apm;

import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$h implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ JSONObject c;

    public final void a() {
        String r0 = this.a;
        JSONObject r1 = this.b;
        JSONObject r2 = this.c;
        if (r2 != null) goto L13;
        r2 = new JSONObject();
    L13:
        r2.put("log_type", UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L9
        r2.put("service", r0);     // Catch: JSONException -> L9
        r2.put("status", 0);     // Catch: JSONException -> L9
        if (r1 == null) goto L10;
        r2.put("value", r1);     // Catch: JSONException -> L9
    L10:
        if (r2 == null) goto L15;
        ApmAgent.storeLogBypass("monitorDuration", r2.toString());
        return;
    L15:
        return;
    L9:
        r2 = null;
        goto L10
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

    public ApmAgent$h(String r1, JSONObject r2, JSONObject r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
