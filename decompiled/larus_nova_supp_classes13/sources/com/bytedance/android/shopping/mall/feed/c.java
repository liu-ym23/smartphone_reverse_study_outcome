package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements com.bytedance.android.ec.hybrid.list.ability.h0 {
    public final /* synthetic */ ECMallFeed.a a;

    public final boolean a() {
        ECHybridListEngine r0 = this.a.b.J;
        if (r0 == null) goto L22;
        ECHybridRecyclerView r1 = r0.b;
        if (r1 == null) goto L23;
        VirtualLayoutManager r2 = r1.getLayoutManager();
        if (r2 == null) goto L28;
        ECHybridListEngine r3 = this.a.b.J;
        if (r3 == null) goto L24;
        int r4 = r3.n("multi_in_one_section");
        if (r4 > 0) goto L14;
        return false;
    L14:
        ECHybridListEngine r5 = this.a.b.J;
        if (r5 == null) goto L25;
        BaseViewHolder r6 = r5.g("multi_in_one_section", r4 - 1);
        if (r6 == null) goto L26;
        int r7 = r6.getAdapterPosition();
        if (r2.findFirstVisibleItemPosition() > r7) goto L27;
        return true;
    L27:
        return false;
    L26:
        return false;
    L25:
        return false;
    L24:
        return false;
    L28:
        return false;
    L23:
        return false;
    L22:
        return false;
    }

    public c(ECMallFeed.a r1) {
        this.a = r1;
    }
}
