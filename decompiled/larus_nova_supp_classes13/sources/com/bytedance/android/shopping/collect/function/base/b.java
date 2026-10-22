package com.bytedance.android.shopping.collect.function.base;

import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import io.reactivex.functions.Action;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Action {
    public final /* synthetic */ long a;
    public final /* synthetic */ Function1 b;

    public b(long r1, Function1 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void run() {
        Lazy r0 = CollectCommonLog.a;
        CollectCommonLog.c("CollectSelfFun-selfDelay", "delay " + this.a + " success");
        Function1 r1 = this.b;
        int r2 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r1.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
