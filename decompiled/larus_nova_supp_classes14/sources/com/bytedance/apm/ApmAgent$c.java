package com.bytedance.apm;

import com.larus.apm.impl.protector.RunnableProtector;
import jt3.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ JSONObject e;

    @Override // java.lang.Runnable
    public final void run() {
        a.e(this.a, this.b, ApmAgent.access$000(this.c, true), ApmAgent.access$000(this.d, true), ApmAgent.access$000(this.e, false));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ApmAgent$c(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
