package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowMfaEngine", f = "FlowMfaEngine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {46, 51, 54, 59, 63}, m = "startFirstParty-BWLJW6A", n = {"activity", "scope", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, DyPayConstant.KEY_START_TIME, "awaitingSessionResult", "activity", "scope", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, DyPayConstant.KEY_START_TIME, "awaitingSessionResult", "scope", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, DyPayConstant.KEY_START_TIME, "awaitingSessionResult", "scope", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, DyPayConstant.KEY_START_TIME, "awaitingSessionResult", "scope", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, DyPayConstant.KEY_START_TIME, "awaitingSessionResult"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0", "I$0", "L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "J$0", "I$0"})
public final class FlowMfaEngine$startFirstParty$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMfaEngine this$0;

    public FlowMfaEngine$startFirstParty$1(FlowMfaEngine r100, Continuation<? super FlowMfaEngine$startFirstParty$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.e(null, null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
