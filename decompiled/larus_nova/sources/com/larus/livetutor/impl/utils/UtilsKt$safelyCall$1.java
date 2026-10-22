package com.larus.livetutor.impl.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.utils.UtilsKt", f = "Utils.kt", i = {0}, l = {167, 169}, m = "safelyCall", n = {"$this$safelyCall"}, s = {"L$0"})
public final class UtilsKt$safelyCall$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public UtilsKt$safelyCall$1(Continuation<? super UtilsKt$safelyCall$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return UtilsKt.o(null, this);
    }
}
