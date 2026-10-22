package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ ECWindowTabsSelectionJSbPluginExp a;
    public final /* synthetic */ String b;

    public b(ECWindowTabsSelectionJSbPluginExp r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECWindowTabsSelectionJSbPluginExp r0 = this.a;     // Catch: Throwable -> L4
        r0.f.invoke(this.b, r0.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
