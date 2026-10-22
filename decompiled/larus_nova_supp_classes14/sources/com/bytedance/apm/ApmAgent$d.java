package com.bytedance.apm;

import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$d implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ JSONObject e;

    public final void a() {
        String r0 = this.a;
        int r1 = this.b;
        JSONObject r2 = this.c;
        JSONObject r3 = this.d;
        JSONObject r4 = this.e;
        if (r4 != null) goto L15;
        r4 = new JSONObject();
    L15:
        r4.put("log_type", UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L11
        r4.put("service", r0);     // Catch: JSONException -> L11
        r4.put("status", r1);     // Catch: JSONException -> L11
        if (r2 == null) goto L8;
        r4.put("category", r2);     // Catch: JSONException -> L11
    L8:
        if (r3 == null) goto L12;
        r4.put("metric", r3);     // Catch: JSONException -> L11
    L12:
        if (r4 == null) goto L17;
        ApmAgent.storeLogBypass("monitorStatusAndEvent", r4.toString());
        return;
    L17:
        return;
    L11:
        r4 = null;
        goto L12
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

    public ApmAgent$d(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
