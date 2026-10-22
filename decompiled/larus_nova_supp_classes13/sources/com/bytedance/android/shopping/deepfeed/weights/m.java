package com.bytedance.android.shopping.deepfeed.weights;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.larus.apm.impl.protector.RunnableProtector;
import he3.v;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements Runnable {
    public final /* synthetic */ DeepFeedProductInfoExtraView a;
    public final /* synthetic */ InFeedProductV2 b;
    public final /* synthetic */ com.bytedance.android.shopping.deepfeed.action.h c;

    public m(DeepFeedProductInfoExtraView r1, InFeedProductV2 r2, com.bytedance.android.shopping.deepfeed.action.h r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.a.getBottom() > 0) goto L5;
        return;
    L5:
        if (this.a.getRight() <= 0) goto L15;
        InFeedProductV2 r0 = this.b;
        if (r0 == null) goto L16;
        v r1 = r0.getDynamicData();
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.e != true) goto L18;
        int r2 = com.bytedance.android.shopping.deepfeed.utlis.k.a;
        Pair r3 = com.bytedance.android.shopping.deepfeed.utlis.k.b(this.a);
        com.bytedance.android.shopping.deepfeed.action.h r4 = this.c;
        ((Number) r3.getFirst()).intValue();
        this.a.getWidth();
        ((Number) r3.getSecond()).intValue();
        com.bytedance.android.shopping.extensions.b.b(8);
        r4.o();
        return;
    L18:
        return;
    L16:
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
