package com.bytedance.apm;

import com.larus.apm.impl.protector.RunnableProtector;
import js3.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$r implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ JSONObject e;

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r0 = new e(this.a, this.b, ApmAgent.access$000(this.c, true), ApmAgent.access$000(this.d, true), this.e).a();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        ApmAgent.storeLogBypass("monitorPerformance", r0.toString());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public ApmAgent$r(String r1, String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
