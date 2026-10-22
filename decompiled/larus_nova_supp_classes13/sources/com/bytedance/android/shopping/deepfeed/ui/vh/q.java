package com.bytedance.android.shopping.deepfeed.ui.vh;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q implements Runnable {
    public final /* synthetic */ Map a;
    public final /* synthetic */ DeepFeedProductSlcVH b;

    public q(Map r1, DeepFeedProductSlcVH r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        DeepFeedProductSlcVH r0 = this.b;
        r0.getClass();
        r0.getClass();
        r0.getAdapterPosition();
        ((InFeedProductV2) this.b.getItem()).isCacheData();
        String r1 = ((InFeedProductV2) this.b.getItem()).getDynamicData().p;
        this.b.getClass();
        throw null;
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
