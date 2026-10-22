package com.bytedance.android.shopping.collect.yata.ability;

import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.collect.container.CollectYataQueryFrom;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import kotlin.jvm.internal.Intrinsics;
import v96.j;
import v96.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements v96.a {
    public final CollectParams a;

    public a(CollectYataFragment r13) {
        Intrinsics.checkNotNullParameter(r13, "fragment");
        CollectParams r14 = r13.V90().getCollectParams();
        if (r14 != null) goto L5;
        r14 = new CollectParams(null, null, null, null, null, null, false, null, 0, 511, null);
    L5:
        this.a = r14;
    }

    public final j a(m r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        return new j("aweme/v2/collects/yata/update", new qb3.a(CollectYataQueryFrom.REFRESH.getValue(), this.a).a());
    }
}
