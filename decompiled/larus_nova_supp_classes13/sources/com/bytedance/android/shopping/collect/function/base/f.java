package com.bytedance.android.shopping.collect.function.base;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CollectYataFragment a;

    public f(CollectYataFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        CollectCommonLog.c("CollectSelfFun-selfQuitCollect", "selfQuitCollect");
        FragmentActivity r4 = this.a.getActivity();
        if (r4 == null) goto L5;
        r4.finish();
    L5:
        int r5 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
