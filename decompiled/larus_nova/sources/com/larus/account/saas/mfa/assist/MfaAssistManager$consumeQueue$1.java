package com.larus.account.saas.mfa.assist;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.larus.account.saas.mfa.assist.MfaAssistManager", f = "MfaAssistManager.kt", i = {0, 0}, l = {146}, m = "consumeQueue", n = {"this", "reducedUiState"}, s = {"L$0", "L$1"})
final class MfaAssistManager$consumeQueue$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MfaAssistManager this$0;

    public MfaAssistManager$consumeQueue$1(MfaAssistManager r100, Continuation<? super MfaAssistManager$consumeQueue$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MfaAssistManager.a(this.this$0, this);
    }
}
