package com.obric.aiagent.assistant.utils;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.assistant.utils.ObricAppStatusHelper", f = "ObricAppStatusHelper.kt", i = {0}, l = {27}, m = "getObricAppStatus", n = {PerfLog.PARAM_KEY_CONTEXT_ID}, s = {"L$0"})
final class ObricAppStatusHelper$getObricAppStatus$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public ObricAppStatusHelper$getObricAppStatus$1(a r100, Continuation<? super ObricAppStatusHelper$getObricAppStatus$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        a r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        ObricAppStatusHelper$getObricAppStatus$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r104);
        return ObricAppStatus.Unknown;
    L9:
        if (r105 != 1) goto L45;
        Context r106 = (Context) r103.L$0;
        ResultKt.throwOnFailure(r104);
        int r107 = a.C4583a.f384612a[((PrivacyApprovalStatus) r104).ordinal()];
        if (r107 == 1) goto L54;
        if (r107 == 2) goto L53;
        if (r107 == 3) goto L53;
        if (r107 != 4) goto L41;
        b.f384613a.getClass();
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L25
        Bundle r109 = r106.getContentResolver().call(b.f384614b, "is_login", null, null);     // Catch: Throwable -> L25
        if (r109 == null) goto L22;
        boolean r110 = r109.getBoolean("is_login");     // Catch: Throwable -> L25
    L23:
        Object r111 = Result.m9449constructorimpl(Boolean.valueOf(r110));     // Catch: Throwable -> L25
    L27:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L30;
        r112.getMessage();
    L30:
        Boolean r113 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r111) == false) goto L34;
        r111 = r113;
    L34:
        if (((Boolean) r111).booleanValue() == false) goto L50;
        b.f384613a.getClass();
        if (Intrinsics.areEqual(b.d(r106), "com.larus.nova") == true) goto L52;
        return ObricAppStatus.NotRoleAssistant;
    L52:
        return ObricAppStatus.Success;
    L50:
        return ObricAppStatus.UserNoLogin;
    L22:
        r110 = false;
    L25:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L41:
        throw new NoWhenBranchMatchedException();
    L53:
        return ObricAppStatus.PrivacyNotObtainError;
    L54:
        return ObricAppStatus.PrivacyNotApprovalError;
    L45:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r103 = new ObricAppStatusHelper$getObricAppStatus$1(r101, this);
        goto L6
    }
}
