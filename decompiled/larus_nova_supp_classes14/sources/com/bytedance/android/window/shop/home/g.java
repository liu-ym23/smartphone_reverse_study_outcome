package com.bytedance.android.window.shop.home;

import android.app.Activity;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.p;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public g(String r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        Activity r0 = ECAppInfoService.e.getCurrentActivity();
        m0 r1 = new m0(this.a);
        r1.b("author_id", this.b);
        r1.b("sec_author_id", this.c);
        String r2 = r1.c();
        p.a.openSchema(r0, r2);
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
