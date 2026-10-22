package com.bytedance.ee.bear.document.selection;

import android.webkit.ValueCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class d0 implements ValueCallback {
    public final /* synthetic */ e0 a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ d0(e0 r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r6) {
        e0 r0 = this.a;
        Runnable r1 = this.b;
        String r7 = (String) r6;
        r0.getClass();
        e0.l(new String[]{"jsMenu:" + r7});
        r0.K = false;     // Catch: Throwable -> L5
        r0.D.a(r7);     // Catch: Throwable -> L5
        r1.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("SelectionOld", th, false);
    }
}
