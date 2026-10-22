package com.bytedance.apm;

import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$p implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ JSONObject d;

    public final void a() {
        String r0 = this.a;
        String r1 = this.b;
        JSONObject r2 = ApmAgent.access$000(this.c, true);
        JSONObject r3 = this.d;
        if (r3 == null) goto L11;
    L5:
        r3.put("log_type", UploadTypeInf.UI_ACTION);     // Catch: JSONException -> L7
        r3.put("action", r0);     // Catch: JSONException -> L7
        r3.put("page", r1);     // Catch: JSONException -> L7
        r3.put("context", r2);     // Catch: JSONException -> L7
    L8:
        if (r3 == null) goto L13;
        ApmAgent.storeLogBypass("monitorUIAction", r3.toString());
        return;
    L13:
        return;
    L7:
        r3 = null;
        goto L8
    L11:
        r3 = new JSONObject();     // Catch: JSONException -> L7
        goto L5
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

    public ApmAgent$p(String r1, String r2, JSONObject r3, JSONObject r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
