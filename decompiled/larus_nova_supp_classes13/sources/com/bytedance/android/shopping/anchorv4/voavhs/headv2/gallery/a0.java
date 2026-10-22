package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 implements Runnable {
    public final /* synthetic */ t a;

    public a0(t r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
