package com.larus.paging;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes29.dex */
public final class FlowExtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f363652a = null;

    static {
        f363652a = new Object();
    }

    public static final <T, R> Flow<R> a(Flow<? extends T> r100, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "transform");
        return SimpleChannelFlowKt.a(new FlowExtKt$simpleTransformLatest$1(r100, r101, null));
    }
}
