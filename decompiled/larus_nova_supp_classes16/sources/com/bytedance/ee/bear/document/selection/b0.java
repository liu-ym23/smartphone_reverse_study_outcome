package com.bytedance.ee.bear.document.selection;

import android.webkit.ValueCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class b0 implements ValueCallback {
    public final /* synthetic */ e0 a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ b0(e0 r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r6) {
        e0 r0 = this.a;
        Runnable r1 = this.b;
        String r7 = (String) r6;
        r0.getClass();
        e0.l(new String[]{"jsCursorBounds:" + r7});
        r0.m(new JSONObject(r7), r0.S);     // Catch: Throwable -> L5
        r1.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("SelectionOld", th, false);
    }
}
