package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.os.Bundle;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l0 implements Runnable {
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Bundle c;
    public final /* synthetic */ WikiMovePlugin d;

    public l0(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h r1, String r2, Bundle r3, WikiMovePlugin r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        String r0 = ((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) this.a).n;
        String r1 = this.b;
        Bundle r2 = this.c;
        int r3 = lw4.a.g;
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.a(r0, "", r1, r2, Boolean.valueOf(com.bytedance.ee.util.ui.a.a(WikiMovePlugin.access$getActivity(this.d))));
        WikiMovePlugin.access$getActivity(this.d).finish();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
