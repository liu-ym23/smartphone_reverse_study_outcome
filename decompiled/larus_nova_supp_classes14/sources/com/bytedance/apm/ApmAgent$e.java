package com.bytedance.apm;

import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$e implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ JSONObject c;

    public final void a() {
        String r0 = this.a;
        int r1 = this.b;
        JSONObject r2 = this.c;
        if (r2 != null) goto L11;
        r2 = new JSONObject();
    L11:
        r2.put("log_type", UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L7
        r2.put("service", r0);     // Catch: JSONException -> L7
        r2.put("status", r1);     // Catch: JSONException -> L7
    L8:
        if (r2 == null) goto L13;
        ApmAgent.storeLogBypass("monitorStatusRate", r2.toString());
        return;
    L13:
        return;
    L7:
        r2 = null;
        goto L8
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

    public ApmAgent$e(String r1, int r2, JSONObject r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
