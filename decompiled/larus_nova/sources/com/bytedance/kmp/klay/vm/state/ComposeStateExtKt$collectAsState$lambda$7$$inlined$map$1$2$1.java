package com.bytedance.kmp.klay.vm.state;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.klay.vm.state.ComposeStateExtKt$collectAsState$lambda$7$$inlined$map$1$2", f = "ComposeStateExt.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
public final class ComposeStateExtKt$collectAsState$lambda$7$$inlined$map$1$2$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public ComposeStateExtKt$collectAsState$lambda$7$$inlined$map$1$2$1(b r100, Continuation r101) {
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
