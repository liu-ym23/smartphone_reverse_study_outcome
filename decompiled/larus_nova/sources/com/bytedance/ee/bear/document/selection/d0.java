package com.bytedance.ee.bear.document.selection;

import android.webkit.ValueCallback;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class d0 implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f221606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f221607b;

    public /* synthetic */ d0(e0 r100, Runnable r101) {
        this.f221606a = r100;
        this.f221607b = r101;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        e0 r101 = this.f221606a;
        Runnable r102 = this.f221607b;
        String r103 = (String) r100;
        r101.getClass();
        e0.l(new String[]{"jsMenu:" + r103});
        r101.K = false;     // Catch: Throwable -> L5
        r101.D.a(r103);     // Catch: Throwable -> L5
        r102.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("SelectionOld", th, false);
    }
}
