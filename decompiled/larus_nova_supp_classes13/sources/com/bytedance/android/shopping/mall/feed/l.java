package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements com.bytedance.android.ec.hybrid.list.ability.d0 {
    public final /* synthetic */ ECMallFeed.a a;

    public l(ECMallFeed.a r1) {
        this.a = r1;
    }

    public final void a(int r2) {
        ECHybridListEngine r0 = this.a.b.J;
        if (r0 == null) goto L6;
        r0.g.b(r2);
        return;
    }
}
