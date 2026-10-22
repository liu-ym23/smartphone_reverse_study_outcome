package com.larus.account.saas.mfa.assist;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.larus.account.saas.mfa.assist.MfaAssistManager", f = "MfaAssistManager.kt", i = {0, 0, 0}, l = {246}, m = "requestPushCode", n = {"uiState", "retryTimes", DBDefinition.RETRY_COUNT}, s = {"L$0", "I$0", "I$1"})
public final class MfaAssistManager$requestPushCode$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MfaAssistManager this$0;

    public MfaAssistManager$requestPushCode$1(MfaAssistManager r100, Continuation<? super MfaAssistManager$requestPushCode$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MfaAssistManager r101 = this.this$0;
        MfaAssistManager r102 = MfaAssistManager.f286395a;
        return r101.c(null, this);
    }
}
