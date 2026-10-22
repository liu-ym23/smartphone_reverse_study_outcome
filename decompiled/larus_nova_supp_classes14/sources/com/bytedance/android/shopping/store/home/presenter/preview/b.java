package com.bytedance.android.shopping.store.home.presenter.preview;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements cf.n {
    public final /* synthetic */ ECShopExplainCardPresenter a;

    public b(ECShopExplainCardPresenter r1) {
        this.a = r1;
    }

    public final boolean open(String r3) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        dm.a.a("点击进直播间").a("setupOpenSchemaProxy");
        ECShopExplainCardPresenter r0 = this.a;
        ViewGroup r1 = r0.k;
        if (r1 == null) goto L7;
        o r2 = (o) r0.n.getValue();
        if (r2 == null) goto L7;
        return r2.c(r3, r1);
    L7:
        return false;
    }
}
