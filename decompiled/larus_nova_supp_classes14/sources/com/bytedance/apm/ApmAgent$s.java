package com.bytedance.apm;

import com.larus.apm.impl.protector.RunnableProtector;
import is3.a;
import js3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$s implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ float c;

    @Override // java.lang.Runnable
    public final void run() {
        a.h().b(new d(this.a, this.b, this.c));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ApmAgent$s(String r1, String r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
