package com.bytedance.kmp.ec.yata.event.common;

import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b implements d {
    public abstract com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r100);

    @Override // com.bytedance.kmp.ec.yata.event.common.d
    public void onDestroy() {
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.d
    public d.a b() {
        return new d.a(true, CollectionsKt.emptyList());
    }

    public b() {
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.d
    @Deprecated(message = "SDK内部API,业务不需要实现处理")
    public final void a(com.bytedance.kmp.ec.yata.event.core.a r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "chainNextCallback");
        r101.invoke(c(r100));
    }
}
