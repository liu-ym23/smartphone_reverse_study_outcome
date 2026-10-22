package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.list.view.ECVirtualLayoutManager;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final int a(ECHybridListEngine r2) {
        VirtualLayoutManager r0 = null;
        if (r2 == null) goto L7;
        ECHybridRecyclerView r3 = r2.b;
        if (r3 == null) goto L7;
        VirtualLayoutManager r4 = r3.getLayoutManager();
    L9:
        if ((r4 instanceof ECVirtualLayoutManager) == false) goto L12;
        r0 = r4;
    L12:
        ECVirtualLayoutManager r1 = (ECVirtualLayoutManager) r0;
        if (r1 != null) goto L17;
        return -1;
    L17:
        return r1.findFirstVisibleItemPosition();
    L7:
        r4 = null;
        goto L9
    }

    public static final int b(ECHybridListEngine r2) {
        VirtualLayoutManager r0 = null;
        if (r2 == null) goto L7;
        ECHybridRecyclerView r3 = r2.b;
        if (r3 == null) goto L7;
        VirtualLayoutManager r4 = r3.getLayoutManager();
    L9:
        if ((r4 instanceof ECVirtualLayoutManager) == false) goto L12;
        r0 = r4;
    L12:
        ECVirtualLayoutManager r1 = (ECVirtualLayoutManager) r0;
        if (r1 != null) goto L17;
        return -1;
    L17:
        return r1.findLastCompletelyVisibleItemPosition();
    L7:
        r4 = null;
        goto L9
    }
}
