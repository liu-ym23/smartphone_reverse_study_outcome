package com.bytedance.lark.molten_livequery_wrapper;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j {
    public static final i a(com.bytedance.lark.molten_livequery_wrapper.adapter.d r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.bytedance.lark.molten_livequery_wrapper.adapter.c r102 = r100.a();
        final com.bytedance.lark.molten_livequery_wrapper.adapter.b r103 = new com.bytedance.lark.molten_livequery_wrapper.adapter.b(r102, 0);
        List<Object> r104 = r103.h();
        if (r104 != null) goto L5;
        r104 = CollectionsKt.emptyList();
    L5:
        r101.invoke(new h(r104, null, r103));
        r102.a(new LiveListKt$subscribeList$1(r101, r103));
        r102.resume();
        return new i(r102);
    }
}
