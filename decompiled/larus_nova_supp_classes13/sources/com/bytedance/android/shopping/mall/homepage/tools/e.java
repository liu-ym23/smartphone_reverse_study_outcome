package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements Runnable {
    public final /* synthetic */ DataEngineWrapper a;
    public final /* synthetic */ HomePageDTO b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;

    public e(DataEngineWrapper r1, HomePageDTO r2, boolean r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataEngineWrapper r0 = this.a;     // Catch: Throwable -> L4
        HomePageDTO r1 = this.b;     // Catch: Throwable -> L4
        boolean r2 = this.c;     // Catch: Throwable -> L4
        String r3 = this.d;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        kk.d.c(new DataEngineWrapper$prefetchImageInner$1(r0, r1, r3, r2));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
