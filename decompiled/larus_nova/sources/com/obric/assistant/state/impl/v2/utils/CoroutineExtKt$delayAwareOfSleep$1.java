package com.obric.assistant.state.impl.v2.utils;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.utils.CoroutineExtKt", f = "CoroutineExt.kt", i = {0, 0}, l = {22}, m = "delayAwareOfSleep", n = {"delayMillis", DyPayConstant.KEY_START_TIME}, s = {"J$0", "J$1"})
public final class CoroutineExtKt$delayAwareOfSleep$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    int label;
    /* synthetic */ Object result;

    public CoroutineExtKt$delayAwareOfSleep$1(Continuation<? super CoroutineExtKt$delayAwareOfSleep$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return CoroutineExtKt.a(0, this);
    }
}
