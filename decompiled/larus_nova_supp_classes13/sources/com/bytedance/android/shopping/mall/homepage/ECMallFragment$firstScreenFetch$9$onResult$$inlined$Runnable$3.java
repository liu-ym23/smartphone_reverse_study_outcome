package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$3 implements Runnable {
    public final /* synthetic */ ECMallFragment$firstScreenFetch$9 a;
    public final /* synthetic */ String b;

    public ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$3(ECMallFragment$firstScreenFetch$9 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        final DataEngineWrapper r0 = this.a.d.L0;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.s == false) goto L8;
        return;
    L8:
        if (this.a.d.H2 == true) goto L20;
        r0.I();
        r0.s = true;
        if (((Boolean) this.a.d.H.getValue()).booleanValue() == false) goto L14;
        kk.d.c(new ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$3$lambda$1(r0, this));
    L14:
        if (((Boolean) this.a.d.I.getValue()).booleanValue() == false) goto L18;
        kk.d.c(new ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$3$lambda$2(r0, this));
        return;
    L18:
        return;
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
