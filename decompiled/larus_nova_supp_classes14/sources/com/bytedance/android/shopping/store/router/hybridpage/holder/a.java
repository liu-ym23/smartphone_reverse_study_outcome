package com.bytedance.android.shopping.store.router.hybridpage.holder;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.shopping.store.home.presenter.b4;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements b4 {
    public final /* synthetic */ HybridPageLynxCardHolder a;

    public a(HybridPageLynxCardHolder r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.b4
    public final void onEvent(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        HybridPageLynxCardHolder r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "eventName");
        ECLynxCard r0 = ((ECLynxCardHolder) r1).t;
        if (r0 == null) goto L6;
        r0.o(r3, r4);
        return;
    }
}
