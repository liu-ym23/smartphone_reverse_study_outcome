package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductListPresenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public e(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ECHybridListEngine r4 = this.a.n;
        if (r4 == null) goto L7;
        ECHybridRecyclerView r5 = r4.b;
        if (r5 == null) goto L7;
        r5.stopScroll();
    L7:
        ECHybridListEngine r6 = this.a.n;
        if (r6 == null) goto L15;
        ECHybridRecyclerView r7 = r6.b;
        if (r7 == null) goto L16;
        VirtualLayoutManager r8 = r7.getLayoutManager();
        if (r8 == null) goto L17;
        r8.scrollToPositionWithOffset(0, -1);
        return;
    L17:
        return;
    L16:
        return;
    }
}
