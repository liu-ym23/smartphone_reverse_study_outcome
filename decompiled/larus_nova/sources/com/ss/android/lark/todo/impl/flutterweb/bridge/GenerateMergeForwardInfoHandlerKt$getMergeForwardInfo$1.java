package com.ss.android.lark.todo.impl.flutterweb.bridge;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.todo.impl.flutterweb.bridge.GenerateMergeForwardInfoHandlerKt", f = "GenerateMergeForwardInfoHandler.kt", i = {0}, l = {50}, m = "getMergeForwardInfo", n = {"referResourceId"}, s = {"L$0"})
public final class GenerateMergeForwardInfoHandlerKt$getMergeForwardInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public GenerateMergeForwardInfoHandlerKt$getMergeForwardInfo$1(Continuation<? super GenerateMergeForwardInfoHandlerKt$getMergeForwardInfo$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return GenerateMergeForwardInfoHandlerKt.a(null, this);
    }
}
