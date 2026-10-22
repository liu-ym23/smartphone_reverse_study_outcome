package com.bytedance.android.shopping.collect.function.base;

import com.bytedance.android.shopping.collect.common.function.CollectCommonHandleEventWhenAppearFunction;
import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.kmp.ec.yata.event.common.a {
    public final CollectYataFragment a;

    public c(CollectYataFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r6, Function1 r7) {
        Intrinsics.checkNotNullParameter(r6, "input");
        Intrinsics.checkNotNullParameter(r7, "chainNextCallback");
        CollectCommonLog.c("CollectSelfFun-selfHandleEventWhenAppear", "selfHandleEventWhenAppear");
        kb3.a r1 = this.a.n;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "input");
        lb3.a r2 = r1.f;
        Map<String, pb3.a> r3 = pb3.a.h;
        CollectParams r4 = r1.b;
        if (r4 == null) goto L5;
        String r5 = r4.getMonitorId();
    L6:
        new CollectCommonHandleEventWhenAppearFunction(r2, r6, (pb3.a) ((LinkedHashMap) pb3.a.h).get(r5)).a();
        int r8 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r7.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L5:
        r5 = null;
        goto L6
    }
}
