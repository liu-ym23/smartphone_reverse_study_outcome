package com.bytedance.android.shopping.store.router.hybridpage.holder;

import android.view.View;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/holder/HybridPageSliceBaseProductCardHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class HybridPageSliceBaseProductCardHolder extends BaseViewHolder {
    public final boolean C3() {
        return false;
    }

    public abstract void q4(Object r1, String r2);

    public HybridPageSliceBaseProductCardHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    public final void b4(Object r2, String r3, k.a r4) {
        Intrinsics.checkNotNullParameter(r3, "itemId");
        if ((r2 instanceof com.bytedance.android.ec.store.window.b) == true) goto L6;
        super.b4(r2, r3, r4);
        q4(r2, r3);
        return;
    L6:
        ((com.bytedance.android.ec.store.window.b) r2).getClass();
        throw null;
    }
}
