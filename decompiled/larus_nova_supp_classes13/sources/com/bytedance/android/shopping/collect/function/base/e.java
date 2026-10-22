package com.bytedance.android.shopping.collect.function.base;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.collect.custom_view.CollectGoodsLinkedScrollView;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CollectYataFragment a;

    public e(CollectYataFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        CollectCommonLog.c("CollectSelfFun-selfScrollToTop", "selfScrollToTop");
        CollectGoodsLinkedScrollView r4 = this.a.S90();
        if (r4 == null) goto L10;
        r4.m.stopScroll();
        RecyclerView r1 = r4.n.getFeedView();
        if (r1 == null) goto L7;
        r1.stopScroll();
    L7:
        r4.scrollTo(0, 0);
        r4.m.scrollToPosition(0);
        RecyclerView r5 = r4.n.getFeedView();
        if (r5 == null) goto L10;
        r5.scrollToPosition(0);
    L10:
        int r6 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
