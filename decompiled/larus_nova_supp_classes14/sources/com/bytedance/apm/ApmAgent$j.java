package com.bytedance.apm;

import com.larus.apm.impl.protector.RunnableProtector;
import is3.a;
import js3.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$j implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ JSONObject b;

    @Override // java.lang.Runnable
    public final void run() {
        a.h().b(new c(this.a, this.b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ApmAgent$j(String r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
    }
}
