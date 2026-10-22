package com.bytedance.apm;

import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$i implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ JSONObject d;

    public final void a() {
        String r0 = this.a;
        int r1 = this.b;
        JSONObject r2 = this.c;
        JSONObject r3 = this.d;
        if (r3 != null) goto L13;
        r3 = new JSONObject();
    L13:
        r3.put("log_type", UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L9
        r3.put("service", r0);     // Catch: JSONException -> L9
        r3.put("status", r1);     // Catch: JSONException -> L9
        if (r2 == null) goto L10;
        r3.put("value", r2);     // Catch: JSONException -> L9
    L10:
        if (r3 == null) goto L15;
        ApmAgent.storeLogBypass("monitorStatusAndDuration", r3.toString());
        return;
    L15:
        return;
    L9:
        r3 = null;
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

    public ApmAgent$i(String r1, int r2, JSONObject r3, JSONObject r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
