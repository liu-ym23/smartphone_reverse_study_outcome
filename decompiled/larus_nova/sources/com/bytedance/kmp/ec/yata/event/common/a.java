package com.bytedance.kmp.ec.yata.event.common;

import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a implements d {
    public abstract void c(com.bytedance.kmp.ec.yata.event.core.a r100, Function1 r101);

    @Override // com.bytedance.kmp.ec.yata.event.common.d
    public final void onDestroy() {
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.d
    public d.a b() {
        return new d.a(true, CollectionsKt.emptyList());
    }

    public a() {
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.d
    @Deprecated(message = "SDK内部API,业务不需要实现处理")
    public final void a(com.bytedance.kmp.ec.yata.event.core.a r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "chainNextCallback");
        c(r100, new AbsASyncHandleFunction$execute$1(r101));
    }
}
