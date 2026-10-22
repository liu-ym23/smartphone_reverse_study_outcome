package com.bytedance.ee.bear.document.render.init;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ ChameleonPluginHost b;

    public g(a r1, ChameleonPluginHost r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r0 = this.a;     // Catch: Throwable -> L12
        ChameleonPluginHost r1 = this.b;     // Catch: Throwable -> L12
        int r2 = a.d;     // Catch: Throwable -> L12
        r0.getClass();     // Catch: Throwable -> L12
        Fragment r3 = r1.getFragment();     // Catch: Throwable -> L12
        if (ForsetiHelper.s(r3) == false) goto L5;
        com.suite.lark.component.navroute.forseti.g r4 = com.suite.lark.component.navroute.forseti.f.b(r3);     // Catch: Throwable -> L12
    L6:
        if (r4 == null) goto L8;
        r4.g(null);     // Catch: Throwable -> L12
        return;
    L8:
        com.bytedance.ee.bear.document.container.a r5 = (com.bytedance.ee.bear.document.container.a) r1.getHostAbilityOrNull(com.bytedance.ee.bear.document.container.a.class);     // Catch: Throwable -> L12
        if (r5 == null) goto L18;
        r5.w();     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L5:
        r4 = null;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
