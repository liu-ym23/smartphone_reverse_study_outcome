package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DataEngineExtKt {
    public static final void a(final ECHybridDataEngine r6, com.bytedance.android.shopping.mall.homepage.pagecard.d r7, Map<String, ? extends Object> r8, long r9, final List<String> r11, final com.bytedance.android.ec.hybrid.data.entity.a r12, final ECHybridNetworkTask.a r13) {
        Intrinsics.checkNotNullParameter(r6, "$this$fetchListWithDynamicParams");
        Intrinsics.checkNotNullParameter(r8, "clientParams");
        Intrinsics.checkNotNullParameter(r11, "apiKeyList");
        Intrinsics.checkNotNullParameter(r13, "callback");
        if (r7 == null) goto L5;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r10 = r7.a();
    L6:
        com.bytedance.android.shopping.mall.homepage.pagecard.c r0 = r10;
        if (r0 != null) goto L9;
    L11:
        r6.a(r11, r13);
        return;
    L9:
        if (r0.a.a() == true) goto L11;
        r0.g(r11, r8, r9, new DataEngineExtKt$fetchListWithDynamicParams$1(r6, r11, r12, r13));
        return;
    L5:
        r10 = null;
        goto L6
    }
}
