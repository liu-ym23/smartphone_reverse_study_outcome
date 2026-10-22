package com.larus.paging;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes29.dex */
public final class SimpleChannelFlowKt {
    public static final <T> Flow<T> a(Function2<? super b1<T>, ? super Continuation<? super Unit>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        return kotlinx.coroutines.flow.e.d(new kotlinx.coroutines.flow.c1(new SimpleChannelFlowKt$simpleChannelFlow$1(r100, null)), -2, 2);
    }
}
