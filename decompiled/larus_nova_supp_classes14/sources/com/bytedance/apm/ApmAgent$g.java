package com.bytedance.apm;

import com.larus.apm.impl.protector.RunnableProtector;
import jt3.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$g implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ JSONObject c;

    @Override // java.lang.Runnable
    public final void run() {
        a.d(new lt3.a(this.a, 0, ApmAgent.access$000(this.b, true), null, null, ApmAgent.access$000(this.c, false)));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ApmAgent$g(String r1, JSONObject r2, JSONObject r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
