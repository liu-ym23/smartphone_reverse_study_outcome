package com.bytedance.apm;

import com.larus.apm.impl.protector.RunnableProtector;
import is3.a;
import js3.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$q implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ JSONObject e;

    @Override // java.lang.Runnable
    public final void run() {
        e r6 = new e(this.a, this.b, this.c, this.d, this.e);     // Catch: Throwable -> L4
        a.h().b(r6);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ApmAgent$q(String r1, String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
