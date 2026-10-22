package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z0 implements com.bytedance.android.ec.hybrid.list.ability.b {
    public final /* synthetic */ ECMallFeedComponent a;
    public final /* synthetic */ com.bytedance.android.shopping.api.mall.feed.c b;

    public final void a(int r5) {
        com.bytedance.android.shopping.api.mall.feed.c r0 = this.b;
        if (r0.a == false) goto L9;
        int r1 = r0.b;
        if (r1 <= 0) goto L9;
        if (r5 >= (r1 - 1)) goto L9;
        return;
    L9:
        ECHybridListEngine r2 = this.a.k.J;
        if (r2 != null) goto L12;
        return;
    L12:
        int r3 = Math.min((r0.d + r5) + 1, r2.i());
    L13:
        r5 = r5 + 1;
        if (r5 >= r3) goto L22;
        ECHybridListItemVO r4 = r2.h(r5);
        if (r4 == null) goto L13;
        ECNAMallCardExtra r6 = r4.c();
        if (r6 == null) goto L13;
        DataEngineWrapper r7 = this.a.o;
        if (r7 == null) goto L13;
        r7.E(r6);
        goto L13
    }

    public z0(ECMallFeedComponent r1, com.bytedance.android.shopping.api.mall.feed.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
