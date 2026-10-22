package com.ss.android.lark.conditional.access.nopermission.viewmodel;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.viewmodel.DialogUserScopeView", f = "DialogUserScopeView.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {67, 85}, m = "mfa", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "scope", "customParams", "mfaParams", "successToastResId", "mfaParams", "token", "successToastResId"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "I$0"})
public final class DialogUserScopeView$mfa$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DialogUserScopeView this$0;

    public DialogUserScopeView$mfa$1(DialogUserScopeView r100, Continuation<? super DialogUserScopeView$mfa$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, null, 0, this);
    }
}
