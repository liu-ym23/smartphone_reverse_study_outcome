package com.bytedance.ee.bear.document.editionmanager.executor;

import com.bytedance.ee.bear.domain.BearUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ BearUrl b;
    public final /* synthetic */ sbb.e c;
    public final /* synthetic */ String d;

    public /* synthetic */ f(k r1, BearUrl r2, sbb.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = "";
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r0 = this.a;
        BearUrl r1 = this.b;
        sbb.e r2 = this.c;
        String r3 = this.d;
        r0.getClass();
        r0.a(r1.b, r2.b, r3, new j());
    }
}
