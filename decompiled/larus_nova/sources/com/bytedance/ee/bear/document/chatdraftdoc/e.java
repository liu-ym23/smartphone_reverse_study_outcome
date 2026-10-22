package com.bytedance.ee.bear.document.chatdraftdoc;

import android.os.Bundle;
import com.bytedance.ee.bear.route.RouteBean;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f219201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f219202b;

    public e(String r100, String r101) {
        this.f219201a = r100;
        this.f219202b = r101;
    }

    public final void a() {
        RouteBean r100 = new RouteBean();
        Bundle r101 = new Bundle();
        r101.putString("chat_id", this.f219201a);
        r100.f236649n = r101;
        ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).m9(this.f219202b, r100);
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
