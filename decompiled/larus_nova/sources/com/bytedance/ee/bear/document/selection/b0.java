package com.bytedance.ee.bear.document.selection;

import android.webkit.ValueCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class b0 implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f221599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f221600b;

    public /* synthetic */ b0(e0 r100, Runnable r101) {
        this.f221599a = r100;
        this.f221600b = r101;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        e0 r101 = this.f221599a;
        Runnable r102 = this.f221600b;
        String r103 = (String) r100;
        r101.getClass();
        e0.l(new String[]{"jsCursorBounds:" + r103});
        r101.m(new JSONObject(r103), r101.S);     // Catch: Throwable -> L5
        r102.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("SelectionOld", th, false);
    }
}
