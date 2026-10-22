package com.obric.capability.schedulekit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.capability.schedulekit.IntentSdkVersionResolver", f = "IntentSdkVersionResolver.kt", i = {0}, l = {35}, m = "getSdkVersionByIntent", n = {"intentName"}, s = {"L$0"})
final class IntentSdkVersionResolver$getSdkVersionByIntent$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public IntentSdkVersionResolver$getSdkVersionByIntent$1(c r100, Continuation<? super IntentSdkVersionResolver$getSdkVersionByIntent$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
