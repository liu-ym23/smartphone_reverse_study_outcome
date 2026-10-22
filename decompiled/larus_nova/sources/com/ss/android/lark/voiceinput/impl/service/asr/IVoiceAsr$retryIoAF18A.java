package com.ss.android.lark.voiceinput.impl.service.asr;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: com.ss.android.lark.voiceinput.impl.service.asr.IVoiceAsr$retry-IoAF18A, reason: invalid class name */
/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.voiceinput.impl.service.asr.IVoiceAsr$DefaultImpls", f = "IVoiceAsr.kt", i = {}, l = {16}, m = "retry-IoAF18A", n = {}, s = {})
final class IVoiceAsr$retryIoAF18A extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public IVoiceAsr$retryIoAF18A(Continuation<? super IVoiceAsr$retryIoAF18A> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = a.C5386a.a(this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
