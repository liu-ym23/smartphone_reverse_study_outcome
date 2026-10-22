package com.ss.android.lark.forwardv3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.forwardv3.ExternalForwardSendHelperKt", f = "ExternalForwardSendHelper.kt", i = {}, l = {96}, m = "awaitExternalForwardOutcome", n = {}, s = {})
public final class ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1(Continuation<? super ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ExternalForwardSendHelperKt.a(0, null, this);
    }
}
