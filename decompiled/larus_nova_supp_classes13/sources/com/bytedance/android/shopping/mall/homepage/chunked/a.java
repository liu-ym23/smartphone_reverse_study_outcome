package com.bytedance.android.shopping.mall.homepage.chunked;

import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ HomepageChunkedCallback a;
    public final /* synthetic */ HomePageDTO b;

    public a(HomepageChunkedCallback r1, HomePageDTO r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    L19:
        return;
    L3:
        if (((Boolean) this.a.a.getValue()).booleanValue() == false) goto L14;
        DataEngineWrapper r0 = this.a.c;     // Catch: Throwable -> L11
        if (r0 == null) goto L7;
        r0.s = true;     // Catch: Throwable -> L11
    L7:
        DataEngineWrapper r1 = this.a.c;     // Catch: Throwable -> L11
        if (r1 == null) goto L18;
        DataEngineWrapper.C(r1, this.b, false, 6);     // Catch: Throwable -> L11
        return;
    L18:
        return;
    }
}
