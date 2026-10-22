package com.ss.android.lark.compose.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.util.FlowExtensionsKt$asNullable$$inlined$map$1$2", f = "FlowExtensions.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
public final class FlowExtensionsKt$asNullable$$inlined$map$1$2$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public FlowExtensionsKt$asNullable$$inlined$map$1$2$1(d r100, Continuation r101) {
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
