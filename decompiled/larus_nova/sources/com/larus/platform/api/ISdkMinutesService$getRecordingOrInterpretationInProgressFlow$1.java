package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.platform.api.ISdkMinutesService$DefaultImpls", f = "ISdkMinutesService.kt", i = {0}, l = {44}, m = "getRecordingOrInterpretationInProgressFlow", n = {"$this"}, s = {"L$0"})
public final class ISdkMinutesService$getRecordingOrInterpretationInProgressFlow$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ISdkMinutesService$getRecordingOrInterpretationInProgressFlow$1(Continuation<? super ISdkMinutesService$getRecordingOrInterpretationInProgressFlow$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ISdkMinutesService.DefaultImpls.a(null, this);
    }
}
