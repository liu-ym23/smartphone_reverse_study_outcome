package com.bytedance.apm;

import com.bytedance.apm.config.d;
import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$b implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ JSONObject d;

    public final void a() {
        d r0 = this.a;
        String r1 = r0.a;
        int r2 = r0.b;
        JSONObject r3 = this.b;
        JSONObject r4 = this.c;
        JSONObject r5 = this.d;
        boolean r6 = r0.f;
        if (r5 != null) goto L15;
        r5 = new JSONObject();
    L15:
        r5.put("log_type", UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L11
        r5.put("service", r1);     // Catch: JSONException -> L11
        r5.put("status", r2);     // Catch: JSONException -> L11
        if (r3 == null) goto L8;
        r5.put("category", r3);     // Catch: JSONException -> L11
    L8:
        if (r4 == null) goto L12;
        r5.put("metric", r4);     // Catch: JSONException -> L11
    L12:
        if (r5 == null) goto L17;
        ApmAgent.storeLogBypass("monitorEvent", r5.toString());
        return;
    L17:
        return;
    L11:
        r5 = null;
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

    public ApmAgent$b(d r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
