package com.bytedance.ee.bear.document.chatdraftdoc;

import android.os.Bundle;
import com.bytedance.ee.bear.route.RouteBean;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public e(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        RouteBean r0 = new RouteBean();
        Bundle r1 = new Bundle();
        r1.putString("chat_id", this.a);
        r0.n = r1;
        ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).m9(this.b, r0);
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
