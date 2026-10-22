package com.flow.kmp.common.util;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.flow.kmp.common.util.CoroutineExtKt", f = "CoroutineExt.kt", i = {0}, l = {47, 51}, m = "waitOrTimeout", n = {LynxVideoManagerLite.EVENT_ON_ERROR}, s = {"L$0"})
public final class CoroutineExtKt$waitOrTimeout$1<R> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public CoroutineExtKt$waitOrTimeout$1(Continuation<? super CoroutineExtKt$waitOrTimeout$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return CoroutineExtKt.d(0, null, null, this);
    }
}
